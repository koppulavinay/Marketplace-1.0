package com.marketplace.specification.resource;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW, 
		"mvc.command.name=specificationLabelVal", }, service = MVCResourceCommand.class)

public class SpecificationLabelResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SpecificationLabelResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside SpecificationLabelResource Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		String specificationLabel = ParamUtil.getString(resourceRequest, SpecificationViewPortletKeys.SPECIFICATION_LABEL);
		DynamicQuery dynamicQuery = specificationLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.ilike(SpecificationViewPortletKeys.SPECIFICATION_LABEL, specificationLabel));
		List<Specification> specifications = specificationLocalService.dynamicQuery(dynamicQuery);
		
		if(specifications.isEmpty()) {
			jsonObject.put("specificationLabelSize", 0);
			jsonObject.put(SpecificationViewPortletKeys.SPECIFICATION_ID, 0);
		} else {
			jsonObject.put("specificationLabelSize", specifications.size());
			jsonObject.put(SpecificationViewPortletKeys.SPECIFICATION_ID, specifications.get(0).getSpecificationId());
		}
		
		resourceResponse.getWriter().print(jsonObject);
		
	}
	
	@Reference
	private SpecificationLocalService specificationLocalService;

}
