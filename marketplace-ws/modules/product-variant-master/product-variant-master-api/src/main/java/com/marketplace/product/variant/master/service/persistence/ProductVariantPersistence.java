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

package com.marketplace.product.variant.master.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.variant.master.exception.NoSuchProductVariantException;
import com.marketplace.product.variant.master.model.ProductVariant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product variant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariantUtil
 * @generated
 */
@ProviderType
public interface ProductVariantPersistence
	extends BasePersistence<ProductVariant> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductVariantUtil} to access the product variant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid(String uuid);

	/**
	 * Returns a range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant[] findByUuid_PrevAndNext(
			long productVariantId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Removes all the product variants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product variants
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByUUID_G(String uuid, long groupId)
		throws NoSuchProductVariantException;

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product variant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product variant that was removed
	 */
	public ProductVariant removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductVariantException;

	/**
	 * Returns the number of product variants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product variants
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant[] findByUuid_C_PrevAndNext(
			long productVariantId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Removes all the product variants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product variants
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product variants
	 */
	public java.util.List<ProductVariant> findBydraftProductId(
		long draftProductId);

	/**
	 * Returns a range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public java.util.List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end);

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findBydraftProductId_First(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchBydraftProductId_First(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findBydraftProductId_Last(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchBydraftProductId_Last(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant[] findBydraftProductId_PrevAndNext(
			long productVariantId, long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Removes all the product variants where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public void removeBydraftProductId(long draftProductId);

	/**
	 * Returns the number of product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product variants
	 */
	public int countBydraftProductId(long draftProductId);

	/**
	 * Returns all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the matching product variants
	 */
	public java.util.List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName);

	/**
	 * Returns a range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	public java.util.List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end);

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	public java.util.List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByvariantNameID_First(
			long draftProductId, String variantName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByvariantNameID_First(
		long draftProductId, String variantName,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	public ProductVariant findByvariantNameID_Last(
			long draftProductId, String variantName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	public ProductVariant fetchByvariantNameID_Last(
		long draftProductId, String variantName,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant[] findByvariantNameID_PrevAndNext(
			long productVariantId, long draftProductId, String variantName,
			com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
				orderByComparator)
		throws NoSuchProductVariantException;

	/**
	 * Removes all the product variants where draftProductId = &#63; and variantName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 */
	public void removeByvariantNameID(long draftProductId, String variantName);

	/**
	 * Returns the number of product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the number of matching product variants
	 */
	public int countByvariantNameID(long draftProductId, String variantName);

	/**
	 * Caches the product variant in the entity cache if it is enabled.
	 *
	 * @param productVariant the product variant
	 */
	public void cacheResult(ProductVariant productVariant);

	/**
	 * Caches the product variants in the entity cache if it is enabled.
	 *
	 * @param productVariants the product variants
	 */
	public void cacheResult(java.util.List<ProductVariant> productVariants);

	/**
	 * Creates a new product variant with the primary key. Does not add the product variant to the database.
	 *
	 * @param productVariantId the primary key for the new product variant
	 * @return the new product variant
	 */
	public ProductVariant create(long productVariantId);

	/**
	 * Removes the product variant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant that was removed
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant remove(long productVariantId)
		throws NoSuchProductVariantException;

	public ProductVariant updateImpl(ProductVariant productVariant);

	/**
	 * Returns the product variant with the primary key or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	public ProductVariant findByPrimaryKey(long productVariantId)
		throws NoSuchProductVariantException;

	/**
	 * Returns the product variant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant, or <code>null</code> if a product variant with the primary key could not be found
	 */
	public ProductVariant fetchByPrimaryKey(long productVariantId);

	/**
	 * Returns all the product variants.
	 *
	 * @return the product variants
	 */
	public java.util.List<ProductVariant> findAll();

	/**
	 * Returns a range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of product variants
	 */
	public java.util.List<ProductVariant> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product variants
	 */
	public java.util.List<ProductVariant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product variants
	 */
	public java.util.List<ProductVariant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductVariant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product variants from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product variants.
	 *
	 * @return the number of product variants
	 */
	public int countAll();

}