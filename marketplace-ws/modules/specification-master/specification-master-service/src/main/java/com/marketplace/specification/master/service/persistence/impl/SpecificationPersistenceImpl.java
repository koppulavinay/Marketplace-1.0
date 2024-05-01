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

package com.marketplace.specification.master.service.persistence.impl;

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

import com.marketplace.specification.master.exception.NoSuchSpecificationException;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.model.SpecificationTable;
import com.marketplace.specification.master.model.impl.SpecificationImpl;
import com.marketplace.specification.master.model.impl.SpecificationModelImpl;
import com.marketplace.specification.master.service.persistence.SpecificationPersistence;
import com.marketplace.specification.master.service.persistence.SpecificationUtil;
import com.marketplace.specification.master.service.persistence.impl.constants.marketplacePersistenceConstants;

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
 * The persistence implementation for the specification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecificationPersistence.class)
public class SpecificationPersistenceImpl
	extends BasePersistenceImpl<Specification>
	implements SpecificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecificationUtil</code> to access the specification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecificationImpl.class.getName();

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
	 * Returns all the specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching specifications
	 */
	@Override
	public List<Specification> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Specification> orderByComparator,
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

		List<Specification> list = null;

		if (useFinderCache) {
			list = (List<Specification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Specification specification : list) {
					if (!uuid.equals(specification.getUuid())) {
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

			sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

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
				sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Specification>)QueryUtil.list(
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
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findByUuid_First(
			String uuid, OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchByUuid_First(
			uuid, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUuid_First(
		String uuid, OrderByComparator<Specification> orderByComparator) {

		List<Specification> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findByUuid_Last(
			String uuid, OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchByUuid_Last(uuid, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUuid_Last(
		String uuid, OrderByComparator<Specification> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Specification> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification[] findByUuid_PrevAndNext(
			long specificationId, String uuid,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		uuid = Objects.toString(uuid, "");

		Specification specification = findByPrimaryKey(specificationId);

		Session session = null;

		try {
			session = openSession();

			Specification[] array = new SpecificationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, specification, uuid, orderByComparator, true);

			array[1] = specification;

			array[2] = getByUuid_PrevAndNext(
				session, specification, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Specification getByUuid_PrevAndNext(
		Session session, Specification specification, String uuid,
		OrderByComparator<Specification> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

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
			sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
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
						specification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Specification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Specification specification :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(specification);
		}
	}

	/**
	 * Returns the number of specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching specifications
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECIFICATION_WHERE);

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
		"specification.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(specification.uuid IS NULL OR specification.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationException {

		Specification specification = fetchByUUID_G(uuid, groupId);

		if (specification == null) {
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

			throw new NoSuchSpecificationException(sb.toString());
		}

		return specification;
	}

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUUID_G(
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

		if (result instanceof Specification) {
			Specification specification = (Specification)result;

			if (!Objects.equals(uuid, specification.getUuid()) ||
				(groupId != specification.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

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

				List<Specification> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Specification specification = list.get(0);

					result = specification;

					cacheResult(specification);
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
			return (Specification)result;
		}
	}

	/**
	 * Removes the specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the specification that was removed
	 */
	@Override
	public Specification removeByUUID_G(String uuid, long groupId)
		throws NoSuchSpecificationException {

		Specification specification = findByUUID_G(uuid, groupId);

		return remove(specification);
	}

	/**
	 * Returns the number of specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching specifications
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPECIFICATION_WHERE);

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
		"specification.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(specification.uuid IS NULL OR specification.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"specification.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching specifications
	 */
	@Override
	public List<Specification> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Specification> orderByComparator,
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

		List<Specification> list = null;

		if (useFinderCache) {
			list = (List<Specification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Specification specification : list) {
					if (!uuid.equals(specification.getUuid()) ||
						(companyId != specification.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

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
				sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Specification>)QueryUtil.list(
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
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the first specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Specification> orderByComparator) {

		List<Specification> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the last specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Specification> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Specification> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification[] findByUuid_C_PrevAndNext(
			long specificationId, String uuid, long companyId,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		uuid = Objects.toString(uuid, "");

		Specification specification = findByPrimaryKey(specificationId);

		Session session = null;

		try {
			session = openSession();

			Specification[] array = new SpecificationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, specification, uuid, companyId, orderByComparator,
				true);

			array[1] = specification;

			array[2] = getByUuid_C_PrevAndNext(
				session, specification, uuid, companyId, orderByComparator,
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

	protected Specification getByUuid_C_PrevAndNext(
		Session session, Specification specification, String uuid,
		long companyId, OrderByComparator<Specification> orderByComparator,
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

		sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

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
			sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
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
						specification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Specification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Specification specification :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(specification);
		}
	}

	/**
	 * Returns the number of specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching specifications
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPECIFICATION_WHERE);

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
		"specification.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(specification.uuid IS NULL OR specification.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"specification.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBySpecificationStatus;
	private FinderPath _finderPathWithoutPaginationFindBySpecificationStatus;
	private FinderPath _finderPathCountBySpecificationStatus;

	/**
	 * Returns all the specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the matching specifications
	 */
	@Override
	public List<Specification> findBySpecificationStatus(
		String specificationStatus) {

		return findBySpecificationStatus(
			specificationStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of matching specifications
	 */
	@Override
	public List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end) {

		return findBySpecificationStatus(specificationStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return findBySpecificationStatus(
			specificationStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the specifications where specificationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param specificationStatus the specification status
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specifications
	 */
	@Override
	public List<Specification> findBySpecificationStatus(
		String specificationStatus, int start, int end,
		OrderByComparator<Specification> orderByComparator,
		boolean useFinderCache) {

		specificationStatus = Objects.toString(specificationStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySpecificationStatus;
				finderArgs = new Object[] {specificationStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySpecificationStatus;
			finderArgs = new Object[] {
				specificationStatus, start, end, orderByComparator
			};
		}

		List<Specification> list = null;

		if (useFinderCache) {
			list = (List<Specification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Specification specification : list) {
					if (!specificationStatus.equals(
							specification.getSpecificationStatus())) {

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

			sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

			boolean bindSpecificationStatus = false;

			if (specificationStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_3);
			}
			else {
				bindSpecificationStatus = true;

				sb.append(
					_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSpecificationStatus) {
					queryPos.add(specificationStatus);
				}

				list = (List<Specification>)QueryUtil.list(
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
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findBySpecificationStatus_First(
			String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchBySpecificationStatus_First(
			specificationStatus, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specificationStatus=");
		sb.append(specificationStatus);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the first specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchBySpecificationStatus_First(
		String specificationStatus,
		OrderByComparator<Specification> orderByComparator) {

		List<Specification> list = findBySpecificationStatus(
			specificationStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification
	 * @throws NoSuchSpecificationException if a matching specification could not be found
	 */
	@Override
	public Specification findBySpecificationStatus_Last(
			String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		Specification specification = fetchBySpecificationStatus_Last(
			specificationStatus, orderByComparator);

		if (specification != null) {
			return specification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("specificationStatus=");
		sb.append(specificationStatus);

		sb.append("}");

		throw new NoSuchSpecificationException(sb.toString());
	}

	/**
	 * Returns the last specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specification, or <code>null</code> if a matching specification could not be found
	 */
	@Override
	public Specification fetchBySpecificationStatus_Last(
		String specificationStatus,
		OrderByComparator<Specification> orderByComparator) {

		int count = countBySpecificationStatus(specificationStatus);

		if (count == 0) {
			return null;
		}

		List<Specification> list = findBySpecificationStatus(
			specificationStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specifications before and after the current specification in the ordered set where specificationStatus = &#63;.
	 *
	 * @param specificationId the primary key of the current specification
	 * @param specificationStatus the specification status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification[] findBySpecificationStatus_PrevAndNext(
			long specificationId, String specificationStatus,
			OrderByComparator<Specification> orderByComparator)
		throws NoSuchSpecificationException {

		specificationStatus = Objects.toString(specificationStatus, "");

		Specification specification = findByPrimaryKey(specificationId);

		Session session = null;

		try {
			session = openSession();

			Specification[] array = new SpecificationImpl[3];

			array[0] = getBySpecificationStatus_PrevAndNext(
				session, specification, specificationStatus, orderByComparator,
				true);

			array[1] = specification;

			array[2] = getBySpecificationStatus_PrevAndNext(
				session, specification, specificationStatus, orderByComparator,
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

	protected Specification getBySpecificationStatus_PrevAndNext(
		Session session, Specification specification,
		String specificationStatus,
		OrderByComparator<Specification> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECIFICATION_WHERE);

		boolean bindSpecificationStatus = false;

		if (specificationStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_3);
		}
		else {
			bindSpecificationStatus = true;

			sb.append(_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_2);
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
			sb.append(SpecificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSpecificationStatus) {
			queryPos.add(specificationStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Specification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specifications where specificationStatus = &#63; from the database.
	 *
	 * @param specificationStatus the specification status
	 */
	@Override
	public void removeBySpecificationStatus(String specificationStatus) {
		for (Specification specification :
				findBySpecificationStatus(
					specificationStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(specification);
		}
	}

	/**
	 * Returns the number of specifications where specificationStatus = &#63;.
	 *
	 * @param specificationStatus the specification status
	 * @return the number of matching specifications
	 */
	@Override
	public int countBySpecificationStatus(String specificationStatus) {
		specificationStatus = Objects.toString(specificationStatus, "");

		FinderPath finderPath = _finderPathCountBySpecificationStatus;

		Object[] finderArgs = new Object[] {specificationStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECIFICATION_WHERE);

			boolean bindSpecificationStatus = false;

			if (specificationStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_3);
			}
			else {
				bindSpecificationStatus = true;

				sb.append(
					_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSpecificationStatus) {
					queryPos.add(specificationStatus);
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
		_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_2 =
			"specification.specificationStatus = ?";

	private static final String
		_FINDER_COLUMN_SPECIFICATIONSTATUS_SPECIFICATIONSTATUS_3 =
			"(specification.specificationStatus IS NULL OR specification.specificationStatus = '')";

	public SpecificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Specification.class);

		setModelImplClass(SpecificationImpl.class);
		setModelPKClass(long.class);

		setTable(SpecificationTable.INSTANCE);
	}

	/**
	 * Caches the specification in the entity cache if it is enabled.
	 *
	 * @param specification the specification
	 */
	@Override
	public void cacheResult(Specification specification) {
		entityCache.putResult(
			SpecificationImpl.class, specification.getPrimaryKey(),
			specification);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {specification.getUuid(), specification.getGroupId()},
			specification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the specifications in the entity cache if it is enabled.
	 *
	 * @param specifications the specifications
	 */
	@Override
	public void cacheResult(List<Specification> specifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specifications.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Specification specification : specifications) {
			if (entityCache.getResult(
					SpecificationImpl.class, specification.getPrimaryKey()) ==
						null) {

				cacheResult(specification);
			}
		}
	}

	/**
	 * Clears the cache for all specifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecificationImpl.class);

		finderCache.clearCache(SpecificationImpl.class);
	}

	/**
	 * Clears the cache for the specification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Specification specification) {
		entityCache.removeResult(SpecificationImpl.class, specification);
	}

	@Override
	public void clearCache(List<Specification> specifications) {
		for (Specification specification : specifications) {
			entityCache.removeResult(SpecificationImpl.class, specification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecificationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecificationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SpecificationModelImpl specificationModelImpl) {

		Object[] args = new Object[] {
			specificationModelImpl.getUuid(),
			specificationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, specificationModelImpl);
	}

	/**
	 * Creates a new specification with the primary key. Does not add the specification to the database.
	 *
	 * @param specificationId the primary key for the new specification
	 * @return the new specification
	 */
	@Override
	public Specification create(long specificationId) {
		Specification specification = new SpecificationImpl();

		specification.setNew(true);
		specification.setPrimaryKey(specificationId);

		String uuid = _portalUUID.generate();

		specification.setUuid(uuid);

		specification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return specification;
	}

	/**
	 * Removes the specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification that was removed
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification remove(long specificationId)
		throws NoSuchSpecificationException {

		return remove((Serializable)specificationId);
	}

	/**
	 * Removes the specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the specification
	 * @return the specification that was removed
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification remove(Serializable primaryKey)
		throws NoSuchSpecificationException {

		Session session = null;

		try {
			session = openSession();

			Specification specification = (Specification)session.get(
				SpecificationImpl.class, primaryKey);

			if (specification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specification);
		}
		catch (NoSuchSpecificationException noSuchEntityException) {
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
	protected Specification removeImpl(Specification specification) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specification)) {
				specification = (Specification)session.get(
					SpecificationImpl.class, specification.getPrimaryKeyObj());
			}

			if (specification != null) {
				session.delete(specification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specification != null) {
			clearCache(specification);
		}

		return specification;
	}

	@Override
	public Specification updateImpl(Specification specification) {
		boolean isNew = specification.isNew();

		if (!(specification instanceof SpecificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Specification implementation " +
					specification.getClass());
		}

		SpecificationModelImpl specificationModelImpl =
			(SpecificationModelImpl)specification;

		if (Validator.isNull(specification.getUuid())) {
			String uuid = _portalUUID.generate();

			specification.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (specification.getCreateDate() == null)) {
			if (serviceContext == null) {
				specification.setCreateDate(date);
			}
			else {
				specification.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!specificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				specification.setModifiedDate(date);
			}
			else {
				specification.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specification);
			}
			else {
				specification = (Specification)session.merge(specification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecificationImpl.class, specificationModelImpl, false, true);

		cacheUniqueFindersCache(specificationModelImpl);

		if (isNew) {
			specification.setNew(false);
		}

		specification.resetOriginalValues();

		return specification;
	}

	/**
	 * Returns the specification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the specification
	 * @return the specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecificationException {

		Specification specification = fetchByPrimaryKey(primaryKey);

		if (specification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specification;
	}

	/**
	 * Returns the specification with the primary key or throws a <code>NoSuchSpecificationException</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification
	 * @throws NoSuchSpecificationException if a specification with the primary key could not be found
	 */
	@Override
	public Specification findByPrimaryKey(long specificationId)
		throws NoSuchSpecificationException {

		return findByPrimaryKey((Serializable)specificationId);
	}

	/**
	 * Returns the specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specificationId the primary key of the specification
	 * @return the specification, or <code>null</code> if a specification with the primary key could not be found
	 */
	@Override
	public Specification fetchByPrimaryKey(long specificationId) {
		return fetchByPrimaryKey((Serializable)specificationId);
	}

	/**
	 * Returns all the specifications.
	 *
	 * @return the specifications
	 */
	@Override
	public List<Specification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @return the range of specifications
	 */
	@Override
	public List<Specification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specifications
	 */
	@Override
	public List<Specification> findAll(
		int start, int end,
		OrderByComparator<Specification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specifications
	 * @param end the upper bound of the range of specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specifications
	 */
	@Override
	public List<Specification> findAll(
		int start, int end, OrderByComparator<Specification> orderByComparator,
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

		List<Specification> list = null;

		if (useFinderCache) {
			list = (List<Specification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECIFICATION;

				sql = sql.concat(SpecificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Specification>)QueryUtil.list(
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
	 * Removes all the specifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Specification specification : findAll()) {
			remove(specification);
		}
	}

	/**
	 * Returns the number of specifications.
	 *
	 * @return the number of specifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECIFICATION);

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
		return "specificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the specification persistence.
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

		_finderPathWithPaginationFindBySpecificationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpecificationStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"specificationStatus"}, true);

		_finderPathWithoutPaginationFindBySpecificationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySpecificationStatus", new String[] {String.class.getName()},
			new String[] {"specificationStatus"}, true);

		_finderPathCountBySpecificationStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpecificationStatus", new String[] {String.class.getName()},
			new String[] {"specificationStatus"}, false);

		_setSpecificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecificationUtilPersistence(null);

		entityCache.removeCache(SpecificationImpl.class.getName());
	}

	private void _setSpecificationUtilPersistence(
		SpecificationPersistence specificationPersistence) {

		try {
			Field field = SpecificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specificationPersistence);
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

	private static final String _SQL_SELECT_SPECIFICATION =
		"SELECT specification FROM Specification specification";

	private static final String _SQL_SELECT_SPECIFICATION_WHERE =
		"SELECT specification FROM Specification specification WHERE ";

	private static final String _SQL_COUNT_SPECIFICATION =
		"SELECT COUNT(specification) FROM Specification specification";

	private static final String _SQL_COUNT_SPECIFICATION_WHERE =
		"SELECT COUNT(specification) FROM Specification specification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Specification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Specification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecificationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}