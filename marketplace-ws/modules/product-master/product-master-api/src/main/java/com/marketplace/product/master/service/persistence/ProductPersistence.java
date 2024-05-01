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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.master.exception.NoSuchProductException;
import com.marketplace.product.master.model.Product;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductUtil
 * @generated
 */
@ProviderType
public interface ProductPersistence extends BasePersistence<Product> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching products
	 */
	public java.util.List<Product> findByUuid(String uuid);

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
	public java.util.List<Product> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Product> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public java.util.List<Product> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Returns the first product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

	/**
	 * Returns the last product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Returns the last product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

	/**
	 * Returns the products before and after the current product in the ordered set where uuid = &#63;.
	 *
	 * @param draftProductId the primary key of the current product
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public Product[] findByUuid_PrevAndNext(
			long draftProductId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Removes all the products where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching products
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByUUID_G(String uuid, long groupId)
		throws NoSuchProductException;

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product that was removed
	 */
	public Product removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductException;

	/**
	 * Returns the number of products where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching products
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching products
	 */
	public java.util.List<Product> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public java.util.List<Product> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

	/**
	 * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public Product[] findByUuid_C_PrevAndNext(
			long draftProductId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Removes all the products where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching products
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the product where cpDefinitionId = &#63; or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching product
	 * @throws NoSuchProductException if a matching product could not be found
	 */
	public Product findByCPDefinitionId(long cpDefinitionId)
		throws NoSuchProductException;

	/**
	 * Returns the product where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByCPDefinitionId(long cpDefinitionId);

	/**
	 * Returns the product where cpDefinitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	public Product fetchByCPDefinitionId(
		long cpDefinitionId, boolean useFinderCache);

	/**
	 * Removes the product where cpDefinitionId = &#63; from the database.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the product that was removed
	 */
	public Product removeByCPDefinitionId(long cpDefinitionId)
		throws NoSuchProductException;

	/**
	 * Returns the number of products where cpDefinitionId = &#63;.
	 *
	 * @param cpDefinitionId the cp definition ID
	 * @return the number of matching products
	 */
	public int countByCPDefinitionId(long cpDefinitionId);

	/**
	 * Returns all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @return the matching products
	 */
	public java.util.List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus);

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
	public java.util.List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end);

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
	public java.util.List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public java.util.List<Product> findByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator,
		boolean useFinderCache);

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
	public Product findByproductsWithStatusById_First(
			String vendorId, long categoryId, String organizationId,
			String productStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

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
	public Product fetchByproductsWithStatusById_First(
		String vendorId, long categoryId, String organizationId,
		String productStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public Product findByproductsWithStatusById_Last(
			String vendorId, long categoryId, String organizationId,
			String productStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

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
	public Product fetchByproductsWithStatusById_Last(
		String vendorId, long categoryId, String organizationId,
		String productStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public Product[] findByproductsWithStatusById_PrevAndNext(
			long draftProductId, String vendorId, long categoryId,
			String organizationId, String productStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Product>
				orderByComparator)
		throws NoSuchProductException;

	/**
	 * Removes all the products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63; from the database.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 */
	public void removeByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus);

	/**
	 * Returns the number of products where vendorId = &#63; and categoryId = &#63; and organizationId = &#63; and productStatus = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param categoryId the category ID
	 * @param organizationId the organization ID
	 * @param productStatus the product status
	 * @return the number of matching products
	 */
	public int countByproductsWithStatusById(
		String vendorId, long categoryId, String organizationId,
		String productStatus);

	/**
	 * Caches the product in the entity cache if it is enabled.
	 *
	 * @param product the product
	 */
	public void cacheResult(Product product);

	/**
	 * Caches the products in the entity cache if it is enabled.
	 *
	 * @param products the products
	 */
	public void cacheResult(java.util.List<Product> products);

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param draftProductId the primary key for the new product
	 * @return the new product
	 */
	public Product create(long draftProductId);

	/**
	 * Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product that was removed
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public Product remove(long draftProductId) throws NoSuchProductException;

	public Product updateImpl(Product product);

	/**
	 * Returns the product with the primary key or throws a <code>NoSuchProductException</code> if it could not be found.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product
	 * @throws NoSuchProductException if a product with the primary key could not be found
	 */
	public Product findByPrimaryKey(long draftProductId)
		throws NoSuchProductException;

	/**
	 * Returns the product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product, or <code>null</code> if a product with the primary key could not be found
	 */
	public Product fetchByPrimaryKey(long draftProductId);

	/**
	 * Returns all the products.
	 *
	 * @return the products
	 */
	public java.util.List<Product> findAll();

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
	public java.util.List<Product> findAll(int start, int end);

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
	public java.util.List<Product> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator);

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
	public java.util.List<Product> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Product>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the products from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	public int countAll();

}