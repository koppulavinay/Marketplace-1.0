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

package com.marketplace.product.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.master.model.Product;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product service. This utility wraps <code>com.marketplace.product.master.service.persistence.impl.ProductPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductPersistence
 * @generated
 */
public class ProductUtil {

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
	public static void clearCache(Product product) {
		getPersistence().clearCache(product);
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
	public static Map<Serializable, Product> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Product> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Product> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Product> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Product update(Product product) {
		return getPersistence().update(product);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Product update(
		Product product, ServiceContext serviceContext) {

		return getPersistence().update(product, serviceContext);
	}

	/**
	 * Returns all the products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching products
	 */
	public static List<Product> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 */
	public static List<Product> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the products where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Product> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByUuid_First(
			String uuid, OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUuid_First(
		String uuid, OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByUuid_Last(
			String uuid, OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUuid_Last(
		String uuid, OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the products before and after the current product in the ordered set where uuid = &#63;.
	 *
	 * @param draftProductId the primary key of the current product
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public static Product[] findByUuid_PrevAndNext(
			long draftProductId, String uuid,
			OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_PrevAndNext(
			draftProductId, uuid, orderByComparator);
	}

	/**
	 * Removes all the products where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching products
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the product where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product that was removed
	 */
	public static Product removeByUUID_G(String uuid, long groupId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of products where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching products
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching products
	 */
	public static List<Product> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 */
	public static List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the products where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Product> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the products before and after the current product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param draftProductId the primary key of the current product
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public static Product[] findByUuid_C_PrevAndNext(
			long draftProductId, String uuid, long companyId,
			OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByUuid_C_PrevAndNext(
			draftProductId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the products where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching products
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the product where cpDefinitionId = &#63; or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByCPDefinitionId(long cpDefinitionId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the product where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByCPDefinitionId(long cpDefinitionId) {
		return getPersistence().fetchByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the product where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByCPDefinitionId(
		long cpDefinitionId, boolean useFinderCache) {

		return getPersistence().fetchByCPDefinitionId(
			cpDefinitionId, useFinderCache);
	}

	/**
	 * Removes the product where cpDefinitionId = &#63; from the database.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the product that was removed
	 */
	public static Product removeByCPDefinitionId(long cpDefinitionId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().removeByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns the number of products where cpDefinitionId = &#63;.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the number of matching products
	 */
	public static int countByCPDefinitionId(long cpDefinitionId) {
		return getPersistence().countByCPDefinitionId(cpDefinitionId);
	}

	/**
	 * Returns all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @return the matching products
	 */
	public static List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus) {

		return getPersistence().findByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus);
	}

	/**
	 * Returns a range of all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 */
	public static List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end) {

		return getPersistence().findByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end,
		OrderByComparator<Product> orderByComparator) {

		return getPersistence().findByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching products
	 */
	public static List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end,
		OrderByComparator<Product> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product in the ordered set where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByproductsWithStatusById_First(
			String vendorId, long categoryId, String organizationId,
			String productStatus, OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByproductsWithStatusById_First(
			vendorId, categoryId, organizationId, productStatus,
			orderByComparator);
	}

	/**
	 * Returns the first product in the ordered set where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByproductsWithStatusById_First(
		String vendorId, long categoryId, String organizationId,
		String productStatus, OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByproductsWithStatusById_First(
			vendorId, categoryId, organizationId, productStatus,
			orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public static Product findByproductsWithStatusById_Last(
			String vendorId, long categoryId, String organizationId,
			String productStatus, OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByproductsWithStatusById_Last(
			vendorId, categoryId, organizationId, productStatus,
			orderByComparator);
	}

	/**
	 * Returns the last product in the ordered set where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 */
	public static Product fetchByproductsWithStatusById_Last(
		String vendorId, long categoryId, String organizationId,
		String productStatus, OrderByComparator<Product> orderByComparator) {

		return getPersistence().fetchByproductsWithStatusById_Last(
			vendorId, categoryId, organizationId, productStatus,
			orderByComparator);
	}

	/**
	 * Returns the products before and after the current product in the ordered set where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param draftProductId the primary key of the current product
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public static Product[] findByproductsWithStatusById_PrevAndNext(
			long draftProductId, String vendorId, long categoryId,
			String organizationId, String productStatus,
			OrderByComparator<Product> orderByComparator)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByproductsWithStatusById_PrevAndNext(
			draftProductId, vendorId, categoryId, organizationId, productStatus,
			orderByComparator);
	}

	/**
	 * Removes all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63; from the database.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 */
	public static void removeByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus) {

		getPersistence().removeByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus);
	}

	/**
	 * Returns the number of products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @return the number of matching products
	 */
	public static int countByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus) {

		return getPersistence().countByproductsWithStatusById(
			vendorId, categoryId, organizationId, productStatus);
	}

	/**
	 * Caches the product in the entity cache if it is enabled.
	 *
	 * @param product the product
	 */
	public static void cacheResult(Product product) {
		getPersistence().cacheResult(product);
	}

	/**
	 * Caches the products in the entity cache if it is enabled.
	 *
	 * @param products the products
	 */
	public static void cacheResult(List<Product> products) {
		getPersistence().cacheResult(products);
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param draftProductId the primary key for the new product
	 * @return the new product
	 */
	public static Product create(long draftProductId) {
		return getPersistence().create(draftProductId);
	}

	/**
	 * Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product that was removed
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public static Product remove(long draftProductId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().remove(draftProductId);
	}

	public static Product updateImpl(Product product) {
		return getPersistence().updateImpl(product);
	}

	/**
	 * Returns the product with the primary key or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public static Product findByPrimaryKey(long draftProductId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return getPersistence().findByPrimaryKey(draftProductId);
	}

	/**
	 * Returns the product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product, or <code>null</code> if a product with the primary key could not be found
	 */
	public static Product fetchByPrimaryKey(long draftProductId) {
		return getPersistence().fetchByPrimaryKey(draftProductId);
	}

	/**
	 * Returns all the products.
	 *
	 * @return the products
	 */
	public static List<Product> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 */
	public static List<Product> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of products
	 */
	public static List<Product> findAll(
		int start, int end, OrderByComparator<Product> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of products
	 */
	public static List<Product> findAll(
		int start, int end, OrderByComparator<Product> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the products from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductPersistence _persistence;

}