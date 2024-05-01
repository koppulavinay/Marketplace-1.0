package com.marketplace.specification.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=getSpecifications", }, service = MVCResourceCommand.class)

public class GetSpecificationsResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(GetSpecificationsResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside GetSpecificationsResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		long specificationId = ParamUtil.getLong(resourceRequest, SpecificationViewPortletKeys.SPECIFICATION_ID);
		List<SpecificationValue> specificationValues = specificationValueLocalService.findByFBYSpecificationId(specificationId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (SpecificationValue specificationValue : specificationValues) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("specificationValueId", specificationValue.getSpecificationValueId())
				.put("valueLabel", specificationValue.getSpecificationValueLabel()).put("valueUOM", specificationValue.getSpecificationUOM());
			jsonArray.put(jsonObject);
		}
		
		resourceResponse.getWriter().print(jsonArray);
		
	}
	
	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

}
