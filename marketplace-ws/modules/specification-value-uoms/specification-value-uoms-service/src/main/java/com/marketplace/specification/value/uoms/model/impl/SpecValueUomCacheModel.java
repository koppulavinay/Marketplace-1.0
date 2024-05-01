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

package com.marketplace.specification.value.uoms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.specification.value.uoms.model.SpecValueUom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SpecValueUom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecValueUomCacheModel
	implements CacheModel<SpecValueUom>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecValueUomCacheModel)) {
			return false;
		}

		SpecValueUomCacheModel specValueUomCacheModel =
			(SpecValueUomCacheModel)object;

		if (specValueUomId == specValueUomCacheModel.specValueUomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specValueUomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", specValueUomId=");
		sb.append(specValueUomId);
		sb.append(", valueUomName=");
		sb.append(valueUomName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpecValueUom toEntityModel() {
		SpecValueUomImpl specValueUomImpl = new SpecValueUomImpl();

		if (uuid == null) {
			specValueUomImpl.setUuid("");
		}
		else {
			specValueUomImpl.setUuid(uuid);
		}

		specValueUomImpl.setSpecValueUomId(specValueUomId);

		if (valueUomName == null) {
			specValueUomImpl.setValueUomName("");
		}
		else {
			specValueUomImpl.setValueUomName(valueUomName);
		}

		specValueUomImpl.resetOriginalValues();

		return specValueUomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		specValueUomId = objectInput.readLong();
		valueUomName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(specValueUomId);

		if (valueUomName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(valueUomName);
		}
	}

	public String uuid;
	public long specValueUomId;
	public String valueUomName;

}