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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TokenEntrySoap implements Serializable {

	public static TokenEntrySoap toSoapModel(TokenEntry model) {
		TokenEntrySoap soapModel = new TokenEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTokenId(model.getTokenId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setUserName(model.getUserName());
		soapModel.setRefreshToken(model.getRefreshToken());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setRefreshedDate(model.getRefreshedDate());
		soapModel.setUserAgent(model.getUserAgent());
		soapModel.setClientIp(model.getClientIp());
		soapModel.setFirstLoginDate(model.getFirstLoginDate());
		soapModel.setSessionId(model.getSessionId());
		soapModel.setRemember(model.getRemember());

		return soapModel;
	}

	public static TokenEntrySoap[] toSoapModels(TokenEntry[] models) {
		TokenEntrySoap[] soapModels = new TokenEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TokenEntrySoap[][] toSoapModels(TokenEntry[][] models) {
		TokenEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TokenEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TokenEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TokenEntrySoap[] toSoapModels(List<TokenEntry> models) {
		List<TokenEntrySoap> soapModels = new ArrayList<TokenEntrySoap>(
			models.size());

		for (TokenEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TokenEntrySoap[soapModels.size()]);
	}

	public TokenEntrySoap() {
	}

	public long getPrimaryKey() {
		return _tokenId;
	}

	public void setPrimaryKey(long pk) {
		setTokenId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTokenId() {
		return _tokenId;
	}

	public void setTokenId(long tokenId) {
		_tokenId = tokenId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getRefreshToken() {
		return _refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		_refreshToken = refreshToken;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public Date getRefreshedDate() {
		return _refreshedDate;
	}

	public void setRefreshedDate(Date refreshedDate) {
		_refreshedDate = refreshedDate;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public String getClientIp() {
		return _clientIp;
	}

	public void setClientIp(String clientIp) {
		_clientIp = clientIp;
	}

	public Date getFirstLoginDate() {
		return _firstLoginDate;
	}

	public void setFirstLoginDate(Date firstLoginDate) {
		_firstLoginDate = firstLoginDate;
	}

	public String getSessionId() {
		return _sessionId;
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public Boolean getRemember() {
		return _remember;
	}

	public void setRemember(Boolean remember) {
		_remember = remember;
	}

	private String _uuid;
	private long _tokenId;
	private long _accountId;
	private long _businessId;
	private String _userName;
	private String _refreshToken;
	private Date _expiryDate;
	private Date _issuedDate;
	private Date _refreshedDate;
	private String _userAgent;
	private String _clientIp;
	private Date _firstLoginDate;
	private String _sessionId;
	private Boolean _remember;

}