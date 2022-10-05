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

package com.swork.auth.login.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TokenEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenEntryLocalService
 * @generated
 */
public class TokenEntryLocalServiceWrapper
	implements ServiceWrapper<TokenEntryLocalService>, TokenEntryLocalService {

	public TokenEntryLocalServiceWrapper(
		TokenEntryLocalService tokenEntryLocalService) {

		_tokenEntryLocalService = tokenEntryLocalService;
	}

	@Override
	public com.swork.auth.login.service.model.TokenEntry addTokenEntry(
		long accountId, String username, java.util.Date expiryDate,
		String userAgent, String clientId, Boolean remember) {

		return _tokenEntryLocalService.addTokenEntry(
			accountId, username, expiryDate, userAgent, clientId, remember);
	}

	/**
	 * Adds the token entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tokenEntry the token entry
	 * @return the token entry that was added
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry addTokenEntry(
		com.swork.auth.login.service.model.TokenEntry tokenEntry) {

		return _tokenEntryLocalService.addTokenEntry(tokenEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tokenEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new token entry with the primary key. Does not add the token entry to the database.
	 *
	 * @param tokenId the primary key for the new token entry
	 * @return the new token entry
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry createTokenEntry(
		long tokenId) {

		return _tokenEntryLocalService.createTokenEntry(tokenId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tokenEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry that was removed
	 * @throws PortalException if a token entry with the primary key could not be found
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry deleteTokenEntry(
			long tokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tokenEntryLocalService.deleteTokenEntry(tokenId);
	}

	/**
	 * Deletes the token entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tokenEntry the token entry
	 * @return the token entry that was removed
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry deleteTokenEntry(
		com.swork.auth.login.service.model.TokenEntry tokenEntry) {

		return _tokenEntryLocalService.deleteTokenEntry(tokenEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tokenEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tokenEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tokenEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tokenEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.login.service.model.impl.TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tokenEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.login.service.model.impl.TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tokenEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tokenEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tokenEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.auth.login.service.model.TokenEntry fetchTokenEntry(
		long tokenId) {

		return _tokenEntryLocalService.fetchTokenEntry(tokenId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tokenEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.swork.auth.login.service.model.TokenEntry getByRefreshToken(
		String refreshToken) {

		return _tokenEntryLocalService.getByRefreshToken(refreshToken);
	}

	@Override
	public com.swork.auth.login.service.model.TokenEntry getByUsername(
		String username) {

		return _tokenEntryLocalService.getByUsername(username);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tokenEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tokenEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tokenEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.login.service.model.impl.TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @return the range of token entries
	 */
	@Override
	public java.util.List<com.swork.auth.login.service.model.TokenEntry>
		getTokenEntries(int start, int end) {

		return _tokenEntryLocalService.getTokenEntries(start, end);
	}

	/**
	 * Returns the number of token entries.
	 *
	 * @return the number of token entries
	 */
	@Override
	public int getTokenEntriesCount() {
		return _tokenEntryLocalService.getTokenEntriesCount();
	}

	/**
	 * Returns the token entry with the primary key.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry
	 * @throws PortalException if a token entry with the primary key could not be found
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry getTokenEntry(
			long tokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tokenEntryLocalService.getTokenEntry(tokenId);
	}

	@Override
	public com.swork.auth.login.service.model.TokenEntry updateExpiryDate(
		String refreshToken, java.util.Date expiryDate) {

		return _tokenEntryLocalService.updateExpiryDate(
			refreshToken, expiryDate);
	}

	/**
	 * Updates the token entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tokenEntry the token entry
	 * @return the token entry that was updated
	 */
	@Override
	public com.swork.auth.login.service.model.TokenEntry updateTokenEntry(
		com.swork.auth.login.service.model.TokenEntry tokenEntry) {

		return _tokenEntryLocalService.updateTokenEntry(tokenEntry);
	}

	@Override
	public TokenEntryLocalService getWrappedService() {
		return _tokenEntryLocalService;
	}

	@Override
	public void setWrappedService(
		TokenEntryLocalService tokenEntryLocalService) {

		_tokenEntryLocalService = tokenEntryLocalService;
	}

	private TokenEntryLocalService _tokenEntryLocalService;

}