package com.marketplace.product.view.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, 
		"mvc.command.name=deleteVariantValue", }, service = MVCResourceCommand.class)

public class DeleteVariantValueResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteVariantValueResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside DeleteVariantValueResource Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		long variantValueId = ParamUtil.getLong(resourceRequest, "variantValueId");
		try {
			variantValueLocalService.deleteVariantValue(variantValueId);
		} catch(Exception e) {
			LOGGER.error("Variant Value is not available :: " + e.getMessage());
		}
		
		
		resourceResponse.getWriter().print("true");
		
	}
	
	@Reference
	private VariantValueLocalService variantValueLocalService;

}
