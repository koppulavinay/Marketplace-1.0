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

package com.marketplace.product.mediasku.master.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.marketplace.product.mediasku.master.exception.NoSuchProductMediaSKUException;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.model.ProductMediaSKUTable;
import com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUImpl;
import com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl;
import com.marketplace.product.mediasku.master.service.persistence.ProductMediaSKUPersistence;
import com.marketplace.product.mediasku.master.service.persistence.ProductMediaSKUUtil;
import com.marketplace.product.mediasku.master.service.persistence.impl.constants.marketplace_product_mediaskuPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the product media sku service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductMediaSKUPersistence.class)
public class ProductMediaSKUPersistenceImpl
	extends BasePersistenceImpl<ProductMediaSKU>
	implements ProductMediaSKUPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductMediaSKUUtil</code> to access the product media sku persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductMediaSKUImpl.class.getName();

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
	 * Returns all the product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductMediaSKU productMediaSKU : list) {
					if (!uuid.equals(productMediaSKU.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

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
				sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByUuid_First(
			String uuid, OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByUuid_First(
			uuid, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUuid_First(
		String uuid, OrderByComparator<ProductMediaSKU> orderByComparator) {

		List<ProductMediaSKU> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByUuid_Last(
			String uuid, OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUuid_Last(
		String uuid, OrderByComparator<ProductMediaSKU> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductMediaSKU> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU[] findByUuid_PrevAndNext(
			long ProductMediaSKUId, String uuid,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		uuid = Objects.toString(uuid, "");

		ProductMediaSKU productMediaSKU = findByPrimaryKey(ProductMediaSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU[] array = new ProductMediaSKUImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productMediaSKU, uuid, orderByComparator, true);

			array[1] = productMediaSKU;

			array[2] = getByUuid_PrevAndNext(
				session, productMediaSKU, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductMediaSKU getByUuid_PrevAndNext(
		Session session, ProductMediaSKU productMediaSKU, String uuid,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

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
			sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
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
						productMediaSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductMediaSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product media skus where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductMediaSKU productMediaSKU :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

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
		"productMediaSKU.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productMediaSKU.uuid IS NULL OR productMediaSKU.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByUUID_G(String uuid, long groupId)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByUUID_G(uuid, groupId);

		if (productMediaSKU == null) {
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

			throw new NoSuchProductMediaSKUException(sb.toString());
		}

		return productMediaSKU;
	}

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product media sku where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUUID_G(
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

		if (result instanceof ProductMediaSKU) {
			ProductMediaSKU productMediaSKU = (ProductMediaSKU)result;

			if (!Objects.equals(uuid, productMediaSKU.getUuid()) ||
				(groupId != productMediaSKU.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

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

				List<ProductMediaSKU> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductMediaSKU productMediaSKU = list.get(0);

					result = productMediaSKU;

					cacheResult(productMediaSKU);
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
			return (ProductMediaSKU)result;
		}
	}

	/**
	 * Removes the product media sku where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product media sku that was removed
	 */
	@Override
	public ProductMediaSKU removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = findByUUID_G(uuid, groupId);

		return remove(productMediaSKU);
	}

	/**
	 * Returns the number of product media skus where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

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
		"productMediaSKU.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productMediaSKU.uuid IS NULL OR productMediaSKU.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productMediaSKU.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductMediaSKU productMediaSKU : list) {
					if (!uuid.equals(productMediaSKU.getUuid()) ||
						(companyId != productMediaSKU.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

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
				sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the first product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		List<ProductMediaSKU> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the last product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductMediaSKU> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU[] findByUuid_C_PrevAndNext(
			long ProductMediaSKUId, String uuid, long companyId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		uuid = Objects.toString(uuid, "");

		ProductMediaSKU productMediaSKU = findByPrimaryKey(ProductMediaSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU[] array = new ProductMediaSKUImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productMediaSKU, uuid, companyId, orderByComparator,
				true);

			array[1] = productMediaSKU;

			array[2] = getByUuid_C_PrevAndNext(
				session, productMediaSKU, uuid, companyId, orderByComparator,
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

	protected ProductMediaSKU getByUuid_C_PrevAndNext(
		Session session, ProductMediaSKU productMediaSKU, String uuid,
		long companyId, OrderByComparator<ProductMediaSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

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
			sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
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
						productMediaSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductMediaSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product media skus where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductMediaSKU productMediaSKU :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

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
		"productMediaSKU.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productMediaSKU.uuid IS NULL OR productMediaSKU.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productMediaSKU.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByproductSKUIdWithDraftProductId;
	private FinderPath
		_finderPathWithoutPaginationFindByproductSKUIdWithDraftProductId;
	private FinderPath _finderPathCountByproductSKUIdWithDraftProductId;

	/**
	 * Returns all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		return findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end) {

		return findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByproductSKUIdWithDraftProductId;
				finderArgs = new Object[] {draftProductId, productSKUId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByproductSKUIdWithDraftProductId;
			finderArgs = new Object[] {
				draftProductId, productSKUId, start, end, orderByComparator
			};
		}

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductMediaSKU productMediaSKU : list) {
					if ((draftProductId !=
							productMediaSKU.getDraftProductId()) ||
						(productSKUId != productMediaSKU.getProductSKUId())) {

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

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_DRAFTPRODUCTID_2);

			sb.append(
				_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_PRODUCTSKUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				queryPos.add(productSKUId);

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByproductSKUIdWithDraftProductId_First(
			long draftProductId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU =
			fetchByproductSKUIdWithDraftProductId_First(
				draftProductId, productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the first product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByproductSKUIdWithDraftProductId_First(
		long draftProductId, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		List<ProductMediaSKU> list = findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByproductSKUIdWithDraftProductId_Last(
			long draftProductId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU =
			fetchByproductSKUIdWithDraftProductId_Last(
				draftProductId, productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the last product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByproductSKUIdWithDraftProductId_Last(
		long draftProductId, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		int count = countByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId);

		if (count == 0) {
			return null;
		}

		List<ProductMediaSKU> list = findByproductSKUIdWithDraftProductId(
			draftProductId, productSKUId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU[] findByproductSKUIdWithDraftProductId_PrevAndNext(
			long ProductMediaSKUId, long draftProductId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = findByPrimaryKey(ProductMediaSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU[] array = new ProductMediaSKUImpl[3];

			array[0] = getByproductSKUIdWithDraftProductId_PrevAndNext(
				session, productMediaSKU, draftProductId, productSKUId,
				orderByComparator, true);

			array[1] = productMediaSKU;

			array[2] = getByproductSKUIdWithDraftProductId_PrevAndNext(
				session, productMediaSKU, draftProductId, productSKUId,
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

	protected ProductMediaSKU getByproductSKUIdWithDraftProductId_PrevAndNext(
		Session session, ProductMediaSKU productMediaSKU, long draftProductId,
		long productSKUId, OrderByComparator<ProductMediaSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

		sb.append(
			_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_DRAFTPRODUCTID_2);

		sb.append(_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_PRODUCTSKUID_2);

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
			sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		queryPos.add(productSKUId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productMediaSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductMediaSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product media skus where draftProductId = &#63; and productSKUId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 */
	@Override
	public void removeByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		for (ProductMediaSKU productMediaSKU :
				findByproductSKUIdWithDraftProductId(
					draftProductId, productSKUId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus where draftProductId = &#63; and productSKUId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByproductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		FinderPath finderPath =
			_finderPathCountByproductSKUIdWithDraftProductId;

		Object[] finderArgs = new Object[] {draftProductId, productSKUId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

			sb.append(
				_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_DRAFTPRODUCTID_2);

			sb.append(
				_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_PRODUCTSKUID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				queryPos.add(productSKUId);

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
		_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_DRAFTPRODUCTID_2 =
			"productMediaSKU.draftProductId = ? AND ";

	private static final String
		_FINDER_COLUMN_PRODUCTSKUIDWITHDRAFTPRODUCTID_PRODUCTSKUID_2 =
			"productMediaSKU.productSKUId = ?";

	private FinderPath _finderPathWithPaginationFindByproductSkuId;
	private FinderPath _finderPathWithoutPaginationFindByproductSkuId;
	private FinderPath _finderPathCountByproductSkuId;

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSkuId(long productSKUId) {
		return findByproductSkuId(
			productSKUId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end) {

		return findByproductSkuId(productSKUId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findByproductSkuId(
			productSKUId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByproductSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByproductSkuId;
				finderArgs = new Object[] {productSKUId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByproductSkuId;
			finderArgs = new Object[] {
				productSKUId, start, end, orderByComparator
			};
		}

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductMediaSKU productMediaSKU : list) {
					if (productSKUId != productMediaSKU.getProductSKUId()) {
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

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTSKUID_PRODUCTSKUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSKUId);

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByproductSkuId_First(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByproductSkuId_First(
			productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByproductSkuId_First(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		List<ProductMediaSKU> list = findByproductSkuId(
			productSKUId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByproductSkuId_Last(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByproductSkuId_Last(
			productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByproductSkuId_Last(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		int count = countByproductSkuId(productSKUId);

		if (count == 0) {
			return null;
		}

		List<ProductMediaSKU> list = findByproductSkuId(
			productSKUId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU[] findByproductSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = findByPrimaryKey(ProductMediaSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU[] array = new ProductMediaSKUImpl[3];

			array[0] = getByproductSkuId_PrevAndNext(
				session, productMediaSKU, productSKUId, orderByComparator,
				true);

			array[1] = productMediaSKU;

			array[2] = getByproductSkuId_PrevAndNext(
				session, productMediaSKU, productSKUId, orderByComparator,
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

	protected ProductMediaSKU getByproductSkuId_PrevAndNext(
		Session session, ProductMediaSKU productMediaSKU, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTSKUID_PRODUCTSKUID_2);

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
			sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productSKUId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productMediaSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductMediaSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	@Override
	public void removeByproductSkuId(long productSKUId) {
		for (ProductMediaSKU productMediaSKU :
				findByproductSkuId(
					productSKUId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByproductSkuId(long productSKUId) {
		FinderPath finderPath = _finderPathCountByproductSkuId;

		Object[] finderArgs = new Object[] {productSKUId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTSKUID_PRODUCTSKUID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSKUId);

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

	private static final String _FINDER_COLUMN_PRODUCTSKUID_PRODUCTSKUID_2 =
		"productMediaSKU.productSKUId = ?";

	private FinderPath _finderPathWithPaginationFindByProductMediaSkuId;
	private FinderPath _finderPathWithoutPaginationFindByProductMediaSkuId;
	private FinderPath _finderPathCountByProductMediaSkuId;

	/**
	 * Returns all the product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByProductMediaSkuId(long productSKUId) {
		return findByProductMediaSkuId(
			productSKUId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end) {

		return findByProductMediaSkuId(productSKUId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findByProductMediaSkuId(
			productSKUId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus where productSKUId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param productSKUId the product sku ID
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product media skus
	 */
	@Override
	public List<ProductMediaSKU> findByProductMediaSkuId(
		long productSKUId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProductMediaSkuId;
				finderArgs = new Object[] {productSKUId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProductMediaSkuId;
			finderArgs = new Object[] {
				productSKUId, start, end, orderByComparator
			};
		}

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductMediaSKU productMediaSKU : list) {
					if (productSKUId != productMediaSKU.getProductSKUId()) {
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

			sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTMEDIASKUID_PRODUCTSKUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSKUId);

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByProductMediaSkuId_First(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByProductMediaSkuId_First(
			productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the first product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByProductMediaSkuId_First(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		List<ProductMediaSKU> list = findByProductMediaSkuId(
			productSKUId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku
	 * @throws NoSuchProductMediaSKUException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU findByProductMediaSkuId_Last(
			long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByProductMediaSkuId_Last(
			productSKUId, orderByComparator);

		if (productMediaSKU != null) {
			return productMediaSKU;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productSKUId=");
		sb.append(productSKUId);

		sb.append("}");

		throw new NoSuchProductMediaSKUException(sb.toString());
	}

	/**
	 * Returns the last product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchByProductMediaSkuId_Last(
		long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		int count = countByProductMediaSkuId(productSKUId);

		if (count == 0) {
			return null;
		}

		List<ProductMediaSKU> list = findByProductMediaSkuId(
			productSKUId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product media skus before and after the current product media sku in the ordered set where productSKUId = &#63;.
	 *
	 * @param ProductMediaSKUId the primary key of the current product media sku
	 * @param productSKUId the product sku ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU[] findByProductMediaSkuId_PrevAndNext(
			long ProductMediaSKUId, long productSKUId,
			OrderByComparator<ProductMediaSKU> orderByComparator)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = findByPrimaryKey(ProductMediaSKUId);

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU[] array = new ProductMediaSKUImpl[3];

			array[0] = getByProductMediaSkuId_PrevAndNext(
				session, productMediaSKU, productSKUId, orderByComparator,
				true);

			array[1] = productMediaSKU;

			array[2] = getByProductMediaSkuId_PrevAndNext(
				session, productMediaSKU, productSKUId, orderByComparator,
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

	protected ProductMediaSKU getByProductMediaSkuId_PrevAndNext(
		Session session, ProductMediaSKU productMediaSKU, long productSKUId,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTMEDIASKU_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTMEDIASKUID_PRODUCTSKUID_2);

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
			sb.append(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productSKUId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productMediaSKU)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductMediaSKU> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product media skus where productSKUId = &#63; from the database.
	 *
	 * @param productSKUId the product sku ID
	 */
	@Override
	public void removeByProductMediaSkuId(long productSKUId) {
		for (ProductMediaSKU productMediaSKU :
				findByProductMediaSkuId(
					productSKUId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus where productSKUId = &#63;.
	 *
	 * @param productSKUId the product sku ID
	 * @return the number of matching product media skus
	 */
	@Override
	public int countByProductMediaSkuId(long productSKUId) {
		FinderPath finderPath = _finderPathCountByProductMediaSkuId;

		Object[] finderArgs = new Object[] {productSKUId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTMEDIASKU_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTMEDIASKUID_PRODUCTSKUID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productSKUId);

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
		_FINDER_COLUMN_PRODUCTMEDIASKUID_PRODUCTSKUID_2 =
			"productMediaSKU.productSKUId = ?";

	public ProductMediaSKUPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductMediaSKU.class);

		setModelImplClass(ProductMediaSKUImpl.class);
		setModelPKClass(long.class);

		setTable(ProductMediaSKUTable.INSTANCE);
	}

	/**
	 * Caches the product media sku in the entity cache if it is enabled.
	 *
	 * @param productMediaSKU the product media sku
	 */
	@Override
	public void cacheResult(ProductMediaSKU productMediaSKU) {
		entityCache.putResult(
			ProductMediaSKUImpl.class, productMediaSKU.getPrimaryKey(),
			productMediaSKU);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productMediaSKU.getUuid(), productMediaSKU.getGroupId()
			},
			productMediaSKU);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product media skus in the entity cache if it is enabled.
	 *
	 * @param productMediaSKUs the product media skus
	 */
	@Override
	public void cacheResult(List<ProductMediaSKU> productMediaSKUs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productMediaSKUs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductMediaSKU productMediaSKU : productMediaSKUs) {
			if (entityCache.getResult(
					ProductMediaSKUImpl.class,
					productMediaSKU.getPrimaryKey()) == null) {

				cacheResult(productMediaSKU);
			}
		}
	}

	/**
	 * Clears the cache for all product media skus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductMediaSKUImpl.class);

		finderCache.clearCache(ProductMediaSKUImpl.class);
	}

	/**
	 * Clears the cache for the product media sku.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductMediaSKU productMediaSKU) {
		entityCache.removeResult(ProductMediaSKUImpl.class, productMediaSKU);
	}

	@Override
	public void clearCache(List<ProductMediaSKU> productMediaSKUs) {
		for (ProductMediaSKU productMediaSKU : productMediaSKUs) {
			entityCache.removeResult(
				ProductMediaSKUImpl.class, productMediaSKU);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductMediaSKUImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductMediaSKUImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductMediaSKUModelImpl productMediaSKUModelImpl) {

		Object[] args = new Object[] {
			productMediaSKUModelImpl.getUuid(),
			productMediaSKUModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productMediaSKUModelImpl);
	}

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	@Override
	public ProductMediaSKU create(long ProductMediaSKUId) {
		ProductMediaSKU productMediaSKU = new ProductMediaSKUImpl();

		productMediaSKU.setNew(true);
		productMediaSKU.setPrimaryKey(ProductMediaSKUId);

		String uuid = _portalUUID.generate();

		productMediaSKU.setUuid(uuid);

		productMediaSKU.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productMediaSKU;
	}

	/**
	 * Removes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU remove(long ProductMediaSKUId)
		throws NoSuchProductMediaSKUException {

		return remove((Serializable)ProductMediaSKUId);
	}

	/**
	 * Removes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU remove(Serializable primaryKey)
		throws NoSuchProductMediaSKUException {

		Session session = null;

		try {
			session = openSession();

			ProductMediaSKU productMediaSKU = (ProductMediaSKU)session.get(
				ProductMediaSKUImpl.class, primaryKey);

			if (productMediaSKU == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductMediaSKUException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productMediaSKU);
		}
		catch (NoSuchProductMediaSKUException noSuchEntityException) {
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
	protected ProductMediaSKU removeImpl(ProductMediaSKU productMediaSKU) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productMediaSKU)) {
				productMediaSKU = (ProductMediaSKU)session.get(
					ProductMediaSKUImpl.class,
					productMediaSKU.getPrimaryKeyObj());
			}

			if (productMediaSKU != null) {
				session.delete(productMediaSKU);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productMediaSKU != null) {
			clearCache(productMediaSKU);
		}

		return productMediaSKU;
	}

	@Override
	public ProductMediaSKU updateImpl(ProductMediaSKU productMediaSKU) {
		boolean isNew = productMediaSKU.isNew();

		if (!(productMediaSKU instanceof ProductMediaSKUModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productMediaSKU.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productMediaSKU);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productMediaSKU proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductMediaSKU implementation " +
					productMediaSKU.getClass());
		}

		ProductMediaSKUModelImpl productMediaSKUModelImpl =
			(ProductMediaSKUModelImpl)productMediaSKU;

		if (Validator.isNull(productMediaSKU.getUuid())) {
			String uuid = _portalUUID.generate();

			productMediaSKU.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productMediaSKU.getCreateDate() == null)) {
			if (serviceContext == null) {
				productMediaSKU.setCreateDate(date);
			}
			else {
				productMediaSKU.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productMediaSKUModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productMediaSKU.setModifiedDate(date);
			}
			else {
				productMediaSKU.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productMediaSKU);
			}
			else {
				productMediaSKU = (ProductMediaSKU)session.merge(
					productMediaSKU);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductMediaSKUImpl.class, productMediaSKUModelImpl, false, true);

		cacheUniqueFindersCache(productMediaSKUModelImpl);

		if (isNew) {
			productMediaSKU.setNew(false);
		}

		productMediaSKU.resetOriginalValues();

		return productMediaSKU;
	}

	/**
	 * Returns the product media sku with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product media sku
	 * @return the product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductMediaSKUException {

		ProductMediaSKU productMediaSKU = fetchByPrimaryKey(primaryKey);

		if (productMediaSKU == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductMediaSKUException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productMediaSKU;
	}

	/**
	 * Returns the product media sku with the primary key or throws a <code>NoSuchProductMediaSKUException</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws NoSuchProductMediaSKUException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU findByPrimaryKey(long ProductMediaSKUId)
		throws NoSuchProductMediaSKUException {

		return findByPrimaryKey((Serializable)ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku, or <code>null</code> if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU fetchByPrimaryKey(long ProductMediaSKUId) {
		return fetchByPrimaryKey((Serializable)ProductMediaSKUId);
	}

	/**
	 * Returns all the product media skus.
	 *
	 * @return the product media skus
	 */
	@Override
	public List<ProductMediaSKU> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of product media skus
	 */
	@Override
	public List<ProductMediaSKU> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product media skus
	 */
	@Override
	public List<ProductMediaSKU> findAll(
		int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product media skus
	 */
	@Override
	public List<ProductMediaSKU> findAll(
		int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator,
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

		List<ProductMediaSKU> list = null;

		if (useFinderCache) {
			list = (List<ProductMediaSKU>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTMEDIASKU);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTMEDIASKU;

				sql = sql.concat(ProductMediaSKUModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductMediaSKU>)QueryUtil.list(
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
	 * Removes all the product media skus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductMediaSKU productMediaSKU : findAll()) {
			remove(productMediaSKU);
		}
	}

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTMEDIASKU);

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
		return "ProductMediaSKUId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTMEDIASKU;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductMediaSKUModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product media sku persistence.
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

		_finderPathWithPaginationFindByproductSKUIdWithDraftProductId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByproductSKUIdWithDraftProductId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"draftProductId", "productSKUId"}, true);

		_finderPathWithoutPaginationFindByproductSKUIdWithDraftProductId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByproductSKUIdWithDraftProductId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"draftProductId", "productSKUId"}, true);

		_finderPathCountByproductSKUIdWithDraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByproductSKUIdWithDraftProductId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"draftProductId", "productSKUId"}, false);

		_finderPathWithPaginationFindByproductSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproductSkuId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productSKUId"}, true);

		_finderPathWithoutPaginationFindByproductSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproductSkuId",
			new String[] {Long.class.getName()}, new String[] {"productSKUId"},
			true);

		_finderPathCountByproductSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductSkuId",
			new String[] {Long.class.getName()}, new String[] {"productSKUId"},
			false);

		_finderPathWithPaginationFindByProductMediaSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductMediaSkuId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productSKUId"}, true);

		_finderPathWithoutPaginationFindByProductMediaSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProductMediaSkuId", new String[] {Long.class.getName()},
			new String[] {"productSKUId"}, true);

		_finderPathCountByProductMediaSkuId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductMediaSkuId", new String[] {Long.class.getName()},
			new String[] {"productSKUId"}, false);

		_setProductMediaSKUUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductMediaSKUUtilPersistence(null);

		entityCache.removeCache(ProductMediaSKUImpl.class.getName());
	}

	private void _setProductMediaSKUUtilPersistence(
		ProductMediaSKUPersistence productMediaSKUPersistence) {

		try {
			Field field = ProductMediaSKUUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productMediaSKUPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_product_mediaskuPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_product_mediaskuPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_product_mediaskuPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTMEDIASKU =
		"SELECT productMediaSKU FROM ProductMediaSKU productMediaSKU";

	private static final String _SQL_SELECT_PRODUCTMEDIASKU_WHERE =
		"SELECT productMediaSKU FROM ProductMediaSKU productMediaSKU WHERE ";

	private static final String _SQL_COUNT_PRODUCTMEDIASKU =
		"SELECT COUNT(productMediaSKU) FROM ProductMediaSKU productMediaSKU";

	private static final String _SQL_COUNT_PRODUCTMEDIASKU_WHERE =
		"SELECT COUNT(productMediaSKU) FROM ProductMediaSKU productMediaSKU WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productMediaSKU.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductMediaSKU exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductMediaSKU exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductMediaSKUPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}