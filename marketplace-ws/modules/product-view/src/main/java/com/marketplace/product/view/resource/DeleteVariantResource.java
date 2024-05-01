package com.marketplace.product.view.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.product.variant.master.service.ProductVariantLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, 
		"mvc.command.name=deleteVariant", }, service = MVCResourceCommand.class)

public class DeleteVariantResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteVariantResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside DeleteVariantResource Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		long productVariantId = ParamUtil.getLong(resourceRequest, "variantId");
		try {
			List<VariantValue> variantValues = variantValueLocalService.findByProductVariantId(productVariantId);
			
			for (VariantValue variantValue : variantValues) {
				variantValueLocalService.deleteVariantValue(variantValue.getVariantValueId());
			}
			
			productVariantLocalService.deleteProductVariant(productVariantId);
		} catch(Exception e) {
			LOGGER.error("Variant is not available :: " + e.getMessage());
		}
		
		resourceResponse.getWriter().print("true");
	}
	
	@Reference
	private ProductVariantLocalService productVariantLocalService;
	
	@Reference
	private VariantValueLocalService variantValueLocalService;

}
