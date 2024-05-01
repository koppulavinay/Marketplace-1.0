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

package com.marketplace.checkout.consignee.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_consigneedetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutConsigneeDetails
 * @generated
 */
public class CheckoutConsigneeDetailsTable
	extends BaseTable<CheckoutConsigneeDetailsTable> {

	public static final CheckoutConsigneeDetailsTable INSTANCE =
		new CheckoutConsigneeDetailsTable();

	public final Column<CheckoutConsigneeDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long>
		checkoutConsigneeId = createColumn(
			"checkoutConsigneeId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CheckoutConsigneeDetailsTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> parentCartId =
		createColumn(
			"parentCartId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> orderItemId =
		createColumn(
			"orderItemId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		shippingConsigneeId = createColumn(
			"shippingConsigneeId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		shipConsigneeJson = createColumn(
			"shipConsigneeJson", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		shipConsigneeAddressID = createColumn(
			"shipConsigneeAddressID", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		shipConsigneeAddressJson = createColumn(
			"shipConsigneeAddressJson", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		billingConsigneeId = createColumn(
			"billingConsigneeId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		billConsigneeJson = createColumn(
			"billConsigneeJson", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		billConsigneeAddressId = createColumn(
			"billConsigneeAddressId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, String>
		billConsigneeAddressJson = createColumn(
			"billConsigneeAddressJson", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CheckoutConsigneeDetailsTable, Long> quantity =
		createColumn("quantity", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CheckoutConsigneeDetailsTable() {
		super(
			"marketplace_consigneedetails", CheckoutConsigneeDetailsTable::new);
	}

}