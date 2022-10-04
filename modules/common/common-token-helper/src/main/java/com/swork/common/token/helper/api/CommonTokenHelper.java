package com.swork.common.token.helper.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.common.token.model.AccountTokenModel;
import com.swork.common.token.model.UserTokenModel;
import com.swork.common.token.service.JwtService;
import com.swork.common.token.util.ClaimsKeys;
import com.swork.common.token.util.TokenKeys;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * @author longnv
 */

@Component(immediate = true, service = CommonTokenHelper.class)
public class CommonTokenHelper {

    public UserTokenModel getUserToken(HttpServletRequest httpServletRequest) {
        String userContext = httpServletRequest.getHeader(TokenKeys.USER_CONTEXT);

        Claims claims = jwtService.decodeJWToken(userContext);

        UserTokenModel userToken = new UserTokenModel();

        userToken.setEmail(GetterUtil.getString(claims.get(ClaimsKeys.EMAIL)));
        userToken.setUsername(GetterUtil.getString(claims.get(ClaimsKeys.USERNAME)));
        userToken.setFullName(GetterUtil.getString(claims.get(ClaimsKeys.FULL_NAME)));
        userToken.setAccount(getAccountTokenModel(claims));
        userToken.setAccountId(GetterUtil.getLong(claims.get(ClaimsKeys.ACCOUNT_ID)));

        return userToken;
    }

    private AccountTokenModel getAccountTokenModel(Claims claims) {
        LinkedHashMap<String, Object> accountHash =
                (LinkedHashMap<String, Object>) claims.get(ClaimsKeys.ACCOUNT);

        ObjectMapper oMapper = new ObjectMapper();

        AccountTokenModel accountTokenModel = oMapper.convertValue(accountHash, AccountTokenModel.class);

        return accountTokenModel;
    }

    @Reference
    private JwtService jwtService;
}