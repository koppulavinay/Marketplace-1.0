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

package com.marketplace.product.specifications.master.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.model.ProductSpecificationModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProductSpecification service. Represents a row in the &quot;marketplace_productspecs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductSpecificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductSpecificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationImpl
 * @generated
 */
public class ProductSpecificationModelImpl
	extends BaseModelImpl<ProductSpecification>
	implements ProductSpecificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product specification model instance should use the <code>ProductSpecification</code> interface instead.
	 */
	public static final String TABLE_NAME = "marketplace_productspecs";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"productSpecificationId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"specificationId", Types.BIGINT},
		{"specificationLabel", Types.VARCHAR},
		{"specificationFieldType", Types.VARCHAR},
		{"draftProductId", Types.BIGINT}, {"isMandatory", Types.BOOLEAN},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createdBy", Types.BIGINT},
		{"modifiedBy", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"ipAddress", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productSpecificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("specificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("specificationLabel", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specificationFieldType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("draftProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isMandatory", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table marketplace_productspecs (uuid_ VARCHAR(75) null,productSpecificationId LONG not null primary key,groupId LONG,specificationId LONG,specificationLabel VARCHAR(75) null,specificationFieldType VARCHAR(75) null,draftProductId LONG,isMandatory BOOLEAN,companyId LONG,userId LONG,userName VARCHAR(75) null,createdBy LONG,modifiedBy LONG,createDate DATE null,modifiedDate DATE null,ipAddress VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table marketplace_productspecs";

	public static final String ORDER_BY_JPQL =
		" ORDER BY productSpecification.productSpecificationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY marketplace_productspecs.productSpecificationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DRAFTPRODUCTID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRODUCTSPECIFICATIONID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ProductSpecificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productSpecificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductSpecificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productSpecificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProductSpecification.class;
	}

	@Override
	public String getModelClassName() {
		return ProductSpecification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProductSpecification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProductSpecification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductSpecification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProductSpecification)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProductSpecification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProductSpecification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProductSpecification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProductSpecification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProductSpecification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ProductSpecification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProductSpecification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProductSpecification, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProductSpecification, Object>>();
		Map<String, BiConsumer<ProductSpecification, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ProductSpecification, ?>>();

		attributeGetterFunctions.put("uuid", ProductSpecification::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProductSpecification, String>)
				ProductSpecification::setUuid);
		attributeGetterFunctions.put(
			"productSpecificationId",
			ProductSpecification::getProductSpecificationId);
		attributeSetterBiConsumers.put(
			"productSpecificationId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setProductSpecificationId);
		attributeGetterFunctions.put(
			"groupId", ProductSpecification::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setGroupId);
		attributeGetterFunctions.put(
			"specificationId", ProductSpecification::getSpecificationId);
		attributeSetterBiConsumers.put(
			"specificationId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setSpecificationId);
		attributeGetterFunctions.put(
			"specificationLabel", ProductSpecification::getSpecificationLabel);
		attributeSetterBiConsumers.put(
			"specificationLabel",
			(BiConsumer<ProductSpecification, String>)
				ProductSpecification::setSpecificationLabel);
		attributeGetterFunctions.put(
			"specificationFieldType",
			ProductSpecification::getSpecificationFieldType);
		attributeSetterBiConsumers.put(
			"specificationFieldType",
			(BiConsumer<ProductSpecification, String>)
				ProductSpecification::setSpecificationFieldType);
		attributeGetterFunctions.put(
			"draftProductId", ProductSpecification::getDraftProductId);
		attributeSetterBiConsumers.put(
			"draftProductId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setDraftProductId);
		attributeGetterFunctions.put(
			"isMandatory", ProductSpecification::getIsMandatory);
		attributeSetterBiConsumers.put(
			"isMandatory",
			(BiConsumer<ProductSpecification, Boolean>)
				ProductSpecification::setIsMandatory);
		attributeGetterFunctions.put(
			"companyId", ProductSpecification::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setCompanyId);
		attributeGetterFunctions.put("userId", ProductSpecification::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setUserId);
		attributeGetterFunctions.put(
			"userName", ProductSpecification::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProductSpecification, String>)
				ProductSpecification::setUserName);
		attributeGetterFunctions.put(
			"createdBy", ProductSpecification::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", ProductSpecification::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProductSpecification, Long>)
				ProductSpecification::setModifiedBy);
		attributeGetterFunctions.put(
			"createDate", ProductSpecification::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProductSpecification, Date>)
				ProductSpecification::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProductSpecification::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProductSpecification, Date>)
				ProductSpecification::setModifiedDate);
		attributeGetterFunctions.put(
			"ipAddress", ProductSpecification::getIpAddress);
		attributeSetterBiConsumers.put(
			"ipAddress",
			(BiConsumer<ProductSpecification, String>)
				ProductSpecification::setIpAddress);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getProductSpecificationId() {
		return _productSpecificationId;
	}

	@Override
	public void setProductSpecificationId(long productSpecificationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_productSpecificationId = productSpecificationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getSpecificationId() {
		return _specificationId;
	}

	@Override
	public void setSpecificationId(long specificationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_specificationId = specificationId;
	}

	@Override
	public String getSpecificationLabel() {
		if (_specificationLabel == null) {
			return "";
		}
		else {
			return _specificationLabel;
		}
	}

	@Override
	public void setSpecificationLabel(String specificationLabel) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_specificationLabel = specificationLabel;
	}

	@Override
	public String getSpecificationFieldType() {
		if (_specificationFieldType == null) {
			return "";
		}
		else {
			return _specificationFieldType;
		}
	}

	@Override
	public void setSpecificationFieldType(String specificationFieldType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_specificationFieldType = specificationFieldType;
	}

	@Override
	public long getDraftProductId() {
		return _draftProductId;
	}

	@Override
	public void setDraftProductId(long draftProductId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_draftProductId = draftProductId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDraftProductId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("draftProductId"));
	}

	@Override
	public boolean getIsMandatory() {
		return _isMandatory;
	}

	@Override
	public boolean isIsMandatory() {
		return _isMandatory;
	}

	@Override
	public void setIsMandatory(boolean isMandatory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isMandatory = isMandatory;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdBy = createdBy;
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return "";
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ipAddress = ipAddress;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProductSpecification.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProductSpecification.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProductSpecification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProductSpecification>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductSpecificationImpl productSpecificationImpl =
			new ProductSpecificationImpl();

		productSpecificationImpl.setUuid(getUuid());
		productSpecificationImpl.setProductSpecificationId(
			getProductSpecificationId());
		productSpecificationImpl.setGroupId(getGroupId());
		productSpecificationImpl.setSpecificationId(getSpecificationId());
		productSpecificationImpl.setSpecificationLabel(getSpecificationLabel());
		productSpecificationImpl.setSpecificationFieldType(
			getSpecificationFieldType());
		productSpecificationImpl.setDraftProductId(getDraftProductId());
		productSpecificationImpl.setIsMandatory(isIsMandatory());
		productSpecificationImpl.setCompanyId(getCompanyId());
		productSpecificationImpl.setUserId(getUserId());
		productSpecificationImpl.setUserName(getUserName());
		productSpecificationImpl.setCreatedBy(getCreatedBy());
		productSpecificationImpl.setModifiedBy(getModifiedBy());
		productSpecificationImpl.setCreateDate(getCreateDate());
		productSpecificationImpl.setModifiedDate(getModifiedDate());
		productSpecificationImpl.setIpAddress(getIpAddress());

		productSpecificationImpl.resetOriginalValues();

		return productSpecificationImpl;
	}

	@Override
	public ProductSpecification cloneWithOriginalValues() {
		ProductSpecificationImpl productSpecificationImpl =
			new ProductSpecificationImpl();

		productSpecificationImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		productSpecificationImpl.setProductSpecificationId(
			this.<Long>getColumnOriginalValue("productSpecificationId"));
		productSpecificationImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		productSpecificationImpl.setSpecificationId(
			this.<Long>getColumnOriginalValue("specificationId"));
		productSpecificationImpl.setSpecificationLabel(
			this.<String>getColumnOriginalValue("specificationLabel"));
		productSpecificationImpl.setSpecificationFieldType(
			this.<String>getColumnOriginalValue("specificationFieldType"));
		productSpecificationImpl.setDraftProductId(
			this.<Long>getColumnOriginalValue("draftProductId"));
		productSpecificationImpl.setIsMandatory(
			this.<Boolean>getColumnOriginalValue("isMandatory"));
		productSpecificationImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		productSpecificationImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		productSpecificationImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		productSpecificationImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("createdBy"));
		productSpecificationImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		productSpecificationImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		productSpecificationImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		productSpecificationImpl.setIpAddress(
			this.<String>getColumnOriginalValue("ipAddress"));

		return productSpecificationImpl;
	}

	@Override
	public int compareTo(ProductSpecification productSpecification) {
		long primaryKey = productSpecification.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSpecification)) {
			return false;
		}

		ProductSpecification productSpecification =
			(ProductSpecification)object;

		long primaryKey = productSpecification.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ProductSpecification> toCacheModel() {
		ProductSpecificationCacheModel productSpecificationCacheModel =
			new ProductSpecificationCacheModel();

		productSpecificationCacheModel.uuid = getUuid();

		String uuid = productSpecificationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			productSpecificationCacheModel.uuid = null;
		}

		productSpecificationCacheModel.productSpecificationId =
			getProductSpecificationId();

		productSpecificationCacheModel.groupId = getGroupId();

		productSpecificationCacheModel.specificationId = getSpecificationId();

		productSpecificationCacheModel.specificationLabel =
			getSpecificationLabel();

		String specificationLabel =
			productSpecificationCacheModel.specificationLabel;

		if ((specificationLabel != null) &&
			(specificationLabel.length() == 0)) {

			productSpecificationCacheModel.specificationLabel = null;
		}

		productSpecificationCacheModel.specificationFieldType =
			getSpecificationFieldType();

		String specificationFieldType =
			productSpecificationCacheModel.specificationFieldType;

		if ((specificationFieldType != null) &&
			(specificationFieldType.length() == 0)) {

			productSpecificationCacheModel.specificationFieldType = null;
		}

		productSpecificationCacheModel.draftProductId = getDraftProductId();

		productSpecificationCacheModel.isMandatory = isIsMandatory();

		productSpecificationCacheModel.companyId = getCompanyId();

		productSpecificationCacheModel.userId = getUserId();

		productSpecificationCacheModel.userName = getUserName();

		String userName = productSpecificationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			productSpecificationCacheModel.userName = null;
		}

		productSpecificationCacheModel.createdBy = getCreatedBy();

		productSpecificationCacheModel.modifiedBy = getModifiedBy();

		Date createDate = getCreateDate();

		if (createDate != null) {
			productSpecificationCacheModel.createDate = createDate.getTime();
		}
		else {
			productSpecificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productSpecificationCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			productSpecificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		productSpecificationCacheModel.ipAddress = getIpAddress();

		String ipAddress = productSpecificationCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			productSpecificationCacheModel.ipAddress = null;
		}

		return productSpecificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProductSpecification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProductSpecification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductSpecification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProductSpecification)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProductSpecification>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ProductSpecification.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _productSpecificationId;
	private long _groupId;
	private long _specificationId;
	private String _specificationLabel;
	private String _specificationFieldType;
	private long _draftProductId;
	private boolean _isMandatory;
	private long _companyId;
	private long _userId;
	private String _userName;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _ipAddress;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProductSpecification, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProductSpecification)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"productSpecificationId", _productSpecificationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("specificationId", _specificationId);
		_columnOriginalValues.put("specificationLabel", _specificationLabel);
		_columnOriginalValues.put(
			"specificationFieldType", _specificationFieldType);
		_columnOriginalValues.put("draftProductId", _draftProductId);
		_columnOriginalValues.put("isMandatory", _isMandatory);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createdBy", _createdBy);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("ipAddress", _ipAddress);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("productSpecificationId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("specificationId", 8L);

		columnBitmasks.put("specificationLabel", 16L);

		columnBitmasks.put("specificationFieldType", 32L);

		columnBitmasks.put("draftProductId", 64L);

		columnBitmasks.put("isMandatory", 128L);

		columnBitmasks.put("companyId", 256L);

		columnBitmasks.put("userId", 512L);

		columnBitmasks.put("userName", 1024L);

		columnBitmasks.put("createdBy", 2048L);

		columnBitmasks.put("modifiedBy", 4096L);

		columnBitmasks.put("createDate", 8192L);

		columnBitmasks.put("modifiedDate", 16384L);

		columnBitmasks.put("ipAddress", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProductSpecification _escapedModel;

}