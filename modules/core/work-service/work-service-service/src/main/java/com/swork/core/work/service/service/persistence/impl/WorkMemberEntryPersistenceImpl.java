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

package com.swork.core.work.service.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.swork.core.work.service.exception.NoSuchWorkMemberEntryException;
import com.swork.core.work.service.model.WorkMemberEntry;
import com.swork.core.work.service.model.WorkMemberEntryTable;
import com.swork.core.work.service.model.impl.WorkMemberEntryImpl;
import com.swork.core.work.service.model.impl.WorkMemberEntryModelImpl;
import com.swork.core.work.service.service.persistence.WorkMemberEntryPersistence;
import com.swork.core.work.service.service.persistence.WorkMemberEntryUtil;
import com.swork.core.work.service.service.persistence.impl.constants.SW_WORKPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the work member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {WorkMemberEntryPersistence.class, BasePersistence.class})
public class WorkMemberEntryPersistenceImpl
	extends BasePersistenceImpl<WorkMemberEntry>
	implements WorkMemberEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkMemberEntryUtil</code> to access the work member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkMemberEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByW_MT_T;
	private FinderPath _finderPathWithoutPaginationFindByW_MT_T;
	private FinderPath _finderPathCountByW_MT_T;

	/**
	 * Returns all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type) {

		return findByW_MT_T(
			workId, memberType, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end) {

		return findByW_MT_T(workId, memberType, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return findByW_MT_T(
			workId, memberType, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByW_MT_T;
				finderArgs = new Object[] {workId, memberType, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByW_MT_T;
			finderArgs = new Object[] {
				workId, memberType, type, start, end, orderByComparator
			};
		}

		List<WorkMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkMemberEntry workMemberEntry : list) {
					if ((workId != workMemberEntry.getWorkId()) ||
						!memberType.equals(workMemberEntry.getMemberType()) ||
						!type.equals(workMemberEntry.getType())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W_MT_T_WORKID_2);

			boolean bindMemberType = false;

			if (memberType.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_MT_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_W_MT_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

				if (bindMemberType) {
					queryPos.add(memberType);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<WorkMemberEntry>)QueryUtil.list(
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
	 * Returns the first work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW_MT_T_First(
			long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW_MT_T_First(
			workId, memberType, type, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append(", memberType=");
		sb.append(memberType);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW_MT_T_First(
		long workId, String memberType, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		List<WorkMemberEntry> list = findByW_MT_T(
			workId, memberType, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW_MT_T_Last(
			long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW_MT_T_Last(
			workId, memberType, type, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append(", memberType=");
		sb.append(memberType);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW_MT_T_Last(
		long workId, String memberType, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		int count = countByW_MT_T(workId, memberType, type);

		if (count == 0) {
			return null;
		}

		List<WorkMemberEntry> list = findByW_MT_T(
			workId, memberType, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry[] findByW_MT_T_PrevAndNext(
			long workMemberId, long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		WorkMemberEntry workMemberEntry = findByPrimaryKey(workMemberId);

		Session session = null;

		try {
			session = openSession();

			WorkMemberEntry[] array = new WorkMemberEntryImpl[3];

			array[0] = getByW_MT_T_PrevAndNext(
				session, workMemberEntry, workId, memberType, type,
				orderByComparator, true);

			array[1] = workMemberEntry;

			array[2] = getByW_MT_T_PrevAndNext(
				session, workMemberEntry, workId, memberType, type,
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

	protected WorkMemberEntry getByW_MT_T_PrevAndNext(
		Session session, WorkMemberEntry workMemberEntry, long workId,
		String memberType, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_W_MT_T_WORKID_2);

		boolean bindMemberType = false;

		if (memberType.isEmpty()) {
			sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_3);
		}
		else {
			bindMemberType = true;

			sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_W_MT_T_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_W_MT_T_TYPE_2);
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
			sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workId);

		if (bindMemberType) {
			queryPos.add(memberType);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work member entries where workId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 */
	@Override
	public void removeByW_MT_T(long workId, String memberType, String type) {
		for (WorkMemberEntry workMemberEntry :
				findByW_MT_T(
					workId, memberType, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(workMemberEntry);
		}
	}

	/**
	 * Returns the number of work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	@Override
	public int countByW_MT_T(long workId, String memberType, String type) {
		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByW_MT_T;

		Object[] finderArgs = new Object[] {workId, memberType, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W_MT_T_WORKID_2);

			boolean bindMemberType = false;

			if (memberType.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				sb.append(_FINDER_COLUMN_W_MT_T_MEMBERTYPE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_MT_T_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_W_MT_T_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

				if (bindMemberType) {
					queryPos.add(memberType);
				}

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_W_MT_T_WORKID_2 =
		"workMemberEntry.workId = ? AND ";

	private static final String _FINDER_COLUMN_W_MT_T_MEMBERTYPE_2 =
		"workMemberEntry.memberType = ? AND ";

	private static final String _FINDER_COLUMN_W_MT_T_MEMBERTYPE_3 =
		"(workMemberEntry.memberType IS NULL OR workMemberEntry.memberType = '') AND ";

	private static final String _FINDER_COLUMN_W_MT_T_TYPE_2 =
		"workMemberEntry.type = ?";

	private static final String _FINDER_COLUMN_W_MT_T_TYPE_3 =
		"(workMemberEntry.type IS NULL OR workMemberEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByW_T_;
	private FinderPath _finderPathWithoutPaginationFindByW_T_;
	private FinderPath _finderPathCountByW_T_;

	/**
	 * Returns all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_T_(long workId, String type) {
		return findByW_T_(
			workId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end) {

		return findByW_T_(workId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return findByW_T_(workId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByW_T_;
				finderArgs = new Object[] {workId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByW_T_;
			finderArgs = new Object[] {
				workId, type, start, end, orderByComparator
			};
		}

		List<WorkMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkMemberEntry workMemberEntry : list) {
					if ((workId != workMemberEntry.getWorkId()) ||
						!type.equals(workMemberEntry.getType())) {

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

			sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W_T__WORKID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_T__TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_W_T__TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<WorkMemberEntry>)QueryUtil.list(
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
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW_T__First(
			long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW_T__First(
			workId, type, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW_T__First(
		long workId, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		List<WorkMemberEntry> list = findByW_T_(
			workId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW_T__Last(
			long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW_T__Last(
			workId, type, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW_T__Last(
		long workId, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		int count = countByW_T_(workId, type);

		if (count == 0) {
			return null;
		}

		List<WorkMemberEntry> list = findByW_T_(
			workId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry[] findByW_T__PrevAndNext(
			long workMemberId, long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		type = Objects.toString(type, "");

		WorkMemberEntry workMemberEntry = findByPrimaryKey(workMemberId);

		Session session = null;

		try {
			session = openSession();

			WorkMemberEntry[] array = new WorkMemberEntryImpl[3];

			array[0] = getByW_T__PrevAndNext(
				session, workMemberEntry, workId, type, orderByComparator,
				true);

			array[1] = workMemberEntry;

			array[2] = getByW_T__PrevAndNext(
				session, workMemberEntry, workId, type, orderByComparator,
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

	protected WorkMemberEntry getByW_T__PrevAndNext(
		Session session, WorkMemberEntry workMemberEntry, long workId,
		String type, OrderByComparator<WorkMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_W_T__WORKID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_W_T__TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_W_T__TYPE_2);
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
			sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work member entries where workId = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param type the type
	 */
	@Override
	public void removeByW_T_(long workId, String type) {
		for (WorkMemberEntry workMemberEntry :
				findByW_T_(
					workId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workMemberEntry);
		}
	}

	/**
	 * Returns the number of work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	@Override
	public int countByW_T_(long workId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByW_T_;

		Object[] finderArgs = new Object[] {workId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W_T__WORKID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_W_T__TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_W_T__TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_W_T__WORKID_2 =
		"workMemberEntry.workId = ? AND ";

	private static final String _FINDER_COLUMN_W_T__TYPE_2 =
		"workMemberEntry.type = ?";

	private static final String _FINDER_COLUMN_W_T__TYPE_3 =
		"(workMemberEntry.type IS NULL OR workMemberEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByW_;
	private FinderPath _finderPathWithoutPaginationFindByW_;
	private FinderPath _finderPathCountByW_;

	/**
	 * Returns all the work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_(long workId) {
		return findByW_(workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_(long workId, int start, int end) {
		return findByW_(workId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return findByW_(workId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	@Override
	public List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByW_;
				finderArgs = new Object[] {workId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByW_;
			finderArgs = new Object[] {workId, start, end, orderByComparator};
		}

		List<WorkMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkMemberEntry workMemberEntry : list) {
					if (workId != workMemberEntry.getWorkId()) {
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

			sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W__WORKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

				list = (List<WorkMemberEntry>)QueryUtil.list(
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
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW__First(
			long workId, OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW__First(
			workId, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW__First(
		long workId, OrderByComparator<WorkMemberEntry> orderByComparator) {

		List<WorkMemberEntry> list = findByW_(workId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry findByW__Last(
			long workId, OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByW__Last(
			workId, orderByComparator);

		if (workMemberEntry != null) {
			return workMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchWorkMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	@Override
	public WorkMemberEntry fetchByW__Last(
		long workId, OrderByComparator<WorkMemberEntry> orderByComparator) {

		int count = countByW_(workId);

		if (count == 0) {
			return null;
		}

		List<WorkMemberEntry> list = findByW_(
			workId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry[] findByW__PrevAndNext(
			long workMemberId, long workId,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = findByPrimaryKey(workMemberId);

		Session session = null;

		try {
			session = openSession();

			WorkMemberEntry[] array = new WorkMemberEntryImpl[3];

			array[0] = getByW__PrevAndNext(
				session, workMemberEntry, workId, orderByComparator, true);

			array[1] = workMemberEntry;

			array[2] = getByW__PrevAndNext(
				session, workMemberEntry, workId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkMemberEntry getByW__PrevAndNext(
		Session session, WorkMemberEntry workMemberEntry, long workId,
		OrderByComparator<WorkMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_W__WORKID_2);

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
			sb.append(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(workId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work member entries where workId = &#63; from the database.
	 *
	 * @param workId the work ID
	 */
	@Override
	public void removeByW_(long workId) {
		for (WorkMemberEntry workMemberEntry :
				findByW_(workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workMemberEntry);
		}
	}

	/**
	 * Returns the number of work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the number of matching work member entries
	 */
	@Override
	public int countByW_(long workId) {
		FinderPath finderPath = _finderPathCountByW_;

		Object[] finderArgs = new Object[] {workId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_W__WORKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(workId);

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

	private static final String _FINDER_COLUMN_W__WORKID_2 =
		"workMemberEntry.workId = ?";

	public WorkMemberEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkMemberEntry.class);

		setModelImplClass(WorkMemberEntryImpl.class);
		setModelPKClass(long.class);

		setTable(WorkMemberEntryTable.INSTANCE);
	}

	/**
	 * Caches the work member entry in the entity cache if it is enabled.
	 *
	 * @param workMemberEntry the work member entry
	 */
	@Override
	public void cacheResult(WorkMemberEntry workMemberEntry) {
		entityCache.putResult(
			WorkMemberEntryImpl.class, workMemberEntry.getPrimaryKey(),
			workMemberEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work member entries in the entity cache if it is enabled.
	 *
	 * @param workMemberEntries the work member entries
	 */
	@Override
	public void cacheResult(List<WorkMemberEntry> workMemberEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workMemberEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkMemberEntry workMemberEntry : workMemberEntries) {
			if (entityCache.getResult(
					WorkMemberEntryImpl.class,
					workMemberEntry.getPrimaryKey()) == null) {

				cacheResult(workMemberEntry);
			}
		}
	}

	/**
	 * Clears the cache for all work member entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkMemberEntryImpl.class);

		finderCache.clearCache(WorkMemberEntryImpl.class);
	}

	/**
	 * Clears the cache for the work member entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkMemberEntry workMemberEntry) {
		entityCache.removeResult(WorkMemberEntryImpl.class, workMemberEntry);
	}

	@Override
	public void clearCache(List<WorkMemberEntry> workMemberEntries) {
		for (WorkMemberEntry workMemberEntry : workMemberEntries) {
			entityCache.removeResult(
				WorkMemberEntryImpl.class, workMemberEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkMemberEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkMemberEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work member entry with the primary key. Does not add the work member entry to the database.
	 *
	 * @param workMemberId the primary key for the new work member entry
	 * @return the new work member entry
	 */
	@Override
	public WorkMemberEntry create(long workMemberId) {
		WorkMemberEntry workMemberEntry = new WorkMemberEntryImpl();

		workMemberEntry.setNew(true);
		workMemberEntry.setPrimaryKey(workMemberId);

		return workMemberEntry;
	}

	/**
	 * Removes the work member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry that was removed
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry remove(long workMemberId)
		throws NoSuchWorkMemberEntryException {

		return remove((Serializable)workMemberId);
	}

	/**
	 * Removes the work member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work member entry
	 * @return the work member entry that was removed
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry remove(Serializable primaryKey)
		throws NoSuchWorkMemberEntryException {

		Session session = null;

		try {
			session = openSession();

			WorkMemberEntry workMemberEntry = (WorkMemberEntry)session.get(
				WorkMemberEntryImpl.class, primaryKey);

			if (workMemberEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkMemberEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workMemberEntry);
		}
		catch (NoSuchWorkMemberEntryException noSuchEntityException) {
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
	protected WorkMemberEntry removeImpl(WorkMemberEntry workMemberEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workMemberEntry)) {
				workMemberEntry = (WorkMemberEntry)session.get(
					WorkMemberEntryImpl.class,
					workMemberEntry.getPrimaryKeyObj());
			}

			if (workMemberEntry != null) {
				session.delete(workMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workMemberEntry != null) {
			clearCache(workMemberEntry);
		}

		return workMemberEntry;
	}

	@Override
	public WorkMemberEntry updateImpl(WorkMemberEntry workMemberEntry) {
		boolean isNew = workMemberEntry.isNew();

		if (!(workMemberEntry instanceof WorkMemberEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workMemberEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workMemberEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workMemberEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkMemberEntry implementation " +
					workMemberEntry.getClass());
		}

		WorkMemberEntryModelImpl workMemberEntryModelImpl =
			(WorkMemberEntryModelImpl)workMemberEntry;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workMemberEntry);
			}
			else {
				workMemberEntry = (WorkMemberEntry)session.merge(
					workMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkMemberEntryImpl.class, workMemberEntryModelImpl, false, true);

		if (isNew) {
			workMemberEntry.setNew(false);
		}

		workMemberEntry.resetOriginalValues();

		return workMemberEntry;
	}

	/**
	 * Returns the work member entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work member entry
	 * @return the work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkMemberEntryException {

		WorkMemberEntry workMemberEntry = fetchByPrimaryKey(primaryKey);

		if (workMemberEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkMemberEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workMemberEntry;
	}

	/**
	 * Returns the work member entry with the primary key or throws a <code>NoSuchWorkMemberEntryException</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry findByPrimaryKey(long workMemberId)
		throws NoSuchWorkMemberEntryException {

		return findByPrimaryKey((Serializable)workMemberId);
	}

	/**
	 * Returns the work member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry, or <code>null</code> if a work member entry with the primary key could not be found
	 */
	@Override
	public WorkMemberEntry fetchByPrimaryKey(long workMemberId) {
		return fetchByPrimaryKey((Serializable)workMemberId);
	}

	/**
	 * Returns all the work member entries.
	 *
	 * @return the work member entries
	 */
	@Override
	public List<WorkMemberEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of work member entries
	 */
	@Override
	public List<WorkMemberEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work member entries
	 */
	@Override
	public List<WorkMemberEntry> findAll(
		int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work member entries
	 */
	@Override
	public List<WorkMemberEntry> findAll(
		int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
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

		List<WorkMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKMEMBERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKMEMBERENTRY;

				sql = sql.concat(WorkMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkMemberEntry>)QueryUtil.list(
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
	 * Removes all the work member entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkMemberEntry workMemberEntry : findAll()) {
			remove(workMemberEntry);
		}
	}

	/**
	 * Returns the number of work member entries.
	 *
	 * @return the number of work member entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKMEMBERENTRY);

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
		return "workMemberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKMEMBERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkMemberEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work member entry persistence.
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

		_finderPathWithPaginationFindByW_MT_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByW_MT_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workId", "memberType", "type_"}, true);

		_finderPathWithoutPaginationFindByW_MT_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByW_MT_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"workId", "memberType", "type_"}, true);

		_finderPathCountByW_MT_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_MT_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"workId", "memberType", "type_"}, false);

		_finderPathWithPaginationFindByW_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByW_T_",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"workId", "type_"}, true);

		_finderPathWithoutPaginationFindByW_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByW_T_",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"workId", "type_"}, true);

		_finderPathCountByW_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_T_",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"workId", "type_"}, false);

		_finderPathWithPaginationFindByW_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByW_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"workId"}, true);

		_finderPathWithoutPaginationFindByW_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByW_",
			new String[] {Long.class.getName()}, new String[] {"workId"}, true);

		_finderPathCountByW_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_",
			new String[] {Long.class.getName()}, new String[] {"workId"},
			false);

		_setWorkMemberEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setWorkMemberEntryUtilPersistence(null);

		entityCache.removeCache(WorkMemberEntryImpl.class.getName());
	}

	private void _setWorkMemberEntryUtilPersistence(
		WorkMemberEntryPersistence workMemberEntryPersistence) {

		try {
			Field field = WorkMemberEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, workMemberEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_WORKMEMBERENTRY =
		"SELECT workMemberEntry FROM WorkMemberEntry workMemberEntry";

	private static final String _SQL_SELECT_WORKMEMBERENTRY_WHERE =
		"SELECT workMemberEntry FROM WorkMemberEntry workMemberEntry WHERE ";

	private static final String _SQL_COUNT_WORKMEMBERENTRY =
		"SELECT COUNT(workMemberEntry) FROM WorkMemberEntry workMemberEntry";

	private static final String _SQL_COUNT_WORKMEMBERENTRY_WHERE =
		"SELECT COUNT(workMemberEntry) FROM WorkMemberEntry workMemberEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workMemberEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkMemberEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkMemberEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkMemberEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private WorkMemberEntryModelArgumentsResolver
		_workMemberEntryModelArgumentsResolver;

}