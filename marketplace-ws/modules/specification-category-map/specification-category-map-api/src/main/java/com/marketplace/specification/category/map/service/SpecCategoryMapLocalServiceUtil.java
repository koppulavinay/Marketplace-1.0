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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.category.map.model.SpecCategoryMap;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SpecCategoryMap. This utility wraps
 * <code>com.marketplace.specification.category.map.service.impl.SpecCategoryMapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapLocalService
 * @generated
 */
public class SpecCategoryMapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.specification.category.map.service.impl.SpecCategoryMapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static SpecCategoryMap addSpecCategoryMap(
		SpecCategoryMap specCategoryMap) {

		return getService().addSpecCategoryMap(specCategoryMap);
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
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	public static SpecCategoryMap createSpecCategoryMap(
		long specCategoryMapId) {

		return getService().createSpecCategoryMap(specCategoryMapId);
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
	public static SpecCategoryMap deleteSpecCategoryMap(long specCategoryMapId)
		throws PortalException {

		return getService().deleteSpecCategoryMap(specCategoryMapId);
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
	public static SpecCategoryMap deleteSpecCategoryMap(
		SpecCategoryMap specCategoryMap) {

		return getService().deleteSpecCategoryMap(specCategoryMap);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
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

	public static SpecCategoryMap fetchSpecCategoryMap(long specCategoryMapId) {
		return getService().fetchSpecCategoryMap(specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	public static SpecCategoryMap fetchSpecCategoryMapByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchSpecCategoryMapByUuidAndCompanyId(
			uuid, companyId);
	}

	public static List<SpecCategoryMap> findByCategoryId(long categoryId) {
		return getService().findByCategoryId(categoryId);
	}

	public static List<SpecCategoryMap> findByCategoryId(
		long categoryId, int start, int end) {

		return getService().findByCategoryId(categoryId, start, end);
	}

	public static List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId) {

		return getService().findByFBYSpecificationId(specificationId);
	}

	public static SpecCategoryMap findBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws com.marketplace.specification.category.map.exception.
			NoSuchSpecCategoryMapException {

		return getService().findBySpecificationIdNCategoryId(
			specificationId, categoryId);
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
	 * Returns the spec category map with the primary key.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws PortalException if a spec category map with the primary key could not be found
	 */
	public static SpecCategoryMap getSpecCategoryMap(long specCategoryMapId)
		throws PortalException {

		return getService().getSpecCategoryMap(specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map
	 * @throws PortalException if a matching spec category map could not be found
	 */
	public static SpecCategoryMap getSpecCategoryMapByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getSpecCategoryMapByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<SpecCategoryMap> getSpecCategoryMaps(
		int start, int end) {

		return getService().getSpecCategoryMaps(start, end);
	}

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	public static int getSpecCategoryMapsCount() {
		return getService().getSpecCategoryMapsCount();
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
	public static SpecCategoryMap updateSpecCategoryMap(
		SpecCategoryMap specCategoryMap) {

		return getService().updateSpecCategoryMap(specCategoryMap);
	}

	public static SpecCategoryMapLocalService getService() {
		return _service;
	}

	private static volatile SpecCategoryMapLocalService _service;

}