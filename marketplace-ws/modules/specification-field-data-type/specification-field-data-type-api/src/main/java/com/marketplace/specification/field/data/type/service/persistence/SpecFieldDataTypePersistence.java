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

package com.marketplace.specification.field.data.type.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specification.field.data.type.exception.NoSuchSpecFieldDataTypeException;
import com.marketplace.specification.field.data.type.model.SpecFieldDataType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the spec field data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldDataTypeUtil
 * @generated
 */
@ProviderType
public interface SpecFieldDataTypePersistence
	extends BasePersistence<SpecFieldDataType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecFieldDataTypeUtil} to access the spec field data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field data types
	 */
	public java.util.List<SpecFieldDataType> findByUuid(String uuid);

	/**
	 * Returns a range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of matching spec field data types
	 */
	public java.util.List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field data types
	 */
	public java.util.List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field data types
	 */
	public java.util.List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	public SpecFieldDataType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
				orderByComparator)
		throws NoSuchSpecFieldDataTypeException;

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	public SpecFieldDataType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator);

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	public SpecFieldDataType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
				orderByComparator)
		throws NoSuchSpecFieldDataTypeException;

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	public SpecFieldDataType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator);

	/**
	 * Returns the spec field data types before and after the current spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldDataTypeId the primary key of the current spec field data type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public SpecFieldDataType[] findByUuid_PrevAndNext(
			long specFieldDataTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
				orderByComparator)
		throws NoSuchSpecFieldDataTypeException;

	/**
	 * Removes all the spec field data types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field data types
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the spec field data type in the entity cache if it is enabled.
	 *
	 * @param specFieldDataType the spec field data type
	 */
	public void cacheResult(SpecFieldDataType specFieldDataType);

	/**
	 * Caches the spec field data types in the entity cache if it is enabled.
	 *
	 * @param specFieldDataTypes the spec field data types
	 */
	public void cacheResult(
		java.util.List<SpecFieldDataType> specFieldDataTypes);

	/**
	 * Creates a new spec field data type with the primary key. Does not add the spec field data type to the database.
	 *
	 * @param specFieldDataTypeId the primary key for the new spec field data type
	 * @return the new spec field data type
	 */
	public SpecFieldDataType create(long specFieldDataTypeId);

	/**
	 * Removes the spec field data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type that was removed
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public SpecFieldDataType remove(long specFieldDataTypeId)
		throws NoSuchSpecFieldDataTypeException;

	public SpecFieldDataType updateImpl(SpecFieldDataType specFieldDataType);

	/**
	 * Returns the spec field data type with the primary key or throws a <code>NoSuchSpecFieldDataTypeException</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	public SpecFieldDataType findByPrimaryKey(long specFieldDataTypeId)
		throws NoSuchSpecFieldDataTypeException;

	/**
	 * Returns the spec field data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type, or <code>null</code> if a spec field data type with the primary key could not be found
	 */
	public SpecFieldDataType fetchByPrimaryKey(long specFieldDataTypeId);

	/**
	 * Returns all the spec field data types.
	 *
	 * @return the spec field data types
	 */
	public java.util.List<SpecFieldDataType> findAll();

	/**
	 * Returns a range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of spec field data types
	 */
	public java.util.List<SpecFieldDataType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field data types
	 */
	public java.util.List<SpecFieldDataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field data types
	 */
	public java.util.List<SpecFieldDataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecFieldDataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the spec field data types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of spec field data types.
	 *
	 * @return the number of spec field data types
	 */
	public int countAll();

}