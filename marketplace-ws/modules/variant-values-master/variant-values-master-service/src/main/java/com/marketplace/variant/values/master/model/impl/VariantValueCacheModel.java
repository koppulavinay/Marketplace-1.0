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

package com.marketplace.variant.values.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.variant.values.master.model.VariantValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VariantValue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VariantValueCacheModel
	implements CacheModel<VariantValue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VariantValueCacheModel)) {
			return false;
		}

		VariantValueCacheModel variantValueCacheModel =
			(VariantValueCacheModel)object;

		if (variantValueId == variantValueCacheModel.variantValueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, variantValueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", variantValueId=");
		sb.append(variantValueId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", productVariantId=");
		sb.append(productVariantId);
		sb.append(", variantVal=");
		sb.append(variantVal);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
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
	public VariantValue toEntityModel() {
		VariantValueImpl variantValueImpl = new VariantValueImpl();

		if (uuid == null) {
			variantValueImpl.setUuid("");
		}
		else {
			variantValueImpl.setUuid(uuid);
		}

		variantValueImpl.setVariantValueId(variantValueId);
		variantValueImpl.setGroupId(groupId);
		variantValueImpl.setProductVariantId(productVariantId);

		if (variantVal == null) {
			variantValueImpl.setVariantVal("");
		}
		else {
			variantValueImpl.setVariantVal(variantVal);
		}

		variantValueImpl.setDraftProductId(draftProductId);
		variantValueImpl.setCompanyId(companyId);
		variantValueImpl.setUserId(userId);

		if (userName == null) {
			variantValueImpl.setUserName("");
		}
		else {
			variantValueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			variantValueImpl.setCreateDate(null);
		}
		else {
			variantValueImpl.setCreateDate(new Date(createDate));
		}

		variantValueImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			variantValueImpl.setModifiedDate(null);
		}
		else {
			variantValueImpl.setModifiedDate(new Date(modifiedDate));
		}

		variantValueImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			variantValueImpl.setIpAddress("");
		}
		else {
			variantValueImpl.setIpAddress(ipAddress);
		}

		variantValueImpl.resetOriginalValues();

		return variantValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		variantValueId = objectInput.readLong();

		groupId = objectInput.readLong();

		productVariantId = objectInput.readLong();
		variantVal = objectInput.readUTF();

		draftProductId = objectInput.readLong();

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

		objectOutput.writeLong(variantValueId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(productVariantId);

		if (variantVal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(variantVal);
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
	public long variantValueId;
	public long groupId;
	public long productVariantId;
	public String variantVal;
	public long draftProductId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String ipAddress;

}