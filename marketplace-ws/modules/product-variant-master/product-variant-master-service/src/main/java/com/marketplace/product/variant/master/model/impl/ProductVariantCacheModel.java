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

package com.marketplace.product.variant.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.variant.master.model.ProductVariant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductVariant in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductVariantCacheModel
	implements CacheModel<ProductVariant>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductVariantCacheModel)) {
			return false;
		}

		ProductVariantCacheModel productVariantCacheModel =
			(ProductVariantCacheModel)object;

		if (productVariantId == productVariantCacheModel.productVariantId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productVariantId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productVariantId=");
		sb.append(productVariantId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
		sb.append(", variantName=");
		sb.append(variantName);
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
	public ProductVariant toEntityModel() {
		ProductVariantImpl productVariantImpl = new ProductVariantImpl();

		if (uuid == null) {
			productVariantImpl.setUuid("");
		}
		else {
			productVariantImpl.setUuid(uuid);
		}

		productVariantImpl.setProductVariantId(productVariantId);
		productVariantImpl.setGroupId(groupId);
		productVariantImpl.setDraftProductId(draftProductId);

		if (variantName == null) {
			productVariantImpl.setVariantName("");
		}
		else {
			productVariantImpl.setVariantName(variantName);
		}

		productVariantImpl.setCompanyId(companyId);
		productVariantImpl.setUserId(userId);

		if (userName == null) {
			productVariantImpl.setUserName("");
		}
		else {
			productVariantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productVariantImpl.setCreateDate(null);
		}
		else {
			productVariantImpl.setCreateDate(new Date(createDate));
		}

		productVariantImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			productVariantImpl.setModifiedDate(null);
		}
		else {
			productVariantImpl.setModifiedDate(new Date(modifiedDate));
		}

		productVariantImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			productVariantImpl.setIpAddress("");
		}
		else {
			productVariantImpl.setIpAddress(ipAddress);
		}

		productVariantImpl.resetOriginalValues();

		return productVariantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productVariantId = objectInput.readLong();

		groupId = objectInput.readLong();

		draftProductId = objectInput.readLong();
		variantName = objectInput.readUTF();

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

		objectOutput.writeLong(productVariantId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(draftProductId);

		if (variantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(variantName);
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
	public long productVariantId;
	public long groupId;
	public long draftProductId;
	public String variantName;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String ipAddress;

}