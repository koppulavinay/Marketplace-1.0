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

package com.marketplace.checkout.consignee.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the checkout consignee details service. This utility wraps <code>com.marketplace.checkout.consignee.service.persistence.impl.CheckoutConsigneeDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetailsPersistence
 * @generated
 */
public class CheckoutConsigneeDetailsUtil {

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
	public static void clearCache(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		getPersistence().clearCache(checkoutConsigneeDetails);
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
	public static Map<Serializable, CheckoutConsigneeDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CheckoutConsigneeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CheckoutConsigneeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CheckoutConsigneeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CheckoutConsigneeDetails update(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return getPersistence().update(checkoutConsigneeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CheckoutConsigneeDetails update(
		CheckoutConsigneeDetails checkoutConsigneeDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			checkoutConsigneeDetails, serviceContext);
	}

	/**
	 * Returns all the checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByUuid_First(
			String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByUuid_Last(
			String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails[] findByUuid_PrevAndNext(
			long checkoutConsigneeId, String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			checkoutConsigneeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checkout consignee detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByUUID_G(
			String uuid, long groupId)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the checkout consignee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checkout consignee details that was removed
	 */
	public static CheckoutConsigneeDetails removeByUUID_G(
			String uuid, long groupId)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checkout consignee detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails[] findByUuid_C_PrevAndNext(
			long checkoutConsigneeId, String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			checkoutConsigneeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checkout consignee detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId) {

		return getPersistence().findByCartIdNOrderItemId(
			parentCartId, orderItemId);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end) {

		return getPersistence().findByCartIdNOrderItemId(
			parentCartId, orderItemId, start, end);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findByCartIdNOrderItemId(
			parentCartId, orderItemId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCartIdNOrderItemId(
			parentCartId, orderItemId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByCartIdNOrderItemId_First(
			long parentCartId, long orderItemId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByCartIdNOrderItemId_First(
			parentCartId, orderItemId, orderByComparator);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByCartIdNOrderItemId_First(
		long parentCartId, long orderItemId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByCartIdNOrderItemId_First(
			parentCartId, orderItemId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByCartIdNOrderItemId_Last(
			long parentCartId, long orderItemId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByCartIdNOrderItemId_Last(
			parentCartId, orderItemId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByCartIdNOrderItemId_Last(
		long parentCartId, long orderItemId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByCartIdNOrderItemId_Last(
			parentCartId, orderItemId, orderByComparator);
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails[]
			findByCartIdNOrderItemId_PrevAndNext(
				long checkoutConsigneeId, long parentCartId, long orderItemId,
				OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByCartIdNOrderItemId_PrevAndNext(
			checkoutConsigneeId, parentCartId, orderItemId, orderByComparator);
	}

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 */
	public static void removeByCartIdNOrderItemId(
		long parentCartId, long orderItemId) {

		getPersistence().removeByCartIdNOrderItemId(parentCartId, orderItemId);
	}

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the number of matching checkout consignee detailses
	 */
	public static int countByCartIdNOrderItemId(
		long parentCartId, long orderItemId) {

		return getPersistence().countByCartIdNOrderItemId(
			parentCartId, orderItemId);
	}

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId) {

		return getPersistence().findByParentCartId(parentCartId);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end) {

		return getPersistence().findByParentCartId(parentCartId, start, end);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findByParentCartId(
			parentCartId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCartId(
			parentCartId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByParentCartId_First(
			long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByParentCartId_First(
			parentCartId, orderByComparator);
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByParentCartId_First(
		long parentCartId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByParentCartId_First(
			parentCartId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails findByParentCartId_Last(
			long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByParentCartId_Last(
			parentCartId, orderByComparator);
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails fetchByParentCartId_Last(
		long parentCartId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().fetchByParentCartId_Last(
			parentCartId, orderByComparator);
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails[] findByParentCartId_PrevAndNext(
			long checkoutConsigneeId, long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByParentCartId_PrevAndNext(
			checkoutConsigneeId, parentCartId, orderByComparator);
	}

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 */
	public static void removeByParentCartId(long parentCartId) {
		getPersistence().removeByParentCartId(parentCartId);
	}

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the number of matching checkout consignee detailses
	 */
	public static int countByParentCartId(long parentCartId) {
		return getPersistence().countByParentCartId(parentCartId);
	}

	/**
	 * Caches the checkout consignee details in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 */
	public static void cacheResult(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		getPersistence().cacheResult(checkoutConsigneeDetails);
	}

	/**
	 * Caches the checkout consignee detailses in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetailses the checkout consignee detailses
	 */
	public static void cacheResult(
		List<CheckoutConsigneeDetails> checkoutConsigneeDetailses) {

		getPersistence().cacheResult(checkoutConsigneeDetailses);
	}

	/**
	 * Creates a new checkout consignee details with the primary key. Does not add the checkout consignee details to the database.
	 *
	 * @param checkoutConsigneeId the primary key for the new checkout consignee details
	 * @return the new checkout consignee details
	 */
	public static CheckoutConsigneeDetails create(long checkoutConsigneeId) {
		return getPersistence().create(checkoutConsigneeId);
	}

	/**
	 * Removes the checkout consignee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details that was removed
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails remove(long checkoutConsigneeId)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().remove(checkoutConsigneeId);
	}

	public static CheckoutConsigneeDetails updateImpl(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return getPersistence().updateImpl(checkoutConsigneeDetails);
	}

	/**
	 * Returns the checkout consignee details with the primary key or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails findByPrimaryKey(
			long checkoutConsigneeId)
		throws com.marketplace.checkout.consignee.exception.
			NoSuchCheckoutConsigneeDetailsException {

		return getPersistence().findByPrimaryKey(checkoutConsigneeId);
	}

	/**
	 * Returns the checkout consignee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details, or <code>null</code> if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails fetchByPrimaryKey(
		long checkoutConsigneeId) {

		return getPersistence().fetchByPrimaryKey(checkoutConsigneeId);
	}

	/**
	 * Returns all the checkout consignee detailses.
	 *
	 * @return the checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the checkout consignee detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of checkout consignee detailses.
	 *
	 * @return the number of checkout consignee detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CheckoutConsigneeDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CheckoutConsigneeDetailsPersistence _persistence;

}