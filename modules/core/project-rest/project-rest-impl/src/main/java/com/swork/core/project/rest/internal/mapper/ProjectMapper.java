package com.swork.core.project.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.common.comment.service.service.CommentEntryLocalServiceUtil;
import com.swork.common.file.service.FileManagerEntryLocalServiceUtil;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.project.rest.dto.v1_0.*;
import com.swork.core.project.service.constant.Type;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component(
        immediate = true,
        service = ProjectMapper.class
)
public class ProjectMapper {
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

    public Project mapDTOFromEntry(long myId,
                                   Long myDepartmentId,
                                   ProjectEntry from) {
        Project to = new Project();

        to.setId(from.getProjectId());
        to.setName(from.getName());
        to.setCode(from.getCode());
        to.setBudget(from.getBudget());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setStatus(Project.Status.create(from.getStatus()));
        to.setCommentNumber(CommentEntryLocalServiceUtil.countByClassPkIdAndClassPkName(from.getProjectId(), "project"));
        to.setAttachNumber(FileManagerEntryLocalServiceUtil.countByProjectId(from.getBusinessId(), from.getProjectId()));
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
        to.setRole(getRole(myId, myDepartmentId, to));

        return to;
    }

    private String getRole(long myId,
                           Long myDepartmentId,
                           Project project) {
        if (Arrays.stream(project.getManages()).anyMatch(manage -> GetterUtil.getLong(manage.getMemberId()) == myId)) {
            return "manage";
        }

        if (Arrays.stream(project.getHandles()).anyMatch(handle -> {
            if (handle.getMemberType().equals(Handle.MemberType.DEPARTMENT) && Objects.equals(handle.getMemberId(), myDepartmentId)) {
                return true;
            }

            return handle.getMemberType().equals(Handle.MemberType.ACCOUNT) && handle.getMemberId() == myId;

        })) {
            return "handle";
        }

        if (Arrays.stream(project.getParticipates()).anyMatch(participate -> {
            if (participate.getMemberType().equals(Participate.MemberType.DEPARTMENT) && Objects.equals(participate.getMemberId(), myDepartmentId)) {
                return true;
            }

            return participate.getMemberType().equals(Participate.MemberType.ACCOUNT) && participate.getMemberId() == myId;

        })) {
            return "participate";
        }

        return null;
    }

    public Phase mapPhaseFromPhaseEntry(PhaseEntry phaseEntry) {
        Phase to = new Phase();

        to.setId(phaseEntry.getPhaseId());
        to.setName(phaseEntry.getPhaseName());
        to.setProgress(phaseEntry.getProgress());
        to.setStatus(phaseEntry.getStatus());
        to.setStartDate(phaseEntry.getStartDate());
        to.setEndDate(phaseEntry.getEndDate());

        List<WorkEntry> workEntries = workEntryLocalService.findByPhaseId(phaseEntry.getPhaseId(), false);

        to.setWorks(workEntries.stream().map(this::mapWorkFromWorkEntry).toArray(Work[]::new));

        return to;
    }

    public Work mapWorkFromWorkEntry(WorkEntry workEntry) {
        Work to = new Work();

        to.setId(workEntry.getWorkId());
        to.setName(workEntry.getName());
        to.setProgress(workEntry.getProgress());
        to.setStatus(workEntry.getStatus());
        to.setStartDate(workEntry.getStartDate());
        to.setEndDate(workEntry.getEndDate());

        List<WorkEntry> workEntries = workEntryLocalService.findByParentId(workEntry.getBusinessId(), workEntry.getWorkId());

        to.setWorks(workEntries.stream().map(this::mapWorkFromWorkEntry).toArray(Work[]::new));

        return to;
    }

    public GanttChart mapGanttChartFromPhaseAndWork(List<PhaseEntry> phaseEntries,
                                                    List<WorkEntry> workEntries) {
        GanttChart to = new GanttChart();
        to.setPhases(phaseEntries.stream().map(this::mapPhaseFromPhaseEntry).toArray(Phase[]::new));
        to.setWorks(workEntries.stream().map(this::mapWorkFromWorkEntry).toArray(Work[]::new));

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
    @Reference
    private WorkEntryLocalService workEntryLocalService;
}
