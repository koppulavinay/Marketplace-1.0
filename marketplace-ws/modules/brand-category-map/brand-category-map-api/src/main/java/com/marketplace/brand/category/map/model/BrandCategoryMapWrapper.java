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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BrandCategoryMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrandCategoryMap
 * @generated
 */
public class BrandCategoryMapWrapper
	extends BaseModelWrapper<BrandCategoryMap>
	implements BrandCategoryMap, ModelWrapper<BrandCategoryMap> {

	public BrandCategoryMapWrapper(BrandCategoryMap brandCategoryMap) {
		super(brandCategoryMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brandCategoryMapId", getBrandCategoryMapId());
		attributes.put("brandId", getBrandId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brandCategoryMapId = (Long)attributes.get("brandCategoryMapId");

		if (brandCategoryMapId != null) {
			setBrandCategoryMapId(brandCategoryMapId);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	@Override
	public BrandCategoryMap cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the brand category map ID of this brand category map.
	 *
	 * @return the brand category map ID of this brand category map
	 */
	@Override
	public long getBrandCategoryMapId() {
		return model.getBrandCategoryMapId();
	}

	/**
	 * Returns the brand ID of this brand category map.
	 *
	 * @return the brand ID of this brand category map
	 */
	@Override
	public long getBrandId() {
		return model.getBrandId();
	}

	/**
	 * Returns the category ID of this brand category map.
	 *
	 * @return the category ID of this brand category map
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the primary key of this brand category map.
	 *
	 * @return the primary key of this brand category map
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the brand category map ID of this brand category map.
	 *
	 * @param brandCategoryMapId the brand category map ID of this brand category map
	 */
	@Override
	public void setBrandCategoryMapId(long brandCategoryMapId) {
		model.setBrandCategoryMapId(brandCategoryMapId);
	}

	/**
	 * Sets the brand ID of this brand category map.
	 *
	 * @param brandId the brand ID of this brand category map
	 */
	@Override
	public void setBrandId(long brandId) {
		model.setBrandId(brandId);
	}

	/**
	 * Sets the category ID of this brand category map.
	 *
	 * @param categoryId the category ID of this brand category map
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the primary key of this brand category map.
	 *
	 * @param primaryKey the primary key of this brand category map
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BrandCategoryMapWrapper wrap(BrandCategoryMap brandCategoryMap) {
		return new BrandCategoryMapWrapper(brandCategoryMap);
	}

}