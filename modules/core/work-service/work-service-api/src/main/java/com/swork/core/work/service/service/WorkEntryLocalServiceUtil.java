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

package com.swork.core.work.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.work.service.model.WorkEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for WorkEntry. This utility wraps
 * <code>com.swork.core.work.service.service.impl.WorkEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntryLocalService
 * @generated
 */
public class WorkEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.work.service.service.impl.WorkEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static WorkEntry addWorkEntry(
		long businessId, long creatorId,
		com.swork.core.work.service.mapper.model.WorkMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addWorkEntry(
			businessId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the work entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was added
	 */
	public static WorkEntry addWorkEntry(WorkEntry workEntry) {
		return getService().addWorkEntry(workEntry);
	}

	public static long calcProgress(
		List<WorkEntry> workEntries, String progressType) {

		return getService().calcProgress(workEntries, progressType);
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
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	public static WorkEntry createWorkEntry(long workId) {
		return getService().createWorkEntry(workId);
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
	 * Deletes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws PortalException if a work entry with the primary key could not be found
	 */
	public static WorkEntry deleteWorkEntry(long workId)
		throws PortalException {

		return getService().deleteWorkEntry(workId);
	}

	/**
	 * Deletes the work entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was removed
	 */
	public static WorkEntry deleteWorkEntry(WorkEntry workEntry) {
		return getService().deleteWorkEntry(workEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
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

	public static WorkEntry fetchWorkEntry(long workId) {
		return getService().fetchWorkEntry(workId);
	}

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchWorkEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchWorkEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchWorkEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static WorkEntry fetchWorkEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchWorkEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the work entry matching the UUID and group.
	 *
	 * @param uuid the work entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchWorkEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchWorkEntryByUuidAndGroupId(uuid, groupId);
	}

	public static WorkEntry findByP_Name(long projectId, String name) {
		return getService().findByP_Name(projectId, name);
	}

	public static List<WorkEntry> findByParentId(
		long businessId, long parentId) {

		return getService().findByParentId(businessId, parentId);
	}

	public static List<WorkEntry> findByPhaseId(
		long phaseId, boolean hasChildren) {

		return getService().findByPhaseId(phaseId, hasChildren);
	}

	public static WorkEntry findByPID_Name(
		long businessId, long parentId, String name) {

		return getService().findByPID_Name(businessId, parentId, name);
	}

	public static List<WorkEntry> findByProjectId(
		long projectId, boolean hasChildren) {

		return getService().findByProjectId(projectId, hasChildren);
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
	 * Returns a range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of work entries
	 */
	public static List<WorkEntry> getWorkEntries(int start, int end) {
		return getService().getWorkEntries(start, end);
	}

	/**
	 * Returns all the work entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the work entries
	 * @param companyId the primary key of the company
	 * @return the matching work entries, or an empty list if no matches were found
	 */
	public static List<WorkEntry> getWorkEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getWorkEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of work entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the work entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work entries, or an empty list if no matches were found
	 */
	public static List<WorkEntry> getWorkEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getService().getWorkEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	public static int getWorkEntriesCount() {
		return getService().getWorkEntriesCount();
	}

	/**
	 * Returns the work entry with the primary key.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws PortalException if a work entry with the primary key could not be found
	 */
	public static WorkEntry getWorkEntry(long workId) throws PortalException {
		return getService().getWorkEntry(workId);
	}

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry
	 * @throws PortalException if a matching work entry could not be found
	 */
	public static WorkEntry getWorkEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getWorkEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the work entry matching the UUID and group.
	 *
	 * @param uuid the work entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work entry
	 * @throws PortalException if a matching work entry could not be found
	 */
	public static WorkEntry getWorkEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getWorkEntryByUuidAndGroupId(uuid, groupId);
	}

	public static WorkEntry reportProgressByAmount(
		long creatorId, long workId, double completeAmount,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().reportProgressByAmount(
			creatorId, workId, completeAmount, serviceContext);
	}

	public static WorkEntry updateProcessWorkEntry(
		long creatorId, long workId, long progress,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateProcessWorkEntry(
			creatorId, workId, progress, serviceContext);
	}

	public static WorkEntry updateProgress(long workId, long progress) {
		return getService().updateProgress(workId, progress);
	}

	public static WorkEntry updateStatus(
		long creatorId, long workId, String status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatus(
			creatorId, workId, status, serviceContext);
	}

	public static WorkEntry updateWorkEntry(
		long creatorId, long workId,
		com.swork.core.work.service.mapper.model.WorkMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateWorkEntry(
			creatorId, workId, model, serviceContext);
	}

	/**
	 * Updates the work entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was updated
	 */
	public static WorkEntry updateWorkEntry(WorkEntry workEntry) {
		return getService().updateWorkEntry(workEntry);
	}

	public static WorkEntryLocalService getService() {
		return _service;
	}

	private static volatile WorkEntryLocalService _service;

}