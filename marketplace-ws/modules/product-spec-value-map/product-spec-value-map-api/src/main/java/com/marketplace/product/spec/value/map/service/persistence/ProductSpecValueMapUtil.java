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

package com.marketplace.product.spec.value.map.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product spec value map service. This utility wraps <code>com.marketplace.product.spec.value.map.service.persistence.impl.ProductSpecValueMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMapPersistence
 * @generated
 */
public class ProductSpecValueMapUtil {

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
	public static void clearCache(ProductSpecValueMap productSpecValueMap) {
		getPersistence().clearCache(productSpecValueMap);
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
	public static Map<Serializable, ProductSpecValueMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductSpecValueMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSpecValueMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSpecValueMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductSpecValueMap update(
		ProductSpecValueMap productSpecValueMap) {

		return getPersistence().update(productSpecValueMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductSpecValueMap update(
		ProductSpecValueMap productSpecValueMap,
		ServiceContext serviceContext) {

		return getPersistence().update(productSpecValueMap, serviceContext);
	}

	/**
	 * Returns all the product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUuid_First(
		String uuid, OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUuid_Last(
		String uuid, OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap[] findByUuid_PrevAndNext(
			long productSpecValueId, String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_PrevAndNext(
			productSpecValueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product spec value maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product spec value maps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product spec value map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product spec value map that was removed
	 */
	public static ProductSpecValueMap removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product spec value maps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap[] findByUuid_C_PrevAndNext(
			long productSpecValueId, String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productSpecValueId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product spec value maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product spec value maps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId) {

		return getPersistence().findByproductSpecificationId(
			productSpecificationId);
	}

	/**
	 * Returns a range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end) {

		return getPersistence().findByproductSpecificationId(
			productSpecificationId, start, end);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().findByproductSpecificationId(
			productSpecificationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public static List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproductSpecificationId(
			productSpecificationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByproductSpecificationId_First(
			long productSpecificationId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByproductSpecificationId_First(
			productSpecificationId, orderByComparator);
	}

	/**
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByproductSpecificationId_First(
		long productSpecificationId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByproductSpecificationId_First(
			productSpecificationId, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByproductSpecificationId_Last(
			long productSpecificationId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByproductSpecificationId_Last(
			productSpecificationId, orderByComparator);
	}

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByproductSpecificationId_Last(
		long productSpecificationId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().fetchByproductSpecificationId_Last(
			productSpecificationId, orderByComparator);
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap[]
			findByproductSpecificationId_PrevAndNext(
				long productSpecValueId, long productSpecificationId,
				OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByproductSpecificationId_PrevAndNext(
			productSpecValueId, productSpecificationId, orderByComparator);
	}

	/**
	 * Removes all the product spec value maps where productSpecificationId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 */
	public static void removeByproductSpecificationId(
		long productSpecificationId) {

		getPersistence().removeByproductSpecificationId(productSpecificationId);
	}

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the number of matching product spec value maps
	 */
	public static int countByproductSpecificationId(
		long productSpecificationId) {

		return getPersistence().countByproductSpecificationId(
			productSpecificationId);
	}

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap findByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId);
	}

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId) {

		return getPersistence().fetchByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId);
	}

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public static ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId,
		boolean useFinderCache) {

		return getPersistence().fetchByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId, useFinderCache);
	}

	/**
	 * Removes the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the product spec value map that was removed
	 */
	public static ProductSpecValueMap removeByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().removeByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId);
	}

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63; and specificationValueLabelId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the number of matching product spec value maps
	 */
	public static int countByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId) {

		return getPersistence().countByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId);
	}

	/**
	 * Caches the product spec value map in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMap the product spec value map
	 */
	public static void cacheResult(ProductSpecValueMap productSpecValueMap) {
		getPersistence().cacheResult(productSpecValueMap);
	}

	/**
	 * Caches the product spec value maps in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMaps the product spec value maps
	 */
	public static void cacheResult(
		List<ProductSpecValueMap> productSpecValueMaps) {

		getPersistence().cacheResult(productSpecValueMaps);
	}

	/**
	 * Creates a new product spec value map with the primary key. Does not add the product spec value map to the database.
	 *
	 * @param productSpecValueId the primary key for the new product spec value map
	 * @return the new product spec value map
	 */
	public static ProductSpecValueMap create(long productSpecValueId) {
		return getPersistence().create(productSpecValueId);
	}

	/**
	 * Removes the product spec value map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map that was removed
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap remove(long productSpecValueId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().remove(productSpecValueId);
	}

	public static ProductSpecValueMap updateImpl(
		ProductSpecValueMap productSpecValueMap) {

		return getPersistence().updateImpl(productSpecValueMap);
	}

	/**
	 * Returns the product spec value map with the primary key or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap findByPrimaryKey(long productSpecValueId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return getPersistence().findByPrimaryKey(productSpecValueId);
	}

	/**
	 * Returns the product spec value map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map, or <code>null</code> if a product spec value map with the primary key could not be found
	 */
	public static ProductSpecValueMap fetchByPrimaryKey(
		long productSpecValueId) {

		return getPersistence().fetchByPrimaryKey(productSpecValueId);
	}

	/**
	 * Returns all the product spec value maps.
	 *
	 * @return the product spec value maps
	 */
	public static List<ProductSpecValueMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of product spec value maps
	 */
	public static List<ProductSpecValueMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product spec value maps
	 */
	public static List<ProductSpecValueMap> findAll(
		int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product spec value maps
	 */
	public static List<ProductSpecValueMap> findAll(
		int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product spec value maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product spec value maps.
	 *
	 * @return the number of product spec value maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductSpecValueMapPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductSpecValueMapPersistence _persistence;

}