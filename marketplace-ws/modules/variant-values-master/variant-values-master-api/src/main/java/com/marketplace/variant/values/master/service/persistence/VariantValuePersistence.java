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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.variant.values.master.exception.NoSuchVariantValueException;
import com.marketplace.variant.values.master.model.VariantValue;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the variant value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VariantValueUtil
 * @generated
 */
@ProviderType
public interface VariantValuePersistence extends BasePersistence<VariantValue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VariantValueUtil} to access the variant value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variant values
	 */
	public java.util.List<VariantValue> findByUuid(String uuid);

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
	public java.util.List<VariantValue> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<VariantValue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public java.util.List<VariantValue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where uuid = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public VariantValue[] findByUuid_PrevAndNext(
			long variantValueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Removes all the variant values where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variant values
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByUUID_G(String uuid, long groupId)
		throws NoSuchVariantValueException;

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the variant value where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the variant value that was removed
	 */
	public VariantValue removeByUUID_G(String uuid, long groupId)
		throws NoSuchVariantValueException;

	/**
	 * Returns the number of variant values where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching variant values
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching variant values
	 */
	public java.util.List<VariantValue> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public java.util.List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public VariantValue[] findByUuid_C_PrevAndNext(
			long variantValueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Removes all the variant values where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching variant values
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the matching variant values
	 */
	public java.util.List<VariantValue> findByproductVariantId(
		long productVariantId);

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
	public java.util.List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end);

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
	public java.util.List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public java.util.List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByproductVariantId_First(
			long productVariantId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByproductVariantId_First(
		long productVariantId,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByproductVariantId_Last(
			long productVariantId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByproductVariantId_Last(
		long productVariantId,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public VariantValue[] findByproductVariantId_PrevAndNext(
			long variantValueId, long productVariantId,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Removes all the variant values where productVariantId = &#63; from the database.
	 *
	 * @param productVariantId the product variant ID
	 */
	public void removeByproductVariantId(long productVariantId);

	/**
	 * Returns the number of variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the number of matching variant values
	 */
	public int countByproductVariantId(long productVariantId);

	/**
	 * Returns all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the matching variant values
	 */
	public java.util.List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal);

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
	public java.util.List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end);

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
	public java.util.List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public java.util.List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByvalueAndId_First(
			long draftProductId, String variantVal,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByvalueAndId_First(
		long draftProductId, String variantVal,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	public VariantValue findByvalueAndId_Last(
			long draftProductId, String variantVal,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public VariantValue fetchByvalueAndId_Last(
		long draftProductId, String variantVal,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public VariantValue[] findByvalueAndId_PrevAndNext(
			long variantValueId, long draftProductId, String variantVal,
			com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
				orderByComparator)
		throws NoSuchVariantValueException;

	/**
	 * Removes all the variant values where draftProductId = &#63; and variantVal = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 */
	public void removeByvalueAndId(long draftProductId, String variantVal);

	/**
	 * Returns the number of variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the number of matching variant values
	 */
	public int countByvalueAndId(long draftProductId, String variantVal);

	/**
	 * Caches the variant value in the entity cache if it is enabled.
	 *
	 * @param variantValue the variant value
	 */
	public void cacheResult(VariantValue variantValue);

	/**
	 * Caches the variant values in the entity cache if it is enabled.
	 *
	 * @param variantValues the variant values
	 */
	public void cacheResult(java.util.List<VariantValue> variantValues);

	/**
	 * Creates a new variant value with the primary key. Does not add the variant value to the database.
	 *
	 * @param variantValueId the primary key for the new variant value
	 * @return the new variant value
	 */
	public VariantValue create(long variantValueId);

	/**
	 * Removes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public VariantValue remove(long variantValueId)
		throws NoSuchVariantValueException;

	public VariantValue updateImpl(VariantValue variantValue);

	/**
	 * Returns the variant value with the primary key or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	public VariantValue findByPrimaryKey(long variantValueId)
		throws NoSuchVariantValueException;

	/**
	 * Returns the variant value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value, or <code>null</code> if a variant value with the primary key could not be found
	 */
	public VariantValue fetchByPrimaryKey(long variantValueId);

	/**
	 * Returns all the variant values.
	 *
	 * @return the variant values
	 */
	public java.util.List<VariantValue> findAll();

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
	public java.util.List<VariantValue> findAll(int start, int end);

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
	public java.util.List<VariantValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator);

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
	public java.util.List<VariantValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VariantValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the variant values from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of variant values.
	 *
	 * @return the number of variant values
	 */
	public int countAll();

}