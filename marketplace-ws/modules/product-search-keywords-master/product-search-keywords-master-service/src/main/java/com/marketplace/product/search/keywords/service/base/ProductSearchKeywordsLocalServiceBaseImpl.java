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

package com.marketplace.product.search.keywords.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.marketplace.product.search.keywords.model.ProductSearchKeywords;
import com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalService;
import com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalServiceUtil;
import com.marketplace.product.search.keywords.service.persistence.ProductSearchKeywordsPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the product search keywords local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.marketplace.product.search.keywords.service.impl.ProductSearchKeywordsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.marketplace.product.search.keywords.service.impl.ProductSearchKeywordsLocalServiceImpl
 * @generated
 */
public abstract class ProductSearchKeywordsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProductSearchKeywordsLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProductSearchKeywordsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProductSearchKeywordsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the product search keywords to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductSearchKeywords addProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		productSearchKeywords.setNew(true);

		return productSearchKeywordsPersistence.update(productSearchKeywords);
	}

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	@Override
	@Transactional(enabled = false)
	public ProductSearchKeywords createProductSearchKeywords(
		long searchKeywordId) {

		return productSearchKeywordsPersistence.create(searchKeywordId);
	}

	/**
	 * Deletes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws PortalException if a product search keywords with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductSearchKeywords deleteProductSearchKeywords(
			long searchKeywordId)
		throws PortalException {

		return productSearchKeywordsPersistence.remove(searchKeywordId);
	}

	/**
	 * Deletes the product search keywords from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductSearchKeywords deleteProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		return productSearchKeywordsPersistence.remove(productSearchKeywords);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return productSearchKeywordsPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ProductSearchKeywords.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return productSearchKeywordsPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return productSearchKeywordsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return productSearchKeywordsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return productSearchKeywordsPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return productSearchKeywordsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProductSearchKeywords fetchProductSearchKeywords(
		long searchKeywordId) {

		return productSearchKeywordsPersistence.fetchByPrimaryKey(
			searchKeywordId);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords fetchProductSearchKeywordsByUuidAndGroupId(
		String uuid, long groupId) {

		return productSearchKeywordsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product search keywords with the primary key.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws PortalException if a product search keywords with the primary key could not be found
	 */
	@Override
	public ProductSearchKeywords getProductSearchKeywords(long searchKeywordId)
		throws PortalException {

		return productSearchKeywordsPersistence.findByPrimaryKey(
			searchKeywordId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			productSearchKeywordsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductSearchKeywords.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("searchKeywordId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			productSearchKeywordsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ProductSearchKeywords.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"searchKeywordId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			productSearchKeywordsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductSearchKeywords.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("searchKeywordId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ProductSearchKeywords>() {

				@Override
				public void performAction(
						ProductSearchKeywords productSearchKeywords)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, productSearchKeywords);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					ProductSearchKeywords.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productSearchKeywordsPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ProductSearchKeywordsLocalServiceImpl#deleteProductSearchKeywords(ProductSearchKeywords) to avoid orphaned data");
		}

		return productSearchKeywordsLocalService.deleteProductSearchKeywords(
			(ProductSearchKeywords)persistedModel);
	}

	@Override
	public BasePersistence<ProductSearchKeywords> getBasePersistence() {
		return productSearchKeywordsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productSearchKeywordsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the product search keywordses matching the UUID and company.
	 *
	 * @param uuid the UUID of the product search keywordses
	 * @param companyId the primary key of the company
	 * @return the matching product search keywordses, or an empty list if no matches were found
	 */
	@Override
	public List<ProductSearchKeywords>
		getProductSearchKeywordsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return productSearchKeywordsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of product search keywordses matching the UUID and company.
	 *
	 * @param uuid the UUID of the product search keywordses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product search keywordses, or an empty list if no matches were found
	 */
	@Override
	public List<ProductSearchKeywords>
		getProductSearchKeywordsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return productSearchKeywordsPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords
	 * @throws PortalException if a matching product search keywords could not be found
	 */
	@Override
	public ProductSearchKeywords getProductSearchKeywordsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return productSearchKeywordsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of product search keywordses
	 */
	@Override
	public List<ProductSearchKeywords> getProductSearchKeywordses(
		int start, int end) {

		return productSearchKeywordsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
	 */
	@Override
	public int getProductSearchKeywordsesCount() {
		return productSearchKeywordsPersistence.countAll();
	}

	/**
	 * Updates the product search keywords in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductSearchKeywords updateProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		return productSearchKeywordsPersistence.update(productSearchKeywords);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProductSearchKeywordsLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		productSearchKeywordsLocalService =
			(ProductSearchKeywordsLocalService)aopProxy;

		_setLocalServiceUtilService(productSearchKeywordsLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProductSearchKeywordsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProductSearchKeywords.class;
	}

	protected String getModelClassName() {
		return ProductSearchKeywords.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				productSearchKeywordsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ProductSearchKeywordsLocalService productSearchKeywordsLocalService) {

		try {
			Field field =
				ProductSearchKeywordsLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, productSearchKeywordsLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ProductSearchKeywordsLocalService
		productSearchKeywordsLocalService;

	@Reference
	protected ProductSearchKeywordsPersistence productSearchKeywordsPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ProductSearchKeywordsLocalServiceBaseImpl.class);

}