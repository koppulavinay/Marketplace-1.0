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

package com.marketplace.checkout.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CheckoutCustom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutCustom
 * @generated
 */
public class CheckoutCustomWrapper
	extends BaseModelWrapper<CheckoutCustom>
	implements CheckoutCustom, ModelWrapper<CheckoutCustom> {

	public CheckoutCustomWrapper(CheckoutCustom checkoutCustom) {
		super(checkoutCustom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("checkoutCustomId", getCheckoutCustomId());
		attributes.put("commerceOrderId", getCommerceOrderId());
		attributes.put("requestJson", getRequestJson());
		attributes.put("responseJson", getResponseJson());
		attributes.put("module", getModule());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long checkoutCustomId = (Long)attributes.get("checkoutCustomId");

		if (checkoutCustomId != null) {
			setCheckoutCustomId(checkoutCustomId);
		}

		Long commerceOrderId = (Long)attributes.get("commerceOrderId");

		if (commerceOrderId != null) {
			setCommerceOrderId(commerceOrderId);
		}

		String requestJson = (String)attributes.get("requestJson");

		if (requestJson != null) {
			setRequestJson(requestJson);
		}

		String responseJson = (String)attributes.get("responseJson");

		if (responseJson != null) {
			setResponseJson(responseJson);
		}

		String module = (String)attributes.get("module");

		if (module != null) {
			setModule(module);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public CheckoutCustom cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the checkout custom ID of this checkout custom.
	 *
	 * @return the checkout custom ID of this checkout custom
	 */
	@Override
	public long getCheckoutCustomId() {
		return model.getCheckoutCustomId();
	}

	/**
	 * Returns the commerce order ID of this checkout custom.
	 *
	 * @return the commerce order ID of this checkout custom
	 */
	@Override
	public long getCommerceOrderId() {
		return model.getCommerceOrderId();
	}

	/**
	 * Returns the create date of this checkout custom.
	 *
	 * @return the create date of this checkout custom
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the module of this checkout custom.
	 *
	 * @return the module of this checkout custom
	 */
	@Override
	public String getModule() {
		return model.getModule();
	}

	/**
	 * Returns the primary key of this checkout custom.
	 *
	 * @return the primary key of this checkout custom
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request json of this checkout custom.
	 *
	 * @return the request json of this checkout custom
	 */
	@Override
	public String getRequestJson() {
		return model.getRequestJson();
	}

	/**
	 * Returns the response json of this checkout custom.
	 *
	 * @return the response json of this checkout custom
	 */
	@Override
	public String getResponseJson() {
		return model.getResponseJson();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the checkout custom ID of this checkout custom.
	 *
	 * @param checkoutCustomId the checkout custom ID of this checkout custom
	 */
	@Override
	public void setCheckoutCustomId(long checkoutCustomId) {
		model.setCheckoutCustomId(checkoutCustomId);
	}

	/**
	 * Sets the commerce order ID of this checkout custom.
	 *
	 * @param commerceOrderId the commerce order ID of this checkout custom
	 */
	@Override
	public void setCommerceOrderId(long commerceOrderId) {
		model.setCommerceOrderId(commerceOrderId);
	}

	/**
	 * Sets the create date of this checkout custom.
	 *
	 * @param createDate the create date of this checkout custom
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the module of this checkout custom.
	 *
	 * @param module the module of this checkout custom
	 */
	@Override
	public void setModule(String module) {
		model.setModule(module);
	}

	/**
	 * Sets the primary key of this checkout custom.
	 *
	 * @param primaryKey the primary key of this checkout custom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the request json of this checkout custom.
	 *
	 * @param requestJson the request json of this checkout custom
	 */
	@Override
	public void setRequestJson(String requestJson) {
		model.setRequestJson(requestJson);
	}

	/**
	 * Sets the response json of this checkout custom.
	 *
	 * @param responseJson the response json of this checkout custom
	 */
	@Override
	public void setResponseJson(String responseJson) {
		model.setResponseJson(responseJson);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CheckoutCustomWrapper wrap(CheckoutCustom checkoutCustom) {
		return new CheckoutCustomWrapper(checkoutCustom);
	}

}