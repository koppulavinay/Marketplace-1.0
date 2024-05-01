package com.marketplace.product.inventory.management.model;


import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ProductModel.class)
public class ProductModel {

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getStatus() {
		return status;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getProductMappingId() {
		return productMappingId;
	}

	public void setProductMappingId(String productMappingId) {
		this.productMappingId = productMappingId;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	private long productId;
	private String productName;
	private String categoryName;
	private String brandName;
	private String status;
	private String createDate;
	private String productMappingId;
	private String imageURL;
	private String productType;

}
