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

package com.marketplace.product.sku.master.service.base;

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

import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.sku.master.service.ProductSKULocalServiceUtil;
import com.marketplace.product.sku.master.service.persistence.ProductSKUPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the product sku local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.marketplace.product.sku.master.service.impl.ProductSKULocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.marketplace.product.sku.master.service.impl.ProductSKULocalServiceImpl
 * @generated
 */
public abstract class ProductSKULocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, ProductSKULocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProductSKULocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProductSKULocalServiceUtil</code>.
	 */

	/**
	 * Adds the product sku to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSKU the product sku
	 * @return the product sku that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductSKU addProductSKU(ProductSKU productSKU) {
		productSKU.setNew(true);

		return productSKUPersistence.update(productSKU);
	}

	/**
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	@Override
	@Transactional(enabled = false)
	public ProductSKU createProductSKU(long productSKUId) {
		return productSKUPersistence.create(productSKUId);
	}

	/**
	 * Deletes the product sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku that was removed
	 * @throws PortalException if a product sku with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductSKU deleteProductSKU(long productSKUId)
		throws PortalException {

		return productSKUPersistence.remove(productSKUId);
	}

	/**
	 * Deletes the product sku from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSKU the product sku
	 * @return the product sku that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductSKU deleteProductSKU(ProductSKU productSKU) {
		return productSKUPersistence.remove(productSKU);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return productSKUPersistence.dslQuery(dslQuery);
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
			ProductSKU.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return productSKUPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl</code>.
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

		return productSKUPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl</code>.
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

		return productSKUPersistence.findWithDynamicQuery(
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
		return productSKUPersistence.countWithDynamicQuery(dynamicQuery);
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

		return productSKUPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProductSKU fetchProductSKU(long productSKUId) {
		return productSKUPersistence.fetchByPrimaryKey(productSKUId);
	}

	/**
	 * Returns the product sku matching the UUID and group.
	 *
	 * @param uuid the product sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public ProductSKU fetchProductSKUByUuidAndGroupId(
		String uuid, long groupId) {

		return productSKUPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product sku with the primary key.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws PortalException if a product sku with the primary key could not be found
	 */
	@Override
	public ProductSKU getProductSKU(long productSKUId) throws PortalException {
		return productSKUPersistence.findByPrimaryKey(productSKUId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(productSKULocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductSKU.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productSKUId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			productSKULocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ProductSKU.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"productSKUId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(productSKULocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductSKU.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("productSKUId");
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
			new ActionableDynamicQuery.PerformActionMethod<ProductSKU>() {

				@Override
				public void performAction(ProductSKU productSKU)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, productSKU);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ProductSKU.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productSKUPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ProductSKULocalServiceImpl#deleteProductSKU(ProductSKU) to avoid orphaned data");
		}

		return productSKULocalService.deleteProductSKU(
			(ProductSKU)persistedModel);
	}

	@Override
	public BasePersistence<ProductSKU> getBasePersistence() {
		return productSKUPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productSKUPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the product skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product skus
	 * @param companyId the primary key of the company
	 * @return the matching product skus, or an empty list if no matches were found
	 */
	@Override
	public List<ProductSKU> getProductSKUsByUuidAndCompanyId(
		String uuid, long companyId) {

		return productSKUPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of product skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product skus
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product skus, or an empty list if no matches were found
	 */
	@Override
	public List<ProductSKU> getProductSKUsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return productSKUPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the product sku matching the UUID and group.
	 *
	 * @param uuid the product sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product sku
	 * @throws PortalException if a matching product sku could not be found
	 */
	@Override
	public ProductSKU getProductSKUByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return productSKUPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the product skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product skus
	 * @param end the upper bound of the range of product skus (not inclusive)
	 * @return the range of product skus
	 */
	@Override
	public List<ProductSKU> getProductSKUs(int start, int end) {
		return productSKUPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	@Override
	public int getProductSKUsCount() {
		return productSKUPersistence.countAll();
	}

	/**
	 * Updates the product sku in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSKU the product sku
	 * @return the product sku that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductSKU updateProductSKU(ProductSKU productSKU) {
		return productSKUPersistence.update(productSKU);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProductSKULocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		productSKULocalService = (ProductSKULocalService)aopProxy;

		_setLocalServiceUtilService(productSKULocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProductSKULocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProductSKU.class;
	}

	protected String getModelClassName() {
		return ProductSKU.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = productSKUPersistence.getDataSource();

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
		ProductSKULocalService productSKULocalService) {

		try {
			Field field = ProductSKULocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, productSKULocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ProductSKULocalService productSKULocalService;

	@Reference
	protected ProductSKUPersistence productSKUPersistence;

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
		ProductSKULocalServiceBaseImpl.class);

}