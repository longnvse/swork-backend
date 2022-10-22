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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChecklistHandlerEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntryLocalService
 * @generated
 */
public class ChecklistHandlerEntryLocalServiceWrapper
	implements ChecklistHandlerEntryLocalService,
			   ServiceWrapper<ChecklistHandlerEntryLocalService> {

	public ChecklistHandlerEntryLocalServiceWrapper(
		ChecklistHandlerEntryLocalService checklistHandlerEntryLocalService) {

		_checklistHandlerEntryLocalService = checklistHandlerEntryLocalService;
	}

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
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		addChecklistHandlerEntry(
			com.swork.checklist.service.model.ChecklistHandlerEntry
				checklistHandlerEntry) {

		return _checklistHandlerEntryLocalService.addChecklistHandlerEntry(
			checklistHandlerEntry);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		addCheckListHandlerEntry(Long checkListId, Long accId) {

		return _checklistHandlerEntryLocalService.addCheckListHandlerEntry(
			checkListId, accId);
	}

	/**
	 * Creates a new checklist handler entry with the primary key. Does not add the checklist handler entry to the database.
	 *
	 * @param checklistHandlerId the primary key for the new checklist handler entry
	 * @return the new checklist handler entry
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		createChecklistHandlerEntry(long checklistHandlerId) {

		return _checklistHandlerEntryLocalService.createChecklistHandlerEntry(
			checklistHandlerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteByChecklistId(long checklistId) {
		_checklistHandlerEntryLocalService.deleteByChecklistId(checklistId);
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
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		deleteChecklistHandlerEntry(
			com.swork.checklist.service.model.ChecklistHandlerEntry
				checklistHandlerEntry) {

		return _checklistHandlerEntryLocalService.deleteChecklistHandlerEntry(
			checklistHandlerEntry);
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
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
			deleteChecklistHandlerEntry(long checklistHandlerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.deleteChecklistHandlerEntry(
			checklistHandlerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checklistHandlerEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checklistHandlerEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checklistHandlerEntryLocalService.dynamicQuery();
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

		return _checklistHandlerEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _checklistHandlerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _checklistHandlerEntryLocalService.dynamicQuery(
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

		return _checklistHandlerEntryLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _checklistHandlerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		fetchChecklistHandlerEntry(long checklistHandlerId) {

		return _checklistHandlerEntryLocalService.fetchChecklistHandlerEntry(
			checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry matching the UUID and group.
	 *
	 * @param uuid the checklist handler entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		fetchChecklistHandlerEntryByUuidAndGroupId(String uuid, long groupId) {

		return _checklistHandlerEntryLocalService.
			fetchChecklistHandlerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checklistHandlerEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.swork.checklist.service.model.ChecklistHandlerEntry>
			getByCheckListId(long checkListId) {

		return _checklistHandlerEntryLocalService.getByCheckListId(checkListId);
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
	@Override
	public java.util.List
		<com.swork.checklist.service.model.ChecklistHandlerEntry>
			getChecklistHandlerEntries(int start, int end) {

		return _checklistHandlerEntryLocalService.getChecklistHandlerEntries(
			start, end);
	}

	/**
	 * Returns the number of checklist handler entries.
	 *
	 * @return the number of checklist handler entries
	 */
	@Override
	public int getChecklistHandlerEntriesCount() {
		return _checklistHandlerEntryLocalService.
			getChecklistHandlerEntriesCount();
	}

	/**
	 * Returns the checklist handler entry with the primary key.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws PortalException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
			getChecklistHandlerEntry(long checklistHandlerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.getChecklistHandlerEntry(
			checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry matching the UUID and group.
	 *
	 * @param uuid the checklist handler entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist handler entry
	 * @throws PortalException if a matching checklist handler entry could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
			getChecklistHandlerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.
			getChecklistHandlerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checklistHandlerEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checklistHandlerEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistHandlerEntryLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.swork.checklist.service.model.ChecklistHandlerEntry
		updateChecklistHandlerEntry(
			com.swork.checklist.service.model.ChecklistHandlerEntry
				checklistHandlerEntry) {

		return _checklistHandlerEntryLocalService.updateChecklistHandlerEntry(
			checklistHandlerEntry);
	}

	@Override
	public ChecklistHandlerEntryLocalService getWrappedService() {
		return _checklistHandlerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ChecklistHandlerEntryLocalService checklistHandlerEntryLocalService) {

		_checklistHandlerEntryLocalService = checklistHandlerEntryLocalService;
	}

	private ChecklistHandlerEntryLocalService
		_checklistHandlerEntryLocalService;

}