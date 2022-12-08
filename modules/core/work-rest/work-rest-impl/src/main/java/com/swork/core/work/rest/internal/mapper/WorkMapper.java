package com.swork.core.work.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.constant.Type;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.model.WorkMemberEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import com.swork.core.work.service.service.WorkMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = WorkMapper.class
)
public class WorkMapper {
    public WorkMapperModel mapModelFromDTO(long companyId,
                                           Work from) {
        WorkMapperModel to = new WorkMapperModel();

        to.setName(from.getName());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setParentId(from.getParentId());
        to.setProgressType(from.getProgressType().getValue());
        to.setIncompleteAmount(from.getIncompleteAmount());
        to.setUnit(from.getUnit());
        to.setPhaseId(from.getPhaseId());
        to.setProjectId(from.getProjectId());

        to.setManages(workMemberMapper.mapModelFromDTO(from.getManages()));
        to.setParticipates(workMemberMapper.mapModelFromDTO(companyId, from.getParticipates()));
        to.setHandles(workMemberMapper.mapModelFromDTO(companyId, from.getHandles()));

        return to;
    }

    public Work mapDTOFromEntry(WorkEntry from) {
        Work to = new Work();

        to.setId(from.getWorkId());
        to.setName(from.getName());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setParentId(GetterUtil.getLong(from.getParentId()) != 0 ? from.getParentId() : null);

        WorkEntry parent = localService.fetchWorkEntry(from.getWorkId());

        if (Validator.isNotNull(parent)) {
            to.setParentName(parent.getName());
        }

        to.setPhaseId(GetterUtil.getLong(from.getPhaseId()) != 0 ? from.getPhaseId() : null);

        PhaseEntry phaseEntry = phaseEntryLocalService.fetchPhaseEntry(from.getPhaseId());

        if (Validator.isNotNull(phaseEntry)) {
            to.setPhaseName(phaseEntry.getPhaseName());
        }

        to.setProjectId(GetterUtil.getLong(from.getProjectId()) != 0 ? from.getProjectId() : null);

        ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(from.getProjectId());

        if (Validator.isNotNull(projectEntry)) {
            to.setProjectName(projectEntry.getName());
        }

        to.setProgressType(Work.ProgressType.create(from.getProgressType()));
        to.setProgress(from.getProgress());
        to.setIncompleteAmount(from.getIncompleteAmount());
        to.setUnit(from.getUnit());
        to.setStatus(Work.Status.create(from.getStatus()));

        List<WorkMemberEntry> manageEntries =
                memberEntryLocalService.findByW_T(from.getWorkId(), Type.MANAGE.getValue());

        to.setManages(workMemberMapper.mapManagesFromEntries(manageEntries));

        List<WorkMemberEntry> participateEntries =
                memberEntryLocalService.findByW_T(from.getWorkId(), Type.PARTICIPATE.getValue());

        to.setParticipates(workMemberMapper.mapParticipatesFromEntries(participateEntries));

        List<WorkMemberEntry> handleEntries =
                memberEntryLocalService.findByW_T(from.getWorkId(), Type.HANDLE.getValue());

        to.setHandles(workMemberMapper.mapHandlesFromEntries(handleEntries));


        return to;
    }

    @Reference
    private WorkMemberMapper workMemberMapper;
    @Reference
    private WorkMemberEntryLocalService memberEntryLocalService;
    @Reference
    private WorkEntryLocalService localService;
    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
}
