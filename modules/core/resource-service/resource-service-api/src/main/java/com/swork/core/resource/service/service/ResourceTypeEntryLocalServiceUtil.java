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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.resource.service.model.ResourceTypeEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ResourceTypeEntry. This utility wraps
 * <code>com.swork.core.resource.service.service.impl.ResourceTypeEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntryLocalService
 * @generated
 */
public class ResourceTypeEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.resource.service.service.impl.ResourceTypeEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ResourceTypeEntry addResourceTypeEntry(
		long businessId, long creatorId,
		com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel
			model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addResourceTypeEntry(
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
	public static ResourceTypeEntry addResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		return getService().addResourceTypeEntry(resourceTypeEntry);
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
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	public static ResourceTypeEntry createResourceTypeEntry(
		long resourceTypeId) {

		return getService().createResourceTypeEntry(resourceTypeId);
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
	public static ResourceTypeEntry deleteResourceTypeEntry(long resourceTypeId)
		throws PortalException {

		return getService().deleteResourceTypeEntry(resourceTypeId);
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
	public static ResourceTypeEntry deleteResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		return getService().deleteResourceTypeEntry(resourceTypeEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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

	public static ResourceTypeEntry fetchResourceTypeEntry(
		long resourceTypeId) {

		return getService().fetchResourceTypeEntry(resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry
		fetchResourceTypeEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchResourceTypeEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceTypeEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static ResourceTypeEntry fetchResourceTypeEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchResourceTypeEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry matching the UUID and group.
	 *
	 * @param uuid the resource type entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchResourceTypeEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchResourceTypeEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static ResourceTypeEntry findByName(long businessId, String name) {
		return getService().findByName(businessId, name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<ResourceTypeEntry> getChildren(
		long businessId, long parentId) {

		return getService().getChildren(businessId, parentId);
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
	public static List<ResourceTypeEntry> getResourceTypeEntries(
		int start, int end) {

		return getService().getResourceTypeEntries(start, end);
	}

	/**
	 * Returns all the resource type entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource type entries
	 * @param companyId the primary key of the company
	 * @return the matching resource type entries, or an empty list if no matches were found
	 */
	public static List<ResourceTypeEntry>
		getResourceTypeEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getResourceTypeEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ResourceTypeEntry>
		getResourceTypeEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getService().getResourceTypeEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	public static int getResourceTypeEntriesCount() {
		return getService().getResourceTypeEntriesCount();
	}

	/**
	 * Returns the resource type entry with the primary key.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws PortalException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry getResourceTypeEntry(long resourceTypeId)
		throws PortalException {

		return getService().getResourceTypeEntry(resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry
	 * @throws PortalException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry getResourceTypeEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getResourceTypeEntryByExternalReferenceCode(
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
	public static ResourceTypeEntry getResourceTypeEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getResourceTypeEntryByUuidAndGroupId(uuid, groupId);
	}

	public static ResourceTypeEntry updateResourceTypeEntry(
		long creatorId, long okrIntervalConfigEntryId,
		com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel
			model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateResourceTypeEntry(
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
	public static ResourceTypeEntry updateResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		return getService().updateResourceTypeEntry(resourceTypeEntry);
	}

	public static ResourceTypeEntryLocalService getService() {
		return _service;
	}

	private static volatile ResourceTypeEntryLocalService _service;

}