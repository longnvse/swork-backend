package com.swork.core.resource.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import com.swork.core.resource.service.mapper.model.ResourcesMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalService;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(immediate = true, service = ResourceMapper.class)
public class ResourceMapper {
    public ResourceMapperModel mapDTOToMapperModel(Resource from) {
        ResourceMapperModel to = new ResourceMapperModel();

        to.setResourceTypeId(from.getResourceTypeId());
        to.setTeamId(GetterUtil.getLong(from.getTeamId()));
        TeamEntry objectGroupWorkEntry =
                teamEntryLocalService.fetchTeamEntry(from.getTeamId());
        to.setTeamName(Validator.isNotNull(objectGroupWorkEntry) ?
                objectGroupWorkEntry.getName() : "");
        to.setQuantity(GetterUtil.getInteger(from.getQuantity()));
        to.setDateResource(from.getDateResource());
        to.setTotalAmount(from.getTotalAmount());

        ResourceTypeEntry resourceTypeEntry = resourceTypeEntryLocalService.fetchResourceTypeEntry(from.getResourceTypeId());

        if (Validator.isNotNull(resourceTypeEntry)) {
            to.setResourceTypeName(resourceTypeEntry.getName());
            to.setUnit(resourceTypeEntry.getUnit());
        }

        return to;
    }

    public ResourcesMapperModel mapDTOToMapperModels(Resource[] from) {
        return Arrays.stream(from).map(this::mapDTOToMapperModel).collect(
                ResourcesMapperModel::new, ResourcesMapperModel::add,
                ResourcesMapperModel::addAll);
    }


    public Resource mapEntryToDTO(ResourceEntry from) {
        Resource to = new Resource();

        to.setId(from.getResourceId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setResourceTypeId(from.getResourceTypeId());
        to.setResourceTypeName(from.getResourceTypeName());
        to.setTeamId(from.getTeamId());
        to.setTeamName(from.getTeamName());
        to.setUnit(from.getUnit());
        to.setQuantity(from.getQuantity());
        to.setDateResource(from.getDateResource());
        to.setTotalAmount(from.getTotalAmount());
        to.setWorkId(from.getWorkId());
        to.setPhaseId(from.getPhaseId());
        to.setProjectId(from.getProjectId());
        to.setCreatorId(from.getAccountId());

        AccountEntry accountEntry =
                accountEntryLocalService.fetchAccountEntry(from.getAccountId());

        if (Validator.isNotNull(accountEntry)) {
            to.setCreator(GetterUtil.getString(accountEntry.getFullName()));
        }

        if (Validator.isNotNull(from.getWorkId())) {
            WorkEntry taskEntry = workEntryLocalService.fetchWorkEntry(from.getWorkId());

            if (Validator.isNotNull(taskEntry)) {
                to.setParentName(taskEntry.getName());
            }
        } else if (Validator.isNotNull(from.getPhaseId())) {
            PhaseEntry phaseEntry = phaseEntryLocalService.fetchPhaseEntry(from.getPhaseId());

            if (Validator.isNotNull(phaseEntry)) {
                to.setParentName(phaseEntry.getPhaseName());
            }
        } else {
            ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(from.getProjectId());

            if (Validator.isNotNull(projectEntry)) {
                to.setParentName(projectEntry.getName());
            }
        }

        return to;
    }

    public Resource[] mapEntriesToDTO(List<ResourceEntry> from) {
        return from
                .stream()
                .map(this::mapEntryToDTO)
                .toArray(Resource[]::new);
    }

    public List<Resource> mapMapperModelToDtos(List<ResourceMapperModel> from) {
        List<Resource> to = new ArrayList<>();

        from.forEach(resourceMapperModel -> to.add(mapMapperModelToDto(resourceMapperModel)));

        return to;
    }

    public Resource mapMapperModelToDto(ResourceMapperModel from) {
        Resource to = new Resource();

        to.setId(from.getResourceId());

        ResourceTypeEntry resourceTypeEntry = resourceTypeEntryLocalService.fetchResourceTypeEntry(from.getResourceTypeId());
        to.setResourceTypeName(Validator.isNotNull(resourceTypeEntry) ? resourceTypeEntry.getName() : "");
        to.setQuantity(from.getQuantity());

        AccountEntry entry = accountEntryLocalService.fetchAccountEntry(from.getCreatorId());
        to.setCreator(Validator.isNotNull(entry) ? entry.getFullName() : "Admin");
        return to;
    }

    @Reference
    private ResourceTypeEntryLocalService resourceTypeEntryLocalService;
    @Reference
    private TeamEntryLocalService teamEntryLocalService;
    @Reference
    private WorkEntryLocalService workEntryLocalService;
    @Reference
    private AccountEntryLocalService accountEntryLocalService;
    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
}
