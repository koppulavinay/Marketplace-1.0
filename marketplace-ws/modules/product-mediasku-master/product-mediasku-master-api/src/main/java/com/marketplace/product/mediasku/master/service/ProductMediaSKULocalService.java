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

package com.marketplace.product.mediasku.master.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.mediasku.master.model.ProductMediaSKU;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProductMediaSKU. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKULocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProductMediaSKULocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.marketplace.product.mediasku.master.service.impl.ProductMediaSKULocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the product media sku local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProductMediaSKULocalServiceUtil} if injection and service tracking are not available.
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
	public ProductMediaSKU addProductMediaSKU(ProductMediaSKU productMediaSKU);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	@Transactional(enabled = false)
	public ProductMediaSKU createProductMediaSKU(long ProductMediaSKUId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	public ProductMediaSKU deleteProductMediaSKU(long ProductMediaSKUId)
		throws PortalException;

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
	public ProductMediaSKU deleteProductMediaSKU(
		ProductMediaSKU productMediaSKU);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductMediaSKU fetchProductMediaSKU(long ProductMediaSKUId);

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductMediaSKU fetchProductMediaSKUByUuidAndGroupId(
		String uuid, long groupId);

	public List<ProductMediaSKU> findByProductMediaSkuId(
		long productMediaSkuId);

	public List<ProductMediaSKU> findByProductSkuId(long productSkuId);

	public List<ProductMediaSKU> findByProductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the product media sku with the primary key.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductMediaSKU getProductMediaSKU(long ProductMediaSKUId)
		throws PortalException;

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku
	 * @throws PortalException if a matching product media sku could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProductMediaSKU getProductMediaSKUByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductMediaSKU> getProductMediaSKUs(int start, int end);

	/**
	 * Returns all the product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @return the matching product media skus, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator);

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProductMediaSKUsCount();

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
	public ProductMediaSKU updateProductMediaSKU(
		ProductMediaSKU productMediaSKU);

}