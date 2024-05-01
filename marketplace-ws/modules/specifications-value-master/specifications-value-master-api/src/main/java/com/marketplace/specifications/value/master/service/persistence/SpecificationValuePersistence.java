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

package com.marketplace.specifications.value.master.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specifications.value.master.exception.NoSuchSpecificationValueException;
import com.marketplace.specifications.value.master.model.SpecificationValue;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the specification value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValueUtil
 * @generated
 */
@ProviderType
public interface SpecificationValuePersistence
	extends BasePersistence<SpecificationValue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecificationValueUtil} to access the specification value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the specification values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid(String uuid);

	/**
	 * Returns a range of all the specification values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @return the range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the specification values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specification values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the first specification value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the last specification value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the last specification value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the specification values before and after the current specification value in the ordered set where uuid = &#63;.
	 *
	 * @param specificationValueId the primary key of the current specification value
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification value
	 * @throws NoSuchSpecificationValueException if a specification value with the primary key could not be found
	 */
	public SpecificationValue[] findByUuid_PrevAndNext(
			long specificationValueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Removes all the specification values where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of specification values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching specification values
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the specification value where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSpecificationValueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the specification value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the specification value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the specification value where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the specification value that was removed
	 */
	public SpecificationValue removeByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the number of specification values where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching specification values
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the specification values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the specification values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @return the range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the specification values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specification values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the first specification value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the last specification value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the last specification value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the specification values before and after the current specification value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specificationValueId the primary key of the current specification value
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification value
	 * @throws NoSuchSpecificationValueException if a specification value with the primary key could not be found
	 */
	public SpecificationValue[] findByUuid_C_PrevAndNext(
			long specificationValueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Removes all the specification values where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of specification values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching specification values
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the specification values where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the matching specification values
	 */
	public java.util.List<SpecificationValue> findByFBYSpecificationId(
		long specificationId);

	/**
	 * Returns a range of all the specification values where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @return the range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByFBYSpecificationId(
		long specificationId, int start, int end);

	/**
	 * Returns an ordered range of all the specification values where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByFBYSpecificationId(
		long specificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specification values where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specification values
	 */
	public java.util.List<SpecificationValue> findByFBYSpecificationId(
		long specificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification value in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByFBYSpecificationId_First(
			long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the first specification value in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByFBYSpecificationId_First(
		long specificationId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the last specification value in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value
	 * @throws NoSuchSpecificationValueException if a matching specification value could not be found
	 */
	public SpecificationValue findByFBYSpecificationId_Last(
			long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the last specification value in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public SpecificationValue fetchByFBYSpecificationId_Last(
		long specificationId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns the specification values before and after the current specification value in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationValueId the primary key of the current specification value
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification value
	 * @throws NoSuchSpecificationValueException if a specification value with the primary key could not be found
	 */
	public SpecificationValue[] findByFBYSpecificationId_PrevAndNext(
			long specificationValueId, long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
				orderByComparator)
		throws NoSuchSpecificationValueException;

	/**
	 * Removes all the specification values where specificationId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 */
	public void removeByFBYSpecificationId(long specificationId);

	/**
	 * Returns the number of specification values where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the number of matching specification values
	 */
	public int countByFBYSpecificationId(long specificationId);

	/**
	 * Caches the specification value in the entity cache if it is enabled.
	 *
	 * @param specificationValue the specification value
	 */
	public void cacheResult(SpecificationValue specificationValue);

	/**
	 * Caches the specification values in the entity cache if it is enabled.
	 *
	 * @param specificationValues the specification values
	 */
	public void cacheResult(
		java.util.List<SpecificationValue> specificationValues);

	/**
	 * Creates a new specification value with the primary key. Does not add the specification value to the database.
	 *
	 * @param specificationValueId the primary key for the new specification value
	 * @return the new specification value
	 */
	public SpecificationValue create(long specificationValueId);

	/**
	 * Removes the specification value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value that was removed
	 * @throws NoSuchSpecificationValueException if a specification value with the primary key could not be found
	 */
	public SpecificationValue remove(long specificationValueId)
		throws NoSuchSpecificationValueException;

	public SpecificationValue updateImpl(SpecificationValue specificationValue);

	/**
	 * Returns the specification value with the primary key or throws a <code>NoSuchSpecificationValueException</code> if it could not be found.
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value
	 * @throws NoSuchSpecificationValueException if a specification value with the primary key could not be found
	 */
	public SpecificationValue findByPrimaryKey(long specificationValueId)
		throws NoSuchSpecificationValueException;

	/**
	 * Returns the specification value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value, or <code>null</code> if a specification value with the primary key could not be found
	 */
	public SpecificationValue fetchByPrimaryKey(long specificationValueId);

	/**
	 * Returns all the specification values.
	 *
	 * @return the specification values
	 */
	public java.util.List<SpecificationValue> findAll();

	/**
	 * Returns a range of all the specification values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @return the range of specification values
	 */
	public java.util.List<SpecificationValue> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the specification values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specification values
	 */
	public java.util.List<SpecificationValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specification values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specification values
	 */
	public java.util.List<SpecificationValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecificationValue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the specification values from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of specification values.
	 *
	 * @return the number of specification values
	 */
	public int countAll();

}