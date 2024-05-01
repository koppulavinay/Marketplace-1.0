package com.marketplace.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CategoryModel {
	
	@JsonProperty("categoryid")
	public long categoryId;
	
	@JsonProperty("categorycode")
	public String categoryCode;
	
	@JsonProperty("parentcategoryid")
	public long parentCategoryId;
	
	@JsonProperty("categoryname")
	public String categoryName;
	
	@JsonProperty("categorydescription")
	public String categoryDescription;
	
	@JsonProperty("categorytype")
	public String categoryType;
	
	@JsonProperty("assignmanager")
	public long assignManager;
	
	@JsonProperty("assignreviewer")
	public long assignReviewer;
	
	@JsonProperty("categoryapprovalstatus")
	public String categoryApprovalStatus;
	
	@JsonProperty("categoryexpirydate")
	public Date categoryExpiryDate;
	
	@JsonProperty("categoryinactive")
	public Boolean categoryInactive;
	
	@JsonProperty("externalreferenceid")
	public String externalReferenceId;
	
	@JsonProperty("categoryimageurl")
	public String categoryImageURL;
	
	@JsonProperty("treepath")
	public String treePath;
	
	@JsonProperty("termscondition")
	public String termsCondition;
	
	@JsonProperty("createdby")
	public long createdBy;
	
	@JsonProperty("customatr1")
	public String customAtr1;
	
	@JsonProperty("customatr2")
	public String customAtr2;
	
	@JsonProperty("customatr3")
	public String CustomAtr3;
	
	@JsonProperty("customatr4")
	public String customAtr4;
	
	@JsonProperty("customatr5")
	public String customAtr5;
	
	@JsonProperty("customatr6")
	public String customAtr6;
	
	@JsonProperty("customatr7")
	public String customAtr7;
	
	@JsonProperty("customatr8")
	public String customAtr8;
	
	@JsonProperty("customatr9")
	public String customAtr9;
	
	@JsonProperty("customatr10")
	public String customAtr10;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public long getAssignManager() {
		return assignManager;
	}

	public void setAssignManager(long assignManager) {
		this.assignManager = assignManager;
	}

	public long getAssignReviewer() {
		return assignReviewer;
	}

	public void setAssignReviewer(long assignReviewer) {
		this.assignReviewer = assignReviewer;
	}

	public String getCategoryApprovalStatus() {
		return categoryApprovalStatus;
	}

	public void setCategoryApprovalStatus(String categoryApprovalStatus) {
		this.categoryApprovalStatus = categoryApprovalStatus;
	}

	public Date getCategoryExpiryDate() {
		return categoryExpiryDate;
	}

	public void setCategoryExpiryDate(Date categoryExpiryDate) {
		this.categoryExpiryDate = categoryExpiryDate;
	}

	public Boolean getCategoryInactive() {
		return categoryInactive;
	}

	public void setCategoryInactive(Boolean categoryInactive) {
		this.categoryInactive = categoryInactive;
	}
	
	public String getExternalReferenceId() {
		return externalReferenceId;
	}

	public void setExternalReferenceId(String externalReferenceId) {
		this.externalReferenceId = externalReferenceId;
	}

	public String getCategoryImageURL() {
		return categoryImageURL;
	}

	public void setCategoryImageURL(String categoryImageURL) {
		this.categoryImageURL = categoryImageURL;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getTermsCondition() {
		return termsCondition;
	}

	public void setTermsCondition(String termsCondition) {
		this.termsCondition = termsCondition;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public String getCustomAtr1() {
		return customAtr1;
	}

	public void setCustomAtr1(String customAtr1) {
		this.customAtr1 = customAtr1;
	}

	public String getCustomAtr2() {
		return customAtr2;
	}

	public void setCustomAtr2(String customAtr2) {
		this.customAtr2 = customAtr2;
	}

	public String getCustomAtr3() {
		return CustomAtr3;
	}

	public void setCustomAtr3(String customAtr3) {
		CustomAtr3 = customAtr3;
	}

	public String getCustomAtr4() {
		return customAtr4;
	}

	public void setCustomAtr4(String customAtr4) {
		this.customAtr4 = customAtr4;
	}

	public String getCustomAtr5() {
		return customAtr5;
	}

	public void setCustomAtr5(String customAtr5) {
		this.customAtr5 = customAtr5;
	}

	public String getCustomAtr6() {
		return customAtr6;
	}

	public void setCustomAtr6(String customAtr6) {
		this.customAtr6 = customAtr6;
	}

	public String getCustomAtr7() {
		return customAtr7;
	}

	public void setCustomAtr7(String customAtr7) {
		this.customAtr7 = customAtr7;
	}

	public String getCustomAtr8() {
		return customAtr8;
	}

	public void setCustomAtr8(String customAtr8) {
		this.customAtr8 = customAtr8;
	}

	public String getCustomAtr9() {
		return customAtr9;
	}

	public void setCustomAtr9(String customAtr9) {
		this.customAtr9 = customAtr9;
	}

	public String getCustomAtr10() {
		return customAtr10;
	}

	public void setCustomAtr10(String customAtr10) {
		this.customAtr10 = customAtr10;
	}

	
}