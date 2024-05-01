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

package com.marketplace.specification.category.map.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpecCategoryMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMap
 * @generated
 */
public class SpecCategoryMapWrapper
	extends BaseModelWrapper<SpecCategoryMap>
	implements ModelWrapper<SpecCategoryMap>, SpecCategoryMap {

	public SpecCategoryMapWrapper(SpecCategoryMap specCategoryMap) {
		super(specCategoryMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specCategoryMapId", getSpecCategoryMapId());
		attributes.put("specificationId", getSpecificationId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("isCategoryMandatory", isIsCategoryMandatory());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long specCategoryMapId = (Long)attributes.get("specCategoryMapId");

		if (specCategoryMapId != null) {
			setSpecCategoryMapId(specCategoryMapId);
		}

		Long specificationId = (Long)attributes.get("specificationId");

		if (specificationId != null) {
			setSpecificationId(specificationId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Boolean isCategoryMandatory = (Boolean)attributes.get(
			"isCategoryMandatory");

		if (isCategoryMandatory != null) {
			setIsCategoryMandatory(isCategoryMandatory);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public SpecCategoryMap cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category ID of this spec category map.
	 *
	 * @return the category ID of this spec category map
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this spec category map.
	 *
	 * @return the company ID of this spec category map
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this spec category map.
	 *
	 * @return the create date of this spec category map
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this spec category map.
	 *
	 * @return the created by of this spec category map
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the ip address of this spec category map.
	 *
	 * @return the ip address of this spec category map
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the is category mandatory of this spec category map.
	 *
	 * @return the is category mandatory of this spec category map
	 */
	@Override
	public boolean getIsCategoryMandatory() {
		return model.getIsCategoryMandatory();
	}

	/**
	 * Returns the modified by of this spec category map.
	 *
	 * @return the modified by of this spec category map
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this spec category map.
	 *
	 * @return the modified date of this spec category map
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this spec category map.
	 *
	 * @return the primary key of this spec category map
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the spec category map ID of this spec category map.
	 *
	 * @return the spec category map ID of this spec category map
	 */
	@Override
	public long getSpecCategoryMapId() {
		return model.getSpecCategoryMapId();
	}

	/**
	 * Returns the specification ID of this spec category map.
	 *
	 * @return the specification ID of this spec category map
	 */
	@Override
	public long getSpecificationId() {
		return model.getSpecificationId();
	}

	/**
	 * Returns the uuid of this spec category map.
	 *
	 * @return the uuid of this spec category map
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this spec category map is is category mandatory.
	 *
	 * @return <code>true</code> if this spec category map is is category mandatory; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsCategoryMandatory() {
		return model.isIsCategoryMandatory();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category ID of this spec category map.
	 *
	 * @param categoryId the category ID of this spec category map
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this spec category map.
	 *
	 * @param companyId the company ID of this spec category map
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this spec category map.
	 *
	 * @param createDate the create date of this spec category map
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this spec category map.
	 *
	 * @param createdBy the created by of this spec category map
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the ip address of this spec category map.
	 *
	 * @param ipAddress the ip address of this spec category map
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets whether this spec category map is is category mandatory.
	 *
	 * @param isCategoryMandatory the is category mandatory of this spec category map
	 */
	@Override
	public void setIsCategoryMandatory(boolean isCategoryMandatory) {
		model.setIsCategoryMandatory(isCategoryMandatory);
	}

	/**
	 * Sets the modified by of this spec category map.
	 *
	 * @param modifiedBy the modified by of this spec category map
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this spec category map.
	 *
	 * @param modifiedDate the modified date of this spec category map
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this spec category map.
	 *
	 * @param primaryKey the primary key of this spec category map
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the spec category map ID of this spec category map.
	 *
	 * @param specCategoryMapId the spec category map ID of this spec category map
	 */
	@Override
	public void setSpecCategoryMapId(long specCategoryMapId) {
		model.setSpecCategoryMapId(specCategoryMapId);
	}

	/**
	 * Sets the specification ID of this spec category map.
	 *
	 * @param specificationId the specification ID of this spec category map
	 */
	@Override
	public void setSpecificationId(long specificationId) {
		model.setSpecificationId(specificationId);
	}

	/**
	 * Sets the uuid of this spec category map.
	 *
	 * @param uuid the uuid of this spec category map
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SpecCategoryMapWrapper wrap(SpecCategoryMap specCategoryMap) {
		return new SpecCategoryMapWrapper(specCategoryMap);
	}

}