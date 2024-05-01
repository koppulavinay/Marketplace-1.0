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

package com.marketplace.product.pkg.content.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductPackageContentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContentLocalService
 * @generated
 */
public class ProductPackageContentLocalServiceWrapper
	implements ProductPackageContentLocalService,
			   ServiceWrapper<ProductPackageContentLocalService> {

	public ProductPackageContentLocalServiceWrapper() {
		this(null);
	}

	public ProductPackageContentLocalServiceWrapper(
		ProductPackageContentLocalService productPackageContentLocalService) {

		_productPackageContentLocalService = productPackageContentLocalService;
	}

	/**
	 * Adds the product package content to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductPackageContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productPackageContent the product package content
	 * @return the product package content that was added
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		addProductPackageContent(
			com.marketplace.product.pkg.content.model.ProductPackageContent
				productPackageContent) {

		return _productPackageContentLocalService.addProductPackageContent(
			productPackageContent);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product package content with the primary key. Does not add the product package content to the database.
	 *
	 * @param packageContentId the primary key for the new product package content
	 * @return the new product package content
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		createProductPackageContent(long packageContentId) {

		return _productPackageContentLocalService.createProductPackageContent(
			packageContentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product package content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductPackageContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content that was removed
	 * @throws PortalException if a product package content with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
			deleteProductPackageContent(long packageContentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.deleteProductPackageContent(
			packageContentId);
	}

	/**
	 * Deletes the product package content from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductPackageContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productPackageContent the product package content
	 * @return the product package content that was removed
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		deleteProductPackageContent(
			com.marketplace.product.pkg.content.model.ProductPackageContent
				productPackageContent) {

		return _productPackageContentLocalService.deleteProductPackageContent(
			productPackageContent);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productPackageContentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productPackageContentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productPackageContentLocalService.dynamicQuery();
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

		return _productPackageContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl</code>.
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

		return _productPackageContentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl</code>.
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

		return _productPackageContentLocalService.dynamicQuery(
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

		return _productPackageContentLocalService.dynamicQueryCount(
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

		return _productPackageContentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		fetchProductPackageContent(long packageContentId) {

		return _productPackageContentLocalService.fetchProductPackageContent(
			packageContentId);
	}

	/**
	 * Returns the product package content matching the UUID and group.
	 *
	 * @param uuid the product package content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		fetchProductPackageContentByUuidAndGroupId(String uuid, long groupId) {

		return _productPackageContentLocalService.
			fetchProductPackageContentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.pkg.content.model.ProductPackageContent>
			findByDraftProductId(long draftProductId) {

		return _productPackageContentLocalService.findByDraftProductId(
			draftProductId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productPackageContentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productPackageContentLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productPackageContentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productPackageContentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product package content with the primary key.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content
	 * @throws PortalException if a product package content with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
			getProductPackageContent(long packageContentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.getProductPackageContent(
			packageContentId);
	}

	/**
	 * Returns the product package content matching the UUID and group.
	 *
	 * @param uuid the product package content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product package content
	 * @throws PortalException if a matching product package content could not be found
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
			getProductPackageContentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productPackageContentLocalService.
			getProductPackageContentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the product package contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @return the range of product package contents
	 */
	@Override
	public java.util.List
		<com.marketplace.product.pkg.content.model.ProductPackageContent>
			getProductPackageContents(int start, int end) {

		return _productPackageContentLocalService.getProductPackageContents(
			start, end);
	}

	/**
	 * Returns all the product package contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the product package contents
	 * @param companyId the primary key of the company
	 * @return the matching product package contents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.pkg.content.model.ProductPackageContent>
			getProductPackageContentsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _productPackageContentLocalService.
			getProductPackageContentsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of product package contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the product package contents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product package contents
	 * @param end the upper bound of the range of product package contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product package contents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.pkg.content.model.ProductPackageContent>
			getProductPackageContentsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.pkg.content.model.
						ProductPackageContent> orderByComparator) {

		return _productPackageContentLocalService.
			getProductPackageContentsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product package contents.
	 *
	 * @return the number of product package contents
	 */
	@Override
	public int getProductPackageContentsCount() {
		return _productPackageContentLocalService.
			getProductPackageContentsCount();
	}

	/**
	 * Updates the product package content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductPackageContentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productPackageContent the product package content
	 * @return the product package content that was updated
	 */
	@Override
	public com.marketplace.product.pkg.content.model.ProductPackageContent
		updateProductPackageContent(
			com.marketplace.product.pkg.content.model.ProductPackageContent
				productPackageContent) {

		return _productPackageContentLocalService.updateProductPackageContent(
			productPackageContent);
	}

	@Override
	public ProductPackageContentLocalService getWrappedService() {
		return _productPackageContentLocalService;
	}

	@Override
	public void setWrappedService(
		ProductPackageContentLocalService productPackageContentLocalService) {

		_productPackageContentLocalService = productPackageContentLocalService;
	}

	private ProductPackageContentLocalService
		_productPackageContentLocalService;

}