package com.swork.auth.login.rest.internal.service;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.login.rest.dto.v1_0.Credential;
import com.swork.auth.login.rest.dto.v1_0.CredentialRefresh;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.service.TokenEntryLocalService;
import com.swork.common.token.service.JwtService;
import com.swork.common.token.util.TokenKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component(immediate = true, service = TokenService.class)
public class TokenService {

    public Credential getToken(String userName,
                               Boolean rememberMe,
                               String userAgent,
                               String clientIp) {

        Credential credential = new Credential();

        AccountEntry account = accountEntryLocalService.getAccount(userName);

        String token = jwtService.getJWToken(
                account.getAccountId(),
                userName);

        Date expirationDate =
                getExpirationDate(
                        getRefreshTokenExpiredDateByRememberMe(GetterUtil.getBoolean(rememberMe)));

        TokenEntry entry = tokenLocalService
                .addTokenEntry(
                        account.getAccountId(),
                        userName,
                        expirationDate,
                        userAgent,
                        clientIp,
                        rememberMe);

        credential.setAccessToken(token);
        credential.setTokenType(TokenKeys.TOKEN_TYPE);
        credential.setRefreshToken(entry.getRefreshToken());

        return credential;
    }

    public CredentialRefresh refreshToken(String refreshToken) {

        CredentialRefresh credential = new CredentialRefresh();

        TokenEntry tokenEntry =
                tokenLocalService.getByRefreshToken(refreshToken);

        String token =
                jwtService.getJWToken(
                        tokenEntry.getAccountId(),
                        tokenEntry.getUserName());

        Date expirationDate =
                getExpirationDate(
                        getRefreshTokenExpiredDateByRememberMe(tokenEntry.getRemember()));

        tokenLocalService.updateExpiryDate(refreshToken, expirationDate);

        credential.setAccessToken(token);
        credential.setTokenType(TokenKeys.TOKEN_TYPE);
        credential.setRefreshToken(refreshToken);

        return credential;
    }

    public void removeToken(String refreshToken) {

        TokenEntry entry = tokenLocalService.getByRefreshToken(refreshToken);

        tokenLocalService.deleteTokenEntry(entry);
    }

    private Date getExpirationDate(long expirationTimeMs) {
        LocalDateTime localDateTime = LocalDateTime.now().plus(expirationTimeMs, ChronoUnit.MILLIS);
        return DateUtil.newDate(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    private long getRefreshTokenExpiredDateByRememberMe(Boolean rememberMe) {
        if (!rememberMe) {
            return GetterUtil.getLong(
                    jwtService.getAuthPropertiesPath(TokenKeys.EXPIRATION_REFRESH_TIME));
        }

        return GetterUtil.getLong(
                jwtService.getAuthPropertiesPath(TokenKeys.REMEMBER_EXPIRATION_REFRESH_TIME));
    }

    @Reference
    private JwtService jwtService;

    @Reference
    private TokenEntryLocalService tokenLocalService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
