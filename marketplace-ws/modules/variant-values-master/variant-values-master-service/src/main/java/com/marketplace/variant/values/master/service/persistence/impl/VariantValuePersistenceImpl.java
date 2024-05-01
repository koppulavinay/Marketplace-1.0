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

package com.marketplace.variant.values.master.service.persistence.impl;

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

import com.marketplace.variant.values.master.exception.NoSuchVariantValueException;
import com.marketplace.variant.values.master.model.VariantValue;
import com.marketplace.variant.values.master.model.VariantValueTable;
import com.marketplace.variant.values.master.model.impl.VariantValueImpl;
import com.marketplace.variant.values.master.model.impl.VariantValueModelImpl;
import com.marketplace.variant.values.master.service.persistence.VariantValuePersistence;
import com.marketplace.variant.values.master.service.persistence.VariantValueUtil;
import com.marketplace.variant.values.master.service.persistence.impl.constants.marketplace_variant_valuePersistenceConstants;

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
 * The persistence implementation for the variant value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VariantValuePersistence.class)
public class VariantValuePersistenceImpl
	extends BasePersistenceImpl<VariantValue>
	implements VariantValuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VariantValueUtil</code> to access the variant value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VariantValueImpl.class.getName();

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
	 * Returns all the variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
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

		List<VariantValue> list = null;

		if (useFinderCache) {
			list = (List<VariantValue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VariantValue variantValue : list) {
					if (!uuid.equals(variantValue.getUuid())) {
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

			sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

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
				sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
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

				list = (List<VariantValue>)QueryUtil.list(
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
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByUuid_First(
			String uuid, OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByUuid_First(uuid, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUuid_First(
		String uuid, OrderByComparator<VariantValue> orderByComparator) {

		List<VariantValue> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByUuid_Last(
			String uuid, OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByUuid_Last(uuid, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUuid_Last(
		String uuid, OrderByComparator<VariantValue> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<VariantValue> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where uuid = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue[] findByUuid_PrevAndNext(
			long variantValueId, String uuid,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		uuid = Objects.toString(uuid, "");

		VariantValue variantValue = findByPrimaryKey(variantValueId);

		Session session = null;

		try {
			session = openSession();

			VariantValue[] array = new VariantValueImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, variantValue, uuid, orderByComparator, true);

			array[1] = variantValue;

			array[2] = getByUuid_PrevAndNext(
				session, variantValue, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VariantValue getByUuid_PrevAndNext(
		Session session, VariantValue variantValue, String uuid,
		OrderByComparator<VariantValue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

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
			sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(variantValue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VariantValue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the variant values where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (VariantValue variantValue :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(variantValue);
		}
	}

	/**
	 * Returns the number of variant values where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variant values
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VARIANTVALUE_WHERE);

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
		"variantValue.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(variantValue.uuid IS NULL OR variantValue.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByUUID_G(String uuid, long groupId)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByUUID_G(uuid, groupId);

		if (variantValue == null) {
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

			throw new NoSuchVariantValueException(sb.toString());
		}

		return variantValue;
	}

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the variant value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUUID_G(
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

		if (result instanceof VariantValue) {
			VariantValue variantValue = (VariantValue)result;

			if (!Objects.equals(uuid, variantValue.getUuid()) ||
				(groupId != variantValue.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

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

				List<VariantValue> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					VariantValue variantValue = list.get(0);

					result = variantValue;

					cacheResult(variantValue);
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
			return (VariantValue)result;
		}
	}

	/**
	 * Removes the variant value where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the variant value that was removed
	 */
	@Override
	public VariantValue removeByUUID_G(String uuid, long groupId)
		throws NoSuchVariantValueException {

		VariantValue variantValue = findByUUID_G(uuid, groupId);

		return remove(variantValue);
	}

	/**
	 * Returns the number of variant values where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching variant values
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VARIANTVALUE_WHERE);

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
		"variantValue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(variantValue.uuid IS NULL OR variantValue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"variantValue.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
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

		List<VariantValue> list = null;

		if (useFinderCache) {
			list = (List<VariantValue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VariantValue variantValue : list) {
					if (!uuid.equals(variantValue.getUuid()) ||
						(companyId != variantValue.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

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
				sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
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

				list = (List<VariantValue>)QueryUtil.list(
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
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the first variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VariantValue> orderByComparator) {

		List<VariantValue> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the last variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VariantValue> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<VariantValue> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue[] findByUuid_C_PrevAndNext(
			long variantValueId, String uuid, long companyId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		uuid = Objects.toString(uuid, "");

		VariantValue variantValue = findByPrimaryKey(variantValueId);

		Session session = null;

		try {
			session = openSession();

			VariantValue[] array = new VariantValueImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, variantValue, uuid, companyId, orderByComparator,
				true);

			array[1] = variantValue;

			array[2] = getByUuid_C_PrevAndNext(
				session, variantValue, uuid, companyId, orderByComparator,
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

	protected VariantValue getByUuid_C_PrevAndNext(
		Session session, VariantValue variantValue, String uuid, long companyId,
		OrderByComparator<VariantValue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

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
			sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(variantValue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VariantValue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the variant values where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (VariantValue variantValue :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(variantValue);
		}
	}

	/**
	 * Returns the number of variant values where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching variant values
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VARIANTVALUE_WHERE);

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
		"variantValue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(variantValue.uuid IS NULL OR variantValue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"variantValue.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByproductVariantId;
	private FinderPath _finderPathWithoutPaginationFindByproductVariantId;
	private FinderPath _finderPathCountByproductVariantId;

	/**
	 * Returns all the variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the matching variant values
	 */
	@Override
	public List<VariantValue> findByproductVariantId(long productVariantId) {
		return findByproductVariantId(
			productVariantId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	@Override
	public List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end) {

		return findByproductVariantId(productVariantId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return findByproductVariantId(
			productVariantId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variant values where productVariantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param productVariantId the product variant ID
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByproductVariantId(
		long productVariantId, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByproductVariantId;
				finderArgs = new Object[] {productVariantId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByproductVariantId;
			finderArgs = new Object[] {
				productVariantId, start, end, orderByComparator
			};
		}

		List<VariantValue> list = null;

		if (useFinderCache) {
			list = (List<VariantValue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VariantValue variantValue : list) {
					if (productVariantId !=
							variantValue.getProductVariantId()) {

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

			sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTVARIANTID_PRODUCTVARIANTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productVariantId);

				list = (List<VariantValue>)QueryUtil.list(
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
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByproductVariantId_First(
			long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByproductVariantId_First(
			productVariantId, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productVariantId=");
		sb.append(productVariantId);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the first variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByproductVariantId_First(
		long productVariantId,
		OrderByComparator<VariantValue> orderByComparator) {

		List<VariantValue> list = findByproductVariantId(
			productVariantId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByproductVariantId_Last(
			long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByproductVariantId_Last(
			productVariantId, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productVariantId=");
		sb.append(productVariantId);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the last variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByproductVariantId_Last(
		long productVariantId,
		OrderByComparator<VariantValue> orderByComparator) {

		int count = countByproductVariantId(productVariantId);

		if (count == 0) {
			return null;
		}

		List<VariantValue> list = findByproductVariantId(
			productVariantId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where productVariantId = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param productVariantId the product variant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue[] findByproductVariantId_PrevAndNext(
			long variantValueId, long productVariantId,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = findByPrimaryKey(variantValueId);

		Session session = null;

		try {
			session = openSession();

			VariantValue[] array = new VariantValueImpl[3];

			array[0] = getByproductVariantId_PrevAndNext(
				session, variantValue, productVariantId, orderByComparator,
				true);

			array[1] = variantValue;

			array[2] = getByproductVariantId_PrevAndNext(
				session, variantValue, productVariantId, orderByComparator,
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

	protected VariantValue getByproductVariantId_PrevAndNext(
		Session session, VariantValue variantValue, long productVariantId,
		OrderByComparator<VariantValue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTVARIANTID_PRODUCTVARIANTID_2);

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
			sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productVariantId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(variantValue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VariantValue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the variant values where productVariantId = &#63; from the database.
	 *
	 * @param productVariantId the product variant ID
	 */
	@Override
	public void removeByproductVariantId(long productVariantId) {
		for (VariantValue variantValue :
				findByproductVariantId(
					productVariantId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(variantValue);
		}
	}

	/**
	 * Returns the number of variant values where productVariantId = &#63;.
	 *
	 * @param productVariantId the product variant ID
	 * @return the number of matching variant values
	 */
	@Override
	public int countByproductVariantId(long productVariantId) {
		FinderPath finderPath = _finderPathCountByproductVariantId;

		Object[] finderArgs = new Object[] {productVariantId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VARIANTVALUE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTVARIANTID_PRODUCTVARIANTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productVariantId);

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
		_FINDER_COLUMN_PRODUCTVARIANTID_PRODUCTVARIANTID_2 =
			"variantValue.productVariantId = ?";

	private FinderPath _finderPathWithPaginationFindByvalueAndId;
	private FinderPath _finderPathWithoutPaginationFindByvalueAndId;
	private FinderPath _finderPathCountByvalueAndId;

	/**
	 * Returns all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the matching variant values
	 */
	@Override
	public List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal) {

		return findByvalueAndId(
			draftProductId, variantVal, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of matching variant values
	 */
	@Override
	public List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end) {

		return findByvalueAndId(draftProductId, variantVal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		OrderByComparator<VariantValue> orderByComparator) {

		return findByvalueAndId(
			draftProductId, variantVal, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variant values
	 */
	@Override
	public List<VariantValue> findByvalueAndId(
		long draftProductId, String variantVal, int start, int end,
		OrderByComparator<VariantValue> orderByComparator,
		boolean useFinderCache) {

		variantVal = Objects.toString(variantVal, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByvalueAndId;
				finderArgs = new Object[] {draftProductId, variantVal};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByvalueAndId;
			finderArgs = new Object[] {
				draftProductId, variantVal, start, end, orderByComparator
			};
		}

		List<VariantValue> list = null;

		if (useFinderCache) {
			list = (List<VariantValue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VariantValue variantValue : list) {
					if ((draftProductId != variantValue.getDraftProductId()) ||
						!variantVal.equals(variantValue.getVariantVal())) {

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

			sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

			sb.append(_FINDER_COLUMN_VALUEANDID_DRAFTPRODUCTID_2);

			boolean bindVariantVal = false;

			if (variantVal.isEmpty()) {
				sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_3);
			}
			else {
				bindVariantVal = true;

				sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindVariantVal) {
					queryPos.add(variantVal);
				}

				list = (List<VariantValue>)QueryUtil.list(
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
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByvalueAndId_First(
			long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByvalueAndId_First(
			draftProductId, variantVal, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", variantVal=");
		sb.append(variantVal);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the first variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByvalueAndId_First(
		long draftProductId, String variantVal,
		OrderByComparator<VariantValue> orderByComparator) {

		List<VariantValue> list = findByvalueAndId(
			draftProductId, variantVal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value
	 * @throws NoSuchVariantValueException if a matching variant value could not be found
	 */
	@Override
	public VariantValue findByvalueAndId_Last(
			long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByvalueAndId_Last(
			draftProductId, variantVal, orderByComparator);

		if (variantValue != null) {
			return variantValue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append(", variantVal=");
		sb.append(variantVal);

		sb.append("}");

		throw new NoSuchVariantValueException(sb.toString());
	}

	/**
	 * Returns the last variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public VariantValue fetchByvalueAndId_Last(
		long draftProductId, String variantVal,
		OrderByComparator<VariantValue> orderByComparator) {

		int count = countByvalueAndId(draftProductId, variantVal);

		if (count == 0) {
			return null;
		}

		List<VariantValue> list = findByvalueAndId(
			draftProductId, variantVal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the variant values before and after the current variant value in the ordered set where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param variantValueId the primary key of the current variant value
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue[] findByvalueAndId_PrevAndNext(
			long variantValueId, long draftProductId, String variantVal,
			OrderByComparator<VariantValue> orderByComparator)
		throws NoSuchVariantValueException {

		variantVal = Objects.toString(variantVal, "");

		VariantValue variantValue = findByPrimaryKey(variantValueId);

		Session session = null;

		try {
			session = openSession();

			VariantValue[] array = new VariantValueImpl[3];

			array[0] = getByvalueAndId_PrevAndNext(
				session, variantValue, draftProductId, variantVal,
				orderByComparator, true);

			array[1] = variantValue;

			array[2] = getByvalueAndId_PrevAndNext(
				session, variantValue, draftProductId, variantVal,
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

	protected VariantValue getByvalueAndId_PrevAndNext(
		Session session, VariantValue variantValue, long draftProductId,
		String variantVal, OrderByComparator<VariantValue> orderByComparator,
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

		sb.append(_SQL_SELECT_VARIANTVALUE_WHERE);

		sb.append(_FINDER_COLUMN_VALUEANDID_DRAFTPRODUCTID_2);

		boolean bindVariantVal = false;

		if (variantVal.isEmpty()) {
			sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_3);
		}
		else {
			bindVariantVal = true;

			sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_2);
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
			sb.append(VariantValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(draftProductId);

		if (bindVariantVal) {
			queryPos.add(variantVal);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(variantValue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VariantValue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the variant values where draftProductId = &#63; and variantVal = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 */
	@Override
	public void removeByvalueAndId(long draftProductId, String variantVal) {
		for (VariantValue variantValue :
				findByvalueAndId(
					draftProductId, variantVal, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(variantValue);
		}
	}

	/**
	 * Returns the number of variant values where draftProductId = &#63; and variantVal = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param variantVal the variant val
	 * @return the number of matching variant values
	 */
	@Override
	public int countByvalueAndId(long draftProductId, String variantVal) {
		variantVal = Objects.toString(variantVal, "");

		FinderPath finderPath = _finderPathCountByvalueAndId;

		Object[] finderArgs = new Object[] {draftProductId, variantVal};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VARIANTVALUE_WHERE);

			sb.append(_FINDER_COLUMN_VALUEANDID_DRAFTPRODUCTID_2);

			boolean bindVariantVal = false;

			if (variantVal.isEmpty()) {
				sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_3);
			}
			else {
				bindVariantVal = true;

				sb.append(_FINDER_COLUMN_VALUEANDID_VARIANTVAL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				if (bindVariantVal) {
					queryPos.add(variantVal);
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

	private static final String _FINDER_COLUMN_VALUEANDID_DRAFTPRODUCTID_2 =
		"variantValue.draftProductId = ? AND ";

	private static final String _FINDER_COLUMN_VALUEANDID_VARIANTVAL_2 =
		"variantValue.variantVal = ?";

	private static final String _FINDER_COLUMN_VALUEANDID_VARIANTVAL_3 =
		"(variantValue.variantVal IS NULL OR variantValue.variantVal = '')";

	public VariantValuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(VariantValue.class);

		setModelImplClass(VariantValueImpl.class);
		setModelPKClass(long.class);

		setTable(VariantValueTable.INSTANCE);
	}

	/**
	 * Caches the variant value in the entity cache if it is enabled.
	 *
	 * @param variantValue the variant value
	 */
	@Override
	public void cacheResult(VariantValue variantValue) {
		entityCache.putResult(
			VariantValueImpl.class, variantValue.getPrimaryKey(), variantValue);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {variantValue.getUuid(), variantValue.getGroupId()},
			variantValue);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the variant values in the entity cache if it is enabled.
	 *
	 * @param variantValues the variant values
	 */
	@Override
	public void cacheResult(List<VariantValue> variantValues) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (variantValues.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VariantValue variantValue : variantValues) {
			if (entityCache.getResult(
					VariantValueImpl.class, variantValue.getPrimaryKey()) ==
						null) {

				cacheResult(variantValue);
			}
		}
	}

	/**
	 * Clears the cache for all variant values.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VariantValueImpl.class);

		finderCache.clearCache(VariantValueImpl.class);
	}

	/**
	 * Clears the cache for the variant value.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VariantValue variantValue) {
		entityCache.removeResult(VariantValueImpl.class, variantValue);
	}

	@Override
	public void clearCache(List<VariantValue> variantValues) {
		for (VariantValue variantValue : variantValues) {
			entityCache.removeResult(VariantValueImpl.class, variantValue);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VariantValueImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VariantValueImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		VariantValueModelImpl variantValueModelImpl) {

		Object[] args = new Object[] {
			variantValueModelImpl.getUuid(), variantValueModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, variantValueModelImpl);
	}

	/**
	 * Creates a new variant value with the primary key. Does not add the variant value to the database.
	 *
	 * @param variantValueId the primary key for the new variant value
	 * @return the new variant value
	 */
	@Override
	public VariantValue create(long variantValueId) {
		VariantValue variantValue = new VariantValueImpl();

		variantValue.setNew(true);
		variantValue.setPrimaryKey(variantValueId);

		String uuid = _portalUUID.generate();

		variantValue.setUuid(uuid);

		variantValue.setCompanyId(CompanyThreadLocal.getCompanyId());

		return variantValue;
	}

	/**
	 * Removes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue remove(long variantValueId)
		throws NoSuchVariantValueException {

		return remove((Serializable)variantValueId);
	}

	/**
	 * Removes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue remove(Serializable primaryKey)
		throws NoSuchVariantValueException {

		Session session = null;

		try {
			session = openSession();

			VariantValue variantValue = (VariantValue)session.get(
				VariantValueImpl.class, primaryKey);

			if (variantValue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVariantValueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(variantValue);
		}
		catch (NoSuchVariantValueException noSuchEntityException) {
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
	protected VariantValue removeImpl(VariantValue variantValue) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(variantValue)) {
				variantValue = (VariantValue)session.get(
					VariantValueImpl.class, variantValue.getPrimaryKeyObj());
			}

			if (variantValue != null) {
				session.delete(variantValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (variantValue != null) {
			clearCache(variantValue);
		}

		return variantValue;
	}

	@Override
	public VariantValue updateImpl(VariantValue variantValue) {
		boolean isNew = variantValue.isNew();

		if (!(variantValue instanceof VariantValueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(variantValue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					variantValue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in variantValue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VariantValue implementation " +
					variantValue.getClass());
		}

		VariantValueModelImpl variantValueModelImpl =
			(VariantValueModelImpl)variantValue;

		if (Validator.isNull(variantValue.getUuid())) {
			String uuid = _portalUUID.generate();

			variantValue.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (variantValue.getCreateDate() == null)) {
			if (serviceContext == null) {
				variantValue.setCreateDate(date);
			}
			else {
				variantValue.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!variantValueModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				variantValue.setModifiedDate(date);
			}
			else {
				variantValue.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(variantValue);
			}
			else {
				variantValue = (VariantValue)session.merge(variantValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VariantValueImpl.class, variantValueModelImpl, false, true);

		cacheUniqueFindersCache(variantValueModelImpl);

		if (isNew) {
			variantValue.setNew(false);
		}

		variantValue.resetOriginalValues();

		return variantValue;
	}

	/**
	 * Returns the variant value with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the variant value
	 * @return the variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVariantValueException {

		VariantValue variantValue = fetchByPrimaryKey(primaryKey);

		if (variantValue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVariantValueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return variantValue;
	}

	/**
	 * Returns the variant value with the primary key or throws a <code>NoSuchVariantValueException</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value
	 * @throws NoSuchVariantValueException if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue findByPrimaryKey(long variantValueId)
		throws NoSuchVariantValueException {

		return findByPrimaryKey((Serializable)variantValueId);
	}

	/**
	 * Returns the variant value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value, or <code>null</code> if a variant value with the primary key could not be found
	 */
	@Override
	public VariantValue fetchByPrimaryKey(long variantValueId) {
		return fetchByPrimaryKey((Serializable)variantValueId);
	}

	/**
	 * Returns all the variant values.
	 *
	 * @return the variant values
	 */
	@Override
	public List<VariantValue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of variant values
	 */
	@Override
	public List<VariantValue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of variant values
	 */
	@Override
	public List<VariantValue> findAll(
		int start, int end, OrderByComparator<VariantValue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of variant values
	 */
	@Override
	public List<VariantValue> findAll(
		int start, int end, OrderByComparator<VariantValue> orderByComparator,
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

		List<VariantValue> list = null;

		if (useFinderCache) {
			list = (List<VariantValue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VARIANTVALUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VARIANTVALUE;

				sql = sql.concat(VariantValueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VariantValue>)QueryUtil.list(
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
	 * Removes all the variant values from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VariantValue variantValue : findAll()) {
			remove(variantValue);
		}
	}

	/**
	 * Returns the number of variant values.
	 *
	 * @return the number of variant values
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VARIANTVALUE);

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
		return "variantValueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VARIANTVALUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VariantValueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the variant value persistence.
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

		_finderPathWithPaginationFindByproductVariantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproductVariantId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productVariantId"}, true);

		_finderPathWithoutPaginationFindByproductVariantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproductVariantId",
			new String[] {Long.class.getName()},
			new String[] {"productVariantId"}, true);

		_finderPathCountByproductVariantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByproductVariantId", new String[] {Long.class.getName()},
			new String[] {"productVariantId"}, false);

		_finderPathWithPaginationFindByvalueAndId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvalueAndId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"draftProductId", "variantVal"}, true);

		_finderPathWithoutPaginationFindByvalueAndId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvalueAndId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "variantVal"}, true);

		_finderPathCountByvalueAndId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvalueAndId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"draftProductId", "variantVal"}, false);

		_setVariantValueUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVariantValueUtilPersistence(null);

		entityCache.removeCache(VariantValueImpl.class.getName());
	}

	private void _setVariantValueUtilPersistence(
		VariantValuePersistence variantValuePersistence) {

		try {
			Field field = VariantValueUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, variantValuePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_variant_valuePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_variant_valuePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_variant_valuePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VARIANTVALUE =
		"SELECT variantValue FROM VariantValue variantValue";

	private static final String _SQL_SELECT_VARIANTVALUE_WHERE =
		"SELECT variantValue FROM VariantValue variantValue WHERE ";

	private static final String _SQL_COUNT_VARIANTVALUE =
		"SELECT COUNT(variantValue) FROM VariantValue variantValue";

	private static final String _SQL_COUNT_VARIANTVALUE_WHERE =
		"SELECT COUNT(variantValue) FROM VariantValue variantValue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "variantValue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VariantValue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VariantValue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VariantValuePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}