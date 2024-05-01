package com.marketplace.specification.resource;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=getAllSpecifications", }, service = MVCResourceCommand.class)

public class GetAllSpecificationsResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(GetAllSpecificationsResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside GetAllSpecificationsResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		List<Specification> specifications = specificationLocalService.getSpecifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd, HH:mm");
		JSONArray specificationJsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Specification specification : specifications) {
			JSONObject specificationJson = JSONFactoryUtil.createJSONObject();
			specificationJson.put(SpecificationViewPortletKeys.SPECIFICATION_ID, specification.getSpecificationId());
			specificationJson.put(SpecificationViewPortletKeys.SPECIFICATION_LABEL, specification.getSpecificationLabel());
			specificationJson.put(SpecificationViewPortletKeys.SPECIFICATION_STATUS, specification.getSpecificationStatus());
			specificationJson.put(SpecificationViewPortletKeys.SPECIFICATION_VALUE_COUNT, 
					specificationValueLocalService.countBySpecificationId(specification.getSpecificationId()));
			specificationJson.put("createDate", dateFormat.format(specification.getCreateDate()));
			specificationJson.put("modifiedDate", dateFormat.format(specification.getModifiedDate()));
			specificationJsonArray.put(specificationJson);
		}
		
		resourceResponse.getWriter().print(specificationJsonArray);
	}
	
	@Reference
	private SpecificationLocalService specificationLocalService;
	
	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

}
