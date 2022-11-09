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

package com.swork.core.project.service.service.base;

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

import com.swork.core.project.service.model.ProjectMemberEntry;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import com.swork.core.project.service.service.ProjectMemberEntryLocalServiceUtil;
import com.swork.core.project.service.service.persistence.ProjectEntryPersistence;
import com.swork.core.project.service.service.persistence.ProjectMemberEntryPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the project member entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.swork.core.project.service.service.impl.ProjectMemberEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.swork.core.project.service.service.impl.ProjectMemberEntryLocalServiceImpl
 * @generated
 */
public abstract class ProjectMemberEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProjectMemberEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProjectMemberEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ProjectMemberEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the project member entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProjectMemberEntry addProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		projectMemberEntry.setNew(true);

		return projectMemberEntryPersistence.update(projectMemberEntry);
	}

	/**
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	@Override
	@Transactional(enabled = false)
	public ProjectMemberEntry createProjectMemberEntry(long projectMemberId) {
		return projectMemberEntryPersistence.create(projectMemberId);
	}

	/**
	 * Deletes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws PortalException if a project member entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProjectMemberEntry deleteProjectMemberEntry(long projectMemberId)
		throws PortalException {

		return projectMemberEntryPersistence.remove(projectMemberId);
	}

	/**
	 * Deletes the project member entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProjectMemberEntry deleteProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		return projectMemberEntryPersistence.remove(projectMemberEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return projectMemberEntryPersistence.dslQuery(dslQuery);
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
			ProjectMemberEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return projectMemberEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
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

		return projectMemberEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
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

		return projectMemberEntryPersistence.findWithDynamicQuery(
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
		return projectMemberEntryPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return projectMemberEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProjectMemberEntry fetchProjectMemberEntry(long projectMemberId) {
		return projectMemberEntryPersistence.fetchByPrimaryKey(projectMemberId);
	}

	/**
	 * Returns the project member entry with the primary key.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws PortalException if a project member entry with the primary key could not be found
	 */
	@Override
	public ProjectMemberEntry getProjectMemberEntry(long projectMemberId)
		throws PortalException {

		return projectMemberEntryPersistence.findByPrimaryKey(projectMemberId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			projectMemberEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProjectMemberEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("projectMemberId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			projectMemberEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ProjectMemberEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"projectMemberId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			projectMemberEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProjectMemberEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("projectMemberId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return projectMemberEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return projectMemberEntryLocalService.deleteProjectMemberEntry(
			(ProjectMemberEntry)persistedModel);
	}

	@Override
	public BasePersistence<ProjectMemberEntry> getBasePersistence() {
		return projectMemberEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return projectMemberEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of project member entries
	 */
	@Override
	public List<ProjectMemberEntry> getProjectMemberEntries(
		int start, int end) {

		return projectMemberEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	@Override
	public int getProjectMemberEntriesCount() {
		return projectMemberEntryPersistence.countAll();
	}

	/**
	 * Updates the project member entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectMemberEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMemberEntry the project member entry
	 * @return the project member entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProjectMemberEntry updateProjectMemberEntry(
		ProjectMemberEntry projectMemberEntry) {

		return projectMemberEntryPersistence.update(projectMemberEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProjectMemberEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		projectMemberEntryLocalService =
			(ProjectMemberEntryLocalService)aopProxy;

		_setLocalServiceUtilService(projectMemberEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProjectMemberEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProjectMemberEntry.class;
	}

	protected String getModelClassName() {
		return ProjectMemberEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				projectMemberEntryPersistence.getDataSource();

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
		ProjectMemberEntryLocalService projectMemberEntryLocalService) {

		try {
			Field field =
				ProjectMemberEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, projectMemberEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ProjectEntryPersistence projectEntryPersistence;

	protected ProjectMemberEntryLocalService projectMemberEntryLocalService;

	@Reference
	protected ProjectMemberEntryPersistence projectMemberEntryPersistence;

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