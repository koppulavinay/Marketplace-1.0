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

package com.marketplace.product.sku.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_product_sku&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKU
 * @generated
 */
public class ProductSKUTable extends BaseTable<ProductSKUTable> {

	public static final ProductSKUTable INSTANCE = new ProductSKUTable();

	public final Column<ProductSKUTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> productSKUId = createColumn(
		"productSKUId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductSKUTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> draftProductId = createColumn(
		"draftProductId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> skuId = createColumn(
		"skuId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> sellerSkuId = createColumn(
		"sellerSkuId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> skuName = createColumn(
		"skuName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> skuCreationName = createColumn(
		"skuCreationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> defaultSku = createColumn(
		"defaultSku", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, BigDecimal> basePrice = createColumn(
		"basePrice", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, BigDecimal> offerPrice = createColumn(
		"offerPrice", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, BigDecimal> cost = createColumn(
		"cost", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, BigDecimal> margin = createColumn(
		"margin", BigDecimal.class, Types.DECIMAL, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> stock = createColumn(
		"stock", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> uom = createColumn(
		"uom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> minimumOrderQuantity =
		createColumn(
			"minimumOrderQuantity", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> maximumOrderQuantity =
		createColumn(
			"maximumOrderQuantity", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> lowStockThreshold = createColumn(
		"lowStockThreshold", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> tax = createColumn(
		"tax", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Date> skuPublishingDate = createColumn(
		"skuPublishingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Date> skuExpiryDate = createColumn(
		"skuExpiryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> images = createColumn(
		"images", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductSKUTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProductSKUTable() {
		super("marketplace_product_sku", ProductSKUTable::new);
	}

}