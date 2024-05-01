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

package com.marketplace.product.mediasku.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product_mediasku&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKU
 * @generated
 */
public class ProductMediaSKUTable extends BaseTable<ProductMediaSKUTable> {

	public static final ProductMediaSKUTable INSTANCE =
		new ProductMediaSKUTable();

	public final Column<ProductMediaSKUTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> ProductMediaSKUId =
		createColumn(
			"ProductMediaSKUId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductMediaSKUTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> draftProductId =
		createColumn(
			"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> productSKUId = createColumn(
		"productSKUId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, String> imageUrl = createColumn(
		"imageUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductMediaSKUTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProductMediaSKUTable() {
		super("marketplace_product_mediasku", ProductMediaSKUTable::new);
	}

}