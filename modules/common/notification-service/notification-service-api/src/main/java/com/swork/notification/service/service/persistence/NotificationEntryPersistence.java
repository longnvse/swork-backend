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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.notification.service.exception.NoSuchNotificationEntryException;
import com.swork.notification.service.model.NotificationEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the notification entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntryUtil
 * @generated
 */
@ProviderType
public interface NotificationEntryPersistence
	extends BasePersistence<NotificationEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationEntryUtil} to access the notification entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notification entries
	 */
	public java.util.List<NotificationEntry> findByUuid(String uuid);

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
	public java.util.List<NotificationEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public java.util.List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public NotificationEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Removes all the notification entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notification entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the notification entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the notification entry that was removed
	 */
	public NotificationEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the number of notification entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notification entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notification entries
	 */
	public java.util.List<NotificationEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public java.util.List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public NotificationEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Removes all the notification entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notification entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the matching notification entries
	 */
	public java.util.List<NotificationEntry> findByR_V(long receiverId);

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
	public java.util.List<NotificationEntry> findByR_V(
		long receiverId, int start, int end);

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
	public java.util.List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public java.util.List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByR_V_First(
			long receiverId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByR_V_First(
		long receiverId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByR_V_Last(
			long receiverId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByR_V_Last(
		long receiverId,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public NotificationEntry[] findByR_V_PrevAndNext(
			long id, long receiverId,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Removes all the notification entries where receiverId = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 */
	public void removeByR_V(long receiverId);

	/**
	 * Returns the number of notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the number of matching notification entries
	 */
	public int countByR_V(long receiverId);

	/**
	 * Returns all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the matching notification entries
	 */
	public java.util.List<NotificationEntry> findByR_S(
		long receiverId, String status);

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
	public java.util.List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end);

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
	public java.util.List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public java.util.List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByR_S_First(
			long receiverId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByR_S_First(
		long receiverId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByR_S_Last(
			long receiverId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByR_S_Last(
		long receiverId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public NotificationEntry[] findByR_S_PrevAndNext(
			long id, long receiverId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
				orderByComparator)
		throws NoSuchNotificationEntryException;

	/**
	 * Removes all the notification entries where receiverId = &#63; and status = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 */
	public void removeByR_S(long receiverId, String status);

	/**
	 * Returns the number of notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the number of matching notification entries
	 */
	public int countByR_S(long receiverId, String status);

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	public NotificationEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public NotificationEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the notification entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the notification entry that was removed
	 */
	public NotificationEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the number of notification entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching notification entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the notification entry in the entity cache if it is enabled.
	 *
	 * @param notificationEntry the notification entry
	 */
	public void cacheResult(NotificationEntry notificationEntry);

	/**
	 * Caches the notification entries in the entity cache if it is enabled.
	 *
	 * @param notificationEntries the notification entries
	 */
	public void cacheResult(
		java.util.List<NotificationEntry> notificationEntries);

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param id the primary key for the new notification entry
	 * @return the new notification entry
	 */
	public NotificationEntry create(long id);

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public NotificationEntry remove(long id)
		throws NoSuchNotificationEntryException;

	public NotificationEntry updateImpl(NotificationEntry notificationEntry);

	/**
	 * Returns the notification entry with the primary key or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	public NotificationEntry findByPrimaryKey(long id)
		throws NoSuchNotificationEntryException;

	/**
	 * Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	 */
	public NotificationEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the notification entries.
	 *
	 * @return the notification entries
	 */
	public java.util.List<NotificationEntry> findAll();

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
	public java.util.List<NotificationEntry> findAll(int start, int end);

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
	public java.util.List<NotificationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator);

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
	public java.util.List<NotificationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NotificationEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the notification entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 */
	public int countAll();

}