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

package com.marketplace.product.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalService
 * @generated
 */
public class ProductLocalServiceWrapper
	implements ProductLocalService, ServiceWrapper<ProductLocalService> {

	public ProductLocalServiceWrapper() {
		this(null);
	}

	public ProductLocalServiceWrapper(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	/**
	 * Adds the product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was added
	 */
	@Override
	public com.marketplace.product.master.model.Product addProduct(
		com.marketplace.product.master.model.Product product) {

		return _productLocalService.addProduct(product);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param draftProductId the primary key for the new product
	 * @return the new product
	 */
	@Override
	public com.marketplace.product.master.model.Product createProduct(
		long draftProductId) {

		return _productLocalService.createProduct(draftProductId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product that was removed
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.master.model.Product deleteProduct(
			long draftProductId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deleteProduct(draftProductId);
	}

	/**
	 * Deletes the product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was removed
	 */
	@Override
	public com.marketplace.product.master.model.Product deleteProduct(
		com.marketplace.product.master.model.Product product) {

		return _productLocalService.deleteProduct(product);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productLocalService.dynamicQuery();
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

		return _productLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.master.model.impl.ProductModelImpl</code>.
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

		return _productLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.master.model.impl.ProductModelImpl</code>.
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

		return _productLocalService.dynamicQuery(
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

		return _productLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.master.model.Product fetchProduct(
		long draftProductId) {

		return _productLocalService.fetchProduct(draftProductId);
	}

	/**
	 * Returns the product matching the UUID and group.
	 *
	 * @param uuid the product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	@Override
	public com.marketplace.product.master.model.Product
		fetchProductByUuidAndGroupId(String uuid, long groupId) {

		return _productLocalService.fetchProductByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.marketplace.product.master.model.Product findByCPDefinitionId(
			long cpDefinitionId)
		throws com.marketplace.product.master.exception.NoSuchProductException {

		return _productLocalService.findByCPDefinitionId(cpDefinitionId);
	}

	@Override
	public java.util.List<com.marketplace.product.master.model.Product>
		findByProductWithStatusById(
			String vendorId, long categoryId, String organizationId,
			String productStatus, int start, int end) {

		return _productLocalService.findByProductWithStatusById(
			vendorId, categoryId, organizationId, productStatus, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param draftProductId the primary key of the product
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.master.model.Product getProduct(
			long draftProductId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getProduct(draftProductId);
	}

	/**
	 * Returns the product matching the UUID and group.
	 *
	 * @param uuid the product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product
	 * @throws PortalException if a matching product could not be found
	 */
	@Override
	public com.marketplace.product.master.model.Product
			getProductByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.master.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 */
	@Override
	public java.util.List<com.marketplace.product.master.model.Product>
		getProducts(int start, int end) {

		return _productLocalService.getProducts(start, end);
	}

	/**
	 * Returns all the products matching the UUID and company.
	 *
	 * @param uuid the UUID of the products
	 * @param companyId the primary key of the company
	 * @return the matching products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.marketplace.product.master.model.Product>
		getProductsByUuidAndCompanyId(String uuid, long companyId) {

		return _productLocalService.getProductsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of products matching the UUID and company.
	 *
	 * @param uuid the UUID of the products
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.marketplace.product.master.model.Product>
		getProductsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.marketplace.product.master.model.Product>
					orderByComparator) {

		return _productLocalService.getProductsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	@Override
	public int getProductsCount() {
		return _productLocalService.getProductsCount();
	}

	/**
	 * Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was updated
	 */
	@Override
	public com.marketplace.product.master.model.Product updateProduct(
		com.marketplace.product.master.model.Product product) {

		return _productLocalService.updateProduct(product);
	}

	@Override
	public ProductLocalService getWrappedService() {
		return _productLocalService;
	}

	@Override
	public void setWrappedService(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	private ProductLocalService _productLocalService;

}