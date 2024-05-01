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

package com.marketplace.product.specifications.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductSpecificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationLocalService
 * @generated
 */
public class ProductSpecificationLocalServiceWrapper
	implements ProductSpecificationLocalService,
			   ServiceWrapper<ProductSpecificationLocalService> {

	public ProductSpecificationLocalServiceWrapper() {
		this(null);
	}

	public ProductSpecificationLocalServiceWrapper(
		ProductSpecificationLocalService productSpecificationLocalService) {

		_productSpecificationLocalService = productSpecificationLocalService;
	}

	/**
	 * Adds the product specification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecification the product specification
	 * @return the product specification that was added
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			addProductSpecification(
				com.marketplace.product.specifications.master.model.
					ProductSpecification productSpecification) {

		return _productSpecificationLocalService.addProductSpecification(
			productSpecification);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product specification with the primary key. Does not add the product specification to the database.
	 *
	 * @param productSpecificationId the primary key for the new product specification
	 * @return the new product specification
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			createProductSpecification(long productSpecificationId) {

		return _productSpecificationLocalService.createProductSpecification(
			productSpecificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product specification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification that was removed
	 * @throws PortalException if a product specification with the primary key could not be found
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
				deleteProductSpecification(long productSpecificationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.deleteProductSpecification(
			productSpecificationId);
	}

	/**
	 * Deletes the product specification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecification the product specification
	 * @return the product specification that was removed
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			deleteProductSpecification(
				com.marketplace.product.specifications.master.model.
					ProductSpecification productSpecification) {

		return _productSpecificationLocalService.deleteProductSpecification(
			productSpecification);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productSpecificationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productSpecificationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSpecificationLocalService.dynamicQuery();
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

		return _productSpecificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.specifications.master.model.impl.ProductSpecificationModelImpl</code>.
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

		return _productSpecificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.specifications.master.model.impl.ProductSpecificationModelImpl</code>.
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

		return _productSpecificationLocalService.dynamicQuery(
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

		return _productSpecificationLocalService.dynamicQueryCount(
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productSpecificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			fetchProductSpecification(long productSpecificationId) {

		return _productSpecificationLocalService.fetchProductSpecification(
			productSpecificationId);
	}

	/**
	 * Returns the product specification matching the UUID and group.
	 *
	 * @param uuid the product specification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product specification, or <code>null</code> if a matching product specification could not be found
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			fetchProductSpecificationByUuidAndGroupId(
				String uuid, long groupId) {

		return _productSpecificationLocalService.
			fetchProductSpecificationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.specifications.master.model.
			ProductSpecification> findByDraftProductId(long draftProductId) {

		return _productSpecificationLocalService.findByDraftProductId(
			draftProductId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productSpecificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productSpecificationLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productSpecificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productSpecificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product specification with the primary key.
	 *
	 * @param productSpecificationId the primary key of the product specification
	 * @return the product specification
	 * @throws PortalException if a product specification with the primary key could not be found
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
				getProductSpecification(long productSpecificationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.getProductSpecification(
			productSpecificationId);
	}

	/**
	 * Returns the product specification matching the UUID and group.
	 *
	 * @param uuid the product specification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product specification
	 * @throws PortalException if a matching product specification could not be found
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
				getProductSpecificationByUuidAndGroupId(
					String uuid, long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _productSpecificationLocalService.
			getProductSpecificationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the product specifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.specifications.master.model.impl.ProductSpecificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @return the range of product specifications
	 */
	@Override
	public java.util.List
		<com.marketplace.product.specifications.master.model.
			ProductSpecification> getProductSpecifications(int start, int end) {

		return _productSpecificationLocalService.getProductSpecifications(
			start, end);
	}

	/**
	 * Returns all the product specifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the product specifications
	 * @param companyId the primary key of the company
	 * @return the matching product specifications, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.specifications.master.model.
			ProductSpecification> getProductSpecificationsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _productSpecificationLocalService.
			getProductSpecificationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of product specifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the product specifications
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product specifications
	 * @param end the upper bound of the range of product specifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product specifications, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.specifications.master.model.
			ProductSpecification> getProductSpecificationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.specifications.master.model.
						ProductSpecification> orderByComparator) {

		return _productSpecificationLocalService.
			getProductSpecificationsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product specifications.
	 *
	 * @return the number of product specifications
	 */
	@Override
	public int getProductSpecificationsCount() {
		return _productSpecificationLocalService.
			getProductSpecificationsCount();
	}

	/**
	 * Updates the product specification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSpecificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSpecification the product specification
	 * @return the product specification that was updated
	 */
	@Override
	public
		com.marketplace.product.specifications.master.model.ProductSpecification
			updateProductSpecification(
				com.marketplace.product.specifications.master.model.
					ProductSpecification productSpecification) {

		return _productSpecificationLocalService.updateProductSpecification(
			productSpecification);
	}

	@Override
	public ProductSpecificationLocalService getWrappedService() {
		return _productSpecificationLocalService;
	}

	@Override
	public void setWrappedService(
		ProductSpecificationLocalService productSpecificationLocalService) {

		_productSpecificationLocalService = productSpecificationLocalService;
	}

	private ProductSpecificationLocalService _productSpecificationLocalService;

}