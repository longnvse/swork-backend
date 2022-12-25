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
 * Provides a wrapper for {@link PhaseManageEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntryLocalService
 * @generated
 */
public class PhaseManageEntryLocalServiceWrapper
	implements PhaseManageEntryLocalService,
			   ServiceWrapper<PhaseManageEntryLocalService> {

	public PhaseManageEntryLocalServiceWrapper(
		PhaseManageEntryLocalService phaseManageEntryLocalService) {

		_phaseManageEntryLocalService = phaseManageEntryLocalService;
	}

	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry addPhaseManage(
		long phaseId, long accountId) {

		return _phaseManageEntryLocalService.addPhaseManage(phaseId, accountId);
	}

	/**
	 * Adds the phase manage entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseManageEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseManageEntry the phase manage entry
	 * @return the phase manage entry that was added
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
		addPhaseManageEntry(
			com.swork.core.phase.service.model.PhaseManageEntry
				phaseManageEntry) {

		return _phaseManageEntryLocalService.addPhaseManageEntry(
			phaseManageEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseManageEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new phase manage entry with the primary key. Does not add the phase manage entry to the database.
	 *
	 * @param phaseManageId the primary key for the new phase manage entry
	 * @return the new phase manage entry
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
		createPhaseManageEntry(long phaseManageId) {

		return _phaseManageEntryLocalService.createPhaseManageEntry(
			phaseManageId);
	}

	@Override
	public void deleteByPhaseId(long phaseId) {
		_phaseManageEntryLocalService.deleteByPhaseId(phaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseManageEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the phase manage entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseManageEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry that was removed
	 * @throws PortalException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
			deletePhaseManageEntry(long phaseManageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseManageEntryLocalService.deletePhaseManageEntry(
			phaseManageId);
	}

	/**
	 * Deletes the phase manage entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseManageEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseManageEntry the phase manage entry
	 * @return the phase manage entry that was removed
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
		deletePhaseManageEntry(
			com.swork.core.phase.service.model.PhaseManageEntry
				phaseManageEntry) {

		return _phaseManageEntryLocalService.deletePhaseManageEntry(
			phaseManageEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phaseManageEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phaseManageEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phaseManageEntryLocalService.dynamicQuery();
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

		return _phaseManageEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl</code>.
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

		return _phaseManageEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl</code>.
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

		return _phaseManageEntryLocalService.dynamicQuery(
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

		return _phaseManageEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phaseManageEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
		fetchPhaseManageEntry(long phaseManageId) {

		return _phaseManageEntryLocalService.fetchPhaseManageEntry(
			phaseManageId);
	}

	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseManageEntry>
		findByPhaseId(long phaseId) {

		return _phaseManageEntryLocalService.findByPhaseId(phaseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phaseManageEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phaseManageEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phaseManageEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseManageEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @return the range of phase manage entries
	 */
	@Override
	public java.util.List<com.swork.core.phase.service.model.PhaseManageEntry>
		getPhaseManageEntries(int start, int end) {

		return _phaseManageEntryLocalService.getPhaseManageEntries(start, end);
	}

	/**
	 * Returns the number of phase manage entries.
	 *
	 * @return the number of phase manage entries
	 */
	@Override
	public int getPhaseManageEntriesCount() {
		return _phaseManageEntryLocalService.getPhaseManageEntriesCount();
	}

	/**
	 * Returns the phase manage entry with the primary key.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws PortalException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
			getPhaseManageEntry(long phaseManageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phaseManageEntryLocalService.getPhaseManageEntry(phaseManageId);
	}

	/**
	 * Updates the phase manage entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhaseManageEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phaseManageEntry the phase manage entry
	 * @return the phase manage entry that was updated
	 */
	@Override
	public com.swork.core.phase.service.model.PhaseManageEntry
		updatePhaseManageEntry(
			com.swork.core.phase.service.model.PhaseManageEntry
				phaseManageEntry) {

		return _phaseManageEntryLocalService.updatePhaseManageEntry(
			phaseManageEntry);
	}

	@Override
	public PhaseManageEntryLocalService getWrappedService() {
		return _phaseManageEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PhaseManageEntryLocalService phaseManageEntryLocalService) {

		_phaseManageEntryLocalService = phaseManageEntryLocalService;
	}

	private PhaseManageEntryLocalService _phaseManageEntryLocalService;

}