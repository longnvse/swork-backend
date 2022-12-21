package com.swork.account.rest.test.mapper;

import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.mapper.AccountMapper;
import com.swork.account.rest.test.mockdata.AccountEntryMockData;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AccountMapperTest {
    @InjectMocks
    private AccountMapper accountMapper;
    @Test
    public void testMapDTOFromEntry(){
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        accountEntry.setAccountId(1L);
        accountEntry.setExternalReferenceCode("ABC");
        accountEntry.setUsername("Dat nguyen");
        accountEntry.setFullName("Nguyen Quoc Dat");
        accountEntry.setEmail("Datnguyen12200@gmail.com");
        accountEntry.setPhoneNumber("0948854268");
        accountEntry.setAddress("Nam Dinh");
        accountEntry.setPassword("DatNQ123@");
        accountEntry.setDateOfBirth(new Date(2000,02,01));
        accountEntry.setStatus(Account.Status.ACTIVE.toString());
        Account account=accountMapper.mapDTOFromEntry(accountEntry);
        assertEquals(accountEntry.getAccountId(),(long) account.getId());
        assertEquals(accountEntry.getExternalReferenceCode(),account.getExternalReferenceCode());
        assertEquals(accountEntry.getUsername(), account.getUsername());
        assertEquals(accountEntry.getFullName(),account.getFullName());
        assertEquals(accountEntry.getEmail(),account.getEmail());
        assertEquals(accountEntry.getPhoneNumber(), account.getPhoneNumber());
        assertEquals(accountEntry.getAddress(),account.getAddress());
        assertEquals(accountEntry.getPassword(),account.getPassword());
        assertEquals(accountEntry.getDateOfBirth(),account.getDateOfBirth());
        assertEquals(accountEntry.getStatus(),account.getStatus().getValue());
    }

}
