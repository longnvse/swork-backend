package com.swork.auth.department.rest.test.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.service.DepartmentService;
import com.swork.auth.department.rest.internal.service.LanguageService;
import com.swork.auth.department.rest.internal.validator.DepartmentValidator;
import com.swork.auth.department.rest.test.mockdata.DepartmentEntryMockData;
import com.swork.auth.department.rest.test.mockdata.DepartmentMockDataUtil;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.model.DepartmentEntryWrapper;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NameDuplicateException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentValidatorTest {
    @InjectMocks
    private DepartmentValidator validator;
    @Mock
    private LanguageService languageService;
    @Mock
    private DepartmentEntryLocalService localService;
    @Mock
    private DepartmentService service;
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testValidatorForPostBusinessRequiredFieldWhenFieldEmpty() throws SW_NameDuplicateException, SW_FieldRequiredException {
        Department department = DepartmentMockDataUtil.buildDepartment();
        department.setName("");
        expected.expect(PortalException.class);
        validator.validatorForPostBusiness(department);
    }

    @Test
    public void testValidatorForPostWhenNameExist() throws PortalException {
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(localService.findByName(anyString()))
                .thenReturn(departmentEntry);
        Department department = DepartmentMockDataUtil.buildDepartment();
        department.setName(departmentEntry.getName());
        expected.expect(PortalException.class);
        validator.validatorForPostBusiness(department);
    }

    @Test
    public void testValidatorFieldsForUpdateDepartmentWhenDepartmentHaveExist() throws SW_NoSuchEntryException, SW_NameDuplicateException, SW_FieldRequiredException {
        DepartmentEntry departmentEntryFetch = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        DepartmentEntry departmentEntryDuplicate = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(localService.fetchDepartmentEntry(anyLong()))
                .thenReturn(departmentEntryFetch);
        when(localService.findByName(anyString()))
                .thenReturn(departmentEntryDuplicate);
        Department department = DepartmentMockDataUtil.buildDepartment();
        Long id = 1L;
        department.setName(departmentEntryFetch.getName());
        expected.expect(PortalException.class);
        validator.validatorFieldsForUpdateDepartment(id, department);
    }

    @Test
    public void testValidatorForUpdateWhenEmptyField() throws SW_NoSuchEntryException, SW_NameDuplicateException, SW_FieldRequiredException {
        DepartmentEntry departmentEntryFetch = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        DepartmentEntry departmentEntryDuplicate = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(localService.fetchDepartmentEntry(anyLong()))
                .thenReturn(departmentEntryFetch);
        when(localService.findByName(anyString()))
                .thenReturn(departmentEntryDuplicate);
        Department department = DepartmentMockDataUtil.buildDepartment();
        Long id = 1L;
        department.setName((String) null);
        expected.expect(PortalException.class);
        validator.validatorFieldsForUpdateDepartment(id, department);
    }


}
