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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.phase.service.model.PhaseManageEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PhaseManageEntry. This utility wraps
 * <code>com.swork.core.phase.service.service.impl.PhaseManageEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntryLocalService
 * @generated
 */
public class PhaseManageEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.phase.service.service.impl.PhaseManageEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PhaseManageEntry addPhaseManage(
		long phaseId, long accountId) {

		return getService().addPhaseManage(phaseId, accountId);
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
	public static PhaseManageEntry addPhaseManageEntry(
		PhaseManageEntry phaseManageEntry) {

		return getService().addPhaseManageEntry(phaseManageEntry);
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
	 * Creates a new phase manage entry with the primary key. Does not add the phase manage entry to the database.
	 *
	 * @param phaseManageId the primary key for the new phase manage entry
	 * @return the new phase manage entry
	 */
	public static PhaseManageEntry createPhaseManageEntry(long phaseManageId) {
		return getService().createPhaseManageEntry(phaseManageId);
	}

	public static void deleteByPhaseId(long phaseId) {
		getService().deleteByPhaseId(phaseId);
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
	public static PhaseManageEntry deletePhaseManageEntry(long phaseManageId)
		throws PortalException {

		return getService().deletePhaseManageEntry(phaseManageId);
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
	public static PhaseManageEntry deletePhaseManageEntry(
		PhaseManageEntry phaseManageEntry) {

		return getService().deletePhaseManageEntry(phaseManageEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl</code>.
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

	public static PhaseManageEntry fetchPhaseManageEntry(long phaseManageId) {
		return getService().fetchPhaseManageEntry(phaseManageId);
	}

	public static List<PhaseManageEntry> findByPhaseId(long phaseId) {
		return getService().findByPhaseId(phaseId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<PhaseManageEntry> getPhaseManageEntries(
		int start, int end) {

		return getService().getPhaseManageEntries(start, end);
	}

	/**
	 * Returns the number of phase manage entries.
	 *
	 * @return the number of phase manage entries
	 */
	public static int getPhaseManageEntriesCount() {
		return getService().getPhaseManageEntriesCount();
	}

	/**
	 * Returns the phase manage entry with the primary key.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws PortalException if a phase manage entry with the primary key could not be found
	 */
	public static PhaseManageEntry getPhaseManageEntry(long phaseManageId)
		throws PortalException {

		return getService().getPhaseManageEntry(phaseManageId);
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
	public static PhaseManageEntry updatePhaseManageEntry(
		PhaseManageEntry phaseManageEntry) {

		return getService().updatePhaseManageEntry(phaseManageEntry);
	}

	public static PhaseManageEntryLocalService getService() {
		return _service;
	}

	private static volatile PhaseManageEntryLocalService _service;

}