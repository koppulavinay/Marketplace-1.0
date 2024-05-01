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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.brand.document.master.exception.NoSuchBrandDocumentUploadException;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the brand document upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandDocumentUploadUtil
 * @generated
 */
@ProviderType
public interface BrandDocumentUploadPersistence
	extends BasePersistence<BrandDocumentUpload> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrandDocumentUploadUtil} to access the brand document upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand document uploads
	 */
	public java.util.List<BrandDocumentUpload> findByFBYBrandId(long brandId);

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
	public java.util.List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end);

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
	public java.util.List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

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
	public java.util.List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload findByFBYBrandId_First(
			long brandId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload fetchByFBYBrandId_First(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload findByFBYBrandId_Last(
			long brandId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload fetchByFBYBrandId_Last(
		long brandId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

	/**
	 * Returns the brand document uploads before and after the current brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandDocumentUploadId the primary key of the current brand document upload
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public BrandDocumentUpload[] findByFBYBrandId_PrevAndNext(
			long brandDocumentUploadId, long brandId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Removes all the brand document uploads where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	public void removeByFBYBrandId(long brandId);

	/**
	 * Returns the number of brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand document uploads
	 */
	public int countByFBYBrandId(long brandId);

	/**
	 * Returns all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the matching brand document uploads
	 */
	public java.util.List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId);

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
	public java.util.List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end);

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
	public java.util.List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

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
	public java.util.List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload findByBrandAndFileId_First(
			long brandId, long documentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload fetchByBrandAndFileId_First(
		long brandId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload findByBrandAndFileId_Last(
			long brandId, long documentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	public BrandDocumentUpload fetchByBrandAndFileId_Last(
		long brandId, long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

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
	public BrandDocumentUpload[] findByBrandAndFileId_PrevAndNext(
			long brandDocumentUploadId, long brandId, long documentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Removes all the brand document uploads where brandId = &#63; and documentId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 */
	public void removeByBrandAndFileId(long brandId, long documentId);

	/**
	 * Returns the number of brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the number of matching brand document uploads
	 */
	public int countByBrandAndFileId(long brandId, long documentId);

	/**
	 * Caches the brand document upload in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUpload the brand document upload
	 */
	public void cacheResult(BrandDocumentUpload brandDocumentUpload);

	/**
	 * Caches the brand document uploads in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUploads the brand document uploads
	 */
	public void cacheResult(
		java.util.List<BrandDocumentUpload> brandDocumentUploads);

	/**
	 * Creates a new brand document upload with the primary key. Does not add the brand document upload to the database.
	 *
	 * @param brandDocumentUploadId the primary key for the new brand document upload
	 * @return the new brand document upload
	 */
	public BrandDocumentUpload create(long brandDocumentUploadId);

	/**
	 * Removes the brand document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload that was removed
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public BrandDocumentUpload remove(long brandDocumentUploadId)
		throws NoSuchBrandDocumentUploadException;

	public BrandDocumentUpload updateImpl(
		BrandDocumentUpload brandDocumentUpload);

	/**
	 * Returns the brand document upload with the primary key or throws a <code>NoSuchBrandDocumentUploadException</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	public BrandDocumentUpload findByPrimaryKey(long brandDocumentUploadId)
		throws NoSuchBrandDocumentUploadException;

	/**
	 * Returns the brand document upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload, or <code>null</code> if a brand document upload with the primary key could not be found
	 */
	public BrandDocumentUpload fetchByPrimaryKey(long brandDocumentUploadId);

	/**
	 * Returns all the brand document uploads.
	 *
	 * @return the brand document uploads
	 */
	public java.util.List<BrandDocumentUpload> findAll();

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
	public java.util.List<BrandDocumentUpload> findAll(int start, int end);

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
	public java.util.List<BrandDocumentUpload> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator);

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
	public java.util.List<BrandDocumentUpload> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrandDocumentUpload>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the brand document uploads from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of brand document uploads.
	 *
	 * @return the number of brand document uploads
	 */
	public int countAll();

}