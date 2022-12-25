package com.swork.auth.login.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.login.rest.internal.service.LanguageService;
import com.swork.auth.login.rest.internal.util.LanguageKeys;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.service.TokenEntryLocalService;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_TokenExpiredException;
import com.swork.common.exception.model.SW_UnAuthorizationException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(immediate = true, service = TokenValidator.class)
public class TokenValidator {

    public void validatorForLogin(String username,
                                  String password) throws SW_FieldRequiredException, SW_UnAuthorizationException {

        isNotPopulated(username, LanguageKeys.USERNAME_REQUIRED);
        isNotPopulated(password, LanguageKeys.PASSWORD_REQUIRED);

        validateForPassword(username, password);
        validateForStatus(username);
    }

    private void validateForPassword(String username,
                                     String password) throws SW_UnAuthorizationException {
        AccountEntry entry = accountEntryLocalService.getAccount(username);

        if (Validator.isNotNull(entry) && entry.getPassword().equals(password)) {
            return;
        }

        throw new SW_UnAuthorizationException(languageService.getMessage(LanguageKeys.LOGIN_FAILED));
    }

    private void validateForStatus(String username) throws SW_UnAuthorizationException {
        AccountEntry entry = accountEntryLocalService.getAccount(username);

        if (Account.Status.ACTIVE.getValue().equals(entry.getStatus())) {
            return;
        }

        throw new SW_UnAuthorizationException(languageService.getMessage(LanguageKeys.ACCOUNT_INACTIVE));
    }

    public void validatorRefreshToken(String refreshToken) throws SW_TokenExpiredException {

        TokenEntry entry = localService.getByRefreshToken(refreshToken);

        Date now = new Date();

        if (Validator.isNull(entry) ||
                entry.getExpiryDate().compareTo(now) < 0) {
            throw new SW_TokenExpiredException(languageService.getMessage(LanguageKeys.LOGIN_AGAIN));
        }
    }

    public void validatorRemoveToken(String refreshToken) throws SW_TokenExpiredException {

        TokenEntry entry = localService.getByRefreshToken(refreshToken);

        if (Validator.isNull(entry)) {
            throw new SW_TokenExpiredException(languageService.getMessage(LanguageKeys.LOGIN_AGAIN));
        }
    }

    private void isNotPopulated(String value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    @Reference
    private TokenEntryLocalService localService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private LanguageService languageService;

}
