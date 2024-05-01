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

package com.marketplace.specification.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_specification&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Specification
 * @generated
 */
public class SpecificationTable extends BaseTable<SpecificationTable> {

	public static final SpecificationTable INSTANCE = new SpecificationTable();

	public final Column<SpecificationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> specificationId =
		createColumn(
			"specificationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SpecificationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, String> specificationLabel =
		createColumn(
			"specificationLabel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, String> specificationDescription =
		createColumn(
			"specificationDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> specificationFieldType =
		createColumn(
			"specificationFieldType", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> specificationFieldDataType =
		createColumn(
			"specificationFieldDataType", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> specificationPriority =
		createColumn(
			"specificationPriority", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Boolean> isVariant = createColumn(
		"isVariant", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> specificationGroupId =
		createColumn(
			"specificationGroupId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> cpSpecificationId =
		createColumn(
			"cpSpecificationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, String> specificationStatus =
		createColumn(
			"specificationStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecificationTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SpecificationTable() {
		super("marketplace_specification", SpecificationTable::new);
	}

}