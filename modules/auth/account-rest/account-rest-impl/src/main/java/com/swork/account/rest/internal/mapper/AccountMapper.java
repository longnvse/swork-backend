package com.swork.account.rest.internal.mapper;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.service.model.AccountEntry;
import org.osgi.service.component.annotations.Component;

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
        to.setPassword(from.getPassword());
        to.setDateOfBirth(from.getDateOfBirth());
        to.setStatus(Account.Status.create(from.getStatus()));

        return to;
    }

}
