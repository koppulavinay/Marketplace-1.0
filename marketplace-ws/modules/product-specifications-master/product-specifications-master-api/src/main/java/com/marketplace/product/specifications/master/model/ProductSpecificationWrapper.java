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

package com.marketplace.product.specifications.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductSpecification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecification
 * @generated
 */
public class ProductSpecificationWrapper
	extends BaseModelWrapper<ProductSpecification>
	implements ModelWrapper<ProductSpecification>, ProductSpecification {

	public ProductSpecificationWrapper(
		ProductSpecification productSpecification) {

		super(productSpecification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productSpecificationId", getProductSpecificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("specificationId", getSpecificationId());
		attributes.put("specificationLabel", getSpecificationLabel());
		attributes.put("specificationFieldType", getSpecificationFieldType());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("isMandatory", isIsMandatory());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productSpecificationId = (Long)attributes.get(
			"productSpecificationId");

		if (productSpecificationId != null) {
			setProductSpecificationId(productSpecificationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long specificationId = (Long)attributes.get("specificationId");

		if (specificationId != null) {
			setSpecificationId(specificationId);
		}

		String specificationLabel = (String)attributes.get(
			"specificationLabel");

		if (specificationLabel != null) {
			setSpecificationLabel(specificationLabel);
		}

		String specificationFieldType = (String)attributes.get(
			"specificationFieldType");

		if (specificationFieldType != null) {
			setSpecificationFieldType(specificationFieldType);
		}

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
		}

		Boolean isMandatory = (Boolean)attributes.get("isMandatory");

		if (isMandatory != null) {
			setIsMandatory(isMandatory);
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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public ProductSpecification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product specification.
	 *
	 * @return the company ID of this product specification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product specification.
	 *
	 * @return the create date of this product specification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product specification.
	 *
	 * @return the created by of this product specification
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this product specification.
	 *
	 * @return the draft product ID of this product specification
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product specification.
	 *
	 * @return the group ID of this product specification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product specification.
	 *
	 * @return the ip address of this product specification
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the is mandatory of this product specification.
	 *
	 * @return the is mandatory of this product specification
	 */
	@Override
	public boolean getIsMandatory() {
		return model.getIsMandatory();
	}

	/**
	 * Returns the modified by of this product specification.
	 *
	 * @return the modified by of this product specification
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product specification.
	 *
	 * @return the modified date of this product specification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product specification.
	 *
	 * @return the primary key of this product specification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product specification ID of this product specification.
	 *
	 * @return the product specification ID of this product specification
	 */
	@Override
	public long getProductSpecificationId() {
		return model.getProductSpecificationId();
	}

	/**
	 * Returns the specification field type of this product specification.
	 *
	 * @return the specification field type of this product specification
	 */
	@Override
	public String getSpecificationFieldType() {
		return model.getSpecificationFieldType();
	}

	/**
	 * Returns the specification ID of this product specification.
	 *
	 * @return the specification ID of this product specification
	 */
	@Override
	public long getSpecificationId() {
		return model.getSpecificationId();
	}

	/**
	 * Returns the specification label of this product specification.
	 *
	 * @return the specification label of this product specification
	 */
	@Override
	public String getSpecificationLabel() {
		return model.getSpecificationLabel();
	}

	/**
	 * Returns the user ID of this product specification.
	 *
	 * @return the user ID of this product specification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product specification.
	 *
	 * @return the user name of this product specification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product specification.
	 *
	 * @return the user uuid of this product specification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product specification.
	 *
	 * @return the uuid of this product specification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this product specification is is mandatory.
	 *
	 * @return <code>true</code> if this product specification is is mandatory; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMandatory() {
		return model.isIsMandatory();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this product specification.
	 *
	 * @param companyId the company ID of this product specification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product specification.
	 *
	 * @param createDate the create date of this product specification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product specification.
	 *
	 * @param createdBy the created by of this product specification
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product specification.
	 *
	 * @param draftProductId the draft product ID of this product specification
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product specification.
	 *
	 * @param groupId the group ID of this product specification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product specification.
	 *
	 * @param ipAddress the ip address of this product specification
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets whether this product specification is is mandatory.
	 *
	 * @param isMandatory the is mandatory of this product specification
	 */
	@Override
	public void setIsMandatory(boolean isMandatory) {
		model.setIsMandatory(isMandatory);
	}

	/**
	 * Sets the modified by of this product specification.
	 *
	 * @param modifiedBy the modified by of this product specification
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product specification.
	 *
	 * @param modifiedDate the modified date of this product specification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product specification.
	 *
	 * @param primaryKey the primary key of this product specification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product specification ID of this product specification.
	 *
	 * @param productSpecificationId the product specification ID of this product specification
	 */
	@Override
	public void setProductSpecificationId(long productSpecificationId) {
		model.setProductSpecificationId(productSpecificationId);
	}

	/**
	 * Sets the specification field type of this product specification.
	 *
	 * @param specificationFieldType the specification field type of this product specification
	 */
	@Override
	public void setSpecificationFieldType(String specificationFieldType) {
		model.setSpecificationFieldType(specificationFieldType);
	}

	/**
	 * Sets the specification ID of this product specification.
	 *
	 * @param specificationId the specification ID of this product specification
	 */
	@Override
	public void setSpecificationId(long specificationId) {
		model.setSpecificationId(specificationId);
	}

	/**
	 * Sets the specification label of this product specification.
	 *
	 * @param specificationLabel the specification label of this product specification
	 */
	@Override
	public void setSpecificationLabel(String specificationLabel) {
		model.setSpecificationLabel(specificationLabel);
	}

	/**
	 * Sets the user ID of this product specification.
	 *
	 * @param userId the user ID of this product specification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product specification.
	 *
	 * @param userName the user name of this product specification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product specification.
	 *
	 * @param userUuid the user uuid of this product specification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product specification.
	 *
	 * @param uuid the uuid of this product specification
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
	protected ProductSpecificationWrapper wrap(
		ProductSpecification productSpecification) {

		return new ProductSpecificationWrapper(productSpecification);
	}

}