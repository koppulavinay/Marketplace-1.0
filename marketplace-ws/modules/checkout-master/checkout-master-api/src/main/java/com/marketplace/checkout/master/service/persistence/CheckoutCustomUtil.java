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

package com.marketplace.checkout.master.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.checkout.master.model.CheckoutCustom;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the checkout custom service. This utility wraps <code>com.marketplace.checkout.master.service.persistence.impl.CheckoutCustomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutCustomPersistence
 * @generated
 */
public class CheckoutCustomUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CheckoutCustom checkoutCustom) {
		getPersistence().clearCache(checkoutCustom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CheckoutCustom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CheckoutCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CheckoutCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CheckoutCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CheckoutCustom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CheckoutCustom update(CheckoutCustom checkoutCustom) {
		return getPersistence().update(checkoutCustom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CheckoutCustom update(
		CheckoutCustom checkoutCustom, ServiceContext serviceContext) {

		return getPersistence().update(checkoutCustom, serviceContext);
	}

	/**
	 * Caches the checkout custom in the entity cache if it is enabled.
	 *
	 * @param checkoutCustom the checkout custom
	 */
	public static void cacheResult(CheckoutCustom checkoutCustom) {
		getPersistence().cacheResult(checkoutCustom);
	}

	/**
	 * Caches the checkout customs in the entity cache if it is enabled.
	 *
	 * @param checkoutCustoms the checkout customs
	 */
	public static void cacheResult(List<CheckoutCustom> checkoutCustoms) {
		getPersistence().cacheResult(checkoutCustoms);
	}

	/**
	 * Creates a new checkout custom with the primary key. Does not add the checkout custom to the database.
	 *
	 * @param checkoutCustomId the primary key for the new checkout custom
	 * @return the new checkout custom
	 */
	public static CheckoutCustom create(long checkoutCustomId) {
		return getPersistence().create(checkoutCustomId);
	}

	/**
	 * Removes the checkout custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom that was removed
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	public static CheckoutCustom remove(long checkoutCustomId)
		throws com.marketplace.checkout.master.exception.
			NoSuchCheckoutCustomException {

		return getPersistence().remove(checkoutCustomId);
	}

	public static CheckoutCustom updateImpl(CheckoutCustom checkoutCustom) {
		return getPersistence().updateImpl(checkoutCustom);
	}

	/**
	 * Returns the checkout custom with the primary key or throws a <code>NoSuchCheckoutCustomException</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	public static CheckoutCustom findByPrimaryKey(long checkoutCustomId)
		throws com.marketplace.checkout.master.exception.
			NoSuchCheckoutCustomException {

		return getPersistence().findByPrimaryKey(checkoutCustomId);
	}

	/**
	 * Returns the checkout custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom, or <code>null</code> if a checkout custom with the primary key could not be found
	 */
	public static CheckoutCustom fetchByPrimaryKey(long checkoutCustomId) {
		return getPersistence().fetchByPrimaryKey(checkoutCustomId);
	}

	/**
	 * Returns all the checkout customs.
	 *
	 * @return the checkout customs
	 */
	public static List<CheckoutCustom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @return the range of checkout customs
	 */
	public static List<CheckoutCustom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checkout customs
	 */
	public static List<CheckoutCustom> findAll(
		int start, int end,
		OrderByComparator<CheckoutCustom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checkout customs
	 */
	public static List<CheckoutCustom> findAll(
		int start, int end, OrderByComparator<CheckoutCustom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the checkout customs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of checkout customs.
	 *
	 * @return the number of checkout customs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CheckoutCustomPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CheckoutCustomPersistence _persistence;

}