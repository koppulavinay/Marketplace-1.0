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

package com.marketplace.specification.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationLocalService
 * @generated
 */
public class SpecificationLocalServiceWrapper
	implements ServiceWrapper<SpecificationLocalService>,
			   SpecificationLocalService {

	public SpecificationLocalServiceWrapper() {
		this(null);
	}

	public SpecificationLocalServiceWrapper(
		SpecificationLocalService specificationLocalService) {

		_specificationLocalService = specificationLocalService;
	}

	/**
	 * Adds the specification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specification the specification
	 * @return the specification that was added
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
		addSpecification(
			com.marketplace.specification.master.model.Specification
				specification) {

		return _specificationLocalService.addSpecification(specification);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new specification with the primary key. Does not add the specification to the database.
	 *
	 * @param specificationId the primary key for the new specification
	 * @return the new specification
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
		createSpecification(long specificationId) {

		return _specificationLocalService.createSpecification(specificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification that was removed
	 * @throws PortalException if a specification with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
			deleteSpecification(long specificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.deleteSpecification(specificationId);
	}

	/**
	 * Deletes the specification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specification the specification
	 * @return the specification that was removed
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
		deleteSpecification(
			com.marketplace.specification.master.model.Specification
				specification) {

		return _specificationLocalService.deleteSpecification(specification);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _specificationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _specificationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specificationLocalService.dynamicQuery();
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

		return _specificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.master.model.impl.SpecificationModelImpl</code>.
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

		return _specificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.master.model.impl.SpecificationModelImpl</code>.
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

		return _specificationLocalService.dynamicQuery(
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

		return _specificationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _specificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.specification.master.model.Specification
		fetchSpecification(long specificationId) {

		return _specificationLocalService.fetchSpecification(specificationId);
	}

	/**
	 * Returns the specification matching the UUID and group.
	 *
	 * @param uuid the specification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
		fetchSpecificationByUuidAndGroupId(String uuid, long groupId) {

		return _specificationLocalService.fetchSpecificationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.specification.master.model.Specification>
			findBySpecificationStatus(String specificationStatus) {

		return _specificationLocalService.findBySpecificationStatus(
			specificationStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _specificationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specificationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the specification with the primary key.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification
	 * @throws PortalException if a specification with the primary key could not be found
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
			getSpecification(long specificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.getSpecification(specificationId);
	}

	/**
	 * Returns the specification matching the UUID and group.
	 *
	 * @param uuid the specification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification
	 * @throws PortalException if a matching specification could not be found
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
			getSpecificationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specificationLocalService.getSpecificationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.master.model.impl.SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of specifications
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.master.model.Specification>
			getSpecifications(int start, int end) {

		return _specificationLocalService.getSpecifications(start, end);
	}

	/**
	 * Returns all the specifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the specifications
	 * @param companyId the primary key of the company
	 * @return the matching specifications, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.master.model.Specification>
			getSpecificationsByUuidAndCompanyId(String uuid, long companyId) {

		return _specificationLocalService.getSpecificationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of specifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the specifications
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching specifications, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.specification.master.model.Specification>
			getSpecificationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.specification.master.model.Specification>
						orderByComparator) {

		return _specificationLocalService.getSpecificationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of specifications.
	 *
	 * @return the number of specifications
	 */
	@Override
	public int getSpecificationsCount() {
		return _specificationLocalService.getSpecificationsCount();
	}

	/**
	 * Updates the specification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specification the specification
	 * @return the specification that was updated
	 */
	@Override
	public com.marketplace.specification.master.model.Specification
		updateSpecification(
			com.marketplace.specification.master.model.Specification
				specification) {

		return _specificationLocalService.updateSpecification(specification);
	}

	@Override
	public SpecificationLocalService getWrappedService() {
		return _specificationLocalService;
	}

	@Override
	public void setWrappedService(
		SpecificationLocalService specificationLocalService) {

		_specificationLocalService = specificationLocalService;
	}

	private SpecificationLocalService _specificationLocalService;

}