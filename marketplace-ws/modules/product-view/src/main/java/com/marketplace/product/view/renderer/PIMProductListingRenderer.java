package com.marketplace.product.view.renderer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.marketplace.product.view.constants.ProductViewPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.PIM_PRODUCT_LISTING_RENDER_CMD }, service = MVCRenderCommand.class)
public class PIMProductListingRenderer implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		LOGGER.info("----------------- Redirecting back to PIM Product Listing page -----------------");
		
		return ProductViewPortletKeys.VIEW_JSP;
	}
	
	private static final Log LOGGER = LogFactoryUtil.getLog(PIMProductListingRenderer.class);

}
