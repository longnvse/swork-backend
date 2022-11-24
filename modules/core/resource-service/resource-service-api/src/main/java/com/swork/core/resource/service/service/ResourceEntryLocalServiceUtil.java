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

import com.swork.core.resource.service.model.ResourceEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ResourceEntry. This utility wraps
 * <code>com.swork.core.resource.service.service.impl.ResourceEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntryLocalService
 * @generated
 */
public class ResourceEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.resource.service.service.impl.ResourceEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ResourceEntry addResourceEntry(
		long businessId, long creatorId, Long workId, Long phaseId,
		Long projectId,
		com.swork.core.resource.service.mapper.model.ResourceMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addResourceEntry(
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
	public static ResourceEntry addResourceEntry(ResourceEntry resourceEntry) {
		return getService().addResourceEntry(resourceEntry);
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
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	public static ResourceEntry createResourceEntry(long resourceId) {
		return getService().createResourceEntry(resourceId);
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
	public static ResourceEntry deleteResourceEntry(long resourceId)
		throws PortalException {

		return getService().deleteResourceEntry(resourceId);
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
	public static ResourceEntry deleteResourceEntry(
		ResourceEntry resourceEntry) {

		return getService().deleteResourceEntry(resourceEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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

	public static ResourceEntry fetchResourceEntry(long resourceId) {
		return getService().fetchResourceEntry(resourceId);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchResourceEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchResourceEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static ResourceEntry fetchResourceEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchResourceEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchResourceEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchResourceEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<ResourceEntry> getByObjectGroupId(
		long businessId, long teamId) {

		return getService().getByObjectGroupId(businessId, teamId);
	}

	public static List<ResourceEntry> getByParentId(
		long businessId, long workId, long phaseId, long projectId) {

		return getService().getByParentId(
			businessId, workId, phaseId, projectId);
	}

	public static List<ResourceEntry> getByPhaseId(
		long businessId, long phaseId) {

		return getService().getByPhaseId(businessId, phaseId);
	}

	public static List<ResourceEntry> getByProjectId(
		long businessId, long projectId) {

		return getService().getByProjectId(businessId, projectId);
	}

	public static List<ResourceEntry> getByTaskId(
		long businessId, long workId) {

		return getService().getByTaskId(businessId, workId);
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
	public static List<ResourceEntry> getResourceEntries(int start, int end) {
		return getService().getResourceEntries(start, end);
	}

	/**
	 * Returns all the resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @return the matching resource entries, or an empty list if no matches were found
	 */
	public static List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getResourceEntriesByUuidAndCompanyId(
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
	public static List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getService().getResourceEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	public static int getResourceEntriesCount() {
		return getService().getResourceEntriesCount();
	}

	/**
	 * Returns the resource entry with the primary key.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry getResourceEntry(long resourceId)
		throws PortalException {

		return getService().getResourceEntry(resourceId);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	public static ResourceEntry getResourceEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getResourceEntryByExternalReferenceCode(
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
	public static ResourceEntry getResourceEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getResourceEntryByUuidAndGroupId(uuid, groupId);
	}

	public static ResourceEntry updateResourceEntry(
		long resourceId,
		com.swork.core.resource.service.mapper.model.ResourceMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateResourceEntry(
			resourceId, model, serviceContext);
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
	public static ResourceEntry updateResourceEntry(
		ResourceEntry resourceEntry) {

		return getService().updateResourceEntry(resourceEntry);
	}

	public static ResourceEntryLocalService getService() {
		return _service;
	}

	private static volatile ResourceEntryLocalService _service;

}