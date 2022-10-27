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
 * Provides a wrapper for {@link AccountPermisionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermisionEntryLocalService
 * @generated
 */
public class AccountPermisionEntryLocalServiceWrapper
	implements AccountPermisionEntryLocalService,
			   ServiceWrapper<AccountPermisionEntryLocalService> {

	public AccountPermisionEntryLocalServiceWrapper(
		AccountPermisionEntryLocalService accountPermisionEntryLocalService) {

		_accountPermisionEntryLocalService = accountPermisionEntryLocalService;
	}

	/**
	 * Adds the account permision entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermisionEntry the account permision entry
	 * @return the account permision entry that was added
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		addAccountPermisionEntry(
			com.swork.account.service.model.AccountPermisionEntry
				accountPermisionEntry) {

		return _accountPermisionEntryLocalService.addAccountPermisionEntry(
			accountPermisionEntry);
	}

	@Override
	public com.swork.account.service.model.AccountPermisionEntry
			addAccountPermisionEntry(
				long permisionId, long accountId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PwdEncryptorException {

		return _accountPermisionEntryLocalService.addAccountPermisionEntry(
			permisionId, accountId, serviceContext);
	}

	/**
	 * Creates a new account permision entry with the primary key. Does not add the account permision entry to the database.
	 *
	 * @param id the primary key for the new account permision entry
	 * @return the new account permision entry
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		createAccountPermisionEntry(long id) {

		return _accountPermisionEntryLocalService.createAccountPermisionEntry(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the account permision entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermisionEntry the account permision entry
	 * @return the account permision entry that was removed
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		deleteAccountPermisionEntry(
			com.swork.account.service.model.AccountPermisionEntry
				accountPermisionEntry) {

		return _accountPermisionEntryLocalService.deleteAccountPermisionEntry(
			accountPermisionEntry);
	}

	/**
	 * Deletes the account permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry that was removed
	 * @throws PortalException if a account permision entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
			deleteAccountPermisionEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.deleteAccountPermisionEntry(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountPermisionEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountPermisionEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountPermisionEntryLocalService.dynamicQuery();
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

		return _accountPermisionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermisionEntryModelImpl</code>.
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

		return _accountPermisionEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermisionEntryModelImpl</code>.
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

		return _accountPermisionEntryLocalService.dynamicQuery(
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

		return _accountPermisionEntryLocalService.dynamicQueryCount(
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

		return _accountPermisionEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		fetchAccountPermisionEntry(long id) {

		return _accountPermisionEntryLocalService.fetchAccountPermisionEntry(
			id);
	}

	/**
	 * Returns the account permision entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permision entry's external reference code
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		fetchAccountPermisionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountPermisionEntryLocalService.
			fetchAccountPermisionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAccountPermisionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		fetchAccountPermisionEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountPermisionEntryLocalService.
			fetchAccountPermisionEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permision entry with the matching UUID and company.
	 *
	 * @param uuid the account permision entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		fetchAccountPermisionEntryByUuidAndCompanyId(
			String uuid, long companyId) {

		return _accountPermisionEntryLocalService.
			fetchAccountPermisionEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of account permision entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.AccountPermisionEntry>
		getAccountPermisionEntries(int start, int end) {

		return _accountPermisionEntryLocalService.getAccountPermisionEntries(
			start, end);
	}

	/**
	 * Returns the number of account permision entries.
	 *
	 * @return the number of account permision entries
	 */
	@Override
	public int getAccountPermisionEntriesCount() {
		return _accountPermisionEntryLocalService.
			getAccountPermisionEntriesCount();
	}

	/**
	 * Returns the account permision entry with the primary key.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry
	 * @throws PortalException if a account permision entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
			getAccountPermisionEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.getAccountPermisionEntry(id);
	}

	/**
	 * Returns the account permision entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permision entry's external reference code
	 * @return the matching account permision entry
	 * @throws PortalException if a matching account permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
			getAccountPermisionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.
			getAccountPermisionEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permision entry with the matching UUID and company.
	 *
	 * @param uuid the account permision entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permision entry
	 * @throws PortalException if a matching account permision entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
			getAccountPermisionEntryByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.
			getAccountPermisionEntryByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountPermisionEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountPermisionEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountPermisionEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountPermisionEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the account permision entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermisionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermisionEntry the account permision entry
	 * @return the account permision entry that was updated
	 */
	@Override
	public com.swork.account.service.model.AccountPermisionEntry
		updateAccountPermisionEntry(
			com.swork.account.service.model.AccountPermisionEntry
				accountPermisionEntry) {

		return _accountPermisionEntryLocalService.updateAccountPermisionEntry(
			accountPermisionEntry);
	}

	@Override
	public AccountPermisionEntryLocalService getWrappedService() {
		return _accountPermisionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AccountPermisionEntryLocalService accountPermisionEntryLocalService) {

		_accountPermisionEntryLocalService = accountPermisionEntryLocalService;
	}

	private AccountPermisionEntryLocalService
		_accountPermisionEntryLocalService;

}