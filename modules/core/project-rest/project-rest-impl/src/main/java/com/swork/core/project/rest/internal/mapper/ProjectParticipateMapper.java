package com.swork.core.project.rest.internal.mapper;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Participate;
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
        service = ProjectParticipateMapper.class
)
public class ProjectParticipateMapper {

    public Participate mapDTOFromEntry(ProjectMemberEntry from) {

        Participate to = new Participate();

        to.setId(from.getProjectMemberId());
        to.setMemberId(from.getMemberId());
        to.setMemberReferenceCode(from.getMemberReferenceCode());
        to.setMemberType(Participate.MemberType.create(from.getMemberType()));
        to.setMemberName(
                projectHandleMapper
                        .getNameByIdAndType(from.getMemberId(), from.getMemberType()));

        return to;
    }

    public ProjectMemberMapperModel mapModelFromDTO(Participate from) {

        ProjectMemberMapperModel to = new ProjectMemberMapperModel();

        to.setMemberId(from.getMemberId());
        to.setMemberType(from.getMemberType().getValue());
        to.setMemberReferenceCode(from.getMemberReferenceCode());

        return to;
    }

    public ProjectMembersMapperModel mapModelsFromDTO(long companyId, Participate[] from) {
        if (Validator.isNull(from)) {
            return new ProjectMembersMapperModel();
        }

        return Arrays.stream(from)
                .map(dto -> mapModelFromDTO(mapMemberFromExt(companyId, dto.getMemberReferenceCode())))
                .collect(Collectors.toCollection(ProjectMembersMapperModel::new));
    }

    public Participate[] mapDTOFromEntries(List<ProjectMemberEntry> from) {
        return from.stream()
                .map(this::mapDTOFromEntry)
                .toArray(Participate[]::new);

    }

    public Participate mapMemberFromExt(long companyId, String externalReferenceCode) {
        Participate to = new Participate();

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
            to.setMemberType(Participate.MemberType.ACCOUNT);
        }
//        }

        return to;
    }

    @Reference
    private ProjectHandleMapper projectHandleMapper;
    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
