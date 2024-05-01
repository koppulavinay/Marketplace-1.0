package com.marketplace.application;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.application.constants.RESTAPIsPortletKeys;
import com.marketplace.application.model.BrandModel;
import com.marketplace.application.model.CategoryModel;
import com.marketplace.application.util.RESTAPIsApplicationUtil;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.BrandCategoryMapLocalServiceUtil;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author nehalunagar
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/buycorp",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Marketplace.Rest" }, service = Application.class)
public class RESTAPIsApplication extends Application {

	private static final Log logger = LogFactoryUtil.getLog(RESTAPIsApplication.class.getName());

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	// To List all categories 
	@GET
	@Path(RESTAPIsPortletKeys.CATEGORY_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public String categoryDetails() {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Category details" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			JSONObject resJSON = JSONFactoryUtil.createJSONObject();
			JSONArray categoryJSONArray = JSONFactoryUtil.createJSONArray();

			List<Category> allCategoryList = CategoryLocalServiceUtil.getCategories(-1, -1);

			for (Category category : allCategoryList) {
				JSONObject categoryJSON = RESTAPIsApplicationUtil.createCategoryJSONObject(category);
				categoryJSONArray.put(categoryJSON);
			}

			resJSON.put(RESTAPIsPortletKeys.CATEGORY_LIST, categoryJSONArray);
			return resJSON.toString();

		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.GET_CATEGORY_ERROR_MSG;
		}
	}

	// To get details of a category 
	@GET
	@Path(RESTAPIsPortletKeys.CATEGORY_WITH_CATEGORY_ID_PATH) 
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryDetails(@PathParam(RESTAPIsPortletKeys.CATEGORY_ID) long categoryId) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Details of specific category" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);

