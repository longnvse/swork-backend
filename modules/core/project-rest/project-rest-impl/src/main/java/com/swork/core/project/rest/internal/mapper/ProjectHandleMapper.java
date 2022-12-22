package com.swork.core.project.rest.internal.mapper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Handle;
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
        service = ProjectHandleMapper.class
)
public class ProjectHandleMapper {

    public Handle mapDTOFromEntry(ProjectMemberEntry from) {

        Handle to = new Handle();

        to.setId(from.getProjectMemberId());
        to.setMemberId(from.getMemberId());
        to.setMemberType(Handle.MemberType.create(from.getMemberType()));
        to.setMemberReferenceCode(from.getMemberReferenceCode());
        to.setMemberName(getNameByIdAndType(from.getMemberId(), from.getMemberType()));

        return to;
    }

    public ProjectMemberMapperModel mapHandleFromDTO(Handle from) {
        ProjectMemberMapperModel to = new ProjectMemberMapperModel();

        to.setMemberId(from.getMemberId());
        if (Validator.isNotNull(from.getMemberType())) {
            to.setMemberType(from.getMemberType().getValue());
        }
        to.setMemberReferenceCode(from.getMemberReferenceCode());

        return to;
    }

    public ProjectMembersMapperModel mapHandlesFromDTO(long companyId, Handle[] from) {
        if (Validator.isNull(from)) {
            return new ProjectMembersMapperModel();
        }

        return Arrays.stream(from)
                .map(handle -> mapHandleFromDTO(mapHandleFromExt(companyId, handle.getMemberReferenceCode())))
                .collect(Collectors.toCollection(ProjectMembersMapperModel::new));

    }

    public Handle[] mapHandleFromEntries(List<ProjectMemberEntry> from) {

        if (!from.isEmpty()) {
            return from.stream()
                    .map(this::mapDTOFromEntry)
                    .toArray(Handle[]::new);
        }

        return new Handle[0];
    }

    public String getNameByIdAndType(long id, String type) {

        switch (type) {
//            case "department":
//                DepartmentEntry departmentEntry =
//                        departmentEntryLocalService.fetchDepartmentEntry(id);
//
//                if (Validator.isNotNull(departmentEntry)) {
//                    return departmentEntry.getName();
//                }
//                break;
            default:
                AccountEntry accountEntry =
                        accountEntryLocalService.fetchAccountEntry(id);

                if (Validator.isNotNull(accountEntry)) {
                    return accountEntry.getFullName();
                }
                break;
        }


        return StringPool.BLANK;
    }

    public Handle mapHandleFromExt(long companyId, String externalReferenceCode) {
        Handle to = new Handle();

        to.setMemberReferenceCode(externalReferenceCode);

//        DepartmentEntry departmentEntry =
//                departmentEntryLocalService
//                        .fetchDepartmentEntryByExternalReferenceCode(companyId, externalReferenceCode);
//
//        if (Validator.isNotNull(departmentEntry)) {
//            to.setMemberId(departmentEntry.getDepartmentId());
//            to.setMemberType(Handle.MemberType.DEPARTMENT);
//        } else {
        AccountEntry accountEntry =
                accountEntryLocalService
                        .fetchAccountEntryByExternalReferenceCode(companyId, externalReferenceCode);

        if (Validator.isNotNull(accountEntry)) {
            to.setMemberId(accountEntry.getAccountId());
            to.setMemberType(Handle.MemberType.ACCOUNT);
        }
//        }

        return to;
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
