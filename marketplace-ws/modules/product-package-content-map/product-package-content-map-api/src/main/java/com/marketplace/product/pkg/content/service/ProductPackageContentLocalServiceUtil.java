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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.pkg.content.model.ProductPackageContent;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductPackageContent. This utility wraps
 * <code>com.marketplace.product.pkg.content.service.impl.ProductPackageContentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductPackageContentLocalService
 * @generated
 */
public class ProductPackageContentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.product.pkg.content.service.impl.ProductPackageContentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProductPackageContent addProductPackageContent(
		ProductPackageContent productPackageContent) {

		return getService().addProductPackageContent(productPackageContent);
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
	 * Creates a new product package content with the primary key. Does not add the product package content to the database.
	 *
	 * @param packageContentId the primary key for the new product package content
	 * @return the new product package content
	 */
	public static ProductPackageContent createProductPackageContent(
		long packageContentId) {

		return getService().createProductPackageContent(packageContentId);
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
	public static ProductPackageContent deleteProductPackageContent(
			long packageContentId)
		throws PortalException {

		return getService().deleteProductPackageContent(packageContentId);
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
	public static ProductPackageContent deleteProductPackageContent(
		ProductPackageContent productPackageContent) {

		return getService().deleteProductPackageContent(productPackageContent);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.pkg.content.model.impl.ProductPackageContentModelImpl</code>.
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

	public static ProductPackageContent fetchProductPackageContent(
		long packageContentId) {

		return getService().fetchProductPackageContent(packageContentId);
	}

	/**
	 * Returns the product package content matching the UUID and group.
	 *
	 * @param uuid the product package content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product package content, or <code>null</code> if a matching product package content could not be found
	 */
	public static ProductPackageContent
		fetchProductPackageContentByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProductPackageContentByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ProductPackageContent> findByDraftProductId(
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
	 * Returns the product package content with the primary key.
	 *
	 * @param packageContentId the primary key of the product package content
	 * @return the product package content
	 * @throws PortalException if a product package content with the primary key could not be found
	 */
	public static ProductPackageContent getProductPackageContent(
			long packageContentId)
		throws PortalException {

		return getService().getProductPackageContent(packageContentId);
	}

	/**
	 * Returns the product package content matching the UUID and group.
	 *
	 * @param uuid the product package content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product package content
	 * @throws PortalException if a matching product package content could not be found
	 */
	public static ProductPackageContent
			getProductPackageContentByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProductPackageContentByUuidAndGroupId(
			uuid, groupId);
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
	public static List<ProductPackageContent> getProductPackageContents(
		int start, int end) {

		return getService().getProductPackageContents(start, end);
	}

	/**
	 * Returns all the product package contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the product package contents
	 * @param companyId the primary key of the company
	 * @return the matching product package contents, or an empty list if no matches were found
	 */
	public static List<ProductPackageContent>
		getProductPackageContentsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProductPackageContentsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProductPackageContent>
		getProductPackageContentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProductPackageContent> orderByComparator) {

		return getService().getProductPackageContentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product package contents.
	 *
	 * @return the number of product package contents
	 */
	public static int getProductPackageContentsCount() {
		return getService().getProductPackageContentsCount();
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
	public static ProductPackageContent updateProductPackageContent(
		ProductPackageContent productPackageContent) {

		return getService().updateProductPackageContent(productPackageContent);
	}

	public static ProductPackageContentLocalService getService() {
		return _service;
	}

	private static volatile ProductPackageContentLocalService _service;

}