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

package com.marketplace.category.service.persistence.impl;

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

import com.marketplace.category.exception.NoSuchCategoryException;
import com.marketplace.category.model.Category;
import com.marketplace.category.model.CategoryTable;
import com.marketplace.category.model.impl.CategoryImpl;
import com.marketplace.category.model.impl.CategoryModelImpl;
import com.marketplace.category.service.persistence.CategoryPersistence;
import com.marketplace.category.service.persistence.CategoryUtil;
import com.marketplace.category.service.persistence.impl.constants.marketplace_categoryPersistenceConstants;

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
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CategoryPersistence.class)
public class CategoryPersistenceImpl
	extends BasePersistenceImpl<Category> implements CategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CategoryUtil</code> to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CategoryImpl.class.getName();

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
	 * Returns all the categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

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

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if (!uuid.equals(category.getUuid())) {
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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

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
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByUuid_First(
			String uuid, OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByUuid_First(uuid, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUuid_First(
		String uuid, OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByUuid_Last(
			String uuid, OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByUuid_Last(uuid, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUuid_Last(
		String uuid, OrderByComparator<Category> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		uuid = Objects.toString(uuid, "");

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, category, uuid, orderByComparator, true);

			array[1] = category;

			array[2] = getByUuid_PrevAndNext(
				session, category, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category getByUuid_PrevAndNext(
		Session session, Category category, String uuid,
		OrderByComparator<Category> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Category category :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching categories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

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
		"category.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(category.uuid IS NULL OR category.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryException {

		Category category = fetchByUUID_G(uuid, groupId);

		if (category == null) {
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

			throw new NoSuchCategoryException(sb.toString());
		}

		return category;
	}

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUUID_G(
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

		if (result instanceof Category) {
			Category category = (Category)result;

			if (!Objects.equals(uuid, category.getUuid()) ||
				(groupId != category.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

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

				List<Category> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Category category = list.get(0);

					result = category;

					cacheResult(category);
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
			return (Category)result;
		}
	}

	/**
	 * Removes the category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the category that was removed
	 */
	@Override
	public Category removeByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryException {

		Category category = findByUUID_G(uuid, groupId);

		return remove(category);
	}

	/**
	 * Returns the number of categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

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
		"category.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(category.uuid IS NULL OR category.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"category.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

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

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if (!uuid.equals(category.getUuid()) ||
						(companyId != category.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

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
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Category> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		uuid = Objects.toString(uuid, "");

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, category, uuid, companyId, orderByComparator, true);

			array[1] = category;

			array[2] = getByUuid_C_PrevAndNext(
				session, category, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category getByUuid_C_PrevAndNext(
		Session session, Category category, String uuid, long companyId,
		OrderByComparator<Category> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Category category :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

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
		"category.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(category.uuid IS NULL OR category.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"category.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBycategoryApprovalStatus;
	private FinderPath _finderPathWithoutPaginationFindBycategoryApprovalStatus;
	private FinderPath _finderPathCountBycategoryApprovalStatus;

	/**
	 * Returns all the categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	@Override
	public List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus) {

		return findBycategoryApprovalStatus(
			categoryApprovalStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end) {

		return findBycategoryApprovalStatus(
			categoryApprovalStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findBycategoryApprovalStatus(
			categoryApprovalStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findBycategoryApprovalStatus(
		String categoryApprovalStatus, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBycategoryApprovalStatus;
				finderArgs = new Object[] {categoryApprovalStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycategoryApprovalStatus;
			finderArgs = new Object[] {
				categoryApprovalStatus, start, end, orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if (!categoryApprovalStatus.equals(
							category.getCategoryApprovalStatus())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			boolean bindCategoryApprovalStatus = false;

			if (categoryApprovalStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_3);
			}
			else {
				bindCategoryApprovalStatus = true;

				sb.append(
					_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryApprovalStatus) {
					queryPos.add(categoryApprovalStatus);
				}

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findBycategoryApprovalStatus_First(
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchBycategoryApprovalStatus_First(
			categoryApprovalStatus, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryApprovalStatus=");
		sb.append(categoryApprovalStatus);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchBycategoryApprovalStatus_First(
		String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findBycategoryApprovalStatus(
			categoryApprovalStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findBycategoryApprovalStatus_Last(
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchBycategoryApprovalStatus_Last(
			categoryApprovalStatus, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryApprovalStatus=");
		sb.append(categoryApprovalStatus);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchBycategoryApprovalStatus_Last(
		String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		int count = countBycategoryApprovalStatus(categoryApprovalStatus);

		if (count == 0) {
			return null;
		}

		List<Category> list = findBycategoryApprovalStatus(
			categoryApprovalStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findBycategoryApprovalStatus_PrevAndNext(
			long categoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getBycategoryApprovalStatus_PrevAndNext(
				session, category, categoryApprovalStatus, orderByComparator,
				true);

			array[1] = category;

			array[2] = getBycategoryApprovalStatus_PrevAndNext(
				session, category, categoryApprovalStatus, orderByComparator,
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

	protected Category getBycategoryApprovalStatus_PrevAndNext(
		Session session, Category category, String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		boolean bindCategoryApprovalStatus = false;

		if (categoryApprovalStatus.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_3);
		}
		else {
			bindCategoryApprovalStatus = true;

			sb.append(
				_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_2);
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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategoryApprovalStatus) {
			queryPos.add(categoryApprovalStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where categoryApprovalStatus = &#63; from the database.
	 *
	 * @param categoryApprovalStatus the category approval status
	 */
	@Override
	public void removeBycategoryApprovalStatus(String categoryApprovalStatus) {
		for (Category category :
				findBycategoryApprovalStatus(
					categoryApprovalStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where categoryApprovalStatus = &#63;.
	 *
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	@Override
	public int countBycategoryApprovalStatus(String categoryApprovalStatus) {
		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		FinderPath finderPath = _finderPathCountBycategoryApprovalStatus;

		Object[] finderArgs = new Object[] {categoryApprovalStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			boolean bindCategoryApprovalStatus = false;

			if (categoryApprovalStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_3);
			}
			else {
				bindCategoryApprovalStatus = true;

				sb.append(
					_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryApprovalStatus) {
					queryPos.add(categoryApprovalStatus);
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
		_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_2 =
			"category.categoryApprovalStatus = ?";

	private static final String
		_FINDER_COLUMN_CATEGORYAPPROVALSTATUS_CATEGORYAPPROVALSTATUS_3 =
			"(category.categoryApprovalStatus IS NULL OR category.categoryApprovalStatus = '')";

	private FinderPath _finderPathWithPaginationFindByparentCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByparentCategoryId;
	private FinderPath _finderPathCountByparentCategoryId;

	/**
	 * Returns all the categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByparentCategoryId(long parentCategoryId) {
		return findByparentCategoryId(
			parentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end) {

		return findByparentCategoryId(parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findByparentCategoryId(
			parentCategoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryId(
		long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByparentCategoryId;
				finderArgs = new Object[] {parentCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByparentCategoryId;
			finderArgs = new Object[] {
				parentCategoryId, start, end, orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if (parentCategoryId != category.getParentCategoryId()) {
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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCategoryId);

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByparentCategoryId_First(
			long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByparentCategoryId_First(
			parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByparentCategoryId_First(
		long parentCategoryId, OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByparentCategoryId(
			parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByparentCategoryId_Last(
			long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByparentCategoryId_Last(
			parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByparentCategoryId_Last(
		long parentCategoryId, OrderByComparator<Category> orderByComparator) {

		int count = countByparentCategoryId(parentCategoryId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByparentCategoryId(
			parentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByparentCategoryId_PrevAndNext(
			long categoryId, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByparentCategoryId_PrevAndNext(
				session, category, parentCategoryId, orderByComparator, true);

			array[1] = category;

			array[2] = getByparentCategoryId_PrevAndNext(
				session, category, parentCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Category getByparentCategoryId_PrevAndNext(
		Session session, Category category, long parentCategoryId,
		OrderByComparator<Category> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where parentCategoryId = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 */
	@Override
	public void removeByparentCategoryId(long parentCategoryId) {
		for (Category category :
				findByparentCategoryId(
					parentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByparentCategoryId(long parentCategoryId) {
		FinderPath finderPath = _finderPathCountByparentCategoryId;

		Object[] finderArgs = new Object[] {parentCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCategoryId);

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
		_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2 =
			"category.parentCategoryId = ?";

	private FinderPath _finderPathWithPaginationFindByassignManager;
	private FinderPath _finderPathWithoutPaginationFindByassignManager;
	private FinderPath _finderPathCountByassignManager;

	/**
	 * Returns all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByassignManager(
		long assignManager, long parentCategoryId) {

		return findByassignManager(
			assignManager, parentCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end) {

		return findByassignManager(
			assignManager, parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findByassignManager(
			assignManager, parentCategoryId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByassignManager(
		long assignManager, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByassignManager;
				finderArgs = new Object[] {assignManager, parentCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByassignManager;
			finderArgs = new Object[] {
				assignManager, parentCategoryId, start, end, orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if ((assignManager != category.getAssignManager()) ||
						(parentCategoryId != category.getParentCategoryId())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_ASSIGNMANAGER_ASSIGNMANAGER_2);

			sb.append(_FINDER_COLUMN_ASSIGNMANAGER_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assignManager);

				queryPos.add(parentCategoryId);

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByassignManager_First(
			long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByassignManager_First(
			assignManager, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assignManager=");
		sb.append(assignManager);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByassignManager_First(
		long assignManager, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByassignManager(
			assignManager, parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByassignManager_Last(
			long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByassignManager_Last(
			assignManager, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assignManager=");
		sb.append(assignManager);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByassignManager_Last(
		long assignManager, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		int count = countByassignManager(assignManager, parentCategoryId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByassignManager(
			assignManager, parentCategoryId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByassignManager_PrevAndNext(
			long categoryId, long assignManager, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByassignManager_PrevAndNext(
				session, category, assignManager, parentCategoryId,
				orderByComparator, true);

			array[1] = category;

			array[2] = getByassignManager_PrevAndNext(
				session, category, assignManager, parentCategoryId,
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

	protected Category getByassignManager_PrevAndNext(
		Session session, Category category, long assignManager,
		long parentCategoryId, OrderByComparator<Category> orderByComparator,
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

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_ASSIGNMANAGER_ASSIGNMANAGER_2);

		sb.append(_FINDER_COLUMN_ASSIGNMANAGER_PARENTCATEGORYID_2);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(assignManager);

		queryPos.add(parentCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where assignManager = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 */
	@Override
	public void removeByassignManager(
		long assignManager, long parentCategoryId) {

		for (Category category :
				findByassignManager(
					assignManager, parentCategoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where assignManager = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignManager the assign manager
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByassignManager(long assignManager, long parentCategoryId) {
		FinderPath finderPath = _finderPathCountByassignManager;

		Object[] finderArgs = new Object[] {assignManager, parentCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_ASSIGNMANAGER_ASSIGNMANAGER_2);

			sb.append(_FINDER_COLUMN_ASSIGNMANAGER_PARENTCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assignManager);

				queryPos.add(parentCategoryId);

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

	private static final String _FINDER_COLUMN_ASSIGNMANAGER_ASSIGNMANAGER_2 =
		"category.assignManager = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSIGNMANAGER_PARENTCATEGORYID_2 =
			"category.parentCategoryId = ?";

	private FinderPath _finderPathWithPaginationFindByassignReviewer;
	private FinderPath _finderPathWithoutPaginationFindByassignReviewer;
	private FinderPath _finderPathCountByassignReviewer;

	/**
	 * Returns all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		return findByassignReviewer(
			assignReviewer, parentCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end) {

		return findByassignReviewer(
			assignReviewer, parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findByassignReviewer(
			assignReviewer, parentCategoryId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByassignReviewer(
		long assignReviewer, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByassignReviewer;
				finderArgs = new Object[] {assignReviewer, parentCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByassignReviewer;
			finderArgs = new Object[] {
				assignReviewer, parentCategoryId, start, end, orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if ((assignReviewer != category.getAssignReviewer()) ||
						(parentCategoryId != category.getParentCategoryId())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_ASSIGNREVIEWER_2);

			sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assignReviewer);

				queryPos.add(parentCategoryId);

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByassignReviewer_First(
			long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByassignReviewer_First(
			assignReviewer, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assignReviewer=");
		sb.append(assignReviewer);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByassignReviewer_First(
		long assignReviewer, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByassignReviewer(
			assignReviewer, parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByassignReviewer_Last(
			long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByassignReviewer_Last(
			assignReviewer, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assignReviewer=");
		sb.append(assignReviewer);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByassignReviewer_Last(
		long assignReviewer, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		int count = countByassignReviewer(assignReviewer, parentCategoryId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByassignReviewer(
			assignReviewer, parentCategoryId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByassignReviewer_PrevAndNext(
			long categoryId, long assignReviewer, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByassignReviewer_PrevAndNext(
				session, category, assignReviewer, parentCategoryId,
				orderByComparator, true);

			array[1] = category;

			array[2] = getByassignReviewer_PrevAndNext(
				session, category, assignReviewer, parentCategoryId,
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

	protected Category getByassignReviewer_PrevAndNext(
		Session session, Category category, long assignReviewer,
		long parentCategoryId, OrderByComparator<Category> orderByComparator,
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

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_ASSIGNREVIEWER_2);

		sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_PARENTCATEGORYID_2);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(assignReviewer);

		queryPos.add(parentCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where assignReviewer = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 */
	@Override
	public void removeByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		for (Category category :
				findByassignReviewer(
					assignReviewer, parentCategoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where assignReviewer = &#63; and parentCategoryId = &#63;.
	 *
	 * @param assignReviewer the assign reviewer
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByassignReviewer(
		long assignReviewer, long parentCategoryId) {

		FinderPath finderPath = _finderPathCountByassignReviewer;

		Object[] finderArgs = new Object[] {assignReviewer, parentCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_ASSIGNREVIEWER_2);

			sb.append(_FINDER_COLUMN_ASSIGNREVIEWER_PARENTCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assignReviewer);

				queryPos.add(parentCategoryId);

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

	private static final String _FINDER_COLUMN_ASSIGNREVIEWER_ASSIGNREVIEWER_2 =
		"category.assignReviewer = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSIGNREVIEWER_PARENTCATEGORYID_2 =
			"category.parentCategoryId = ?";

	private FinderPath _finderPathWithPaginationFindBycreatedBy;
	private FinderPath _finderPathWithoutPaginationFindBycreatedBy;
	private FinderPath _finderPathCountBycreatedBy;

	/**
	 * Returns all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the matching categories
	 */
	@Override
	public List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId) {

		return findBycreatedBy(
			createdBy, parentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end) {

		return findBycreatedBy(createdBy, parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator) {

		return findBycreatedBy(
			createdBy, parentCategoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findBycreatedBy(
		long createdBy, long parentCategoryId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycreatedBy;
				finderArgs = new Object[] {createdBy, parentCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycreatedBy;
			finderArgs = new Object[] {
				createdBy, parentCategoryId, start, end, orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if ((createdBy != category.getCreatedBy()) ||
						(parentCategoryId != category.getParentCategoryId())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

			sb.append(_FINDER_COLUMN_CREATEDBY_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdBy);

				queryPos.add(parentCategoryId);

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findBycreatedBy_First(
			long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchBycreatedBy_First(
			createdBy, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdBy=");
		sb.append(createdBy);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchBycreatedBy_First(
		long createdBy, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findBycreatedBy(
			createdBy, parentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findBycreatedBy_Last(
			long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchBycreatedBy_Last(
			createdBy, parentCategoryId, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdBy=");
		sb.append(createdBy);

		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchBycreatedBy_Last(
		long createdBy, long parentCategoryId,
		OrderByComparator<Category> orderByComparator) {

		int count = countBycreatedBy(createdBy, parentCategoryId);

		if (count == 0) {
			return null;
		}

		List<Category> list = findBycreatedBy(
			createdBy, parentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findBycreatedBy_PrevAndNext(
			long categoryId, long createdBy, long parentCategoryId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getBycreatedBy_PrevAndNext(
				session, category, createdBy, parentCategoryId,
				orderByComparator, true);

			array[1] = category;

			array[2] = getBycreatedBy_PrevAndNext(
				session, category, createdBy, parentCategoryId,
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

	protected Category getBycreatedBy_PrevAndNext(
		Session session, Category category, long createdBy,
		long parentCategoryId, OrderByComparator<Category> orderByComparator,
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

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

		sb.append(_FINDER_COLUMN_CREATEDBY_PARENTCATEGORYID_2);

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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(createdBy);

		queryPos.add(parentCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where createdBy = &#63; and parentCategoryId = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 */
	@Override
	public void removeBycreatedBy(long createdBy, long parentCategoryId) {
		for (Category category :
				findBycreatedBy(
					createdBy, parentCategoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where createdBy = &#63; and parentCategoryId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching categories
	 */
	@Override
	public int countBycreatedBy(long createdBy, long parentCategoryId) {
		FinderPath finderPath = _finderPathCountBycreatedBy;

		Object[] finderArgs = new Object[] {createdBy, parentCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

			sb.append(_FINDER_COLUMN_CREATEDBY_PARENTCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdBy);

				queryPos.add(parentCategoryId);

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

	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_2 =
		"category.createdBy = ? AND ";

	private static final String _FINDER_COLUMN_CREATEDBY_PARENTCATEGORYID_2 =
		"category.parentCategoryId = ?";

	private FinderPath _finderPathFetchByFBYAssetCategoryId;
	private FinderPath _finderPathCountByFBYAssetCategoryId;

	/**
	 * Returns the category where assetCategoryId = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchCategoryException {

		Category category = fetchByFBYAssetCategoryId(assetCategoryId);

		if (category == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("assetCategoryId=");
			sb.append(assetCategoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCategoryException(sb.toString());
		}

		return category;
	}

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByFBYAssetCategoryId(long assetCategoryId) {
		return fetchByFBYAssetCategoryId(assetCategoryId, true);
	}

	/**
	 * Returns the category where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByFBYAssetCategoryId(
		long assetCategoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {assetCategoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFBYAssetCategoryId, finderArgs, this);
		}

		if (result instanceof Category) {
			Category category = (Category)result;

			if (assetCategoryId != category.getAssetCategoryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_FBYASSETCATEGORYID_ASSETCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetCategoryId);

				List<Category> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFBYAssetCategoryId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {assetCategoryId};
							}

							_log.warn(
								"CategoryPersistenceImpl.fetchByFBYAssetCategoryId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Category category = list.get(0);

					result = category;

					cacheResult(category);
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
			return (Category)result;
		}
	}

	/**
	 * Removes the category where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the category that was removed
	 */
	@Override
	public Category removeByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchCategoryException {

		Category category = findByFBYAssetCategoryId(assetCategoryId);

		return remove(category);
	}

	/**
	 * Returns the number of categories where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching categories
	 */
	@Override
	public int countByFBYAssetCategoryId(long assetCategoryId) {
		FinderPath finderPath = _finderPathCountByFBYAssetCategoryId;

		Object[] finderArgs = new Object[] {assetCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_FBYASSETCATEGORYID_ASSETCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetCategoryId);

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
		_FINDER_COLUMN_FBYASSETCATEGORYID_ASSETCATEGORYID_2 =
			"category.assetCategoryId = ?";

	private FinderPath _finderPathWithPaginationFindByparentCategoryIdStatus;
	private FinderPath _finderPathWithoutPaginationFindByparentCategoryIdStatus;
	private FinderPath _finderPathCountByparentCategoryIdStatus;

	/**
	 * Returns all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the matching categories
	 */
	@Override
	public List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		return findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end) {

		return findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end, OrderByComparator<Category> orderByComparator) {

		return findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Override
	public List<Category> findByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus, int start,
		int end, OrderByComparator<Category> orderByComparator,
		boolean useFinderCache) {

		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByparentCategoryIdStatus;
				finderArgs = new Object[] {
					parentCategoryId, categoryApprovalStatus
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByparentCategoryIdStatus;
			finderArgs = new Object[] {
				parentCategoryId, categoryApprovalStatus, start, end,
				orderByComparator
			};
		}

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Category category : list) {
					if ((parentCategoryId != category.getParentCategoryId()) ||
						!categoryApprovalStatus.equals(
							category.getCategoryApprovalStatus())) {

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

			sb.append(_SQL_SELECT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_PARENTCATEGORYID_2);

			boolean bindCategoryApprovalStatus = false;

			if (categoryApprovalStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_3);
			}
			else {
				bindCategoryApprovalStatus = true;

				sb.append(
					_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCategoryId);

				if (bindCategoryApprovalStatus) {
					queryPos.add(categoryApprovalStatus);
				}

				list = (List<Category>)QueryUtil.list(
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
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByparentCategoryIdStatus_First(
			long parentCategoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByparentCategoryIdStatus_First(
			parentCategoryId, categoryApprovalStatus, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append(", categoryApprovalStatus=");
		sb.append(categoryApprovalStatus);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByparentCategoryIdStatus_First(
		long parentCategoryId, String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		List<Category> list = findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByparentCategoryIdStatus_Last(
			long parentCategoryId, String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		Category category = fetchByparentCategoryIdStatus_Last(
			parentCategoryId, categoryApprovalStatus, orderByComparator);

		if (category != null) {
			return category;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCategoryId=");
		sb.append(parentCategoryId);

		sb.append(", categoryApprovalStatus=");
		sb.append(categoryApprovalStatus);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByparentCategoryIdStatus_Last(
		long parentCategoryId, String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator) {

		int count = countByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus);

		if (count == 0) {
			return null;
		}

		List<Category> list = findByparentCategoryIdStatus(
			parentCategoryId, categoryApprovalStatus, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the categories before and after the current category in the ordered set where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category[] findByparentCategoryIdStatus_PrevAndNext(
			long categoryId, long parentCategoryId,
			String categoryApprovalStatus,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException {

		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		Category category = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			Category[] array = new CategoryImpl[3];

			array[0] = getByparentCategoryIdStatus_PrevAndNext(
				session, category, parentCategoryId, categoryApprovalStatus,
				orderByComparator, true);

			array[1] = category;

			array[2] = getByparentCategoryIdStatus_PrevAndNext(
				session, category, parentCategoryId, categoryApprovalStatus,
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

	protected Category getByparentCategoryIdStatus_PrevAndNext(
		Session session, Category category, long parentCategoryId,
		String categoryApprovalStatus,
		OrderByComparator<Category> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_PARENTCATEGORYID_2);

		boolean bindCategoryApprovalStatus = false;

		if (categoryApprovalStatus.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_3);
		}
		else {
			bindCategoryApprovalStatus = true;

			sb.append(
				_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_2);
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
			sb.append(CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentCategoryId);

		if (bindCategoryApprovalStatus) {
			queryPos.add(categoryApprovalStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(category)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Category> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 */
	@Override
	public void removeByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		for (Category category :
				findByparentCategoryIdStatus(
					parentCategoryId, categoryApprovalStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(category);
		}
	}

	/**
	 * Returns the number of categories where parentCategoryId = &#63; and categoryApprovalStatus = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param categoryApprovalStatus the category approval status
	 * @return the number of matching categories
	 */
	@Override
	public int countByparentCategoryIdStatus(
		long parentCategoryId, String categoryApprovalStatus) {

		categoryApprovalStatus = Objects.toString(categoryApprovalStatus, "");

		FinderPath finderPath = _finderPathCountByparentCategoryIdStatus;

		Object[] finderArgs = new Object[] {
			parentCategoryId, categoryApprovalStatus
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_PARENTCATEGORYID_2);

			boolean bindCategoryApprovalStatus = false;

			if (categoryApprovalStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_3);
			}
			else {
				bindCategoryApprovalStatus = true;

				sb.append(
					_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCategoryId);

				if (bindCategoryApprovalStatus) {
					queryPos.add(categoryApprovalStatus);
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
		_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_PARENTCATEGORYID_2 =
			"category.parentCategoryId = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_2 =
			"category.categoryApprovalStatus = ?";

	private static final String
		_FINDER_COLUMN_PARENTCATEGORYIDSTATUS_CATEGORYAPPROVALSTATUS_3 =
			"(category.categoryApprovalStatus IS NULL OR category.categoryApprovalStatus = '')";

	public CategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Category.class);

		setModelImplClass(CategoryImpl.class);
		setModelPKClass(long.class);

		setTable(CategoryTable.INSTANCE);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	@Override
	public void cacheResult(Category category) {
		entityCache.putResult(
			CategoryImpl.class, category.getPrimaryKey(), category);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {category.getUuid(), category.getGroupId()}, category);

		finderCache.putResult(
			_finderPathFetchByFBYAssetCategoryId,
			new Object[] {category.getAssetCategoryId()}, category);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	@Override
	public void cacheResult(List<Category> categories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (categories.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Category category : categories) {
			if (entityCache.getResult(
					CategoryImpl.class, category.getPrimaryKey()) == null) {

				cacheResult(category);
			}
		}
	}

	/**
	 * Clears the cache for all categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryImpl.class);

		finderCache.clearCache(CategoryImpl.class);
	}

	/**
	 * Clears the cache for the category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Category category) {
		entityCache.removeResult(CategoryImpl.class, category);
	}

	@Override
	public void clearCache(List<Category> categories) {
		for (Category category : categories) {
			entityCache.removeResult(CategoryImpl.class, category);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CategoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CategoryModelImpl categoryModelImpl) {

		Object[] args = new Object[] {
			categoryModelImpl.getUuid(), categoryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, categoryModelImpl);

		args = new Object[] {categoryModelImpl.getAssetCategoryId()};

		finderCache.putResult(
			_finderPathCountByFBYAssetCategoryId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFBYAssetCategoryId, args, categoryModelImpl);
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public Category create(long categoryId) {
		Category category = new CategoryImpl();

		category.setNew(true);
		category.setPrimaryKey(categoryId);

		String uuid = _portalUUID.generate();

		category.setUuid(uuid);

		category.setCompanyId(CompanyThreadLocal.getCompanyId());

		return category;
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(long categoryId) throws NoSuchCategoryException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(Serializable primaryKey)
		throws NoSuchCategoryException {

		Session session = null;

		try {
			session = openSession();

			Category category = (Category)session.get(
				CategoryImpl.class, primaryKey);

			if (category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(category);
		}
		catch (NoSuchCategoryException noSuchEntityException) {
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
	protected Category removeImpl(Category category) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(category)) {
				category = (Category)session.get(
					CategoryImpl.class, category.getPrimaryKeyObj());
			}

			if (category != null) {
				session.delete(category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (category != null) {
			clearCache(category);
		}

		return category;
	}

	@Override
	public Category updateImpl(Category category) {
		boolean isNew = category.isNew();

		if (!(category instanceof CategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(category.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(category);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in category proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Category implementation " +
					category.getClass());
		}

		CategoryModelImpl categoryModelImpl = (CategoryModelImpl)category;

		if (Validator.isNull(category.getUuid())) {
			String uuid = _portalUUID.generate();

			category.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (category.getCreateDate() == null)) {
			if (serviceContext == null) {
				category.setCreateDate(date);
			}
			else {
				category.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!categoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				category.setModifiedDate(date);
			}
			else {
				category.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(category);
			}
			else {
				category = (Category)session.merge(category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CategoryImpl.class, categoryModelImpl, false, true);

		cacheUniqueFindersCache(categoryModelImpl);

		if (isNew) {
			category.setNew(false);
		}

		category.resetOriginalValues();

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException {

		Category category = fetchByPrimaryKey(primaryKey);

		if (category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public Category fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	@Override
	public List<Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	@Override
	public List<Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator,
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

		List<Category> list = null;

		if (useFinderCache) {
			list = (List<Category>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORY;

				sql = sql.concat(CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Category>)QueryUtil.list(
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
	 * Removes all the categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Category category : findAll()) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATEGORY);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category persistence.
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

		_finderPathWithPaginationFindBycategoryApprovalStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycategoryApprovalStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"categoryApprovalStatus"}, true);

		_finderPathWithoutPaginationFindBycategoryApprovalStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBycategoryApprovalStatus",
				new String[] {String.class.getName()},
				new String[] {"categoryApprovalStatus"}, true);

		_finderPathCountBycategoryApprovalStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycategoryApprovalStatus",
			new String[] {String.class.getName()},
			new String[] {"categoryApprovalStatus"}, false);

		_finderPathWithPaginationFindByparentCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentCategoryId"}, true);

		_finderPathWithoutPaginationFindByparentCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparentCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"parentCategoryId"}, true);

		_finderPathCountByparentCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentCategoryId", new String[] {Long.class.getName()},
			new String[] {"parentCategoryId"}, false);

		_finderPathWithPaginationFindByassignManager = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByassignManager",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"assignManager", "parentCategoryId"}, true);

		_finderPathWithoutPaginationFindByassignManager = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByassignManager",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"assignManager", "parentCategoryId"}, true);

		_finderPathCountByassignManager = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassignManager",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"assignManager", "parentCategoryId"}, false);

		_finderPathWithPaginationFindByassignReviewer = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByassignReviewer",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"assignReviewer", "parentCategoryId"}, true);

		_finderPathWithoutPaginationFindByassignReviewer = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByassignReviewer",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"assignReviewer", "parentCategoryId"}, true);

		_finderPathCountByassignReviewer = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassignReviewer",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"assignReviewer", "parentCategoryId"}, false);

		_finderPathWithPaginationFindBycreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreatedBy",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"createdBy", "parentCategoryId"}, true);

		_finderPathWithoutPaginationFindBycreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreatedBy",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"createdBy", "parentCategoryId"}, true);

		_finderPathCountBycreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreatedBy",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"createdBy", "parentCategoryId"}, false);

		_finderPathFetchByFBYAssetCategoryId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFBYAssetCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"assetCategoryId"}, true);

		_finderPathCountByFBYAssetCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFBYAssetCategoryId", new String[] {Long.class.getName()},
			new String[] {"assetCategoryId"}, false);

		_finderPathWithPaginationFindByparentCategoryIdStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentCategoryIdStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parentCategoryId", "categoryApprovalStatus"}, true);

		_finderPathWithoutPaginationFindByparentCategoryIdStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByparentCategoryIdStatus",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"parentCategoryId", "categoryApprovalStatus"},
				true);

		_finderPathCountByparentCategoryIdStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentCategoryIdStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"parentCategoryId", "categoryApprovalStatus"}, false);

		_setCategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCategoryUtilPersistence(null);

		entityCache.removeCache(CategoryImpl.class.getName());
	}

	private void _setCategoryUtilPersistence(
		CategoryPersistence categoryPersistence) {

		try {
			Field field = CategoryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, categoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_categoryPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_categoryPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_categoryPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CATEGORY =
		"SELECT category FROM Category category";

	private static final String _SQL_SELECT_CATEGORY_WHERE =
		"SELECT category FROM Category category WHERE ";

	private static final String _SQL_COUNT_CATEGORY =
		"SELECT COUNT(category) FROM Category category";

	private static final String _SQL_COUNT_CATEGORY_WHERE =
		"SELECT COUNT(category) FROM Category category WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "category.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Category exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Category exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}