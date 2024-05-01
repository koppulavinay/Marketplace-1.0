package com.marketplace.product.inventory.management.model;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ProductSkuModel.class)
public class ProductSkuModel {

	private long productSkuId;
	private long stock;

	public long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(long productSkuId) {
		this.productSkuId = productSkuId;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

}
