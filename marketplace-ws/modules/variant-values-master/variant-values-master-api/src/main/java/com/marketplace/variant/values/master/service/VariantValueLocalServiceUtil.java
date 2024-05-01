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

package com.marketplace.variant.values.master.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.variant.values.master.model.VariantValue;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for VariantValue. This utility wraps
 * <code>com.marketplace.variant.values.master.service.impl.VariantValueLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VariantValueLocalService
 * @generated
 */
public class VariantValueLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.variant.values.master.service.impl.VariantValueLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the variant value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was added
	 */
	public static VariantValue addVariantValue(VariantValue variantValue) {
		return getService().addVariantValue(variantValue);
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
	 * Creates a new variant value with the primary key. Does not add the variant value to the database.
	 *
	 * @param variantValueId the primary key for the new variant value
	 * @return the new variant value
	 */
	public static VariantValue createVariantValue(long variantValueId) {
		return getService().createVariantValue(variantValueId);
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
	 * Deletes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws PortalException if a variant value with the primary key could not be found
	 */
	public static VariantValue deleteVariantValue(long variantValueId)
		throws PortalException {

		return getService().deleteVariantValue(variantValueId);
	}

	/**
	 * Deletes the variant value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was removed
	 */
	public static VariantValue deleteVariantValue(VariantValue variantValue) {
		return getService().deleteVariantValue(variantValue);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
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

	public static VariantValue fetchVariantValue(long variantValueId) {
		return getService().fetchVariantValue(variantValueId);
	}

	/**
	 * Returns the variant value matching the UUID and group.
	 *
	 * @param uuid the variant value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	public static VariantValue fetchVariantValueByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchVariantValueByUuidAndGroupId(uuid, groupId);
	}

	public static List<VariantValue> findByProductVariantId(
		long productVariantId) {

		return getService().findByProductVariantId(productVariantId);
	}

	public static List<VariantValue> findByValueAndId(
		long draftProductId, String variantVal) {

		return getService().findByValueAndId(draftProductId, variantVal);
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
	 * Returns the variant value with the primary key.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value
	 * @throws PortalException if a variant value with the primary key could not be found
	 */
	public static VariantValue getVariantValue(long variantValueId)
		throws PortalException {

		return getService().getVariantValue(variantValueId);
	}

	/**
	 * Returns the variant value matching the UUID and group.
	 *
	 * @param uuid the variant value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching variant value
	 * @throws PortalException if a matching variant value could not be found
	 */
	public static VariantValue getVariantValueByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getVariantValueByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of variant values
	 */
	public static List<VariantValue> getVariantValues(int start, int end) {
		return getService().getVariantValues(start, end);
	}

	/**
	 * Returns all the variant values matching the UUID and company.
	 *
	 * @param uuid the UUID of the variant values
	 * @param companyId the primary key of the company
	 * @return the matching variant values, or an empty list if no matches were found
	 */
	public static List<VariantValue> getVariantValuesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getVariantValuesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of variant values matching the UUID and company.
	 *
	 * @param uuid the UUID of the variant values
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching variant values, or an empty list if no matches were found
	 */
	public static List<VariantValue> getVariantValuesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return getService().getVariantValuesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of variant values.
	 *
	 * @return the number of variant values
	 */
	public static int getVariantValuesCount() {
		return getService().getVariantValuesCount();
	}

	/**
	 * Updates the variant value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was updated
	 */
	public static VariantValue updateVariantValue(VariantValue variantValue) {
		return getService().updateVariantValue(variantValue);
	}

	public static VariantValueLocalService getService() {
		return _service;
	}

	private static volatile VariantValueLocalService _service;

}