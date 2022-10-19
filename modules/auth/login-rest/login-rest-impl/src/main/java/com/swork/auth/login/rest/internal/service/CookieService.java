package com.swork.auth.login.rest.internal.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.service.TokenEntryLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Component(immediate = true, service = CookieService.class)
public class CookieService {

    private static final String COOKIE_NAME = "REFRESH_TOKEN";

    public void addRefreshTokenCookie(String refreshToken, HttpServletResponse response) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.ISO_8601_PATTERN);
        TokenEntry tokenEntry = TokenEntryLocalServiceUtil.getByRefreshToken(refreshToken);

        String cookieString = stringNameValue(COOKIE_NAME, refreshToken) +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("Max-Age", "2592000") +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("Path", StringPool.SLASH) +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                "HttpOnly" +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("SameSite", "none");

        response.setHeader("Set-Cookie", cookieString);
    }

    private String stringNameValue(String name, String value) {
        return name + StringPool.EQUAL + value;
    }

    public String getRefreshTokenByCookies(HttpServletRequest request) {
        return Arrays
                .stream(request.getCookies())
                .filter(cookie ->
                        cookie.getName().equals(COOKIE_NAME)
                                && Validator.isNotNull(cookie.getValue())
                                && !Validator.isBlank(cookie.getValue()))
                .findFirst()
                .orElse(new Cookie(COOKIE_NAME, StringPool.BLANK)).getValue();
    }

    public void deleteRefreshTokenCookie(HttpServletResponse response) {
        String cookieString = stringNameValue(COOKIE_NAME, StringPool.BLANK) +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("Max-Age", "0") +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("Path", StringPool.SLASH) +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                "HttpOnly" +
                StringPool.SEMICOLON +
                StringPool.SPACE +
                stringNameValue("SameSite", "none");

        response.setHeader("Set-Cookie", cookieString);
    }
}
