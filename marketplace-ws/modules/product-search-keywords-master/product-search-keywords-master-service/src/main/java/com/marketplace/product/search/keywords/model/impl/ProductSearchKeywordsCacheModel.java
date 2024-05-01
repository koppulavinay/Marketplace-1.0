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

package com.marketplace.product.search.keywords.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.product.search.keywords.model.ProductSearchKeywords;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductSearchKeywords in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSearchKeywordsCacheModel
	implements CacheModel<ProductSearchKeywords>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSearchKeywordsCacheModel)) {
			return false;
		}

		ProductSearchKeywordsCacheModel productSearchKeywordsCacheModel =
			(ProductSearchKeywordsCacheModel)object;

		if (searchKeywordId ==
				productSearchKeywordsCacheModel.searchKeywordId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, searchKeywordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", searchKeywordId=");
		sb.append(searchKeywordId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", searchKeyword=");
		sb.append(searchKeyword);
		sb.append(", draftProductId=");
		sb.append(draftProductId);
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
	public ProductSearchKeywords toEntityModel() {
		ProductSearchKeywordsImpl productSearchKeywordsImpl =
			new ProductSearchKeywordsImpl();

		if (uuid == null) {
			productSearchKeywordsImpl.setUuid("");
		}
		else {
			productSearchKeywordsImpl.setUuid(uuid);
		}

		productSearchKeywordsImpl.setSearchKeywordId(searchKeywordId);
		productSearchKeywordsImpl.setGroupId(groupId);

		if (searchKeyword == null) {
			productSearchKeywordsImpl.setSearchKeyword("");
		}
		else {
			productSearchKeywordsImpl.setSearchKeyword(searchKeyword);
		}

		productSearchKeywordsImpl.setDraftProductId(draftProductId);
		productSearchKeywordsImpl.setCompanyId(companyId);
		productSearchKeywordsImpl.setUserId(userId);

		if (userName == null) {
			productSearchKeywordsImpl.setUserName("");
		}
		else {
			productSearchKeywordsImpl.setUserName(userName);
		}

		productSearchKeywordsImpl.setCreatedBy(createdBy);
		productSearchKeywordsImpl.setModifiedBy(modifiedBy);

		if (createDate == Long.MIN_VALUE) {
			productSearchKeywordsImpl.setCreateDate(null);
		}
		else {
			productSearchKeywordsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productSearchKeywordsImpl.setModifiedDate(null);
		}
		else {
			productSearchKeywordsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ipAddress == null) {
			productSearchKeywordsImpl.setIpAddress("");
		}
		else {
			productSearchKeywordsImpl.setIpAddress(ipAddress);
		}

		productSearchKeywordsImpl.resetOriginalValues();

		return productSearchKeywordsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		searchKeywordId = objectInput.readLong();

		groupId = objectInput.readLong();
		searchKeyword = objectInput.readUTF();

		draftProductId = objectInput.readLong();

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

		objectOutput.writeLong(searchKeywordId);

		objectOutput.writeLong(groupId);

		if (searchKeyword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(searchKeyword);
		}

		objectOutput.writeLong(draftProductId);

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
	public long searchKeywordId;
	public long groupId;
	public String searchKeyword;
	public long draftProductId;
	public long companyId;
	public long userId;
	public String userName;
	public long createdBy;
	public long modifiedBy;
	public long createDate;
	public long modifiedDate;
	public String ipAddress;

}