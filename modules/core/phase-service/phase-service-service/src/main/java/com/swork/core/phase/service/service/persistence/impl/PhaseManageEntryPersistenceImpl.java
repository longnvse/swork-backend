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

package com.swork.core.phase.service.service.persistence.impl;

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

import com.swork.core.phase.service.exception.NoSuchPhaseManageEntryException;
import com.swork.core.phase.service.model.PhaseManageEntry;
import com.swork.core.phase.service.model.PhaseManageEntryTable;
import com.swork.core.phase.service.model.impl.PhaseManageEntryImpl;
import com.swork.core.phase.service.model.impl.PhaseManageEntryModelImpl;
import com.swork.core.phase.service.service.persistence.PhaseManageEntryPersistence;
import com.swork.core.phase.service.service.persistence.PhaseManageEntryUtil;
import com.swork.core.phase.service.service.persistence.impl.constants.SW_PHASEPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the phase manage entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PhaseManageEntryPersistence.class, BasePersistence.class})
public class PhaseManageEntryPersistenceImpl
	extends BasePersistenceImpl<PhaseManageEntry>
	implements PhaseManageEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhaseManageEntryUtil</code> to access the phase manage entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhaseManageEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByP_;
	private FinderPath _finderPathWithoutPaginationFindByP_;
	private FinderPath _finderPathCountByP_;

	/**
	 * Returns all the phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the matching phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findByP_(long phaseId) {
		return findByP_(phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @return the range of matching phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findByP_(long phaseId, int start, int end) {
		return findByP_(phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator) {

		return findByP_(phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_;
				finderArgs = new Object[] {phaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_;
			finderArgs = new Object[] {phaseId, start, end, orderByComparator};
		}

		List<PhaseManageEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseManageEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhaseManageEntry phaseManageEntry : list) {
					if (phaseId != phaseManageEntry.getPhaseId()) {
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

			sb.append(_SQL_SELECT_PHASEMANAGEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhaseManageEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId);

				list = (List<PhaseManageEntry>)QueryUtil.list(
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
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	@Override
	public PhaseManageEntry findByP__First(
			long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator)
		throws NoSuchPhaseManageEntryException {

		PhaseManageEntry phaseManageEntry = fetchByP__First(
			phaseId, orderByComparator);

		if (phaseManageEntry != null) {
			return phaseManageEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchPhaseManageEntryException(sb.toString());
	}

	/**
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	@Override
	public PhaseManageEntry fetchByP__First(
		long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator) {

		List<PhaseManageEntry> list = findByP_(
			phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	@Override
	public PhaseManageEntry findByP__Last(
			long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator)
		throws NoSuchPhaseManageEntryException {

		PhaseManageEntry phaseManageEntry = fetchByP__Last(
			phaseId, orderByComparator);

		if (phaseManageEntry != null) {
			return phaseManageEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchPhaseManageEntryException(sb.toString());
	}

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	@Override
	public PhaseManageEntry fetchByP__Last(
		long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator) {

		int count = countByP_(phaseId);

		if (count == 0) {
			return null;
		}

		List<PhaseManageEntry> list = findByP_(
			phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phase manage entries before and after the current phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseManageId the primary key of the current phase manage entry
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry[] findByP__PrevAndNext(
			long phaseManageId, long phaseId,
			OrderByComparator<PhaseManageEntry> orderByComparator)
		throws NoSuchPhaseManageEntryException {

		PhaseManageEntry phaseManageEntry = findByPrimaryKey(phaseManageId);

		Session session = null;

		try {
			session = openSession();

			PhaseManageEntry[] array = new PhaseManageEntryImpl[3];

			array[0] = getByP__PrevAndNext(
				session, phaseManageEntry, phaseId, orderByComparator, true);

			array[1] = phaseManageEntry;

			array[2] = getByP__PrevAndNext(
				session, phaseManageEntry, phaseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhaseManageEntry getByP__PrevAndNext(
		Session session, PhaseManageEntry phaseManageEntry, long phaseId,
		OrderByComparator<PhaseManageEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PHASEMANAGEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P__PHASEID_2);

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
			sb.append(PhaseManageEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(phaseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						phaseManageEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhaseManageEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phase manage entries where phaseId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByP_(long phaseId) {
		for (PhaseManageEntry phaseManageEntry :
				findByP_(phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phaseManageEntry);
		}
	}

	/**
	 * Returns the number of phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the number of matching phase manage entries
	 */
	@Override
	public int countByP_(long phaseId) {
		FinderPath finderPath = _finderPathCountByP_;

		Object[] finderArgs = new Object[] {phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHASEMANAGEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId);

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

	private static final String _FINDER_COLUMN_P__PHASEID_2 =
		"phaseManageEntry.phaseId = ?";

	public PhaseManageEntryPersistenceImpl() {
		setModelClass(PhaseManageEntry.class);

		setModelImplClass(PhaseManageEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PhaseManageEntryTable.INSTANCE);
	}

	/**
	 * Caches the phase manage entry in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntry the phase manage entry
	 */
	@Override
	public void cacheResult(PhaseManageEntry phaseManageEntry) {
		entityCache.putResult(
			PhaseManageEntryImpl.class, phaseManageEntry.getPrimaryKey(),
			phaseManageEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phase manage entries in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntries the phase manage entries
	 */
	@Override
	public void cacheResult(List<PhaseManageEntry> phaseManageEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phaseManageEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PhaseManageEntry phaseManageEntry : phaseManageEntries) {
			if (entityCache.getResult(
					PhaseManageEntryImpl.class,
					phaseManageEntry.getPrimaryKey()) == null) {

				cacheResult(phaseManageEntry);
			}
		}
	}

	/**
	 * Clears the cache for all phase manage entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhaseManageEntryImpl.class);

		finderCache.clearCache(PhaseManageEntryImpl.class);
	}

	/**
	 * Clears the cache for the phase manage entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhaseManageEntry phaseManageEntry) {
		entityCache.removeResult(PhaseManageEntryImpl.class, phaseManageEntry);
	}

	@Override
	public void clearCache(List<PhaseManageEntry> phaseManageEntries) {
		for (PhaseManageEntry phaseManageEntry : phaseManageEntries) {
			entityCache.removeResult(
				PhaseManageEntryImpl.class, phaseManageEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhaseManageEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhaseManageEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new phase manage entry with the primary key. Does not add the phase manage entry to the database.
	 *
	 * @param phaseManageId the primary key for the new phase manage entry
	 * @return the new phase manage entry
	 */
	@Override
	public PhaseManageEntry create(long phaseManageId) {
		PhaseManageEntry phaseManageEntry = new PhaseManageEntryImpl();

		phaseManageEntry.setNew(true);
		phaseManageEntry.setPrimaryKey(phaseManageId);

		return phaseManageEntry;
	}

	/**
	 * Removes the phase manage entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry that was removed
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry remove(long phaseManageId)
		throws NoSuchPhaseManageEntryException {

		return remove((Serializable)phaseManageId);
	}

	/**
	 * Removes the phase manage entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phase manage entry
	 * @return the phase manage entry that was removed
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry remove(Serializable primaryKey)
		throws NoSuchPhaseManageEntryException {

		Session session = null;

		try {
			session = openSession();

			PhaseManageEntry phaseManageEntry = (PhaseManageEntry)session.get(
				PhaseManageEntryImpl.class, primaryKey);

			if (phaseManageEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhaseManageEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phaseManageEntry);
		}
		catch (NoSuchPhaseManageEntryException noSuchEntityException) {
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
	protected PhaseManageEntry removeImpl(PhaseManageEntry phaseManageEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phaseManageEntry)) {
				phaseManageEntry = (PhaseManageEntry)session.get(
					PhaseManageEntryImpl.class,
					phaseManageEntry.getPrimaryKeyObj());
			}

			if (phaseManageEntry != null) {
				session.delete(phaseManageEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phaseManageEntry != null) {
			clearCache(phaseManageEntry);
		}

		return phaseManageEntry;
	}

	@Override
	public PhaseManageEntry updateImpl(PhaseManageEntry phaseManageEntry) {
		boolean isNew = phaseManageEntry.isNew();

		if (!(phaseManageEntry instanceof PhaseManageEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phaseManageEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					phaseManageEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phaseManageEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhaseManageEntry implementation " +
					phaseManageEntry.getClass());
		}

		PhaseManageEntryModelImpl phaseManageEntryModelImpl =
			(PhaseManageEntryModelImpl)phaseManageEntry;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phaseManageEntry);
			}
			else {
				phaseManageEntry = (PhaseManageEntry)session.merge(
					phaseManageEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhaseManageEntryImpl.class, phaseManageEntryModelImpl, false, true);

		if (isNew) {
			phaseManageEntry.setNew(false);
		}

		phaseManageEntry.resetOriginalValues();

		return phaseManageEntry;
	}

	/**
	 * Returns the phase manage entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhaseManageEntryException {

		PhaseManageEntry phaseManageEntry = fetchByPrimaryKey(primaryKey);

		if (phaseManageEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhaseManageEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phaseManageEntry;
	}

	/**
	 * Returns the phase manage entry with the primary key or throws a <code>NoSuchPhaseManageEntryException</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry findByPrimaryKey(long phaseManageId)
		throws NoSuchPhaseManageEntryException {

		return findByPrimaryKey((Serializable)phaseManageId);
	}

	/**
	 * Returns the phase manage entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry, or <code>null</code> if a phase manage entry with the primary key could not be found
	 */
	@Override
	public PhaseManageEntry fetchByPrimaryKey(long phaseManageId) {
		return fetchByPrimaryKey((Serializable)phaseManageId);
	}

	/**
	 * Returns all the phase manage entries.
	 *
	 * @return the phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @return the range of phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findAll(
		int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phase manage entries
	 */
	@Override
	public List<PhaseManageEntry> findAll(
		int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator,
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

		List<PhaseManageEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseManageEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHASEMANAGEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHASEMANAGEENTRY;

				sql = sql.concat(PhaseManageEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhaseManageEntry>)QueryUtil.list(
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
	 * Removes all the phase manage entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhaseManageEntry phaseManageEntry : findAll()) {
			remove(phaseManageEntry);
		}
	}

	/**
	 * Returns the number of phase manage entries.
	 *
	 * @return the number of phase manage entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHASEMANAGEENTRY);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "phaseManageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHASEMANAGEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhaseManageEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phase manage entry persistence.
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

		_finderPathWithPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"phaseId"}, true);

		_finderPathWithoutPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_",
			new String[] {Long.class.getName()}, new String[] {"phaseId"},
			true);

		_finderPathCountByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_",
			new String[] {Long.class.getName()}, new String[] {"phaseId"},
			false);

		_setPhaseManageEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPhaseManageEntryUtilPersistence(null);

		entityCache.removeCache(PhaseManageEntryImpl.class.getName());
	}

	private void _setPhaseManageEntryUtilPersistence(
		PhaseManageEntryPersistence phaseManageEntryPersistence) {

		try {
			Field field = PhaseManageEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, phaseManageEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHASEMANAGEENTRY =
		"SELECT phaseManageEntry FROM PhaseManageEntry phaseManageEntry";

	private static final String _SQL_SELECT_PHASEMANAGEENTRY_WHERE =
		"SELECT phaseManageEntry FROM PhaseManageEntry phaseManageEntry WHERE ";

	private static final String _SQL_COUNT_PHASEMANAGEENTRY =
		"SELECT COUNT(phaseManageEntry) FROM PhaseManageEntry phaseManageEntry";

	private static final String _SQL_COUNT_PHASEMANAGEENTRY_WHERE =
		"SELECT COUNT(phaseManageEntry) FROM PhaseManageEntry phaseManageEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phaseManageEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhaseManageEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhaseManageEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhaseManageEntryPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PhaseManageEntryModelArgumentsResolver
		_phaseManageEntryModelArgumentsResolver;

}