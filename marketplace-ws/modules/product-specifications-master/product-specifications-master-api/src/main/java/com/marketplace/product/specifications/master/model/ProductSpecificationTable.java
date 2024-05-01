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

package com.marketplace.product.specifications.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_productspecs&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecification
 * @generated
 */
public class ProductSpecificationTable
	extends BaseTable<ProductSpecificationTable> {

	public static final ProductSpecificationTable INSTANCE =
		new ProductSpecificationTable();

	public final Column<ProductSpecificationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long>
		productSpecificationId = createColumn(
			"productSpecificationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProductSpecificationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> specificationId =
		createColumn(
			"specificationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, String> specificationLabel =
		createColumn(
			"specificationLabel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, String>
		specificationFieldType = createColumn(
			"specificationFieldType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> draftProductId =
		createColumn(
			"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Boolean> isMandatory =
		createColumn(
			"isMandatory", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecificationTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductSpecificationTable() {
		super("marketplace_productspecs", ProductSpecificationTable::new);
	}

}