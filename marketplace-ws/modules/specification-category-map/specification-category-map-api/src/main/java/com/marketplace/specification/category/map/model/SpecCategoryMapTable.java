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

package com.marketplace.specification.category.map.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_speccategorymap&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMap
 * @generated
 */
public class SpecCategoryMapTable extends BaseTable<SpecCategoryMapTable> {

	public static final SpecCategoryMapTable INSTANCE =
		new SpecCategoryMapTable();

	public final Column<SpecCategoryMapTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Long> specCategoryMapId =
		createColumn(
			"specCategoryMapId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SpecCategoryMapTable, Long> specificationId =
		createColumn(
			"specificationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Boolean> isCategoryMandatory =
		createColumn(
			"isCategoryMandatory", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SpecCategoryMapTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SpecCategoryMapTable() {
		super("marketplace_speccategorymap", SpecCategoryMapTable::new);
	}

}