			if (category != null) {
				JSONObject categoryJSON = RESTAPIsApplicationUtil.createCategoryJSONObject(category);

				return categoryJSON.toString();
			} else {
				return RESTAPIsPortletKeys.GET_SPECIFIC_CATEGORY_MSG;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.GET_CATEGORY_ERROR_MSG;
		}
	}

	// To List all categories tree wise
	@GET
	@Path(RESTAPIsPortletKeys.CATEGORY_TREE_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public String categoryDetailsintree() {
	    try {
	        logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Category tree details" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
	        
	        List<Category> allCategoryList = CategoryLocalServiceUtil.getCategories(-1, -1);
	        Map<Long, List<Category>> categoryMap = new HashMap<>();

	        for (Category category : allCategoryList) {
	            long parentCategoryId = category.getParentCategoryId();
	            categoryMap.computeIfAbsent(parentCategoryId, k -> new ArrayList<>()).add(category);
	        }
	        JSONArray topLevelCategoryArray = JSONFactoryUtil.createJSONArray();
	        for (Category topLevelCategory : categoryMap.get(0L)) {
	            JSONObject topLevelCategoryJSON = buildCategoryJSON(topLevelCategory, categoryMap);
	            topLevelCategoryArray.put(topLevelCategoryJSON);
	        }
	        JSONObject resJSON = JSONFactoryUtil.createJSONObject();
	        resJSON.put(RESTAPIsPortletKeys.CATEGORIES, topLevelCategoryArray);

	        return resJSON.toString();

	    } catch (Exception e) {
	    	logger.error(e.getMessage());
	        return RESTAPIsPortletKeys.GET_CATEGORY_ERROR_MSG;
	    }
	}
	
	private JSONObject buildCategoryJSON(Category category, Map<Long, List<Category>> categoryMap) {
	    JSONObject categoryJSON = RESTAPIsApplicationUtil.createCategoryJSONObject(category);

	    List<Category> subcategories = categoryMap.get(category.getCategoryId());
	    if (subcategories != null) {
	        JSONArray subcategoryArray = JSONFactoryUtil.createJSONArray();
	        for (Category subcategory : subcategories) {
	            JSONObject subcategoryJSON = buildCategoryJSON(subcategory, categoryMap);
	            subcategoryArray.put(subcategoryJSON);
	        }
	        categoryJSON.put(RESTAPIsPortletKeys.SUB_CATEGORIES, subcategoryArray);
	    }

	    return categoryJSON;
	}

	// To get category and all its sub- category tree 
	@GET
	@Path(RESTAPIsPortletKeys.CATEGORY_TREE_SPECIFIC_CATEGORY_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryAndSubcategoryDetails(@PathParam(RESTAPIsPortletKeys.CATEGORY_ID) long categoryId) {
	    try {
	        logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Category tree details of specific category" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
	        List<Category> allCategoryList = CategoryLocalServiceUtil.getCategories(-1, -1);
	        Map<Long, List<Category>> categoryMap = new HashMap<>();

	        for (Category category : allCategoryList) {
	            long parentCategoryId = category.getParentCategoryId();
	            categoryMap.computeIfAbsent(parentCategoryId, k -> new ArrayList<>()).add(category);
	        }
	        JSONObject resJSON = JSONFactoryUtil.createJSONObject();
	        Category targetCategory = findCategory(categoryMap, categoryId);
	        if (targetCategory != null) {
	            JSONObject categoryJSON = buildCategoryJSON(targetCategory, categoryMap);
	            resJSON.put(RESTAPIsPortletKeys.CATEGORY, categoryJSON);
	        } else {
	            resJSON.put(RESTAPIsPortletKeys.ERROR, RESTAPIsPortletKeys.NO_CATEGORY);
	        }
	        return resJSON.toString();

	    } catch (Exception e) {
	    	logger.error(e.getMessage());
	        return RESTAPIsPortletKeys.GET_CATEGORY_ERROR_MSG;
	    }
	}

	private Category findCategory(Map<Long, List<Category>> categoryMap, long targetCategoryId) {
	    for (Category category : categoryMap.get(0L)) {
	        if (category.getCategoryId() == targetCategoryId) {
	            return category;
	        }
	    }
	    return null; 
	}

	// To create a category 
	@POST
	@Path(RESTAPIsPortletKeys.CATEGORY_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createCategory(CategoryModel categoryModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "POST: Create category" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			long categoryId = CounterLocalServiceUtil.increment(Category.class.getName());
			Category category = CategoryLocalServiceUtil.createCategory(categoryId);
			Category parentCategory = null;
			Date createdDate = new Date();
			
			if(categoryModel.getParentCategoryId() == 0L) {
				category.setParentCategoryId(0L);
			}
			else {
				category.setParentCategoryId(categoryModel.getParentCategoryId());				
			}
			
			if(categoryModel.getParentCategoryId() > 0) {
				parentCategory = CategoryLocalServiceUtil.getCategory(categoryModel.getParentCategoryId());
			}
			
			if(categoryModel.getParentCategoryId() == 0L) {
				category.setTreePath("/" + categoryId + "/");
			}
			else if(Validator.isNotNull(parentCategory)){
				category.setTreePath(parentCategory.getTreePath() + categoryId + "/");
			}
			
			RESTAPIsApplicationUtil.validateCategoryField(categoryModel);
			
			category.setCategoryName(categoryModel.getCategoryName());
			category.setCategoryDescription(categoryModel.getCategoryDescription());
			category.setCategoryType(categoryModel.getCategoryType());
			category.setAssignManager(categoryModel.getAssignManager());
			category.setAssignReviewer(categoryModel.getAssignReviewer());
			category.setCategoryApprovalStatus(RESTAPIsPortletKeys.PENDING);
			category.setCategoryExpiryDate(categoryModel.getCategoryExpiryDate());
			category.setCategoryInactive(categoryModel.getCategoryInactive());
			category.setExternalReferenceId(categoryModel.getExternalReferenceId());
			category.setTermsCondition(categoryModel.getTermsCondition());
			category.setCreateDate(createdDate);
			category.setModifiedDate(createdDate);
			category.setCreatedBy(categoryModel.getCreatedBy());

			category = CategoryLocalServiceUtil.addCategory(category);
			
			JSONObject categoryJSON = JSONFactoryUtil.createJSONObject();
			categoryJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.CREATED_CATEGORY_MSG);
			categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_ID, category.getCategoryId());
			logger.info("Category created and Id is" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX + category.getCategoryId());

			return categoryJSON.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.CATEGORY_CREATION_ERROR_MESSAGE;
		}
	}

	// To edit a category 
	@PATCH
	@Path(RESTAPIsPortletKeys.CATEGORY_WITH_CATEGORY_ID_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCategory(@PathParam(RESTAPIsPortletKeys.CATEGORY_ID) long categoryId, CategoryModel categoryModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "PATCH: Update category" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			Category category = CategoryLocalServiceUtil.getCategory(categoryId);

			if (category != null) {

				RESTAPIsApplicationUtil.updateCategoryModel(categoryModel, category);

				category = CategoryLocalServiceUtil.updateCategory(category);
				JSONObject categoryJSON = JSONFactoryUtil.createJSONObject();
				categoryJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.UPDATED_CATEGORY_MSG);
				categoryJSON.put(RESTAPIsPortletKeys.CATEGORY_ID, category.getCategoryId());

				return categoryJSON.toString();
			} else {
				return RESTAPIsPortletKeys.CATEGORY_NOT_FOUND_ERROR_MESSAGE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.CATEGORY_UPDATION_ERROR_MESSAGE;
		}
	}

	// To Deactivate a category 
	@POST
	@Path(RESTAPIsPortletKeys.CATEGORY_WITH_CATEGORY_ID_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deactivateCategory(@PathParam(RESTAPIsPortletKeys.CATEGORY_ID) long categoryId, CategoryModel categoryModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "POST: Deactivate category" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);

			Category category = CategoryLocalServiceUtil.getCategory(categoryId);

			if (category != null) {
				category.setCategoryInactive(categoryModel.getCategoryInactive());
				category = CategoryLocalServiceUtil.updateCategory(category);
				JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
				responseJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.DEACTIVATED_CATEGORY_MSG);
				responseJSON.put(RESTAPIsPortletKeys.CATEGORY_ID, category.getCategoryId());

				return responseJSON.toString();
			} else {
				return RESTAPIsPortletKeys.CATEGORY_NOT_FOUND_ERROR_MESSAGE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.CATEGORY_UPDATION_ERROR_MESSAGE;
		}
	}
	
	public List<Category> fetchByParentCategoryId(long parentCategoryId) {
	    List<Category> categoryList = new ArrayList<>();

	    DynamicQuery dynamicQuery = CategoryLocalServiceUtil.dynamicQuery();
	    dynamicQuery.add(PropertyFactoryUtil.forName(RESTAPIsPortletKeys.PARENT_CATEGORYID).eq(parentCategoryId));

	    List<Category> categories = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);

	    for (Category category : categories) {
	        categoryList.add(category);

	        List<Category> subcategories = fetchByParentCategoryId(category.getCategoryId());
	        categoryList.addAll(subcategories);
	    }

	    return categoryList;
	}
	
	// To create a brand 
	@POST
	@Path(RESTAPIsPortletKeys.BRAND_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createBrand(BrandModel brandModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "POST: Create brand" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			long brandId = CounterLocalServiceUtil.increment(Category.class.getName());
			Brand brand = BrandLocalServiceUtil.createBrand(brandId);
			Date createdDate = new Date();
			
			RESTAPIsApplicationUtil.validateBrandField(brandModel);
			
			brand.setBrandCode(brandModel.getBrandCode());
			brand.setBrandName(brandModel.getBrandName());
			brand.setBrandDescription(brandModel.getBrandDescription());
			brand.setBrandReviewer(brandModel.getBrandReviewer());
			brand.setBrandOwner(brandModel.getBrandOwner());
			brand.setBrandType(brandModel.getBrandType());
			brand.setExternalReferenceId(brandModel.getExternalReferenceId());
			brand.setBrandApprovalStatus(RESTAPIsPortletKeys.PENDING);
			brand.setBrandInactive(brandModel.getBrandInactive());
			brand.setCreateDate(createdDate);
			brand.setModifiedDate(createdDate);
			brand.setCreatedBy(brandModel.getCreatedBy());
			
			brand = BrandLocalServiceUtil.addBrand(brand);
			JSONObject brandJSON = JSONFactoryUtil.createJSONObject();
			brandJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.CREATED_BRAND_MSG);
			brandJSON.put(RESTAPIsPortletKeys.BRAND_ID, brand.getBrandId());
			logger.info("Brand Created and Id is" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX + brand.getBrandId());

			return brandJSON.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.BRAND_CREATION_ERROR_MESSAGE;
		}
	}
	
	// To list all the brands 
	@GET
	@Path(RESTAPIsPortletKeys.BRAND_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public String brandDetails() {
		try {

			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Brand details" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			JSONObject resJSON = JSONFactoryUtil.createJSONObject();
			JSONArray brandJSONArray = JSONFactoryUtil.createJSONArray();
			List<Brand> allBrandList = BrandLocalServiceUtil.getBrands(-1, -1);

			for (Brand brand : allBrandList) {
				JSONObject brandJSON = RESTAPIsApplicationUtil.createBrandJSONObject(brand);
				brandJSONArray.put(brandJSON);
			}

			resJSON.put(RESTAPIsPortletKeys.BRAND_LIST, brandJSONArray);
			return resJSON.toString();

		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.BRAND_FETCH_ERROR_MSG;
		}
	}
	
	// To get details of a brand 
	@GET
	@Path(RESTAPIsPortletKeys.BRAND_WITH_BRAND_ID_PATH) 
	@Produces(MediaType.APPLICATION_JSON)
	public String getBrandDetails(@PathParam(RESTAPIsPortletKeys.BRAND_ID) long brandId) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "GET: Details of specific brand" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			Brand brand = BrandLocalServiceUtil.getBrand(brandId);

			if (brand != null) {
				JSONObject brandJSON = RESTAPIsApplicationUtil.createBrandJSONObject(brand);
				return brandJSON.toString();
				
			} else {
				return RESTAPIsPortletKeys.BRAND_ID_ERROR_MSG;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.BRAND_FETCH_ERROR_MSG;
		}
	}
	
	// To edit a brand 
	@PATCH
	@Path(RESTAPIsPortletKeys.BRAND_WITH_BRAND_ID_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateBrand(@PathParam(RESTAPIsPortletKeys.BRAND_ID) long brandId, BrandModel brandModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "PATCH: Update brand" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);
			Brand brand = BrandLocalServiceUtil.getBrand(brandId);
			
			if (brand != null) {

				RESTAPIsApplicationUtil.updateBrandModel(brandModel, brand);
				brand = BrandLocalServiceUtil.updateBrand(brand);

				JSONObject brandJSON = JSONFactoryUtil.createJSONObject();
				brandJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.UPDATED_BRAND_MSG);
				brandJSON.put(RESTAPIsPortletKeys.BRAND_ID, brand.getBrandId());

				return brandJSON.toString();
			} else {
				return RESTAPIsPortletKeys.BRAND_ID_ERROR_MSG;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.UPDATE_BRAND_ERROR_MSG;
		}
	}
	
	// To cancel a brand 
	@POST
	@Path(RESTAPIsPortletKeys.BRAND_WITH_BRAND_ID_PATH)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deactivateBrand(@PathParam(RESTAPIsPortletKeys.BRAND_ID) long brandId, BrandModel brandModel) {
		try {
			logger.info(RESTAPIsPortletKeys.LOGGER_INFO_PREFIX + "POST: Cancel brand" + RESTAPIsPortletKeys.LOGGER_INFO_SUFFIX);

			Brand brand = BrandLocalServiceUtil.getBrand(brandId);

			if (brand != null) {
				brand.setBrandInactive(brandModel.getBrandInactive());
				brand = BrandLocalServiceUtil.updateBrand(brand);
				JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
				responseJSON.put(RESTAPIsPortletKeys.MESSAGE, RESTAPIsPortletKeys.CANCEL_BRAND);
				responseJSON.put(RESTAPIsPortletKeys.BRAND_ID, brand.getBrandId());

				return responseJSON.toString();
			} else {
				return RESTAPIsPortletKeys.BRAND_ID_ERROR_MSG;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return RESTAPIsPortletKeys.CANCEL_ERROR_MSG;
		}
	}
	
	@POST
	@Path("/brand/brand-category/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String brandCategoryMapping(@PathParam("brandId") long brandId, Map<String, Object> categoryMap) {
	    try {
	    	logger.info("API ::: POST ::: Brand Category Mapping");

	        String categoryMapString = (String) categoryMap.get("categoryMap");
	        String[] categoryIds = categoryMapString.split(",");
	        
	        List<BrandCategoryMap> brandCategoryMaps = BrandCategoryMapLocalServiceUtil.findByFBYBrandId(brandId);
	        for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
	        	BrandCategoryMapLocalServiceUtil.deleteBrandCategoryMap(brandCategoryMap.getBrandCategoryMapId());
	        }
	        logger.info("Deleted earlier Brand Category Mapping");

	        for (String categoryId : categoryIds) {
	            BrandCategoryMap brandCategoryMap = BrandCategoryMapLocalServiceUtil.createBrandCategoryMap(CounterLocalServiceUtil.increment());
	            brandCategoryMap.setBrandId(brandId);
	            brandCategoryMap.setCategoryId(Long.parseLong(categoryId.trim())); 

	            BrandCategoryMapLocalServiceUtil.addBrandCategoryMap(brandCategoryMap);
	        }

	        JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
	        responseJSON.put("message", "Brand mapped with categories successfully");

	        return responseJSON.toString();
	    } catch (Exception e) {
	    	logger.error(e.getMessage());
	        return "{ \"error\": \"An error occurred while creating the brand.\" }";
	    }
	}
	
}

