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

package com.marketplace.product.pkg.content.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.pkg.content.exception.NoSuchProductPackageContentException;
import com.marketplace.product.pkg.content.model.ProductPackageContent;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product package content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContentUtil
 * @generated
 */
@ProviderType
public interface ProductPackageContentPersistence
	extends BasePersistence<ProductPackageContent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductPackageContentUtil} to access the product package content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid(String uuid);

	/**
	 * Returns a range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where uuid = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public ProductPackageContent[] findByUuid_PrevAndNext(
			long packageContentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Removes all the product package contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product package contents
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findByUUID_G(String uuid, long groupId)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product package content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product package content that was removed
	 */
	public ProductPackageContent removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the number of product package contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product package contents
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public ProductPackageContent[] findByUuid_C_PrevAndNext(
			long packageContentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Removes all the product package contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product package contents
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product package contents
	 */
	public java.util.List<ProductPackageContent> findBydraftProductId(
		long draftProductId);

	/**
	 * Returns a range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end);

	/**
	 * Returns an ordered range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	public java.util.List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findBydraftProductId_First(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchBydraftProductId_First(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public ProductPackageContent findBydraftProductId_Last(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public ProductPackageContent fetchBydraftProductId_Last(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public ProductPackageContent[] findBydraftProductId_PrevAndNext(
			long packageContentId, long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException;

	/**
	 * Removes all the product package contents where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public void removeBydraftProductId(long draftProductId);

	/**
	 * Returns the number of product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product package contents
	 */
	public int countBydraftProductId(long draftProductId);

	/**
	 * Caches the product package content in the entity cache if it is enabled.
	 *
	 * @param productPackageContent the product package content
	 */
	public void cacheResult(ProductPackageContent productPackageContent);

	/**
	 * Caches the product package contents in the entity cache if it is enabled.
	 *
	 * @param productPackageContents the product package contents
	 */
	public void cacheResult(
		java.util.List<ProductPackageContent> productPackageContents);

	/**
	 * Creates a new product package content with the primary key. Does not add the product package content to the database.
	 *
	 * @param packageContentId the primary key for the new product package content
	 * @return the new product package content
	 */
	public ProductPackageContent create(long packageContentId);

	/**
	 * Removes the product package content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content that was removed
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public ProductPackageContent remove(long packageContentId)
		throws NoSuchProductPackageContentException;

	public ProductPackageContent updateImpl(
		ProductPackageContent productPackageContent);

	/**
	 * Returns the product package content with the primary key or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public ProductPackageContent findByPrimaryKey(long packageContentId)
		throws NoSuchProductPackageContentException;

	/**
	 * Returns the product package content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content, or <code>null</code> if a product package content with the primary key could not be found
	 */
	public ProductPackageContent fetchByPrimaryKey(long packageContentId);

	/**
	 * Returns all the product package contents.
	 *
	 * @return the product package contents
	 */
	public java.util.List<ProductPackageContent> findAll();

	/**
	 * Returns a range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of product package contents
	 */
	public java.util.List<ProductPackageContent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product package contents
	 */
	public java.util.List<ProductPackageContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product package contents
	 */
	public java.util.List<ProductPackageContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductPackageContent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product package contents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product package contents.
	 *
	 * @return the number of product package contents
	 */
	public int countAll();

}