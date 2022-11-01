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

package com.swork.account.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.account.service.model.AccountPermissionEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the account permission entry service. This utility wraps <code>com.swork.account.service.service.persistence.impl.AccountPermissionEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermissionEntryPersistence
 * @generated
 */
public class AccountPermissionEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		AccountPermissionEntry accountPermissionEntry) {

		getPersistence().clearCache(accountPermissionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AccountPermissionEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountPermissionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountPermissionEntry update(
		AccountPermissionEntry accountPermissionEntry) {

		return getPersistence().update(accountPermissionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountPermissionEntry update(
		AccountPermissionEntry accountPermissionEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(accountPermissionEntry, serviceContext);
	}

	/**
	 * Returns all the account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the account permission entries before and after the current account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public static AccountPermissionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the account permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permission entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permission entries
	 */
	public static List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the account permission entries before and after the current account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current account permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public static AccountPermissionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the account permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permission entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the account permission entry where accountId = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByAccountId(long accountId)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByAccountId(accountId);
	}

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByAccountId(long accountId) {
		return getPersistence().fetchByAccountId(accountId);
	}

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountId the account ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByAccountId(
		long accountId, boolean useFinderCache) {

		return getPersistence().fetchByAccountId(accountId, useFinderCache);
	}

	/**
	 * Removes the account permission entry where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 * @return the account permission entry that was removed
	 */
	public static AccountPermissionEntry removeByAccountId(long accountId)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().removeByAccountId(accountId);
	}

	/**
	 * Returns the number of account permission entries where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account permission entries
	 */
	public static int countByAccountId(long accountId) {
		return getPersistence().countByAccountId(accountId);
	}

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public static AccountPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the account permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permission entry that was removed
	 */
	public static AccountPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of account permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permission entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the account permission entry in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntry the account permission entry
	 */
	public static void cacheResult(
		AccountPermissionEntry accountPermissionEntry) {

		getPersistence().cacheResult(accountPermissionEntry);
	}

	/**
	 * Caches the account permission entries in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntries the account permission entries
	 */
	public static void cacheResult(
		List<AccountPermissionEntry> accountPermissionEntries) {

		getPersistence().cacheResult(accountPermissionEntries);
	}

	/**
	 * Creates a new account permission entry with the primary key. Does not add the account permission entry to the database.
	 *
	 * @param id the primary key for the new account permission entry
	 * @return the new account permission entry
	 */
	public static AccountPermissionEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public static AccountPermissionEntry remove(long id)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().remove(id);
	}

	public static AccountPermissionEntry updateImpl(
		AccountPermissionEntry accountPermissionEntry) {

		return getPersistence().updateImpl(accountPermissionEntry);
	}

	/**
	 * Returns the account permission entry with the primary key or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public static AccountPermissionEntry findByPrimaryKey(long id)
		throws com.swork.account.service.exception.
			NoSuchAccountPermissionEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the account permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry, or <code>null</code> if a account permission entry with the primary key could not be found
	 */
	public static AccountPermissionEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the account permission entries.
	 *
	 * @return the account permission entries
	 */
	public static List<AccountPermissionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of account permission entries
	 */
	public static List<AccountPermissionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account permission entries
	 */
	public static List<AccountPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account permission entries
	 */
	public static List<AccountPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account permission entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account permission entries.
	 *
	 * @return the number of account permission entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountPermissionEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AccountPermissionEntryPersistence _persistence;

}