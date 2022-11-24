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
 * Provides a wrapper for {@link ResourceTypeEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntryLocalService
 * @generated
 */
public class ResourceTypeEntryLocalServiceWrapper
	implements ResourceTypeEntryLocalService,
			   ServiceWrapper<ResourceTypeEntryLocalService> {

	public ResourceTypeEntryLocalServiceWrapper(
		ResourceTypeEntryLocalService resourceTypeEntryLocalService) {

		_resourceTypeEntryLocalService = resourceTypeEntryLocalService;
	}

	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		addResourceTypeEntry(
			long businessId, long creatorId,
			com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _resourceTypeEntryLocalService.addResourceTypeEntry(
			businessId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the resource type entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was added
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		addResourceTypeEntry(
			com.swork.core.resource.service.model.ResourceTypeEntry
				resourceTypeEntry) {

		return _resourceTypeEntryLocalService.addResourceTypeEntry(
			resourceTypeEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		createResourceTypeEntry(long resourceTypeId) {

		return _resourceTypeEntryLocalService.createResourceTypeEntry(
			resourceTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws PortalException if a resource type entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
			deleteResourceTypeEntry(long resourceTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.deleteResourceTypeEntry(
			resourceTypeId);
	}

	/**
	 * Deletes the resource type entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was removed
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		deleteResourceTypeEntry(
			com.swork.core.resource.service.model.ResourceTypeEntry
				resourceTypeEntry) {

		return _resourceTypeEntryLocalService.deleteResourceTypeEntry(
			resourceTypeEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _resourceTypeEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _resourceTypeEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceTypeEntryLocalService.dynamicQuery();
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

		return _resourceTypeEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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

		return _resourceTypeEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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

		return _resourceTypeEntryLocalService.dynamicQuery(
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

		return _resourceTypeEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _resourceTypeEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		fetchResourceTypeEntry(long resourceTypeId) {

		return _resourceTypeEntryLocalService.fetchResourceTypeEntry(
			resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		fetchResourceTypeEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _resourceTypeEntryLocalService.
			fetchResourceTypeEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceTypeEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		fetchResourceTypeEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _resourceTypeEntryLocalService.
			fetchResourceTypeEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry matching the UUID and group.
	 *
	 * @param uuid the resource type entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		fetchResourceTypeEntryByUuidAndGroupId(String uuid, long groupId) {

		return _resourceTypeEntryLocalService.
			fetchResourceTypeEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry findByName(
		long businessId, String name) {

		return _resourceTypeEntryLocalService.findByName(businessId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _resourceTypeEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.swork.core.resource.service.model.ResourceTypeEntry> getChildren(
			long businessId, long parentId) {

		return _resourceTypeEntryLocalService.getChildren(businessId, parentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _resourceTypeEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _resourceTypeEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _resourceTypeEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of resource type entries
	 */
	@Override
	public java.util.List
		<com.swork.core.resource.service.model.ResourceTypeEntry>
			getResourceTypeEntries(int start, int end) {

		return _resourceTypeEntryLocalService.getResourceTypeEntries(
			start, end);
	}

	/**
	 * Returns all the resource type entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource type entries
	 * @param companyId the primary key of the company
	 * @return the matching resource type entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.swork.core.resource.service.model.ResourceTypeEntry>
			getResourceTypeEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _resourceTypeEntryLocalService.
			getResourceTypeEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of resource type entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource type entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource type entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.swork.core.resource.service.model.ResourceTypeEntry>
			getResourceTypeEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.swork.core.resource.service.model.ResourceTypeEntry>
						orderByComparator) {

		return _resourceTypeEntryLocalService.
			getResourceTypeEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	@Override
	public int getResourceTypeEntriesCount() {
		return _resourceTypeEntryLocalService.getResourceTypeEntriesCount();
	}

	/**
	 * Returns the resource type entry with the primary key.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws PortalException if a resource type entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
			getResourceTypeEntry(long resourceTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.getResourceTypeEntry(
			resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry
	 * @throws PortalException if a matching resource type entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
			getResourceTypeEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.
			getResourceTypeEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry matching the UUID and group.
	 *
	 * @param uuid the resource type entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource type entry
	 * @throws PortalException if a matching resource type entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
			getResourceTypeEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceTypeEntryLocalService.
			getResourceTypeEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		updateResourceTypeEntry(
			long creatorId, long okrIntervalConfigEntryId,
			com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel
				model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _resourceTypeEntryLocalService.updateResourceTypeEntry(
			creatorId, okrIntervalConfigEntryId, model, serviceContext);
	}

	/**
	 * Updates the resource type entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was updated
	 */
	@Override
	public com.swork.core.resource.service.model.ResourceTypeEntry
		updateResourceTypeEntry(
			com.swork.core.resource.service.model.ResourceTypeEntry
				resourceTypeEntry) {

		return _resourceTypeEntryLocalService.updateResourceTypeEntry(
			resourceTypeEntry);
	}

	@Override
	public ResourceTypeEntryLocalService getWrappedService() {
		return _resourceTypeEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ResourceTypeEntryLocalService resourceTypeEntryLocalService) {

		_resourceTypeEntryLocalService = resourceTypeEntryLocalService;
	}

	private ResourceTypeEntryLocalService _resourceTypeEntryLocalService;

}