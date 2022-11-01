package com.swork.business.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.service.BusinessEntryLocalService;
import com.swork.common.exception.model.*;
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


    public void validatorForPostBusiness(Business business) throws SW_DataInputException, SW_FieldRequiredException, SW_FieldDuplicateException, SW_NameDuplicateException {
        validatorFieldsForUpdateBusiness(business);

        validatorNameIsExist(business.getName());
        validatorEmailIsExist(business.getEmail());
        validatorPhoneNumberIsExist(business.getPhoneNumber());
    }

    public void validatorForPutBusiness(long businessId,
                                        Business business)
            throws
            SW_DataInputException,
            SW_FieldDuplicateException,
            SW_FieldRequiredException,
            SW_NoSuchEntryException,
            SW_NameDuplicateException {

        validatorBusinessIsExists(businessId);

        validatorFieldsForUpdateBusiness(business);

        validatorNameIsExist(
                businessId,
                business.getName());
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
                "Email không đúng định dạng");
        validatorRegexField(business.getPhoneNumber(),
                VALID_PHONE_NUMBER_REGEX,
                "Số điện thoại không đúng định dạng");
    }

    private void validateRequireField(Business business) throws SW_FieldRequiredException {
        isNotPopulated(
                business.getName(), "Vui lòng nhập tên đơn vị");
        isNotPopulated(
                business.getPhoneNumber(), "Vui lòng nhập số điện thoại");
        isNotPopulated(
                business.getBusinessAddress(), "Vui lòng nhập địa chỉ đơn vị");
        isNotPopulated(
                business.getFieldOperations(), "Vui lòng nhập lĩnh vực hoạt động");
        isNotPopulated(
                business.getEmail(), "Vui lòng nhập email");
    }

    public void validatorBusinessIsExists(long businessId) throws SW_NoSuchEntryException {

        BusinessEntry customerEntry = localService.fetchBusinessEntry(businessId);

        if (customerEntry != null) return;

        throw new SW_NoSuchEntryException("Business Not found");
    }

    private void validatorNameIsExist(long businessId,
                                      String value) throws SW_NameDuplicateException {
        BusinessEntry entry = localService.fetchBusinessEntry(businessId);

        if (entry.getName().equals(value)) return;

        validatorNameIsExist(value);
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

    private void validatorNameIsExist(String value) throws SW_NameDuplicateException {
        BusinessEntry customerEntry = localService.findByName(value);

        if (Validator.isNull(customerEntry)) return;
        throw new SW_NameDuplicateException("Tên đã được sử dụng");
    }

    private void validatorEmailIsExist(String value) throws SW_FieldDuplicateException {
        BusinessEntry customerEntry = localService.findByEmail(value);

        if (Validator.isNull(customerEntry)) return;
        throw new SW_FieldDuplicateException("Email đã được đăng ký cho đơn vị khác!");
    }

    private void validatorPhoneNumberIsExist(String value) throws SW_FieldDuplicateException {
        BusinessEntry customerEntry = localService.findByPhoneNumber(value);

        if (Validator.isNull(customerEntry)) return;
        throw new SW_FieldDuplicateException("Số điện thoại đã được đăng ký cho đơn vị khác!");
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
    BusinessEntryLocalService localService;

    @Reference
    AccountEntryLocalService accountEntryLocalService;
}
