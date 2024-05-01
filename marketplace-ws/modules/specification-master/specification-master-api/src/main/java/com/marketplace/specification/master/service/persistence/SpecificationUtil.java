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

package com.marketplace.specification.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.master.model.Specification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the specification service. This utility wraps <code>com.marketplace.specification.master.service.persistence.impl.SpecificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationPersistence
 * @generated
 */
public class SpecificationUtil {

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
	public static void clearCache(Specification specification) {
		getPersistence().clearCache(specification);
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
	public static Map<Serializable, Specification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Specification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Specification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Specification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Specification update(Specification specification) {
		return getPersistence().update(specification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Specification update(
		Specification specification, ServiceContext serviceContext) {

		return getPersistence().update(specification, serviceContext);
	}

	/**
	 * Returns all the specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching specifications
	 */
	public static List<Specification> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public static List<Specification> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Specification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findByUuid_First(
			String uuid, OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUuid_First(
		String uuid, OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findByUuid_Last(
			String uuid, OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUuid_Last(
		String uuid, OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public static Specification[] findByUuid_PrevAndNext(
			long specificationId, String uuid,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_PrevAndNext(
			specificationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching specifications
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findByUUID_G(String uuid, long groupId)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the specification that was removed
	 */
	public static Specification removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching specifications
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching specifications
	 */
	public static List<Specification> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public static List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Specification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public static Specification[] findByUuid_C_PrevAndNext(
			long specificationId, String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			specificationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching specifications
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the matching specifications
	 */
	public static List<Specification> findBySpecificationStatus(
		String specificationStatus) {

		return getPersistence().findBySpecificationStatus(specificationStatus);
	}

	/**
	 * Returns a range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public static List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end) {

		return getPersistence().findBySpecificationStatus(
			specificationStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().findBySpecificationStatus(
			specificationStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public static List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		OrderByComparator<Specification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySpecificationStatus(
			specificationStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findBySpecificationStatus_First(
			String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findBySpecificationStatus_First(
			specificationStatus, orderByComparator);
	}

	/**
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchBySpecificationStatus_First(
		String specificationStatus,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchBySpecificationStatus_First(
			specificationStatus, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public static Specification findBySpecificationStatus_Last(
			String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findBySpecificationStatus_Last(
			specificationStatus, orderByComparator);
	}

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public static Specification fetchBySpecificationStatus_Last(
		String specificationStatus,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().fetchBySpecificationStatus_Last(
			specificationStatus, orderByComparator);
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public static Specification[] findBySpecificationStatus_PrevAndNext(
			long specificationId, String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findBySpecificationStatus_PrevAndNext(
			specificationId, specificationStatus, orderByComparator);
	}

	/**
	 * Removes all the specifications where specificationStatus = &#63; from the database.
	 *
	 * @param specificationStatus the specification status
	 */
	public static void removeBySpecificationStatus(String specificationStatus) {
		getPersistence().removeBySpecificationStatus(specificationStatus);
	}

	/**
	 * Returns the number of specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the number of matching specifications
	 */
	public static int countBySpecificationStatus(String specificationStatus) {
		return getPersistence().countBySpecificationStatus(specificationStatus);
	}

	/**
	 * Caches the specification in the entity cache if it is enabled.
	 *
	 * @param specification the specification
	 */
	public static void cacheResult(Specification specification) {
		getPersistence().cacheResult(specification);
	}

	/**
	 * Caches the specifications in the entity cache if it is enabled.
	 *
	 * @param specifications the specifications
	 */
	public static void cacheResult(List<Specification> specifications) {
		getPersistence().cacheResult(specifications);
	}

	/**
	 * Creates a new specification with the primary key. Does not add the specification to the database.
	 *
	 * @param specificationId the primary key for the new specification
	 * @return the new specification
	 */
	public static Specification create(long specificationId) {
		return getPersistence().create(specificationId);
	}

	/**
	 * Removes the specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification that was removed
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public static Specification remove(long specificationId)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().remove(specificationId);
	}

	public static Specification updateImpl(Specification specification) {
		return getPersistence().updateImpl(specification);
	}

	/**
	 * Returns the specification with the primary key or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public static Specification findByPrimaryKey(long specificationId)
		throws com.marketplace.specification.master.exception.
			NoSuchSpecificationException {

		return getPersistence().findByPrimaryKey(specificationId);
	}

	/**
	 * Returns the specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification, or <code>null</code> if a specification with the primary key could not be found
	 */
	public static Specification fetchByPrimaryKey(long specificationId) {
		return getPersistence().fetchByPrimaryKey(specificationId);
	}

	/**
	 * Returns all the specifications.
	 *
	 * @return the specifications
	 */
	public static List<Specification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of specifications
	 */
	public static List<Specification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specifications
	 */
	public static List<Specification> findAll(
		int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specifications
	 */
	public static List<Specification> findAll(
		int start, int end, OrderByComparator<Specification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the specifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of specifications.
	 *
	 * @return the number of specifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecificationPersistence _persistence;

}