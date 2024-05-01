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

package com.marketplace.specification.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Specification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Specification
 * @generated
 */
public class SpecificationWrapper
	extends BaseModelWrapper<Specification>
	implements ModelWrapper<Specification>, Specification {

	public SpecificationWrapper(Specification specification) {
		super(specification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("specificationId", getSpecificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("specificationLabel", getSpecificationLabel());
		attributes.put(
			"specificationDescription", getSpecificationDescription());
		attributes.put("specificationFieldType", getSpecificationFieldType());
		attributes.put(
			"specificationFieldDataType", getSpecificationFieldDataType());
		attributes.put("specificationPriority", getSpecificationPriority());
		attributes.put("isVariant", isIsVariant());
		attributes.put("specificationGroupId", getSpecificationGroupId());
		attributes.put("cpSpecificationId", getCpSpecificationId());
		attributes.put("specificationStatus", getSpecificationStatus());
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

		Long specificationId = (Long)attributes.get("specificationId");

		if (specificationId != null) {
			setSpecificationId(specificationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String specificationLabel = (String)attributes.get(
			"specificationLabel");

		if (specificationLabel != null) {
			setSpecificationLabel(specificationLabel);
		}

		String specificationDescription = (String)attributes.get(
			"specificationDescription");

		if (specificationDescription != null) {
			setSpecificationDescription(specificationDescription);
		}

		Long specificationFieldType = (Long)attributes.get(
			"specificationFieldType");

		if (specificationFieldType != null) {
			setSpecificationFieldType(specificationFieldType);
		}

		Long specificationFieldDataType = (Long)attributes.get(
			"specificationFieldDataType");

		if (specificationFieldDataType != null) {
			setSpecificationFieldDataType(specificationFieldDataType);
		}

		Long specificationPriority = (Long)attributes.get(
			"specificationPriority");

		if (specificationPriority != null) {
			setSpecificationPriority(specificationPriority);
		}

		Boolean isVariant = (Boolean)attributes.get("isVariant");

		if (isVariant != null) {
			setIsVariant(isVariant);
		}

		Long specificationGroupId = (Long)attributes.get(
			"specificationGroupId");

		if (specificationGroupId != null) {
			setSpecificationGroupId(specificationGroupId);
		}

		Long cpSpecificationId = (Long)attributes.get("cpSpecificationId");

		if (cpSpecificationId != null) {
			setCpSpecificationId(cpSpecificationId);
		}

		String specificationStatus = (String)attributes.get(
			"specificationStatus");

		if (specificationStatus != null) {
			setSpecificationStatus(specificationStatus);
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
	public Specification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this specification.
	 *
	 * @return the company ID of this specification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cp specification ID of this specification.
	 *
	 * @return the cp specification ID of this specification
	 */
	@Override
	public long getCpSpecificationId() {
		return model.getCpSpecificationId();
	}

	/**
	 * Returns the create date of this specification.
	 *
	 * @return the create date of this specification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this specification.
	 *
	 * @return the created by of this specification
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this specification.
	 *
	 * @return the group ID of this specification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this specification.
	 *
	 * @return the ip address of this specification
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the is variant of this specification.
	 *
	 * @return the is variant of this specification
	 */
	@Override
	public boolean getIsVariant() {
		return model.getIsVariant();
	}

	/**
	 * Returns the modified by of this specification.
	 *
	 * @return the modified by of this specification
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this specification.
	 *
	 * @return the modified date of this specification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this specification.
	 *
	 * @return the primary key of this specification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specification description of this specification.
	 *
	 * @return the specification description of this specification
	 */
	@Override
	public String getSpecificationDescription() {
		return model.getSpecificationDescription();
	}

	/**
	 * Returns the specification field data type of this specification.
	 *
	 * @return the specification field data type of this specification
	 */
	@Override
	public long getSpecificationFieldDataType() {
		return model.getSpecificationFieldDataType();
	}

	/**
	 * Returns the specification field type of this specification.
	 *
	 * @return the specification field type of this specification
	 */
	@Override
	public long getSpecificationFieldType() {
		return model.getSpecificationFieldType();
	}

	/**
	 * Returns the specification group ID of this specification.
	 *
	 * @return the specification group ID of this specification
	 */
	@Override
	public long getSpecificationGroupId() {
		return model.getSpecificationGroupId();
	}

	/**
	 * Returns the specification ID of this specification.
	 *
	 * @return the specification ID of this specification
	 */
	@Override
	public long getSpecificationId() {
		return model.getSpecificationId();
	}

	/**
	 * Returns the specification label of this specification.
	 *
	 * @return the specification label of this specification
	 */
	@Override
	public String getSpecificationLabel() {
		return model.getSpecificationLabel();
	}

	/**
	 * Returns the specification priority of this specification.
	 *
	 * @return the specification priority of this specification
	 */
	@Override
	public long getSpecificationPriority() {
		return model.getSpecificationPriority();
	}

	/**
	 * Returns the specification status of this specification.
	 *
	 * @return the specification status of this specification
	 */
	@Override
	public String getSpecificationStatus() {
		return model.getSpecificationStatus();
	}

	/**
	 * Returns the user ID of this specification.
	 *
	 * @return the user ID of this specification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this specification.
	 *
	 * @return the user name of this specification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this specification.
	 *
	 * @return the user uuid of this specification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this specification.
	 *
	 * @return the uuid of this specification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this specification is is variant.
	 *
	 * @return <code>true</code> if this specification is is variant; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsVariant() {
		return model.isIsVariant();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this specification.
	 *
	 * @param companyId the company ID of this specification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cp specification ID of this specification.
	 *
	 * @param cpSpecificationId the cp specification ID of this specification
	 */
	@Override
	public void setCpSpecificationId(long cpSpecificationId) {
		model.setCpSpecificationId(cpSpecificationId);
	}

	/**
	 * Sets the create date of this specification.
	 *
	 * @param createDate the create date of this specification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this specification.
	 *
	 * @param createdBy the created by of this specification
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this specification.
	 *
	 * @param groupId the group ID of this specification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this specification.
	 *
	 * @param ipAddress the ip address of this specification
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets whether this specification is is variant.
	 *
	 * @param isVariant the is variant of this specification
	 */
	@Override
	public void setIsVariant(boolean isVariant) {
		model.setIsVariant(isVariant);
	}

	/**
	 * Sets the modified by of this specification.
	 *
	 * @param modifiedBy the modified by of this specification
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this specification.
	 *
	 * @param modifiedDate the modified date of this specification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this specification.
	 *
	 * @param primaryKey the primary key of this specification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specification description of this specification.
	 *
	 * @param specificationDescription the specification description of this specification
	 */
	@Override
	public void setSpecificationDescription(String specificationDescription) {
		model.setSpecificationDescription(specificationDescription);
	}

	/**
	 * Sets the specification field data type of this specification.
	 *
	 * @param specificationFieldDataType the specification field data type of this specification
	 */
	@Override
	public void setSpecificationFieldDataType(long specificationFieldDataType) {
		model.setSpecificationFieldDataType(specificationFieldDataType);
	}

	/**
	 * Sets the specification field type of this specification.
	 *
	 * @param specificationFieldType the specification field type of this specification
	 */
	@Override
	public void setSpecificationFieldType(long specificationFieldType) {
		model.setSpecificationFieldType(specificationFieldType);
	}

	/**
	 * Sets the specification group ID of this specification.
	 *
	 * @param specificationGroupId the specification group ID of this specification
	 */
	@Override
	public void setSpecificationGroupId(long specificationGroupId) {
		model.setSpecificationGroupId(specificationGroupId);
	}

	/**
	 * Sets the specification ID of this specification.
	 *
	 * @param specificationId the specification ID of this specification
	 */
	@Override
	public void setSpecificationId(long specificationId) {
		model.setSpecificationId(specificationId);
	}

	/**
	 * Sets the specification label of this specification.
	 *
	 * @param specificationLabel the specification label of this specification
	 */
	@Override
	public void setSpecificationLabel(String specificationLabel) {
		model.setSpecificationLabel(specificationLabel);
	}

	/**
	 * Sets the specification priority of this specification.
	 *
	 * @param specificationPriority the specification priority of this specification
	 */
	@Override
	public void setSpecificationPriority(long specificationPriority) {
		model.setSpecificationPriority(specificationPriority);
	}

	/**
	 * Sets the specification status of this specification.
	 *
	 * @param specificationStatus the specification status of this specification
	 */
	@Override
	public void setSpecificationStatus(String specificationStatus) {
		model.setSpecificationStatus(specificationStatus);
	}

	/**
	 * Sets the user ID of this specification.
	 *
	 * @param userId the user ID of this specification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this specification.
	 *
	 * @param userName the user name of this specification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this specification.
	 *
	 * @param userUuid the user uuid of this specification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this specification.
	 *
	 * @param uuid the uuid of this specification
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
	protected SpecificationWrapper wrap(Specification specification) {
		return new SpecificationWrapper(specification);
	}

}