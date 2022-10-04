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

package com.swork.auth.login.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TokenEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenEntry
 * @generated
 */
public class TokenEntryWrapper
	extends BaseModelWrapper<TokenEntry>
	implements ModelWrapper<TokenEntry>, TokenEntry {

	public TokenEntryWrapper(TokenEntry tokenEntry) {
		super(tokenEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tokenId", getTokenId());
		attributes.put("accountId", getAccountId());
		attributes.put("businessId", getBusinessId());
		attributes.put("userName", getUserName());
		attributes.put("refreshToken", getRefreshToken());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("refreshedDate", getRefreshedDate());
		attributes.put("userAgent", getUserAgent());
		attributes.put("clientIp", getClientIp());
		attributes.put("firstLoginDate", getFirstLoginDate());
		attributes.put("sessionId", getSessionId());
		attributes.put("remember", getRemember());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tokenId = (Long)attributes.get("tokenId");

		if (tokenId != null) {
			setTokenId(tokenId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String refreshToken = (String)attributes.get("refreshToken");

		if (refreshToken != null) {
			setRefreshToken(refreshToken);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		Date refreshedDate = (Date)attributes.get("refreshedDate");

		if (refreshedDate != null) {
			setRefreshedDate(refreshedDate);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String clientIp = (String)attributes.get("clientIp");

		if (clientIp != null) {
			setClientIp(clientIp);
		}

		Date firstLoginDate = (Date)attributes.get("firstLoginDate");

		if (firstLoginDate != null) {
			setFirstLoginDate(firstLoginDate);
		}

		String sessionId = (String)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		Boolean remember = (Boolean)attributes.get("remember");

		if (remember != null) {
			setRemember(remember);
		}
	}

	@Override
	public TokenEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this token entry.
	 *
	 * @return the account ID of this token entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this token entry.
	 *
	 * @return the business ID of this token entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the client ip of this token entry.
	 *
	 * @return the client ip of this token entry
	 */
	@Override
	public String getClientIp() {
		return model.getClientIp();
	}

	/**
	 * Returns the expiry date of this token entry.
	 *
	 * @return the expiry date of this token entry
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the first login date of this token entry.
	 *
	 * @return the first login date of this token entry
	 */
	@Override
	public Date getFirstLoginDate() {
		return model.getFirstLoginDate();
	}

	/**
	 * Returns the issued date of this token entry.
	 *
	 * @return the issued date of this token entry
	 */
	@Override
	public Date getIssuedDate() {
		return model.getIssuedDate();
	}

	/**
	 * Returns the primary key of this token entry.
	 *
	 * @return the primary key of this token entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the refreshed date of this token entry.
	 *
	 * @return the refreshed date of this token entry
	 */
	@Override
	public Date getRefreshedDate() {
		return model.getRefreshedDate();
	}

	/**
	 * Returns the refresh token of this token entry.
	 *
	 * @return the refresh token of this token entry
	 */
	@Override
	public String getRefreshToken() {
		return model.getRefreshToken();
	}

	/**
	 * Returns the remember of this token entry.
	 *
	 * @return the remember of this token entry
	 */
	@Override
	public Boolean getRemember() {
		return model.getRemember();
	}

	/**
	 * Returns the session ID of this token entry.
	 *
	 * @return the session ID of this token entry
	 */
	@Override
	public String getSessionId() {
		return model.getSessionId();
	}

	/**
	 * Returns the token ID of this token entry.
	 *
	 * @return the token ID of this token entry
	 */
	@Override
	public long getTokenId() {
		return model.getTokenId();
	}

	/**
	 * Returns the user agent of this token entry.
	 *
	 * @return the user agent of this token entry
	 */
	@Override
	public String getUserAgent() {
		return model.getUserAgent();
	}

	/**
	 * Returns the user name of this token entry.
	 *
	 * @return the user name of this token entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this token entry.
	 *
	 * @return the uuid of this token entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this token entry.
	 *
	 * @param accountId the account ID of this token entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this token entry.
	 *
	 * @param businessId the business ID of this token entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the client ip of this token entry.
	 *
	 * @param clientIp the client ip of this token entry
	 */
	@Override
	public void setClientIp(String clientIp) {
		model.setClientIp(clientIp);
	}

	/**
	 * Sets the expiry date of this token entry.
	 *
	 * @param expiryDate the expiry date of this token entry
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the first login date of this token entry.
	 *
	 * @param firstLoginDate the first login date of this token entry
	 */
	@Override
	public void setFirstLoginDate(Date firstLoginDate) {
		model.setFirstLoginDate(firstLoginDate);
	}

	/**
	 * Sets the issued date of this token entry.
	 *
	 * @param issuedDate the issued date of this token entry
	 */
	@Override
	public void setIssuedDate(Date issuedDate) {
		model.setIssuedDate(issuedDate);
	}

	/**
	 * Sets the primary key of this token entry.
	 *
	 * @param primaryKey the primary key of this token entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the refreshed date of this token entry.
	 *
	 * @param refreshedDate the refreshed date of this token entry
	 */
	@Override
	public void setRefreshedDate(Date refreshedDate) {
		model.setRefreshedDate(refreshedDate);
	}

	/**
	 * Sets the refresh token of this token entry.
	 *
	 * @param refreshToken the refresh token of this token entry
	 */
	@Override
	public void setRefreshToken(String refreshToken) {
		model.setRefreshToken(refreshToken);
	}

	/**
	 * Sets the remember of this token entry.
	 *
	 * @param remember the remember of this token entry
	 */
	@Override
	public void setRemember(Boolean remember) {
		model.setRemember(remember);
	}

	/**
	 * Sets the session ID of this token entry.
	 *
	 * @param sessionId the session ID of this token entry
	 */
	@Override
	public void setSessionId(String sessionId) {
		model.setSessionId(sessionId);
	}

	/**
	 * Sets the token ID of this token entry.
	 *
	 * @param tokenId the token ID of this token entry
	 */
	@Override
	public void setTokenId(long tokenId) {
		model.setTokenId(tokenId);
	}

	/**
	 * Sets the user agent of this token entry.
	 *
	 * @param userAgent the user agent of this token entry
	 */
	@Override
	public void setUserAgent(String userAgent) {
		model.setUserAgent(userAgent);
	}

	/**
	 * Sets the user name of this token entry.
	 *
	 * @param userName the user name of this token entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this token entry.
	 *
	 * @param uuid the uuid of this token entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TokenEntryWrapper wrap(TokenEntry tokenEntry) {
		return new TokenEntryWrapper(tokenEntry);
	}

}