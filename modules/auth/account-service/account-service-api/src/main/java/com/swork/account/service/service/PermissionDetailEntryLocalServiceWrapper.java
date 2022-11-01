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
 * Provides a wrapper for {@link PermissionDetailEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionDetailEntryLocalService
 * @generated
 */
public class PermissionDetailEntryLocalServiceWrapper
	implements PermissionDetailEntryLocalService,
			   ServiceWrapper<PermissionDetailEntryLocalService> {

	public PermissionDetailEntryLocalServiceWrapper(
		PermissionDetailEntryLocalService permissionDetailEntryLocalService) {

		_permissionDetailEntryLocalService = permissionDetailEntryLocalService;
	}

	/**
	 * Adds the permission detail entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionDetailEntry the permission detail entry
	 * @return the permission detail entry that was added
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		addPermissionDetailEntry(
			com.swork.account.service.model.PermissionDetailEntry
				permissionDetailEntry) {

		return _permissionDetailEntryLocalService.addPermissionDetailEntry(
			permissionDetailEntry);
	}

	/**
	 * Creates a new permission detail entry with the primary key. Does not add the permission detail entry to the database.
	 *
	 * @param id the primary key for the new permission detail entry
	 * @return the new permission detail entry
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		createPermissionDetailEntry(long id) {

		return _permissionDetailEntryLocalService.createPermissionDetailEntry(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the permission detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry that was removed
	 * @throws PortalException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
			deletePermissionDetailEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.deletePermissionDetailEntry(
			id);
	}

	/**
	 * Deletes the permission detail entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionDetailEntry the permission detail entry
	 * @return the permission detail entry that was removed
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		deletePermissionDetailEntry(
			com.swork.account.service.model.PermissionDetailEntry
				permissionDetailEntry) {

		return _permissionDetailEntryLocalService.deletePermissionDetailEntry(
			permissionDetailEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _permissionDetailEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _permissionDetailEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permissionDetailEntryLocalService.dynamicQuery();
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

		return _permissionDetailEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionDetailEntryModelImpl</code>.
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

		return _permissionDetailEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionDetailEntryModelImpl</code>.
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

		return _permissionDetailEntryLocalService.dynamicQuery(
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

		return _permissionDetailEntryLocalService.dynamicQueryCount(
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

		return _permissionDetailEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		fetchPermissionDetailEntry(long id) {

		return _permissionDetailEntryLocalService.fetchPermissionDetailEntry(
			id);
	}

	/**
	 * Returns the permission detail entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission detail entry's external reference code
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		fetchPermissionDetailEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permissionDetailEntryLocalService.
			fetchPermissionDetailEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPermissionDetailEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		fetchPermissionDetailEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permissionDetailEntryLocalService.
			fetchPermissionDetailEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission detail entry with the matching UUID and company.
	 *
	 * @param uuid the permission detail entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		fetchPermissionDetailEntryByUuidAndCompanyId(
			String uuid, long companyId) {

		return _permissionDetailEntryLocalService.
			fetchPermissionDetailEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _permissionDetailEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.account.service.model.PermissionDetailEntry>
		getByAccountId(long accountId) {

		return _permissionDetailEntryLocalService.getByAccountId(accountId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _permissionDetailEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _permissionDetailEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of permission detail entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.PermissionDetailEntry>
		getPermissionDetailEntries(int start, int end) {

		return _permissionDetailEntryLocalService.getPermissionDetailEntries(
			start, end);
	}

	/**
	 * Returns the number of permission detail entries.
	 *
	 * @return the number of permission detail entries
	 */
	@Override
	public int getPermissionDetailEntriesCount() {
		return _permissionDetailEntryLocalService.
			getPermissionDetailEntriesCount();
	}

	/**
	 * Returns the permission detail entry with the primary key.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry
	 * @throws PortalException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
			getPermissionDetailEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.getPermissionDetailEntry(id);
	}

	/**
	 * Returns the permission detail entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission detail entry's external reference code
	 * @return the matching permission detail entry
	 * @throws PortalException if a matching permission detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
			getPermissionDetailEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.
			getPermissionDetailEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission detail entry with the matching UUID and company.
	 *
	 * @param uuid the permission detail entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission detail entry
	 * @throws PortalException if a matching permission detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
			getPermissionDetailEntryByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.
			getPermissionDetailEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionDetailEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the permission detail entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionDetailEntry the permission detail entry
	 * @return the permission detail entry that was updated
	 */
	@Override
	public com.swork.account.service.model.PermissionDetailEntry
		updatePermissionDetailEntry(
			com.swork.account.service.model.PermissionDetailEntry
				permissionDetailEntry) {

		return _permissionDetailEntryLocalService.updatePermissionDetailEntry(
			permissionDetailEntry);
	}

	@Override
	public PermissionDetailEntryLocalService getWrappedService() {
		return _permissionDetailEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PermissionDetailEntryLocalService permissionDetailEntryLocalService) {

		_permissionDetailEntryLocalService = permissionDetailEntryLocalService;
	}

	private PermissionDetailEntryLocalService
		_permissionDetailEntryLocalService;

}