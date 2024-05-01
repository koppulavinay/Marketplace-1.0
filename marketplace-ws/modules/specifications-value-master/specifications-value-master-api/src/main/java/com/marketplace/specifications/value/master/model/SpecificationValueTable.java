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

package com.marketplace.specifications.value.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_specificationvalue&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValue
 * @generated
 */
public class SpecificationValueTable
	extends BaseTable<SpecificationValueTable> {

	public static final SpecificationValueTable INSTANCE =
		new SpecificationValueTable();

	public final Column<SpecificationValueTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> specificationValueId =
		createColumn(
			"specificationValueId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SpecificationValueTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> specificationId =
		createColumn(
			"specificationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, String>
		specificationValueLabel = createColumn(
			"specificationValueLabel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, String> specificationUOM =
		createColumn(
			"specificationUOM", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationValueTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SpecificationValueTable() {
		super("marketplace_specificationvalue", SpecificationValueTable::new);
	}

}