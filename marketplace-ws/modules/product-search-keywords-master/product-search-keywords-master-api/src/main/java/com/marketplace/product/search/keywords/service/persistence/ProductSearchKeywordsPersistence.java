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

package com.marketplace.product.search.keywords.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.search.keywords.exception.NoSuchProductSearchKeywordsException;
import com.marketplace.product.search.keywords.model.ProductSearchKeywords;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product search keywords service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywordsUtil
 * @generated
 */
@ProviderType
public interface ProductSearchKeywordsPersistence
	extends BasePersistence<ProductSearchKeywords> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductSearchKeywordsUtil} to access the product search keywords persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid(String uuid);

	/**
	 * Returns a range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords[] findByUuid_PrevAndNext(
			long searchKeywordId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Removes all the product search keywordses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product search keywordses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product search keywords where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product search keywords that was removed
	 */
	public ProductSearchKeywords removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product search keywordses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords[] findByUuid_C_PrevAndNext(
			long searchKeywordId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Removes all the product search keywordses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product search keywordses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId);

	/**
	 * Returns a range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end);

	/**
	 * Returns an ordered range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findBydraftProductId_First(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchBydraftProductId_First(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords findBydraftProductId_Last(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public ProductSearchKeywords fetchBydraftProductId_Last(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords[] findBydraftProductId_PrevAndNext(
			long searchKeywordId, long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Removes all the product search keywordses where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public void removeBydraftProductId(long draftProductId);

	/**
	 * Returns the number of product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product search keywordses
	 */
	public int countBydraftProductId(long draftProductId);

	/**
	 * Caches the product search keywords in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywords the product search keywords
	 */
	public void cacheResult(ProductSearchKeywords productSearchKeywords);

	/**
	 * Caches the product search keywordses in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywordses the product search keywordses
	 */
	public void cacheResult(
		java.util.List<ProductSearchKeywords> productSearchKeywordses);

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	public ProductSearchKeywords create(long searchKeywordId);

	/**
	 * Removes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords remove(long searchKeywordId)
		throws NoSuchProductSearchKeywordsException;

	public ProductSearchKeywords updateImpl(
		ProductSearchKeywords productSearchKeywords);

	/**
	 * Returns the product search keywords with the primary key or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords findByPrimaryKey(long searchKeywordId)
		throws NoSuchProductSearchKeywordsException;

	/**
	 * Returns the product search keywords with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords, or <code>null</code> if a product search keywords with the primary key could not be found
	 */
	public ProductSearchKeywords fetchByPrimaryKey(long searchKeywordId);

	/**
	 * Returns all the product search keywordses.
	 *
	 * @return the product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findAll();

	/**
	 * Returns a range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product search keywordses
	 */
	public java.util.List<ProductSearchKeywords> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSearchKeywords>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product search keywordses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
	 */
	public int countAll();

}