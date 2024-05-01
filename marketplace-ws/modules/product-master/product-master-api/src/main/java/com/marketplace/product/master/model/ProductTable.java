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

package com.marketplace.product.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductTable extends BaseTable<ProductTable> {

	public static final ProductTable INSTANCE = new ProductTable();

	public final Column<ProductTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> draftProductId = createColumn(
		"draftProductId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> brandId = createColumn(
		"brandId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> productName = createColumn(
		"productName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> productType = createColumn(
		"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> shortDescription = createColumn(
		"shortDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> longDescription = createColumn(
		"longDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> modelNumber = createColumn(
		"modelNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> productStatus = createColumn(
		"productStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> stepNumber = createColumn(
		"stepNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> productMappingId = createColumn(
		"productMappingId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> taxCategoryId = createColumn(
		"taxCategoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> cpDefinitionId = createColumn(
		"cpDefinitionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> vendorId = createColumn(
		"vendorId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> vendorName = createColumn(
		"vendorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> organizationId = createColumn(
		"organizationId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> organizationName = createColumn(
		"organizationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductTable() {
		super("marketplace_product", ProductTable::new);
	}

}