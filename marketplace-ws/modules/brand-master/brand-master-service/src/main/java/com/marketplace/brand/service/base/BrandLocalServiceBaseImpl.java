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

package com.marketplace.brand.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.brand.service.BrandLocalServiceUtil;
import com.marketplace.brand.service.persistence.BrandPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the brand local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.marketplace.brand.service.impl.BrandLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.marketplace.brand.service.impl.BrandLocalServiceImpl
 * @generated
 */
public abstract class BrandLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, BrandLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>BrandLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BrandLocalServiceUtil</code>.
	 */

	/**
	 * Adds the brand to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Brand addBrand(Brand brand) {
		brand.setNew(true);

		return brandPersistence.update(brand);
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param brandId the primary key for the new brand
	 * @return the new brand
	 */
	@Override
	@Transactional(enabled = false)
	public Brand createBrand(long brandId) {
		return brandPersistence.create(brandId);
	}

	/**
	 * Deletes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand that was removed
	 * @throws PortalException if a brand with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Brand deleteBrand(long brandId) throws PortalException {
		return brandPersistence.remove(brandId);
	}

	/**
	 * Deletes the brand from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Brand deleteBrand(Brand brand) {
		return brandPersistence.remove(brand);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return brandPersistence.dslQuery(dslQuery);
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
			Brand.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return brandPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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

		return brandPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
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

		return brandPersistence.findWithDynamicQuery(
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
		return brandPersistence.countWithDynamicQuery(dynamicQuery);
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

		return brandPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Brand fetchBrand(long brandId) {
		return brandPersistence.fetchByPrimaryKey(brandId);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchBrandByUuidAndGroupId(String uuid, long groupId) {
		return brandPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the brand with the primary key.
	 *
	 * @param brandId the primary key of the brand
	 * @return the brand
	 * @throws PortalException if a brand with the primary key could not be found
	 */
	@Override
	public Brand getBrand(long brandId) throws PortalException {
		return brandPersistence.findByPrimaryKey(brandId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(brandLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Brand.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("brandId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(brandLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Brand.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("brandId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(brandLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Brand.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("brandId");
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
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									Brand.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Brand>() {

				@Override
				public void performAction(Brand brand) throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, brand);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Brand.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return brandPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement BrandLocalServiceImpl#deleteBrand(Brand) to avoid orphaned data");
		}

		return brandLocalService.deleteBrand((Brand)persistedModel);
	}

	@Override
	public BasePersistence<Brand> getBasePersistence() {
		return brandPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return brandPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the brands matching the UUID and company.
	 *
	 * @param uuid the UUID of the brands
	 * @param companyId the primary key of the company
	 * @return the matching brands, or an empty list if no matches were found
	 */
	@Override
	public List<Brand> getBrandsByUuidAndCompanyId(
		String uuid, long companyId) {

		return brandPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of brands matching the UUID and company.
	 *
	 * @param uuid the UUID of the brands
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching brands, or an empty list if no matches were found
	 */
	@Override
	public List<Brand> getBrandsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return brandPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the brand matching the UUID and group.
	 *
	 * @param uuid the brand's UUID
	 * @param groupId the primary key of the group
	 * @return the matching brand
	 * @throws PortalException if a matching brand could not be found
	 */
	@Override
	public Brand getBrandByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return brandPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.brand.model.impl.BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of brands
	 */
	@Override
	public List<Brand> getBrands(int start, int end) {
		return brandPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	@Override
	public int getBrandsCount() {
		return brandPersistence.countAll();
	}

	/**
	 * Updates the brand in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrandLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param brand the brand
	 * @return the brand that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Brand updateBrand(Brand brand) {
		return brandPersistence.update(brand);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			BrandLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		brandLocalService = (BrandLocalService)aopProxy;

		_setLocalServiceUtilService(brandLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BrandLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Brand.class;
	}

	protected String getModelClassName() {
		return Brand.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = brandPersistence.getDataSource();

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
		BrandLocalService brandLocalService) {

		try {
			Field field = BrandLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, brandLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected BrandLocalService brandLocalService;

	@Reference
	protected BrandPersistence brandPersistence;

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
		BrandLocalServiceBaseImpl.class);

}