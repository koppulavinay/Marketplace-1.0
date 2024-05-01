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

package com.marketplace.product.sku.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.sku.master.model.ProductSKU;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing ProductSKU in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSKUCacheModel
	implements CacheModel<ProductSKU>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSKUCacheModel)) {
			return false;
		}

		ProductSKUCacheModel productSKUCacheModel =
			(ProductSKUCacheModel)object;

		if (productSKUId == productSKUCacheModel.productSKUId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productSKUId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productSKUId=");
		sb.append(productSKUId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
		sb.append(", skuId=");
		sb.append(skuId);
		sb.append(", sellerSkuId=");
		sb.append(sellerSkuId);
		sb.append(", skuName=");
		sb.append(skuName);
		sb.append(", skuCreationName=");
		sb.append(skuCreationName);
		sb.append(", defaultSku=");
		sb.append(defaultSku);
		sb.append(", basePrice=");
		sb.append(basePrice);
		sb.append(", offerPrice=");
		sb.append(offerPrice);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", margin=");
		sb.append(margin);
		sb.append(", stock=");
		sb.append(stock);
		sb.append(", uom=");
		sb.append(uom);
		sb.append(", minimumOrderQuantity=");
		sb.append(minimumOrderQuantity);
		sb.append(", maximumOrderQuantity=");
		sb.append(maximumOrderQuantity);
		sb.append(", lowStockThreshold=");
		sb.append(lowStockThreshold);
		sb.append(", tax=");
		sb.append(tax);
		sb.append(", skuPublishingDate=");
		sb.append(skuPublishingDate);
		sb.append(", skuExpiryDate=");
		sb.append(skuExpiryDate);
		sb.append(", images=");
		sb.append(images);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductSKU toEntityModel() {
		ProductSKUImpl productSKUImpl = new ProductSKUImpl();

		if (uuid == null) {
			productSKUImpl.setUuid("");
		}
		else {
			productSKUImpl.setUuid(uuid);
		}

		productSKUImpl.setProductSKUId(productSKUId);
		productSKUImpl.setGroupId(groupId);
		productSKUImpl.setDraftProductId(draftProductId);

		if (skuId == null) {
			productSKUImpl.setSkuId("");
		}
		else {
			productSKUImpl.setSkuId(skuId);
		}

		if (sellerSkuId == null) {
			productSKUImpl.setSellerSkuId("");
		}
		else {
			productSKUImpl.setSellerSkuId(sellerSkuId);
		}

		if (skuName == null) {
			productSKUImpl.setSkuName("");
		}
		else {
			productSKUImpl.setSkuName(skuName);
		}

		if (skuCreationName == null) {
			productSKUImpl.setSkuCreationName("");
		}
		else {
			productSKUImpl.setSkuCreationName(skuCreationName);
		}

		if (defaultSku == null) {
			productSKUImpl.setDefaultSku("");
		}
		else {
			productSKUImpl.setDefaultSku(defaultSku);
		}

		productSKUImpl.setBasePrice(basePrice);
		productSKUImpl.setOfferPrice(offerPrice);
		productSKUImpl.setCost(cost);
		productSKUImpl.setMargin(margin);
		productSKUImpl.setStock(stock);

		if (uom == null) {
			productSKUImpl.setUom("");
		}
		else {
			productSKUImpl.setUom(uom);
		}

		productSKUImpl.setMinimumOrderQuantity(minimumOrderQuantity);
		productSKUImpl.setMaximumOrderQuantity(maximumOrderQuantity);
		productSKUImpl.setLowStockThreshold(lowStockThreshold);

		if (tax == null) {
			productSKUImpl.setTax("");
		}
		else {
			productSKUImpl.setTax(tax);
		}

		if (skuPublishingDate == Long.MIN_VALUE) {
			productSKUImpl.setSkuPublishingDate(null);
		}
		else {
			productSKUImpl.setSkuPublishingDate(new Date(skuPublishingDate));
		}

		if (skuExpiryDate == Long.MIN_VALUE) {
			productSKUImpl.setSkuExpiryDate(null);
		}
		else {
			productSKUImpl.setSkuExpiryDate(new Date(skuExpiryDate));
		}

		if (images == null) {
			productSKUImpl.setImages("");
		}
		else {
			productSKUImpl.setImages(images);
		}

		productSKUImpl.setCompanyId(companyId);
		productSKUImpl.setUserId(userId);

		if (userName == null) {
			productSKUImpl.setUserName("");
		}
		else {
			productSKUImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productSKUImpl.setCreateDate(null);
		}
		else {
			productSKUImpl.setCreateDate(new Date(createDate));
		}

		productSKUImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			productSKUImpl.setModifiedDate(null);
		}
		else {
			productSKUImpl.setModifiedDate(new Date(modifiedDate));
		}

		productSKUImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			productSKUImpl.setIpAddress("");
		}
		else {
			productSKUImpl.setIpAddress(ipAddress);
		}

		productSKUImpl.resetOriginalValues();

		return productSKUImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		productSKUId = objectInput.readLong();

		groupId = objectInput.readLong();

		draftProductId = objectInput.readLong();
		skuId = objectInput.readUTF();
		sellerSkuId = objectInput.readUTF();
		skuName = objectInput.readUTF();
		skuCreationName = objectInput.readUTF();
		defaultSku = objectInput.readUTF();
		basePrice = (BigDecimal)objectInput.readObject();
		offerPrice = (BigDecimal)objectInput.readObject();
		cost = (BigDecimal)objectInput.readObject();
		margin = (BigDecimal)objectInput.readObject();

		stock = objectInput.readLong();
		uom = objectInput.readUTF();

		minimumOrderQuantity = objectInput.readLong();

		maximumOrderQuantity = objectInput.readLong();

		lowStockThreshold = objectInput.readLong();
		tax = objectInput.readUTF();
		skuPublishingDate = objectInput.readLong();
		skuExpiryDate = objectInput.readLong();
		images = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productSKUId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(draftProductId);

		if (skuId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skuId);
		}

		if (sellerSkuId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sellerSkuId);
		}

		if (skuName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skuName);
		}

		if (skuCreationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skuCreationName);
		}

		if (defaultSku == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultSku);
		}

		objectOutput.writeObject(basePrice);
		objectOutput.writeObject(offerPrice);
		objectOutput.writeObject(cost);
		objectOutput.writeObject(margin);

		objectOutput.writeLong(stock);

		if (uom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uom);
		}

		objectOutput.writeLong(minimumOrderQuantity);

		objectOutput.writeLong(maximumOrderQuantity);

		objectOutput.writeLong(lowStockThreshold);

		if (tax == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tax);
		}

		objectOutput.writeLong(skuPublishingDate);
		objectOutput.writeLong(skuExpiryDate);

		if (images == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(images);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public String uuid;
	public long productSKUId;
	public long groupId;
	public long draftProductId;
	public String skuId;
	public String sellerSkuId;
	public String skuName;
	public String skuCreationName;
	public String defaultSku;
	public BigDecimal basePrice;
	public BigDecimal offerPrice;
	public BigDecimal cost;
	public BigDecimal margin;
	public long stock;
	public String uom;
	public long minimumOrderQuantity;
	public long maximumOrderQuantity;
	public long lowStockThreshold;
	public String tax;
	public long skuPublishingDate;
	public long skuExpiryDate;
	public String images;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String ipAddress;

}