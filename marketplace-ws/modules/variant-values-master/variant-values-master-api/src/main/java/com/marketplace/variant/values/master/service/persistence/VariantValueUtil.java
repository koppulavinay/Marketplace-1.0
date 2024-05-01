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

package com.marketplace.variant.values.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.variant.values.master.model.VariantValue;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the variant value service. This utility wraps <code>com.marketplace.variant.values.master.service.persistence.impl.VariantValuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VariantValuePersistence
 * @generated
 */
public class VariantValueUtil {

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
	public static void clearCache(VariantValue variantValue) {
		getPersistence().clearCache(variantValue);
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
	public static Map<Serializable, VariantValue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VariantValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VariantValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VariantValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VariantValue update(VariantValue variantValue) {
		return getPersistence().update(variantValue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VariantValue update(
		VariantValue variantValue, ServiceContext serviceContext) {

		return getPersistence().update(variantValue, serviceContext);
	}

	/**
	 * Returns all the variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variant values
	 */
	public static List<VariantValue> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	public static List<VariantValue> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByUuid_First(
			String uuid, OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUuid_First(
		String uuid, OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByUuid_Last(
			String uuid, OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUuid_Last(
		String uuid, OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where uuid = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue[] findByUuid_PrevAndNext(
			long variantValueId, String uuid,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_PrevAndNext(
			variantValueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the variant values where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variant values
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByUUID_G(String uuid, long groupId)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the variant value where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the variant value that was removed
	 */
	public static VariantValue removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of variant values where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching variant values
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching variant values
	 */
	public static List<VariantValue> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	public static List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue[] findByUuid_C_PrevAndNext(
			long variantValueId, String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByUuid_C_PrevAndNext(
			variantValueId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the variant values where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching variant values
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the matching variant values
	 */
	public static List<VariantValue> findByproductVariantId(
		long productVariantId) {

		return getPersistence().findByproductVariantId(productVariantId);
	}

	/**
	 * Returns a range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	public static List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end) {

		return getPersistence().findByproductVariantId(
			productVariantId, start, end);
	}

	/**
	 * Returns an ordered range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findByproductVariantId(
			productVariantId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproductVariantId(
			productVariantId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByproductVariantId_First(
			long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByproductVariantId_First(
			productVariantId, orderByComparator);
	}

	/**
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByproductVariantId_First(
		long productVariantId,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByproductVariantId_First(
			productVariantId, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByproductVariantId_Last(
			long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByproductVariantId_Last(
			productVariantId, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByproductVariantId_Last(
		long productVariantId,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByproductVariantId_Last(
			productVariantId, orderByComparator);
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue[] findByproductVariantId_PrevAndNext(
			long variantValueId, long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByproductVariantId_PrevAndNext(
			variantValueId, productVariantId, orderByComparator);
	}

	/**
	 * Removes all the variant values where productVariantId = &#63; from the database.
	 *
	 * @param productVariantId the product variant ID
	 */
	public static void removeByproductVariantId(long productVariantId) {
		getPersistence().removeByproductVariantId(productVariantId);
	}

	/**
	 * Returns the number of variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the number of matching variant values
	 */
	public static int countByproductVariantId(long productVariantId) {
		return getPersistence().countByproductVariantId(productVariantId);
	}

	/**
	 * Returns all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the matching variant values
	 */
	public static List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal) {

		return getPersistence().findByvalueAndId(draftProductId, variantVal);
	}

	/**
	 * Returns a range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	public static List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end) {

		return getPersistence().findByvalueAndId(
			draftProductId, variantVal, start, end);
	}

	/**
	 * Returns an ordered range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findByvalueAndId(
			draftProductId, variantVal, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	public static List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByvalueAndId(
			draftProductId, variantVal, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByvalueAndId_First(
			long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByvalueAndId_First(
			draftProductId, variantVal, orderByComparator);
	}

	/**
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByvalueAndId_First(
		long draftProductId, String variantVal,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByvalueAndId_First(
			draftProductId, variantVal, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public static VariantValue findByvalueAndId_Last(
			long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByvalueAndId_Last(
			draftProductId, variantVal, orderByComparator);
	}

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchByvalueAndId_Last(
		long draftProductId, String variantVal,
		OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().fetchByvalueAndId_Last(
			draftProductId, variantVal, orderByComparator);
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue[] findByvalueAndId_PrevAndNext(
			long variantValueId, long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByvalueAndId_PrevAndNext(
			variantValueId, draftProductId, variantVal, orderByComparator);
	}

	/**
	 * Removes all the variant values where draftProductId = &#63; and variantVal = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 */
	public static void removeByvalueAndId(
		long draftProductId, String variantVal) {

		getPersistence().removeByvalueAndId(draftProductId, variantVal);
	}

	/**
	 * Returns the number of variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the number of matching variant values
	 */
	public static int countByvalueAndId(
		long draftProductId, String variantVal) {

		return getPersistence().countByvalueAndId(draftProductId, variantVal);
	}

	/**
	 * Caches the variant value in the entity cache if it is enabled.
	 *
	 * @param variantValue the variant value
	 */
	public static void cacheResult(VariantValue variantValue) {
		getPersistence().cacheResult(variantValue);
	}

	/**
	 * Caches the variant values in the entity cache if it is enabled.
	 *
	 * @param variantValues the variant values
	 */
	public static void cacheResult(List<VariantValue> variantValues) {
		getPersistence().cacheResult(variantValues);
	}

	/**
	 * Creates a new variant value with the primary key. Does not add the variant value to the database.
	 *
	 * @param variantValueId the primary key for the new variant value
	 * @return the new variant value
	 */
	public static VariantValue create(long variantValueId) {
		return getPersistence().create(variantValueId);
	}

	/**
	 * Removes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue remove(long variantValueId)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().remove(variantValueId);
	}

	public static VariantValue updateImpl(VariantValue variantValue) {
		return getPersistence().updateImpl(variantValue);
	}

	/**
	 * Returns the variant value with the primary key or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public static VariantValue findByPrimaryKey(long variantValueId)
		throws com.marketplace.variant.values.master.exception.
			NoSuchVariantValueException {

		return getPersistence().findByPrimaryKey(variantValueId);
	}

	/**
	 * Returns the variant value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value, or <code>null</code> if a variant value with the primary key could not be found
	 */
	public static VariantValue fetchByPrimaryKey(long variantValueId) {
		return getPersistence().fetchByPrimaryKey(variantValueId);
	}

	/**
	 * Returns all the variant values.
	 *
	 * @return the variant values
	 */
	public static List<VariantValue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of variant values
	 */
	public static List<VariantValue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of variant values
	 */
	public static List<VariantValue> findAll(
		int start, int end, OrderByComparator<VariantValue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of variant values
	 */
	public static List<VariantValue> findAll(
		int start, int end, OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the variant values from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of variant values.
	 *
	 * @return the number of variant values
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VariantValuePersistence getPersistence() {
		return _persistence;
	}

	private static volatile VariantValuePersistence _persistence;

}