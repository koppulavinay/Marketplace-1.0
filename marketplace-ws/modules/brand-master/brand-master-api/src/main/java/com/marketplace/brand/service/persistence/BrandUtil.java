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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.brand.model.Brand;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the brand service. This utility wraps <code>com.marketplace.brand.service.persistence.impl.BrandPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandPersistence
 * @generated
 */
public class BrandUtil {

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
	public static void clearCache(Brand brand) {
		getPersistence().clearCache(brand);
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
	public static Map<Serializable, Brand> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Brand> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Brand> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Brand> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Brand update(Brand brand) {
		return getPersistence().update(brand);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Brand update(Brand brand, ServiceContext serviceContext) {
		return getPersistence().update(brand, serviceContext);
	}

	/**
	 * Returns all the brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching brands
	 */
	public static List<Brand> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Brand> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByUuid_First(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUuid_First(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByUuid_Last(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUuid_Last(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public static Brand[] findByUuid_PrevAndNext(
			long brandId, String uuid,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_PrevAndNext(
			brandId, uuid, orderByComparator);
	}

	/**
	 * Removes all the brands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching brands
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByUUID_G(String uuid, long groupId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the brand where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the brand that was removed
	 */
	public static Brand removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of brands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching brands
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching brands
	 */
	public static List<Brand> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Brand[] findByUuid_C_PrevAndNext(
			long brandId, String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByUuid_C_PrevAndNext(
			brandId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the brands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching brands
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the matching brands
	 */
	public static List<Brand> findByFBYStatus(String brandApprovalStatus) {
		return getPersistence().findByFBYStatus(brandApprovalStatus);
	}

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
	public static List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end) {

		return getPersistence().findByFBYStatus(
			brandApprovalStatus, start, end);
	}

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
	public static List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findByFBYStatus(
			brandApprovalStatus, start, end, orderByComparator);
	}

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
	public static List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFBYStatus(
			brandApprovalStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByFBYStatus_First(
			String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYStatus_First(
			brandApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYStatus_First(
		String brandApprovalStatus,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByFBYStatus_First(
			brandApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByFBYStatus_Last(
			String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYStatus_Last(
			brandApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYStatus_Last(
		String brandApprovalStatus,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByFBYStatus_Last(
			brandApprovalStatus, orderByComparator);
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public static Brand[] findByFBYStatus_PrevAndNext(
			long brandId, String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYStatus_PrevAndNext(
			brandId, brandApprovalStatus, orderByComparator);
	}

	/**
	 * Removes all the brands where brandApprovalStatus = &#63; from the database.
	 *
	 * @param brandApprovalStatus the brand approval status
	 */
	public static void removeByFBYStatus(String brandApprovalStatus) {
		getPersistence().removeByFBYStatus(brandApprovalStatus);
	}

	/**
	 * Returns the number of brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the number of matching brands
	 */
	public static int countByFBYStatus(String brandApprovalStatus) {
		return getPersistence().countByFBYStatus(brandApprovalStatus);
	}

	/**
	 * Returns all the brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching brands
	 */
	public static List<Brand> findByFBYCreatedBy(long createdBy) {
		return getPersistence().findByFBYCreatedBy(createdBy);
	}

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
	public static List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end) {

		return getPersistence().findByFBYCreatedBy(createdBy, start, end);
	}

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
	public static List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findByFBYCreatedBy(
			createdBy, start, end, orderByComparator);
	}

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
	public static List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFBYCreatedBy(
			createdBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByFBYCreatedBy_First(
			long createdBy, OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYCreatedBy_First(
			createdBy, orderByComparator);
	}

	/**
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYCreatedBy_First(
		long createdBy, OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByFBYCreatedBy_First(
			createdBy, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByFBYCreatedBy_Last(
			long createdBy, OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYCreatedBy_Last(
			createdBy, orderByComparator);
	}

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYCreatedBy_Last(
		long createdBy, OrderByComparator<Brand> orderByComparator) {

		return getPersistence().fetchByFBYCreatedBy_Last(
			createdBy, orderByComparator);
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where createdBy = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public static Brand[] findByFBYCreatedBy_PrevAndNext(
			long brandId, long createdBy,
			OrderByComparator<Brand> orderByComparator)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYCreatedBy_PrevAndNext(
			brandId, createdBy, orderByComparator);
	}

	/**
	 * Removes all the brands where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 */
	public static void removeByFBYCreatedBy(long createdBy) {
		getPersistence().removeByFBYCreatedBy(createdBy);
	}

	/**
	 * Returns the number of brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching brands
	 */
	public static int countByFBYCreatedBy(long createdBy) {
		return getPersistence().countByFBYCreatedBy(createdBy);
	}

	/**
	 * Returns the brand where assetCategoryId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	public static Brand findByFBYAssetCategoryId(long assetCategoryId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYAssetCategoryId(long assetCategoryId) {
		return getPersistence().fetchByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchByFBYAssetCategoryId(
		long assetCategoryId, boolean useFinderCache) {

		return getPersistence().fetchByFBYAssetCategoryId(
			assetCategoryId, useFinderCache);
	}

	/**
	 * Removes the brand where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the brand that was removed
	 */
	public static Brand removeByFBYAssetCategoryId(long assetCategoryId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().removeByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Returns the number of brands where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching brands
	 */
	public static int countByFBYAssetCategoryId(long assetCategoryId) {
		return getPersistence().countByFBYAssetCategoryId(assetCategoryId);
	}

	/**
	 * Caches the brand in the entity cache if it is enabled.
	 *
	 * @param brand the brand
	 */
	public static void cacheResult(Brand brand) {
		getPersistence().cacheResult(brand);
	}

	/**
	 * Caches the brands in the entity cache if it is enabled.
	 *
	 * @param brands the brands
	 */
	public static void cacheResult(List<Brand> brands) {
		getPersistence().cacheResult(brands);
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	public static Brand create(long brandId) {
		return getPersistence().create(brandId);
	}

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public static Brand remove(long brandId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().remove(brandId);
	}

	public static Brand updateImpl(Brand brand) {
		return getPersistence().updateImpl(brand);
	}

	/**
	 * Returns the brand with the primary key or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	public static Brand findByPrimaryKey(long brandId)
		throws com.marketplace.brand.exception.NoSuchBrandException {

		return getPersistence().findByPrimaryKey(brandId);
	}

	/**
	 * Returns the brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand, or <code>null</code> if a brand with the primary key could not be found
	 */
	public static Brand fetchByPrimaryKey(long brandId) {
		return getPersistence().fetchByPrimaryKey(brandId);
	}

	/**
	 * Returns all the brands.
	 *
	 * @return the brands
	 */
	public static List<Brand> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Brand> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the brands from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BrandPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BrandPersistence _persistence;

}