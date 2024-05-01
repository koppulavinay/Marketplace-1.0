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

package com.marketplace.checkout.consignee.service.persistence.impl;

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

import com.marketplace.checkout.consignee.exception.NoSuchCheckoutConsigneeDetailsException;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetailsTable;
import com.marketplace.checkout.consignee.model.impl.CheckoutConsigneeDetailsImpl;
import com.marketplace.checkout.consignee.model.impl.CheckoutConsigneeDetailsModelImpl;
import com.marketplace.checkout.consignee.service.persistence.CheckoutConsigneeDetailsPersistence;
import com.marketplace.checkout.consignee.service.persistence.CheckoutConsigneeDetailsUtil;
import com.marketplace.checkout.consignee.service.persistence.impl.constants.marketplace_consigneedetailsPersistenceConstants;

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
 * The persistence implementation for the checkout consignee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CheckoutConsigneeDetailsPersistence.class)
public class CheckoutConsigneeDetailsPersistenceImpl
	extends BasePersistenceImpl<CheckoutConsigneeDetails>
	implements CheckoutConsigneeDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CheckoutConsigneeDetailsUtil</code> to access the checkout consignee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CheckoutConsigneeDetailsImpl.class.getName();

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
	 * Returns all the checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		List<CheckoutConsigneeDetails> list = null;

		if (useFinderCache) {
			list = (List<CheckoutConsigneeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckoutConsigneeDetails checkoutConsigneeDetails : list) {
					if (!uuid.equals(checkoutConsigneeDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
				sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<CheckoutConsigneeDetails>)QueryUtil.list(
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
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByUuid_First(
			String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		List<CheckoutConsigneeDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByUuid_Last(
			String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CheckoutConsigneeDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where uuid = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails[] findByUuid_PrevAndNext(
			long checkoutConsigneeId, String uuid,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		uuid = Objects.toString(uuid, "");

		CheckoutConsigneeDetails checkoutConsigneeDetails = findByPrimaryKey(
			checkoutConsigneeId);

		Session session = null;

		try {
			session = openSession();

			CheckoutConsigneeDetails[] array =
				new CheckoutConsigneeDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, checkoutConsigneeDetails, uuid, orderByComparator,
				true);

			array[1] = checkoutConsigneeDetails;

			array[2] = getByUuid_PrevAndNext(
				session, checkoutConsigneeDetails, uuid, orderByComparator,
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

	protected CheckoutConsigneeDetails getByUuid_PrevAndNext(
		Session session, CheckoutConsigneeDetails checkoutConsigneeDetails,
		String uuid,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
			sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
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
						checkoutConsigneeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckoutConsigneeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checkoutConsigneeDetails);
		}
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checkout consignee detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
		"checkoutConsigneeDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(checkoutConsigneeDetails.uuid IS NULL OR checkoutConsigneeDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByUUID_G(
			uuid, groupId);

		if (checkoutConsigneeDetails == null) {
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

			throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
		}

		return checkoutConsigneeDetails;
	}

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the checkout consignee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUUID_G(
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

		if (result instanceof CheckoutConsigneeDetails) {
			CheckoutConsigneeDetails checkoutConsigneeDetails =
				(CheckoutConsigneeDetails)result;

			if (!Objects.equals(uuid, checkoutConsigneeDetails.getUuid()) ||
				(groupId != checkoutConsigneeDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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

				List<CheckoutConsigneeDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CheckoutConsigneeDetails checkoutConsigneeDetails =
						list.get(0);

					result = checkoutConsigneeDetails;

					cacheResult(checkoutConsigneeDetails);
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
			return (CheckoutConsigneeDetails)result;
		}
	}

	/**
	 * Removes the checkout consignee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checkout consignee details that was removed
	 */
	@Override
	public CheckoutConsigneeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = findByUUID_G(
			uuid, groupId);

		return remove(checkoutConsigneeDetails);
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checkout consignee detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
		"checkoutConsigneeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(checkoutConsigneeDetails.uuid IS NULL OR checkoutConsigneeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"checkoutConsigneeDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		List<CheckoutConsigneeDetails> list = null;

		if (useFinderCache) {
			list = (List<CheckoutConsigneeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckoutConsigneeDetails checkoutConsigneeDetails : list) {
					if (!uuid.equals(checkoutConsigneeDetails.getUuid()) ||
						(companyId !=
							checkoutConsigneeDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
				sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<CheckoutConsigneeDetails>)QueryUtil.list(
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
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		List<CheckoutConsigneeDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CheckoutConsigneeDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails[] findByUuid_C_PrevAndNext(
			long checkoutConsigneeId, String uuid, long companyId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		uuid = Objects.toString(uuid, "");

		CheckoutConsigneeDetails checkoutConsigneeDetails = findByPrimaryKey(
			checkoutConsigneeId);

		Session session = null;

		try {
			session = openSession();

			CheckoutConsigneeDetails[] array =
				new CheckoutConsigneeDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, checkoutConsigneeDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = checkoutConsigneeDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, checkoutConsigneeDetails, uuid, companyId,
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

	protected CheckoutConsigneeDetails getByUuid_C_PrevAndNext(
		Session session, CheckoutConsigneeDetails checkoutConsigneeDetails,
		String uuid, long companyId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
			sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
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
						checkoutConsigneeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckoutConsigneeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checkout consignee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(checkoutConsigneeDetails);
		}
	}

	/**
	 * Returns the number of checkout consignee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checkout consignee detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE);

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
		"checkoutConsigneeDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(checkoutConsigneeDetails.uuid IS NULL OR checkoutConsigneeDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"checkoutConsigneeDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCartIdNOrderItemId;
	private FinderPath _finderPathWithoutPaginationFindByCartIdNOrderItemId;
	private FinderPath _finderPathCountByCartIdNOrderItemId;

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId) {

		return findByCartIdNOrderItemId(
			parentCartId, orderItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end) {

		return findByCartIdNOrderItemId(
			parentCartId, orderItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return findByCartIdNOrderItemId(
			parentCartId, orderItemId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByCartIdNOrderItemId(
		long parentCartId, long orderItemId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCartIdNOrderItemId;
				finderArgs = new Object[] {parentCartId, orderItemId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCartIdNOrderItemId;
			finderArgs = new Object[] {
				parentCartId, orderItemId, start, end, orderByComparator
			};
		}

		List<CheckoutConsigneeDetails> list = null;

		if (useFinderCache) {
			list = (List<CheckoutConsigneeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckoutConsigneeDetails checkoutConsigneeDetails : list) {
					if ((parentCartId !=
							checkoutConsigneeDetails.getParentCartId()) ||
						(orderItemId !=
							checkoutConsigneeDetails.getOrderItemId())) {

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

			sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_PARENTCARTID_2);

			sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_ORDERITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCartId);

				queryPos.add(orderItemId);

				list = (List<CheckoutConsigneeDetails>)QueryUtil.list(
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
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByCartIdNOrderItemId_First(
			long parentCartId, long orderItemId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails =
			fetchByCartIdNOrderItemId_First(
				parentCartId, orderItemId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCartId=");
		sb.append(parentCartId);

		sb.append(", orderItemId=");
		sb.append(orderItemId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByCartIdNOrderItemId_First(
		long parentCartId, long orderItemId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		List<CheckoutConsigneeDetails> list = findByCartIdNOrderItemId(
			parentCartId, orderItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByCartIdNOrderItemId_Last(
			long parentCartId, long orderItemId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails =
			fetchByCartIdNOrderItemId_Last(
				parentCartId, orderItemId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCartId=");
		sb.append(parentCartId);

		sb.append(", orderItemId=");
		sb.append(orderItemId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByCartIdNOrderItemId_Last(
		long parentCartId, long orderItemId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		int count = countByCartIdNOrderItemId(parentCartId, orderItemId);

		if (count == 0) {
			return null;
		}

		List<CheckoutConsigneeDetails> list = findByCartIdNOrderItemId(
			parentCartId, orderItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails[] findByCartIdNOrderItemId_PrevAndNext(
			long checkoutConsigneeId, long parentCartId, long orderItemId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = findByPrimaryKey(
			checkoutConsigneeId);

		Session session = null;

		try {
			session = openSession();

			CheckoutConsigneeDetails[] array =
				new CheckoutConsigneeDetailsImpl[3];

			array[0] = getByCartIdNOrderItemId_PrevAndNext(
				session, checkoutConsigneeDetails, parentCartId, orderItemId,
				orderByComparator, true);

			array[1] = checkoutConsigneeDetails;

			array[2] = getByCartIdNOrderItemId_PrevAndNext(
				session, checkoutConsigneeDetails, parentCartId, orderItemId,
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

	protected CheckoutConsigneeDetails getByCartIdNOrderItemId_PrevAndNext(
		Session session, CheckoutConsigneeDetails checkoutConsigneeDetails,
		long parentCartId, long orderItemId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_PARENTCARTID_2);

		sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_ORDERITEMID_2);

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
			sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentCartId);

		queryPos.add(orderItemId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						checkoutConsigneeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckoutConsigneeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 */
	@Override
	public void removeByCartIdNOrderItemId(
		long parentCartId, long orderItemId) {

		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				findByCartIdNOrderItemId(
					parentCartId, orderItemId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(checkoutConsigneeDetails);
		}
	}

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63; and orderItemId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderItemId the order item ID
	 * @return the number of matching checkout consignee detailses
	 */
	@Override
	public int countByCartIdNOrderItemId(long parentCartId, long orderItemId) {
		FinderPath finderPath = _finderPathCountByCartIdNOrderItemId;

		Object[] finderArgs = new Object[] {parentCartId, orderItemId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_PARENTCARTID_2);

			sb.append(_FINDER_COLUMN_CARTIDNORDERITEMID_ORDERITEMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCartId);

				queryPos.add(orderItemId);

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
		_FINDER_COLUMN_CARTIDNORDERITEMID_PARENTCARTID_2 =
			"checkoutConsigneeDetails.parentCartId = ? AND ";

	private static final String
		_FINDER_COLUMN_CARTIDNORDERITEMID_ORDERITEMID_2 =
			"checkoutConsigneeDetails.orderItemId = ?";

	private FinderPath _finderPathWithPaginationFindByParentCartId;
	private FinderPath _finderPathWithoutPaginationFindByParentCartId;
	private FinderPath _finderPathCountByParentCartId;

	/**
	 * Returns all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId) {

		return findByParentCartId(
			parentCartId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end) {

		return findByParentCartId(parentCartId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return findByParentCartId(
			parentCartId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses where parentCartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param parentCartId the parent cart ID
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findByParentCartId(
		long parentCartId, int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentCartId;
				finderArgs = new Object[] {parentCartId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentCartId;
			finderArgs = new Object[] {
				parentCartId, start, end, orderByComparator
			};
		}

		List<CheckoutConsigneeDetails> list = null;

		if (useFinderCache) {
			list = (List<CheckoutConsigneeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CheckoutConsigneeDetails checkoutConsigneeDetails : list) {
					if (parentCartId !=
							checkoutConsigneeDetails.getParentCartId()) {

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

			sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCARTID_PARENTCARTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCartId);

				list = (List<CheckoutConsigneeDetails>)QueryUtil.list(
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
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByParentCartId_First(
			long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails =
			fetchByParentCartId_First(parentCartId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCartId=");
		sb.append(parentCartId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the first checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByParentCartId_First(
		long parentCartId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		List<CheckoutConsigneeDetails> list = findByParentCartId(
			parentCartId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByParentCartId_Last(
			long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails =
			fetchByParentCartId_Last(parentCartId, orderByComparator);

		if (checkoutConsigneeDetails != null) {
			return checkoutConsigneeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentCartId=");
		sb.append(parentCartId);

		sb.append("}");

		throw new NoSuchCheckoutConsigneeDetailsException(sb.toString());
	}

	/**
	 * Returns the last checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checkout consignee details, or <code>null</code> if a matching checkout consignee details could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByParentCartId_Last(
		long parentCartId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		int count = countByParentCartId(parentCartId);

		if (count == 0) {
			return null;
		}

		List<CheckoutConsigneeDetails> list = findByParentCartId(
			parentCartId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checkout consignee detailses before and after the current checkout consignee details in the ordered set where parentCartId = &#63;.
	 *
	 * @param checkoutConsigneeId the primary key of the current checkout consignee details
	 * @param parentCartId the parent cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails[] findByParentCartId_PrevAndNext(
			long checkoutConsigneeId, long parentCartId,
			OrderByComparator<CheckoutConsigneeDetails> orderByComparator)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = findByPrimaryKey(
			checkoutConsigneeId);

		Session session = null;

		try {
			session = openSession();

			CheckoutConsigneeDetails[] array =
				new CheckoutConsigneeDetailsImpl[3];

			array[0] = getByParentCartId_PrevAndNext(
				session, checkoutConsigneeDetails, parentCartId,
				orderByComparator, true);

			array[1] = checkoutConsigneeDetails;

			array[2] = getByParentCartId_PrevAndNext(
				session, checkoutConsigneeDetails, parentCartId,
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

	protected CheckoutConsigneeDetails getByParentCartId_PrevAndNext(
		Session session, CheckoutConsigneeDetails checkoutConsigneeDetails,
		long parentCartId,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_PARENTCARTID_PARENTCARTID_2);

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
			sb.append(CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentCartId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						checkoutConsigneeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CheckoutConsigneeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checkout consignee detailses where parentCartId = &#63; from the database.
	 *
	 * @param parentCartId the parent cart ID
	 */
	@Override
	public void removeByParentCartId(long parentCartId) {
		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				findByParentCartId(
					parentCartId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checkoutConsigneeDetails);
		}
	}

	/**
	 * Returns the number of checkout consignee detailses where parentCartId = &#63;.
	 *
	 * @param parentCartId the parent cart ID
	 * @return the number of matching checkout consignee detailses
	 */
	@Override
	public int countByParentCartId(long parentCartId) {
		FinderPath finderPath = _finderPathCountByParentCartId;

		Object[] finderArgs = new Object[] {parentCartId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCARTID_PARENTCARTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentCartId);

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

	private static final String _FINDER_COLUMN_PARENTCARTID_PARENTCARTID_2 =
		"checkoutConsigneeDetails.parentCartId = ?";

	public CheckoutConsigneeDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CheckoutConsigneeDetails.class);

		setModelImplClass(CheckoutConsigneeDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(CheckoutConsigneeDetailsTable.INSTANCE);
	}

	/**
	 * Caches the checkout consignee details in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetails the checkout consignee details
	 */
	@Override
	public void cacheResult(CheckoutConsigneeDetails checkoutConsigneeDetails) {
		entityCache.putResult(
			CheckoutConsigneeDetailsImpl.class,
			checkoutConsigneeDetails.getPrimaryKey(), checkoutConsigneeDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				checkoutConsigneeDetails.getUuid(),
				checkoutConsigneeDetails.getGroupId()
			},
			checkoutConsigneeDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the checkout consignee detailses in the entity cache if it is enabled.
	 *
	 * @param checkoutConsigneeDetailses the checkout consignee detailses
	 */
	@Override
	public void cacheResult(
		List<CheckoutConsigneeDetails> checkoutConsigneeDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (checkoutConsigneeDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				checkoutConsigneeDetailses) {

			if (entityCache.getResult(
					CheckoutConsigneeDetailsImpl.class,
					checkoutConsigneeDetails.getPrimaryKey()) == null) {

				cacheResult(checkoutConsigneeDetails);
			}
		}
	}

	/**
	 * Clears the cache for all checkout consignee detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CheckoutConsigneeDetailsImpl.class);

		finderCache.clearCache(CheckoutConsigneeDetailsImpl.class);
	}

	/**
	 * Clears the cache for the checkout consignee details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CheckoutConsigneeDetails checkoutConsigneeDetails) {
		entityCache.removeResult(
			CheckoutConsigneeDetailsImpl.class, checkoutConsigneeDetails);
	}

	@Override
	public void clearCache(
		List<CheckoutConsigneeDetails> checkoutConsigneeDetailses) {

		for (CheckoutConsigneeDetails checkoutConsigneeDetails :
				checkoutConsigneeDetailses) {

			entityCache.removeResult(
				CheckoutConsigneeDetailsImpl.class, checkoutConsigneeDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CheckoutConsigneeDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CheckoutConsigneeDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CheckoutConsigneeDetailsModelImpl checkoutConsigneeDetailsModelImpl) {

		Object[] args = new Object[] {
			checkoutConsigneeDetailsModelImpl.getUuid(),
			checkoutConsigneeDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, checkoutConsigneeDetailsModelImpl);
	}

	/**
	 * Creates a new checkout consignee details with the primary key. Does not add the checkout consignee details to the database.
	 *
	 * @param checkoutConsigneeId the primary key for the new checkout consignee details
	 * @return the new checkout consignee details
	 */
	@Override
	public CheckoutConsigneeDetails create(long checkoutConsigneeId) {
		CheckoutConsigneeDetails checkoutConsigneeDetails =
			new CheckoutConsigneeDetailsImpl();

		checkoutConsigneeDetails.setNew(true);
		checkoutConsigneeDetails.setPrimaryKey(checkoutConsigneeId);

		String uuid = _portalUUID.generate();

		checkoutConsigneeDetails.setUuid(uuid);

		checkoutConsigneeDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return checkoutConsigneeDetails;
	}

	/**
	 * Removes the checkout consignee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details that was removed
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails remove(long checkoutConsigneeId)
		throws NoSuchCheckoutConsigneeDetailsException {

		return remove((Serializable)checkoutConsigneeId);
	}

	/**
	 * Removes the checkout consignee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the checkout consignee details
	 * @return the checkout consignee details that was removed
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails remove(Serializable primaryKey)
		throws NoSuchCheckoutConsigneeDetailsException {

		Session session = null;

		try {
			session = openSession();

			CheckoutConsigneeDetails checkoutConsigneeDetails =
				(CheckoutConsigneeDetails)session.get(
					CheckoutConsigneeDetailsImpl.class, primaryKey);

			if (checkoutConsigneeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCheckoutConsigneeDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(checkoutConsigneeDetails);
		}
		catch (NoSuchCheckoutConsigneeDetailsException noSuchEntityException) {
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
	protected CheckoutConsigneeDetails removeImpl(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(checkoutConsigneeDetails)) {
				checkoutConsigneeDetails =
					(CheckoutConsigneeDetails)session.get(
						CheckoutConsigneeDetailsImpl.class,
						checkoutConsigneeDetails.getPrimaryKeyObj());
			}

			if (checkoutConsigneeDetails != null) {
				session.delete(checkoutConsigneeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (checkoutConsigneeDetails != null) {
			clearCache(checkoutConsigneeDetails);
		}

		return checkoutConsigneeDetails;
	}

	@Override
	public CheckoutConsigneeDetails updateImpl(
		CheckoutConsigneeDetails checkoutConsigneeDetails) {

		boolean isNew = checkoutConsigneeDetails.isNew();

		if (!(checkoutConsigneeDetails instanceof
				CheckoutConsigneeDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(checkoutConsigneeDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					checkoutConsigneeDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in checkoutConsigneeDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CheckoutConsigneeDetails implementation " +
					checkoutConsigneeDetails.getClass());
		}

		CheckoutConsigneeDetailsModelImpl checkoutConsigneeDetailsModelImpl =
			(CheckoutConsigneeDetailsModelImpl)checkoutConsigneeDetails;

		if (Validator.isNull(checkoutConsigneeDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			checkoutConsigneeDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (checkoutConsigneeDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				checkoutConsigneeDetails.setCreateDate(date);
			}
			else {
				checkoutConsigneeDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!checkoutConsigneeDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				checkoutConsigneeDetails.setModifiedDate(date);
			}
			else {
				checkoutConsigneeDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(checkoutConsigneeDetails);
			}
			else {
				checkoutConsigneeDetails =
					(CheckoutConsigneeDetails)session.merge(
						checkoutConsigneeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CheckoutConsigneeDetailsImpl.class,
			checkoutConsigneeDetailsModelImpl, false, true);

		cacheUniqueFindersCache(checkoutConsigneeDetailsModelImpl);

		if (isNew) {
			checkoutConsigneeDetails.setNew(false);
		}

		checkoutConsigneeDetails.resetOriginalValues();

		return checkoutConsigneeDetails;
	}

	/**
	 * Returns the checkout consignee details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCheckoutConsigneeDetailsException {

		CheckoutConsigneeDetails checkoutConsigneeDetails = fetchByPrimaryKey(
			primaryKey);

		if (checkoutConsigneeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCheckoutConsigneeDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return checkoutConsigneeDetails;
	}

	/**
	 * Returns the checkout consignee details with the primary key or throws a <code>NoSuchCheckoutConsigneeDetailsException</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details
	 * @throws NoSuchCheckoutConsigneeDetailsException if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails findByPrimaryKey(long checkoutConsigneeId)
		throws NoSuchCheckoutConsigneeDetailsException {

		return findByPrimaryKey((Serializable)checkoutConsigneeId);
	}

	/**
	 * Returns the checkout consignee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutConsigneeId the primary key of the checkout consignee details
	 * @return the checkout consignee details, or <code>null</code> if a checkout consignee details with the primary key could not be found
	 */
	@Override
	public CheckoutConsigneeDetails fetchByPrimaryKey(
		long checkoutConsigneeId) {

		return fetchByPrimaryKey((Serializable)checkoutConsigneeId);
	}

	/**
	 * Returns all the checkout consignee detailses.
	 *
	 * @return the checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @return the range of checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout consignee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutConsigneeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout consignee detailses
	 * @param end the upper bound of the range of checkout consignee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checkout consignee detailses
	 */
	@Override
	public List<CheckoutConsigneeDetails> findAll(
		int start, int end,
		OrderByComparator<CheckoutConsigneeDetails> orderByComparator,
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

		List<CheckoutConsigneeDetails> list = null;

		if (useFinderCache) {
			list = (List<CheckoutConsigneeDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHECKOUTCONSIGNEEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHECKOUTCONSIGNEEDETAILS;

				sql = sql.concat(
					CheckoutConsigneeDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CheckoutConsigneeDetails>)QueryUtil.list(
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
	 * Removes all the checkout consignee detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CheckoutConsigneeDetails checkoutConsigneeDetails : findAll()) {
			remove(checkoutConsigneeDetails);
		}
	}

	/**
	 * Returns the number of checkout consignee detailses.
	 *
	 * @return the number of checkout consignee detailses
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
					_SQL_COUNT_CHECKOUTCONSIGNEEDETAILS);

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
		return "checkoutConsigneeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHECKOUTCONSIGNEEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CheckoutConsigneeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the checkout consignee details persistence.
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

		_finderPathWithPaginationFindByCartIdNOrderItemId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCartIdNOrderItemId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"parentCartId", "orderItemId"}, true);

		_finderPathWithoutPaginationFindByCartIdNOrderItemId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCartIdNOrderItemId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"parentCartId", "orderItemId"}, true);

		_finderPathCountByCartIdNOrderItemId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCartIdNOrderItemId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"parentCartId", "orderItemId"}, false);

		_finderPathWithPaginationFindByParentCartId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentCartId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentCartId"}, true);

		_finderPathWithoutPaginationFindByParentCartId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentCartId",
			new String[] {Long.class.getName()}, new String[] {"parentCartId"},
			true);

		_finderPathCountByParentCartId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentCartId",
			new String[] {Long.class.getName()}, new String[] {"parentCartId"},
			false);

		_setCheckoutConsigneeDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCheckoutConsigneeDetailsUtilPersistence(null);

		entityCache.removeCache(CheckoutConsigneeDetailsImpl.class.getName());
	}

	private void _setCheckoutConsigneeDetailsUtilPersistence(
		CheckoutConsigneeDetailsPersistence
			checkoutConsigneeDetailsPersistence) {

		try {
			Field field = CheckoutConsigneeDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, checkoutConsigneeDetailsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_consigneedetailsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_consigneedetailsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_consigneedetailsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHECKOUTCONSIGNEEDETAILS =
		"SELECT checkoutConsigneeDetails FROM CheckoutConsigneeDetails checkoutConsigneeDetails";

	private static final String _SQL_SELECT_CHECKOUTCONSIGNEEDETAILS_WHERE =
		"SELECT checkoutConsigneeDetails FROM CheckoutConsigneeDetails checkoutConsigneeDetails WHERE ";

	private static final String _SQL_COUNT_CHECKOUTCONSIGNEEDETAILS =
		"SELECT COUNT(checkoutConsigneeDetails) FROM CheckoutConsigneeDetails checkoutConsigneeDetails";

	private static final String _SQL_COUNT_CHECKOUTCONSIGNEEDETAILS_WHERE =
		"SELECT COUNT(checkoutConsigneeDetails) FROM CheckoutConsigneeDetails checkoutConsigneeDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"checkoutConsigneeDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CheckoutConsigneeDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CheckoutConsigneeDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CheckoutConsigneeDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}