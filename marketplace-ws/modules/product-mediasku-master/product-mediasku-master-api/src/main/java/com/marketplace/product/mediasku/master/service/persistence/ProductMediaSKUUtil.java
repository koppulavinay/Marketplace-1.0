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

package com.marketplace.product.mediasku.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.mediasku.master.model.ProductMediaSKU;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product media sku service. This utility wraps <code>com.marketplace.product.mediasku.master.service.persistence.impl.ProductMediaSKUPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKUPersistence
 * @generated
 */
public class ProductMediaSKUUtil {

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
	public static void clearCache(ProductMediaSKU productMediaSKU) {
		getPersistence().clearCache(productMediaSKU);
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
	public static Map<Serializable, ProductMediaSKU> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductMediaSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductMediaSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductMediaSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductMediaSKU update(ProductMediaSKU productMediaSKU) {
		return getPersistence().update(productMediaSKU);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductMediaSKU update(
		ProductMediaSKU productMediaSKU, ServiceContext serviceContext) {

		return getPersistence().update(productMediaSKU, serviceContext);
	}

	/**
	 * Returns all the product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByUuid_First(
			String uuid, OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUuid_First(
		String uuid, OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByUuid_Last(
			String uuid, OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUuid_Last(
		String uuid, OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU[] findByUuid_PrevAndNext(
			long ProductMediaSKUId, String uuid,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_PrevAndNext(
			ProductMediaSKUId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product media skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product media skus
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product media sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product media sku that was removed
	 */
	public static ProductMediaSKU removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product media skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product media skus
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU[] findByUuid_C_PrevAndNext(
			long ProductMediaSKUId, String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ProductMediaSKUId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product media skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product media skus
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		return getPersistence().findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId);
	}

	/**
	 * Returns a range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end) {

		return getPersistence().findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByproductSKUIdWithDraftProductId_First(
			long draftProductId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByproductSKUIdWithDraftProductId_First(
			draftProductId, productSKUId, orderByComparator);
	}

	/**
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByproductSKUIdWithDraftProductId_First(
		long draftProductId, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByproductSKUIdWithDraftProductId_First(
			draftProductId, productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByproductSKUIdWithDraftProductId_Last(
			long draftProductId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByproductSKUIdWithDraftProductId_Last(
			draftProductId, productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByproductSKUIdWithDraftProductId_Last(
		long draftProductId, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByproductSKUIdWithDraftProductId_Last(
			draftProductId, productSKUId, orderByComparator);
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU[]
			findByproductSKUIdWithDraftProductId_PrevAndNext(
				long ProductMediaSKUId, long draftProductId, long productSKUId,
				OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().
			findByproductSKUIdWithDraftProductId_PrevAndNext(
				ProductMediaSKUId, draftProductId, productSKUId,
				orderByComparator);
	}

	/**
	 * Removes all the product media skus where draftProductId = &#63; and productSKUId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 */
	public static void removeByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		getPersistence().removeByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId);
	}

	/**
	 * Returns the number of product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public static int countByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		return getPersistence().countByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId);
	}

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSkuId(long productSKUId) {
		return getPersistence().findByproductSkuId(productSKUId);
	}

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end) {

		return getPersistence().findByproductSkuId(productSKUId, start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findByproductSkuId(
			productSKUId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproductSkuId(
			productSKUId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByproductSkuId_First(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByproductSkuId_First(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByproductSkuId_First(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByproductSkuId_First(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByproductSkuId_Last(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByproductSkuId_Last(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByproductSkuId_Last(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByproductSkuId_Last(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU[] findByproductSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByproductSkuId_PrevAndNext(
			ProductMediaSKUId, productSKUId, orderByComparator);
	}

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	public static void removeByproductSkuId(long productSKUId) {
		getPersistence().removeByproductSkuId(productSKUId);
	}

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public static int countByproductSkuId(long productSKUId) {
		return getPersistence().countByproductSkuId(productSKUId);
	}

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public static List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId) {

		return getPersistence().findByProductMediaSkuId(productSKUId);
	}

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end) {

		return getPersistence().findByProductMediaSkuId(
			productSKUId, start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findByProductMediaSkuId(
			productSKUId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public static List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProductMediaSkuId(
			productSKUId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByProductMediaSkuId_First(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByProductMediaSkuId_First(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByProductMediaSkuId_First(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByProductMediaSkuId_First(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU findByProductMediaSkuId_Last(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByProductMediaSkuId_Last(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchByProductMediaSkuId_Last(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().fetchByProductMediaSkuId_Last(
			productSKUId, orderByComparator);
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU[] findByProductMediaSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByProductMediaSkuId_PrevAndNext(
			ProductMediaSKUId, productSKUId, orderByComparator);
	}

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	public static void removeByProductMediaSkuId(long productSKUId) {
		getPersistence().removeByProductMediaSkuId(productSKUId);
	}

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public static int countByProductMediaSkuId(long productSKUId) {
		return getPersistence().countByProductMediaSkuId(productSKUId);
	}

	/**
	 * Caches the product media sku in the entity cache if it is enabled.
	 *
	 * @param productMediaSKU the product media sku
	 */
	public static void cacheResult(ProductMediaSKU productMediaSKU) {
		getPersistence().cacheResult(productMediaSKU);
	}

	/**
	 * Caches the product media skus in the entity cache if it is enabled.
	 *
	 * @param productMediaSKUs the product media skus
	 */
	public static void cacheResult(List<ProductMediaSKU> productMediaSKUs) {
		getPersistence().cacheResult(productMediaSKUs);
	}

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	public static ProductMediaSKU create(long ProductMediaSKUId) {
		return getPersistence().create(ProductMediaSKUId);
	}

	/**
	 * Removes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU remove(long ProductMediaSKUId)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().remove(ProductMediaSKUId);
	}

	public static ProductMediaSKU updateImpl(ProductMediaSKU productMediaSKU) {
		return getPersistence().updateImpl(productMediaSKU);
	}

	/**
	 * Returns the product media sku with the primary key or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU findByPrimaryKey(long ProductMediaSKUId)
		throws com.marketplace.product.mediasku.master.exception.
			NoSuchProductMediaSKUException {

		return getPersistence().findByPrimaryKey(ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku, or <code>null</code> if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU fetchByPrimaryKey(long ProductMediaSKUId) {
		return getPersistence().fetchByPrimaryKey(ProductMediaSKUId);
	}

	/**
	 * Returns all the product media skus.
	 *
	 * @return the product media skus
	 */
	public static List<ProductMediaSKU> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of product media skus
	 */
	public static List<ProductMediaSKU> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product media skus
	 */
	public static List<ProductMediaSKU> findAll(
		int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product media skus
	 */
	public static List<ProductMediaSKU> findAll(
		int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product media skus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductMediaSKUPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductMediaSKUPersistence _persistence;

}