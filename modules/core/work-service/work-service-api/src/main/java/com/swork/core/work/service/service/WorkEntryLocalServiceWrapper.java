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
 * Provides a wrapper for {@link WorkEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntryLocalService
 * @generated
 */
public class WorkEntryLocalServiceWrapper
	implements ServiceWrapper<WorkEntryLocalService>, WorkEntryLocalService {

	public WorkEntryLocalServiceWrapper(
		WorkEntryLocalService workEntryLocalService) {

		_workEntryLocalService = workEntryLocalService;
	}

	@Override
	public com.swork.core.work.service.model.WorkEntry addWorkEntry(
		long creatorId, long businessId,
		com.swork.core.work.service.mapper.model.WorkMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _workEntryLocalService.addWorkEntry(
			creatorId, businessId, model, serviceContext);
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
	@Override
	public com.swork.core.work.service.model.WorkEntry addWorkEntry(
		com.swork.core.work.service.model.WorkEntry workEntry) {

		return _workEntryLocalService.addWorkEntry(workEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	@Override
	public com.swork.core.work.service.model.WorkEntry createWorkEntry(
		long workId) {

		return _workEntryLocalService.createWorkEntry(workId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.swork.core.work.service.model.WorkEntry deleteWorkEntry(
			long workId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.deleteWorkEntry(workId);
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
	@Override
	public com.swork.core.work.service.model.WorkEntry deleteWorkEntry(
		com.swork.core.work.service.model.WorkEntry workEntry) {

		return _workEntryLocalService.deleteWorkEntry(workEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workEntryLocalService.dynamicQuery();
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

		return _workEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _workEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _workEntryLocalService.dynamicQuery(
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

		return _workEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.work.service.model.WorkEntry fetchWorkEntry(
		long workId) {

		return _workEntryLocalService.fetchWorkEntry(workId);
	}

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkEntry
		fetchWorkEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _workEntryLocalService.fetchWorkEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchWorkEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.work.service.model.WorkEntry
		fetchWorkEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _workEntryLocalService.fetchWorkEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the work entry matching the UUID and group.
	 *
	 * @param uuid the work entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkEntry
		fetchWorkEntryByUuidAndGroupId(String uuid, long groupId) {

		return _workEntryLocalService.fetchWorkEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.work.service.model.WorkEntry findByP_Name(
		long projectId, String name) {

		return _workEntryLocalService.findByP_Name(projectId, name);
	}

	@Override
	public java.util.List<com.swork.core.work.service.model.WorkEntry>
		findByParentId(long businessId, long parentId) {

		return _workEntryLocalService.findByParentId(businessId, parentId);
	}

	@Override
	public com.swork.core.work.service.model.WorkEntry findByPID_Name(
		long businessId, long parentId, String name) {

		return _workEntryLocalService.findByPID_Name(
			businessId, parentId, name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _workEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.swork.core.work.service.model.WorkEntry>
		getWorkEntries(int start, int end) {

		return _workEntryLocalService.getWorkEntries(start, end);
	}

	/**
	 * Returns all the work entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the work entries
	 * @param companyId the primary key of the company
	 * @return the matching work entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.work.service.model.WorkEntry>
		getWorkEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _workEntryLocalService.getWorkEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.swork.core.work.service.model.WorkEntry>
		getWorkEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.core.work.service.model.WorkEntry>
					orderByComparator) {

		return _workEntryLocalService.getWorkEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	@Override
	public int getWorkEntriesCount() {
		return _workEntryLocalService.getWorkEntriesCount();
	}

	/**
	 * Returns the work entry with the primary key.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws PortalException if a work entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkEntry getWorkEntry(long workId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.getWorkEntry(workId);
	}

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry
	 * @throws PortalException if a matching work entry could not be found
	 */
	@Override
	public com.swork.core.work.service.model.WorkEntry
			getWorkEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.getWorkEntryByExternalReferenceCode(
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
	@Override
	public com.swork.core.work.service.model.WorkEntry
			getWorkEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workEntryLocalService.getWorkEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.work.service.model.WorkEntry updateWorkEntry(
		long creatorId, long workId,
		com.swork.core.work.service.mapper.model.WorkMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _workEntryLocalService.updateWorkEntry(
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
	@Override
	public com.swork.core.work.service.model.WorkEntry updateWorkEntry(
		com.swork.core.work.service.model.WorkEntry workEntry) {

		return _workEntryLocalService.updateWorkEntry(workEntry);
	}

	@Override
	public WorkEntryLocalService getWrappedService() {
		return _workEntryLocalService;
	}

	@Override
	public void setWrappedService(WorkEntryLocalService workEntryLocalService) {
		_workEntryLocalService = workEntryLocalService;
	}

	private WorkEntryLocalService _workEntryLocalService;

}