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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.checkout.consignee.exception.NoSuchCheckoutConsigneeDetailsException;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the checkout consignee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetailsUtil
 * @generated
 */
@ProviderType
public interface CheckoutConsigneeDetailsPersistence
	extends BasePersistence<CheckoutConsigneeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CheckoutConsigneeDetailsUtil} to access the checkout consignee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checkout consignee detailses
	 */
	public java.util.List<CheckoutConsigneeDetails> findByUuid(String uuid);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public CheckoutConsigneeDetails[] findByUuid_PrevAndNext(
			long checkoutConsigneeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checkout consignee detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the checkout consignee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checkout consignee details that was removed
	 */
	public CheckoutConsigneeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checkout consignee detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checkout consignee detailses
	 */
	public java.util.List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public java.util.List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public CheckoutConsigneeDetails[] findByUuid_C_PrevAndNext(
			long checkoutConsigneeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checkout consignee detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the matching checkout consignee detailses
	 */
	public java.util.List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId);

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
	public java.util.List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end);

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
	public java.util.List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public java.util.List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByCartIdNOrderItemId_First(
			long parentCartId, long orderItemId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByCartIdNOrderItemId_First(
		long parentCartId, long orderItemId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByCartIdNOrderItemId_Last(
			long parentCartId, long orderItemId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByCartIdNOrderItemId_Last(
		long parentCartId, long orderItemId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public CheckoutConsigneeDetails[] findByCartIdNOrderItemId_PrevAndNext(
			long checkoutConsigneeId, long parentCartId, long orderItemId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 */
	public void removeByCartIdNOrderItemId(long parentCartId, long orderItemId);

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the number of matching checkout consignee detailses
	 */
	public int countByCartIdNOrderItemId(long parentCartId, long orderItemId);

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the matching checkout consignee detailses
	 */
	public java.util.List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId);

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
	public java.util.List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end);

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
	public java.util.List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public java.util.List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByParentCartId_First(
			long parentCartId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByParentCartId_First(
		long parentCartId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails findByParentCartId_Last(
			long parentCartId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public CheckoutConsigneeDetails fetchByParentCartId_Last(
		long parentCartId,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public CheckoutConsigneeDetails[] findByParentCartId_PrevAndNext(
			long checkoutConsigneeId, long parentCartId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 */
	public void removeByParentCartId(long parentCartId);

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the number of matching checkout consignee detailses
	 */
	public int countByParentCartId(long parentCartId);

	/**
	 * Caches the checkout consignee details in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 */
	public void cacheResult(CheckoutConsigneeDetails checkoutConsigneeDetails);

	/**
	 * Caches the checkout consignee detailses in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetailses the checkout consignee detailses
	 */
	public void cacheResult(
		java.util.List<CheckoutConsigneeDetails> checkoutConsigneeDetailses);

	/**
	 * Creates a new checkout consignee details with the primary key. Does not add the checkout consignee details to the database.
	 *
	 * @param checkoutConsigneeId the primary key for the new checkout consignee details
	 * @return the new checkout consignee details
	 */
	public CheckoutConsigneeDetails create(long checkoutConsigneeId);

	/**
	 * Removes the checkout consignee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details that was removed
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public CheckoutConsigneeDetails remove(long checkoutConsigneeId)
		throws NoSuchCheckoutConsigneeDetailsException;

	public CheckoutConsigneeDetails updateImpl(
		CheckoutConsigneeDetails checkoutConsigneeDetails);

	/**
	 * Returns the checkout consignee details with the primary key or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	public CheckoutConsigneeDetails findByPrimaryKey(long checkoutConsigneeId)
		throws NoSuchCheckoutConsigneeDetailsException;

	/**
	 * Returns the checkout consignee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details, or <code>null</code> if a checkout consignee details with the primary key could not be found
	 */
	public CheckoutConsigneeDetails fetchByPrimaryKey(long checkoutConsigneeId);

	/**
	 * Returns all the checkout consignee detailses.
	 *
	 * @return the checkout consignee detailses
	 */
	public java.util.List<CheckoutConsigneeDetails> findAll();

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
	public java.util.List<CheckoutConsigneeDetails> findAll(int start, int end);

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
	public java.util.List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator);

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
	public java.util.List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the checkout consignee detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of checkout consignee detailses.
	 *
	 * @return the number of checkout consignee detailses
	 */
	public int countAll();

}