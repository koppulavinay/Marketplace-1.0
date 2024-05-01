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

package com.marketplace.brand.document.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.brand.document.master.model.BrandDocumentUpload;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the brand document upload service. This utility wraps <code>com.marketplace.brand.document.master.service.persistence.impl.BrandDocumentUploadPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandDocumentUploadPersistence
 * @generated
 */
public class BrandDocumentUploadUtil {

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
	public static void clearCache(BrandDocumentUpload brandDocumentUpload) {
		getPersistence().clearCache(brandDocumentUpload);
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
	public static Map<Serializable, BrandDocumentUpload> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BrandDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BrandDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BrandDocumentUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BrandDocumentUpload update(
		BrandDocumentUpload brandDocumentUpload) {

		return getPersistence().update(brandDocumentUpload);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BrandDocumentUpload update(
		BrandDocumentUpload brandDocumentUpload,
		ServiceContext serviceContext) {

		return getPersistence().update(brandDocumentUpload, serviceContext);
	}

	/**
	 * Returns all the brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByFBYBrandId(long brandId) {
		return getPersistence().findByFBYBrandId(brandId);
	}

	/**
	 * Returns a range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end) {

		return getPersistence().findByFBYBrandId(brandId, start, end);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().findByFBYBrandId(
			brandId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFBYBrandId(
			brandId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload findByFBYBrandId_First(
			long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByFBYBrandId_First(
			brandId, orderByComparator);
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload fetchByFBYBrandId_First(
		long brandId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().fetchByFBYBrandId_First(
			brandId, orderByComparator);
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload findByFBYBrandId_Last(
			long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByFBYBrandId_Last(
			brandId, orderByComparator);
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload fetchByFBYBrandId_Last(
		long brandId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().fetchByFBYBrandId_Last(
			brandId, orderByComparator);
	}

	/**
	 * Returns the brand document uploads before and after the current brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandDocumentUploadId the primary key of the current brand document upload
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload[] findByFBYBrandId_PrevAndNext(
			long brandDocumentUploadId, long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByFBYBrandId_PrevAndNext(
			brandDocumentUploadId, brandId, orderByComparator);
	}

	/**
	 * Removes all the brand document uploads where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	public static void removeByFBYBrandId(long brandId) {
		getPersistence().removeByFBYBrandId(brandId);
	}

	/**
	 * Returns the number of brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand document uploads
	 */
	public static int countByFBYBrandId(long brandId) {
		return getPersistence().countByFBYBrandId(brandId);
	}

	/**
	 * Returns all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId) {

		return getPersistence().findByBrandAndFileId(brandId, documentId);
	}

	/**
	 * Returns a range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end) {

		return getPersistence().findByBrandAndFileId(
			brandId, documentId, start, end);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().findByBrandAndFileId(
			brandId, documentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand document uploads
	 */
	public static List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBrandAndFileId(
			brandId, documentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload findByBrandAndFileId_First(
			long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByBrandAndFileId_First(
			brandId, documentId, orderByComparator);
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload fetchByBrandAndFileId_First(
		long brandId, long documentId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().fetchByBrandAndFileId_First(
			brandId, documentId, orderByComparator);
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload findByBrandAndFileId_Last(
			long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByBrandAndFileId_Last(
			brandId, documentId, orderByComparator);
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public static BrandDocumentUpload fetchByBrandAndFileId_Last(
		long brandId, long documentId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().fetchByBrandAndFileId_Last(
			brandId, documentId, orderByComparator);
	}

	/**
	 * Returns the brand document uploads before and after the current brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandDocumentUploadId the primary key of the current brand document upload
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload[] findByBrandAndFileId_PrevAndNext(
			long brandDocumentUploadId, long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByBrandAndFileId_PrevAndNext(
			brandDocumentUploadId, brandId, documentId, orderByComparator);
	}

	/**
	 * Removes all the brand document uploads where brandId = &#63; and documentId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 */
	public static void removeByBrandAndFileId(long brandId, long documentId) {
		getPersistence().removeByBrandAndFileId(brandId, documentId);
	}

	/**
	 * Returns the number of brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the number of matching brand document uploads
	 */
	public static int countByBrandAndFileId(long brandId, long documentId) {
		return getPersistence().countByBrandAndFileId(brandId, documentId);
	}

	/**
	 * Caches the brand document upload in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUpload the brand document upload
	 */
	public static void cacheResult(BrandDocumentUpload brandDocumentUpload) {
		getPersistence().cacheResult(brandDocumentUpload);
	}

	/**
	 * Caches the brand document uploads in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUploads the brand document uploads
	 */
	public static void cacheResult(
		List<BrandDocumentUpload> brandDocumentUploads) {

		getPersistence().cacheResult(brandDocumentUploads);
	}

	/**
	 * Creates a new brand document upload with the primary key. Does not add the brand document upload to the database.
	 *
	 * @param brandDocumentUploadId the primary key for the new brand document upload
	 * @return the new brand document upload
	 */
	public static BrandDocumentUpload create(long brandDocumentUploadId) {
		return getPersistence().create(brandDocumentUploadId);
	}

	/**
	 * Removes the brand document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload that was removed
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload remove(long brandDocumentUploadId)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().remove(brandDocumentUploadId);
	}

	public static BrandDocumentUpload updateImpl(
		BrandDocumentUpload brandDocumentUpload) {

		return getPersistence().updateImpl(brandDocumentUpload);
	}

	/**
	 * Returns the brand document upload with the primary key or throws a <code>NoSuchBrandDocumentUploadException</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload findByPrimaryKey(
			long brandDocumentUploadId)
		throws com.marketplace.brand.document.master.exception.
			NoSuchBrandDocumentUploadException {

		return getPersistence().findByPrimaryKey(brandDocumentUploadId);
	}

	/**
	 * Returns the brand document upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload, or <code>null</code> if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload fetchByPrimaryKey(
		long brandDocumentUploadId) {

		return getPersistence().fetchByPrimaryKey(brandDocumentUploadId);
	}

	/**
	 * Returns all the brand document uploads.
	 *
	 * @return the brand document uploads
	 */
	public static List<BrandDocumentUpload> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of brand document uploads
	 */
	public static List<BrandDocumentUpload> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand document uploads
	 */
	public static List<BrandDocumentUpload> findAll(
		int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brand document uploads
	 */
	public static List<BrandDocumentUpload> findAll(
		int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the brand document uploads from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of brand document uploads.
	 *
	 * @return the number of brand document uploads
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BrandDocumentUploadPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BrandDocumentUploadPersistence _persistence;

}