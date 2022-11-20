package com.swork.auth.department.rest.test.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.mapper.DepartmentMapper;
import com.swork.auth.department.rest.internal.service.DepartmentService;
import com.swork.auth.department.rest.test.mockdata.DepartmentEntryMockData;
import com.swork.auth.department.rest.test.mockdata.DepartmentMockDataUtil;
import com.swork.auth.department.service.mapper.model.DepartmentMapperModel;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.model.DepartmentEntryWrapper;
import com.swork.auth.department.service.service.DepartmentAccountEntryLocalService;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @InjectMocks
    public DepartmentService departmentService;
    @Mock
    public DepartmentMapper mapper;
    @Mock
    public DepartmentEntryLocalService departmentEntryLocalService;
    @Mock
    public DepartmentAccountEntryLocalService departmentAccountEntryLocalService;

    @Mock
    public Filter filter;

    @Mock
    public Pagination pagination;
    @Mock
    public Page<Department> departmentPage;

    @Mock
    public ServiceContext serviceContext;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testPostDepartment() {
        Department department = DepartmentMockDataUtil.buildDepartment();
        DepartmentMapperModel model = mapper.mapMapperModelFromDTO(department);
        Long businessId = 1L;
        Long creatorId = 1L;
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(departmentEntryLocalService.addDepartmentEntry(businessId, creatorId, model, serviceContext))
                .thenReturn(departmentEntry);
    }

    @Test
    public void testUpdateDepartment() {
        Department department = DepartmentMockDataUtil.buildDepartment();
        DepartmentMapperModel model = mapper.mapMapperModelFromDTO(department);
        Long modifiedId = 1L;
        Long departmentId = 1L;
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(departmentEntryLocalService.updateDepartmentEntry(modifiedId, departmentId, model, serviceContext))
                .thenReturn(departmentEntry);
    }

    @Test
    public void testGetById() throws PortalException {
        Long id = 1L;
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        when(departmentEntryLocalService.getById(id))
                .thenReturn(departmentEntry);
    }

    @Test
    public void deleteById() throws PortalException {
        Long id = 1L;
        departmentEntryLocalService.deleteDepartmentEntry(id);
        departmentService.deleteById(id);
    }

}
