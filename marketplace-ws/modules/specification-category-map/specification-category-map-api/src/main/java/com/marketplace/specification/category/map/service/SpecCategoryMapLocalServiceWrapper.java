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

package com.marketplace.specification.category.map.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecCategoryMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapLocalService
 * @generated
 */
public class SpecCategoryMapLocalServiceWrapper
	implements ServiceWrapper<SpecCategoryMapLocalService>,
			   SpecCategoryMapLocalService {

	public SpecCategoryMapLocalServiceWrapper() {
		this(null);
	}

	public SpecCategoryMapLocalServiceWrapper(
		SpecCategoryMapLocalService specCategoryMapLocalService) {

		_specCategoryMapLocalService = specCategoryMapLocalService;
	}

	/**
	 * Adds the spec category map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was added
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		addSpecCategoryMap(
			com.marketplace.specification.category.map.model.SpecCategoryMap
				specCategoryMap) {

		return _specCategoryMapLocalService.addSpecCategoryMap(specCategoryMap);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		createSpecCategoryMap(long specCategoryMapId) {

		return _specCategoryMapLocalService.createSpecCategoryMap(
			specCategoryMapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws PortalException if a spec category map with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
			deleteSpecCategoryMap(long specCategoryMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.deleteSpecCategoryMap(
			specCategoryMapId);
	}

	/**
	 * Deletes the spec category map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was removed
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		deleteSpecCategoryMap(
			com.marketplace.specification.category.map.model.SpecCategoryMap
				specCategoryMap) {

		return _specCategoryMapLocalService.deleteSpecCategoryMap(
			specCategoryMap);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _specCategoryMapLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _specCategoryMapLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specCategoryMapLocalService.dynamicQuery();
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

		return _specCategoryMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
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

		return _specCategoryMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
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

		return _specCategoryMapLocalService.dynamicQuery(
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

		return _specCategoryMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specCategoryMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		fetchSpecCategoryMap(long specCategoryMapId) {

		return _specCategoryMapLocalService.fetchSpecCategoryMap(
			specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		fetchSpecCategoryMapByUuidAndCompanyId(String uuid, long companyId) {

		return _specCategoryMapLocalService.
			fetchSpecCategoryMapByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List
		<com.marketplace.specification.category.map.model.SpecCategoryMap>
			findByCategoryId(long categoryId) {

		return _specCategoryMapLocalService.findByCategoryId(categoryId);
	}

	@Override
	public java.util.List
		<com.marketplace.specification.category.map.model.SpecCategoryMap>
			findByCategoryId(long categoryId, int start, int end) {

		return _specCategoryMapLocalService.findByCategoryId(
			categoryId, start, end);
	}

	@Override
	public java.util.List
		<com.marketplace.specification.category.map.model.SpecCategoryMap>
			findByFBYSpecificationId(long specificationId) {

		return _specCategoryMapLocalService.findByFBYSpecificationId(
			specificationId);
	}

	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
			findBySpecificationIdNCategoryId(
				long specificationId, long categoryId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return _specCategoryMapLocalService.findBySpecificationIdNCategoryId(
			specificationId, categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specCategoryMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _specCategoryMapLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specCategoryMapLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specCategoryMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the spec category map with the primary key.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws PortalException if a spec category map with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
			getSpecCategoryMap(long specCategoryMapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.getSpecCategoryMap(
			specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map
	 * @throws PortalException if a matching spec category map could not be found
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
			getSpecCategoryMapByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specCategoryMapLocalService.
			getSpecCategoryMapByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of spec category maps
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.category.map.model.SpecCategoryMap>
			getSpecCategoryMaps(int start, int end) {

		return _specCategoryMapLocalService.getSpecCategoryMaps(start, end);
	}

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	@Override
	public int getSpecCategoryMapsCount() {
		return _specCategoryMapLocalService.getSpecCategoryMapsCount();
	}

	/**
	 * Updates the spec category map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was updated
	 */
	@Override
	public com.marketplace.specification.category.map.model.SpecCategoryMap
		updateSpecCategoryMap(
			com.marketplace.specification.category.map.model.SpecCategoryMap
				specCategoryMap) {

		return _specCategoryMapLocalService.updateSpecCategoryMap(
			specCategoryMap);
	}

	@Override
	public SpecCategoryMapLocalService getWrappedService() {
		return _specCategoryMapLocalService;
	}

	@Override
	public void setWrappedService(
		SpecCategoryMapLocalService specCategoryMapLocalService) {

		_specCategoryMapLocalService = specCategoryMapLocalService;
	}

	private SpecCategoryMapLocalService _specCategoryMapLocalService;

}