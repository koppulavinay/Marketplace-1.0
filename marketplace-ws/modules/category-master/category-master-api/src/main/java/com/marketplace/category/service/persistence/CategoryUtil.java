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

package com.marketplace.category.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.category.model.Category;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the category service. This utility wraps <code>com.marketplace.category.service.persistence.impl.CategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryPersistence
 * @generated
 */
public class CategoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Category category) {
		getPersistence().clearCache(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Category update(Category category) {
		return getPersistence().update(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Category update(
		Category category, ServiceContext serviceContext) {

		return getPersistence().update(category, serviceContext);
	}

	/**
	 * Returns all the categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching categories
	 */
	public static List<Category> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByUuid_First(
			String uuid, OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUuid_First(
		String uuid, OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByUuid_Last(
			String uuid, OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUuid_Last(
		String uuid, OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_PrevAndNext(
			categoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching categories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByUUID_G(String uuid, long groupId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category that was removed
	 */
	public static Category removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching categories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching categories
	 */
	public static List<Category> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			categoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching categories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	public static List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus) {

		return getPersistence().findBycategoryApprovalStatus(
			categoryApprovalStatus);
	}

	/**
	 * Returns a range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end) {

		return getPersistence().findBycategoryApprovalStatus(
			categoryApprovalStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findBycategoryApprovalStatus(
			categoryApprovalStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycategoryApprovalStatus(
			categoryApprovalStatus, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findBycategoryApprovalStatus_First(
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycategoryApprovalStatus_First(
			categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchBycategoryApprovalStatus_First(
		String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchBycategoryApprovalStatus_First(
			categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findBycategoryApprovalStatus_Last(
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycategoryApprovalStatus_Last(
			categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchBycategoryApprovalStatus_Last(
		String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchBycategoryApprovalStatus_Last(
			categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findBycategoryApprovalStatus_PrevAndNext(
			long categoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycategoryApprovalStatus_PrevAndNext(
			categoryId, categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Removes all the categories where categoryApprovalStatus = &#63; from the database.
	 *
	 * @param categoryApprovalStatus the category approval status
	 */
	public static void removeBycategoryApprovalStatus(
		String categoryApprovalStatus) {

		getPersistence().removeBycategoryApprovalStatus(categoryApprovalStatus);
	}

	/**
	 * Returns the number of categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	public static int countBycategoryApprovalStatus(
		String categoryApprovalStatus) {

		return getPersistence().countBycategoryApprovalStatus(
			categoryApprovalStatus);
	}

	/**
	 * Returns all the categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public static List<Category> findByparentCategoryId(long parentCategoryId) {
		return getPersistence().findByparentCategoryId(parentCategoryId);
	}

	/**
	 * Returns a range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end) {

		return getPersistence().findByparentCategoryId(
			parentCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByparentCategoryId(
			parentCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByparentCategoryId(
			parentCategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByparentCategoryId_First(
			long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryId_First(
			parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByparentCategoryId_First(
		long parentCategoryId, OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByparentCategoryId_First(
			parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByparentCategoryId_Last(
			long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryId_Last(
			parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByparentCategoryId_Last(
		long parentCategoryId, OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByparentCategoryId_Last(
			parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByparentCategoryId_PrevAndNext(
			long categoryId, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryId_PrevAndNext(
			categoryId, parentCategoryId, orderByComparator);
	}

	/**
	 * Removes all the categories where parentCategoryId = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 */
	public static void removeByparentCategoryId(long parentCategoryId) {
		getPersistence().removeByparentCategoryId(parentCategoryId);
	}

	/**
	 * Returns the number of categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public static int countByparentCategoryId(long parentCategoryId) {
		return getPersistence().countByparentCategoryId(parentCategoryId);
	}

	/**
	 * Returns all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public static List<Category> findByassignManager(
		long assignManager, long parentCategoryId) {

		return getPersistence().findByassignManager(
			assignManager, parentCategoryId);
	}

	/**
	 * Returns a range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end) {

		return getPersistence().findByassignManager(
			assignManager, parentCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByassignManager(
			assignManager, parentCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByassignManager(
			assignManager, parentCategoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByassignManager_First(
			long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignManager_First(
			assignManager, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByassignManager_First(
		long assignManager, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByassignManager_First(
			assignManager, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByassignManager_Last(
			long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignManager_Last(
			assignManager, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByassignManager_Last(
		long assignManager, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByassignManager_Last(
			assignManager, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByassignManager_PrevAndNext(
			long categoryId, long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignManager_PrevAndNext(
			categoryId, assignManager, parentCategoryId, orderByComparator);
	}

	/**
	 * Removes all the categories where assignManager = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 */
	public static void removeByassignManager(
		long assignManager, long parentCategoryId) {

		getPersistence().removeByassignManager(assignManager, parentCategoryId);
	}

	/**
	 * Returns the number of categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public static int countByassignManager(
		long assignManager, long parentCategoryId) {

		return getPersistence().countByassignManager(
			assignManager, parentCategoryId);
	}

	/**
	 * Returns all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public static List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		return getPersistence().findByassignReviewer(
			assignReviewer, parentCategoryId);
	}

	/**
	 * Returns a range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end) {

		return getPersistence().findByassignReviewer(
			assignReviewer, parentCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByassignReviewer(
			assignReviewer, parentCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByassignReviewer(
			assignReviewer, parentCategoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByassignReviewer_First(
			long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignReviewer_First(
			assignReviewer, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByassignReviewer_First(
		long assignReviewer, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByassignReviewer_First(
			assignReviewer, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByassignReviewer_Last(
			long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignReviewer_Last(
			assignReviewer, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByassignReviewer_Last(
		long assignReviewer, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByassignReviewer_Last(
			assignReviewer, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByassignReviewer_PrevAndNext(
			long categoryId, long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByassignReviewer_PrevAndNext(
			categoryId, assignReviewer, parentCategoryId, orderByComparator);
	}

	/**
	 * Removes all the categories where assignReviewer = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 */
	public static void removeByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		getPersistence().removeByassignReviewer(
			assignReviewer, parentCategoryId);
	}

	/**
	 * Returns the number of categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public static int countByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		return getPersistence().countByassignReviewer(
			assignReviewer, parentCategoryId);
	}

	/**
	 * Returns all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public static List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId) {

		return getPersistence().findBycreatedBy(createdBy, parentCategoryId);
	}

	/**
	 * Returns a range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end) {

		return getPersistence().findBycreatedBy(
			createdBy, parentCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().findBycreatedBy(
			createdBy, parentCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycreatedBy(
			createdBy, parentCategoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findBycreatedBy_First(
			long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycreatedBy_First(
			createdBy, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchBycreatedBy_First(
		long createdBy, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchBycreatedBy_First(
			createdBy, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findBycreatedBy_Last(
			long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycreatedBy_Last(
			createdBy, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchBycreatedBy_Last(
		long createdBy, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchBycreatedBy_Last(
			createdBy, parentCategoryId, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findBycreatedBy_PrevAndNext(
			long categoryId, long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findBycreatedBy_PrevAndNext(
			categoryId, createdBy, parentCategoryId, orderByComparator);
	}

	/**
	 * Removes all the categories where createdBy = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 */
	public static void removeBycreatedBy(
		long createdBy, long parentCategoryId) {

		getPersistence().removeBycreatedBy(createdBy, parentCategoryId);
	}

	/**
	 * Returns the number of categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public static int countBycreatedBy(long createdBy, long parentCategoryId) {
		return getPersistence().countBycreatedBy(createdBy, parentCategoryId);
	}

	/**
	 * Returns the category where assetCategoryId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByFBYAssetCategoryId(long assetCategoryId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByFBYAssetCategoryId(long assetCategoryId) {
		return getPersistence().fetchByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByFBYAssetCategoryId(
		long assetCategoryId, boolean useFinderCache) {

		return getPersistence().fetchByFBYAssetCategoryId(
			assetCategoryId, useFinderCache);
	}

	/**
	 * Removes the category where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the category that was removed
	 */
	public static Category removeByFBYAssetCategoryId(long assetCategoryId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().removeByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the number of categories where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching categories
	 */
	public static int countByFBYAssetCategoryId(long assetCategoryId) {
		return getPersistence().countByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	public static List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		return getPersistence().findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus);
	}

	/**
	 * Returns a range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public static List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end) {

		return getPersistence().findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end, OrderByComparator<Category> orderByComparator) {

		return getPersistence().findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	public static List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end, OrderByComparator<Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByparentCategoryIdStatus_First(
			long parentCategoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryIdStatus_First(
			parentCategoryId, categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByparentCategoryIdStatus_First(
		long parentCategoryId, String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByparentCategoryIdStatus_First(
			parentCategoryId, categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public static Category findByparentCategoryIdStatus_Last(
			long parentCategoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryIdStatus_Last(
			parentCategoryId, categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public static Category fetchByparentCategoryIdStatus_Last(
		long parentCategoryId, String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		return getPersistence().fetchByparentCategoryIdStatus_Last(
			parentCategoryId, categoryApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category[] findByparentCategoryIdStatus_PrevAndNext(
			long categoryId, long parentCategoryId,
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByparentCategoryIdStatus_PrevAndNext(
			categoryId, parentCategoryId, categoryApprovalStatus,
			orderByComparator);
	}

	/**
	 * Removes all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 */
	public static void removeByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		getPersistence().removeByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus);
	}

	/**
	 * Returns the number of categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	public static int countByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		return getPersistence().countByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	public static void cacheResult(Category category) {
		getPersistence().cacheResult(category);
	}

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	public static void cacheResult(List<Category> categories) {
		getPersistence().cacheResult(categories);
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	public static Category create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category remove(long categoryId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().remove(categoryId);
	}

	public static Category updateImpl(Category category) {
		return getPersistence().updateImpl(category);
	}

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public static Category findByPrimaryKey(long categoryId)
		throws com.marketplace.category.exception.NoSuchCategoryException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	public static Category fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	public static List<Category> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	public static List<Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	public static List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categories
	 */
	public static List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CategoryPersistence _persistence;

}