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

package com.marketplace.product.spec.value.map.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product_spec_value&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMap
 * @generated
 */
public class ProductSpecValueMapTable
	extends BaseTable<ProductSpecValueMapTable> {

	public static final ProductSpecValueMapTable INSTANCE =
		new ProductSpecValueMapTable();

	public final Column<ProductSpecValueMapTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> productSpecValueId =
		createColumn(
			"productSpecValueId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProductSpecValueMapTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> productSpecificationId =
		createColumn(
			"productSpecificationId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long>
		specificationValueLabelId = createColumn(
			"specificationValueLabelId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, String>
		specificationValueLabel = createColumn(
			"specificationValueLabel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, String>
		specificationValueUOM = createColumn(
			"specificationValueUOM", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSpecValueMapTable, String> ipAddress =
		createColumn(
			"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductSpecValueMapTable() {
		super("marketplace_product_spec_value", ProductSpecValueMapTable::new);
	}

}