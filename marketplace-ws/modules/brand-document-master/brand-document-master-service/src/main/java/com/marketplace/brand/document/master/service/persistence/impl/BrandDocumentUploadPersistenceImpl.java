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

package com.marketplace.brand.document.master.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.marketplace.brand.document.master.exception.NoSuchBrandDocumentUploadException;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.model.BrandDocumentUploadTable;
import com.marketplace.brand.document.master.model.impl.BrandDocumentUploadImpl;
import com.marketplace.brand.document.master.model.impl.BrandDocumentUploadModelImpl;
import com.marketplace.brand.document.master.service.persistence.BrandDocumentUploadPersistence;
import com.marketplace.brand.document.master.service.persistence.BrandDocumentUploadUtil;
import com.marketplace.brand.document.master.service.persistence.impl.constants.marketplace_branddocumentPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the brand document upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BrandDocumentUploadPersistence.class)
public class BrandDocumentUploadPersistenceImpl
	extends BasePersistenceImpl<BrandDocumentUpload>
	implements BrandDocumentUploadPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BrandDocumentUploadUtil</code> to access the brand document upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BrandDocumentUploadImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFBYBrandId;
	private FinderPath _finderPathWithoutPaginationFindByFBYBrandId;
	private FinderPath _finderPathCountByFBYBrandId;

	/**
	 * Returns all the brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByFBYBrandId(long brandId) {
		return findByFBYBrandId(
			brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end) {

		return findByFBYBrandId(brandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return findByFBYBrandId(brandId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFBYBrandId;
				finderArgs = new Object[] {brandId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFBYBrandId;
			finderArgs = new Object[] {brandId, start, end, orderByComparator};
		}

		List<BrandDocumentUpload> list = null;

		if (useFinderCache) {
			list = (List<BrandDocumentUpload>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BrandDocumentUpload brandDocumentUpload : list) {
					if (brandId != brandDocumentUpload.getBrandId()) {
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

			sb.append(_SQL_SELECT_BRANDDOCUMENTUPLOAD_WHERE);

			sb.append(_FINDER_COLUMN_FBYBRANDID_BRANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrandDocumentUploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(brandId);

				list = (List<BrandDocumentUpload>)QueryUtil.list(
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
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload findByFBYBrandId_First(
			long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = fetchByFBYBrandId_First(
			brandId, orderByComparator);

		if (brandDocumentUpload != null) {
			return brandDocumentUpload;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append("}");

		throw new NoSuchBrandDocumentUploadException(sb.toString());
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload fetchByFBYBrandId_First(
		long brandId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		List<BrandDocumentUpload> list = findByFBYBrandId(
			brandId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload findByFBYBrandId_Last(
			long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = fetchByFBYBrandId_Last(
			brandId, orderByComparator);

		if (brandDocumentUpload != null) {
			return brandDocumentUpload;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append("}");

		throw new NoSuchBrandDocumentUploadException(sb.toString());
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload fetchByFBYBrandId_Last(
		long brandId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		int count = countByFBYBrandId(brandId);

		if (count == 0) {
			return null;
		}

		List<BrandDocumentUpload> list = findByFBYBrandId(
			brandId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand document uploads before and after the current brand document upload in the ordered set where brandId = &#63;.
	 *
	 * @param brandDocumentUploadId the primary key of the current brand document upload
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload[] findByFBYBrandId_PrevAndNext(
			long brandDocumentUploadId, long brandId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = findByPrimaryKey(
			brandDocumentUploadId);

		Session session = null;

		try {
			session = openSession();

			BrandDocumentUpload[] array = new BrandDocumentUploadImpl[3];

			array[0] = getByFBYBrandId_PrevAndNext(
				session, brandDocumentUpload, brandId, orderByComparator, true);

			array[1] = brandDocumentUpload;

			array[2] = getByFBYBrandId_PrevAndNext(
				session, brandDocumentUpload, brandId, orderByComparator,
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

	protected BrandDocumentUpload getByFBYBrandId_PrevAndNext(
		Session session, BrandDocumentUpload brandDocumentUpload, long brandId,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
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

		sb.append(_SQL_SELECT_BRANDDOCUMENTUPLOAD_WHERE);

		sb.append(_FINDER_COLUMN_FBYBRANDID_BRANDID_2);

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
			sb.append(BrandDocumentUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(brandId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						brandDocumentUpload)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BrandDocumentUpload> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand document uploads where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	@Override
	public void removeByFBYBrandId(long brandId) {
		for (BrandDocumentUpload brandDocumentUpload :
				findByFBYBrandId(
					brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(brandDocumentUpload);
		}
	}

	/**
	 * Returns the number of brand document uploads where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand document uploads
	 */
	@Override
	public int countByFBYBrandId(long brandId) {
		FinderPath finderPath = _finderPathCountByFBYBrandId;

		Object[] finderArgs = new Object[] {brandId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANDDOCUMENTUPLOAD_WHERE);

			sb.append(_FINDER_COLUMN_FBYBRANDID_BRANDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(brandId);

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

	private static final String _FINDER_COLUMN_FBYBRANDID_BRANDID_2 =
		"brandDocumentUpload.brandId = ?";

	private FinderPath _finderPathWithPaginationFindByBrandAndFileId;
	private FinderPath _finderPathWithoutPaginationFindByBrandAndFileId;
	private FinderPath _finderPathCountByBrandAndFileId;

	/**
	 * Returns all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId) {

		return findByBrandAndFileId(
			brandId, documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end) {

		return findByBrandAndFileId(brandId, documentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return findByBrandAndFileId(
			brandId, documentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findByBrandAndFileId(
		long brandId, long documentId, int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBrandAndFileId;
				finderArgs = new Object[] {brandId, documentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBrandAndFileId;
			finderArgs = new Object[] {
				brandId, documentId, start, end, orderByComparator
			};
		}

		List<BrandDocumentUpload> list = null;

		if (useFinderCache) {
			list = (List<BrandDocumentUpload>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BrandDocumentUpload brandDocumentUpload : list) {
					if ((brandId != brandDocumentUpload.getBrandId()) ||
						(documentId != brandDocumentUpload.getDocumentId())) {

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

			sb.append(_SQL_SELECT_BRANDDOCUMENTUPLOAD_WHERE);

			sb.append(_FINDER_COLUMN_BRANDANDFILEID_BRANDID_2);

			sb.append(_FINDER_COLUMN_BRANDANDFILEID_DOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrandDocumentUploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(brandId);

				queryPos.add(documentId);

				list = (List<BrandDocumentUpload>)QueryUtil.list(
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
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload findByBrandAndFileId_First(
			long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = fetchByBrandAndFileId_First(
			brandId, documentId, orderByComparator);

		if (brandDocumentUpload != null) {
			return brandDocumentUpload;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append(", documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchBrandDocumentUploadException(sb.toString());
	}

	/**
	 * Returns the first brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload fetchByBrandAndFileId_First(
		long brandId, long documentId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		List<BrandDocumentUpload> list = findByBrandAndFileId(
			brandId, documentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload findByBrandAndFileId_Last(
			long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = fetchByBrandAndFileId_Last(
			brandId, documentId, orderByComparator);

		if (brandDocumentUpload != null) {
			return brandDocumentUpload;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append(", documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchBrandDocumentUploadException(sb.toString());
	}

	/**
	 * Returns the last brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand document upload, or <code>null</code> if a matching brand document upload could not be found
	 */
	@Override
	public BrandDocumentUpload fetchByBrandAndFileId_Last(
		long brandId, long documentId,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		int count = countByBrandAndFileId(brandId, documentId);

		if (count == 0) {
			return null;
		}

		List<BrandDocumentUpload> list = findByBrandAndFileId(
			brandId, documentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand document uploads before and after the current brand document upload in the ordered set where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandDocumentUploadId the primary key of the current brand document upload
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload[] findByBrandAndFileId_PrevAndNext(
			long brandDocumentUploadId, long brandId, long documentId,
			OrderByComparator<BrandDocumentUpload> orderByComparator)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = findByPrimaryKey(
			brandDocumentUploadId);

		Session session = null;

		try {
			session = openSession();

			BrandDocumentUpload[] array = new BrandDocumentUploadImpl[3];

			array[0] = getByBrandAndFileId_PrevAndNext(
				session, brandDocumentUpload, brandId, documentId,
				orderByComparator, true);

			array[1] = brandDocumentUpload;

			array[2] = getByBrandAndFileId_PrevAndNext(
				session, brandDocumentUpload, brandId, documentId,
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

	protected BrandDocumentUpload getByBrandAndFileId_PrevAndNext(
		Session session, BrandDocumentUpload brandDocumentUpload, long brandId,
		long documentId,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
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

		sb.append(_SQL_SELECT_BRANDDOCUMENTUPLOAD_WHERE);

		sb.append(_FINDER_COLUMN_BRANDANDFILEID_BRANDID_2);

		sb.append(_FINDER_COLUMN_BRANDANDFILEID_DOCUMENTID_2);

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
			sb.append(BrandDocumentUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(brandId);

		queryPos.add(documentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						brandDocumentUpload)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BrandDocumentUpload> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand document uploads where brandId = &#63; and documentId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 */
	@Override
	public void removeByBrandAndFileId(long brandId, long documentId) {
		for (BrandDocumentUpload brandDocumentUpload :
				findByBrandAndFileId(
					brandId, documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(brandDocumentUpload);
		}
	}

	/**
	 * Returns the number of brand document uploads where brandId = &#63; and documentId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param documentId the document ID
	 * @return the number of matching brand document uploads
	 */
	@Override
	public int countByBrandAndFileId(long brandId, long documentId) {
		FinderPath finderPath = _finderPathCountByBrandAndFileId;

		Object[] finderArgs = new Object[] {brandId, documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BRANDDOCUMENTUPLOAD_WHERE);

			sb.append(_FINDER_COLUMN_BRANDANDFILEID_BRANDID_2);

			sb.append(_FINDER_COLUMN_BRANDANDFILEID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(brandId);

				queryPos.add(documentId);

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

	private static final String _FINDER_COLUMN_BRANDANDFILEID_BRANDID_2 =
		"brandDocumentUpload.brandId = ? AND ";

	private static final String _FINDER_COLUMN_BRANDANDFILEID_DOCUMENTID_2 =
		"brandDocumentUpload.documentId = ?";

	public BrandDocumentUploadPersistenceImpl() {
		setModelClass(BrandDocumentUpload.class);

		setModelImplClass(BrandDocumentUploadImpl.class);
		setModelPKClass(long.class);

		setTable(BrandDocumentUploadTable.INSTANCE);
	}

	/**
	 * Caches the brand document upload in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUpload the brand document upload
	 */
	@Override
	public void cacheResult(BrandDocumentUpload brandDocumentUpload) {
		entityCache.putResult(
			BrandDocumentUploadImpl.class, brandDocumentUpload.getPrimaryKey(),
			brandDocumentUpload);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the brand document uploads in the entity cache if it is enabled.
	 *
	 * @param brandDocumentUploads the brand document uploads
	 */
	@Override
	public void cacheResult(List<BrandDocumentUpload> brandDocumentUploads) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (brandDocumentUploads.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BrandDocumentUpload brandDocumentUpload : brandDocumentUploads) {
			if (entityCache.getResult(
					BrandDocumentUploadImpl.class,
					brandDocumentUpload.getPrimaryKey()) == null) {

				cacheResult(brandDocumentUpload);
			}
		}
	}

	/**
	 * Clears the cache for all brand document uploads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BrandDocumentUploadImpl.class);

		finderCache.clearCache(BrandDocumentUploadImpl.class);
	}

	/**
	 * Clears the cache for the brand document upload.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BrandDocumentUpload brandDocumentUpload) {
		entityCache.removeResult(
			BrandDocumentUploadImpl.class, brandDocumentUpload);
	}

	@Override
	public void clearCache(List<BrandDocumentUpload> brandDocumentUploads) {
		for (BrandDocumentUpload brandDocumentUpload : brandDocumentUploads) {
			entityCache.removeResult(
				BrandDocumentUploadImpl.class, brandDocumentUpload);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BrandDocumentUploadImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BrandDocumentUploadImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new brand document upload with the primary key. Does not add the brand document upload to the database.
	 *
	 * @param brandDocumentUploadId the primary key for the new brand document upload
	 * @return the new brand document upload
	 */
	@Override
	public BrandDocumentUpload create(long brandDocumentUploadId) {
		BrandDocumentUpload brandDocumentUpload = new BrandDocumentUploadImpl();

		brandDocumentUpload.setNew(true);
		brandDocumentUpload.setPrimaryKey(brandDocumentUploadId);

		return brandDocumentUpload;
	}

	/**
	 * Removes the brand document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload that was removed
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload remove(long brandDocumentUploadId)
		throws NoSuchBrandDocumentUploadException {

		return remove((Serializable)brandDocumentUploadId);
	}

	/**
	 * Removes the brand document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the brand document upload
	 * @return the brand document upload that was removed
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload remove(Serializable primaryKey)
		throws NoSuchBrandDocumentUploadException {

		Session session = null;

		try {
			session = openSession();

			BrandDocumentUpload brandDocumentUpload =
				(BrandDocumentUpload)session.get(
					BrandDocumentUploadImpl.class, primaryKey);

			if (brandDocumentUpload == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandDocumentUploadException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(brandDocumentUpload);
		}
		catch (NoSuchBrandDocumentUploadException noSuchEntityException) {
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
	protected BrandDocumentUpload removeImpl(
		BrandDocumentUpload brandDocumentUpload) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(brandDocumentUpload)) {
				brandDocumentUpload = (BrandDocumentUpload)session.get(
					BrandDocumentUploadImpl.class,
					brandDocumentUpload.getPrimaryKeyObj());
			}

			if (brandDocumentUpload != null) {
				session.delete(brandDocumentUpload);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (brandDocumentUpload != null) {
			clearCache(brandDocumentUpload);
		}

		return brandDocumentUpload;
	}

	@Override
	public BrandDocumentUpload updateImpl(
		BrandDocumentUpload brandDocumentUpload) {

		boolean isNew = brandDocumentUpload.isNew();

		if (!(brandDocumentUpload instanceof BrandDocumentUploadModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(brandDocumentUpload.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					brandDocumentUpload);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in brandDocumentUpload proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BrandDocumentUpload implementation " +
					brandDocumentUpload.getClass());
		}

		BrandDocumentUploadModelImpl brandDocumentUploadModelImpl =
			(BrandDocumentUploadModelImpl)brandDocumentUpload;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(brandDocumentUpload);
			}
			else {
				brandDocumentUpload = (BrandDocumentUpload)session.merge(
					brandDocumentUpload);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BrandDocumentUploadImpl.class, brandDocumentUploadModelImpl, false,
			true);

		if (isNew) {
			brandDocumentUpload.setNew(false);
		}

		brandDocumentUpload.resetOriginalValues();

		return brandDocumentUpload;
	}

	/**
	 * Returns the brand document upload with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandDocumentUploadException {

		BrandDocumentUpload brandDocumentUpload = fetchByPrimaryKey(primaryKey);

		if (brandDocumentUpload == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandDocumentUploadException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return brandDocumentUpload;
	}

	/**
	 * Returns the brand document upload with the primary key or throws a <code>NoSuchBrandDocumentUploadException</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload
	 * @throws NoSuchBrandDocumentUploadException if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload findByPrimaryKey(long brandDocumentUploadId)
		throws NoSuchBrandDocumentUploadException {

		return findByPrimaryKey((Serializable)brandDocumentUploadId);
	}

	/**
	 * Returns the brand document upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandDocumentUploadId the primary key of the brand document upload
	 * @return the brand document upload, or <code>null</code> if a brand document upload with the primary key could not be found
	 */
	@Override
	public BrandDocumentUpload fetchByPrimaryKey(long brandDocumentUploadId) {
		return fetchByPrimaryKey((Serializable)brandDocumentUploadId);
	}

	/**
	 * Returns all the brand document uploads.
	 *
	 * @return the brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @return the range of brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findAll(
		int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brand document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandDocumentUploadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand document uploads
	 * @param end the upper bound of the range of brand document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brand document uploads
	 */
	@Override
	public List<BrandDocumentUpload> findAll(
		int start, int end,
		OrderByComparator<BrandDocumentUpload> orderByComparator,
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

		List<BrandDocumentUpload> list = null;

		if (useFinderCache) {
			list = (List<BrandDocumentUpload>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRANDDOCUMENTUPLOAD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRANDDOCUMENTUPLOAD;

				sql = sql.concat(BrandDocumentUploadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BrandDocumentUpload>)QueryUtil.list(
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
	 * Removes all the brand document uploads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BrandDocumentUpload brandDocumentUpload : findAll()) {
			remove(brandDocumentUpload);
		}
	}

	/**
	 * Returns the number of brand document uploads.
	 *
	 * @return the number of brand document uploads
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
					_SQL_COUNT_BRANDDOCUMENTUPLOAD);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "brandDocumentUploadId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BRANDDOCUMENTUPLOAD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BrandDocumentUploadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the brand document upload persistence.
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

		_finderPathWithPaginationFindByFBYBrandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFBYBrandId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"brandId"}, true);

		_finderPathWithoutPaginationFindByFBYBrandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFBYBrandId",
			new String[] {Long.class.getName()}, new String[] {"brandId"},
			true);

		_finderPathCountByFBYBrandId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFBYBrandId",
			new String[] {Long.class.getName()}, new String[] {"brandId"},
			false);

		_finderPathWithPaginationFindByBrandAndFileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrandAndFileId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"brandId", "documentId"}, true);

		_finderPathWithoutPaginationFindByBrandAndFileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBrandAndFileId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"brandId", "documentId"}, true);

		_finderPathCountByBrandAndFileId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrandAndFileId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"brandId", "documentId"}, false);

		_setBrandDocumentUploadUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBrandDocumentUploadUtilPersistence(null);

		entityCache.removeCache(BrandDocumentUploadImpl.class.getName());
	}

	private void _setBrandDocumentUploadUtilPersistence(
		BrandDocumentUploadPersistence brandDocumentUploadPersistence) {

		try {
			Field field = BrandDocumentUploadUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, brandDocumentUploadPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_branddocumentPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_branddocumentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_branddocumentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BRANDDOCUMENTUPLOAD =
		"SELECT brandDocumentUpload FROM BrandDocumentUpload brandDocumentUpload";

	private static final String _SQL_SELECT_BRANDDOCUMENTUPLOAD_WHERE =
		"SELECT brandDocumentUpload FROM BrandDocumentUpload brandDocumentUpload WHERE ";

	private static final String _SQL_COUNT_BRANDDOCUMENTUPLOAD =
		"SELECT COUNT(brandDocumentUpload) FROM BrandDocumentUpload brandDocumentUpload";

	private static final String _SQL_COUNT_BRANDDOCUMENTUPLOAD_WHERE =
		"SELECT COUNT(brandDocumentUpload) FROM BrandDocumentUpload brandDocumentUpload WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "brandDocumentUpload.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BrandDocumentUpload exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BrandDocumentUpload exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BrandDocumentUploadPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}