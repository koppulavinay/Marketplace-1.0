package com.marketplace.product.view.model;

/**
 * 
 * @author anubhav.kalra
 *
 */
public class WrapperMap {

	public WrapperMap(long specificationValueId, String value, boolean isSelected) {
		super();
		this.specificationValueId = specificationValueId;
		this.value = value;
		this.isSelected = isSelected;
	}
	
	public long getSpecificationValueId() {
		return specificationValueId;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	private long specificationValueId;
	private String value;
	private boolean isSelected;
	
}
