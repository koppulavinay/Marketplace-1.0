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

package com.marketplace.product.variant.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.variant.master.model.ProductVariant;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product variant service. This utility wraps <code>com.marketplace.product.variant.master.service.persistence.impl.ProductVariantPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariantPersistence
 * @generated
 */
public class ProductVariantUtil {

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
	public static void clearCache(ProductVariant productVariant) {
		getPersistence().clearCache(productVariant);
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
	public static Map<Serializable, ProductVariant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductVariant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductVariant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductVariant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductVariant update(ProductVariant productVariant) {
		return getPersistence().update(productVariant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductVariant update(
		ProductVariant productVariant, ServiceContext serviceContext) {

		return getPersistence().update(productVariant, serviceContext);
	}

	/**
	 * Returns all the product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product variants
	 */
	public static List<ProductVariant> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public static List<ProductVariant> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByUuid_First(
			String uuid, OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUuid_First(
		String uuid, OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByUuid_Last(
			String uuid, OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUuid_Last(
		String uuid, OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant[] findByUuid_PrevAndNext(
			long productVariantId, String uuid,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_PrevAndNext(
			productVariantId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product variants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product variants
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product variant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product variant that was removed
	 */
	public static ProductVariant removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product variants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product variants
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product variants
	 */
	public static List<ProductVariant> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public static List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant[] findByUuid_C_PrevAndNext(
			long productVariantId, String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productVariantId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product variants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product variants
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product variants
	 */
	public static List<ProductVariant> findBydraftProductId(
		long draftProductId) {

		return getPersistence().findBydraftProductId(draftProductId);
	}

	/**
	 * Returns a range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public static List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant[] findBydraftProductId_PrevAndNext(
			long productVariantId, long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findBydraftProductId_PrevAndNext(
			productVariantId, draftProductId, orderByComparator);
	}

	/**
	 * Removes all the product variants where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public static void removeBydraftProductId(long draftProductId) {
		getPersistence().removeBydraftProductId(draftProductId);
	}

	/**
	 * Returns the number of product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product variants
	 */
	public static int countBydraftProductId(long draftProductId) {
		return getPersistence().countBydraftProductId(draftProductId);
	}

	/**
	 * Returns all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the matching product variants
	 */
	public static List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName) {

		return getPersistence().findByvariantNameID(
			draftProductId, variantName);
	}

	/**
	 * Returns a range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public static List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end) {

		return getPersistence().findByvariantNameID(
			draftProductId, variantName, start, end);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findByvariantNameID(
			draftProductId, variantName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public static List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByvariantNameID(
			draftProductId, variantName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByvariantNameID_First(
			long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByvariantNameID_First(
			draftProductId, variantName, orderByComparator);
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByvariantNameID_First(
		long draftProductId, String variantName,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByvariantNameID_First(
			draftProductId, variantName, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public static ProductVariant findByvariantNameID_Last(
			long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByvariantNameID_Last(
			draftProductId, variantName, orderByComparator);
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public static ProductVariant fetchByvariantNameID_Last(
		long draftProductId, String variantName,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().fetchByvariantNameID_Last(
			draftProductId, variantName, orderByComparator);
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant[] findByvariantNameID_PrevAndNext(
			long productVariantId, long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByvariantNameID_PrevAndNext(
			productVariantId, draftProductId, variantName, orderByComparator);
	}

	/**
	 * Removes all the product variants where draftProductId = &#63; and variantName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 */
	public static void removeByvariantNameID(
		long draftProductId, String variantName) {

		getPersistence().removeByvariantNameID(draftProductId, variantName);
	}

	/**
	 * Returns the number of product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the number of matching product variants
	 */
	public static int countByvariantNameID(
		long draftProductId, String variantName) {

		return getPersistence().countByvariantNameID(
			draftProductId, variantName);
	}

	/**
	 * Caches the product variant in the entity cache if it is enabled.
	 *
	 * @param productVariant the product variant
	 */
	public static void cacheResult(ProductVariant productVariant) {
		getPersistence().cacheResult(productVariant);
	}

	/**
	 * Caches the product variants in the entity cache if it is enabled.
	 *
	 * @param productVariants the product variants
	 */
	public static void cacheResult(List<ProductVariant> productVariants) {
		getPersistence().cacheResult(productVariants);
	}

	/**
	 * Creates a new product variant with the primary key. Does not add the product variant to the database.
	 *
	 * @param productVariantId the primary key for the new product variant
	 * @return the new product variant
	 */
	public static ProductVariant create(long productVariantId) {
		return getPersistence().create(productVariantId);
	}

	/**
	 * Removes the product variant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant that was removed
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant remove(long productVariantId)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().remove(productVariantId);
	}

	public static ProductVariant updateImpl(ProductVariant productVariant) {
		return getPersistence().updateImpl(productVariant);
	}

	/**
	 * Returns the product variant with the primary key or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public static ProductVariant findByPrimaryKey(long productVariantId)
		throws com.marketplace.product.variant.master.exception.
			NoSuchProductVariantException {

		return getPersistence().findByPrimaryKey(productVariantId);
	}

	/**
	 * Returns the product variant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant, or <code>null</code> if a product variant with the primary key could not be found
	 */
	public static ProductVariant fetchByPrimaryKey(long productVariantId) {
		return getPersistence().fetchByPrimaryKey(productVariantId);
	}

	/**
	 * Returns all the product variants.
	 *
	 * @return the product variants
	 */
	public static List<ProductVariant> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of product variants
	 */
	public static List<ProductVariant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product variants
	 */
	public static List<ProductVariant> findAll(
		int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product variants
	 */
	public static List<ProductVariant> findAll(
		int start, int end, OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product variants from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product variants.
	 *
	 * @return the number of product variants
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductVariantPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductVariantPersistence _persistence;

}