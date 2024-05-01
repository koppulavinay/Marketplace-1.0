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

package com.marketplace.brand.document.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BrandDocumentUpload}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandDocumentUpload
 * @generated
 */
public class BrandDocumentUploadWrapper
	extends BaseModelWrapper<BrandDocumentUpload>
	implements BrandDocumentUpload, ModelWrapper<BrandDocumentUpload> {

	public BrandDocumentUploadWrapper(BrandDocumentUpload brandDocumentUpload) {
		super(brandDocumentUpload);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brandDocumentUploadId", getBrandDocumentUploadId());
		attributes.put("brandId", getBrandId());
		attributes.put("documentId", getDocumentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brandDocumentUploadId = (Long)attributes.get(
			"brandDocumentUploadId");

		if (brandDocumentUploadId != null) {
			setBrandDocumentUploadId(brandDocumentUploadId);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}
	}

	@Override
	public BrandDocumentUpload cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the brand document upload ID of this brand document upload.
	 *
	 * @return the brand document upload ID of this brand document upload
	 */
	@Override
	public long getBrandDocumentUploadId() {
		return model.getBrandDocumentUploadId();
	}

	/**
	 * Returns the brand ID of this brand document upload.
	 *
	 * @return the brand ID of this brand document upload
	 */
	@Override
	public long getBrandId() {
		return model.getBrandId();
	}

	/**
	 * Returns the document ID of this brand document upload.
	 *
	 * @return the document ID of this brand document upload
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the primary key of this brand document upload.
	 *
	 * @return the primary key of this brand document upload
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the brand document upload ID of this brand document upload.
	 *
	 * @param brandDocumentUploadId the brand document upload ID of this brand document upload
	 */
	@Override
	public void setBrandDocumentUploadId(long brandDocumentUploadId) {
		model.setBrandDocumentUploadId(brandDocumentUploadId);
	}

	/**
	 * Sets the brand ID of this brand document upload.
	 *
	 * @param brandId the brand ID of this brand document upload
	 */
	@Override
	public void setBrandId(long brandId) {
		model.setBrandId(brandId);
	}

	/**
	 * Sets the document ID of this brand document upload.
	 *
	 * @param documentId the document ID of this brand document upload
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the primary key of this brand document upload.
	 *
	 * @param primaryKey the primary key of this brand document upload
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BrandDocumentUploadWrapper wrap(
		BrandDocumentUpload brandDocumentUpload) {

		return new BrandDocumentUploadWrapper(brandDocumentUpload);
	}

}