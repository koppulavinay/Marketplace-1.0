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

package com.marketplace.product.variant.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductVariantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductVariantLocalService
 * @generated
 */
public class ProductVariantLocalServiceWrapper
	implements ProductVariantLocalService,
			   ServiceWrapper<ProductVariantLocalService> {

	public ProductVariantLocalServiceWrapper() {
		this(null);
	}

	public ProductVariantLocalServiceWrapper(
		ProductVariantLocalService productVariantLocalService) {

		_productVariantLocalService = productVariantLocalService;
	}

	/**
	 * Adds the product variant to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductVariantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productVariant the product variant
	 * @return the product variant that was added
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		addProductVariant(
			com.marketplace.product.variant.master.model.ProductVariant
				productVariant) {

		return _productVariantLocalService.addProductVariant(productVariant);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product variant with the primary key. Does not add the product variant to the database.
	 *
	 * @param productVariantId the primary key for the new product variant
	 * @return the new product variant
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		createProductVariant(long productVariantId) {

		return _productVariantLocalService.createProductVariant(
			productVariantId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product variant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductVariantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant that was removed
	 * @throws PortalException if a product variant with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
			deleteProductVariant(long productVariantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.deleteProductVariant(
			productVariantId);
	}

	/**
	 * Deletes the product variant from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductVariantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productVariant the product variant
	 * @return the product variant that was removed
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		deleteProductVariant(
			com.marketplace.product.variant.master.model.ProductVariant
				productVariant) {

		return _productVariantLocalService.deleteProductVariant(productVariant);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productVariantLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productVariantLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productVariantLocalService.dynamicQuery();
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

		return _productVariantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.variant.master.model.impl.ProductVariantModelImpl</code>.
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

		return _productVariantLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.variant.master.model.impl.ProductVariantModelImpl</code>.
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

		return _productVariantLocalService.dynamicQuery(
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

		return _productVariantLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productVariantLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		fetchProductVariant(long productVariantId) {

		return _productVariantLocalService.fetchProductVariant(
			productVariantId);
	}

	/**
	 * Returns the product variant matching the UUID and group.
	 *
	 * @param uuid the product variant's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product variant, or <code>null</code> if a matching product variant could not be found
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		fetchProductVariantByUuidAndGroupId(String uuid, long groupId) {

		return _productVariantLocalService.fetchProductVariantByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.variant.master.model.ProductVariant>
			findByDraftProductId(long draftProductId) {

		return _productVariantLocalService.findByDraftProductId(draftProductId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.variant.master.model.ProductVariant>
			findByVariantNameID(long draftProductId, String variantName) {

		return _productVariantLocalService.findByVariantNameID(
			draftProductId, variantName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productVariantLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productVariantLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productVariantLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productVariantLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product variant with the primary key.
	 *
	 * @param productVariantId the primary key of the product variant
	 * @return the product variant
	 * @throws PortalException if a product variant with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
			getProductVariant(long productVariantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.getProductVariant(productVariantId);
	}

	/**
	 * Returns the product variant matching the UUID and group.
	 *
	 * @param uuid the product variant's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product variant
	 * @throws PortalException if a matching product variant could not be found
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
			getProductVariantByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productVariantLocalService.getProductVariantByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the product variants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.variant.master.model.impl.ProductVariantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @return the range of product variants
	 */
	@Override
	public java.util.List
		<com.marketplace.product.variant.master.model.ProductVariant>
			getProductVariants(int start, int end) {

		return _productVariantLocalService.getProductVariants(start, end);
	}

	/**
	 * Returns all the product variants matching the UUID and company.
	 *
	 * @param uuid the UUID of the product variants
	 * @param companyId the primary key of the company
	 * @return the matching product variants, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.variant.master.model.ProductVariant>
			getProductVariantsByUuidAndCompanyId(String uuid, long companyId) {

		return _productVariantLocalService.getProductVariantsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of product variants matching the UUID and company.
	 *
	 * @param uuid the UUID of the product variants
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product variants
	 * @param end the upper bound of the range of product variants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product variants, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.variant.master.model.ProductVariant>
			getProductVariantsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.variant.master.model.
						ProductVariant> orderByComparator) {

		return _productVariantLocalService.getProductVariantsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product variants.
	 *
	 * @return the number of product variants
	 */
	@Override
	public int getProductVariantsCount() {
		return _productVariantLocalService.getProductVariantsCount();
	}

	/**
	 * Updates the product variant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductVariantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productVariant the product variant
	 * @return the product variant that was updated
	 */
	@Override
	public com.marketplace.product.variant.master.model.ProductVariant
		updateProductVariant(
			com.marketplace.product.variant.master.model.ProductVariant
				productVariant) {

		return _productVariantLocalService.updateProductVariant(productVariant);
	}

	@Override
	public ProductVariantLocalService getWrappedService() {
		return _productVariantLocalService;
	}

	@Override
	public void setWrappedService(
		ProductVariantLocalService productVariantLocalService) {

		_productVariantLocalService = productVariantLocalService;
	}

	private ProductVariantLocalService _productVariantLocalService;

}