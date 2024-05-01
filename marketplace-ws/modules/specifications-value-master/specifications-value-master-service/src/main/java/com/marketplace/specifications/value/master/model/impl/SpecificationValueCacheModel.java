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

package com.marketplace.specifications.value.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specifications.value.master.model.SpecificationValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SpecificationValue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecificationValueCacheModel
	implements CacheModel<SpecificationValue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationValueCacheModel)) {
			return false;
		}

		SpecificationValueCacheModel specificationValueCacheModel =
			(SpecificationValueCacheModel)object;

		if (specificationValueId ==
				specificationValueCacheModel.specificationValueId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specificationValueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specificationValueId=");
		sb.append(specificationValueId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", specificationId=");
		sb.append(specificationId);
		sb.append(", specificationValueLabel=");
		sb.append(specificationValueLabel);
		sb.append(", specificationUOM=");
		sb.append(specificationUOM);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpecificationValue toEntityModel() {
		SpecificationValueImpl specificationValueImpl =
			new SpecificationValueImpl();

		if (uuid == null) {
			specificationValueImpl.setUuid("");
		}
		else {
			specificationValueImpl.setUuid(uuid);
		}

		specificationValueImpl.setSpecificationValueId(specificationValueId);
		specificationValueImpl.setGroupId(groupId);
		specificationValueImpl.setSpecificationId(specificationId);

		if (specificationValueLabel == null) {
			specificationValueImpl.setSpecificationValueLabel("");
		}
		else {
			specificationValueImpl.setSpecificationValueLabel(
				specificationValueLabel);
		}

		if (specificationUOM == null) {
			specificationValueImpl.setSpecificationUOM("");
		}
		else {
			specificationValueImpl.setSpecificationUOM(specificationUOM);
		}

		if (ipAddress == null) {
			specificationValueImpl.setIpAddress("");
		}
		else {
			specificationValueImpl.setIpAddress(ipAddress);
		}

		specificationValueImpl.setCompanyId(companyId);
		specificationValueImpl.setUserId(userId);

		if (userName == null) {
			specificationValueImpl.setUserName("");
		}
		else {
			specificationValueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			specificationValueImpl.setCreateDate(null);
		}
		else {
			specificationValueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			specificationValueImpl.setModifiedDate(null);
		}
		else {
			specificationValueImpl.setModifiedDate(new Date(modifiedDate));
		}

		specificationValueImpl.setCreatedBy(createdBy);
		specificationValueImpl.setModifiedBy(modifiedBy);

		specificationValueImpl.resetOriginalValues();

		return specificationValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specificationValueId = objectInput.readLong();

		groupId = objectInput.readLong();

		specificationId = objectInput.readLong();
		specificationValueLabel = objectInput.readUTF();
		specificationUOM = objectInput.readUTF();
		ipAddress = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(specificationValueId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(specificationId);

		if (specificationValueLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationValueLabel);
		}

		if (specificationUOM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationUOM);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
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
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long specificationValueId;
	public long groupId;
	public long specificationId;
	public String specificationValueLabel;
	public String specificationUOM;
	public String ipAddress;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}