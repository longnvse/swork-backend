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
 * Provides a wrapper for {@link PermisionDetailEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PermisionDetailEntryLocalService
 * @generated
 */
public class PermisionDetailEntryLocalServiceWrapper
	implements PermisionDetailEntryLocalService,
			   ServiceWrapper<PermisionDetailEntryLocalService> {

	public PermisionDetailEntryLocalServiceWrapper(
		PermisionDetailEntryLocalService permisionDetailEntryLocalService) {

		_permisionDetailEntryLocalService = permisionDetailEntryLocalService;
	}

	/**
	 * Adds the permision detail entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionDetailEntry the permision detail entry
	 * @return the permision detail entry that was added
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		addPermisionDetailEntry(
			com.swork.account.service.model.PermisionDetailEntry
				permisionDetailEntry) {

		return _permisionDetailEntryLocalService.addPermisionDetailEntry(
			permisionDetailEntry);
	}

	/**
	 * Creates a new permision detail entry with the primary key. Does not add the permision detail entry to the database.
	 *
	 * @param id the primary key for the new permision detail entry
	 * @return the new permision detail entry
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		createPermisionDetailEntry(long id) {

		return _permisionDetailEntryLocalService.createPermisionDetailEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the permision detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry that was removed
	 * @throws PortalException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
			deletePermisionDetailEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.deletePermisionDetailEntry(id);
	}

	/**
	 * Deletes the permision detail entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionDetailEntry the permision detail entry
	 * @return the permision detail entry that was removed
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		deletePermisionDetailEntry(
			com.swork.account.service.model.PermisionDetailEntry
				permisionDetailEntry) {

		return _permisionDetailEntryLocalService.deletePermisionDetailEntry(
			permisionDetailEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _permisionDetailEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _permisionDetailEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permisionDetailEntryLocalService.dynamicQuery();
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

		return _permisionDetailEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionDetailEntryModelImpl</code>.
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

		return _permisionDetailEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionDetailEntryModelImpl</code>.
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

		return _permisionDetailEntryLocalService.dynamicQuery(
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

		return _permisionDetailEntryLocalService.dynamicQueryCount(
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

		return _permisionDetailEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		fetchPermisionDetailEntry(long id) {

		return _permisionDetailEntryLocalService.fetchPermisionDetailEntry(id);
	}

	/**
	 * Returns the permision detail entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permision detail entry's external reference code
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		fetchPermisionDetailEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permisionDetailEntryLocalService.
			fetchPermisionDetailEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPermisionDetailEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		fetchPermisionDetailEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permisionDetailEntryLocalService.
			fetchPermisionDetailEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permision detail entry with the matching UUID and company.
	 *
	 * @param uuid the permision detail entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		fetchPermisionDetailEntryByUuidAndCompanyId(
			String uuid, long companyId) {

		return _permisionDetailEntryLocalService.
			fetchPermisionDetailEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _permisionDetailEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _permisionDetailEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _permisionDetailEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the permision detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @return the range of permision detail entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.PermisionDetailEntry>
		getPermisionDetailEntries(int start, int end) {

		return _permisionDetailEntryLocalService.getPermisionDetailEntries(
			start, end);
	}

	/**
	 * Returns the number of permision detail entries.
	 *
	 * @return the number of permision detail entries
	 */
	@Override
	public int getPermisionDetailEntriesCount() {
		return _permisionDetailEntryLocalService.
			getPermisionDetailEntriesCount();
	}

	/**
	 * Returns the permision detail entry with the primary key.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry
	 * @throws PortalException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
			getPermisionDetailEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.getPermisionDetailEntry(id);
	}

	/**
	 * Returns the permision detail entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permision detail entry's external reference code
	 * @return the matching permision detail entry
	 * @throws PortalException if a matching permision detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
			getPermisionDetailEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.
			getPermisionDetailEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permision detail entry with the matching UUID and company.
	 *
	 * @param uuid the permision detail entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permision detail entry
	 * @throws PortalException if a matching permision detail entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
			getPermisionDetailEntryByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.
			getPermisionDetailEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionDetailEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the permision detail entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionDetailEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionDetailEntry the permision detail entry
	 * @return the permision detail entry that was updated
	 */
	@Override
	public com.swork.account.service.model.PermisionDetailEntry
		updatePermisionDetailEntry(
			com.swork.account.service.model.PermisionDetailEntry
				permisionDetailEntry) {

		return _permisionDetailEntryLocalService.updatePermisionDetailEntry(
			permisionDetailEntry);
	}

	@Override
	public PermisionDetailEntryLocalService getWrappedService() {
		return _permisionDetailEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PermisionDetailEntryLocalService permisionDetailEntryLocalService) {

		_permisionDetailEntryLocalService = permisionDetailEntryLocalService;
	}

	private PermisionDetailEntryLocalService _permisionDetailEntryLocalService;

}