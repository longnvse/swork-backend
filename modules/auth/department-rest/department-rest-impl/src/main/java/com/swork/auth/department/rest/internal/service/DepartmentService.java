package com.swork.auth.department.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.mapper.DepartmentMapper;
import com.swork.auth.department.service.constant.SearchField;
import com.swork.auth.department.service.mapper.model.DepartmentMapperModel;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentAccountEntryLocalService;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.List;

@Component(immediate = true, service = DepartmentService.class)
public class DepartmentService {
    public Page<Department> getAllDepartmentAccounts() {
        List<DepartmentEntry> departmentEntries = departmentEntryLocalService.getDepartmentEntries(-1, -1);
        List<Department> departments = mapper.mapDTOFromEntries(departmentEntries);
        return Page.of(departments, Pagination.of(1, departments.size()), departments.size());
    }

    public Page<Department> getDepartmentsPage(long businessId,
                                               String search,
                                               Filter filter,
                                               Pagination pagination,
                                               Sort[] sorts,
                                               ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter businessIdFilter =
                            new TermFilter(SearchField.BUSINESS_ID, String.valueOf(businessId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                DepartmentEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK
                ),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long departmentId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            departmentEntryLocalService.getDepartmentEntry(departmentId));
                }
        );
    }


    public Department postDepartment(long businessId,
                                     long creatorId,
                                     Department department,
                                     ServiceContext serviceContext) {
        DepartmentMapperModel model = mapper.mapMapperModelFromDTO(department);
        DepartmentEntry departmentEntry =
                departmentEntryLocalService.addDepartmentEntry(businessId, creatorId, model, serviceContext);
        return mapper.mapDTOFromEntry(departmentEntry);
    }

    public void deleteById(long id) throws PortalException {
        departmentAccountEntryLocalService.deleteByDepartmentId(id);
        departmentEntryLocalService.deleteDepartmentEntry(id);
    }

    public Department updateDepartment(long modifierId,
                                       long departmentId,
                                       Department department,
                                       ServiceContext serviceContext) {
        DepartmentMapperModel model=mapper.mapMapperModelFromDTO(department);
        DepartmentEntry checklistEntry = departmentEntryLocalService.updateDepartmentEntry(
                modifierId,
                departmentId,
                model,
                serviceContext
        );
        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public Department geById(long id) throws PortalException {
        DepartmentEntry departmentEntry = departmentEntryLocalService.getDepartmentEntry(id);
        return mapper.mapDTOFromEntry(departmentEntry);
    }


    @Reference
    DepartmentMapper mapper;
    @Reference
    DepartmentEntryLocalService departmentEntryLocalService;
    @Reference
    DepartmentAccountEntryLocalService departmentAccountEntryLocalService;

}
