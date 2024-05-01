package com.marketplace.product.inventory.management.helper;

import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CProductLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.product.inventory.management.constants.BuycorpProductInventoryManagementPortletKeys;
import com.marketplace.product.inventory.management.model.ProductModel;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.sku.master.exception.NoSuchProductSKUException;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ProductListingHelper.class)

public class ProductListingHelper {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ProductListingHelper.class);

	public List<ProductModel> getAllProducts(ThemeDisplay themeDisplay, int start, int end,String search) {

		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside getAllProducts Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		
		List<Product> products = getProductsByModifiedDate(themeDisplay.getUserId(), themeDisplay.getCompanyId(),start,end,search);

		List<ProductModel> productsModel = new ArrayList<>();

		products.stream().forEach(product -> {
			ProductModel productModel = new ProductModel();

			String createdDate = formatDateInUTC(product.getCreateDate());

			productModel.setProductId(product.getDraftProductId());
			productModel.setProductName(product.getProductName(themeDisplay.getLocale()));
			productModel.setCreateDate(createdDate);
			try {
				productModel.setStatus(getProductStatusCode(product.getDraftProductId(), themeDisplay));
			} catch (PortalException e) {
				LOGGER.warn("unable to fetch product status");
			}
			productModel.setProductMappingId(product.getProductMappingId());
			//productModel.setImageURL(getProductImageURL(product.getDraftProductId()));
			
			if(product.getProductType().equalsIgnoreCase("simple")) {
				productModel.setProductType("Physical");
			} else if(product.getProductType().equalsIgnoreCase("virtual")) {
				productModel.setProductType("Service");
			}

			String brandName = StringPool.BLANK;
			String categoryName = StringPool.BLANK;

			try {
				brandName = brandLocalService.getBrand(product.getBrandId()).getBrandName();
				categoryName = categoryLocalService.getCategory(product.getCategoryId()).getCategoryName();
			} catch (PortalException e) {
				e.getStackTrace();
			}

			productModel.setBrandName(brandName);
			productModel.setCategoryName(categoryName);

			productsModel.add(productModel);

		});

		return productsModel;
	}
	
	public List<ProductModel> getAllProducts(ThemeDisplay themeDisplay) {

		LOGGER.info(BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_PREFIX + "Inside getAllProducts Method" + 
				BuycorpProductInventoryManagementPortletKeys.LOGGER_INFO_SUFFIX);
		
		List<Product> products = getProductsByModifiedDate(themeDisplay.getUserId(), themeDisplay.getCompanyId(),"");

		List<ProductModel> productsModel = new ArrayList<>();

		products.stream().forEach(product -> {
			ProductModel productModel = new ProductModel();

			String createdDate = formatDateInUTC(product.getCreateDate());

			productModel.setProductId(product.getDraftProductId());
			productModel.setProductName(product.getProductName(themeDisplay.getLocale()));
			productModel.setCreateDate(createdDate);
			try {
				productModel.setStatus(getProductStatusCode(product.getDraftProductId(), themeDisplay));
			} catch (PortalException e) {
				LOGGER.warn("unable to fetch product status");
			}
			productModel.setProductMappingId(product.getProductMappingId());
			//productModel.setImageURL(getProductImageURL(product.getDraftProductId()));
			
			if(product.getProductType().equalsIgnoreCase("simple")) {
				productModel.setProductType("Physical");
			} else if(product.getProductType().equalsIgnoreCase("virtual")) {
				productModel.setProductType("Service");
			}

			String brandName = StringPool.BLANK;
			String categoryName = StringPool.BLANK;

			try {
				brandName = brandLocalService.getBrand(product.getBrandId()).getBrandName();
				categoryName = categoryLocalService.getCategory(product.getCategoryId()).getCategoryName();
			} catch (PortalException e) {
				e.getStackTrace();
			}

			productModel.setBrandName(brandName);
			productModel.setCategoryName(categoryName);

			productsModel.add(productModel);

		});

		return productsModel;
	}
	
	public List<Product> fetchAllProductWithSearch(ThemeDisplay themeDisplay,String search){
		return getProductsByModifiedDate(themeDisplay.getUserId(), themeDisplay.getCompanyId(),search);
	}
	
	private List<Product> getProductsByModifiedDate(long userId, long companyId,String search) {

		long adminstratorRoleId = 0l;
		try {
			adminstratorRoleId = RoleLocalServiceUtil.getRole(companyId, "Administrator").getRoleId();
		} catch (Exception e) {
			LOGGER.error("No role exist as Administrator :: " + e.getMessage());
		}
		
		final long adminRoleId = adminstratorRoleId;
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
		boolean administrator = roles.stream().anyMatch(role -> role.getRoleId() == adminRoleId);
		
		Order order = OrderFactoryUtil.desc("modifiedDate");
		DynamicQuery dynamicQuery = productLocalService.dynamicQuery();
		dynamicQuery.addOrder(order);
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("productStatus", "APPROVED"));
		if(Validator.isNotNull(search)) {
			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("LOWER (productName) LIKE ?", "%" + search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			dynamicQuery.add(disjunction);
		}
		if(!administrator) {
			dynamicQuery.add(PropertyFactoryUtil.forName("createdBy").eq(userId));
		}

		return productLocalService.dynamicQuery(dynamicQuery);

	}
	
	private List<Product> getProductsByModifiedDate(long userId, long companyId, int start , int end,String search) {

		long adminstratorRoleId = 0l;
		try {
			adminstratorRoleId = RoleLocalServiceUtil.getRole(companyId, "Administrator").getRoleId();
		} catch (Exception e) {
			LOGGER.error("No role exist as Administrator :: " + e.getMessage());
		}
		
		final long adminRoleId = adminstratorRoleId;
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
		boolean administrator = roles.stream().anyMatch(role -> role.getRoleId() == adminRoleId);
		
		Order order = OrderFactoryUtil.desc("modifiedDate");
		DynamicQuery dynamicQuery = productLocalService.dynamicQuery();
		dynamicQuery.addOrder(order);
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("productStatus", "APPROVED"));
		if(Validator.isNotNull(search)) {
			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			Criterion criterion = RestrictionsFactoryUtil.sqlRestriction("LOWER (productName) LIKE ?", "%" + search.toLowerCase() + "%", Type.STRING);
			disjunction.add(criterion);
			dynamicQuery.add(disjunction);
		}
		if(!administrator) {
			dynamicQuery.add(PropertyFactoryUtil.forName("createdBy").eq(userId));
		}

		LOGGER.info("dynamic query "+dynamicQuery);
		return productLocalService.dynamicQuery(dynamicQuery,start,end);

	}
	
	private String formatDateInUTC(Date date) {

		return new SimpleDateFormat("MMM dd, yyyy, HH:mm").format(date);
	}
	
	private String getProductStatusCode(long draftProductId, ThemeDisplay themeDisplay) throws PortalException {

		CProduct cProduct = cProductLocalService.getCProductByExternalReferenceCode(String.valueOf(draftProductId),
				themeDisplay.getCompanyId());
		int status = cpDefinitionLocalService.fetchCPDefinitionByCProductId(cProduct.getCProductId()).getStatus();

		return WorkflowConstants.getStatusLabel(status);

	}
	
	private String getProductImageURL(long draftProductId) {

		ProductSKU defaultSKU = null;

		try {
			defaultSKU = productSKULocalService.findByDraftProductIdNDefaultSKU(draftProductId, "on");

			List<ProductMediaSKU> productMediaSKU = productMediaSKULocalService
					.findByProductSKUIdWithDraftProductId(draftProductId, defaultSKU.getProductSKUId());

			return productMediaSKU.stream().filter(element -> element.getImageUrl() != null).findFirst().get()
					.getImageUrl();
		} catch (NoSuchProductSKUException e) {
			LOGGER.warn("Unable to get Product Media SKU with Product Id---------> " + draftProductId);
		}

		return StringPool.BLANK;
	}
	
	@Reference
	private CProductLocalService cProductLocalService;

	@Reference
	private CPDefinitionLocalService cpDefinitionLocalService;
	
	@Reference
	private ProductSKULocalService productSKULocalService;

	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;
	
	@Reference
	private ProductLocalService productLocalService;
	
	@Reference
	private BrandLocalService brandLocalService;

	@Reference
	private CategoryLocalService categoryLocalService;
}
