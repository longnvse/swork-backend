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

package com.swork.core.resource.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ResourceEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntryLocalService
 * @generated
 */
public class ResourceEntryLocalServiceWrapper
	implements ResourceEntryLocalService,
			   ServiceWrapper<ResourceEntryLocalService> {

	public ResourceEntryLocalServiceWrapper(
		ResourceEntryLocalService resourceEntryLocalService) {

		_resourceEntryLocalService = resourceEntryLocalService;
	}

	@Override
	public com.swork.core.resource.service.model.ResourceEntry addResourceEntry(
		long businessId, long creatorId, Long workId, Long phaseId,
		Long projectId,
		com.swork.core.resource.service.mapper.model.ResourceMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _resourceEntryLocalService.addResourceEntry(
			businessId, creatorId, workId, phaseId, projectId, model,
			serviceContext);
	}

	/**
	 * Adds the resource entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was added
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry addResourceEntry(
		com.swork.core.resource.service.model.ResourceEntry resourceEntry) {

		return _resourceEntryLocalService.addResourceEntry(resourceEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		createResourceEntry(long resourceId) {

		return _resourceEntryLocalService.createResourceEntry(resourceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the resource entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry that was removed
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
			deleteResourceEntry(long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.deleteResourceEntry(resourceId);
	}

	/**
	 * Deletes the resource entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was removed
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		deleteResourceEntry(
			com.swork.core.resource.service.model.ResourceEntry resourceEntry) {

		return _resourceEntryLocalService.deleteResourceEntry(resourceEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _resourceEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _resourceEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceEntryLocalService.dynamicQuery();
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

		return _resourceEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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

		return _resourceEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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

		return _resourceEntryLocalService.dynamicQuery(
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

		return _resourceEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _resourceEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		fetchResourceEntry(long resourceId) {

		return _resourceEntryLocalService.fetchResourceEntry(resourceId);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		fetchResourceEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _resourceEntryLocalService.
			fetchResourceEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		fetchResourceEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _resourceEntryLocalService.fetchResourceEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		fetchResourceEntryByUuidAndGroupId(String uuid, long groupId) {

		return _resourceEntryLocalService.fetchResourceEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _resourceEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getByObjectGroupId(long businessId, long teamId) {

		return _resourceEntryLocalService.getByObjectGroupId(
			businessId, teamId);
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getByParentId(
			long businessId, long workId, long phaseId, long projectId) {

		return _resourceEntryLocalService.getByParentId(
			businessId, workId, phaseId, projectId);
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getByPhaseId(long businessId, long phaseId) {

		return _resourceEntryLocalService.getByPhaseId(businessId, phaseId);
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getByProjectId(long businessId, long projectId) {

		return _resourceEntryLocalService.getByProjectId(businessId, projectId);
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getByTaskId(long businessId, long workId) {

		return _resourceEntryLocalService.getByTaskId(businessId, workId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _resourceEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _resourceEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _resourceEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of resource entries
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getResourceEntries(int start, int end) {

		return _resourceEntryLocalService.getResourceEntries(start, end);
	}

	/**
	 * Returns all the resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @return the matching resource entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getResourceEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _resourceEntryLocalService.getResourceEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.ResourceEntry>
		getResourceEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.core.resource.service.model.ResourceEntry>
					orderByComparator) {

		return _resourceEntryLocalService.getResourceEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	@Override
	public int getResourceEntriesCount() {
		return _resourceEntryLocalService.getResourceEntriesCount();
	}

	/**
	 * Returns the resource entry with the primary key.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry getResourceEntry(
			long resourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.getResourceEntry(resourceId);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
			getResourceEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.
			getResourceEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
			getResourceEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceEntryLocalService.getResourceEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		updateResourceEntry(
			long creatorId, long resourceId,
			com.swork.core.resource.service.mapper.model.ResourceMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _resourceEntryLocalService.updateResourceEntry(
			creatorId, resourceId, model, serviceContext);
	}

	/**
	 * Updates the resource entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was updated
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceEntry
		updateResourceEntry(
			com.swork.core.resource.service.model.ResourceEntry resourceEntry) {

		return _resourceEntryLocalService.updateResourceEntry(resourceEntry);
	}

	@Override
	public ResourceEntryLocalService getWrappedService() {
		return _resourceEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ResourceEntryLocalService resourceEntryLocalService) {

		_resourceEntryLocalService = resourceEntryLocalService;
	}

	private ResourceEntryLocalService _resourceEntryLocalService;

}