package com.marketplace.product.view.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.ProductListingHelper;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ashishinani
 * @author anubhav.kalra
 * @author kashyap.mishra
 * 
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=buycorp",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.copy-request-parameters=false", "javax.portlet.display-name=ProductView",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.version=3.0" }, service = Portlet.class)
public class ProductViewPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(ProductViewPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		LOGGER.info("---------------Inside Product Creation Portlet---------------");
		
		long draftProductId = ParamUtil.getLong(renderRequest, "draftProductId");
		
		//if(draftProductId == 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			renderRequest.setAttribute("products", productListingHelper.getAllProducts(themeDisplay));
		//}

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private ProductListingHelper productListingHelper;

}