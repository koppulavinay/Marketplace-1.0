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

package com.marketplace.brand.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrandLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrandLocalService
 * @generated
 */
public class BrandLocalServiceWrapper
	implements BrandLocalService, ServiceWrapper<BrandLocalService> {

	public BrandLocalServiceWrapper() {
		this(null);
	}

	public BrandLocalServiceWrapper(BrandLocalService brandLocalService) {
		_brandLocalService = brandLocalService;
	}

	/**
	 * Adds the brand to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was added
	 */
	@Override
	public com.marketplace.brand.model.Brand addBrand(
		com.marketplace.brand.model.Brand brand) {

		return _brandLocalService.addBrand(brand);
	}

	@Override
	public com.marketplace.brand.model.Brand addBrand(
			com.marketplace.brand.model.Brand brand,
			com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.addBrand(brand, user, serviceContext);
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	@Override
	public com.marketplace.brand.model.Brand createBrand(long brandId) {
		return _brandLocalService.createBrand(brandId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the brand from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was removed
	 */
	@Override
	public com.marketplace.brand.model.Brand deleteBrand(
		com.marketplace.brand.model.Brand brand) {

		return _brandLocalService.deleteBrand(brand);
	}

	/**
	 * Deletes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand that was removed
	 * @throws PortalException if a brand with the primary key could not be found
	 */
	@Override
	public com.marketplace.brand.model.Brand deleteBrand(long brandId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.deleteBrand(brandId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _brandLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _brandLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _brandLocalService.dynamicQuery();
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

		return _brandLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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

		return _brandLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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

		return _brandLocalService.dynamicQuery(
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

		return _brandLocalService.dynamicQueryCount(dynamicQuery);
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

		return _brandLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.marketplace.brand.model.Brand fetchBrand(long brandId) {
		return _brandLocalService.fetchBrand(brandId);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public com.marketplace.brand.model.Brand fetchBrandByUuidAndGroupId(
		String uuid, long groupId) {

		return _brandLocalService.fetchBrandByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.marketplace.brand.model.Brand findByFBYAssetCategoryId(
		long assetCategoryId) {

		return _brandLocalService.findByFBYAssetCategoryId(assetCategoryId);
	}

	@Override
	public java.util.List<com.marketplace.brand.model.Brand> findByFBYCreatedBy(
		long createdBy) {

		return _brandLocalService.findByFBYCreatedBy(createdBy);
	}

	@Override
	public java.util.List<com.marketplace.brand.model.Brand>
		findByFBYCreatedBys(long createdBy, int start, int end) {

		return _brandLocalService.findByFBYCreatedBys(createdBy, start, end);
	}

	@Override
	public java.util.List<com.marketplace.brand.model.Brand> findByFBYStatus(
		String brandApprovalStatus) {

		return _brandLocalService.findByFBYStatus(brandApprovalStatus);
	}

	@Override
	public java.util.List<com.marketplace.brand.model.Brand> findByFBYStatuses(
		String brandApprovalStatus, int start, int end) {

		return _brandLocalService.findByFBYStatuses(
			brandApprovalStatus, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _brandLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the brand with the primary key.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws PortalException if a brand with the primary key could not be found
	 */
	@Override
	public com.marketplace.brand.model.Brand getBrand(long brandId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.getBrand(brandId);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand
	 * @throws PortalException if a matching brand could not be found
	 */
	@Override
	public com.marketplace.brand.model.Brand getBrandByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.getBrandByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of brands
	 */
	@Override
	public java.util.List<com.marketplace.brand.model.Brand> getBrands(
		int start, int end) {

		return _brandLocalService.getBrands(start, end);
	}

	/**
	 * Returns all the brands matching the UUID and company.
	 *
	 * @param uuid the UUID of the brands
	 * @param companyId the primary key of the company
	 * @return the matching brands, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.marketplace.brand.model.Brand>
		getBrandsByUuidAndCompanyId(String uuid, long companyId) {

		return _brandLocalService.getBrandsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of brands matching the UUID and company.
	 *
	 * @param uuid the UUID of the brands
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching brands, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.marketplace.brand.model.Brand>
		getBrandsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.marketplace.brand.model.Brand> orderByComparator) {

		return _brandLocalService.getBrandsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	@Override
	public int getBrandsCount() {
		return _brandLocalService.getBrandsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _brandLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _brandLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _brandLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the brand in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was updated
	 */
	@Override
	public com.marketplace.brand.model.Brand updateBrand(
		com.marketplace.brand.model.Brand brand) {

		return _brandLocalService.updateBrand(brand);
	}

	@Override
	public com.marketplace.brand.model.Brand updateStatus(
			long userId, long brandId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _brandLocalService.updateStatus(
			userId, brandId, status, serviceContext);
	}

	@Override
	public BrandLocalService getWrappedService() {
		return _brandLocalService;
	}

	@Override
	public void setWrappedService(BrandLocalService brandLocalService) {
		_brandLocalService = brandLocalService;
	}

	private BrandLocalService _brandLocalService;

}