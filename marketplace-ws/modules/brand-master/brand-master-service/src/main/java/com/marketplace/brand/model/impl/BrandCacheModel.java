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

package com.marketplace.brand.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.brand.model.Brand;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Brand in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandCacheModel implements CacheModel<Brand>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrandCacheModel)) {
			return false;
		}

		BrandCacheModel brandCacheModel = (BrandCacheModel)object;

		if (brandId == brandCacheModel.brandId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, brandId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(87);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", assetCategoryId=");
		sb.append(assetCategoryId);
		sb.append(", brandCode=");
		sb.append(brandCode);
		sb.append(", brandName=");
		sb.append(brandName);
		sb.append(", brandDescription=");
		sb.append(brandDescription);
		sb.append(", brandOwner=");
		sb.append(brandOwner);
		sb.append(", brandReviewer=");
		sb.append(brandReviewer);
		sb.append(", brandType=");
		sb.append(brandType);
		sb.append(", externalReferenceId=");
		sb.append(externalReferenceId);
		sb.append(", brandApprovalStatus=");
		sb.append(brandApprovalStatus);
		sb.append(", reviewerRemarks=");
		sb.append(reviewerRemarks);
		sb.append(", brandInactive=");
		sb.append(brandInactive);
		sb.append(", brandImageUpload=");
		sb.append(brandImageUpload);
		sb.append(", brandImageURL=");
		sb.append(brandImageURL);
		sb.append(", managerRemarks=");
		sb.append(managerRemarks);
		sb.append(", customAtr1=");
		sb.append(customAtr1);
		sb.append(", customAtr2=");
		sb.append(customAtr2);
		sb.append(", customAtr3=");
		sb.append(customAtr3);
		sb.append(", customAtr4=");
		sb.append(customAtr4);
		sb.append(", customAtr5=");
		sb.append(customAtr5);
		sb.append(", customAtr6=");
		sb.append(customAtr6);
		sb.append(", customAtr7=");
		sb.append(customAtr7);
		sb.append(", customAtr8=");
		sb.append(customAtr8);
		sb.append(", customAtr9=");
		sb.append(customAtr9);
		sb.append(", customAtr10=");
		sb.append(customAtr10);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", downForSeller=");
		sb.append(downForSeller);
		sb.append(", downForBuyer=");
		sb.append(downForBuyer);
		sb.append(", downForMaintenance=");
		sb.append(downForMaintenance);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Brand toEntityModel() {
		BrandImpl brandImpl = new BrandImpl();

		if (uuid == null) {
			brandImpl.setUuid("");
		}
		else {
			brandImpl.setUuid(uuid);
		}

		brandImpl.setBrandId(brandId);
		brandImpl.setGroupId(groupId);
		brandImpl.setAssetCategoryId(assetCategoryId);

		if (brandCode == null) {
			brandImpl.setBrandCode("");
		}
		else {
			brandImpl.setBrandCode(brandCode);
		}

		if (brandName == null) {
			brandImpl.setBrandName("");
		}
		else {
			brandImpl.setBrandName(brandName);
		}

		if (brandDescription == null) {
			brandImpl.setBrandDescription("");
		}
		else {
			brandImpl.setBrandDescription(brandDescription);
		}

		if (brandOwner == null) {
			brandImpl.setBrandOwner("");
		}
		else {
			brandImpl.setBrandOwner(brandOwner);
		}

		brandImpl.setBrandReviewer(brandReviewer);

		if (brandType == null) {
			brandImpl.setBrandType("");
		}
		else {
			brandImpl.setBrandType(brandType);
		}

		if (externalReferenceId == null) {
			brandImpl.setExternalReferenceId("");
		}
		else {
			brandImpl.setExternalReferenceId(externalReferenceId);
		}

		if (brandApprovalStatus == null) {
			brandImpl.setBrandApprovalStatus("");
		}
		else {
			brandImpl.setBrandApprovalStatus(brandApprovalStatus);
		}

		if (reviewerRemarks == null) {
			brandImpl.setReviewerRemarks("");
		}
		else {
			brandImpl.setReviewerRemarks(reviewerRemarks);
		}

		brandImpl.setBrandInactive(brandInactive);
		brandImpl.setBrandImageUpload(brandImageUpload);

		if (brandImageURL == null) {
			brandImpl.setBrandImageURL("");
		}
		else {
			brandImpl.setBrandImageURL(brandImageURL);
		}

		if (managerRemarks == null) {
			brandImpl.setManagerRemarks("");
		}
		else {
			brandImpl.setManagerRemarks(managerRemarks);
		}

		if (customAtr1 == null) {
			brandImpl.setCustomAtr1("");
		}
		else {
			brandImpl.setCustomAtr1(customAtr1);
		}

		if (customAtr2 == null) {
			brandImpl.setCustomAtr2("");
		}
		else {
			brandImpl.setCustomAtr2(customAtr2);
		}

		if (customAtr3 == null) {
			brandImpl.setCustomAtr3("");
		}
		else {
			brandImpl.setCustomAtr3(customAtr3);
		}

		if (customAtr4 == null) {
			brandImpl.setCustomAtr4("");
		}
		else {
			brandImpl.setCustomAtr4(customAtr4);
		}

		if (customAtr5 == null) {
			brandImpl.setCustomAtr5("");
		}
		else {
			brandImpl.setCustomAtr5(customAtr5);
		}

		if (customAtr6 == null) {
			brandImpl.setCustomAtr6("");
		}
		else {
			brandImpl.setCustomAtr6(customAtr6);
		}

		if (customAtr7 == null) {
			brandImpl.setCustomAtr7("");
		}
		else {
			brandImpl.setCustomAtr7(customAtr7);
		}

		if (customAtr8 == null) {
			brandImpl.setCustomAtr8("");
		}
		else {
			brandImpl.setCustomAtr8(customAtr8);
		}

		if (customAtr9 == null) {
			brandImpl.setCustomAtr9("");
		}
		else {
			brandImpl.setCustomAtr9(customAtr9);
		}

		if (customAtr10 == null) {
			brandImpl.setCustomAtr10("");
		}
		else {
			brandImpl.setCustomAtr10(customAtr10);
		}

		brandImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			brandImpl.setCreateDate(null);
		}
		else {
			brandImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			brandImpl.setModifiedDate(null);
		}
		else {
			brandImpl.setModifiedDate(new Date(modifiedDate));
		}

		brandImpl.setCreatedBy(createdBy);
		brandImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			brandImpl.setIpAddress("");
		}
		else {
			brandImpl.setIpAddress(ipAddress);
		}

		brandImpl.setIsActive(isActive);
		brandImpl.setDownForSeller(downForSeller);
		brandImpl.setDownForBuyer(downForBuyer);
		brandImpl.setDownForMaintenance(downForMaintenance);
		brandImpl.setUserId(userId);

		if (userName == null) {
			brandImpl.setUserName("");
		}
		else {
			brandImpl.setUserName(userName);
		}

		brandImpl.setStatus(status);
		brandImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			brandImpl.setStatusByUserName("");
		}
		else {
			brandImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			brandImpl.setStatusDate(null);
		}
		else {
			brandImpl.setStatusDate(new Date(statusDate));
		}

		brandImpl.resetOriginalValues();

		return brandImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		brandId = objectInput.readLong();

		groupId = objectInput.readLong();

		assetCategoryId = objectInput.readLong();
		brandCode = objectInput.readUTF();
		brandName = objectInput.readUTF();
		brandDescription = objectInput.readUTF();
		brandOwner = objectInput.readUTF();

		brandReviewer = objectInput.readLong();
		brandType = objectInput.readUTF();
		externalReferenceId = objectInput.readUTF();
		brandApprovalStatus = objectInput.readUTF();
		reviewerRemarks = objectInput.readUTF();

		brandInactive = objectInput.readBoolean();

		brandImageUpload = objectInput.readLong();
		brandImageURL = objectInput.readUTF();
		managerRemarks = objectInput.readUTF();
		customAtr1 = objectInput.readUTF();
		customAtr2 = objectInput.readUTF();
		customAtr3 = objectInput.readUTF();
		customAtr4 = objectInput.readUTF();
		customAtr5 = objectInput.readUTF();
		customAtr6 = objectInput.readUTF();
		customAtr7 = objectInput.readUTF();
		customAtr8 = objectInput.readUTF();
		customAtr9 = objectInput.readUTF();
		customAtr10 = objectInput.readUTF();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		ipAddress = objectInput.readUTF();

		isActive = objectInput.readBoolean();

		downForSeller = objectInput.readBoolean();

		downForBuyer = objectInput.readBoolean();

		downForMaintenance = objectInput.readBoolean();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(brandId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(assetCategoryId);

		if (brandCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandCode);
		}

		if (brandName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandName);
		}

		if (brandDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandDescription);
		}

		if (brandOwner == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandOwner);
		}

		objectOutput.writeLong(brandReviewer);

		if (brandType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandType);
		}

		if (externalReferenceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceId);
		}

		if (brandApprovalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandApprovalStatus);
		}

		if (reviewerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewerRemarks);
		}

		objectOutput.writeBoolean(brandInactive);

		objectOutput.writeLong(brandImageUpload);

		if (brandImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandImageURL);
		}

		if (managerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managerRemarks);
		}

		if (customAtr1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr1);
		}

		if (customAtr2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr2);
		}

		if (customAtr3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr3);
		}

		if (customAtr4 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr4);
		}

		if (customAtr5 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr5);
		}

		if (customAtr6 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr6);
		}

		if (customAtr7 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr7);
		}

		if (customAtr8 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr8);
		}

		if (customAtr9 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr9);
		}

		if (customAtr10 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customAtr10);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}

		objectOutput.writeBoolean(isActive);

		objectOutput.writeBoolean(downForSeller);

		objectOutput.writeBoolean(downForBuyer);

		objectOutput.writeBoolean(downForMaintenance);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long brandId;
	public long groupId;
	public long assetCategoryId;
	public String brandCode;
	public String brandName;
	public String brandDescription;
	public String brandOwner;
	public long brandReviewer;
	public String brandType;
	public String externalReferenceId;
	public String brandApprovalStatus;
	public String reviewerRemarks;
	public boolean brandInactive;
	public long brandImageUpload;
	public String brandImageURL;
	public String managerRemarks;
	public String customAtr1;
	public String customAtr2;
	public String customAtr3;
	public String customAtr4;
	public String customAtr5;
	public String customAtr6;
	public String customAtr7;
	public String customAtr8;
	public String customAtr9;
	public String customAtr10;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public String ipAddress;
	public boolean isActive;
	public boolean downForSeller;
	public boolean downForBuyer;
	public boolean downForMaintenance;
	public long userId;
	public String userName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}