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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specifications.value.master.model.SpecificationValue;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SpecificationValue. This utility wraps
 * <code>com.marketplace.specifications.value.master.service.impl.SpecificationValueLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValueLocalService
 * @generated
 */
public class SpecificationValueLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.specifications.value.master.service.impl.SpecificationValueLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static SpecificationValue addSpecificationValue(
		SpecificationValue specificationValue) {

		return getService().addSpecificationValue(specificationValue);
	}

	public static long countBySpecificationId(long specificationId) {
		return getService().countBySpecificationId(specificationId);
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
	 * Creates a new specification value with the primary key. Does not add the specification value to the database.
	 *
	 * @param specificationValueId the primary key for the new specification value
	 * @return the new specification value
	 */
	public static SpecificationValue createSpecificationValue(
		long specificationValueId) {

		return getService().createSpecificationValue(specificationValueId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SpecificationValue deleteSpecificationValue(
			long specificationValueId)
		throws PortalException {

		return getService().deleteSpecificationValue(specificationValueId);
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
	public static SpecificationValue deleteSpecificationValue(
		SpecificationValue specificationValue) {

		return getService().deleteSpecificationValue(specificationValue);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code>.
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

	public static SpecificationValue fetchSpecificationValue(
		long specificationValueId) {

		return getService().fetchSpecificationValue(specificationValueId);
	}

	/**
	 * Returns the specification value matching the UUID and group.
	 *
	 * @param uuid the specification value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification value, or <code>null</code> if a matching specification value could not be found
	 */
	public static SpecificationValue fetchSpecificationValueByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSpecificationValueByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<SpecificationValue> findByFBYSpecificationId(
		long specificationId) {

		return getService().findByFBYSpecificationId(specificationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the specification value with the primary key.
	 *
	 * @param specificationValueId the primary key of the specification value
	 * @return the specification value
	 * @throws PortalException if a specification value with the primary key could not be found
	 */
	public static SpecificationValue getSpecificationValue(
			long specificationValueId)
		throws PortalException {

		return getService().getSpecificationValue(specificationValueId);
	}

	/**
	 * Returns the specification value matching the UUID and group.
	 *
	 * @param uuid the specification value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching specification value
	 * @throws PortalException if a matching specification value could not be found
	 */
	public static SpecificationValue getSpecificationValueByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSpecificationValueByUuidAndGroupId(
			uuid, groupId);
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
	public static List<SpecificationValue> getSpecificationValues(
		int start, int end) {

		return getService().getSpecificationValues(start, end);
	}

	/**
	 * Returns all the specification values matching the UUID and company.
	 *
	 * @param uuid the UUID of the specification values
	 * @param companyId the primary key of the company
	 * @return the matching specification values, or an empty list if no matches were found
	 */
	public static List<SpecificationValue>
		getSpecificationValuesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getSpecificationValuesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<SpecificationValue>
		getSpecificationValuesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SpecificationValue> orderByComparator) {

		return getService().getSpecificationValuesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of specification values.
	 *
	 * @return the number of specification values
	 */
	public static int getSpecificationValuesCount() {
		return getService().getSpecificationValuesCount();
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
	public static SpecificationValue updateSpecificationValue(
		SpecificationValue specificationValue) {

		return getService().updateSpecificationValue(specificationValue);
	}

	public static SpecificationValueLocalService getService() {
		return _service;
	}

	private static volatile SpecificationValueLocalService _service;

}