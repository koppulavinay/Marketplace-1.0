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

package com.marketplace.specification.value.uoms.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.value.uoms.model.SpecValueUom;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the spec value uom service. This utility wraps <code>com.marketplace.specification.value.uoms.service.persistence.impl.SpecValueUomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecValueUomPersistence
 * @generated
 */
public class SpecValueUomUtil {

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
	public static void clearCache(SpecValueUom specValueUom) {
		getPersistence().clearCache(specValueUom);
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
	public static Map<Serializable, SpecValueUom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SpecValueUom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpecValueUom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpecValueUom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SpecValueUom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SpecValueUom update(SpecValueUom specValueUom) {
		return getPersistence().update(specValueUom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SpecValueUom update(
		SpecValueUom specValueUom, ServiceContext serviceContext) {

		return getPersistence().update(specValueUom, serviceContext);
	}

	/**
	 * Returns all the spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec value uoms
	 */
	public static List<SpecValueUom> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of matching spec value uoms
	 */
	public static List<SpecValueUom> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec value uoms
	 */
	public static List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecValueUom> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec value uoms
	 */
	public static List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecValueUom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	public static SpecValueUom findByUuid_First(
			String uuid, OrderByComparator<SpecValueUom> orderByComparator)
		throws com.marketplace.specification.value.uoms.exception.
			NoSuchSpecValueUomException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	public static SpecValueUom fetchByUuid_First(
		String uuid, OrderByComparator<SpecValueUom> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	public static SpecValueUom findByUuid_Last(
			String uuid, OrderByComparator<SpecValueUom> orderByComparator)
		throws com.marketplace.specification.value.uoms.exception.
			NoSuchSpecValueUomException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	public static SpecValueUom fetchByUuid_Last(
		String uuid, OrderByComparator<SpecValueUom> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the spec value uoms before and after the current spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param specValueUomId the primary key of the current spec value uom
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public static SpecValueUom[] findByUuid_PrevAndNext(
			long specValueUomId, String uuid,
			OrderByComparator<SpecValueUom> orderByComparator)
		throws com.marketplace.specification.value.uoms.exception.
			NoSuchSpecValueUomException {

		return getPersistence().findByUuid_PrevAndNext(
			specValueUomId, uuid, orderByComparator);
	}

	/**
	 * Removes all the spec value uoms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec value uoms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the spec value uom in the entity cache if it is enabled.
	 *
	 * @param specValueUom the spec value uom
	 */
	public static void cacheResult(SpecValueUom specValueUom) {
		getPersistence().cacheResult(specValueUom);
	}

	/**
	 * Caches the spec value uoms in the entity cache if it is enabled.
	 *
	 * @param specValueUoms the spec value uoms
	 */
	public static void cacheResult(List<SpecValueUom> specValueUoms) {
		getPersistence().cacheResult(specValueUoms);
	}

	/**
	 * Creates a new spec value uom with the primary key. Does not add the spec value uom to the database.
	 *
	 * @param specValueUomId the primary key for the new spec value uom
	 * @return the new spec value uom
	 */
	public static SpecValueUom create(long specValueUomId) {
		return getPersistence().create(specValueUomId);
	}

	/**
	 * Removes the spec value uom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom that was removed
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public static SpecValueUom remove(long specValueUomId)
		throws com.marketplace.specification.value.uoms.exception.
			NoSuchSpecValueUomException {

		return getPersistence().remove(specValueUomId);
	}

	public static SpecValueUom updateImpl(SpecValueUom specValueUom) {
		return getPersistence().updateImpl(specValueUom);
	}

	/**
	 * Returns the spec value uom with the primary key or throws a <code>NoSuchSpecValueUomException</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public static SpecValueUom findByPrimaryKey(long specValueUomId)
		throws com.marketplace.specification.value.uoms.exception.
			NoSuchSpecValueUomException {

		return getPersistence().findByPrimaryKey(specValueUomId);
	}

	/**
	 * Returns the spec value uom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom, or <code>null</code> if a spec value uom with the primary key could not be found
	 */
	public static SpecValueUom fetchByPrimaryKey(long specValueUomId) {
		return getPersistence().fetchByPrimaryKey(specValueUomId);
	}

	/**
	 * Returns all the spec value uoms.
	 *
	 * @return the spec value uoms
	 */
	public static List<SpecValueUom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of spec value uoms
	 */
	public static List<SpecValueUom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec value uoms
	 */
	public static List<SpecValueUom> findAll(
		int start, int end, OrderByComparator<SpecValueUom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec value uoms
	 */
	public static List<SpecValueUom> findAll(
		int start, int end, OrderByComparator<SpecValueUom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the spec value uoms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of spec value uoms.
	 *
	 * @return the number of spec value uoms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecValueUomPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecValueUomPersistence _persistence;

}