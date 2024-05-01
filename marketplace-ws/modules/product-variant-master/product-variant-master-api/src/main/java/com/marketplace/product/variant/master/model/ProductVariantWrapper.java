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

package com.marketplace.product.variant.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductVariant}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariant
 * @generated
 */
public class ProductVariantWrapper
	extends BaseModelWrapper<ProductVariant>
	implements ModelWrapper<ProductVariant>, ProductVariant {

	public ProductVariantWrapper(ProductVariant productVariant) {
		super(productVariant);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productVariantId", getProductVariantId());
		attributes.put("groupId", getGroupId());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("variantName", getVariantName());
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

		Long productVariantId = (Long)attributes.get("productVariantId");

		if (productVariantId != null) {
			setProductVariantId(productVariantId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
		}

		String variantName = (String)attributes.get("variantName");

		if (variantName != null) {
			setVariantName(variantName);
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
	public ProductVariant cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product variant.
	 *
	 * @return the company ID of this product variant
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product variant.
	 *
	 * @return the create date of this product variant
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product variant.
	 *
	 * @return the created by of this product variant
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this product variant.
	 *
	 * @return the draft product ID of this product variant
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product variant.
	 *
	 * @return the group ID of this product variant
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product variant.
	 *
	 * @return the ip address of this product variant
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this product variant.
	 *
	 * @return the modified by of this product variant
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product variant.
	 *
	 * @return the modified date of this product variant
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product variant.
	 *
	 * @return the primary key of this product variant
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product variant ID of this product variant.
	 *
	 * @return the product variant ID of this product variant
	 */
	@Override
	public long getProductVariantId() {
		return model.getProductVariantId();
	}

	/**
	 * Returns the user ID of this product variant.
	 *
	 * @return the user ID of this product variant
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product variant.
	 *
	 * @return the user name of this product variant
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product variant.
	 *
	 * @return the user uuid of this product variant
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product variant.
	 *
	 * @return the uuid of this product variant
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the variant name of this product variant.
	 *
	 * @return the variant name of this product variant
	 */
	@Override
	public String getVariantName() {
		return model.getVariantName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this product variant.
	 *
	 * @param companyId the company ID of this product variant
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product variant.
	 *
	 * @param createDate the create date of this product variant
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product variant.
	 *
	 * @param createdBy the created by of this product variant
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product variant.
	 *
	 * @param draftProductId the draft product ID of this product variant
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product variant.
	 *
	 * @param groupId the group ID of this product variant
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product variant.
	 *
	 * @param ipAddress the ip address of this product variant
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this product variant.
	 *
	 * @param modifiedBy the modified by of this product variant
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product variant.
	 *
	 * @param modifiedDate the modified date of this product variant
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product variant.
	 *
	 * @param primaryKey the primary key of this product variant
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product variant ID of this product variant.
	 *
	 * @param productVariantId the product variant ID of this product variant
	 */
	@Override
	public void setProductVariantId(long productVariantId) {
		model.setProductVariantId(productVariantId);
	}

	/**
	 * Sets the user ID of this product variant.
	 *
	 * @param userId the user ID of this product variant
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product variant.
	 *
	 * @param userName the user name of this product variant
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product variant.
	 *
	 * @param userUuid the user uuid of this product variant
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product variant.
	 *
	 * @param uuid the uuid of this product variant
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the variant name of this product variant.
	 *
	 * @param variantName the variant name of this product variant
	 */
	@Override
	public void setVariantName(String variantName) {
		model.setVariantName(variantName);
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
	protected ProductVariantWrapper wrap(ProductVariant productVariant) {
		return new ProductVariantWrapper(productVariant);
	}

}