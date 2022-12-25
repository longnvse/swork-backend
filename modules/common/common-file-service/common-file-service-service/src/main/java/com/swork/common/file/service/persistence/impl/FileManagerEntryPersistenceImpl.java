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

package com.swork.common.file.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.swork.common.file.exception.NoSuchFileManagerEntryException;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.model.FileManagerEntryTable;
import com.swork.common.file.model.impl.FileManagerEntryImpl;
import com.swork.common.file.model.impl.FileManagerEntryModelImpl;
import com.swork.common.file.service.persistence.FileManagerEntryPersistence;
import com.swork.common.file.service.persistence.FileManagerEntryUtil;
import com.swork.common.file.service.persistence.impl.constants.FIlePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the file manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FileManagerEntryPersistence.class, BasePersistence.class})
public class FileManagerEntryPersistenceImpl
	extends BasePersistenceImpl<FileManagerEntry>
	implements FileManagerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FileManagerEntryUtil</code> to access the file manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FileManagerEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileManagerEntry fileManagerEntry : list) {
					if (!uuid.equals(fileManagerEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByUuid_First(
			String uuid, OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUuid_First(
		String uuid, OrderByComparator<FileManagerEntry> orderByComparator) {

		List<FileManagerEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByUuid_Last(
			String uuid, OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<FileManagerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FileManagerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		uuid = Objects.toString(uuid, "");

		FileManagerEntry fileManagerEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry[] array = new FileManagerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fileManagerEntry, uuid, orderByComparator, true);

			array[1] = fileManagerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, fileManagerEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileManagerEntry getByUuid_PrevAndNext(
		Session session, FileManagerEntry fileManagerEntry, String uuid,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FileManagerEntry fileManagerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"fileManagerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fileManagerEntry.uuid IS NULL OR fileManagerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByUUID_G(uuid, groupId);

		if (fileManagerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileManagerEntryException(sb.toString());
		}

		return fileManagerEntry;
	}

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof FileManagerEntry) {
			FileManagerEntry fileManagerEntry = (FileManagerEntry)result;

			if (!Objects.equals(uuid, fileManagerEntry.getUuid()) ||
				(groupId != fileManagerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<FileManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FileManagerEntry fileManagerEntry = list.get(0);

					result = fileManagerEntry;

					cacheResult(fileManagerEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileManagerEntry)result;
		}
	}

	/**
	 * Removes the file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file manager entry that was removed
	 */
	@Override
	public FileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByUUID_G(uuid, groupId);

		return remove(fileManagerEntry);
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"fileManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(fileManagerEntry.uuid IS NULL OR fileManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"fileManagerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileManagerEntry fileManagerEntry : list) {
					if (!uuid.equals(fileManagerEntry.getUuid()) ||
						(companyId != fileManagerEntry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		List<FileManagerEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FileManagerEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		uuid = Objects.toString(uuid, "");

		FileManagerEntry fileManagerEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry[] array = new FileManagerEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, fileManagerEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = fileManagerEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, fileManagerEntry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileManagerEntry getByUuid_C_PrevAndNext(
		Session session, FileManagerEntry fileManagerEntry, String uuid,
		long companyId, OrderByComparator<FileManagerEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FileManagerEntry fileManagerEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"fileManagerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(fileManagerEntry.uuid IS NULL OR fileManagerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"fileManagerEntry.companyId = ?";

	private FinderPath _finderPathFetchByF_B;
	private FinderPath _finderPathCountByF_B;

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByF_B(long fileId, long businessId)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByF_B(fileId, businessId);

		if (fileManagerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fileId=");
			sb.append(fileId);

			sb.append(", businessId=");
			sb.append(businessId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileManagerEntryException(sb.toString());
		}

		return fileManagerEntry;
	}

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByF_B(long fileId, long businessId) {
		return fetchByF_B(fileId, businessId, true);
	}

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByF_B(
		long fileId, long businessId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fileId, businessId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByF_B, finderArgs);
		}

		if (result instanceof FileManagerEntry) {
			FileManagerEntry fileManagerEntry = (FileManagerEntry)result;

			if ((fileId != fileManagerEntry.getFileId()) ||
				(businessId != fileManagerEntry.getBusinessId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_F_B_FILEID_2);

			sb.append(_FINDER_COLUMN_F_B_BUSINESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				queryPos.add(businessId);

				List<FileManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByF_B, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fileId, businessId};
							}

							_log.warn(
								"FileManagerEntryPersistenceImpl.fetchByF_B(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FileManagerEntry fileManagerEntry = list.get(0);

					result = fileManagerEntry;

					cacheResult(fileManagerEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileManagerEntry)result;
		}
	}

	/**
	 * Removes the file manager entry where fileId = &#63; and businessId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the file manager entry that was removed
	 */
	@Override
	public FileManagerEntry removeByF_B(long fileId, long businessId)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByF_B(fileId, businessId);

		return remove(fileManagerEntry);
	}

	/**
	 * Returns the number of file manager entries where fileId = &#63; and businessId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByF_B(long fileId, long businessId) {
		FinderPath finderPath = _finderPathCountByF_B;

		Object[] finderArgs = new Object[] {fileId, businessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_F_B_FILEID_2);

			sb.append(_FINDER_COLUMN_F_B_BUSINESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileId);

				queryPos.add(businessId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_F_B_FILEID_2 =
		"fileManagerEntry.fileId = ? AND ";

	private static final String _FINDER_COLUMN_F_B_BUSINESSID_2 =
		"fileManagerEntry.businessId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PID;
	private FinderPath _finderPathWithoutPaginationFindByB_PID;
	private FinderPath _finderPathCountByB_PID;

	/**
	 * Returns all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PID(long businessId, Long projectId) {
		return findByB_PID(
			businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end) {

		return findByB_PID(businessId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findByB_PID(
			businessId, projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_PID;
				finderArgs = new Object[] {businessId, projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_PID;
			finderArgs = new Object[] {
				businessId, projectId, start, end, orderByComparator
			};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileManagerEntry fileManagerEntry : list) {
					if ((businessId != fileManagerEntry.getBusinessId()) ||
						!Objects.equals(
							projectId, fileManagerEntry.getProjectId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId.longValue());

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_PID_First(
			long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_PID_First(
			businessId, projectId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_PID_First(
		long businessId, Long projectId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		List<FileManagerEntry> list = findByB_PID(
			businessId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_PID_Last(
			long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_PID_Last(
			businessId, projectId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_PID_Last(
		long businessId, Long projectId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		int count = countByB_PID(businessId, projectId);

		if (count == 0) {
			return null;
		}

		List<FileManagerEntry> list = findByB_PID(
			businessId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry[] findByB_PID_PrevAndNext(
			long id, long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry[] array = new FileManagerEntryImpl[3];

			array[0] = getByB_PID_PrevAndNext(
				session, fileManagerEntry, businessId, projectId,
				orderByComparator, true);

			array[1] = fileManagerEntry;

			array[2] = getByB_PID_PrevAndNext(
				session, fileManagerEntry, businessId, projectId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileManagerEntry getByB_PID_PrevAndNext(
		Session session, FileManagerEntry fileManagerEntry, long businessId,
		Long projectId, OrderByComparator<FileManagerEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_PID_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(projectId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByB_PID(long businessId, Long projectId) {
		for (FileManagerEntry fileManagerEntry :
				findByB_PID(
					businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByB_PID(long businessId, Long projectId) {
		FinderPath finderPath = _finderPathCountByB_PID;

		Object[] finderArgs = new Object[] {businessId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PID_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_B_PID_BUSINESSID_2 =
		"fileManagerEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PID_PROJECTID_2 =
		"fileManagerEntry.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PHID;
	private FinderPath _finderPathWithoutPaginationFindByB_PHID;
	private FinderPath _finderPathCountByB_PHID;

	/**
	 * Returns all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PHID(long businessId, Long phaseId) {
		return findByB_PHID(
			businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end) {

		return findByB_PHID(businessId, phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findByB_PHID(
			businessId, phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_PHID;
				finderArgs = new Object[] {businessId, phaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_PHID;
			finderArgs = new Object[] {
				businessId, phaseId, start, end, orderByComparator
			};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileManagerEntry fileManagerEntry : list) {
					if ((businessId != fileManagerEntry.getBusinessId()) ||
						!Objects.equals(
							phaseId, fileManagerEntry.getPhaseId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PHID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PHID_PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(phaseId.longValue());

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_PHID_First(
			long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_PHID_First(
			businessId, phaseId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_PHID_First(
		long businessId, Long phaseId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		List<FileManagerEntry> list = findByB_PHID(
			businessId, phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_PHID_Last(
			long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_PHID_Last(
			businessId, phaseId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_PHID_Last(
		long businessId, Long phaseId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		int count = countByB_PHID(businessId, phaseId);

		if (count == 0) {
			return null;
		}

		List<FileManagerEntry> list = findByB_PHID(
			businessId, phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry[] findByB_PHID_PrevAndNext(
			long id, long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry[] array = new FileManagerEntryImpl[3];

			array[0] = getByB_PHID_PrevAndNext(
				session, fileManagerEntry, businessId, phaseId,
				orderByComparator, true);

			array[1] = fileManagerEntry;

			array[2] = getByB_PHID_PrevAndNext(
				session, fileManagerEntry, businessId, phaseId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileManagerEntry getByB_PHID_PrevAndNext(
		Session session, FileManagerEntry fileManagerEntry, long businessId,
		Long phaseId, OrderByComparator<FileManagerEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_PHID_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_PHID_PHASEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(phaseId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByB_PHID(long businessId, Long phaseId) {
		for (FileManagerEntry fileManagerEntry :
				findByB_PHID(
					businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByB_PHID(long businessId, Long phaseId) {
		FinderPath finderPath = _finderPathCountByB_PHID;

		Object[] finderArgs = new Object[] {businessId, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PHID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PHID_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(phaseId.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_B_PHID_BUSINESSID_2 =
		"fileManagerEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PHID_PHASEID_2 =
		"fileManagerEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByB_WID;
	private FinderPath _finderPathWithoutPaginationFindByB_WID;
	private FinderPath _finderPathCountByB_WID;

	/**
	 * Returns all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_WID(long businessId, Long workId) {
		return findByB_WID(
			businessId, workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end) {

		return findByB_WID(businessId, workId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findByB_WID(
			businessId, workId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	@Override
	public List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_WID;
				finderArgs = new Object[] {businessId, workId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_WID;
			finderArgs = new Object[] {
				businessId, workId, start, end, orderByComparator
			};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (FileManagerEntry fileManagerEntry : list) {
					if ((businessId != fileManagerEntry.getBusinessId()) ||
						!Objects.equals(workId, fileManagerEntry.getWorkId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_WID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_WID_WORKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_WID_First(
			long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_WID_First(
			businessId, workId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_WID_First(
		long businessId, Long workId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		List<FileManagerEntry> list = findByB_WID(
			businessId, workId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByB_WID_Last(
			long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByB_WID_Last(
			businessId, workId, orderByComparator);

		if (fileManagerEntry != null) {
			return fileManagerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchFileManagerEntryException(sb.toString());
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByB_WID_Last(
		long businessId, Long workId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		int count = countByB_WID(businessId, workId);

		if (count == 0) {
			return null;
		}

		List<FileManagerEntry> list = findByB_WID(
			businessId, workId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry[] findByB_WID_PrevAndNext(
			long id, long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry[] array = new FileManagerEntryImpl[3];

			array[0] = getByB_WID_PrevAndNext(
				session, fileManagerEntry, businessId, workId,
				orderByComparator, true);

			array[1] = fileManagerEntry;

			array[2] = getByB_WID_PrevAndNext(
				session, fileManagerEntry, businessId, workId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileManagerEntry getByB_WID_PrevAndNext(
		Session session, FileManagerEntry fileManagerEntry, long businessId,
		Long workId, OrderByComparator<FileManagerEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_WID_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_WID_WORKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FileManagerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(workId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fileManagerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FileManagerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and workId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 */
	@Override
	public void removeByB_WID(long businessId, Long workId) {
		for (FileManagerEntry fileManagerEntry :
				findByB_WID(
					businessId, workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByB_WID(long businessId, Long workId) {
		FinderPath finderPath = _finderPathCountByB_WID;

		Object[] finderArgs = new Object[] {businessId, workId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_WID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_WID_WORKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_B_WID_BUSINESSID_2 =
		"fileManagerEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_WID_WORKID_2 =
		"fileManagerEntry.workId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (fileManagerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFileManagerEntryException(sb.toString());
		}

		return fileManagerEntry;
	}

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_ERC, finderArgs);
		}

		if (result instanceof FileManagerEntry) {
			FileManagerEntry fileManagerEntry = (FileManagerEntry)result;

			if ((companyId != fileManagerEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					fileManagerEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<FileManagerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"FileManagerEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FileManagerEntry fileManagerEntry = list.get(0);

					result = fileManagerEntry;

					cacheResult(fileManagerEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FileManagerEntry)result;
		}
	}

	/**
	 * Removes the file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the file manager entry that was removed
	 */
	@Override
	public FileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(fileManagerEntry);
	}

	/**
	 * Returns the number of file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching file manager entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FILEMANAGERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"fileManagerEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"fileManagerEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(fileManagerEntry.externalReferenceCode IS NULL OR fileManagerEntry.externalReferenceCode = '')";

	public FileManagerEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FileManagerEntry.class);

		setModelImplClass(FileManagerEntryImpl.class);
		setModelPKClass(long.class);

		setTable(FileManagerEntryTable.INSTANCE);
	}

	/**
	 * Caches the file manager entry in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntry the file manager entry
	 */
	@Override
	public void cacheResult(FileManagerEntry fileManagerEntry) {
		entityCache.putResult(
			FileManagerEntryImpl.class, fileManagerEntry.getPrimaryKey(),
			fileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				fileManagerEntry.getUuid(), fileManagerEntry.getGroupId()
			},
			fileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByF_B,
			new Object[] {
				fileManagerEntry.getFileId(), fileManagerEntry.getBusinessId()
			},
			fileManagerEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				fileManagerEntry.getCompanyId(),
				fileManagerEntry.getExternalReferenceCode()
			},
			fileManagerEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the file manager entries in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntries the file manager entries
	 */
	@Override
	public void cacheResult(List<FileManagerEntry> fileManagerEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fileManagerEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FileManagerEntry fileManagerEntry : fileManagerEntries) {
			if (entityCache.getResult(
					FileManagerEntryImpl.class,
					fileManagerEntry.getPrimaryKey()) == null) {

				cacheResult(fileManagerEntry);
			}
		}
	}

	/**
	 * Clears the cache for all file manager entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FileManagerEntryImpl.class);

		finderCache.clearCache(FileManagerEntryImpl.class);
	}

	/**
	 * Clears the cache for the file manager entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileManagerEntry fileManagerEntry) {
		entityCache.removeResult(FileManagerEntryImpl.class, fileManagerEntry);
	}

	@Override
	public void clearCache(List<FileManagerEntry> fileManagerEntries) {
		for (FileManagerEntry fileManagerEntry : fileManagerEntries) {
			entityCache.removeResult(
				FileManagerEntryImpl.class, fileManagerEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FileManagerEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FileManagerEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FileManagerEntryModelImpl fileManagerEntryModelImpl) {

		Object[] args = new Object[] {
			fileManagerEntryModelImpl.getUuid(),
			fileManagerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, fileManagerEntryModelImpl);

		args = new Object[] {
			fileManagerEntryModelImpl.getFileId(),
			fileManagerEntryModelImpl.getBusinessId()
		};

		finderCache.putResult(_finderPathCountByF_B, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByF_B, args, fileManagerEntryModelImpl);

		args = new Object[] {
			fileManagerEntryModelImpl.getCompanyId(),
			fileManagerEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, fileManagerEntryModelImpl);
	}

	/**
	 * Creates a new file manager entry with the primary key. Does not add the file manager entry to the database.
	 *
	 * @param id the primary key for the new file manager entry
	 * @return the new file manager entry
	 */
	@Override
	public FileManagerEntry create(long id) {
		FileManagerEntry fileManagerEntry = new FileManagerEntryImpl();

		fileManagerEntry.setNew(true);
		fileManagerEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		fileManagerEntry.setUuid(uuid);

		fileManagerEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return fileManagerEntry;
	}

	/**
	 * Removes the file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry that was removed
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry remove(long id)
		throws NoSuchFileManagerEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file manager entry
	 * @return the file manager entry that was removed
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry remove(Serializable primaryKey)
		throws NoSuchFileManagerEntryException {

		Session session = null;

		try {
			session = openSession();

			FileManagerEntry fileManagerEntry = (FileManagerEntry)session.get(
				FileManagerEntryImpl.class, primaryKey);

			if (fileManagerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileManagerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fileManagerEntry);
		}
		catch (NoSuchFileManagerEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FileManagerEntry removeImpl(FileManagerEntry fileManagerEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileManagerEntry)) {
				fileManagerEntry = (FileManagerEntry)session.get(
					FileManagerEntryImpl.class,
					fileManagerEntry.getPrimaryKeyObj());
			}

			if (fileManagerEntry != null) {
				session.delete(fileManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fileManagerEntry != null) {
			clearCache(fileManagerEntry);
		}

		return fileManagerEntry;
	}

	@Override
	public FileManagerEntry updateImpl(FileManagerEntry fileManagerEntry) {
		boolean isNew = fileManagerEntry.isNew();

		if (!(fileManagerEntry instanceof FileManagerEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fileManagerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fileManagerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fileManagerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FileManagerEntry implementation " +
					fileManagerEntry.getClass());
		}

		FileManagerEntryModelImpl fileManagerEntryModelImpl =
			(FileManagerEntryModelImpl)fileManagerEntry;

		if (Validator.isNull(fileManagerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fileManagerEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fileManagerEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				fileManagerEntry.setCreateDate(date);
			}
			else {
				fileManagerEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!fileManagerEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fileManagerEntry.setModifiedDate(date);
			}
			else {
				fileManagerEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fileManagerEntry);
			}
			else {
				fileManagerEntry = (FileManagerEntry)session.merge(
					fileManagerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FileManagerEntryImpl.class, fileManagerEntryModelImpl, false, true);

		cacheUniqueFindersCache(fileManagerEntryModelImpl);

		if (isNew) {
			fileManagerEntry.setNew(false);
		}

		fileManagerEntry.resetOriginalValues();

		return fileManagerEntry;
	}

	/**
	 * Returns the file manager entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileManagerEntryException {

		FileManagerEntry fileManagerEntry = fetchByPrimaryKey(primaryKey);

		if (fileManagerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileManagerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fileManagerEntry;
	}

	/**
	 * Returns the file manager entry with the primary key or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry findByPrimaryKey(long id)
		throws NoSuchFileManagerEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry, or <code>null</code> if a file manager entry with the primary key could not be found
	 */
	@Override
	public FileManagerEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the file manager entries.
	 *
	 * @return the file manager entries
	 */
	@Override
	public List<FileManagerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of file manager entries
	 */
	@Override
	public List<FileManagerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file manager entries
	 */
	@Override
	public List<FileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file manager entries
	 */
	@Override
	public List<FileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FileManagerEntry> list = null;

		if (useFinderCache) {
			list = (List<FileManagerEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILEMANAGERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILEMANAGERENTRY;

				sql = sql.concat(FileManagerEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FileManagerEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the file manager entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FileManagerEntry fileManagerEntry : findAll()) {
			remove(fileManagerEntry);
		}
	}

	/**
	 * Returns the number of file manager entries.
	 *
	 * @return the number of file manager entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILEMANAGERENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FILEMANAGERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FileManagerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the file manager entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByF_B = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByF_B",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"fileId", "businessId"}, true);

		_finderPathCountByF_B = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_B",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"fileId", "businessId"}, false);

		_finderPathWithPaginationFindByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_PID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "projectId"}, true);

		_finderPathWithoutPaginationFindByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_PID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, true);

		_finderPathCountByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_PID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, false);

		_finderPathWithPaginationFindByB_PHID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_PHID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "phaseId"}, true);

		_finderPathWithoutPaginationFindByB_PHID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_PHID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "phaseId"}, true);

		_finderPathCountByB_PHID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_PHID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "phaseId"}, false);

		_finderPathWithPaginationFindByB_WID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_WID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "workId"}, true);

		_finderPathWithoutPaginationFindByB_WID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_WID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "workId"}, true);

		_finderPathCountByB_WID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_WID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "workId"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setFileManagerEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFileManagerEntryUtilPersistence(null);

		entityCache.removeCache(FileManagerEntryImpl.class.getName());
	}

	private void _setFileManagerEntryUtilPersistence(
		FileManagerEntryPersistence fileManagerEntryPersistence) {

		try {
			Field field = FileManagerEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fileManagerEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FIlePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FIlePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FIlePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FILEMANAGERENTRY =
		"SELECT fileManagerEntry FROM FileManagerEntry fileManagerEntry";

	private static final String _SQL_SELECT_FILEMANAGERENTRY_WHERE =
		"SELECT fileManagerEntry FROM FileManagerEntry fileManagerEntry WHERE ";

	private static final String _SQL_COUNT_FILEMANAGERENTRY =
		"SELECT COUNT(fileManagerEntry) FROM FileManagerEntry fileManagerEntry";

	private static final String _SQL_COUNT_FILEMANAGERENTRY_WHERE =
		"SELECT COUNT(fileManagerEntry) FROM FileManagerEntry fileManagerEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fileManagerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FileManagerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FileManagerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FileManagerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private FileManagerEntryModelArgumentsResolver
		_fileManagerEntryModelArgumentsResolver;

}