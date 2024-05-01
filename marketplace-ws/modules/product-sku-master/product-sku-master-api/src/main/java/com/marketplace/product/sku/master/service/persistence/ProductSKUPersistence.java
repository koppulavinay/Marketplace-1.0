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

package com.marketplace.product.sku.master.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.sku.master.exception.NoSuchProductSKUException;
import com.marketplace.product.sku.master.model.ProductSKU;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product sku service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKUUtil
 * @generated
 */
@ProviderType
public interface ProductSKUPersistence extends BasePersistence<ProductSKU> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductSKUUtil} to access the product sku persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid(String uuid);

	/**
	 * Returns a range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU[] findByUuid_PrevAndNext(
			long productSKUId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Removes all the product skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product skus
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSKUException;

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product sku that was removed
	 */
	public ProductSKU removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSKUException;

	/**
	 * Returns the number of product skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product skus
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU[] findByUuid_C_PrevAndNext(
			long productSKUId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Removes all the product skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product skus
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product skus
	 */
	public java.util.List<ProductSKU> findBySkuDraftProductId(
		long draftProductId);

	/**
	 * Returns a range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public java.util.List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end);

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findBySkuDraftProductId_First(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchBySkuDraftProductId_First(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findBySkuDraftProductId_Last(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchBySkuDraftProductId_Last(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU[] findBySkuDraftProductId_PrevAndNext(
			long productSKUId, long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Removes all the product skus where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public void removeBySkuDraftProductId(long draftProductId);

	/**
	 * Returns the number of product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product skus
	 */
	public int countBySkuDraftProductId(long draftProductId);

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws NoSuchProductSKUException;

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku);

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku, boolean useFinderCache);

	/**
	 * Removes the product sku where draftProductId = &#63; and defaultSku = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the product sku that was removed
	 */
	public ProductSKU removeByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws NoSuchProductSKUException;

	/**
	 * Returns the number of product skus where draftProductId = &#63; and defaultSku = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the number of matching product skus
	 */
	public int countByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku);

	/**
	 * Returns all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the matching product skus
	 */
	public java.util.List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName);

	/**
	 * Returns a range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	public java.util.List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end);

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	public java.util.List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByDraftProductIdNSkuName_First(
			long draftProductId, String skuName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByDraftProductIdNSkuName_First(
		long draftProductId, String skuName,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findByDraftProductIdNSkuName_Last(
			long draftProductId, String skuName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchByDraftProductIdNSkuName_Last(
		long draftProductId, String skuName,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU[] findByDraftProductIdNSkuName_PrevAndNext(
			long productSKUId, long draftProductId, String skuName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
				orderByComparator)
		throws NoSuchProductSKUException;

	/**
	 * Removes all the product skus where draftProductId = &#63; and skuName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 */
	public void removeByDraftProductIdNSkuName(
		long draftProductId, String skuName);

	/**
	 * Returns the number of product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the number of matching product skus
	 */
	public int countByDraftProductIdNSkuName(
		long draftProductId, String skuName);

	/**
	 * Returns the product sku where skuId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	public ProductSKU findBySkuId(String skuId)
		throws NoSuchProductSKUException;

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchBySkuId(String skuId);

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param skuId the sku ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public ProductSKU fetchBySkuId(String skuId, boolean useFinderCache);

	/**
	 * Removes the product sku where skuId = &#63; from the database.
	 *
	 * @param skuId the sku ID
	 * @return the product sku that was removed
	 */
	public ProductSKU removeBySkuId(String skuId)
		throws NoSuchProductSKUException;

	/**
	 * Returns the number of product skus where skuId = &#63;.
	 *
	 * @param skuId the sku ID
	 * @return the number of matching product skus
	 */
	public int countBySkuId(String skuId);

	/**
	 * Caches the product sku in the entity cache if it is enabled.
	 *
	 * @param productSKU the product sku
	 */
	public void cacheResult(ProductSKU productSKU);

	/**
	 * Caches the product skus in the entity cache if it is enabled.
	 *
	 * @param productSKUs the product skus
	 */
	public void cacheResult(java.util.List<ProductSKU> productSKUs);

	/**
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	public ProductSKU create(long productSKUId);

	/**
	 * Removes the product sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku that was removed
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU remove(long productSKUId)
		throws NoSuchProductSKUException;

	public ProductSKU updateImpl(ProductSKU productSKU);

	/**
	 * Returns the product sku with the primary key or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	public ProductSKU findByPrimaryKey(long productSKUId)
		throws NoSuchProductSKUException;

	/**
	 * Returns the product sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku, or <code>null</code> if a product sku with the primary key could not be found
	 */
	public ProductSKU fetchByPrimaryKey(long productSKUId);

	/**
	 * Returns all the product skus.
	 *
	 * @return the product skus
	 */
	public java.util.List<ProductSKU> findAll();

	/**
	 * Returns a range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of product skus
	 */
	public java.util.List<ProductSKU> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product skus
	 */
	public java.util.List<ProductSKU> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product skus
	 */
	public java.util.List<ProductSKU> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSKU>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product skus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	public int countAll();

}