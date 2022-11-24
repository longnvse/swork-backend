package com.swork.core.work.rest.internal.mapper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import com.swork.core.work.rest.dto.v1_0.Handle;
import com.swork.core.work.rest.dto.v1_0.Manage;
import com.swork.core.work.rest.dto.v1_0.Participate;
import com.swork.core.work.service.mapper.model.WorkMemberMapperModel;
import com.swork.core.work.service.mapper.model.WorkMembersMapperModel;
import com.swork.core.work.service.model.WorkMemberEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = WorkMemberMapper.class
)
public class WorkMemberMapper {

    public WorkMembersMapperModel mapModelFromDTO(Manage[] from) {
        if (Validator.isNull(from)) {
            return new WorkMembersMapperModel();
        }

        return Arrays
                .stream(from)
                .map(manage -> identifyMember(manage.getMemberId()))
                .collect(Collectors.toCollection(WorkMembersMapperModel::new));
    }

    public WorkMembersMapperModel mapModelFromDTO(long companyId,
                                                  Participate[] from) {
        if (Validator.isNull(from)) {
            return new WorkMembersMapperModel();
        }

        return Arrays
                .stream(from)
                .map(participate -> identifyMember(companyId, participate.getMemberReferenceCode()))
                .collect(Collectors.toCollection(WorkMembersMapperModel::new));
    }

    public WorkMembersMapperModel mapModelFromDTO(long companyId,
                                                  Handle[] from) {
        if (Validator.isNull(from)) {
            return new WorkMembersMapperModel();
        }

        return Arrays
                .stream(from)
                .map(handle -> identifyMember(companyId, handle.getMemberReferenceCode()))
                .collect(Collectors.toCollection(WorkMembersMapperModel::new));
    }

    public Manage mapManageFromEntry(WorkMemberEntry from) {
        Manage to = new Manage();

        to.setId(from.getWorkMemberId());
        to.setMemberId(from.getMemberId());

        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(from.getMemberId());

        if (Validator.isNotNull(accountEntry)) {
            to.setMemberName(accountEntry.getFullName());
        }

        return to;
    }

    public Manage[] mapManagesFromEntries(List<WorkMemberEntry> from) {
        return from.stream().map(this::mapManageFromEntry).toArray(Manage[]::new);
    }

    public Participate[] mapParticipatesFromEntries(List<WorkMemberEntry> from) {
        return from.stream().map(this::mapParticipateFromEntry).toArray(Participate[]::new);
    }

    public Handle[] mapHandlesFromEntries(List<WorkMemberEntry> from) {
        return from.stream().map(this::mapHandleFromEntry).toArray(Handle[]::new);
    }

    public Participate mapParticipateFromEntry(WorkMemberEntry from) {
        Participate to = new Participate();

        to.setId(from.getWorkMemberId());
        to.setMemberId(from.getMemberId());
        to.setMemberReferenceCode(from.getMemberReferenceCode());
        to.setMemberName(getMemberName(from));

        return to;
    }

    public Handle mapHandleFromEntry(WorkMemberEntry from) {
        Handle to = new Handle();

        to.setId(from.getWorkMemberId());
        to.setMemberId(from.getMemberId());
        to.setMemberReferenceCode(from.getMemberReferenceCode());
        to.setMemberName(getMemberName(from));

        return to;
    }

    private String getMemberName(WorkMemberEntry from) {
        Participate.Type type = Participate.Type.create(from.getMemberType());
        if (type == Participate.Type.ACCOUNT) {
            AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(from.getMemberId());

            if (Validator.isNotNull(accountEntry)) {
                return accountEntry.getFullName();
            }
        } else if (type == Participate.Type.DEPARTMENT) {
            DepartmentEntry departmentEntry = departmentEntryLocalService.fetchDepartmentEntry(from.getMemberId());

            if (Validator.isNotNull(departmentEntry)) {
                return departmentEntry.getName();
            }
        }

        return StringPool.BLANK;
    }

    private WorkMemberMapperModel identifyMember(long companyId,
                                                 String memberReferenceCode) {
        WorkMemberMapperModel to = new WorkMemberMapperModel();

        to.setMemberReferenceCode(memberReferenceCode);

        AccountEntry accountEntry =
                accountEntryLocalService.fetchAccountEntryByExternalReferenceCode(companyId, memberReferenceCode);
        if (Validator.isNotNull(accountEntry)) {
            to.setMemberId(accountEntry.getAccountId());
            to.setMemberType(Participate.Type.ACCOUNT.getValue());
            return to;
        }

        DepartmentEntry departmentEntry =
                departmentEntryLocalService.fetchDepartmentEntryByExternalReferenceCode(companyId, memberReferenceCode);

        if (Validator.isNotNull(departmentEntry)) {
            to.setMemberId(accountEntry.getAccountId());
            to.setMemberType(Participate.Type.DEPARTMENT.getValue());
        }

        return to;
    }

    public WorkMemberMapperModel identifyMember(long accountId) {
        WorkMemberMapperModel to = new WorkMemberMapperModel();

        to.setMemberId(accountId);
        to.setMemberType(Participate.Type.ACCOUNT.getValue());

        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(accountId);

        to.setMemberReferenceCode(accountEntry.getExternalReferenceCode());

        return to;
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private DepartmentEntryLocalService departmentEntryLocalService;
}
