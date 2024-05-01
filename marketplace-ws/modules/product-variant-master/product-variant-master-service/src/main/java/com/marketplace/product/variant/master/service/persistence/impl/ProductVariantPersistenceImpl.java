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

package com.marketplace.product.variant.master.service.persistence.impl;

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

import com.marketplace.product.variant.master.exception.NoSuchProductVariantException;
import com.marketplace.product.variant.master.model.ProductVariant;
import com.marketplace.product.variant.master.model.ProductVariantTable;
import com.marketplace.product.variant.master.model.impl.ProductVariantImpl;
import com.marketplace.product.variant.master.model.impl.ProductVariantModelImpl;
import com.marketplace.product.variant.master.service.persistence.ProductVariantPersistence;
import com.marketplace.product.variant.master.service.persistence.ProductVariantUtil;
import com.marketplace.product.variant.master.service.persistence.impl.constants.marketplace_product_variantPersistenceConstants;

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
 * The persistence implementation for the product variant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductVariantPersistence.class)
public class ProductVariantPersistenceImpl
	extends BasePersistenceImpl<ProductVariant>
	implements ProductVariantPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductVariantUtil</code> to access the product variant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductVariantImpl.class.getName();

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
	 * Returns all the product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
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

		List<ProductVariant> list = null;

		if (useFinderCache) {
			list = (List<ProductVariant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductVariant productVariant : list) {
					if (!uuid.equals(productVariant.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

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
				sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductVariant>)QueryUtil.list(
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
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByUuid_First(
			String uuid, OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByUuid_First(
			uuid, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUuid_First(
		String uuid, OrderByComparator<ProductVariant> orderByComparator) {

		List<ProductVariant> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByUuid_Last(
			String uuid, OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUuid_Last(
		String uuid, OrderByComparator<ProductVariant> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductVariant> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant[] findByUuid_PrevAndNext(
			long productVariantId, String uuid,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		uuid = Objects.toString(uuid, "");

		ProductVariant productVariant = findByPrimaryKey(productVariantId);

		Session session = null;

		try {
			session = openSession();

			ProductVariant[] array = new ProductVariantImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productVariant, uuid, orderByComparator, true);

			array[1] = productVariant;

			array[2] = getByUuid_PrevAndNext(
				session, productVariant, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductVariant getByUuid_PrevAndNext(
		Session session, ProductVariant productVariant, String uuid,
		OrderByComparator<ProductVariant> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

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
			sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
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
						productVariant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductVariant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product variants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductVariant productVariant :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productVariant);
		}
	}

	/**
	 * Returns the number of product variants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product variants
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTVARIANT_WHERE);

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
		"productVariant.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productVariant.uuid IS NULL OR productVariant.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByUUID_G(String uuid, long groupId)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByUUID_G(uuid, groupId);

		if (productVariant == null) {
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

			throw new NoSuchProductVariantException(sb.toString());
		}

		return productVariant;
	}

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product variant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUUID_G(
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

		if (result instanceof ProductVariant) {
			ProductVariant productVariant = (ProductVariant)result;

			if (!Objects.equals(uuid, productVariant.getUuid()) ||
				(groupId != productVariant.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

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

				List<ProductVariant> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductVariant productVariant = list.get(0);

					result = productVariant;

					cacheResult(productVariant);
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
			return (ProductVariant)result;
		}
	}

	/**
	 * Removes the product variant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product variant that was removed
	 */
	@Override
	public ProductVariant removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = findByUUID_G(uuid, groupId);

		return remove(productVariant);
	}

	/**
	 * Returns the number of product variants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product variants
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTVARIANT_WHERE);

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
		"productVariant.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productVariant.uuid IS NULL OR productVariant.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productVariant.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
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

		List<ProductVariant> list = null;

		if (useFinderCache) {
			list = (List<ProductVariant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductVariant productVariant : list) {
					if (!uuid.equals(productVariant.getUuid()) ||
						(companyId != productVariant.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

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
				sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductVariant>)QueryUtil.list(
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
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the first product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductVariant> orderByComparator) {

		List<ProductVariant> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the last product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductVariant> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductVariant> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant[] findByUuid_C_PrevAndNext(
			long productVariantId, String uuid, long companyId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		uuid = Objects.toString(uuid, "");

		ProductVariant productVariant = findByPrimaryKey(productVariantId);

		Session session = null;

		try {
			session = openSession();

			ProductVariant[] array = new ProductVariantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productVariant, uuid, companyId, orderByComparator,
				true);

			array[1] = productVariant;

			array[2] = getByUuid_C_PrevAndNext(
				session, productVariant, uuid, companyId, orderByComparator,
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

	protected ProductVariant getByUuid_C_PrevAndNext(
		Session session, ProductVariant productVariant, String uuid,
		long companyId, OrderByComparator<ProductVariant> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

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
			sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
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
						productVariant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductVariant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product variants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductVariant productVariant :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productVariant);
		}
	}

	/**
	 * Returns the number of product variants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product variants
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTVARIANT_WHERE);

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
		"productVariant.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productVariant.uuid IS NULL OR productVariant.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productVariant.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBydraftProductId;
	private FinderPath _finderPathWithoutPaginationFindBydraftProductId;
	private FinderPath _finderPathCountBydraftProductId;

	/**
	 * Returns all the product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product variants
	 */
	@Override
	public List<ProductVariant> findBydraftProductId(long draftProductId) {
		return findBydraftProductId(
			draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	@Override
	public List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end) {

		return findBydraftProductId(draftProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return findBydraftProductId(
			draftProductId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydraftProductId;
				finderArgs = new Object[] {draftProductId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydraftProductId;
			finderArgs = new Object[] {
				draftProductId, start, end, orderByComparator
			};
		}

		List<ProductVariant> list = null;

		if (useFinderCache) {
			list = (List<ProductVariant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductVariant productVariant : list) {
					if (draftProductId != productVariant.getDraftProductId()) {
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

			sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				list = (List<ProductVariant>)QueryUtil.list(
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
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchBydraftProductId_First(
			draftProductId, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductVariant> orderByComparator) {

		List<ProductVariant> list = findBydraftProductId(
			draftProductId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchBydraftProductId_Last(
			draftProductId, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductVariant> orderByComparator) {

		int count = countBydraftProductId(draftProductId);

		if (count == 0) {
			return null;
		}

		List<ProductVariant> list = findBydraftProductId(
			draftProductId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant[] findBydraftProductId_PrevAndNext(
			long productVariantId, long draftProductId,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = findByPrimaryKey(productVariantId);

		Session session = null;

		try {
			session = openSession();

			ProductVariant[] array = new ProductVariantImpl[3];

			array[0] = getBydraftProductId_PrevAndNext(
				session, productVariant, draftProductId, orderByComparator,
				true);

			array[1] = productVariant;

			array[2] = getBydraftProductId_PrevAndNext(
				session, productVariant, draftProductId, orderByComparator,
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

	protected ProductVariant getBydraftProductId_PrevAndNext(
		Session session, ProductVariant productVariant, long draftProductId,
		OrderByComparator<ProductVariant> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

		sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

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
			sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productVariant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductVariant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product variants where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	@Override
	public void removeBydraftProductId(long draftProductId) {
		for (ProductVariant productVariant :
				findBydraftProductId(
					draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productVariant);
		}
	}

	/**
	 * Returns the number of product variants where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product variants
	 */
	@Override
	public int countBydraftProductId(long draftProductId) {
		FinderPath finderPath = _finderPathCountBydraftProductId;

		Object[] finderArgs = new Object[] {draftProductId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTVARIANT_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

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

	private static final String _FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2 =
		"productVariant.draftProductId = ?";

	private FinderPath _finderPathWithPaginationFindByvariantNameID;
	private FinderPath _finderPathWithoutPaginationFindByvariantNameID;
	private FinderPath _finderPathCountByvariantNameID;

	/**
	 * Returns all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the matching product variants
	 */
	@Override
	public List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName) {

		return findByvariantNameID(
			draftProductId, variantName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end) {

		return findByvariantNameID(
			draftProductId, variantName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return findByvariantNameID(
			draftProductId, variantName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product variants
	 */
	@Override
	public List<ProductVariant> findByvariantNameID(
		long draftProductId, String variantName, int start, int end,
		OrderByComparator<ProductVariant> orderByComparator,
		boolean useFinderCache) {

		variantName = Objects.toString(variantName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByvariantNameID;
				finderArgs = new Object[] {draftProductId, variantName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByvariantNameID;
			finderArgs = new Object[] {
				draftProductId, variantName, start, end, orderByComparator
			};
		}

		List<ProductVariant> list = null;

		if (useFinderCache) {
			list = (List<ProductVariant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductVariant productVariant : list) {
					if ((draftProductId !=
							productVariant.getDraftProductId()) ||
						!variantName.equals(productVariant.getVariantName())) {

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

			sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

			sb.append(_FINDER_COLUMN_VARIANTNAMEID_DRAFTPRODUCTID_2);

			boolean bindVariantName = false;

			if (variantName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_3);
			}
			else {
				bindVariantName = true;

				sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindVariantName) {
					queryPos.add(variantName);
				}

				list = (List<ProductVariant>)QueryUtil.list(
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
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByvariantNameID_First(
			long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByvariantNameID_First(
			draftProductId, variantName, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", variantName=");
		sb.append(variantName);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the first product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByvariantNameID_First(
		long draftProductId, String variantName,
		OrderByComparator<ProductVariant> orderByComparator) {

		List<ProductVariant> list = findByvariantNameID(
			draftProductId, variantName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant
	 * @throws NoSuchProductVariantException if a matching product variant could not be found
	 */
	@Override
	public ProductVariant findByvariantNameID_Last(
			long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByvariantNameID_Last(
			draftProductId, variantName, orderByComparator);

		if (productVariant != null) {
			return productVariant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", variantName=");
		sb.append(variantName);

		sb.append("}");

		throw new NoSuchProductVariantException(sb.toString());
	}

	/**
	 * Returns the last product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public ProductVariant fetchByvariantNameID_Last(
		long draftProductId, String variantName,
		OrderByComparator<ProductVariant> orderByComparator) {

		int count = countByvariantNameID(draftProductId, variantName);

		if (count == 0) {
			return null;
		}

		List<ProductVariant> list = findByvariantNameID(
			draftProductId, variantName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product variants before and after the current product variant in the ordered set where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param productVariantId the primary key of the current product variant
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant[] findByvariantNameID_PrevAndNext(
			long productVariantId, long draftProductId, String variantName,
			OrderByComparator<ProductVariant> orderByComparator)
		throws NoSuchProductVariantException {

		variantName = Objects.toString(variantName, "");

		ProductVariant productVariant = findByPrimaryKey(productVariantId);

		Session session = null;

		try {
			session = openSession();

			ProductVariant[] array = new ProductVariantImpl[3];

			array[0] = getByvariantNameID_PrevAndNext(
				session, productVariant, draftProductId, variantName,
				orderByComparator, true);

			array[1] = productVariant;

			array[2] = getByvariantNameID_PrevAndNext(
				session, productVariant, draftProductId, variantName,
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

	protected ProductVariant getByvariantNameID_PrevAndNext(
		Session session, ProductVariant productVariant, long draftProductId,
		String variantName, OrderByComparator<ProductVariant> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTVARIANT_WHERE);

		sb.append(_FINDER_COLUMN_VARIANTNAMEID_DRAFTPRODUCTID_2);

		boolean bindVariantName = false;

		if (variantName.isEmpty()) {
			sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_3);
		}
		else {
			bindVariantName = true;

			sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_2);
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
			sb.append(ProductVariantModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		if (bindVariantName) {
			queryPos.add(variantName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productVariant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductVariant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product variants where draftProductId = &#63; and variantName = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 */
	@Override
	public void removeByvariantNameID(long draftProductId, String variantName) {
		for (ProductVariant productVariant :
				findByvariantNameID(
					draftProductId, variantName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(productVariant);
		}
	}

	/**
	 * Returns the number of product variants where draftProductId = &#63; and variantName = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantName the variant name
	 * @return the number of matching product variants
	 */
	@Override
	public int countByvariantNameID(long draftProductId, String variantName) {
		variantName = Objects.toString(variantName, "");

		FinderPath finderPath = _finderPathCountByvariantNameID;

		Object[] finderArgs = new Object[] {draftProductId, variantName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTVARIANT_WHERE);

			sb.append(_FINDER_COLUMN_VARIANTNAMEID_DRAFTPRODUCTID_2);

			boolean bindVariantName = false;

			if (variantName.isEmpty()) {
				sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_3);
			}
			else {
				bindVariantName = true;

				sb.append(_FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindVariantName) {
					queryPos.add(variantName);
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

	private static final String _FINDER_COLUMN_VARIANTNAMEID_DRAFTPRODUCTID_2 =
		"productVariant.draftProductId = ? AND ";

	private static final String _FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_2 =
		"productVariant.variantName = ?";

	private static final String _FINDER_COLUMN_VARIANTNAMEID_VARIANTNAME_3 =
		"(productVariant.variantName IS NULL OR productVariant.variantName = '')";

	public ProductVariantPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductVariant.class);

		setModelImplClass(ProductVariantImpl.class);
		setModelPKClass(long.class);

		setTable(ProductVariantTable.INSTANCE);
	}

	/**
	 * Caches the product variant in the entity cache if it is enabled.
	 *
	 * @param productVariant the product variant
	 */
	@Override
	public void cacheResult(ProductVariant productVariant) {
		entityCache.putResult(
			ProductVariantImpl.class, productVariant.getPrimaryKey(),
			productVariant);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productVariant.getUuid(), productVariant.getGroupId()
			},
			productVariant);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product variants in the entity cache if it is enabled.
	 *
	 * @param productVariants the product variants
	 */
	@Override
	public void cacheResult(List<ProductVariant> productVariants) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productVariants.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductVariant productVariant : productVariants) {
			if (entityCache.getResult(
					ProductVariantImpl.class, productVariant.getPrimaryKey()) ==
						null) {

				cacheResult(productVariant);
			}
		}
	}

	/**
	 * Clears the cache for all product variants.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductVariantImpl.class);

		finderCache.clearCache(ProductVariantImpl.class);
	}

	/**
	 * Clears the cache for the product variant.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductVariant productVariant) {
		entityCache.removeResult(ProductVariantImpl.class, productVariant);
	}

	@Override
	public void clearCache(List<ProductVariant> productVariants) {
		for (ProductVariant productVariant : productVariants) {
			entityCache.removeResult(ProductVariantImpl.class, productVariant);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductVariantImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductVariantImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductVariantModelImpl productVariantModelImpl) {

		Object[] args = new Object[] {
			productVariantModelImpl.getUuid(),
			productVariantModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productVariantModelImpl);
	}

	/**
	 * Creates a new product variant with the primary key. Does not add the product variant to the database.
	 *
	 * @param productVariantId the primary key for the new product variant
	 * @return the new product variant
	 */
	@Override
	public ProductVariant create(long productVariantId) {
		ProductVariant productVariant = new ProductVariantImpl();

		productVariant.setNew(true);
		productVariant.setPrimaryKey(productVariantId);

		String uuid = _portalUUID.generate();

		productVariant.setUuid(uuid);

		productVariant.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productVariant;
	}

	/**
	 * Removes the product variant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant that was removed
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant remove(long productVariantId)
		throws NoSuchProductVariantException {

		return remove((Serializable)productVariantId);
	}

	/**
	 * Removes the product variant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product variant
	 * @return the product variant that was removed
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant remove(Serializable primaryKey)
		throws NoSuchProductVariantException {

		Session session = null;

		try {
			session = openSession();

			ProductVariant productVariant = (ProductVariant)session.get(
				ProductVariantImpl.class, primaryKey);

			if (productVariant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductVariantException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productVariant);
		}
		catch (NoSuchProductVariantException noSuchEntityException) {
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
	protected ProductVariant removeImpl(ProductVariant productVariant) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productVariant)) {
				productVariant = (ProductVariant)session.get(
					ProductVariantImpl.class,
					productVariant.getPrimaryKeyObj());
			}

			if (productVariant != null) {
				session.delete(productVariant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productVariant != null) {
			clearCache(productVariant);
		}

		return productVariant;
	}

	@Override
	public ProductVariant updateImpl(ProductVariant productVariant) {
		boolean isNew = productVariant.isNew();

		if (!(productVariant instanceof ProductVariantModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productVariant.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productVariant);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productVariant proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductVariant implementation " +
					productVariant.getClass());
		}

		ProductVariantModelImpl productVariantModelImpl =
			(ProductVariantModelImpl)productVariant;

		if (Validator.isNull(productVariant.getUuid())) {
			String uuid = _portalUUID.generate();

			productVariant.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productVariant.getCreateDate() == null)) {
			if (serviceContext == null) {
				productVariant.setCreateDate(date);
			}
			else {
				productVariant.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productVariantModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productVariant.setModifiedDate(date);
			}
			else {
				productVariant.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productVariant);
			}
			else {
				productVariant = (ProductVariant)session.merge(productVariant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductVariantImpl.class, productVariantModelImpl, false, true);

		cacheUniqueFindersCache(productVariantModelImpl);

		if (isNew) {
			productVariant.setNew(false);
		}

		productVariant.resetOriginalValues();

		return productVariant;
	}

	/**
	 * Returns the product variant with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product variant
	 * @return the product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductVariantException {

		ProductVariant productVariant = fetchByPrimaryKey(primaryKey);

		if (productVariant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductVariantException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productVariant;
	}

	/**
	 * Returns the product variant with the primary key or throws a <code>NoSuchProductVariantException</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant
	 * @throws NoSuchProductVariantException if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant findByPrimaryKey(long productVariantId)
		throws NoSuchProductVariantException {

		return findByPrimaryKey((Serializable)productVariantId);
	}

	/**
	 * Returns the product variant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant, or <code>null</code> if a product variant with the primary key could not be found
	 */
	@Override
	public ProductVariant fetchByPrimaryKey(long productVariantId) {
		return fetchByPrimaryKey((Serializable)productVariantId);
	}

	/**
	 * Returns all the product variants.
	 *
	 * @return the product variants
	 */
	@Override
	public List<ProductVariant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of product variants
	 */
	@Override
	public List<ProductVariant> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product variants
	 */
	@Override
	public List<ProductVariant> findAll(
		int start, int end,
		OrderByComparator<ProductVariant> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product variants
	 */
	@Override
	public List<ProductVariant> findAll(
		int start, int end, OrderByComparator<ProductVariant> orderByComparator,
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

		List<ProductVariant> list = null;

		if (useFinderCache) {
			list = (List<ProductVariant>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTVARIANT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTVARIANT;

				sql = sql.concat(ProductVariantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductVariant>)QueryUtil.list(
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
	 * Removes all the product variants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductVariant productVariant : findAll()) {
			remove(productVariant);
		}
	}

	/**
	 * Returns the number of product variants.
	 *
	 * @return the number of product variants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTVARIANT);

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
		return "productVariantId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTVARIANT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductVariantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product variant persistence.
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

		_finderPathWithPaginationFindBydraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydraftProductId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"draftProductId"}, true);

		_finderPathWithoutPaginationFindBydraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydraftProductId",
			new String[] {Long.class.getName()},
			new String[] {"draftProductId"}, true);

		_finderPathCountBydraftProductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydraftProductId",
			new String[] {Long.class.getName()},
			new String[] {"draftProductId"}, false);

		_finderPathWithPaginationFindByvariantNameID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvariantNameID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"draftProductId", "variantName"}, true);

		_finderPathWithoutPaginationFindByvariantNameID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvariantNameID",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "variantName"}, true);

		_finderPathCountByvariantNameID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvariantNameID",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "variantName"}, false);

		_setProductVariantUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductVariantUtilPersistence(null);

		entityCache.removeCache(ProductVariantImpl.class.getName());
	}

	private void _setProductVariantUtilPersistence(
		ProductVariantPersistence productVariantPersistence) {

		try {
			Field field = ProductVariantUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productVariantPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_product_variantPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_product_variantPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_product_variantPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTVARIANT =
		"SELECT productVariant FROM ProductVariant productVariant";

	private static final String _SQL_SELECT_PRODUCTVARIANT_WHERE =
		"SELECT productVariant FROM ProductVariant productVariant WHERE ";

	private static final String _SQL_COUNT_PRODUCTVARIANT =
		"SELECT COUNT(productVariant) FROM ProductVariant productVariant";

	private static final String _SQL_COUNT_PRODUCTVARIANT_WHERE =
		"SELECT COUNT(productVariant) FROM ProductVariant productVariant WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productVariant.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductVariant exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductVariant exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductVariantPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}