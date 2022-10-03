package com.swork.common.token.service;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.swork.common.token.util.ClaimsKeys;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ClaimsService.class)
public class ClaimsService {

    private final String CUSTOMER_NAME = "customerName";
    private final String CLIENT_ID = "clientId";
    private final String SECRET_ID = "secretId";
    private final String CLIENT_ID_KEY = "oauth2.client.default.key";
    private final String SECRET_ID_KEY = "oauth2.secret.default.key";

    public Claims buildClaims(long customerId, long userId, String userName, Claims claims) {

//        AccountEntry entry = _accountEntryLocalService.fetchByScreenName(customerId, userName);
        User entry = UserLocalServiceUtil.fetchUser(userId);

        claims.put(ClaimsKeys.SCREEN_NAME, userName);
        claims.put(ClaimsKeys.CUSTOMER_ID, customerId);
//        claims.put(CUSTOMER_NAME, getCustomerName(customerId));
        claims.put(CLIENT_ID, GetterUtil.getString(PropsUtil.get(CLIENT_ID_KEY)));
        claims.put(SECRET_ID, GetterUtil.getString(PropsUtil.get(SECRET_ID_KEY)));
        claims.put(ClaimsKeys.USER_ID, userId);

//        if (Validator.isNotNull(entry)) {
//            claims.put(ClaimsKeys.ACCOUNT_ID, entry.getAccountId());
//
//            if (Validator.isNotNull(entry.getEmployeeId())) {
//                claims.put(ClaimsKeys.EMPLOYEE, entry.getEmployeeId());
//            }
//
//            claims.put(ClaimsKeys.EMAIL, entry.getEmail());
//            claims.put(ClaimsKeys.FULL_NAME, entry.getFullName());
//        }

        return claims;
    }

//    private String getCustomerName(long customerId) {
//        CustomerEntry customerEntry =
//                _customerEntryLocalService.fetchCustomerEntry(customerId);
//
//        if (Validator.isNotNull(customerEntry)) {
//            return customerEntry.getName();
//        }
//
//        return "ROOT";
//    }
//
//    private AccountTokenModel buildAccountTokenModel(AccountEntry accountEntry) {
//        AccountTokenModel accountToken = new AccountTokenModel();
//
//        long accountId = accountEntry.getAccountId();
//
//        String[] roles =
//                ListUtil.toArray(
//                        _roleEntryLocalService
//                                .getAccountEntryRoleEntries(accountId), ROLE_KEY_ACCESSOR);
//
//        accountToken.setAccountId(accountId);
//        accountToken.setRoles(roles);
//        accountToken.setEmployee(buildEmployeeTokenModel());
//
//        return accountToken;
//    }
//
//    private EmployeeTokenModel buildEmployeeTokenModel() {
//        //TODO: need to implement
//        EmployeeTokenModel employeeToken = new EmployeeTokenModel();
//
//        employeeToken.setEmployeeCode("MOCK_CODE");
//        employeeToken.setDepartment(buildEmployeeDepartment(0l));
//        employeeToken.setPositions(buildPositionTokenModels(0l));
//
//        return employeeToken;
//    }
//
//    private DepartmentTokenModel buildEmployeeDepartment(long employeeId) {
//        //TODO: need to implement
//
//        DepartmentTokenModel departmentTokenModel = new DepartmentTokenModel();
//        departmentTokenModel.setCode("MOCK_CODE");
//        departmentTokenModel.setName("MOCK_NAME");
//
//        return departmentTokenModel;
//    }
//
//    private ArrayList<PositionTokenModel> buildPositionTokenModels(long employeeId) {
//        //TODO: need to implement
//        ArrayList<PositionTokenModel> positionTokenModels = new ArrayList<>();
//
//        PositionTokenModel model = new PositionTokenModel();
//        model.setCode("MOCK_CODE");
//        model.setName("MOCK_NAME");
//
//        positionTokenModels.add(model);
//
//        return positionTokenModels;
//    }
//
//    protected static final Accessor<RoleEntry, String> ROLE_KEY_ACCESSOR = new Accessor<RoleEntry, String>() {
//        @Override
//        public String get(RoleEntry roleEntry) {
//            return roleEntry.getKey();
//        }
//
//        @Override
//        public Class<String> getAttributeClass() {
//            return String.class;
//        }
//
//        @Override
//        public Class<RoleEntry> getTypeClass() {
//            return RoleEntry.class;
//        }
//    };
//
//    @Reference
//    private AccountEntryLocalService _accountEntryLocalService;
//
//    @Reference
//    private RoleEntryLocalService _roleEntryLocalService;
//
//    @Reference
//    private CustomerEntryLocalService _customerEntryLocalService;
}
