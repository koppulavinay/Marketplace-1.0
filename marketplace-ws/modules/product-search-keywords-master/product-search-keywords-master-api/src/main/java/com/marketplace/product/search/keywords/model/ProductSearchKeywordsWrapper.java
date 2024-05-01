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

package com.marketplace.product.search.keywords.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductSearchKeywords}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywords
 * @generated
 */
public class ProductSearchKeywordsWrapper
	extends BaseModelWrapper<ProductSearchKeywords>
	implements ModelWrapper<ProductSearchKeywords>, ProductSearchKeywords {

	public ProductSearchKeywordsWrapper(
		ProductSearchKeywords productSearchKeywords) {

		super(productSearchKeywords);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("searchKeywordId", getSearchKeywordId());
		attributes.put("groupId", getGroupId());
		attributes.put("searchKeyword", getSearchKeyword());
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

		Long searchKeywordId = (Long)attributes.get("searchKeywordId");

		if (searchKeywordId != null) {
			setSearchKeywordId(searchKeywordId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String searchKeyword = (String)attributes.get("searchKeyword");

		if (searchKeyword != null) {
			setSearchKeyword(searchKeyword);
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
	public ProductSearchKeywords cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product search keywords.
	 *
	 * @return the company ID of this product search keywords
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product search keywords.
	 *
	 * @return the create date of this product search keywords
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product search keywords.
	 *
	 * @return the created by of this product search keywords
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the draft product ID of this product search keywords.
	 *
	 * @return the draft product ID of this product search keywords
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product search keywords.
	 *
	 * @return the group ID of this product search keywords
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product search keywords.
	 *
	 * @return the ip address of this product search keywords
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this product search keywords.
	 *
	 * @return the modified by of this product search keywords
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product search keywords.
	 *
	 * @return the modified date of this product search keywords
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product search keywords.
	 *
	 * @return the primary key of this product search keywords
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the search keyword of this product search keywords.
	 *
	 * @return the search keyword of this product search keywords
	 */
	@Override
	public String getSearchKeyword() {
		return model.getSearchKeyword();
	}

	/**
	 * Returns the search keyword ID of this product search keywords.
	 *
	 * @return the search keyword ID of this product search keywords
	 */
	@Override
	public long getSearchKeywordId() {
		return model.getSearchKeywordId();
	}

	/**
	 * Returns the user ID of this product search keywords.
	 *
	 * @return the user ID of this product search keywords
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product search keywords.
	 *
	 * @return the user name of this product search keywords
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product search keywords.
	 *
	 * @return the user uuid of this product search keywords
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product search keywords.
	 *
	 * @return the uuid of this product search keywords
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
	 * Sets the company ID of this product search keywords.
	 *
	 * @param companyId the company ID of this product search keywords
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product search keywords.
	 *
	 * @param createDate the create date of this product search keywords
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product search keywords.
	 *
	 * @param createdBy the created by of this product search keywords
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product search keywords.
	 *
	 * @param draftProductId the draft product ID of this product search keywords
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product search keywords.
	 *
	 * @param groupId the group ID of this product search keywords
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product search keywords.
	 *
	 * @param ipAddress the ip address of this product search keywords
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this product search keywords.
	 *
	 * @param modifiedBy the modified by of this product search keywords
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product search keywords.
	 *
	 * @param modifiedDate the modified date of this product search keywords
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product search keywords.
	 *
	 * @param primaryKey the primary key of this product search keywords
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the search keyword of this product search keywords.
	 *
	 * @param searchKeyword the search keyword of this product search keywords
	 */
	@Override
	public void setSearchKeyword(String searchKeyword) {
		model.setSearchKeyword(searchKeyword);
	}

	/**
	 * Sets the search keyword ID of this product search keywords.
	 *
	 * @param searchKeywordId the search keyword ID of this product search keywords
	 */
	@Override
	public void setSearchKeywordId(long searchKeywordId) {
		model.setSearchKeywordId(searchKeywordId);
	}

	/**
	 * Sets the user ID of this product search keywords.
	 *
	 * @param userId the user ID of this product search keywords
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product search keywords.
	 *
	 * @param userName the user name of this product search keywords
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product search keywords.
	 *
	 * @param userUuid the user uuid of this product search keywords
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product search keywords.
	 *
	 * @param uuid the uuid of this product search keywords
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
	protected ProductSearchKeywordsWrapper wrap(
		ProductSearchKeywords productSearchKeywords) {

		return new ProductSearchKeywordsWrapper(productSearchKeywords);
	}

}