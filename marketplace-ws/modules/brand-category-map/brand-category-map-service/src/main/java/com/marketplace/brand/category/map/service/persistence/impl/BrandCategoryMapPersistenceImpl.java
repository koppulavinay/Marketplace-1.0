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

package com.marketplace.brand.category.map.service.persistence.impl;

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

import com.marketplace.brand.category.map.exception.NoSuchBrandCategoryMapException;
import com.marketplace.brand.category.map.model.BrandCategoryMap;
import com.marketplace.brand.category.map.model.BrandCategoryMapTable;
import com.marketplace.brand.category.map.model.impl.BrandCategoryMapImpl;
import com.marketplace.brand.category.map.model.impl.BrandCategoryMapModelImpl;
import com.marketplace.brand.category.map.service.persistence.BrandCategoryMapPersistence;
import com.marketplace.brand.category.map.service.persistence.BrandCategoryMapUtil;
import com.marketplace.brand.category.map.service.persistence.impl.constants.marketplace_brandcategorymapPersistenceConstants;

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
 * The persistence implementation for the brand category map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BrandCategoryMapPersistence.class)
public class BrandCategoryMapPersistenceImpl
	extends BasePersistenceImpl<BrandCategoryMap>
	implements BrandCategoryMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BrandCategoryMapUtil</code> to access the brand category map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BrandCategoryMapImpl.class.getName();

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
	 * Returns all the brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the matching brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findByFBYBrandId(long brandId) {
		return findByFBYBrandId(
			brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of matching brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end) {

		return findByFBYBrandId(brandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator) {

		return findByFBYBrandId(brandId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brand category maps where brandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param brandId the brand ID
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findByFBYBrandId(
		long brandId, int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator,
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

		List<BrandCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<BrandCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BrandCategoryMap brandCategoryMap : list) {
					if (brandId != brandCategoryMap.getBrandId()) {
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

			sb.append(_SQL_SELECT_BRANDCATEGORYMAP_WHERE);

			sb.append(_FINDER_COLUMN_FBYBRANDID_BRANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrandCategoryMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(brandId);

				list = (List<BrandCategoryMap>)QueryUtil.list(
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
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	@Override
	public BrandCategoryMap findByFBYBrandId_First(
			long brandId, OrderByComparator<BrandCategoryMap> orderByComparator)
		throws NoSuchBrandCategoryMapException {

		BrandCategoryMap brandCategoryMap = fetchByFBYBrandId_First(
			brandId, orderByComparator);

		if (brandCategoryMap != null) {
			return brandCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append("}");

		throw new NoSuchBrandCategoryMapException(sb.toString());
	}

	/**
	 * Returns the first brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	@Override
	public BrandCategoryMap fetchByFBYBrandId_First(
		long brandId, OrderByComparator<BrandCategoryMap> orderByComparator) {

		List<BrandCategoryMap> list = findByFBYBrandId(
			brandId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map
	 * @throws NoSuchBrandCategoryMapException if a matching brand category map could not be found
	 */
	@Override
	public BrandCategoryMap findByFBYBrandId_Last(
			long brandId, OrderByComparator<BrandCategoryMap> orderByComparator)
		throws NoSuchBrandCategoryMapException {

		BrandCategoryMap brandCategoryMap = fetchByFBYBrandId_Last(
			brandId, orderByComparator);

		if (brandCategoryMap != null) {
			return brandCategoryMap;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("brandId=");
		sb.append(brandId);

		sb.append("}");

		throw new NoSuchBrandCategoryMapException(sb.toString());
	}

	/**
	 * Returns the last brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand category map, or <code>null</code> if a matching brand category map could not be found
	 */
	@Override
	public BrandCategoryMap fetchByFBYBrandId_Last(
		long brandId, OrderByComparator<BrandCategoryMap> orderByComparator) {

		int count = countByFBYBrandId(brandId);

		if (count == 0) {
			return null;
		}

		List<BrandCategoryMap> list = findByFBYBrandId(
			brandId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand category maps before and after the current brand category map in the ordered set where brandId = &#63;.
	 *
	 * @param brandCategoryMapId the primary key of the current brand category map
	 * @param brandId the brand ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap[] findByFBYBrandId_PrevAndNext(
			long brandCategoryMapId, long brandId,
			OrderByComparator<BrandCategoryMap> orderByComparator)
		throws NoSuchBrandCategoryMapException {

		BrandCategoryMap brandCategoryMap = findByPrimaryKey(
			brandCategoryMapId);

		Session session = null;

		try {
			session = openSession();

			BrandCategoryMap[] array = new BrandCategoryMapImpl[3];

			array[0] = getByFBYBrandId_PrevAndNext(
				session, brandCategoryMap, brandId, orderByComparator, true);

			array[1] = brandCategoryMap;

			array[2] = getByFBYBrandId_PrevAndNext(
				session, brandCategoryMap, brandId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BrandCategoryMap getByFBYBrandId_PrevAndNext(
		Session session, BrandCategoryMap brandCategoryMap, long brandId,
		OrderByComparator<BrandCategoryMap> orderByComparator,
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

		sb.append(_SQL_SELECT_BRANDCATEGORYMAP_WHERE);

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
			sb.append(BrandCategoryMapModelImpl.ORDER_BY_JPQL);
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
						brandCategoryMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BrandCategoryMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand category maps where brandId = &#63; from the database.
	 *
	 * @param brandId the brand ID
	 */
	@Override
	public void removeByFBYBrandId(long brandId) {
		for (BrandCategoryMap brandCategoryMap :
				findByFBYBrandId(
					brandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(brandCategoryMap);
		}
	}

	/**
	 * Returns the number of brand category maps where brandId = &#63;.
	 *
	 * @param brandId the brand ID
	 * @return the number of matching brand category maps
	 */
	@Override
	public int countByFBYBrandId(long brandId) {
		FinderPath finderPath = _finderPathCountByFBYBrandId;

		Object[] finderArgs = new Object[] {brandId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANDCATEGORYMAP_WHERE);

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
		"brandCategoryMap.brandId = ?";

	public BrandCategoryMapPersistenceImpl() {
		setModelClass(BrandCategoryMap.class);

		setModelImplClass(BrandCategoryMapImpl.class);
		setModelPKClass(long.class);

		setTable(BrandCategoryMapTable.INSTANCE);
	}

	/**
	 * Caches the brand category map in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMap the brand category map
	 */
	@Override
	public void cacheResult(BrandCategoryMap brandCategoryMap) {
		entityCache.putResult(
			BrandCategoryMapImpl.class, brandCategoryMap.getPrimaryKey(),
			brandCategoryMap);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the brand category maps in the entity cache if it is enabled.
	 *
	 * @param brandCategoryMaps the brand category maps
	 */
	@Override
	public void cacheResult(List<BrandCategoryMap> brandCategoryMaps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (brandCategoryMaps.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
			if (entityCache.getResult(
					BrandCategoryMapImpl.class,
					brandCategoryMap.getPrimaryKey()) == null) {

				cacheResult(brandCategoryMap);
			}
		}
	}

	/**
	 * Clears the cache for all brand category maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BrandCategoryMapImpl.class);

		finderCache.clearCache(BrandCategoryMapImpl.class);
	}

	/**
	 * Clears the cache for the brand category map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BrandCategoryMap brandCategoryMap) {
		entityCache.removeResult(BrandCategoryMapImpl.class, brandCategoryMap);
	}

	@Override
	public void clearCache(List<BrandCategoryMap> brandCategoryMaps) {
		for (BrandCategoryMap brandCategoryMap : brandCategoryMaps) {
			entityCache.removeResult(
				BrandCategoryMapImpl.class, brandCategoryMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BrandCategoryMapImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BrandCategoryMapImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new brand category map with the primary key. Does not add the brand category map to the database.
	 *
	 * @param brandCategoryMapId the primary key for the new brand category map
	 * @return the new brand category map
	 */
	@Override
	public BrandCategoryMap create(long brandCategoryMapId) {
		BrandCategoryMap brandCategoryMap = new BrandCategoryMapImpl();

		brandCategoryMap.setNew(true);
		brandCategoryMap.setPrimaryKey(brandCategoryMapId);

		return brandCategoryMap;
	}

	/**
	 * Removes the brand category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map that was removed
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap remove(long brandCategoryMapId)
		throws NoSuchBrandCategoryMapException {

		return remove((Serializable)brandCategoryMapId);
	}

	/**
	 * Removes the brand category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the brand category map
	 * @return the brand category map that was removed
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap remove(Serializable primaryKey)
		throws NoSuchBrandCategoryMapException {

		Session session = null;

		try {
			session = openSession();

			BrandCategoryMap brandCategoryMap = (BrandCategoryMap)session.get(
				BrandCategoryMapImpl.class, primaryKey);

			if (brandCategoryMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandCategoryMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(brandCategoryMap);
		}
		catch (NoSuchBrandCategoryMapException noSuchEntityException) {
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
	protected BrandCategoryMap removeImpl(BrandCategoryMap brandCategoryMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(brandCategoryMap)) {
				brandCategoryMap = (BrandCategoryMap)session.get(
					BrandCategoryMapImpl.class,
					brandCategoryMap.getPrimaryKeyObj());
			}

			if (brandCategoryMap != null) {
				session.delete(brandCategoryMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (brandCategoryMap != null) {
			clearCache(brandCategoryMap);
		}

		return brandCategoryMap;
	}

	@Override
	public BrandCategoryMap updateImpl(BrandCategoryMap brandCategoryMap) {
		boolean isNew = brandCategoryMap.isNew();

		if (!(brandCategoryMap instanceof BrandCategoryMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(brandCategoryMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					brandCategoryMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in brandCategoryMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BrandCategoryMap implementation " +
					brandCategoryMap.getClass());
		}

		BrandCategoryMapModelImpl brandCategoryMapModelImpl =
			(BrandCategoryMapModelImpl)brandCategoryMap;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(brandCategoryMap);
			}
			else {
				brandCategoryMap = (BrandCategoryMap)session.merge(
					brandCategoryMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BrandCategoryMapImpl.class, brandCategoryMapModelImpl, false, true);

		if (isNew) {
			brandCategoryMap.setNew(false);
		}

		brandCategoryMap.resetOriginalValues();

		return brandCategoryMap;
	}

	/**
	 * Returns the brand category map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand category map
	 * @return the brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandCategoryMapException {

		BrandCategoryMap brandCategoryMap = fetchByPrimaryKey(primaryKey);

		if (brandCategoryMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandCategoryMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return brandCategoryMap;
	}

	/**
	 * Returns the brand category map with the primary key or throws a <code>NoSuchBrandCategoryMapException</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map
	 * @throws NoSuchBrandCategoryMapException if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap findByPrimaryKey(long brandCategoryMapId)
		throws NoSuchBrandCategoryMapException {

		return findByPrimaryKey((Serializable)brandCategoryMapId);
	}

	/**
	 * Returns the brand category map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param brandCategoryMapId the primary key of the brand category map
	 * @return the brand category map, or <code>null</code> if a brand category map with the primary key could not be found
	 */
	@Override
	public BrandCategoryMap fetchByPrimaryKey(long brandCategoryMapId) {
		return fetchByPrimaryKey((Serializable)brandCategoryMapId);
	}

	/**
	 * Returns all the brand category maps.
	 *
	 * @return the brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @return the range of brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findAll(
		int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brand category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand category maps
	 * @param end the upper bound of the range of brand category maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brand category maps
	 */
	@Override
	public List<BrandCategoryMap> findAll(
		int start, int end,
		OrderByComparator<BrandCategoryMap> orderByComparator,
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

		List<BrandCategoryMap> list = null;

		if (useFinderCache) {
			list = (List<BrandCategoryMap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRANDCATEGORYMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRANDCATEGORYMAP;

				sql = sql.concat(BrandCategoryMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BrandCategoryMap>)QueryUtil.list(
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
	 * Removes all the brand category maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BrandCategoryMap brandCategoryMap : findAll()) {
			remove(brandCategoryMap);
		}
	}

	/**
	 * Returns the number of brand category maps.
	 *
	 * @return the number of brand category maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BRANDCATEGORYMAP);

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
		return "brandCategoryMapId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BRANDCATEGORYMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BrandCategoryMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the brand category map persistence.
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

		_setBrandCategoryMapUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBrandCategoryMapUtilPersistence(null);

		entityCache.removeCache(BrandCategoryMapImpl.class.getName());
	}

	private void _setBrandCategoryMapUtilPersistence(
		BrandCategoryMapPersistence brandCategoryMapPersistence) {

		try {
			Field field = BrandCategoryMapUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, brandCategoryMapPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_brandcategorymapPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_brandcategorymapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_brandcategorymapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BRANDCATEGORYMAP =
		"SELECT brandCategoryMap FROM BrandCategoryMap brandCategoryMap";

	private static final String _SQL_SELECT_BRANDCATEGORYMAP_WHERE =
		"SELECT brandCategoryMap FROM BrandCategoryMap brandCategoryMap WHERE ";

	private static final String _SQL_COUNT_BRANDCATEGORYMAP =
		"SELECT COUNT(brandCategoryMap) FROM BrandCategoryMap brandCategoryMap";

	private static final String _SQL_COUNT_BRANDCATEGORYMAP_WHERE =
		"SELECT COUNT(brandCategoryMap) FROM BrandCategoryMap brandCategoryMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "brandCategoryMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BrandCategoryMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BrandCategoryMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BrandCategoryMapPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}