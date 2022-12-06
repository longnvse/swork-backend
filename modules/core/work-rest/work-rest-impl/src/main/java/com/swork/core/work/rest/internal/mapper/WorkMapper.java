package com.swork.core.work.rest.internal.mapper;

import com.swork.core.project.service.constant.Type;
import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.model.WorkMemberEntry;
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
        to.setParentId(from.getParentId() != 0 ? from.getParentId() : null);
        to.setPhaseId(from.getPhaseId() != 0 ? from.getPhaseId() : null);
        to.setProjectId(from.getProjectId() != 0 ? from.getProjectId() : null);
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
}
