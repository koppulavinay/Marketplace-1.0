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

package com.marketplace.product.variant.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product_variant&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariant
 * @generated
 */
public class ProductVariantTable extends BaseTable<ProductVariantTable> {

	public static final ProductVariantTable INSTANCE =
		new ProductVariantTable();

	public final Column<ProductVariantTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> productVariantId =
		createColumn(
			"productVariantId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductVariantTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> draftProductId =
		createColumn(
			"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, String> variantName = createColumn(
		"variantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductVariantTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductVariantTable() {
		super("marketplace_product_variant", ProductVariantTable::new);
	}

}