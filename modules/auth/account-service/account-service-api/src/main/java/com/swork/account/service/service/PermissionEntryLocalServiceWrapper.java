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

package com.swork.account.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionEntryLocalService
 * @generated
 */
public class PermissionEntryLocalServiceWrapper
	implements PermissionEntryLocalService,
			   ServiceWrapper<PermissionEntryLocalService> {

	public PermissionEntryLocalServiceWrapper(
		PermissionEntryLocalService permissionEntryLocalService) {

		_permissionEntryLocalService = permissionEntryLocalService;
	}

	/**
	 * Adds the permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was added
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry addPermissionEntry(
		com.swork.account.service.model.PermissionEntry permissionEntry) {

		return _permissionEntryLocalService.addPermissionEntry(permissionEntry);
	}

	/**
	 * Creates a new permission entry with the primary key. Does not add the permission entry to the database.
	 *
	 * @param id the primary key for the new permission entry
	 * @return the new permission entry
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
		createPermissionEntry(long id) {

		return _permissionEntryLocalService.createPermissionEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry that was removed
	 * @throws PortalException if a permission entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
			deletePermissionEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.deletePermissionEntry(id);
	}

	/**
	 * Deletes the permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was removed
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
		deletePermissionEntry(
			com.swork.account.service.model.PermissionEntry permissionEntry) {

		return _permissionEntryLocalService.deletePermissionEntry(
			permissionEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _permissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _permissionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permissionEntryLocalService.dynamicQuery();
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

		return _permissionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
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

		return _permissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
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

		return _permissionEntryLocalService.dynamicQuery(
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

		return _permissionEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _permissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.PermissionEntry fetchPermissionEntry(
		long id) {

		return _permissionEntryLocalService.fetchPermissionEntry(id);
	}

	/**
	 * Returns the permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission entry's external reference code
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
		fetchPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permissionEntryLocalService.
			fetchPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.PermissionEntry
		fetchPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permissionEntryLocalService.fetchPermissionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission entry with the matching UUID and company.
	 *
	 * @param uuid the permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
		fetchPermissionEntryByUuidAndCompanyId(String uuid, long companyId) {

		return _permissionEntryLocalService.
			fetchPermissionEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _permissionEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _permissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _permissionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @return the range of permission entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.PermissionEntry>
		getPermissionEntries(int start, int end) {

		return _permissionEntryLocalService.getPermissionEntries(start, end);
	}

	/**
	 * Returns the number of permission entries.
	 *
	 * @return the number of permission entries
	 */
	@Override
	public int getPermissionEntriesCount() {
		return _permissionEntryLocalService.getPermissionEntriesCount();
	}

	/**
	 * Returns the permission entry with the primary key.
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry
	 * @throws PortalException if a permission entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry getPermissionEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.getPermissionEntry(id);
	}

	/**
	 * Returns the permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission entry's external reference code
	 * @return the matching permission entry
	 * @throws PortalException if a matching permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
			getPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.
			getPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission entry with the matching UUID and company.
	 *
	 * @param uuid the permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission entry
	 * @throws PortalException if a matching permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
			getPermissionEntryByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.
			getPermissionEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was updated
	 */
	@Override
	public com.swork.account.service.model.PermissionEntry
		updatePermissionEntry(
			com.swork.account.service.model.PermissionEntry permissionEntry) {

		return _permissionEntryLocalService.updatePermissionEntry(
			permissionEntry);
	}

	@Override
	public PermissionEntryLocalService getWrappedService() {
		return _permissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PermissionEntryLocalService permissionEntryLocalService) {

		_permissionEntryLocalService = permissionEntryLocalService;
	}

	private PermissionEntryLocalService _permissionEntryLocalService;

}