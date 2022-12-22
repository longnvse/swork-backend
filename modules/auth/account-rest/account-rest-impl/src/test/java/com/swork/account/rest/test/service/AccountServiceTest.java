package com.swork.account.rest.test.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.mapper.AccountMapper;
import com.swork.account.rest.internal.service.AccountService;
import com.swork.account.rest.test.mockdata.AccountMockDataUtil;
import com.swork.account.service.service.AccountEntryLocalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @Mock
    private AccountMapper mapper;
    @Mock
    private AccountEntryLocalService accountEntryLocalService;
    @Mock
    private ServiceContext serviceContext;
    @InjectMocks
    private AccountService accountService;
    @Test
    public void testAddAccount(){
        Account account= AccountMockDataUtil.buildAccount();
        accountService.addAccount(1L,1L,account,serviceContext);
    }

    @Test
    public void testDeleteAccount() throws PortalException {
        accountService.deleteAccount(1L);
    }

    @Test
    public void testUpdateAccount(){
        Account account= AccountMockDataUtil.buildAccount();
        accountService.updateAccount(1L,1L,account,serviceContext);
    }

    @Test
    public void testGetAccount() throws PortalException {
        Account account=accountService.getAccount(1L);
    }

    @Test
    public void testApprovalAccount(){
        accountService.approvalAccount(1L, Account.Status.INACTIVE.toString(), serviceContext);
    }
}
