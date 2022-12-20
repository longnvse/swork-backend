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

package com.swork.notification.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.notification.service.model.NotificationEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the notification entry service. This utility wraps <code>com.swork.notification.service.service.persistence.impl.NotificationEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntryPersistence
 * @generated
 */
public class NotificationEntryUtil {

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
	public static void clearCache(NotificationEntry notificationEntry) {
		getPersistence().clearCache(notificationEntry);
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
	public static Map<Serializable, NotificationEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NotificationEntry update(
		NotificationEntry notificationEntry) {

		return getPersistence().update(notificationEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NotificationEntry update(
		NotificationEntry notificationEntry, ServiceContext serviceContext) {

		return getPersistence().update(notificationEntry, serviceContext);
	}

	/**
	 * Returns all the notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notification entries
	 */
	public static List<NotificationEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByUuid_First(
			String uuid, OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUuid_First(
		String uuid, OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByUuid_Last(
			String uuid, OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUuid_Last(
		String uuid, OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the notification entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notification entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the notification entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the notification entry that was removed
	 */
	public static NotificationEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of notification entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notification entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notification entries
	 */
	public static List<NotificationEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the notification entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notification entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the matching notification entries
	 */
	public static List<NotificationEntry> findByR_V(long receiverId) {
		return getPersistence().findByR_V(receiverId);
	}

	/**
	 * Returns a range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_V(
		long receiverId, int start, int end) {

		return getPersistence().findByR_V(receiverId, start, end);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findByR_V(
			receiverId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByR_V(
			receiverId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByR_V_First(
			long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_V_First(receiverId, orderByComparator);
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByR_V_First(
		long receiverId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByR_V_First(receiverId, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByR_V_Last(
			long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_V_Last(receiverId, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByR_V_Last(
		long receiverId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByR_V_Last(receiverId, orderByComparator);
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry[] findByR_V_PrevAndNext(
			long id, long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_V_PrevAndNext(
			id, receiverId, orderByComparator);
	}

	/**
	 * Removes all the notification entries where receiverId = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 */
	public static void removeByR_V(long receiverId) {
		getPersistence().removeByR_V(receiverId);
	}

	/**
	 * Returns the number of notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the number of matching notification entries
	 */
	public static int countByR_V(long receiverId) {
		return getPersistence().countByR_V(receiverId);
	}

	/**
	 * Returns all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the matching notification entries
	 */
	public static List<NotificationEntry> findByR_S(
		long receiverId, String status) {

		return getPersistence().findByR_S(receiverId, status);
	}

	/**
	 * Returns a range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end) {

		return getPersistence().findByR_S(receiverId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findByR_S(
			receiverId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	public static List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByR_S(
			receiverId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByR_S_First(
			long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_S_First(
			receiverId, status, orderByComparator);
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByR_S_First(
		long receiverId, String status,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByR_S_First(
			receiverId, status, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByR_S_Last(
			long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_S_Last(
			receiverId, status, orderByComparator);
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByR_S_Last(
		long receiverId, String status,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().fetchByR_S_Last(
			receiverId, status, orderByComparator);
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry[] findByR_S_PrevAndNext(
			long id, long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByR_S_PrevAndNext(
			id, receiverId, status, orderByComparator);
	}

	/**
	 * Removes all the notification entries where receiverId = &#63; and status = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 */
	public static void removeByR_S(long receiverId, String status) {
		getPersistence().removeByR_S(receiverId, status);
	}

	/**
	 * Returns the number of notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the number of matching notification entries
	 */
	public static int countByR_S(long receiverId, String status) {
		return getPersistence().countByR_S(receiverId, status);
	}

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public static NotificationEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the notification entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the notification entry that was removed
	 */
	public static NotificationEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of notification entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching notification entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the notification entry in the entity cache if it is enabled.
	 *
	 * @param notificationEntry the notification entry
	 */
	public static void cacheResult(NotificationEntry notificationEntry) {
		getPersistence().cacheResult(notificationEntry);
	}

	/**
	 * Caches the notification entries in the entity cache if it is enabled.
	 *
	 * @param notificationEntries the notification entries
	 */
	public static void cacheResult(
		List<NotificationEntry> notificationEntries) {

		getPersistence().cacheResult(notificationEntries);
	}

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param id the primary key for the new notification entry
	 * @return the new notification entry
	 */
	public static NotificationEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry remove(long id)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().remove(id);
	}

	public static NotificationEntry updateImpl(
		NotificationEntry notificationEntry) {

		return getPersistence().updateImpl(notificationEntry);
	}

	/**
	 * Returns the notification entry with the primary key or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry findByPrimaryKey(long id)
		throws com.swork.notification.service.exception.
			NoSuchNotificationEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the notification entries.
	 *
	 * @return the notification entries
	 */
	public static List<NotificationEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of notification entries
	 */
	public static List<NotificationEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification entries
	 */
	public static List<NotificationEntry> findAll(
		int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notification entries
	 */
	public static List<NotificationEntry> findAll(
		int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the notification entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotificationEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile NotificationEntryPersistence _persistence;

}