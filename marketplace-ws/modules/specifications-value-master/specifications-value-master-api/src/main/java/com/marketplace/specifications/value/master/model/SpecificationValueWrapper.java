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

package com.marketplace.specifications.value.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SpecificationValue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValue
 * @generated
 */
public class SpecificationValueWrapper
	extends BaseModelWrapper<SpecificationValue>
	implements ModelWrapper<SpecificationValue>, SpecificationValue {

	public SpecificationValueWrapper(SpecificationValue specificationValue) {
		super(specificationValue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specificationValueId", getSpecificationValueId());
		attributes.put("groupId", getGroupId());
		attributes.put("specificationId", getSpecificationId());
		attributes.put("specificationValueLabel", getSpecificationValueLabel());
		attributes.put("specificationUOM", getSpecificationUOM());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long specificationValueId = (Long)attributes.get(
			"specificationValueId");

		if (specificationValueId != null) {
			setSpecificationValueId(specificationValueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long specificationId = (Long)attributes.get("specificationId");

		if (specificationId != null) {
			setSpecificationId(specificationId);
		}

		String specificationValueLabel = (String)attributes.get(
			"specificationValueLabel");

		if (specificationValueLabel != null) {
			setSpecificationValueLabel(specificationValueLabel);
		}

		String specificationUOM = (String)attributes.get("specificationUOM");

		if (specificationUOM != null) {
			setSpecificationUOM(specificationUOM);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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
	}

	@Override
	public SpecificationValue cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this specification value.
	 *
	 * @return the company ID of this specification value
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this specification value.
	 *
	 * @return the create date of this specification value
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this specification value.
	 *
	 * @return the created by of this specification value
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this specification value.
	 *
	 * @return the group ID of this specification value
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this specification value.
	 *
	 * @return the ip address of this specification value
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this specification value.
	 *
	 * @return the modified by of this specification value
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this specification value.
	 *
	 * @return the modified date of this specification value
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this specification value.
	 *
	 * @return the primary key of this specification value
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specification ID of this specification value.
	 *
	 * @return the specification ID of this specification value
	 */
	@Override
	public long getSpecificationId() {
		return model.getSpecificationId();
	}

	/**
	 * Returns the specification uom of this specification value.
	 *
	 * @return the specification uom of this specification value
	 */
	@Override
	public String getSpecificationUOM() {
		return model.getSpecificationUOM();
	}

	/**
	 * Returns the specification value ID of this specification value.
	 *
	 * @return the specification value ID of this specification value
	 */
	@Override
	public long getSpecificationValueId() {
		return model.getSpecificationValueId();
	}

	/**
	 * Returns the specification value label of this specification value.
	 *
	 * @return the specification value label of this specification value
	 */
	@Override
	public String getSpecificationValueLabel() {
		return model.getSpecificationValueLabel();
	}

	/**
	 * Returns the user ID of this specification value.
	 *
	 * @return the user ID of this specification value
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this specification value.
	 *
	 * @return the user name of this specification value
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this specification value.
	 *
	 * @return the user uuid of this specification value
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this specification value.
	 *
	 * @return the uuid of this specification value
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
	 * Sets the company ID of this specification value.
	 *
	 * @param companyId the company ID of this specification value
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this specification value.
	 *
	 * @param createDate the create date of this specification value
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this specification value.
	 *
	 * @param createdBy the created by of this specification value
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this specification value.
	 *
	 * @param groupId the group ID of this specification value
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this specification value.
	 *
	 * @param ipAddress the ip address of this specification value
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this specification value.
	 *
	 * @param modifiedBy the modified by of this specification value
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this specification value.
	 *
	 * @param modifiedDate the modified date of this specification value
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this specification value.
	 *
	 * @param primaryKey the primary key of this specification value
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specification ID of this specification value.
	 *
	 * @param specificationId the specification ID of this specification value
	 */
	@Override
	public void setSpecificationId(long specificationId) {
		model.setSpecificationId(specificationId);
	}

	/**
	 * Sets the specification uom of this specification value.
	 *
	 * @param specificationUOM the specification uom of this specification value
	 */
	@Override
	public void setSpecificationUOM(String specificationUOM) {
		model.setSpecificationUOM(specificationUOM);
	}

	/**
	 * Sets the specification value ID of this specification value.
	 *
	 * @param specificationValueId the specification value ID of this specification value
	 */
	@Override
	public void setSpecificationValueId(long specificationValueId) {
		model.setSpecificationValueId(specificationValueId);
	}

	/**
	 * Sets the specification value label of this specification value.
	 *
	 * @param specificationValueLabel the specification value label of this specification value
	 */
	@Override
	public void setSpecificationValueLabel(String specificationValueLabel) {
		model.setSpecificationValueLabel(specificationValueLabel);
	}

	/**
	 * Sets the user ID of this specification value.
	 *
	 * @param userId the user ID of this specification value
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this specification value.
	 *
	 * @param userName the user name of this specification value
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this specification value.
	 *
	 * @param userUuid the user uuid of this specification value
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this specification value.
	 *
	 * @param uuid the uuid of this specification value
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
	protected SpecificationValueWrapper wrap(
		SpecificationValue specificationValue) {

		return new SpecificationValueWrapper(specificationValue);
	}

}