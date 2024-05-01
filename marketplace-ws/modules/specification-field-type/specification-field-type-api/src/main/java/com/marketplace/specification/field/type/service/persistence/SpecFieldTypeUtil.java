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

package com.marketplace.specification.field.type.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.field.type.model.SpecFieldType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the spec field type service. This utility wraps <code>com.marketplace.specification.field.type.service.persistence.impl.SpecFieldTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldTypePersistence
 * @generated
 */
public class SpecFieldTypeUtil {

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
	public static void clearCache(SpecFieldType specFieldType) {
		getPersistence().clearCache(specFieldType);
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
	public static Map<Serializable, SpecFieldType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SpecFieldType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpecFieldType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpecFieldType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SpecFieldType update(SpecFieldType specFieldType) {
		return getPersistence().update(specFieldType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SpecFieldType update(
		SpecFieldType specFieldType, ServiceContext serviceContext) {

		return getPersistence().update(specFieldType, serviceContext);
	}

	/**
	 * Returns all the spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field types
	 */
	public static List<SpecFieldType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of matching spec field types
	 */
	public static List<SpecFieldType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field types
	 */
	public static List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field types
	 */
	public static List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	public static SpecFieldType findByUuid_First(
			String uuid, OrderByComparator<SpecFieldType> orderByComparator)
		throws com.marketplace.specification.field.type.exception.
			NoSuchSpecFieldTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	public static SpecFieldType fetchByUuid_First(
		String uuid, OrderByComparator<SpecFieldType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	public static SpecFieldType findByUuid_Last(
			String uuid, OrderByComparator<SpecFieldType> orderByComparator)
		throws com.marketplace.specification.field.type.exception.
			NoSuchSpecFieldTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	public static SpecFieldType fetchByUuid_Last(
		String uuid, OrderByComparator<SpecFieldType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the spec field types before and after the current spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldTypeId the primary key of the current spec field type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public static SpecFieldType[] findByUuid_PrevAndNext(
			long specFieldTypeId, String uuid,
			OrderByComparator<SpecFieldType> orderByComparator)
		throws com.marketplace.specification.field.type.exception.
			NoSuchSpecFieldTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			specFieldTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the spec field types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the spec field type in the entity cache if it is enabled.
	 *
	 * @param specFieldType the spec field type
	 */
	public static void cacheResult(SpecFieldType specFieldType) {
		getPersistence().cacheResult(specFieldType);
	}

	/**
	 * Caches the spec field types in the entity cache if it is enabled.
	 *
	 * @param specFieldTypes the spec field types
	 */
	public static void cacheResult(List<SpecFieldType> specFieldTypes) {
		getPersistence().cacheResult(specFieldTypes);
	}

	/**
	 * Creates a new spec field type with the primary key. Does not add the spec field type to the database.
	 *
	 * @param specFieldTypeId the primary key for the new spec field type
	 * @return the new spec field type
	 */
	public static SpecFieldType create(long specFieldTypeId) {
		return getPersistence().create(specFieldTypeId);
	}

	/**
	 * Removes the spec field type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type that was removed
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public static SpecFieldType remove(long specFieldTypeId)
		throws com.marketplace.specification.field.type.exception.
			NoSuchSpecFieldTypeException {

		return getPersistence().remove(specFieldTypeId);
	}

	public static SpecFieldType updateImpl(SpecFieldType specFieldType) {
		return getPersistence().updateImpl(specFieldType);
	}

	/**
	 * Returns the spec field type with the primary key or throws a <code>NoSuchSpecFieldTypeException</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public static SpecFieldType findByPrimaryKey(long specFieldTypeId)
		throws com.marketplace.specification.field.type.exception.
			NoSuchSpecFieldTypeException {

		return getPersistence().findByPrimaryKey(specFieldTypeId);
	}

	/**
	 * Returns the spec field type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type, or <code>null</code> if a spec field type with the primary key could not be found
	 */
	public static SpecFieldType fetchByPrimaryKey(long specFieldTypeId) {
		return getPersistence().fetchByPrimaryKey(specFieldTypeId);
	}

	/**
	 * Returns all the spec field types.
	 *
	 * @return the spec field types
	 */
	public static List<SpecFieldType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of spec field types
	 */
	public static List<SpecFieldType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field types
	 */
	public static List<SpecFieldType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field types
	 */
	public static List<SpecFieldType> findAll(
		int start, int end, OrderByComparator<SpecFieldType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the spec field types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of spec field types.
	 *
	 * @return the number of spec field types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecFieldTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecFieldTypePersistence _persistence;

}