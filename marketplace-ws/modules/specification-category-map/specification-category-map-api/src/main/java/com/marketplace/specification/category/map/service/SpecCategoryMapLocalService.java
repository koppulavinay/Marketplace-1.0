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

package com.marketplace.specification.category.map.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.marketplace.specification.category.map.exception.NoSuchSpecCategoryMapException;
import com.marketplace.specification.category.map.model.SpecCategoryMap;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SpecCategoryMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SpecCategoryMapLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SpecCategoryMapLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.marketplace.specification.category.map.service.impl.SpecCategoryMapLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the spec category map local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SpecCategoryMapLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the spec category map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SpecCategoryMap addSpecCategoryMap(SpecCategoryMap specCategoryMap);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new spec category map with the primary key. Does not add the spec category map to the database.
	 *
	 * @param specCategoryMapId the primary key for the new spec category map
	 * @return the new spec category map
	 */
	@Transactional(enabled = false)
	public SpecCategoryMap createSpecCategoryMap(long specCategoryMapId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the spec category map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map that was removed
	 * @throws PortalException if a spec category map with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SpecCategoryMap deleteSpecCategoryMap(long specCategoryMapId)
		throws PortalException;

	/**
	 * Deletes the spec category map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SpecCategoryMap deleteSpecCategoryMap(
		SpecCategoryMap specCategoryMap);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SpecCategoryMap fetchSpecCategoryMap(long specCategoryMapId);

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map, or <code>null</code> if a matching spec category map could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SpecCategoryMap fetchSpecCategoryMapByUuidAndCompanyId(
		String uuid, long companyId);

	public List<SpecCategoryMap> findByCategoryId(long categoryId);

	public List<SpecCategoryMap> findByCategoryId(
		long categoryId, int start, int end);

	public List<SpecCategoryMap> findByFBYSpecificationId(long specificationId);

	public SpecCategoryMap findBySpecificationIdNCategoryId(
			long specificationId, long categoryId)
		throws NoSuchSpecCategoryMapException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the spec category map with the primary key.
	 *
	 * @param specCategoryMapId the primary key of the spec category map
	 * @return the spec category map
	 * @throws PortalException if a spec category map with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SpecCategoryMap getSpecCategoryMap(long specCategoryMapId)
		throws PortalException;

	/**
	 * Returns the spec category map with the matching UUID and company.
	 *
	 * @param uuid the spec category map's UUID
	 * @param companyId the primary key of the company
	 * @return the matching spec category map
	 * @throws PortalException if a matching spec category map could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SpecCategoryMap getSpecCategoryMapByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the spec category maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.marketplace.specification.category.map.model.impl.SpecCategoryMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of spec category maps
	 * @param end the upper bound of the range of spec category maps (not inclusive)
	 * @return the range of spec category maps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SpecCategoryMap> getSpecCategoryMaps(int start, int end);

	/**
	 * Returns the number of spec category maps.
	 *
	 * @return the number of spec category maps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSpecCategoryMapsCount();

	/**
	 * Updates the spec category map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecCategoryMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specCategoryMap the spec category map
	 * @return the spec category map that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SpecCategoryMap updateSpecCategoryMap(
		SpecCategoryMap specCategoryMap);

}