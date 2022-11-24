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

import com.swork.core.resource.service.model.TeamMemberEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TeamMemberEntry. This utility wraps
 * <code>com.swork.core.resource.service.service.impl.TeamMemberEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntryLocalService
 * @generated
 */
public class TeamMemberEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.resource.service.service.impl.TeamMemberEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TeamMemberEntry addTeamMemberEntries(
		long companyId, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMemberMapperModel
			model,
		boolean isAdmin) {

		return getService().addTeamMemberEntries(
			companyId, teamId, model, isAdmin);
	}

	public static void addTeamMemberEntries(
		long companyId, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMembersMapperModel
			models,
		boolean isAdmin) {

		getService().addTeamMemberEntries(companyId, teamId, models, isAdmin);
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
	public static TeamMemberEntry addTeamMemberEntry(
		TeamMemberEntry teamMemberEntry) {

		return getService().addTeamMemberEntry(teamMemberEntry);
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
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	public static TeamMemberEntry createTeamMemberEntry(long teamMemberId) {
		return getService().createTeamMemberEntry(teamMemberId);
	}

	public static void deleteAdminByTeamId(long teamId) {
		getService().deleteAdminByTeamId(teamId);
	}

	public static void deleteMemberByTeamId(long teamId) {
		getService().deleteMemberByTeamId(teamId);
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
	public static TeamMemberEntry deleteTeamMemberEntry(long teamMemberId)
		throws PortalException {

		return getService().deleteTeamMemberEntry(teamMemberId);
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
	public static TeamMemberEntry deleteTeamMemberEntry(
		TeamMemberEntry teamMemberEntry) {

		return getService().deleteTeamMemberEntry(teamMemberEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
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

	public static TeamMemberEntry fetchTeamMemberEntry(long teamMemberId) {
		return getService().fetchTeamMemberEntry(teamMemberId);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchTeamMemberEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchTeamMemberEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchTeamMemberEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static TeamMemberEntry fetchTeamMemberEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchTeamMemberEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry with the matching UUID and company.
	 *
	 * @param uuid the team member entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchTeamMemberEntryByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchTeamMemberEntryByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<TeamMemberEntry> getAdminsByTeamId(long teamId) {
		return getService().getAdminsByTeamId(teamId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<TeamMemberEntry> getMembersByTeamId(long teamId) {
		return getService().getMembersByTeamId(teamId);
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
	public static List<TeamMemberEntry> getTeamMemberEntries(
		int start, int end) {

		return getService().getTeamMemberEntries(start, end);
	}

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	public static int getTeamMemberEntriesCount() {
		return getService().getTeamMemberEntriesCount();
	}

	/**
	 * Returns the team member entry with the primary key.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry
	 * @throws PortalException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry getTeamMemberEntry(long teamMemberId)
		throws PortalException {

		return getService().getTeamMemberEntry(teamMemberId);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry
	 * @throws PortalException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry getTeamMemberEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getTeamMemberEntryByExternalReferenceCode(
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
	public static TeamMemberEntry getTeamMemberEntryByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getTeamMemberEntryByUuidAndCompanyId(
			uuid, companyId);
	}

	public static void updateTeamMemberEntries(
		long companyId, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMembersMapperModel
			model,
		boolean isAdmin) {

		getService().updateTeamMemberEntries(companyId, teamId, model, isAdmin);
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
	public static TeamMemberEntry updateTeamMemberEntry(
		TeamMemberEntry teamMemberEntry) {

		return getService().updateTeamMemberEntry(teamMemberEntry);
	}

	public static TeamMemberEntryLocalService getService() {
		return _service;
	}

	private static volatile TeamMemberEntryLocalService _service;

}