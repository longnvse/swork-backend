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
 * Provides a wrapper for {@link ProjectEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryLocalService
 * @generated
 */
public class ProjectEntryLocalServiceWrapper
	implements ProjectEntryLocalService,
			   ServiceWrapper<ProjectEntryLocalService> {

	public ProjectEntryLocalServiceWrapper(
		ProjectEntryLocalService projectEntryLocalService) {

		_projectEntryLocalService = projectEntryLocalService;
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry addProject(
		long businessId, long creatorId,
		com.swork.core.project.service.mapper.model.ProjectMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.addProject(
			businessId, creatorId, model, serviceContext);
	}

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
	@Override
	public com.swork.core.project.service.model.ProjectEntry addProjectEntry(
		com.swork.core.project.service.model.ProjectEntry projectEntry) {

		return _projectEntryLocalService.addProjectEntry(projectEntry);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry approvalProject(
		long creatorId, long projectId, String status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.approvalProject(
			creatorId, projectId, status, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry createProjectEntry(
		long projectId) {

		return _projectEntryLocalService.createProjectEntry(projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.swork.core.project.service.model.ProjectEntry deleteProjectEntry(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.deleteProjectEntry(projectId);
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
	@Override
	public com.swork.core.project.service.model.ProjectEntry deleteProjectEntry(
		com.swork.core.project.service.model.ProjectEntry projectEntry) {

		return _projectEntryLocalService.deleteProjectEntry(projectEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectEntryLocalService.dynamicQuery();
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

		return _projectEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _projectEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _projectEntryLocalService.dynamicQuery(
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

		return _projectEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry fetchProjectEntry(
		long projectId) {

		return _projectEntryLocalService.fetchProjectEntry(projectId);
	}

	/**
	 * Returns the project entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the project entry's external reference code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry
		fetchProjectEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _projectEntryLocalService.
			fetchProjectEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchProjectEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.project.service.model.ProjectEntry
		fetchProjectEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _projectEntryLocalService.fetchProjectEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry
		fetchProjectEntryByUuidAndGroupId(String uuid, long groupId) {

		return _projectEntryLocalService.fetchProjectEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.swork.core.project.service.model.ProjectEntry>
		findByBusinessId(long businessId) {

		return _projectEntryLocalService.findByBusinessId(businessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry getByCode(
		long businessId, String projectCode) {

		return _projectEntryLocalService.getByCode(businessId, projectCode);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry getByName(
		long businessId, String projectName) {

		return _projectEntryLocalService.getByName(businessId, projectName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _projectEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.swork.core.project.service.model.ProjectEntry>
		getProjectEntries(int start, int end) {

		return _projectEntryLocalService.getProjectEntries(start, end);
	}

	/**
	 * Returns all the project entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the project entries
	 * @param companyId the primary key of the company
	 * @return the matching project entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.project.service.model.ProjectEntry>
		getProjectEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _projectEntryLocalService.getProjectEntriesByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.swork.core.project.service.model.ProjectEntry>
		getProjectEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.core.project.service.model.ProjectEntry>
					orderByComparator) {

		return _projectEntryLocalService.getProjectEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	@Override
	public int getProjectEntriesCount() {
		return _projectEntryLocalService.getProjectEntriesCount();
	}

	/**
	 * Returns the project entry with the primary key.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws PortalException if a project entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry getProjectEntry(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.getProjectEntry(projectId);
	}

	/**
	 * Returns the project entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the project entry's external reference code
	 * @return the matching project entry
	 * @throws PortalException if a matching project entry could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry
			getProjectEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.getProjectEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry
	 * @throws PortalException if a matching project entry could not be found
	 */
	@Override
	public com.swork.core.project.service.model.ProjectEntry
			getProjectEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEntryLocalService.getProjectEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry updateActualDate(
		long creatorId, long projectId, java.util.Date actualStartDate,
		java.util.Date actualEndDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.updateActualDate(
			creatorId, projectId, actualStartDate, actualEndDate,
			serviceContext);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry updateDate(
		long creatorId, long projectId, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.updateDate(
			creatorId, projectId, startDate, endDate, serviceContext);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry updateDescription(
		long creatorId, long projectId, String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.updateDescription(
			creatorId, projectId, description, serviceContext);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry updateMember(
		long creatorId, long projectId,
		com.swork.core.project.service.mapper.model.ProjectMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.updateMember(
			creatorId, projectId, model, serviceContext);
	}

	@Override
	public com.swork.core.project.service.model.ProjectEntry updateProject(
		long creatorId, long projectId,
		com.swork.core.project.service.mapper.model.ProjectMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _projectEntryLocalService.updateProject(
			creatorId, projectId, model, serviceContext);
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
	@Override
	public com.swork.core.project.service.model.ProjectEntry updateProjectEntry(
		com.swork.core.project.service.model.ProjectEntry projectEntry) {

		return _projectEntryLocalService.updateProjectEntry(projectEntry);
	}

	@Override
	public ProjectEntryLocalService getWrappedService() {
		return _projectEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectEntryLocalService projectEntryLocalService) {

		_projectEntryLocalService = projectEntryLocalService;
	}

	private ProjectEntryLocalService _projectEntryLocalService;

}