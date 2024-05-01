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

package com.marketplace.specification.field.type.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specification.field.type.model.SpecFieldType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpecFieldType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecFieldTypeCacheModel
	implements CacheModel<SpecFieldType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecFieldTypeCacheModel)) {
			return false;
		}

		SpecFieldTypeCacheModel specFieldTypeCacheModel =
			(SpecFieldTypeCacheModel)object;

		if (specFieldTypeId == specFieldTypeCacheModel.specFieldTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specFieldTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specFieldTypeId=");
		sb.append(specFieldTypeId);
		sb.append(", fieldTypeName=");
		sb.append(fieldTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpecFieldType toEntityModel() {
		SpecFieldTypeImpl specFieldTypeImpl = new SpecFieldTypeImpl();

		if (uuid == null) {
			specFieldTypeImpl.setUuid("");
		}
		else {
			specFieldTypeImpl.setUuid(uuid);
		}

		specFieldTypeImpl.setSpecFieldTypeId(specFieldTypeId);

		if (fieldTypeName == null) {
			specFieldTypeImpl.setFieldTypeName("");
		}
		else {
			specFieldTypeImpl.setFieldTypeName(fieldTypeName);
		}

		specFieldTypeImpl.resetOriginalValues();

		return specFieldTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specFieldTypeId = objectInput.readLong();
		fieldTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(specFieldTypeId);

		if (fieldTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldTypeName);
		}
	}

	public String uuid;
	public long specFieldTypeId;
	public String fieldTypeName;

}