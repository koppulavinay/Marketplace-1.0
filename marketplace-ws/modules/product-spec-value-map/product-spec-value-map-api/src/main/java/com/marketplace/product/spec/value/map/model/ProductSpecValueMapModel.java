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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ProductSpecValueMap service. Represents a row in the &quot;marketplace_product_spec_value&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMap
 * @generated
 */
@ProviderType
public interface ProductSpecValueMapModel
	extends BaseModel<ProductSpecValueMap>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a product spec value map model instance should use the {@link ProductSpecValueMap} interface instead.
	 */

	/**
	 * Returns the primary key of this product spec value map.
	 *
	 * @return the primary key of this product spec value map
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this product spec value map.
	 *
	 * @param primaryKey the primary key of this product spec value map
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this product spec value map.
	 *
	 * @return the uuid of this product spec value map
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this product spec value map.
	 *
	 * @param uuid the uuid of this product spec value map
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the product spec value ID of this product spec value map.
	 *
	 * @return the product spec value ID of this product spec value map
	 */
	public long getProductSpecValueId();

	/**
	 * Sets the product spec value ID of this product spec value map.
	 *
	 * @param productSpecValueId the product spec value ID of this product spec value map
	 */
	public void setProductSpecValueId(long productSpecValueId);

	/**
	 * Returns the group ID of this product spec value map.
	 *
	 * @return the group ID of this product spec value map
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this product spec value map.
	 *
	 * @param groupId the group ID of this product spec value map
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the product specification ID of this product spec value map.
	 *
	 * @return the product specification ID of this product spec value map
	 */
	public long getProductSpecificationId();

	/**
	 * Sets the product specification ID of this product spec value map.
	 *
	 * @param productSpecificationId the product specification ID of this product spec value map
	 */
	public void setProductSpecificationId(long productSpecificationId);

	/**
	 * Returns the specification value label ID of this product spec value map.
	 *
	 * @return the specification value label ID of this product spec value map
	 */
	public long getSpecificationValueLabelId();

	/**
	 * Sets the specification value label ID of this product spec value map.
	 *
	 * @param specificationValueLabelId the specification value label ID of this product spec value map
	 */
	public void setSpecificationValueLabelId(long specificationValueLabelId);

	/**
	 * Returns the specification value label of this product spec value map.
	 *
	 * @return the specification value label of this product spec value map
	 */
	@AutoEscape
	public String getSpecificationValueLabel();

	/**
	 * Sets the specification value label of this product spec value map.
	 *
	 * @param specificationValueLabel the specification value label of this product spec value map
	 */
	public void setSpecificationValueLabel(String specificationValueLabel);

	/**
	 * Returns the specification value uom of this product spec value map.
	 *
	 * @return the specification value uom of this product spec value map
	 */
	@AutoEscape
	public String getSpecificationValueUOM();

	/**
	 * Sets the specification value uom of this product spec value map.
	 *
	 * @param specificationValueUOM the specification value uom of this product spec value map
	 */
	public void setSpecificationValueUOM(String specificationValueUOM);

	/**
	 * Returns the company ID of this product spec value map.
	 *
	 * @return the company ID of this product spec value map
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this product spec value map.
	 *
	 * @param companyId the company ID of this product spec value map
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this product spec value map.
	 *
	 * @return the user ID of this product spec value map
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this product spec value map.
	 *
	 * @param userId the user ID of this product spec value map
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this product spec value map.
	 *
	 * @return the user uuid of this product spec value map
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this product spec value map.
	 *
	 * @param userUuid the user uuid of this product spec value map
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this product spec value map.
	 *
	 * @return the user name of this product spec value map
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this product spec value map.
	 *
	 * @param userName the user name of this product spec value map
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the created by of this product spec value map.
	 *
	 * @return the created by of this product spec value map
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this product spec value map.
	 *
	 * @param createdBy the created by of this product spec value map
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this product spec value map.
	 *
	 * @return the modified by of this product spec value map
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this product spec value map.
	 *
	 * @param modifiedBy the modified by of this product spec value map
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the create date of this product spec value map.
	 *
	 * @return the create date of this product spec value map
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this product spec value map.
	 *
	 * @param createDate the create date of this product spec value map
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this product spec value map.
	 *
	 * @return the modified date of this product spec value map
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this product spec value map.
	 *
	 * @param modifiedDate the modified date of this product spec value map
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ip address of this product spec value map.
	 *
	 * @return the ip address of this product spec value map
	 */
	@AutoEscape
	public String getIpAddress();

	/**
	 * Sets the ip address of this product spec value map.
	 *
	 * @param ipAddress the ip address of this product spec value map
	 */
	public void setIpAddress(String ipAddress);

	@Override
	public ProductSpecValueMap cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}