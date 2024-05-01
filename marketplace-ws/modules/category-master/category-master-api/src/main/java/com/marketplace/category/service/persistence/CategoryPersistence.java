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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.category.exception.NoSuchCategoryException;
import com.marketplace.category.model.Category;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryUtil
 * @generated
 */
@ProviderType
public interface CategoryPersistence extends BasePersistence<Category> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching categories
	 */
	public java.util.List<Category> findByUuid(String uuid);

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
	public java.util.List<Category> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Category> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the categories before and after the current category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching categories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryException;

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category that was removed
	 */
	public Category removeByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryException;

	/**
	 * Returns the number of categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching categories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public Category[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching categories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	public java.util.List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus);

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
	public java.util.List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end);

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
	public java.util.List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findBycategoryApprovalStatus_First(
			String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchBycategoryApprovalStatus_First(
		String categoryApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findBycategoryApprovalStatus_Last(
			String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchBycategoryApprovalStatus_Last(
		String categoryApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the categories before and after the current category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category[] findBycategoryApprovalStatus_PrevAndNext(
			long categoryId, String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where categoryApprovalStatus = &#63; from the database.
	 *
	 * @param categoryApprovalStatus the category approval status
	 */
	public void removeBycategoryApprovalStatus(String categoryApprovalStatus);

	/**
	 * Returns the number of categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	public int countBycategoryApprovalStatus(String categoryApprovalStatus);

	/**
	 * Returns all the categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findByparentCategoryId(
		long parentCategoryId);

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
	public java.util.List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end);

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
	public java.util.List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByparentCategoryId_First(
			long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByparentCategoryId_First(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByparentCategoryId_Last(
			long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByparentCategoryId_Last(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the categories before and after the current category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category[] findByparentCategoryId_PrevAndNext(
			long categoryId, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where parentCategoryId = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 */
	public void removeByparentCategoryId(long parentCategoryId);

	/**
	 * Returns the number of categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public int countByparentCategoryId(long parentCategoryId);

	/**
	 * Returns all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findByassignManager(
		long assignManager, long parentCategoryId);

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
	public java.util.List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end);

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
	public java.util.List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByassignManager_First(
			long assignManager, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByassignManager_First(
		long assignManager, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByassignManager_Last(
			long assignManager, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByassignManager_Last(
		long assignManager, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public Category[] findByassignManager_PrevAndNext(
			long categoryId, long assignManager, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where assignManager = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 */
	public void removeByassignManager(
		long assignManager, long parentCategoryId);

	/**
	 * Returns the number of categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public int countByassignManager(long assignManager, long parentCategoryId);

	/**
	 * Returns all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId);

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
	public java.util.List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end);

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
	public java.util.List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByassignReviewer_First(
			long assignReviewer, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByassignReviewer_First(
		long assignReviewer, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByassignReviewer_Last(
			long assignReviewer, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByassignReviewer_Last(
		long assignReviewer, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public Category[] findByassignReviewer_PrevAndNext(
			long categoryId, long assignReviewer, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where assignReviewer = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 */
	public void removeByassignReviewer(
		long assignReviewer, long parentCategoryId);

	/**
	 * Returns the number of categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public int countByassignReviewer(
		long assignReviewer, long parentCategoryId);

	/**
	 * Returns all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId);

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
	public java.util.List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end);

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
	public java.util.List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findBycreatedBy_First(
			long createdBy, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchBycreatedBy_First(
		long createdBy, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findBycreatedBy_Last(
			long createdBy, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchBycreatedBy_Last(
		long createdBy, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public Category[] findBycreatedBy_PrevAndNext(
			long categoryId, long createdBy, long parentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where createdBy = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 */
	public void removeBycreatedBy(long createdBy, long parentCategoryId);

	/**
	 * Returns the number of categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	public int countBycreatedBy(long createdBy, long parentCategoryId);

	/**
	 * Returns the category where assetCategoryId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchCategoryException;

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFBYAssetCategoryId(long assetCategoryId);

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFBYAssetCategoryId(
		long assetCategoryId, boolean useFinderCache);

	/**
	 * Removes the category where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the category that was removed
	 */
	public Category removeByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchCategoryException;

	/**
	 * Returns the number of categories where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching categories
	 */
	public int countByFBYAssetCategoryId(long assetCategoryId);

	/**
	 * Returns all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	public java.util.List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus);

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
	public java.util.List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end);

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
	public java.util.List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByparentCategoryIdStatus_First(
			long parentCategoryId, String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByparentCategoryIdStatus_First(
		long parentCategoryId, String categoryApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByparentCategoryIdStatus_Last(
			long parentCategoryId, String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByparentCategoryIdStatus_Last(
		long parentCategoryId, String categoryApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public Category[] findByparentCategoryIdStatus_PrevAndNext(
			long categoryId, long parentCategoryId,
			String categoryApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Category>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 */
	public void removeByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus);

	/**
	 * Returns the number of categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	public int countByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus);

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	public void cacheResult(Category category);

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	public void cacheResult(java.util.List<Category> categories);

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	public Category create(long categoryId);

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category remove(long categoryId) throws NoSuchCategoryException;

	public Category updateImpl(Category category);

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException;

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	public Category fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	public java.util.List<Category> findAll();

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
	public java.util.List<Category> findAll(int start, int end);

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
	public java.util.List<Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator);

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
	public java.util.List<Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	public int countAll();

}