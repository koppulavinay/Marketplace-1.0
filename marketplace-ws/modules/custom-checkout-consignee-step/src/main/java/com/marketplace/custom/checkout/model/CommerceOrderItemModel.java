package com.marketplace.custom.checkout.model;

import com.liferay.petra.string.StringPool;

import java.math.BigDecimal;

public class CommerceOrderItemModel {

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public String getModelName() {
		return modelName;
	}

	public String getProductFullName() {
		return this.getProductName() + StringPool.SPACE + StringPool.DASH + StringPool.SPACE + this.getModelName();
	}

	public String getProductDisplayUrl() {
		return productDisplayUrl;
	}

	public String getProductVariant() {
		return productVariant;
	}

	public String getSellerId() {
		return sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public long getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getBrandType() {
		return brandType;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setProductDisplayUrl(String productDisplayUrl) {
		this.productDisplayUrl = productDisplayUrl;
	}

	public void setProductVariant(String productVariant) {
		this.productVariant = productVariant;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getCommerceOrderItemId() {
		return commerceOrderItemId;
	}

	public void setCommerceOrderItemId(long commerceOrderItemId) {
		this.commerceOrderItemId = commerceOrderItemId;
	}

	public int getTotalConsignees() {
		return totalConsignees;
	}

	public void setTotalConsignees(int totalConsignees) {
		this.totalConsignees = totalConsignees;
	}

	private long commerceOrderItemId;
	private String productImageUrl;
	private String productName;
	private String modelName;
	private String productDisplayUrl;
	private String productVariant;
	private String sellerId;
	private String sellerName;
	private long brandId;
	private String brandName;
	private String brandType;
	private long categoryId;
	private String categoryName;
	private BigDecimal unitPrice;
	private BigDecimal basePrice;
	private String discountPercentage;
	private int quantity;
	private BigDecimal totalAmount;
	private int totalConsignees;

}
