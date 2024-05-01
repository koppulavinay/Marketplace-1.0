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

package com.marketplace.product.spec.value.map.service.persistence.impl;

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

import com.marketplace.product.spec.value.map.exception.NoSuchProductSpecValueMapException;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMap;
import com.marketplace.product.spec.value.map.model.ProductSpecValueMapTable;
import com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapImpl;
import com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapModelImpl;
import com.marketplace.product.spec.value.map.service.persistence.ProductSpecValueMapPersistence;
import com.marketplace.product.spec.value.map.service.persistence.ProductSpecValueMapUtil;
import com.marketplace.product.spec.value.map.service.persistence.impl.constants.marketplace_productspecvaluemapPersistenceConstants;

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
 * The persistence implementation for the product spec value map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductSpecValueMapPersistence.class)
public class ProductSpecValueMapPersistenceImpl
	extends BasePersistenceImpl<ProductSpecValueMap>
	implements ProductSpecValueMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductSpecValueMapUtil</code> to access the product spec value map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductSpecValueMapImpl.class.getName();

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
	 * Returns all the product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		List<ProductSpecValueMap> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecValueMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecValueMap productSpecValueMap : list) {
					if (!uuid.equals(productSpecValueMap.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

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
				sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSpecValueMap>)QueryUtil.list(
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
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByUuid_First(
			uuid, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUuid_First(
		String uuid, OrderByComparator<ProductSpecValueMap> orderByComparator) {

		List<ProductSpecValueMap> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUuid_Last(
		String uuid, OrderByComparator<ProductSpecValueMap> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductSpecValueMap> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap[] findByUuid_PrevAndNext(
			long productSpecValueId, String uuid,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		uuid = Objects.toString(uuid, "");

		ProductSpecValueMap productSpecValueMap = findByPrimaryKey(
			productSpecValueId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecValueMap[] array = new ProductSpecValueMapImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productSpecValueMap, uuid, orderByComparator, true);

			array[1] = productSpecValueMap;

			array[2] = getByUuid_PrevAndNext(
				session, productSpecValueMap, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecValueMap getByUuid_PrevAndNext(
		Session session, ProductSpecValueMap productSpecValueMap, String uuid,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

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
			sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
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
						productSpecValueMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecValueMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product spec value maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductSpecValueMap productSpecValueMap :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSpecValueMap);
		}
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product spec value maps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE);

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
		"productSpecValueMap.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productSpecValueMap.uuid IS NULL OR productSpecValueMap.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByUUID_G(uuid, groupId);

		if (productSpecValueMap == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductSpecValueMapException(sb.toString());
		}

		return productSpecValueMap;
	}

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product spec value map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ProductSpecValueMap) {
			ProductSpecValueMap productSpecValueMap =
				(ProductSpecValueMap)result;

			if (!Objects.equals(uuid, productSpecValueMap.getUuid()) ||
				(groupId != productSpecValueMap.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ProductSpecValueMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductSpecValueMap productSpecValueMap = list.get(0);

					result = productSpecValueMap;

					cacheResult(productSpecValueMap);
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
			return (ProductSpecValueMap)result;
		}
	}

	/**
	 * Removes the product spec value map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product spec value map that was removed
	 */
	@Override
	public ProductSpecValueMap removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = findByUUID_G(uuid, groupId);

		return remove(productSpecValueMap);
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product spec value maps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"productSpecValueMap.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productSpecValueMap.uuid IS NULL OR productSpecValueMap.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productSpecValueMap.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		List<ProductSpecValueMap> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecValueMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecValueMap productSpecValueMap : list) {
					if (!uuid.equals(productSpecValueMap.getUuid()) ||
						(companyId != productSpecValueMap.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

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
				sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSpecValueMap>)QueryUtil.list(
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
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the first product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		List<ProductSpecValueMap> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the last product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductSpecValueMap> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap[] findByUuid_C_PrevAndNext(
			long productSpecValueId, String uuid, long companyId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		uuid = Objects.toString(uuid, "");

		ProductSpecValueMap productSpecValueMap = findByPrimaryKey(
			productSpecValueId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecValueMap[] array = new ProductSpecValueMapImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productSpecValueMap, uuid, companyId,
				orderByComparator, true);

			array[1] = productSpecValueMap;

			array[2] = getByUuid_C_PrevAndNext(
				session, productSpecValueMap, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecValueMap getByUuid_C_PrevAndNext(
		Session session, ProductSpecValueMap productSpecValueMap, String uuid,
		long companyId,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

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
			sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
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
						productSpecValueMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecValueMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product spec value maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductSpecValueMap productSpecValueMap :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSpecValueMap);
		}
	}

	/**
	 * Returns the number of product spec value maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product spec value maps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE);

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
		"productSpecValueMap.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productSpecValueMap.uuid IS NULL OR productSpecValueMap.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productSpecValueMap.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByproductSpecificationId;
	private FinderPath _finderPathWithoutPaginationFindByproductSpecificationId;
	private FinderPath _finderPathCountByproductSpecificationId;

	/**
	 * Returns all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId) {

		return findByproductSpecificationId(
			productSpecificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end) {

		return findByproductSpecificationId(
			productSpecificationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return findByproductSpecificationId(
			productSpecificationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product spec value maps where productSpecificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param productSpecificationId the product specification ID
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findByproductSpecificationId(
		long productSpecificationId, int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByproductSpecificationId;
				finderArgs = new Object[] {productSpecificationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByproductSpecificationId;
			finderArgs = new Object[] {
				productSpecificationId, start, end, orderByComparator
			};
		}

		List<ProductSpecValueMap> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecValueMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecValueMap productSpecValueMap : list) {
					if (productSpecificationId !=
							productSpecValueMap.getProductSpecificationId()) {

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

			sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIFICATIONID_PRODUCTSPECIFICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSpecificationId);

				list = (List<ProductSpecValueMap>)QueryUtil.list(
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
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByproductSpecificationId_First(
			long productSpecificationId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap =
			fetchByproductSpecificationId_First(
				productSpecificationId, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSpecificationId=");
		sb.append(productSpecificationId);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the first product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByproductSpecificationId_First(
		long productSpecificationId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		List<ProductSpecValueMap> list = findByproductSpecificationId(
			productSpecificationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByproductSpecificationId_Last(
			long productSpecificationId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap =
			fetchByproductSpecificationId_Last(
				productSpecificationId, orderByComparator);

		if (productSpecValueMap != null) {
			return productSpecValueMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSpecificationId=");
		sb.append(productSpecificationId);

		sb.append("}");

		throw new NoSuchProductSpecValueMapException(sb.toString());
	}

	/**
	 * Returns the last product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByproductSpecificationId_Last(
		long productSpecificationId,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		int count = countByproductSpecificationId(productSpecificationId);

		if (count == 0) {
			return null;
		}

		List<ProductSpecValueMap> list = findByproductSpecificationId(
			productSpecificationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product spec value maps before and after the current product spec value map in the ordered set where productSpecificationId = &#63;.
	 *
	 * @param productSpecValueId the primary key of the current product spec value map
	 * @param productSpecificationId the product specification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap[] findByproductSpecificationId_PrevAndNext(
			long productSpecValueId, long productSpecificationId,
			OrderByComparator<ProductSpecValueMap> orderByComparator)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = findByPrimaryKey(
			productSpecValueId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecValueMap[] array = new ProductSpecValueMapImpl[3];

			array[0] = getByproductSpecificationId_PrevAndNext(
				session, productSpecValueMap, productSpecificationId,
				orderByComparator, true);

			array[1] = productSpecValueMap;

			array[2] = getByproductSpecificationId_PrevAndNext(
				session, productSpecValueMap, productSpecificationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecValueMap getByproductSpecificationId_PrevAndNext(
		Session session, ProductSpecValueMap productSpecValueMap,
		long productSpecificationId,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

		sb.append(
			_FINDER_COLUMN_PRODUCTSPECIFICATIONID_PRODUCTSPECIFICATIONID_2);

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
			sb.append(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productSpecificationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productSpecValueMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecValueMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product spec value maps where productSpecificationId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 */
	@Override
	public void removeByproductSpecificationId(long productSpecificationId) {
		for (ProductSpecValueMap productSpecValueMap :
				findByproductSpecificationId(
					productSpecificationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(productSpecValueMap);
		}
	}

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @return the number of matching product spec value maps
	 */
	@Override
	public int countByproductSpecificationId(long productSpecificationId) {
		FinderPath finderPath = _finderPathCountByproductSpecificationId;

		Object[] finderArgs = new Object[] {productSpecificationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIFICATIONID_PRODUCTSPECIFICATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSpecificationId);

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
		_FINDER_COLUMN_PRODUCTSPECIFICATIONID_PRODUCTSPECIFICATIONID_2 =
			"productSpecValueMap.productSpecificationId = ?";

	private FinderPath _finderPathFetchByProductSpecIdNSpecValueId;
	private FinderPath _finderPathCountByProductSpecIdNSpecValueId;

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map
	 * @throws NoSuchProductSpecValueMapException if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap findByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap =
			fetchByProductSpecIdNSpecValueId(
				productSpecificationId, specificationValueLabelId);

		if (productSpecValueMap == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("productSpecificationId=");
			sb.append(productSpecificationId);

			sb.append(", specificationValueLabelId=");
			sb.append(specificationValueLabelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductSpecValueMapException(sb.toString());
		}

		return productSpecValueMap;
	}

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId) {

		return fetchByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueLabelId, true);
	}

	/**
	 * Returns the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				productSpecificationId, specificationValueLabelId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProductSpecIdNSpecValueId, finderArgs, this);
		}

		if (result instanceof ProductSpecValueMap) {
			ProductSpecValueMap productSpecValueMap =
				(ProductSpecValueMap)result;

			if ((productSpecificationId !=
					productSpecValueMap.getProductSpecificationId()) ||
				(specificationValueLabelId !=
					productSpecValueMap.getSpecificationValueLabelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_PRODUCTSPECIFICATIONID_2);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_SPECIFICATIONVALUELABELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSpecificationId);

				queryPos.add(specificationValueLabelId);

				List<ProductSpecValueMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProductSpecIdNSpecValueId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									productSpecificationId,
									specificationValueLabelId
								};
							}

							_log.warn(
								"ProductSpecValueMapPersistenceImpl.fetchByProductSpecIdNSpecValueId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductSpecValueMap productSpecValueMap = list.get(0);

					result = productSpecValueMap;

					cacheResult(productSpecValueMap);
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
			return (ProductSpecValueMap)result;
		}
	}

	/**
	 * Removes the product spec value map where productSpecificationId = &#63; and specificationValueLabelId = &#63; from the database.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the product spec value map that was removed
	 */
	@Override
	public ProductSpecValueMap removeByProductSpecIdNSpecValueId(
			long productSpecificationId, long specificationValueLabelId)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap =
			findByProductSpecIdNSpecValueId(
				productSpecificationId, specificationValueLabelId);

		return remove(productSpecValueMap);
	}

	/**
	 * Returns the number of product spec value maps where productSpecificationId = &#63; and specificationValueLabelId = &#63;.
	 *
	 * @param productSpecificationId the product specification ID
	 * @param specificationValueLabelId the specification value label ID
	 * @return the number of matching product spec value maps
	 */
	@Override
	public int countByProductSpecIdNSpecValueId(
		long productSpecificationId, long specificationValueLabelId) {

		FinderPath finderPath = _finderPathCountByProductSpecIdNSpecValueId;

		Object[] finderArgs = new Object[] {
			productSpecificationId, specificationValueLabelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_PRODUCTSPECIFICATIONID_2);

			sb.append(
				_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_SPECIFICATIONVALUELABELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSpecificationId);

				queryPos.add(specificationValueLabelId);

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
		_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_PRODUCTSPECIFICATIONID_2 =
			"productSpecValueMap.productSpecificationId = ? AND ";

	private static final String
		_FINDER_COLUMN_PRODUCTSPECIDNSPECVALUEID_SPECIFICATIONVALUELABELID_2 =
			"productSpecValueMap.specificationValueLabelId = ?";

	public ProductSpecValueMapPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductSpecValueMap.class);

		setModelImplClass(ProductSpecValueMapImpl.class);
		setModelPKClass(long.class);

		setTable(ProductSpecValueMapTable.INSTANCE);
	}

	/**
	 * Caches the product spec value map in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMap the product spec value map
	 */
	@Override
	public void cacheResult(ProductSpecValueMap productSpecValueMap) {
		entityCache.putResult(
			ProductSpecValueMapImpl.class, productSpecValueMap.getPrimaryKey(),
			productSpecValueMap);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productSpecValueMap.getUuid(), productSpecValueMap.getGroupId()
			},
			productSpecValueMap);

		finderCache.putResult(
			_finderPathFetchByProductSpecIdNSpecValueId,
			new Object[] {
				productSpecValueMap.getProductSpecificationId(),
				productSpecValueMap.getSpecificationValueLabelId()
			},
			productSpecValueMap);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product spec value maps in the entity cache if it is enabled.
	 *
	 * @param productSpecValueMaps the product spec value maps
	 */
	@Override
	public void cacheResult(List<ProductSpecValueMap> productSpecValueMaps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productSpecValueMaps.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductSpecValueMap productSpecValueMap : productSpecValueMaps) {
			if (entityCache.getResult(
					ProductSpecValueMapImpl.class,
					productSpecValueMap.getPrimaryKey()) == null) {

				cacheResult(productSpecValueMap);
			}
		}
	}

	/**
	 * Clears the cache for all product spec value maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductSpecValueMapImpl.class);

		finderCache.clearCache(ProductSpecValueMapImpl.class);
	}

	/**
	 * Clears the cache for the product spec value map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductSpecValueMap productSpecValueMap) {
		entityCache.removeResult(
			ProductSpecValueMapImpl.class, productSpecValueMap);
	}

	@Override
	public void clearCache(List<ProductSpecValueMap> productSpecValueMaps) {
		for (ProductSpecValueMap productSpecValueMap : productSpecValueMaps) {
			entityCache.removeResult(
				ProductSpecValueMapImpl.class, productSpecValueMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductSpecValueMapImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductSpecValueMapImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductSpecValueMapModelImpl productSpecValueMapModelImpl) {

		Object[] args = new Object[] {
			productSpecValueMapModelImpl.getUuid(),
			productSpecValueMapModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productSpecValueMapModelImpl);

		args = new Object[] {
			productSpecValueMapModelImpl.getProductSpecificationId(),
			productSpecValueMapModelImpl.getSpecificationValueLabelId()
		};

		finderCache.putResult(
			_finderPathCountByProductSpecIdNSpecValueId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProductSpecIdNSpecValueId, args,
			productSpecValueMapModelImpl);
	}

	/**
	 * Creates a new product spec value map with the primary key. Does not add the product spec value map to the database.
	 *
	 * @param productSpecValueId the primary key for the new product spec value map
	 * @return the new product spec value map
	 */
	@Override
	public ProductSpecValueMap create(long productSpecValueId) {
		ProductSpecValueMap productSpecValueMap = new ProductSpecValueMapImpl();

		productSpecValueMap.setNew(true);
		productSpecValueMap.setPrimaryKey(productSpecValueId);

		String uuid = _portalUUID.generate();

		productSpecValueMap.setUuid(uuid);

		productSpecValueMap.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productSpecValueMap;
	}

	/**
	 * Removes the product spec value map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map that was removed
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap remove(long productSpecValueId)
		throws NoSuchProductSpecValueMapException {

		return remove((Serializable)productSpecValueId);
	}

	/**
	 * Removes the product spec value map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product spec value map
	 * @return the product spec value map that was removed
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap remove(Serializable primaryKey)
		throws NoSuchProductSpecValueMapException {

		Session session = null;

		try {
			session = openSession();

			ProductSpecValueMap productSpecValueMap =
				(ProductSpecValueMap)session.get(
					ProductSpecValueMapImpl.class, primaryKey);

			if (productSpecValueMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSpecValueMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productSpecValueMap);
		}
		catch (NoSuchProductSpecValueMapException noSuchEntityException) {
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
	protected ProductSpecValueMap removeImpl(
		ProductSpecValueMap productSpecValueMap) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSpecValueMap)) {
				productSpecValueMap = (ProductSpecValueMap)session.get(
					ProductSpecValueMapImpl.class,
					productSpecValueMap.getPrimaryKeyObj());
			}

			if (productSpecValueMap != null) {
				session.delete(productSpecValueMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productSpecValueMap != null) {
			clearCache(productSpecValueMap);
		}

		return productSpecValueMap;
	}

	@Override
	public ProductSpecValueMap updateImpl(
		ProductSpecValueMap productSpecValueMap) {

		boolean isNew = productSpecValueMap.isNew();

		if (!(productSpecValueMap instanceof ProductSpecValueMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productSpecValueMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productSpecValueMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productSpecValueMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductSpecValueMap implementation " +
					productSpecValueMap.getClass());
		}

		ProductSpecValueMapModelImpl productSpecValueMapModelImpl =
			(ProductSpecValueMapModelImpl)productSpecValueMap;

		if (Validator.isNull(productSpecValueMap.getUuid())) {
			String uuid = _portalUUID.generate();

			productSpecValueMap.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productSpecValueMap.getCreateDate() == null)) {
			if (serviceContext == null) {
				productSpecValueMap.setCreateDate(date);
			}
			else {
				productSpecValueMap.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productSpecValueMapModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productSpecValueMap.setModifiedDate(date);
			}
			else {
				productSpecValueMap.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productSpecValueMap);
			}
			else {
				productSpecValueMap = (ProductSpecValueMap)session.merge(
					productSpecValueMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductSpecValueMapImpl.class, productSpecValueMapModelImpl, false,
			true);

		cacheUniqueFindersCache(productSpecValueMapModelImpl);

		if (isNew) {
			productSpecValueMap.setNew(false);
		}

		productSpecValueMap.resetOriginalValues();

		return productSpecValueMap;
	}

	/**
	 * Returns the product spec value map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product spec value map
	 * @return the product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSpecValueMapException {

		ProductSpecValueMap productSpecValueMap = fetchByPrimaryKey(primaryKey);

		if (productSpecValueMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSpecValueMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productSpecValueMap;
	}

	/**
	 * Returns the product spec value map with the primary key or throws a <code>NoSuchProductSpecValueMapException</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map
	 * @throws NoSuchProductSpecValueMapException if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap findByPrimaryKey(long productSpecValueId)
		throws NoSuchProductSpecValueMapException {

		return findByPrimaryKey((Serializable)productSpecValueId);
	}

	/**
	 * Returns the product spec value map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map, or <code>null</code> if a product spec value map with the primary key could not be found
	 */
	@Override
	public ProductSpecValueMap fetchByPrimaryKey(long productSpecValueId) {
		return fetchByPrimaryKey((Serializable)productSpecValueId);
	}

	/**
	 * Returns all the product spec value maps.
	 *
	 * @return the product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findAll(
		int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product spec value maps
	 */
	@Override
	public List<ProductSpecValueMap> findAll(
		int start, int end,
		OrderByComparator<ProductSpecValueMap> orderByComparator,
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

		List<ProductSpecValueMap> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecValueMap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTSPECVALUEMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSPECVALUEMAP;

				sql = sql.concat(ProductSpecValueMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductSpecValueMap>)QueryUtil.list(
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
	 * Removes all the product spec value maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductSpecValueMap productSpecValueMap : findAll()) {
			remove(productSpecValueMap);
		}
	}

	/**
	 * Returns the number of product spec value maps.
	 *
	 * @return the number of product spec value maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PRODUCTSPECVALUEMAP);

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
		return "productSpecValueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTSPECVALUEMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductSpecValueMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product spec value map persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

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

		_finderPathWithPaginationFindByproductSpecificationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByproductSpecificationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productSpecificationId"}, true);

		_finderPathWithoutPaginationFindByproductSpecificationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByproductSpecificationId",
				new String[] {Long.class.getName()},
				new String[] {"productSpecificationId"}, true);

		_finderPathCountByproductSpecificationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByproductSpecificationId",
			new String[] {Long.class.getName()},
			new String[] {"productSpecificationId"}, false);

		_finderPathFetchByProductSpecIdNSpecValueId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProductSpecIdNSpecValueId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {
				"productSpecificationId", "specificationValueLabelId"
			},
			true);

		_finderPathCountByProductSpecIdNSpecValueId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductSpecIdNSpecValueId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {
				"productSpecificationId", "specificationValueLabelId"
			},
			false);

		_setProductSpecValueMapUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductSpecValueMapUtilPersistence(null);

		entityCache.removeCache(ProductSpecValueMapImpl.class.getName());
	}

	private void _setProductSpecValueMapUtilPersistence(
		ProductSpecValueMapPersistence productSpecValueMapPersistence) {

		try {
			Field field = ProductSpecValueMapUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productSpecValueMapPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_productspecvaluemapPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_productspecvaluemapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_productspecvaluemapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTSPECVALUEMAP =
		"SELECT productSpecValueMap FROM ProductSpecValueMap productSpecValueMap";

	private static final String _SQL_SELECT_PRODUCTSPECVALUEMAP_WHERE =
		"SELECT productSpecValueMap FROM ProductSpecValueMap productSpecValueMap WHERE ";

	private static final String _SQL_COUNT_PRODUCTSPECVALUEMAP =
		"SELECT COUNT(productSpecValueMap) FROM ProductSpecValueMap productSpecValueMap";

	private static final String _SQL_COUNT_PRODUCTSPECVALUEMAP_WHERE =
		"SELECT COUNT(productSpecValueMap) FROM ProductSpecValueMap productSpecValueMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productSpecValueMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductSpecValueMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductSpecValueMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSpecValueMapPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}