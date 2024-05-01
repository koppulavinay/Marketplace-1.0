package com.marketplace.specification.resource;

import com.liferay.commerce.product.model.CPSpecificationOption;
import com.liferay.commerce.product.service.CPSpecificationOptionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=specificationDelete", }, service = MVCResourceCommand.class)

public class DeleteSpecificationResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteSpecificationResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside DeleteSpecificationResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long specificationId = ParamUtil.getLong(resourceRequest, SpecificationViewPortletKeys.SPECIFICATION_ID);
		
		Specification specification = specificationLocalService.getSpecification(specificationId);
		
		// Deleting Specification Option from Liferay Commerce
		try {
			deleteSpecOptionFromCommerce(themeDisplay.getCompanyId(), specification.getSpecificationLabel());
		} catch (PortalException e) {
			LOGGER.warn("No Specification Option found in Liferay with key----------> " + specification.getSpecificationLabel().toLowerCase());
			LOGGER.debug(e, e);
		}
		
		List<SpecificationValue> specificationValues = specificationValueLocalService.findByFBYSpecificationId(specificationId);
		for (SpecificationValue specificationValue : specificationValues) {
			specificationValueLocalService.deleteSpecificationValue(specificationValue.getSpecificationValueId());
		}
		
		List<SpecCategoryMap> specCategoryMaps = specCategoryMapLocalService.findByFBYSpecificationId(specificationId);
		for (SpecCategoryMap specCategoryMap : specCategoryMaps) {
			specCategoryMapLocalService.deleteSpecCategoryMap(specCategoryMap.getSpecCategoryMapId());
		}

		specificationLocalService.deleteSpecification(specificationId);
		
		LOGGER.info("--------- Specification deleted successfully ---------");
		
		resourceResponse.getWriter().print(Boolean.TRUE);
		
	}
	
	private void deleteSpecOptionFromCommerce(long companyId, String specificationLabel) throws PortalException {
		
		CPSpecificationOption cpSpecificationOption = cpSpecificationOptionLocalService.getCPSpecificationOption(companyId, specificationLabel.toLowerCase());
		
		cpSpecificationOptionLocalService.deleteCPSpecificationOption(cpSpecificationOption);
		
	}
	
	@Reference
	private SpecificationLocalService specificationLocalService;
	
	@Reference
	private SpecificationValueLocalService specificationValueLocalService;
	
	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;
	
	@Reference
	private CPSpecificationOptionLocalService cpSpecificationOptionLocalService;

}
