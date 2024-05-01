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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.marketplace.checkout.master.exception.NoSuchCheckoutCustomException;
import com.marketplace.checkout.master.model.CheckoutCustom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the checkout custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutCustomUtil
 * @generated
 */
@ProviderType
public interface CheckoutCustomPersistence
	extends BasePersistence<CheckoutCustom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CheckoutCustomUtil} to access the checkout custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the checkout custom in the entity cache if it is enabled.
	 *
	 * @param checkoutCustom the checkout custom
	 */
	public void cacheResult(CheckoutCustom checkoutCustom);

	/**
	 * Caches the checkout customs in the entity cache if it is enabled.
	 *
	 * @param checkoutCustoms the checkout customs
	 */
	public void cacheResult(java.util.List<CheckoutCustom> checkoutCustoms);

	/**
	 * Creates a new checkout custom with the primary key. Does not add the checkout custom to the database.
	 *
	 * @param checkoutCustomId the primary key for the new checkout custom
	 * @return the new checkout custom
	 */
	public CheckoutCustom create(long checkoutCustomId);

	/**
	 * Removes the checkout custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom that was removed
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	public CheckoutCustom remove(long checkoutCustomId)
		throws NoSuchCheckoutCustomException;

	public CheckoutCustom updateImpl(CheckoutCustom checkoutCustom);

	/**
	 * Returns the checkout custom with the primary key or throws a <code>NoSuchCheckoutCustomException</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	public CheckoutCustom findByPrimaryKey(long checkoutCustomId)
		throws NoSuchCheckoutCustomException;

	/**
	 * Returns the checkout custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom, or <code>null</code> if a checkout custom with the primary key could not be found
	 */
	public CheckoutCustom fetchByPrimaryKey(long checkoutCustomId);

	/**
	 * Returns all the checkout customs.
	 *
	 * @return the checkout customs
	 */
	public java.util.List<CheckoutCustom> findAll();

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
	public java.util.List<CheckoutCustom> findAll(int start, int end);

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
	public java.util.List<CheckoutCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckoutCustom>
			orderByComparator);

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
	public java.util.List<CheckoutCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CheckoutCustom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the checkout customs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of checkout customs.
	 *
	 * @return the number of checkout customs
	 */
	public int countAll();

}