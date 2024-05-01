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

package com.marketplace.product.specifications.master.service.persistence.impl;

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

import com.marketplace.product.specifications.master.exception.NoSuchProductSpecificationException;
import com.marketplace.product.specifications.master.model.ProductSpecification;
import com.marketplace.product.specifications.master.model.ProductSpecificationTable;
import com.marketplace.product.specifications.master.model.impl.ProductSpecificationImpl;
import com.marketplace.product.specifications.master.model.impl.ProductSpecificationModelImpl;
import com.marketplace.product.specifications.master.service.persistence.ProductSpecificationPersistence;
import com.marketplace.product.specifications.master.service.persistence.ProductSpecificationUtil;
import com.marketplace.product.specifications.master.service.persistence.impl.constants.marketplace_productspecificationsPersistenceConstants;

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
 * The persistence implementation for the product specification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductSpecificationPersistence.class)
public class ProductSpecificationPersistenceImpl
	extends BasePersistenceImpl<ProductSpecification>
	implements ProductSpecificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductSpecificationUtil</code> to access the product specification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductSpecificationImpl.class.getName();

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
	 * Returns all the product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		List<ProductSpecification> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecification productSpecification : list) {
					if (!uuid.equals(productSpecification.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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
				sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSpecification>)QueryUtil.list(
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
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findByUuid_First(
			String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByUuid_First(
			uuid, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductSpecification> orderByComparator) {

		List<ProductSpecification> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findByUuid_Last(
			String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductSpecification> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductSpecification> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where uuid = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification[] findByUuid_PrevAndNext(
			long productSpecificationId, String uuid,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		uuid = Objects.toString(uuid, "");

		ProductSpecification productSpecification = findByPrimaryKey(
			productSpecificationId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecification[] array = new ProductSpecificationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productSpecification, uuid, orderByComparator, true);

			array[1] = productSpecification;

			array[2] = getByUuid_PrevAndNext(
				session, productSpecification, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductSpecification getByUuid_PrevAndNext(
		Session session, ProductSpecification productSpecification, String uuid,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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
			sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
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
						productSpecification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductSpecification productSpecification :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productSpecification);
		}
	}

	/**
	 * Returns the number of product specifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product specifications
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATION_WHERE);

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
		"productSpecification.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productSpecification.uuid IS NULL OR productSpecification.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByUUID_G(
			uuid, groupId);

		if (productSpecification == null) {
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

			throw new NoSuchProductSpecificationException(sb.toString());
		}

		return productSpecification;
	}

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product specification where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUUID_G(
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

		if (result instanceof ProductSpecification) {
			ProductSpecification productSpecification =
				(ProductSpecification)result;

			if (!Objects.equals(uuid, productSpecification.getUuid()) ||
				(groupId != productSpecification.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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

				List<ProductSpecification> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductSpecification productSpecification = list.get(0);

					result = productSpecification;

					cacheResult(productSpecification);
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
			return (ProductSpecification)result;
		}
	}

	/**
	 * Removes the product specification where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product specification that was removed
	 */
	@Override
	public ProductSpecification removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = findByUUID_G(uuid, groupId);

		return remove(productSpecification);
	}

	/**
	 * Returns the number of product specifications where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product specifications
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATION_WHERE);

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
		"productSpecification.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productSpecification.uuid IS NULL OR productSpecification.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productSpecification.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		List<ProductSpecification> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecification productSpecification : list) {
					if (!uuid.equals(productSpecification.getUuid()) ||
						(companyId != productSpecification.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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
				sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductSpecification>)QueryUtil.list(
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
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the first product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		List<ProductSpecification> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the last product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductSpecification> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification[] findByUuid_C_PrevAndNext(
			long productSpecificationId, String uuid, long companyId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		uuid = Objects.toString(uuid, "");

		ProductSpecification productSpecification = findByPrimaryKey(
			productSpecificationId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecification[] array = new ProductSpecificationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productSpecification, uuid, companyId,
				orderByComparator, true);

			array[1] = productSpecification;

			array[2] = getByUuid_C_PrevAndNext(
				session, productSpecification, uuid, companyId,
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

	protected ProductSpecification getByUuid_C_PrevAndNext(
		Session session, ProductSpecification productSpecification, String uuid,
		long companyId,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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
			sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
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
						productSpecification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductSpecification productSpecification :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSpecification);
		}
	}

	/**
	 * Returns the number of product specifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product specifications
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATION_WHERE);

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
		"productSpecification.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productSpecification.uuid IS NULL OR productSpecification.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productSpecification.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBydraftProductId;
	private FinderPath _finderPathWithoutPaginationFindBydraftProductId;
	private FinderPath _finderPathCountBydraftProductId;

	/**
	 * Returns all the product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product specifications
	 */
	@Override
	public List<ProductSpecification> findBydraftProductId(
		long draftProductId) {

		return findBydraftProductId(
			draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end) {

		return findBydraftProductId(draftProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return findBydraftProductId(
			draftProductId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product specifications where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product specifications
	 */
	@Override
	public List<ProductSpecification> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		List<ProductSpecification> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductSpecification productSpecification : list) {
					if (draftProductId !=
							productSpecification.getDraftProductId()) {

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

			sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				list = (List<ProductSpecification>)QueryUtil.list(
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
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchBydraftProductId_First(
			draftProductId, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the first product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		List<ProductSpecification> list = findBydraftProductId(
			draftProductId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification
	 * @throws NoSuchProductSpecificationException if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchBydraftProductId_Last(
			draftProductId, orderByComparator);

		if (productSpecification != null) {
			return productSpecification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductSpecificationException(sb.toString());
	}

	/**
	 * Returns the last product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public ProductSpecification fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductSpecification> orderByComparator) {

		int count = countBydraftProductId(draftProductId);

		if (count == 0) {
			return null;
		}

		List<ProductSpecification> list = findBydraftProductId(
			draftProductId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product specifications before and after the current product specification in the ordered set where draftProductId = &#63;.
	 *
	 * @param productSpecificationId the primary key of the current product specification
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification[] findBydraftProductId_PrevAndNext(
			long productSpecificationId, long draftProductId,
			OrderByComparator<ProductSpecification> orderByComparator)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = findByPrimaryKey(
			productSpecificationId);

		Session session = null;

		try {
			session = openSession();

			ProductSpecification[] array = new ProductSpecificationImpl[3];

			array[0] = getBydraftProductId_PrevAndNext(
				session, productSpecification, draftProductId,
				orderByComparator, true);

			array[1] = productSpecification;

			array[2] = getBydraftProductId_PrevAndNext(
				session, productSpecification, draftProductId,
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

	protected ProductSpecification getBydraftProductId_PrevAndNext(
		Session session, ProductSpecification productSpecification,
		long draftProductId,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTSPECIFICATION_WHERE);

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
			sb.append(ProductSpecificationModelImpl.ORDER_BY_JPQL);
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
						productSpecification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductSpecification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product specifications where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	@Override
	public void removeBydraftProductId(long draftProductId) {
		for (ProductSpecification productSpecification :
				findBydraftProductId(
					draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productSpecification);
		}
	}

	/**
	 * Returns the number of product specifications where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product specifications
	 */
	@Override
	public int countBydraftProductId(long draftProductId) {
		FinderPath finderPath = _finderPathCountBydraftProductId;

		Object[] finderArgs = new Object[] {draftProductId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTSPECIFICATION_WHERE);

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
		"productSpecification.draftProductId = ?";

	public ProductSpecificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductSpecification.class);

		setModelImplClass(ProductSpecificationImpl.class);
		setModelPKClass(long.class);

		setTable(ProductSpecificationTable.INSTANCE);
	}

	/**
	 * Caches the product specification in the entity cache if it is enabled.
	 *
	 * @param productSpecification the product specification
	 */
	@Override
	public void cacheResult(ProductSpecification productSpecification) {
		entityCache.putResult(
			ProductSpecificationImpl.class,
			productSpecification.getPrimaryKey(), productSpecification);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productSpecification.getUuid(),
				productSpecification.getGroupId()
			},
			productSpecification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product specifications in the entity cache if it is enabled.
	 *
	 * @param productSpecifications the product specifications
	 */
	@Override
	public void cacheResult(List<ProductSpecification> productSpecifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productSpecifications.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductSpecification productSpecification :
				productSpecifications) {

			if (entityCache.getResult(
					ProductSpecificationImpl.class,
					productSpecification.getPrimaryKey()) == null) {

				cacheResult(productSpecification);
			}
		}
	}

	/**
	 * Clears the cache for all product specifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductSpecificationImpl.class);

		finderCache.clearCache(ProductSpecificationImpl.class);
	}

	/**
	 * Clears the cache for the product specification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductSpecification productSpecification) {
		entityCache.removeResult(
			ProductSpecificationImpl.class, productSpecification);
	}

	@Override
	public void clearCache(List<ProductSpecification> productSpecifications) {
		for (ProductSpecification productSpecification :
				productSpecifications) {

			entityCache.removeResult(
				ProductSpecificationImpl.class, productSpecification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductSpecificationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductSpecificationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductSpecificationModelImpl productSpecificationModelImpl) {

		Object[] args = new Object[] {
			productSpecificationModelImpl.getUuid(),
			productSpecificationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productSpecificationModelImpl);
	}

	/**
	 * Creates a new product specification with the primary key. Does not add the product specification to the database.
	 *
	 * @param productSpecificationId the primary key for the new product specification
	 * @return the new product specification
	 */
	@Override
	public ProductSpecification create(long productSpecificationId) {
		ProductSpecification productSpecification =
			new ProductSpecificationImpl();

		productSpecification.setNew(true);
		productSpecification.setPrimaryKey(productSpecificationId);

		String uuid = _portalUUID.generate();

		productSpecification.setUuid(uuid);

		productSpecification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productSpecification;
	}

	/**
	 * Removes the product specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification that was removed
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification remove(long productSpecificationId)
		throws NoSuchProductSpecificationException {

		return remove((Serializable)productSpecificationId);
	}

	/**
	 * Removes the product specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product specification
	 * @return the product specification that was removed
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification remove(Serializable primaryKey)
		throws NoSuchProductSpecificationException {

		Session session = null;

		try {
			session = openSession();

			ProductSpecification productSpecification =
				(ProductSpecification)session.get(
					ProductSpecificationImpl.class, primaryKey);

			if (productSpecification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductSpecificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productSpecification);
		}
		catch (NoSuchProductSpecificationException noSuchEntityException) {
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
	protected ProductSpecification removeImpl(
		ProductSpecification productSpecification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productSpecification)) {
				productSpecification = (ProductSpecification)session.get(
					ProductSpecificationImpl.class,
					productSpecification.getPrimaryKeyObj());
			}

			if (productSpecification != null) {
				session.delete(productSpecification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productSpecification != null) {
			clearCache(productSpecification);
		}

		return productSpecification;
	}

	@Override
	public ProductSpecification updateImpl(
		ProductSpecification productSpecification) {

		boolean isNew = productSpecification.isNew();

		if (!(productSpecification instanceof ProductSpecificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productSpecification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productSpecification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productSpecification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductSpecification implementation " +
					productSpecification.getClass());
		}

		ProductSpecificationModelImpl productSpecificationModelImpl =
			(ProductSpecificationModelImpl)productSpecification;

		if (Validator.isNull(productSpecification.getUuid())) {
			String uuid = _portalUUID.generate();

			productSpecification.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productSpecification.getCreateDate() == null)) {
			if (serviceContext == null) {
				productSpecification.setCreateDate(date);
			}
			else {
				productSpecification.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productSpecificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productSpecification.setModifiedDate(date);
			}
			else {
				productSpecification.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productSpecification);
			}
			else {
				productSpecification = (ProductSpecification)session.merge(
					productSpecification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductSpecificationImpl.class, productSpecificationModelImpl,
			false, true);

		cacheUniqueFindersCache(productSpecificationModelImpl);

		if (isNew) {
			productSpecification.setNew(false);
		}

		productSpecification.resetOriginalValues();

		return productSpecification;
	}

	/**
	 * Returns the product specification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product specification
	 * @return the product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductSpecificationException {

		ProductSpecification productSpecification = fetchByPrimaryKey(
			primaryKey);

		if (productSpecification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductSpecificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productSpecification;
	}

	/**
	 * Returns the product specification with the primary key or throws a <code>NoSuchProductSpecificationException</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification
	 * @throws NoSuchProductSpecificationException if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification findByPrimaryKey(long productSpecificationId)
		throws NoSuchProductSpecificationException {

		return findByPrimaryKey((Serializable)productSpecificationId);
	}

	/**
	 * Returns the product specification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification, or <code>null</code> if a product specification with the primary key could not be found
	 */
	@Override
	public ProductSpecification fetchByPrimaryKey(long productSpecificationId) {
		return fetchByPrimaryKey((Serializable)productSpecificationId);
	}

	/**
	 * Returns all the product specifications.
	 *
	 * @return the product specifications
	 */
	@Override
	public List<ProductSpecification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of product specifications
	 */
	@Override
	public List<ProductSpecification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product specifications
	 */
	@Override
	public List<ProductSpecification> findAll(
		int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product specifications
	 */
	@Override
	public List<ProductSpecification> findAll(
		int start, int end,
		OrderByComparator<ProductSpecification> orderByComparator,
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

		List<ProductSpecification> list = null;

		if (useFinderCache) {
			list = (List<ProductSpecification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTSPECIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTSPECIFICATION;

				sql = sql.concat(ProductSpecificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductSpecification>)QueryUtil.list(
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
	 * Removes all the product specifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductSpecification productSpecification : findAll()) {
			remove(productSpecification);
		}
	}

	/**
	 * Returns the number of product specifications.
	 *
	 * @return the number of product specifications
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
					_SQL_COUNT_PRODUCTSPECIFICATION);

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
		return "productSpecificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTSPECIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductSpecificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product specification persistence.
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

		_setProductSpecificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductSpecificationUtilPersistence(null);

		entityCache.removeCache(ProductSpecificationImpl.class.getName());
	}

	private void _setProductSpecificationUtilPersistence(
		ProductSpecificationPersistence productSpecificationPersistence) {

		try {
			Field field = ProductSpecificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productSpecificationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_productspecificationsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_productspecificationsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_productspecificationsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTSPECIFICATION =
		"SELECT productSpecification FROM ProductSpecification productSpecification";

	private static final String _SQL_SELECT_PRODUCTSPECIFICATION_WHERE =
		"SELECT productSpecification FROM ProductSpecification productSpecification WHERE ";

	private static final String _SQL_COUNT_PRODUCTSPECIFICATION =
		"SELECT COUNT(productSpecification) FROM ProductSpecification productSpecification";

	private static final String _SQL_COUNT_PRODUCTSPECIFICATION_WHERE =
		"SELECT COUNT(productSpecification) FROM ProductSpecification productSpecification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productSpecification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductSpecification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductSpecification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSpecificationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}