package com.swork.account.rest.internal.mapper;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.AccountPermision;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountPermisionEntry;

public class AccountPermisionMapper {
    public AccountPermision mapDTOFromEntry(AccountPermisionEntry from) {
        AccountPermision to = new AccountPermision();
        to.setId(from.getId());
        to.setAccountId(from.getAccountId());
        to.setPermisionId(from.getPermisionId());

        return to;
    }
}
