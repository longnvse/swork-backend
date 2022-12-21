package com.swork.account.rest.test.mockdata;

import com.swork.account.rest.dto.v1_0.Account;

import java.util.Date;

public class AccountMockDataUtil {
    public static Account buildAccount() {
        Account to = new Account();
        to.setId(1L);
        to.setExternalReferenceCode("ABC");
        to.setUsername("Dat nguyen");
        to.setFullName("Nguyen Quoc Dat");
        to.setEmail("Datnguyen12200@gmail.com");
        to.setPhoneNumber("0948854268");
        to.setAddress("Nam Dinh");
        to.setPassword("DatNQ123@");
        to.setDateOfBirth(new Date(2000,02,01));
        to.setStatus(Account.Status.ACTIVE);
        return to;
    }
}
