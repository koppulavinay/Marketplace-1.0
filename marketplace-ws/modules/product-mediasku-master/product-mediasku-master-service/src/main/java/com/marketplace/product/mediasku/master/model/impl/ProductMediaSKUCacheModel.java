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

package com.marketplace.product.mediasku.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.mediasku.master.model.ProductMediaSKU;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductMediaSKU in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductMediaSKUCacheModel
	implements CacheModel<ProductMediaSKU>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductMediaSKUCacheModel)) {
			return false;
		}

		ProductMediaSKUCacheModel productMediaSKUCacheModel =
			(ProductMediaSKUCacheModel)object;

		if (ProductMediaSKUId == productMediaSKUCacheModel.ProductMediaSKUId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ProductMediaSKUId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ProductMediaSKUId=");
		sb.append(ProductMediaSKUId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", draftProductId=");
		sb.append(draftProductId);
		sb.append(", productSKUId=");
		sb.append(productSKUId);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductMediaSKU toEntityModel() {
		ProductMediaSKUImpl productMediaSKUImpl = new ProductMediaSKUImpl();

		if (uuid == null) {
			productMediaSKUImpl.setUuid("");
		}
		else {
			productMediaSKUImpl.setUuid(uuid);
		}

		productMediaSKUImpl.setProductMediaSKUId(ProductMediaSKUId);
		productMediaSKUImpl.setGroupId(groupId);
		productMediaSKUImpl.setCompanyId(companyId);
		productMediaSKUImpl.setUserId(userId);

		if (userName == null) {
			productMediaSKUImpl.setUserName("");
		}
		else {
			productMediaSKUImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productMediaSKUImpl.setCreateDate(null);
		}
		else {
			productMediaSKUImpl.setCreateDate(new Date(createDate));
		}

		productMediaSKUImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			productMediaSKUImpl.setModifiedDate(null);
		}
		else {
			productMediaSKUImpl.setModifiedDate(new Date(modifiedDate));
		}

		productMediaSKUImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			productMediaSKUImpl.setIpAddress("");
		}
		else {
			productMediaSKUImpl.setIpAddress(ipAddress);
		}

		productMediaSKUImpl.setDraftProductId(draftProductId);
		productMediaSKUImpl.setProductSKUId(productSKUId);

		if (imageUrl == null) {
			productMediaSKUImpl.setImageUrl("");
		}
		else {
			productMediaSKUImpl.setImageUrl(imageUrl);
		}

		productMediaSKUImpl.setFileEntryId(fileEntryId);

		productMediaSKUImpl.resetOriginalValues();

		return productMediaSKUImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ProductMediaSKUId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		ipAddress = objectInput.readUTF();

		draftProductId = objectInput.readLong();

		productSKUId = objectInput.readLong();
		imageUrl = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ProductMediaSKUId);

		objectOutput.writeLong(groupId);

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

		objectOutput.writeLong(draftProductId);

		objectOutput.writeLong(productSKUId);

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		objectOutput.writeLong(fileEntryId);
	}

	public String uuid;
	public long ProductMediaSKUId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String ipAddress;
	public long draftProductId;
	public long productSKUId;
	public String imageUrl;
	public long fileEntryId;

}