package com.marketplace.specification.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=deleteSpecificationVal", }, service = MVCResourceCommand.class)

public class SpecificationValueResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationValueResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SpecificationValueResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		long specificationValueId = ParamUtil.getLong(resourceRequest, "specificationValueId");
		specificationValueLocalService.deleteSpecificationValue(specificationValueId);
		resourceResponse.getWriter().print("true");
		
	}
	
	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

}
