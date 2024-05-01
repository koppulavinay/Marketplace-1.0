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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_checkout&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutCustom
 * @generated
 */
public class CheckoutCustomTable extends BaseTable<CheckoutCustomTable> {

	public static final CheckoutCustomTable INSTANCE =
		new CheckoutCustomTable();

	public final Column<CheckoutCustomTable, Long> checkoutCustomId =
		createColumn(
			"checkoutCustomId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CheckoutCustomTable, Long> commerceOrderId =
		createColumn(
			"commerceOrderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutCustomTable, String> requestJson = createColumn(
		"requestJson", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckoutCustomTable, String> responseJson =
		createColumn(
			"responseJson", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckoutCustomTable, String> module = createColumn(
		"module", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckoutCustomTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CheckoutCustomTable() {
		super("marketplace_checkout", CheckoutCustomTable::new);
	}

}