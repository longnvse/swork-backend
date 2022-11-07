package com.swork.core.project.rest.internal.mapper;

import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.service.constant.Type;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;

@Component(
        immediate = true,
        service = ProjectMapper.class
)
public class ProjectMapper {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public ProjectMapperModel mapModelFromDTO(long companyId, Project from) {

        ProjectMapperModel to = new ProjectMapperModel();

        to.setBudget(from.getBudget());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setDescription(from.getDescription());
        to.setName(from.getName());
        to.setCode(from.getCode());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setActualStartDate(from.getActualStartDate());
        to.setActualEndDate(from.getActualEndDate());
        to.setProgressType(from.getProgressType());

        to.setHandles(
                projectHandleMapper
                        .mapHandlesFromDTO(companyId, from.getHandles()));
        to.setManages(
                projectManageMapper
                        .mapModelsFromDTO(from.getManages()));
        to.setParticipates(
                projectParticipateMapper
                        .mapModelsFromDTO(companyId, from.getParticipates()));

        return to;
    }

    public Project mapDTOFromEntry(ProjectEntry from) {
        Project to = new Project();

        to.setId(from.getProjectId());
        to.setName(from.getName());
        to.setCode(from.getCode());
        to.setBudget(from.getBudget());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setStatus(Project.Status.create(from.getStatus()));

        to.setHandles(
                projectHandleMapper
                        .mapHandleFromEntries(
                                memberEntryLocalService
                                        .findByP_T(from.getProjectId(), Type.HANDLE.getValue())));

        to.setManages(
                projectManageMapper
                        .mapModelFromEntries(
                                memberEntryLocalService
                                        .findByP_T(from.getProjectId(), Type.MANAGE.getValue())));

        to.setParticipates(
                projectParticipateMapper
                        .mapDTOFromEntries(
                                memberEntryLocalService.findByP_T(from.getProjectId(), Type.PARTICIPATE.getValue())));

        to.setProgress(from.getProgress());

        to.setActualStartDate(from.getActualStartDate());
        to.setActualEndDate(from.getActualEndDate());
        to.setProgressType(from.getProgressType());

        return to;
    }

    @Reference
    private ProjectHandleMapper projectHandleMapper;
    @Reference
    private ProjectManageMapper projectManageMapper;
    @Reference
    private ProjectParticipateMapper projectParticipateMapper;

    @Reference
    private ProjectMemberEntryLocalService memberEntryLocalService;
}
