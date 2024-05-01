package com.marketplace.product.view.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalService;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW, 
		"mvc.command.name=categoryMap", }, service = MVCResourceCommand.class)

public class CategoryMapResource extends BaseMVCResourceCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(CategoryMapResource.class.getName());

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info(ProductViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CategoryMapResource Method" + ProductViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		long brandId = ParamUtil.getLong(resourceRequest, "brandId");
		List<BrandCategoryMap> brandCategoryMaps = brandCategoryMapLocalService.findByFBYBrandId(brandId);
		JSONObject categoryJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
			Category category = categoryLocalService.getCategory(brandCategoryMap.getCategoryId());
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("categoryId", category.getCategoryId());
			jsonObject.put("categoryName", category.getCategoryName());
			jsonArray.put(jsonObject);
		}
		categoryJson.put("categoryJson", jsonArray);
		resourceResponse.getWriter().print(categoryJson);
	}
	
	@Reference
	private BrandCategoryMapLocalService brandCategoryMapLocalService;
	
	@Reference
	private CategoryLocalService categoryLocalService;

}
