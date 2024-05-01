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

package com.marketplace.brand.category.map.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;marketplace_brandcategorymap&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BrandCategoryMap
 * @generated
 */
public class BrandCategoryMapTable extends BaseTable<BrandCategoryMapTable> {

	public static final BrandCategoryMapTable INSTANCE =
		new BrandCategoryMapTable();

	public final Column<BrandCategoryMapTable, Long> brandCategoryMapId =
		createColumn(
			"brandCategoryMapId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BrandCategoryMapTable, Long> brandId = createColumn(
		"brandId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BrandCategoryMapTable, Long> categoryId = createColumn(
		"categoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BrandCategoryMapTable() {
		super("marketplace_brandcategorymap", BrandCategoryMapTable::new);
	}

}