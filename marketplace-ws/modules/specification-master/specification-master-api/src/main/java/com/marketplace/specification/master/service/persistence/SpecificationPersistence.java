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

package com.marketplace.specification.master.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specification.master.exception.NoSuchSpecificationException;
import com.marketplace.specification.master.model.Specification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the specification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationUtil
 * @generated
 */
@ProviderType
public interface SpecificationPersistence
	extends BasePersistence<Specification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecificationUtil} to access the specification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching specifications
	 */
	public java.util.List<Specification> findByUuid(String uuid);

	/**
	 * Returns a range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public java.util.List<Specification> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public Specification[] findByUuid_PrevAndNext(
			long specificationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Removes all the specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching specifications
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationException;

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the specification that was removed
	 */
	public Specification removeByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationException;

	/**
	 * Returns the number of specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching specifications
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching specifications
	 */
	public java.util.List<Specification> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public java.util.List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public Specification[] findByUuid_C_PrevAndNext(
			long specificationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Removes all the specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching specifications
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the matching specifications
	 */
	public java.util.List<Specification> findBySpecificationStatus(
		String specificationStatus);

	/**
	 * Returns a range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	public java.util.List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end);

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	public java.util.List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findBySpecificationStatus_First(
			String specificationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchBySpecificationStatus_First(
		String specificationStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	public Specification findBySpecificationStatus_Last(
			String specificationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	public Specification fetchBySpecificationStatus_Last(
		String specificationStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns the specifications before and after the current specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public Specification[] findBySpecificationStatus_PrevAndNext(
			long specificationId, String specificationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Specification>
				orderByComparator)
		throws NoSuchSpecificationException;

	/**
	 * Removes all the specifications where specificationStatus = &#63; from the database.
	 *
	 * @param specificationStatus the specification status
	 */
	public void removeBySpecificationStatus(String specificationStatus);

	/**
	 * Returns the number of specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the number of matching specifications
	 */
	public int countBySpecificationStatus(String specificationStatus);

	/**
	 * Caches the specification in the entity cache if it is enabled.
	 *
	 * @param specification the specification
	 */
	public void cacheResult(Specification specification);

	/**
	 * Caches the specifications in the entity cache if it is enabled.
	 *
	 * @param specifications the specifications
	 */
	public void cacheResult(java.util.List<Specification> specifications);

	/**
	 * Creates a new specification with the primary key. Does not add the specification to the database.
	 *
	 * @param specificationId the primary key for the new specification
	 * @return the new specification
	 */
	public Specification create(long specificationId);

	/**
	 * Removes the specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification that was removed
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public Specification remove(long specificationId)
		throws NoSuchSpecificationException;

	public Specification updateImpl(Specification specification);

	/**
	 * Returns the specification with the primary key or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	public Specification findByPrimaryKey(long specificationId)
		throws NoSuchSpecificationException;

	/**
	 * Returns the specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification, or <code>null</code> if a specification with the primary key could not be found
	 */
	public Specification fetchByPrimaryKey(long specificationId);

	/**
	 * Returns all the specifications.
	 *
	 * @return the specifications
	 */
	public java.util.List<Specification> findAll();

	/**
	 * Returns a range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of specifications
	 */
	public java.util.List<Specification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specifications
	 */
	public java.util.List<Specification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specifications
	 */
	public java.util.List<Specification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the specifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of specifications.
	 *
	 * @return the number of specifications
	 */
	public int countAll();

}