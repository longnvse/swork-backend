package com.swork.common.token.service;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import com.swork.common.token.util.ClaimsKeys;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ClaimsService.class)
public class ClaimsService {
    private final String CLIENT_ID = "clientId";
    private final String SECRET_ID = "secretId";
    private final String CLIENT_ID_KEY = "oauth2.client.default.key";
    private final String SECRET_ID_KEY = "oauth2.secret.default.key";

    public Claims buildClaims(long accountId, String username, Claims claims) {

        AccountEntry entry = accountEntryLocalService.fetchAccountEntry(accountId);

        claims.put(ClaimsKeys.USERNAME, username);
        claims.put(CLIENT_ID, GetterUtil.getString(PropsUtil.get(CLIENT_ID_KEY)));
        claims.put(SECRET_ID, GetterUtil.getString(PropsUtil.get(SECRET_ID_KEY)));

        if (Validator.isNotNull(entry)) {
            claims.put(ClaimsKeys.ACCOUNT_ID, entry.getAccountId());
            claims.put(ClaimsKeys.EMAIL, entry.getEmail());
            claims.put(ClaimsKeys.FULL_NAME, entry.getFullName());
            claims.put(ClaimsKeys.BUSINESS_ID, entry.getBusinessId());
            DepartmentEntry departmentEntry = departmentEntryLocalService.findByAccount(entry.getAccountId());

            if (Validator.isNotNull(departmentEntry)) {
                claims.put(ClaimsKeys.DEPARTMENT, departmentEntry.getDepartmentId());
            }
            claims.put(ClaimsKeys.ROLE, entry.getRole());
        }

        return claims;
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
    @Reference
    private DepartmentEntryLocalService departmentEntryLocalService;
}
