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

package com.swork.core.project.service.service.persistence.impl;

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

import com.swork.core.project.service.exception.NoSuchProjectMemberEntryException;
import com.swork.core.project.service.model.ProjectMemberEntry;
import com.swork.core.project.service.model.ProjectMemberEntryTable;
import com.swork.core.project.service.model.impl.ProjectMemberEntryImpl;
import com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl;
import com.swork.core.project.service.service.persistence.ProjectMemberEntryPersistence;
import com.swork.core.project.service.service.persistence.ProjectMemberEntryUtil;
import com.swork.core.project.service.service.persistence.impl.constants.SW_PROJECTPersistenceConstants;

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
 * The persistence implementation for the project member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ProjectMemberEntryPersistence.class, BasePersistence.class}
)
public class ProjectMemberEntryPersistenceImpl
	extends BasePersistenceImpl<ProjectMemberEntry>
	implements ProjectMemberEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectMemberEntryUtil</code> to access the project member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectMemberEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByP_T_MT;
	private FinderPath _finderPathWithoutPaginationFindByP_T_MT;
	private FinderPath _finderPathCountByP_T_MT;

	/**
	 * Returns all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type) {

		return findByP_T_MT(
			projectId, memberType, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end) {

		return findByP_T_MT(projectId, memberType, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return findByP_T_MT(
			projectId, memberType, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_T_MT;
				finderArgs = new Object[] {projectId, memberType, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_T_MT;
			finderArgs = new Object[] {
				projectId, memberType, type, start, end, orderByComparator
			};
		}

		List<ProjectMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectMemberEntry projectMemberEntry : list) {
					if ((projectId != projectMemberEntry.getProjectId()) ||
						!memberType.equals(
							projectMemberEntry.getMemberType()) ||
						!type.equals(projectMemberEntry.getType())) {

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

			sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_T_MT_PROJECTID_2);

			boolean bindMemberType = false;

			if (memberType.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T_MT_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_P_T_MT_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				if (bindMemberType) {
					queryPos.add(memberType);
				}

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<ProjectMemberEntry>)QueryUtil.list(
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
	 * Returns the first project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP_T_MT_First(
			long projectId, String memberType, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP_T_MT_First(
			projectId, memberType, type, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", memberType=");
		sb.append(memberType);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP_T_MT_First(
		long projectId, String memberType, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		List<ProjectMemberEntry> list = findByP_T_MT(
			projectId, memberType, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP_T_MT_Last(
			long projectId, String memberType, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP_T_MT_Last(
			projectId, memberType, type, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", memberType=");
		sb.append(memberType);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP_T_MT_Last(
		long projectId, String memberType, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		int count = countByP_T_MT(projectId, memberType, type);

		if (count == 0) {
			return null;
		}

		List<ProjectMemberEntry> list = findByP_T_MT(
			projectId, memberType, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry[] findByP_T_MT_PrevAndNext(
			long projectMemberId, long projectId, String memberType,
			String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		ProjectMemberEntry projectMemberEntry = findByPrimaryKey(
			projectMemberId);

		Session session = null;

		try {
			session = openSession();

			ProjectMemberEntry[] array = new ProjectMemberEntryImpl[3];

			array[0] = getByP_T_MT_PrevAndNext(
				session, projectMemberEntry, projectId, memberType, type,
				orderByComparator, true);

			array[1] = projectMemberEntry;

			array[2] = getByP_T_MT_PrevAndNext(
				session, projectMemberEntry, projectId, memberType, type,
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

	protected ProjectMemberEntry getByP_T_MT_PrevAndNext(
		Session session, ProjectMemberEntry projectMemberEntry, long projectId,
		String memberType, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P_T_MT_PROJECTID_2);

		boolean bindMemberType = false;

		if (memberType.isEmpty()) {
			sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_3);
		}
		else {
			bindMemberType = true;

			sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_P_T_MT_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_P_T_MT_TYPE_2);
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
			sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (bindMemberType) {
			queryPos.add(memberType);
		}

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 */
	@Override
	public void removeByP_T_MT(long projectId, String memberType, String type) {
		for (ProjectMemberEntry projectMemberEntry :
				findByP_T_MT(
					projectId, memberType, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(projectMemberEntry);
		}
	}

	/**
	 * Returns the number of project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching project member entries
	 */
	@Override
	public int countByP_T_MT(long projectId, String memberType, String type) {
		memberType = Objects.toString(memberType, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByP_T_MT;

		Object[] finderArgs = new Object[] {projectId, memberType, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_T_MT_PROJECTID_2);

			boolean bindMemberType = false;

			if (memberType.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				sb.append(_FINDER_COLUMN_P_T_MT_MEMBERTYPE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T_MT_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_P_T_MT_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_P_T_MT_PROJECTID_2 =
		"projectMemberEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_P_T_MT_MEMBERTYPE_2 =
		"projectMemberEntry.memberType = ? AND ";

	private static final String _FINDER_COLUMN_P_T_MT_MEMBERTYPE_3 =
		"(projectMemberEntry.memberType IS NULL OR projectMemberEntry.memberType = '') AND ";

	private static final String _FINDER_COLUMN_P_T_MT_TYPE_2 =
		"projectMemberEntry.type = ?";

	private static final String _FINDER_COLUMN_P_T_MT_TYPE_3 =
		"(projectMemberEntry.type IS NULL OR projectMemberEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByP_T_;
	private FinderPath _finderPathWithoutPaginationFindByP_T_;
	private FinderPath _finderPathCountByP_T_;

	/**
	 * Returns all the project member entries where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @return the matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_(long projectId, String type) {
		return findByP_T_(
			projectId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project member entries where projectId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_(
		long projectId, String type, int start, int end) {

		return findByP_T_(projectId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_(
		long projectId, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return findByP_T_(projectId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_T_(
		long projectId, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_T_;
				finderArgs = new Object[] {projectId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_T_;
			finderArgs = new Object[] {
				projectId, type, start, end, orderByComparator
			};
		}

		List<ProjectMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectMemberEntry projectMemberEntry : list) {
					if ((projectId != projectMemberEntry.getProjectId()) ||
						!type.equals(projectMemberEntry.getType())) {

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

			sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_T__PROJECTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T__TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_P_T__TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<ProjectMemberEntry>)QueryUtil.list(
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
	 * Returns the first project member entry in the ordered set where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP_T__First(
			long projectId, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP_T__First(
			projectId, type, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP_T__First(
		long projectId, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		List<ProjectMemberEntry> list = findByP_T_(
			projectId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP_T__Last(
			long projectId, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP_T__Last(
			projectId, type, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP_T__Last(
		long projectId, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		int count = countByP_T_(projectId, type);

		if (count == 0) {
			return null;
		}

		List<ProjectMemberEntry> list = findByP_T_(
			projectId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63; and type = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry[] findByP_T__PrevAndNext(
			long projectMemberId, long projectId, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		type = Objects.toString(type, "");

		ProjectMemberEntry projectMemberEntry = findByPrimaryKey(
			projectMemberId);

		Session session = null;

		try {
			session = openSession();

			ProjectMemberEntry[] array = new ProjectMemberEntryImpl[3];

			array[0] = getByP_T__PrevAndNext(
				session, projectMemberEntry, projectId, type, orderByComparator,
				true);

			array[1] = projectMemberEntry;

			array[2] = getByP_T__PrevAndNext(
				session, projectMemberEntry, projectId, type, orderByComparator,
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

	protected ProjectMemberEntry getByP_T__PrevAndNext(
		Session session, ProjectMemberEntry projectMemberEntry, long projectId,
		String type, OrderByComparator<ProjectMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P_T__PROJECTID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_P_T__TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_P_T__TYPE_2);
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
			sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project member entries where projectId = &#63; and type = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 */
	@Override
	public void removeByP_T_(long projectId, String type) {
		for (ProjectMemberEntry projectMemberEntry :
				findByP_T_(
					projectId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectMemberEntry);
		}
	}

	/**
	 * Returns the number of project member entries where projectId = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param type the type
	 * @return the number of matching project member entries
	 */
	@Override
	public int countByP_T_(long projectId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByP_T_;

		Object[] finderArgs = new Object[] {projectId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_T__PROJECTID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_T__TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_P_T__TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_P_T__PROJECTID_2 =
		"projectMemberEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_P_T__TYPE_2 =
		"projectMemberEntry.type = ?";

	private static final String _FINDER_COLUMN_P_T__TYPE_3 =
		"(projectMemberEntry.type IS NULL OR projectMemberEntry.type = '')";

	private FinderPath _finderPathWithPaginationFindByP_;
	private FinderPath _finderPathWithoutPaginationFindByP_;
	private FinderPath _finderPathCountByP_;

	/**
	 * Returns all the project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_(long projectId) {
		return findByP_(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end) {

		return findByP_(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return findByP_(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<ProjectMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectMemberEntry projectMemberEntry : list) {
					if (projectId != projectMemberEntry.getProjectId()) {
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

			sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<ProjectMemberEntry>)QueryUtil.list(
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
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP__First(
			long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP__First(
			projectId, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP__First(
		long projectId,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		List<ProjectMemberEntry> list = findByP_(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry findByP__Last(
			long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByP__Last(
			projectId, orderByComparator);

		if (projectMemberEntry != null) {
			return projectMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchProjectMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByP__Last(
		long projectId,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		int count = countByP_(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectMemberEntry> list = findByP_(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry[] findByP__PrevAndNext(
			long projectMemberId, long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = findByPrimaryKey(
			projectMemberId);

		Session session = null;

		try {
			session = openSession();

			ProjectMemberEntry[] array = new ProjectMemberEntryImpl[3];

			array[0] = getByP__PrevAndNext(
				session, projectMemberEntry, projectId, orderByComparator,
				true);

			array[1] = projectMemberEntry;

			array[2] = getByP__PrevAndNext(
				session, projectMemberEntry, projectId, orderByComparator,
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

	protected ProjectMemberEntry getByP__PrevAndNext(
		Session session, ProjectMemberEntry projectMemberEntry, long projectId,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PROJECTMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P__PROJECTID_2);

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
			sb.append(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project member entries where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByP_(long projectId) {
		for (ProjectMemberEntry projectMemberEntry :
				findByP_(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectMemberEntry);
		}
	}

	/**
	 * Returns the number of project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project member entries
	 */
	@Override
	public int countByP_(long projectId) {
		FinderPath finderPath = _finderPathCountByP_;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_P__PROJECTID_2 =
		"projectMemberEntry.projectId = ?";

	public ProjectMemberEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectMemberEntry.class);

		setModelImplClass(ProjectMemberEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectMemberEntryTable.INSTANCE);
	}

	/**
	 * Caches the project member entry in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntry the project member entry
	 */
	@Override
	public void cacheResult(ProjectMemberEntry projectMemberEntry) {
		entityCache.putResult(
			ProjectMemberEntryImpl.class, projectMemberEntry.getPrimaryKey(),
			projectMemberEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project member entries in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntries the project member entries
	 */
	@Override
	public void cacheResult(List<ProjectMemberEntry> projectMemberEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectMemberEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectMemberEntry projectMemberEntry : projectMemberEntries) {
			if (entityCache.getResult(
					ProjectMemberEntryImpl.class,
					projectMemberEntry.getPrimaryKey()) == null) {

				cacheResult(projectMemberEntry);
			}
		}
	}

	/**
	 * Clears the cache for all project member entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectMemberEntryImpl.class);

		finderCache.clearCache(ProjectMemberEntryImpl.class);
	}

	/**
	 * Clears the cache for the project member entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectMemberEntry projectMemberEntry) {
		entityCache.removeResult(
			ProjectMemberEntryImpl.class, projectMemberEntry);
	}

	@Override
	public void clearCache(List<ProjectMemberEntry> projectMemberEntries) {
		for (ProjectMemberEntry projectMemberEntry : projectMemberEntries) {
			entityCache.removeResult(
				ProjectMemberEntryImpl.class, projectMemberEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectMemberEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectMemberEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	@Override
	public ProjectMemberEntry create(long projectMemberId) {
		ProjectMemberEntry projectMemberEntry = new ProjectMemberEntryImpl();

		projectMemberEntry.setNew(true);
		projectMemberEntry.setPrimaryKey(projectMemberId);

		return projectMemberEntry;
	}

	/**
	 * Removes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry remove(long projectMemberId)
		throws NoSuchProjectMemberEntryException {

		return remove((Serializable)projectMemberId);
	}

	/**
	 * Removes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry remove(Serializable primaryKey)
		throws NoSuchProjectMemberEntryException {

		Session session = null;

		try {
			session = openSession();

			ProjectMemberEntry projectMemberEntry =
				(ProjectMemberEntry)session.get(
					ProjectMemberEntryImpl.class, primaryKey);

			if (projectMemberEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectMemberEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectMemberEntry);
		}
		catch (NoSuchProjectMemberEntryException noSuchEntityException) {
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
	protected ProjectMemberEntry removeImpl(
		ProjectMemberEntry projectMemberEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectMemberEntry)) {
				projectMemberEntry = (ProjectMemberEntry)session.get(
					ProjectMemberEntryImpl.class,
					projectMemberEntry.getPrimaryKeyObj());
			}

			if (projectMemberEntry != null) {
				session.delete(projectMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectMemberEntry != null) {
			clearCache(projectMemberEntry);
		}

		return projectMemberEntry;
	}

	@Override
	public ProjectMemberEntry updateImpl(
		ProjectMemberEntry projectMemberEntry) {

		boolean isNew = projectMemberEntry.isNew();

		if (!(projectMemberEntry instanceof ProjectMemberEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectMemberEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectMemberEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectMemberEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectMemberEntry implementation " +
					projectMemberEntry.getClass());
		}

		ProjectMemberEntryModelImpl projectMemberEntryModelImpl =
			(ProjectMemberEntryModelImpl)projectMemberEntry;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectMemberEntry);
			}
			else {
				projectMemberEntry = (ProjectMemberEntry)session.merge(
					projectMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectMemberEntryImpl.class, projectMemberEntryModelImpl, false,
			true);

		if (isNew) {
			projectMemberEntry.setNew(false);
		}

		projectMemberEntry.resetOriginalValues();

		return projectMemberEntry;
	}

	/**
	 * Returns the project member entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project member entry
	 * @return the project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectMemberEntryException {

		ProjectMemberEntry projectMemberEntry = fetchByPrimaryKey(primaryKey);

		if (projectMemberEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectMemberEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectMemberEntry;
	}

	/**
	 * Returns the project member entry with the primary key or throws a <code>NoSuchProjectMemberEntryException</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry findByPrimaryKey(long projectMemberId)
		throws NoSuchProjectMemberEntryException {

		return findByPrimaryKey((Serializable)projectMemberId);
	}

	/**
	 * Returns the project member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry, or <code>null</code> if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry fetchByPrimaryKey(long projectMemberId) {
		return fetchByPrimaryKey((Serializable)projectMemberId);
	}

	/**
	 * Returns all the project member entries.
	 *
	 * @return the project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findAll(
		int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project member entries
	 */
	@Override
	public List<ProjectMemberEntry> findAll(
		int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
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

		List<ProjectMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTMEMBERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTMEMBERENTRY;

				sql = sql.concat(ProjectMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectMemberEntry>)QueryUtil.list(
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
	 * Removes all the project member entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectMemberEntry projectMemberEntry : findAll()) {
			remove(projectMemberEntry);
		}
	}

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PROJECTMEMBERENTRY);

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
		return "projectMemberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTMEMBERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectMemberEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project member entry persistence.
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

		_finderPathWithPaginationFindByP_T_MT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_T_MT",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId", "memberType", "type_"}, true);

		_finderPathWithoutPaginationFindByP_T_MT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_T_MT",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"projectId", "memberType", "type_"}, true);

		_finderPathCountByP_T_MT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_T_MT",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"projectId", "memberType", "type_"}, false);

		_finderPathWithPaginationFindByP_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_T_",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"projectId", "type_"}, true);

		_finderPathWithoutPaginationFindByP_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_T_",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"projectId", "type_"}, true);

		_finderPathCountByP_T_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_T_",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"projectId", "type_"}, false);

		_finderPathWithPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_setProjectMemberEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProjectMemberEntryUtilPersistence(null);

		entityCache.removeCache(ProjectMemberEntryImpl.class.getName());
	}

	private void _setProjectMemberEntryUtilPersistence(
		ProjectMemberEntryPersistence projectMemberEntryPersistence) {

		try {
			Field field = ProjectMemberEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, projectMemberEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROJECTMEMBERENTRY =
		"SELECT projectMemberEntry FROM ProjectMemberEntry projectMemberEntry";

	private static final String _SQL_SELECT_PROJECTMEMBERENTRY_WHERE =
		"SELECT projectMemberEntry FROM ProjectMemberEntry projectMemberEntry WHERE ";

	private static final String _SQL_COUNT_PROJECTMEMBERENTRY =
		"SELECT COUNT(projectMemberEntry) FROM ProjectMemberEntry projectMemberEntry";

	private static final String _SQL_COUNT_PROJECTMEMBERENTRY_WHERE =
		"SELECT COUNT(projectMemberEntry) FROM ProjectMemberEntry projectMemberEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectMemberEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectMemberEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectMemberEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectMemberEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProjectMemberEntryModelArgumentsResolver
		_projectMemberEntryModelArgumentsResolver;

}