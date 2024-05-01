package buycorp.arx.process.filter.hook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import buycorp.arx.process.filter.constants.BuycorpArxProcessFilterPortletKeys;

@Component(immediate = true,property = {"servlet-context-name=","servlet-filter-name= Custom Filter",
"url-pattern=/c/portal/redirect"},service = Filter.class)

public class BuyCorpProcessFilter extends BaseFilter {

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws Exception{

		HttpSession httpSession = request.getSession();
		Long openIdConnectSessionId = (Long) httpSession.getAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_SESSION_ID);

		//if(request.getSession().getAttribute("com.liferay.portal.security.sso.openid.connect.internal.OpenIdConnectAuthenticationHandlerImpl#OPEN_ID_CONNECT_AUTHENTICATION_SESSION") == null )
		if (openIdConnectSessionId == null) {

			String redirectUrl = request.getParameter("redirectUrl");
			String authlogin = "/web/guest/login/-/login/ ?p_p_state=maximized&_com_liferay_login_web_portlet_LoginPortlet_saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_redirect=" + redirectUrl + "&_com_liferay_login_web_portlet_LoginPortlet_OPEN_ID_CONNECT_PROVIDER_NAME=ARX";
			response.sendRedirect(authlogin);
		}else {
			String remoteAddress = request.getRemoteAddr();
			String redirectToMarketplace= remoteAddress + BuycorpArxProcessFilterPortletKeys.HOME_URL;
			logger.info("Redirect url to marketplace"+redirectToMarketplace);
			response.sendRedirect(redirectToMarketplace);
		}
		super.processFilter(request, response, filterChain);

}
	@Override
	protected Log getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	public static final Log logger = LogFactoryUtil.getLog(BuyCorpProcessFilter.class.getName());
}
