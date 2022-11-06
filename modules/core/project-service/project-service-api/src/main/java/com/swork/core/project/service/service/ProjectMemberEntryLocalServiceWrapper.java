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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectMemberEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntryLocalService
 * @generated
 */
public class ProjectMemberEntryLocalServiceWrapper
	implements ProjectMemberEntryLocalService,
			   ServiceWrapper<ProjectMemberEntryLocalService> {

	public ProjectMemberEntryLocalServiceWrapper(
		ProjectMemberEntryLocalService projectMemberEntryLocalService) {

		_projectMemberEntryLocalService = projectMemberEntryLocalService;
	}

	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		addProjectMemberEntry(
			long projectId,
			com.swork.core.project.service.mapper.model.ProjectMemberMapperModel
				model,
			String type) {

		return _projectMemberEntryLocalService.addProjectMemberEntry(
			projectId, model, type);
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
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		addProjectMemberEntry(
			com.swork.core.project.service.model.ProjectMemberEntry
				projectMemberEntry) {

		return _projectMemberEntryLocalService.addProjectMemberEntry(
			projectMemberEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectMemberEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		createProjectMemberEntry(long projectMemberId) {

		return _projectMemberEntryLocalService.createProjectMemberEntry(
			projectMemberId);
	}

	@Override
	public void deleteByProjectId(long projectId) {
		_projectMemberEntryLocalService.deleteByProjectId(projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectMemberEntryLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
			deleteProjectMemberEntry(long projectMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectMemberEntryLocalService.deleteProjectMemberEntry(
			projectMemberId);
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
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		deleteProjectMemberEntry(
			com.swork.core.project.service.model.ProjectMemberEntry
				projectMemberEntry) {

		return _projectMemberEntryLocalService.deleteProjectMemberEntry(
			projectMemberEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectMemberEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectMemberEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectMemberEntryLocalService.dynamicQuery();
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

		return _projectMemberEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _projectMemberEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _projectMemberEntryLocalService.dynamicQuery(
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

		return _projectMemberEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectMemberEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		fetchProjectMemberEntry(long projectMemberId) {

		return _projectMemberEntryLocalService.fetchProjectMemberEntry(
			projectMemberId);
	}

	@Override
	public java.util.List
		<com.swork.core.project.service.model.ProjectMemberEntry> findByP_MT_T(
			long projectId, String memberType, String type) {

		return _projectMemberEntryLocalService.findByP_MT_T(
			projectId, memberType, type);
	}

	@Override
	public java.util.List
		<com.swork.core.project.service.model.ProjectMemberEntry> findByP_T(
			long projectId, String type) {

		return _projectMemberEntryLocalService.findByP_T(projectId, type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectMemberEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectMemberEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectMemberEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectMemberEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List
		<com.swork.core.project.service.model.ProjectMemberEntry>
			getProjectMemberEntries(int start, int end) {

		return _projectMemberEntryLocalService.getProjectMemberEntries(
			start, end);
	}

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	@Override
	public int getProjectMemberEntriesCount() {
		return _projectMemberEntryLocalService.getProjectMemberEntriesCount();
	}

	/**
	 * Returns the project member entry with the primary key.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws PortalException if a project member entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
			getProjectMemberEntry(long projectMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectMemberEntryLocalService.getProjectMemberEntry(
			projectMemberId);
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
	@Override
	public com.swork.core.project.service.model.ProjectMemberEntry
		updateProjectMemberEntry(
			com.swork.core.project.service.model.ProjectMemberEntry
				projectMemberEntry) {

		return _projectMemberEntryLocalService.updateProjectMemberEntry(
			projectMemberEntry);
	}

	@Override
	public ProjectMemberEntryLocalService getWrappedService() {
		return _projectMemberEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectMemberEntryLocalService projectMemberEntryLocalService) {

		_projectMemberEntryLocalService = projectMemberEntryLocalService;
	}

	private ProjectMemberEntryLocalService _projectMemberEntryLocalService;

}