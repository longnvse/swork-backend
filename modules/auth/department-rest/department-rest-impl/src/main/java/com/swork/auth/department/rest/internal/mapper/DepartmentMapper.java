package com.swork.auth.department.rest.internal.mapper;

import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.service.model.DepartmentEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = DepartmentMapper.class
)
public class DepartmentMapper {
    public Department mapDTOFromEntry(DepartmentEntry from) {
        Department to = new Department();

        to.setId(from.getDepartmentId());
        to.setBusinessId(from.getBusinessId());
        to.setName(from.getName());

        return to;
    }

    public List<Department> mapDTOFromEntries(List<DepartmentEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }

}
