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

package com.marketplace.brand.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.base.BrandLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.marketplace.brand.model.Brand",
	service = AopService.class
)
public class BrandLocalServiceImpl extends BrandLocalServiceBaseImpl {
	
	public static Log _log = LogFactoryUtil.getLog(BrandLocalServiceImpl.class.getName());
	
	public List<Brand> findByFBYStatus(String brandApprovalStatus){
		return brandPersistence.findByFBYStatus(brandApprovalStatus);
	}
	
	public List<Brand> findByFBYStatuses(String brandApprovalStatus, int start, int end){
		OrderByComparator<Brand> comparator = OrderByComparatorFactoryUtil.create(
				"Brand", "modifiedDate", true);
		return brandPersistence.findByFBYStatus(brandApprovalStatus, start, end, comparator);
	}
	
	public List<Brand> findByFBYCreatedBy(long createdBy){
		return brandPersistence.findByFBYCreatedBy(createdBy);
	}
	
	public List<Brand> findByFBYCreatedBys(long createdBy, int start, int end){
		OrderByComparator<Brand> comparator = OrderByComparatorFactoryUtil.create(
				"Brand", "modifiedDate", true);
		return brandPersistence.findByFBYCreatedBy(createdBy, start, end, comparator);
	}
	
	public Brand findByFBYAssetCategoryId(long assetCategoryId) {
		Brand brand = null;
		try {
			brand = brandPersistence.findByFBYAssetCategoryId(assetCategoryId);
		} catch(Exception e) {
			_log.info(e.getMessage());
		}
		return brand;
	}
	
	public Brand updateStatus(long userId, long brandId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Brand brand = brandPersistence.fetchByPrimaryKey(brandId);

		brand.setStatus(status);
		brand.setStatusByUserId(userId);
		brand.setStatusByUserName(user.getFullName());
		brand.setStatusDate(new Date());

		brandPersistence.update(brand);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Brand.class.getName(), brandId, true);
		} else {
			assetEntryLocalService.updateVisible(Brand.class.getName(), brandId, false);
		}
		return brand;
	}
	
	public Brand addBrand(Brand brand,User user,ServiceContext serviceContext) throws PortalException {
		
		Brand brandResult = brandLocalService.addBrand(brand);
		try {
			resourceLocalService.addResources(user.getCompanyId(), user.getGroupId(), user.getUserId(),
				Brand.class.getName(), brand.getBrandId(), false, true, true);
			_log.info("Successfully Added ");
		}catch(Exception e) {
			_log.info("Error in Adding Resoucre :::: " + e.getMessage());
		}
		
		return brandResult;
	}
	
}