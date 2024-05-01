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

package com.marketplace.specification.value.uoms.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpecValueUom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecValueUom
 * @generated
 */
public class SpecValueUomWrapper
	extends BaseModelWrapper<SpecValueUom>
	implements ModelWrapper<SpecValueUom>, SpecValueUom {

	public SpecValueUomWrapper(SpecValueUom specValueUom) {
		super(specValueUom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specValueUomId", getSpecValueUomId());
		attributes.put("valueUomName", getValueUomName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long specValueUomId = (Long)attributes.get("specValueUomId");

		if (specValueUomId != null) {
			setSpecValueUomId(specValueUomId);
		}

		String valueUomName = (String)attributes.get("valueUomName");

		if (valueUomName != null) {
			setValueUomName(valueUomName);
		}
	}

	@Override
	public SpecValueUom cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this spec value uom.
	 *
	 * @return the primary key of this spec value uom
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spec value uom ID of this spec value uom.
	 *
	 * @return the spec value uom ID of this spec value uom
	 */
	@Override
	public long getSpecValueUomId() {
		return model.getSpecValueUomId();
	}

	/**
	 * Returns the uuid of this spec value uom.
	 *
	 * @return the uuid of this spec value uom
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the value uom name of this spec value uom.
	 *
	 * @return the value uom name of this spec value uom
	 */
	@Override
	public String getValueUomName() {
		return model.getValueUomName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this spec value uom.
	 *
	 * @param primaryKey the primary key of this spec value uom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spec value uom ID of this spec value uom.
	 *
	 * @param specValueUomId the spec value uom ID of this spec value uom
	 */
	@Override
	public void setSpecValueUomId(long specValueUomId) {
		model.setSpecValueUomId(specValueUomId);
	}

	/**
	 * Sets the uuid of this spec value uom.
	 *
	 * @param uuid the uuid of this spec value uom
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the value uom name of this spec value uom.
	 *
	 * @param valueUomName the value uom name of this spec value uom
	 */
	@Override
	public void setValueUomName(String valueUomName) {
		model.setValueUomName(valueUomName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SpecValueUomWrapper wrap(SpecValueUom specValueUom) {
		return new SpecValueUomWrapper(specValueUom);
	}

}