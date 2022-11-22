package com.swork.core.work.rest.internal.mapper;

import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = WorkMapper.class
)
public class WorkMapper {
    public WorkMapperModel mapDTOToMapperModel(long companyId,
                                               Work from) {
        WorkMapperModel to = new WorkMapperModel();

        to.setName(from.getName());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setParentId(from.getParentId());
        to.setProgressType(from.getProgressType());
        to.setPhaseId(from.getPhaseId());
        to.setProjectId(from.getProjectId());

        to.setManages(workMemberMapper.mapModelFromDTO(from.getManages()));
        to.setParticipates(workMemberMapper.mapModelFromDTO(companyId, from.getParticipates()));
        to.setManages(workMemberMapper.mapModelFromDTO(companyId, from.getHandles()));

        return to;
    }

    public Work mapDTOFromEntry(WorkEntry from) {
        Work to = new Work();

        to.setId(from.getWorkId());
        to.setName(from.getName());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setDescription(from.getDescription());
        to.setParentId(from.getParentId());
        to.setProjectId(from.getProjectId());
        to.setPhaseId(from.getPhaseId());
        to.setProgressType(from.getProgressType());
        to.setProgress(from.getProgress());

        return to;
    }

    @Reference
    private WorkMemberMapper workMemberMapper;
}
