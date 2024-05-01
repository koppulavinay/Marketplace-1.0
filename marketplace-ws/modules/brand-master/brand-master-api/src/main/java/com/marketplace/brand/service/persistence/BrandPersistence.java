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

package com.marketplace.brand.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.brand.exception.NoSuchBrandException;
import com.marketplace.brand.model.Brand;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the brand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandUtil
 * @generated
 */
@ProviderType
public interface BrandPersistence extends BasePersistence<Brand> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrandUtil} to access the brand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching brands
	 */
	public java.util.List<Brand> findByUuid(String uuid);

	/**
	 * Returns a range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	public java.util.List<Brand> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand[] findByUuid_PrevAndNext(
			long brandId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Removes all the brands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching brands
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByUUID_G(String uuid, long groupId)
		throws NoSuchBrandException;

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the brand where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the brand that was removed
	 */
	public Brand removeByUUID_G(String uuid, long groupId)
		throws NoSuchBrandException;

	/**
	 * Returns the number of brands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching brands
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching brands
	 */
	public java.util.List<Brand> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	public java.util.List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand[] findByUuid_C_PrevAndNext(
			long brandId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Removes all the brands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching brands
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the matching brands
	 */
	public java.util.List<Brand> findByFBYStatus(String brandApprovalStatus);

	/**
	 * Returns a range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	public java.util.List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end);

	/**
	 * Returns an ordered range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByFBYStatus_First(
			String brandApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYStatus_First(
		String brandApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByFBYStatus_Last(
			String brandApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYStatus_Last(
		String brandApprovalStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the brands before and after the current brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand[] findByFBYStatus_PrevAndNext(
			long brandId, String brandApprovalStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Removes all the brands where brandApprovalStatus = &#63; from the database.
	 *
	 * @param brandApprovalStatus the brand approval status
	 */
	public void removeByFBYStatus(String brandApprovalStatus);

	/**
	 * Returns the number of brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the number of matching brands
	 */
	public int countByFBYStatus(String brandApprovalStatus);

	/**
	 * Returns all the brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching brands
	 */
	public java.util.List<Brand> findByFBYCreatedBy(long createdBy);

	/**
	 * Returns a range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	public java.util.List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end);

	/**
	 * Returns an ordered range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	public java.util.List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByFBYCreatedBy_First(
			long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYCreatedBy_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByFBYCreatedBy_Last(
			long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYCreatedBy_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns the brands before and after the current brand in the ordered set where createdBy = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand[] findByFBYCreatedBy_PrevAndNext(
			long brandId, long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator<Brand>
				orderByComparator)
		throws NoSuchBrandException;

	/**
	 * Removes all the brands where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 */
	public void removeByFBYCreatedBy(long createdBy);

	/**
	 * Returns the number of brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching brands
	 */
	public int countByFBYCreatedBy(long createdBy);

	/**
	 * Returns the brand where assetCategoryId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public Brand findByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchBrandException;

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYAssetCategoryId(long assetCategoryId);

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public Brand fetchByFBYAssetCategoryId(
		long assetCategoryId, boolean useFinderCache);

	/**
	 * Removes the brand where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the brand that was removed
	 */
	public Brand removeByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchBrandException;

	/**
	 * Returns the number of brands where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching brands
	 */
	public int countByFBYAssetCategoryId(long assetCategoryId);

	/**
	 * Caches the brand in the entity cache if it is enabled.
	 *
	 * @param brand the brand
	 */
	public void cacheResult(Brand brand);

	/**
	 * Caches the brands in the entity cache if it is enabled.
	 *
	 * @param brands the brands
	 */
	public void cacheResult(java.util.List<Brand> brands);

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	public Brand create(long brandId);

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand remove(long brandId) throws NoSuchBrandException;

	public Brand updateImpl(Brand brand);

	/**
	 * Returns the brand with the primary key or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public Brand findByPrimaryKey(long brandId) throws NoSuchBrandException;

	/**
	 * Returns the brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand, or <code>null</code> if a brand with the primary key could not be found
	 */
	public Brand fetchByPrimaryKey(long brandId);

	/**
	 * Returns all the brands.
	 *
	 * @return the brands
	 */
	public java.util.List<Brand> findAll();

	/**
	 * Returns a range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of brands
	 */
	public java.util.List<Brand> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brands
	 */
	public java.util.List<Brand> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brands
	 */
	public java.util.List<Brand> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Brand>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the brands from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	public int countAll();

}