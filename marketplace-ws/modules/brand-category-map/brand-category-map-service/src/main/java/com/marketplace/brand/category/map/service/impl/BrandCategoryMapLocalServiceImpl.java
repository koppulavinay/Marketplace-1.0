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

package com.marketplace.brand.category.map.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.service.base.BrandCategoryMapLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.marketplace.brand.category.map.model.BrandCategoryMap",
	service = AopService.class
)
public class BrandCategoryMapLocalServiceImpl
	extends BrandCategoryMapLocalServiceBaseImpl {
	
	public List<BrandCategoryMap> findByFBYBrandId(long brandId){
		return brandCategoryMapPersistence.findByFBYBrandId(brandId);
	}
	
}