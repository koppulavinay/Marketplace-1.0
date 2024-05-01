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

package com.marketplace.brand.category.map.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrandCategoryMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrandCategoryMapLocalService
 * @generated
 */
public class BrandCategoryMapLocalServiceWrapper
	implements BrandCategoryMapLocalService,
			   ServiceWrapper<BrandCategoryMapLocalService> {

	public BrandCategoryMapLocalServiceWrapper() {
		this(null);
	}

	public BrandCategoryMapLocalServiceWrapper(
		BrandCategoryMapLocalService brandCategoryMapLocalService) {

		_brandCategoryMapLocalService = brandCategoryMapLocalService;
	}

	/**
	 * Adds the brand category map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandCategoryMap the brand category map
	 * @return the brand category map that was added
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
		addBrandCategoryMap(
			com.marketplace.brand.category.map.model.BrandCategoryMap
				brandCategoryMap) {

		return _brandCategoryMapLocalService.addBrandCategoryMap(
			brandCategoryMap);
	}

	/**
	 * Creates a new brand category map with the primary key. Does not add the brand category map to the database.
	 *
	 * @param brandCategoryMapId the primary key for the new brand category map
	 * @return the new brand category map
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
		createBrandCategoryMap(long brandCategoryMapId) {

		return _brandCategoryMapLocalService.createBrandCategoryMap(
			brandCategoryMapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandCategoryMapLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the brand category map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandCategoryMap the brand category map
	 * @return the brand category map that was removed
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
		deleteBrandCategoryMap(
			com.marketplace.brand.category.map.model.BrandCategoryMap
				brandCategoryMap) {

		return _brandCategoryMapLocalService.deleteBrandCategoryMap(
			brandCategoryMap);
	}

	/**
	 * Deletes the brand category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map that was removed
	 * @throws PortalException if a brand category map with the primary key could not be found
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
			deleteBrandCategoryMap(long brandCategoryMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandCategoryMapLocalService.deleteBrandCategoryMap(
			brandCategoryMapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandCategoryMapLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _brandCategoryMapLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _brandCategoryMapLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _brandCategoryMapLocalService.dynamicQuery();
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

		return _brandCategoryMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.category.map.model.impl.BrandCategoryMapModelImpl</code>.
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

		return _brandCategoryMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.category.map.model.impl.BrandCategoryMapModelImpl</code>.
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

		return _brandCategoryMapLocalService.dynamicQuery(
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

		return _brandCategoryMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _brandCategoryMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
		fetchBrandCategoryMap(long brandCategoryMapId) {

		return _brandCategoryMapLocalService.fetchBrandCategoryMap(
			brandCategoryMapId);
	}

	@Override
	public java.util.List
		<com.marketplace.brand.category.map.model.BrandCategoryMap>
			findByFBYBrandId(long brandId) {

		return _brandCategoryMapLocalService.findByFBYBrandId(brandId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _brandCategoryMapLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the brand category map with the primary key.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map
	 * @throws PortalException if a brand category map with the primary key could not be found
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
			getBrandCategoryMap(long brandCategoryMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandCategoryMapLocalService.getBrandCategoryMap(
			brandCategoryMapId);
	}

	/**
	 * Returns a range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.category.map.model.impl.BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of brand category maps
	 */
	@Override
	public java.util.List
		<com.marketplace.brand.category.map.model.BrandCategoryMap>
			getBrandCategoryMaps(int start, int end) {

		return _brandCategoryMapLocalService.getBrandCategoryMaps(start, end);
	}

	/**
	 * Returns the number of brand category maps.
	 *
	 * @return the number of brand category maps
	 */
	@Override
	public int getBrandCategoryMapsCount() {
		return _brandCategoryMapLocalService.getBrandCategoryMapsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _brandCategoryMapLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _brandCategoryMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _brandCategoryMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the brand category map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandCategoryMap the brand category map
	 * @return the brand category map that was updated
	 */
	@Override
	public com.marketplace.brand.category.map.model.BrandCategoryMap
		updateBrandCategoryMap(
			com.marketplace.brand.category.map.model.BrandCategoryMap
				brandCategoryMap) {

		return _brandCategoryMapLocalService.updateBrandCategoryMap(
			brandCategoryMap);
	}

	@Override
	public BrandCategoryMapLocalService getWrappedService() {
		return _brandCategoryMapLocalService;
	}

	@Override
	public void setWrappedService(
		BrandCategoryMapLocalService brandCategoryMapLocalService) {

		_brandCategoryMapLocalService = brandCategoryMapLocalService;
	}

	private BrandCategoryMapLocalService _brandCategoryMapLocalService;

}