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

package com.marketplace.specification.field.type.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpecFieldType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldType
 * @generated
 */
public class SpecFieldTypeWrapper
	extends BaseModelWrapper<SpecFieldType>
	implements ModelWrapper<SpecFieldType>, SpecFieldType {

	public SpecFieldTypeWrapper(SpecFieldType specFieldType) {
		super(specFieldType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specFieldTypeId", getSpecFieldTypeId());
		attributes.put("fieldTypeName", getFieldTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long specFieldTypeId = (Long)attributes.get("specFieldTypeId");

		if (specFieldTypeId != null) {
			setSpecFieldTypeId(specFieldTypeId);
		}

		String fieldTypeName = (String)attributes.get("fieldTypeName");

		if (fieldTypeName != null) {
			setFieldTypeName(fieldTypeName);
		}
	}

	@Override
	public SpecFieldType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the field type name of this spec field type.
	 *
	 * @return the field type name of this spec field type
	 */
	@Override
	public String getFieldTypeName() {
		return model.getFieldTypeName();
	}

	/**
	 * Returns the primary key of this spec field type.
	 *
	 * @return the primary key of this spec field type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spec field type ID of this spec field type.
	 *
	 * @return the spec field type ID of this spec field type
	 */
	@Override
	public long getSpecFieldTypeId() {
		return model.getSpecFieldTypeId();
	}

	/**
	 * Returns the uuid of this spec field type.
	 *
	 * @return the uuid of this spec field type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field type name of this spec field type.
	 *
	 * @param fieldTypeName the field type name of this spec field type
	 */
	@Override
	public void setFieldTypeName(String fieldTypeName) {
		model.setFieldTypeName(fieldTypeName);
	}

	/**
	 * Sets the primary key of this spec field type.
	 *
	 * @param primaryKey the primary key of this spec field type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spec field type ID of this spec field type.
	 *
	 * @param specFieldTypeId the spec field type ID of this spec field type
	 */
	@Override
	public void setSpecFieldTypeId(long specFieldTypeId) {
		model.setSpecFieldTypeId(specFieldTypeId);
	}

	/**
	 * Sets the uuid of this spec field type.
	 *
	 * @param uuid the uuid of this spec field type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SpecFieldTypeWrapper wrap(SpecFieldType specFieldType) {
		return new SpecFieldTypeWrapper(specFieldType);
	}

}