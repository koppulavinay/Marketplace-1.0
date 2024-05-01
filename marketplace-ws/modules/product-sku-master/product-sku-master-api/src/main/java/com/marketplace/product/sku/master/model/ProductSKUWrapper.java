/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.marketplace.product.sku.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductSKU}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKU
 * @generated
 */
public class ProductSKUWrapper
	extends BaseModelWrapper<ProductSKU>
	implements ModelWrapper<ProductSKU>, ProductSKU {

	public ProductSKUWrapper(ProductSKU productSKU) {
		super(productSKU);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productSKUId", getProductSKUId());
		attributes.put("groupId", getGroupId());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("skuId", getSkuId());
		attributes.put("sellerSkuId", getSellerSkuId());
		attributes.put("skuName", getSkuName());
		attributes.put("skuCreationName", getSkuCreationName());
		attributes.put("defaultSku", getDefaultSku());
		attributes.put("basePrice", getBasePrice());
		attributes.put("offerPrice", getOfferPrice());
		attributes.put("cost", getCost());
		attributes.put("margin", getMargin());
		attributes.put("stock", getStock());
		attributes.put("uom", getUom());
		attributes.put("minimumOrderQuantity", getMinimumOrderQuantity());
		attributes.put("maximumOrderQuantity", getMaximumOrderQuantity());
		attributes.put("lowStockThreshold", getLowStockThreshold());
		attributes.put("tax", getTax());
		attributes.put("skuPublishingDate", getSkuPublishingDate());
		attributes.put("skuExpiryDate", getSkuExpiryDate());
		attributes.put("images", getImages());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productSKUId = (Long)attributes.get("productSKUId");

		if (productSKUId != null) {
			setProductSKUId(productSKUId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
		}

		String skuId = (String)attributes.get("skuId");

		if (skuId != null) {
			setSkuId(skuId);
		}

		String sellerSkuId = (String)attributes.get("sellerSkuId");

		if (sellerSkuId != null) {
			setSellerSkuId(sellerSkuId);
		}

		String skuName = (String)attributes.get("skuName");

		if (skuName != null) {
			setSkuName(skuName);
		}

		String skuCreationName = (String)attributes.get("skuCreationName");

		if (skuCreationName != null) {
			setSkuCreationName(skuCreationName);
		}

		String defaultSku = (String)attributes.get("defaultSku");

		if (defaultSku != null) {
			setDefaultSku(defaultSku);
		}

		BigDecimal basePrice = (BigDecimal)attributes.get("basePrice");

		if (basePrice != null) {
			setBasePrice(basePrice);
		}

		BigDecimal offerPrice = (BigDecimal)attributes.get("offerPrice");

		if (offerPrice != null) {
			setOfferPrice(offerPrice);
		}

		BigDecimal cost = (BigDecimal)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		BigDecimal margin = (BigDecimal)attributes.get("margin");

		if (margin != null) {
			setMargin(margin);
		}

		Long stock = (Long)attributes.get("stock");

		if (stock != null) {
			setStock(stock);
		}

		String uom = (String)attributes.get("uom");

		if (uom != null) {
			setUom(uom);
		}

		Long minimumOrderQuantity = (Long)attributes.get(
			"minimumOrderQuantity");

		if (minimumOrderQuantity != null) {
			setMinimumOrderQuantity(minimumOrderQuantity);
		}

		Long maximumOrderQuantity = (Long)attributes.get(
			"maximumOrderQuantity");

		if (maximumOrderQuantity != null) {
			setMaximumOrderQuantity(maximumOrderQuantity);
		}

		Long lowStockThreshold = (Long)attributes.get("lowStockThreshold");

		if (lowStockThreshold != null) {
			setLowStockThreshold(lowStockThreshold);
		}

		String tax = (String)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		Date skuPublishingDate = (Date)attributes.get("skuPublishingDate");

		if (skuPublishingDate != null) {
			setSkuPublishingDate(skuPublishingDate);
		}

		Date skuExpiryDate = (Date)attributes.get("skuExpiryDate");

		if (skuExpiryDate != null) {
			setSkuExpiryDate(skuExpiryDate);
		}

		String images = (String)attributes.get("images");

		if (images != null) {
			setImages(images);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public ProductSKU cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the base price of this product sku.
	 *
	 * @return the base price of this product sku
	 */
	@Override
	public BigDecimal getBasePrice() {
		return model.getBasePrice();
	}

	/**
	 * Returns the company ID of this product sku.
	 *
	 * @return the company ID of this product sku
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cost of this product sku.
	 *
	 * @return the cost of this product sku
	 */
	@Override
	public BigDecimal getCost() {
		return model.getCost();
	}

	/**
	 * Returns the create date of this product sku.
	 *
	 * @return the create date of this product sku
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product sku.
	 *
	 * @return the created by of this product sku
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the default sku of this product sku.
	 *
	 * @return the default sku of this product sku
	 */
	@Override
	public String getDefaultSku() {
		return model.getDefaultSku();
	}

	/**
	 * Returns the draft product ID of this product sku.
	 *
	 * @return the draft product ID of this product sku
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product sku.
	 *
	 * @return the group ID of this product sku
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the images of this product sku.
	 *
	 * @return the images of this product sku
	 */
	@Override
	public String getImages() {
		return model.getImages();
	}

	/**
	 * Returns the ip address of this product sku.
	 *
	 * @return the ip address of this product sku
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the low stock threshold of this product sku.
	 *
	 * @return the low stock threshold of this product sku
	 */
	@Override
	public long getLowStockThreshold() {
		return model.getLowStockThreshold();
	}

	/**
	 * Returns the margin of this product sku.
	 *
	 * @return the margin of this product sku
	 */
	@Override
	public BigDecimal getMargin() {
		return model.getMargin();
	}

	/**
	 * Returns the maximum order quantity of this product sku.
	 *
	 * @return the maximum order quantity of this product sku
	 */
	@Override
	public long getMaximumOrderQuantity() {
		return model.getMaximumOrderQuantity();
	}

	/**
	 * Returns the minimum order quantity of this product sku.
	 *
	 * @return the minimum order quantity of this product sku
	 */
	@Override
	public long getMinimumOrderQuantity() {
		return model.getMinimumOrderQuantity();
	}

	/**
	 * Returns the modified by of this product sku.
	 *
	 * @return the modified by of this product sku
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product sku.
	 *
	 * @return the modified date of this product sku
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the offer price of this product sku.
	 *
	 * @return the offer price of this product sku
	 */
	@Override
	public BigDecimal getOfferPrice() {
		return model.getOfferPrice();
	}

	/**
	 * Returns the primary key of this product sku.
	 *
	 * @return the primary key of this product sku
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product sku ID of this product sku.
	 *
	 * @return the product sku ID of this product sku
	 */
	@Override
	public long getProductSKUId() {
		return model.getProductSKUId();
	}

	/**
	 * Returns the seller sku ID of this product sku.
	 *
	 * @return the seller sku ID of this product sku
	 */
	@Override
	public String getSellerSkuId() {
		return model.getSellerSkuId();
	}

	/**
	 * Returns the sku creation name of this product sku.
	 *
	 * @return the sku creation name of this product sku
	 */
	@Override
	public String getSkuCreationName() {
		return model.getSkuCreationName();
	}

	/**
	 * Returns the sku expiry date of this product sku.
	 *
	 * @return the sku expiry date of this product sku
	 */
	@Override
	public Date getSkuExpiryDate() {
		return model.getSkuExpiryDate();
	}

	/**
	 * Returns the sku ID of this product sku.
	 *
	 * @return the sku ID of this product sku
	 */
	@Override
	public String getSkuId() {
		return model.getSkuId();
	}

	/**
	 * Returns the sku name of this product sku.
	 *
	 * @return the sku name of this product sku
	 */
	@Override
	public String getSkuName() {
		return model.getSkuName();
	}

	/**
	 * Returns the sku publishing date of this product sku.
	 *
	 * @return the sku publishing date of this product sku
	 */
	@Override
	public Date getSkuPublishingDate() {
		return model.getSkuPublishingDate();
	}

	/**
	 * Returns the stock of this product sku.
	 *
	 * @return the stock of this product sku
	 */
	@Override
	public long getStock() {
		return model.getStock();
	}

	/**
	 * Returns the tax of this product sku.
	 *
	 * @return the tax of this product sku
	 */
	@Override
	public String getTax() {
		return model.getTax();
	}

	/**
	 * Returns the uom of this product sku.
	 *
	 * @return the uom of this product sku
	 */
	@Override
	public String getUom() {
		return model.getUom();
	}

	/**
	 * Returns the user ID of this product sku.
	 *
	 * @return the user ID of this product sku
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product sku.
	 *
	 * @return the user name of this product sku
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product sku.
	 *
	 * @return the user uuid of this product sku
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product sku.
	 *
	 * @return the uuid of this product sku
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the base price of this product sku.
	 *
	 * @param basePrice the base price of this product sku
	 */
	@Override
	public void setBasePrice(BigDecimal basePrice) {
		model.setBasePrice(basePrice);
	}

	/**
	 * Sets the company ID of this product sku.
	 *
	 * @param companyId the company ID of this product sku
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cost of this product sku.
	 *
	 * @param cost the cost of this product sku
	 */
	@Override
	public void setCost(BigDecimal cost) {
		model.setCost(cost);
	}

	/**
	 * Sets the create date of this product sku.
	 *
	 * @param createDate the create date of this product sku
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product sku.
	 *
	 * @param createdBy the created by of this product sku
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the default sku of this product sku.
	 *
	 * @param defaultSku the default sku of this product sku
	 */
	@Override
	public void setDefaultSku(String defaultSku) {
		model.setDefaultSku(defaultSku);
	}

	/**
	 * Sets the draft product ID of this product sku.
	 *
	 * @param draftProductId the draft product ID of this product sku
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product sku.
	 *
	 * @param groupId the group ID of this product sku
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the images of this product sku.
	 *
	 * @param images the images of this product sku
	 */
	@Override
	public void setImages(String images) {
		model.setImages(images);
	}

	/**
	 * Sets the ip address of this product sku.
	 *
	 * @param ipAddress the ip address of this product sku
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the low stock threshold of this product sku.
	 *
	 * @param lowStockThreshold the low stock threshold of this product sku
	 */
	@Override
	public void setLowStockThreshold(long lowStockThreshold) {
		model.setLowStockThreshold(lowStockThreshold);
	}

	/**
	 * Sets the margin of this product sku.
	 *
	 * @param margin the margin of this product sku
	 */
	@Override
	public void setMargin(BigDecimal margin) {
		model.setMargin(margin);
	}

	/**
	 * Sets the maximum order quantity of this product sku.
	 *
	 * @param maximumOrderQuantity the maximum order quantity of this product sku
	 */
	@Override
	public void setMaximumOrderQuantity(long maximumOrderQuantity) {
		model.setMaximumOrderQuantity(maximumOrderQuantity);
	}

	/**
	 * Sets the minimum order quantity of this product sku.
	 *
	 * @param minimumOrderQuantity the minimum order quantity of this product sku
	 */
	@Override
	public void setMinimumOrderQuantity(long minimumOrderQuantity) {
		model.setMinimumOrderQuantity(minimumOrderQuantity);
	}

	/**
	 * Sets the modified by of this product sku.
	 *
	 * @param modifiedBy the modified by of this product sku
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product sku.
	 *
	 * @param modifiedDate the modified date of this product sku
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the offer price of this product sku.
	 *
	 * @param offerPrice the offer price of this product sku
	 */
	@Override
	public void setOfferPrice(BigDecimal offerPrice) {
		model.setOfferPrice(offerPrice);
	}

	/**
	 * Sets the primary key of this product sku.
	 *
	 * @param primaryKey the primary key of this product sku
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product sku ID of this product sku.
	 *
	 * @param productSKUId the product sku ID of this product sku
	 */
	@Override
	public void setProductSKUId(long productSKUId) {
		model.setProductSKUId(productSKUId);
	}

	/**
	 * Sets the seller sku ID of this product sku.
	 *
	 * @param sellerSkuId the seller sku ID of this product sku
	 */
	@Override
	public void setSellerSkuId(String sellerSkuId) {
		model.setSellerSkuId(sellerSkuId);
	}

	/**
	 * Sets the sku creation name of this product sku.
	 *
	 * @param skuCreationName the sku creation name of this product sku
	 */
	@Override
	public void setSkuCreationName(String skuCreationName) {
		model.setSkuCreationName(skuCreationName);
	}

	/**
	 * Sets the sku expiry date of this product sku.
	 *
	 * @param skuExpiryDate the sku expiry date of this product sku
	 */
	@Override
	public void setSkuExpiryDate(Date skuExpiryDate) {
		model.setSkuExpiryDate(skuExpiryDate);
	}

	/**
	 * Sets the sku ID of this product sku.
	 *
	 * @param skuId the sku ID of this product sku
	 */
	@Override
	public void setSkuId(String skuId) {
		model.setSkuId(skuId);
	}

	/**
	 * Sets the sku name of this product sku.
	 *
	 * @param skuName the sku name of this product sku
	 */
	@Override
	public void setSkuName(String skuName) {
		model.setSkuName(skuName);
	}

	/**
	 * Sets the sku publishing date of this product sku.
	 *
	 * @param skuPublishingDate the sku publishing date of this product sku
	 */
	@Override
	public void setSkuPublishingDate(Date skuPublishingDate) {
		model.setSkuPublishingDate(skuPublishingDate);
	}

	/**
	 * Sets the stock of this product sku.
	 *
	 * @param stock the stock of this product sku
	 */
	@Override
	public void setStock(long stock) {
		model.setStock(stock);
	}

	/**
	 * Sets the tax of this product sku.
	 *
	 * @param tax the tax of this product sku
	 */
	@Override
	public void setTax(String tax) {
		model.setTax(tax);
	}

	/**
	 * Sets the uom of this product sku.
	 *
	 * @param uom the uom of this product sku
	 */
	@Override
	public void setUom(String uom) {
		model.setUom(uom);
	}

	/**
	 * Sets the user ID of this product sku.
	 *
	 * @param userId the user ID of this product sku
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product sku.
	 *
	 * @param userName the user name of this product sku
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product sku.
	 *
	 * @param userUuid the user uuid of this product sku
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product sku.
	 *
	 * @param uuid the uuid of this product sku
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProductSKUWrapper wrap(ProductSKU productSKU) {
		return new ProductSKUWrapper(productSKU);
	}

}