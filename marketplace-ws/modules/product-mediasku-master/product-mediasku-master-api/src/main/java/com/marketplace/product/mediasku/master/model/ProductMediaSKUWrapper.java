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

package com.marketplace.product.mediasku.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductMediaSKU}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKU
 * @generated
 */
public class ProductMediaSKUWrapper
	extends BaseModelWrapper<ProductMediaSKU>
	implements ModelWrapper<ProductMediaSKU>, ProductMediaSKU {

	public ProductMediaSKUWrapper(ProductMediaSKU productMediaSKU) {
		super(productMediaSKU);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ProductMediaSKUId", getProductMediaSKUId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("productSKUId", getProductSKUId());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ProductMediaSKUId = (Long)attributes.get("ProductMediaSKUId");

		if (ProductMediaSKUId != null) {
			setProductMediaSKUId(ProductMediaSKUId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
		}

		Long productSKUId = (Long)attributes.get("productSKUId");

		if (productSKUId != null) {
			setProductSKUId(productSKUId);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@Override
	public ProductMediaSKU cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product media sku.
	 *
	 * @return the company ID of this product media sku
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product media sku.
	 *
	 * @return the create date of this product media sku
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product media sku.
	 *
	 * @return the created by of this product media sku
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this product media sku.
	 *
	 * @return the draft product ID of this product media sku
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the file entry ID of this product media sku.
	 *
	 * @return the file entry ID of this product media sku
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the group ID of this product media sku.
	 *
	 * @return the group ID of this product media sku
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image url of this product media sku.
	 *
	 * @return the image url of this product media sku
	 */
	@Override
	public String getImageUrl() {
		return model.getImageUrl();
	}

	/**
	 * Returns the ip address of this product media sku.
	 *
	 * @return the ip address of this product media sku
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this product media sku.
	 *
	 * @return the modified by of this product media sku
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product media sku.
	 *
	 * @return the modified date of this product media sku
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product media sku.
	 *
	 * @return the primary key of this product media sku
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product media sku ID of this product media sku.
	 *
	 * @return the product media sku ID of this product media sku
	 */
	@Override
	public long getProductMediaSKUId() {
		return model.getProductMediaSKUId();
	}

	/**
	 * Returns the product sku ID of this product media sku.
	 *
	 * @return the product sku ID of this product media sku
	 */
	@Override
	public long getProductSKUId() {
		return model.getProductSKUId();
	}

	/**
	 * Returns the user ID of this product media sku.
	 *
	 * @return the user ID of this product media sku
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product media sku.
	 *
	 * @return the user name of this product media sku
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product media sku.
	 *
	 * @return the user uuid of this product media sku
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product media sku.
	 *
	 * @return the uuid of this product media sku
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
	 * Sets the company ID of this product media sku.
	 *
	 * @param companyId the company ID of this product media sku
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product media sku.
	 *
	 * @param createDate the create date of this product media sku
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product media sku.
	 *
	 * @param createdBy the created by of this product media sku
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product media sku.
	 *
	 * @param draftProductId the draft product ID of this product media sku
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the file entry ID of this product media sku.
	 *
	 * @param fileEntryId the file entry ID of this product media sku
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the group ID of this product media sku.
	 *
	 * @param groupId the group ID of this product media sku
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image url of this product media sku.
	 *
	 * @param imageUrl the image url of this product media sku
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		model.setImageUrl(imageUrl);
	}

	/**
	 * Sets the ip address of this product media sku.
	 *
	 * @param ipAddress the ip address of this product media sku
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this product media sku.
	 *
	 * @param modifiedBy the modified by of this product media sku
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product media sku.
	 *
	 * @param modifiedDate the modified date of this product media sku
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product media sku.
	 *
	 * @param primaryKey the primary key of this product media sku
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product media sku ID of this product media sku.
	 *
	 * @param ProductMediaSKUId the product media sku ID of this product media sku
	 */
	@Override
	public void setProductMediaSKUId(long ProductMediaSKUId) {
		model.setProductMediaSKUId(ProductMediaSKUId);
	}

	/**
	 * Sets the product sku ID of this product media sku.
	 *
	 * @param productSKUId the product sku ID of this product media sku
	 */
	@Override
	public void setProductSKUId(long productSKUId) {
		model.setProductSKUId(productSKUId);
	}

	/**
	 * Sets the user ID of this product media sku.
	 *
	 * @param userId the user ID of this product media sku
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product media sku.
	 *
	 * @param userName the user name of this product media sku
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product media sku.
	 *
	 * @param userUuid the user uuid of this product media sku
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product media sku.
	 *
	 * @param uuid the uuid of this product media sku
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
	protected ProductMediaSKUWrapper wrap(ProductMediaSKU productMediaSKU) {
		return new ProductMediaSKUWrapper(productMediaSKU);
	}

}