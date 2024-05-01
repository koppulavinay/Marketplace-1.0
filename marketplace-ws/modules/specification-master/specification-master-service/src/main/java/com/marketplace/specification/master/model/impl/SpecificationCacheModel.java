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

package com.marketplace.specification.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specification.master.model.Specification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Specification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecificationCacheModel
	implements CacheModel<Specification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationCacheModel)) {
			return false;
		}

		SpecificationCacheModel specificationCacheModel =
			(SpecificationCacheModel)object;

		if (specificationId == specificationCacheModel.specificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specificationId=");
		sb.append(specificationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", specificationLabel=");
		sb.append(specificationLabel);
		sb.append(", specificationDescription=");
		sb.append(specificationDescription);
		sb.append(", specificationFieldType=");
		sb.append(specificationFieldType);
		sb.append(", specificationFieldDataType=");
		sb.append(specificationFieldDataType);
		sb.append(", specificationPriority=");
		sb.append(specificationPriority);
		sb.append(", isVariant=");
		sb.append(isVariant);
		sb.append(", specificationGroupId=");
		sb.append(specificationGroupId);
		sb.append(", cpSpecificationId=");
		sb.append(cpSpecificationId);
		sb.append(", specificationStatus=");
		sb.append(specificationStatus);
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
	public Specification toEntityModel() {
		SpecificationImpl specificationImpl = new SpecificationImpl();

		if (uuid == null) {
			specificationImpl.setUuid("");
		}
		else {
			specificationImpl.setUuid(uuid);
		}

		specificationImpl.setSpecificationId(specificationId);
		specificationImpl.setGroupId(groupId);

		if (specificationLabel == null) {
			specificationImpl.setSpecificationLabel("");
		}
		else {
			specificationImpl.setSpecificationLabel(specificationLabel);
		}

		if (specificationDescription == null) {
			specificationImpl.setSpecificationDescription("");
		}
		else {
			specificationImpl.setSpecificationDescription(
				specificationDescription);
		}

		specificationImpl.setSpecificationFieldType(specificationFieldType);
		specificationImpl.setSpecificationFieldDataType(
			specificationFieldDataType);
		specificationImpl.setSpecificationPriority(specificationPriority);
		specificationImpl.setIsVariant(isVariant);
		specificationImpl.setSpecificationGroupId(specificationGroupId);
		specificationImpl.setCpSpecificationId(cpSpecificationId);

		if (specificationStatus == null) {
			specificationImpl.setSpecificationStatus("");
		}
		else {
			specificationImpl.setSpecificationStatus(specificationStatus);
		}

		if (ipAddress == null) {
			specificationImpl.setIpAddress("");
		}
		else {
			specificationImpl.setIpAddress(ipAddress);
		}

		specificationImpl.setCompanyId(companyId);
		specificationImpl.setUserId(userId);

		if (userName == null) {
			specificationImpl.setUserName("");
		}
		else {
			specificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			specificationImpl.setCreateDate(null);
		}
		else {
			specificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			specificationImpl.setModifiedDate(null);
		}
		else {
			specificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		specificationImpl.setCreatedBy(createdBy);
		specificationImpl.setModifiedBy(modifiedBy);

		specificationImpl.resetOriginalValues();

		return specificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specificationId = objectInput.readLong();

		groupId = objectInput.readLong();
		specificationLabel = objectInput.readUTF();
		specificationDescription = objectInput.readUTF();

		specificationFieldType = objectInput.readLong();

		specificationFieldDataType = objectInput.readLong();

		specificationPriority = objectInput.readLong();

		isVariant = objectInput.readBoolean();

		specificationGroupId = objectInput.readLong();

		cpSpecificationId = objectInput.readLong();
		specificationStatus = objectInput.readUTF();
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

		objectOutput.writeLong(specificationId);

		objectOutput.writeLong(groupId);

		if (specificationLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationLabel);
		}

		if (specificationDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationDescription);
		}

		objectOutput.writeLong(specificationFieldType);

		objectOutput.writeLong(specificationFieldDataType);

		objectOutput.writeLong(specificationPriority);

		objectOutput.writeBoolean(isVariant);

		objectOutput.writeLong(specificationGroupId);

		objectOutput.writeLong(cpSpecificationId);

		if (specificationStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationStatus);
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
	public long specificationId;
	public long groupId;
	public String specificationLabel;
	public String specificationDescription;
	public long specificationFieldType;
	public long specificationFieldDataType;
	public long specificationPriority;
	public boolean isVariant;
	public long specificationGroupId;
	public long cpSpecificationId;
	public String specificationStatus;
	public String ipAddress;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}