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

package com.marketplace.variant.values.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VariantValueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VariantValueLocalService
 * @generated
 */
public class VariantValueLocalServiceWrapper
	implements ServiceWrapper<VariantValueLocalService>,
			   VariantValueLocalService {

	public VariantValueLocalServiceWrapper() {
		this(null);
	}

	public VariantValueLocalServiceWrapper(
		VariantValueLocalService variantValueLocalService) {

		_variantValueLocalService = variantValueLocalService;
	}

	/**
	 * Adds the variant value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was added
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		addVariantValue(
			com.marketplace.variant.values.master.model.VariantValue
				variantValue) {

		return _variantValueLocalService.addVariantValue(variantValue);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new variant value with the primary key. Does not add the variant value to the database.
	 *
	 * @param variantValueId the primary key for the new variant value
	 * @return the new variant value
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		createVariantValue(long variantValueId) {

		return _variantValueLocalService.createVariantValue(variantValueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the variant value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value that was removed
	 * @throws PortalException if a variant value with the primary key could not be found
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
			deleteVariantValue(long variantValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.deleteVariantValue(variantValueId);
	}

	/**
	 * Deletes the variant value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was removed
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		deleteVariantValue(
			com.marketplace.variant.values.master.model.VariantValue
				variantValue) {

		return _variantValueLocalService.deleteVariantValue(variantValue);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _variantValueLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _variantValueLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _variantValueLocalService.dynamicQuery();
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

		return _variantValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
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

		return _variantValueLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
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

		return _variantValueLocalService.dynamicQuery(
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

		return _variantValueLocalService.dynamicQueryCount(dynamicQuery);
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

		return _variantValueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		fetchVariantValue(long variantValueId) {

		return _variantValueLocalService.fetchVariantValue(variantValueId);
	}

	/**
	 * Returns the variant value matching the UUID and group.
	 *
	 * @param uuid the variant value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching variant value, or <code>null</code> if a matching variant value could not be found
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		fetchVariantValueByUuidAndGroupId(String uuid, long groupId) {

		return _variantValueLocalService.fetchVariantValueByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List
		<com.marketplace.variant.values.master.model.VariantValue>
			findByProductVariantId(long productVariantId) {

		return _variantValueLocalService.findByProductVariantId(
			productVariantId);
	}

	@Override
	public java.util.List
		<com.marketplace.variant.values.master.model.VariantValue>
			findByValueAndId(long draftProductId, String variantVal) {

		return _variantValueLocalService.findByValueAndId(
			draftProductId, variantVal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _variantValueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _variantValueLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _variantValueLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _variantValueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the variant value with the primary key.
	 *
	 * @param variantValueId the primary key of the variant value
	 * @return the variant value
	 * @throws PortalException if a variant value with the primary key could not be found
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
			getVariantValue(long variantValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.getVariantValue(variantValueId);
	}

	/**
	 * Returns the variant value matching the UUID and group.
	 *
	 * @param uuid the variant value's UUID
	 * @param groupId the primary key of the group
	 * @return the matching variant value
	 * @throws PortalException if a matching variant value could not be found
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
			getVariantValueByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variantValueLocalService.getVariantValueByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the variant values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.variant.values.master.model.impl.VariantValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @return the range of variant values
	 */
	@Override
	public java.util.List
		<com.marketplace.variant.values.master.model.VariantValue>
			getVariantValues(int start, int end) {

		return _variantValueLocalService.getVariantValues(start, end);
	}

	/**
	 * Returns all the variant values matching the UUID and company.
	 *
	 * @param uuid the UUID of the variant values
	 * @param companyId the primary key of the company
	 * @return the matching variant values, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.variant.values.master.model.VariantValue>
			getVariantValuesByUuidAndCompanyId(String uuid, long companyId) {

		return _variantValueLocalService.getVariantValuesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of variant values matching the UUID and company.
	 *
	 * @param uuid the UUID of the variant values
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of variant values
	 * @param end the upper bound of the range of variant values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching variant values, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.marketplace.variant.values.master.model.VariantValue>
			getVariantValuesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.marketplace.variant.values.master.model.VariantValue>
						orderByComparator) {

		return _variantValueLocalService.getVariantValuesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of variant values.
	 *
	 * @return the number of variant values
	 */
	@Override
	public int getVariantValuesCount() {
		return _variantValueLocalService.getVariantValuesCount();
	}

	/**
	 * Updates the variant value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VariantValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param variantValue the variant value
	 * @return the variant value that was updated
	 */
	@Override
	public com.marketplace.variant.values.master.model.VariantValue
		updateVariantValue(
			com.marketplace.variant.values.master.model.VariantValue
				variantValue) {

		return _variantValueLocalService.updateVariantValue(variantValue);
	}

	@Override
	public VariantValueLocalService getWrappedService() {
		return _variantValueLocalService;
	}

	@Override
	public void setWrappedService(
		VariantValueLocalService variantValueLocalService) {

		_variantValueLocalService = variantValueLocalService;
	}

	private VariantValueLocalService _variantValueLocalService;

}