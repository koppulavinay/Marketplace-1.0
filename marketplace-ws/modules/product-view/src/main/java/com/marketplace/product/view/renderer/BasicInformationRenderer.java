package com.marketplace.product.view.renderer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name=" + ProductViewPortletKeys.BASIC_INFO_RENDER_CMD }, service = MVCRenderCommand.class)
public class BasicInformationRenderer implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside BasicInformationRenderer Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);

		String draftProductId = ParamUtil.getString(renderRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);

		LOGGER.info("Draft Product Id -------> " + draftProductId);

		Product product = null;

		try {
			product = productLocalService.getProduct(Long.parseLong(draftProductId));
		} catch (Exception e) {
			LOGGER.error("::: Error while fetching product : " + e.getMessage());
		}

		renderRequest.setAttribute(ProductViewPortletKeys.PRODUCT, product);

		try {
			ProductViewUtil.setLastModifiedDateInRequest(renderRequest, product, Long.valueOf(draftProductId));
		} catch (PortalException e) {
			LOGGER.warn("Unable to set Modified Date. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

		return ProductViewPortletKeys.BASIC_INFO_JSP;
	}

	@Reference
	private ProductLocalService productLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(BasicInformationRenderer.class.getName());

}
