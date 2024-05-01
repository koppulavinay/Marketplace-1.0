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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.sku.master.model.ProductSKU;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductSKU. This utility wraps
 * <code>com.marketplace.product.sku.master.service.impl.ProductSKULocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductSKULocalService
 * @generated
 */
public class ProductSKULocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.product.sku.master.service.impl.ProductSKULocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProductSKU addProductSKU(ProductSKU productSKU) {
		return getService().addProductSKU(productSKU);
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
	 * Creates a new product sku with the primary key. Does not add the product sku to the database.
	 *
	 * @param productSKUId the primary key for the new product sku
	 * @return the new product sku
	 */
	public static ProductSKU createProductSKU(long productSKUId) {
		return getService().createProductSKU(productSKUId);
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
	public static ProductSKU deleteProductSKU(long productSKUId)
		throws PortalException {

		return getService().deleteProductSKU(productSKUId);
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
	public static ProductSKU deleteProductSKU(ProductSKU productSKU) {
		return getService().deleteProductSKU(productSKU);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.sku.master.model.impl.ProductSKUModelImpl</code>.
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

	public static ProductSKU fetchProductSKU(long productSKUId) {
		return getService().fetchProductSKU(productSKUId);
	}

	/**
	 * Returns the product sku matching the UUID and group.
	 *
	 * @param uuid the product sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product sku, or <code>null</code> if a matching product sku could not be found
	 */
	public static ProductSKU fetchProductSKUByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProductSKUByUuidAndGroupId(uuid, groupId);
	}

	public static ProductSKU findByDraftProductIdNDefaultSKU(
			long draftProductId, String defaultSKU)
		throws com.marketplace.product.sku.master.exception.
			NoSuchProductSKUException {

		return getService().findByDraftProductIdNDefaultSKU(
			draftProductId, defaultSKU);
	}

	public static List<ProductSKU> findByDraftProductIdNSkuName(
		long draftProductId, String skuName) {

		return getService().findByDraftProductIdNSkuName(
			draftProductId, skuName);
	}

	public static List<ProductSKU> findByDraftProductNDefaultSKU(
		long draftProductId, String defaultSKU) {

		return getService().findByDraftProductNDefaultSKU(
			draftProductId, defaultSKU);
	}

	public static List<ProductSKU> findByDraftProductSkuId(
		long draftProductId) {

		return getService().findByDraftProductSkuId(draftProductId);
	}

	public static List<ProductSKU> findByDraftProductSkuId(
		long draftProductId, int start, int end) {

		return getService().findByDraftProductSkuId(draftProductId, start, end);
	}

	public static ProductSKU findBySkuId(String skuId) {
		return getService().findBySkuId(skuId);
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
	 * Returns the product sku with the primary key.
	 *
	 * @param productSKUId the primary key of the product sku
	 * @return the product sku
	 * @throws PortalException if a product sku with the primary key could not be found
	 */
	public static ProductSKU getProductSKU(long productSKUId)
		throws PortalException {

		return getService().getProductSKU(productSKUId);
	}

	/**
	 * Returns the product sku matching the UUID and group.
	 *
	 * @param uuid the product sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product sku
	 * @throws PortalException if a matching product sku could not be found
	 */
	public static ProductSKU getProductSKUByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProductSKUByUuidAndGroupId(uuid, groupId);
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
	public static List<ProductSKU> getProductSKUs(int start, int end) {
		return getService().getProductSKUs(start, end);
	}

	/**
	 * Returns all the product skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product skus
	 * @param companyId the primary key of the company
	 * @return the matching product skus, or an empty list if no matches were found
	 */
	public static List<ProductSKU> getProductSKUsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProductSKUsByUuidAndCompanyId(uuid, companyId);
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
	public static List<ProductSKU> getProductSKUsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductSKU> orderByComparator) {

		return getService().getProductSKUsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product skus.
	 *
	 * @return the number of product skus
	 */
	public static int getProductSKUsCount() {
		return getService().getProductSKUsCount();
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
	public static ProductSKU updateProductSKU(ProductSKU productSKU) {
		return getService().updateProductSKU(productSKU);
	}

	public static ProductSKULocalService getService() {
		return _service;
	}

	private static volatile ProductSKULocalService _service;

}