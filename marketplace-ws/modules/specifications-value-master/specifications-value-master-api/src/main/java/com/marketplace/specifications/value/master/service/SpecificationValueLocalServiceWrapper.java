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

package com.marketplace.specifications.value.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecificationValueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValueLocalService
 * @generated
 */
public class SpecificationValueLocalServiceWrapper
	implements ServiceWrapper<SpecificationValueLocalService>,
			   SpecificationValueLocalService {

	public SpecificationValueLocalServiceWrapper() {
		this(null);
	}

	public SpecificationValueLocalServiceWrapper(
		SpecificationValueLocalService specificationValueLocalService) {

		_specificationValueLocalService = specificationValueLocalService;
	}

	/**
	 * Adds the specification value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specificationValue the specification value
	 * @return the specification value that was added
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		addSpecificationValue(
			com.marketplace.specifications.value.master.model.SpecificationValue
				specificationValue) {

		return _specificationValueLocalService.addSpecificationValue(
			specificationValue);
	}

	@Override
	public long countBySpecificationId(long specificationId) {
		return _specificationValueLocalService.countBySpecificationId(
			specificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new specification value with the primary key. Does not add the specification value to the database.
	 *
	 * @param specificationValueId the primary key for the new specification value
	 * @return the new specification value
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		createSpecificationValue(long specificationValueId) {

		return _specificationValueLocalService.createSpecificationValue(
			specificationValueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the specification value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value that was removed
	 * @throws PortalException if a specification value with the primary key could not be found
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
			deleteSpecificationValue(long specificationValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.deleteSpecificationValue(
			specificationValueId);
	}

	/**
	 * Deletes the specification value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specificationValue the specification value
	 * @return the specification value that was removed
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		deleteSpecificationValue(
			com.marketplace.specifications.value.master.model.SpecificationValue
				specificationValue) {

		return _specificationValueLocalService.deleteSpecificationValue(
			specificationValue);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _specificationValueLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _specificationValueLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specificationValueLocalService.dynamicQuery();
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

		return _specificationValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code>.
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

		return _specificationValueLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code>.
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

		return _specificationValueLocalService.dynamicQuery(
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

		return _specificationValueLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specificationValueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		fetchSpecificationValue(long specificationValueId) {

		return _specificationValueLocalService.fetchSpecificationValue(
			specificationValueId);
	}

	/**
	 * Returns the specification value matching the UUID and group.
	 *
	 * @param uuid the specification value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		fetchSpecificationValueByUuidAndGroupId(String uuid, long groupId) {

		return _specificationValueLocalService.
			fetchSpecificationValueByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.specifications.value.master.model.SpecificationValue>
			findByFBYSpecificationId(long specificationId) {

		return _specificationValueLocalService.findByFBYSpecificationId(
			specificationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specificationValueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _specificationValueLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specificationValueLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specificationValueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the specification value with the primary key.
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value
	 * @throws PortalException if a specification value with the primary key could not be found
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
			getSpecificationValue(long specificationValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.getSpecificationValue(
			specificationValueId);
	}

	/**
	 * Returns the specification value matching the UUID and group.
	 *
	 * @param uuid the specification value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification value
	 * @throws PortalException if a matching specification value could not be found
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
			getSpecificationValueByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationValueLocalService.
			getSpecificationValueByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the specification values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @return the range of specification values
	 */
	@Override
	public java.util.List
		<com.marketplace.specifications.value.master.model.SpecificationValue>
			getSpecificationValues(int start, int end) {

		return _specificationValueLocalService.getSpecificationValues(
			start, end);
	}

	/**
	 * Returns all the specification values matching the UUID and company.
	 *
	 * @param uuid the UUID of the specification values
	 * @param companyId the primary key of the company
	 * @return the matching specification values, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.specifications.value.master.model.SpecificationValue>
			getSpecificationValuesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _specificationValueLocalService.
			getSpecificationValuesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of specification values matching the UUID and company.
	 *
	 * @param uuid the UUID of the specification values
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of specification values
	 * @param end the upper bound of the range of specification values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching specification values, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.specifications.value.master.model.SpecificationValue>
			getSpecificationValuesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.specifications.value.master.model.
						SpecificationValue> orderByComparator) {

		return _specificationValueLocalService.
			getSpecificationValuesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of specification values.
	 *
	 * @return the number of specification values
	 */
	@Override
	public int getSpecificationValuesCount() {
		return _specificationValueLocalService.getSpecificationValuesCount();
	}

	/**
	 * Updates the specification value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specificationValue the specification value
	 * @return the specification value that was updated
	 */
	@Override
	public com.marketplace.specifications.value.master.model.SpecificationValue
		updateSpecificationValue(
			com.marketplace.specifications.value.master.model.SpecificationValue
				specificationValue) {

		return _specificationValueLocalService.updateSpecificationValue(
			specificationValue);
	}

	@Override
	public SpecificationValueLocalService getWrappedService() {
		return _specificationValueLocalService;
	}

	@Override
	public void setWrappedService(
		SpecificationValueLocalService specificationValueLocalService) {

		_specificationValueLocalService = specificationValueLocalService;
	}

	private SpecificationValueLocalService _specificationValueLocalService;

}