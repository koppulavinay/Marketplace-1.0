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

package com.marketplace.checkout.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CheckoutCustomLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutCustomLocalService
 * @generated
 */
public class CheckoutCustomLocalServiceWrapper
	implements CheckoutCustomLocalService,
			   ServiceWrapper<CheckoutCustomLocalService> {

	public CheckoutCustomLocalServiceWrapper() {
		this(null);
	}

	public CheckoutCustomLocalServiceWrapper(
		CheckoutCustomLocalService checkoutCustomLocalService) {

		_checkoutCustomLocalService = checkoutCustomLocalService;
	}

	/**
	 * Adds the checkout custom to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutCustomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutCustom the checkout custom
	 * @return the checkout custom that was added
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
		addCheckoutCustom(
			com.marketplace.checkout.master.model.CheckoutCustom
				checkoutCustom) {

		return _checkoutCustomLocalService.addCheckoutCustom(checkoutCustom);
	}

	/**
	 * Creates a new checkout custom with the primary key. Does not add the checkout custom to the database.
	 *
	 * @param checkoutCustomId the primary key for the new checkout custom
	 * @return the new checkout custom
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
		createCheckoutCustom(long checkoutCustomId) {

		return _checkoutCustomLocalService.createCheckoutCustom(
			checkoutCustomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutCustomLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the checkout custom from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutCustomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutCustom the checkout custom
	 * @return the checkout custom that was removed
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
		deleteCheckoutCustom(
			com.marketplace.checkout.master.model.CheckoutCustom
				checkoutCustom) {

		return _checkoutCustomLocalService.deleteCheckoutCustom(checkoutCustom);
	}

	/**
	 * Deletes the checkout custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutCustomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom that was removed
	 * @throws PortalException if a checkout custom with the primary key could not be found
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
			deleteCheckoutCustom(long checkoutCustomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutCustomLocalService.deleteCheckoutCustom(
			checkoutCustomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutCustomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checkoutCustomLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checkoutCustomLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checkoutCustomLocalService.dynamicQuery();
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

		return _checkoutCustomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.master.model.impl.CheckoutCustomModelImpl</code>.
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

		return _checkoutCustomLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.master.model.impl.CheckoutCustomModelImpl</code>.
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

		return _checkoutCustomLocalService.dynamicQuery(
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

		return _checkoutCustomLocalService.dynamicQueryCount(dynamicQuery);
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

		return _checkoutCustomLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
		fetchCheckoutCustom(long checkoutCustomId) {

		return _checkoutCustomLocalService.fetchCheckoutCustom(
			checkoutCustomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checkoutCustomLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the checkout custom with the primary key.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom
	 * @throws PortalException if a checkout custom with the primary key could not be found
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
			getCheckoutCustom(long checkoutCustomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutCustomLocalService.getCheckoutCustom(checkoutCustomId);
	}

	/**
	 * Returns a range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.checkout.master.model.impl.CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @return the range of checkout customs
	 */
	@Override
	public java.util.List<com.marketplace.checkout.master.model.CheckoutCustom>
		getCheckoutCustoms(int start, int end) {

		return _checkoutCustomLocalService.getCheckoutCustoms(start, end);
	}

	/**
	 * Returns the number of checkout customs.
	 *
	 * @return the number of checkout customs
	 */
	@Override
	public int getCheckoutCustomsCount() {
		return _checkoutCustomLocalService.getCheckoutCustomsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checkoutCustomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkoutCustomLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkoutCustomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the checkout custom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CheckoutCustomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkoutCustom the checkout custom
	 * @return the checkout custom that was updated
	 */
	@Override
	public com.marketplace.checkout.master.model.CheckoutCustom
		updateCheckoutCustom(
			com.marketplace.checkout.master.model.CheckoutCustom
				checkoutCustom) {

		return _checkoutCustomLocalService.updateCheckoutCustom(checkoutCustom);
	}

	@Override
	public CheckoutCustomLocalService getWrappedService() {
		return _checkoutCustomLocalService;
	}

	@Override
	public void setWrappedService(
		CheckoutCustomLocalService checkoutCustomLocalService) {

		_checkoutCustomLocalService = checkoutCustomLocalService;
	}

	private CheckoutCustomLocalService _checkoutCustomLocalService;

}