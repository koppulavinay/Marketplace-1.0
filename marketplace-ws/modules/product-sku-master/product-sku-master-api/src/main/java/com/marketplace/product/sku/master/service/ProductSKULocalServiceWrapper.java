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

package com.marketplace.product.sku.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductSKULocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKULocalService
 * @generated
 */
public class ProductSKULocalServiceWrapper
	implements ProductSKULocalService, ServiceWrapper<ProductSKULocalService> {

	public ProductSKULocalServiceWrapper() {
		this(null);
	}

	public ProductSKULocalServiceWrapper(
		ProductSKULocalService productSKULocalService) {

		_productSKULocalService = productSKULocalService;
	}

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
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU addProductSKU(
		com.marketplace.product.sku.master.model.ProductSKU productSKU) {

		return _productSKULocalService.addProductSKU(productSKU);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU createProductSKU(
		long productSKUId) {

		return _productSKULocalService.createProductSKU(productSKUId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU deleteProductSKU(
			long productSKUId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.deleteProductSKU(productSKUId);
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
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU deleteProductSKU(
		com.marketplace.product.sku.master.model.ProductSKU productSKU) {

		return _productSKULocalService.deleteProductSKU(productSKU);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productSKULocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productSKULocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSKULocalService.dynamicQuery();
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

		return _productSKULocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productSKULocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productSKULocalService.dynamicQuery(
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

		return _productSKULocalService.dynamicQueryCount(dynamicQuery);
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

		return _productSKULocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.sku.master.model.ProductSKU fetchProductSKU(
		long productSKUId) {

		return _productSKULocalService.fetchProductSKU(productSKUId);
	}

	/**
	 * Returns the product sku matching the UUID and group.
	 *
	 * @param uuid the product sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU
		fetchProductSKUByUuidAndGroupId(String uuid, long groupId) {

		return _productSKULocalService.fetchProductSKUByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.marketplace.product.sku.master.model.ProductSKU
			findByDraftProductIdNDefaultSKU(
				long draftProductId, String defaultSKU)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return _productSKULocalService.findByDraftProductIdNDefaultSKU(
			draftProductId, defaultSKU);
	}

	@Override
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		findByDraftProductIdNSkuName(long draftProductId, String skuName) {

		return _productSKULocalService.findByDraftProductIdNSkuName(
			draftProductId, skuName);
	}

	@Override
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		findByDraftProductNDefaultSKU(long draftProductId, String defaultSKU) {

		return _productSKULocalService.findByDraftProductNDefaultSKU(
			draftProductId, defaultSKU);
	}

	@Override
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		findByDraftProductSkuId(long draftProductId) {

		return _productSKULocalService.findByDraftProductSkuId(draftProductId);
	}

	@Override
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		findByDraftProductSkuId(long draftProductId, int start, int end) {

		return _productSKULocalService.findByDraftProductSkuId(
			draftProductId, start, end);
	}

	@Override
	public com.marketplace.product.sku.master.model.ProductSKU findBySkuId(
		String skuId) {

		return _productSKULocalService.findBySkuId(skuId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productSKULocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productSKULocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productSKULocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productSKULocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product sku with the primary key.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws PortalException if a product sku with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU getProductSKU(
			long productSKUId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.getProductSKU(productSKUId);
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
	public com.marketplace.product.sku.master.model.ProductSKU
			getProductSKUByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSKULocalService.getProductSKUByUuidAndGroupId(
			uuid, groupId);
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
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		getProductSKUs(int start, int end) {

		return _productSKULocalService.getProductSKUs(start, end);
	}

	/**
	 * Returns all the product skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product skus
	 * @param companyId the primary key of the company
	 * @return the matching product skus, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		getProductSKUsByUuidAndCompanyId(String uuid, long companyId) {

		return _productSKULocalService.getProductSKUsByUuidAndCompanyId(
			uuid, companyId);
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
	public java.util.List<com.marketplace.product.sku.master.model.ProductSKU>
		getProductSKUsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.marketplace.product.sku.master.model.ProductSKU>
					orderByComparator) {

		return _productSKULocalService.getProductSKUsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	@Override
	public int getProductSKUsCount() {
		return _productSKULocalService.getProductSKUsCount();
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
	@Override
	public com.marketplace.product.sku.master.model.ProductSKU updateProductSKU(
		com.marketplace.product.sku.master.model.ProductSKU productSKU) {

		return _productSKULocalService.updateProductSKU(productSKU);
	}

	@Override
	public ProductSKULocalService getWrappedService() {
		return _productSKULocalService;
	}

	@Override
	public void setWrappedService(
		ProductSKULocalService productSKULocalService) {

		_productSKULocalService = productSKULocalService;
	}

	private ProductSKULocalService _productSKULocalService;

}