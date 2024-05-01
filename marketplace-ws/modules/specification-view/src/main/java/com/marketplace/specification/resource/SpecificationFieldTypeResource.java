package com.marketplace.specification.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=specificationFieldTypeVal", }, service = MVCResourceCommand.class)

public class SpecificationFieldTypeResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationFieldTypeResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SpecificationLabelResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
	
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		long fieldTypeId = ParamUtil.getLong(resourceRequest, "fieldTypeId");
		LOGGER.info("fieldTypeId--> " + fieldTypeId);
		
		SpecFieldType specFieldType = specFieldTypeLocalService.fetchSpecFieldType(fieldTypeId);
		jsonObject.put("fieldType", specFieldType.getFieldTypeName());
		
		resourceResponse.getWriter().print(jsonObject);
		
	}
	
	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;

}
