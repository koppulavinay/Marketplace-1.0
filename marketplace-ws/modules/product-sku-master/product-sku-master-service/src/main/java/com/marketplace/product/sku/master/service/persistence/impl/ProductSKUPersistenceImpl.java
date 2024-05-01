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

package com.marketplace.product.sku.master.service.persistence.impl;

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

import com.marketplace.product.sku.master.exception.NoSuchProductSKUException;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.model.ProductSKUTable;
import com.marketplace.product.sku.master.model.impl.ProductSKUImpl;
import com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl;
import com.marketplace.product.sku.master.service.persistence.ProductSKUPersistence;
import com.marketplace.product.sku.master.service.persistence.ProductSKUUtil;
import com.marketplace.product.sku.master.service.persistence.impl.constants.marketplace_product_skuPersistenceConstants;

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
 * The persistence implementation for the product sku service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductSKUPersistence.class)
public class ProductSKUPersistenceImpl
	extends BasePersistenceImpl<ProductSKU> implements ProductSKUPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductSKUUtil</code> to access the product sku persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductSKUImpl.class.getName();

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
	 * Returns all the product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
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

		List<ProductSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSKU productSKU : list) {
					if (!uuid.equals(productSKU.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

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
				sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSKU>)QueryUtil.list(
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
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByUuid_First(
			String uuid, OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByUuid_First(uuid, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUuid_First(
		String uuid, OrderByComparator<ProductSKU> orderByComparator) {

		List<ProductSKU> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByUuid_Last(
			String uuid, OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByUuid_Last(uuid, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUuid_Last(
		String uuid, OrderByComparator<ProductSKU> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductSKU> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU[] findByUuid_PrevAndNext(
			long productSKUId, String uuid,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		uuid = Objects.toString(uuid, "");

		ProductSKU productSKU = findByPrimaryKey(productSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductSKU[] array = new ProductSKUImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productSKU, uuid, orderByComparator, true);

			array[1] = productSKU;

			array[2] = getByUuid_PrevAndNext(
				session, productSKU, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSKU getByUuid_PrevAndNext(
		Session session, ProductSKU productSKU, String uuid,
		OrderByComparator<ProductSKU> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

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
			sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(productSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductSKU productSKU :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSKU);
		}
	}

	/**
	 * Returns the number of product skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product skus
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

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
		"productSKU.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productSKU.uuid IS NULL OR productSKU.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByUUID_G(uuid, groupId);

		if (productSKU == null) {
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

			throw new NoSuchProductSKUException(sb.toString());
		}

		return productSKU;
	}

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUUID_G(
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

		if (result instanceof ProductSKU) {
			ProductSKU productSKU = (ProductSKU)result;

			if (!Objects.equals(uuid, productSKU.getUuid()) ||
				(groupId != productSKU.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

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

				List<ProductSKU> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductSKU productSKU = list.get(0);

					result = productSKU;

					cacheResult(productSKU);
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
			return (ProductSKU)result;
		}
	}

	/**
	 * Removes the product sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product sku that was removed
	 */
	@Override
	public ProductSKU removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = findByUUID_G(uuid, groupId);

		return remove(productSKU);
	}

	/**
	 * Returns the number of product skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product skus
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

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
		"productSKU.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productSKU.uuid IS NULL OR productSKU.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productSKU.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
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

		List<ProductSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSKU productSKU : list) {
					if (!uuid.equals(productSKU.getUuid()) ||
						(companyId != productSKU.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

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
				sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSKU>)QueryUtil.list(
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
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the first product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSKU> orderByComparator) {

		List<ProductSKU> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the last product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSKU> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductSKU> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU[] findByUuid_C_PrevAndNext(
			long productSKUId, String uuid, long companyId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		uuid = Objects.toString(uuid, "");

		ProductSKU productSKU = findByPrimaryKey(productSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductSKU[] array = new ProductSKUImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productSKU, uuid, companyId, orderByComparator, true);

			array[1] = productSKU;

			array[2] = getByUuid_C_PrevAndNext(
				session, productSKU, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSKU getByUuid_C_PrevAndNext(
		Session session, ProductSKU productSKU, String uuid, long companyId,
		OrderByComparator<ProductSKU> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

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
			sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(productSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductSKU productSKU :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSKU);
		}
	}

	/**
	 * Returns the number of product skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product skus
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

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
		"productSKU.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productSKU.uuid IS NULL OR productSKU.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productSKU.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBySkuDraftProductId;
	private FinderPath _finderPathWithoutPaginationFindBySkuDraftProductId;
	private FinderPath _finderPathCountBySkuDraftProductId;

	/**
	 * Returns all the product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product skus
	 */
	@Override
	public List<ProductSKU> findBySkuDraftProductId(long draftProductId) {
		return findBySkuDraftProductId(
			draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	@Override
	public List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end) {

		return findBySkuDraftProductId(draftProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return findBySkuDraftProductId(
			draftProductId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findBySkuDraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySkuDraftProductId;
				finderArgs = new Object[] {draftProductId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySkuDraftProductId;
			finderArgs = new Object[] {
				draftProductId, start, end, orderByComparator
			};
		}

		List<ProductSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSKU productSKU : list) {
					if (draftProductId != productSKU.getDraftProductId()) {
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

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

			sb.append(_FINDER_COLUMN_SKUDRAFTPRODUCTID_DRAFTPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				list = (List<ProductSKU>)QueryUtil.list(
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
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findBySkuDraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchBySkuDraftProductId_First(
			draftProductId, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchBySkuDraftProductId_First(
		long draftProductId, OrderByComparator<ProductSKU> orderByComparator) {

		List<ProductSKU> list = findBySkuDraftProductId(
			draftProductId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findBySkuDraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchBySkuDraftProductId_Last(
			draftProductId, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchBySkuDraftProductId_Last(
		long draftProductId, OrderByComparator<ProductSKU> orderByComparator) {

		int count = countBySkuDraftProductId(draftProductId);

		if (count == 0) {
			return null;
		}

		List<ProductSKU> list = findBySkuDraftProductId(
			draftProductId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU[] findBySkuDraftProductId_PrevAndNext(
			long productSKUId, long draftProductId,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = findByPrimaryKey(productSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductSKU[] array = new ProductSKUImpl[3];

			array[0] = getBySkuDraftProductId_PrevAndNext(
				session, productSKU, draftProductId, orderByComparator, true);

			array[1] = productSKU;

			array[2] = getBySkuDraftProductId_PrevAndNext(
				session, productSKU, draftProductId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSKU getBySkuDraftProductId_PrevAndNext(
		Session session, ProductSKU productSKU, long draftProductId,
		OrderByComparator<ProductSKU> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

		sb.append(_FINDER_COLUMN_SKUDRAFTPRODUCTID_DRAFTPRODUCTID_2);

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
			sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(productSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product skus where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	@Override
	public void removeBySkuDraftProductId(long draftProductId) {
		for (ProductSKU productSKU :
				findBySkuDraftProductId(
					draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSKU);
		}
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product skus
	 */
	@Override
	public int countBySkuDraftProductId(long draftProductId) {
		FinderPath finderPath = _finderPathCountBySkuDraftProductId;

		Object[] finderArgs = new Object[] {draftProductId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

			sb.append(_FINDER_COLUMN_SKUDRAFTPRODUCTID_DRAFTPRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

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
		_FINDER_COLUMN_SKUDRAFTPRODUCTID_DRAFTPRODUCTID_2 =
			"productSKU.draftProductId = ?";

	private FinderPath _finderPathFetchByDraftProductIdNDefaultSKU;
	private FinderPath _finderPathCountByDraftProductIdNDefaultSKU;

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);

		if (productSKU == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("draftProductId=");
			sb.append(draftProductId);

			sb.append(", defaultSku=");
			sb.append(defaultSku);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductSKUException(sb.toString());
		}

		return productSKU;
	}

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku) {

		return fetchByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku, true);
	}

	/**
	 * Returns the product sku where draftProductId = &#63; and defaultSku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku, boolean useFinderCache) {

		defaultSku = Objects.toString(defaultSku, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {draftProductId, defaultSku};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDraftProductIdNDefaultSKU, finderArgs, this);
		}

		if (result instanceof ProductSKU) {
			ProductSKU productSKU = (ProductSKU)result;

			if ((draftProductId != productSKU.getDraftProductId()) ||
				!Objects.equals(defaultSku, productSKU.getDefaultSku())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

			sb.append(
				_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DRAFTPRODUCTID_2);

			boolean bindDefaultSku = false;

			if (defaultSku.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_3);
			}
			else {
				bindDefaultSku = true;

				sb.append(
					_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindDefaultSku) {
					queryPos.add(defaultSku);
				}

				List<ProductSKU> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDraftProductIdNDefaultSKU,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									draftProductId, defaultSku
								};
							}

							_log.warn(
								"ProductSKUPersistenceImpl.fetchByDraftProductIdNDefaultSKU(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductSKU productSKU = list.get(0);

					result = productSKU;

					cacheResult(productSKU);
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
			return (ProductSKU)result;
		}
	}

	/**
	 * Removes the product sku where draftProductId = &#63; and defaultSku = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the product sku that was removed
	 */
	@Override
	public ProductSKU removeByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSku)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = findByDraftProductIdNDefaultSKU(
			draftProductId, defaultSku);

		return remove(productSKU);
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63; and defaultSku = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param defaultSku the default sku
	 * @return the number of matching product skus
	 */
	@Override
	public int countByDraftProductIdNDefaultSKU(
		long draftProductId, String defaultSku) {

		defaultSku = Objects.toString(defaultSku, "");

		FinderPath finderPath = _finderPathCountByDraftProductIdNDefaultSKU;

		Object[] finderArgs = new Object[] {draftProductId, defaultSku};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

			sb.append(
				_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DRAFTPRODUCTID_2);

			boolean bindDefaultSku = false;

			if (defaultSku.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_3);
			}
			else {
				bindDefaultSku = true;

				sb.append(
					_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindDefaultSku) {
					queryPos.add(defaultSku);
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

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DRAFTPRODUCTID_2 =
			"productSKU.draftProductId = ? AND ";

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_2 =
			"productSKU.defaultSku = ?";

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNDEFAULTSKU_DEFAULTSKU_3 =
			"(productSKU.defaultSku IS NULL OR productSKU.defaultSku = '')";

	private FinderPath _finderPathWithPaginationFindByDraftProductIdNSkuName;
	private FinderPath _finderPathWithoutPaginationFindByDraftProductIdNSkuName;
	private FinderPath _finderPathCountByDraftProductIdNSkuName;

	/**
	 * Returns all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the matching product skus
	 */
	@Override
	public List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		return findByDraftProductIdNSkuName(
			draftProductId, skuName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end) {

		return findByDraftProductIdNSkuName(
			draftProductId, skuName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return findByDraftProductIdNSkuName(
			draftProductId, skuName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product skus
	 */
	@Override
	public List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator,
		boolean useFinderCache) {

		skuName = Objects.toString(skuName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDraftProductIdNSkuName;
				finderArgs = new Object[] {draftProductId, skuName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDraftProductIdNSkuName;
			finderArgs = new Object[] {
				draftProductId, skuName, start, end, orderByComparator
			};
		}

		List<ProductSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSKU productSKU : list) {
					if ((draftProductId != productSKU.getDraftProductId()) ||
						!skuName.equals(productSKU.getSkuName())) {

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

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_DRAFTPRODUCTID_2);

			boolean bindSkuName = false;

			if (skuName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_3);
			}
			else {
				bindSkuName = true;

				sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindSkuName) {
					queryPos.add(skuName);
				}

				list = (List<ProductSKU>)QueryUtil.list(
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
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByDraftProductIdNSkuName_First(
			long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByDraftProductIdNSkuName_First(
			draftProductId, skuName, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", skuName=");
		sb.append(skuName);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the first product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByDraftProductIdNSkuName_First(
		long draftProductId, String skuName,
		OrderByComparator<ProductSKU> orderByComparator) {

		List<ProductSKU> list = findByDraftProductIdNSkuName(
			draftProductId, skuName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findByDraftProductIdNSkuName_Last(
			long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByDraftProductIdNSkuName_Last(
			draftProductId, skuName, orderByComparator);

		if (productSKU != null) {
			return productSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", skuName=");
		sb.append(skuName);

		sb.append("}");

		throw new NoSuchProductSKUException(sb.toString());
	}

	/**
	 * Returns the last product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchByDraftProductIdNSkuName_Last(
		long draftProductId, String skuName,
		OrderByComparator<ProductSKU> orderByComparator) {

		int count = countByDraftProductIdNSkuName(draftProductId, skuName);

		if (count == 0) {
			return null;
		}

		List<ProductSKU> list = findByDraftProductIdNSkuName(
			draftProductId, skuName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product skus before and after the current product sku in the ordered set where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param productSKUId the primary key of the current product sku
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU[] findByDraftProductIdNSkuName_PrevAndNext(
			long productSKUId, long draftProductId, String skuName,
			OrderByComparator<ProductSKU> orderByComparator)
		throws NoSuchProductSKUException {

		skuName = Objects.toString(skuName, "");

		ProductSKU productSKU = findByPrimaryKey(productSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductSKU[] array = new ProductSKUImpl[3];

			array[0] = getByDraftProductIdNSkuName_PrevAndNext(
				session, productSKU, draftProductId, skuName, orderByComparator,
				true);

			array[1] = productSKU;

			array[2] = getByDraftProductIdNSkuName_PrevAndNext(
				session, productSKU, draftProductId, skuName, orderByComparator,
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

	protected ProductSKU getByDraftProductIdNSkuName_PrevAndNext(
		Session session, ProductSKU productSKU, long draftProductId,
		String skuName, OrderByComparator<ProductSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

		sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_DRAFTPRODUCTID_2);

		boolean bindSkuName = false;

		if (skuName.isEmpty()) {
			sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_3);
		}
		else {
			bindSkuName = true;

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_2);
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
			sb.append(ProductSKUModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		if (bindSkuName) {
			queryPos.add(skuName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(productSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product skus where draftProductId = &#63; and skuName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 */
	@Override
	public void removeByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		for (ProductSKU productSKU :
				findByDraftProductIdNSkuName(
					draftProductId, skuName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(productSKU);
		}
	}

	/**
	 * Returns the number of product skus where draftProductId = &#63; and skuName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param skuName the sku name
	 * @return the number of matching product skus
	 */
	@Override
	public int countByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		skuName = Objects.toString(skuName, "");

		FinderPath finderPath = _finderPathCountByDraftProductIdNSkuName;

		Object[] finderArgs = new Object[] {draftProductId, skuName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_DRAFTPRODUCTID_2);

			boolean bindSkuName = false;

			if (skuName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_3);
			}
			else {
				bindSkuName = true;

				sb.append(_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindSkuName) {
					queryPos.add(skuName);
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

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_DRAFTPRODUCTID_2 =
			"productSKU.draftProductId = ? AND ";

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_2 =
			"productSKU.skuName = ?";

	private static final String
		_FINDER_COLUMN_DRAFTPRODUCTIDNSKUNAME_SKUNAME_3 =
			"(productSKU.skuName IS NULL OR productSKU.skuName = '')";

	private FinderPath _finderPathFetchBySkuId;
	private FinderPath _finderPathCountBySkuId;

	/**
	 * Returns the product sku where skuId = &#63; or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku
	 * @throws NoSuchProductSKUException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU findBySkuId(String skuId)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchBySkuId(skuId);

		if (productSKU == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("skuId=");
			sb.append(skuId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductSKUException(sb.toString());
		}

		return productSKU;
	}

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param skuId the sku ID
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchBySkuId(String skuId) {
		return fetchBySkuId(skuId, true);
	}

	/**
	 * Returns the product sku where skuId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param skuId the sku ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchBySkuId(String skuId, boolean useFinderCache) {
		skuId = Objects.toString(skuId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {skuId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySkuId, finderArgs, this);
		}

		if (result instanceof ProductSKU) {
			ProductSKU productSKU = (ProductSKU)result;

			if (!Objects.equals(skuId, productSKU.getSkuId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTSKU_WHERE);

			boolean bindSkuId = false;

			if (skuId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SKUID_SKUID_3);
			}
			else {
				bindSkuId = true;

				sb.append(_FINDER_COLUMN_SKUID_SKUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSkuId) {
					queryPos.add(skuId);
				}

				List<ProductSKU> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySkuId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {skuId};
							}

							_log.warn(
								"ProductSKUPersistenceImpl.fetchBySkuId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductSKU productSKU = list.get(0);

					result = productSKU;

					cacheResult(productSKU);
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
			return (ProductSKU)result;
		}
	}

	/**
	 * Removes the product sku where skuId = &#63; from the database.
	 *
	 * @param skuId the sku ID
	 * @return the product sku that was removed
	 */
	@Override
	public ProductSKU removeBySkuId(String skuId)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = findBySkuId(skuId);

		return remove(productSKU);
	}

	/**
	 * Returns the number of product skus where skuId = &#63;.
	 *
	 * @param skuId the sku ID
	 * @return the number of matching product skus
	 */
	@Override
	public int countBySkuId(String skuId) {
		skuId = Objects.toString(skuId, "");

		FinderPath finderPath = _finderPathCountBySkuId;

		Object[] finderArgs = new Object[] {skuId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSKU_WHERE);

			boolean bindSkuId = false;

			if (skuId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SKUID_SKUID_3);
			}
			else {
				bindSkuId = true;

				sb.append(_FINDER_COLUMN_SKUID_SKUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSkuId) {
					queryPos.add(skuId);
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

	private static final String _FINDER_COLUMN_SKUID_SKUID_2 =
		"productSKU.skuId = ?";

	private static final String _FINDER_COLUMN_SKUID_SKUID_3 =
		"(productSKU.skuId IS NULL OR productSKU.skuId = '')";

	public ProductSKUPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductSKU.class);

		setModelImplClass(ProductSKUImpl.class);
		setModelPKClass(long.class);

		setTable(ProductSKUTable.INSTANCE);
	}

	/**
	 * Caches the product sku in the entity cache if it is enabled.
	 *
	 * @param productSKU the product sku
	 */
	@Override
	public void cacheResult(ProductSKU productSKU) {
		entityCache.putResult(
			ProductSKUImpl.class, productSKU.getPrimaryKey(), productSKU);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {productSKU.getUuid(), productSKU.getGroupId()},
			productSKU);

		finderCache.putResult(
			_finderPathFetchByDraftProductIdNDefaultSKU,
			new Object[] {
				productSKU.getDraftProductId(), productSKU.getDefaultSku()
			},
			productSKU);

		finderCache.putResult(
			_finderPathFetchBySkuId, new Object[] {productSKU.getSkuId()},
			productSKU);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product skus in the entity cache if it is enabled.
	 *
	 * @param productSKUs the product skus
	 */
	@Override
	public void cacheResult(List<ProductSKU> productSKUs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productSKUs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductSKU productSKU : productSKUs) {
			if (entityCache.getResult(
					ProductSKUImpl.class, productSKU.getPrimaryKey()) == null) {

				cacheResult(productSKU);
			}
		}
	}

	/**
	 * Clears the cache for all product skus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductSKUImpl.class);

		finderCache.clearCache(ProductSKUImpl.class);
	}

	/**
	 * Clears the cache for the product sku.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductSKU productSKU) {
		entityCache.removeResult(ProductSKUImpl.class, productSKU);
	}

	@Override
	public void clearCache(List<ProductSKU> productSKUs) {
		for (ProductSKU productSKU : productSKUs) {
			entityCache.removeResult(ProductSKUImpl.class, productSKU);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductSKUImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductSKUImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductSKUModelImpl productSKUModelImpl) {

		Object[] args = new Object[] {
			productSKUModelImpl.getUuid(), productSKUModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productSKUModelImpl);

		args = new Object[] {
			productSKUModelImpl.getDraftProductId(),
			productSKUModelImpl.getDefaultSku()
		};

		finderCache.putResult(
			_finderPathCountByDraftProductIdNDefaultSKU, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDraftProductIdNDefaultSKU, args,
			productSKUModelImpl);

		args = new Object[] {productSKUModelImpl.getSkuId()};

		finderCache.putResult(_finderPathCountBySkuId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySkuId, args, productSKUModelImpl);
	}

	/**
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	@Override
	public ProductSKU create(long productSKUId) {
		ProductSKU productSKU = new ProductSKUImpl();

		productSKU.setNew(true);
		productSKU.setPrimaryKey(productSKUId);

		String uuid = _portalUUID.generate();

		productSKU.setUuid(uuid);

		productSKU.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productSKU;
	}

	/**
	 * Removes the product sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku that was removed
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU remove(long productSKUId)
		throws NoSuchProductSKUException {

		return remove((Serializable)productSKUId);
	}

	/**
	 * Removes the product sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product sku
	 * @return the product sku that was removed
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU remove(Serializable primaryKey)
		throws NoSuchProductSKUException {

		Session session = null;

		try {
			session = openSession();

			ProductSKU productSKU = (ProductSKU)session.get(
				ProductSKUImpl.class, primaryKey);

			if (productSKU == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSKUException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productSKU);
		}
		catch (NoSuchProductSKUException noSuchEntityException) {
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
	protected ProductSKU removeImpl(ProductSKU productSKU) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSKU)) {
				productSKU = (ProductSKU)session.get(
					ProductSKUImpl.class, productSKU.getPrimaryKeyObj());
			}

			if (productSKU != null) {
				session.delete(productSKU);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productSKU != null) {
			clearCache(productSKU);
		}

		return productSKU;
	}

	@Override
	public ProductSKU updateImpl(ProductSKU productSKU) {
		boolean isNew = productSKU.isNew();

		if (!(productSKU instanceof ProductSKUModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productSKU.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(productSKU);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productSKU proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductSKU implementation " +
					productSKU.getClass());
		}

		ProductSKUModelImpl productSKUModelImpl =
			(ProductSKUModelImpl)productSKU;

		if (Validator.isNull(productSKU.getUuid())) {
			String uuid = _portalUUID.generate();

			productSKU.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productSKU.getCreateDate() == null)) {
			if (serviceContext == null) {
				productSKU.setCreateDate(date);
			}
			else {
				productSKU.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!productSKUModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productSKU.setModifiedDate(date);
			}
			else {
				productSKU.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productSKU);
			}
			else {
				productSKU = (ProductSKU)session.merge(productSKU);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductSKUImpl.class, productSKUModelImpl, false, true);

		cacheUniqueFindersCache(productSKUModelImpl);

		if (isNew) {
			productSKU.setNew(false);
		}

		productSKU.resetOriginalValues();

		return productSKU;
	}

	/**
	 * Returns the product sku with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product sku
	 * @return the product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSKUException {

		ProductSKU productSKU = fetchByPrimaryKey(primaryKey);

		if (productSKU == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSKUException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productSKU;
	}

	/**
	 * Returns the product sku with the primary key or throws a <code>NoSuchProductSKUException</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws NoSuchProductSKUException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU findByPrimaryKey(long productSKUId)
		throws NoSuchProductSKUException {

		return findByPrimaryKey((Serializable)productSKUId);
	}

	/**
	 * Returns the product sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku, or <code>null</code> if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU fetchByPrimaryKey(long productSKUId) {
		return fetchByPrimaryKey((Serializable)productSKUId);
	}

	/**
	 * Returns all the product skus.
	 *
	 * @return the product skus
	 */
	@Override
	public List<ProductSKU> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of product skus
	 */
	@Override
	public List<ProductSKU> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product skus
	 */
	@Override
	public List<ProductSKU> findAll(
		int start, int end, OrderByComparator<ProductSKU> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product skus
	 */
	@Override
	public List<ProductSKU> findAll(
		int start, int end, OrderByComparator<ProductSKU> orderByComparator,
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

		List<ProductSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductSKU>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTSKU);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSKU;

				sql = sql.concat(ProductSKUModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductSKU>)QueryUtil.list(
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
	 * Removes all the product skus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductSKU productSKU : findAll()) {
			remove(productSKU);
		}
	}

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTSKU);

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
		return "productSKUId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTSKU;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductSKUModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product sku persistence.
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

		_finderPathWithPaginationFindBySkuDraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySkuDraftProductId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"draftProductId"}, true);

		_finderPathWithoutPaginationFindBySkuDraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySkuDraftProductId", new String[] {Long.class.getName()},
			new String[] {"draftProductId"}, true);

		_finderPathCountBySkuDraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySkuDraftProductId", new String[] {Long.class.getName()},
			new String[] {"draftProductId"}, false);

		_finderPathFetchByDraftProductIdNDefaultSKU = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDraftProductIdNDefaultSKU",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "defaultSku"}, true);

		_finderPathCountByDraftProductIdNDefaultSKU = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDraftProductIdNDefaultSKU",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "defaultSku"}, false);

		_finderPathWithPaginationFindByDraftProductIdNSkuName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDraftProductIdNSkuName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"draftProductId", "skuName"}, true);

		_finderPathWithoutPaginationFindByDraftProductIdNSkuName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDraftProductIdNSkuName",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"draftProductId", "skuName"}, true);

		_finderPathCountByDraftProductIdNSkuName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDraftProductIdNSkuName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "skuName"}, false);

		_finderPathFetchBySkuId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySkuId",
			new String[] {String.class.getName()}, new String[] {"skuId"},
			true);

		_finderPathCountBySkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySkuId",
			new String[] {String.class.getName()}, new String[] {"skuId"},
			false);

		_setProductSKUUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductSKUUtilPersistence(null);

		entityCache.removeCache(ProductSKUImpl.class.getName());
	}

	private void _setProductSKUUtilPersistence(
		ProductSKUPersistence productSKUPersistence) {

		try {
			Field field = ProductSKUUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, productSKUPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_product_skuPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_product_skuPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_product_skuPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTSKU =
		"SELECT productSKU FROM ProductSKU productSKU";

	private static final String _SQL_SELECT_PRODUCTSKU_WHERE =
		"SELECT productSKU FROM ProductSKU productSKU WHERE ";

	private static final String _SQL_COUNT_PRODUCTSKU =
		"SELECT COUNT(productSKU) FROM ProductSKU productSKU";

	private static final String _SQL_COUNT_PRODUCTSKU_WHERE =
		"SELECT COUNT(productSKU) FROM ProductSKU productSKU WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productSKU.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductSKU exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductSKU exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSKUPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}