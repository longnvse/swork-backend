package com.swork.core.phase.rest.internal.mapper;

import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.service.mapper.model.PhaseMapperModel;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseManageEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Objects;

@Component(
        immediate = true,
        service = PhaseMapper.class
)
public class PhaseMapper {

    public PhaseMapperModel mapModelFromDto(Phase from) {
        PhaseMapperModel to = new PhaseMapperModel();

        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setStatus(from.getStatus().getValue());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setManages(from.getManages());
        to.setProjectId(from.getProjectId());

        return to;
    }

    public Phase mapDTOFromEntry(PhaseEntry from) {
        Phase to = new Phase();

        to.setId(from.getPhaseId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getPhaseName());
        to.setDescription(from.getDescription());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setProjectId(from.getProjectId());

        to.setProgress(from.getProgress());

        if (Objects.equals(to.getProgress(), 100L)) {
            to.setStatus(Phase.Status.create(Phase.Status.INACTIVE.getValue()));
        } else {
            to.setStatus(Phase.Status.create(from.getStatus()));
        }

        to.setPhaseManages(
                phaseManageMapper
                        .mapFromEntries(
                                phaseManageEntryLocalService.findByPhaseId(from.getPhaseId())));
        return to;
    }

    @Reference
    private PhaseManageEntryLocalService phaseManageEntryLocalService;
    @Reference
    private PhaseManageMapper phaseManageMapper;
}
