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

package com.marketplace.specification.category.map.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.specification.category.map.exception.NoSuchSpecCategoryMapException;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.base.SpecCategoryMapLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.marketplace.specification.category.map.model.SpecCategoryMap",
	service = AopService.class
)
public class SpecCategoryMapLocalServiceImpl
	extends SpecCategoryMapLocalServiceBaseImpl {
	
	public List<SpecCategoryMap> findByFBYSpecificationId(long specificationId){
		return specCategoryMapPersistence.findByFBYSpecificationId(specificationId);
	}
	
	public List<SpecCategoryMap> findByCategoryId(long categoryId) {
		return specCategoryMapPersistence.findByFBYCategoryId(categoryId);
	}
	
	public List<SpecCategoryMap> findByCategoryId(long categoryId, int start, int end) {
		return specCategoryMapPersistence.findByFBYCategoryId(categoryId, start, end);
	}
	
	public SpecCategoryMap findBySpecificationIdNCategoryId(long specificationId, long categoryId) throws NoSuchSpecCategoryMapException {
		return specCategoryMapPersistence.findBySpecificationIdNCategoryId(specificationId, categoryId);
	}
	
}