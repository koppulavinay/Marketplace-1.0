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

package com.marketplace.brand.service.persistence.impl;

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

import com.marketplace.brand.exception.NoSuchBrandException;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.model.BrandTable;
import com.marketplace.brand.model.impl.BrandImpl;
import com.marketplace.brand.model.impl.BrandModelImpl;
import com.marketplace.brand.service.persistence.BrandPersistence;
import com.marketplace.brand.service.persistence.BrandUtil;
import com.marketplace.brand.service.persistence.impl.constants.marketplace_brandPersistenceConstants;

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
 * The persistence implementation for the brand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BrandPersistence.class)
public class BrandPersistenceImpl
	extends BasePersistenceImpl<Brand> implements BrandPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BrandUtil</code> to access the brand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BrandImpl.class.getName();

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
	 * Returns all the brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching brands
	 */
	@Override
	public List<Brand> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

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

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Brand brand : list) {
					if (!uuid.equals(brand.getUuid())) {
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

			sb.append(_SQL_SELECT_BRAND_WHERE);

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
				sb.append(BrandModelImpl.ORDER_BY_JPQL);
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

				list = (List<Brand>)QueryUtil.list(
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
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_First(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_First(uuid, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_First(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		List<Brand> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_Last(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_Last(uuid, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_Last(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Brand> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand[] findByUuid_PrevAndNext(
			long brandId, String uuid,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		uuid = Objects.toString(uuid, "");

		Brand brand = findByPrimaryKey(brandId);

		Session session = null;

		try {
			session = openSession();

			Brand[] array = new BrandImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, brand, uuid, orderByComparator, true);

			array[1] = brand;

			array[2] = getByUuid_PrevAndNext(
				session, brand, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Brand getByUuid_PrevAndNext(
		Session session, Brand brand, String uuid,
		OrderByComparator<Brand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRAND_WHERE);

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
			sb.append(BrandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(brand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Brand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Brand brand :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(brand);
		}
	}

	/**
	 * Returns the number of brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching brands
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "brand.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(brand.uuid IS NULL OR brand.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUUID_G(String uuid, long groupId)
		throws NoSuchBrandException {

		Brand brand = fetchByUUID_G(uuid, groupId);

		if (brand == null) {
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

			throw new NoSuchBrandException(sb.toString());
		}

		return brand;
	}

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the brand where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUUID_G(
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

		if (result instanceof Brand) {
			Brand brand = (Brand)result;

			if (!Objects.equals(uuid, brand.getUuid()) ||
				(groupId != brand.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BRAND_WHERE);

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

				List<Brand> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Brand brand = list.get(0);

					result = brand;

					cacheResult(brand);
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
			return (Brand)result;
		}
	}

	/**
	 * Removes the brand where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the brand that was removed
	 */
	@Override
	public Brand removeByUUID_G(String uuid, long groupId)
		throws NoSuchBrandException {

		Brand brand = findByUUID_G(uuid, groupId);

		return remove(brand);
	}

	/**
	 * Returns the number of brands where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching brands
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BRAND_WHERE);

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
		"brand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(brand.uuid IS NULL OR brand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"brand.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching brands
	 */
	@Override
	public List<Brand> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	@Override
	public List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

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

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Brand brand : list) {
					if (!uuid.equals(brand.getUuid()) ||
						(companyId != brand.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BRAND_WHERE);

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
				sb.append(BrandModelImpl.ORDER_BY_JPQL);
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

				list = (List<Brand>)QueryUtil.list(
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
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Brand> orderByComparator) {

		List<Brand> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Brand> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Brand> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand[] findByUuid_C_PrevAndNext(
			long brandId, String uuid, long companyId,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		uuid = Objects.toString(uuid, "");

		Brand brand = findByPrimaryKey(brandId);

		Session session = null;

		try {
			session = openSession();

			Brand[] array = new BrandImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, brand, uuid, companyId, orderByComparator, true);

			array[1] = brand;

			array[2] = getByUuid_C_PrevAndNext(
				session, brand, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Brand getByUuid_C_PrevAndNext(
		Session session, Brand brand, String uuid, long companyId,
		OrderByComparator<Brand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BRAND_WHERE);

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
			sb.append(BrandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(brand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Brand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brands where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Brand brand :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(brand);
		}
	}

	/**
	 * Returns the number of brands where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching brands
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BRAND_WHERE);

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
		"brand.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(brand.uuid IS NULL OR brand.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"brand.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFBYStatus;
	private FinderPath _finderPathWithoutPaginationFindByFBYStatus;
	private FinderPath _finderPathCountByFBYStatus;

	/**
	 * Returns all the brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the matching brands
	 */
	@Override
	public List<Brand> findByFBYStatus(String brandApprovalStatus) {
		return findByFBYStatus(
			brandApprovalStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	@Override
	public List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end) {

		return findByFBYStatus(brandApprovalStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return findByFBYStatus(
			brandApprovalStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands where brandApprovalStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByFBYStatus(
		String brandApprovalStatus, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		brandApprovalStatus = Objects.toString(brandApprovalStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFBYStatus;
				finderArgs = new Object[] {brandApprovalStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFBYStatus;
			finderArgs = new Object[] {
				brandApprovalStatus, start, end, orderByComparator
			};
		}

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Brand brand : list) {
					if (!brandApprovalStatus.equals(
							brand.getBrandApprovalStatus())) {

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

			sb.append(_SQL_SELECT_BRAND_WHERE);

			boolean bindBrandApprovalStatus = false;

			if (brandApprovalStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_3);
			}
			else {
				bindBrandApprovalStatus = true;

				sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBrandApprovalStatus) {
					queryPos.add(brandApprovalStatus);
				}

				list = (List<Brand>)QueryUtil.list(
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
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByFBYStatus_First(
			String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByFBYStatus_First(
			brandApprovalStatus, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandApprovalStatus=");
		sb.append(brandApprovalStatus);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the first brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYStatus_First(
		String brandApprovalStatus,
		OrderByComparator<Brand> orderByComparator) {

		List<Brand> list = findByFBYStatus(
			brandApprovalStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByFBYStatus_Last(
			String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByFBYStatus_Last(
			brandApprovalStatus, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandApprovalStatus=");
		sb.append(brandApprovalStatus);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the last brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYStatus_Last(
		String brandApprovalStatus,
		OrderByComparator<Brand> orderByComparator) {

		int count = countByFBYStatus(brandApprovalStatus);

		if (count == 0) {
			return null;
		}

		List<Brand> list = findByFBYStatus(
			brandApprovalStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where brandApprovalStatus = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param brandApprovalStatus the brand approval status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand[] findByFBYStatus_PrevAndNext(
			long brandId, String brandApprovalStatus,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		brandApprovalStatus = Objects.toString(brandApprovalStatus, "");

		Brand brand = findByPrimaryKey(brandId);

		Session session = null;

		try {
			session = openSession();

			Brand[] array = new BrandImpl[3];

			array[0] = getByFBYStatus_PrevAndNext(
				session, brand, brandApprovalStatus, orderByComparator, true);

			array[1] = brand;

			array[2] = getByFBYStatus_PrevAndNext(
				session, brand, brandApprovalStatus, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Brand getByFBYStatus_PrevAndNext(
		Session session, Brand brand, String brandApprovalStatus,
		OrderByComparator<Brand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRAND_WHERE);

		boolean bindBrandApprovalStatus = false;

		if (brandApprovalStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_3);
		}
		else {
			bindBrandApprovalStatus = true;

			sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_2);
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
			sb.append(BrandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBrandApprovalStatus) {
			queryPos.add(brandApprovalStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(brand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Brand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brands where brandApprovalStatus = &#63; from the database.
	 *
	 * @param brandApprovalStatus the brand approval status
	 */
	@Override
	public void removeByFBYStatus(String brandApprovalStatus) {
		for (Brand brand :
				findByFBYStatus(
					brandApprovalStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(brand);
		}
	}

	/**
	 * Returns the number of brands where brandApprovalStatus = &#63;.
	 *
	 * @param brandApprovalStatus the brand approval status
	 * @return the number of matching brands
	 */
	@Override
	public int countByFBYStatus(String brandApprovalStatus) {
		brandApprovalStatus = Objects.toString(brandApprovalStatus, "");

		FinderPath finderPath = _finderPathCountByFBYStatus;

		Object[] finderArgs = new Object[] {brandApprovalStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

			boolean bindBrandApprovalStatus = false;

			if (brandApprovalStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_3);
			}
			else {
				bindBrandApprovalStatus = true;

				sb.append(_FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBrandApprovalStatus) {
					queryPos.add(brandApprovalStatus);
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

	private static final String _FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_2 =
		"brand.brandApprovalStatus = ?";

	private static final String _FINDER_COLUMN_FBYSTATUS_BRANDAPPROVALSTATUS_3 =
		"(brand.brandApprovalStatus IS NULL OR brand.brandApprovalStatus = '')";

	private FinderPath _finderPathWithPaginationFindByFBYCreatedBy;
	private FinderPath _finderPathWithoutPaginationFindByFBYCreatedBy;
	private FinderPath _finderPathCountByFBYCreatedBy;

	/**
	 * Returns all the brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching brands
	 */
	@Override
	public List<Brand> findByFBYCreatedBy(long createdBy) {
		return findByFBYCreatedBy(
			createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	@Override
	public List<Brand> findByFBYCreatedBy(long createdBy, int start, int end) {
		return findByFBYCreatedBy(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return findByFBYCreatedBy(
			createdBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByFBYCreatedBy(
		long createdBy, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFBYCreatedBy;
				finderArgs = new Object[] {createdBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFBYCreatedBy;
			finderArgs = new Object[] {
				createdBy, start, end, orderByComparator
			};
		}

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Brand brand : list) {
					if (createdBy != brand.getCreatedBy()) {
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

			sb.append(_SQL_SELECT_BRAND_WHERE);

			sb.append(_FINDER_COLUMN_FBYCREATEDBY_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrandModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdBy);

				list = (List<Brand>)QueryUtil.list(
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
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByFBYCreatedBy_First(
			long createdBy, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByFBYCreatedBy_First(createdBy, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdBy=");
		sb.append(createdBy);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the first brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYCreatedBy_First(
		long createdBy, OrderByComparator<Brand> orderByComparator) {

		List<Brand> list = findByFBYCreatedBy(
			createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByFBYCreatedBy_Last(
			long createdBy, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByFBYCreatedBy_Last(createdBy, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdBy=");
		sb.append(createdBy);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the last brand in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYCreatedBy_Last(
		long createdBy, OrderByComparator<Brand> orderByComparator) {

		int count = countByFBYCreatedBy(createdBy);

		if (count == 0) {
			return null;
		}

		List<Brand> list = findByFBYCreatedBy(
			createdBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where createdBy = &#63;.
	 *
	 * @param brandId the primary key of the current brand
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand[] findByFBYCreatedBy_PrevAndNext(
			long brandId, long createdBy,
			OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = findByPrimaryKey(brandId);

		Session session = null;

		try {
			session = openSession();

			Brand[] array = new BrandImpl[3];

			array[0] = getByFBYCreatedBy_PrevAndNext(
				session, brand, createdBy, orderByComparator, true);

			array[1] = brand;

			array[2] = getByFBYCreatedBy_PrevAndNext(
				session, brand, createdBy, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Brand getByFBYCreatedBy_PrevAndNext(
		Session session, Brand brand, long createdBy,
		OrderByComparator<Brand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRAND_WHERE);

		sb.append(_FINDER_COLUMN_FBYCREATEDBY_CREATEDBY_2);

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
			sb.append(BrandModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(createdBy);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(brand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Brand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brands where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 */
	@Override
	public void removeByFBYCreatedBy(long createdBy) {
		for (Brand brand :
				findByFBYCreatedBy(
					createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(brand);
		}
	}

	/**
	 * Returns the number of brands where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching brands
	 */
	@Override
	public int countByFBYCreatedBy(long createdBy) {
		FinderPath finderPath = _finderPathCountByFBYCreatedBy;

		Object[] finderArgs = new Object[] {createdBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

			sb.append(_FINDER_COLUMN_FBYCREATEDBY_CREATEDBY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdBy);

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

	private static final String _FINDER_COLUMN_FBYCREATEDBY_CREATEDBY_2 =
		"brand.createdBy = ?";

	private FinderPath _finderPathFetchByFBYAssetCategoryId;
	private FinderPath _finderPathCountByFBYAssetCategoryId;

	/**
	 * Returns the brand where assetCategoryId = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchBrandException {

		Brand brand = fetchByFBYAssetCategoryId(assetCategoryId);

		if (brand == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("assetCategoryId=");
			sb.append(assetCategoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBrandException(sb.toString());
		}

		return brand;
	}

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYAssetCategoryId(long assetCategoryId) {
		return fetchByFBYAssetCategoryId(assetCategoryId, true);
	}

	/**
	 * Returns the brand where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByFBYAssetCategoryId(
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

		if (result instanceof Brand) {
			Brand brand = (Brand)result;

			if (assetCategoryId != brand.getAssetCategoryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BRAND_WHERE);

			sb.append(_FINDER_COLUMN_FBYASSETCATEGORYID_ASSETCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetCategoryId);

				List<Brand> list = query.list();

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
								"BrandPersistenceImpl.fetchByFBYAssetCategoryId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Brand brand = list.get(0);

					result = brand;

					cacheResult(brand);
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
			return (Brand)result;
		}
	}

	/**
	 * Removes the brand where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the brand that was removed
	 */
	@Override
	public Brand removeByFBYAssetCategoryId(long assetCategoryId)
		throws NoSuchBrandException {

		Brand brand = findByFBYAssetCategoryId(assetCategoryId);

		return remove(brand);
	}

	/**
	 * Returns the number of brands where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching brands
	 */
	@Override
	public int countByFBYAssetCategoryId(long assetCategoryId) {
		FinderPath finderPath = _finderPathCountByFBYAssetCategoryId;

		Object[] finderArgs = new Object[] {assetCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

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
			"brand.assetCategoryId = ?";

	public BrandPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Brand.class);

		setModelImplClass(BrandImpl.class);
		setModelPKClass(long.class);

		setTable(BrandTable.INSTANCE);
	}

	/**
	 * Caches the brand in the entity cache if it is enabled.
	 *
	 * @param brand the brand
	 */
	@Override
	public void cacheResult(Brand brand) {
		entityCache.putResult(BrandImpl.class, brand.getPrimaryKey(), brand);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {brand.getUuid(), brand.getGroupId()}, brand);

		finderCache.putResult(
			_finderPathFetchByFBYAssetCategoryId,
			new Object[] {brand.getAssetCategoryId()}, brand);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the brands in the entity cache if it is enabled.
	 *
	 * @param brands the brands
	 */
	@Override
	public void cacheResult(List<Brand> brands) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (brands.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Brand brand : brands) {
			if (entityCache.getResult(BrandImpl.class, brand.getPrimaryKey()) ==
					null) {

				cacheResult(brand);
			}
		}
	}

	/**
	 * Clears the cache for all brands.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BrandImpl.class);

		finderCache.clearCache(BrandImpl.class);
	}

	/**
	 * Clears the cache for the brand.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Brand brand) {
		entityCache.removeResult(BrandImpl.class, brand);
	}

	@Override
	public void clearCache(List<Brand> brands) {
		for (Brand brand : brands) {
			entityCache.removeResult(BrandImpl.class, brand);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BrandImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BrandImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(BrandModelImpl brandModelImpl) {
		Object[] args = new Object[] {
			brandModelImpl.getUuid(), brandModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, brandModelImpl);

		args = new Object[] {brandModelImpl.getAssetCategoryId()};

		finderCache.putResult(
			_finderPathCountByFBYAssetCategoryId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFBYAssetCategoryId, args, brandModelImpl);
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	@Override
	public Brand create(long brandId) {
		Brand brand = new BrandImpl();

		brand.setNew(true);
		brand.setPrimaryKey(brandId);

		String uuid = _portalUUID.generate();

		brand.setUuid(uuid);

		brand.setCompanyId(CompanyThreadLocal.getCompanyId());

		return brand;
	}

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand remove(long brandId) throws NoSuchBrandException {
		return remove((Serializable)brandId);
	}

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand remove(Serializable primaryKey) throws NoSuchBrandException {
		Session session = null;

		try {
			session = openSession();

			Brand brand = (Brand)session.get(BrandImpl.class, primaryKey);

			if (brand == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(brand);
		}
		catch (NoSuchBrandException noSuchEntityException) {
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
	protected Brand removeImpl(Brand brand) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(brand)) {
				brand = (Brand)session.get(
					BrandImpl.class, brand.getPrimaryKeyObj());
			}

			if (brand != null) {
				session.delete(brand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (brand != null) {
			clearCache(brand);
		}

		return brand;
	}

	@Override
	public Brand updateImpl(Brand brand) {
		boolean isNew = brand.isNew();

		if (!(brand instanceof BrandModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(brand.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(brand);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in brand proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Brand implementation " +
					brand.getClass());
		}

		BrandModelImpl brandModelImpl = (BrandModelImpl)brand;

		if (Validator.isNull(brand.getUuid())) {
			String uuid = _portalUUID.generate();

			brand.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (brand.getCreateDate() == null)) {
			if (serviceContext == null) {
				brand.setCreateDate(date);
			}
			else {
				brand.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!brandModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				brand.setModifiedDate(date);
			}
			else {
				brand.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(brand);
			}
			else {
				brand = (Brand)session.merge(brand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BrandImpl.class, brandModelImpl, false, true);

		cacheUniqueFindersCache(brandModelImpl);

		if (isNew) {
			brand.setNew(false);
		}

		brand.resetOriginalValues();

		return brand;
	}

	/**
	 * Returns the brand with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandException {

		Brand brand = fetchByPrimaryKey(primaryKey);

		if (brand == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return brand;
	}

	/**
	 * Returns the brand with the primary key or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand findByPrimaryKey(long brandId) throws NoSuchBrandException {
		return findByPrimaryKey((Serializable)brandId);
	}

	/**
	 * Returns the brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand, or <code>null</code> if a brand with the primary key could not be found
	 */
	@Override
	public Brand fetchByPrimaryKey(long brandId) {
		return fetchByPrimaryKey((Serializable)brandId);
	}

	/**
	 * Returns all the brands.
	 *
	 * @return the brands
	 */
	@Override
	public List<Brand> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of brands
	 */
	@Override
	public List<Brand> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brands
	 */
	@Override
	public List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brands
	 */
	@Override
	public List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator,
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

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRAND);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRAND;

				sql = sql.concat(BrandModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Brand>)QueryUtil.list(
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
	 * Removes all the brands from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Brand brand : findAll()) {
			remove(brand);
		}
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BRAND);

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
		return "brandId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BRAND;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BrandModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the brand persistence.
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

		_finderPathWithPaginationFindByFBYStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFBYStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"brandApprovalStatus"}, true);

		_finderPathWithoutPaginationFindByFBYStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFBYStatus",
			new String[] {String.class.getName()},
			new String[] {"brandApprovalStatus"}, true);

		_finderPathCountByFBYStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFBYStatus",
			new String[] {String.class.getName()},
			new String[] {"brandApprovalStatus"}, false);

		_finderPathWithPaginationFindByFBYCreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFBYCreatedBy",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"createdBy"}, true);

		_finderPathWithoutPaginationFindByFBYCreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFBYCreatedBy",
			new String[] {Long.class.getName()}, new String[] {"createdBy"},
			true);

		_finderPathCountByFBYCreatedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFBYCreatedBy",
			new String[] {Long.class.getName()}, new String[] {"createdBy"},
			false);

		_finderPathFetchByFBYAssetCategoryId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFBYAssetCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"assetCategoryId"}, true);

		_finderPathCountByFBYAssetCategoryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFBYAssetCategoryId", new String[] {Long.class.getName()},
			new String[] {"assetCategoryId"}, false);

		_setBrandUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBrandUtilPersistence(null);

		entityCache.removeCache(BrandImpl.class.getName());
	}

	private void _setBrandUtilPersistence(BrandPersistence brandPersistence) {
		try {
			Field field = BrandUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, brandPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_brandPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_brandPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_brandPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BRAND =
		"SELECT brand FROM Brand brand";

	private static final String _SQL_SELECT_BRAND_WHERE =
		"SELECT brand FROM Brand brand WHERE ";

	private static final String _SQL_COUNT_BRAND =
		"SELECT COUNT(brand) FROM Brand brand";

	private static final String _SQL_COUNT_BRAND_WHERE =
		"SELECT COUNT(brand) FROM Brand brand WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "brand.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Brand exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Brand exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BrandPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}