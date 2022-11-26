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

import com.swork.core.resource.service.model.TeamEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TeamEntry. This utility wraps
 * <code>com.swork.core.resource.service.service.impl.TeamEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntryLocalService
 * @generated
 */
public class TeamEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.resource.service.service.impl.TeamEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TeamEntry addTeamEntry(
		long businessId, long creatorId,
		com.swork.core.resource.service.mapper.model.TeamMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addTeamEntry(
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
	public static TeamEntry addTeamEntry(TeamEntry teamEntry) {
		return getService().addTeamEntry(teamEntry);
	}

	public static TeamEntry addTotalIncoming(
		long objectGroupId, long totalIncoming) {

		return getService().addTotalIncoming(objectGroupId, totalIncoming);
	}

	public static TeamEntry addTotalSpending(
		long objectGroupId, long totalSpending) {

		return getService().addTotalSpending(objectGroupId, totalSpending);
	}

	public static int countCodeDb(long businessId, String code) {
		return getService().countCodeDb(businessId, code);
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
	 * Creates a new team entry with the primary key. Does not add the team entry to the database.
	 *
	 * @param teamId the primary key for the new team entry
	 * @return the new team entry
	 */
	public static TeamEntry createTeamEntry(long teamId) {
		return getService().createTeamEntry(teamId);
	}

	public static void deleteByPhaseId(long businessId, long phaseId) {
		getService().deleteByPhaseId(businessId, phaseId);
	}

	public static void deleteByProjectId(long businessId, long projectId) {
		getService().deleteByProjectId(businessId, projectId);
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
	public static TeamEntry deleteTeamEntry(long teamId)
		throws PortalException {

		return getService().deleteTeamEntry(teamId);
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
	public static TeamEntry deleteTeamEntry(TeamEntry teamEntry) {
		return getService().deleteTeamEntry(teamEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamEntryModelImpl</code>.
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

	public static TeamEntry fetchTeamEntry(long teamId) {
		return getService().fetchTeamEntry(teamId);
	}

	/**
	 * Returns the team entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team entry's external reference code
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchTeamEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchTeamEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchTeamEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static TeamEntry fetchTeamEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchTeamEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team entry matching the UUID and group.
	 *
	 * @param uuid the team entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchTeamEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTeamEntryByUuidAndGroupId(uuid, groupId);
	}

	public static TeamEntry findNameByPhaseId(
		long businessId, String name, long phaseId) {

		return getService().findNameByPhaseId(businessId, name, phaseId);
	}

	public static TeamEntry findNameByProjectId(
		long businessId, String name, long projectId) {

		return getService().findNameByProjectId(businessId, name, projectId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<TeamEntry> getByPhaseId(long businessId, long phaseId) {
		return getService().getByPhaseId(businessId, phaseId);
	}

	public static List<TeamEntry> getByProjectId(
		long businessId, long projectId) {

		return getService().getByProjectId(businessId, projectId);
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
	public static List<TeamEntry> getTeamEntries(int start, int end) {
		return getService().getTeamEntries(start, end);
	}

	/**
	 * Returns all the team entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the team entries
	 * @param companyId the primary key of the company
	 * @return the matching team entries, or an empty list if no matches were found
	 */
	public static List<TeamEntry> getTeamEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTeamEntriesByUuidAndCompanyId(uuid, companyId);
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
	public static List<TeamEntry> getTeamEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getService().getTeamEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of team entries.
	 *
	 * @return the number of team entries
	 */
	public static int getTeamEntriesCount() {
		return getService().getTeamEntriesCount();
	}

	/**
	 * Returns the team entry with the primary key.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry
	 * @throws PortalException if a team entry with the primary key could not be found
	 */
	public static TeamEntry getTeamEntry(long teamId) throws PortalException {
		return getService().getTeamEntry(teamId);
	}

	/**
	 * Returns the team entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team entry's external reference code
	 * @return the matching team entry
	 * @throws PortalException if a matching team entry could not be found
	 */
	public static TeamEntry getTeamEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getTeamEntryByExternalReferenceCode(
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
	public static TeamEntry getTeamEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTeamEntryByUuidAndGroupId(uuid, groupId);
	}

	public static TeamEntry updateTeamEntry(
		long creator, long teamId,
		com.swork.core.resource.service.mapper.model.TeamMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateTeamEntry(
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
	public static TeamEntry updateTeamEntry(TeamEntry teamEntry) {
		return getService().updateTeamEntry(teamEntry);
	}

	public static TeamEntryLocalService getService() {
		return _service;
	}

	private static volatile TeamEntryLocalService _service;

}