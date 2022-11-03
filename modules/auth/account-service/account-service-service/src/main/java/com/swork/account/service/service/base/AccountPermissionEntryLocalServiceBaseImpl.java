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

package com.swork.account.service.service.base;

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

import com.swork.account.service.model.AccountPermissionEntry;
import com.swork.account.service.service.AccountPermissionEntryLocalService;
import com.swork.account.service.service.AccountPermissionEntryLocalServiceUtil;
import com.swork.account.service.service.persistence.AccountEntryPersistence;
import com.swork.account.service.service.persistence.AccountPermissionEntryPersistence;
import com.swork.account.service.service.persistence.PermissionDetailEntryPersistence;
import com.swork.account.service.service.persistence.PermissionEntryPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the account permission entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.swork.account.service.service.impl.AccountPermissionEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.swork.account.service.service.impl.AccountPermissionEntryLocalServiceImpl
 * @generated
 */
public abstract class AccountPermissionEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AccountPermissionEntryLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AccountPermissionEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AccountPermissionEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the account permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AccountPermissionEntry addAccountPermissionEntry(
		AccountPermissionEntry accountPermissionEntry) {

		accountPermissionEntry.setNew(true);

		return accountPermissionEntryPersistence.update(accountPermissionEntry);
	}

	/**
	 * Creates a new account permission entry with the primary key. Does not add the account permission entry to the database.
	 *
	 * @param id the primary key for the new account permission entry
	 * @return the new account permission entry
	 */
	@Override
	@Transactional(enabled = false)
	public AccountPermissionEntry createAccountPermissionEntry(long id) {
		return accountPermissionEntryPersistence.create(id);
	}

	/**
	 * Deletes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws PortalException if a account permission entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AccountPermissionEntry deleteAccountPermissionEntry(long id)
		throws PortalException {

		return accountPermissionEntryPersistence.remove(id);
	}

	/**
	 * Deletes the account permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AccountPermissionEntry deleteAccountPermissionEntry(
		AccountPermissionEntry accountPermissionEntry) {

		return accountPermissionEntryPersistence.remove(accountPermissionEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return accountPermissionEntryPersistence.dslQuery(dslQuery);
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
			AccountPermissionEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return accountPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
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

		return accountPermissionEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
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

		return accountPermissionEntryPersistence.findWithDynamicQuery(
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
		return accountPermissionEntryPersistence.countWithDynamicQuery(
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

		return accountPermissionEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AccountPermissionEntry fetchAccountPermissionEntry(long id) {
		return accountPermissionEntryPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the account permission entry with the matching UUID and company.
	 *
	 * @param uuid the account permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchAccountPermissionEntryByUuidAndCompanyId(
		String uuid, long companyId) {

		return accountPermissionEntryPersistence.fetchByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns the account permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permission entry's external reference code
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry
		fetchAccountPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return accountPermissionEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchAccountPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public AccountPermissionEntry fetchAccountPermissionEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchAccountPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the account permission entry's external reference code
	 * @return the matching account permission entry
	 * @throws PortalException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry
			getAccountPermissionEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException {

		return accountPermissionEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the account permission entry with the primary key.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws PortalException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry getAccountPermissionEntry(long id)
		throws PortalException {

		return accountPermissionEntryPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			accountPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AccountPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			accountPermissionEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			AccountPermissionEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			accountPermissionEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AccountPermissionEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return accountPermissionEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return accountPermissionEntryLocalService.deleteAccountPermissionEntry(
			(AccountPermissionEntry)persistedModel);
	}

	@Override
	public BasePersistence<AccountPermissionEntry> getBasePersistence() {
		return accountPermissionEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return accountPermissionEntryPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns the account permission entry with the matching UUID and company.
	 *
	 * @param uuid the account permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching account permission entry
	 * @throws PortalException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry getAccountPermissionEntryByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return accountPermissionEntryPersistence.findByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns a range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> getAccountPermissionEntries(
		int start, int end) {

		return accountPermissionEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of account permission entries.
	 *
	 * @return the number of account permission entries
	 */
	@Override
	public int getAccountPermissionEntriesCount() {
		return accountPermissionEntryPersistence.countAll();
	}

	/**
	 * Updates the account permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountPermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountPermissionEntry the account permission entry
	 * @return the account permission entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AccountPermissionEntry updateAccountPermissionEntry(
		AccountPermissionEntry accountPermissionEntry) {

		return accountPermissionEntryPersistence.update(accountPermissionEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AccountPermissionEntryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		accountPermissionEntryLocalService =
			(AccountPermissionEntryLocalService)aopProxy;

		_setLocalServiceUtilService(accountPermissionEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AccountPermissionEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AccountPermissionEntry.class;
	}

	protected String getModelClassName() {
		return AccountPermissionEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				accountPermissionEntryPersistence.getDataSource();

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
		AccountPermissionEntryLocalService accountPermissionEntryLocalService) {

		try {
			Field field =
				AccountPermissionEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, accountPermissionEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AccountEntryPersistence accountEntryPersistence;

	protected AccountPermissionEntryLocalService
		accountPermissionEntryLocalService;

	@Reference
	protected AccountPermissionEntryPersistence
		accountPermissionEntryPersistence;

	@Reference
	protected PermissionDetailEntryPersistence permissionDetailEntryPersistence;

	@Reference
	protected PermissionEntryPersistence permissionEntryPersistence;

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