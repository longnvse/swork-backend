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

package com.swork.auth.department.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.auth.department.service.model.DepartmentAccountEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DepartmentAccountEntry. This utility wraps
 * <code>com.swork.auth.department.service.service.impl.DepartmentAccountEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntryLocalService
 * @generated
 */
public class DepartmentAccountEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.auth.department.service.service.impl.DepartmentAccountEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the department account entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was added
	 */
	public static DepartmentAccountEntry addDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry) {

		return getService().addDepartmentAccountEntry(departmentAccountEntry);
	}

	public static DepartmentAccountEntry addDepartmentAccountEntry(
		long departmentId, long accountId, long companyId) {

		return getService().addDepartmentAccountEntry(
			departmentId, accountId, companyId);
	}

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	public static DepartmentAccountEntry createDepartmentAccountEntry(
		long departmentAccountId) {

		return getService().createDepartmentAccountEntry(departmentAccountId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteByDepartmentId(long departmentId) {
		getService().deleteByDepartmentId(departmentId);
	}

	/**
	 * Deletes the department account entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was removed
	 */
	public static DepartmentAccountEntry deleteDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry) {

		return getService().deleteDepartmentAccountEntry(
			departmentAccountEntry);
	}

	/**
	 * Deletes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws PortalException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry deleteDepartmentAccountEntry(
			long departmentAccountId)
		throws PortalException {

		return getService().deleteDepartmentAccountEntry(departmentAccountId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
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

	public static DepartmentAccountEntry fetchDepartmentAccountEntry(
		long departmentAccountId) {

		return getService().fetchDepartmentAccountEntry(departmentAccountId);
	}

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry
		fetchDepartmentAccountEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDepartmentAccountEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDepartmentAccountEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static DepartmentAccountEntry
		fetchDepartmentAccountEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchDepartmentAccountEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the department account entry matching the UUID and group.
	 *
	 * @param uuid the department account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry
		fetchDepartmentAccountEntryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchDepartmentAccountEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DepartmentAccountEntry> getByDepartmentId(
		long departmentId) {

		return getService().getByDepartmentId(departmentId);
	}

	/**
	 * Returns a range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of department account entries
	 */
	public static List<DepartmentAccountEntry> getDepartmentAccountEntries(
		int start, int end) {

		return getService().getDepartmentAccountEntries(start, end);
	}

	/**
	 * Returns all the department account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department account entries
	 * @param companyId the primary key of the company
	 * @return the matching department account entries, or an empty list if no matches were found
	 */
	public static List<DepartmentAccountEntry>
		getDepartmentAccountEntriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getDepartmentAccountEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of department account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department account entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching department account entries, or an empty list if no matches were found
	 */
	public static List<DepartmentAccountEntry>
		getDepartmentAccountEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getService().getDepartmentAccountEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	public static int getDepartmentAccountEntriesCount() {
		return getService().getDepartmentAccountEntriesCount();
	}

	/**
	 * Returns the department account entry with the primary key.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws PortalException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry getDepartmentAccountEntry(
			long departmentAccountId)
		throws PortalException {

		return getService().getDepartmentAccountEntry(departmentAccountId);
	}

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry
	 * @throws PortalException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry
			getDepartmentAccountEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getDepartmentAccountEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the department account entry matching the UUID and group.
	 *
	 * @param uuid the department account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department account entry
	 * @throws PortalException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry
			getDepartmentAccountEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDepartmentAccountEntryByUuidAndGroupId(
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
	 * Updates the department account entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was updated
	 */
	public static DepartmentAccountEntry updateDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry) {

		return getService().updateDepartmentAccountEntry(
			departmentAccountEntry);
	}

	public static DepartmentAccountEntryLocalService getService() {
		return _service;
	}

	private static volatile DepartmentAccountEntryLocalService _service;

}