package com.swork.auth.department.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.service.LanguageService;
import com.swork.auth.department.rest.internal.util.LanguageKeys;
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
        service = {DepartmentValidator.class}
)
public class DepartmentValidator {

    public void validatorForPostBusiness(Department department) throws SW_FieldRequiredException,SW_NameDuplicateException {
        validateRequireField(department);
        validatorNameIsExist(department.getName());
    }

    public void validatorFieldsForUpdateDepartment(long departmentId,
                                                  Department department)
            throws SW_FieldRequiredException,  SW_NameDuplicateException, SW_NoSuchEntryException {

        validatorDepartmentIsExists(departmentId);
        validateRequireField(department);
        validatorNameIsExist(
                departmentId,
                department.getName());
    }


    public void validatorDepartmentIsExists(long departmentId) throws SW_NoSuchEntryException {

        DepartmentEntry departmentEntry = localService.fetchDepartmentEntry(departmentId);

        if (departmentEntry != null) return;

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.DEPARTMENT_NOT_FOUND));
    }



    private void validateRequireField(Department department) throws SW_FieldRequiredException {
        isNotPopulated(
                department.getName(), languageService.getMessage(LanguageKeys.NAME_REQUIRED));
    }

    private void validatorNameIsExist(String value) throws SW_NameDuplicateException {
        DepartmentEntry departmentEntry = localService.findByName(value);

        if (Validator.isNull(departmentEntry)) return;
        throw new SW_NameDuplicateException(languageService.getMessage(LanguageKeys.NAME_EXIST));
    }
    private void validatorNameIsExist(long departmentId,
                                      String value) throws SW_NameDuplicateException {
        DepartmentEntry entry = localService.fetchDepartmentEntry(departmentId);

        if (entry.getName().equals(value)) return;

        validatorNameIsExist(value);
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
    DepartmentEntryLocalService localService;

}
