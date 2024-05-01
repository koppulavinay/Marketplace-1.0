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

package com.marketplace.variant.values.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VariantValue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VariantValue
 * @generated
 */
public class VariantValueWrapper
	extends BaseModelWrapper<VariantValue>
	implements ModelWrapper<VariantValue>, VariantValue {

	public VariantValueWrapper(VariantValue variantValue) {
		super(variantValue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("variantValueId", getVariantValueId());
		attributes.put("groupId", getGroupId());
		attributes.put("productVariantId", getProductVariantId());
		attributes.put("variantVal", getVariantVal());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
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

		Long variantValueId = (Long)attributes.get("variantValueId");

		if (variantValueId != null) {
			setVariantValueId(variantValueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long productVariantId = (Long)attributes.get("productVariantId");

		if (productVariantId != null) {
			setProductVariantId(productVariantId);
		}

		String variantVal = (String)attributes.get("variantVal");

		if (variantVal != null) {
			setVariantVal(variantVal);
		}

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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
	public VariantValue cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this variant value.
	 *
	 * @return the company ID of this variant value
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this variant value.
	 *
	 * @return the create date of this variant value
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this variant value.
	 *
	 * @return the created by of this variant value
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this variant value.
	 *
	 * @return the draft product ID of this variant value
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this variant value.
	 *
	 * @return the group ID of this variant value
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this variant value.
	 *
	 * @return the ip address of this variant value
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this variant value.
	 *
	 * @return the modified by of this variant value
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this variant value.
	 *
	 * @return the modified date of this variant value
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this variant value.
	 *
	 * @return the primary key of this variant value
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product variant ID of this variant value.
	 *
	 * @return the product variant ID of this variant value
	 */
	@Override
	public long getProductVariantId() {
		return model.getProductVariantId();
	}

	/**
	 * Returns the user ID of this variant value.
	 *
	 * @return the user ID of this variant value
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this variant value.
	 *
	 * @return the user name of this variant value
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this variant value.
	 *
	 * @return the user uuid of this variant value
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this variant value.
	 *
	 * @return the uuid of this variant value
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the variant val of this variant value.
	 *
	 * @return the variant val of this variant value
	 */
	@Override
	public String getVariantVal() {
		return model.getVariantVal();
	}

	/**
	 * Returns the variant value ID of this variant value.
	 *
	 * @return the variant value ID of this variant value
	 */
	@Override
	public long getVariantValueId() {
		return model.getVariantValueId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this variant value.
	 *
	 * @param companyId the company ID of this variant value
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this variant value.
	 *
	 * @param createDate the create date of this variant value
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this variant value.
	 *
	 * @param createdBy the created by of this variant value
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this variant value.
	 *
	 * @param draftProductId the draft product ID of this variant value
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this variant value.
	 *
	 * @param groupId the group ID of this variant value
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this variant value.
	 *
	 * @param ipAddress the ip address of this variant value
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this variant value.
	 *
	 * @param modifiedBy the modified by of this variant value
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this variant value.
	 *
	 * @param modifiedDate the modified date of this variant value
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this variant value.
	 *
	 * @param primaryKey the primary key of this variant value
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product variant ID of this variant value.
	 *
	 * @param productVariantId the product variant ID of this variant value
	 */
	@Override
	public void setProductVariantId(long productVariantId) {
		model.setProductVariantId(productVariantId);
	}

	/**
	 * Sets the user ID of this variant value.
	 *
	 * @param userId the user ID of this variant value
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this variant value.
	 *
	 * @param userName the user name of this variant value
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this variant value.
	 *
	 * @param userUuid the user uuid of this variant value
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this variant value.
	 *
	 * @param uuid the uuid of this variant value
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the variant val of this variant value.
	 *
	 * @param variantVal the variant val of this variant value
	 */
	@Override
	public void setVariantVal(String variantVal) {
		model.setVariantVal(variantVal);
	}

	/**
	 * Sets the variant value ID of this variant value.
	 *
	 * @param variantValueId the variant value ID of this variant value
	 */
	@Override
	public void setVariantValueId(long variantValueId) {
		model.setVariantValueId(variantValueId);
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
	protected VariantValueWrapper wrap(VariantValue variantValue) {
		return new VariantValueWrapper(variantValue);
	}

}