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

package com.marketplace.specification.field.data.type.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.field.data.type.model.SpecFieldDataType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the spec field data type service. This utility wraps <code>com.marketplace.specification.field.data.type.service.persistence.impl.SpecFieldDataTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldDataTypePersistence
 * @generated
 */
public class SpecFieldDataTypeUtil {

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
	public static void clearCache(SpecFieldDataType specFieldDataType) {
		getPersistence().clearCache(specFieldDataType);
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
	public static Map<Serializable, SpecFieldDataType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SpecFieldDataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpecFieldDataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpecFieldDataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SpecFieldDataType update(
		SpecFieldDataType specFieldDataType) {

		return getPersistence().update(specFieldDataType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SpecFieldDataType update(
		SpecFieldDataType specFieldDataType, ServiceContext serviceContext) {

		return getPersistence().update(specFieldDataType, serviceContext);
	}

	/**
	 * Returns all the spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field data types
	 */
	public static List<SpecFieldDataType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of matching spec field data types
	 */
	public static List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field data types
	 */
	public static List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field data types
	 */
	public static List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	public static SpecFieldDataType findByUuid_First(
			String uuid, OrderByComparator<SpecFieldDataType> orderByComparator)
		throws com.marketplace.specification.field.data.type.exception.
			NoSuchSpecFieldDataTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	public static SpecFieldDataType fetchByUuid_First(
		String uuid, OrderByComparator<SpecFieldDataType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	public static SpecFieldDataType findByUuid_Last(
			String uuid, OrderByComparator<SpecFieldDataType> orderByComparator)
		throws com.marketplace.specification.field.data.type.exception.
			NoSuchSpecFieldDataTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	public static SpecFieldDataType fetchByUuid_Last(
		String uuid, OrderByComparator<SpecFieldDataType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the spec field data types before and after the current spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldDataTypeId the primary key of the current spec field data type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public static SpecFieldDataType[] findByUuid_PrevAndNext(
			long specFieldDataTypeId, String uuid,
			OrderByComparator<SpecFieldDataType> orderByComparator)
		throws com.marketplace.specification.field.data.type.exception.
			NoSuchSpecFieldDataTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			specFieldDataTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the spec field data types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field data types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the spec field data type in the entity cache if it is enabled.
	 *
	 * @param specFieldDataType the spec field data type
	 */
	public static void cacheResult(SpecFieldDataType specFieldDataType) {
		getPersistence().cacheResult(specFieldDataType);
	}

	/**
	 * Caches the spec field data types in the entity cache if it is enabled.
	 *
	 * @param specFieldDataTypes the spec field data types
	 */
	public static void cacheResult(List<SpecFieldDataType> specFieldDataTypes) {
		getPersistence().cacheResult(specFieldDataTypes);
	}

	/**
	 * Creates a new spec field data type with the primary key. Does not add the spec field data type to the database.
	 *
	 * @param specFieldDataTypeId the primary key for the new spec field data type
	 * @return the new spec field data type
	 */
	public static SpecFieldDataType create(long specFieldDataTypeId) {
		return getPersistence().create(specFieldDataTypeId);
	}

	/**
	 * Removes the spec field data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type that was removed
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public static SpecFieldDataType remove(long specFieldDataTypeId)
		throws com.marketplace.specification.field.data.type.exception.
			NoSuchSpecFieldDataTypeException {

		return getPersistence().remove(specFieldDataTypeId);
	}

	public static SpecFieldDataType updateImpl(
		SpecFieldDataType specFieldDataType) {

		return getPersistence().updateImpl(specFieldDataType);
	}

	/**
	 * Returns the spec field data type with the primary key or throws a <code>NoSuchSpecFieldDataTypeException</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public static SpecFieldDataType findByPrimaryKey(long specFieldDataTypeId)
		throws com.marketplace.specification.field.data.type.exception.
			NoSuchSpecFieldDataTypeException {

		return getPersistence().findByPrimaryKey(specFieldDataTypeId);
	}

	/**
	 * Returns the spec field data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type, or <code>null</code> if a spec field data type with the primary key could not be found
	 */
	public static SpecFieldDataType fetchByPrimaryKey(
		long specFieldDataTypeId) {

		return getPersistence().fetchByPrimaryKey(specFieldDataTypeId);
	}

	/**
	 * Returns all the spec field data types.
	 *
	 * @return the spec field data types
	 */
	public static List<SpecFieldDataType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of spec field data types
	 */
	public static List<SpecFieldDataType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field data types
	 */
	public static List<SpecFieldDataType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field data types
	 */
	public static List<SpecFieldDataType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the spec field data types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of spec field data types.
	 *
	 * @return the number of spec field data types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecFieldDataTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecFieldDataTypePersistence _persistence;

}