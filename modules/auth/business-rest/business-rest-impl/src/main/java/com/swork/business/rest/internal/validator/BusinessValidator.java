package com.swork.business.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.service.LanguageService;
import com.swork.business.rest.internal.util.LanguageKeys;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.service.BusinessEntryLocalService;
import com.swork.common.exception.model.SW_DataInputException;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(
        immediate = true,
        service = {BusinessValidator.class}
)
public class BusinessValidator {

    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String VALID_PHONE_NUMBER_REGEX = "^\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})$";


    public void validatorForPostBusiness(Business business) throws SW_DataInputException,
            SW_FieldRequiredException, SW_FieldDuplicateException {
        validatorFieldsForUpdateBusiness(business);

        validatorEmailIsExist(business.getEmail());
        validatorPhoneNumberIsExist(business.getPhoneNumber());
    }

    public void validatorForPutBusiness(long businessId,
                                        Business business)
            throws
            SW_DataInputException,
            SW_FieldDuplicateException,
            SW_FieldRequiredException,
            SW_NoSuchEntryException {

        validatorBusinessIsExists(businessId);

        validatorFieldsForUpdateBusiness(business);

        validatorEmailIsExist(
                businessId,
                business.getEmail());
        validatorPhoneNumberIsExist(
                businessId,
                business.getPhoneNumber());
    }

    private void validatorFieldsForUpdateBusiness(
            Business business)
            throws SW_FieldRequiredException, SW_DataInputException {

        validateRequireField(business);

        validatorRegexField(business.getEmail(),
                VALID_EMAIL_ADDRESS_REGEX,
                languageService.getMessage(LanguageKeys.EMAIL_INVALID));
        validatorRegexField(business.getPhoneNumber(),
                VALID_PHONE_NUMBER_REGEX,
                languageService.getMessage(LanguageKeys.PHONE_INVALID));
    }

    private void validateRequireField(Business business) throws SW_FieldRequiredException {
        isNotPopulated(
                business.getName(), languageService.getMessage(LanguageKeys.NAME_REQUIRED));
        isNotPopulated(
                business.getPhoneNumber(), languageService.getMessage(LanguageKeys.PHONE_REQUIRED));
        isNotPopulated(
                business.getBusinessAddress(), languageService.getMessage(LanguageKeys.ADDRESS_REQUIRED));
        isNotPopulated(
                business.getFieldOperations(), languageService.getMessage(LanguageKeys.FIELD_OPERATIONS_REQUIRED));
        isNotPopulated(
                business.getEmail(), languageService.getMessage(LanguageKeys.EMAIL_REQUIRED));
    }

    public void validatorBusinessIsExists(long businessId) throws SW_NoSuchEntryException {

        BusinessEntry customerEntry = localService.fetchBusinessEntry(businessId);

        if (customerEntry != null) return;

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.BUSINESS_NOT_FOUND));
    }

    private void validatorEmailIsExist(long customerId,
                                       String value) throws SW_FieldDuplicateException {
        BusinessEntry entry = localService.fetchBusinessEntry(customerId);

        if (entry.getEmail().equals(value)) return;

        validatorEmailIsExist(value);
    }

    private void validatorPhoneNumberIsExist(long businessId,
                                             String value) throws SW_FieldDuplicateException {
        BusinessEntry entry = localService.fetchBusinessEntry(businessId);
        if (entry.getPhoneNumber().equals(value)) return;

        validatorPhoneNumberIsExist(value);
    }

    private void validatorEmailIsExist(String value) throws SW_FieldDuplicateException {
        BusinessEntry customerEntry = localService.findByEmail(value);

        if (Validator.isNull(customerEntry)) return;
        throw new SW_FieldDuplicateException(languageService.getMessage(LanguageKeys.EMAIL_WAS_USED));
    }

    private void validatorPhoneNumberIsExist(String value) throws SW_FieldDuplicateException {
        BusinessEntry customerEntry = localService.findByPhoneNumber(value);

        if (Validator.isNull(customerEntry)) return;
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
    BusinessEntryLocalService localService;
}
