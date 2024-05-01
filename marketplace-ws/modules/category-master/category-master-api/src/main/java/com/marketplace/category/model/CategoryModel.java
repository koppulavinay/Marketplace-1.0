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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Category service. Represents a row in the &quot;marketplace_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.marketplace.category.model.impl.CategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.marketplace.category.model.impl.CategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
@ProviderType
public interface CategoryModel
	extends BaseModel<Category>, GroupedModel, ShardedModel, StagedAuditedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this category.
	 *
	 * @return the uuid of this category
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this category.
	 *
	 * @param uuid the uuid of this category
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the parent category ID of this category.
	 *
	 * @return the parent category ID of this category
	 */
	public long getParentCategoryId();

	/**
	 * Sets the parent category ID of this category.
	 *
	 * @param parentCategoryId the parent category ID of this category
	 */
	public void setParentCategoryId(long parentCategoryId);

	/**
	 * Returns the asset category ID of this category.
	 *
	 * @return the asset category ID of this category
	 */
	public long getAssetCategoryId();

	/**
	 * Sets the asset category ID of this category.
	 *
	 * @param assetCategoryId the asset category ID of this category
	 */
	public void setAssetCategoryId(long assetCategoryId);

	/**
	 * Returns the group ID of this category.
	 *
	 * @return the group ID of this category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this category.
	 *
	 * @param groupId the group ID of this category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the category name of this category.
	 *
	 * @return the category name of this category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this category.
	 *
	 * @param categoryName the category name of this category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * Returns the category code of this category.
	 *
	 * @return the category code of this category
	 */
	@AutoEscape
	public String getCategoryCode();

	/**
	 * Sets the category code of this category.
	 *
	 * @param categoryCode the category code of this category
	 */
	public void setCategoryCode(String categoryCode);

	/**
	 * Returns the category description of this category.
	 *
	 * @return the category description of this category
	 */
	@AutoEscape
	public String getCategoryDescription();

	/**
	 * Sets the category description of this category.
	 *
	 * @param categoryDescription the category description of this category
	 */
	public void setCategoryDescription(String categoryDescription);

	/**
	 * Returns the category type of this category.
	 *
	 * @return the category type of this category
	 */
	@AutoEscape
	public String getCategoryType();

	/**
	 * Sets the category type of this category.
	 *
	 * @param categoryType the category type of this category
	 */
	public void setCategoryType(String categoryType);

	/**
	 * Returns the assign manager of this category.
	 *
	 * @return the assign manager of this category
	 */
	public long getAssignManager();

	/**
	 * Sets the assign manager of this category.
	 *
	 * @param assignManager the assign manager of this category
	 */
	public void setAssignManager(long assignManager);

	/**
	 * Returns the assign reviewer of this category.
	 *
	 * @return the assign reviewer of this category
	 */
	public long getAssignReviewer();

	/**
	 * Sets the assign reviewer of this category.
	 *
	 * @param assignReviewer the assign reviewer of this category
	 */
	public void setAssignReviewer(long assignReviewer);

	/**
	 * Returns the category approval status of this category.
	 *
	 * @return the category approval status of this category
	 */
	@AutoEscape
	public String getCategoryApprovalStatus();

	/**
	 * Sets the category approval status of this category.
	 *
	 * @param categoryApprovalStatus the category approval status of this category
	 */
	public void setCategoryApprovalStatus(String categoryApprovalStatus);

	/**
	 * Returns the reviewer remarks of this category.
	 *
	 * @return the reviewer remarks of this category
	 */
	@AutoEscape
	public String getReviewerRemarks();

	/**
	 * Sets the reviewer remarks of this category.
	 *
	 * @param reviewerRemarks the reviewer remarks of this category
	 */
	public void setReviewerRemarks(String reviewerRemarks);

	/**
	 * Returns the category expiry date of this category.
	 *
	 * @return the category expiry date of this category
	 */
	public Date getCategoryExpiryDate();

	/**
	 * Sets the category expiry date of this category.
	 *
	 * @param categoryExpiryDate the category expiry date of this category
	 */
	public void setCategoryExpiryDate(Date categoryExpiryDate);

	/**
	 * Returns the category inactive of this category.
	 *
	 * @return the category inactive of this category
	 */
	public Boolean getCategoryInactive();

	/**
	 * Sets the category inactive of this category.
	 *
	 * @param categoryInactive the category inactive of this category
	 */
	public void setCategoryInactive(Boolean categoryInactive);

	/**
	 * Returns the external reference ID of this category.
	 *
	 * @return the external reference ID of this category
	 */
	@AutoEscape
	public String getExternalReferenceId();

	/**
	 * Sets the external reference ID of this category.
	 *
	 * @param externalReferenceId the external reference ID of this category
	 */
	public void setExternalReferenceId(String externalReferenceId);

	/**
	 * Returns the category image ID of this category.
	 *
	 * @return the category image ID of this category
	 */
	public long getCategoryImageId();

	/**
	 * Sets the category image ID of this category.
	 *
	 * @param categoryImageId the category image ID of this category
	 */
	public void setCategoryImageId(long categoryImageId);

	/**
	 * Returns the category image url of this category.
	 *
	 * @return the category image url of this category
	 */
	@AutoEscape
	public String getCategoryImageURL();

	/**
	 * Sets the category image url of this category.
	 *
	 * @param categoryImageURL the category image url of this category
	 */
	public void setCategoryImageURL(String categoryImageURL);

	/**
	 * Returns the manager remarks of this category.
	 *
	 * @return the manager remarks of this category
	 */
	@AutoEscape
	public String getManagerRemarks();

	/**
	 * Sets the manager remarks of this category.
	 *
	 * @param managerRemarks the manager remarks of this category
	 */
	public void setManagerRemarks(String managerRemarks);

	/**
	 * Returns the tree path of this category.
	 *
	 * @return the tree path of this category
	 */
	@AutoEscape
	public String getTreePath();

	/**
	 * Sets the tree path of this category.
	 *
	 * @param treePath the tree path of this category
	 */
	public void setTreePath(String treePath);

	/**
	 * Returns the terms condition of this category.
	 *
	 * @return the terms condition of this category
	 */
	@AutoEscape
	public String getTermsCondition();

	/**
	 * Sets the terms condition of this category.
	 *
	 * @param termsCondition the terms condition of this category
	 */
	public void setTermsCondition(String termsCondition);

	/**
	 * Returns the has child of this category.
	 *
	 * @return the has child of this category
	 */
	public Boolean getHasChild();

	/**
	 * Sets the has child of this category.
	 *
	 * @param hasChild the has child of this category
	 */
	public void setHasChild(Boolean hasChild);

	/**
	 * Returns the custom atr1 of this category.
	 *
	 * @return the custom atr1 of this category
	 */
	@AutoEscape
	public String getCustomAtr1();

	/**
	 * Sets the custom atr1 of this category.
	 *
	 * @param customAtr1 the custom atr1 of this category
	 */
	public void setCustomAtr1(String customAtr1);

	/**
	 * Returns the custom atr2 of this category.
	 *
	 * @return the custom atr2 of this category
	 */
	@AutoEscape
	public String getCustomAtr2();

	/**
	 * Sets the custom atr2 of this category.
	 *
	 * @param customAtr2 the custom atr2 of this category
	 */
	public void setCustomAtr2(String customAtr2);

	/**
	 * Returns the custom atr3 of this category.
	 *
	 * @return the custom atr3 of this category
	 */
	@AutoEscape
	public String getCustomAtr3();

	/**
	 * Sets the custom atr3 of this category.
	 *
	 * @param customAtr3 the custom atr3 of this category
	 */
	public void setCustomAtr3(String customAtr3);

	/**
	 * Returns the custom atr4 of this category.
	 *
	 * @return the custom atr4 of this category
	 */
	@AutoEscape
	public String getCustomAtr4();

	/**
	 * Sets the custom atr4 of this category.
	 *
	 * @param customAtr4 the custom atr4 of this category
	 */
	public void setCustomAtr4(String customAtr4);

	/**
	 * Returns the custom atr5 of this category.
	 *
	 * @return the custom atr5 of this category
	 */
	@AutoEscape
	public String getCustomAtr5();

	/**
	 * Sets the custom atr5 of this category.
	 *
	 * @param customAtr5 the custom atr5 of this category
	 */
	public void setCustomAtr5(String customAtr5);

	/**
	 * Returns the custom atr6 of this category.
	 *
	 * @return the custom atr6 of this category
	 */
	@AutoEscape
	public String getCustomAtr6();

	/**
	 * Sets the custom atr6 of this category.
	 *
	 * @param customAtr6 the custom atr6 of this category
	 */
	public void setCustomAtr6(String customAtr6);

	/**
	 * Returns the custom atr7 of this category.
	 *
	 * @return the custom atr7 of this category
	 */
	@AutoEscape
	public String getCustomAtr7();

	/**
	 * Sets the custom atr7 of this category.
	 *
	 * @param customAtr7 the custom atr7 of this category
	 */
	public void setCustomAtr7(String customAtr7);

	/**
	 * Returns the custom atr8 of this category.
	 *
	 * @return the custom atr8 of this category
	 */
	@AutoEscape
	public String getCustomAtr8();

	/**
	 * Sets the custom atr8 of this category.
	 *
	 * @param customAtr8 the custom atr8 of this category
	 */
	public void setCustomAtr8(String customAtr8);

	/**
	 * Returns the custom atr9 of this category.
	 *
	 * @return the custom atr9 of this category
	 */
	@AutoEscape
	public String getCustomAtr9();

	/**
	 * Sets the custom atr9 of this category.
	 *
	 * @param customAtr9 the custom atr9 of this category
	 */
	public void setCustomAtr9(String customAtr9);

	/**
	 * Returns the custom atr10 of this category.
	 *
	 * @return the custom atr10 of this category
	 */
	@AutoEscape
	public String getCustomAtr10();

	/**
	 * Sets the custom atr10 of this category.
	 *
	 * @param customAtr10 the custom atr10 of this category
	 */
	public void setCustomAtr10(String customAtr10);

	/**
	 * Returns the created by of this category.
	 *
	 * @return the created by of this category
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this category.
	 *
	 * @param createdBy the created by of this category
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this category.
	 *
	 * @return the modified by of this category
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this category.
	 *
	 * @param modifiedBy the modified by of this category
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the ip address of this category.
	 *
	 * @return the ip address of this category
	 */
	@AutoEscape
	public String getIpAddress();

	/**
	 * Sets the ip address of this category.
	 *
	 * @param ipAddress the ip address of this category
	 */
	public void setIpAddress(String ipAddress);

	/**
	 * Returns the is active of this category.
	 *
	 * @return the is active of this category
	 */
	public Boolean getIsActive();

	/**
	 * Sets the is active of this category.
	 *
	 * @param isActive the is active of this category
	 */
	public void setIsActive(Boolean isActive);

	/**
	 * Returns the down for seller of this category.
	 *
	 * @return the down for seller of this category
	 */
	public Boolean getDownForSeller();

	/**
	 * Sets the down for seller of this category.
	 *
	 * @param downForSeller the down for seller of this category
	 */
	public void setDownForSeller(Boolean downForSeller);

	/**
	 * Returns the down for buyer of this category.
	 *
	 * @return the down for buyer of this category
	 */
	public Boolean getDownForBuyer();

	/**
	 * Sets the down for buyer of this category.
	 *
	 * @param downForBuyer the down for buyer of this category
	 */
	public void setDownForBuyer(Boolean downForBuyer);

	/**
	 * Returns the down for maintenance of this category.
	 *
	 * @return the down for maintenance of this category
	 */
	public Boolean getDownForMaintenance();

	/**
	 * Sets the down for maintenance of this category.
	 *
	 * @param downForMaintenance the down for maintenance of this category
	 */
	public void setDownForMaintenance(Boolean downForMaintenance);

	/**
	 * Returns the company ID of this category.
	 *
	 * @return the company ID of this category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this category.
	 *
	 * @param companyId the company ID of this category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this category.
	 *
	 * @return the user ID of this category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this category.
	 *
	 * @param userId the user ID of this category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this category.
	 *
	 * @return the user uuid of this category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this category.
	 *
	 * @param userUuid the user uuid of this category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this category.
	 *
	 * @return the user name of this category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this category.
	 *
	 * @param userName the user name of this category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this category.
	 *
	 * @return the create date of this category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this category.
	 *
	 * @param createDate the create date of this category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this category.
	 *
	 * @return the status of this category
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this category.
	 *
	 * @param status the status of this category
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this category.
	 *
	 * @return the status by user ID of this category
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this category.
	 *
	 * @param statusByUserId the status by user ID of this category
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this category.
	 *
	 * @return the status by user uuid of this category
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this category.
	 *
	 * @param statusByUserUuid the status by user uuid of this category
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this category.
	 *
	 * @return the status by user name of this category
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this category.
	 *
	 * @param statusByUserName the status by user name of this category
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this category.
	 *
	 * @return the status date of this category
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this category.
	 *
	 * @param statusDate the status date of this category
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this category is approved.
	 *
	 * @return <code>true</code> if this category is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this category is denied.
	 *
	 * @return <code>true</code> if this category is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this category is a draft.
	 *
	 * @return <code>true</code> if this category is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this category is expired.
	 *
	 * @return <code>true</code> if this category is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this category is inactive.
	 *
	 * @return <code>true</code> if this category is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this category is incomplete.
	 *
	 * @return <code>true</code> if this category is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this category is pending.
	 *
	 * @return <code>true</code> if this category is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this category is scheduled.
	 *
	 * @return <code>true</code> if this category is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public Category cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}