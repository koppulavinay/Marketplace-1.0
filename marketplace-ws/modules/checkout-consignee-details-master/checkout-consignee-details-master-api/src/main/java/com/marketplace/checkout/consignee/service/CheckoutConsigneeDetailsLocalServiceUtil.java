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

package com.marketplace.checkout.consignee.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CheckoutConsigneeDetails. This utility wraps
 * <code>com.marketplace.checkout.consignee.service.impl.CheckoutConsigneeDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetailsLocalService
 * @generated
 */
public class CheckoutConsigneeDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.checkout.consignee.service.impl.CheckoutConsigneeDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the checkout consignee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutConsigneeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 * @return the checkout consignee details that was added
	 */
	public static CheckoutConsigneeDetails addCheckoutConsigneeDetails(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return getService().addCheckoutConsigneeDetails(
			checkoutConsigneeDetails);
	}

	/**
	 * Creates a new checkout consignee details with the primary key. Does not add the checkout consignee details to the database.
	 *
	 * @param checkoutConsigneeId the primary key for the new checkout consignee details
	 * @return the new checkout consignee details
	 */
	public static CheckoutConsigneeDetails createCheckoutConsigneeDetails(
		long checkoutConsigneeId) {

		return getService().createCheckoutConsigneeDetails(checkoutConsigneeId);
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
	 * Deletes the checkout consignee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutConsigneeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 * @return the checkout consignee details that was removed
	 */
	public static CheckoutConsigneeDetails deleteCheckoutConsigneeDetails(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return getService().deleteCheckoutConsigneeDetails(
			checkoutConsigneeDetails);
	}

	/**
	 * Deletes the checkout consignee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutConsigneeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details that was removed
	 * @throws PortalException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails deleteCheckoutConsigneeDetails(
			long checkoutConsigneeId)
		throws PortalException {

		return getService().deleteCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	public static void deleteConsigneesForOrderItems(
		long parentCartId, long orderItemId) {

		getService().deleteConsigneesForOrderItems(parentCartId, orderItemId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.consignee.model.impl.CheckoutConsigneeDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.consignee.model.impl.CheckoutConsigneeDetailsModelImpl</code>.
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

	public static CheckoutConsigneeDetails fetchCheckoutConsigneeDetails(
		long checkoutConsigneeId) {

		return getService().fetchCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	/**
	 * Returns the checkout consignee details matching the UUID and group.
	 *
	 * @param uuid the checkout consignee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails
		fetchCheckoutConsigneeDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchCheckoutConsigneeDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId) {

		return getService().findByParentCartId(parentCartId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the checkout consignee details with the primary key.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws PortalException if a checkout consignee details with the primary key could not be found
	 */
	public static CheckoutConsigneeDetails getCheckoutConsigneeDetails(
			long checkoutConsigneeId)
		throws PortalException {

		return getService().getCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	public static List<CheckoutConsigneeDetails> getCheckoutConsigneeDetails(
		long parentCartId, long orderItemId) {

		return getService().getCheckoutConsigneeDetails(
			parentCartId, orderItemId);
	}

	/**
	 * Returns the checkout consignee details matching the UUID and group.
	 *
	 * @param uuid the checkout consignee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checkout consignee details
	 * @throws PortalException if a matching checkout consignee details could not be found
	 */
	public static CheckoutConsigneeDetails
			getCheckoutConsigneeDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getCheckoutConsigneeDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.consignee.model.impl.CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of checkout consignee detailses
	 */
	public static List<CheckoutConsigneeDetails> getCheckoutConsigneeDetailses(
		int start, int end) {

		return getService().getCheckoutConsigneeDetailses(start, end);
	}

	/**
	 * Returns all the checkout consignee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the checkout consignee detailses
	 * @param companyId the primary key of the company
	 * @return the matching checkout consignee detailses, or an empty list if no matches were found
	 */
	public static List<CheckoutConsigneeDetails>
		getCheckoutConsigneeDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getCheckoutConsigneeDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of checkout consignee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the checkout consignee detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching checkout consignee detailses, or an empty list if no matches were found
	 */
	public static List<CheckoutConsigneeDetails>
		getCheckoutConsigneeDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return getService().getCheckoutConsigneeDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checkout consignee detailses.
	 *
	 * @return the number of checkout consignee detailses
	 */
	public static int getCheckoutConsigneeDetailsesCount() {
		return getService().getCheckoutConsigneeDetailsesCount();
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
	 * Updates the checkout consignee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutConsigneeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 * @return the checkout consignee details that was updated
	 */
	public static CheckoutConsigneeDetails updateCheckoutConsigneeDetails(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		return getService().updateCheckoutConsigneeDetails(
			checkoutConsigneeDetails);
	}

	public static CheckoutConsigneeDetailsLocalService getService() {
		return _service;
	}

	private static volatile CheckoutConsigneeDetailsLocalService _service;

}