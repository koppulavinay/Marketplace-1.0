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

package com.marketplace.specification.value.uoms.service.persistence.impl;

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

import com.marketplace.specification.value.uoms.exception.NoSuchSpecValueUomException;
import com.marketplace.specification.value.uoms.model.SpecValueUom;
import com.marketplace.specification.value.uoms.model.SpecValueUomTable;
import com.marketplace.specification.value.uoms.model.impl.SpecValueUomImpl;
import com.marketplace.specification.value.uoms.model.impl.SpecValueUomModelImpl;
import com.marketplace.specification.value.uoms.service.persistence.SpecValueUomPersistence;
import com.marketplace.specification.value.uoms.service.persistence.SpecValueUomUtil;
import com.marketplace.specification.value.uoms.service.persistence.impl.constants.marketplacePersistenceConstants;

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
 * The persistence implementation for the spec value uom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecValueUomPersistence.class)
public class SpecValueUomPersistenceImpl
	extends BasePersistenceImpl<SpecValueUom>
	implements SpecValueUomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecValueUomUtil</code> to access the spec value uom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecValueUomImpl.class.getName();

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
	 * Returns all the spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec value uoms
	 */
	@Override
	public List<SpecValueUom> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of matching spec value uoms
	 */
	@Override
	public List<SpecValueUom> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec value uoms
	 */
	@Override
	public List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecValueUom> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec value uoms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec value uoms
	 */
	@Override
	public List<SpecValueUom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecValueUom> orderByComparator,
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

		List<SpecValueUom> list = null;

		if (useFinderCache) {
			list = (List<SpecValueUom>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecValueUom specValueUom : list) {
					if (!uuid.equals(specValueUom.getUuid())) {
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

			sb.append(_SQL_SELECT_SPECVALUEUOM_WHERE);

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
				sb.append(SpecValueUomModelImpl.ORDER_BY_JPQL);
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

				list = (List<SpecValueUom>)QueryUtil.list(
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
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	@Override
	public SpecValueUom findByUuid_First(
			String uuid, OrderByComparator<SpecValueUom> orderByComparator)
		throws NoSuchSpecValueUomException {

		SpecValueUom specValueUom = fetchByUuid_First(uuid, orderByComparator);

		if (specValueUom != null) {
			return specValueUom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecValueUomException(sb.toString());
	}

	/**
	 * Returns the first spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	@Override
	public SpecValueUom fetchByUuid_First(
		String uuid, OrderByComparator<SpecValueUom> orderByComparator) {

		List<SpecValueUom> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom
	 * @throws NoSuchSpecValueUomException if a matching spec value uom could not be found
	 */
	@Override
	public SpecValueUom findByUuid_Last(
			String uuid, OrderByComparator<SpecValueUom> orderByComparator)
		throws NoSuchSpecValueUomException {

		SpecValueUom specValueUom = fetchByUuid_Last(uuid, orderByComparator);

		if (specValueUom != null) {
			return specValueUom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecValueUomException(sb.toString());
	}

	/**
	 * Returns the last spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec value uom, or <code>null</code> if a matching spec value uom could not be found
	 */
	@Override
	public SpecValueUom fetchByUuid_Last(
		String uuid, OrderByComparator<SpecValueUom> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SpecValueUom> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec value uoms before and after the current spec value uom in the ordered set where uuid = &#63;.
	 *
	 * @param specValueUomId the primary key of the current spec value uom
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom[] findByUuid_PrevAndNext(
			long specValueUomId, String uuid,
			OrderByComparator<SpecValueUom> orderByComparator)
		throws NoSuchSpecValueUomException {

		uuid = Objects.toString(uuid, "");

		SpecValueUom specValueUom = findByPrimaryKey(specValueUomId);

		Session session = null;

		try {
			session = openSession();

			SpecValueUom[] array = new SpecValueUomImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, specValueUom, uuid, orderByComparator, true);

			array[1] = specValueUom;

			array[2] = getByUuid_PrevAndNext(
				session, specValueUom, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecValueUom getByUuid_PrevAndNext(
		Session session, SpecValueUom specValueUom, String uuid,
		OrderByComparator<SpecValueUom> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECVALUEUOM_WHERE);

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
			sb.append(SpecValueUomModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(specValueUom)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecValueUom> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec value uoms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SpecValueUom specValueUom :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specValueUom);
		}
	}

	/**
	 * Returns the number of spec value uoms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec value uoms
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECVALUEUOM_WHERE);

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
		"specValueUom.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(specValueUom.uuid IS NULL OR specValueUom.uuid = '')";

	public SpecValueUomPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SpecValueUom.class);

		setModelImplClass(SpecValueUomImpl.class);
		setModelPKClass(long.class);

		setTable(SpecValueUomTable.INSTANCE);
	}

	/**
	 * Caches the spec value uom in the entity cache if it is enabled.
	 *
	 * @param specValueUom the spec value uom
	 */
	@Override
	public void cacheResult(SpecValueUom specValueUom) {
		entityCache.putResult(
			SpecValueUomImpl.class, specValueUom.getPrimaryKey(), specValueUom);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the spec value uoms in the entity cache if it is enabled.
	 *
	 * @param specValueUoms the spec value uoms
	 */
	@Override
	public void cacheResult(List<SpecValueUom> specValueUoms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specValueUoms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SpecValueUom specValueUom : specValueUoms) {
			if (entityCache.getResult(
					SpecValueUomImpl.class, specValueUom.getPrimaryKey()) ==
						null) {

				cacheResult(specValueUom);
			}
		}
	}

	/**
	 * Clears the cache for all spec value uoms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecValueUomImpl.class);

		finderCache.clearCache(SpecValueUomImpl.class);
	}

	/**
	 * Clears the cache for the spec value uom.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpecValueUom specValueUom) {
		entityCache.removeResult(SpecValueUomImpl.class, specValueUom);
	}

	@Override
	public void clearCache(List<SpecValueUom> specValueUoms) {
		for (SpecValueUom specValueUom : specValueUoms) {
			entityCache.removeResult(SpecValueUomImpl.class, specValueUom);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecValueUomImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecValueUomImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new spec value uom with the primary key. Does not add the spec value uom to the database.
	 *
	 * @param specValueUomId the primary key for the new spec value uom
	 * @return the new spec value uom
	 */
	@Override
	public SpecValueUom create(long specValueUomId) {
		SpecValueUom specValueUom = new SpecValueUomImpl();

		specValueUom.setNew(true);
		specValueUom.setPrimaryKey(specValueUomId);

		String uuid = _portalUUID.generate();

		specValueUom.setUuid(uuid);

		return specValueUom;
	}

	/**
	 * Removes the spec value uom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom that was removed
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom remove(long specValueUomId)
		throws NoSuchSpecValueUomException {

		return remove((Serializable)specValueUomId);
	}

	/**
	 * Removes the spec value uom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the spec value uom
	 * @return the spec value uom that was removed
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom remove(Serializable primaryKey)
		throws NoSuchSpecValueUomException {

		Session session = null;

		try {
			session = openSession();

			SpecValueUom specValueUom = (SpecValueUom)session.get(
				SpecValueUomImpl.class, primaryKey);

			if (specValueUom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecValueUomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specValueUom);
		}
		catch (NoSuchSpecValueUomException noSuchEntityException) {
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
	protected SpecValueUom removeImpl(SpecValueUom specValueUom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specValueUom)) {
				specValueUom = (SpecValueUom)session.get(
					SpecValueUomImpl.class, specValueUom.getPrimaryKeyObj());
			}

			if (specValueUom != null) {
				session.delete(specValueUom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specValueUom != null) {
			clearCache(specValueUom);
		}

		return specValueUom;
	}

	@Override
	public SpecValueUom updateImpl(SpecValueUom specValueUom) {
		boolean isNew = specValueUom.isNew();

		if (!(specValueUom instanceof SpecValueUomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specValueUom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specValueUom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specValueUom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SpecValueUom implementation " +
					specValueUom.getClass());
		}

		SpecValueUomModelImpl specValueUomModelImpl =
			(SpecValueUomModelImpl)specValueUom;

		if (Validator.isNull(specValueUom.getUuid())) {
			String uuid = _portalUUID.generate();

			specValueUom.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specValueUom);
			}
			else {
				specValueUom = (SpecValueUom)session.merge(specValueUom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecValueUomImpl.class, specValueUomModelImpl, false, true);

		if (isNew) {
			specValueUom.setNew(false);
		}

		specValueUom.resetOriginalValues();

		return specValueUom;
	}

	/**
	 * Returns the spec value uom with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the spec value uom
	 * @return the spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecValueUomException {

		SpecValueUom specValueUom = fetchByPrimaryKey(primaryKey);

		if (specValueUom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecValueUomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specValueUom;
	}

	/**
	 * Returns the spec value uom with the primary key or throws a <code>NoSuchSpecValueUomException</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom
	 * @throws NoSuchSpecValueUomException if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom findByPrimaryKey(long specValueUomId)
		throws NoSuchSpecValueUomException {

		return findByPrimaryKey((Serializable)specValueUomId);
	}

	/**
	 * Returns the spec value uom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specValueUomId the primary key of the spec value uom
	 * @return the spec value uom, or <code>null</code> if a spec value uom with the primary key could not be found
	 */
	@Override
	public SpecValueUom fetchByPrimaryKey(long specValueUomId) {
		return fetchByPrimaryKey((Serializable)specValueUomId);
	}

	/**
	 * Returns all the spec value uoms.
	 *
	 * @return the spec value uoms
	 */
	@Override
	public List<SpecValueUom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @return the range of spec value uoms
	 */
	@Override
	public List<SpecValueUom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec value uoms
	 */
	@Override
	public List<SpecValueUom> findAll(
		int start, int end, OrderByComparator<SpecValueUom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec value uoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecValueUomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec value uoms
	 * @param end the upper bound of the range of spec value uoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec value uoms
	 */
	@Override
	public List<SpecValueUom> findAll(
		int start, int end, OrderByComparator<SpecValueUom> orderByComparator,
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

		List<SpecValueUom> list = null;

		if (useFinderCache) {
			list = (List<SpecValueUom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECVALUEUOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECVALUEUOM;

				sql = sql.concat(SpecValueUomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SpecValueUom>)QueryUtil.list(
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
	 * Removes all the spec value uoms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SpecValueUom specValueUom : findAll()) {
			remove(specValueUom);
		}
	}

	/**
	 * Returns the number of spec value uoms.
	 *
	 * @return the number of spec value uoms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECVALUEUOM);

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
		return "specValueUomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECVALUEUOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecValueUomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the spec value uom persistence.
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

		_setSpecValueUomUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecValueUomUtilPersistence(null);

		entityCache.removeCache(SpecValueUomImpl.class.getName());
	}

	private void _setSpecValueUomUtilPersistence(
		SpecValueUomPersistence specValueUomPersistence) {

		try {
			Field field = SpecValueUomUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specValueUomPersistence);
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

	private static final String _SQL_SELECT_SPECVALUEUOM =
		"SELECT specValueUom FROM SpecValueUom specValueUom";

	private static final String _SQL_SELECT_SPECVALUEUOM_WHERE =
		"SELECT specValueUom FROM SpecValueUom specValueUom WHERE ";

	private static final String _SQL_COUNT_SPECVALUEUOM =
		"SELECT COUNT(specValueUom) FROM SpecValueUom specValueUom";

	private static final String _SQL_COUNT_SPECVALUEUOM_WHERE =
		"SELECT COUNT(specValueUom) FROM SpecValueUom specValueUom WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specValueUom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SpecValueUom exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SpecValueUom exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecValueUomPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}