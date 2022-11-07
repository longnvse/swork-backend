package com.swork.auth.department.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.mapper.DepartmentMapper;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;

@Component(immediate = true, service = DepartmentService.class)
public class DepartmentService {
    public Page<Department> getCheckListPages() {
        List<DepartmentEntry> checklistEntries = departmentEntryLocalService.getDepartmentEntries(-1, -1);
        List<Department> checkLists = mapper.mapDTOFromEntries(checklistEntries);
        return Page.of(checkLists, Pagination.of(1, checkLists.size()), checkLists.size());
    }

    public Department postDepartment(long accountId,
                                     Department department,
                                     ServiceContext serviceContext) throws ParseException {
        DepartmentEntry departmentEntry = departmentEntryLocalService.addDepartmentEntry(accountId, department.getBusinessId(), department.getName(), serviceContext);
        return mapper.mapDTOFromEntry(departmentEntry);
    }

    public void deleteById(long id) throws PortalException {
        departmentEntryLocalService.deleteDepartmentEntry(id);
    }

    public Department updateDepartment(long modifierId,
                                       Department department,
                                       ServiceContext serviceContext) {
        DepartmentEntry checklistEntry = departmentEntryLocalService.updateDepartmentEntry(
                modifierId,
                department.getId(),
                department.getBusinessId(),
                department.getName(),
                serviceContext
        );

        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public Department geById(long id) throws PortalException {
        DepartmentEntry departmentEntry = departmentEntryLocalService.getDepartmentEntry(id);
        return mapper.mapDTOFromEntry(departmentEntry);
    }

//    public Page<Department> getDepartmentPages(String search,
//                                               Filter filter,
//                                               Pagination pagination,
//                                               Sort[] sorts,
//                                               ServiceContext serviceContext) throws Exception {
//
//        return SearchUtil.search(
//                Collections.emptyMap(),
//                booleanQuery -> {
//                },
//                filter,
//                DepartmentEntry.class.getName(),
//                search,
//                pagination,
//                queryConfig -> queryConfig.setSelectedFieldNames(
//                        Field.ENTRY_CLASS_PK
//                ),
//                searchContext -> {
//                    searchContext.setCompanyId(serviceContext.getCompanyId());
//
//                    if (Validator.isNotNull(search)) {
//                        searchContext.setKeywords(search);
//                    }
//                },
//                sorts
//                ,
//                document -> {
//                    long checklistId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
//
//                    return mapper.mapDTOFromEntry(
//                            departmentEntryLocalService.getDepartmentEntry(checklistId));
//                }
//        );
//    }

    @Reference
    DepartmentMapper mapper;
    @Reference
    DepartmentEntryLocalService departmentEntryLocalService;
}
