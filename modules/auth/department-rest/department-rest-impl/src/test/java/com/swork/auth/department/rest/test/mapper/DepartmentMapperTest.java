package com.swork.auth.department.rest.test.mapper;

import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.mapper.DepartmentMapper;
import com.swork.auth.department.rest.test.mockdata.DepartmentEntryMockData;
import com.swork.auth.department.rest.test.mockdata.DepartmentMockDataUtil;
import com.swork.auth.department.service.mapper.model.DepartmentMapperModel;
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.model.DepartmentEntryWrapper;
import com.swork.auth.department.service.service.DepartmentAccountEntryLocalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentMapperTest {
    @InjectMocks
    private DepartmentMapper departmentMapper;
    @Mock
    private DepartmentAccountEntryLocalService departmentAccountEntryLocalService;

    @Test
    public void testMapFromDeparmentEntryToDepartment() {
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        departmentEntry.setName("abc");
        departmentEntry.setBusinessId(1L);
        List<DepartmentAccountEntry> departmentAccountEntries=new ArrayList<DepartmentAccountEntry>();
        when(departmentAccountEntryLocalService.getByDepartmentId(anyLong())).thenReturn(departmentAccountEntries);
        Department actual = departmentMapper
                .mapDTOFromEntry(new DepartmentEntryWrapper(departmentEntry));
        assertEquals("abc",actual.getName());
    }

    @Test
    public void testFromListDepartmentEntryToListDepartment(){
        List<DepartmentEntry> departmentEntries=new ArrayList<DepartmentEntry>();
        DepartmentEntry departmentEntry = new DepartmentEntryWrapper(new DepartmentEntryMockData());
        departmentEntry.setName("Department A");
        departmentEntries.add(departmentEntry);
        List<Department> departments=departmentMapper.mapDTOFromEntries(departmentEntries);;
        assertEquals("Department A",departments.get(0).getName());
    }

    @Test
    public void testFromDepartmentToDepartmentMapperModel(){
        Department department = DepartmentMockDataUtil.buildDepartment();
        DepartmentMapperModel departmentMapperModel=departmentMapper.mapMapperModelFromDTO(department);
        assertEquals("Department A",departmentMapperModel.getName());
    }
}
