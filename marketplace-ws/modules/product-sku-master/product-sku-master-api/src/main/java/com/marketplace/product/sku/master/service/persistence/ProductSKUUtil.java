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

package com.marketplace.product.sku.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.sku.master.model.ProductSKU;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product sku service. This utility wraps <code>com.marketplace.product.sku.master.service.persistence.impl.ProductSKUPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKUPersistence
 * @generated
 */
public class ProductSKUUtil {

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
	public static void clearCache(ProductSKU productSKU) {
		getPersistence().clearCache(productSKU);
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
	public static Map<Serializable, ProductSKU> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSKU> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductSKU update(ProductSKU productSKU) {
		return getPersistence().update(productSKU);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductSKU update(
		ProductSKU productSKU, ServiceContext serviceContext) {

		return getPersistence().update(productSKU, serviceContext);
	}

	/**
	 * Returns all the product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product skus
	 */
	public static List<ProductSKU> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public static List<ProductSKU> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByUuid_First(
			String uuid, OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUuid_First(
		String uuid, OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByUuid_Last(
			String uuid, OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUuid_Last(
		String uuid, OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU[] findByUuid_PrevAndNext(
			long productSKUId, String uuid,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_PrevAndNext(
			productSKUId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product skus
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product sku that was removed
	 */
	public static ProductSKU removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product skus
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product skus
	 */
	public static List<ProductSKU> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public static List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU[] findByUuid_C_PrevAndNext(
			long productSKUId, String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productSKUId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product skus
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product skus
	 */
	public static List<ProductSKU> findBySkuDraftProductId(
		long draftProductId) {

		return getPersistence().findBySkuDraftProductId(draftProductId);
	}

	/**
	 * Returns a range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public static List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end) {

		return getPersistence().findBySkuDraftProductId(
			draftProductId, start, end);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findBySkuDraftProductId(
			draftProductId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySkuDraftProductId(
			draftProductId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findBySkuDraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findBySkuDraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchBySkuDraftProductId_First(
		long draftProductId, OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchBySkuDraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findBySkuDraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findBySkuDraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchBySkuDraftProductId_Last(
		long draftProductId, OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchBySkuDraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU[] findBySkuDraftProductId_PrevAndNext(
			long productSKUId, long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findBySkuDraftProductId_PrevAndNext(
			productSKUId, draftProductId, orderByComparator);
	}

	/**
	 * Removes all the product skus where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public static void removeBySkuDraftProductId(long draftProductId) {
		getPersistence().removeBySkuDraftProductId(draftProductId);
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product skus
	 */
	public static int countBySkuDraftProductId(long draftProductId) {
		return getPersistence().countBySkuDraftProductId(draftProductId);
	}

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);
	}

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku) {

		return getPersistence().fetchByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);
	}

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku, boolean useFinderCache) {

		return getPersistence().fetchByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku, useFinderCache);
	}

	/**
	 * Removes the product sku where draftProductId = &#63; and defaultSku = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the product sku that was removed
	 */
	public static ProductSKU removeByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().removeByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63; and defaultSku = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the number of matching product skus
	 */
	public static int countByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku) {

		return getPersistence().countByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);
	}

	/**
	 * Returns all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the matching product skus
	 */
	public static List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		return getPersistence().findByDraftProductIdNSkuName(
			draftProductId, skuName);
	}

	/**
	 * Returns a range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public static List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end) {

		return getPersistence().findByDraftProductIdNSkuName(
			draftProductId, skuName, start, end);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findByDraftProductIdNSkuName(
			draftProductId, skuName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public static List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDraftProductIdNSkuName(
			draftProductId, skuName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByDraftProductIdNSkuName_First(
			long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByDraftProductIdNSkuName_First(
			draftProductId, skuName, orderByComparator);
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByDraftProductIdNSkuName_First(
		long draftProductId, String skuName,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByDraftProductIdNSkuName_First(
			draftProductId, skuName, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findByDraftProductIdNSkuName_Last(
			long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByDraftProductIdNSkuName_Last(
			draftProductId, skuName, orderByComparator);
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchByDraftProductIdNSkuName_Last(
		long draftProductId, String skuName,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().fetchByDraftProductIdNSkuName_Last(
			draftProductId, skuName, orderByComparator);
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU[] findByDraftProductIdNSkuName_PrevAndNext(
			long productSKUId, long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByDraftProductIdNSkuName_PrevAndNext(
			productSKUId, draftProductId, skuName, orderByComparator);
	}

	/**
	 * Removes all the product skus where draftProductId = &#63; and skuName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 */
	public static void removeByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		getPersistence().removeByDraftProductIdNSkuName(
			draftProductId, skuName);
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the number of matching product skus
	 */
	public static int countByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		return getPersistence().countByDraftProductIdNSkuName(
			draftProductId, skuName);
	}

	/**
	 * Returns the product sku where skuId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public static ProductSKU findBySkuId(String skuId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findBySkuId(skuId);
	}

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchBySkuId(String skuId) {
		return getPersistence().fetchBySkuId(skuId);
	}

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param skuId the sku ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchBySkuId(
		String skuId, boolean useFinderCache) {

		return getPersistence().fetchBySkuId(skuId, useFinderCache);
	}

	/**
	 * Removes the product sku where skuId = &#63; from the database.
	 *
	 * @param skuId the sku ID
	 * @return the product sku that was removed
	 */
	public static ProductSKU removeBySkuId(String skuId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().removeBySkuId(skuId);
	}

	/**
	 * Returns the number of product skus where skuId = &#63;.
	 *
	 * @param skuId the sku ID
	 * @return the number of matching product skus
	 */
	public static int countBySkuId(String skuId) {
		return getPersistence().countBySkuId(skuId);
	}

	/**
	 * Caches the product sku in the entity cache if it is enabled.
	 *
	 * @param productSKU the product sku
	 */
	public static void cacheResult(ProductSKU productSKU) {
		getPersistence().cacheResult(productSKU);
	}

	/**
	 * Caches the product skus in the entity cache if it is enabled.
	 *
	 * @param productSKUs the product skus
	 */
	public static void cacheResult(List<ProductSKU> productSKUs) {
		getPersistence().cacheResult(productSKUs);
	}

	/**
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	public static ProductSKU create(long productSKUId) {
		return getPersistence().create(productSKUId);
	}

	/**
	 * Removes the product sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku that was removed
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU remove(long productSKUId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().remove(productSKUId);
	}

	public static ProductSKU updateImpl(ProductSKU productSKU) {
		return getPersistence().updateImpl(productSKU);
	}

	/**
	 * Returns the product sku with the primary key or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public static ProductSKU findByPrimaryKey(long productSKUId)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getPersistence().findByPrimaryKey(productSKUId);
	}

	/**
	 * Returns the product sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku, or <code>null</code> if a product sku with the primary key could not be found
	 */
	public static ProductSKU fetchByPrimaryKey(long productSKUId) {
		return getPersistence().fetchByPrimaryKey(productSKUId);
	}

	/**
	 * Returns all the product skus.
	 *
	 * @return the product skus
	 */
	public static List<ProductSKU> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of product skus
	 */
	public static List<ProductSKU> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product skus
	 */
	public static List<ProductSKU> findAll(
		int start, int end, OrderByComparator<ProductSKU> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product skus
	 */
	public static List<ProductSKU> findAll(
		int start, int end, OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product skus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductSKUPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductSKUPersistence _persistence;

}