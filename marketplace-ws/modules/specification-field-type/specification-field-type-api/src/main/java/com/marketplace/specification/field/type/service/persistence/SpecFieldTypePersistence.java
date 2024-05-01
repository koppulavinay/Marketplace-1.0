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

package com.marketplace.specification.field.type.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specification.field.type.exception.NoSuchSpecFieldTypeException;
import com.marketplace.specification.field.type.model.SpecFieldType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the spec field type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldTypeUtil
 * @generated
 */
@ProviderType
public interface SpecFieldTypePersistence
	extends BasePersistence<SpecFieldType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecFieldTypeUtil} to access the spec field type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field types
	 */
	public java.util.List<SpecFieldType> findByUuid(String uuid);

	/**
	 * Returns a range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of matching spec field types
	 */
	public java.util.List<SpecFieldType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field types
	 */
	public java.util.List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field types
	 */
	public java.util.List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	public SpecFieldType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
				orderByComparator)
		throws NoSuchSpecFieldTypeException;

	/**
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	public SpecFieldType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator);

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	public SpecFieldType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
				orderByComparator)
		throws NoSuchSpecFieldTypeException;

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	public SpecFieldType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator);

	/**
	 * Returns the spec field types before and after the current spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldTypeId the primary key of the current spec field type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public SpecFieldType[] findByUuid_PrevAndNext(
			long specFieldTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
				orderByComparator)
		throws NoSuchSpecFieldTypeException;

	/**
	 * Removes all the spec field types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field types
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the spec field type in the entity cache if it is enabled.
	 *
	 * @param specFieldType the spec field type
	 */
	public void cacheResult(SpecFieldType specFieldType);

	/**
	 * Caches the spec field types in the entity cache if it is enabled.
	 *
	 * @param specFieldTypes the spec field types
	 */
	public void cacheResult(java.util.List<SpecFieldType> specFieldTypes);

	/**
	 * Creates a new spec field type with the primary key. Does not add the spec field type to the database.
	 *
	 * @param specFieldTypeId the primary key for the new spec field type
	 * @return the new spec field type
	 */
	public SpecFieldType create(long specFieldTypeId);

	/**
	 * Removes the spec field type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type that was removed
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public SpecFieldType remove(long specFieldTypeId)
		throws NoSuchSpecFieldTypeException;

	public SpecFieldType updateImpl(SpecFieldType specFieldType);

	/**
	 * Returns the spec field type with the primary key or throws a <code>NoSuchSpecFieldTypeException</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	public SpecFieldType findByPrimaryKey(long specFieldTypeId)
		throws NoSuchSpecFieldTypeException;

	/**
	 * Returns the spec field type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type, or <code>null</code> if a spec field type with the primary key could not be found
	 */
	public SpecFieldType fetchByPrimaryKey(long specFieldTypeId);

	/**
	 * Returns all the spec field types.
	 *
	 * @return the spec field types
	 */
	public java.util.List<SpecFieldType> findAll();

	/**
	 * Returns a range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of spec field types
	 */
	public java.util.List<SpecFieldType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field types
	 */
	public java.util.List<SpecFieldType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field types
	 */
	public java.util.List<SpecFieldType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the spec field types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of spec field types.
	 *
	 * @return the number of spec field types
	 */
	public int countAll();

}