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

package com.marketplace.category.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
public class CategoryWrapper
	extends BaseModelWrapper<Category>
	implements Category, ModelWrapper<Category> {

	public CategoryWrapper(Category category) {
		super(category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("categoryId", getCategoryId());
		attributes.put("parentCategoryId", getParentCategoryId());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryCode", getCategoryCode());
		attributes.put("categoryDescription", getCategoryDescription());
		attributes.put("categoryType", getCategoryType());
		attributes.put("assignManager", getAssignManager());
		attributes.put("assignReviewer", getAssignReviewer());
		attributes.put("categoryApprovalStatus", getCategoryApprovalStatus());
		attributes.put("reviewerRemarks", getReviewerRemarks());
		attributes.put("categoryExpiryDate", getCategoryExpiryDate());
		attributes.put("categoryInactive", getCategoryInactive());
		attributes.put("externalReferenceId", getExternalReferenceId());
		attributes.put("categoryImageId", getCategoryImageId());
		attributes.put("categoryImageURL", getCategoryImageURL());
		attributes.put("managerRemarks", getManagerRemarks());
		attributes.put("treePath", getTreePath());
		attributes.put("termsCondition", getTermsCondition());
		attributes.put("hasChild", getHasChild());
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
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("isActive", getIsActive());
		attributes.put("downForSeller", getDownForSeller());
		attributes.put("downForBuyer", getDownForBuyer());
		attributes.put("downForMaintenance", getDownForMaintenance());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryCode = (String)attributes.get("categoryCode");

		if (categoryCode != null) {
			setCategoryCode(categoryCode);
		}

		String categoryDescription = (String)attributes.get(
			"categoryDescription");

		if (categoryDescription != null) {
			setCategoryDescription(categoryDescription);
		}

		String categoryType = (String)attributes.get("categoryType");

		if (categoryType != null) {
			setCategoryType(categoryType);
		}

		Long assignManager = (Long)attributes.get("assignManager");

		if (assignManager != null) {
			setAssignManager(assignManager);
		}

		Long assignReviewer = (Long)attributes.get("assignReviewer");

		if (assignReviewer != null) {
			setAssignReviewer(assignReviewer);
		}

		String categoryApprovalStatus = (String)attributes.get(
			"categoryApprovalStatus");

		if (categoryApprovalStatus != null) {
			setCategoryApprovalStatus(categoryApprovalStatus);
		}

		String reviewerRemarks = (String)attributes.get("reviewerRemarks");

		if (reviewerRemarks != null) {
			setReviewerRemarks(reviewerRemarks);
		}

		Date categoryExpiryDate = (Date)attributes.get("categoryExpiryDate");

		if (categoryExpiryDate != null) {
			setCategoryExpiryDate(categoryExpiryDate);
		}

		Boolean categoryInactive = (Boolean)attributes.get("categoryInactive");

		if (categoryInactive != null) {
			setCategoryInactive(categoryInactive);
		}

		String externalReferenceId = (String)attributes.get(
			"externalReferenceId");

		if (externalReferenceId != null) {
			setExternalReferenceId(externalReferenceId);
		}

		Long categoryImageId = (Long)attributes.get("categoryImageId");

		if (categoryImageId != null) {
			setCategoryImageId(categoryImageId);
		}

		String categoryImageURL = (String)attributes.get("categoryImageURL");

		if (categoryImageURL != null) {
			setCategoryImageURL(categoryImageURL);
		}

		String managerRemarks = (String)attributes.get("managerRemarks");

		if (managerRemarks != null) {
			setManagerRemarks(managerRemarks);
		}

		String treePath = (String)attributes.get("treePath");

		if (treePath != null) {
			setTreePath(treePath);
		}

		String termsCondition = (String)attributes.get("termsCondition");

		if (termsCondition != null) {
			setTermsCondition(termsCondition);
		}

		Boolean hasChild = (Boolean)attributes.get("hasChild");

		if (hasChild != null) {
			setHasChild(hasChild);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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
	public String buildTreePath()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.buildTreePath();
	}

	@Override
	public Category cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the asset category ID of this category.
	 *
	 * @return the asset category ID of this category
	 */
	@Override
	public long getAssetCategoryId() {
		return model.getAssetCategoryId();
	}

	/**
	 * Returns the assign manager of this category.
	 *
	 * @return the assign manager of this category
	 */
	@Override
	public long getAssignManager() {
		return model.getAssignManager();
	}

	/**
	 * Returns the assign reviewer of this category.
	 *
	 * @return the assign reviewer of this category
	 */
	@Override
	public long getAssignReviewer() {
		return model.getAssignReviewer();
	}

	/**
	 * Returns the category approval status of this category.
	 *
	 * @return the category approval status of this category
	 */
	@Override
	public String getCategoryApprovalStatus() {
		return model.getCategoryApprovalStatus();
	}

	/**
	 * Returns the category code of this category.
	 *
	 * @return the category code of this category
	 */
	@Override
	public String getCategoryCode() {
		return model.getCategoryCode();
	}

	/**
	 * Returns the category description of this category.
	 *
	 * @return the category description of this category
	 */
	@Override
	public String getCategoryDescription() {
		return model.getCategoryDescription();
	}

	/**
	 * Returns the category expiry date of this category.
	 *
	 * @return the category expiry date of this category
	 */
	@Override
	public Date getCategoryExpiryDate() {
		return model.getCategoryExpiryDate();
	}

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the category image ID of this category.
	 *
	 * @return the category image ID of this category
	 */
	@Override
	public long getCategoryImageId() {
		return model.getCategoryImageId();
	}

	/**
	 * Returns the category image url of this category.
	 *
	 * @return the category image url of this category
	 */
	@Override
	public String getCategoryImageURL() {
		return model.getCategoryImageURL();
	}

	/**
	 * Returns the category inactive of this category.
	 *
	 * @return the category inactive of this category
	 */
	@Override
	public Boolean getCategoryInactive() {
		return model.getCategoryInactive();
	}

	/**
	 * Returns the category name of this category.
	 *
	 * @return the category name of this category
	 */
	@Override
	public String getCategoryName() {
		return model.getCategoryName();
	}

	/**
	 * Returns the category type of this category.
	 *
	 * @return the category type of this category
	 */
	@Override
	public String getCategoryType() {
		return model.getCategoryType();
	}

	/**
	 * Returns the company ID of this category.
	 *
	 * @return the company ID of this category
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this category.
	 *
	 * @return the create date of this category
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this category.
	 *
	 * @return the created by of this category
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the custom atr1 of this category.
	 *
	 * @return the custom atr1 of this category
	 */
	@Override
	public String getCustomAtr1() {
		return model.getCustomAtr1();
	}

	/**
	 * Returns the custom atr10 of this category.
	 *
	 * @return the custom atr10 of this category
	 */
	@Override
	public String getCustomAtr10() {
		return model.getCustomAtr10();
	}

	/**
	 * Returns the custom atr2 of this category.
	 *
	 * @return the custom atr2 of this category
	 */
	@Override
	public String getCustomAtr2() {
		return model.getCustomAtr2();
	}

	/**
	 * Returns the custom atr3 of this category.
	 *
	 * @return the custom atr3 of this category
	 */
	@Override
	public String getCustomAtr3() {
		return model.getCustomAtr3();
	}

	/**
	 * Returns the custom atr4 of this category.
	 *
	 * @return the custom atr4 of this category
	 */
	@Override
	public String getCustomAtr4() {
		return model.getCustomAtr4();
	}

	/**
	 * Returns the custom atr5 of this category.
	 *
	 * @return the custom atr5 of this category
	 */
	@Override
	public String getCustomAtr5() {
		return model.getCustomAtr5();
	}

	/**
	 * Returns the custom atr6 of this category.
	 *
	 * @return the custom atr6 of this category
	 */
	@Override
	public String getCustomAtr6() {
		return model.getCustomAtr6();
	}

	/**
	 * Returns the custom atr7 of this category.
	 *
	 * @return the custom atr7 of this category
	 */
	@Override
	public String getCustomAtr7() {
		return model.getCustomAtr7();
	}

	/**
	 * Returns the custom atr8 of this category.
	 *
	 * @return the custom atr8 of this category
	 */
	@Override
	public String getCustomAtr8() {
		return model.getCustomAtr8();
	}

	/**
	 * Returns the custom atr9 of this category.
	 *
	 * @return the custom atr9 of this category
	 */
	@Override
	public String getCustomAtr9() {
		return model.getCustomAtr9();
	}

	/**
	 * Returns the down for buyer of this category.
	 *
	 * @return the down for buyer of this category
	 */
	@Override
	public Boolean getDownForBuyer() {
		return model.getDownForBuyer();
	}

	/**
	 * Returns the down for maintenance of this category.
	 *
	 * @return the down for maintenance of this category
	 */
	@Override
	public Boolean getDownForMaintenance() {
		return model.getDownForMaintenance();
	}

	/**
	 * Returns the down for seller of this category.
	 *
	 * @return the down for seller of this category
	 */
	@Override
	public Boolean getDownForSeller() {
		return model.getDownForSeller();
	}

	/**
	 * Returns the external reference ID of this category.
	 *
	 * @return the external reference ID of this category
	 */
	@Override
	public String getExternalReferenceId() {
		return model.getExternalReferenceId();
	}

	/**
	 * Returns the group ID of this category.
	 *
	 * @return the group ID of this category
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has child of this category.
	 *
	 * @return the has child of this category
	 */
	@Override
	public Boolean getHasChild() {
		return model.getHasChild();
	}

	/**
	 * Returns the ip address of this category.
	 *
	 * @return the ip address of this category
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the is active of this category.
	 *
	 * @return the is active of this category
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the manager remarks of this category.
	 *
	 * @return the manager remarks of this category
	 */
	@Override
	public String getManagerRemarks() {
		return model.getManagerRemarks();
	}

	/**
	 * Returns the modified by of this category.
	 *
	 * @return the modified by of this category
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parent category ID of this category.
	 *
	 * @return the parent category ID of this category
	 */
	@Override
	public long getParentCategoryId() {
		return model.getParentCategoryId();
	}

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reviewer remarks of this category.
	 *
	 * @return the reviewer remarks of this category
	 */
	@Override
	public String getReviewerRemarks() {
		return model.getReviewerRemarks();
	}

	/**
	 * Returns the status of this category.
	 *
	 * @return the status of this category
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this category.
	 *
	 * @return the status by user ID of this category
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this category.
	 *
	 * @return the status by user name of this category
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this category.
	 *
	 * @return the status by user uuid of this category
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this category.
	 *
	 * @return the status date of this category
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the terms condition of this category.
	 *
	 * @return the terms condition of this category
	 */
	@Override
	public String getTermsCondition() {
		return model.getTermsCondition();
	}

	/**
	 * Returns the tree path of this category.
	 *
	 * @return the tree path of this category
	 */
	@Override
	public String getTreePath() {
		return model.getTreePath();
	}

	/**
	 * Returns the user ID of this category.
	 *
	 * @return the user ID of this category
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this category.
	 *
	 * @return the user name of this category
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this category.
	 *
	 * @return the user uuid of this category
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this category.
	 *
	 * @return the uuid of this category
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this category is approved.
	 *
	 * @return <code>true</code> if this category is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this category is denied.
	 *
	 * @return <code>true</code> if this category is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this category is a draft.
	 *
	 * @return <code>true</code> if this category is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this category is expired.
	 *
	 * @return <code>true</code> if this category is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this category is inactive.
	 *
	 * @return <code>true</code> if this category is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this category is incomplete.
	 *
	 * @return <code>true</code> if this category is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this category is pending.
	 *
	 * @return <code>true</code> if this category is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this category is scheduled.
	 *
	 * @return <code>true</code> if this category is scheduled; <code>false</code> otherwise
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
	 * Sets the asset category ID of this category.
	 *
	 * @param assetCategoryId the asset category ID of this category
	 */
	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		model.setAssetCategoryId(assetCategoryId);
	}

	/**
	 * Sets the assign manager of this category.
	 *
	 * @param assignManager the assign manager of this category
	 */
	@Override
	public void setAssignManager(long assignManager) {
		model.setAssignManager(assignManager);
	}

	/**
	 * Sets the assign reviewer of this category.
	 *
	 * @param assignReviewer the assign reviewer of this category
	 */
	@Override
	public void setAssignReviewer(long assignReviewer) {
		model.setAssignReviewer(assignReviewer);
	}

	/**
	 * Sets the category approval status of this category.
	 *
	 * @param categoryApprovalStatus the category approval status of this category
	 */
	@Override
	public void setCategoryApprovalStatus(String categoryApprovalStatus) {
		model.setCategoryApprovalStatus(categoryApprovalStatus);
	}

	/**
	 * Sets the category code of this category.
	 *
	 * @param categoryCode the category code of this category
	 */
	@Override
	public void setCategoryCode(String categoryCode) {
		model.setCategoryCode(categoryCode);
	}

	/**
	 * Sets the category description of this category.
	 *
	 * @param categoryDescription the category description of this category
	 */
	@Override
	public void setCategoryDescription(String categoryDescription) {
		model.setCategoryDescription(categoryDescription);
	}

	/**
	 * Sets the category expiry date of this category.
	 *
	 * @param categoryExpiryDate the category expiry date of this category
	 */
	@Override
	public void setCategoryExpiryDate(Date categoryExpiryDate) {
		model.setCategoryExpiryDate(categoryExpiryDate);
	}

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the category image ID of this category.
	 *
	 * @param categoryImageId the category image ID of this category
	 */
	@Override
	public void setCategoryImageId(long categoryImageId) {
		model.setCategoryImageId(categoryImageId);
	}

	/**
	 * Sets the category image url of this category.
	 *
	 * @param categoryImageURL the category image url of this category
	 */
	@Override
	public void setCategoryImageURL(String categoryImageURL) {
		model.setCategoryImageURL(categoryImageURL);
	}

	/**
	 * Sets the category inactive of this category.
	 *
	 * @param categoryInactive the category inactive of this category
	 */
	@Override
	public void setCategoryInactive(Boolean categoryInactive) {
		model.setCategoryInactive(categoryInactive);
	}

	/**
	 * Sets the category name of this category.
	 *
	 * @param categoryName the category name of this category
	 */
	@Override
	public void setCategoryName(String categoryName) {
		model.setCategoryName(categoryName);
	}

	/**
	 * Sets the category type of this category.
	 *
	 * @param categoryType the category type of this category
	 */
	@Override
	public void setCategoryType(String categoryType) {
		model.setCategoryType(categoryType);
	}

	/**
	 * Sets the company ID of this category.
	 *
	 * @param companyId the company ID of this category
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this category.
	 *
	 * @param createDate the create date of this category
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this category.
	 *
	 * @param createdBy the created by of this category
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the custom atr1 of this category.
	 *
	 * @param customAtr1 the custom atr1 of this category
	 */
	@Override
	public void setCustomAtr1(String customAtr1) {
		model.setCustomAtr1(customAtr1);
	}

	/**
	 * Sets the custom atr10 of this category.
	 *
	 * @param customAtr10 the custom atr10 of this category
	 */
	@Override
	public void setCustomAtr10(String customAtr10) {
		model.setCustomAtr10(customAtr10);
	}

	/**
	 * Sets the custom atr2 of this category.
	 *
	 * @param customAtr2 the custom atr2 of this category
	 */
	@Override
	public void setCustomAtr2(String customAtr2) {
		model.setCustomAtr2(customAtr2);
	}

	/**
	 * Sets the custom atr3 of this category.
	 *
	 * @param customAtr3 the custom atr3 of this category
	 */
	@Override
	public void setCustomAtr3(String customAtr3) {
		model.setCustomAtr3(customAtr3);
	}

	/**
	 * Sets the custom atr4 of this category.
	 *
	 * @param customAtr4 the custom atr4 of this category
	 */
	@Override
	public void setCustomAtr4(String customAtr4) {
		model.setCustomAtr4(customAtr4);
	}

	/**
	 * Sets the custom atr5 of this category.
	 *
	 * @param customAtr5 the custom atr5 of this category
	 */
	@Override
	public void setCustomAtr5(String customAtr5) {
		model.setCustomAtr5(customAtr5);
	}

	/**
	 * Sets the custom atr6 of this category.
	 *
	 * @param customAtr6 the custom atr6 of this category
	 */
	@Override
	public void setCustomAtr6(String customAtr6) {
		model.setCustomAtr6(customAtr6);
	}

	/**
	 * Sets the custom atr7 of this category.
	 *
	 * @param customAtr7 the custom atr7 of this category
	 */
	@Override
	public void setCustomAtr7(String customAtr7) {
		model.setCustomAtr7(customAtr7);
	}

	/**
	 * Sets the custom atr8 of this category.
	 *
	 * @param customAtr8 the custom atr8 of this category
	 */
	@Override
	public void setCustomAtr8(String customAtr8) {
		model.setCustomAtr8(customAtr8);
	}

	/**
	 * Sets the custom atr9 of this category.
	 *
	 * @param customAtr9 the custom atr9 of this category
	 */
	@Override
	public void setCustomAtr9(String customAtr9) {
		model.setCustomAtr9(customAtr9);
	}

	/**
	 * Sets the down for buyer of this category.
	 *
	 * @param downForBuyer the down for buyer of this category
	 */
	@Override
	public void setDownForBuyer(Boolean downForBuyer) {
		model.setDownForBuyer(downForBuyer);
	}

	/**
	 * Sets the down for maintenance of this category.
	 *
	 * @param downForMaintenance the down for maintenance of this category
	 */
	@Override
	public void setDownForMaintenance(Boolean downForMaintenance) {
		model.setDownForMaintenance(downForMaintenance);
	}

	/**
	 * Sets the down for seller of this category.
	 *
	 * @param downForSeller the down for seller of this category
	 */
	@Override
	public void setDownForSeller(Boolean downForSeller) {
		model.setDownForSeller(downForSeller);
	}

	/**
	 * Sets the external reference ID of this category.
	 *
	 * @param externalReferenceId the external reference ID of this category
	 */
	@Override
	public void setExternalReferenceId(String externalReferenceId) {
		model.setExternalReferenceId(externalReferenceId);
	}

	/**
	 * Sets the group ID of this category.
	 *
	 * @param groupId the group ID of this category
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the has child of this category.
	 *
	 * @param hasChild the has child of this category
	 */
	@Override
	public void setHasChild(Boolean hasChild) {
		model.setHasChild(hasChild);
	}

	/**
	 * Sets the ip address of this category.
	 *
	 * @param ipAddress the ip address of this category
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the is active of this category.
	 *
	 * @param isActive the is active of this category
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the manager remarks of this category.
	 *
	 * @param managerRemarks the manager remarks of this category
	 */
	@Override
	public void setManagerRemarks(String managerRemarks) {
		model.setManagerRemarks(managerRemarks);
	}

	/**
	 * Sets the modified by of this category.
	 *
	 * @param modifiedBy the modified by of this category
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent category ID of this category.
	 *
	 * @param parentCategoryId the parent category ID of this category
	 */
	@Override
	public void setParentCategoryId(long parentCategoryId) {
		model.setParentCategoryId(parentCategoryId);
	}

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reviewer remarks of this category.
	 *
	 * @param reviewerRemarks the reviewer remarks of this category
	 */
	@Override
	public void setReviewerRemarks(String reviewerRemarks) {
		model.setReviewerRemarks(reviewerRemarks);
	}

	/**
	 * Sets the status of this category.
	 *
	 * @param status the status of this category
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this category.
	 *
	 * @param statusByUserId the status by user ID of this category
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this category.
	 *
	 * @param statusByUserName the status by user name of this category
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this category.
	 *
	 * @param statusByUserUuid the status by user uuid of this category
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this category.
	 *
	 * @param statusDate the status date of this category
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the terms condition of this category.
	 *
	 * @param termsCondition the terms condition of this category
	 */
	@Override
	public void setTermsCondition(String termsCondition) {
		model.setTermsCondition(termsCondition);
	}

	/**
	 * Sets the tree path of this category.
	 *
	 * @param treePath the tree path of this category
	 */
	@Override
	public void setTreePath(String treePath) {
		model.setTreePath(treePath);
	}

	/**
	 * Sets the user ID of this category.
	 *
	 * @param userId the user ID of this category
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this category.
	 *
	 * @param userName the user name of this category
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this category.
	 *
	 * @param userUuid the user uuid of this category
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this category.
	 *
	 * @param uuid the uuid of this category
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
	public void updateTreePath(String treePath) {
		model.updateTreePath(treePath);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CategoryWrapper wrap(Category category) {
		return new CategoryWrapper(category);
	}

}