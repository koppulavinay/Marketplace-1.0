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

package com.marketplace.product.variant.master.model.impl;

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

import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.model.ProductVariantModel;

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
 * The base model implementation for the ProductVariant service. Represents a row in the &quot;marketplace_product_variant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductVariantModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductVariantImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariantImpl
 * @generated
 */
public class ProductVariantModelImpl
	extends BaseModelImpl<ProductVariant> implements ProductVariantModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product variant model instance should use the <code>ProductVariant</code> interface instead.
	 */
	public static final String TABLE_NAME = "marketplace_product_variant";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"productVariantId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"draftProductId", Types.BIGINT},
		{"variantName", Types.VARCHAR}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"createdBy", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"modifiedBy", Types.BIGINT},
		{"ipAddress", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productVariantId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("draftProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("variantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table marketplace_product_variant (uuid_ VARCHAR(75) null,productVariantId LONG not null primary key,groupId LONG,draftProductId LONG,variantName VARCHAR(75) null,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG,ipAddress VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table marketplace_product_variant";

	public static final String ORDER_BY_JPQL =
		" ORDER BY productVariant.productVariantId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY marketplace_product_variant.productVariantId ASC";

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
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VARIANTNAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRODUCTVARIANTID_COLUMN_BITMASK = 32L;

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

	public ProductVariantModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productVariantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductVariantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productVariantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProductVariant.class;
	}

	@Override
	public String getModelClassName() {
		return ProductVariant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProductVariant, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProductVariant, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductVariant, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProductVariant)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProductVariant, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProductVariant, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProductVariant)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProductVariant, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProductVariant, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ProductVariant, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProductVariant, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProductVariant, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ProductVariant, Object>>();
		Map<String, BiConsumer<ProductVariant, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProductVariant, ?>>();

		attributeGetterFunctions.put("uuid", ProductVariant::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProductVariant, String>)ProductVariant::setUuid);
		attributeGetterFunctions.put(
			"productVariantId", ProductVariant::getProductVariantId);
		attributeSetterBiConsumers.put(
			"productVariantId",
			(BiConsumer<ProductVariant, Long>)
				ProductVariant::setProductVariantId);
		attributeGetterFunctions.put("groupId", ProductVariant::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProductVariant, Long>)ProductVariant::setGroupId);
		attributeGetterFunctions.put(
			"draftProductId", ProductVariant::getDraftProductId);
		attributeSetterBiConsumers.put(
			"draftProductId",
			(BiConsumer<ProductVariant, Long>)
				ProductVariant::setDraftProductId);
		attributeGetterFunctions.put(
			"variantName", ProductVariant::getVariantName);
		attributeSetterBiConsumers.put(
			"variantName",
			(BiConsumer<ProductVariant, String>)ProductVariant::setVariantName);
		attributeGetterFunctions.put("companyId", ProductVariant::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProductVariant, Long>)ProductVariant::setCompanyId);
		attributeGetterFunctions.put("userId", ProductVariant::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProductVariant, Long>)ProductVariant::setUserId);
		attributeGetterFunctions.put("userName", ProductVariant::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProductVariant, String>)ProductVariant::setUserName);
		attributeGetterFunctions.put(
			"createDate", ProductVariant::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProductVariant, Date>)ProductVariant::setCreateDate);
		attributeGetterFunctions.put("createdBy", ProductVariant::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProductVariant, Long>)ProductVariant::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate", ProductVariant::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProductVariant, Date>)ProductVariant::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", ProductVariant::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProductVariant, Long>)ProductVariant::setModifiedBy);
		attributeGetterFunctions.put("ipAddress", ProductVariant::getIpAddress);
		attributeSetterBiConsumers.put(
			"ipAddress",
			(BiConsumer<ProductVariant, String>)ProductVariant::setIpAddress);

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
	public long getProductVariantId() {
		return _productVariantId;
	}

	@Override
	public void setProductVariantId(long productVariantId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_productVariantId = productVariantId;
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
	public String getVariantName() {
		if (_variantName == null) {
			return "";
		}
		else {
			return _variantName;
		}
	}

	@Override
	public void setVariantName(String variantName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_variantName = variantName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalVariantName() {
		return getColumnOriginalValue("variantName");
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
			PortalUtil.getClassNameId(ProductVariant.class.getName()));
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
			getCompanyId(), ProductVariant.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProductVariant toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProductVariant>
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
		ProductVariantImpl productVariantImpl = new ProductVariantImpl();

		productVariantImpl.setUuid(getUuid());
		productVariantImpl.setProductVariantId(getProductVariantId());
		productVariantImpl.setGroupId(getGroupId());
		productVariantImpl.setDraftProductId(getDraftProductId());
		productVariantImpl.setVariantName(getVariantName());
		productVariantImpl.setCompanyId(getCompanyId());
		productVariantImpl.setUserId(getUserId());
		productVariantImpl.setUserName(getUserName());
		productVariantImpl.setCreateDate(getCreateDate());
		productVariantImpl.setCreatedBy(getCreatedBy());
		productVariantImpl.setModifiedDate(getModifiedDate());
		productVariantImpl.setModifiedBy(getModifiedBy());
		productVariantImpl.setIpAddress(getIpAddress());

		productVariantImpl.resetOriginalValues();

		return productVariantImpl;
	}

	@Override
	public ProductVariant cloneWithOriginalValues() {
		ProductVariantImpl productVariantImpl = new ProductVariantImpl();

		productVariantImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		productVariantImpl.setProductVariantId(
			this.<Long>getColumnOriginalValue("productVariantId"));
		productVariantImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		productVariantImpl.setDraftProductId(
			this.<Long>getColumnOriginalValue("draftProductId"));
		productVariantImpl.setVariantName(
			this.<String>getColumnOriginalValue("variantName"));
		productVariantImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		productVariantImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		productVariantImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		productVariantImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		productVariantImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("createdBy"));
		productVariantImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		productVariantImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		productVariantImpl.setIpAddress(
			this.<String>getColumnOriginalValue("ipAddress"));

		return productVariantImpl;
	}

	@Override
	public int compareTo(ProductVariant productVariant) {
		long primaryKey = productVariant.getPrimaryKey();

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

		if (!(object instanceof ProductVariant)) {
			return false;
		}

		ProductVariant productVariant = (ProductVariant)object;

		long primaryKey = productVariant.getPrimaryKey();

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
	public CacheModel<ProductVariant> toCacheModel() {
		ProductVariantCacheModel productVariantCacheModel =
			new ProductVariantCacheModel();

		productVariantCacheModel.uuid = getUuid();

		String uuid = productVariantCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			productVariantCacheModel.uuid = null;
		}

		productVariantCacheModel.productVariantId = getProductVariantId();

		productVariantCacheModel.groupId = getGroupId();

		productVariantCacheModel.draftProductId = getDraftProductId();

		productVariantCacheModel.variantName = getVariantName();

		String variantName = productVariantCacheModel.variantName;

		if ((variantName != null) && (variantName.length() == 0)) {
			productVariantCacheModel.variantName = null;
		}

		productVariantCacheModel.companyId = getCompanyId();

		productVariantCacheModel.userId = getUserId();

		productVariantCacheModel.userName = getUserName();

		String userName = productVariantCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			productVariantCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			productVariantCacheModel.createDate = createDate.getTime();
		}
		else {
			productVariantCacheModel.createDate = Long.MIN_VALUE;
		}

		productVariantCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productVariantCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			productVariantCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		productVariantCacheModel.modifiedBy = getModifiedBy();

		productVariantCacheModel.ipAddress = getIpAddress();

		String ipAddress = productVariantCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			productVariantCacheModel.ipAddress = null;
		}

		return productVariantCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProductVariant, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProductVariant, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductVariant, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ProductVariant)this);

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

		private static final Function<InvocationHandler, ProductVariant>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ProductVariant.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _productVariantId;
	private long _groupId;
	private long _draftProductId;
	private String _variantName;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private String _ipAddress;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProductVariant, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProductVariant)this);
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
		_columnOriginalValues.put("productVariantId", _productVariantId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("draftProductId", _draftProductId);
		_columnOriginalValues.put("variantName", _variantName);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("createdBy", _createdBy);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
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

		columnBitmasks.put("productVariantId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("draftProductId", 8L);

		columnBitmasks.put("variantName", 16L);

		columnBitmasks.put("companyId", 32L);

		columnBitmasks.put("userId", 64L);

		columnBitmasks.put("userName", 128L);

		columnBitmasks.put("createDate", 256L);

		columnBitmasks.put("createdBy", 512L);

		columnBitmasks.put("modifiedDate", 1024L);

		columnBitmasks.put("modifiedBy", 2048L);

		columnBitmasks.put("ipAddress", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProductVariant _escapedModel;

}