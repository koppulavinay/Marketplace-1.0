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

package com.marketplace.specification.field.data.type.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.marketplace.specification.field.data.type.exception.NoSuchSpecFieldDataTypeException;
import com.marketplace.specification.field.data.type.model.SpecFieldDataType;
import com.marketplace.specification.field.data.type.model.SpecFieldDataTypeTable;
import com.marketplace.specification.field.data.type.model.impl.SpecFieldDataTypeImpl;
import com.marketplace.specification.field.data.type.model.impl.SpecFieldDataTypeModelImpl;
import com.marketplace.specification.field.data.type.service.persistence.SpecFieldDataTypePersistence;
import com.marketplace.specification.field.data.type.service.persistence.SpecFieldDataTypeUtil;
import com.marketplace.specification.field.data.type.service.persistence.impl.constants.marketplacePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the spec field data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecFieldDataTypePersistence.class)
public class SpecFieldDataTypePersistenceImpl
	extends BasePersistenceImpl<SpecFieldDataType>
	implements SpecFieldDataTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecFieldDataTypeUtil</code> to access the spec field data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecFieldDataTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of matching spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec field data types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<SpecFieldDataType> list = null;

		if (useFinderCache) {
			list = (List<SpecFieldDataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecFieldDataType specFieldDataType : list) {
					if (!uuid.equals(specFieldDataType.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SPECFIELDDATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecFieldDataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<SpecFieldDataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	@Override
	public SpecFieldDataType findByUuid_First(
			String uuid, OrderByComparator<SpecFieldDataType> orderByComparator)
		throws NoSuchSpecFieldDataTypeException {

		SpecFieldDataType specFieldDataType = fetchByUuid_First(
			uuid, orderByComparator);

		if (specFieldDataType != null) {
			return specFieldDataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecFieldDataTypeException(sb.toString());
	}

	/**
	 * Returns the first spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	@Override
	public SpecFieldDataType fetchByUuid_First(
		String uuid, OrderByComparator<SpecFieldDataType> orderByComparator) {

		List<SpecFieldDataType> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a matching spec field data type could not be found
	 */
	@Override
	public SpecFieldDataType findByUuid_Last(
			String uuid, OrderByComparator<SpecFieldDataType> orderByComparator)
		throws NoSuchSpecFieldDataTypeException {

		SpecFieldDataType specFieldDataType = fetchByUuid_Last(
			uuid, orderByComparator);

		if (specFieldDataType != null) {
			return specFieldDataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecFieldDataTypeException(sb.toString());
	}

	/**
	 * Returns the last spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field data type, or <code>null</code> if a matching spec field data type could not be found
	 */
	@Override
	public SpecFieldDataType fetchByUuid_Last(
		String uuid, OrderByComparator<SpecFieldDataType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SpecFieldDataType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec field data types before and after the current spec field data type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldDataTypeId the primary key of the current spec field data type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType[] findByUuid_PrevAndNext(
			long specFieldDataTypeId, String uuid,
			OrderByComparator<SpecFieldDataType> orderByComparator)
		throws NoSuchSpecFieldDataTypeException {

		uuid = Objects.toString(uuid, "");

		SpecFieldDataType specFieldDataType = findByPrimaryKey(
			specFieldDataTypeId);

		Session session = null;

		try {
			session = openSession();

			SpecFieldDataType[] array = new SpecFieldDataTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, specFieldDataType, uuid, orderByComparator, true);

			array[1] = specFieldDataType;

			array[2] = getByUuid_PrevAndNext(
				session, specFieldDataType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecFieldDataType getByUuid_PrevAndNext(
		Session session, SpecFieldDataType specFieldDataType, String uuid,
		OrderByComparator<SpecFieldDataType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECFIELDDATATYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SpecFieldDataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specFieldDataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecFieldDataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec field data types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SpecFieldDataType specFieldDataType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specFieldDataType);
		}
	}

	/**
	 * Returns the number of spec field data types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field data types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECFIELDDATATYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"specFieldDataType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(specFieldDataType.uuid IS NULL OR specFieldDataType.uuid = '')";

	public SpecFieldDataTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SpecFieldDataType.class);

		setModelImplClass(SpecFieldDataTypeImpl.class);
		setModelPKClass(long.class);

		setTable(SpecFieldDataTypeTable.INSTANCE);
	}

	/**
	 * Caches the spec field data type in the entity cache if it is enabled.
	 *
	 * @param specFieldDataType the spec field data type
	 */
	@Override
	public void cacheResult(SpecFieldDataType specFieldDataType) {
		entityCache.putResult(
			SpecFieldDataTypeImpl.class, specFieldDataType.getPrimaryKey(),
			specFieldDataType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the spec field data types in the entity cache if it is enabled.
	 *
	 * @param specFieldDataTypes the spec field data types
	 */
	@Override
	public void cacheResult(List<SpecFieldDataType> specFieldDataTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specFieldDataTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SpecFieldDataType specFieldDataType : specFieldDataTypes) {
			if (entityCache.getResult(
					SpecFieldDataTypeImpl.class,
					specFieldDataType.getPrimaryKey()) == null) {

				cacheResult(specFieldDataType);
			}
		}
	}

	/**
	 * Clears the cache for all spec field data types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecFieldDataTypeImpl.class);

		finderCache.clearCache(SpecFieldDataTypeImpl.class);
	}

	/**
	 * Clears the cache for the spec field data type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpecFieldDataType specFieldDataType) {
		entityCache.removeResult(
			SpecFieldDataTypeImpl.class, specFieldDataType);
	}

	@Override
	public void clearCache(List<SpecFieldDataType> specFieldDataTypes) {
		for (SpecFieldDataType specFieldDataType : specFieldDataTypes) {
			entityCache.removeResult(
				SpecFieldDataTypeImpl.class, specFieldDataType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecFieldDataTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecFieldDataTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new spec field data type with the primary key. Does not add the spec field data type to the database.
	 *
	 * @param specFieldDataTypeId the primary key for the new spec field data type
	 * @return the new spec field data type
	 */
	@Override
	public SpecFieldDataType create(long specFieldDataTypeId) {
		SpecFieldDataType specFieldDataType = new SpecFieldDataTypeImpl();

		specFieldDataType.setNew(true);
		specFieldDataType.setPrimaryKey(specFieldDataTypeId);

		String uuid = _portalUUID.generate();

		specFieldDataType.setUuid(uuid);

		return specFieldDataType;
	}

	/**
	 * Removes the spec field data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type that was removed
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType remove(long specFieldDataTypeId)
		throws NoSuchSpecFieldDataTypeException {

		return remove((Serializable)specFieldDataTypeId);
	}

	/**
	 * Removes the spec field data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the spec field data type
	 * @return the spec field data type that was removed
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType remove(Serializable primaryKey)
		throws NoSuchSpecFieldDataTypeException {

		Session session = null;

		try {
			session = openSession();

			SpecFieldDataType specFieldDataType =
				(SpecFieldDataType)session.get(
					SpecFieldDataTypeImpl.class, primaryKey);

			if (specFieldDataType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecFieldDataTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specFieldDataType);
		}
		catch (NoSuchSpecFieldDataTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SpecFieldDataType removeImpl(
		SpecFieldDataType specFieldDataType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specFieldDataType)) {
				specFieldDataType = (SpecFieldDataType)session.get(
					SpecFieldDataTypeImpl.class,
					specFieldDataType.getPrimaryKeyObj());
			}

			if (specFieldDataType != null) {
				session.delete(specFieldDataType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specFieldDataType != null) {
			clearCache(specFieldDataType);
		}

		return specFieldDataType;
	}

	@Override
	public SpecFieldDataType updateImpl(SpecFieldDataType specFieldDataType) {
		boolean isNew = specFieldDataType.isNew();

		if (!(specFieldDataType instanceof SpecFieldDataTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specFieldDataType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specFieldDataType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specFieldDataType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SpecFieldDataType implementation " +
					specFieldDataType.getClass());
		}

		SpecFieldDataTypeModelImpl specFieldDataTypeModelImpl =
			(SpecFieldDataTypeModelImpl)specFieldDataType;

		if (Validator.isNull(specFieldDataType.getUuid())) {
			String uuid = _portalUUID.generate();

			specFieldDataType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specFieldDataType);
			}
			else {
				specFieldDataType = (SpecFieldDataType)session.merge(
					specFieldDataType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecFieldDataTypeImpl.class, specFieldDataTypeModelImpl, false,
			true);

		if (isNew) {
			specFieldDataType.setNew(false);
		}

		specFieldDataType.resetOriginalValues();

		return specFieldDataType;
	}

	/**
	 * Returns the spec field data type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the spec field data type
	 * @return the spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecFieldDataTypeException {

		SpecFieldDataType specFieldDataType = fetchByPrimaryKey(primaryKey);

		if (specFieldDataType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecFieldDataTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specFieldDataType;
	}

	/**
	 * Returns the spec field data type with the primary key or throws a <code>NoSuchSpecFieldDataTypeException</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type
	 * @throws NoSuchSpecFieldDataTypeException if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType findByPrimaryKey(long specFieldDataTypeId)
		throws NoSuchSpecFieldDataTypeException {

		return findByPrimaryKey((Serializable)specFieldDataTypeId);
	}

	/**
	 * Returns the spec field data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldDataTypeId the primary key of the spec field data type
	 * @return the spec field data type, or <code>null</code> if a spec field data type with the primary key could not be found
	 */
	@Override
	public SpecFieldDataType fetchByPrimaryKey(long specFieldDataTypeId) {
		return fetchByPrimaryKey((Serializable)specFieldDataTypeId);
	}

	/**
	 * Returns all the spec field data types.
	 *
	 * @return the spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @return the range of spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec field data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldDataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field data types
	 * @param end the upper bound of the range of spec field data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field data types
	 */
	@Override
	public List<SpecFieldDataType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldDataType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SpecFieldDataType> list = null;

		if (useFinderCache) {
			list = (List<SpecFieldDataType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECFIELDDATATYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECFIELDDATATYPE;

				sql = sql.concat(SpecFieldDataTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SpecFieldDataType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the spec field data types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SpecFieldDataType specFieldDataType : findAll()) {
			remove(specFieldDataType);
		}
	}

	/**
	 * Returns the number of spec field data types.
	 *
	 * @return the number of spec field data types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECFIELDDATATYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "specFieldDataTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECFIELDDATATYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecFieldDataTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the spec field data type persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setSpecFieldDataTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecFieldDataTypeUtilPersistence(null);

		entityCache.removeCache(SpecFieldDataTypeImpl.class.getName());
	}

	private void _setSpecFieldDataTypeUtilPersistence(
		SpecFieldDataTypePersistence specFieldDataTypePersistence) {

		try {
			Field field = SpecFieldDataTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specFieldDataTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplacePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplacePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplacePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SPECFIELDDATATYPE =
		"SELECT specFieldDataType FROM SpecFieldDataType specFieldDataType";

	private static final String _SQL_SELECT_SPECFIELDDATATYPE_WHERE =
		"SELECT specFieldDataType FROM SpecFieldDataType specFieldDataType WHERE ";

	private static final String _SQL_COUNT_SPECFIELDDATATYPE =
		"SELECT COUNT(specFieldDataType) FROM SpecFieldDataType specFieldDataType";

	private static final String _SQL_COUNT_SPECFIELDDATATYPE_WHERE =
		"SELECT COUNT(specFieldDataType) FROM SpecFieldDataType specFieldDataType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specFieldDataType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SpecFieldDataType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SpecFieldDataType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecFieldDataTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}