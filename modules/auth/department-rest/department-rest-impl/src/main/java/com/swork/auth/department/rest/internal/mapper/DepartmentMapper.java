package com.swork.auth.department.rest.internal.mapper;

import com.liferay.portal.kernel.util.Validator;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.dto.v1_0.Member;
import com.swork.auth.department.service.mapper.model.DepartmentMapperModel;
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentAccountEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = DepartmentMapper.class)
public class DepartmentMapper {

    public Department mapDTOFromEntry(DepartmentEntry from) {
        Department to = new Department();

        to.setId(from.getDepartmentId());
        to.setName(from.getName());

        List<DepartmentAccountEntry> departmentAccountEntries =
                departmentAccountEntryLocalService.getByDepartmentId(from.getDepartmentId());

        to.setMembers(memberMapper.mapDTOFromEntries(departmentAccountEntries));

        return to;
    }

    public List<Department> mapDTOFromEntries(List<DepartmentEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }

    public DepartmentMapperModel mapMapperModelFromDTO(Department from) {
        DepartmentMapperModel to = new DepartmentMapperModel();

        to.setName(from.getName());

        if (Validator.isNotNull(from.getMembers())) {
            to.setAccounts(Arrays.stream(from.getMembers()).mapToLong(Member::getMemberId).boxed().toArray(Long[]::new));
        }
        return to;
    }

    @Reference
    DepartmentAccountEntryLocalService departmentAccountEntryLocalService;

    @Reference
    MemberMapper memberMapper;
}
