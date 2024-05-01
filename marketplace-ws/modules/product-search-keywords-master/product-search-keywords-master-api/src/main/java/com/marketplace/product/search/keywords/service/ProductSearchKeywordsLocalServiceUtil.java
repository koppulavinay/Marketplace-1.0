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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.search.keywords.model.ProductSearchKeywords;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductSearchKeywords. This utility wraps
 * <code>com.marketplace.product.search.keywords.service.impl.ProductSearchKeywordsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSearchKeywordsLocalService
 * @generated
 */
public class ProductSearchKeywordsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.product.search.keywords.service.impl.ProductSearchKeywordsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProductSearchKeywords addProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		return getService().addProductSearchKeywords(productSearchKeywords);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product search keywords with the primary key. Does not add the product search keywords to the database.
	 *
	 * @param searchKeywordId the primary key for the new product search keywords
	 * @return the new product search keywords
	 */
	public static ProductSearchKeywords createProductSearchKeywords(
		long searchKeywordId) {

		return getService().createProductSearchKeywords(searchKeywordId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProductSearchKeywords deleteProductSearchKeywords(
			long searchKeywordId)
		throws PortalException {

		return getService().deleteProductSearchKeywords(searchKeywordId);
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
	public static ProductSearchKeywords deleteProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		return getService().deleteProductSearchKeywords(productSearchKeywords);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProductSearchKeywords fetchProductSearchKeywords(
		long searchKeywordId) {

		return getService().fetchProductSearchKeywords(searchKeywordId);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords, or <code>null</code> if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords
		fetchProductSearchKeywordsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProductSearchKeywordsByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ProductSearchKeywords> findByDraftProductId(
		long draftProductId) {

		return getService().findByDraftProductId(draftProductId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product search keywords with the primary key.
	 *
	 * @param searchKeywordId the primary key of the product search keywords
	 * @return the product search keywords
	 * @throws PortalException if a product search keywords with the primary key could not be found
	 */
	public static ProductSearchKeywords getProductSearchKeywords(
			long searchKeywordId)
		throws PortalException {

		return getService().getProductSearchKeywords(searchKeywordId);
	}

	/**
	 * Returns the product search keywords matching the UUID and group.
	 *
	 * @param uuid the product search keywords's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product search keywords
	 * @throws PortalException if a matching product search keywords could not be found
	 */
	public static ProductSearchKeywords
			getProductSearchKeywordsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProductSearchKeywordsByUuidAndGroupId(
			uuid, groupId);
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
	public static List<ProductSearchKeywords> getProductSearchKeywordses(
		int start, int end) {

		return getService().getProductSearchKeywordses(start, end);
	}

	/**
	 * Returns all the product search keywordses matching the UUID and company.
	 *
	 * @param uuid the UUID of the product search keywordses
	 * @param companyId the primary key of the company
	 * @return the matching product search keywordses, or an empty list if no matches were found
	 */
	public static List<ProductSearchKeywords>
		getProductSearchKeywordsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProductSearchKeywordsesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProductSearchKeywords>
		getProductSearchKeywordsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProductSearchKeywords> orderByComparator) {

		return getService().getProductSearchKeywordsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product search keywordses.
	 *
	 * @return the number of product search keywordses
	 */
	public static int getProductSearchKeywordsesCount() {
		return getService().getProductSearchKeywordsesCount();
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
	public static ProductSearchKeywords updateProductSearchKeywords(
		ProductSearchKeywords productSearchKeywords) {

		return getService().updateProductSearchKeywords(productSearchKeywords);
	}

	public static ProductSearchKeywordsLocalService getService() {
		return _service;
	}

	private static volatile ProductSearchKeywordsLocalService _service;

}