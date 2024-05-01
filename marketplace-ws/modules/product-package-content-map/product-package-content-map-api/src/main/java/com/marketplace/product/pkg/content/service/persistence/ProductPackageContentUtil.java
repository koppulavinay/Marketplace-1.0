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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.pkg.content.model.ProductPackageContent;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product package content service. This utility wraps <code>com.marketplace.product.pkg.content.service.persistence.impl.ProductPackageContentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContentPersistence
 * @generated
 */
public class ProductPackageContentUtil {

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
	public static void clearCache(ProductPackageContent productPackageContent) {
		getPersistence().clearCache(productPackageContent);
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
	public static Map<Serializable, ProductPackageContent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductPackageContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductPackageContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductPackageContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductPackageContent update(
		ProductPackageContent productPackageContent) {

		return getPersistence().update(productPackageContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductPackageContent update(
		ProductPackageContent productPackageContent,
		ServiceContext serviceContext) {

		return getPersistence().update(productPackageContent, serviceContext);
	}

	/**
	 * Returns all the product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product package contents
	 */
	public static List<ProductPackageContent> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProductPackageContent> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findByUuid_First(
			String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findByUuid_Last(
			String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where uuid = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent[] findByUuid_PrevAndNext(
			long packageContentId, String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_PrevAndNext(
			packageContentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product package contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product package contents
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product package content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product package content that was removed
	 */
	public static ProductPackageContent removeByUUID_G(
			String uuid, long groupId)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product package contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product package contents
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product package contents
	 */
	public static List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ProductPackageContent[] findByUuid_C_PrevAndNext(
			long packageContentId, String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			packageContentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product package contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product package contents
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product package contents
	 */
	public static List<ProductPackageContent> findBydraftProductId(
		long draftProductId) {

		return getPersistence().findBydraftProductId(draftProductId);
	}

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
	public static List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end);
	}

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
	public static List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator);
	}

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
	public static List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	public static ProductPackageContent findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().fetchBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent[] findBydraftProductId_PrevAndNext(
			long packageContentId, long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findBydraftProductId_PrevAndNext(
			packageContentId, draftProductId, orderByComparator);
	}

	/**
	 * Removes all the product package contents where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public static void removeBydraftProductId(long draftProductId) {
		getPersistence().removeBydraftProductId(draftProductId);
	}

	/**
	 * Returns the number of product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product package contents
	 */
	public static int countBydraftProductId(long draftProductId) {
		return getPersistence().countBydraftProductId(draftProductId);
	}

	/**
	 * Caches the product package content in the entity cache if it is enabled.
	 *
	 * @param productPackageContent the product package content
	 */
	public static void cacheResult(
		ProductPackageContent productPackageContent) {

		getPersistence().cacheResult(productPackageContent);
	}

	/**
	 * Caches the product package contents in the entity cache if it is enabled.
	 *
	 * @param productPackageContents the product package contents
	 */
	public static void cacheResult(
		List<ProductPackageContent> productPackageContents) {

		getPersistence().cacheResult(productPackageContents);
	}

	/**
	 * Creates a new product package content with the primary key. Does not add the product package content to the database.
	 *
	 * @param packageContentId the primary key for the new product package content
	 * @return the new product package content
	 */
	public static ProductPackageContent create(long packageContentId) {
		return getPersistence().create(packageContentId);
	}

	/**
	 * Removes the product package content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content that was removed
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent remove(long packageContentId)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().remove(packageContentId);
	}

	public static ProductPackageContent updateImpl(
		ProductPackageContent productPackageContent) {

		return getPersistence().updateImpl(productPackageContent);
	}

	/**
	 * Returns the product package content with the primary key or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent findByPrimaryKey(long packageContentId)
		throws com.marketplace.product.pkg.content.exception.
			NoSuchProductPackageContentException {

		return getPersistence().findByPrimaryKey(packageContentId);
	}

	/**
	 * Returns the product package content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content, or <code>null</code> if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent fetchByPrimaryKey(
		long packageContentId) {

		return getPersistence().fetchByPrimaryKey(packageContentId);
	}

	/**
	 * Returns all the product package contents.
	 *
	 * @return the product package contents
	 */
	public static List<ProductPackageContent> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProductPackageContent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProductPackageContent> findAll(
		int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProductPackageContent> findAll(
		int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product package contents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product package contents.
	 *
	 * @return the number of product package contents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductPackageContentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductPackageContentPersistence _persistence;

}