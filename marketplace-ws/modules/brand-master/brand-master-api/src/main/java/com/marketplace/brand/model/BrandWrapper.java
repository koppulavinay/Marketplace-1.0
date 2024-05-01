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

package com.marketplace.brand.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Brand}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Brand
 * @generated
 */
public class BrandWrapper
	extends BaseModelWrapper<Brand> implements Brand, ModelWrapper<Brand> {

	public BrandWrapper(Brand brand) {
		super(brand);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("brandId", getBrandId());
		attributes.put("groupId", getGroupId());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("brandCode", getBrandCode());
		attributes.put("brandName", getBrandName());
		attributes.put("brandDescription", getBrandDescription());
		attributes.put("brandOwner", getBrandOwner());
		attributes.put("brandReviewer", getBrandReviewer());
		attributes.put("brandType", getBrandType());
		attributes.put("externalReferenceId", getExternalReferenceId());
		attributes.put("brandApprovalStatus", getBrandApprovalStatus());
		attributes.put("reviewerRemarks", getReviewerRemarks());
		attributes.put("brandInactive", getBrandInactive());
		attributes.put("brandImageUpload", getBrandImageUpload());
		attributes.put("brandImageURL", getBrandImageURL());
		attributes.put("managerRemarks", getManagerRemarks());
		attributes.put("customAtr1", getCustomAtr1());
		attributes.put("customAtr2", getCustomAtr2());
		attributes.put("customAtr3", getCustomAtr3());
		attributes.put("customAtr4", getCustomAtr4());
		attributes.put("customAtr5", getCustomAtr5());
		attributes.put("customAtr6", getCustomAtr6());
		attributes.put("customAtr7", getCustomAtr7());
		attributes.put("customAtr8", getCustomAtr8());
		attributes.put("customAtr9", getCustomAtr9());
		attributes.put("customAtr10", getCustomAtr10());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("isActive", getIsActive());
		attributes.put("downForSeller", getDownForSeller());
		attributes.put("downForBuyer", getDownForBuyer());
		attributes.put("downForMaintenance", getDownForMaintenance());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		String brandCode = (String)attributes.get("brandCode");

		if (brandCode != null) {
			setBrandCode(brandCode);
		}

		String brandName = (String)attributes.get("brandName");

		if (brandName != null) {
			setBrandName(brandName);
		}

		String brandDescription = (String)attributes.get("brandDescription");

		if (brandDescription != null) {
			setBrandDescription(brandDescription);
		}

		String brandOwner = (String)attributes.get("brandOwner");

		if (brandOwner != null) {
			setBrandOwner(brandOwner);
		}

		Long brandReviewer = (Long)attributes.get("brandReviewer");

		if (brandReviewer != null) {
			setBrandReviewer(brandReviewer);
		}

		String brandType = (String)attributes.get("brandType");

		if (brandType != null) {
			setBrandType(brandType);
		}

		String externalReferenceId = (String)attributes.get(
			"externalReferenceId");

		if (externalReferenceId != null) {
			setExternalReferenceId(externalReferenceId);
		}

		String brandApprovalStatus = (String)attributes.get(
			"brandApprovalStatus");

		if (brandApprovalStatus != null) {
			setBrandApprovalStatus(brandApprovalStatus);
		}

		String reviewerRemarks = (String)attributes.get("reviewerRemarks");

		if (reviewerRemarks != null) {
			setReviewerRemarks(reviewerRemarks);
		}

		Boolean brandInactive = (Boolean)attributes.get("brandInactive");

		if (brandInactive != null) {
			setBrandInactive(brandInactive);
		}

		Long brandImageUpload = (Long)attributes.get("brandImageUpload");

		if (brandImageUpload != null) {
			setBrandImageUpload(brandImageUpload);
		}

		String brandImageURL = (String)attributes.get("brandImageURL");

		if (brandImageURL != null) {
			setBrandImageURL(brandImageURL);
		}

		String managerRemarks = (String)attributes.get("managerRemarks");

		if (managerRemarks != null) {
			setManagerRemarks(managerRemarks);
		}

		String customAtr1 = (String)attributes.get("customAtr1");

		if (customAtr1 != null) {
			setCustomAtr1(customAtr1);
		}

		String customAtr2 = (String)attributes.get("customAtr2");

		if (customAtr2 != null) {
			setCustomAtr2(customAtr2);
		}

		String customAtr3 = (String)attributes.get("customAtr3");

		if (customAtr3 != null) {
			setCustomAtr3(customAtr3);
		}

		String customAtr4 = (String)attributes.get("customAtr4");

		if (customAtr4 != null) {
			setCustomAtr4(customAtr4);
		}

		String customAtr5 = (String)attributes.get("customAtr5");

		if (customAtr5 != null) {
			setCustomAtr5(customAtr5);
		}

		String customAtr6 = (String)attributes.get("customAtr6");

		if (customAtr6 != null) {
			setCustomAtr6(customAtr6);
		}

		String customAtr7 = (String)attributes.get("customAtr7");

		if (customAtr7 != null) {
			setCustomAtr7(customAtr7);
		}

		String customAtr8 = (String)attributes.get("customAtr8");

		if (customAtr8 != null) {
			setCustomAtr8(customAtr8);
		}

		String customAtr9 = (String)attributes.get("customAtr9");

		if (customAtr9 != null) {
			setCustomAtr9(customAtr9);
		}

		String customAtr10 = (String)attributes.get("customAtr10");

		if (customAtr10 != null) {
			setCustomAtr10(customAtr10);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Boolean downForSeller = (Boolean)attributes.get("downForSeller");

		if (downForSeller != null) {
			setDownForSeller(downForSeller);
		}

		Boolean downForBuyer = (Boolean)attributes.get("downForBuyer");

		if (downForBuyer != null) {
			setDownForBuyer(downForBuyer);
		}

		Boolean downForMaintenance = (Boolean)attributes.get(
			"downForMaintenance");

		if (downForMaintenance != null) {
			setDownForMaintenance(downForMaintenance);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public Brand cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the asset category ID of this brand.
	 *
	 * @return the asset category ID of this brand
	 */
	@Override
	public long getAssetCategoryId() {
		return model.getAssetCategoryId();
	}

	/**
	 * Returns the brand approval status of this brand.
	 *
	 * @return the brand approval status of this brand
	 */
	@Override
	public String getBrandApprovalStatus() {
		return model.getBrandApprovalStatus();
	}

	/**
	 * Returns the brand code of this brand.
	 *
	 * @return the brand code of this brand
	 */
	@Override
	public String getBrandCode() {
		return model.getBrandCode();
	}

	/**
	 * Returns the brand description of this brand.
	 *
	 * @return the brand description of this brand
	 */
	@Override
	public String getBrandDescription() {
		return model.getBrandDescription();
	}

	/**
	 * Returns the brand ID of this brand.
	 *
	 * @return the brand ID of this brand
	 */
	@Override
	public long getBrandId() {
		return model.getBrandId();
	}

	/**
	 * Returns the brand image upload of this brand.
	 *
	 * @return the brand image upload of this brand
	 */
	@Override
	public long getBrandImageUpload() {
		return model.getBrandImageUpload();
	}

	/**
	 * Returns the brand image url of this brand.
	 *
	 * @return the brand image url of this brand
	 */
	@Override
	public String getBrandImageURL() {
		return model.getBrandImageURL();
	}

	/**
	 * Returns the brand inactive of this brand.
	 *
	 * @return the brand inactive of this brand
	 */
	@Override
	public Boolean getBrandInactive() {
		return model.getBrandInactive();
	}

	/**
	 * Returns the brand name of this brand.
	 *
	 * @return the brand name of this brand
	 */
	@Override
	public String getBrandName() {
		return model.getBrandName();
	}

	/**
	 * Returns the brand owner of this brand.
	 *
	 * @return the brand owner of this brand
	 */
	@Override
	public String getBrandOwner() {
		return model.getBrandOwner();
	}

	/**
	 * Returns the brand reviewer of this brand.
	 *
	 * @return the brand reviewer of this brand
	 */
	@Override
	public long getBrandReviewer() {
		return model.getBrandReviewer();
	}

	/**
	 * Returns the brand type of this brand.
	 *
	 * @return the brand type of this brand
	 */
	@Override
	public String getBrandType() {
		return model.getBrandType();
	}

	/**
	 * Returns the company ID of this brand.
	 *
	 * @return the company ID of this brand
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this brand.
	 *
	 * @return the create date of this brand
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this brand.
	 *
	 * @return the created by of this brand
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the custom atr1 of this brand.
	 *
	 * @return the custom atr1 of this brand
	 */
	@Override
	public String getCustomAtr1() {
		return model.getCustomAtr1();
	}

	/**
	 * Returns the custom atr10 of this brand.
	 *
	 * @return the custom atr10 of this brand
	 */
	@Override
	public String getCustomAtr10() {
		return model.getCustomAtr10();
	}

	/**
	 * Returns the custom atr2 of this brand.
	 *
	 * @return the custom atr2 of this brand
	 */
	@Override
	public String getCustomAtr2() {
		return model.getCustomAtr2();
	}

	/**
	 * Returns the custom atr3 of this brand.
	 *
	 * @return the custom atr3 of this brand
	 */
	@Override
	public String getCustomAtr3() {
		return model.getCustomAtr3();
	}

	/**
	 * Returns the custom atr4 of this brand.
	 *
	 * @return the custom atr4 of this brand
	 */
	@Override
	public String getCustomAtr4() {
		return model.getCustomAtr4();
	}

	/**
	 * Returns the custom atr5 of this brand.
	 *
	 * @return the custom atr5 of this brand
	 */
	@Override
	public String getCustomAtr5() {
		return model.getCustomAtr5();
	}

	/**
	 * Returns the custom atr6 of this brand.
	 *
	 * @return the custom atr6 of this brand
	 */
	@Override
	public String getCustomAtr6() {
		return model.getCustomAtr6();
	}

	/**
	 * Returns the custom atr7 of this brand.
	 *
	 * @return the custom atr7 of this brand
	 */
	@Override
	public String getCustomAtr7() {
		return model.getCustomAtr7();
	}

	/**
	 * Returns the custom atr8 of this brand.
	 *
	 * @return the custom atr8 of this brand
	 */
	@Override
	public String getCustomAtr8() {
		return model.getCustomAtr8();
	}

	/**
	 * Returns the custom atr9 of this brand.
	 *
	 * @return the custom atr9 of this brand
	 */
	@Override
	public String getCustomAtr9() {
		return model.getCustomAtr9();
	}

	/**
	 * Returns the down for buyer of this brand.
	 *
	 * @return the down for buyer of this brand
	 */
	@Override
	public Boolean getDownForBuyer() {
		return model.getDownForBuyer();
	}

	/**
	 * Returns the down for maintenance of this brand.
	 *
	 * @return the down for maintenance of this brand
	 */
	@Override
	public Boolean getDownForMaintenance() {
		return model.getDownForMaintenance();
	}

	/**
	 * Returns the down for seller of this brand.
	 *
	 * @return the down for seller of this brand
	 */
	@Override
	public Boolean getDownForSeller() {
		return model.getDownForSeller();
	}

	/**
	 * Returns the external reference ID of this brand.
	 *
	 * @return the external reference ID of this brand
	 */
	@Override
	public String getExternalReferenceId() {
		return model.getExternalReferenceId();
	}

	/**
	 * Returns the group ID of this brand.
	 *
	 * @return the group ID of this brand
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this brand.
	 *
	 * @return the ip address of this brand
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the is active of this brand.
	 *
	 * @return the is active of this brand
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the manager remarks of this brand.
	 *
	 * @return the manager remarks of this brand
	 */
	@Override
	public String getManagerRemarks() {
		return model.getManagerRemarks();
	}

	/**
	 * Returns the modified by of this brand.
	 *
	 * @return the modified by of this brand
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this brand.
	 *
	 * @return the modified date of this brand
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this brand.
	 *
	 * @return the primary key of this brand
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reviewer remarks of this brand.
	 *
	 * @return the reviewer remarks of this brand
	 */
	@Override
	public String getReviewerRemarks() {
		return model.getReviewerRemarks();
	}

	/**
	 * Returns the status of this brand.
	 *
	 * @return the status of this brand
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this brand.
	 *
	 * @return the status by user ID of this brand
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this brand.
	 *
	 * @return the status by user name of this brand
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this brand.
	 *
	 * @return the status by user uuid of this brand
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this brand.
	 *
	 * @return the status date of this brand
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this brand.
	 *
	 * @return the user ID of this brand
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this brand.
	 *
	 * @return the user name of this brand
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this brand.
	 *
	 * @return the user uuid of this brand
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this brand.
	 *
	 * @return the uuid of this brand
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this brand is approved.
	 *
	 * @return <code>true</code> if this brand is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this brand is denied.
	 *
	 * @return <code>true</code> if this brand is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this brand is a draft.
	 *
	 * @return <code>true</code> if this brand is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this brand is expired.
	 *
	 * @return <code>true</code> if this brand is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this brand is inactive.
	 *
	 * @return <code>true</code> if this brand is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this brand is incomplete.
	 *
	 * @return <code>true</code> if this brand is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this brand is pending.
	 *
	 * @return <code>true</code> if this brand is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this brand is scheduled.
	 *
	 * @return <code>true</code> if this brand is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the asset category ID of this brand.
	 *
	 * @param assetCategoryId the asset category ID of this brand
	 */
	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		model.setAssetCategoryId(assetCategoryId);
	}

	/**
	 * Sets the brand approval status of this brand.
	 *
	 * @param brandApprovalStatus the brand approval status of this brand
	 */
	@Override
	public void setBrandApprovalStatus(String brandApprovalStatus) {
		model.setBrandApprovalStatus(brandApprovalStatus);
	}

	/**
	 * Sets the brand code of this brand.
	 *
	 * @param brandCode the brand code of this brand
	 */
	@Override
	public void setBrandCode(String brandCode) {
		model.setBrandCode(brandCode);
	}

	/**
	 * Sets the brand description of this brand.
	 *
	 * @param brandDescription the brand description of this brand
	 */
	@Override
	public void setBrandDescription(String brandDescription) {
		model.setBrandDescription(brandDescription);
	}

	/**
	 * Sets the brand ID of this brand.
	 *
	 * @param brandId the brand ID of this brand
	 */
	@Override
	public void setBrandId(long brandId) {
		model.setBrandId(brandId);
	}

	/**
	 * Sets the brand image upload of this brand.
	 *
	 * @param brandImageUpload the brand image upload of this brand
	 */
	@Override
	public void setBrandImageUpload(long brandImageUpload) {
		model.setBrandImageUpload(brandImageUpload);
	}

	/**
	 * Sets the brand image url of this brand.
	 *
	 * @param brandImageURL the brand image url of this brand
	 */
	@Override
	public void setBrandImageURL(String brandImageURL) {
		model.setBrandImageURL(brandImageURL);
	}

	/**
	 * Sets the brand inactive of this brand.
	 *
	 * @param brandInactive the brand inactive of this brand
	 */
	@Override
	public void setBrandInactive(Boolean brandInactive) {
		model.setBrandInactive(brandInactive);
	}

	/**
	 * Sets the brand name of this brand.
	 *
	 * @param brandName the brand name of this brand
	 */
	@Override
	public void setBrandName(String brandName) {
		model.setBrandName(brandName);
	}

	/**
	 * Sets the brand owner of this brand.
	 *
	 * @param brandOwner the brand owner of this brand
	 */
	@Override
	public void setBrandOwner(String brandOwner) {
		model.setBrandOwner(brandOwner);
	}

	/**
	 * Sets the brand reviewer of this brand.
	 *
	 * @param brandReviewer the brand reviewer of this brand
	 */
	@Override
	public void setBrandReviewer(long brandReviewer) {
		model.setBrandReviewer(brandReviewer);
	}

	/**
	 * Sets the brand type of this brand.
	 *
	 * @param brandType the brand type of this brand
	 */
	@Override
	public void setBrandType(String brandType) {
		model.setBrandType(brandType);
	}

	/**
	 * Sets the company ID of this brand.
	 *
	 * @param companyId the company ID of this brand
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this brand.
	 *
	 * @param createDate the create date of this brand
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this brand.
	 *
	 * @param createdBy the created by of this brand
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the custom atr1 of this brand.
	 *
	 * @param customAtr1 the custom atr1 of this brand
	 */
	@Override
	public void setCustomAtr1(String customAtr1) {
		model.setCustomAtr1(customAtr1);
	}

	/**
	 * Sets the custom atr10 of this brand.
	 *
	 * @param customAtr10 the custom atr10 of this brand
	 */
	@Override
	public void setCustomAtr10(String customAtr10) {
		model.setCustomAtr10(customAtr10);
	}

	/**
	 * Sets the custom atr2 of this brand.
	 *
	 * @param customAtr2 the custom atr2 of this brand
	 */
	@Override
	public void setCustomAtr2(String customAtr2) {
		model.setCustomAtr2(customAtr2);
	}

	/**
	 * Sets the custom atr3 of this brand.
	 *
	 * @param customAtr3 the custom atr3 of this brand
	 */
	@Override
	public void setCustomAtr3(String customAtr3) {
		model.setCustomAtr3(customAtr3);
	}

	/**
	 * Sets the custom atr4 of this brand.
	 *
	 * @param customAtr4 the custom atr4 of this brand
	 */
	@Override
	public void setCustomAtr4(String customAtr4) {
		model.setCustomAtr4(customAtr4);
	}

	/**
	 * Sets the custom atr5 of this brand.
	 *
	 * @param customAtr5 the custom atr5 of this brand
	 */
	@Override
	public void setCustomAtr5(String customAtr5) {
		model.setCustomAtr5(customAtr5);
	}

	/**
	 * Sets the custom atr6 of this brand.
	 *
	 * @param customAtr6 the custom atr6 of this brand
	 */
	@Override
	public void setCustomAtr6(String customAtr6) {
		model.setCustomAtr6(customAtr6);
	}

	/**
	 * Sets the custom atr7 of this brand.
	 *
	 * @param customAtr7 the custom atr7 of this brand
	 */
	@Override
	public void setCustomAtr7(String customAtr7) {
		model.setCustomAtr7(customAtr7);
	}

	/**
	 * Sets the custom atr8 of this brand.
	 *
	 * @param customAtr8 the custom atr8 of this brand
	 */
	@Override
	public void setCustomAtr8(String customAtr8) {
		model.setCustomAtr8(customAtr8);
	}

	/**
	 * Sets the custom atr9 of this brand.
	 *
	 * @param customAtr9 the custom atr9 of this brand
	 */
	@Override
	public void setCustomAtr9(String customAtr9) {
		model.setCustomAtr9(customAtr9);
	}

	/**
	 * Sets the down for buyer of this brand.
	 *
	 * @param downForBuyer the down for buyer of this brand
	 */
	@Override
	public void setDownForBuyer(Boolean downForBuyer) {
		model.setDownForBuyer(downForBuyer);
	}

	/**
	 * Sets the down for maintenance of this brand.
	 *
	 * @param downForMaintenance the down for maintenance of this brand
	 */
	@Override
	public void setDownForMaintenance(Boolean downForMaintenance) {
		model.setDownForMaintenance(downForMaintenance);
	}

	/**
	 * Sets the down for seller of this brand.
	 *
	 * @param downForSeller the down for seller of this brand
	 */
	@Override
	public void setDownForSeller(Boolean downForSeller) {
		model.setDownForSeller(downForSeller);
	}

	/**
	 * Sets the external reference ID of this brand.
	 *
	 * @param externalReferenceId the external reference ID of this brand
	 */
	@Override
	public void setExternalReferenceId(String externalReferenceId) {
		model.setExternalReferenceId(externalReferenceId);
	}

	/**
	 * Sets the group ID of this brand.
	 *
	 * @param groupId the group ID of this brand
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this brand.
	 *
	 * @param ipAddress the ip address of this brand
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the is active of this brand.
	 *
	 * @param isActive the is active of this brand
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the manager remarks of this brand.
	 *
	 * @param managerRemarks the manager remarks of this brand
	 */
	@Override
	public void setManagerRemarks(String managerRemarks) {
		model.setManagerRemarks(managerRemarks);
	}

	/**
	 * Sets the modified by of this brand.
	 *
	 * @param modifiedBy the modified by of this brand
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this brand.
	 *
	 * @param modifiedDate the modified date of this brand
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this brand.
	 *
	 * @param primaryKey the primary key of this brand
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reviewer remarks of this brand.
	 *
	 * @param reviewerRemarks the reviewer remarks of this brand
	 */
	@Override
	public void setReviewerRemarks(String reviewerRemarks) {
		model.setReviewerRemarks(reviewerRemarks);
	}

	/**
	 * Sets the status of this brand.
	 *
	 * @param status the status of this brand
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this brand.
	 *
	 * @param statusByUserId the status by user ID of this brand
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this brand.
	 *
	 * @param statusByUserName the status by user name of this brand
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this brand.
	 *
	 * @param statusByUserUuid the status by user uuid of this brand
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this brand.
	 *
	 * @param statusDate the status date of this brand
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this brand.
	 *
	 * @param userId the user ID of this brand
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this brand.
	 *
	 * @param userName the user name of this brand
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this brand.
	 *
	 * @param userUuid the user uuid of this brand
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this brand.
	 *
	 * @param uuid the uuid of this brand
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
	protected BrandWrapper wrap(Brand brand) {
		return new BrandWrapper(brand);
	}

}