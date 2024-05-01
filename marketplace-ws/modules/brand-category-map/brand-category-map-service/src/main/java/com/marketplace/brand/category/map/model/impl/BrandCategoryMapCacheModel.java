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

package com.marketplace.brand.category.map.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.brand.category.map.model.BrandCategoryMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BrandCategoryMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandCategoryMapCacheModel
	implements CacheModel<BrandCategoryMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrandCategoryMapCacheModel)) {
			return false;
		}

		BrandCategoryMapCacheModel brandCategoryMapCacheModel =
			(BrandCategoryMapCacheModel)object;

		if (brandCategoryMapId ==
				brandCategoryMapCacheModel.brandCategoryMapId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, brandCategoryMapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{brandCategoryMapId=");
		sb.append(brandCategoryMapId);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BrandCategoryMap toEntityModel() {
		BrandCategoryMapImpl brandCategoryMapImpl = new BrandCategoryMapImpl();

		brandCategoryMapImpl.setBrandCategoryMapId(brandCategoryMapId);
		brandCategoryMapImpl.setBrandId(brandId);
		brandCategoryMapImpl.setCategoryId(categoryId);

		brandCategoryMapImpl.resetOriginalValues();

		return brandCategoryMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brandCategoryMapId = objectInput.readLong();

		brandId = objectInput.readLong();

		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(brandCategoryMapId);

		objectOutput.writeLong(brandId);

		objectOutput.writeLong(categoryId);
	}

	public long brandCategoryMapId;
	public long brandId;
	public long categoryId;

}