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

package com.marketplace.specification.field.data.type.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specification.field.data.type.model.SpecFieldDataType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpecFieldDataType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecFieldDataTypeCacheModel
	implements CacheModel<SpecFieldDataType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecFieldDataTypeCacheModel)) {
			return false;
		}

		SpecFieldDataTypeCacheModel specFieldDataTypeCacheModel =
			(SpecFieldDataTypeCacheModel)object;

		if (specFieldDataTypeId ==
				specFieldDataTypeCacheModel.specFieldDataTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specFieldDataTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specFieldDataTypeId=");
		sb.append(specFieldDataTypeId);
		sb.append(", fieldDataTypeName=");
		sb.append(fieldDataTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpecFieldDataType toEntityModel() {
		SpecFieldDataTypeImpl specFieldDataTypeImpl =
			new SpecFieldDataTypeImpl();

		if (uuid == null) {
			specFieldDataTypeImpl.setUuid("");
		}
		else {
			specFieldDataTypeImpl.setUuid(uuid);
		}

		specFieldDataTypeImpl.setSpecFieldDataTypeId(specFieldDataTypeId);

		if (fieldDataTypeName == null) {
			specFieldDataTypeImpl.setFieldDataTypeName("");
		}
		else {
			specFieldDataTypeImpl.setFieldDataTypeName(fieldDataTypeName);
		}

		specFieldDataTypeImpl.resetOriginalValues();

		return specFieldDataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specFieldDataTypeId = objectInput.readLong();
		fieldDataTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(specFieldDataTypeId);

		if (fieldDataTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldDataTypeName);
		}
	}

	public String uuid;
	public long specFieldDataTypeId;
	public String fieldDataTypeName;

}