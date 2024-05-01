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

package com.marketplace.specification.field.data.type.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpecFieldDataType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldDataType
 * @generated
 */
public class SpecFieldDataTypeWrapper
	extends BaseModelWrapper<SpecFieldDataType>
	implements ModelWrapper<SpecFieldDataType>, SpecFieldDataType {

	public SpecFieldDataTypeWrapper(SpecFieldDataType specFieldDataType) {
		super(specFieldDataType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specFieldDataTypeId", getSpecFieldDataTypeId());
		attributes.put("fieldDataTypeName", getFieldDataTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long specFieldDataTypeId = (Long)attributes.get("specFieldDataTypeId");

		if (specFieldDataTypeId != null) {
			setSpecFieldDataTypeId(specFieldDataTypeId);
		}

		String fieldDataTypeName = (String)attributes.get("fieldDataTypeName");

		if (fieldDataTypeName != null) {
			setFieldDataTypeName(fieldDataTypeName);
		}
	}

	@Override
	public SpecFieldDataType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the field data type name of this spec field data type.
	 *
	 * @return the field data type name of this spec field data type
	 */
	@Override
	public String getFieldDataTypeName() {
		return model.getFieldDataTypeName();
	}

	/**
	 * Returns the primary key of this spec field data type.
	 *
	 * @return the primary key of this spec field data type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spec field data type ID of this spec field data type.
	 *
	 * @return the spec field data type ID of this spec field data type
	 */
	@Override
	public long getSpecFieldDataTypeId() {
		return model.getSpecFieldDataTypeId();
	}

	/**
	 * Returns the uuid of this spec field data type.
	 *
	 * @return the uuid of this spec field data type
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
	 * Sets the field data type name of this spec field data type.
	 *
	 * @param fieldDataTypeName the field data type name of this spec field data type
	 */
	@Override
	public void setFieldDataTypeName(String fieldDataTypeName) {
		model.setFieldDataTypeName(fieldDataTypeName);
	}

	/**
	 * Sets the primary key of this spec field data type.
	 *
	 * @param primaryKey the primary key of this spec field data type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spec field data type ID of this spec field data type.
	 *
	 * @param specFieldDataTypeId the spec field data type ID of this spec field data type
	 */
	@Override
	public void setSpecFieldDataTypeId(long specFieldDataTypeId) {
		model.setSpecFieldDataTypeId(specFieldDataTypeId);
	}

	/**
	 * Sets the uuid of this spec field data type.
	 *
	 * @param uuid the uuid of this spec field data type
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
	protected SpecFieldDataTypeWrapper wrap(
		SpecFieldDataType specFieldDataType) {

		return new SpecFieldDataTypeWrapper(specFieldDataType);
	}

}