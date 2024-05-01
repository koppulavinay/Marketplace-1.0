package com.marketplace.product.view.renderer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.BRAND_CATEGORY_SELECT_RENDER_CMD }, service = MVCRenderCommand.class)

public class BrandCategorySelectionRenderer implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(BrandCategorySelectionRenderer.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside BrandCategorySelectionRenderer Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);

		long brandId = 0;
		long categoryId = 0;

		String productType = StringPool.BLANK;

		Product product = null;
		List<String> productTypes = new ArrayList<>();

		// get all the data from masters
		List<Brand> brands = brandLocalService.findByFBYStatus(ProductViewPortletKeys.APPROVED);

		String draftProductId = ParamUtil.getString(renderRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		LOGGER.info("draftProductId--> " + draftProductId);

		/*
		 * productTypes.add(SimpleCPTypeConstants.NAME);
		 * productTypes.add(GroupedCPTypeConstants.NAME);
		 * productTypes.add(VirtualCPTypeConstants.NAME);
		 */

		productTypes.add("physical");
		productTypes.add("service");

		if (!draftProductId.equals("")) {
			try {
				product = productLocalService.getProduct(Long.parseLong(draftProductId));
				brandId = product.getBrandId();
				categoryId = product.getCategoryId();

				if (product.getProductType().equalsIgnoreCase("simple")) {
					productType = "physical";
				} else if (product.getProductType().equalsIgnoreCase("virtual")) {
					productType = "service";
				}

			} catch (Exception e) {
				LOGGER.error("Error while fetching product : " + e.getMessage());
			}
		}

		// setting all the data in request to fetch the data in jsp
		renderRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		renderRequest.setAttribute(ProductViewPortletKeys.PRODUCT, product);
		renderRequest.setAttribute(ProductViewPortletKeys.BRAND_ID, brandId);
		renderRequest.setAttribute(ProductViewPortletKeys.CATEGORY_ID, categoryId);
		renderRequest.setAttribute(ProductViewPortletKeys.PRODUCT_TYPE, productType);
		renderRequest.setAttribute(ProductViewPortletKeys.BRANDS, brands);
		renderRequest.setAttribute(ProductViewPortletKeys.PRODUCT_TYPES, productTypes);

		if (Validator.isNotNull(draftProductId)) {
			try {
				ProductViewUtil.setLastModifiedDateInRequest(renderRequest, product, Long.valueOf(draftProductId));
			} catch (PortalException e) {
				LOGGER.warn("Unable to set Modified Date. Please enable debug logs for full details.");
				LOGGER.debug(e, e);
			}
		}

		return ProductViewPortletKeys.BRAND_CATEGORY_SELECTION;
	}

	@Reference
	private BrandLocalService brandLocalService;

	@Reference
	private ProductLocalService productLocalService;

}
