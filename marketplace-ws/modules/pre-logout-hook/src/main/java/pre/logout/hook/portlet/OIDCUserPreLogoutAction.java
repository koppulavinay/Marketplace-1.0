package pre.logout.hook.portlet;

import com.buycorp.common.util.CommonUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.openid.connect.persistence.service.OpenIdConnectSessionLocalService;

import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pre.logout.hook.constants.PreLogoutHookPortletKeys;

@Component(immediate = true, property = "key=logout.events.pre", service = LifecycleAction.class)

public class OIDCUserPreLogoutAction implements LifecycleAction {

    private static final Log LOGGER = LogFactoryUtil.getLog(OIDCUserPreLogoutAction.class);

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

        LOGGER.info("Inside Pre Logout Hook");
        
        try {
            
            /* HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(lifecycleEvent.getRequest());
            
            HttpSession httpSession = httpServletRequest.getSession();
            String accessToken = (String) httpSession.getAttribute("accessToken"); */

            // Getting ARX Logout API URL from site specific custom field
            String logoutApiURL = CommonUtil.getCustomFieldValue(PreLogoutHookPortletKeys.ARX_Logout_API_URL_Key);
  
            // Getting Redirect Logout URL from site specific custom field 
            String redirectURL = CommonUtil.getCustomFieldValue(PreLogoutHookPortletKeys.Post_Logout_Redirect_URL_KEY);
  
            String logoutURL = logoutApiURL + "?post_logout_redirect_uri=" + redirectURL;

            LOGGER.info("logoutURL--> " + logoutURL);
            
            ThemeDisplay themeDisplay = (ThemeDisplay) lifecycleEvent.getRequest().getAttribute(WebKeys.THEME_DISPLAY);
           // openIdConnectSessionLocalService.deleteOpenIdConnectSessions(themeDisplay.getUserId());
            
            HttpServletResponse response = lifecycleEvent.getResponse();
            response.sendRedirect(logoutURL);
            
        } catch (Exception e) {
            LOGGER.error("Error in Pre Logout Hook :: " + e.getMessage());
        }
    }

    @Reference
    private OpenIdConnectSessionLocalService openIdConnectSessionLocalService;

}
