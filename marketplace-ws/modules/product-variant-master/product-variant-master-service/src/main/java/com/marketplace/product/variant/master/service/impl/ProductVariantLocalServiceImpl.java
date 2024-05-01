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

package com.marketplace.product.variant.master.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.product.variant.master.exception.NoSuchProductVariantException;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.service.base.ProductVariantLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.marketplace.product.variant.master.model.ProductVariant",
	service = AopService.class
)
public class ProductVariantLocalServiceImpl
	extends ProductVariantLocalServiceBaseImpl {
	
	public List<ProductVariant> findByDraftProductId(long draftProductId) {
		return productVariantPersistence.findBydraftProductId(draftProductId);
	}
	
	public List<ProductVariant> findByVariantNameID(long draftProductId, String variantName) {
		return productVariantPersistence.findByvariantNameID(draftProductId, variantName);
	}
	
}