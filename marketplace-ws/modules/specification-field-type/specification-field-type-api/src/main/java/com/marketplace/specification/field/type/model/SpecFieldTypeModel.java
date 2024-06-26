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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SpecFieldType service. Represents a row in the &quot;marketplace_specfieldtype&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.marketplace.specification.field.type.model.impl.SpecFieldTypeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.marketplace.specification.field.type.model.impl.SpecFieldTypeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldType
 * @generated
 */
@ProviderType
public interface SpecFieldTypeModel extends BaseModel<SpecFieldType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a spec field type model instance should use the {@link SpecFieldType} interface instead.
	 */

	/**
	 * Returns the primary key of this spec field type.
	 *
	 * @return the primary key of this spec field type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this spec field type.
	 *
	 * @param primaryKey the primary key of this spec field type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this spec field type.
	 *
	 * @return the uuid of this spec field type
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this spec field type.
	 *
	 * @param uuid the uuid of this spec field type
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the spec field type ID of this spec field type.
	 *
	 * @return the spec field type ID of this spec field type
	 */
	public long getSpecFieldTypeId();

	/**
	 * Sets the spec field type ID of this spec field type.
	 *
	 * @param specFieldTypeId the spec field type ID of this spec field type
	 */
	public void setSpecFieldTypeId(long specFieldTypeId);

	/**
	 * Returns the field type name of this spec field type.
	 *
	 * @return the field type name of this spec field type
	 */
	@AutoEscape
	public String getFieldTypeName();

	/**
	 * Sets the field type name of this spec field type.
	 *
	 * @param fieldTypeName the field type name of this spec field type
	 */
	public void setFieldTypeName(String fieldTypeName);

	@Override
	public SpecFieldType cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}