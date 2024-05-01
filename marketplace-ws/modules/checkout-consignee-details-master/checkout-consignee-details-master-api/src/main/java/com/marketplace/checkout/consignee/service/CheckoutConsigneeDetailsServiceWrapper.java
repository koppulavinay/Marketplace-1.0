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
 * Provides a wrapper for {@link CheckoutConsigneeDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetailsService
 * @generated
 */
public class CheckoutConsigneeDetailsServiceWrapper
	implements CheckoutConsigneeDetailsService,
			   ServiceWrapper<CheckoutConsigneeDetailsService> {

	public CheckoutConsigneeDetailsServiceWrapper() {
		this(null);
	}

	public CheckoutConsigneeDetailsServiceWrapper(
		CheckoutConsigneeDetailsService checkoutConsigneeDetailsService) {

		_checkoutConsigneeDetailsService = checkoutConsigneeDetailsService;
	}

	@Override
	public void deleteConsigneesForOrderItems(
		long parentCartId, long orderItemId) {

		_checkoutConsigneeDetailsService.deleteConsigneesForOrderItems(
			parentCartId, orderItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkoutConsigneeDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public CheckoutConsigneeDetailsService getWrappedService() {
		return _checkoutConsigneeDetailsService;
	}

	@Override
	public void setWrappedService(
		CheckoutConsigneeDetailsService checkoutConsigneeDetailsService) {

		_checkoutConsigneeDetailsService = checkoutConsigneeDetailsService;
	}

	private CheckoutConsigneeDetailsService _checkoutConsigneeDetailsService;

}