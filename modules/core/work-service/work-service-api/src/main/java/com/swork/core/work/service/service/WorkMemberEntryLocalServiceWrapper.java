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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkMemberEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkMemberEntryLocalService
 * @generated
 */
public class WorkMemberEntryLocalServiceWrapper
	implements ServiceWrapper<WorkMemberEntryLocalService>,
			   WorkMemberEntryLocalService {

	public WorkMemberEntryLocalServiceWrapper(
		WorkMemberEntryLocalService workMemberEntryLocalService) {

		_workMemberEntryLocalService = workMemberEntryLocalService;
	}

	@Override
	public com.swork.core.work.service.model.WorkMemberEntry addWorkMemberEntry(
		long workId,
		com.swork.core.work.service.mapper.model.WorkMemberMapperModel model,
		String type) {

		return _workMemberEntryLocalService.addWorkMemberEntry(
			workId, model, type);
	}

	/**
	 * Adds the work member entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workMemberEntry the work member entry
	 * @return the work member entry that was added
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry addWorkMemberEntry(
		com.swork.core.work.service.model.WorkMemberEntry workMemberEntry) {

		return _workMemberEntryLocalService.addWorkMemberEntry(workMemberEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workMemberEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work member entry with the primary key. Does not add the work member entry to the database.
	 *
	 * @param workMemberId the primary key for the new work member entry
	 * @return the new work member entry
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry
		createWorkMemberEntry(long workMemberId) {

		return _workMemberEntryLocalService.createWorkMemberEntry(workMemberId);
	}

	@Override
	public void deleteByWorkId(long workId) {
		_workMemberEntryLocalService.deleteByWorkId(workId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workMemberEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the work member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry that was removed
	 * @throws PortalException if a work member entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry
			deleteWorkMemberEntry(long workMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workMemberEntryLocalService.deleteWorkMemberEntry(workMemberId);
	}

	/**
	 * Deletes the work member entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workMemberEntry the work member entry
	 * @return the work member entry that was removed
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry
		deleteWorkMemberEntry(
			com.swork.core.work.service.model.WorkMemberEntry workMemberEntry) {

		return _workMemberEntryLocalService.deleteWorkMemberEntry(
			workMemberEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workMemberEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workMemberEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workMemberEntryLocalService.dynamicQuery();
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

		return _workMemberEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkMemberEntryModelImpl</code>.
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

		return _workMemberEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkMemberEntryModelImpl</code>.
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

		return _workMemberEntryLocalService.dynamicQuery(
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

		return _workMemberEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workMemberEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.work.service.model.WorkMemberEntry
		fetchWorkMemberEntry(long workMemberId) {

		return _workMemberEntryLocalService.fetchWorkMemberEntry(workMemberId);
	}

	@Override
	public java.util.List<com.swork.core.work.service.model.WorkMemberEntry>
		findByW_MT_T(long workId, String memberType, String type) {

		return _workMemberEntryLocalService.findByW_MT_T(
			workId, memberType, type);
	}

	@Override
	public java.util.List<com.swork.core.work.service.model.WorkMemberEntry>
		findByW_T(long workId, String type) {

		return _workMemberEntryLocalService.findByW_T(workId, type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workMemberEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workMemberEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workMemberEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workMemberEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of work member entries
	 */
	@Override
	public java.util.List<com.swork.core.work.service.model.WorkMemberEntry>
		getWorkMemberEntries(int start, int end) {

		return _workMemberEntryLocalService.getWorkMemberEntries(start, end);
	}

	/**
	 * Returns the number of work member entries.
	 *
	 * @return the number of work member entries
	 */
	@Override
	public int getWorkMemberEntriesCount() {
		return _workMemberEntryLocalService.getWorkMemberEntriesCount();
	}

	/**
	 * Returns the work member entry with the primary key.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry
	 * @throws PortalException if a work member entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry getWorkMemberEntry(
			long workMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workMemberEntryLocalService.getWorkMemberEntry(workMemberId);
	}

	/**
	 * Updates the work member entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workMemberEntry the work member entry
	 * @return the work member entry that was updated
	 */
	@Override
	public com.swork.core.work.service.model.WorkMemberEntry
		updateWorkMemberEntry(
			com.swork.core.work.service.model.WorkMemberEntry workMemberEntry) {

		return _workMemberEntryLocalService.updateWorkMemberEntry(
			workMemberEntry);
	}

	@Override
	public WorkMemberEntryLocalService getWrappedService() {
		return _workMemberEntryLocalService;
	}

	@Override
	public void setWrappedService(
		WorkMemberEntryLocalService workMemberEntryLocalService) {

		_workMemberEntryLocalService = workMemberEntryLocalService;
	}

	private WorkMemberEntryLocalService _workMemberEntryLocalService;

}