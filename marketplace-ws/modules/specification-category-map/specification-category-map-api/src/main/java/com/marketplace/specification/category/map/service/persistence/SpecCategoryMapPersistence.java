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

package com.marketplace.specification.category.map.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specification.category.map.exception.NoSuchSpecCategoryMapException;
import com.marketplace.specification.category.map.model.SpecCategoryMap;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the spec category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapUtil
 * @generated
 */
@ProviderType
public interface SpecCategoryMapPersistence
	extends BasePersistence<SpecCategoryMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecCategoryMapUtil} to access the spec category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid(String uuid);

	/**
	 * Returns a range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap[] findByUuid_PrevAndNext(
			long specCategoryMapId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Removes all the spec category maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec category maps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap[] findByUuid_C_PrevAndNext(
			long specCategoryMapId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Removes all the spec category maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching spec category maps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId);

	/**
	 * Returns a range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end);

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByFBYSpecificationId_First(
			long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByFBYSpecificationId_First(
		long specificationId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByFBYSpecificationId_Last(
			long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByFBYSpecificationId_Last(
		long specificationId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap[] findByFBYSpecificationId_PrevAndNext(
			long specCategoryMapId, long specificationId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Removes all the spec category maps where specificationId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 */
	public void removeByFBYSpecificationId(long specificationId);

	/**
	 * Returns the number of spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the number of matching spec category maps
	 */
	public int countByFBYSpecificationId(long specificationId);

	/**
	 * Returns all the spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYCategoryId(long categoryId);

	/**
	 * Returns a range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end);

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	public java.util.List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByFBYCategoryId_First(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByFBYCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findByFBYCategoryId_Last(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchByFBYCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap[] findByFBYCategoryId_PrevAndNext(
			long specCategoryMapId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
				orderByComparator)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Removes all the spec category maps where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByFBYCategoryId(long categoryId);

	/**
	 * Returns the number of spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	public int countByFBYCategoryId(long categoryId);

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	public SpecCategoryMap findBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId);

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId, boolean useFinderCache);

	/**
	 * Removes the spec category map where specificationId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the spec category map that was removed
	 */
	public SpecCategoryMap removeBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the number of spec category maps where specificationId = &#63; and categoryId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	public int countBySpecificationIdNCategoryId(
		long specificationId, long categoryId);

	/**
	 * Caches the spec category map in the entity cache if it is enabled.
	 *
	 * @param specCategoryMap the spec category map
	 */
	public void cacheResult(SpecCategoryMap specCategoryMap);

	/**
	 * Caches the spec category maps in the entity cache if it is enabled.
	 *
	 * @param specCategoryMaps the spec category maps
	 */
	public void cacheResult(java.util.List<SpecCategoryMap> specCategoryMaps);

	/**
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	public SpecCategoryMap create(long specCategoryMapId);

	/**
	 * Removes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap remove(long specCategoryMapId)
		throws NoSuchSpecCategoryMapException;

	public SpecCategoryMap updateImpl(SpecCategoryMap specCategoryMap);

	/**
	 * Returns the spec category map with the primary key or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap findByPrimaryKey(long specCategoryMapId)
		throws NoSuchSpecCategoryMapException;

	/**
	 * Returns the spec category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map, or <code>null</code> if a spec category map with the primary key could not be found
	 */
	public SpecCategoryMap fetchByPrimaryKey(long specCategoryMapId);

	/**
	 * Returns all the spec category maps.
	 *
	 * @return the spec category maps
	 */
	public java.util.List<SpecCategoryMap> findAll();

	/**
	 * Returns a range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of spec category maps
	 */
	public java.util.List<SpecCategoryMap> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec category maps
	 */
	public java.util.List<SpecCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec category maps
	 */
	public java.util.List<SpecCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the spec category maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	public int countAll();

}