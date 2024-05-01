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

package com.marketplace.specification.category.map.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.category.map.model.SpecCategoryMap;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the spec category map service. This utility wraps <code>com.marketplace.specification.category.map.service.persistence.impl.SpecCategoryMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapPersistence
 * @generated
 */
public class SpecCategoryMapUtil {

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
	public static void clearCache(SpecCategoryMap specCategoryMap) {
		getPersistence().clearCache(specCategoryMap);
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
	public static Map<Serializable, SpecCategoryMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SpecCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpecCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpecCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SpecCategoryMap update(SpecCategoryMap specCategoryMap) {
		return getPersistence().update(specCategoryMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SpecCategoryMap update(
		SpecCategoryMap specCategoryMap, ServiceContext serviceContext) {

		return getPersistence().update(specCategoryMap, serviceContext);
	}

	/**
	 * Returns all the spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByUuid_First(
			String uuid, OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByUuid_First(
		String uuid, OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByUuid_Last(
			String uuid, OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByUuid_Last(
		String uuid, OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap[] findByUuid_PrevAndNext(
			long specCategoryMapId, String uuid,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_PrevAndNext(
			specCategoryMapId, uuid, orderByComparator);
	}

	/**
	 * Removes all the spec category maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec category maps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap[] findByUuid_C_PrevAndNext(
			long specCategoryMapId, String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByUuid_C_PrevAndNext(
			specCategoryMapId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the spec category maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching spec category maps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId) {

		return getPersistence().findByFBYSpecificationId(specificationId);
	}

	/**
	 * Returns a range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end) {

		return getPersistence().findByFBYSpecificationId(
			specificationId, start, end);
	}

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findByFBYSpecificationId(
			specificationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFBYSpecificationId(
			specificationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByFBYSpecificationId_First(
			long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYSpecificationId_First(
			specificationId, orderByComparator);
	}

	/**
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByFBYSpecificationId_First(
		long specificationId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYSpecificationId_First(
			specificationId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByFBYSpecificationId_Last(
			long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYSpecificationId_Last(
			specificationId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByFBYSpecificationId_Last(
		long specificationId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYSpecificationId_Last(
			specificationId, orderByComparator);
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap[] findByFBYSpecificationId_PrevAndNext(
			long specCategoryMapId, long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYSpecificationId_PrevAndNext(
			specCategoryMapId, specificationId, orderByComparator);
	}

	/**
	 * Removes all the spec category maps where specificationId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 */
	public static void removeByFBYSpecificationId(long specificationId) {
		getPersistence().removeByFBYSpecificationId(specificationId);
	}

	/**
	 * Returns the number of spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the number of matching spec category maps
	 */
	public static int countByFBYSpecificationId(long specificationId) {
		return getPersistence().countByFBYSpecificationId(specificationId);
	}

	/**
	 * Returns all the spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYCategoryId(long categoryId) {
		return getPersistence().findByFBYCategoryId(categoryId);
	}

	/**
	 * Returns a range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end) {

		return getPersistence().findByFBYCategoryId(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findByFBYCategoryId(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public static List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFBYCategoryId(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByFBYCategoryId_First(
			long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByFBYCategoryId_First(
		long categoryId, OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findByFBYCategoryId_Last(
			long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchByFBYCategoryId_Last(
		long categoryId, OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap[] findByFBYCategoryId_PrevAndNext(
			long specCategoryMapId, long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByFBYCategoryId_PrevAndNext(
			specCategoryMapId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the spec category maps where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByFBYCategoryId(long categoryId) {
		getPersistence().removeByFBYCategoryId(categoryId);
	}

	/**
	 * Returns the number of spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	public static int countByFBYCategoryId(long categoryId) {
		return getPersistence().countByFBYCategoryId(categoryId);
	}

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap findBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findBySpecificationIdNCategoryId(
			specificationId, categoryId);
	}

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId) {

		return getPersistence().fetchBySpecificationIdNCategoryId(
			specificationId, categoryId);
	}

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId, boolean useFinderCache) {

		return getPersistence().fetchBySpecificationIdNCategoryId(
			specificationId, categoryId, useFinderCache);
	}

	/**
	 * Removes the spec category map where specificationId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the spec category map that was removed
	 */
	public static SpecCategoryMap removeBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().removeBySpecificationIdNCategoryId(
			specificationId, categoryId);
	}

	/**
	 * Returns the number of spec category maps where specificationId = &#63; and categoryId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	public static int countBySpecificationIdNCategoryId(
		long specificationId, long categoryId) {

		return getPersistence().countBySpecificationIdNCategoryId(
			specificationId, categoryId);
	}

	/**
	 * Caches the spec category map in the entity cache if it is enabled.
	 *
	 * @param specCategoryMap the spec category map
	 */
	public static void cacheResult(SpecCategoryMap specCategoryMap) {
		getPersistence().cacheResult(specCategoryMap);
	}

	/**
	 * Caches the spec category maps in the entity cache if it is enabled.
	 *
	 * @param specCategoryMaps the spec category maps
	 */
	public static void cacheResult(List<SpecCategoryMap> specCategoryMaps) {
		getPersistence().cacheResult(specCategoryMaps);
	}

	/**
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	public static SpecCategoryMap create(long specCategoryMapId) {
		return getPersistence().create(specCategoryMapId);
	}

	/**
	 * Removes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap remove(long specCategoryMapId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().remove(specCategoryMapId);
	}

	public static SpecCategoryMap updateImpl(SpecCategoryMap specCategoryMap) {
		return getPersistence().updateImpl(specCategoryMap);
	}

	/**
	 * Returns the spec category map with the primary key or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap findByPrimaryKey(long specCategoryMapId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getPersistence().findByPrimaryKey(specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map, or <code>null</code> if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap fetchByPrimaryKey(long specCategoryMapId) {
		return getPersistence().fetchByPrimaryKey(specCategoryMapId);
	}

	/**
	 * Returns all the spec category maps.
	 *
	 * @return the spec category maps
	 */
	public static List<SpecCategoryMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of spec category maps
	 */
	public static List<SpecCategoryMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec category maps
	 */
	public static List<SpecCategoryMap> findAll(
		int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec category maps
	 */
	public static List<SpecCategoryMap> findAll(
		int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the spec category maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecCategoryMapPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecCategoryMapPersistence _persistence;

}