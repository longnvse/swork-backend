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

package com.swork.checklist.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.checklist.service.model.ChecklistEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ChecklistEntry. This utility wraps
 * <code>com.swork.checklist.service.service.impl.ChecklistEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntryLocalService
 * @generated
 */
public class ChecklistEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.checklist.service.service.impl.ChecklistEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the checklist entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistEntry the checklist entry
	 * @return the checklist entry that was added
	 */
	public static ChecklistEntry addChecklistEntry(
		ChecklistEntry checklistEntry) {

		return getService().addChecklistEntry(checklistEntry);
	}

	public static ChecklistEntry addCheckListEntry(
		long userId,
		com.swork.checklist.service.mapper.model.ChecklistMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addCheckListEntry(userId, model, serviceContext);
	}

	public static ChecklistEntry changeStatus(
		Long userId, Long checkListId, Boolean status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().changeStatus(
			userId, checkListId, status, serviceContext);
	}

	/**
	 * Creates a new checklist entry with the primary key. Does not add the checklist entry to the database.
	 *
	 * @param checklistId the primary key for the new checklist entry
	 * @return the new checklist entry
	 */
	public static ChecklistEntry createChecklistEntry(long checklistId) {
		return getService().createChecklistEntry(checklistId);
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
	 * Deletes the checklist entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistEntry the checklist entry
	 * @return the checklist entry that was removed
	 */
	public static ChecklistEntry deleteChecklistEntry(
		ChecklistEntry checklistEntry) {

		return getService().deleteChecklistEntry(checklistEntry);
	}

	/**
	 * Deletes the checklist entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry that was removed
	 * @throws PortalException if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry deleteChecklistEntry(long checklistId)
		throws PortalException {

		return getService().deleteChecklistEntry(checklistId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistEntryModelImpl</code>.
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

	public static ChecklistEntry fetchChecklistEntry(long checklistId) {
		return getService().fetchChecklistEntry(checklistId);
	}

	/**
	 * Returns the checklist entry matching the UUID and group.
	 *
	 * @param uuid the checklist entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchChecklistEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchChecklistEntryByUuidAndGroupId(uuid, groupId);
	}

	public static ChecklistEntry findByName(String name) {
		return getService().findByName(name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of checklist entries
	 */
	public static List<ChecklistEntry> getChecklistEntries(int start, int end) {
		return getService().getChecklistEntries(start, end);
	}

	/**
	 * Returns all the checklist entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the checklist entries
	 * @param companyId the primary key of the company
	 * @return the matching checklist entries, or an empty list if no matches were found
	 */
	public static List<ChecklistEntry> getChecklistEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getChecklistEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of checklist entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the checklist entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching checklist entries, or an empty list if no matches were found
	 */
	public static List<ChecklistEntry> getChecklistEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getService().getChecklistEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checklist entries.
	 *
	 * @return the number of checklist entries
	 */
	public static int getChecklistEntriesCount() {
		return getService().getChecklistEntriesCount();
	}

	/**
	 * Returns the checklist entry with the primary key.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws PortalException if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry getChecklistEntry(long checklistId)
		throws PortalException {

		return getService().getChecklistEntry(checklistId);
	}

	/**
	 * Returns the checklist entry matching the UUID and group.
	 *
	 * @param uuid the checklist entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist entry
	 * @throws PortalException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry getChecklistEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getChecklistEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the checklist entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistEntry the checklist entry
	 * @return the checklist entry that was updated
	 */
	public static ChecklistEntry updateChecklistEntry(
		ChecklistEntry checklistEntry) {

		return getService().updateChecklistEntry(checklistEntry);
	}

	public static ChecklistEntry updateCheckListEntry(
		long userId, long checklistId,
		com.swork.checklist.service.mapper.model.ChecklistMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateCheckListEntry(
			userId, checklistId, model, serviceContext);
	}

	public static ChecklistEntryLocalService getService() {
		return _service;
	}

	private static volatile ChecklistEntryLocalService _service;

}