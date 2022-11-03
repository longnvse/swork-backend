package com.swork.account.rest.internal.mapper;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.PermissionDetail;
import com.swork.account.service.mapper.model.AccountMapperModel;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.PermissionDetailEntry;
import com.swork.account.service.service.PermisionDetailEntryLocalService;
import com.swork.account.service.service.PermissionDetailEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;

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

        List<PermissionDetailEntry> permissionDetailEntrys=permissionDetailEntryLocalService.getByAccountId(from.getAccountId());

        String[] actionCode = new String[permissionDetailEntrys.size()];

        // Adding list values into ArrayList
        for (int i = 0; i < permissionDetailEntrys.size(); i++) {
            actionCode[i] = permissionDetailEntrys.get(i).getActionCode();
        }

        to.setActionCode(actionCode);

        return to;
    }

    @Reference
    PermissionDetailEntryLocalService permissionDetailEntryLocalService;

}
