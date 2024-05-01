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

package com.marketplace.checkout.consignee.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CheckoutConsigneeDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetails
 * @generated
 */
public class CheckoutConsigneeDetailsWrapper
	extends BaseModelWrapper<CheckoutConsigneeDetails>
	implements CheckoutConsigneeDetails,
			   ModelWrapper<CheckoutConsigneeDetails> {

	public CheckoutConsigneeDetailsWrapper(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		super(checkoutConsigneeDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("checkoutConsigneeId", getCheckoutConsigneeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentCartId", getParentCartId());
		attributes.put("orderItemId", getOrderItemId());
		attributes.put("shippingConsigneeId", getShippingConsigneeId());
		attributes.put("shipConsigneeJson", getShipConsigneeJson());
		attributes.put("shipConsigneeAddressID", getShipConsigneeAddressID());
		attributes.put(
			"shipConsigneeAddressJson", getShipConsigneeAddressJson());
		attributes.put("billingConsigneeId", getBillingConsigneeId());
		attributes.put("billConsigneeJson", getBillConsigneeJson());
		attributes.put("billConsigneeAddressId", getBillConsigneeAddressId());
		attributes.put(
			"billConsigneeAddressJson", getBillConsigneeAddressJson());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long checkoutConsigneeId = (Long)attributes.get("checkoutConsigneeId");

		if (checkoutConsigneeId != null) {
			setCheckoutConsigneeId(checkoutConsigneeId);
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

		Long parentCartId = (Long)attributes.get("parentCartId");

		if (parentCartId != null) {
			setParentCartId(parentCartId);
		}

		Long orderItemId = (Long)attributes.get("orderItemId");

		if (orderItemId != null) {
			setOrderItemId(orderItemId);
		}

		String shippingConsigneeId = (String)attributes.get(
			"shippingConsigneeId");

		if (shippingConsigneeId != null) {
			setShippingConsigneeId(shippingConsigneeId);
		}

		String shipConsigneeJson = (String)attributes.get("shipConsigneeJson");

		if (shipConsigneeJson != null) {
			setShipConsigneeJson(shipConsigneeJson);
		}

		String shipConsigneeAddressID = (String)attributes.get(
			"shipConsigneeAddressID");

		if (shipConsigneeAddressID != null) {
			setShipConsigneeAddressID(shipConsigneeAddressID);
		}

		String shipConsigneeAddressJson = (String)attributes.get(
			"shipConsigneeAddressJson");

		if (shipConsigneeAddressJson != null) {
			setShipConsigneeAddressJson(shipConsigneeAddressJson);
		}

		String billingConsigneeId = (String)attributes.get(
			"billingConsigneeId");

		if (billingConsigneeId != null) {
			setBillingConsigneeId(billingConsigneeId);
		}

		String billConsigneeJson = (String)attributes.get("billConsigneeJson");

		if (billConsigneeJson != null) {
			setBillConsigneeJson(billConsigneeJson);
		}

		String billConsigneeAddressId = (String)attributes.get(
			"billConsigneeAddressId");

		if (billConsigneeAddressId != null) {
			setBillConsigneeAddressId(billConsigneeAddressId);
		}

		String billConsigneeAddressJson = (String)attributes.get(
			"billConsigneeAddressJson");

		if (billConsigneeAddressJson != null) {
			setBillConsigneeAddressJson(billConsigneeAddressJson);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	@Override
	public CheckoutConsigneeDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bill consignee address ID of this checkout consignee details.
	 *
	 * @return the bill consignee address ID of this checkout consignee details
	 */
	@Override
	public String getBillConsigneeAddressId() {
		return model.getBillConsigneeAddressId();
	}

	/**
	 * Returns the bill consignee address json of this checkout consignee details.
	 *
	 * @return the bill consignee address json of this checkout consignee details
	 */
	@Override
	public String getBillConsigneeAddressJson() {
		return model.getBillConsigneeAddressJson();
	}

	/**
	 * Returns the bill consignee json of this checkout consignee details.
	 *
	 * @return the bill consignee json of this checkout consignee details
	 */
	@Override
	public String getBillConsigneeJson() {
		return model.getBillConsigneeJson();
	}

	/**
	 * Returns the billing consignee ID of this checkout consignee details.
	 *
	 * @return the billing consignee ID of this checkout consignee details
	 */
	@Override
	public String getBillingConsigneeId() {
		return model.getBillingConsigneeId();
	}

	/**
	 * Returns the checkout consignee ID of this checkout consignee details.
	 *
	 * @return the checkout consignee ID of this checkout consignee details
	 */
	@Override
	public long getCheckoutConsigneeId() {
		return model.getCheckoutConsigneeId();
	}

	/**
	 * Returns the company ID of this checkout consignee details.
	 *
	 * @return the company ID of this checkout consignee details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this checkout consignee details.
	 *
	 * @return the create date of this checkout consignee details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this checkout consignee details.
	 *
	 * @return the created by of this checkout consignee details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this checkout consignee details.
	 *
	 * @return the group ID of this checkout consignee details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this checkout consignee details.
	 *
	 * @return the modified by of this checkout consignee details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this checkout consignee details.
	 *
	 * @return the modified date of this checkout consignee details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the order item ID of this checkout consignee details.
	 *
	 * @return the order item ID of this checkout consignee details
	 */
	@Override
	public long getOrderItemId() {
		return model.getOrderItemId();
	}

	/**
	 * Returns the parent cart ID of this checkout consignee details.
	 *
	 * @return the parent cart ID of this checkout consignee details
	 */
	@Override
	public long getParentCartId() {
		return model.getParentCartId();
	}

	/**
	 * Returns the primary key of this checkout consignee details.
	 *
	 * @return the primary key of this checkout consignee details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this checkout consignee details.
	 *
	 * @return the quantity of this checkout consignee details
	 */
	@Override
	public long getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the ship consignee address ID of this checkout consignee details.
	 *
	 * @return the ship consignee address ID of this checkout consignee details
	 */
	@Override
	public String getShipConsigneeAddressID() {
		return model.getShipConsigneeAddressID();
	}

	/**
	 * Returns the ship consignee address json of this checkout consignee details.
	 *
	 * @return the ship consignee address json of this checkout consignee details
	 */
	@Override
	public String getShipConsigneeAddressJson() {
		return model.getShipConsigneeAddressJson();
	}

	/**
	 * Returns the ship consignee json of this checkout consignee details.
	 *
	 * @return the ship consignee json of this checkout consignee details
	 */
	@Override
	public String getShipConsigneeJson() {
		return model.getShipConsigneeJson();
	}

	/**
	 * Returns the shipping consignee ID of this checkout consignee details.
	 *
	 * @return the shipping consignee ID of this checkout consignee details
	 */
	@Override
	public String getShippingConsigneeId() {
		return model.getShippingConsigneeId();
	}

	/**
	 * Returns the user ID of this checkout consignee details.
	 *
	 * @return the user ID of this checkout consignee details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this checkout consignee details.
	 *
	 * @return the user name of this checkout consignee details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this checkout consignee details.
	 *
	 * @return the user uuid of this checkout consignee details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this checkout consignee details.
	 *
	 * @return the uuid of this checkout consignee details
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
	 * Sets the bill consignee address ID of this checkout consignee details.
	 *
	 * @param billConsigneeAddressId the bill consignee address ID of this checkout consignee details
	 */
	@Override
	public void setBillConsigneeAddressId(String billConsigneeAddressId) {
		model.setBillConsigneeAddressId(billConsigneeAddressId);
	}

	/**
	 * Sets the bill consignee address json of this checkout consignee details.
	 *
	 * @param billConsigneeAddressJson the bill consignee address json of this checkout consignee details
	 */
	@Override
	public void setBillConsigneeAddressJson(String billConsigneeAddressJson) {
		model.setBillConsigneeAddressJson(billConsigneeAddressJson);
	}

	/**
	 * Sets the bill consignee json of this checkout consignee details.
	 *
	 * @param billConsigneeJson the bill consignee json of this checkout consignee details
	 */
	@Override
	public void setBillConsigneeJson(String billConsigneeJson) {
		model.setBillConsigneeJson(billConsigneeJson);
	}

	/**
	 * Sets the billing consignee ID of this checkout consignee details.
	 *
	 * @param billingConsigneeId the billing consignee ID of this checkout consignee details
	 */
	@Override
	public void setBillingConsigneeId(String billingConsigneeId) {
		model.setBillingConsigneeId(billingConsigneeId);
	}

	/**
	 * Sets the checkout consignee ID of this checkout consignee details.
	 *
	 * @param checkoutConsigneeId the checkout consignee ID of this checkout consignee details
	 */
	@Override
	public void setCheckoutConsigneeId(long checkoutConsigneeId) {
		model.setCheckoutConsigneeId(checkoutConsigneeId);
	}

	/**
	 * Sets the company ID of this checkout consignee details.
	 *
	 * @param companyId the company ID of this checkout consignee details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this checkout consignee details.
	 *
	 * @param createDate the create date of this checkout consignee details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this checkout consignee details.
	 *
	 * @param createdBy the created by of this checkout consignee details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this checkout consignee details.
	 *
	 * @param groupId the group ID of this checkout consignee details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this checkout consignee details.
	 *
	 * @param modifiedBy the modified by of this checkout consignee details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this checkout consignee details.
	 *
	 * @param modifiedDate the modified date of this checkout consignee details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the order item ID of this checkout consignee details.
	 *
	 * @param orderItemId the order item ID of this checkout consignee details
	 */
	@Override
	public void setOrderItemId(long orderItemId) {
		model.setOrderItemId(orderItemId);
	}

	/**
	 * Sets the parent cart ID of this checkout consignee details.
	 *
	 * @param parentCartId the parent cart ID of this checkout consignee details
	 */
	@Override
	public void setParentCartId(long parentCartId) {
		model.setParentCartId(parentCartId);
	}

	/**
	 * Sets the primary key of this checkout consignee details.
	 *
	 * @param primaryKey the primary key of this checkout consignee details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this checkout consignee details.
	 *
	 * @param quantity the quantity of this checkout consignee details
	 */
	@Override
	public void setQuantity(long quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the ship consignee address ID of this checkout consignee details.
	 *
	 * @param shipConsigneeAddressID the ship consignee address ID of this checkout consignee details
	 */
	@Override
	public void setShipConsigneeAddressID(String shipConsigneeAddressID) {
		model.setShipConsigneeAddressID(shipConsigneeAddressID);
	}

	/**
	 * Sets the ship consignee address json of this checkout consignee details.
	 *
	 * @param shipConsigneeAddressJson the ship consignee address json of this checkout consignee details
	 */
	@Override
	public void setShipConsigneeAddressJson(String shipConsigneeAddressJson) {
		model.setShipConsigneeAddressJson(shipConsigneeAddressJson);
	}

	/**
	 * Sets the ship consignee json of this checkout consignee details.
	 *
	 * @param shipConsigneeJson the ship consignee json of this checkout consignee details
	 */
	@Override
	public void setShipConsigneeJson(String shipConsigneeJson) {
		model.setShipConsigneeJson(shipConsigneeJson);
	}

	/**
	 * Sets the shipping consignee ID of this checkout consignee details.
	 *
	 * @param shippingConsigneeId the shipping consignee ID of this checkout consignee details
	 */
	@Override
	public void setShippingConsigneeId(String shippingConsigneeId) {
		model.setShippingConsigneeId(shippingConsigneeId);
	}

	/**
	 * Sets the user ID of this checkout consignee details.
	 *
	 * @param userId the user ID of this checkout consignee details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this checkout consignee details.
	 *
	 * @param userName the user name of this checkout consignee details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this checkout consignee details.
	 *
	 * @param userUuid the user uuid of this checkout consignee details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this checkout consignee details.
	 *
	 * @param uuid the uuid of this checkout consignee details
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
	protected CheckoutConsigneeDetailsWrapper wrap(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return new CheckoutConsigneeDetailsWrapper(checkoutConsigneeDetails);
	}

}