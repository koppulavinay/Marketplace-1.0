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

package com.marketplace.checkout.master.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.marketplace.checkout.master.exception.NoSuchCheckoutCustomException;
import com.marketplace.checkout.master.model.CheckoutCustom;
import com.marketplace.checkout.master.model.CheckoutCustomTable;
import com.marketplace.checkout.master.model.impl.CheckoutCustomImpl;
import com.marketplace.checkout.master.model.impl.CheckoutCustomModelImpl;
import com.marketplace.checkout.master.service.persistence.CheckoutCustomPersistence;
import com.marketplace.checkout.master.service.persistence.CheckoutCustomUtil;
import com.marketplace.checkout.master.service.persistence.impl.constants.marketplace_checkoutPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the checkout custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CheckoutCustomPersistence.class)
public class CheckoutCustomPersistenceImpl
	extends BasePersistenceImpl<CheckoutCustom>
	implements CheckoutCustomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CheckoutCustomUtil</code> to access the checkout custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CheckoutCustomImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CheckoutCustomPersistenceImpl() {
		setModelClass(CheckoutCustom.class);

		setModelImplClass(CheckoutCustomImpl.class);
		setModelPKClass(long.class);

		setTable(CheckoutCustomTable.INSTANCE);
	}

	/**
	 * Caches the checkout custom in the entity cache if it is enabled.
	 *
	 * @param checkoutCustom the checkout custom
	 */
	@Override
	public void cacheResult(CheckoutCustom checkoutCustom) {
		entityCache.putResult(
			CheckoutCustomImpl.class, checkoutCustom.getPrimaryKey(),
			checkoutCustom);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the checkout customs in the entity cache if it is enabled.
	 *
	 * @param checkoutCustoms the checkout customs
	 */
	@Override
	public void cacheResult(List<CheckoutCustom> checkoutCustoms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (checkoutCustoms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CheckoutCustom checkoutCustom : checkoutCustoms) {
			if (entityCache.getResult(
					CheckoutCustomImpl.class, checkoutCustom.getPrimaryKey()) ==
						null) {

				cacheResult(checkoutCustom);
			}
		}
	}

	/**
	 * Clears the cache for all checkout customs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CheckoutCustomImpl.class);

		finderCache.clearCache(CheckoutCustomImpl.class);
	}

	/**
	 * Clears the cache for the checkout custom.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CheckoutCustom checkoutCustom) {
		entityCache.removeResult(CheckoutCustomImpl.class, checkoutCustom);
	}

	@Override
	public void clearCache(List<CheckoutCustom> checkoutCustoms) {
		for (CheckoutCustom checkoutCustom : checkoutCustoms) {
			entityCache.removeResult(CheckoutCustomImpl.class, checkoutCustom);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CheckoutCustomImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CheckoutCustomImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new checkout custom with the primary key. Does not add the checkout custom to the database.
	 *
	 * @param checkoutCustomId the primary key for the new checkout custom
	 * @return the new checkout custom
	 */
	@Override
	public CheckoutCustom create(long checkoutCustomId) {
		CheckoutCustom checkoutCustom = new CheckoutCustomImpl();

		checkoutCustom.setNew(true);
		checkoutCustom.setPrimaryKey(checkoutCustomId);

		return checkoutCustom;
	}

	/**
	 * Removes the checkout custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom that was removed
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	@Override
	public CheckoutCustom remove(long checkoutCustomId)
		throws NoSuchCheckoutCustomException {

		return remove((Serializable)checkoutCustomId);
	}

	/**
	 * Removes the checkout custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the checkout custom
	 * @return the checkout custom that was removed
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	@Override
	public CheckoutCustom remove(Serializable primaryKey)
		throws NoSuchCheckoutCustomException {

		Session session = null;

		try {
			session = openSession();

			CheckoutCustom checkoutCustom = (CheckoutCustom)session.get(
				CheckoutCustomImpl.class, primaryKey);

			if (checkoutCustom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCheckoutCustomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(checkoutCustom);
		}
		catch (NoSuchCheckoutCustomException noSuchEntityException) {
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
	protected CheckoutCustom removeImpl(CheckoutCustom checkoutCustom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(checkoutCustom)) {
				checkoutCustom = (CheckoutCustom)session.get(
					CheckoutCustomImpl.class,
					checkoutCustom.getPrimaryKeyObj());
			}

			if (checkoutCustom != null) {
				session.delete(checkoutCustom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (checkoutCustom != null) {
			clearCache(checkoutCustom);
		}

		return checkoutCustom;
	}

	@Override
	public CheckoutCustom updateImpl(CheckoutCustom checkoutCustom) {
		boolean isNew = checkoutCustom.isNew();

		if (!(checkoutCustom instanceof CheckoutCustomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(checkoutCustom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					checkoutCustom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in checkoutCustom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CheckoutCustom implementation " +
					checkoutCustom.getClass());
		}

		CheckoutCustomModelImpl checkoutCustomModelImpl =
			(CheckoutCustomModelImpl)checkoutCustom;

		if (isNew && (checkoutCustom.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				checkoutCustom.setCreateDate(date);
			}
			else {
				checkoutCustom.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(checkoutCustom);
			}
			else {
				checkoutCustom = (CheckoutCustom)session.merge(checkoutCustom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CheckoutCustomImpl.class, checkoutCustom, false, true);

		if (isNew) {
			checkoutCustom.setNew(false);
		}

		checkoutCustom.resetOriginalValues();

		return checkoutCustom;
	}

	/**
	 * Returns the checkout custom with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the checkout custom
	 * @return the checkout custom
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	@Override
	public CheckoutCustom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCheckoutCustomException {

		CheckoutCustom checkoutCustom = fetchByPrimaryKey(primaryKey);

		if (checkoutCustom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCheckoutCustomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return checkoutCustom;
	}

	/**
	 * Returns the checkout custom with the primary key or throws a <code>NoSuchCheckoutCustomException</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom
	 * @throws NoSuchCheckoutCustomException if a checkout custom with the primary key could not be found
	 */
	@Override
	public CheckoutCustom findByPrimaryKey(long checkoutCustomId)
		throws NoSuchCheckoutCustomException {

		return findByPrimaryKey((Serializable)checkoutCustomId);
	}

	/**
	 * Returns the checkout custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkoutCustomId the primary key of the checkout custom
	 * @return the checkout custom, or <code>null</code> if a checkout custom with the primary key could not be found
	 */
	@Override
	public CheckoutCustom fetchByPrimaryKey(long checkoutCustomId) {
		return fetchByPrimaryKey((Serializable)checkoutCustomId);
	}

	/**
	 * Returns all the checkout customs.
	 *
	 * @return the checkout customs
	 */
	@Override
	public List<CheckoutCustom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @return the range of checkout customs
	 */
	@Override
	public List<CheckoutCustom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checkout customs
	 */
	@Override
	public List<CheckoutCustom> findAll(
		int start, int end,
		OrderByComparator<CheckoutCustom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checkout customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CheckoutCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checkout customs
	 * @param end the upper bound of the range of checkout customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checkout customs
	 */
	@Override
	public List<CheckoutCustom> findAll(
		int start, int end, OrderByComparator<CheckoutCustom> orderByComparator,
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

		List<CheckoutCustom> list = null;

		if (useFinderCache) {
			list = (List<CheckoutCustom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHECKOUTCUSTOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHECKOUTCUSTOM;

				sql = sql.concat(CheckoutCustomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CheckoutCustom>)QueryUtil.list(
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
	 * Removes all the checkout customs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CheckoutCustom checkoutCustom : findAll()) {
			remove(checkoutCustom);
		}
	}

	/**
	 * Returns the number of checkout customs.
	 *
	 * @return the number of checkout customs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHECKOUTCUSTOM);

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
		return "checkoutCustomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHECKOUTCUSTOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CheckoutCustomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the checkout custom persistence.
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

		_setCheckoutCustomUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCheckoutCustomUtilPersistence(null);

		entityCache.removeCache(CheckoutCustomImpl.class.getName());
	}

	private void _setCheckoutCustomUtilPersistence(
		CheckoutCustomPersistence checkoutCustomPersistence) {

		try {
			Field field = CheckoutCustomUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, checkoutCustomPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = marketplace_checkoutPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = marketplace_checkoutPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = marketplace_checkoutPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHECKOUTCUSTOM =
		"SELECT checkoutCustom FROM CheckoutCustom checkoutCustom";

	private static final String _SQL_COUNT_CHECKOUTCUSTOM =
		"SELECT COUNT(checkoutCustom) FROM CheckoutCustom checkoutCustom";

	private static final String _ORDER_BY_ENTITY_ALIAS = "checkoutCustom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CheckoutCustom exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CheckoutCustomPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}