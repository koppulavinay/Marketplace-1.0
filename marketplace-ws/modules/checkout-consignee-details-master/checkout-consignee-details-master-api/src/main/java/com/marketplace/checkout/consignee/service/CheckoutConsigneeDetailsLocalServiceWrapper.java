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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CheckoutConsigneeDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetailsLocalService
 * @generated
 */
public class CheckoutConsigneeDetailsLocalServiceWrapper
	implements CheckoutConsigneeDetailsLocalService,
			   ServiceWrapper<CheckoutConsigneeDetailsLocalService> {

	public CheckoutConsigneeDetailsLocalServiceWrapper() {
		this(null);
	}

	public CheckoutConsigneeDetailsLocalServiceWrapper(
		CheckoutConsigneeDetailsLocalService
			checkoutConsigneeDetailsLocalService) {

		_checkoutConsigneeDetailsLocalService =
			checkoutConsigneeDetailsLocalService;
	}

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
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		addCheckoutConsigneeDetails(
			com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
				checkoutConsigneeDetails) {

		return _checkoutConsigneeDetailsLocalService.
			addCheckoutConsigneeDetails(checkoutConsigneeDetails);
	}

	/**
	 * Creates a new checkout consignee details with the primary key. Does not add the checkout consignee details to the database.
	 *
	 * @param checkoutConsigneeId the primary key for the new checkout consignee details
	 * @return the new checkout consignee details
	 */
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		createCheckoutConsigneeDetails(long checkoutConsigneeId) {

		return _checkoutConsigneeDetailsLocalService.
			createCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		deleteCheckoutConsigneeDetails(
			com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
				checkoutConsigneeDetails) {

		return _checkoutConsigneeDetailsLocalService.
			deleteCheckoutConsigneeDetails(checkoutConsigneeDetails);
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
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
			deleteCheckoutConsigneeDetails(long checkoutConsigneeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.
			deleteCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	@Override
	public void deleteConsigneesForOrderItems(
		long parentCartId, long orderItemId) {

		_checkoutConsigneeDetailsLocalService.deleteConsigneesForOrderItems(
			parentCartId, orderItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checkoutConsigneeDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checkoutConsigneeDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checkoutConsigneeDetailsLocalService.dynamicQuery();
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

		return _checkoutConsigneeDetailsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _checkoutConsigneeDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _checkoutConsigneeDetailsLocalService.dynamicQuery(
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

		return _checkoutConsigneeDetailsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _checkoutConsigneeDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		fetchCheckoutConsigneeDetails(long checkoutConsigneeId) {

		return _checkoutConsigneeDetailsLocalService.
			fetchCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	/**
	 * Returns the checkout consignee details matching the UUID and group.
	 *
	 * @param uuid the checkout consignee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		fetchCheckoutConsigneeDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _checkoutConsigneeDetailsLocalService.
			fetchCheckoutConsigneeDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails>
			findByParentCartId(long parentCartId) {

		return _checkoutConsigneeDetailsLocalService.findByParentCartId(
			parentCartId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checkoutConsigneeDetailsLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the checkout consignee details with the primary key.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws PortalException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
			getCheckoutConsigneeDetails(long checkoutConsigneeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetails(checkoutConsigneeId);
	}

	@Override
	public java.util.List
		<com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails>
			getCheckoutConsigneeDetails(long parentCartId, long orderItemId) {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetails(parentCartId, orderItemId);
	}

	/**
	 * Returns the checkout consignee details matching the UUID and group.
	 *
	 * @param uuid the checkout consignee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checkout consignee details
	 * @throws PortalException if a matching checkout consignee details could not be found
	 */
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
			getCheckoutConsigneeDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetailsByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List
		<com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails>
			getCheckoutConsigneeDetailses(int start, int end) {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetailses(start, end);
	}

	/**
	 * Returns all the checkout consignee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the checkout consignee detailses
	 * @param companyId the primary key of the company
	 * @return the matching checkout consignee detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails>
			getCheckoutConsigneeDetailsesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetailsesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails>
			getCheckoutConsigneeDetailsesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.checkout.consignee.model.
						CheckoutConsigneeDetails> orderByComparator) {

		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checkout consignee detailses.
	 *
	 * @return the number of checkout consignee detailses
	 */
	@Override
	public int getCheckoutConsigneeDetailsesCount() {
		return _checkoutConsigneeDetailsLocalService.
			getCheckoutConsigneeDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _checkoutConsigneeDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checkoutConsigneeDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkoutConsigneeDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutConsigneeDetailsLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
		updateCheckoutConsigneeDetails(
			com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails
				checkoutConsigneeDetails) {

		return _checkoutConsigneeDetailsLocalService.
			updateCheckoutConsigneeDetails(checkoutConsigneeDetails);
	}

	@Override
	public CheckoutConsigneeDetailsLocalService getWrappedService() {
		return _checkoutConsigneeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		CheckoutConsigneeDetailsLocalService
			checkoutConsigneeDetailsLocalService) {

		_checkoutConsigneeDetailsLocalService =
			checkoutConsigneeDetailsLocalService;
	}

	private CheckoutConsigneeDetailsLocalService
		_checkoutConsigneeDetailsLocalService;

}