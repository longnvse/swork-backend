package com.swork.core.project.rest.internal.mapper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Handle;
import com.swork.core.project.rest.dto.v1_0.Manage;
import com.swork.core.project.service.mapper.model.ProjectMemberMapperModel;
import com.swork.core.project.service.mapper.model.ProjectMembersMapperModel;
import com.swork.core.project.service.model.ProjectMemberEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = ProjectManageMapper.class
)
public class ProjectManageMapper {

    public ProjectMemberMapperModel mapModelFromDTO(Manage from) {
        ProjectMemberMapperModel to = new ProjectMemberMapperModel();

        to.setMemberId(from.getMemberId());
        to.setMemberType(Handle.MemberType.ACCOUNT.getValue());

        return to;
    }

    public Manage mapDTOFromEntry(ProjectMemberEntry from) {
        Manage to = new Manage();

        to.setId(from.getProjectMemberId());
        to.setMemberId(from.getMemberId());
        to.setMemberName(getNameById(from.getMemberId()));

        return to;
    }

    public ProjectMembersMapperModel mapModelsFromDTO(Manage[] from) {
        if (Validator.isNull(from)) {
            return new ProjectMembersMapperModel();

        }

        return Arrays.stream(from)
                .map(this::mapModelFromDTO)
                .collect(Collectors.toCollection(ProjectMembersMapperModel::new));
    }

    public Manage[] mapModelFromEntries(List<ProjectMemberEntry> from) {
        return from.stream()
                .map(this::mapDTOFromEntry)
                .toArray(Manage[]::new);
    }

    public String getNameById(long id) {
        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(id);

        if (Validator.isNotNull(accountEntry)) {
            return accountEntry.getFullName();
        }
        return StringPool.BLANK;
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
