/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.swork.auth.login.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.service.base.TokenEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.auth.login.service.model.TokenEntry",
        service = AopService.class
)
public class TokenEntryLocalServiceImpl extends TokenEntryLocalServiceBaseImpl {
    public TokenEntry addTokenEntry(long accountId,
                                    String username,
                                    Date expiryDate,
                                    String userAgent,
                                    String clientId,
                                    Boolean remember) {
        TokenEntry entry =
                createTokenEntry(counterLocalService.increment(TokenEntry.class.getName()));

        setDataTokenEntry(entry, username, expiryDate, userAgent, clientId, remember);

        entry.setAccountId(accountId);

        return addTokenEntry(entry);
    }

    private void setDataTokenEntry(TokenEntry entry,
                                   String username,
                                   Date expiryDate,
                                   String userAgent,
                                   String clientId,
                                   Boolean remember) {

        Date currentDate = new Date();

        entry.setUserName(username);
        entry.setRefreshToken(UUID.randomUUID().toString());
        entry.setExpiryDate(expiryDate);
        entry.setIssuedDate(currentDate);
        entry.setFirstLoginDate(currentDate);
        entry.setUserAgent(userAgent);
        entry.setClientIp(clientId);
        entry.setSessionId(UUID.randomUUID().toString());
        entry.setRemember(remember);
    }


    public TokenEntry updateExpiryDate(String refreshToken,
                                       Date expiryDate) {

        TokenEntry entry = tokenEntryPersistence.fetchByR_T(refreshToken);

        entry.setExpiryDate(expiryDate);

        return updateTokenEntry(entry);
    }

    public TokenEntry getByRefreshToken(String refreshToken) {
        return tokenEntryPersistence.fetchByR_T(refreshToken);
    }

    public TokenEntry getByUsername(String username) {
        return tokenEntryPersistence.fetchByU_N(username);
    }
}