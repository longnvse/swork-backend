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
 * Provides a wrapper for {@link ChecklistEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntryLocalService
 * @generated
 */
public class ChecklistEntryLocalServiceWrapper
	implements ChecklistEntryLocalService,
			   ServiceWrapper<ChecklistEntryLocalService> {

	public ChecklistEntryLocalServiceWrapper(
		ChecklistEntryLocalService checklistEntryLocalService) {

		_checklistEntryLocalService = checklistEntryLocalService;
	}

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
	@Override
	public com.swork.checklist.service.model.ChecklistEntry addChecklistEntry(
		com.swork.checklist.service.model.ChecklistEntry checklistEntry) {

		return _checklistEntryLocalService.addChecklistEntry(checklistEntry);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistEntry addCheckListEntry(
		long userId, String name, java.util.Date startDate,
		java.util.Date endDate, Long taskId, Boolean status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _checklistEntryLocalService.addCheckListEntry(
			userId, name, startDate, endDate, taskId, status, serviceContext);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistEntry changeStatus(
		Long userId, Long checkListId, Boolean status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _checklistEntryLocalService.changeStatus(
			userId, checkListId, status, serviceContext);
	}

	/**
	 * Creates a new checklist entry with the primary key. Does not add the checklist entry to the database.
	 *
	 * @param checklistId the primary key for the new checklist entry
	 * @return the new checklist entry
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
		createChecklistEntry(long checklistId) {

		return _checklistEntryLocalService.createChecklistEntry(checklistId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
		deleteChecklistEntry(
			com.swork.checklist.service.model.ChecklistEntry checklistEntry) {

		return _checklistEntryLocalService.deleteChecklistEntry(checklistEntry);
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
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
			deleteChecklistEntry(long checklistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.deleteChecklistEntry(checklistId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checklistEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checklistEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checklistEntryLocalService.dynamicQuery();
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

		return _checklistEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _checklistEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _checklistEntryLocalService.dynamicQuery(
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

		return _checklistEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _checklistEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistEntry fetchChecklistEntry(
		long checklistId) {

		return _checklistEntryLocalService.fetchChecklistEntry(checklistId);
	}

	/**
	 * Returns the checklist entry matching the UUID and group.
	 *
	 * @param uuid the checklist entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
		fetchChecklistEntryByUuidAndGroupId(String uuid, long groupId) {

		return _checklistEntryLocalService.fetchChecklistEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistEntry findByName(
		String name) {

		return _checklistEntryLocalService.findByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checklistEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.swork.checklist.service.model.ChecklistEntry>
		getChecklistEntries(int start, int end) {

		return _checklistEntryLocalService.getChecklistEntries(start, end);
	}

	/**
	 * Returns all the checklist entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the checklist entries
	 * @param companyId the primary key of the company
	 * @return the matching checklist entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.checklist.service.model.ChecklistEntry>
		getChecklistEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _checklistEntryLocalService.
			getChecklistEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.swork.checklist.service.model.ChecklistEntry>
		getChecklistEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.checklist.service.model.ChecklistEntry>
					orderByComparator) {

		return _checklistEntryLocalService.
			getChecklistEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checklist entries.
	 *
	 * @return the number of checklist entries
	 */
	@Override
	public int getChecklistEntriesCount() {
		return _checklistEntryLocalService.getChecklistEntriesCount();
	}

	/**
	 * Returns the checklist entry with the primary key.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws PortalException if a checklist entry with the primary key could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistEntry getChecklistEntry(
			long checklistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.getChecklistEntry(checklistId);
	}

	/**
	 * Returns the checklist entry matching the UUID and group.
	 *
	 * @param uuid the checklist entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching checklist entry
	 * @throws PortalException if a matching checklist entry could not be found
	 */
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
			getChecklistEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.getChecklistEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _checklistEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checklistEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checklistEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checklistEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.swork.checklist.service.model.ChecklistEntry
		updateChecklistEntry(
			com.swork.checklist.service.model.ChecklistEntry checklistEntry) {

		return _checklistEntryLocalService.updateChecklistEntry(checklistEntry);
	}

	@Override
	public com.swork.checklist.service.model.ChecklistEntry
		updateCheckListEntry(
			Long userId, Long cid, String name, java.util.Date startDate,
			java.util.Date endDate, Long taskId, Boolean status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _checklistEntryLocalService.updateCheckListEntry(
			userId, cid, name, startDate, endDate, taskId, status,
			serviceContext);
	}

	@Override
	public ChecklistEntryLocalService getWrappedService() {
		return _checklistEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ChecklistEntryLocalService checklistEntryLocalService) {

		_checklistEntryLocalService = checklistEntryLocalService;
	}

	private ChecklistEntryLocalService _checklistEntryLocalService;

}