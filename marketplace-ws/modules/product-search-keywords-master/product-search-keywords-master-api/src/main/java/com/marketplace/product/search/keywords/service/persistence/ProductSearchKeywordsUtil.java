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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.search.keywords.model.ProductSearchKeywords;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product search keywords service. This utility wraps <code>com.marketplace.product.search.keywords.service.persistence.impl.ProductSearchKeywordsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywordsPersistence
 * @generated
 */
public class ProductSearchKeywordsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProductSearchKeywords productSearchKeywords) {
		getPersistence().clearCache(productSearchKeywords);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProductSearchKeywords> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductSearchKeywords> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSearchKeywords> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSearchKeywords> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductSearchKeywords update(
		ProductSearchKeywords productSearchKeywords) {

		return getPersistence().update(productSearchKeywords);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductSearchKeywords update(
		ProductSearchKeywords productSearchKeywords,
		ServiceContext serviceContext) {

		return getPersistence().update(productSearchKeywords, serviceContext);
	}

	/**
	 * Returns all the product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product search keywordses
	 */
	public static List<ProductSearchKeywords> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findByUuid_First(
			String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords[] findByUuid_PrevAndNext(
			long searchKeywordId, String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_PrevAndNext(
			searchKeywordId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product search keywordses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product search keywordses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product search keywords where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product search keywords that was removed
	 */
	public static ProductSearchKeywords removeByUUID_G(
			String uuid, long groupId)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product search keywordses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product search keywordses
	 */
	public static List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ProductSearchKeywords[] findByUuid_C_PrevAndNext(
			long searchKeywordId, String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			searchKeywordId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product search keywordses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product search keywordses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product search keywordses
	 */
	public static List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId) {

		return getPersistence().findBydraftProductId(draftProductId);
	}

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
	public static List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end);
	}

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
	public static List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator);
	}

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
	public static List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().fetchBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords[] findBydraftProductId_PrevAndNext(
			long searchKeywordId, long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findBydraftProductId_PrevAndNext(
			searchKeywordId, draftProductId, orderByComparator);
	}

	/**
	 * Removes all the product search keywordses where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public static void removeBydraftProductId(long draftProductId) {
		getPersistence().removeBydraftProductId(draftProductId);
	}

	/**
	 * Returns the number of product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product search keywordses
	 */
	public static int countBydraftProductId(long draftProductId) {
		return getPersistence().countBydraftProductId(draftProductId);
	}

	/**
	 * Caches the product search keywords in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywords the product search keywords
	 */
	public static void cacheResult(
		ProductSearchKeywords productSearchKeywords) {

		getPersistence().cacheResult(productSearchKeywords);
	}

	/**
	 * Caches the product search keywordses in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywordses the product search keywordses
	 */
	public static void cacheResult(
		List<ProductSearchKeywords> productSearchKeywordses) {

		getPersistence().cacheResult(productSearchKeywordses);
	}

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	public static ProductSearchKeywords create(long searchKeywordId) {
		return getPersistence().create(searchKeywordId);
	}

	/**
	 * Removes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords remove(long searchKeywordId)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().remove(searchKeywordId);
	}

	public static ProductSearchKeywords updateImpl(
		ProductSearchKeywords productSearchKeywords) {

		return getPersistence().updateImpl(productSearchKeywords);
	}

	/**
	 * Returns the product search keywords with the primary key or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords findByPrimaryKey(long searchKeywordId)
		throws com.marketplace.product.search.keywords.exception.
			NoSuchProductSearchKeywordsException {

		return getPersistence().findByPrimaryKey(searchKeywordId);
	}

	/**
	 * Returns the product search keywords with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords, or <code>null</code> if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords fetchByPrimaryKey(
		long searchKeywordId) {

		return getPersistence().fetchByPrimaryKey(searchKeywordId);
	}

	/**
	 * Returns all the product search keywordses.
	 *
	 * @return the product search keywordses
	 */
	public static List<ProductSearchKeywords> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProductSearchKeywords> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProductSearchKeywords> findAll(
		int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProductSearchKeywords> findAll(
		int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product search keywordses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductSearchKeywordsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductSearchKeywordsPersistence _persistence;

}