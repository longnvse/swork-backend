package com.swork.core.resource.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.resource.rest.dto.v1_0.ResourceType;
import com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = ResourceTypeMapper.class)
public class ResourceTypeMapper {
    public ResourceTypeMapperModel mapDTOToMapperModel(ResourceType from) {
        ResourceTypeMapperModel to = new ResourceTypeMapperModel();

        to.setName(from.getName());
        to.setUnit(from.getUnit());
        to.setParentId(GetterUtil.getLong(from.getParentId(), 0L));

        return to;
    }

    public ResourceType mapEntryToDTO(ResourceTypeEntry from) {
        ResourceType to = new ResourceType();

        to.setId(from.getResourceTypeId());
        to.setName(from.getName());
        to.setUnit(from.getUnit());
        to.setParentId(from.getParentId());

        AccountEntry accountEntry =
                accountEntryLocalService.fetchAccountEntry(from.getAccountId());

        if (Validator.isNotNull(accountEntry)) {
            to.setCreator(GetterUtil.getString(accountEntry.getFullName()));
        }

        List<ResourceTypeEntry> children = localService.getChildren(from.getBusinessId(), from.getResourceTypeId());

        to.setResourceTypes(children.stream().map(this::mapEntryToDTO).toArray(ResourceType[]::new));

        return to;
    }

    @Reference
    private ResourceTypeEntryLocalService localService;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
