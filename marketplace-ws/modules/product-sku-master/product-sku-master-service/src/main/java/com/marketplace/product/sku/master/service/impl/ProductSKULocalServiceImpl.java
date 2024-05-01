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

package com.marketplace.product.sku.master.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.product.sku.master.exception.NoSuchProductSKUException;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.base.ProductSKULocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.marketplace.product.sku.master.model.ProductSKU", service = AopService.class)
public class ProductSKULocalServiceImpl extends ProductSKULocalServiceBaseImpl {

	public List<ProductSKU> findByDraftProductSkuId(long draftProductId) {
		return productSKUPersistence.findBySkuDraftProductId(draftProductId);
	}
	
	public List<ProductSKU> findByDraftProductSkuId(long draftProductId, int start, int end) {
		return productSKUPersistence.findBySkuDraftProductId(draftProductId, start, end);
	}

	@Override
	public List<ProductSKU> findByDraftProductNDefaultSKU(long draftProductId, String defaultSKU) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProductSKU findByDraftProductIdNDefaultSKU(long draftProductId, String defaultSKU) throws NoSuchProductSKUException {
		return productSKUPersistence.findByDraftProductIdNDefaultSKU(draftProductId, defaultSKU);
	}

	public List<ProductSKU>  findByDraftProductIdNSkuName(long draftProductId, String skuName)  {
		return productSKUPersistence.findByDraftProductIdNSkuName(draftProductId, skuName);
	}
	
	public ProductSKU findBySkuId(String skuId) {
		ProductSKU productSKU;
		try {
			productSKU = productSKUPersistence.findBySkuId(skuId);
		} catch (NoSuchProductSKUException e) {
			productSKU = null;
		}
		return productSKU;
	}
}