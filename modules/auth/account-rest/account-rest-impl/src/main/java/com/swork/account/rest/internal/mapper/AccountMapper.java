package com.swork.account.rest.internal.mapper;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AccountMapper.class)
public class AccountMapper {

    public Account mapDTOFromEntry(AccountEntry from) {
        Account to = new Account();

        to.setId(from.getAccountId());
        to.setUsername(from.getUsername());
        to.setFullName(from.getFullName());
        to.setEmail(from.getEmail());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setAddress(from.getAddress());

        return to;
    }


    @Reference
    private AccountEntryLocalService accountEntryLocalService;

}
