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

package com.marketplace.product.mediasku.master.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.product.mediasku.master.model.ProductMediaSKU;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductMediaSKU. This utility wraps
 * <code>com.marketplace.product.mediasku.master.service.impl.ProductMediaSKULocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductMediaSKULocalService
 * @generated
 */
public class ProductMediaSKULocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.marketplace.product.mediasku.master.service.impl.ProductMediaSKULocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the product media sku to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was added
	 */
	public static ProductMediaSKU addProductMediaSKU(
		ProductMediaSKU productMediaSKU) {

		return getService().addProductMediaSKU(productMediaSKU);
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
	 * Creates a new product media sku with the primary key. Does not add the product media sku to the database.
	 *
	 * @param ProductMediaSKUId the primary key for the new product media sku
	 * @return the new product media sku
	 */
	public static ProductMediaSKU createProductMediaSKU(
		long ProductMediaSKUId) {

		return getService().createProductMediaSKU(ProductMediaSKUId);
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
	 * Deletes the product media sku with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku that was removed
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU deleteProductMediaSKU(long ProductMediaSKUId)
		throws PortalException {

		return getService().deleteProductMediaSKU(ProductMediaSKUId);
	}

	/**
	 * Deletes the product media sku from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was removed
	 */
	public static ProductMediaSKU deleteProductMediaSKU(
		ProductMediaSKU productMediaSKU) {

		return getService().deleteProductMediaSKU(productMediaSKU);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
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

	public static ProductMediaSKU fetchProductMediaSKU(long ProductMediaSKUId) {
		return getService().fetchProductMediaSKU(ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku, or <code>null</code> if a matching product media sku could not be found
	 */
	public static ProductMediaSKU fetchProductMediaSKUByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProductMediaSKUByUuidAndGroupId(uuid, groupId);
	}

	public static List<ProductMediaSKU> findByProductMediaSkuId(
		long productMediaSkuId) {

		return getService().findByProductMediaSkuId(productMediaSkuId);
	}

	public static List<ProductMediaSKU> findByProductSkuId(long productSkuId) {
		return getService().findByProductSkuId(productSkuId);
	}

	public static List<ProductMediaSKU> findByProductSKUIdWithDraftProductId(
		long draftProductId, long productSKUId) {

		return getService().findByProductSKUIdWithDraftProductId(
			draftProductId, productSKUId);
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
	 * Returns the product media sku with the primary key.
	 *
	 * @param ProductMediaSKUId the primary key of the product media sku
	 * @return the product media sku
	 * @throws PortalException if a product media sku with the primary key could not be found
	 */
	public static ProductMediaSKU getProductMediaSKU(long ProductMediaSKUId)
		throws PortalException {

		return getService().getProductMediaSKU(ProductMediaSKUId);
	}

	/**
	 * Returns the product media sku matching the UUID and group.
	 *
	 * @param uuid the product media sku's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product media sku
	 * @throws PortalException if a matching product media sku could not be found
	 */
	public static ProductMediaSKU getProductMediaSKUByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProductMediaSKUByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the product media skus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.product.mediasku.master.model.impl.ProductMediaSKUModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @return the range of product media skus
	 */
	public static List<ProductMediaSKU> getProductMediaSKUs(
		int start, int end) {

		return getService().getProductMediaSKUs(start, end);
	}

	/**
	 * Returns all the product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @return the matching product media skus, or an empty list if no matches were found
	 */
	public static List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProductMediaSKUsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of product media skus matching the UUID and company.
	 *
	 * @param uuid the UUID of the product media skus
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of product media skus
	 * @param end the upper bound of the range of product media skus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching product media skus, or an empty list if no matches were found
	 */
	public static List<ProductMediaSKU> getProductMediaSKUsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProductMediaSKU> orderByComparator) {

		return getService().getProductMediaSKUsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of product media skus.
	 *
	 * @return the number of product media skus
	 */
	public static int getProductMediaSKUsCount() {
		return getService().getProductMediaSKUsCount();
	}

	/**
	 * Updates the product media sku in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductMediaSKULocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productMediaSKU the product media sku
	 * @return the product media sku that was updated
	 */
	public static ProductMediaSKU updateProductMediaSKU(
		ProductMediaSKU productMediaSKU) {

		return getService().updateProductMediaSKU(productMediaSKU);
	}

	public static ProductMediaSKULocalService getService() {
		return _service;
	}

	private static volatile ProductMediaSKULocalService _service;

}