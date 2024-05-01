package com.marketplace.application.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.marketplace.application.constants.RESTAPIsPortletKeys;
import com.marketplace.application.model.BrandModel;
import com.marketplace.application.model.CategoryModel;
import com.marketplace.brand.model.Brand;
import com.marketplace.category.model.Category;

public class RESTAPIsApplicationUtil {

	public static JSONObject createCategoryJSONObject(Category category) {
        JSONObject categoryJSON = JSONFactoryUtil.createJSONObject();

        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_ID, category.getCategoryId());
        categoryJSON.put(RESTAPIsPortletKeys.TREE_PATH, category.getTreePath());
        categoryJSON.put(RESTAPIsPortletKeys.PARENT_CATEGORYID, category.getParentCategoryId());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_NAME, category.getCategoryName());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_DESCRIPTION, category.getCategoryDescription());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_TYPE, category.getCategoryType());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_APPROVAL_STATUS, category.getCategoryApprovalStatus());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_EXPIRY_DATE, category.getCategoryExpiryDate());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_INACTIVE, category.getCategoryInactive());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_EXTERNAL_REFERNNCEID, category.getExternalReferenceId());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_TERMS_AND_CONDITION, category.getTermsCondition());
        categoryJSON.put(RESTAPIsPortletKeys.CREATE_DATE, category.getCreateDate());
        categoryJSON.put(RESTAPIsPortletKeys.MODIFIED_DATE, category.getModifiedDate());
        categoryJSON.put(RESTAPIsPortletKeys.CREATED_BY, category.getCreatedBy());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_MANAGER, category.getAssignManager());
        categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_REVIEWER, category.getAssignReviewer());

        return categoryJSON;
    }
	
	public static JSONObject createBrandJSONObject(Brand brand) {
		JSONObject brandJSON = JSONFactoryUtil.createJSONObject();
		
		brandJSON.put(RESTAPIsPortletKeys.BRAND_ID, brand.getBrandId());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_NAME, brand.getBrandName());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_REVIEWER, brand.getBrandReviewer());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_OWNER, brand.getBrandOwner());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_CODE, brand.getBrandCode());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_DESCRIPTION, brand.getBrandDescription());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_TYPE, brand.getBrandType());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_APPROVAL_STATUS, brand.getBrandApprovalStatus());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_INACTIVE, brand.getBrandInactive());
		brandJSON.put(RESTAPIsPortletKeys.BRAND_EXTERNAL_REFERENCEID, brand.getExternalReferenceId());
		brandJSON.put(RESTAPIsPortletKeys.CREATED_BY, brand.getCreatedBy());
		brandJSON.put(RESTAPIsPortletKeys.CREATE_DATE, brand.getCreateDate());
		brandJSON.put(RESTAPIsPortletKeys.MODIFIED_DATE, brand.getModifiedDate());

        return brandJSON;
    }
	
	public static String validateCategoryField(CategoryModel categoryModel) {
		
		if(categoryModel.getCategoryName().isEmpty()) {
			return RESTAPIsPortletKeys.CATEGORY_NAME_ERROR_MSG;
		}
		
		if(categoryModel.getCreatedBy() == 0) {
			return RESTAPIsPortletKeys.CATEGORY_CREATED_BY_ERROR_MSG;
		}
		
		if(categoryModel.getCategoryType().isEmpty()) {
			return RESTAPIsPortletKeys.CATEGORY_TYPE_ERROR_MSG;
		}
		
		return null;
	}
	
	public static String validateBrandField(BrandModel brandModel) {
			
		if(brandModel.getBrandName() == null) {
			return RESTAPIsPortletKeys.BRAND_NAME_ERROR_MSG;
		}
		
		if(brandModel.getCreatedBy() == 0) {
			return RESTAPIsPortletKeys.BRAND_CREATED_BY_ERROR_MSG;
		}
			
		return null;
	}
	
	public static void updateCategoryModel(CategoryModel categoryModel, Category category) {
		
		if (categoryModel.getParentCategoryId() != 0L) {
			category.setParentCategoryId(categoryModel.getParentCategoryId());
		}

		if (categoryModel.getCategoryName() != null) {
			category.setCategoryName(categoryModel.getCategoryName());
		}

		if (categoryModel.getCategoryDescription() != null) {
			category.setCategoryDescription(categoryModel.getCategoryDescription());
		}

		if (categoryModel.getCategoryType() != null) {
			category.setCategoryType(categoryModel.getCategoryType());
		}

		if (categoryModel.getAssignManager() != 0L) {
			category.setAssignManager(categoryModel.getAssignManager());
		}

		if (categoryModel.getAssignReviewer() != 0L) {
			category.setAssignReviewer(categoryModel.getAssignReviewer());
		}

		if (categoryModel.getExternalReferenceId() != null) {
			category.setExternalReferenceId(categoryModel.getExternalReferenceId());
		}

		if (categoryModel.getTermsCondition() != null) {
			category.setTermsCondition(categoryModel.getTermsCondition());
		}

		if (categoryModel.getCategoryInactive() != null) {
			category.setCategoryInactive(categoryModel.getCategoryInactive());
		}
	}
	
	public static void updateBrandModel(BrandModel brandModel, Brand brand) {
		
		if (brandModel.getBrandName() != null) {
			brand.setBrandName(brandModel.getBrandName());
		}

		if (brandModel.getBrandDescription() != null) {
			brand.setBrandDescription(brandModel.getBrandDescription());
		}
		
		if (brandModel.getBrandCode() != null) {
			brand.setBrandCode(brandModel.getBrandCode());
		}

		if (brandModel.getBrandType() != null) {
			brand.setBrandType(brandModel.getBrandType());
		}

		if (brandModel.getBrandOwner() != null) {
			brand.setBrandOwner(brandModel.getBrandOwner());
		}
		
		if (brandModel.getBrandReviewer() != 0L) {
			brand.setBrandReviewer(brandModel.getBrandReviewer());
		}

		if (brandModel.getExternalReferenceId() != null) {
			brand.setExternalReferenceId(brandModel.getExternalReferenceId());
		}

		if (brandModel.getBrandInactive() != null) {
			brand.setBrandInactive(brandModel.getBrandInactive());
		}
	}

}
