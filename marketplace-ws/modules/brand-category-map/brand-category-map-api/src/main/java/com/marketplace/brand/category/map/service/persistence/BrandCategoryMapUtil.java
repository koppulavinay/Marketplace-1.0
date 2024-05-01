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

package com.marketplace.brand.category.map.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.brand.category.map.model.BrandCategoryMap;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the brand category map service. This utility wraps <code>com.marketplace.brand.category.map.service.persistence.impl.BrandCategoryMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandCategoryMapPersistence
 * @generated
 */
public class BrandCategoryMapUtil {

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
	public static void clearCache(BrandCategoryMap brandCategoryMap) {
		getPersistence().clearCache(brandCategoryMap);
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
	public static Map<Serializable, BrandCategoryMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BrandCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BrandCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BrandCategoryMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BrandCategoryMap update(BrandCategoryMap brandCategoryMap) {
		return getPersistence().update(brandCategoryMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BrandCategoryMap update(
		BrandCategoryMap brandCategoryMap, ServiceContext serviceContext) {

		return getPersistence().update(brandCategoryMap, serviceContext);
	}

	/**
	 * Returns all the brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand category maps
	 */
	public static List<BrandCategoryMap> findByFBYBrandId(long brandId) {
		return getPersistence().findByFBYBrandId(brandId);
	}

	/**
	 * Returns a range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of matching brand category maps
	 */
	public static List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end) {

		return getPersistence().findByFBYBrandId(brandId, start, end);
	}

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand category maps
	 */
	public static List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator) {

		return getPersistence().findByFBYBrandId(
			brandId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand category maps
	 */
	public static List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFBYBrandId(
			brandId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	public static BrandCategoryMap findByFBYBrandId_First(
			long brandId, OrderByComparator<BrandCategoryMap> orderByComparator)
		throws com.marketplace.brand.category.map.exception.
			NoSuchBrandCategoryMapException {

		return getPersistence().findByFBYBrandId_First(
			brandId, orderByComparator);
	}

	/**
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	public static BrandCategoryMap fetchByFBYBrandId_First(
		long brandId, OrderByComparator<BrandCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYBrandId_First(
			brandId, orderByComparator);
	}

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	public static BrandCategoryMap findByFBYBrandId_Last(
			long brandId, OrderByComparator<BrandCategoryMap> orderByComparator)
		throws com.marketplace.brand.category.map.exception.
			NoSuchBrandCategoryMapException {

		return getPersistence().findByFBYBrandId_Last(
			brandId, orderByComparator);
	}

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	public static BrandCategoryMap fetchByFBYBrandId_Last(
		long brandId, OrderByComparator<BrandCategoryMap> orderByComparator) {

		return getPersistence().fetchByFBYBrandId_Last(
			brandId, orderByComparator);
	}

	/**
	 * Returns the brand category maps before and after the current brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandCategoryMapId the primary key of the current brand category map
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public static BrandCategoryMap[] findByFBYBrandId_PrevAndNext(
			long brandCategoryMapId, long brandId,
			OrderByComparator<BrandCategoryMap> orderByComparator)
		throws com.marketplace.brand.category.map.exception.
			NoSuchBrandCategoryMapException {

		return getPersistence().findByFBYBrandId_PrevAndNext(
			brandCategoryMapId, brandId, orderByComparator);
	}

	/**
	 * Removes all the brand category maps where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	public static void removeByFBYBrandId(long brandId) {
		getPersistence().removeByFBYBrandId(brandId);
	}

	/**
	 * Returns the number of brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand category maps
	 */
	public static int countByFBYBrandId(long brandId) {
		return getPersistence().countByFBYBrandId(brandId);
	}

	/**
	 * Caches the brand category map in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMap the brand category map
	 */
	public static void cacheResult(BrandCategoryMap brandCategoryMap) {
		getPersistence().cacheResult(brandCategoryMap);
	}

	/**
	 * Caches the brand category maps in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMaps the brand category maps
	 */
	public static void cacheResult(List<BrandCategoryMap> brandCategoryMaps) {
		getPersistence().cacheResult(brandCategoryMaps);
	}

	/**
	 * Creates a new brand category map with the primary key. Does not add the brand category map to the database.
	 *
	 * @param brandCategoryMapId the primary key for the new brand category map
	 * @return the new brand category map
	 */
	public static BrandCategoryMap create(long brandCategoryMapId) {
		return getPersistence().create(brandCategoryMapId);
	}

	/**
	 * Removes the brand category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map that was removed
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public static BrandCategoryMap remove(long brandCategoryMapId)
		throws com.marketplace.brand.category.map.exception.
			NoSuchBrandCategoryMapException {

		return getPersistence().remove(brandCategoryMapId);
	}

	public static BrandCategoryMap updateImpl(
		BrandCategoryMap brandCategoryMap) {

		return getPersistence().updateImpl(brandCategoryMap);
	}

	/**
	 * Returns the brand category map with the primary key or throws a <code>NoSuchBrandCategoryMapException</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public static BrandCategoryMap findByPrimaryKey(long brandCategoryMapId)
		throws com.marketplace.brand.category.map.exception.
			NoSuchBrandCategoryMapException {

		return getPersistence().findByPrimaryKey(brandCategoryMapId);
	}

	/**
	 * Returns the brand category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map, or <code>null</code> if a brand category map with the primary key could not be found
	 */
	public static BrandCategoryMap fetchByPrimaryKey(long brandCategoryMapId) {
		return getPersistence().fetchByPrimaryKey(brandCategoryMapId);
	}

	/**
	 * Returns all the brand category maps.
	 *
	 * @return the brand category maps
	 */
	public static List<BrandCategoryMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of brand category maps
	 */
	public static List<BrandCategoryMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand category maps
	 */
	public static List<BrandCategoryMap> findAll(
		int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brand category maps
	 */
	public static List<BrandCategoryMap> findAll(
		int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the brand category maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of brand category maps.
	 *
	 * @return the number of brand category maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BrandCategoryMapPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BrandCategoryMapPersistence _persistence;

}