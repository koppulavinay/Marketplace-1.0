package com.marketplace.specification.model;

public class SpecificationCategoryModel {

	public SpecificationCategoryModel(long categoryId, long specCategoryId, String categoryName,
			boolean isCategoryMandatory) {
		super();
		this.categoryId = categoryId;
		this.specCategoryId = specCategoryId;
		this.categoryName = categoryName;
		this.isCategoryMandatory = isCategoryMandatory;
	}

	public SpecificationCategoryModel(long categoryId, String categoryName, boolean isCategorySelected) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.isCategorySelected = isCategorySelected;
	}

	public boolean isCategorySelected() {
		return isCategorySelected;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public long getSpecCategoryId() {
		return specCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public boolean isCategoryMandatory() {
		return isCategoryMandatory;
	}

	private long categoryId;
	private long specCategoryId;
	private String categoryName;
	private boolean isCategoryMandatory;
	private boolean isCategorySelected;

}
