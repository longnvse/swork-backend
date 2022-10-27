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
 * Provides a wrapper for {@link PermisionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PermisionEntryLocalService
 * @generated
 */
public class PermisionEntryLocalServiceWrapper
	implements PermisionEntryLocalService,
			   ServiceWrapper<PermisionEntryLocalService> {

	public PermisionEntryLocalServiceWrapper(
		PermisionEntryLocalService permisionEntryLocalService) {

		_permisionEntryLocalService = permisionEntryLocalService;
	}

	/**
	 * Adds the permision entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionEntry the permision entry
	 * @return the permision entry that was added
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry addPermisionEntry(
		com.swork.account.service.model.PermisionEntry permisionEntry) {

		return _permisionEntryLocalService.addPermisionEntry(permisionEntry);
	}

	/**
	 * Creates a new permision entry with the primary key. Does not add the permision entry to the database.
	 *
	 * @param id the primary key for the new permision entry
	 * @return the new permision entry
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry createPermisionEntry(
		long id) {

		return _permisionEntryLocalService.createPermisionEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the permision entry
	 * @return the permision entry that was removed
	 * @throws PortalException if a permision entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry deletePermisionEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.deletePermisionEntry(id);
	}

	/**
	 * Deletes the permision entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionEntry the permision entry
	 * @return the permision entry that was removed
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry deletePermisionEntry(
		com.swork.account.service.model.PermisionEntry permisionEntry) {

		return _permisionEntryLocalService.deletePermisionEntry(permisionEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _permisionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _permisionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permisionEntryLocalService.dynamicQuery();
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

		return _permisionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionEntryModelImpl</code>.
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

		return _permisionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionEntryModelImpl</code>.
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

		return _permisionEntryLocalService.dynamicQuery(
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

		return _permisionEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _permisionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.PermisionEntry fetchPermisionEntry(
		long id) {

		return _permisionEntryLocalService.fetchPermisionEntry(id);
	}

	/**
	 * Returns the permision entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permision entry's external reference code
	 * @return the matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry
		fetchPermisionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permisionEntryLocalService.
			fetchPermisionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPermisionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.PermisionEntry
		fetchPermisionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _permisionEntryLocalService.fetchPermisionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the permision entry with the matching UUID and company.
	 *
	 * @param uuid the permision entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry
		fetchPermisionEntryByUuidAndCompanyId(String uuid, long companyId) {

		return _permisionEntryLocalService.
			fetchPermisionEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _permisionEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _permisionEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _permisionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @return the range of permision entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.PermisionEntry>
		getPermisionEntries(int start, int end) {

		return _permisionEntryLocalService.getPermisionEntries(start, end);
	}

	/**
	 * Returns the number of permision entries.
	 *
	 * @return the number of permision entries
	 */
	@Override
	public int getPermisionEntriesCount() {
		return _permisionEntryLocalService.getPermisionEntriesCount();
	}

	/**
	 * Returns the permision entry with the primary key.
	 *
	 * @param id the primary key of the permision entry
	 * @return the permision entry
	 * @throws PortalException if a permision entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry getPermisionEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.getPermisionEntry(id);
	}

	/**
	 * Returns the permision entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permision entry's external reference code
	 * @return the matching permision entry
	 * @throws PortalException if a matching permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry
			getPermisionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.
			getPermisionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the permision entry with the matching UUID and company.
	 *
	 * @param uuid the permision entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permision entry
	 * @throws PortalException if a matching permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry
			getPermisionEntryByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.getPermisionEntryByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permisionEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the permision entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permisionEntry the permision entry
	 * @return the permision entry that was updated
	 */
	@Override
	public com.swork.account.service.model.PermisionEntry updatePermisionEntry(
		com.swork.account.service.model.PermisionEntry permisionEntry) {

		return _permisionEntryLocalService.updatePermisionEntry(permisionEntry);
	}

	@Override
	public PermisionEntryLocalService getWrappedService() {
		return _permisionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PermisionEntryLocalService permisionEntryLocalService) {

		_permisionEntryLocalService = permisionEntryLocalService;
	}

	private PermisionEntryLocalService _permisionEntryLocalService;

}