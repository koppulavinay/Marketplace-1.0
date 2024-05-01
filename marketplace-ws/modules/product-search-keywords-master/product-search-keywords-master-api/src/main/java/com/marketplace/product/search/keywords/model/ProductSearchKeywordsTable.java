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

package com.marketplace.product.search.keywords.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product_keywords&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywords
 * @generated
 */
public class ProductSearchKeywordsTable
	extends BaseTable<ProductSearchKeywordsTable> {

	public static final ProductSearchKeywordsTable INSTANCE =
		new ProductSearchKeywordsTable();

	public final Column<ProductSearchKeywordsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> searchKeywordId =
		createColumn(
			"searchKeywordId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductSearchKeywordsTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, String> searchKeyword =
		createColumn(
			"searchKeyword", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> draftProductId =
		createColumn(
			"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSearchKeywordsTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductSearchKeywordsTable() {
		super("marketplace_product_keywords", ProductSearchKeywordsTable::new);
	}

}