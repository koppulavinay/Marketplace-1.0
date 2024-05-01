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

package com.marketplace.category.service.impl;

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
import com.marketplace.category.model.Category;
import com.marketplace.category.service.base.CategoryLocalServiceBaseImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.marketplace.category.model.Category",
	service = AopService.class
)
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

Log _log = LogFactoryUtil.getLog(CategoryLocalServiceImpl.class.getName());

	public List<Category> getbyParentCategoryId(long parentCategoryId) {
		List<Category> categoryList = null;
		try {
		categoryList = categoryPersistence.findByparentCategoryId(parentCategoryId);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
		
	}
	
	public long countByparentCategoryId(long parentCategoryId) {
		long categoryListSize = 0;
		try {
			categoryListSize = categoryPersistence.countByparentCategoryId(parentCategoryId);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryListSize;
		
	}
	
	public List<Category> getbyParentCategoriesId(long parentCategoryId,int start,int end) {
		List<Category> categoryList = null;
		try {
			OrderByComparator<Category> comparator =OrderByComparatorFactoryUtil.create(
					"Category", "modifiedDate", true);
			
			categoryList = categoryPersistence.findByparentCategoryId(parentCategoryId, start, end, comparator);
			
		}catch(Exception e) {
			_log.info(e);
		}
		
		return categoryList;
	}
	
	public List<Category> getbyAdmin(long userId,long parentCategoryId) {
		List<Category> categoryList = null;
		try {
		categoryList = categoryPersistence.findBycreatedBy(userId, parentCategoryId);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
		
	}
	
	public List<Category> getbyAdminCateogries(long userId,long parentCategoryId,int start,int end) {
		List<Category> categoryList = null;
		try {
			OrderByComparator<Category> comparator =OrderByComparatorFactoryUtil.create(
					"Category", "modifiedDate", true);
		categoryList = categoryPersistence.findBycreatedBy(userId, parentCategoryId, start, end, comparator);
				}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
		
	}
	
	public List<Category> getbyManager(long userId,long parentCategoryId) {
		List<Category> categoryList = null;
		try {
		categoryList = categoryPersistence.findByassignManager(userId, parentCategoryId);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
	}
	
	public List<Category> getbyManagerCategories(long userId,long parentCategoryId,int start,int end) {
		List<Category> categoryList = null;
		try {
			OrderByComparator<Category> comparator =OrderByComparatorFactoryUtil.create(
					"Category", "modifiedDate", true);
		categoryList = categoryPersistence.findByassignManager(userId, parentCategoryId, start, end, comparator);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
	}
	
	public List<Category> getbyStatus(String status) {
		List<Category> categoryList = null;
		try {
			OrderByComparator<Category> comparator =OrderByComparatorFactoryUtil.create(
					"Category", "modifiedDate", true);
		categoryList = categoryPersistence.findBycategoryApprovalStatus(status);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
	}
	
	public List<Category> getbyStatuses(String status, int start,int end) {
		List<Category> categoryList = null;
		try {
			
		categoryList = categoryPersistence.findBycategoryApprovalStatus(status, start, end);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
	}
	
	public List<Category> getbyReviewer(long userId,long parentCategoryId) {
		List<Category> categoryList = null;
		try {
		categoryList = categoryPersistence.findByassignReviewer(userId, parentCategoryId);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
	}
	
	public List<Category> getbyReviewerCategories(long userId,long parentCategoryId,int start, int end) {
		List<Category> categoryList = null;
		try {
			OrderByComparator<Category> comparator =OrderByComparatorFactoryUtil.create(
					"Category", "modifiedDate", true);
		categoryList = categoryPersistence.findByassignReviewer(userId, parentCategoryId, start, end, comparator);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryList;
		
	}
	
	public Category findByFBYAssetCategoryId(long assetCategoryId) {
		Category category = null;
		try {
			category = categoryPersistence.findByFBYAssetCategoryId(assetCategoryId);
		} catch (Exception e) {
			_log.info(e.getMessage());
		}
		return category;
	}
	
	public long countByparentCategoryIdStatus(long parentCategoryId, String status) {
		long categoryListSize = 0;
		try {
			categoryListSize = categoryPersistence.countByparentCategoryIdStatus(parentCategoryId, status);
		}catch(Exception e) {
			_log.info(e);
		}
		return categoryListSize;
	}
	
public Category addBrand(Category category,User user,ServiceContext serviceContext) throws PortalException {
		
		Category categoryResult = categoryLocalService.addCategory(category);
		try {
			resourceLocalService.addResources(user.getCompanyId(), user.getGroupId(), user.getUserId(),
				Category.class.getName(), category.getCategoryId(), false, true, true);
			_log.info("Successfully Added ");
		}catch(Exception e) {
			_log.info("Error in Adding Resoucre :::: " + e.getMessage());
		}
		
		return categoryResult;
	}
	
	
	
	public Category updateStatus(long userId, long categoryId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Category category = categoryPersistence.fetchByPrimaryKey(categoryId);

		category.setStatus(status);
		category.setStatusByUserId(userId);
		category.setStatusByUserName(user.getFullName());
		category.setStatusDate(new Date());
			categoryPersistence.update(category);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Category.class.getName(), categoryId, true);
		} else {
			assetEntryLocalService.updateVisible(Category.class.getName(), categoryId, false);
		}
		return category;
	}
}