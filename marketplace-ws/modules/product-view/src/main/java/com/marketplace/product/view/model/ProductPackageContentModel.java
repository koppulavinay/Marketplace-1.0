package com.marketplace.product.view.model;

/**
 * 
 * @author anubhav.kalra
 *
 */
public class ProductPackageContentModel {

	public ProductPackageContentModel(String itemName, String itemQty) {
		super();
		this.itemName = itemName;
		this.itemQty = itemQty;
	}

	public String getItemName() {
		return itemName;
	}
	
	public String getItemQty() {
		return itemQty;
	}
	
	private String itemName;
	private String itemQty;
	
}
