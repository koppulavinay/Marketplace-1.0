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

package com.marketplace.category.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;marketplace_category&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
public class CategoryTable extends BaseTable<CategoryTable> {

	public static final CategoryTable INSTANCE = new CategoryTable();

	public final Column<CategoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CategoryTable, Long> parentCategoryId = createColumn(
		"parentCategoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> assetCategoryId = createColumn(
		"assetCategoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryName = createColumn(
		"categoryName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryCode = createColumn(
		"categoryCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryDescription =
		createColumn(
			"categoryDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryType = createColumn(
		"categoryType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> assignManager = createColumn(
		"assignManager", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> assignReviewer = createColumn(
		"assignReviewer", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryApprovalStatus =
		createColumn(
			"categoryApprovalStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> reviewerRemarks = createColumn(
		"reviewerRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> categoryExpiryDate = createColumn(
		"categoryExpiryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> categoryInactive = createColumn(
		"categoryInactive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> externalReferenceId =
		createColumn(
			"externalReferenceId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> categoryImageId = createColumn(
		"categoryImageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> categoryImageURL = createColumn(
		"categoryImageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> managerRemarks = createColumn(
		"managerRemarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> treePath = createColumn(
		"treePath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> termsCondition = createColumn(
		"termsCondition", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> hasChild = createColumn(
		"hasChild", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr1 = createColumn(
		"customAtr1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr2 = createColumn(
		"customAtr2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr3 = createColumn(
		"customAtr3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr4 = createColumn(
		"customAtr4", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr5 = createColumn(
		"customAtr5", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr6 = createColumn(
		"customAtr6", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr7 = createColumn(
		"customAtr7", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr8 = createColumn(
		"customAtr8", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr9 = createColumn(
		"customAtr9", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> customAtr10 = createColumn(
		"customAtr10", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> downForSeller = createColumn(
		"downForSeller", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> downForBuyer = createColumn(
		"downForBuyer", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Boolean> downForMaintenance =
		createColumn(
			"downForMaintenance", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CategoryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CategoryTable() {
		super("marketplace_category", CategoryTable::new);
	}

}