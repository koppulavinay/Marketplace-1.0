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

package com.marketplace.product.search.keywords.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductSearchKeywordsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywordsLocalService
 * @generated
 */
public class ProductSearchKeywordsLocalServiceWrapper
	implements ProductSearchKeywordsLocalService,
			   ServiceWrapper<ProductSearchKeywordsLocalService> {

	public ProductSearchKeywordsLocalServiceWrapper() {
		this(null);
	}

	public ProductSearchKeywordsLocalServiceWrapper(
		ProductSearchKeywordsLocalService productSearchKeywordsLocalService) {

		_productSearchKeywordsLocalService = productSearchKeywordsLocalService;
	}

	/**
	 * Adds the product search keywords to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was added
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		addProductSearchKeywords(
			com.marketplace.product.search.keywords.model.ProductSearchKeywords
				productSearchKeywords) {

		return _productSearchKeywordsLocalService.addProductSearchKeywords(
			productSearchKeywords);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		createProductSearchKeywords(long searchKeywordId) {

		return _productSearchKeywordsLocalService.createProductSearchKeywords(
			searchKeywordId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product search keywords with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords that was removed
	 * @throws PortalException if a product search keywords with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
			deleteProductSearchKeywords(long searchKeywordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.deleteProductSearchKeywords(
			searchKeywordId);
	}

	/**
	 * Deletes the product search keywords from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was removed
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		deleteProductSearchKeywords(
			com.marketplace.product.search.keywords.model.ProductSearchKeywords
				productSearchKeywords) {

		return _productSearchKeywordsLocalService.deleteProductSearchKeywords(
			productSearchKeywords);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productSearchKeywordsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productSearchKeywordsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSearchKeywordsLocalService.dynamicQuery();
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

		return _productSearchKeywordsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
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

		return _productSearchKeywordsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
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

		return _productSearchKeywordsLocalService.dynamicQuery(
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

		return _productSearchKeywordsLocalService.dynamicQueryCount(
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

		return _productSearchKeywordsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		fetchProductSearchKeywords(long searchKeywordId) {

		return _productSearchKeywordsLocalService.fetchProductSearchKeywords(
			searchKeywordId);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		fetchProductSearchKeywordsByUuidAndGroupId(String uuid, long groupId) {

		return _productSearchKeywordsLocalService.
			fetchProductSearchKeywordsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.product.search.keywords.model.ProductSearchKeywords>
			findByDraftProductId(long draftProductId) {

		return _productSearchKeywordsLocalService.findByDraftProductId(
			draftProductId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productSearchKeywordsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productSearchKeywordsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productSearchKeywordsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productSearchKeywordsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product search keywords with the primary key.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws PortalException if a product search keywords with the primary key could not be found
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
			getProductSearchKeywords(long searchKeywordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.getProductSearchKeywords(
			searchKeywordId);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords
	 * @throws PortalException if a matching product search keywords could not be found
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
			getProductSearchKeywordsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productSearchKeywordsLocalService.
			getProductSearchKeywordsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the product search keywordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.search.keywords.model.impl.ProductSearchKeywordsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @return the range of product search keywordses
	 */
	@Override
	public java.util.List
		<com.marketplace.product.search.keywords.model.ProductSearchKeywords>
			getProductSearchKeywordses(int start, int end) {

		return _productSearchKeywordsLocalService.getProductSearchKeywordses(
			start, end);
	}

	/**
	 * Returns all the product search keywordses matching the UUID and company.
	 *
	 * @param uuid the UUID of the product search keywordses
	 * @param companyId the primary key of the company
	 * @return the matching product search keywordses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.search.keywords.model.ProductSearchKeywords>
			getProductSearchKeywordsesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _productSearchKeywordsLocalService.
			getProductSearchKeywordsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of product search keywordses matching the UUID and company.
	 *
	 * @param uuid the UUID of the product search keywordses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product search keywordses
	 * @param end the upper bound of the range of product search keywordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product search keywordses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.product.search.keywords.model.ProductSearchKeywords>
			getProductSearchKeywordsesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.product.search.keywords.model.
						ProductSearchKeywords> orderByComparator) {

		return _productSearchKeywordsLocalService.
			getProductSearchKeywordsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
	 */
	@Override
	public int getProductSearchKeywordsesCount() {
		return _productSearchKeywordsLocalService.
			getProductSearchKeywordsesCount();
	}

	/**
	 * Updates the product search keywords in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductSearchKeywordsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productSearchKeywords the product search keywords
	 * @return the product search keywords that was updated
	 */
	@Override
	public com.marketplace.product.search.keywords.model.ProductSearchKeywords
		updateProductSearchKeywords(
			com.marketplace.product.search.keywords.model.ProductSearchKeywords
				productSearchKeywords) {

		return _productSearchKeywordsLocalService.updateProductSearchKeywords(
			productSearchKeywords);
	}

	@Override
	public ProductSearchKeywordsLocalService getWrappedService() {
		return _productSearchKeywordsLocalService;
	}

	@Override
	public void setWrappedService(
		ProductSearchKeywordsLocalService productSearchKeywordsLocalService) {

		_productSearchKeywordsLocalService = productSearchKeywordsLocalService;
	}

	private ProductSearchKeywordsLocalService
		_productSearchKeywordsLocalService;

}