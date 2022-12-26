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

package com.swork.core.phase.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhaseEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntryLocalService
 * @generated
 */
public class PhaseEntryLocalServiceWrapper
	implements PhaseEntryLocalService, ServiceWrapper<PhaseEntryLocalService> {

	public PhaseEntryLocalServiceWrapper(
		PhaseEntryLocalService phaseEntryLocalService) {

		_phaseEntryLocalService = phaseEntryLocalService;
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry addPhase(
		long businessId, long creatorId,
		com.swork.core.phase.service.mapper.model.PhaseMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _phaseEntryLocalService.addPhase(
			businessId, creatorId, model, serviceContext);
	}

	/**
	 * Adds the phase entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseEntry the phase entry
	 * @return the phase entry that was added
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry addPhaseEntry(
		com.swork.core.phase.service.model.PhaseEntry phaseEntry) {

		return _phaseEntryLocalService.addPhaseEntry(phaseEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phase entry with the primary key. Does not add the phase entry to the database.
	 *
	 * @param phaseId the primary key for the new phase entry
	 * @return the new phase entry
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry createPhaseEntry(
		long phaseId) {

		return _phaseEntryLocalService.createPhaseEntry(phaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phase entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry that was removed
	 * @throws PortalException if a phase entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry deletePhaseEntry(
			long phaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.deletePhaseEntry(phaseId);
	}

	/**
	 * Deletes the phase entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseEntry the phase entry
	 * @return the phase entry that was removed
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry deletePhaseEntry(
		com.swork.core.phase.service.model.PhaseEntry phaseEntry) {

		return _phaseEntryLocalService.deletePhaseEntry(phaseEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phaseEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phaseEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phaseEntryLocalService.dynamicQuery();
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

		return _phaseEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseEntryModelImpl</code>.
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

		return _phaseEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseEntryModelImpl</code>.
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

		return _phaseEntryLocalService.dynamicQuery(
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

		return _phaseEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phaseEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry fetchPhaseEntry(
		long phaseId) {

		return _phaseEntryLocalService.fetchPhaseEntry(phaseId);
	}

	/**
	 * Returns the phase entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phase entry's external reference code
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry
		fetchPhaseEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _phaseEntryLocalService.fetchPhaseEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPhaseEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.core.phase.service.model.PhaseEntry
		fetchPhaseEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _phaseEntryLocalService.fetchPhaseEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phase entry matching the UUID and group.
	 *
	 * @param uuid the phase entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry
		fetchPhaseEntryByUuidAndGroupId(String uuid, long groupId) {

		return _phaseEntryLocalService.fetchPhaseEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseEntry>
		findByProjectId(long projectId) {

		return _phaseEntryLocalService.findByProjectId(projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phaseEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry getByPhaseName(
		long businessId, long projectId, String phaseName) {

		return _phaseEntryLocalService.getByPhaseName(
			businessId, projectId, phaseName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _phaseEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phaseEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phaseEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of phase entries
	 */
	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseEntry>
		getPhaseEntries(int start, int end) {

		return _phaseEntryLocalService.getPhaseEntries(start, end);
	}

	/**
	 * Returns all the phase entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phase entries
	 * @param companyId the primary key of the company
	 * @return the matching phase entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseEntry>
		getPhaseEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _phaseEntryLocalService.getPhaseEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of phase entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phase entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching phase entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseEntry>
		getPhaseEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.core.phase.service.model.PhaseEntry>
					orderByComparator) {

		return _phaseEntryLocalService.getPhaseEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of phase entries.
	 *
	 * @return the number of phase entries
	 */
	@Override
	public int getPhaseEntriesCount() {
		return _phaseEntryLocalService.getPhaseEntriesCount();
	}

	/**
	 * Returns the phase entry with the primary key.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry
	 * @throws PortalException if a phase entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry getPhaseEntry(
			long phaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.getPhaseEntry(phaseId);
	}

	/**
	 * Returns the phase entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phase entry's external reference code
	 * @return the matching phase entry
	 * @throws PortalException if a matching phase entry could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry
			getPhaseEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.getPhaseEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phase entry matching the UUID and group.
	 *
	 * @param uuid the phase entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phase entry
	 * @throws PortalException if a matching phase entry could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry
			getPhaseEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.getPhaseEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry updateDate(
		long creatorId, long phaseId, java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _phaseEntryLocalService.updateDate(
			creatorId, phaseId, startDate, endDate, serviceContext);
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry updatePhase(
			long creatorId, long phaseId,
			com.swork.core.phase.service.mapper.model.PhaseMapperModel model,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseEntryLocalService.updatePhase(
			creatorId, phaseId, model, serviceContext);
	}

	/**
	 * Updates the phase entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseEntry the phase entry
	 * @return the phase entry that was updated
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseEntry updatePhaseEntry(
		com.swork.core.phase.service.model.PhaseEntry phaseEntry) {

		return _phaseEntryLocalService.updatePhaseEntry(phaseEntry);
	}

	@Override
	public com.swork.core.phase.service.model.PhaseEntry updateProgress(
		long phaseId, long progress) {

		return _phaseEntryLocalService.updateProgress(phaseId, progress);
	}

	@Override
	public PhaseEntryLocalService getWrappedService() {
		return _phaseEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PhaseEntryLocalService phaseEntryLocalService) {

		_phaseEntryLocalService = phaseEntryLocalService;
	}

	private PhaseEntryLocalService _phaseEntryLocalService;

}