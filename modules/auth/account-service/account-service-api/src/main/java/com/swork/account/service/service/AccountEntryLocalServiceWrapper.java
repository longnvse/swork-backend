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
 * Provides a wrapper for {@link AccountEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryLocalService
 * @generated
 */
public class AccountEntryLocalServiceWrapper
	implements AccountEntryLocalService,
			   ServiceWrapper<AccountEntryLocalService> {

	public AccountEntryLocalServiceWrapper(
		AccountEntryLocalService accountEntryLocalService) {

		_accountEntryLocalService = accountEntryLocalService;
	}

	/**
	 * Adds the account entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was added
	 */
	@Override
	public com.swork.account.service.model.AccountEntry addAccountEntry(
		com.swork.account.service.model.AccountEntry accountEntry) {

		return _accountEntryLocalService.addAccountEntry(accountEntry);
	}

	@Override
	public com.swork.account.service.model.AccountEntry addAccountEntry(
			long creatorId, String username, String password, String fullName,
			String email, Integer phoneNumber, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PwdEncryptorException {

		return _accountEntryLocalService.addAccountEntry(
			creatorId, username, password, fullName, email, phoneNumber,
			address, serviceContext);
	}

	/**
	 * Creates a new account entry with the primary key. Does not add the account entry to the database.
	 *
	 * @param accountId the primary key for the new account entry
	 * @return the new account entry
	 */
	@Override
	public com.swork.account.service.model.AccountEntry createAccountEntry(
		long accountId) {

		return _accountEntryLocalService.createAccountEntry(accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the account entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was removed
	 */
	@Override
	public com.swork.account.service.model.AccountEntry deleteAccountEntry(
		com.swork.account.service.model.AccountEntry accountEntry) {

		return _accountEntryLocalService.deleteAccountEntry(accountEntry);
	}

	/**
	 * Deletes the account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry that was removed
	 * @throws PortalException if a account entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry deleteAccountEntry(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.deleteAccountEntry(accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountEntryLocalService.dynamicQuery();
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

		return _accountEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountEntryModelImpl</code>.
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

		return _accountEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountEntryModelImpl</code>.
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

		return _accountEntryLocalService.dynamicQuery(
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

		return _accountEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _accountEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.account.service.model.AccountEntry fetchAccountEntry(
		long accountId) {

		return _accountEntryLocalService.fetchAccountEntry(accountId);
	}

	/**
	 * Returns the account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account entry's external reference code
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry
		fetchAccountEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountEntryLocalService.
			fetchAccountEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAccountEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.account.service.model.AccountEntry
		fetchAccountEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _accountEntryLocalService.fetchAccountEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry, or <code>null</code> if a matching account entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry
		fetchAccountEntryByUuidAndGroupId(String uuid, long groupId) {

		return _accountEntryLocalService.fetchAccountEntryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @return the range of account entries
	 */
	@Override
	public java.util.List<com.swork.account.service.model.AccountEntry>
		getAccountEntries(int start, int end) {

		return _accountEntryLocalService.getAccountEntries(start, end);
	}

	/**
	 * Returns all the account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account entries
	 * @param companyId the primary key of the company
	 * @return the matching account entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.account.service.model.AccountEntry>
		getAccountEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _accountEntryLocalService.getAccountEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the account entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of account entries
	 * @param end the upper bound of the range of account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching account entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.account.service.model.AccountEntry>
		getAccountEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.account.service.model.AccountEntry>
					orderByComparator) {

		return _accountEntryLocalService.getAccountEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account entries.
	 *
	 * @return the number of account entries
	 */
	@Override
	public int getAccountEntriesCount() {
		return _accountEntryLocalService.getAccountEntriesCount();
	}

	/**
	 * Returns the account entry with the primary key.
	 *
	 * @param accountId the primary key of the account entry
	 * @return the account entry
	 * @throws PortalException if a account entry with the primary key could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry getAccountEntry(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.getAccountEntry(accountId);
	}

	/**
	 * Returns the account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account entry's external reference code
	 * @return the matching account entry
	 * @throws PortalException if a matching account entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry
			getAccountEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.getAccountEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the account entry matching the UUID and group.
	 *
	 * @param uuid the account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account entry
	 * @throws PortalException if a matching account entry could not be found
	 */
	@Override
	public com.swork.account.service.model.AccountEntry
			getAccountEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.getAccountEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _accountEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the account entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntry the account entry
	 * @return the account entry that was updated
	 */
	@Override
	public com.swork.account.service.model.AccountEntry updateAccountEntry(
		com.swork.account.service.model.AccountEntry accountEntry) {

		return _accountEntryLocalService.updateAccountEntry(accountEntry);
	}

	@Override
	public com.swork.account.service.model.AccountEntry updateAccountEntry(
		long creatorId, long accountId, String fullName, String email,
		Integer phoneNumber, String address,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _accountEntryLocalService.updateAccountEntry(
			creatorId, accountId, fullName, email, phoneNumber, address,
			serviceContext);
	}

	@Override
	public AccountEntryLocalService getWrappedService() {
		return _accountEntryLocalService;
	}

	@Override
	public void setWrappedService(
		AccountEntryLocalService accountEntryLocalService) {

		_accountEntryLocalService = accountEntryLocalService;
	}

	private AccountEntryLocalService _accountEntryLocalService;

}