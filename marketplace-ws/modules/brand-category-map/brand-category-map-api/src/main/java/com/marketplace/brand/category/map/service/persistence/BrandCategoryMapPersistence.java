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

package com.marketplace.brand.category.map.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.brand.category.map.exception.NoSuchBrandCategoryMapException;
import com.marketplace.brand.category.map.model.BrandCategoryMap;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the brand category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandCategoryMapUtil
 * @generated
 */
@ProviderType
public interface BrandCategoryMapPersistence
	extends BasePersistence<BrandCategoryMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrandCategoryMapUtil} to access the brand category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand category maps
	 */
	public java.util.List<BrandCategoryMap> findByFBYBrandId(long brandId);

	/**
	 * Returns a range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of matching brand category maps
	 */
	public java.util.List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end);

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand category maps
	 */
	public java.util.List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand category maps
	 */
	public java.util.List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	public BrandCategoryMap findByFBYBrandId_First(
			long brandId,
			com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
				orderByComparator)
		throws NoSuchBrandCategoryMapException;

	/**
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	public BrandCategoryMap fetchByFBYBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator);

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	public BrandCategoryMap findByFBYBrandId_Last(
			long brandId,
			com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
				orderByComparator)
		throws NoSuchBrandCategoryMapException;

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	public BrandCategoryMap fetchByFBYBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator);

	/**
	 * Returns the brand category maps before and after the current brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandCategoryMapId the primary key of the current brand category map
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public BrandCategoryMap[] findByFBYBrandId_PrevAndNext(
			long brandCategoryMapId, long brandId,
			com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
				orderByComparator)
		throws NoSuchBrandCategoryMapException;

	/**
	 * Removes all the brand category maps where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	public void removeByFBYBrandId(long brandId);

	/**
	 * Returns the number of brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand category maps
	 */
	public int countByFBYBrandId(long brandId);

	/**
	 * Caches the brand category map in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMap the brand category map
	 */
	public void cacheResult(BrandCategoryMap brandCategoryMap);

	/**
	 * Caches the brand category maps in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMaps the brand category maps
	 */
	public void cacheResult(java.util.List<BrandCategoryMap> brandCategoryMaps);

	/**
	 * Creates a new brand category map with the primary key. Does not add the brand category map to the database.
	 *
	 * @param brandCategoryMapId the primary key for the new brand category map
	 * @return the new brand category map
	 */
	public BrandCategoryMap create(long brandCategoryMapId);

	/**
	 * Removes the brand category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map that was removed
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public BrandCategoryMap remove(long brandCategoryMapId)
		throws NoSuchBrandCategoryMapException;

	public BrandCategoryMap updateImpl(BrandCategoryMap brandCategoryMap);

	/**
	 * Returns the brand category map with the primary key or throws a <code>NoSuchBrandCategoryMapException</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	public BrandCategoryMap findByPrimaryKey(long brandCategoryMapId)
		throws NoSuchBrandCategoryMapException;

	/**
	 * Returns the brand category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map, or <code>null</code> if a brand category map with the primary key could not be found
	 */
	public BrandCategoryMap fetchByPrimaryKey(long brandCategoryMapId);

	/**
	 * Returns all the brand category maps.
	 *
	 * @return the brand category maps
	 */
	public java.util.List<BrandCategoryMap> findAll();

	/**
	 * Returns a range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of brand category maps
	 */
	public java.util.List<BrandCategoryMap> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand category maps
	 */
	public java.util.List<BrandCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brand category maps
	 */
	public java.util.List<BrandCategoryMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandCategoryMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the brand category maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of brand category maps.
	 *
	 * @return the number of brand category maps
	 */
	public int countAll();

}