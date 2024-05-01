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

package com.marketplace.brand.document.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.brand.document.master.model.BrandDocumentUpload;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BrandDocumentUpload in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandDocumentUploadCacheModel
	implements CacheModel<BrandDocumentUpload>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrandDocumentUploadCacheModel)) {
			return false;
		}

		BrandDocumentUploadCacheModel brandDocumentUploadCacheModel =
			(BrandDocumentUploadCacheModel)object;

		if (brandDocumentUploadId ==
				brandDocumentUploadCacheModel.brandDocumentUploadId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, brandDocumentUploadId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{brandDocumentUploadId=");
		sb.append(brandDocumentUploadId);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BrandDocumentUpload toEntityModel() {
		BrandDocumentUploadImpl brandDocumentUploadImpl =
			new BrandDocumentUploadImpl();

		brandDocumentUploadImpl.setBrandDocumentUploadId(brandDocumentUploadId);
		brandDocumentUploadImpl.setBrandId(brandId);
		brandDocumentUploadImpl.setDocumentId(documentId);

		brandDocumentUploadImpl.resetOriginalValues();

		return brandDocumentUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brandDocumentUploadId = objectInput.readLong();

		brandId = objectInput.readLong();

		documentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(brandDocumentUploadId);

		objectOutput.writeLong(brandId);

		objectOutput.writeLong(documentId);
	}

	public long brandDocumentUploadId;
	public long brandId;
	public long documentId;

}