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

import com.swork.checklist.service.model.ChecklistHandlerEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ChecklistHandlerEntry. This utility wraps
 * <code>com.swork.checklist.service.service.impl.ChecklistHandlerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntryLocalService
 * @generated
 */
public class ChecklistHandlerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.checklist.service.service.impl.ChecklistHandlerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the checklist handler entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistHandlerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 * @return the checklist handler entry that was added
	 */
	public static ChecklistHandlerEntry addChecklistHandlerEntry(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return getService().addChecklistHandlerEntry(checklistHandlerEntry);
	}

	public static ChecklistHandlerEntry addCheckListHandlerEntry(
		Long checkListId, Long accId) {

		return getService().addCheckListHandlerEntry(checkListId, accId);
	}

	/**
	 * Creates a new checklist handler entry with the primary key. Does not add the checklist handler entry to the database.
	 *
	 * @param checklistHandlerId the primary key for the new checklist handler entry
	 * @return the new checklist handler entry
	 */
	public static ChecklistHandlerEntry createChecklistHandlerEntry(
		long checklistHandlerId) {

		return getService().createChecklistHandlerEntry(checklistHandlerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteByChecklistId(long checklistId) {
		getService().deleteByChecklistId(checklistId);
	}

	/**
	 * Deletes the checklist handler entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistHandlerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 * @return the checklist handler entry that was removed
	 */
	public static ChecklistHandlerEntry deleteChecklistHandlerEntry(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return getService().deleteChecklistHandlerEntry(checklistHandlerEntry);
	}

	/**
	 * Deletes the checklist handler entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistHandlerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry that was removed
	 * @throws PortalException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry deleteChecklistHandlerEntry(
			long checklistHandlerId)
		throws PortalException {

		return getService().deleteChecklistHandlerEntry(checklistHandlerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistHandlerEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistHandlerEntryModelImpl</code>.
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

	public static ChecklistHandlerEntry fetchChecklistHandlerEntry(
		long checklistHandlerId) {

		return getService().fetchChecklistHandlerEntry(checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry matching the UUID and group.
	 *
	 * @param uuid the checklist handler entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry
		fetchChecklistHandlerEntryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchChecklistHandlerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<ChecklistHandlerEntry> getByCheckListId(
		long checkListId) {

		return getService().getByCheckListId(checkListId);
	}

	/**
	 * Returns a range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.checklist.service.model.impl.ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of checklist handler entries
	 */
	public static List<ChecklistHandlerEntry> getChecklistHandlerEntries(
		int start, int end) {

		return getService().getChecklistHandlerEntries(start, end);
	}

	/**
	 * Returns the number of checklist handler entries.
	 *
	 * @return the number of checklist handler entries
	 */
	public static int getChecklistHandlerEntriesCount() {
		return getService().getChecklistHandlerEntriesCount();
	}

	/**
	 * Returns the checklist handler entry with the primary key.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws PortalException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry getChecklistHandlerEntry(
			long checklistHandlerId)
		throws PortalException {

		return getService().getChecklistHandlerEntry(checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry matching the UUID and group.
	 *
	 * @param uuid the checklist handler entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist handler entry
	 * @throws PortalException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry
			getChecklistHandlerEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getChecklistHandlerEntryByUuidAndGroupId(
			uuid, groupId);
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
	 * Updates the checklist handler entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChecklistHandlerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 * @return the checklist handler entry that was updated
	 */
	public static ChecklistHandlerEntry updateChecklistHandlerEntry(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return getService().updateChecklistHandlerEntry(checklistHandlerEntry);
	}

	public static ChecklistHandlerEntryLocalService getService() {
		return _service;
	}

	private static volatile ChecklistHandlerEntryLocalService _service;

}