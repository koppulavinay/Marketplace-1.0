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

package com.marketplace.specification.category.map.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.model.SpecCategoryMapModel;

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
 * The base model implementation for the SpecCategoryMap service. Represents a row in the &quot;marketplace_speccategorymap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SpecCategoryMapModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SpecCategoryMapImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapImpl
 * @generated
 */
public class SpecCategoryMapModelImpl
	extends BaseModelImpl<SpecCategoryMap> implements SpecCategoryMapModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a spec category map model instance should use the <code>SpecCategoryMap</code> interface instead.
	 */
	public static final String TABLE_NAME = "marketplace_speccategorymap";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"specCategoryMapId", Types.BIGINT},
		{"specificationId", Types.BIGINT}, {"categoryId", Types.BIGINT},
		{"isCategoryMandatory", Types.BOOLEAN}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"createdBy", Types.BIGINT}, {"modifiedBy", Types.BIGINT},
		{"ipAddress", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specCategoryMapId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("specificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isCategoryMandatory", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table marketplace_speccategorymap (uuid_ VARCHAR(75) null,specCategoryMapId LONG not null primary key,specificationId LONG,categoryId LONG,isCategoryMandatory BOOLEAN,companyId LONG,createDate DATE null,modifiedDate DATE null,createdBy LONG,modifiedBy LONG,ipAddress VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table marketplace_speccategorymap";

	public static final String ORDER_BY_JPQL =
		" ORDER BY specCategoryMap.specCategoryMapId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY marketplace_speccategorymap.specCategoryMapId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CATEGORYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SPECIFICATIONID_COLUMN_BITMASK = 4L;

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
	public static final long SPECCATEGORYMAPID_COLUMN_BITMASK = 16L;

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

	public SpecCategoryMapModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _specCategoryMapId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpecCategoryMapId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _specCategoryMapId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SpecCategoryMap.class;
	}

	@Override
	public String getModelClassName() {
		return SpecCategoryMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SpecCategoryMap, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SpecCategoryMap, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SpecCategoryMap, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SpecCategoryMap)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SpecCategoryMap, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SpecCategoryMap, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SpecCategoryMap)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SpecCategoryMap, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SpecCategoryMap, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SpecCategoryMap, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SpecCategoryMap, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SpecCategoryMap, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<SpecCategoryMap, Object>>();
		Map<String, BiConsumer<SpecCategoryMap, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SpecCategoryMap, ?>>();

		attributeGetterFunctions.put("uuid", SpecCategoryMap::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<SpecCategoryMap, String>)SpecCategoryMap::setUuid);
		attributeGetterFunctions.put(
			"specCategoryMapId", SpecCategoryMap::getSpecCategoryMapId);
		attributeSetterBiConsumers.put(
			"specCategoryMapId",
			(BiConsumer<SpecCategoryMap, Long>)
				SpecCategoryMap::setSpecCategoryMapId);
		attributeGetterFunctions.put(
			"specificationId", SpecCategoryMap::getSpecificationId);
		attributeSetterBiConsumers.put(
			"specificationId",
			(BiConsumer<SpecCategoryMap, Long>)
				SpecCategoryMap::setSpecificationId);
		attributeGetterFunctions.put(
			"categoryId", SpecCategoryMap::getCategoryId);
		attributeSetterBiConsumers.put(
			"categoryId",
			(BiConsumer<SpecCategoryMap, Long>)SpecCategoryMap::setCategoryId);
		attributeGetterFunctions.put(
			"isCategoryMandatory", SpecCategoryMap::getIsCategoryMandatory);
		attributeSetterBiConsumers.put(
			"isCategoryMandatory",
			(BiConsumer<SpecCategoryMap, Boolean>)
				SpecCategoryMap::setIsCategoryMandatory);
		attributeGetterFunctions.put(
			"companyId", SpecCategoryMap::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SpecCategoryMap, Long>)SpecCategoryMap::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", SpecCategoryMap::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SpecCategoryMap, Date>)SpecCategoryMap::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SpecCategoryMap::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SpecCategoryMap, Date>)
				SpecCategoryMap::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", SpecCategoryMap::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<SpecCategoryMap, Long>)SpecCategoryMap::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", SpecCategoryMap::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<SpecCategoryMap, Long>)SpecCategoryMap::setModifiedBy);
		attributeGetterFunctions.put(
			"ipAddress", SpecCategoryMap::getIpAddress);
		attributeSetterBiConsumers.put(
			"ipAddress",
			(BiConsumer<SpecCategoryMap, String>)SpecCategoryMap::setIpAddress);

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
	public long getSpecCategoryMapId() {
		return _specCategoryMapId;
	}

	@Override
	public void setSpecCategoryMapId(long specCategoryMapId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_specCategoryMapId = specCategoryMapId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSpecificationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("specificationId"));
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_categoryId = categoryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCategoryId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("categoryId"));
	}

	@Override
	public boolean getIsCategoryMandatory() {
		return _isCategoryMandatory;
	}

	@Override
	public boolean isIsCategoryMandatory() {
		return _isCategoryMandatory;
	}

	@Override
	public void setIsCategoryMandatory(boolean isCategoryMandatory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isCategoryMandatory = isCategoryMandatory;
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
			PortalUtil.getClassNameId(SpecCategoryMap.class.getName()));
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
			getCompanyId(), SpecCategoryMap.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SpecCategoryMap toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SpecCategoryMap>
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
		SpecCategoryMapImpl specCategoryMapImpl = new SpecCategoryMapImpl();

		specCategoryMapImpl.setUuid(getUuid());
		specCategoryMapImpl.setSpecCategoryMapId(getSpecCategoryMapId());
		specCategoryMapImpl.setSpecificationId(getSpecificationId());
		specCategoryMapImpl.setCategoryId(getCategoryId());
		specCategoryMapImpl.setIsCategoryMandatory(isIsCategoryMandatory());
		specCategoryMapImpl.setCompanyId(getCompanyId());
		specCategoryMapImpl.setCreateDate(getCreateDate());
		specCategoryMapImpl.setModifiedDate(getModifiedDate());
		specCategoryMapImpl.setCreatedBy(getCreatedBy());
		specCategoryMapImpl.setModifiedBy(getModifiedBy());
		specCategoryMapImpl.setIpAddress(getIpAddress());

		specCategoryMapImpl.resetOriginalValues();

		return specCategoryMapImpl;
	}

	@Override
	public SpecCategoryMap cloneWithOriginalValues() {
		SpecCategoryMapImpl specCategoryMapImpl = new SpecCategoryMapImpl();

		specCategoryMapImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		specCategoryMapImpl.setSpecCategoryMapId(
			this.<Long>getColumnOriginalValue("specCategoryMapId"));
		specCategoryMapImpl.setSpecificationId(
			this.<Long>getColumnOriginalValue("specificationId"));
		specCategoryMapImpl.setCategoryId(
			this.<Long>getColumnOriginalValue("categoryId"));
		specCategoryMapImpl.setIsCategoryMandatory(
			this.<Boolean>getColumnOriginalValue("isCategoryMandatory"));
		specCategoryMapImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		specCategoryMapImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		specCategoryMapImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		specCategoryMapImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("createdBy"));
		specCategoryMapImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		specCategoryMapImpl.setIpAddress(
			this.<String>getColumnOriginalValue("ipAddress"));

		return specCategoryMapImpl;
	}

	@Override
	public int compareTo(SpecCategoryMap specCategoryMap) {
		long primaryKey = specCategoryMap.getPrimaryKey();

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

		if (!(object instanceof SpecCategoryMap)) {
			return false;
		}

		SpecCategoryMap specCategoryMap = (SpecCategoryMap)object;

		long primaryKey = specCategoryMap.getPrimaryKey();

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
	public CacheModel<SpecCategoryMap> toCacheModel() {
		SpecCategoryMapCacheModel specCategoryMapCacheModel =
			new SpecCategoryMapCacheModel();

		specCategoryMapCacheModel.uuid = getUuid();

		String uuid = specCategoryMapCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			specCategoryMapCacheModel.uuid = null;
		}

		specCategoryMapCacheModel.specCategoryMapId = getSpecCategoryMapId();

		specCategoryMapCacheModel.specificationId = getSpecificationId();

		specCategoryMapCacheModel.categoryId = getCategoryId();

		specCategoryMapCacheModel.isCategoryMandatory = isIsCategoryMandatory();

		specCategoryMapCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			specCategoryMapCacheModel.createDate = createDate.getTime();
		}
		else {
			specCategoryMapCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			specCategoryMapCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			specCategoryMapCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		specCategoryMapCacheModel.createdBy = getCreatedBy();

		specCategoryMapCacheModel.modifiedBy = getModifiedBy();

		specCategoryMapCacheModel.ipAddress = getIpAddress();

		String ipAddress = specCategoryMapCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			specCategoryMapCacheModel.ipAddress = null;
		}

		return specCategoryMapCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SpecCategoryMap, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SpecCategoryMap, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SpecCategoryMap, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((SpecCategoryMap)this);

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

		private static final Function<InvocationHandler, SpecCategoryMap>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					SpecCategoryMap.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _specCategoryMapId;
	private long _specificationId;
	private long _categoryId;
	private boolean _isCategoryMandatory;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private String _ipAddress;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SpecCategoryMap, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SpecCategoryMap)this);
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
		_columnOriginalValues.put("specCategoryMapId", _specCategoryMapId);
		_columnOriginalValues.put("specificationId", _specificationId);
		_columnOriginalValues.put("categoryId", _categoryId);
		_columnOriginalValues.put("isCategoryMandatory", _isCategoryMandatory);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("createdBy", _createdBy);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
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

		columnBitmasks.put("specCategoryMapId", 2L);

		columnBitmasks.put("specificationId", 4L);

		columnBitmasks.put("categoryId", 8L);

		columnBitmasks.put("isCategoryMandatory", 16L);

		columnBitmasks.put("companyId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("createdBy", 256L);

		columnBitmasks.put("modifiedBy", 512L);

		columnBitmasks.put("ipAddress", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SpecCategoryMap _escapedModel;

}