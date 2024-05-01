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

package com.marketplace.product.spec.value.map.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.spec.value.map.exception.NoSuchProductSpecValueMapException;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product spec value map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMapUtil
 * @generated
 */
@ProviderType
public interface ProductSpecValueMapPersistence
	extends BasePersistence<ProductSpecValueMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductSpecValueMapUtil} to access the product spec value map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid(String uuid);

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap[] findByUuid_PrevAndNext(
			long productSpecValueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Removes all the product spec value maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product spec value maps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product spec value map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product spec value map that was removed
	 */
	public ProductSpecValueMap removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product spec value maps
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap[] findByUuid_C_PrevAndNext(
			long productSpecValueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Removes all the product spec value maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product spec value maps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId);

	/**
	 * Returns a range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end);

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByproductSpecificationId_First(
			long productSpecificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByproductSpecificationId_First(
		long productSpecificationId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByproductSpecificationId_Last(
			long productSpecificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByproductSpecificationId_Last(
		long productSpecificationId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap[] findByproductSpecificationId_PrevAndNext(
			long productSpecValueId, long productSpecificationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Removes all the product spec value maps where productSpecificationId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 */
	public void removeByproductSpecificationId(long productSpecificationId);

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the number of matching product spec value maps
	 */
	public int countByproductSpecificationId(long productSpecificationId);

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap findByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId);

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	public ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId,
		boolean useFinderCache);

	/**
	 * Removes the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the product spec value map that was removed
	 */
	public ProductSpecValueMap removeByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63; and specificationValueLabelId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the number of matching product spec value maps
	 */
	public int countByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId);

	/**
	 * Caches the product spec value map in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMap the product spec value map
	 */
	public void cacheResult(ProductSpecValueMap productSpecValueMap);

	/**
	 * Caches the product spec value maps in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMaps the product spec value maps
	 */
	public void cacheResult(
		java.util.List<ProductSpecValueMap> productSpecValueMaps);

	/**
	 * Creates a new product spec value map with the primary key. Does not add the product spec value map to the database.
	 *
	 * @param productSpecValueId the primary key for the new product spec value map
	 * @return the new product spec value map
	 */
	public ProductSpecValueMap create(long productSpecValueId);

	/**
	 * Removes the product spec value map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map that was removed
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap remove(long productSpecValueId)
		throws NoSuchProductSpecValueMapException;

	public ProductSpecValueMap updateImpl(
		ProductSpecValueMap productSpecValueMap);

	/**
	 * Returns the product spec value map with the primary key or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap findByPrimaryKey(long productSpecValueId)
		throws NoSuchProductSpecValueMapException;

	/**
	 * Returns the product spec value map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map, or <code>null</code> if a product spec value map with the primary key could not be found
	 */
	public ProductSpecValueMap fetchByPrimaryKey(long productSpecValueId);

	/**
	 * Returns all the product spec value maps.
	 *
	 * @return the product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findAll();

	/**
	 * Returns a range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product spec value maps
	 */
	public java.util.List<ProductSpecValueMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecValueMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product spec value maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product spec value maps.
	 *
	 * @return the number of product spec value maps
	 */
	public int countAll();

}