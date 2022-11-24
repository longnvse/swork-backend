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
 * Provides a wrapper for {@link TeamMemberEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntryLocalService
 * @generated
 */
public class TeamMemberEntryLocalServiceWrapper
	implements ServiceWrapper<TeamMemberEntryLocalService>,
			   TeamMemberEntryLocalService {

	public TeamMemberEntryLocalServiceWrapper(
		TeamMemberEntryLocalService teamMemberEntryLocalService) {

		_teamMemberEntryLocalService = teamMemberEntryLocalService;
	}

	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		addTeamMemberEntries(
			long companyId, long teamId,
			com.swork.core.resource.service.mapper.model.TeamMemberMapperModel
				model,
			boolean isAdmin) {

		return _teamMemberEntryLocalService.addTeamMemberEntries(
			companyId, teamId, model, isAdmin);
	}

	@Override
	public void addTeamMemberEntries(
		long companyId, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMembersMapperModel
			models,
		boolean isAdmin) {

		_teamMemberEntryLocalService.addTeamMemberEntries(
			companyId, teamId, models, isAdmin);
	}

	/**
	 * Adds the team member entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was added
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		addTeamMemberEntry(
			com.swork.core.resource.service.model.TeamMemberEntry
				teamMemberEntry) {

		return _teamMemberEntryLocalService.addTeamMemberEntry(teamMemberEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		createTeamMemberEntry(long teamMemberId) {

		return _teamMemberEntryLocalService.createTeamMemberEntry(teamMemberId);
	}

	@Override
	public void deleteAdminByTeamId(long teamId) {
		_teamMemberEntryLocalService.deleteAdminByTeamId(teamId);
	}

	@Override
	public void deleteMemberByTeamId(long teamId) {
		_teamMemberEntryLocalService.deleteMemberByTeamId(teamId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws PortalException if a team member entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
			deleteTeamMemberEntry(long teamMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.deleteTeamMemberEntry(teamMemberId);
	}

	/**
	 * Deletes the team member entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was removed
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		deleteTeamMemberEntry(
			com.swork.core.resource.service.model.TeamMemberEntry
				teamMemberEntry) {

		return _teamMemberEntryLocalService.deleteTeamMemberEntry(
			teamMemberEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _teamMemberEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _teamMemberEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teamMemberEntryLocalService.dynamicQuery();
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

		return _teamMemberEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
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

		return _teamMemberEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
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

		return _teamMemberEntryLocalService.dynamicQuery(
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

		return _teamMemberEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teamMemberEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		fetchTeamMemberEntry(long teamMemberId) {

		return _teamMemberEntryLocalService.fetchTeamMemberEntry(teamMemberId);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		fetchTeamMemberEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _teamMemberEntryLocalService.
			fetchTeamMemberEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchTeamMemberEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		fetchTeamMemberEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _teamMemberEntryLocalService.fetchTeamMemberEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry with the matching UUID and company.
	 *
	 * @param uuid the team member entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		fetchTeamMemberEntryByUuidAndCompanyId(String uuid, long companyId) {

		return _teamMemberEntryLocalService.
			fetchTeamMemberEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teamMemberEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamMemberEntry>
		getAdminsByTeamId(long teamId) {

		return _teamMemberEntryLocalService.getAdminsByTeamId(teamId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teamMemberEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamMemberEntry>
		getMembersByTeamId(long teamId) {

		return _teamMemberEntryLocalService.getMembersByTeamId(teamId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamMemberEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of team member entries
	 */
	@Override
	public java.util.List<com.swork.core.resource.service.model.TeamMemberEntry>
		getTeamMemberEntries(int start, int end) {

		return _teamMemberEntryLocalService.getTeamMemberEntries(start, end);
	}

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	@Override
	public int getTeamMemberEntriesCount() {
		return _teamMemberEntryLocalService.getTeamMemberEntriesCount();
	}

	/**
	 * Returns the team member entry with the primary key.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry
	 * @throws PortalException if a team member entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
			getTeamMemberEntry(long teamMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.getTeamMemberEntry(teamMemberId);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry
	 * @throws PortalException if a matching team member entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
			getTeamMemberEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.
			getTeamMemberEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry with the matching UUID and company.
	 *
	 * @param uuid the team member entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching team member entry
	 * @throws PortalException if a matching team member entry could not be found
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
			getTeamMemberEntryByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMemberEntryLocalService.
			getTeamMemberEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public void updateTeamMemberEntries(
		long companyId, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMembersMapperModel
			model,
		boolean isAdmin) {

		_teamMemberEntryLocalService.updateTeamMemberEntries(
			companyId, teamId, model, isAdmin);
	}

	/**
	 * Updates the team member entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was updated
	 */
	@Override
	public com.swork.core.resource.service.model.TeamMemberEntry
		updateTeamMemberEntry(
			com.swork.core.resource.service.model.TeamMemberEntry
				teamMemberEntry) {

		return _teamMemberEntryLocalService.updateTeamMemberEntry(
			teamMemberEntry);
	}

	@Override
	public TeamMemberEntryLocalService getWrappedService() {
		return _teamMemberEntryLocalService;
	}

	@Override
	public void setWrappedService(
		TeamMemberEntryLocalService teamMemberEntryLocalService) {

		_teamMemberEntryLocalService = teamMemberEntryLocalService;
	}

	private TeamMemberEntryLocalService _teamMemberEntryLocalService;

}