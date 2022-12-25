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

package com.swork.business.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.business.service.model.BusinessEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the business entry service. This utility wraps <code>com.swork.business.service.service.persistence.impl.BusinessEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryPersistence
 * @generated
 */
public class BusinessEntryUtil {

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
	public static void clearCache(BusinessEntry businessEntry) {
		getPersistence().clearCache(businessEntry);
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
	public static Map<Serializable, BusinessEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BusinessEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusinessEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusinessEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BusinessEntry update(BusinessEntry businessEntry) {
		return getPersistence().update(businessEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BusinessEntry update(
		BusinessEntry businessEntry, ServiceContext serviceContext) {

		return getPersistence().update(businessEntry, serviceContext);
	}

	/**
	 * Returns all the business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching business entries
	 */
	public static List<BusinessEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByUuid_First(
			String uuid, OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUuid_First(
		String uuid, OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByUuid_Last(
			String uuid, OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUuid_Last(
		String uuid, OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry[] findByUuid_PrevAndNext(
			long businessId, String uuid,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			businessId, uuid, orderByComparator);
	}

	/**
	 * Removes all the business entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching business entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the business entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the business entry that was removed
	 */
	public static BusinessEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of business entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching business entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching business entries
	 */
	public static List<BusinessEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	public static List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry[] findByUuid_C_PrevAndNext(
			long businessId, String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			businessId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the business entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching business entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the business entry where phoneNumber = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByPhone(String phoneNumber)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByPhone(phoneNumber);
	}

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByPhone(String phoneNumber) {
		return getPersistence().fetchByPhone(phoneNumber);
	}

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByPhone(
		String phoneNumber, boolean useFinderCache) {

		return getPersistence().fetchByPhone(phoneNumber, useFinderCache);
	}

	/**
	 * Removes the business entry where phoneNumber = &#63; from the database.
	 *
	 * @param phoneNumber the phone number
	 * @return the business entry that was removed
	 */
	public static BusinessEntry removeByPhone(String phoneNumber)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().removeByPhone(phoneNumber);
	}

	/**
	 * Returns the number of business entries where phoneNumber = &#63;.
	 *
	 * @param phoneNumber the phone number
	 * @return the number of matching business entries
	 */
	public static int countByPhone(String phoneNumber) {
		return getPersistence().countByPhone(phoneNumber);
	}

	/**
	 * Returns the business entry where email = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByEmail(String email)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByEmail(String email) {
		return getPersistence().fetchByEmail(email);
	}

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByEmail(
		String email, boolean useFinderCache) {

		return getPersistence().fetchByEmail(email, useFinderCache);
	}

	/**
	 * Removes the business entry where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the business entry that was removed
	 */
	public static BusinessEntry removeByEmail(String email)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of business entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching business entries
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns the business entry where name = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByName(String name)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the business entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the business entry that was removed
	 */
	public static BusinessEntry removeByName(String name)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of business entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching business entries
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public static BusinessEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the business entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the business entry that was removed
	 */
	public static BusinessEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of business entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching business entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the business entry in the entity cache if it is enabled.
	 *
	 * @param businessEntry the business entry
	 */
	public static void cacheResult(BusinessEntry businessEntry) {
		getPersistence().cacheResult(businessEntry);
	}

	/**
	 * Caches the business entries in the entity cache if it is enabled.
	 *
	 * @param businessEntries the business entries
	 */
	public static void cacheResult(List<BusinessEntry> businessEntries) {
		getPersistence().cacheResult(businessEntries);
	}

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	public static BusinessEntry create(long businessId) {
		return getPersistence().create(businessId);
	}

	/**
	 * Removes the business entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry that was removed
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry remove(long businessId)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().remove(businessId);
	}

	public static BusinessEntry updateImpl(BusinessEntry businessEntry) {
		return getPersistence().updateImpl(businessEntry);
	}

	/**
	 * Returns the business entry with the primary key or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry findByPrimaryKey(long businessId)
		throws com.swork.business.service.exception.
			NoSuchBusinessEntryException {

		return getPersistence().findByPrimaryKey(businessId);
	}

	/**
	 * Returns the business entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry, or <code>null</code> if a business entry with the primary key could not be found
	 */
	public static BusinessEntry fetchByPrimaryKey(long businessId) {
		return getPersistence().fetchByPrimaryKey(businessId);
	}

	/**
	 * Returns all the business entries.
	 *
	 * @return the business entries
	 */
	public static List<BusinessEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of business entries
	 */
	public static List<BusinessEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business entries
	 */
	public static List<BusinessEntry> findAll(
		int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of business entries
	 */
	public static List<BusinessEntry> findAll(
		int start, int end, OrderByComparator<BusinessEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the business entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BusinessEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BusinessEntryPersistence _persistence;

}