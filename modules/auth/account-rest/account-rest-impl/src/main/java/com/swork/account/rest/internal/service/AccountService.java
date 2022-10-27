package com.swork.account.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.AccountPermision;
import com.swork.account.rest.internal.mapper.AccountMapper;
import com.swork.account.rest.internal.mapper.AccountPermisionMapper;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.account.service.service.AccountPermisionEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = AccountService.class)
public class AccountService {

    public Page<Account> getAccountsPage(String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter,
                AccountEntry.class.getName(),
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
                    long accountId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            accountEntryLocalService.getAccountEntry(accountId));
                });
    }

    public Account addAccount(long creatorId,
                              Account account,
                              ServiceContext serviceContext) throws PortalException {

        AccountEntry entry =
                accountEntryLocalService.addAccountEntry(
                        creatorId,
                        account.getUsername(),
                        PwdGenerator.getPassword(12, PwdGenerator.KEY3, PwdGenerator.KEY1),
                        account.getFullName(),
                        account.getEmail(),
                        account.getPhoneNumber(),
                        account.getAddress(),
                        serviceContext);

        return mapper.mapDTOFromEntry(entry);
    }

    public void deleteAccount(long accountId) throws PortalException {
        accountEntryLocalService.deleteAccountEntry(accountId);
    }

    public Account updateAccount(long creatorId,
                                 long accountId,
                                 Account account,
                                 ServiceContext serviceContext) {

        AccountEntry entry =
                accountEntryLocalService.updateAccountEntry(
                        creatorId,
                        accountId,
                        account.getFullName(),
                        account.getEmail(),
                        account.getPhoneNumber(),
                        account.getAddress(),
                        serviceContext);

        return mapper.mapDTOFromEntry(entry);
    }

    public Account getAccount(long accountId) throws PortalException {

        AccountEntry entry =
                accountEntryLocalService.getAccountEntry(accountId);

        return mapper.mapDTOFromEntry(entry);
    }





    @Reference
    private AccountMapper mapper;
    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private AccountPermisionMapper accountPermisionMapper;
    @Reference
    private AccountPermisionEntryLocalService accountPermisionEntryLocalService;
}
