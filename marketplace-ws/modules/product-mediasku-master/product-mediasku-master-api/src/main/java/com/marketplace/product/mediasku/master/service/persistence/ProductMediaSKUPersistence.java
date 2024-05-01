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

package com.marketplace.product.mediasku.master.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.mediasku.master.exception.NoSuchProductMediaSKUException;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product media sku service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKUUtil
 * @generated
 */
@ProviderType
public interface ProductMediaSKUPersistence
	extends BasePersistence<ProductMediaSKU> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductMediaSKUUtil} to access the product media sku persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid(String uuid);

	/**
	 * Returns a range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU[] findByUuid_PrevAndNext(
			long ProductMediaSKUId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Removes all the product media skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product media skus
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByUUID_G(String uuid, long groupId)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product media sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product media sku that was removed
	 */
	public ProductMediaSKU removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the number of product media skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product media skus
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU[] findByUuid_C_PrevAndNext(
			long ProductMediaSKUId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Removes all the product media skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product media skus
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId);

	/**
	 * Returns a range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end);

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByproductSKUIdWithDraftProductId_First(
			long draftProductId, long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByproductSKUIdWithDraftProductId_First(
		long draftProductId, long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByproductSKUIdWithDraftProductId_Last(
			long draftProductId, long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByproductSKUIdWithDraftProductId_Last(
		long draftProductId, long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU[] findByproductSKUIdWithDraftProductId_PrevAndNext(
			long ProductMediaSKUId, long draftProductId, long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Removes all the product media skus where draftProductId = &#63; and productSKUId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 */
	public void removeByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId);

	/**
	 * Returns the number of product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public int countByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId);

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSkuId(
		long productSKUId);

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end);

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByproductSkuId_First(
			long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByproductSkuId_First(
		long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByproductSkuId_Last(
			long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByproductSkuId_Last(
		long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU[] findByproductSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	public void removeByproductSkuId(long productSKUId);

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public int countByproductSkuId(long productSKUId);

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId);

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end);

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	public java.util.List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByProductMediaSkuId_First(
			long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByProductMediaSkuId_First(
		long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	public ProductMediaSKU findByProductMediaSkuId_Last(
			long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public ProductMediaSKU fetchByProductMediaSkuId_Last(
		long productSKUId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU[] findByProductMediaSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
				orderByComparator)
		throws NoSuchProductMediaSKUException;

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	public void removeByProductMediaSkuId(long productSKUId);

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	public int countByProductMediaSkuId(long productSKUId);

	/**
	 * Caches the product media sku in the entity cache if it is enabled.
	 *
	 * @param productMediaSKU the product media sku
	 */
	public void cacheResult(ProductMediaSKU productMediaSKU);

	/**
	 * Caches the product media skus in the entity cache if it is enabled.
	 *
	 * @param productMediaSKUs the product media skus
	 */
	public void cacheResult(java.util.List<ProductMediaSKU> productMediaSKUs);

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	public ProductMediaSKU create(long ProductMediaSKUId);

	/**
	 * Removes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU remove(long ProductMediaSKUId)
		throws NoSuchProductMediaSKUException;

	public ProductMediaSKU updateImpl(ProductMediaSKU productMediaSKU);

	/**
	 * Returns the product media sku with the primary key or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU findByPrimaryKey(long ProductMediaSKUId)
		throws NoSuchProductMediaSKUException;

	/**
	 * Returns the product media sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku, or <code>null</code> if a product media sku with the primary key could not be found
	 */
	public ProductMediaSKU fetchByPrimaryKey(long ProductMediaSKUId);

	/**
	 * Returns all the product media skus.
	 *
	 * @return the product media skus
	 */
	public java.util.List<ProductMediaSKU> findAll();

	/**
	 * Returns a range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of product media skus
	 */
	public java.util.List<ProductMediaSKU> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product media skus
	 */
	public java.util.List<ProductMediaSKU> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product media skus
	 */
	public java.util.List<ProductMediaSKU> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductMediaSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product media skus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	public int countAll();

}