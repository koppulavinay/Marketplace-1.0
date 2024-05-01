package com.buycorp.common.util.resource;

import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = {"javax.portlet.name=" + CPPortletKeys.CP_COMPARE_CONTENT_MINI_WEB,
"mvc.command.name=categoryCheck"}, service = MVCResourceCommand.class)

public class CategoryCheckResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Calling Ajax Method In Compare Mini ");
		String cookiesData = ParamUtil.getString(resourceRequest, "cookiedata");
		//System.out.println("Cookies Data ::::: " + cookiesData);
		String[] cookiesDataArray = cookiesData.split(":");
		boolean sameCategory = true;
		if(cookiesDataArray.length !=0) {
			List<Long> categories = new ArrayList<>();
			for (int i = cookiesDataArray.length - 1; i >= 0; i--) {
			    AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(CPDefinition.class.getName(), Long.parseLong(cookiesDataArray[i]));
			    //System.out.println("Asset Entry " + assetEntry);
			    if(Validator.isNotNull(assetEntry)) {
				    List<AssetEntryAssetCategoryRel> assetEntryAssetCategoryRelList = AssetEntryAssetCategoryRelLocalServiceUtil
				    		.getAssetEntryAssetCategoryRelsByAssetEntryId(assetEntry.getEntryId());
				    for(AssetEntryAssetCategoryRel assetCategoryRel : assetEntryAssetCategoryRelList){
				    	AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryRel.getAssetCategoryId());
				    	AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetCategory.getVocabularyId());
				    	if(assetVocabulary.getName().equalsIgnoreCase("select category")){
				      		if(categories.isEmpty()){
				    			categories.add(assetCategory.getCategoryId());
				    		}else if(!categories.contains(assetCategory.getCategoryId())){
				    			sameCategory = false;
				    			categories.remove(0);
				    			break;
				    		}
				      	}
				    }
			    }
			}
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("sameCategory", sameCategory);
		resourceResponse.getWriter().print(jsonObject);
	}

}
