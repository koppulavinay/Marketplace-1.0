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

package com.marketplace.product.pkg.content.service.persistence.impl;

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

import com.marketplace.product.pkg.content.exception.NoSuchProductPackageContentException;
import com.marketplace.product.pkg.content.model.ProductPackageContent;
import com.marketplace.product.pkg.content.model.ProductPackageContentTable;
import com.marketplace.product.pkg.content.model.impl.ProductPackageContentImpl;
import com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl;
import com.marketplace.product.pkg.content.service.persistence.ProductPackageContentPersistence;
import com.marketplace.product.pkg.content.service.persistence.ProductPackageContentUtil;
import com.marketplace.product.pkg.content.service.persistence.impl.constants.marketplace_product_package_contentPersistenceConstants;

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
 * The persistence implementation for the product package content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductPackageContentPersistence.class)
public class ProductPackageContentPersistenceImpl
	extends BasePersistenceImpl<ProductPackageContent>
	implements ProductPackageContentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductPackageContentUtil</code> to access the product package content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductPackageContentImpl.class.getName();

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
	 * Returns all the product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		List<ProductPackageContent> list = null;

		if (useFinderCache) {
			list = (List<ProductPackageContent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductPackageContent productPackageContent : list) {
					if (!uuid.equals(productPackageContent.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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
				sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductPackageContent>)QueryUtil.list(
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
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findByUuid_First(
			String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByUuid_First(
			uuid, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUuid_First(
		String uuid,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		List<ProductPackageContent> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findByUuid_Last(
			String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductPackageContent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where uuid = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent[] findByUuid_PrevAndNext(
			long packageContentId, String uuid,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		uuid = Objects.toString(uuid, "");

		ProductPackageContent productPackageContent = findByPrimaryKey(
			packageContentId);

		Session session = null;

		try {
			session = openSession();

			ProductPackageContent[] array = new ProductPackageContentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productPackageContent, uuid, orderByComparator, true);

			array[1] = productPackageContent;

			array[2] = getByUuid_PrevAndNext(
				session, productPackageContent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductPackageContent getByUuid_PrevAndNext(
		Session session, ProductPackageContent productPackageContent,
		String uuid, OrderByComparator<ProductPackageContent> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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
			sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
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
						productPackageContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductPackageContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product package contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductPackageContent productPackageContent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productPackageContent);
		}
	}

	/**
	 * Returns the number of product package contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product package contents
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTPACKAGECONTENT_WHERE);

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
		"productPackageContent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productPackageContent.uuid IS NULL OR productPackageContent.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findByUUID_G(String uuid, long groupId)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByUUID_G(
			uuid, groupId);

		if (productPackageContent == null) {
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

			throw new NoSuchProductPackageContentException(sb.toString());
		}

		return productPackageContent;
	}

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the product package content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUUID_G(
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

		if (result instanceof ProductPackageContent) {
			ProductPackageContent productPackageContent =
				(ProductPackageContent)result;

			if (!Objects.equals(uuid, productPackageContent.getUuid()) ||
				(groupId != productPackageContent.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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

				List<ProductPackageContent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProductPackageContent productPackageContent = list.get(0);

					result = productPackageContent;

					cacheResult(productPackageContent);
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
			return (ProductPackageContent)result;
		}
	}

	/**
	 * Removes the product package content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the product package content that was removed
	 */
	@Override
	public ProductPackageContent removeByUUID_G(String uuid, long groupId)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = findByUUID_G(
			uuid, groupId);

		return remove(productPackageContent);
	}

	/**
	 * Returns the number of product package contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching product package contents
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTPACKAGECONTENT_WHERE);

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
		"productPackageContent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(productPackageContent.uuid IS NULL OR productPackageContent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"productPackageContent.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		List<ProductPackageContent> list = null;

		if (useFinderCache) {
			list = (List<ProductPackageContent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductPackageContent productPackageContent : list) {
					if (!uuid.equals(productPackageContent.getUuid()) ||
						(companyId != productPackageContent.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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
				sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductPackageContent>)QueryUtil.list(
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
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the first product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		List<ProductPackageContent> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the last product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProductPackageContent> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent[] findByUuid_C_PrevAndNext(
			long packageContentId, String uuid, long companyId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		uuid = Objects.toString(uuid, "");

		ProductPackageContent productPackageContent = findByPrimaryKey(
			packageContentId);

		Session session = null;

		try {
			session = openSession();

			ProductPackageContent[] array = new ProductPackageContentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, productPackageContent, uuid, companyId,
				orderByComparator, true);

			array[1] = productPackageContent;

			array[2] = getByUuid_C_PrevAndNext(
				session, productPackageContent, uuid, companyId,
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

	protected ProductPackageContent getByUuid_C_PrevAndNext(
		Session session, ProductPackageContent productPackageContent,
		String uuid, long companyId,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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
			sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
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
						productPackageContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductPackageContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product package contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProductPackageContent productPackageContent :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productPackageContent);
		}
	}

	/**
	 * Returns the number of product package contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching product package contents
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTPACKAGECONTENT_WHERE);

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
		"productPackageContent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(productPackageContent.uuid IS NULL OR productPackageContent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"productPackageContent.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBydraftProductId;
	private FinderPath _finderPathWithoutPaginationFindBydraftProductId;
	private FinderPath _finderPathCountBydraftProductId;

	/**
	 * Returns all the product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findBydraftProductId(
		long draftProductId) {

		return findBydraftProductId(
			draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end) {

		return findBydraftProductId(draftProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return findBydraftProductId(
			draftProductId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product package contents where draftProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param draftProductId the draft product ID
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product package contents
	 */
	@Override
	public List<ProductPackageContent> findBydraftProductId(
		long draftProductId, int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		List<ProductPackageContent> list = null;

		if (useFinderCache) {
			list = (List<ProductPackageContent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductPackageContent productPackageContent : list) {
					if (draftProductId !=
							productPackageContent.getDraftProductId()) {

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

			sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

			sb.append(_FINDER_COLUMN_DRAFTPRODUCTID_DRAFTPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(draftProductId);

				list = (List<ProductPackageContent>)QueryUtil.list(
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
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findBydraftProductId_First(
			long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent =
			fetchBydraftProductId_First(draftProductId, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the first product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchBydraftProductId_First(
		long draftProductId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		List<ProductPackageContent> list = findBydraftProductId(
			draftProductId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content
	 * @throws NoSuchProductPackageContentException if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent findBydraftProductId_Last(
			long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent =
			fetchBydraftProductId_Last(draftProductId, orderByComparator);

		if (productPackageContent != null) {
			return productPackageContent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("draftProductId=");
		sb.append(draftProductId);

		sb.append("}");

		throw new NoSuchProductPackageContentException(sb.toString());
	}

	/**
	 * Returns the last product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public ProductPackageContent fetchBydraftProductId_Last(
		long draftProductId,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		int count = countBydraftProductId(draftProductId);

		if (count == 0) {
			return null;
		}

		List<ProductPackageContent> list = findBydraftProductId(
			draftProductId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product package contents before and after the current product package content in the ordered set where draftProductId = &#63;.
	 *
	 * @param packageContentId the primary key of the current product package content
	 * @param draftProductId the draft product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent[] findBydraftProductId_PrevAndNext(
			long packageContentId, long draftProductId,
			OrderByComparator<ProductPackageContent> orderByComparator)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = findByPrimaryKey(
			packageContentId);

		Session session = null;

		try {
			session = openSession();

			ProductPackageContent[] array = new ProductPackageContentImpl[3];

			array[0] = getBydraftProductId_PrevAndNext(
				session, productPackageContent, draftProductId,
				orderByComparator, true);

			array[1] = productPackageContent;

			array[2] = getBydraftProductId_PrevAndNext(
				session, productPackageContent, draftProductId,
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

	protected ProductPackageContent getBydraftProductId_PrevAndNext(
		Session session, ProductPackageContent productPackageContent,
		long draftProductId,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE);

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
			sb.append(ProductPackageContentModelImpl.ORDER_BY_JPQL);
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
						productPackageContent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductPackageContent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product package contents where draftProductId = &#63; from the database.
	 *
	 * @param draftProductId the draft product ID
	 */
	@Override
	public void removeBydraftProductId(long draftProductId) {
		for (ProductPackageContent productPackageContent :
				findBydraftProductId(
					draftProductId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productPackageContent);
		}
	}

	/**
	 * Returns the number of product package contents where draftProductId = &#63;.
	 *
	 * @param draftProductId the draft product ID
	 * @return the number of matching product package contents
	 */
	@Override
	public int countBydraftProductId(long draftProductId) {
		FinderPath finderPath = _finderPathCountBydraftProductId;

		Object[] finderArgs = new Object[] {draftProductId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTPACKAGECONTENT_WHERE);

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
		"productPackageContent.draftProductId = ?";

	public ProductPackageContentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductPackageContent.class);

		setModelImplClass(ProductPackageContentImpl.class);
		setModelPKClass(long.class);

		setTable(ProductPackageContentTable.INSTANCE);
	}

	/**
	 * Caches the product package content in the entity cache if it is enabled.
	 *
	 * @param productPackageContent the product package content
	 */
	@Override
	public void cacheResult(ProductPackageContent productPackageContent) {
		entityCache.putResult(
			ProductPackageContentImpl.class,
			productPackageContent.getPrimaryKey(), productPackageContent);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				productPackageContent.getUuid(),
				productPackageContent.getGroupId()
			},
			productPackageContent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product package contents in the entity cache if it is enabled.
	 *
	 * @param productPackageContents the product package contents
	 */
	@Override
	public void cacheResult(
		List<ProductPackageContent> productPackageContents) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productPackageContents.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductPackageContent productPackageContent :
				productPackageContents) {

			if (entityCache.getResult(
					ProductPackageContentImpl.class,
					productPackageContent.getPrimaryKey()) == null) {

				cacheResult(productPackageContent);
			}
		}
	}

	/**
	 * Clears the cache for all product package contents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductPackageContentImpl.class);

		finderCache.clearCache(ProductPackageContentImpl.class);
	}

	/**
	 * Clears the cache for the product package content.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductPackageContent productPackageContent) {
		entityCache.removeResult(
			ProductPackageContentImpl.class, productPackageContent);
	}

	@Override
	public void clearCache(List<ProductPackageContent> productPackageContents) {
		for (ProductPackageContent productPackageContent :
				productPackageContents) {

			entityCache.removeResult(
				ProductPackageContentImpl.class, productPackageContent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductPackageContentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductPackageContentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductPackageContentModelImpl productPackageContentModelImpl) {

		Object[] args = new Object[] {
			productPackageContentModelImpl.getUuid(),
			productPackageContentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, productPackageContentModelImpl);
	}

	/**
	 * Creates a new product package content with the primary key. Does not add the product package content to the database.
	 *
	 * @param packageContentId the primary key for the new product package content
	 * @return the new product package content
	 */
	@Override
	public ProductPackageContent create(long packageContentId) {
		ProductPackageContent productPackageContent =
			new ProductPackageContentImpl();

		productPackageContent.setNew(true);
		productPackageContent.setPrimaryKey(packageContentId);

		String uuid = _portalUUID.generate();

		productPackageContent.setUuid(uuid);

		productPackageContent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return productPackageContent;
	}

	/**
	 * Removes the product package content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content that was removed
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent remove(long packageContentId)
		throws NoSuchProductPackageContentException {

		return remove((Serializable)packageContentId);
	}

	/**
	 * Removes the product package content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product package content
	 * @return the product package content that was removed
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent remove(Serializable primaryKey)
		throws NoSuchProductPackageContentException {

		Session session = null;

		try {
			session = openSession();

			ProductPackageContent productPackageContent =
				(ProductPackageContent)session.get(
					ProductPackageContentImpl.class, primaryKey);

			if (productPackageContent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductPackageContentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productPackageContent);
		}
		catch (NoSuchProductPackageContentException noSuchEntityException) {
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
	protected ProductPackageContent removeImpl(
		ProductPackageContent productPackageContent) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productPackageContent)) {
				productPackageContent = (ProductPackageContent)session.get(
					ProductPackageContentImpl.class,
					productPackageContent.getPrimaryKeyObj());
			}

			if (productPackageContent != null) {
				session.delete(productPackageContent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productPackageContent != null) {
			clearCache(productPackageContent);
		}

		return productPackageContent;
	}

	@Override
	public ProductPackageContent updateImpl(
		ProductPackageContent productPackageContent) {

		boolean isNew = productPackageContent.isNew();

		if (!(productPackageContent instanceof
				ProductPackageContentModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productPackageContent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productPackageContent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productPackageContent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductPackageContent implementation " +
					productPackageContent.getClass());
		}

		ProductPackageContentModelImpl productPackageContentModelImpl =
			(ProductPackageContentModelImpl)productPackageContent;

		if (Validator.isNull(productPackageContent.getUuid())) {
			String uuid = _portalUUID.generate();

			productPackageContent.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productPackageContent.getCreateDate() == null)) {
			if (serviceContext == null) {
				productPackageContent.setCreateDate(date);
			}
			else {
				productPackageContent.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productPackageContentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productPackageContent.setModifiedDate(date);
			}
			else {
				productPackageContent.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productPackageContent);
			}
			else {
				productPackageContent = (ProductPackageContent)session.merge(
					productPackageContent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductPackageContentImpl.class, productPackageContentModelImpl,
			false, true);

		cacheUniqueFindersCache(productPackageContentModelImpl);

		if (isNew) {
			productPackageContent.setNew(false);
		}

		productPackageContent.resetOriginalValues();

		return productPackageContent;
	}

	/**
	 * Returns the product package content with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product package content
	 * @return the product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductPackageContentException {

		ProductPackageContent productPackageContent = fetchByPrimaryKey(
			primaryKey);

		if (productPackageContent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductPackageContentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productPackageContent;
	}

	/**
	 * Returns the product package content with the primary key or throws a <code>NoSuchProductPackageContentException</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content
	 * @throws NoSuchProductPackageContentException if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent findByPrimaryKey(long packageContentId)
		throws NoSuchProductPackageContentException {

		return findByPrimaryKey((Serializable)packageContentId);
	}

	/**
	 * Returns the product package content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content, or <code>null</code> if a product package content with the primary key could not be found
	 */
	@Override
	public ProductPackageContent fetchByPrimaryKey(long packageContentId) {
		return fetchByPrimaryKey((Serializable)packageContentId);
	}

	/**
	 * Returns all the product package contents.
	 *
	 * @return the product package contents
	 */
	@Override
	public List<ProductPackageContent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of product package contents
	 */
	@Override
	public List<ProductPackageContent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product package contents
	 */
	@Override
	public List<ProductPackageContent> findAll(
		int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product package contents
	 */
	@Override
	public List<ProductPackageContent> findAll(
		int start, int end,
		OrderByComparator<ProductPackageContent> orderByComparator,
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

		List<ProductPackageContent> list = null;

		if (useFinderCache) {
			list = (List<ProductPackageContent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTPACKAGECONTENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTPACKAGECONTENT;

				sql = sql.concat(ProductPackageContentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductPackageContent>)QueryUtil.list(
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
	 * Removes all the product package contents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductPackageContent productPackageContent : findAll()) {
			remove(productPackageContent);
		}
	}

	/**
	 * Returns the number of product package contents.
	 *
	 * @return the number of product package contents
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
					_SQL_COUNT_PRODUCTPACKAGECONTENT);

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
		return "packageContentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTPACKAGECONTENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductPackageContentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product package content persistence.
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

		_setProductPackageContentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductPackageContentUtilPersistence(null);

		entityCache.removeCache(ProductPackageContentImpl.class.getName());
	}

	private void _setProductPackageContentUtilPersistence(
		ProductPackageContentPersistence productPackageContentPersistence) {

		try {
			Field field = ProductPackageContentUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productPackageContentPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_product_package_contentPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_product_package_contentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_product_package_contentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTPACKAGECONTENT =
		"SELECT productPackageContent FROM ProductPackageContent productPackageContent";

	private static final String _SQL_SELECT_PRODUCTPACKAGECONTENT_WHERE =
		"SELECT productPackageContent FROM ProductPackageContent productPackageContent WHERE ";

	private static final String _SQL_COUNT_PRODUCTPACKAGECONTENT =
		"SELECT COUNT(productPackageContent) FROM ProductPackageContent productPackageContent";

	private static final String _SQL_COUNT_PRODUCTPACKAGECONTENT_WHERE =
		"SELECT COUNT(productPackageContent) FROM ProductPackageContent productPackageContent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productPackageContent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductPackageContent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductPackageContent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductPackageContentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}