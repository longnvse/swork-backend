package com.swork.account.rest.test.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.service.LanguageService;
import com.swork.account.rest.internal.validator.AccountValidator;
import com.swork.account.rest.test.mockdata.AccountEntryMockData;
import com.swork.account.rest.test.mockdata.AccountMockDataUtil;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryWrapper;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.common.exception.model.SW_DataInputException;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountValidatorTest {
    @Mock
    AccountEntryLocalService localService;
    @InjectMocks
    AccountValidator accountValidator;
    @Rule
    public ExpectedException expected = ExpectedException.none();
    @Test
    public void testValidatorForPostAccountWhenEmailNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail((String) null);
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }
    @Test
    public void testValidatorForPostAccountWhenEmailEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail("");
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenEmailWrongFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail("Dat");
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenEmailTrueFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail("Dat123@gmail.com");
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenPhoneWrongFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setPhoneNumber("234sf");
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenPhoneTrueFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setPhoneNumber("0948854268");
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenEmailWasUse() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        when(localService.findByEmail(anyString())).thenReturn(accountEntry);
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPostAccountWhenPhoneWasUse() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        when(localService.findByPhone(anyString())).thenReturn(accountEntry);
        expected.expect(PortalException.class);
        accountValidator.validatorForPostAccount(account);
    }

    @Test
    public void testValidatorForPutAccountWhenFetchNull() throws SW_DataInputException, SW_NoSuchEntryException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Account account= AccountMockDataUtil.buildAccount();
        when(localService.fetchAccountEntry(anyLong())).thenReturn(null);
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }

    @Test
    public void testValidatorForPutAccountWhenEmailNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail((String) null);
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }
    @Test
    public void testValidatorForPutAccountWhenEmailEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail("");
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }

    @Test
    public void testValidatorForPutAccountWhenEmailWrongFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setEmail("Dat");
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }

    @Test
    public void testValidatorForPutAccountWhenPhoneWrongFormat() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        account.setPhoneNumber("234sf");
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }


    @Test
    public void testValidatorForPutAccountWhenEmailWasUse() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        when(localService.findByEmail(anyString())).thenReturn(accountEntry);
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }

    @Test
    public void testValidatorForPutAccountWhenPhoneWasUse() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Account account= AccountMockDataUtil.buildAccount();
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        when(localService.findByPhone(anyString())).thenReturn(accountEntry);
        expected.expect(PortalException.class);
        accountValidator.validatorForPutAccount(1L,account);
    }
}
