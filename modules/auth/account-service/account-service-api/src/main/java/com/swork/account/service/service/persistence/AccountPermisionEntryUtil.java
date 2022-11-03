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

import com.swork.account.service.model.AccountPermisionEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the account permision entry service. This utility wraps <code>com.swork.account.service.service.persistence.impl.AccountPermisionEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermisionEntryPersistence
 * @generated
 */
public class AccountPermisionEntryUtil {

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
	public static void clearCache(AccountPermisionEntry accountPermisionEntry) {
		getPersistence().clearCache(accountPermisionEntry);
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
	public static Map<Serializable, AccountPermisionEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountPermisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountPermisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountPermisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountPermisionEntry update(
		AccountPermisionEntry accountPermisionEntry) {

		return getPersistence().update(accountPermisionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountPermisionEntry update(
		AccountPermisionEntry accountPermisionEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(accountPermisionEntry, serviceContext);
	}

	/**
	 * Returns all the account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry findByUuid_First(
			String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the account permision entries before and after the current account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permision entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public static AccountPermisionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the account permision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permision entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permision entries
	 */
	public static List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the account permision entries before and after the current account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current account permision entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public static AccountPermisionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the account permision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permision entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public static AccountPermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the account permision entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permision entry that was removed
	 */
	public static AccountPermisionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of account permision entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permision entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the account permision entry in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntry the account permision entry
	 */
	public static void cacheResult(
		AccountPermisionEntry accountPermisionEntry) {

		getPersistence().cacheResult(accountPermisionEntry);
	}

	/**
	 * Caches the account permision entries in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntries the account permision entries
	 */
	public static void cacheResult(
		List<AccountPermisionEntry> accountPermisionEntries) {

		getPersistence().cacheResult(accountPermisionEntries);
	}

	/**
	 * Creates a new account permision entry with the primary key. Does not add the account permision entry to the database.
	 *
	 * @param id the primary key for the new account permision entry
	 * @return the new account permision entry
	 */
	public static AccountPermisionEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the account permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry that was removed
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public static AccountPermisionEntry remove(long id)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().remove(id);
	}

	public static AccountPermisionEntry updateImpl(
		AccountPermisionEntry accountPermisionEntry) {

		return getPersistence().updateImpl(accountPermisionEntry);
	}

	/**
	 * Returns the account permision entry with the primary key or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public static AccountPermisionEntry findByPrimaryKey(long id)
		throws com.swork.account.service.exception.
			NoSuchAccountPermisionEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the account permision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry, or <code>null</code> if a account permision entry with the primary key could not be found
	 */
	public static AccountPermisionEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the account permision entries.
	 *
	 * @return the account permision entries
	 */
	public static List<AccountPermisionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of account permision entries
	 */
	public static List<AccountPermisionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account permision entries
	 */
	public static List<AccountPermisionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account permision entries
	 */
	public static List<AccountPermisionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account permision entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account permision entries.
	 *
	 * @return the number of account permision entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountPermisionEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AccountPermisionEntryPersistence _persistence;

}