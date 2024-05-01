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

package com.marketplace.product.pkg.content.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductPackageContent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContent
 * @generated
 */
public class ProductPackageContentWrapper
	extends BaseModelWrapper<ProductPackageContent>
	implements ModelWrapper<ProductPackageContent>, ProductPackageContent {

	public ProductPackageContentWrapper(
		ProductPackageContent productPackageContent) {

		super(productPackageContent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("packageContentId", getPackageContentId());
		attributes.put("groupId", getGroupId());
		attributes.put("itemName", getItemName());
		attributes.put("itemQuantity", getItemQuantity());
		attributes.put("draftProductId", getDraftProductId());
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

		Long packageContentId = (Long)attributes.get("packageContentId");

		if (packageContentId != null) {
			setPackageContentId(packageContentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String itemName = (String)attributes.get("itemName");

		if (itemName != null) {
			setItemName(itemName);
		}

		String itemQuantity = (String)attributes.get("itemQuantity");

		if (itemQuantity != null) {
			setItemQuantity(itemQuantity);
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
	public ProductPackageContent cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product package content.
	 *
	 * @return the company ID of this product package content
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product package content.
	 *
	 * @return the create date of this product package content
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product package content.
	 *
	 * @return the created by of this product package content
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this product package content.
	 *
	 * @return the draft product ID of this product package content
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product package content.
	 *
	 * @return the group ID of this product package content
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product package content.
	 *
	 * @return the ip address of this product package content
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the item name of this product package content.
	 *
	 * @return the item name of this product package content
	 */
	@Override
	public String getItemName() {
		return model.getItemName();
	}

	/**
	 * Returns the item quantity of this product package content.
	 *
	 * @return the item quantity of this product package content
	 */
	@Override
	public String getItemQuantity() {
		return model.getItemQuantity();
	}

	/**
	 * Returns the modified by of this product package content.
	 *
	 * @return the modified by of this product package content
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product package content.
	 *
	 * @return the modified date of this product package content
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the package content ID of this product package content.
	 *
	 * @return the package content ID of this product package content
	 */
	@Override
	public long getPackageContentId() {
		return model.getPackageContentId();
	}

	/**
	 * Returns the primary key of this product package content.
	 *
	 * @return the primary key of this product package content
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this product package content.
	 *
	 * @return the user ID of this product package content
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product package content.
	 *
	 * @return the user name of this product package content
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product package content.
	 *
	 * @return the user uuid of this product package content
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product package content.
	 *
	 * @return the uuid of this product package content
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
	 * Sets the company ID of this product package content.
	 *
	 * @param companyId the company ID of this product package content
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product package content.
	 *
	 * @param createDate the create date of this product package content
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product package content.
	 *
	 * @param createdBy the created by of this product package content
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product package content.
	 *
	 * @param draftProductId the draft product ID of this product package content
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product package content.
	 *
	 * @param groupId the group ID of this product package content
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product package content.
	 *
	 * @param ipAddress the ip address of this product package content
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the item name of this product package content.
	 *
	 * @param itemName the item name of this product package content
	 */
	@Override
	public void setItemName(String itemName) {
		model.setItemName(itemName);
	}

	/**
	 * Sets the item quantity of this product package content.
	 *
	 * @param itemQuantity the item quantity of this product package content
	 */
	@Override
	public void setItemQuantity(String itemQuantity) {
		model.setItemQuantity(itemQuantity);
	}

	/**
	 * Sets the modified by of this product package content.
	 *
	 * @param modifiedBy the modified by of this product package content
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product package content.
	 *
	 * @param modifiedDate the modified date of this product package content
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the package content ID of this product package content.
	 *
	 * @param packageContentId the package content ID of this product package content
	 */
	@Override
	public void setPackageContentId(long packageContentId) {
		model.setPackageContentId(packageContentId);
	}

	/**
	 * Sets the primary key of this product package content.
	 *
	 * @param primaryKey the primary key of this product package content
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this product package content.
	 *
	 * @param userId the user ID of this product package content
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product package content.
	 *
	 * @param userName the user name of this product package content
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product package content.
	 *
	 * @param userUuid the user uuid of this product package content
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product package content.
	 *
	 * @param uuid the uuid of this product package content
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
	protected ProductPackageContentWrapper wrap(
		ProductPackageContent productPackageContent) {

		return new ProductPackageContentWrapper(productPackageContent);
	}

}