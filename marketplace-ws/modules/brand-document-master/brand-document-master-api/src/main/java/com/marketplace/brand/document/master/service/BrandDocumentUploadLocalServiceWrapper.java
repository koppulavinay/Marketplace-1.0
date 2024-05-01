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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrandDocumentUploadLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrandDocumentUploadLocalService
 * @generated
 */
public class BrandDocumentUploadLocalServiceWrapper
	implements BrandDocumentUploadLocalService,
			   ServiceWrapper<BrandDocumentUploadLocalService> {

	public BrandDocumentUploadLocalServiceWrapper() {
		this(null);
	}

	public BrandDocumentUploadLocalServiceWrapper(
		BrandDocumentUploadLocalService brandDocumentUploadLocalService) {

		_brandDocumentUploadLocalService = brandDocumentUploadLocalService;
	}

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
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
		addBrandDocumentUpload(
			com.marketplace.brand.document.master.model.BrandDocumentUpload
				brandDocumentUpload) {

		return _brandDocumentUploadLocalService.addBrandDocumentUpload(
			brandDocumentUpload);
	}

	/**
	 * Creates a new brand document upload with the primary key. Does not add the brand document upload to the database.
	 *
	 * @param brandDocumentUploadId the primary key for the new brand document upload
	 * @return the new brand document upload
	 */
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
		createBrandDocumentUpload(long brandDocumentUploadId) {

		return _brandDocumentUploadLocalService.createBrandDocumentUpload(
			brandDocumentUploadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandDocumentUploadLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
		deleteBrandDocumentUpload(
			com.marketplace.brand.document.master.model.BrandDocumentUpload
				brandDocumentUpload) {

		return _brandDocumentUploadLocalService.deleteBrandDocumentUpload(
			brandDocumentUpload);
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
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
			deleteBrandDocumentUpload(long brandDocumentUploadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandDocumentUploadLocalService.deleteBrandDocumentUpload(
			brandDocumentUploadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandDocumentUploadLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _brandDocumentUploadLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _brandDocumentUploadLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _brandDocumentUploadLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _brandDocumentUploadLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _brandDocumentUploadLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _brandDocumentUploadLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _brandDocumentUploadLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _brandDocumentUploadLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
		fetchBrandDocumentUpload(long brandDocumentUploadId) {

		return _brandDocumentUploadLocalService.fetchBrandDocumentUpload(
			brandDocumentUploadId);
	}

	@Override
	public java.util.List
		<com.marketplace.brand.document.master.model.BrandDocumentUpload>
			findByBrandAndFileId(long brandId, long documentId) {

		return _brandDocumentUploadLocalService.findByBrandAndFileId(
			brandId, documentId);
	}

	@Override
	public java.util.List
		<com.marketplace.brand.document.master.model.BrandDocumentUpload>
			findByFBYBrandId(long brandId) {

		return _brandDocumentUploadLocalService.findByFBYBrandId(brandId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _brandDocumentUploadLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the brand document upload with the primary key.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws PortalException if a brand document upload with the primary key could not be found
	 */
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
			getBrandDocumentUpload(long brandDocumentUploadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandDocumentUploadLocalService.getBrandDocumentUpload(
			brandDocumentUploadId);
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
	@Override
	public java.util.List
		<com.marketplace.brand.document.master.model.BrandDocumentUpload>
			getBrandDocumentUploads(int start, int end) {

		return _brandDocumentUploadLocalService.getBrandDocumentUploads(
			start, end);
	}

	/**
	 * Returns the number of brand document uploads.
	 *
	 * @return the number of brand document uploads
	 */
	@Override
	public int getBrandDocumentUploadsCount() {
		return _brandDocumentUploadLocalService.getBrandDocumentUploadsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _brandDocumentUploadLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _brandDocumentUploadLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandDocumentUploadLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.marketplace.brand.document.master.model.BrandDocumentUpload
		updateBrandDocumentUpload(
			com.marketplace.brand.document.master.model.BrandDocumentUpload
				brandDocumentUpload) {

		return _brandDocumentUploadLocalService.updateBrandDocumentUpload(
			brandDocumentUpload);
	}

	@Override
	public BrandDocumentUploadLocalService getWrappedService() {
		return _brandDocumentUploadLocalService;
	}

	@Override
	public void setWrappedService(
		BrandDocumentUploadLocalService brandDocumentUploadLocalService) {

		_brandDocumentUploadLocalService = brandDocumentUploadLocalService;
	}

	private BrandDocumentUploadLocalService _brandDocumentUploadLocalService;

}