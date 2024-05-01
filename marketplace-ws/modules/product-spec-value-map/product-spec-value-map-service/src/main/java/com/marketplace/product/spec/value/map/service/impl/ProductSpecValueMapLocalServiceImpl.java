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

package com.marketplace.product.spec.value.map.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.product.spec.value.map.exception.NoSuchProductSpecValueMapException;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.service.base.ProductSpecValueMapLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.marketplace.product.spec.value.map.model.ProductSpecValueMap", service = AopService.class)
public class ProductSpecValueMapLocalServiceImpl extends ProductSpecValueMapLocalServiceBaseImpl {

	public List<ProductSpecValueMap> findByProductSpecificationId(long productSpecificationId) {

		return productSpecValueMapPersistence.findByproductSpecificationId(productSpecificationId);
	}

	public ProductSpecValueMap findByProductSpecIdNSpecValueId(long productSpecificationId, long specificationValueId)
			throws NoSuchProductSpecValueMapException {

		return productSpecValueMapPersistence.findByProductSpecIdNSpecValueId(productSpecificationId,
				specificationValueId);
	}

}