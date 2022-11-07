package com.swork.core.phase.rest.internal.mapper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.phase.rest.dto.v1_0.PhaseManage;
import com.swork.core.phase.service.model.PhaseManageEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = PhaseManageMapper.class
)
public class PhaseManageMapper {

    public PhaseManage mapFromEntry(PhaseManageEntry from) {
        PhaseManage to = new PhaseManage();

        to.setId(from.getPhaseManageId());
        to.setPhaseId(from.getPhaseId());
        to.setAccountId(from.getAccountId());
        to.setAccountName(getNameById(from.getAccountId()));

        return to;
    }

    public PhaseManage[] mapFromEntries(List<PhaseManageEntry> from) {
        return from.stream().map(this::mapFromEntry).toArray(PhaseManage[]::new);
    }

    private String getNameById(long id) {
        AccountEntry accountEntry = accountEntryLocalService.fetchAccountEntry(id);

        if (Validator.isNotNull(accountEntry)) {
            return accountEntry.getFullName();
        }
        return StringPool.BLANK;
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

}
