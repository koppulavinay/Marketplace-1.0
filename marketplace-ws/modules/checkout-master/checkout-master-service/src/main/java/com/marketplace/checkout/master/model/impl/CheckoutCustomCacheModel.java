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

package com.marketplace.checkout.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.checkout.master.model.CheckoutCustom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CheckoutCustom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CheckoutCustomCacheModel
	implements CacheModel<CheckoutCustom>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CheckoutCustomCacheModel)) {
			return false;
		}

		CheckoutCustomCacheModel checkoutCustomCacheModel =
			(CheckoutCustomCacheModel)object;

		if (checkoutCustomId == checkoutCustomCacheModel.checkoutCustomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, checkoutCustomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{checkoutCustomId=");
		sb.append(checkoutCustomId);
		sb.append(", commerceOrderId=");
		sb.append(commerceOrderId);
		sb.append(", requestJson=");
		sb.append(requestJson);
		sb.append(", responseJson=");
		sb.append(responseJson);
		sb.append(", module=");
		sb.append(module);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CheckoutCustom toEntityModel() {
		CheckoutCustomImpl checkoutCustomImpl = new CheckoutCustomImpl();

		checkoutCustomImpl.setCheckoutCustomId(checkoutCustomId);
		checkoutCustomImpl.setCommerceOrderId(commerceOrderId);

		if (requestJson == null) {
			checkoutCustomImpl.setRequestJson("");
		}
		else {
			checkoutCustomImpl.setRequestJson(requestJson);
		}

		if (responseJson == null) {
			checkoutCustomImpl.setResponseJson("");
		}
		else {
			checkoutCustomImpl.setResponseJson(responseJson);
		}

		if (module == null) {
			checkoutCustomImpl.setModule("");
		}
		else {
			checkoutCustomImpl.setModule(module);
		}

		if (createDate == Long.MIN_VALUE) {
			checkoutCustomImpl.setCreateDate(null);
		}
		else {
			checkoutCustomImpl.setCreateDate(new Date(createDate));
		}

		checkoutCustomImpl.resetOriginalValues();

		return checkoutCustomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		checkoutCustomId = objectInput.readLong();

		commerceOrderId = objectInput.readLong();
		requestJson = objectInput.readUTF();
		responseJson = objectInput.readUTF();
		module = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(checkoutCustomId);

		objectOutput.writeLong(commerceOrderId);

		if (requestJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestJson);
		}

		if (responseJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responseJson);
		}

		if (module == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(module);
		}

		objectOutput.writeLong(createDate);
	}

	public long checkoutCustomId;
	public long commerceOrderId;
	public String requestJson;
	public String responseJson;
	public String module;
	public long createDate;

}