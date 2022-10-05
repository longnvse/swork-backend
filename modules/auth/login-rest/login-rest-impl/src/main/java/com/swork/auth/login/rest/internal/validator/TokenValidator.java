package com.swork.auth.login.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.service.TokenEntryLocalService;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_TokenExpiredException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(immediate = true, service = TokenValidator.class)
public class TokenValidator {

    public void validatorForLogin(String username,
                                  String password) throws SW_FieldRequiredException, SW_BadRequestException {

        isNotPopulated(username, "Vui lòng nhập tên người dùng");
        isNotPopulated(password, "Vui lòng nhập mật khẩu");

        AccountEntry entry = accountEntryLocalService.getAccount(username);

        if (Validator.isNotNull(entry) && entry.getPassword().equals(password)) {
            return;
        }

        throw new SW_BadRequestException("Vui lòng nhập lại tên người dùng hoặc mật khẩu!");
    }

    public void validatorRefreshToken(String refreshToken) throws SW_TokenExpiredException {

        TokenEntry entry = localService.getByRefreshToken(refreshToken);

        Date now = new Date();

        if (Validator.isNull(entry) ||
                entry.getExpiryDate().compareTo(now) < 0) {
            throw new SW_TokenExpiredException("Vui lòng đăng nhập lại!");
        }
    }

    public void validatorRemoveToken(String refreshToken) throws SW_TokenExpiredException {

        TokenEntry entry = localService.getByRefreshToken(refreshToken);

        if (Validator.isNull(entry)) {
            throw new SW_TokenExpiredException("Vui lòng đăng nhập lại!");
        }
    }

    private void isNotPopulated(String value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new SW_FieldRequiredException(errorMsgKey);
        }
    }

    @Reference
    private TokenEntryLocalService localService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

}
