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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.account.service.exception.NoSuchPermissionDetailEntryException;
import com.swork.account.service.model.PermissionDetailEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permission detail entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionDetailEntryUtil
 * @generated
 */
@ProviderType
public interface PermissionDetailEntryPersistence
	extends BasePersistence<PermissionDetailEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermissionDetailEntryUtil} to access the permission detail entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permission detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Removes all the permission detail entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of permission detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permission detail entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Removes all the permission detail entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permission detail entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the permission detail entries where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByPermissionId(
		long permissionId);

	/**
	 * Returns a range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end);

	/**
	 * Returns an ordered range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByPermissionId_First(
			long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the first permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByPermissionId_First(
		long permissionId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the last permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByPermissionId_Last(
			long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the last permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByPermissionId_Last(
		long permissionId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry[] findByPermissionId_PrevAndNext(
			long id, long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Removes all the permission detail entries where permissionId = &#63; from the database.
	 *
	 * @param permissionId the permission ID
	 */
	public void removeByPermissionId(long permissionId);

	/**
	 * Returns the number of permission detail entries where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the number of matching permission detail entries
	 */
	public int countByPermissionId(long permissionId);

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermissionDetailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	public PermissionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permission detail entry that was removed
	 */
	public PermissionDetailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the number of permission detail entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permission detail entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the permission detail entry in the entity cache if it is enabled.
	 *
	 * @param permissionDetailEntry the permission detail entry
	 */
	public void cacheResult(PermissionDetailEntry permissionDetailEntry);

	/**
	 * Caches the permission detail entries in the entity cache if it is enabled.
	 *
	 * @param permissionDetailEntries the permission detail entries
	 */
	public void cacheResult(
		java.util.List<PermissionDetailEntry> permissionDetailEntries);

	/**
	 * Creates a new permission detail entry with the primary key. Does not add the permission detail entry to the database.
	 *
	 * @param id the primary key for the new permission detail entry
	 * @return the new permission detail entry
	 */
	public PermissionDetailEntry create(long id);

	/**
	 * Removes the permission detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry that was removed
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry remove(long id)
		throws NoSuchPermissionDetailEntryException;

	public PermissionDetailEntry updateImpl(
		PermissionDetailEntry permissionDetailEntry);

	/**
	 * Returns the permission detail entry with the primary key or throws a <code>NoSuchPermissionDetailEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry findByPrimaryKey(long id)
		throws NoSuchPermissionDetailEntryException;

	/**
	 * Returns the permission detail entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry, or <code>null</code> if a permission detail entry with the primary key could not be found
	 */
	public PermissionDetailEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the permission detail entries.
	 *
	 * @return the permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findAll();

	/**
	 * Returns a range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission detail entries
	 */
	public java.util.List<PermissionDetailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permission detail entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permission detail entries.
	 *
	 * @return the number of permission detail entries
	 */
	public int countAll();

}