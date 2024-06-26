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

package com.marketplace.specification.field.data.type.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.marketplace.specification.field.data.type.model.SpecFieldDataType;
import com.marketplace.specification.field.data.type.model.SpecFieldDataTypeModel;

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
 * The base model implementation for the SpecFieldDataType service. Represents a row in the &quot;marketplace_specfielddatatype&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SpecFieldDataTypeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SpecFieldDataTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecFieldDataTypeImpl
 * @generated
 */
public class SpecFieldDataTypeModelImpl
	extends BaseModelImpl<SpecFieldDataType> implements SpecFieldDataTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a spec field data type model instance should use the <code>SpecFieldDataType</code> interface instead.
	 */
	public static final String TABLE_NAME = "marketplace_specfielddatatype";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"specFieldDataTypeId", Types.BIGINT},
		{"fieldDataTypeName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("specFieldDataTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fieldDataTypeName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table marketplace_specfielddatatype (uuid_ VARCHAR(75) null,specFieldDataTypeId LONG not null primary key,fieldDataTypeName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table marketplace_specfielddatatype";

	public static final String ORDER_BY_JPQL =
		" ORDER BY specFieldDataType.specFieldDataTypeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY marketplace_specfielddatatype.specFieldDataTypeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SPECFIELDDATATYPEID_COLUMN_BITMASK = 2L;

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

	public SpecFieldDataTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _specFieldDataTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpecFieldDataTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _specFieldDataTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SpecFieldDataType.class;
	}

	@Override
	public String getModelClassName() {
		return SpecFieldDataType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SpecFieldDataType, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SpecFieldDataType, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SpecFieldDataType, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SpecFieldDataType)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SpecFieldDataType, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SpecFieldDataType, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SpecFieldDataType)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SpecFieldDataType, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SpecFieldDataType, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SpecFieldDataType, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SpecFieldDataType, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SpecFieldDataType, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SpecFieldDataType, Object>>();
		Map<String, BiConsumer<SpecFieldDataType, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<SpecFieldDataType, ?>>();

		attributeGetterFunctions.put("uuid", SpecFieldDataType::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<SpecFieldDataType, String>)SpecFieldDataType::setUuid);
		attributeGetterFunctions.put(
			"specFieldDataTypeId", SpecFieldDataType::getSpecFieldDataTypeId);
		attributeSetterBiConsumers.put(
			"specFieldDataTypeId",
			(BiConsumer<SpecFieldDataType, Long>)
				SpecFieldDataType::setSpecFieldDataTypeId);
		attributeGetterFunctions.put(
			"fieldDataTypeName", SpecFieldDataType::getFieldDataTypeName);
		attributeSetterBiConsumers.put(
			"fieldDataTypeName",
			(BiConsumer<SpecFieldDataType, String>)
				SpecFieldDataType::setFieldDataTypeName);

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
	public long getSpecFieldDataTypeId() {
		return _specFieldDataTypeId;
	}

	@Override
	public void setSpecFieldDataTypeId(long specFieldDataTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_specFieldDataTypeId = specFieldDataTypeId;
	}

	@Override
	public String getFieldDataTypeName() {
		if (_fieldDataTypeName == null) {
			return "";
		}
		else {
			return _fieldDataTypeName;
		}
	}

	@Override
	public void setFieldDataTypeName(String fieldDataTypeName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldDataTypeName = fieldDataTypeName;
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
			0, SpecFieldDataType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SpecFieldDataType toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SpecFieldDataType>
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
		SpecFieldDataTypeImpl specFieldDataTypeImpl =
			new SpecFieldDataTypeImpl();

		specFieldDataTypeImpl.setUuid(getUuid());
		specFieldDataTypeImpl.setSpecFieldDataTypeId(getSpecFieldDataTypeId());
		specFieldDataTypeImpl.setFieldDataTypeName(getFieldDataTypeName());

		specFieldDataTypeImpl.resetOriginalValues();

		return specFieldDataTypeImpl;
	}

	@Override
	public SpecFieldDataType cloneWithOriginalValues() {
		SpecFieldDataTypeImpl specFieldDataTypeImpl =
			new SpecFieldDataTypeImpl();

		specFieldDataTypeImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		specFieldDataTypeImpl.setSpecFieldDataTypeId(
			this.<Long>getColumnOriginalValue("specFieldDataTypeId"));
		specFieldDataTypeImpl.setFieldDataTypeName(
			this.<String>getColumnOriginalValue("fieldDataTypeName"));

		return specFieldDataTypeImpl;
	}

	@Override
	public int compareTo(SpecFieldDataType specFieldDataType) {
		long primaryKey = specFieldDataType.getPrimaryKey();

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

		if (!(object instanceof SpecFieldDataType)) {
			return false;
		}

		SpecFieldDataType specFieldDataType = (SpecFieldDataType)object;

		long primaryKey = specFieldDataType.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<SpecFieldDataType> toCacheModel() {
		SpecFieldDataTypeCacheModel specFieldDataTypeCacheModel =
			new SpecFieldDataTypeCacheModel();

		specFieldDataTypeCacheModel.uuid = getUuid();

		String uuid = specFieldDataTypeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			specFieldDataTypeCacheModel.uuid = null;
		}

		specFieldDataTypeCacheModel.specFieldDataTypeId =
			getSpecFieldDataTypeId();

		specFieldDataTypeCacheModel.fieldDataTypeName = getFieldDataTypeName();

		String fieldDataTypeName =
			specFieldDataTypeCacheModel.fieldDataTypeName;

		if ((fieldDataTypeName != null) && (fieldDataTypeName.length() == 0)) {
			specFieldDataTypeCacheModel.fieldDataTypeName = null;
		}

		return specFieldDataTypeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SpecFieldDataType, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SpecFieldDataType, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SpecFieldDataType, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(SpecFieldDataType)this);

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

		private static final Function<InvocationHandler, SpecFieldDataType>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					SpecFieldDataType.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _specFieldDataTypeId;
	private String _fieldDataTypeName;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SpecFieldDataType, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SpecFieldDataType)this);
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
		_columnOriginalValues.put("specFieldDataTypeId", _specFieldDataTypeId);
		_columnOriginalValues.put("fieldDataTypeName", _fieldDataTypeName);
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

		columnBitmasks.put("specFieldDataTypeId", 2L);

		columnBitmasks.put("fieldDataTypeName", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SpecFieldDataType _escapedModel;

}