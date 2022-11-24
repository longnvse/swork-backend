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

package com.swork.core.resource.service.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.swork.core.resource.service.model.TeamMemberEntry;
import com.swork.core.resource.service.service.TeamMemberEntryLocalService;
import com.swork.core.resource.service.service.TeamMemberEntryLocalServiceUtil;
import com.swork.core.resource.service.service.persistence.ResourceEntryPersistence;
import com.swork.core.resource.service.service.persistence.ResourceTypeEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamMemberEntryPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the team member entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.swork.core.resource.service.service.impl.TeamMemberEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.swork.core.resource.service.service.impl.TeamMemberEntryLocalServiceImpl
 * @generated
 */
public abstract class TeamMemberEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   TeamMemberEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TeamMemberEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TeamMemberEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the team member entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TeamMemberEntry addTeamMemberEntry(TeamMemberEntry teamMemberEntry) {
		teamMemberEntry.setNew(true);

		return teamMemberEntryPersistence.update(teamMemberEntry);
	}

	/**
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	@Override
	@Transactional(enabled = false)
	public TeamMemberEntry createTeamMemberEntry(long teamMemberId) {
		return teamMemberEntryPersistence.create(teamMemberId);
	}

	/**
	 * Deletes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws PortalException if a team member entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TeamMemberEntry deleteTeamMemberEntry(long teamMemberId)
		throws PortalException {

		return teamMemberEntryPersistence.remove(teamMemberId);
	}

	/**
	 * Deletes the team member entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TeamMemberEntry deleteTeamMemberEntry(
		TeamMemberEntry teamMemberEntry) {

		return teamMemberEntryPersistence.remove(teamMemberEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return teamMemberEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TeamMemberEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return teamMemberEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return teamMemberEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return teamMemberEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return teamMemberEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return teamMemberEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TeamMemberEntry fetchTeamMemberEntry(long teamMemberId) {
		return teamMemberEntryPersistence.fetchByPrimaryKey(teamMemberId);
	}

	/**
	 * Returns the team member entry with the matching UUID and company.
	 *
	 * @param uuid the team member entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchTeamMemberEntryByUuidAndCompanyId(
		String uuid, long companyId) {

		return teamMemberEntryPersistence.fetchByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchTeamMemberEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return teamMemberEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchTeamMemberEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public TeamMemberEntry fetchTeamMemberEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchTeamMemberEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the team member entry's external reference code
	 * @return the matching team member entry
	 * @throws PortalException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry getTeamMemberEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return teamMemberEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry with the primary key.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry
	 * @throws PortalException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry getTeamMemberEntry(long teamMemberId)
		throws PortalException {

		return teamMemberEntryPersistence.findByPrimaryKey(teamMemberId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(teamMemberEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TeamMemberEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("teamMemberId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			teamMemberEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TeamMemberEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"teamMemberId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(teamMemberEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TeamMemberEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("teamMemberId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return teamMemberEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return teamMemberEntryLocalService.deleteTeamMemberEntry(
			(TeamMemberEntry)persistedModel);
	}

	@Override
	public BasePersistence<TeamMemberEntry> getBasePersistence() {
		return teamMemberEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return teamMemberEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the team member entry with the matching UUID and company.
	 *
	 * @param uuid the team member entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching team member entry
	 * @throws PortalException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry getTeamMemberEntryByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return teamMemberEntryPersistence.findByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns a range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of team member entries
	 */
	@Override
	public List<TeamMemberEntry> getTeamMemberEntries(int start, int end) {
		return teamMemberEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	@Override
	public int getTeamMemberEntriesCount() {
		return teamMemberEntryPersistence.countAll();
	}

	/**
	 * Updates the team member entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMemberEntry the team member entry
	 * @return the team member entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TeamMemberEntry updateTeamMemberEntry(
		TeamMemberEntry teamMemberEntry) {

		return teamMemberEntryPersistence.update(teamMemberEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TeamMemberEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		teamMemberEntryLocalService = (TeamMemberEntryLocalService)aopProxy;

		_setLocalServiceUtilService(teamMemberEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TeamMemberEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TeamMemberEntry.class;
	}

	protected String getModelClassName() {
		return TeamMemberEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = teamMemberEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		TeamMemberEntryLocalService teamMemberEntryLocalService) {

		try {
			Field field =
				TeamMemberEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, teamMemberEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ResourceEntryPersistence resourceEntryPersistence;

	@Reference
	protected ResourceTypeEntryPersistence resourceTypeEntryPersistence;

	@Reference
	protected TeamEntryPersistence teamEntryPersistence;

	protected TeamMemberEntryLocalService teamMemberEntryLocalService;

	@Reference
	protected TeamMemberEntryPersistence teamMemberEntryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}