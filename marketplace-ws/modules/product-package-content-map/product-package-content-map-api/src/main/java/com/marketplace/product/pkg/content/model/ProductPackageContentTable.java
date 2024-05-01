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

package com.marketplace.product.pkg.content.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_prod_pkg_content&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContent
 * @generated
 */
public class ProductPackageContentTable
	extends BaseTable<ProductPackageContentTable> {

	public static final ProductPackageContentTable INSTANCE =
		new ProductPackageContentTable();

	public final Column<ProductPackageContentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> packageContentId =
		createColumn(
			"packageContentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductPackageContentTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, String> itemName =
		createColumn(
			"itemName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, String> itemQuantity =
		createColumn(
			"itemQuantity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> draftProductId =
		createColumn(
			"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductPackageContentTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductPackageContentTable() {
		super("marketplace_prod_pkg_content", ProductPackageContentTable::new);
	}

}