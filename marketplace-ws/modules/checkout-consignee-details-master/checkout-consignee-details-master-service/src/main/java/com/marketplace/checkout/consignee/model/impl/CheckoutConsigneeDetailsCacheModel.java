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

package com.marketplace.checkout.consignee.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CheckoutConsigneeDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CheckoutConsigneeDetailsCacheModel
	implements CacheModel<CheckoutConsigneeDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CheckoutConsigneeDetailsCacheModel)) {
			return false;
		}

		CheckoutConsigneeDetailsCacheModel checkoutConsigneeDetailsCacheModel =
			(CheckoutConsigneeDetailsCacheModel)object;

		if (checkoutConsigneeId ==
				checkoutConsigneeDetailsCacheModel.checkoutConsigneeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, checkoutConsigneeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", checkoutConsigneeId=");
		sb.append(checkoutConsigneeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", parentCartId=");
		sb.append(parentCartId);
		sb.append(", orderItemId=");
		sb.append(orderItemId);
		sb.append(", shippingConsigneeId=");
		sb.append(shippingConsigneeId);
		sb.append(", shipConsigneeJson=");
		sb.append(shipConsigneeJson);
		sb.append(", shipConsigneeAddressID=");
		sb.append(shipConsigneeAddressID);
		sb.append(", shipConsigneeAddressJson=");
		sb.append(shipConsigneeAddressJson);
		sb.append(", billingConsigneeId=");
		sb.append(billingConsigneeId);
		sb.append(", billConsigneeJson=");
		sb.append(billConsigneeJson);
		sb.append(", billConsigneeAddressId=");
		sb.append(billConsigneeAddressId);
		sb.append(", billConsigneeAddressJson=");
		sb.append(billConsigneeAddressJson);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CheckoutConsigneeDetails toEntityModel() {
		CheckoutConsigneeDetailsImpl checkoutConsigneeDetailsImpl =
			new CheckoutConsigneeDetailsImpl();

		if (uuid == null) {
			checkoutConsigneeDetailsImpl.setUuid("");
		}
		else {
			checkoutConsigneeDetailsImpl.setUuid(uuid);
		}

		checkoutConsigneeDetailsImpl.setCheckoutConsigneeId(
			checkoutConsigneeId);
		checkoutConsigneeDetailsImpl.setGroupId(groupId);
		checkoutConsigneeDetailsImpl.setCompanyId(companyId);
		checkoutConsigneeDetailsImpl.setUserId(userId);

		if (userName == null) {
			checkoutConsigneeDetailsImpl.setUserName("");
		}
		else {
			checkoutConsigneeDetailsImpl.setUserName(userName);
		}

		checkoutConsigneeDetailsImpl.setCreatedBy(createdBy);
		checkoutConsigneeDetailsImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			checkoutConsigneeDetailsImpl.setCreateDate(null);
		}
		else {
			checkoutConsigneeDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			checkoutConsigneeDetailsImpl.setModifiedDate(null);
		}
		else {
			checkoutConsigneeDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		checkoutConsigneeDetailsImpl.setParentCartId(parentCartId);
		checkoutConsigneeDetailsImpl.setOrderItemId(orderItemId);

		if (shippingConsigneeId == null) {
			checkoutConsigneeDetailsImpl.setShippingConsigneeId("");
		}
		else {
			checkoutConsigneeDetailsImpl.setShippingConsigneeId(
				shippingConsigneeId);
		}

		if (shipConsigneeJson == null) {
			checkoutConsigneeDetailsImpl.setShipConsigneeJson("");
		}
		else {
			checkoutConsigneeDetailsImpl.setShipConsigneeJson(
				shipConsigneeJson);
		}

		if (shipConsigneeAddressID == null) {
			checkoutConsigneeDetailsImpl.setShipConsigneeAddressID("");
		}
		else {
			checkoutConsigneeDetailsImpl.setShipConsigneeAddressID(
				shipConsigneeAddressID);
		}

		if (shipConsigneeAddressJson == null) {
			checkoutConsigneeDetailsImpl.setShipConsigneeAddressJson("");
		}
		else {
			checkoutConsigneeDetailsImpl.setShipConsigneeAddressJson(
				shipConsigneeAddressJson);
		}

		if (billingConsigneeId == null) {
			checkoutConsigneeDetailsImpl.setBillingConsigneeId("");
		}
		else {
			checkoutConsigneeDetailsImpl.setBillingConsigneeId(
				billingConsigneeId);
		}

		if (billConsigneeJson == null) {
			checkoutConsigneeDetailsImpl.setBillConsigneeJson("");
		}
		else {
			checkoutConsigneeDetailsImpl.setBillConsigneeJson(
				billConsigneeJson);
		}

		if (billConsigneeAddressId == null) {
			checkoutConsigneeDetailsImpl.setBillConsigneeAddressId("");
		}
		else {
			checkoutConsigneeDetailsImpl.setBillConsigneeAddressId(
				billConsigneeAddressId);
		}

		if (billConsigneeAddressJson == null) {
			checkoutConsigneeDetailsImpl.setBillConsigneeAddressJson("");
		}
		else {
			checkoutConsigneeDetailsImpl.setBillConsigneeAddressJson(
				billConsigneeAddressJson);
		}

		checkoutConsigneeDetailsImpl.setQuantity(quantity);

		checkoutConsigneeDetailsImpl.resetOriginalValues();

		return checkoutConsigneeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		checkoutConsigneeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		parentCartId = objectInput.readLong();

		orderItemId = objectInput.readLong();
		shippingConsigneeId = objectInput.readUTF();
		shipConsigneeJson = objectInput.readUTF();
		shipConsigneeAddressID = objectInput.readUTF();
		shipConsigneeAddressJson = objectInput.readUTF();
		billingConsigneeId = objectInput.readUTF();
		billConsigneeJson = objectInput.readUTF();
		billConsigneeAddressId = objectInput.readUTF();
		billConsigneeAddressJson = objectInput.readUTF();

		quantity = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(checkoutConsigneeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(parentCartId);

		objectOutput.writeLong(orderItemId);

		if (shippingConsigneeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shippingConsigneeId);
		}

		if (shipConsigneeJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shipConsigneeJson);
		}

		if (shipConsigneeAddressID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shipConsigneeAddressID);
		}

		if (shipConsigneeAddressJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shipConsigneeAddressJson);
		}

		if (billingConsigneeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billingConsigneeId);
		}

		if (billConsigneeJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billConsigneeJson);
		}

		if (billConsigneeAddressId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billConsigneeAddressId);
		}

		if (billConsigneeAddressJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(billConsigneeAddressJson);
		}

		objectOutput.writeLong(quantity);
	}

	public String uuid;
	public long checkoutConsigneeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public long parentCartId;
	public long orderItemId;
	public String shippingConsigneeId;
	public String shipConsigneeJson;
	public String shipConsigneeAddressID;
	public String shipConsigneeAddressJson;
	public String billingConsigneeId;
	public String billConsigneeJson;
	public String billConsigneeAddressId;
	public String billConsigneeAddressJson;
	public long quantity;

}