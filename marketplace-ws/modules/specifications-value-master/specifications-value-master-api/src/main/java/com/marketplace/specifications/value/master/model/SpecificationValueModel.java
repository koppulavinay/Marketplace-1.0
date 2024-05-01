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

package com.marketplace.specifications.value.master.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SpecificationValue service. Represents a row in the &quot;marketplace_specificationvalue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.marketplace.specifications.value.master.model.impl.SpecificationValueImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecificationValue
 * @generated
 */
@ProviderType
public interface SpecificationValueModel
	extends BaseModel<SpecificationValue>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a specification value model instance should use the {@link SpecificationValue} interface instead.
	 */

	/**
	 * Returns the primary key of this specification value.
	 *
	 * @return the primary key of this specification value
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this specification value.
	 *
	 * @param primaryKey the primary key of this specification value
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this specification value.
	 *
	 * @return the uuid of this specification value
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this specification value.
	 *
	 * @param uuid the uuid of this specification value
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the specification value ID of this specification value.
	 *
	 * @return the specification value ID of this specification value
	 */
	public long getSpecificationValueId();

	/**
	 * Sets the specification value ID of this specification value.
	 *
	 * @param specificationValueId the specification value ID of this specification value
	 */
	public void setSpecificationValueId(long specificationValueId);

	/**
	 * Returns the group ID of this specification value.
	 *
	 * @return the group ID of this specification value
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this specification value.
	 *
	 * @param groupId the group ID of this specification value
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the specification ID of this specification value.
	 *
	 * @return the specification ID of this specification value
	 */
	public long getSpecificationId();

	/**
	 * Sets the specification ID of this specification value.
	 *
	 * @param specificationId the specification ID of this specification value
	 */
	public void setSpecificationId(long specificationId);

	/**
	 * Returns the specification value label of this specification value.
	 *
	 * @return the specification value label of this specification value
	 */
	@AutoEscape
	public String getSpecificationValueLabel();

	/**
	 * Sets the specification value label of this specification value.
	 *
	 * @param specificationValueLabel the specification value label of this specification value
	 */
	public void setSpecificationValueLabel(String specificationValueLabel);

	/**
	 * Returns the specification uom of this specification value.
	 *
	 * @return the specification uom of this specification value
	 */
	@AutoEscape
	public String getSpecificationUOM();

	/**
	 * Sets the specification uom of this specification value.
	 *
	 * @param specificationUOM the specification uom of this specification value
	 */
	public void setSpecificationUOM(String specificationUOM);

	/**
	 * Returns the ip address of this specification value.
	 *
	 * @return the ip address of this specification value
	 */
	@AutoEscape
	public String getIpAddress();

	/**
	 * Sets the ip address of this specification value.
	 *
	 * @param ipAddress the ip address of this specification value
	 */
	public void setIpAddress(String ipAddress);

	/**
	 * Returns the company ID of this specification value.
	 *
	 * @return the company ID of this specification value
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this specification value.
	 *
	 * @param companyId the company ID of this specification value
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this specification value.
	 *
	 * @return the user ID of this specification value
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this specification value.
	 *
	 * @param userId the user ID of this specification value
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this specification value.
	 *
	 * @return the user uuid of this specification value
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this specification value.
	 *
	 * @param userUuid the user uuid of this specification value
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this specification value.
	 *
	 * @return the user name of this specification value
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this specification value.
	 *
	 * @param userName the user name of this specification value
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this specification value.
	 *
	 * @return the create date of this specification value
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this specification value.
	 *
	 * @param createDate the create date of this specification value
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this specification value.
	 *
	 * @return the modified date of this specification value
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this specification value.
	 *
	 * @param modifiedDate the modified date of this specification value
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created by of this specification value.
	 *
	 * @return the created by of this specification value
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this specification value.
	 *
	 * @param createdBy the created by of this specification value
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this specification value.
	 *
	 * @return the modified by of this specification value
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this specification value.
	 *
	 * @param modifiedBy the modified by of this specification value
	 */
	public void setModifiedBy(long modifiedBy);

	@Override
	public SpecificationValue cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}