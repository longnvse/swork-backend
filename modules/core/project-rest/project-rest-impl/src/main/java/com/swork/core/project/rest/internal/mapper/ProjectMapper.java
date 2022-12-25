package com.swork.core.project.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.common.comment.service.service.CommentEntryLocalServiceUtil;
import com.swork.common.file.service.FileManagerEntryLocalServiceUtil;
import com.swork.core.project.rest.dto.v1_0.Handle;
import com.swork.core.project.rest.dto.v1_0.Participate;
import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.service.constant.Type;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
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

    @Reference
    private ProjectHandleMapper projectHandleMapper;
    @Reference
    private ProjectManageMapper projectManageMapper;
    @Reference
    private ProjectParticipateMapper projectParticipateMapper;

    @Reference
    private ProjectMemberEntryLocalService memberEntryLocalService;
}
