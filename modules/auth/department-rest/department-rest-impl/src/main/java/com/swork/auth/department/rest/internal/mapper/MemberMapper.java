package com.swork.auth.department.rest.internal.mapper;

import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.department.rest.dto.v1_0.Member;
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = MemberMapper.class)

public class MemberMapper {
    public Member mapDTOFromEntry(DepartmentAccountEntry from) {
        Member to = new Member();

        to.setId(from.getDepartmentAccountId());
        to.setMemberId(from.getAccountId());

        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(from.getAccountId());

        if (Validator.isNotNull(accountEntry)) {
            to.setMemberName(accountEntry.getFullName());
        }

        return to;
    }

    public Member[] mapDTOFromEntries(List<DepartmentAccountEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .toArray(Member[]::new);
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
