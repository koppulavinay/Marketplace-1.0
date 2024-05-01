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

package com.marketplace.product.search.keywords.service.persistence.impl;

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

import com.marketplace.product.search.keywords.exception.NoSuchProductSearchKeywordsException;
import com.marketplace.product.search.keywords.model.ProductSearchKeywords;
import com.marketplace.product.search.keywords.model.ProductSearchKeywordsTable;
import com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsImpl;
import com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl;
import com.marketplace.product.search.keywords.service.persistence.ProductSearchKeywordsPersistence;
import com.marketplace.product.search.keywords.service.persistence.ProductSearchKeywordsUtil;
import com.marketplace.product.search.keywords.service.persistence.impl.constants.marketplace_product_search_keywordsPersistenceConstants;

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
 * The persistence implementation for the product search keywords service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductSearchKeywordsPersistence.class)
public class ProductSearchKeywordsPersistenceImpl
	extends BasePersistenceImpl<ProductSearchKeywords>
	implements ProductSearchKeywordsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductSearchKeywordsUtil</code> to access the product search keywords persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductSearchKeywordsImpl.class.getName();

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
	 * Returns all the product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		List<ProductSearchKeywords> list = null;

		if (useFinderCache) {
			list = (List<ProductSearchKeywords>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSearchKeywords productSearchKeywords : list) {
					if (!uuid.equals(productSearchKeywords.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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
				sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSearchKeywords>)QueryUtil.list(
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
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findByUuid_First(
			String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByUuid_First(
			uuid, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		List<ProductSearchKeywords> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductSearchKeywords> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where uuid = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords[] findByUuid_PrevAndNext(
			long searchKeywordId, String uuid,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		uuid = Objects.toString(uuid, "");

		ProductSearchKeywords productSearchKeywords = findByPrimaryKey(
			searchKeywordId);

		Session session = null;

		try {
			session = openSession();

			ProductSearchKeywords[] array = new ProductSearchKeywordsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productSearchKeywords, uuid, orderByComparator, true);

			array[1] = productSearchKeywords;

			array[2] = getByUuid_PrevAndNext(
				session, productSearchKeywords, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSearchKeywords getByUuid_PrevAndNext(
		Session session, ProductSearchKeywords productSearchKeywords,
		String uuid, OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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
			sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
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
						productSearchKeywords)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSearchKeywords> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product search keywordses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductSearchKeywords productSearchKeywords :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSearchKeywords);
		}
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product search keywordses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSEARCHKEYWORDS_WHERE);

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
		"productSearchKeywords.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productSearchKeywords.uuid IS NULL OR productSearchKeywords.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByUUID_G(
			uuid, groupId);

		if (productSearchKeywords == null) {
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

			throw new NoSuchProductSearchKeywordsException(sb.toString());
		}

		return productSearchKeywords;
	}

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product search keywords where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUUID_G(
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

		if (result instanceof ProductSearchKeywords) {
			ProductSearchKeywords productSearchKeywords =
				(ProductSearchKeywords)result;

			if (!Objects.equals(uuid, productSearchKeywords.getUuid()) ||
				(groupId != productSearchKeywords.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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

				List<ProductSearchKeywords> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductSearchKeywords productSearchKeywords = list.get(0);

					result = productSearchKeywords;

					cacheResult(productSearchKeywords);
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
			return (ProductSearchKeywords)result;
		}
	}

	/**
	 * Removes the product search keywords where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product search keywords that was removed
	 */
	@Override
	public ProductSearchKeywords removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = findByUUID_G(
			uuid, groupId);

		return remove(productSearchKeywords);
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product search keywordses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSEARCHKEYWORDS_WHERE);

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
		"productSearchKeywords.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productSearchKeywords.uuid IS NULL OR productSearchKeywords.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productSearchKeywords.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		List<ProductSearchKeywords> list = null;

		if (useFinderCache) {
			list = (List<ProductSearchKeywords>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSearchKeywords productSearchKeywords : list) {
					if (!uuid.equals(productSearchKeywords.getUuid()) ||
						(companyId != productSearchKeywords.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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
				sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSearchKeywords>)QueryUtil.list(
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
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the first product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		List<ProductSearchKeywords> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the last product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductSearchKeywords> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords[] findByUuid_C_PrevAndNext(
			long searchKeywordId, String uuid, long companyId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		uuid = Objects.toString(uuid, "");

		ProductSearchKeywords productSearchKeywords = findByPrimaryKey(
			searchKeywordId);

		Session session = null;

		try {
			session = openSession();

			ProductSearchKeywords[] array = new ProductSearchKeywordsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productSearchKeywords, uuid, companyId,
				orderByComparator, true);

			array[1] = productSearchKeywords;

			array[2] = getByUuid_C_PrevAndNext(
				session, productSearchKeywords, uuid, companyId,
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

	protected ProductSearchKeywords getByUuid_C_PrevAndNext(
		Session session, ProductSearchKeywords productSearchKeywords,
		String uuid, long companyId,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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
			sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
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
						productSearchKeywords)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSearchKeywords> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product search keywordses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductSearchKeywords productSearchKeywords :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSearchKeywords);
		}
	}

	/**
	 * Returns the number of product search keywordses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product search keywordses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSEARCHKEYWORDS_WHERE);

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
		"productSearchKeywords.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productSearchKeywords.uuid IS NULL OR productSearchKeywords.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productSearchKeywords.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBydraftProductId;
	private FinderPath _finderPathWithoutPaginationFindBydraftProductId;
	private FinderPath _finderPathCountBydraftProductId;

	/**
	 * Returns all the product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId) {

		return findBydraftProductId(
			draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end) {

		return findBydraftProductId(draftProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return findBydraftProductId(
			draftProductId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product search keywordses where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		List<ProductSearchKeywords> list = null;

		if (useFinderCache) {
			list = (List<ProductSearchKeywords>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSearchKeywords productSearchKeywords : list) {
					if (draftProductId !=
							productSearchKeywords.getDraftProductId()) {

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

			sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				list = (List<ProductSearchKeywords>)QueryUtil.list(
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
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords =
			fetchBydraftProductId_First(draftProductId, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the first product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		List<ProductSearchKeywords> list = findBydraftProductId(
			draftProductId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords =
			fetchBydraftProductId_Last(draftProductId, orderByComparator);

		if (productSearchKeywords != null) {
			return productSearchKeywords;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSearchKeywordsException(sb.toString());
	}

	/**
	 * Returns the last product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		int count = countBydraftProductId(draftProductId);

		if (count == 0) {
			return null;
		}

		List<ProductSearchKeywords> list = findBydraftProductId(
			draftProductId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product search keywordses before and after the current product search keywords in the ordered set where draftProductId = &#63;.
	 *
	 * @param searchKeywordId the primary key of the current product search keywords
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords[] findBydraftProductId_PrevAndNext(
			long searchKeywordId, long draftProductId,
			OrderByComparator<ProductSearchKeywords> orderByComparator)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = findByPrimaryKey(
			searchKeywordId);

		Session session = null;

		try {
			session = openSession();

			ProductSearchKeywords[] array = new ProductSearchKeywordsImpl[3];

			array[0] = getBydraftProductId_PrevAndNext(
				session, productSearchKeywords, draftProductId,
				orderByComparator, true);

			array[1] = productSearchKeywords;

			array[2] = getBydraftProductId_PrevAndNext(
				session, productSearchKeywords, draftProductId,
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

	protected ProductSearchKeywords getBydraftProductId_PrevAndNext(
		Session session, ProductSearchKeywords productSearchKeywords,
		long draftProductId,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE);

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
			sb.append(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
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
						productSearchKeywords)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSearchKeywords> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product search keywordses where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	@Override
	public void removeBydraftProductId(long draftProductId) {
		for (ProductSearchKeywords productSearchKeywords :
				findBydraftProductId(
					draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSearchKeywords);
		}
	}

	/**
	 * Returns the number of product search keywordses where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product search keywordses
	 */
	@Override
	public int countBydraftProductId(long draftProductId) {
		FinderPath finderPath = _finderPathCountBydraftProductId;

		Object[] finderArgs = new Object[] {draftProductId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSEARCHKEYWORDS_WHERE);

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
		"productSearchKeywords.draftProductId = ?";

	public ProductSearchKeywordsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductSearchKeywords.class);

		setModelImplClass(ProductSearchKeywordsImpl.class);
		setModelPKClass(long.class);

		setTable(ProductSearchKeywordsTable.INSTANCE);
	}

	/**
	 * Caches the product search keywords in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywords the product search keywords
	 */
	@Override
	public void cacheResult(ProductSearchKeywords productSearchKeywords) {
		entityCache.putResult(
			ProductSearchKeywordsImpl.class,
			productSearchKeywords.getPrimaryKey(), productSearchKeywords);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productSearchKeywords.getUuid(),
				productSearchKeywords.getGroupId()
			},
			productSearchKeywords);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product search keywordses in the entity cache if it is enabled.
	 *
	 * @param productSearchKeywordses the product search keywordses
	 */
	@Override
	public void cacheResult(
		List<ProductSearchKeywords> productSearchKeywordses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productSearchKeywordses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductSearchKeywords productSearchKeywords :
				productSearchKeywordses) {

			if (entityCache.getResult(
					ProductSearchKeywordsImpl.class,
					productSearchKeywords.getPrimaryKey()) == null) {

				cacheResult(productSearchKeywords);
			}
		}
	}

	/**
	 * Clears the cache for all product search keywordses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductSearchKeywordsImpl.class);

		finderCache.clearCache(ProductSearchKeywordsImpl.class);
	}

	/**
	 * Clears the cache for the product search keywords.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductSearchKeywords productSearchKeywords) {
		entityCache.removeResult(
			ProductSearchKeywordsImpl.class, productSearchKeywords);
	}

	@Override
	public void clearCache(
		List<ProductSearchKeywords> productSearchKeywordses) {

		for (ProductSearchKeywords productSearchKeywords :
				productSearchKeywordses) {

			entityCache.removeResult(
				ProductSearchKeywordsImpl.class, productSearchKeywords);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductSearchKeywordsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductSearchKeywordsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductSearchKeywordsModelImpl productSearchKeywordsModelImpl) {

		Object[] args = new Object[] {
			productSearchKeywordsModelImpl.getUuid(),
			productSearchKeywordsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productSearchKeywordsModelImpl);
	}

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	@Override
	public ProductSearchKeywords create(long searchKeywordId) {
		ProductSearchKeywords productSearchKeywords =
			new ProductSearchKeywordsImpl();

		productSearchKeywords.setNew(true);
		productSearchKeywords.setPrimaryKey(searchKeywordId);

		String uuid = _portalUUID.generate();

		productSearchKeywords.setUuid(uuid);

		productSearchKeywords.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productSearchKeywords;
	}

	/**
	 * Removes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords remove(long searchKeywordId)
		throws NoSuchProductSearchKeywordsException {

		return remove((Serializable)searchKeywordId);
	}

	/**
	 * Removes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords remove(Serializable primaryKey)
		throws NoSuchProductSearchKeywordsException {

		Session session = null;

		try {
			session = openSession();

			ProductSearchKeywords productSearchKeywords =
				(ProductSearchKeywords)session.get(
					ProductSearchKeywordsImpl.class, primaryKey);

			if (productSearchKeywords == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSearchKeywordsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productSearchKeywords);
		}
		catch (NoSuchProductSearchKeywordsException noSuchEntityException) {
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
	protected ProductSearchKeywords removeImpl(
		ProductSearchKeywords productSearchKeywords) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSearchKeywords)) {
				productSearchKeywords = (ProductSearchKeywords)session.get(
					ProductSearchKeywordsImpl.class,
					productSearchKeywords.getPrimaryKeyObj());
			}

			if (productSearchKeywords != null) {
				session.delete(productSearchKeywords);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productSearchKeywords != null) {
			clearCache(productSearchKeywords);
		}

		return productSearchKeywords;
	}

	@Override
	public ProductSearchKeywords updateImpl(
		ProductSearchKeywords productSearchKeywords) {

		boolean isNew = productSearchKeywords.isNew();

		if (!(productSearchKeywords instanceof
				ProductSearchKeywordsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productSearchKeywords.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productSearchKeywords);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productSearchKeywords proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductSearchKeywords implementation " +
					productSearchKeywords.getClass());
		}

		ProductSearchKeywordsModelImpl productSearchKeywordsModelImpl =
			(ProductSearchKeywordsModelImpl)productSearchKeywords;

		if (Validator.isNull(productSearchKeywords.getUuid())) {
			String uuid = _portalUUID.generate();

			productSearchKeywords.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productSearchKeywords.getCreateDate() == null)) {
			if (serviceContext == null) {
				productSearchKeywords.setCreateDate(date);
			}
			else {
				productSearchKeywords.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productSearchKeywordsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productSearchKeywords.setModifiedDate(date);
			}
			else {
				productSearchKeywords.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productSearchKeywords);
			}
			else {
				productSearchKeywords = (ProductSearchKeywords)session.merge(
					productSearchKeywords);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductSearchKeywordsImpl.class, productSearchKeywordsModelImpl,
			false, true);

		cacheUniqueFindersCache(productSearchKeywordsModelImpl);

		if (isNew) {
			productSearchKeywords.setNew(false);
		}

		productSearchKeywords.resetOriginalValues();

		return productSearchKeywords;
	}

	/**
	 * Returns the product search keywords with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSearchKeywordsException {

		ProductSearchKeywords productSearchKeywords = fetchByPrimaryKey(
			primaryKey);

		if (productSearchKeywords == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSearchKeywordsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productSearchKeywords;
	}

	/**
	 * Returns the product search keywords with the primary key or throws a <code>NoSuchProductSearchKeywordsException</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws NoSuchProductSearchKeywordsException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords findByPrimaryKey(long searchKeywordId)
		throws NoSuchProductSearchKeywordsException {

		return findByPrimaryKey((Serializable)searchKeywordId);
	}

	/**
	 * Returns the product search keywords with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords, or <code>null</code> if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords fetchByPrimaryKey(long searchKeywordId) {
		return fetchByPrimaryKey((Serializable)searchKeywordId);
	}

	/**
	 * Returns all the product search keywordses.
	 *
	 * @return the product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findAll(
		int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> findAll(
		int start, int end,
		OrderByComparator<ProductSearchKeywords> orderByComparator,
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

		List<ProductSearchKeywords> list = null;

		if (useFinderCache) {
			list = (List<ProductSearchKeywords>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTSEARCHKEYWORDS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSEARCHKEYWORDS;

				sql = sql.concat(ProductSearchKeywordsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductSearchKeywords>)QueryUtil.list(
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
	 * Removes all the product search keywordses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductSearchKeywords productSearchKeywords : findAll()) {
			remove(productSearchKeywords);
		}
	}

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
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
					_SQL_COUNT_PRODUCTSEARCHKEYWORDS);

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
		return "searchKeywordId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTSEARCHKEYWORDS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductSearchKeywordsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product search keywords persistence.
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

		_setProductSearchKeywordsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductSearchKeywordsUtilPersistence(null);

		entityCache.removeCache(ProductSearchKeywordsImpl.class.getName());
	}

	private void _setProductSearchKeywordsUtilPersistence(
		ProductSearchKeywordsPersistence productSearchKeywordsPersistence) {

		try {
			Field field = ProductSearchKeywordsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productSearchKeywordsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_product_search_keywordsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_product_search_keywordsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_product_search_keywordsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTSEARCHKEYWORDS =
		"SELECT productSearchKeywords FROM ProductSearchKeywords productSearchKeywords";

	private static final String _SQL_SELECT_PRODUCTSEARCHKEYWORDS_WHERE =
		"SELECT productSearchKeywords FROM ProductSearchKeywords productSearchKeywords WHERE ";

	private static final String _SQL_COUNT_PRODUCTSEARCHKEYWORDS =
		"SELECT COUNT(productSearchKeywords) FROM ProductSearchKeywords productSearchKeywords";

	private static final String _SQL_COUNT_PRODUCTSEARCHKEYWORDS_WHERE =
		"SELECT COUNT(productSearchKeywords) FROM ProductSearchKeywords productSearchKeywords WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productSearchKeywords.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductSearchKeywords exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductSearchKeywords exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSearchKeywordsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}