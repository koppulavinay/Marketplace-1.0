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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.product.specifications.master.exception.NoSuchProductSpecificationException;
import com.marketplace.product.specifications.master.model.ProductSpecification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product specification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationUtil
 * @generated
 */
@ProviderType
public interface ProductSpecificationPersistence
	extends BasePersistence<ProductSpecification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductSpecificationUtil} to access the product specification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specifications
	 */
	public java.util.List<ProductSpecification> findByUuid(String uuid);

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
	public java.util.List<ProductSpecification> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

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
	public java.util.List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public ProductSpecification[] findByUuid_PrevAndNext(
			long productSpecificationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Removes all the product specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specifications
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the product specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product specification that was removed
	 */
	public ProductSpecification removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the number of product specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product specifications
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specifications
	 */
	public java.util.List<ProductSpecification> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

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
	public java.util.List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

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
	public ProductSpecification[] findByUuid_C_PrevAndNext(
			long productSpecificationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Removes all the product specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specifications
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product specifications
	 */
	public java.util.List<ProductSpecification> findBydraftProductId(
		long draftProductId);

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
	public java.util.List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end);

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
	public java.util.List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

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
	public java.util.List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findBydraftProductId_First(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchBydraftProductId_First(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	public ProductSpecification findBydraftProductId_Last(
			long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	public ProductSpecification fetchBydraftProductId_Last(
		long draftProductId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public ProductSpecification[] findBydraftProductId_PrevAndNext(
			long productSpecificationId, long draftProductId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException;

	/**
	 * Removes all the product specifications where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	public void removeBydraftProductId(long draftProductId);

	/**
	 * Returns the number of product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product specifications
	 */
	public int countBydraftProductId(long draftProductId);

	/**
	 * Caches the product specification in the entity cache if it is enabled.
	 *
	 * @param productSpecification the product specification
	 */
	public void cacheResult(ProductSpecification productSpecification);

	/**
	 * Caches the product specifications in the entity cache if it is enabled.
	 *
	 * @param productSpecifications the product specifications
	 */
	public void cacheResult(
		java.util.List<ProductSpecification> productSpecifications);

	/**
	 * Creates a new product specification with the primary key. Does not add the product specification to the database.
	 *
	 * @param productSpecificationId the primary key for the new product specification
	 * @return the new product specification
	 */
	public ProductSpecification create(long productSpecificationId);

	/**
	 * Removes the product specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification that was removed
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public ProductSpecification remove(long productSpecificationId)
		throws NoSuchProductSpecificationException;

	public ProductSpecification updateImpl(
		ProductSpecification productSpecification);

	/**
	 * Returns the product specification with the primary key or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	public ProductSpecification findByPrimaryKey(long productSpecificationId)
		throws NoSuchProductSpecificationException;

	/**
	 * Returns the product specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification, or <code>null</code> if a product specification with the primary key could not be found
	 */
	public ProductSpecification fetchByPrimaryKey(long productSpecificationId);

	/**
	 * Returns all the product specifications.
	 *
	 * @return the product specifications
	 */
	public java.util.List<ProductSpecification> findAll();

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
	public java.util.List<ProductSpecification> findAll(int start, int end);

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
	public java.util.List<ProductSpecification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator);

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
	public java.util.List<ProductSpecification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductSpecification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product specifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product specifications.
	 *
	 * @return the number of product specifications
	 */
	public int countAll();

}