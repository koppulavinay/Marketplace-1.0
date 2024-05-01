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

package com.marketplace.product.pkg.content.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.pkg.content.model.ProductPackageContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductPackageContent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductPackageContentCacheModel
	implements CacheModel<ProductPackageContent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductPackageContentCacheModel)) {
			return false;
		}

		ProductPackageContentCacheModel productPackageContentCacheModel =
			(ProductPackageContentCacheModel)object;

		if (packageContentId ==
				productPackageContentCacheModel.packageContentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, packageContentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", packageContentId=");
		sb.append(packageContentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", itemName=");
		sb.append(itemName);
		sb.append(", itemQuantity=");
		sb.append(itemQuantity);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
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
	public ProductPackageContent toEntityModel() {
		ProductPackageContentImpl productPackageContentImpl =
			new ProductPackageContentImpl();

		if (uuid == null) {
			productPackageContentImpl.setUuid("");
		}
		else {
			productPackageContentImpl.setUuid(uuid);
		}

		productPackageContentImpl.setPackageContentId(packageContentId);
		productPackageContentImpl.setGroupId(groupId);

		if (itemName == null) {
			productPackageContentImpl.setItemName("");
		}
		else {
			productPackageContentImpl.setItemName(itemName);
		}

		if (itemQuantity == null) {
			productPackageContentImpl.setItemQuantity("");
		}
		else {
			productPackageContentImpl.setItemQuantity(itemQuantity);
		}

		productPackageContentImpl.setDraftProductId(draftProductId);
		productPackageContentImpl.setCompanyId(companyId);
		productPackageContentImpl.setUserId(userId);

		if (userName == null) {
			productPackageContentImpl.setUserName("");
		}
		else {
			productPackageContentImpl.setUserName(userName);
		}

		productPackageContentImpl.setCreatedBy(createdBy);
		productPackageContentImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			productPackageContentImpl.setCreateDate(null);
		}
		else {
			productPackageContentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productPackageContentImpl.setModifiedDate(null);
		}
		else {
			productPackageContentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ipAddress == null) {
			productPackageContentImpl.setIpAddress("");
		}
		else {
			productPackageContentImpl.setIpAddress(ipAddress);
		}

		productPackageContentImpl.resetOriginalValues();

		return productPackageContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		packageContentId = objectInput.readLong();

		groupId = objectInput.readLong();
		itemName = objectInput.readUTF();
		itemQuantity = objectInput.readUTF();

		draftProductId = objectInput.readLong();

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

		objectOutput.writeLong(packageContentId);

		objectOutput.writeLong(groupId);

		if (itemName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(itemName);
		}

		if (itemQuantity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(itemQuantity);
		}

		objectOutput.writeLong(draftProductId);

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
	public long packageContentId;
	public long groupId;
	public String itemName;
	public String itemQuantity;
	public long draftProductId;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public String ipAddress;

}