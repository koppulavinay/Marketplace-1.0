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

package com.marketplace.specification.category.map.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.marketplace.specification.category.map.exception.NoSuchSpecCategoryMapException;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.model.SpecCategoryMapTable;
import com.marketplace.specification.category.map.model.impl.SpecCategoryMapImpl;
import com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl;
import com.marketplace.specification.category.map.service.persistence.SpecCategoryMapPersistence;
import com.marketplace.specification.category.map.service.persistence.SpecCategoryMapUtil;
import com.marketplace.specification.category.map.service.persistence.impl.constants.marketplacePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the spec category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecCategoryMapPersistence.class)
public class SpecCategoryMapPersistenceImpl
	extends BasePersistenceImpl<SpecCategoryMap>
	implements SpecCategoryMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecCategoryMapUtil</code> to access the spec category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecCategoryMapImpl.class.getName();

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
	 * Returns all the spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
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

		List<SpecCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<SpecCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecCategoryMap specCategoryMap : list) {
					if (!uuid.equals(specCategoryMap.getUuid())) {
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

			sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

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
				sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
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

				list = (List<SpecCategoryMap>)QueryUtil.list(
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
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByUuid_First(
			String uuid, OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByUuid_First(
			uuid, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByUuid_First(
		String uuid, OrderByComparator<SpecCategoryMap> orderByComparator) {

		List<SpecCategoryMap> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByUuid_Last(
			String uuid, OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByUuid_Last(
			uuid, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByUuid_Last(
		String uuid, OrderByComparator<SpecCategoryMap> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SpecCategoryMap> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap[] findByUuid_PrevAndNext(
			long specCategoryMapId, String uuid,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		uuid = Objects.toString(uuid, "");

		SpecCategoryMap specCategoryMap = findByPrimaryKey(specCategoryMapId);

		Session session = null;

		try {
			session = openSession();

			SpecCategoryMap[] array = new SpecCategoryMapImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, specCategoryMap, uuid, orderByComparator, true);

			array[1] = specCategoryMap;

			array[2] = getByUuid_PrevAndNext(
				session, specCategoryMap, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecCategoryMap getByUuid_PrevAndNext(
		Session session, SpecCategoryMap specCategoryMap, String uuid,
		OrderByComparator<SpecCategoryMap> orderByComparator,
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

		sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

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
			sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
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
						specCategoryMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecCategoryMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec category maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SpecCategoryMap specCategoryMap :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specCategoryMap);
		}
	}

	/**
	 * Returns the number of spec category maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching spec category maps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECCATEGORYMAP_WHERE);

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
		"specCategoryMap.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(specCategoryMap.uuid IS NULL OR specCategoryMap.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<SpecCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<SpecCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecCategoryMap specCategoryMap : list) {
					if (!uuid.equals(specCategoryMap.getUuid()) ||
						(companyId != specCategoryMap.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<SpecCategoryMap>)QueryUtil.list(
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
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the first spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		List<SpecCategoryMap> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the last spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SpecCategoryMap> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap[] findByUuid_C_PrevAndNext(
			long specCategoryMapId, String uuid, long companyId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		uuid = Objects.toString(uuid, "");

		SpecCategoryMap specCategoryMap = findByPrimaryKey(specCategoryMapId);

		Session session = null;

		try {
			session = openSession();

			SpecCategoryMap[] array = new SpecCategoryMapImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, specCategoryMap, uuid, companyId, orderByComparator,
				true);

			array[1] = specCategoryMap;

			array[2] = getByUuid_C_PrevAndNext(
				session, specCategoryMap, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecCategoryMap getByUuid_C_PrevAndNext(
		Session session, SpecCategoryMap specCategoryMap, String uuid,
		long companyId, OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specCategoryMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecCategoryMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec category maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SpecCategoryMap specCategoryMap :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(specCategoryMap);
		}
	}

	/**
	 * Returns the number of spec category maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching spec category maps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPECCATEGORYMAP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"specCategoryMap.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(specCategoryMap.uuid IS NULL OR specCategoryMap.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"specCategoryMap.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFBYSpecificationId;
	private FinderPath _finderPathWithoutPaginationFindByFBYSpecificationId;
	private FinderPath _finderPathCountByFBYSpecificationId;

	/**
	 * Returns all the spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId) {

		return findByFBYSpecificationId(
			specificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end) {

		return findByFBYSpecificationId(specificationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return findByFBYSpecificationId(
			specificationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec category maps where specificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param specificationId the specification ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYSpecificationId(
		long specificationId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFBYSpecificationId;
				finderArgs = new Object[] {specificationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFBYSpecificationId;
			finderArgs = new Object[] {
				specificationId, start, end, orderByComparator
			};
		}

		List<SpecCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<SpecCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecCategoryMap specCategoryMap : list) {
					if (specificationId !=
							specCategoryMap.getSpecificationId()) {

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

			sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

			sb.append(_FINDER_COLUMN_FBYSPECIFICATIONID_SPECIFICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specificationId);

				list = (List<SpecCategoryMap>)QueryUtil.list(
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
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByFBYSpecificationId_First(
			long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByFBYSpecificationId_First(
			specificationId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specificationId=");
		sb.append(specificationId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the first spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByFBYSpecificationId_First(
		long specificationId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		List<SpecCategoryMap> list = findByFBYSpecificationId(
			specificationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByFBYSpecificationId_Last(
			long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByFBYSpecificationId_Last(
			specificationId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specificationId=");
		sb.append(specificationId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the last spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByFBYSpecificationId_Last(
		long specificationId,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		int count = countByFBYSpecificationId(specificationId);

		if (count == 0) {
			return null;
		}

		List<SpecCategoryMap> list = findByFBYSpecificationId(
			specificationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where specificationId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param specificationId the specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap[] findByFBYSpecificationId_PrevAndNext(
			long specCategoryMapId, long specificationId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = findByPrimaryKey(specCategoryMapId);

		Session session = null;

		try {
			session = openSession();

			SpecCategoryMap[] array = new SpecCategoryMapImpl[3];

			array[0] = getByFBYSpecificationId_PrevAndNext(
				session, specCategoryMap, specificationId, orderByComparator,
				true);

			array[1] = specCategoryMap;

			array[2] = getByFBYSpecificationId_PrevAndNext(
				session, specCategoryMap, specificationId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecCategoryMap getByFBYSpecificationId_PrevAndNext(
		Session session, SpecCategoryMap specCategoryMap, long specificationId,
		OrderByComparator<SpecCategoryMap> orderByComparator,
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

		sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

		sb.append(_FINDER_COLUMN_FBYSPECIFICATIONID_SPECIFICATIONID_2);

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
			sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(specificationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specCategoryMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecCategoryMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec category maps where specificationId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 */
	@Override
	public void removeByFBYSpecificationId(long specificationId) {
		for (SpecCategoryMap specCategoryMap :
				findByFBYSpecificationId(
					specificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(specCategoryMap);
		}
	}

	/**
	 * Returns the number of spec category maps where specificationId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @return the number of matching spec category maps
	 */
	@Override
	public int countByFBYSpecificationId(long specificationId) {
		FinderPath finderPath = _finderPathCountByFBYSpecificationId;

		Object[] finderArgs = new Object[] {specificationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECCATEGORYMAP_WHERE);

			sb.append(_FINDER_COLUMN_FBYSPECIFICATIONID_SPECIFICATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specificationId);

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

	private static final String
		_FINDER_COLUMN_FBYSPECIFICATIONID_SPECIFICATIONID_2 =
			"specCategoryMap.specificationId = ?";

	private FinderPath _finderPathWithPaginationFindByFBYCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByFBYCategoryId;
	private FinderPath _finderPathCountByFBYCategoryId;

	/**
	 * Returns all the spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYCategoryId(long categoryId) {
		return findByFBYCategoryId(
			categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end) {

		return findByFBYCategoryId(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return findByFBYCategoryId(
			categoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec category maps where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findByFBYCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFBYCategoryId;
				finderArgs = new Object[] {categoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFBYCategoryId;
			finderArgs = new Object[] {
				categoryId, start, end, orderByComparator
			};
		}

		List<SpecCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<SpecCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SpecCategoryMap specCategoryMap : list) {
					if (categoryId != specCategoryMap.getCategoryId()) {
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

			sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

			sb.append(_FINDER_COLUMN_FBYCATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				list = (List<SpecCategoryMap>)QueryUtil.list(
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
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByFBYCategoryId_First(
			long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByFBYCategoryId_First(
			categoryId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the first spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByFBYCategoryId_First(
		long categoryId, OrderByComparator<SpecCategoryMap> orderByComparator) {

		List<SpecCategoryMap> list = findByFBYCategoryId(
			categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findByFBYCategoryId_Last(
			long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByFBYCategoryId_Last(
			categoryId, orderByComparator);

		if (specCategoryMap != null) {
			return specCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchSpecCategoryMapException(sb.toString());
	}

	/**
	 * Returns the last spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchByFBYCategoryId_Last(
		long categoryId, OrderByComparator<SpecCategoryMap> orderByComparator) {

		int count = countByFBYCategoryId(categoryId);

		if (count == 0) {
			return null;
		}

		List<SpecCategoryMap> list = findByFBYCategoryId(
			categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spec category maps before and after the current spec category map in the ordered set where categoryId = &#63;.
	 *
	 * @param specCategoryMapId the primary key of the current spec category map
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap[] findByFBYCategoryId_PrevAndNext(
			long specCategoryMapId, long categoryId,
			OrderByComparator<SpecCategoryMap> orderByComparator)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = findByPrimaryKey(specCategoryMapId);

		Session session = null;

		try {
			session = openSession();

			SpecCategoryMap[] array = new SpecCategoryMapImpl[3];

			array[0] = getByFBYCategoryId_PrevAndNext(
				session, specCategoryMap, categoryId, orderByComparator, true);

			array[1] = specCategoryMap;

			array[2] = getByFBYCategoryId_PrevAndNext(
				session, specCategoryMap, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecCategoryMap getByFBYCategoryId_PrevAndNext(
		Session session, SpecCategoryMap specCategoryMap, long categoryId,
		OrderByComparator<SpecCategoryMap> orderByComparator,
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

		sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

		sb.append(_FINDER_COLUMN_FBYCATEGORYID_CATEGORYID_2);

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
			sb.append(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specCategoryMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SpecCategoryMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spec category maps where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByFBYCategoryId(long categoryId) {
		for (SpecCategoryMap specCategoryMap :
				findByFBYCategoryId(
					categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specCategoryMap);
		}
	}

	/**
	 * Returns the number of spec category maps where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	@Override
	public int countByFBYCategoryId(long categoryId) {
		FinderPath finderPath = _finderPathCountByFBYCategoryId;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECCATEGORYMAP_WHERE);

			sb.append(_FINDER_COLUMN_FBYCATEGORYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_FBYCATEGORYID_CATEGORYID_2 =
		"specCategoryMap.categoryId = ?";

	private FinderPath _finderPathFetchBySpecificationIdNCategoryId;
	private FinderPath _finderPathCountBySpecificationIdNCategoryId;

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map
	 * @throws NoSuchSpecCategoryMapException if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap findBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchBySpecificationIdNCategoryId(
			specificationId, categoryId);

		if (specCategoryMap == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("specificationId=");
			sb.append(specificationId);

			sb.append(", categoryId=");
			sb.append(categoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSpecCategoryMapException(sb.toString());
		}

		return specCategoryMap;
	}

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId) {

		return fetchBySpecificationIdNCategoryId(
			specificationId, categoryId, true);
	}

	/**
	 * Returns the spec category map where specificationId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Override
	public SpecCategoryMap fetchBySpecificationIdNCategoryId(
		long specificationId, long categoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {specificationId, categoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySpecificationIdNCategoryId, finderArgs, this);
		}

		if (result instanceof SpecCategoryMap) {
			SpecCategoryMap specCategoryMap = (SpecCategoryMap)result;

			if ((specificationId != specCategoryMap.getSpecificationId()) ||
				(categoryId != specCategoryMap.getCategoryId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SPECCATEGORYMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_SPECIFICATIONID_2);

			sb.append(_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specificationId);

				queryPos.add(categoryId);

				List<SpecCategoryMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySpecificationIdNCategoryId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									specificationId, categoryId
								};
							}

							_log.warn(
								"SpecCategoryMapPersistenceImpl.fetchBySpecificationIdNCategoryId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SpecCategoryMap specCategoryMap = list.get(0);

					result = specCategoryMap;

					cacheResult(specCategoryMap);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SpecCategoryMap)result;
		}
	}

	/**
	 * Removes the spec category map where specificationId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the spec category map that was removed
	 */
	@Override
	public SpecCategoryMap removeBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = findBySpecificationIdNCategoryId(
			specificationId, categoryId);

		return remove(specCategoryMap);
	}

	/**
	 * Returns the number of spec category maps where specificationId = &#63; and categoryId = &#63;.
	 *
	 * @param specificationId the specification ID
	 * @param categoryId the category ID
	 * @return the number of matching spec category maps
	 */
	@Override
	public int countBySpecificationIdNCategoryId(
		long specificationId, long categoryId) {

		FinderPath finderPath = _finderPathCountBySpecificationIdNCategoryId;

		Object[] finderArgs = new Object[] {specificationId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPECCATEGORYMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_SPECIFICATIONID_2);

			sb.append(_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(specificationId);

				queryPos.add(categoryId);

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

	private static final String
		_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_SPECIFICATIONID_2 =
			"specCategoryMap.specificationId = ? AND ";

	private static final String
		_FINDER_COLUMN_SPECIFICATIONIDNCATEGORYID_CATEGORYID_2 =
			"specCategoryMap.categoryId = ?";

	public SpecCategoryMapPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SpecCategoryMap.class);

		setModelImplClass(SpecCategoryMapImpl.class);
		setModelPKClass(long.class);

		setTable(SpecCategoryMapTable.INSTANCE);
	}

	/**
	 * Caches the spec category map in the entity cache if it is enabled.
	 *
	 * @param specCategoryMap the spec category map
	 */
	@Override
	public void cacheResult(SpecCategoryMap specCategoryMap) {
		entityCache.putResult(
			SpecCategoryMapImpl.class, specCategoryMap.getPrimaryKey(),
			specCategoryMap);

		finderCache.putResult(
			_finderPathFetchBySpecificationIdNCategoryId,
			new Object[] {
				specCategoryMap.getSpecificationId(),
				specCategoryMap.getCategoryId()
			},
			specCategoryMap);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the spec category maps in the entity cache if it is enabled.
	 *
	 * @param specCategoryMaps the spec category maps
	 */
	@Override
	public void cacheResult(List<SpecCategoryMap> specCategoryMaps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specCategoryMaps.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SpecCategoryMap specCategoryMap : specCategoryMaps) {
			if (entityCache.getResult(
					SpecCategoryMapImpl.class,
					specCategoryMap.getPrimaryKey()) == null) {

				cacheResult(specCategoryMap);
			}
		}
	}

	/**
	 * Clears the cache for all spec category maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecCategoryMapImpl.class);

		finderCache.clearCache(SpecCategoryMapImpl.class);
	}

	/**
	 * Clears the cache for the spec category map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpecCategoryMap specCategoryMap) {
		entityCache.removeResult(SpecCategoryMapImpl.class, specCategoryMap);
	}

	@Override
	public void clearCache(List<SpecCategoryMap> specCategoryMaps) {
		for (SpecCategoryMap specCategoryMap : specCategoryMaps) {
			entityCache.removeResult(
				SpecCategoryMapImpl.class, specCategoryMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecCategoryMapImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecCategoryMapImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SpecCategoryMapModelImpl specCategoryMapModelImpl) {

		Object[] args = new Object[] {
			specCategoryMapModelImpl.getSpecificationId(),
			specCategoryMapModelImpl.getCategoryId()
		};

		finderCache.putResult(
			_finderPathCountBySpecificationIdNCategoryId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySpecificationIdNCategoryId, args,
			specCategoryMapModelImpl);
	}

	/**
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	@Override
	public SpecCategoryMap create(long specCategoryMapId) {
		SpecCategoryMap specCategoryMap = new SpecCategoryMapImpl();

		specCategoryMap.setNew(true);
		specCategoryMap.setPrimaryKey(specCategoryMapId);

		String uuid = _portalUUID.generate();

		specCategoryMap.setUuid(uuid);

		specCategoryMap.setCompanyId(CompanyThreadLocal.getCompanyId());

		return specCategoryMap;
	}

	/**
	 * Removes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap remove(long specCategoryMapId)
		throws NoSuchSpecCategoryMapException {

		return remove((Serializable)specCategoryMapId);
	}

	/**
	 * Removes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap remove(Serializable primaryKey)
		throws NoSuchSpecCategoryMapException {

		Session session = null;

		try {
			session = openSession();

			SpecCategoryMap specCategoryMap = (SpecCategoryMap)session.get(
				SpecCategoryMapImpl.class, primaryKey);

			if (specCategoryMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecCategoryMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specCategoryMap);
		}
		catch (NoSuchSpecCategoryMapException noSuchEntityException) {
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
	protected SpecCategoryMap removeImpl(SpecCategoryMap specCategoryMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specCategoryMap)) {
				specCategoryMap = (SpecCategoryMap)session.get(
					SpecCategoryMapImpl.class,
					specCategoryMap.getPrimaryKeyObj());
			}

			if (specCategoryMap != null) {
				session.delete(specCategoryMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specCategoryMap != null) {
			clearCache(specCategoryMap);
		}

		return specCategoryMap;
	}

	@Override
	public SpecCategoryMap updateImpl(SpecCategoryMap specCategoryMap) {
		boolean isNew = specCategoryMap.isNew();

		if (!(specCategoryMap instanceof SpecCategoryMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specCategoryMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specCategoryMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specCategoryMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SpecCategoryMap implementation " +
					specCategoryMap.getClass());
		}

		SpecCategoryMapModelImpl specCategoryMapModelImpl =
			(SpecCategoryMapModelImpl)specCategoryMap;

		if (Validator.isNull(specCategoryMap.getUuid())) {
			String uuid = _portalUUID.generate();

			specCategoryMap.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (specCategoryMap.getCreateDate() == null)) {
			if (serviceContext == null) {
				specCategoryMap.setCreateDate(date);
			}
			else {
				specCategoryMap.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!specCategoryMapModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				specCategoryMap.setModifiedDate(date);
			}
			else {
				specCategoryMap.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specCategoryMap);
			}
			else {
				specCategoryMap = (SpecCategoryMap)session.merge(
					specCategoryMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecCategoryMapImpl.class, specCategoryMapModelImpl, false, true);

		cacheUniqueFindersCache(specCategoryMapModelImpl);

		if (isNew) {
			specCategoryMap.setNew(false);
		}

		specCategoryMap.resetOriginalValues();

		return specCategoryMap;
	}

	/**
	 * Returns the spec category map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the spec category map
	 * @return the spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecCategoryMapException {

		SpecCategoryMap specCategoryMap = fetchByPrimaryKey(primaryKey);

		if (specCategoryMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecCategoryMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specCategoryMap;
	}

	/**
	 * Returns the spec category map with the primary key or throws a <code>NoSuchSpecCategoryMapException</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws NoSuchSpecCategoryMapException if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap findByPrimaryKey(long specCategoryMapId)
		throws NoSuchSpecCategoryMapException {

		return findByPrimaryKey((Serializable)specCategoryMapId);
	}

	/**
	 * Returns the spec category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map, or <code>null</code> if a spec category map with the primary key could not be found
	 */
	@Override
	public SpecCategoryMap fetchByPrimaryKey(long specCategoryMapId) {
		return fetchByPrimaryKey((Serializable)specCategoryMapId);
	}

	/**
	 * Returns all the spec category maps.
	 *
	 * @return the spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findAll(
		int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of spec category maps
	 */
	@Override
	public List<SpecCategoryMap> findAll(
		int start, int end,
		OrderByComparator<SpecCategoryMap> orderByComparator,
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

		List<SpecCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<SpecCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECCATEGORYMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECCATEGORYMAP;

				sql = sql.concat(SpecCategoryMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SpecCategoryMap>)QueryUtil.list(
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
	 * Removes all the spec category maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SpecCategoryMap specCategoryMap : findAll()) {
			remove(specCategoryMap);
		}
	}

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECCATEGORYMAP);

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
		return "specCategoryMapId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECCATEGORYMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecCategoryMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the spec category map persistence.
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

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByFBYSpecificationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFBYSpecificationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"specificationId"}, true);

		_finderPathWithoutPaginationFindByFBYSpecificationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFBYSpecificationId", new String[] {Long.class.getName()},
			new String[] {"specificationId"}, true);

		_finderPathCountByFBYSpecificationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFBYSpecificationId", new String[] {Long.class.getName()},
			new String[] {"specificationId"}, false);

		_finderPathWithPaginationFindByFBYCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFBYCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"categoryId"}, true);

		_finderPathWithoutPaginationFindByFBYCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFBYCategoryId",
			new String[] {Long.class.getName()}, new String[] {"categoryId"},
			true);

		_finderPathCountByFBYCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFBYCategoryId",
			new String[] {Long.class.getName()}, new String[] {"categoryId"},
			false);

		_finderPathFetchBySpecificationIdNCategoryId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySpecificationIdNCategoryId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"specificationId", "categoryId"}, true);

		_finderPathCountBySpecificationIdNCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpecificationIdNCategoryId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"specificationId", "categoryId"}, false);

		_setSpecCategoryMapUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecCategoryMapUtilPersistence(null);

		entityCache.removeCache(SpecCategoryMapImpl.class.getName());
	}

	private void _setSpecCategoryMapUtilPersistence(
		SpecCategoryMapPersistence specCategoryMapPersistence) {

		try {
			Field field = SpecCategoryMapUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specCategoryMapPersistence);
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

	private static final String _SQL_SELECT_SPECCATEGORYMAP =
		"SELECT specCategoryMap FROM SpecCategoryMap specCategoryMap";

	private static final String _SQL_SELECT_SPECCATEGORYMAP_WHERE =
		"SELECT specCategoryMap FROM SpecCategoryMap specCategoryMap WHERE ";

	private static final String _SQL_COUNT_SPECCATEGORYMAP =
		"SELECT COUNT(specCategoryMap) FROM SpecCategoryMap specCategoryMap";

	private static final String _SQL_COUNT_SPECCATEGORYMAP_WHERE =
		"SELECT COUNT(specCategoryMap) FROM SpecCategoryMap specCategoryMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specCategoryMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SpecCategoryMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SpecCategoryMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecCategoryMapPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}