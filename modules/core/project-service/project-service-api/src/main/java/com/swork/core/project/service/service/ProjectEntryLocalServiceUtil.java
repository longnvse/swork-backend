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

package com.swork.core.project.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.project.service.model.ProjectEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProjectEntry. This utility wraps
 * <code>com.swork.core.project.service.service.impl.ProjectEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryLocalService
 * @generated
 */
public class ProjectEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.project.service.service.impl.ProjectEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the project entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was added
	 */
	public static ProjectEntry addProjectEntry(ProjectEntry projectEntry) {
		return getService().addProjectEntry(projectEntry);
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
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	public static ProjectEntry createProjectEntry(long projectId) {
		return getService().createProjectEntry(projectId);
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
	 * Deletes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws PortalException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry deleteProjectEntry(long projectId)
		throws PortalException {

		return getService().deleteProjectEntry(projectId);
	}

	/**
	 * Deletes the project entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was removed
	 */
	public static ProjectEntry deleteProjectEntry(ProjectEntry projectEntry) {
		return getService().deleteProjectEntry(projectEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
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

	public static ProjectEntry fetchProjectEntry(long projectId) {
		return getService().fetchProjectEntry(projectId);
	}

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchProjectEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProjectEntryByUuidAndGroupId(uuid, groupId);
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
	 * Returns a range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of project entries
	 */
	public static List<ProjectEntry> getProjectEntries(int start, int end) {
		return getService().getProjectEntries(start, end);
	}

	/**
	 * Returns all the project entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the project entries
	 * @param companyId the primary key of the company
	 * @return the matching project entries, or an empty list if no matches were found
	 */
	public static List<ProjectEntry> getProjectEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProjectEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of project entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the project entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project entries, or an empty list if no matches were found
	 */
	public static List<ProjectEntry> getProjectEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getService().getProjectEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	public static int getProjectEntriesCount() {
		return getService().getProjectEntriesCount();
	}

	/**
	 * Returns the project entry with the primary key.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws PortalException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry getProjectEntry(long projectId)
		throws PortalException {

		return getService().getProjectEntry(projectId);
	}

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry
	 * @throws PortalException if a matching project entry could not be found
	 */
	public static ProjectEntry getProjectEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProjectEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Updates the project entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was updated
	 */
	public static ProjectEntry updateProjectEntry(ProjectEntry projectEntry) {
		return getService().updateProjectEntry(projectEntry);
	}

	public static ProjectEntryLocalService getService() {
		return _service;
	}

	private static volatile ProjectEntryLocalService _service;

}