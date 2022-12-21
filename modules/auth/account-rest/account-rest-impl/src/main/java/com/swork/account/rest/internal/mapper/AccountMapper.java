package com.swork.account.rest.internal.mapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.service.model.AccountEntry;
import com.swork.common.file.helper.api.CommonFileHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AccountMapper.class)
public class AccountMapper {

    public Account mapDTOFromEntry(AccountEntry from, ThemeDisplay themeDisplay) throws PortalException {
        Account to = new Account();

        to.setId(from.getAccountId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setUsername(from.getUsername());
        to.setFullName(from.getFullName());
        to.setEmail(from.getEmail());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setAddress(from.getAddress());
        to.setDateOfBirth(from.getDateOfBirth());
        to.setGender(from.getGender());
        if (GetterUtil.getLong(from.getAvatar()) != GetterUtil.DEFAULT_LONG) {
            to.setAvatar(commonFileHelper.getPreviewUrl(from.getAvatar(), themeDisplay));
        }

        to.setStatus(Account.Status.create(from.getStatus()));

        return to;
    }

    @Reference
    private CommonFileHelper commonFileHelper;

}
