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

package com.marketplace.product.specifications.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.specifications.master.model.ProductSpecification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductSpecification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSpecificationCacheModel
	implements CacheModel<ProductSpecification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSpecificationCacheModel)) {
			return false;
		}

		ProductSpecificationCacheModel productSpecificationCacheModel =
			(ProductSpecificationCacheModel)object;

		if (productSpecificationId ==
				productSpecificationCacheModel.productSpecificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productSpecificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productSpecificationId=");
		sb.append(productSpecificationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", specificationId=");
		sb.append(specificationId);
		sb.append(", specificationLabel=");
		sb.append(specificationLabel);
		sb.append(", specificationFieldType=");
		sb.append(specificationFieldType);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
		sb.append(", isMandatory=");
		sb.append(isMandatory);
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
	public ProductSpecification toEntityModel() {
		ProductSpecificationImpl productSpecificationImpl =
			new ProductSpecificationImpl();

		if (uuid == null) {
			productSpecificationImpl.setUuid("");
		}
		else {
			productSpecificationImpl.setUuid(uuid);
		}

		productSpecificationImpl.setProductSpecificationId(
			productSpecificationId);
		productSpecificationImpl.setGroupId(groupId);
		productSpecificationImpl.setSpecificationId(specificationId);

		if (specificationLabel == null) {
			productSpecificationImpl.setSpecificationLabel("");
		}
		else {
			productSpecificationImpl.setSpecificationLabel(specificationLabel);
		}

		if (specificationFieldType == null) {
			productSpecificationImpl.setSpecificationFieldType("");
		}
		else {
			productSpecificationImpl.setSpecificationFieldType(
				specificationFieldType);
		}

		productSpecificationImpl.setDraftProductId(draftProductId);
		productSpecificationImpl.setIsMandatory(isMandatory);
		productSpecificationImpl.setCompanyId(companyId);
		productSpecificationImpl.setUserId(userId);

		if (userName == null) {
			productSpecificationImpl.setUserName("");
		}
		else {
			productSpecificationImpl.setUserName(userName);
		}

		productSpecificationImpl.setCreatedBy(createdBy);
		productSpecificationImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			productSpecificationImpl.setCreateDate(null);
		}
		else {
			productSpecificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productSpecificationImpl.setModifiedDate(null);
		}
		else {
			productSpecificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ipAddress == null) {
			productSpecificationImpl.setIpAddress("");
		}
		else {
			productSpecificationImpl.setIpAddress(ipAddress);
		}

		productSpecificationImpl.resetOriginalValues();

		return productSpecificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productSpecificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		specificationId = objectInput.readLong();
		specificationLabel = objectInput.readUTF();
		specificationFieldType = objectInput.readUTF();

		draftProductId = objectInput.readLong();

		isMandatory = objectInput.readBoolean();

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

		objectOutput.writeLong(productSpecificationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(specificationId);

		if (specificationLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationLabel);
		}

		if (specificationFieldType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationFieldType);
		}

		objectOutput.writeLong(draftProductId);

		objectOutput.writeBoolean(isMandatory);

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
	public long productSpecificationId;
	public long groupId;
	public long specificationId;
	public String specificationLabel;
	public String specificationFieldType;
	public long draftProductId;
	public boolean isMandatory;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public String ipAddress;

}