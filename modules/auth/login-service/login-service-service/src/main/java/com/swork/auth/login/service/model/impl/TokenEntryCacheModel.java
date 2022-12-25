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

package com.swork.auth.login.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.auth.login.service.model.TokenEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TokenEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TokenEntryCacheModel
	implements CacheModel<TokenEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TokenEntryCacheModel)) {
			return false;
		}

		TokenEntryCacheModel tokenEntryCacheModel =
			(TokenEntryCacheModel)object;

		if (tokenId == tokenEntryCacheModel.tokenId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tokenId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tokenId=");
		sb.append(tokenId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", refreshToken=");
		sb.append(refreshToken);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", refreshedDate=");
		sb.append(refreshedDate);
		sb.append(", userAgent=");
		sb.append(userAgent);
		sb.append(", clientIp=");
		sb.append(clientIp);
		sb.append(", firstLoginDate=");
		sb.append(firstLoginDate);
		sb.append(", sessionId=");
		sb.append(sessionId);
		sb.append(", remember=");
		sb.append(remember);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TokenEntry toEntityModel() {
		TokenEntryImpl tokenEntryImpl = new TokenEntryImpl();

		if (uuid == null) {
			tokenEntryImpl.setUuid("");
		}
		else {
			tokenEntryImpl.setUuid(uuid);
		}

		tokenEntryImpl.setTokenId(tokenId);
		tokenEntryImpl.setAccountId(accountId);
		tokenEntryImpl.setBusinessId(businessId);

		if (userName == null) {
			tokenEntryImpl.setUserName("");
		}
		else {
			tokenEntryImpl.setUserName(userName);
		}

		if (refreshToken == null) {
			tokenEntryImpl.setRefreshToken("");
		}
		else {
			tokenEntryImpl.setRefreshToken(refreshToken);
		}

		if (expiryDate == Long.MIN_VALUE) {
			tokenEntryImpl.setExpiryDate(null);
		}
		else {
			tokenEntryImpl.setExpiryDate(new Date(expiryDate));
		}

		if (issuedDate == Long.MIN_VALUE) {
			tokenEntryImpl.setIssuedDate(null);
		}
		else {
			tokenEntryImpl.setIssuedDate(new Date(issuedDate));
		}

		if (refreshedDate == Long.MIN_VALUE) {
			tokenEntryImpl.setRefreshedDate(null);
		}
		else {
			tokenEntryImpl.setRefreshedDate(new Date(refreshedDate));
		}

		if (userAgent == null) {
			tokenEntryImpl.setUserAgent("");
		}
		else {
			tokenEntryImpl.setUserAgent(userAgent);
		}

		if (clientIp == null) {
			tokenEntryImpl.setClientIp("");
		}
		else {
			tokenEntryImpl.setClientIp(clientIp);
		}

		if (firstLoginDate == Long.MIN_VALUE) {
			tokenEntryImpl.setFirstLoginDate(null);
		}
		else {
			tokenEntryImpl.setFirstLoginDate(new Date(firstLoginDate));
		}

		if (sessionId == null) {
			tokenEntryImpl.setSessionId("");
		}
		else {
			tokenEntryImpl.setSessionId(sessionId);
		}

		tokenEntryImpl.setRemember(remember);

		tokenEntryImpl.resetOriginalValues();

		return tokenEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tokenId = objectInput.readLong();

		accountId = objectInput.readLong();

		businessId = objectInput.readLong();
		userName = objectInput.readUTF();
		refreshToken = objectInput.readUTF();
		expiryDate = objectInput.readLong();
		issuedDate = objectInput.readLong();
		refreshedDate = objectInput.readLong();
		userAgent = objectInput.readUTF();
		clientIp = objectInput.readUTF();
		firstLoginDate = objectInput.readLong();
		sessionId = objectInput.readUTF();

		remember = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tokenId);

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(businessId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (refreshToken == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refreshToken);
		}

		objectOutput.writeLong(expiryDate);
		objectOutput.writeLong(issuedDate);
		objectOutput.writeLong(refreshedDate);

		if (userAgent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userAgent);
		}

		if (clientIp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientIp);
		}

		objectOutput.writeLong(firstLoginDate);

		if (sessionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sessionId);
		}

		objectOutput.writeBoolean(remember);
	}

	public String uuid;
	public long tokenId;
	public long accountId;
	public long businessId;
	public String userName;
	public String refreshToken;
	public long expiryDate;
	public long issuedDate;
	public long refreshedDate;
	public String userAgent;
	public String clientIp;
	public long firstLoginDate;
	public String sessionId;
	public boolean remember;

}