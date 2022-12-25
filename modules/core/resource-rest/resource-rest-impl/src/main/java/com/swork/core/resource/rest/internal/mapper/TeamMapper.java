package com.swork.core.resource.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.internal.service.TeamMemberService;
import com.swork.core.resource.service.mapper.model.TeamMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.ResourceEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = TeamMapper.class
)
public class TeamMapper {
    public TeamMapperModel mapDTOToMapperModel(Team from) {
        TeamMapperModel to = new TeamMapperModel();

        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setActive(from.getIsActive());
        to.setAdmins(teamMemberMapper.mapDTOToMapperModels(from.getAdmins()));
        to.setMembers(teamMemberMapper.mapDTOToMapperModels(from.getMembers()));
        to.setPhaseId(from.getPhaseId());
        to.setProjectId(from.getProjectId());

        return to;
    }

    public Team mapEntryToDTO(TeamEntry from) {
        Team to = new Team();

        to.setId(from.getTeamId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setIsActive(from.getIsActive());

        to.setMembers(_objectItemService.getMembersByTeamId(from.getTeamId()));
        to.setAdmins(_objectItemService.getAdminsByTeamId(from.getTeamId()));

        to.setPhaseId(from.getPhaseId());
        to.setTotalIncoming(from.getTotalIncoming());
        to.setTotalSpending(from.getTotalSpending());

        if (from.getPhaseId() != GetterUtil.DEFAULT_LONG) {
            PhaseEntry phaseEntry = phaseEntryLocalService.fetchPhaseEntry(from.getPhaseId());

            if (Validator.isNotNull(phaseEntry)) {
                to.setPhaseName(phaseEntry.getPhaseName());
            }
        }

        to.setProjectId(from.getProjectId());
        if (from.getProjectId() != GetterUtil.DEFAULT_LONG) {
            ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(from.getProjectId());

            if (Validator.isNotNull(projectEntry)) {
                to.setProjectName(projectEntry.getName());
            }
        }
        to.setCreateDate(from.getCreateDate());
        to.setModifiedDate(from.getModifiedDate());

        AccountEntry accountEntry =
                accountEntryLocalService.fetchAccountEntry(from.getAccountId());

        if (Validator.isNotNull(accountEntry)) {
            to.setCreator(GetterUtil.getString(accountEntry.getFullName()));
        }

        List<ResourceEntry> resourceEntries = resourceEntryLocalService.getByObjectGroupId(from.getBusinessId(), from.getTeamId());

        to.setResources(resourceMapper.mapEntriesToDTO(resourceEntries));

        return to;
    }

    @Reference
    private TeamMemberMapper teamMemberMapper;

    @Reference
    private TeamMemberService _objectItemService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private ResourceMapper resourceMapper;

    @Reference
    private ResourceEntryLocalService resourceEntryLocalService;

    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;

    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
}
