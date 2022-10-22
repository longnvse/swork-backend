package com.swork.auth.login.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.auth.login.rest.dto.v1_0.Credential;
import com.swork.auth.login.rest.dto.v1_0.CredentialRefresh;
import com.swork.auth.login.rest.internal.service.CookieService;
import com.swork.auth.login.rest.internal.service.TokenService;
import com.swork.auth.login.rest.internal.validator.TokenValidator;
import com.swork.auth.login.rest.resource.v1_0.LoginResource;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_TokenExpiredException;
import com.swork.common.exception.model.SW_UnAuthorizationException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/login.properties",
        scope = ServiceScope.PROTOTYPE, service = LoginResource.class
)
public class LoginResourceImpl extends BaseLoginResourceImpl {
    public static final String USER_AGENT = "User-Agent";

    @Override
    public Credential postCredential(Credential credential) throws SW_UnAuthorizationException, SW_FieldRequiredException {
        validator.validatorForLogin(
                credential.getUsername(),
                credential.getPassword());

        Credential response = _tokenService.getToken(
                credential.getUsername(),
                credential.getRememberMe(),
                contextHttpServletRequest.getHeader(USER_AGENT),
                contextHttpServletRequest.getRemoteAddr());

        _cookieService.addRefreshTokenCookie(response.getRefreshToken(), contextHttpServletResponse);

        return response;
    }

    @Override
    public CredentialRefresh postCredentialRefresh() throws SW_TokenExpiredException {
        String refreshToken = _cookieService.getRefreshTokenByCookies(contextHttpServletRequest);

        validator.validatorRefreshToken(refreshToken);

        CredentialRefresh response = _tokenService.refreshToken(refreshToken);

        _cookieService.addRefreshTokenCookie(response.getRefreshToken(), contextHttpServletResponse);

        return response;
    }

    @Override
    public void postCredentialLogout() throws SW_TokenExpiredException {
        String refreshToken = _cookieService.getRefreshTokenByCookies(contextHttpServletRequest);

        _cookieService.deleteRefreshTokenCookie(contextHttpServletResponse);

        validator.validatorRemoveToken(refreshToken);

        _tokenService.removeToken(refreshToken);
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }


    @Reference
    private TokenValidator validator;
    @Reference
    private TokenService _tokenService;

    @Reference
    private CookieService _cookieService;
}