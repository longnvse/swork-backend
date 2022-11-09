package com.swork.account.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.service.LanguageService;
import com.swork.account.rest.internal.util.LanguageKeys;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.common.exception.model.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(
        immediate = true,
        service = AccountValidator.class
)
public class AccountValidator {
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String VALID_PHONE_NUMBER_REGEX = "^\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})$";


    public void validatorForPostAccount(Account account) throws SW_DataInputException,
            SW_FieldRequiredException, SW_FieldDuplicateException {
        validatorFieldsForUpdateAccount(account);

        validatorEmailIsExist(account.getEmail());
        validatorPhoneNumberIsExist(account.getPhoneNumber());
    }

    public void validatorForPutAccount(long accountId,
                                       Account account)
            throws
            SW_DataInputException,
            SW_FieldDuplicateException,
            SW_FieldRequiredException,
            SW_NoSuchEntryException {

        validatorAccountIsExists(accountId);

        validatorFieldsForUpdateAccount(account);

        validatorEmailIsExist(
                accountId,
                account.getEmail());
        validatorPhoneNumberIsExist(
                accountId,
                account.getPhoneNumber());
    }

    public void validateForDelete(long accountId) throws SW_NoSuchEntryException, SW_BadRequestException {
        validatorAccountIsExists(accountId);

        AccountEntry entry = localService.fetchAccountEntry(accountId);
        if (Account.Status.create(entry.getStatus()).equals(Account.Status.INACTIVE)) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.ACCOUNT_ACTIVE_CANNOT_DELETE));
    }

    private void validatorFieldsForUpdateAccount(
            Account account)
            throws SW_FieldRequiredException, SW_DataInputException {

        validateRequireField(account);

        validatorRegexField(account.getEmail(),
                VALID_EMAIL_ADDRESS_REGEX,
                languageService.getMessage(LanguageKeys.EMAIL_INVALID));

        if (Validator.isNotNull(account.getPhoneNumber())) {
            validatorRegexField(account.getPhoneNumber(),
                    VALID_PHONE_NUMBER_REGEX,
                    languageService.getMessage(LanguageKeys.PHONE_INVALID));
        }
    }

    private void validateRequireField(Account account) throws SW_FieldRequiredException {
        isNotPopulated(
                account.getEmail(), languageService.getMessage(LanguageKeys.EMAIL_REQUIRED));
    }

    public void validatorAccountIsExists(long accountId) throws SW_NoSuchEntryException {

        AccountEntry accountEntry = localService.fetchAccountEntry(accountId);

        if (accountEntry != null) return;

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.ACCOUNT_NOT_FOUND));
    }

    private void validatorEmailIsExist(long customerId,
                                       String value) throws SW_FieldDuplicateException {
        AccountEntry entry = localService.fetchAccountEntry(customerId);

        if (entry.getEmail().equals(value)) return;

        validatorEmailIsExist(value);
    }

    private void validatorPhoneNumberIsExist(long accountId,
                                             String value) throws SW_FieldDuplicateException {
        if (Validator.isNull(value)) {
            return;
        }

        AccountEntry entry = localService.fetchAccountEntry(accountId);
        if (entry.getPhoneNumber().equals(value)) return;

        validatorPhoneNumberIsExist(value);
    }

    private void validatorEmailIsExist(String value) throws SW_FieldDuplicateException {
        AccountEntry accountEntry = localService.findByEmail(value);

        if (Validator.isNull(accountEntry)) return;
        throw new SW_FieldDuplicateException(languageService.getMessage(LanguageKeys.EMAIL_WAS_USED));
    }

    private void validatorPhoneNumberIsExist(String value) throws SW_FieldDuplicateException {
        if (Validator.isNull(value)) {
            return;
        }

        AccountEntry accountEntry = localService.findByPhone(value);

        if (Validator.isNull(accountEntry)) return;
        throw new SW_FieldDuplicateException(languageService.getMessage(LanguageKeys.PHONE_WAS_USED));
    }

    private void validatorRegexField(String value,
                                     String pattern,
                                     String errorMsg) throws SW_DataInputException {
        Pattern pt = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pt.matcher(value);

        if (matcher.find()) return;

        throw new SW_DataInputException(errorMsg);
    }

    private void isNotPopulated(String value,
                                String errorMsg) throws SW_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new SW_FieldRequiredException(errorMsg);
        }
    }

    @Reference
    LanguageService languageService;
    @Reference
    AccountEntryLocalService localService;

}
