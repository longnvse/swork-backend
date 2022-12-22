package com.swork.account.rest.test.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.resource.v1_0.AccountResourceImpl;
import com.swork.account.rest.internal.service.AccountService;
import com.swork.account.rest.internal.validator.AccountValidator;
import com.swork.account.rest.test.mockdata.AccountMockDataUtil;
import com.swork.common.exception.model.SW_DataInputException;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.common.token.helper.api.CommonTokenHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountResourceImplTest {
    @Mock
    private CommonTokenHelper tokenHelper;

    @Mock
    private AccountService service;

    @Mock
    private AccountValidator validator;

    @Mock
    private AccountResourceImpl accountResource;

    @Test
    public void testPostAccount() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        accountResource.postAccount(account);
    }

    @Test
    public void testDeleteAccount() throws PortalException {
        accountResource.deleteAccount(1L);
    }

    @Test
    public void testGetAccount() throws Exception {
        accountResource.getAccount(1L);
    }

    @Test
    public void testPutAccount() throws SW_DataInputException, SW_NoSuchEntryException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        accountResource.putAccount(1L,account);
    }

    @Test
    public void testApprovalAccount() throws Exception {
        accountResource.approvalAccount(1L, Account.Status.INACTIVE.toString());
    }
}
