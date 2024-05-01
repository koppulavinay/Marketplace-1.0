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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductMediaSKULocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKULocalService
 * @generated
 */
public class ProductMediaSKULocalServiceWrapper
	implements ProductMediaSKULocalService,
			   ServiceWrapper<ProductMediaSKULocalService> {

	public ProductMediaSKULocalServiceWrapper() {
		this(null);
	}

	public ProductMediaSKULocalServiceWrapper(
		ProductMediaSKULocalService productMediaSKULocalService) {

		_productMediaSKULocalService = productMediaSKULocalService;
	}

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
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		addProductMediaSKU(
			com.marketplace.product.mediasku.master.model.ProductMediaSKU
				productMediaSKU) {

		return _productMediaSKULocalService.addProductMediaSKU(productMediaSKU);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		createProductMediaSKU(long ProductMediaSKUId) {

		return _productMediaSKULocalService.createProductMediaSKU(
			ProductMediaSKUId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
			deleteProductMediaSKU(long ProductMediaSKUId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.deleteProductMediaSKU(
			ProductMediaSKUId);
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
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		deleteProductMediaSKU(
			com.marketplace.product.mediasku.master.model.ProductMediaSKU
				productMediaSKU) {

		return _productMediaSKULocalService.deleteProductMediaSKU(
			productMediaSKU);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productMediaSKULocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productMediaSKULocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productMediaSKULocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productMediaSKULocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productMediaSKULocalService.dynamicQuery(
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productMediaSKULocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productMediaSKULocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productMediaSKULocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		fetchProductMediaSKU(long ProductMediaSKUId) {

		return _productMediaSKULocalService.fetchProductMediaSKU(
			ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		fetchProductMediaSKUByUuidAndGroupId(String uuid, long groupId) {

		return _productMediaSKULocalService.
			fetchProductMediaSKUByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			findByProductMediaSkuId(long productMediaSkuId) {

		return _productMediaSKULocalService.findByProductMediaSkuId(
			productMediaSkuId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			findByProductSkuId(long productSkuId) {

		return _productMediaSKULocalService.findByProductSkuId(productSkuId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			findByProductSKUIdWithDraftProductId(
				long draftProductId, long productSKUId) {

		return _productMediaSKULocalService.
			findByProductSKUIdWithDraftProductId(draftProductId, productSKUId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productMediaSKULocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productMediaSKULocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productMediaSKULocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productMediaSKULocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product media sku with the primary key.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
			getProductMediaSKU(long ProductMediaSKUId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.getProductMediaSKU(
			ProductMediaSKUId);
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
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
			getProductMediaSKUByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productMediaSKULocalService.getProductMediaSKUByUuidAndGroupId(
			uuid, groupId);
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
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			getProductMediaSKUs(int start, int end) {

		return _productMediaSKULocalService.getProductMediaSKUs(start, end);
	}

	/**
	 * Returns all the product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @return the matching product media skus, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			getProductMediaSKUsByUuidAndCompanyId(String uuid, long companyId) {

		return _productMediaSKULocalService.
			getProductMediaSKUsByUuidAndCompanyId(uuid, companyId);
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
	public java.util.List
		<com.marketplace.product.mediasku.master.model.ProductMediaSKU>
			getProductMediaSKUsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.mediasku.master.model.
						ProductMediaSKU> orderByComparator) {

		return _productMediaSKULocalService.
			getProductMediaSKUsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	@Override
	public int getProductMediaSKUsCount() {
		return _productMediaSKULocalService.getProductMediaSKUsCount();
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
	@Override
	public com.marketplace.product.mediasku.master.model.ProductMediaSKU
		updateProductMediaSKU(
			com.marketplace.product.mediasku.master.model.ProductMediaSKU
				productMediaSKU) {

		return _productMediaSKULocalService.updateProductMediaSKU(
			productMediaSKU);
	}

	@Override
	public ProductMediaSKULocalService getWrappedService() {
		return _productMediaSKULocalService;
	}

	@Override
	public void setWrappedService(
		ProductMediaSKULocalService productMediaSKULocalService) {

		_productMediaSKULocalService = productMediaSKULocalService;
	}

	private ProductMediaSKULocalService _productMediaSKULocalService;

}