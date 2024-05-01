package com.marketplace.product.view.helper;

import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CProductLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.pkg.content.model.ProductPackageContent;
import com.marketplace.product.pkg.content.service.ProductPackageContentLocalService;
import com.marketplace.product.search.keywords.model.ProductSearchKeywords;
import com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalService;
import com.marketplace.product.sku.master.exception.NoSuchProductSKUException;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.service.ProductSpecValueMapLocalService;
import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.service.ProductSpecificationLocalService;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalService;
import com.marketplace.product.view.model.ProductModel;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author kashyap.mishra
 *
 */
@Component(immediate = true, service = ProductListingHelper.class)
public class ProductListingHelper {

	public List<ProductModel> getAllProducts(ThemeDisplay themeDisplay) {

		List<Product> products = getProductsByModifiedDate(themeDisplay.getUserId(), themeDisplay.getCompanyId());

		List<ProductModel> productsModel = new ArrayList<>();

		products.stream().forEach(product -> {
			ProductModel productModel = new ProductModel();

			String createdDate = productViewHelper.formatDateInUTC(product.getCreateDate());

			productModel.setProductId(product.getDraftProductId());
			productModel.setProductName(product.getProductName(themeDisplay.getLocale()));
			productModel.setCreateDate(createdDate);
			try {
				productModel.setStatus(getProductStatusCode(product.getDraftProductId(), themeDisplay));
			} catch (PortalException e) {
				LOGGER.warn("unable to fetch product status");
			}
			productModel.setProductMappingId(product.getProductMappingId());
			productModel.setImageURL(getProductImageURL(product.getDraftProductId()));
			
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

	private List<Product> getProductsByModifiedDate(long userId, long companyId) {

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
		
		if(!administrator) {
			dynamicQuery.add(PropertyFactoryUtil.forName("createdBy").eq(userId));
		}

		return productLocalService.dynamicQuery(dynamicQuery);

	}

	private String getProductImageURL(long draftProductId) {

		ProductSKU defaultSKU = null;

		try {
			defaultSKU = productSKULocalService.findByDraftProductIdNDefaultSKU(draftProductId, "on");

			List<ProductMediaSKU> productMediaSKU = productMediaSKULocalService
					.findByProductSKUIdWithDraftProductId(draftProductId, defaultSKU.getProductSKUId());

			return productMediaSKU.stream().filter(element -> element.getImageUrl() != null).findFirst().get()
					.getImageUrl();
		} catch (NoSuchProductSKUException | NoSuchElementException e) {
			LOGGER.warn("Unable to get Product Media SKU with Product Id---------> " + draftProductId);
		}

		return StringPool.BLANK;
	}

	private String getProductStatusCode(long draftProductId, ThemeDisplay themeDisplay) throws PortalException {

		CProduct cProduct = cProductLocalService.getCProductByExternalReferenceCode(String.valueOf(draftProductId),
				themeDisplay.getCompanyId());
		int status = cpDefinitionLocalService.fetchCPDefinitionByCProductId(cProduct.getCProductId()).getStatus();

		return WorkflowConstants.getStatusLabel(status);

	}

	public void deleteProduct(long draftProductId, long companyId) throws PortalException {

		deleteProductFromCommerce(draftProductId, companyId);
		deleteAdditionalInformation(draftProductId);
		deleteProductSKUs(draftProductId);
		deleteProductVariants(draftProductId);
		deleteProductSpecification(draftProductId);

		productLocalService.deleteProduct(draftProductId);

	}

	private void deleteProductSpecification(long draftProductId) {
		List<ProductSpecification> specifications = productSpecificationLocalService
				.findByDraftProductId(draftProductId);

		specifications.stream().forEach(specification -> {
			List<ProductSpecValueMap> specificationValues = productSpecValueMapLocalService
					.findByProductSpecificationId(specification.getSpecificationId());
			specificationValues.stream().forEach(specificationValue -> {
				try {
					productSpecValueMapLocalService
							.deleteProductSpecValueMap(specificationValue.getProductSpecValueId());
				} catch (PortalException e) {
					LOGGER.warn(
							"Unable to delete Product Spec Value mapping. Please enable debug logs for full details");
					LOGGER.debug(e, e);
				}
			});

			try {
				productSpecificationLocalService.deleteProductSpecification(specification.getSpecificationId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to delete Product Spec Value mapping. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});
	}

	private void deleteProductVariants(long draftProductId) {
		List<ProductVariant> productVariants = productVariantLocalService.findByDraftProductId(draftProductId);
		productVariants.stream().forEach(variant -> {
			List<VariantValue> variantValues = variantValueLocalService
					.findByProductVariantId(variant.getProductVariantId());
			variantValues.stream().forEach(variantValue -> {
				try {
					variantValueLocalService.deleteVariantValue(variantValue.getVariantValueId());
				} catch (PortalException e) {
					LOGGER.warn(
							"Unable to delete Product variant Value mapping. Please enable debug logs for full details");
					LOGGER.debug(e, e);
				}
			});
			try {
				productVariantLocalService.deleteProductVariant(variant.getProductVariantId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to delete Product variant mapping. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});

	}

	private void deleteProductSKUs(long draftProductId) {
		List<ProductSKU> productSKUs = productSKULocalService.findByDraftProductSkuId(draftProductId);

		productSKUs.stream().forEach(productSKU -> {

			List<ProductMediaSKU> productMediaSKUs = productMediaSKULocalService
					.findByProductSkuId(productSKU.getProductSKUId());

			productMediaSKUs.stream().forEach(productMediaSKU -> {
				try {
					productMediaSKULocalService.deleteProductMediaSKU(productMediaSKU.getProductMediaSKUId());
				} catch (PortalException e) {
					LOGGER.warn(
							"Unable to delete Product SKU media mapping. Please enable debug logs for full details");
					LOGGER.debug(e, e);
				}
			});

			try {
				productSKULocalService.deleteProductSKU(productSKU.getProductSKUId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to delete Product SKU mapping. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});
	}

	private void deleteAdditionalInformation(long draftProductId) {
		List<ProductSearchKeywords> productSearchKeywords = productSearchKeywordsLocalService
				.findByDraftProductId(draftProductId);
		List<ProductPackageContent> productPackageContents = productPackageContentLocalService
				.findByDraftProductId(draftProductId);

		productSearchKeywords.stream().forEach(productSearchKeyword -> {
			try {
				productSearchKeywordsLocalService
						.deleteProductSearchKeywords(productSearchKeyword.getSearchKeywordId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to delete Product Search keywords. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});

		productPackageContents.stream().forEach(productPackageContent -> {
			try {
				productPackageContentLocalService
						.deleteProductPackageContent(productPackageContent.getPackageContentId());
			} catch (PortalException e) {
				LOGGER.warn("Unable to delete Product package content. Please enable debug logs for full details");
				LOGGER.debug(e, e);
			}
		});
	}

	private void deleteProductFromCommerce(long draftProductId, long companyId) throws PortalException {
		CProduct cProduct = cProductLocalService.getCProductByExternalReferenceCode(String.valueOf(draftProductId),
				companyId);
		CPDefinition cPDefinition = cpDefinitionLocalService.fetchCPDefinitionByCProductId(cProduct.getCProductId());
		cpDefinitionLocalService.deleteCPDefinition(cPDefinition.getCPDefinitionId());
	}

	@Reference
	private ProductLocalService productLocalService;

	@Reference
	private ProductSpecificationLocalService productSpecificationLocalService;

	@Reference
	private ProductSpecValueMapLocalService productSpecValueMapLocalService;

	@Reference
	private ProductVariantLocalService productVariantLocalService;

	@Reference
	private VariantValueLocalService variantValueLocalService;

	@Reference
	private ProductSKULocalService productSKULocalService;

	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;

	@Reference
	private ProductSearchKeywordsLocalService productSearchKeywordsLocalService;

	@Reference
	private ProductPackageContentLocalService productPackageContentLocalService;

	@Reference
	private BrandLocalService brandLocalService;

	@Reference
	private CategoryLocalService categoryLocalService;

	@Reference
	private ProductViewHelper productViewHelper;

	@Reference
	private CProductLocalService cProductLocalService;

	@Reference
	private CPDefinitionLocalService cpDefinitionLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(ProductListingHelper.class);

}