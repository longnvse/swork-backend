package com.swork.core.project.rest.internal.service;

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
import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.internal.mapper.ProjectMapper;
import com.swork.core.project.service.constant.SearchFields;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.Date;

@Component(
        immediate = true,
        service = ProjectService.class
)
public class ProjectService {

    public Page<Project> getProjectPages(long businessId,
                                         String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                ProjectEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long projectId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            localService
                                    .getProjectEntry(projectId));
                });
    }

    public Project postProject(long businessId,
                               long creatorId,
                               Project project,
                               ServiceContext serviceContext) {

        ProjectMapperModel projectMapperModel = mapper.mapModelFromDTO(serviceContext.getCompanyId(), project);

        ProjectEntry entry = localService.addProject(businessId, creatorId, projectMapperModel, serviceContext);

        return mapper.mapDTOFromEntry(entry);
    }

    public Project putProject(long creatorId,
                              long projectId,
                              Project project,
                              ServiceContext serviceContext) {

        ProjectMapperModel projectMapperModel = mapper.mapModelFromDTO(serviceContext.getCompanyId(), project);

        ProjectEntry entry = localService.updateProject(creatorId, projectId, projectMapperModel, serviceContext);

        return mapper.mapDTOFromEntry(entry);
    }

    public void approvalProject(long creatorId,
                                long projectId,
                                String status,
                                ServiceContext serviceContext) {

        localService.approvalProject(creatorId, projectId, status, serviceContext);

    }

    public void updateDescription(long creatorId,
                                  long projectId,
                                  String description,
                                  ServiceContext serviceContext) {
        localService.updateDescription(creatorId, projectId, description, serviceContext);
    }

    public void updateDate(long creatorId,
                           long projectId,
                           Date startDate,
                           Date endDate,
                           ServiceContext serviceContext) {
        localService.updateDate(creatorId, projectId, startDate, endDate, serviceContext);
    }

    public void updateActualDate(long creatorId,
                                 long projectId,
                                 Date actualStartDate,
                                 Date actualEndDate,
                                 ServiceContext serviceContext) {
        localService.updateDate(creatorId, projectId, actualStartDate, actualEndDate, serviceContext);
    }

    public void updateMember(long creatorId,
                             long projectId,
                             Project project,
                             ServiceContext serviceContext) {
        ProjectMapperModel model = mapper.mapModelFromDTO(serviceContext.getCompanyId(), project);

        localService.updateMember(creatorId, projectId, model, serviceContext);
    }


    public Project getProject(long projectId) {

        return mapper
                .mapDTOFromEntry(
                        localService.fetchProjectEntry(projectId));
    }

    public void deleteProject(long projectId) throws PortalException {
        projectMemberEntryLocalService.deleteByProjectId(projectId);
        localService.deleteProjectEntry(projectId);
    }

    @Reference
    private ProjectMapper mapper;

    @Reference
    private ProjectEntryLocalService localService;

    @Reference
    private ProjectMemberEntryLocalService projectMemberEntryLocalService;


}
