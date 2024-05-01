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

package com.marketplace.specification.field.type.service.persistence.impl;

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

import com.marketplace.specification.field.type.exception.NoSuchSpecFieldTypeException;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.model.SpecFieldTypeTable;
import com.marketplace.specification.field.type.model.impl.SpecFieldTypeImpl;
import com.marketplace.specification.field.type.model.impl.SpecFieldTypeModelImpl;
import com.marketplace.specification.field.type.service.persistence.SpecFieldTypePersistence;
import com.marketplace.specification.field.type.service.persistence.SpecFieldTypeUtil;
import com.marketplace.specification.field.type.service.persistence.impl.constants.marketplacePersistenceConstants;

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
 * The persistence implementation for the spec field type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecFieldTypePersistence.class)
public class SpecFieldTypePersistenceImpl
	extends BasePersistenceImpl<SpecFieldType>
	implements SpecFieldTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecFieldTypeUtil</code> to access the spec field type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecFieldTypeImpl.class.getName();

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
	 * Returns all the spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec field types
	 */
	@Override
	public List<SpecFieldType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of matching spec field types
	 */
	@Override
	public List<SpecFieldType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec field types
	 */
	@Override
	public List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec field types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec field types
	 */
	@Override
	public List<SpecFieldType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator,
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

		List<SpecFieldType> list = null;

		if (useFinderCache) {
			list = (List<SpecFieldType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecFieldType specFieldType : list) {
					if (!uuid.equals(specFieldType.getUuid())) {
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

			sb.append(_SQL_SELECT_SPECFIELDTYPE_WHERE);

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
				sb.append(SpecFieldTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<SpecFieldType>)QueryUtil.list(
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
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	@Override
	public SpecFieldType findByUuid_First(
			String uuid, OrderByComparator<SpecFieldType> orderByComparator)
		throws NoSuchSpecFieldTypeException {

		SpecFieldType specFieldType = fetchByUuid_First(
			uuid, orderByComparator);

		if (specFieldType != null) {
			return specFieldType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecFieldTypeException(sb.toString());
	}

	/**
	 * Returns the first spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	@Override
	public SpecFieldType fetchByUuid_First(
		String uuid, OrderByComparator<SpecFieldType> orderByComparator) {

		List<SpecFieldType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type
	 * @throws NoSuchSpecFieldTypeException if a matching spec field type could not be found
	 */
	@Override
	public SpecFieldType findByUuid_Last(
			String uuid, OrderByComparator<SpecFieldType> orderByComparator)
		throws NoSuchSpecFieldTypeException {

		SpecFieldType specFieldType = fetchByUuid_Last(uuid, orderByComparator);

		if (specFieldType != null) {
			return specFieldType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecFieldTypeException(sb.toString());
	}

	/**
	 * Returns the last spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec field type, or <code>null</code> if a matching spec field type could not be found
	 */
	@Override
	public SpecFieldType fetchByUuid_Last(
		String uuid, OrderByComparator<SpecFieldType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SpecFieldType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec field types before and after the current spec field type in the ordered set where uuid = &#63;.
	 *
	 * @param specFieldTypeId the primary key of the current spec field type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType[] findByUuid_PrevAndNext(
			long specFieldTypeId, String uuid,
			OrderByComparator<SpecFieldType> orderByComparator)
		throws NoSuchSpecFieldTypeException {

		uuid = Objects.toString(uuid, "");

		SpecFieldType specFieldType = findByPrimaryKey(specFieldTypeId);

		Session session = null;

		try {
			session = openSession();

			SpecFieldType[] array = new SpecFieldTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, specFieldType, uuid, orderByComparator, true);

			array[1] = specFieldType;

			array[2] = getByUuid_PrevAndNext(
				session, specFieldType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecFieldType getByUuid_PrevAndNext(
		Session session, SpecFieldType specFieldType, String uuid,
		OrderByComparator<SpecFieldType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECFIELDTYPE_WHERE);

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
			sb.append(SpecFieldTypeModelImpl.ORDER_BY_JPQL);
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
						specFieldType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecFieldType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec field types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SpecFieldType specFieldType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specFieldType);
		}
	}

	/**
	 * Returns the number of spec field types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec field types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECFIELDTYPE_WHERE);

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
		"specFieldType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(specFieldType.uuid IS NULL OR specFieldType.uuid = '')";

	public SpecFieldTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SpecFieldType.class);

		setModelImplClass(SpecFieldTypeImpl.class);
		setModelPKClass(long.class);

		setTable(SpecFieldTypeTable.INSTANCE);
	}

	/**
	 * Caches the spec field type in the entity cache if it is enabled.
	 *
	 * @param specFieldType the spec field type
	 */
	@Override
	public void cacheResult(SpecFieldType specFieldType) {
		entityCache.putResult(
			SpecFieldTypeImpl.class, specFieldType.getPrimaryKey(),
			specFieldType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the spec field types in the entity cache if it is enabled.
	 *
	 * @param specFieldTypes the spec field types
	 */
	@Override
	public void cacheResult(List<SpecFieldType> specFieldTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specFieldTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SpecFieldType specFieldType : specFieldTypes) {
			if (entityCache.getResult(
					SpecFieldTypeImpl.class, specFieldType.getPrimaryKey()) ==
						null) {

				cacheResult(specFieldType);
			}
		}
	}

	/**
	 * Clears the cache for all spec field types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecFieldTypeImpl.class);

		finderCache.clearCache(SpecFieldTypeImpl.class);
	}

	/**
	 * Clears the cache for the spec field type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpecFieldType specFieldType) {
		entityCache.removeResult(SpecFieldTypeImpl.class, specFieldType);
	}

	@Override
	public void clearCache(List<SpecFieldType> specFieldTypes) {
		for (SpecFieldType specFieldType : specFieldTypes) {
			entityCache.removeResult(SpecFieldTypeImpl.class, specFieldType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecFieldTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecFieldTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new spec field type with the primary key. Does not add the spec field type to the database.
	 *
	 * @param specFieldTypeId the primary key for the new spec field type
	 * @return the new spec field type
	 */
	@Override
	public SpecFieldType create(long specFieldTypeId) {
		SpecFieldType specFieldType = new SpecFieldTypeImpl();

		specFieldType.setNew(true);
		specFieldType.setPrimaryKey(specFieldTypeId);

		String uuid = _portalUUID.generate();

		specFieldType.setUuid(uuid);

		return specFieldType;
	}

	/**
	 * Removes the spec field type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type that was removed
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType remove(long specFieldTypeId)
		throws NoSuchSpecFieldTypeException {

		return remove((Serializable)specFieldTypeId);
	}

	/**
	 * Removes the spec field type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the spec field type
	 * @return the spec field type that was removed
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType remove(Serializable primaryKey)
		throws NoSuchSpecFieldTypeException {

		Session session = null;

		try {
			session = openSession();

			SpecFieldType specFieldType = (SpecFieldType)session.get(
				SpecFieldTypeImpl.class, primaryKey);

			if (specFieldType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecFieldTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specFieldType);
		}
		catch (NoSuchSpecFieldTypeException noSuchEntityException) {
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
	protected SpecFieldType removeImpl(SpecFieldType specFieldType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specFieldType)) {
				specFieldType = (SpecFieldType)session.get(
					SpecFieldTypeImpl.class, specFieldType.getPrimaryKeyObj());
			}

			if (specFieldType != null) {
				session.delete(specFieldType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specFieldType != null) {
			clearCache(specFieldType);
		}

		return specFieldType;
	}

	@Override
	public SpecFieldType updateImpl(SpecFieldType specFieldType) {
		boolean isNew = specFieldType.isNew();

		if (!(specFieldType instanceof SpecFieldTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specFieldType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specFieldType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specFieldType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SpecFieldType implementation " +
					specFieldType.getClass());
		}

		SpecFieldTypeModelImpl specFieldTypeModelImpl =
			(SpecFieldTypeModelImpl)specFieldType;

		if (Validator.isNull(specFieldType.getUuid())) {
			String uuid = _portalUUID.generate();

			specFieldType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specFieldType);
			}
			else {
				specFieldType = (SpecFieldType)session.merge(specFieldType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecFieldTypeImpl.class, specFieldTypeModelImpl, false, true);

		if (isNew) {
			specFieldType.setNew(false);
		}

		specFieldType.resetOriginalValues();

		return specFieldType;
	}

	/**
	 * Returns the spec field type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the spec field type
	 * @return the spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecFieldTypeException {

		SpecFieldType specFieldType = fetchByPrimaryKey(primaryKey);

		if (specFieldType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecFieldTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specFieldType;
	}

	/**
	 * Returns the spec field type with the primary key or throws a <code>NoSuchSpecFieldTypeException</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type
	 * @throws NoSuchSpecFieldTypeException if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType findByPrimaryKey(long specFieldTypeId)
		throws NoSuchSpecFieldTypeException {

		return findByPrimaryKey((Serializable)specFieldTypeId);
	}

	/**
	 * Returns the spec field type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specFieldTypeId the primary key of the spec field type
	 * @return the spec field type, or <code>null</code> if a spec field type with the primary key could not be found
	 */
	@Override
	public SpecFieldType fetchByPrimaryKey(long specFieldTypeId) {
		return fetchByPrimaryKey((Serializable)specFieldTypeId);
	}

	/**
	 * Returns all the spec field types.
	 *
	 * @return the spec field types
	 */
	@Override
	public List<SpecFieldType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @return the range of spec field types
	 */
	@Override
	public List<SpecFieldType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec field types
	 */
	@Override
	public List<SpecFieldType> findAll(
		int start, int end,
		OrderByComparator<SpecFieldType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec field types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecFieldTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec field types
	 * @param end the upper bound of the range of spec field types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec field types
	 */
	@Override
	public List<SpecFieldType> findAll(
		int start, int end, OrderByComparator<SpecFieldType> orderByComparator,
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

		List<SpecFieldType> list = null;

		if (useFinderCache) {
			list = (List<SpecFieldType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECFIELDTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECFIELDTYPE;

				sql = sql.concat(SpecFieldTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SpecFieldType>)QueryUtil.list(
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
	 * Removes all the spec field types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SpecFieldType specFieldType : findAll()) {
			remove(specFieldType);
		}
	}

	/**
	 * Returns the number of spec field types.
	 *
	 * @return the number of spec field types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECFIELDTYPE);

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
		return "specFieldTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECFIELDTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecFieldTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the spec field type persistence.
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

		_setSpecFieldTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecFieldTypeUtilPersistence(null);

		entityCache.removeCache(SpecFieldTypeImpl.class.getName());
	}

	private void _setSpecFieldTypeUtilPersistence(
		SpecFieldTypePersistence specFieldTypePersistence) {

		try {
			Field field = SpecFieldTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specFieldTypePersistence);
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

	private static final String _SQL_SELECT_SPECFIELDTYPE =
		"SELECT specFieldType FROM SpecFieldType specFieldType";

	private static final String _SQL_SELECT_SPECFIELDTYPE_WHERE =
		"SELECT specFieldType FROM SpecFieldType specFieldType WHERE ";

	private static final String _SQL_COUNT_SPECFIELDTYPE =
		"SELECT COUNT(specFieldType) FROM SpecFieldType specFieldType";

	private static final String _SQL_COUNT_SPECFIELDTYPE_WHERE =
		"SELECT COUNT(specFieldType) FROM SpecFieldType specFieldType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specFieldType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SpecFieldType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SpecFieldType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecFieldTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}