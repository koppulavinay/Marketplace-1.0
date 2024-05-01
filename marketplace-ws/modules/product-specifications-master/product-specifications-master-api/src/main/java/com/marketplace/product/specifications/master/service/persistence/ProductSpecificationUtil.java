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

package com.marketplace.product.specifications.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.specifications.master.model.ProductSpecification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product specification service. This utility wraps <code>com.marketplace.product.specifications.master.service.persistence.impl.ProductSpecificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationPersistence
 * @generated
 */
public class ProductSpecificationUtil {

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
	public static void clearCache(ProductSpecification productSpecification) {
		getPersistence().clearCache(productSpecification);
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
	public static Map<Serializable, ProductSpecification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductSpecification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductSpecification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductSpecification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductSpecification update(
		ProductSpecification productSpecification) {

		return getPersistence().update(productSpecification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductSpecification update(
		ProductSpecification productSpecification,
		ServiceContext serviceContext) {

		return getPersistence().update(productSpecification, serviceContext);
	}

	/**
	 * Returns all the product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specifications
	 */
	public static List<ProductSpecification> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public static ProductSpecification[] findByUuid_PrevAndNext(
			long productSpecificationId, String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_PrevAndNext(
			productSpecificationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specifications
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product specification that was removed
	 */
	public static ProductSpecification removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of product specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product specifications
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specifications
	 */
	public static List<ProductSpecification> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public static ProductSpecification[] findByUuid_C_PrevAndNext(
			long productSpecificationId, String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			productSpecificationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the product specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specifications
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product specifications
	 */
	public static List<ProductSpecification> findBydraftProductId(
		long draftProductId) {

		return getPersistence().findBydraftProductId(draftProductId);
	}

	/**
	 * Returns a range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	public static List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end);
	}

	/**
	 * Returns an ordered range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	public static List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydraftProductId(
			draftProductId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchBydraftProductId_First(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public static ProductSpecification findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public static ProductSpecification fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().fetchBydraftProductId_Last(
			draftProductId, orderByComparator);
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public static ProductSpecification[] findBydraftProductId_PrevAndNext(
			long productSpecificationId, long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findBydraftProductId_PrevAndNext(
			productSpecificationId, draftProductId, orderByComparator);
	}

	/**
	 * Removes all the product specifications where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public static void removeBydraftProductId(long draftProductId) {
		getPersistence().removeBydraftProductId(draftProductId);
	}

	/**
	 * Returns the number of product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product specifications
	 */
	public static int countBydraftProductId(long draftProductId) {
		return getPersistence().countBydraftProductId(draftProductId);
	}

	/**
	 * Caches the product specification in the entity cache if it is enabled.
	 *
	 * @param productSpecification the product specification
	 */
	public static void cacheResult(ProductSpecification productSpecification) {
		getPersistence().cacheResult(productSpecification);
	}

	/**
	 * Caches the product specifications in the entity cache if it is enabled.
	 *
	 * @param productSpecifications the product specifications
	 */
	public static void cacheResult(
		List<ProductSpecification> productSpecifications) {

		getPersistence().cacheResult(productSpecifications);
	}

	/**
	 * Creates a new product specification with the primary key. Does not add the product specification to the database.
	 *
	 * @param productSpecificationId the primary key for the new product specification
	 * @return the new product specification
	 */
	public static ProductSpecification create(long productSpecificationId) {
		return getPersistence().create(productSpecificationId);
	}

	/**
	 * Removes the product specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification that was removed
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public static ProductSpecification remove(long productSpecificationId)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().remove(productSpecificationId);
	}

	public static ProductSpecification updateImpl(
		ProductSpecification productSpecification) {

		return getPersistence().updateImpl(productSpecification);
	}

	/**
	 * Returns the product specification with the primary key or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public static ProductSpecification findByPrimaryKey(
			long productSpecificationId)
		throws com.marketplace.product.specifications.master.exception.
			NoSuchProductSpecificationException {

		return getPersistence().findByPrimaryKey(productSpecificationId);
	}

	/**
	 * Returns the product specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification, or <code>null</code> if a product specification with the primary key could not be found
	 */
	public static ProductSpecification fetchByPrimaryKey(
		long productSpecificationId) {

		return getPersistence().fetchByPrimaryKey(productSpecificationId);
	}

	/**
	 * Returns all the product specifications.
	 *
	 * @return the product specifications
	 */
	public static List<ProductSpecification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of product specifications
	 */
	public static List<ProductSpecification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product specifications
	 */
	public static List<ProductSpecification> findAll(
		int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product specifications
	 */
	public static List<ProductSpecification> findAll(
		int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product specifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product specifications.
	 *
	 * @return the number of product specifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductSpecificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductSpecificationPersistence _persistence;

}