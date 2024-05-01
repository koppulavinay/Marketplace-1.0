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

package com.marketplace.brand.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_brand&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Brand
 * @generated
 */
public class BrandTable extends BaseTable<BrandTable> {

	public static final BrandTable INSTANCE = new BrandTable();

	public final Column<BrandTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> brandId = createColumn(
		"brandId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BrandTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> assetCategoryId = createColumn(
		"assetCategoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandCode = createColumn(
		"brandCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandName = createColumn(
		"brandName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandDescription = createColumn(
		"brandDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandOwner = createColumn(
		"brandOwner", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> brandReviewer = createColumn(
		"brandReviewer", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandType = createColumn(
		"brandType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> externalReferenceId = createColumn(
		"externalReferenceId", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandApprovalStatus = createColumn(
		"brandApprovalStatus", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> reviewerRemarks = createColumn(
		"reviewerRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Boolean> brandInactive = createColumn(
		"brandInactive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> brandImageUpload = createColumn(
		"brandImageUpload", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> brandImageURL = createColumn(
		"brandImageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> managerRemarks = createColumn(
		"managerRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr1 = createColumn(
		"customAtr1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr2 = createColumn(
		"customAtr2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr3 = createColumn(
		"customAtr3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr4 = createColumn(
		"customAtr4", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr5 = createColumn(
		"customAtr5", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr6 = createColumn(
		"customAtr6", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr7 = createColumn(
		"customAtr7", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr8 = createColumn(
		"customAtr8", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr9 = createColumn(
		"customAtr9", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> customAtr10 = createColumn(
		"customAtr10", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Boolean> downForSeller = createColumn(
		"downForSeller", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Boolean> downForBuyer = createColumn(
		"downForBuyer", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Boolean> downForMaintenance = createColumn(
		"downForMaintenance", Boolean.class, Types.BOOLEAN,
		Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BrandTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private BrandTable() {
		super("marketplace_brand", BrandTable::new);
	}

}