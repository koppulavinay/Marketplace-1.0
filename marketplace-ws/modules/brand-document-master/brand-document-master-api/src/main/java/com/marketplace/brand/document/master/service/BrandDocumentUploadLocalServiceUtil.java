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

package com.marketplace.brand.document.master.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.brand.document.master.model.BrandDocumentUpload;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BrandDocumentUpload. This utility wraps
 * <code>com.marketplace.brand.document.master.service.impl.BrandDocumentUploadLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BrandDocumentUploadLocalService
 * @generated
 */
public class BrandDocumentUploadLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.brand.document.master.service.impl.BrandDocumentUploadLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the brand document upload to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandDocumentUploadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandDocumentUpload the brand document upload
	 * @return the brand document upload that was added
	 */
	public static BrandDocumentUpload addBrandDocumentUpload(
		BrandDocumentUpload brandDocumentUpload) {

		return getService().addBrandDocumentUpload(brandDocumentUpload);
	}

	/**
	 * Creates a new brand document upload with the primary key. Does not add the brand document upload to the database.
	 *
	 * @param brandDocumentUploadId the primary key for the new brand document upload
	 * @return the new brand document upload
	 */
	public static BrandDocumentUpload createBrandDocumentUpload(
		long brandDocumentUploadId) {

		return getService().createBrandDocumentUpload(brandDocumentUploadId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the brand document upload from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandDocumentUploadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandDocumentUpload the brand document upload
	 * @return the brand document upload that was removed
	 */
	public static BrandDocumentUpload deleteBrandDocumentUpload(
		BrandDocumentUpload brandDocumentUpload) {

		return getService().deleteBrandDocumentUpload(brandDocumentUpload);
	}

	/**
	 * Deletes the brand document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandDocumentUploadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload that was removed
	 * @throws PortalException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload deleteBrandDocumentUpload(
			long brandDocumentUploadId)
		throws PortalException {

		return getService().deleteBrandDocumentUpload(brandDocumentUploadId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.document.master.model.impl.BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.document.master.model.impl.BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static BrandDocumentUpload fetchBrandDocumentUpload(
		long brandDocumentUploadId) {

		return getService().fetchBrandDocumentUpload(brandDocumentUploadId);
	}

	public static List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId) {

		return getService().findByBrandAndFileId(brandId, documentId);
	}

	public static List<BrandDocumentUpload> findByFBYBrandId(long brandId) {
		return getService().findByFBYBrandId(brandId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the brand document upload with the primary key.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws PortalException if a brand document upload with the primary key could not be found
	 */
	public static BrandDocumentUpload getBrandDocumentUpload(
			long brandDocumentUploadId)
		throws PortalException {

		return getService().getBrandDocumentUpload(brandDocumentUploadId);
	}

	/**
	 * Returns a range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.document.master.model.impl.BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of brand document uploads
	 */
	public static List<BrandDocumentUpload> getBrandDocumentUploads(
		int start, int end) {

		return getService().getBrandDocumentUploads(start, end);
	}

	/**
	 * Returns the number of brand document uploads.
	 *
	 * @return the number of brand document uploads
	 */
	public static int getBrandDocumentUploadsCount() {
		return getService().getBrandDocumentUploadsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the brand document upload in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandDocumentUploadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandDocumentUpload the brand document upload
	 * @return the brand document upload that was updated
	 */
	public static BrandDocumentUpload updateBrandDocumentUpload(
		BrandDocumentUpload brandDocumentUpload) {

		return getService().updateBrandDocumentUpload(brandDocumentUpload);
	}

	public static BrandDocumentUploadLocalService getService() {
		return _service;
	}

	private static volatile BrandDocumentUploadLocalService _service;

}