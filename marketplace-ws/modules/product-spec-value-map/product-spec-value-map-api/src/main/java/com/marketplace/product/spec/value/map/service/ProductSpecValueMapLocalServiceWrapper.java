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

package com.marketplace.product.spec.value.map.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductSpecValueMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecValueMapLocalService
 * @generated
 */
public class ProductSpecValueMapLocalServiceWrapper
	implements ProductSpecValueMapLocalService,
			   ServiceWrapper<ProductSpecValueMapLocalService> {

	public ProductSpecValueMapLocalServiceWrapper() {
		this(null);
	}

	public ProductSpecValueMapLocalServiceWrapper(
		ProductSpecValueMapLocalService productSpecValueMapLocalService) {

		_productSpecValueMapLocalService = productSpecValueMapLocalService;
	}

	/**
	 * Adds the product spec value map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecValueMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecValueMap the product spec value map
	 * @return the product spec value map that was added
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		addProductSpecValueMap(
			com.marketplace.product.spec.value.map.model.ProductSpecValueMap
				productSpecValueMap) {

		return _productSpecValueMapLocalService.addProductSpecValueMap(
			productSpecValueMap);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product spec value map with the primary key. Does not add the product spec value map to the database.
	 *
	 * @param productSpecValueId the primary key for the new product spec value map
	 * @return the new product spec value map
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		createProductSpecValueMap(long productSpecValueId) {

		return _productSpecValueMapLocalService.createProductSpecValueMap(
			productSpecValueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product spec value map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecValueMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map that was removed
	 * @throws PortalException if a product spec value map with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
			deleteProductSpecValueMap(long productSpecValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.deleteProductSpecValueMap(
			productSpecValueId);
	}

	/**
	 * Deletes the product spec value map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecValueMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecValueMap the product spec value map
	 * @return the product spec value map that was removed
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		deleteProductSpecValueMap(
			com.marketplace.product.spec.value.map.model.ProductSpecValueMap
				productSpecValueMap) {

		return _productSpecValueMapLocalService.deleteProductSpecValueMap(
			productSpecValueMap);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productSpecValueMapLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productSpecValueMapLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSpecValueMapLocalService.dynamicQuery();
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

		return _productSpecValueMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapModelImpl</code>.
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

		return _productSpecValueMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapModelImpl</code>.
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

		return _productSpecValueMapLocalService.dynamicQuery(
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

		return _productSpecValueMapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productSpecValueMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		fetchProductSpecValueMap(long productSpecValueId) {

		return _productSpecValueMapLocalService.fetchProductSpecValueMap(
			productSpecValueId);
	}

	/**
	 * Returns the product spec value map matching the UUID and group.
	 *
	 * @param uuid the product spec value map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product spec value map, or <code>null</code> if a matching product spec value map could not be found
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		fetchProductSpecValueMapByUuidAndGroupId(String uuid, long groupId) {

		return _productSpecValueMapLocalService.
			fetchProductSpecValueMapByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
			findByProductSpecIdNSpecValueId(
				long productSpecificationId, long specificationValueId)
		throws com.marketplace.product.spec.value.map.exception.
			NoSuchProductSpecValueMapException {

		return _productSpecValueMapLocalService.findByProductSpecIdNSpecValueId(
			productSpecificationId, specificationValueId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.spec.value.map.model.ProductSpecValueMap>
			findByProductSpecificationId(long productSpecificationId) {

		return _productSpecValueMapLocalService.findByProductSpecificationId(
			productSpecificationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productSpecValueMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productSpecValueMapLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productSpecValueMapLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productSpecValueMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product spec value map with the primary key.
	 *
	 * @param productSpecValueId the primary key of the product spec value map
	 * @return the product spec value map
	 * @throws PortalException if a product spec value map with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
			getProductSpecValueMap(long productSpecValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.getProductSpecValueMap(
			productSpecValueId);
	}

	/**
	 * Returns the product spec value map matching the UUID and group.
	 *
	 * @param uuid the product spec value map's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product spec value map
	 * @throws PortalException if a matching product spec value map could not be found
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
			getProductSpecValueMapByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecValueMapLocalService.
			getProductSpecValueMapByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the product spec value maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.spec.value.map.model.impl.ProductSpecValueMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @return the range of product spec value maps
	 */
	@Override
	public java.util.List
		<com.marketplace.product.spec.value.map.model.ProductSpecValueMap>
			getProductSpecValueMaps(int start, int end) {

		return _productSpecValueMapLocalService.getProductSpecValueMaps(
			start, end);
	}

	/**
	 * Returns all the product spec value maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the product spec value maps
	 * @param companyId the primary key of the company
	 * @return the matching product spec value maps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.spec.value.map.model.ProductSpecValueMap>
			getProductSpecValueMapsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _productSpecValueMapLocalService.
			getProductSpecValueMapsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of product spec value maps matching the UUID and company.
	 *
	 * @param uuid the UUID of the product spec value maps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product spec value maps
	 * @param end the upper bound of the range of product spec value maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product spec value maps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.spec.value.map.model.ProductSpecValueMap>
			getProductSpecValueMapsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.spec.value.map.model.
						ProductSpecValueMap> orderByComparator) {

		return _productSpecValueMapLocalService.
			getProductSpecValueMapsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product spec value maps.
	 *
	 * @return the number of product spec value maps
	 */
	@Override
	public int getProductSpecValueMapsCount() {
		return _productSpecValueMapLocalService.getProductSpecValueMapsCount();
	}

	/**
	 * Updates the product spec value map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecValueMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecValueMap the product spec value map
	 * @return the product spec value map that was updated
	 */
	@Override
	public com.marketplace.product.spec.value.map.model.ProductSpecValueMap
		updateProductSpecValueMap(
			com.marketplace.product.spec.value.map.model.ProductSpecValueMap
				productSpecValueMap) {

		return _productSpecValueMapLocalService.updateProductSpecValueMap(
			productSpecValueMap);
	}

	@Override
	public ProductSpecValueMapLocalService getWrappedService() {
		return _productSpecValueMapLocalService;
	}

	@Override
	public void setWrappedService(
		ProductSpecValueMapLocalService productSpecValueMapLocalService) {

		_productSpecValueMapLocalService = productSpecValueMapLocalService;
	}

	private ProductSpecValueMapLocalService _productSpecValueMapLocalService;

}