package com.marketplace.category.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + CategoryViewPortletKeys.CATEGORYVIEW,
		"javax.portlet.init-param.copy-request-parameters=false",
		"mvc.command.name=categoryCheck" }, service = MVCResourceCommand.class)

public class CategoryNameResourceCommand extends BaseMVCResourceCommand {

	private static final Log logger = LogFactoryUtil.getLog(CategoryNameResourceCommand.class.getName());
	
	// Validation for category name field using ajax servoresource
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info(CategoryViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CategoryNameResourceCommand Method" + CategoryViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		String categoryName = ParamUtil.getString(resourceRequest, CategoryViewPortletKeys.CATEGORY_NAME);
		String categoryCode = ParamUtil.getString(resourceRequest, CategoryViewPortletKeys.CATEGORY_CODE);
		String externalRefId = ParamUtil.getString(resourceRequest, CategoryViewPortletKeys.EXTERNAL_REFID);
		
		List<Category> counter = null;
		DynamicQuery dynamicQuery = CategoryLocalServiceUtil.dynamicQuery();
		
		if(!categoryName.isEmpty()) {
			dynamicQuery.add(RestrictionsFactoryUtil.ilike(CategoryViewPortletKeys.CATEGORY_NAME, categoryName));
		}
		
		if(!categoryCode.isEmpty()) {
			dynamicQuery.add(RestrictionsFactoryUtil.ilike(CategoryViewPortletKeys.CATEGORY_CODE, categoryCode));
		}
		
		if(!externalRefId.isEmpty()) {
			dynamicQuery.add(RestrictionsFactoryUtil.ilike(CategoryViewPortletKeys.EXTERNAL_REFID, externalRefId));
		}
		
		counter = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if (counter.isEmpty()) {
			jsonObject.put(CategoryViewPortletKeys.SIZE, 0);
			jsonObject.put(CategoryViewPortletKeys.CATEGORY_ID, 0);

		} else {
			jsonObject.put(CategoryViewPortletKeys.SIZE, counter.size());
			jsonObject.put(CategoryViewPortletKeys.CATEGORY_ID, counter.get(0).getCategoryId());
		}

		resourceResponse.getWriter().print(jsonObject.toJSONString());

	}
}
