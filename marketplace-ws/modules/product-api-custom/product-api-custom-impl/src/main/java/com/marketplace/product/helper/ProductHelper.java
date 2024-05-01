package com.marketplace.product.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.product.api.custom.dto.v1_0.Image;
import com.marketplace.product.api.custom.dto.v1_0.PackageContent;
import com.marketplace.product.api.custom.dto.v1_0.ProductListObject;
import com.marketplace.product.api.custom.dto.v1_0.Sku;
import com.marketplace.product.api.custom.dto.v1_0.SkuObject;
import com.marketplace.product.api.custom.dto.v1_0.Specification;
import com.marketplace.product.api.custom.dto.v1_0.SpecificationObject;
import com.marketplace.product.api.custom.dto.v1_0.SpecificationValue;
import com.marketplace.product.api.custom.dto.v1_0.Variant;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.pkg.content.model.ProductPackageContent;
import com.marketplace.product.pkg.content.service.ProductPackageContentLocalService;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.service.ProductSpecValueMapLocalService;
import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.service.ProductSpecificationLocalService;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.ProductVariantLocalService;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.service.VariantValueLocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, service = ProductHelper.class)

public class ProductHelper {
	
	public ProductListObject getProducts(String vendorId, long categoryId,String organizationId, int start,int end) throws PortalException {
		// fetching product using finder method
		List<Product> fetchedProducts = productLocalService.findByProductWithStatusById(vendorId, categoryId, organizationId, "APPROVED", start, end);
		
		ProductListObject productApi = new ProductListObject();
		com.marketplace.product.api.custom.dto.v1_0.Product[] productArray = new com.marketplace.product.api.custom.dto.v1_0.Product[fetchedProducts.size()];
		int i = 0;
		
		// setting up the data
		for(Product product : fetchedProducts) {
		
			com.marketplace.product.api.custom.dto.v1_0.Product productRestAPiObject = new com.marketplace.product.api.custom.dto.v1_0.Product();
			
			Brand brand = brandLocalService.getBrand(product.getBrandId());
			Category category = categoryLocalService.getCategory(categoryId);
			productRestAPiObject.setBrandId(brand.getBrandId());
			productRestAPiObject.setBrandName(brand.getBrandName());
			productRestAPiObject.setCategoryId(categoryId);
			productRestAPiObject.setCategoryName(category.getCategoryName());
			productRestAPiObject.setCreatedDate(product.getCreateDate().toString());
			productRestAPiObject.setModelNumber(product.getModelNumber());
			productRestAPiObject.setModifiedDate(product.getModifiedDate().toString());
			productRestAPiObject.setProductReferenceId(product.getDraftProductId());
			productRestAPiObject.setProductType(product.getProductType());
			productRestAPiObject.setUserId(product.getUserId());
			productRestAPiObject.setUserName(product.getUserName());
			
			// fetching language specific field data
			Map<Locale, String> shortDescriptionMap = product.getShortDescriptionMap();
			JSONObject shortDescObject = JSONFactoryUtil.createJSONObject();
			
			for(Map.Entry<Locale, String> shortDesc : shortDescriptionMap.entrySet()) {
				shortDescObject.put(shortDesc.getKey().toString(), shortDesc.getValue());
			}
			
			productRestAPiObject.setShortDescription(shortDescObject);
			
			// fetching language specific field data
			Map<Locale, String> productNameMap = product.getProductNameMap();
			JSONObject  productNameObject = JSONFactoryUtil.createJSONObject();
			
			for(Map.Entry<Locale, String> productName : productNameMap.entrySet()) {
				productNameObject.put(productName.getKey().toString(), productName.getValue());
			}
			
			productRestAPiObject.setProductName(productNameObject);
			
			// fetching language specific field data
			Map<Locale, String> longDescriptionMap = product.getLongDescriptionMap();
			JSONObject longDescriptionObject = JSONFactoryUtil.createJSONObject();
			
			for(Map.Entry<Locale, String> longDesc : longDescriptionMap.entrySet()) {
				longDescriptionObject.put(longDesc.getKey().toString(), longDesc.getValue());
			}
			
			productRestAPiObject.setLongDescription(longDescriptionObject);
			productArray[i] = productRestAPiObject;
			
			i++;
		}
		
		productApi.setProducts(productArray);
		return productApi;
	}
	
