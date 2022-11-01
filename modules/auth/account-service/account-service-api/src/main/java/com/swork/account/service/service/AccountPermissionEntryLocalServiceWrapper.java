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
 * Provides a wrapper for {@link AccountPermissionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermissionEntryLocalService
 * @generated
 */
public class AccountPermissionEntryLocalServiceWrapper
	implements AccountPermissionEntryLocalService,
			   ServiceWrapper<AccountPermissionEntryLocalService> {

	public AccountPermissionEntryLocalServiceWrapper(
		AccountPermissionEntryLocalService accountPermissionEntryLocalService) {

		_accountPermissionEntryLocalService =
			accountPermissionEntryLocalService;
	}

	/**
	 * Adds the account permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was added
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		addAccountPermissionEntry(
			com.swork.account.service.model.AccountPermissionEntry
				accountPermissionEntry) {

		return _accountPermissionEntryLocalService.addAccountPermissionEntry(
			accountPermissionEntry);
	}

	@Override
	public com.swork.account.service.model.AccountPermissionEntry
			addAccountPermissionEntry(
				long permissionId, long accountId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PwdEncryptorException {

		return _accountPermissionEntryLocalService.addAccountPermissionEntry(
			permissionId, accountId, serviceContext);
	}

	/**
	 * Creates a new account permission entry with the primary key. Does not add the account permission entry to the database.
	 *
	 * @param id the primary key for the new account permission entry
	 * @return the new account permission entry
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		createAccountPermissionEntry(long id) {

		return _accountPermissionEntryLocalService.createAccountPermissionEntry(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the account permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was removed
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		deleteAccountPermissionEntry(
			com.swork.account.service.model.AccountPermissionEntry
				accountPermissionEntry) {

		return _accountPermissionEntryLocalService.deleteAccountPermissionEntry(
			accountPermissionEntry);
	}

	/**
	 * Deletes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws PortalException if a account permission entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
			deleteAccountPermissionEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.deleteAccountPermissionEntry(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountPermissionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountPermissionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountPermissionEntryLocalService.dynamicQuery();
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

		return _accountPermissionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
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

		return _accountPermissionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
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

		return _accountPermissionEntryLocalService.dynamicQuery(
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

		return _accountPermissionEntryLocalService.dynamicQueryCount(
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

		return _accountPermissionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		fetchAccountPermissionEntry(long id) {

		return _accountPermissionEntryLocalService.fetchAccountPermissionEntry(
			id);
	}

	/**
	 * Returns the account permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permission entry's external reference code
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		fetchAccountPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountPermissionEntryLocalService.
			fetchAccountPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAccountPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		fetchAccountPermissionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountPermissionEntryLocalService.
			fetchAccountPermissionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry with the matching UUID and company.
	 *
	 * @param uuid the account permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		fetchAccountPermissionEntryByUuidAndCompanyId(
			String uuid, long companyId) {

		return _accountPermissionEntryLocalService.
			fetchAccountPermissionEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of account permission entries
	 */
	@Override
	public java.util.List
		<com.swork.account.service.model.AccountPermissionEntry>
			getAccountPermissionEntries(int start, int end) {

		return _accountPermissionEntryLocalService.getAccountPermissionEntries(
			start, end);
	}

	/**
	 * Returns the number of account permission entries.
	 *
	 * @return the number of account permission entries
	 */
	@Override
	public int getAccountPermissionEntriesCount() {
		return _accountPermissionEntryLocalService.
			getAccountPermissionEntriesCount();
	}

	/**
	 * Returns the account permission entry with the primary key.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws PortalException if a account permission entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
			getAccountPermissionEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.getAccountPermissionEntry(
			id);
	}

	/**
	 * Returns the account permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permission entry's external reference code
	 * @return the matching account permission entry
	 * @throws PortalException if a matching account permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
			getAccountPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.
			getAccountPermissionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry with the matching UUID and company.
	 *
	 * @param uuid the account permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permission entry
	 * @throws PortalException if a matching account permission entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
			getAccountPermissionEntryByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.
			getAccountPermissionEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountPermissionEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		getByAccountId(long accountId) {

		return _accountPermissionEntryLocalService.getByAccountId(accountId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountPermissionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountPermissionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermissionEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the account permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was updated
	 */
	@Override
	public com.swork.account.service.model.AccountPermissionEntry
		updateAccountPermissionEntry(
			com.swork.account.service.model.AccountPermissionEntry
				accountPermissionEntry) {

		return _accountPermissionEntryLocalService.updateAccountPermissionEntry(
			accountPermissionEntry);
	}

	@Override
	public AccountPermissionEntryLocalService getWrappedService() {
		return _accountPermissionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AccountPermissionEntryLocalService accountPermissionEntryLocalService) {

		_accountPermissionEntryLocalService =
			accountPermissionEntryLocalService;
	}

	private AccountPermissionEntryLocalService
		_accountPermissionEntryLocalService;

}