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
 * Provides a wrapper for {@link TeamEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntryLocalService
 * @generated
 */
public class TeamEntryLocalServiceWrapper
	implements ServiceWrapper<TeamEntryLocalService>, TeamEntryLocalService {

	public TeamEntryLocalServiceWrapper(
		TeamEntryLocalService teamEntryLocalService) {

		_teamEntryLocalService = teamEntryLocalService;
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry addTeamEntry(
		long businessId, long creatorId,
		com.swork.core.resource.service.mapper.model.TeamMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _teamEntryLocalService.addTeamEntry(
			businessId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the team entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamEntry the team entry
	 * @return the team entry that was added
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry addTeamEntry(
		com.swork.core.resource.service.model.TeamEntry teamEntry) {

		return _teamEntryLocalService.addTeamEntry(teamEntry);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry addTotalIncoming(
		long objectGroupId, long totalIncoming) {

		return _teamEntryLocalService.addTotalIncoming(
			objectGroupId, totalIncoming);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry addTotalSpending(
		long objectGroupId, long totalSpending) {

		return _teamEntryLocalService.addTotalSpending(
			objectGroupId, totalSpending);
	}

	@Override
	public int countCodeDb(long businessId, String code) {
		return _teamEntryLocalService.countCodeDb(businessId, code);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new team entry with the primary key. Does not add the team entry to the database.
	 *
	 * @param teamId the primary key for the new team entry
	 * @return the new team entry
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry createTeamEntry(
		long teamId) {

		return _teamEntryLocalService.createTeamEntry(teamId);
	}

	@Override
	public void deleteByPhaseId(long businessId, long phaseId) {
		_teamEntryLocalService.deleteByPhaseId(businessId, phaseId);
	}

	@Override
	public void deleteByProjectId(long businessId, long projectId) {
		_teamEntryLocalService.deleteByProjectId(businessId, projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the team entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry that was removed
	 * @throws PortalException if a team entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry deleteTeamEntry(
			long teamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.deleteTeamEntry(teamId);
	}

	/**
	 * Deletes the team entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamEntry the team entry
	 * @return the team entry that was removed
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry deleteTeamEntry(
		com.swork.core.resource.service.model.TeamEntry teamEntry) {

		return _teamEntryLocalService.deleteTeamEntry(teamEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _teamEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _teamEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teamEntryLocalService.dynamicQuery();
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

		return _teamEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamEntryModelImpl</code>.
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

		return _teamEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamEntryModelImpl</code>.
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

		return _teamEntryLocalService.dynamicQuery(
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

		return _teamEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teamEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry fetchTeamEntry(
		long teamId) {

		return _teamEntryLocalService.fetchTeamEntry(teamId);
	}

	/**
	 * Returns the team entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team entry's external reference code
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry
		fetchTeamEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _teamEntryLocalService.fetchTeamEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchTeamEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.resource.service.model.TeamEntry
		fetchTeamEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _teamEntryLocalService.fetchTeamEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team entry matching the UUID and group.
	 *
	 * @param uuid the team entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry
		fetchTeamEntryByUuidAndGroupId(String uuid, long groupId) {

		return _teamEntryLocalService.fetchTeamEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry findNameByPhaseId(
		long businessId, String name, long phaseId) {

		return _teamEntryLocalService.findNameByPhaseId(
			businessId, name, phaseId);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry findNameByProjectId(
		long businessId, String name, long projectId) {

		return _teamEntryLocalService.findNameByProjectId(
			businessId, name, projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teamEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamEntry>
		getByPhaseId(long businessId, long phaseId) {

		return _teamEntryLocalService.getByPhaseId(businessId, phaseId);
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamEntry>
		getByProjectId(long businessId, long projectId) {

		return _teamEntryLocalService.getByProjectId(businessId, projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _teamEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teamEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of team entries
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamEntry>
		getTeamEntries(int start, int end) {

		return _teamEntryLocalService.getTeamEntries(start, end);
	}

	/**
	 * Returns all the team entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the team entries
	 * @param companyId the primary key of the company
	 * @return the matching team entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamEntry>
		getTeamEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _teamEntryLocalService.getTeamEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of team entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the team entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching team entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamEntry>
		getTeamEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.core.resource.service.model.TeamEntry>
					orderByComparator) {

		return _teamEntryLocalService.getTeamEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of team entries.
	 *
	 * @return the number of team entries
	 */
	@Override
	public int getTeamEntriesCount() {
		return _teamEntryLocalService.getTeamEntriesCount();
	}

	/**
	 * Returns the team entry with the primary key.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry
	 * @throws PortalException if a team entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry getTeamEntry(
			long teamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.getTeamEntry(teamId);
	}

	/**
	 * Returns the team entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team entry's external reference code
	 * @return the matching team entry
	 * @throws PortalException if a matching team entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry
			getTeamEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.getTeamEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team entry matching the UUID and group.
	 *
	 * @param uuid the team entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching team entry
	 * @throws PortalException if a matching team entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry
			getTeamEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamEntryLocalService.getTeamEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.resource.service.model.TeamEntry updateTeamEntry(
		long creator, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _teamEntryLocalService.updateTeamEntry(
			creator, teamId, model, serviceContext);
	}

	/**
	 * Updates the team entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamEntry the team entry
	 * @return the team entry that was updated
	 */
	@Override
	public com.swork.core.resource.service.model.TeamEntry updateTeamEntry(
		com.swork.core.resource.service.model.TeamEntry teamEntry) {

		return _teamEntryLocalService.updateTeamEntry(teamEntry);
	}

	@Override
	public TeamEntryLocalService getWrappedService() {
		return _teamEntryLocalService;
	}

	@Override
	public void setWrappedService(TeamEntryLocalService teamEntryLocalService) {
		_teamEntryLocalService = teamEntryLocalService;
	}

	private TeamEntryLocalService _teamEntryLocalService;

}