	public SpecificationObject getSpecifications(long draftProductId, int start, int end) {
		
		// fetching the specification using finder method
		SpecificationObject specificationObject = new SpecificationObject();
		List<ProductSpecification> productSepcifications = productSpecificationLocalService.findByDraftProductId(draftProductId);
		
		Specification[] specificationArray = new Specification[productSepcifications.size()];
		int i = 0;
		
		for(ProductSpecification productSpec : productSepcifications) {
			
			Specification specification = new Specification();
			specification.setProductSpecificationId(productSpec.getProductSpecificationId());
			specification.setSpecificationLabel(productSpec.getSpecificationLabel());
			
			// Fetching Specification Values using finder 
			List<ProductSpecValueMap> ProductSpecificationValues = productSpecValueMapLocalService.findByProductSpecificationId(productSpec.getProductSpecificationId());

			SpecificationValue[] specificationValueArray = new SpecificationValue[ProductSpecificationValues.size()];
			int j = 0;
			
			//setting up the data
			for(ProductSpecValueMap productSpecValueMap : ProductSpecificationValues) {
				SpecificationValue specificationValue = new SpecificationValue();
				specificationValue.setSpecificationValueId(productSpecValueMap.getProductSpecValueId());
				specificationValue.setSpecificationValueLabel(productSpecValueMap.getSpecificationValueLabel());
				specificationValueArray[j] = specificationValue;
				
				j++;
			}
			
			specification.setSpecificationValues(specificationValueArray);
			specificationArray[i]=specification;
			
			i++;
		}
		
		specificationObject.setSpecification(specificationArray);
		
		//fetching the package data using finder
		List<ProductPackageContent> productPackageContentList = productPackageContentLocalService.findByDraftProductId(draftProductId);
		PackageContent[] packageContentList = new PackageContent[productPackageContentList.size()];
		
		i = 0;
		
		//setting the data
		for (ProductPackageContent productPackageContent : productPackageContentList) {
			PackageContent packageContent = new PackageContent();
			packageContent.setPackageContentId(packageContent.getPackageContentId());;
			packageContent.setItemName(productPackageContent.getItemName());
			packageContent.setItemQuantity(productPackageContent.getItemQuantity());
			packageContentList[i] = packageContent;
			
			i++;
		}
		
		specificationObject.setPackageContent(packageContentList);
		return specificationObject;
	}
	
	
	public SkuObject getSkuObjects(long draftProductId, int start,int end) {
		//fetchign sku
		List<ProductSKU> productSkuList = productSKULocalService.findByDraftProductSkuId(draftProductId, start, end);
		
		// if data is null return the data 
		if(Validator.isNull(productSkuList)) {
			return null;	
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
		Sku[] skuArray = new Sku[productSkuList.size()];
		
		int i = 0;
		//setting the data 
		for(ProductSKU productSku : productSkuList) {
			
			Sku sku = new Sku();
			sku.setProductSkuId(productSku.getProductSKUId());
			sku.setSkuId(productSku.getSkuId());
			sku.setSkuCreationName(productSku.getSkuCreationName());
			sku.setVariants(getVariantObject(draftProductId,productSku.getSkuCreationName()));
			sku.setBasePrice(productSku.getBasePrice().toString());
			sku.setCost(productSku.getCost().toString());
			sku.setMargin(productSku.getMargin().toString());
			sku.setDefaultSku(productSku.getDefaultSku());
			sku.setOfferPrice(productSku.getOfferPrice().toString());
			sku.setStock(productSku.getStock());
			sku.setLowStockThreshold(productSku.getLowStockThreshold());
			sku.setMaximumOrderQuantity(productSku.getMaximumOrderQuantity());
			sku.setMinimumOrderQuantity(productSku.getMinimumOrderQuantity());
			String formattedDate = dateFormat.format(productSku.getSkuPublishingDate());
			sku.setPublishingDate(formattedDate);
			
			if(productSku.getSkuExpiryDate() != null) {
				 formattedDate = dateFormat.format(productSku.getSkuExpiryDate());
				 sku.setExpiryDate(formattedDate);
			} else {
				sku.setExpiryDate("");
			}
			
			sku.setSellerSkuId(productSku.getSellerSkuId());
			sku.setImages(getImageObject(productSku.getProductSKUId()));
			skuArray[i] =sku;
			
			i++;
		}
		SkuObject skuObject = new SkuObject();
		skuObject.setSkus(skuArray);
		
		return skuObject;
	}
	
	public Variant[] getVariantObject(long draftProductId, String variantName) {
		List<VariantValue> varaintValueList = new ArrayList<>();
		
		if(!variantName.equalsIgnoreCase("Default")) {
			String[] variantValues = variantName.split("/");
			for (String variantValue : variantValues) {
				// fetching the variant data
				varaintValueList.addAll(variantValueLocalService.findByValueAndId(draftProductId, variantValue));
			}
		}
		
		//validating the variantvalue list
		if(Validator.isNull(varaintValueList)) {
			return null;
		}
		
		Variant[] variantArray = new Variant[varaintValueList.size()];
		
		int i = 0;
		
		for(VariantValue variantValue : varaintValueList) {
			
			//fetching the product variant using finder
			Variant variantObject = new Variant();
			ProductVariant productVariant = productVariantLocalService.fetchProductVariant(variantValue.getProductVariantId());
			variantObject.setProductVariantId(productVariant.getProductVariantId());
			variantObject.setVariantName(productVariant.getVariantName());
			variantObject.setVariantValueId(variantValue.getVariantValueId());
			variantObject.setVariantValue(variantValue.getVariantVal());
			variantArray[i] = variantObject;
			
			i++;
		}
		
		return variantArray;
	}
	
	public Image[] getImageObject(long productSkuId) {
		// fetching Images of Sku
		List<ProductMediaSKU> productMediaSkuList = productMediaSKULocalService.findByProductSkuId(productSkuId);

		// Validating the product Media SKu List
		if (Validator.isNull(productMediaSkuList)) {
			return null;
		}

		Image[] imageArray = new Image[productMediaSkuList.size()];
		int i = 0;

		for (ProductMediaSKU productMediaSKU : productMediaSkuList) {
			Image imageObject = new Image();
			imageObject.setImageId(productMediaSKU.getFileEntryId());
			imageObject.setImageURL(productMediaSKU.getImageUrl());
			imageArray[i] = imageObject;
			
			i++;
		}
		
		return imageArray;
	}
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;
	
	@Reference
	private ProductSKULocalService productSKULocalService;
	
	@Reference
	private ProductVariantLocalService productVariantLocalService;
	
	@Reference
	private VariantValueLocalService variantValueLocalService;
	
	@Reference
	private ProductSpecificationLocalService productSpecificationLocalService;
	
	@Reference
	private ProductSpecValueMapLocalService productSpecValueMapLocalService;
	
	@Reference
	private ProductPackageContentLocalService productPackageContentLocalService;
	
	@Reference
	private CategoryLocalService categoryLocalService;
	
	@Reference
	private BrandLocalService brandLocalService;
	
	@Reference
	private ProductLocalService productLocalService;
}
