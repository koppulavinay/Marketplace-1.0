package com.marketplace.product.view.model;

public class ProductSpecificationValueModel {

	public long getProductSpecValueId() {
		return productSpecValueId;
	}

	public long getSpecificationValueId() {
		return specificationValueId;
	}

	public String getSpecificationValueLabel() {
		return specificationValueLabel;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setProductSpecValueId(long productSpecValueId) {
		this.productSpecValueId = productSpecValueId;
	}

	public void setSpecificationValueId(long specificationValueId) {
		this.specificationValueId = specificationValueId;
	}

	public void setSpecificationValueLabel(String specificationValueLabel) {
		this.specificationValueLabel = specificationValueLabel;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	private long productSpecValueId;
	private long specificationValueId;
	private String specificationValueLabel;
	private boolean isSelected;

}
