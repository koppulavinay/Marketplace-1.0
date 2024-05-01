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

package com.marketplace.category.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.marketplace.category.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CategoryCacheModel
	implements CacheModel<Category>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryCacheModel)) {
			return false;
		}

		CategoryCacheModel categoryCacheModel = (CategoryCacheModel)object;

		if (categoryId == categoryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(97);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);
		sb.append(", assetCategoryId=");
		sb.append(assetCategoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryCode=");
		sb.append(categoryCode);
		sb.append(", categoryDescription=");
		sb.append(categoryDescription);
		sb.append(", categoryType=");
		sb.append(categoryType);
		sb.append(", assignManager=");
		sb.append(assignManager);
		sb.append(", assignReviewer=");
		sb.append(assignReviewer);
		sb.append(", categoryApprovalStatus=");
		sb.append(categoryApprovalStatus);
		sb.append(", reviewerRemarks=");
		sb.append(reviewerRemarks);
		sb.append(", categoryExpiryDate=");
		sb.append(categoryExpiryDate);
		sb.append(", categoryInactive=");
		sb.append(categoryInactive);
		sb.append(", externalReferenceId=");
		sb.append(externalReferenceId);
		sb.append(", categoryImageId=");
		sb.append(categoryImageId);
		sb.append(", categoryImageURL=");
		sb.append(categoryImageURL);
		sb.append(", managerRemarks=");
		sb.append(managerRemarks);
		sb.append(", treePath=");
		sb.append(treePath);
		sb.append(", termsCondition=");
		sb.append(termsCondition);
		sb.append(", hasChild=");
		sb.append(hasChild);
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
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		if (uuid == null) {
			categoryImpl.setUuid("");
		}
		else {
			categoryImpl.setUuid(uuid);
		}

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setParentCategoryId(parentCategoryId);
		categoryImpl.setAssetCategoryId(assetCategoryId);
		categoryImpl.setGroupId(groupId);

		if (categoryName == null) {
			categoryImpl.setCategoryName("");
		}
		else {
			categoryImpl.setCategoryName(categoryName);
		}

		if (categoryCode == null) {
			categoryImpl.setCategoryCode("");
		}
		else {
			categoryImpl.setCategoryCode(categoryCode);
		}

		if (categoryDescription == null) {
			categoryImpl.setCategoryDescription("");
		}
		else {
			categoryImpl.setCategoryDescription(categoryDescription);
		}

		if (categoryType == null) {
			categoryImpl.setCategoryType("");
		}
		else {
			categoryImpl.setCategoryType(categoryType);
		}

		categoryImpl.setAssignManager(assignManager);
		categoryImpl.setAssignReviewer(assignReviewer);

		if (categoryApprovalStatus == null) {
			categoryImpl.setCategoryApprovalStatus("");
		}
		else {
			categoryImpl.setCategoryApprovalStatus(categoryApprovalStatus);
		}

		if (reviewerRemarks == null) {
			categoryImpl.setReviewerRemarks("");
		}
		else {
			categoryImpl.setReviewerRemarks(reviewerRemarks);
		}

		if (categoryExpiryDate == Long.MIN_VALUE) {
			categoryImpl.setCategoryExpiryDate(null);
		}
		else {
			categoryImpl.setCategoryExpiryDate(new Date(categoryExpiryDate));
		}

		categoryImpl.setCategoryInactive(categoryInactive);

		if (externalReferenceId == null) {
			categoryImpl.setExternalReferenceId("");
		}
		else {
			categoryImpl.setExternalReferenceId(externalReferenceId);
		}

		categoryImpl.setCategoryImageId(categoryImageId);

		if (categoryImageURL == null) {
			categoryImpl.setCategoryImageURL("");
		}
		else {
			categoryImpl.setCategoryImageURL(categoryImageURL);
		}

		if (managerRemarks == null) {
			categoryImpl.setManagerRemarks("");
		}
		else {
			categoryImpl.setManagerRemarks(managerRemarks);
		}

		if (treePath == null) {
			categoryImpl.setTreePath("");
		}
		else {
			categoryImpl.setTreePath(treePath);
		}

		if (termsCondition == null) {
			categoryImpl.setTermsCondition("");
		}
		else {
			categoryImpl.setTermsCondition(termsCondition);
		}

		categoryImpl.setHasChild(hasChild);

		if (customAtr1 == null) {
			categoryImpl.setCustomAtr1("");
		}
		else {
			categoryImpl.setCustomAtr1(customAtr1);
		}

		if (customAtr2 == null) {
			categoryImpl.setCustomAtr2("");
		}
		else {
			categoryImpl.setCustomAtr2(customAtr2);
		}

		if (customAtr3 == null) {
			categoryImpl.setCustomAtr3("");
		}
		else {
			categoryImpl.setCustomAtr3(customAtr3);
		}

		if (customAtr4 == null) {
			categoryImpl.setCustomAtr4("");
		}
		else {
			categoryImpl.setCustomAtr4(customAtr4);
		}

		if (customAtr5 == null) {
			categoryImpl.setCustomAtr5("");
		}
		else {
			categoryImpl.setCustomAtr5(customAtr5);
		}

		if (customAtr6 == null) {
			categoryImpl.setCustomAtr6("");
		}
		else {
			categoryImpl.setCustomAtr6(customAtr6);
		}

		if (customAtr7 == null) {
			categoryImpl.setCustomAtr7("");
		}
		else {
			categoryImpl.setCustomAtr7(customAtr7);
		}

		if (customAtr8 == null) {
			categoryImpl.setCustomAtr8("");
		}
		else {
			categoryImpl.setCustomAtr8(customAtr8);
		}

		if (customAtr9 == null) {
			categoryImpl.setCustomAtr9("");
		}
		else {
			categoryImpl.setCustomAtr9(customAtr9);
		}

		if (customAtr10 == null) {
			categoryImpl.setCustomAtr10("");
		}
		else {
			categoryImpl.setCustomAtr10(customAtr10);
		}

		categoryImpl.setCreatedBy(createdBy);
		categoryImpl.setModifiedBy(modifiedBy);

		if (ipAddress == null) {
			categoryImpl.setIpAddress("");
		}
		else {
			categoryImpl.setIpAddress(ipAddress);
		}

		categoryImpl.setIsActive(isActive);
		categoryImpl.setDownForSeller(downForSeller);
		categoryImpl.setDownForBuyer(downForBuyer);
		categoryImpl.setDownForMaintenance(downForMaintenance);
		categoryImpl.setCompanyId(companyId);
		categoryImpl.setUserId(userId);

		if (userName == null) {
			categoryImpl.setUserName("");
		}
		else {
			categoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryImpl.setCreateDate(null);
		}
		else {
			categoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		categoryImpl.setStatus(status);
		categoryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			categoryImpl.setStatusByUserName("");
		}
		else {
			categoryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			categoryImpl.setStatusDate(null);
		}
		else {
			categoryImpl.setStatusDate(new Date(statusDate));
		}

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		categoryId = objectInput.readLong();

		parentCategoryId = objectInput.readLong();

		assetCategoryId = objectInput.readLong();

		groupId = objectInput.readLong();
		categoryName = objectInput.readUTF();
		categoryCode = objectInput.readUTF();
		categoryDescription = objectInput.readUTF();
		categoryType = objectInput.readUTF();

		assignManager = objectInput.readLong();

		assignReviewer = objectInput.readLong();
		categoryApprovalStatus = objectInput.readUTF();
		reviewerRemarks = objectInput.readUTF();
		categoryExpiryDate = objectInput.readLong();

		categoryInactive = objectInput.readBoolean();
		externalReferenceId = objectInput.readUTF();

		categoryImageId = objectInput.readLong();
		categoryImageURL = objectInput.readUTF();
		managerRemarks = objectInput.readUTF();
		treePath = objectInput.readUTF();
		termsCondition = objectInput.readUTF();

		hasChild = objectInput.readBoolean();
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

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		ipAddress = objectInput.readUTF();

		isActive = objectInput.readBoolean();

		downForSeller = objectInput.readBoolean();

		downForBuyer = objectInput.readBoolean();

		downForMaintenance = objectInput.readBoolean();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

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

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(parentCategoryId);

		objectOutput.writeLong(assetCategoryId);

		objectOutput.writeLong(groupId);

		if (categoryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		if (categoryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryCode);
		}

		if (categoryDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryDescription);
		}

		if (categoryType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryType);
		}

		objectOutput.writeLong(assignManager);

		objectOutput.writeLong(assignReviewer);

		if (categoryApprovalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryApprovalStatus);
		}

		if (reviewerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewerRemarks);
		}

		objectOutput.writeLong(categoryExpiryDate);

		objectOutput.writeBoolean(categoryInactive);

		if (externalReferenceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceId);
		}

		objectOutput.writeLong(categoryImageId);

		if (categoryImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryImageURL);
		}

		if (managerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managerRemarks);
		}

		if (treePath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(treePath);
		}

		if (termsCondition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(termsCondition);
		}

		objectOutput.writeBoolean(hasChild);

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

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

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
	public long categoryId;
	public long parentCategoryId;
	public long assetCategoryId;
	public long groupId;
	public String categoryName;
	public String categoryCode;
	public String categoryDescription;
	public String categoryType;
	public long assignManager;
	public long assignReviewer;
	public String categoryApprovalStatus;
	public String reviewerRemarks;
	public long categoryExpiryDate;
	public boolean categoryInactive;
	public String externalReferenceId;
	public long categoryImageId;
	public String categoryImageURL;
	public String managerRemarks;
	public String treePath;
	public String termsCondition;
	public boolean hasChild;
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
	public long createdBy;
	public long modifiedBy;
	public String ipAddress;
	public boolean isActive;
	public boolean downForSeller;
	public boolean downForBuyer;
	public boolean downForMaintenance;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}