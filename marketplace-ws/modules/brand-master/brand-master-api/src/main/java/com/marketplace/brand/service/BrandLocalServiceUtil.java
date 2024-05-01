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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.brand.model.Brand;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Brand. This utility wraps
 * <code>com.marketplace.brand.service.impl.BrandLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BrandLocalService
 * @generated
 */
public class BrandLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.brand.service.impl.BrandLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Brand addBrand(Brand brand) {
		return getService().addBrand(brand);
	}

	public static Brand addBrand(
			Brand brand, com.liferay.portal.kernel.model.User user,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addBrand(brand, user, serviceContext);
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	public static Brand createBrand(long brandId) {
		return getService().createBrand(brandId);
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
	 * Deletes the brand from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was removed
	 */
	public static Brand deleteBrand(Brand brand) {
		return getService().deleteBrand(brand);
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
	public static Brand deleteBrand(long brandId) throws PortalException {
		return getService().deleteBrand(brandId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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

	public static Brand fetchBrand(long brandId) {
		return getService().fetchBrand(brandId);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	public static Brand fetchBrandByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchBrandByUuidAndGroupId(uuid, groupId);
	}

	public static Brand findByFBYAssetCategoryId(long assetCategoryId) {
		return getService().findByFBYAssetCategoryId(assetCategoryId);
	}

	public static List<Brand> findByFBYCreatedBy(long createdBy) {
		return getService().findByFBYCreatedBy(createdBy);
	}

	public static List<Brand> findByFBYCreatedBys(
		long createdBy, int start, int end) {

		return getService().findByFBYCreatedBys(createdBy, start, end);
	}

	public static List<Brand> findByFBYStatus(String brandApprovalStatus) {
		return getService().findByFBYStatus(brandApprovalStatus);
	}

	public static List<Brand> findByFBYStatuses(
		String brandApprovalStatus, int start, int end) {

		return getService().findByFBYStatuses(brandApprovalStatus, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the brand with the primary key.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws PortalException if a brand with the primary key could not be found
	 */
	public static Brand getBrand(long brandId) throws PortalException {
		return getService().getBrand(brandId);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand
	 * @throws PortalException if a matching brand could not be found
	 */
	public static Brand getBrandByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getBrandByUuidAndGroupId(uuid, groupId);
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
	public static List<Brand> getBrands(int start, int end) {
		return getService().getBrands(start, end);
	}

	/**
	 * Returns all the brands matching the UUID and company.
	 *
	 * @param uuid the UUID of the brands
	 * @param companyId the primary key of the company
	 * @return the matching brands, or an empty list if no matches were found
	 */
	public static List<Brand> getBrandsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBrandsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Brand> getBrandsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return getService().getBrandsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	public static int getBrandsCount() {
		return getService().getBrandsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the brand in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was updated
	 */
	public static Brand updateBrand(Brand brand) {
		return getService().updateBrand(brand);
	}

	public static Brand updateStatus(
			long userId, long brandId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, brandId, status, serviceContext);
	}

	public static BrandLocalService getService() {
		return _service;
	}

	private static volatile BrandLocalService _service;

}