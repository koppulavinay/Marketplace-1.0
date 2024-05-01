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

package com.marketplace.specification.value.uoms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.specification.value.uoms.exception.NoSuchSpecValueUomException;
import com.marketplace.specification.value.uoms.model.SpecValueUom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the spec value uom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecValueUomUtil
 * @generated
 */
@ProviderType
public interface SpecValueUomPersistence extends BasePersistence<SpecValueUom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecValueUomUtil} to access the spec value uom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec value uoms
	 */
	public java.util.List<SpecValueUom> findByUuid(String uuid);

	/**
	 * Returns a range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of matching spec value uoms
	 */
	public java.util.List<SpecValueUom> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec value uoms
	 */
	public java.util.List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec value uoms
	 */
	public java.util.List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	public SpecValueUom findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
				orderByComparator)
		throws NoSuchSpecValueUomException;

	/**
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	public SpecValueUom fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator);

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	public SpecValueUom findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
				orderByComparator)
		throws NoSuchSpecValueUomException;

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	public SpecValueUom fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator);

	/**
	 * Returns the spec value uoms before and after the current spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param specValueUomId the primary key of the current spec value uom
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public SpecValueUom[] findByUuid_PrevAndNext(
			long specValueUomId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
				orderByComparator)
		throws NoSuchSpecValueUomException;

	/**
	 * Removes all the spec value uoms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec value uoms
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the spec value uom in the entity cache if it is enabled.
	 *
	 * @param specValueUom the spec value uom
	 */
	public void cacheResult(SpecValueUom specValueUom);

	/**
	 * Caches the spec value uoms in the entity cache if it is enabled.
	 *
	 * @param specValueUoms the spec value uoms
	 */
	public void cacheResult(java.util.List<SpecValueUom> specValueUoms);

	/**
	 * Creates a new spec value uom with the primary key. Does not add the spec value uom to the database.
	 *
	 * @param specValueUomId the primary key for the new spec value uom
	 * @return the new spec value uom
	 */
	public SpecValueUom create(long specValueUomId);

	/**
	 * Removes the spec value uom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom that was removed
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public SpecValueUom remove(long specValueUomId)
		throws NoSuchSpecValueUomException;

	public SpecValueUom updateImpl(SpecValueUom specValueUom);

	/**
	 * Returns the spec value uom with the primary key or throws a <code>NoSuchSpecValueUomException</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	public SpecValueUom findByPrimaryKey(long specValueUomId)
		throws NoSuchSpecValueUomException;

	/**
	 * Returns the spec value uom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom, or <code>null</code> if a spec value uom with the primary key could not be found
	 */
	public SpecValueUom fetchByPrimaryKey(long specValueUomId);

	/**
	 * Returns all the spec value uoms.
	 *
	 * @return the spec value uoms
	 */
	public java.util.List<SpecValueUom> findAll();

	/**
	 * Returns a range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of spec value uoms
	 */
	public java.util.List<SpecValueUom> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec value uoms
	 */
	public java.util.List<SpecValueUom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec value uoms
	 */
	public java.util.List<SpecValueUom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SpecValueUom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the spec value uoms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of spec value uoms.
	 *
	 * @return the number of spec value uoms
	 */
	public int countAll();

}