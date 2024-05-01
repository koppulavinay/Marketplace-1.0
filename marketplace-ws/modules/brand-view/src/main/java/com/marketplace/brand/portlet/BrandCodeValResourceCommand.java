package com.marketplace.brand.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW, 
		"mvc.command.name=brandCodeVal", }, service = MVCResourceCommand.class)

public class BrandCodeValResourceCommand extends BaseMVCResourceCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(BrandCodeValResourceCommand.class.getName());

	// brand code validation check using ajax
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside BrandCodeValResourceCommand Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		String brandCode = ParamUtil.getString(resourceRequest,  BrandViewPortletKeys.BRAND_CODE);
		DynamicQuery dynamicQuery = BrandLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.ilike( BrandViewPortletKeys.BRAND_CODE, brandCode));
		List<Brand> brands = BrandLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		if(brands.isEmpty()) {
			jsonObject.put("brandCodeSize", 0);
			jsonObject.put(BrandViewPortletKeys.BRAND_ID, 0);
		} else {
			jsonObject.put("brandCodeSize", brands.size());
			jsonObject.put(BrandViewPortletKeys.BRAND_ID, brands.get(0).getBrandId());
		}
		
		resourceResponse.getWriter().print(jsonObject);
		
	}

}
