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

import com.swork.core.phase.service.model.PhaseEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PhaseEntry. This utility wraps
 * <code>com.swork.core.phase.service.service.impl.PhaseEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntryLocalService
 * @generated
 */
public class PhaseEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.core.phase.service.service.impl.PhaseEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PhaseEntry addPhase(
		long customerId, long creatorId,
		com.swork.core.phase.service.mapper.model.PhaseMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addPhase(
			customerId, creatorId, model, serviceContext);
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
	public static PhaseEntry addPhaseEntry(PhaseEntry phaseEntry) {
		return getService().addPhaseEntry(phaseEntry);
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
	 * Creates a new phase entry with the primary key. Does not add the phase entry to the database.
	 *
	 * @param phaseId the primary key for the new phase entry
	 * @return the new phase entry
	 */
	public static PhaseEntry createPhaseEntry(long phaseId) {
		return getService().createPhaseEntry(phaseId);
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
	public static PhaseEntry deletePhaseEntry(long phaseId)
		throws PortalException {

		return getService().deletePhaseEntry(phaseId);
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
	public static PhaseEntry deletePhaseEntry(PhaseEntry phaseEntry) {
		return getService().deletePhaseEntry(phaseEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.phase.service.model.impl.PhaseEntryModelImpl</code>.
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

	public static PhaseEntry fetchPhaseEntry(long phaseId) {
		return getService().fetchPhaseEntry(phaseId);
	}

	/**
	 * Returns the phase entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phase entry's external reference code
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchPhaseEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPhaseEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPhaseEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static PhaseEntry fetchPhaseEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPhaseEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the phase entry matching the UUID and group.
	 *
	 * @param uuid the phase entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchPhaseEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPhaseEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<PhaseEntry> findByProjectId(
		long customerId, long projectId) {

		return getService().findByProjectId(customerId, projectId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static PhaseEntry getByPhaseName(
		long customerId, long projectId, String phaseName) {

		return getService().getByPhaseName(customerId, projectId, phaseName);
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
	public static List<PhaseEntry> getPhaseEntries(int start, int end) {
		return getService().getPhaseEntries(start, end);
	}

	/**
	 * Returns all the phase entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the phase entries
	 * @param companyId the primary key of the company
	 * @return the matching phase entries, or an empty list if no matches were found
	 */
	public static List<PhaseEntry> getPhaseEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPhaseEntriesByUuidAndCompanyId(uuid, companyId);
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
	public static List<PhaseEntry> getPhaseEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getService().getPhaseEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of phase entries.
	 *
	 * @return the number of phase entries
	 */
	public static int getPhaseEntriesCount() {
		return getService().getPhaseEntriesCount();
	}

	/**
	 * Returns the phase entry with the primary key.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry
	 * @throws PortalException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry getPhaseEntry(long phaseId)
		throws PortalException {

		return getService().getPhaseEntry(phaseId);
	}

	/**
	 * Returns the phase entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the phase entry's external reference code
	 * @return the matching phase entry
	 * @throws PortalException if a matching phase entry could not be found
	 */
	public static PhaseEntry getPhaseEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getPhaseEntryByExternalReferenceCode(
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
	public static PhaseEntry getPhaseEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPhaseEntryByUuidAndGroupId(uuid, groupId);
	}

	public static PhaseEntry updatePhase(
			long creatorId, long phaseId,
			com.swork.core.phase.service.mapper.model.PhaseMapperModel
				phaseMapperModel,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePhase(
			creatorId, phaseId, phaseMapperModel, serviceContext);
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
	public static PhaseEntry updatePhaseEntry(PhaseEntry phaseEntry) {
		return getService().updatePhaseEntry(phaseEntry);
	}

	public static PhaseEntryLocalService getService() {
		return _service;
	}

	private static volatile PhaseEntryLocalService _service;

}