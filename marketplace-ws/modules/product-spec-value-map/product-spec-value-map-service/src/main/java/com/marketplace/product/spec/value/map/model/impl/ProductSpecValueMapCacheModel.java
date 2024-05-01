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

package com.marketplace.product.spec.value.map.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductSpecValueMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSpecValueMapCacheModel
	implements CacheModel<ProductSpecValueMap>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSpecValueMapCacheModel)) {
			return false;
		}

		ProductSpecValueMapCacheModel productSpecValueMapCacheModel =
			(ProductSpecValueMapCacheModel)object;

		if (productSpecValueId ==
				productSpecValueMapCacheModel.productSpecValueId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productSpecValueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productSpecValueId=");
		sb.append(productSpecValueId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", productSpecificationId=");
		sb.append(productSpecificationId);
		sb.append(", specificationValueLabelId=");
		sb.append(specificationValueLabelId);
		sb.append(", specificationValueLabel=");
		sb.append(specificationValueLabel);
		sb.append(", specificationValueUOM=");
		sb.append(specificationValueUOM);
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
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductSpecValueMap toEntityModel() {
		ProductSpecValueMapImpl productSpecValueMapImpl =
			new ProductSpecValueMapImpl();

		if (uuid == null) {
			productSpecValueMapImpl.setUuid("");
		}
		else {
			productSpecValueMapImpl.setUuid(uuid);
		}

		productSpecValueMapImpl.setProductSpecValueId(productSpecValueId);
		productSpecValueMapImpl.setGroupId(groupId);
		productSpecValueMapImpl.setProductSpecificationId(
			productSpecificationId);
		productSpecValueMapImpl.setSpecificationValueLabelId(
			specificationValueLabelId);

		if (specificationValueLabel == null) {
			productSpecValueMapImpl.setSpecificationValueLabel("");
		}
		else {
			productSpecValueMapImpl.setSpecificationValueLabel(
				specificationValueLabel);
		}

		if (specificationValueUOM == null) {
			productSpecValueMapImpl.setSpecificationValueUOM("");
		}
		else {
			productSpecValueMapImpl.setSpecificationValueUOM(
				specificationValueUOM);
		}

		productSpecValueMapImpl.setCompanyId(companyId);
		productSpecValueMapImpl.setUserId(userId);

		if (userName == null) {
			productSpecValueMapImpl.setUserName("");
		}
		else {
			productSpecValueMapImpl.setUserName(userName);
		}

		productSpecValueMapImpl.setCreatedBy(createdBy);
		productSpecValueMapImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			productSpecValueMapImpl.setCreateDate(null);
		}
		else {
			productSpecValueMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productSpecValueMapImpl.setModifiedDate(null);
		}
		else {
			productSpecValueMapImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ipAddress == null) {
			productSpecValueMapImpl.setIpAddress("");
		}
		else {
			productSpecValueMapImpl.setIpAddress(ipAddress);
		}

		productSpecValueMapImpl.resetOriginalValues();

		return productSpecValueMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productSpecValueId = objectInput.readLong();

		groupId = objectInput.readLong();

		productSpecificationId = objectInput.readLong();

		specificationValueLabelId = objectInput.readLong();
		specificationValueLabel = objectInput.readUTF();
		specificationValueUOM = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productSpecValueId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(productSpecificationId);

		objectOutput.writeLong(specificationValueLabelId);

		if (specificationValueLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationValueLabel);
		}

		if (specificationValueUOM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specificationValueUOM);
		}

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

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public String uuid;
	public long productSpecValueId;
	public long groupId;
	public long productSpecificationId;
	public long specificationValueLabelId;
	public String specificationValueLabel;
	public String specificationValueUOM;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public String ipAddress;

}