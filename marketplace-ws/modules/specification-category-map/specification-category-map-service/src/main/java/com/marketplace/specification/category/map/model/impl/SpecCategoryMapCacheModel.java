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

package com.marketplace.specification.category.map.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specification.category.map.model.SpecCategoryMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SpecCategoryMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecCategoryMapCacheModel
	implements CacheModel<SpecCategoryMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecCategoryMapCacheModel)) {
			return false;
		}

		SpecCategoryMapCacheModel specCategoryMapCacheModel =
			(SpecCategoryMapCacheModel)object;

		if (specCategoryMapId == specCategoryMapCacheModel.specCategoryMapId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specCategoryMapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specCategoryMapId=");
		sb.append(specCategoryMapId);
		sb.append(", specificationId=");
		sb.append(specificationId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", isCategoryMandatory=");
		sb.append(isCategoryMandatory);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpecCategoryMap toEntityModel() {
		SpecCategoryMapImpl specCategoryMapImpl = new SpecCategoryMapImpl();

		if (uuid == null) {
			specCategoryMapImpl.setUuid("");
		}
		else {
			specCategoryMapImpl.setUuid(uuid);
		}

		specCategoryMapImpl.setSpecCategoryMapId(specCategoryMapId);
		specCategoryMapImpl.setSpecificationId(specificationId);
		specCategoryMapImpl.setCategoryId(categoryId);
		specCategoryMapImpl.setIsCategoryMandatory(isCategoryMandatory);
		specCategoryMapImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			specCategoryMapImpl.setCreateDate(null);
		}
		else {
			specCategoryMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			specCategoryMapImpl.setModifiedDate(null);
		}
		else {
			specCategoryMapImpl.setModifiedDate(new Date(modifiedDate));
		}

		specCategoryMapImpl.setCreatedBy(createdBy);
		specCategoryMapImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			specCategoryMapImpl.setIpAddress("");
		}
		else {
			specCategoryMapImpl.setIpAddress(ipAddress);
		}

		specCategoryMapImpl.resetOriginalValues();

		return specCategoryMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specCategoryMapId = objectInput.readLong();

		specificationId = objectInput.readLong();

		categoryId = objectInput.readLong();

		isCategoryMandatory = objectInput.readBoolean();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

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

		objectOutput.writeLong(specCategoryMapId);

		objectOutput.writeLong(specificationId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeBoolean(isCategoryMandatory);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public String uuid;
	public long specCategoryMapId;
	public long specificationId;
	public long categoryId;
	public boolean isCategoryMandatory;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public String ipAddress;

}