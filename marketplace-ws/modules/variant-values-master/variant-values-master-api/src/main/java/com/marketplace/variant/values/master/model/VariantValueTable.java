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

package com.marketplace.variant.values.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_variant_value&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VariantValue
 * @generated
 */
public class VariantValueTable extends BaseTable<VariantValueTable> {

	public static final VariantValueTable INSTANCE = new VariantValueTable();

	public final Column<VariantValueTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> variantValueId = createColumn(
		"variantValueId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VariantValueTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> productVariantId =
		createColumn(
			"productVariantId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, String> variantVal = createColumn(
		"variantVal", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> draftProductId = createColumn(
		"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VariantValueTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private VariantValueTable() {
		super("marketplace_variant_value", VariantValueTable::new);
	}

}