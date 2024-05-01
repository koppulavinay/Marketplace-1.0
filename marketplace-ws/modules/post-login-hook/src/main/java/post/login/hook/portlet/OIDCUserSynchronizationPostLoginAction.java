package post.login.hook.portlet;

import com.buycorp.common.util.CommonUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;
import com.liferay.portal.security.sso.openid.connect.persistence.model.OpenIdConnectSession;
import com.liferay.portal.security.sso.openid.connect.persistence.service.OpenIdConnectSessionLocalService;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "key=login.events.post", service = LifecycleAction.class)

public class OIDCUserSynchronizationPostLoginAction implements LifecycleAction {

	private static final Log logger = LogFactoryUtil.getLog(OIDCUserSynchronizationPostLoginAction.class);

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		logger.info(":::: OIDCUserSynchronizationPostLoginAction :::");

		HttpServletRequest httpServletRequest = lifecycleEvent.getRequest();
		HttpSession httpSession = httpServletRequest.getSession();
		Long openIdConnectSessionId = (Long) httpSession.getAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_SESSION_ID);
		logger.info("openIdConnectSessionId ::: " + openIdConnectSessionId);

		long userId = _portal.getUserId(httpServletRequest);
		logger.info("userId ::: " + userId);

		long companyId = _portal.getCompanyId(httpServletRequest);
		logger.info("companyId ::: " + companyId);

		String userRole = "";

		if (openIdConnectSessionId != null) {

			try {
				OpenIdConnectSession openIdConnectSession = _openIdConnectSessionLocalService
						.getOpenIdConnectSession(openIdConnectSessionId);

				String accessToken = openIdConnectSession.getAccessToken();

				try {
					JSONObject accessTokenJson = JSONFactoryUtil.createJSONObject(accessToken);
					String actualAccessToken = accessTokenJson.getString("access_token");
					
					httpSession.setAttribute("accessToken", actualAccessToken);
					logger.info("Access Token--> " + httpSession.getAttribute("accessToken"));

					String[] chunks = actualAccessToken.split("\\.");
					Base64.Decoder decoder = Base64.getUrlDecoder();

					//String header = new String(decoder.decode(chunks[0]));

					String payload = new String(decoder.decode(chunks[1]));
					JSONObject payloadJson = JSONFactoryUtil.createJSONObject(payload);

					String arxUserId = payloadJson.getString("sub");
				    httpSession.setAttribute("arxUserId", arxUserId);
				    
				    String userName = payloadJson.getString("fname") + " " + payloadJson.getString("lname");
				    httpSession.setAttribute("userName", userName);
					
					JSONArray rolesArray = payloadJson.getJSONArray("roles");
					for (int i = 0; i < rolesArray.length(); i++) {
						userRole = rolesArray.getString(i);
						httpSession.setAttribute("userType", userRole);
						logger.info("userRole :::: " + userRole);
					}
				} catch (JSONException e) {
					logger.error("Failed to parse 'access_token' from JSON: " + e.getMessage());
				}

//				String idToken = openIdConnectSession.getIdToken();
//				JWT jwt = JWTParser.parse(idToken);
//				JWTClaimsSet claimsSet = (JWTClaimsSet) jwt.getJWTClaimsSet();

				//String userMembership = PostLoginHookPortletKeys.MEMBERSHIP;

				Role role = RoleLocalServiceUtil.getRole(companyId, userRole);
				long roleId = role.getRoleId();
				logger.info("user role :::: " + userRole + " roleId :::: " + roleId);

				//Group group = GroupLocalServiceUtil.getGroup(companyId, CommonUtil.getCustomFieldValue("ARX_Group_ID"));
				//long groupId = group.getGroupId();
				Group group = GroupLocalServiceUtil.getGroup(Long.parseLong(CommonUtil.getCustomFieldValue("ARX_Group_ID")));

				User user = UserLocalServiceUtil.getUser(userId);
				user.setJobTitle(userRole);
				UserLocalServiceUtil.updateUser(user);
				
				UserLocalServiceUtil.addRoleUser(role.getRoleId(), userId);
				UserLocalServiceUtil.addGroupUser(group.getGroupId(), userId);

			} catch (PortalException e) {
				logger.error("Failed to get openid connect session PortalException ::: " + e.getMessage());
			}

		}

	}

	@Reference
	private Portal _portal;

	@Reference
	private OpenIdConnectSessionLocalService _openIdConnectSessionLocalService;

	@Reference
	private UserGroupLocalService _userGroupLocalService;
}
