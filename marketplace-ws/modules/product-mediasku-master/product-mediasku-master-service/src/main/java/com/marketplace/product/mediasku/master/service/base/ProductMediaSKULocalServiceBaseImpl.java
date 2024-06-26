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

package com.marketplace.product.mediasku.master.service.base;

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

import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalServiceUtil;
import com.marketplace.product.mediasku.master.service.persistence.ProductMediaSKUPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the product media sku local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.marketplace.product.mediasku.master.service.impl.ProductMediaSKULocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.marketplace.product.mediasku.master.service.impl.ProductMediaSKULocalServiceImpl
 * @generated
 */
public abstract class ProductMediaSKULocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProductMediaSKULocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProductMediaSKULocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProductMediaSKULocalServiceUtil</code>.
	 */

	/**
	 * Adds the product media sku to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductMediaSKU addProductMediaSKU(ProductMediaSKU productMediaSKU) {
		productMediaSKU.setNew(true);

		return productMediaSKUPersistence.update(productMediaSKU);
	}

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	@Override
	@Transactional(enabled = false)
	public ProductMediaSKU createProductMediaSKU(long ProductMediaSKUId) {
		return productMediaSKUPersistence.create(ProductMediaSKUId);
	}

	/**
	 * Deletes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductMediaSKU deleteProductMediaSKU(long ProductMediaSKUId)
		throws PortalException {

		return productMediaSKUPersistence.remove(ProductMediaSKUId);
	}

	/**
	 * Deletes the product media sku from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductMediaSKU deleteProductMediaSKU(
		ProductMediaSKU productMediaSKU) {

		return productMediaSKUPersistence.remove(productMediaSKU);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return productMediaSKUPersistence.dslQuery(dslQuery);
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
			ProductMediaSKU.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return productMediaSKUPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
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

		return productMediaSKUPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
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

		return productMediaSKUPersistence.findWithDynamicQuery(
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
		return productMediaSKUPersistence.countWithDynamicQuery(dynamicQuery);
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

		return productMediaSKUPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProductMediaSKU fetchProductMediaSKU(long ProductMediaSKUId) {
		return productMediaSKUPersistence.fetchByPrimaryKey(ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU fetchProductMediaSKUByUuidAndGroupId(
		String uuid, long groupId) {

		return productMediaSKUPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the product media sku with the primary key.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	@Override
	public ProductMediaSKU getProductMediaSKU(long ProductMediaSKUId)
		throws PortalException {

		return productMediaSKUPersistence.findByPrimaryKey(ProductMediaSKUId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(productMediaSKULocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductMediaSKU.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ProductMediaSKUId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			productMediaSKULocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ProductMediaSKU.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ProductMediaSKUId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(productMediaSKULocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductMediaSKU.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ProductMediaSKUId");
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
			new ActionableDynamicQuery.PerformActionMethod<ProductMediaSKU>() {

				@Override
				public void performAction(ProductMediaSKU productMediaSKU)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, productMediaSKU);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ProductMediaSKU.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productMediaSKUPersistence.create(
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
				"Implement ProductMediaSKULocalServiceImpl#deleteProductMediaSKU(ProductMediaSKU) to avoid orphaned data");
		}

		return productMediaSKULocalService.deleteProductMediaSKU(
			(ProductMediaSKU)persistedModel);
	}

	@Override
	public BasePersistence<ProductMediaSKU> getBasePersistence() {
		return productMediaSKUPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productMediaSKUPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @return the matching product media skus, or an empty list if no matches were found
	 */
	@Override
	public List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId) {

		return productMediaSKUPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product media skus, or an empty list if no matches were found
	 */
	@Override
	public List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return productMediaSKUPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku
	 * @throws PortalException if a matching product media sku could not be found
	 */
	@Override
	public ProductMediaSKU getProductMediaSKUByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return productMediaSKUPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of product media skus
	 */
	@Override
	public List<ProductMediaSKU> getProductMediaSKUs(int start, int end) {
		return productMediaSKUPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	@Override
	public int getProductMediaSKUsCount() {
		return productMediaSKUPersistence.countAll();
	}

	/**
	 * Updates the product media sku in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductMediaSKU updateProductMediaSKU(
		ProductMediaSKU productMediaSKU) {

		return productMediaSKUPersistence.update(productMediaSKU);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProductMediaSKULocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		productMediaSKULocalService = (ProductMediaSKULocalService)aopProxy;

		_setLocalServiceUtilService(productMediaSKULocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProductMediaSKULocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProductMediaSKU.class;
	}

	protected String getModelClassName() {
		return ProductMediaSKU.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = productMediaSKUPersistence.getDataSource();

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
		ProductMediaSKULocalService productMediaSKULocalService) {

		try {
			Field field =
				ProductMediaSKULocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, productMediaSKULocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ProductMediaSKULocalService productMediaSKULocalService;

	@Reference
	protected ProductMediaSKUPersistence productMediaSKUPersistence;

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
		ProductMediaSKULocalServiceBaseImpl.class);

}