package com.marketplace.product.listing.detail.portlet;

import com.liferay.commerce.inventory.engine.CommerceInventoryEngine;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.content.helper.CPContentHelper;
import com.liferay.commerce.product.content.render.list.CPContentListRenderer;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "commerce.product.content.list.renderer.key=buycorp",
		"commerce.product.content.list.renderer.order=1000",
		"commerce.product.content.list.renderer.portlet.name=" + CPPortletKeys.CP_PUBLISHER_WEB,
		"commerce.product.content.list.renderer.portlet.name="
				+ CPPortletKeys.CP_SEARCH_RESULTS }, service = CPContentListRenderer.class)

public class ProductListingContentRenderer implements CPContentListRenderer, MVCResourceCommand {

	public static final Log LOGGER = LogFactoryUtil.getLog(ProductListingContentRenderer.class.getName());
	
	@Override
	public String getKey() {
		return "buycorp";
	}
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "buycorp-renderer");
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		httpServletRequest.setAttribute("isLoggedUser", themeDisplay.isSignedIn());
		
		_jspRenderer.renderJSP(_servletContext, httpServletRequest, 
				httpServletResponse, "/list_render/product_list.jsp");
		
	}
	
	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private CommerceInventoryEngine _commerceInventoryEngine;

	@Reference
	private JSPRenderer _jspRenderer;
 
	@Reference
	private Portal _portal;

	@Reference(target = "(osgi.web.symbolicname=com.marketplace.product.listing.detail)")
	private ServletContext _servletContext;

	@Reference
	private CPContentHelper _cpContentHelper;
}
