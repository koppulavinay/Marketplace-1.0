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

package com.marketplace.product.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.master.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCacheModel)) {
			return false;
		}

		ProductCacheModel productCacheModel = (ProductCacheModel)object;

		if (draftProductId == productCacheModel.draftProductId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, draftProductId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", productType=");
		sb.append(productType);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", longDescription=");
		sb.append(longDescription);
		sb.append(", modelNumber=");
		sb.append(modelNumber);
		sb.append(", productStatus=");
		sb.append(productStatus);
		sb.append(", stepNumber=");
		sb.append(stepNumber);
		sb.append(", productMappingId=");
		sb.append(productMappingId);
		sb.append(", taxCategoryId=");
		sb.append(taxCategoryId);
		sb.append(", cpDefinitionId=");
		sb.append(cpDefinitionId);
		sb.append(", vendorId=");
		sb.append(vendorId);
		sb.append(", vendorName=");
		sb.append(vendorName);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		if (uuid == null) {
			productImpl.setUuid("");
		}
		else {
			productImpl.setUuid(uuid);
		}

		productImpl.setDraftProductId(draftProductId);
		productImpl.setGroupId(groupId);
		productImpl.setBrandId(brandId);
		productImpl.setCategoryId(categoryId);

		if (productName == null) {
			productImpl.setProductName("");
		}
		else {
			productImpl.setProductName(productName);
		}

		if (productType == null) {
			productImpl.setProductType("");
		}
		else {
			productImpl.setProductType(productType);
		}

		if (shortDescription == null) {
			productImpl.setShortDescription("");
		}
		else {
			productImpl.setShortDescription(shortDescription);
		}

		if (longDescription == null) {
			productImpl.setLongDescription("");
		}
		else {
			productImpl.setLongDescription(longDescription);
		}

		if (modelNumber == null) {
			productImpl.setModelNumber("");
		}
		else {
			productImpl.setModelNumber(modelNumber);
		}

		if (productStatus == null) {
			productImpl.setProductStatus("");
		}
		else {
			productImpl.setProductStatus(productStatus);
		}

		productImpl.setStepNumber(stepNumber);

		if (productMappingId == null) {
			productImpl.setProductMappingId("");
		}
		else {
			productImpl.setProductMappingId(productMappingId);
		}

		productImpl.setTaxCategoryId(taxCategoryId);
		productImpl.setCpDefinitionId(cpDefinitionId);

		if (vendorId == null) {
			productImpl.setVendorId("");
		}
		else {
			productImpl.setVendorId(vendorId);
		}

		if (vendorName == null) {
			productImpl.setVendorName("");
		}
		else {
			productImpl.setVendorName(vendorName);
		}

		if (organizationId == null) {
			productImpl.setOrganizationId("");
		}
		else {
			productImpl.setOrganizationId(organizationId);
		}

		if (organizationName == null) {
			productImpl.setOrganizationName("");
		}
		else {
			productImpl.setOrganizationName(organizationName);
		}

		productImpl.setCompanyId(companyId);
		productImpl.setUserId(userId);

		if (userName == null) {
			productImpl.setUserName("");
		}
		else {
			productImpl.setUserName(userName);
		}

		productImpl.setCreatedBy(createdBy);
		productImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			productImpl.setCreateDate(null);
		}
		else {
			productImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productImpl.setModifiedDate(null);
		}
		else {
			productImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ipAddress == null) {
			productImpl.setIpAddress("");
		}
		else {
			productImpl.setIpAddress(ipAddress);
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		draftProductId = objectInput.readLong();

		groupId = objectInput.readLong();

		brandId = objectInput.readLong();

		categoryId = objectInput.readLong();
		productName = objectInput.readUTF();
		productType = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		longDescription = objectInput.readUTF();
		modelNumber = objectInput.readUTF();
		productStatus = objectInput.readUTF();

		stepNumber = objectInput.readLong();
		productMappingId = objectInput.readUTF();

		taxCategoryId = objectInput.readLong();

		cpDefinitionId = objectInput.readLong();
		vendorId = objectInput.readUTF();
		vendorName = objectInput.readUTF();
		organizationId = objectInput.readUTF();
		organizationName = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(draftProductId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(brandId);

		objectOutput.writeLong(categoryId);

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (longDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longDescription);
		}

		if (modelNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modelNumber);
		}

		if (productStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productStatus);
		}

		objectOutput.writeLong(stepNumber);

		if (productMappingId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productMappingId);
		}

		objectOutput.writeLong(taxCategoryId);

		objectOutput.writeLong(cpDefinitionId);

		if (vendorId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vendorId);
		}

		if (vendorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vendorName);
		}

		if (organizationId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationId);
		}

		if (organizationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public String uuid;
	public long draftProductId;
	public long groupId;
	public long brandId;
	public long categoryId;
	public String productName;
	public String productType;
	public String shortDescription;
	public String longDescription;
	public String modelNumber;
	public String productStatus;
	public long stepNumber;
	public String productMappingId;
	public long taxCategoryId;
	public long cpDefinitionId;
	public String vendorId;
	public String vendorName;
	public String organizationId;
	public String organizationName;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public String ipAddress;

}