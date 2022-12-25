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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepartmentAccountEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntryLocalService
 * @generated
 */
public class DepartmentAccountEntryLocalServiceWrapper
	implements DepartmentAccountEntryLocalService,
			   ServiceWrapper<DepartmentAccountEntryLocalService> {

	public DepartmentAccountEntryLocalServiceWrapper(
		DepartmentAccountEntryLocalService departmentAccountEntryLocalService) {

		_departmentAccountEntryLocalService =
			departmentAccountEntryLocalService;
	}

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
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		addDepartmentAccountEntry(
			com.swork.auth.department.service.model.DepartmentAccountEntry
				departmentAccountEntry) {

		return _departmentAccountEntryLocalService.addDepartmentAccountEntry(
			departmentAccountEntry);
	}

	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		addDepartmentAccountEntry(
			long departmentId, long accountId, long companyId) {

		return _departmentAccountEntryLocalService.addDepartmentAccountEntry(
			departmentId, accountId, companyId);
	}

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		createDepartmentAccountEntry(long departmentAccountId) {

		return _departmentAccountEntryLocalService.createDepartmentAccountEntry(
			departmentAccountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void deleteByDepartmentId(long departmentId) {
		_departmentAccountEntryLocalService.deleteByDepartmentId(departmentId);
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
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		deleteDepartmentAccountEntry(
			com.swork.auth.department.service.model.DepartmentAccountEntry
				departmentAccountEntry) {

		return _departmentAccountEntryLocalService.deleteDepartmentAccountEntry(
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
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
			deleteDepartmentAccountEntry(long departmentAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.deleteDepartmentAccountEntry(
			departmentAccountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _departmentAccountEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _departmentAccountEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departmentAccountEntryLocalService.dynamicQuery();
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

		return _departmentAccountEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _departmentAccountEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _departmentAccountEntryLocalService.dynamicQuery(
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

		return _departmentAccountEntryLocalService.dynamicQueryCount(
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

		return _departmentAccountEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		fetchDepartmentAccountEntry(long departmentAccountId) {

		return _departmentAccountEntryLocalService.fetchDepartmentAccountEntry(
			departmentAccountId);
	}

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		fetchDepartmentAccountEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _departmentAccountEntryLocalService.
			fetchDepartmentAccountEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDepartmentAccountEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		fetchDepartmentAccountEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _departmentAccountEntryLocalService.
			fetchDepartmentAccountEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the department account entry matching the UUID and group.
	 *
	 * @param uuid the department account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		fetchDepartmentAccountEntryByUuidAndGroupId(String uuid, long groupId) {

		return _departmentAccountEntryLocalService.
			fetchDepartmentAccountEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _departmentAccountEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		getByAccountId(long accountId) {

		return _departmentAccountEntryLocalService.getByAccountId(accountId);
	}

	@Override
	public java.util.List
		<com.swork.auth.department.service.model.DepartmentAccountEntry>
			getByDepartmentId(long departmentId) {

		return _departmentAccountEntryLocalService.getByDepartmentId(
			departmentId);
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
	@Override
	public java.util.List
		<com.swork.auth.department.service.model.DepartmentAccountEntry>
			getDepartmentAccountEntries(int start, int end) {

		return _departmentAccountEntryLocalService.getDepartmentAccountEntries(
			start, end);
	}

	/**
	 * Returns all the department account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department account entries
	 * @param companyId the primary key of the company
	 * @return the matching department account entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.swork.auth.department.service.model.DepartmentAccountEntry>
			getDepartmentAccountEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _departmentAccountEntryLocalService.
			getDepartmentAccountEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.swork.auth.department.service.model.DepartmentAccountEntry>
			getDepartmentAccountEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.swork.auth.department.service.model.
						DepartmentAccountEntry> orderByComparator) {

		return _departmentAccountEntryLocalService.
			getDepartmentAccountEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	@Override
	public int getDepartmentAccountEntriesCount() {
		return _departmentAccountEntryLocalService.
			getDepartmentAccountEntriesCount();
	}

	/**
	 * Returns the department account entry with the primary key.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws PortalException if a department account entry with the primary key could not be found
	 */
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
			getDepartmentAccountEntry(long departmentAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.getDepartmentAccountEntry(
			departmentAccountId);
	}

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry
	 * @throws PortalException if a matching department account entry could not be found
	 */
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
			getDepartmentAccountEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.
			getDepartmentAccountEntryByExternalReferenceCode(
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
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
			getDepartmentAccountEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.
			getDepartmentAccountEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _departmentAccountEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentAccountEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentAccountEntryLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.swork.auth.department.service.model.DepartmentAccountEntry
		updateDepartmentAccountEntry(
			com.swork.auth.department.service.model.DepartmentAccountEntry
				departmentAccountEntry) {

		return _departmentAccountEntryLocalService.updateDepartmentAccountEntry(
			departmentAccountEntry);
	}

	@Override
	public DepartmentAccountEntryLocalService getWrappedService() {
		return _departmentAccountEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DepartmentAccountEntryLocalService departmentAccountEntryLocalService) {

		_departmentAccountEntryLocalService =
			departmentAccountEntryLocalService;
	}

	private DepartmentAccountEntryLocalService
		_departmentAccountEntryLocalService;

}