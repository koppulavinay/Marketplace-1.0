package com.marketplace.product.view.model;

import java.util.List;

/**
 * 
 * @author anubhav.kalra
 *
 */
public class ProductSpecificationsModel {

	public long getSpecificationId() {
		return specificationId;
	}

	public String getSpecificationLabel() {
		return specificationLabel;
	}

	public String getSpecificationFieldType() {
		return specificationFieldType;
	}

	public List<ProductSpecificationValueModel> getProductSpecificationValues() {
		return productSpecificationValues;
	}

	public String getSpecificationValueUOM() {
		return specificationValueUOM;
	}

	public long getProductSpecValueId() {
		return productSpecValueId;
	}

	public long getProductSpecificationId() {
		return productSpecificationId;
	}

	public String getSingleInputValueLabel() {
		return singleInputValueLabel;
	}

	public void setSpecificationId(long specificationId) {
		this.specificationId = specificationId;
	}

	public void setSpecificationLabel(String specificationLabel) {
		this.specificationLabel = specificationLabel;
	}

	public void setSpecificationFieldType(String specificationFieldType) {
		this.specificationFieldType = specificationFieldType;
	}

	public void setProductSpecificationValues(List<ProductSpecificationValueModel> productSpecificationValues) {
		this.productSpecificationValues = productSpecificationValues;
	}

	public void setSpecificationValueUOM(String specificationValueUOM) {
		this.specificationValueUOM = specificationValueUOM;
	}

	public void setProductSpecValueId(long productSpecValueId) {
		this.productSpecValueId = productSpecValueId;
	}

	public void setProductSpecificationId(long productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}

	public void setSingleInputValueLabel(String specificationValueLabel) {
		this.singleInputValueLabel = specificationValueLabel;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	private long specificationId;
	private long productSpecValueId;
	private String specificationLabel;
	private String specificationFieldType;
	private List<ProductSpecificationValueModel> productSpecificationValues;
	private String singleInputValueLabel;
	private String specificationValueUOM;
	private long productSpecificationId;
	private boolean isMandatory;

}
