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

import com.swork.core.project.service.model.ProjectMemberEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProjectMemberEntry. This utility wraps
 * <code>com.swork.core.project.service.service.impl.ProjectMemberEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntryLocalService
 * @generated
 */
public class ProjectMemberEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.project.service.service.impl.ProjectMemberEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ProjectMemberEntry addProjectMemberEntry(
		long projectId, long memberId, String memberType, String type) {

		return getService().addProjectMemberEntry(
			projectId, memberId, memberType, type);
	}

	/**
	 * Adds the project member entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was added
	 */
	public static ProjectMemberEntry addProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		return getService().addProjectMemberEntry(projectMemberEntry);
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
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	public static ProjectMemberEntry createProjectMemberEntry(
		long projectMemberId) {

		return getService().createProjectMemberEntry(projectMemberId);
	}

	public static void deleteByProjectId(long projectId) {
		getService().deleteByProjectId(projectId);
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
	 * Deletes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws PortalException if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry deleteProjectMemberEntry(
			long projectMemberId)
		throws PortalException {

		return getService().deleteProjectMemberEntry(projectMemberId);
	}

	/**
	 * Deletes the project member entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was removed
	 */
	public static ProjectMemberEntry deleteProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		return getService().deleteProjectMemberEntry(projectMemberEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
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

	public static ProjectMemberEntry fetchProjectMemberEntry(
		long projectMemberId) {

		return getService().fetchProjectMemberEntry(projectMemberId);
	}

	public static List<ProjectMemberEntry> findByProjectId(long projectId) {
		return getService().findByProjectId(projectId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns a range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of project member entries
	 */
	public static List<ProjectMemberEntry> getProjectMemberEntries(
		int start, int end) {

		return getService().getProjectMemberEntries(start, end);
	}

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	public static int getProjectMemberEntriesCount() {
		return getService().getProjectMemberEntriesCount();
	}

	/**
	 * Returns the project member entry with the primary key.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws PortalException if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry getProjectMemberEntry(long projectMemberId)
		throws PortalException {

		return getService().getProjectMemberEntry(projectMemberId);
	}

	/**
	 * Updates the project member entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was updated
	 */
	public static ProjectMemberEntry updateProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		return getService().updateProjectMemberEntry(projectMemberEntry);
	}

	public static ProjectMemberEntryLocalService getService() {
		return _service;
	}

	private static volatile ProjectMemberEntryLocalService _service;

}