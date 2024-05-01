package com.marketplace.product.view.renderer;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalServiceUtil;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.util.ProductViewUtil;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name=variantCreationRenderer" }, service = MVCRenderCommand.class)

public class VariantCreationRenderer implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(VariantCreationRenderer.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside VariantCreationRenderer Method"
				+ ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		HttpServletRequest servletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		HttpSession httpSession = servletRequest.getSession();
		httpSession.removeAttribute("sessionskuName");
		String draftProductId = ParamUtil.getString(renderRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		LOGGER.info("vaiant draftProductId--> " + draftProductId);

		List<ProductVariant> productVariants = ProductVariantLocalServiceUtil
				.findByDraftProductId(Long.parseLong(draftProductId));
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProductVariant productVariant : productVariants) {
			List<VariantValue> variantValues = VariantValueLocalServiceUtil
					.findByProductVariantId(productVariant.getProductVariantId());
			JSONObject variantObject = JSONFactoryUtil.createJSONObject();
			variantObject.put("variantName", productVariant.getVariantName());
			variantObject.put("productVariantId", productVariant.getProductVariantId());
			JSONArray valuesArray = JSONFactoryUtil.createJSONArray();

			for (VariantValue variantValue : variantValues) {
				JSONObject valueObject = JSONFactoryUtil.createJSONObject();
				valueObject.put("variantValueId", variantValue.getVariantValueId());
				valueObject.put("variantValue", variantValue.getVariantVal());
				valuesArray.put(valueObject);
				// valuesArray.put(variantValue)
			}

			variantObject.put("variantValues", valuesArray);
			jsonArray.put(variantObject);

		}

		LOGGER.info("jsonArray--> " + jsonArray.toString());

		renderRequest.setAttribute(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		renderRequest.setAttribute("variants", jsonArray);

		try {
			ProductViewUtil.setLastModifiedDateInRequest(renderRequest, null, Long.valueOf(draftProductId));
		} catch (PortalException e) {
			LOGGER.warn("Unable to set Modified Date. Please enable debug logs for full details.");
			LOGGER.debug(e, e);
		}

		return ProductViewPortletKeys.VARIANT_CREATION_JSP;

	}

	@Reference
	private ProductLocalService productLocalService;

}
