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

package com.marketplace.checkout.consignee.service.impl;

import com.liferay.portal.aop.AopService;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;
import com.marketplace.checkout.consignee.service.base.CheckoutConsigneeDetailsLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails", service = AopService.class)
public class CheckoutConsigneeDetailsLocalServiceImpl extends CheckoutConsigneeDetailsLocalServiceBaseImpl {

	public List<CheckoutConsigneeDetails> getCheckoutConsigneeDetails(long parentCartId, long orderItemId) {

		return checkoutConsigneeDetailsPersistence.findByCartIdNOrderItemId(parentCartId, orderItemId);
	}

	public List<CheckoutConsigneeDetails> findByParentCartId(long parentCartId) {

		return checkoutConsigneeDetailsPersistence.findByParentCartId(parentCartId);
	}

	public void deleteConsigneesForOrderItems(long parentCartId, long orderItemId) {

		List<CheckoutConsigneeDetails> consigneeDetailsList = getCheckoutConsigneeDetails(parentCartId, orderItemId);

		if (consigneeDetailsList.isEmpty())
			return;

		consigneeDetailsList.stream().forEach(consignee -> {
			checkoutConsigneeDetailsLocalService.deleteCheckoutConsigneeDetails(consignee);
		});

	}

}