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

package com.marketplace.specification.field.data.type.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecFieldDataTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldDataTypeLocalService
 * @generated
 */
public class SpecFieldDataTypeLocalServiceWrapper
	implements ServiceWrapper<SpecFieldDataTypeLocalService>,
			   SpecFieldDataTypeLocalService {

	public SpecFieldDataTypeLocalServiceWrapper() {
		this(null);
	}

	public SpecFieldDataTypeLocalServiceWrapper(
		SpecFieldDataTypeLocalService specFieldDataTypeLocalService) {

		_specFieldDataTypeLocalService = specFieldDataTypeLocalService;
	}

	/**
	 * Adds the spec field data type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldDataType the spec field data type
	 * @return the spec field data type that was added
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
		addSpecFieldDataType(
			com.marketplace.specification.field.data.type.model.
				SpecFieldDataType specFieldDataType) {

		return _specFieldDataTypeLocalService.addSpecFieldDataType(
			specFieldDataType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldDataTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new spec field data type with the primary key. Does not add the spec field data type to the database.
	 *
	 * @param specFieldDataTypeId the primary key for the new spec field data type
	 * @return the new spec field data type
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
		createSpecFieldDataType(long specFieldDataTypeId) {

		return _specFieldDataTypeLocalService.createSpecFieldDataType(
			specFieldDataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldDataTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the spec field data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type that was removed
	 * @throws PortalException if a spec field data type with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
			deleteSpecFieldDataType(long specFieldDataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldDataTypeLocalService.deleteSpecFieldDataType(
			specFieldDataTypeId);
	}

	/**
	 * Deletes the spec field data type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldDataType the spec field data type
	 * @return the spec field data type that was removed
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
		deleteSpecFieldDataType(
			com.marketplace.specification.field.data.type.model.
				SpecFieldDataType specFieldDataType) {

		return _specFieldDataTypeLocalService.deleteSpecFieldDataType(
			specFieldDataType);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _specFieldDataTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _specFieldDataTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specFieldDataTypeLocalService.dynamicQuery();
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

		return _specFieldDataTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.data.type.model.impl.SpecFieldDataTypeModelImpl</code>.
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

		return _specFieldDataTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.data.type.model.impl.SpecFieldDataTypeModelImpl</code>.
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

		return _specFieldDataTypeLocalService.dynamicQuery(
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

		return _specFieldDataTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specFieldDataTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
		fetchSpecFieldDataType(long specFieldDataTypeId) {

		return _specFieldDataTypeLocalService.fetchSpecFieldDataType(
			specFieldDataTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specFieldDataTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specFieldDataTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specFieldDataTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldDataTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the spec field data type with the primary key.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type
	 * @throws PortalException if a spec field data type with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
			getSpecFieldDataType(long specFieldDataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specFieldDataTypeLocalService.getSpecFieldDataType(
			specFieldDataTypeId);
	}

	/**
	 * Returns a range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.field.data.type.model.impl.SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of spec field data types
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.field.data.type.model.SpecFieldDataType>
			getSpecFieldDataTypes(int start, int end) {

		return _specFieldDataTypeLocalService.getSpecFieldDataTypes(start, end);
	}

	/**
	 * Returns the number of spec field data types.
	 *
	 * @return the number of spec field data types
	 */
	@Override
	public int getSpecFieldDataTypesCount() {
		return _specFieldDataTypeLocalService.getSpecFieldDataTypesCount();
	}

	/**
	 * Updates the spec field data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecFieldDataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specFieldDataType the spec field data type
	 * @return the spec field data type that was updated
	 */
	@Override
	public com.marketplace.specification.field.data.type.model.SpecFieldDataType
		updateSpecFieldDataType(
			com.marketplace.specification.field.data.type.model.
				SpecFieldDataType specFieldDataType) {

		return _specFieldDataTypeLocalService.updateSpecFieldDataType(
			specFieldDataType);
	}

	@Override
	public SpecFieldDataTypeLocalService getWrappedService() {
		return _specFieldDataTypeLocalService;
	}

	@Override
	public void setWrappedService(
		SpecFieldDataTypeLocalService specFieldDataTypeLocalService) {

		_specFieldDataTypeLocalService = specFieldDataTypeLocalService;
	}

	private SpecFieldDataTypeLocalService _specFieldDataTypeLocalService;

}