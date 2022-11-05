package com.swork.auth.department.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.service.exception.NoSuchDepartmentEntryException;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import com.swork.common.exception.model.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(
        immediate = true,
        service = DepartmentValidator.class
)
public class DepartmentValidator {
//    public static final String VALID_DATE_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

    public void validatorForPostChecklist(Department department) throws SW_DataInputException, SW_FieldRequiredException, SW_NameDuplicateException, NoSuchDepartmentEntryException {
        validateRequireField(department);
        validatorNameIsExist(department.getName());
    }

    private void validatorRegexField(String value,
                                     String pattern,
                                     String errorMsg) throws SW_DataInputException {
        Pattern pt = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pt.matcher(value);

        if (matcher.find()) return;

        throw new SW_DataInputException(errorMsg);
    }

    public void validatorForPutChecklist(long id, Department department) throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException, SW_NameDuplicateException, NoSuchDepartmentEntryException {

        validatorDepartmentIsExists(id);
        validateRequireField(department);
        validatorNameIsExist(department.getName());

    }


//    private void validatorFieldsForUpdateDepartment(Department department) throws SW_FieldRequiredException, SW_DataInputException {
//
//        validateRequireField(department);
////        validatorRegexField(checkList.getStartDate(),
////                VALID_DATE_REGEX,
////                "Start date wrong format");
////        validatorRegexField(checkList.getEndDate(),
////                VALID_DATE_REGEX,
////                "End date wrong format");
//
//    }

    public void validatorDepartmentIsExists(long id) throws SW_NoSuchEntryException {

        DepartmentEntry departmentEntry = departmentEntryLocalService.fetchDepartmentEntry(id);

        if (departmentEntry != null) return;

        throw new SW_NoSuchEntryException("Not exist");
    }

    public void validateRequireField(Department department) throws SW_FieldRequiredException {
        isNotPopulated(department.getBusinessId().toString(), "BusinessId can not be empty");
        isNotPopulated(department.getName(),"Name can not be empty");
    }

    private void validatorNameIsExist(String name) throws SW_NameDuplicateException, NoSuchDepartmentEntryException {
        DepartmentEntry departmentEntry = departmentEntryLocalService.findByName(name);

        if (Validator.isNull(departmentEntry)) return;
        throw new SW_NameDuplicateException("Name is duplicate");
    }

    private void isNotPopulated(String value, String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new SW_FieldRequiredException(errorMsgKey);
        }
    }

    @Reference
    private DepartmentEntryLocalService departmentEntryLocalService;

}
