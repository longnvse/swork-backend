package com.swork.account.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.AccountPermision;
import com.swork.account.rest.internal.mapper.AccountPermisionMapper;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.service.AccountPermisionEntryLocalService;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

public class AccountPermisionService {
    public Page<AccountPermision> getAccountsPage(String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter,
                AccountPermisionEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            accountPermisionEntryLocalService.getAccountPermisionEntry(id));
                });
    }

    public AccountPermision addAccount(
            AccountPermision accountPermision,
            ServiceContext serviceContext) throws PortalException {

        AccountPermisionEntry entry =
                accountPermisionEntryLocalService.addAccountPermisionEntry(

                        accountPermision.getPermisionId(),
                        accountPermision.getAccountId(),
                        serviceContext);

        return mapper.mapDTOFromEntry(entry);
    }

    public void deleteAccount(long accountId) throws PortalException {
        accountPermisionEntryLocalService.deleteAccountPermisionEntry(accountId);
    }

    @Reference
    private AccountPermisionMapper mapper;
    @Reference
    private AccountPermisionEntryLocalService accountPermisionEntryLocalService;
}
