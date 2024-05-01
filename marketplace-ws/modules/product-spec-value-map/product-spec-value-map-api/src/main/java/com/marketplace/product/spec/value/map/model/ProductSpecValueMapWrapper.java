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

package com.marketplace.product.spec.value.map.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductSpecValueMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMap
 * @generated
 */
public class ProductSpecValueMapWrapper
	extends BaseModelWrapper<ProductSpecValueMap>
	implements ModelWrapper<ProductSpecValueMap>, ProductSpecValueMap {

	public ProductSpecValueMapWrapper(ProductSpecValueMap productSpecValueMap) {
		super(productSpecValueMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productSpecValueId", getProductSpecValueId());
		attributes.put("groupId", getGroupId());
		attributes.put("productSpecificationId", getProductSpecificationId());
		attributes.put(
			"specificationValueLabelId", getSpecificationValueLabelId());
		attributes.put("specificationValueLabel", getSpecificationValueLabel());
		attributes.put("specificationValueUOM", getSpecificationValueUOM());
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

		Long productSpecValueId = (Long)attributes.get("productSpecValueId");

		if (productSpecValueId != null) {
			setProductSpecValueId(productSpecValueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long productSpecificationId = (Long)attributes.get(
			"productSpecificationId");

		if (productSpecificationId != null) {
			setProductSpecificationId(productSpecificationId);
		}

		Long specificationValueLabelId = (Long)attributes.get(
			"specificationValueLabelId");

		if (specificationValueLabelId != null) {
			setSpecificationValueLabelId(specificationValueLabelId);
		}

		String specificationValueLabel = (String)attributes.get(
			"specificationValueLabel");

		if (specificationValueLabel != null) {
			setSpecificationValueLabel(specificationValueLabel);
		}

		String specificationValueUOM = (String)attributes.get(
			"specificationValueUOM");

		if (specificationValueUOM != null) {
			setSpecificationValueUOM(specificationValueUOM);
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
	public ProductSpecValueMap cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this product spec value map.
	 *
	 * @return the company ID of this product spec value map
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this product spec value map.
	 *
	 * @return the create date of this product spec value map
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product spec value map.
	 *
	 * @return the created by of this product spec value map
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this product spec value map.
	 *
	 * @return the group ID of this product spec value map
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product spec value map.
	 *
	 * @return the ip address of this product spec value map
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified by of this product spec value map.
	 *
	 * @return the modified by of this product spec value map
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product spec value map.
	 *
	 * @return the modified date of this product spec value map
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product spec value map.
	 *
	 * @return the primary key of this product spec value map
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product specification ID of this product spec value map.
	 *
	 * @return the product specification ID of this product spec value map
	 */
	@Override
	public long getProductSpecificationId() {
		return model.getProductSpecificationId();
	}

	/**
	 * Returns the product spec value ID of this product spec value map.
	 *
	 * @return the product spec value ID of this product spec value map
	 */
	@Override
	public long getProductSpecValueId() {
		return model.getProductSpecValueId();
	}

	/**
	 * Returns the specification value label of this product spec value map.
	 *
	 * @return the specification value label of this product spec value map
	 */
	@Override
	public String getSpecificationValueLabel() {
		return model.getSpecificationValueLabel();
	}

	/**
	 * Returns the specification value label ID of this product spec value map.
	 *
	 * @return the specification value label ID of this product spec value map
	 */
	@Override
	public long getSpecificationValueLabelId() {
		return model.getSpecificationValueLabelId();
	}

	/**
	 * Returns the specification value uom of this product spec value map.
	 *
	 * @return the specification value uom of this product spec value map
	 */
	@Override
	public String getSpecificationValueUOM() {
		return model.getSpecificationValueUOM();
	}

	/**
	 * Returns the user ID of this product spec value map.
	 *
	 * @return the user ID of this product spec value map
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product spec value map.
	 *
	 * @return the user name of this product spec value map
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product spec value map.
	 *
	 * @return the user uuid of this product spec value map
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product spec value map.
	 *
	 * @return the uuid of this product spec value map
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
	 * Sets the company ID of this product spec value map.
	 *
	 * @param companyId the company ID of this product spec value map
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this product spec value map.
	 *
	 * @param createDate the create date of this product spec value map
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product spec value map.
	 *
	 * @param createdBy the created by of this product spec value map
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this product spec value map.
	 *
	 * @param groupId the group ID of this product spec value map
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product spec value map.
	 *
	 * @param ipAddress the ip address of this product spec value map
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified by of this product spec value map.
	 *
	 * @param modifiedBy the modified by of this product spec value map
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product spec value map.
	 *
	 * @param modifiedDate the modified date of this product spec value map
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this product spec value map.
	 *
	 * @param primaryKey the primary key of this product spec value map
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product specification ID of this product spec value map.
	 *
	 * @param productSpecificationId the product specification ID of this product spec value map
	 */
	@Override
	public void setProductSpecificationId(long productSpecificationId) {
		model.setProductSpecificationId(productSpecificationId);
	}

	/**
	 * Sets the product spec value ID of this product spec value map.
	 *
	 * @param productSpecValueId the product spec value ID of this product spec value map
	 */
	@Override
	public void setProductSpecValueId(long productSpecValueId) {
		model.setProductSpecValueId(productSpecValueId);
	}

	/**
	 * Sets the specification value label of this product spec value map.
	 *
	 * @param specificationValueLabel the specification value label of this product spec value map
	 */
	@Override
	public void setSpecificationValueLabel(String specificationValueLabel) {
		model.setSpecificationValueLabel(specificationValueLabel);
	}

	/**
	 * Sets the specification value label ID of this product spec value map.
	 *
	 * @param specificationValueLabelId the specification value label ID of this product spec value map
	 */
	@Override
	public void setSpecificationValueLabelId(long specificationValueLabelId) {
		model.setSpecificationValueLabelId(specificationValueLabelId);
	}

	/**
	 * Sets the specification value uom of this product spec value map.
	 *
	 * @param specificationValueUOM the specification value uom of this product spec value map
	 */
	@Override
	public void setSpecificationValueUOM(String specificationValueUOM) {
		model.setSpecificationValueUOM(specificationValueUOM);
	}

	/**
	 * Sets the user ID of this product spec value map.
	 *
	 * @param userId the user ID of this product spec value map
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product spec value map.
	 *
	 * @param userName the user name of this product spec value map
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product spec value map.
	 *
	 * @param userUuid the user uuid of this product spec value map
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product spec value map.
	 *
	 * @param uuid the uuid of this product spec value map
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
	protected ProductSpecValueMapWrapper wrap(
		ProductSpecValueMap productSpecValueMap) {

		return new ProductSpecValueMapWrapper(productSpecValueMap);
	}

}