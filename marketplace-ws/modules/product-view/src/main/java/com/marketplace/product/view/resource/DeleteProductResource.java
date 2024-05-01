package com.marketplace.product.view.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.helper.ProductListingHelper;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name=deleteProductResourceCommand", }, service = MVCResourceCommand.class)
public class DeleteProductResource implements MVCResourceCommand {
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long draftProductId = Long.parseLong(httpServletRequest.getParameter("productId"));
		
		try {
			productListingHelper.deleteProduct(draftProductId, themeDisplay.getCompanyId());
		} catch (PortalException e) {
			LOGGER.warn("Unable to delete the product");
			LOGGER.debug(e, e);
		}
		
		return false;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteProductResource.class.getName());

	@Reference
	private ProductListingHelper productListingHelper;
}
