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

package com.marketplace.specification.field.type.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecFieldTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldTypeLocalService
 * @generated
 */
public class SpecFieldTypeLocalServiceWrapper
	implements ServiceWrapper<SpecFieldTypeLocalService>,
			   SpecFieldTypeLocalService {

	public SpecFieldTypeLocalServiceWrapper() {
		this(null);
	}

	public SpecFieldTypeLocalServiceWrapper(
		SpecFieldTypeLocalService specFieldTypeLocalService) {

		_specFieldTypeLocalService = specFieldTypeLocalService;
	}

	/**
	 * Adds the spec field type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldType the spec field type
	 * @return the spec field type that was added
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
		addSpecFieldType(
			com.marketplace.specification.field.type.model.SpecFieldType
				specFieldType) {

		return _specFieldTypeLocalService.addSpecFieldType(specFieldType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new spec field type with the primary key. Does not add the spec field type to the database.
	 *
	 * @param specFieldTypeId the primary key for the new spec field type
	 * @return the new spec field type
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
		createSpecFieldType(long specFieldTypeId) {

		return _specFieldTypeLocalService.createSpecFieldType(specFieldTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the spec field type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type that was removed
	 * @throws PortalException if a spec field type with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
			deleteSpecFieldType(long specFieldTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldTypeLocalService.deleteSpecFieldType(specFieldTypeId);
	}

	/**
	 * Deletes the spec field type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldType the spec field type
	 * @return the spec field type that was removed
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
		deleteSpecFieldType(
			com.marketplace.specification.field.type.model.SpecFieldType
				specFieldType) {

		return _specFieldTypeLocalService.deleteSpecFieldType(specFieldType);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _specFieldTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _specFieldTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specFieldTypeLocalService.dynamicQuery();
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

		return _specFieldTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.type.model.impl.SpecFieldTypeModelImpl</code>.
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

		return _specFieldTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.type.model.impl.SpecFieldTypeModelImpl</code>.
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

		return _specFieldTypeLocalService.dynamicQuery(
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

		return _specFieldTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specFieldTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
		fetchSpecFieldType(long specFieldTypeId) {

		return _specFieldTypeLocalService.fetchSpecFieldType(specFieldTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specFieldTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specFieldTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specFieldTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the spec field type with the primary key.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type
	 * @throws PortalException if a spec field type with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
			getSpecFieldType(long specFieldTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldTypeLocalService.getSpecFieldType(specFieldTypeId);
	}

	/**
	 * Returns a range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.type.model.impl.SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of spec field types
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.field.type.model.SpecFieldType>
			getSpecFieldTypes(int start, int end) {

		return _specFieldTypeLocalService.getSpecFieldTypes(start, end);
	}

	/**
	 * Returns the number of spec field types.
	 *
	 * @return the number of spec field types
	 */
	@Override
	public int getSpecFieldTypesCount() {
		return _specFieldTypeLocalService.getSpecFieldTypesCount();
	}

	/**
	 * Updates the spec field type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldType the spec field type
	 * @return the spec field type that was updated
	 */
	@Override
	public com.marketplace.specification.field.type.model.SpecFieldType
		updateSpecFieldType(
			com.marketplace.specification.field.type.model.SpecFieldType
				specFieldType) {

		return _specFieldTypeLocalService.updateSpecFieldType(specFieldType);
	}

	@Override
	public SpecFieldTypeLocalService getWrappedService() {
		return _specFieldTypeLocalService;
	}

	@Override
	public void setWrappedService(
		SpecFieldTypeLocalService specFieldTypeLocalService) {

		_specFieldTypeLocalService = specFieldTypeLocalService;
	}

	private SpecFieldTypeLocalService _specFieldTypeLocalService;

}