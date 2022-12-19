package com.swork.business.rest.test.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.service.LanguageService;
import com.swork.business.rest.internal.validator.BusinessValidator;
import com.swork.business.rest.test.mockdata.BusinessEntryMockData;
import com.swork.business.rest.test.mockdata.BusinessMockDataUtil;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.model.BusinessEntryWrapper;
import com.swork.business.service.service.BusinessEntryLocalService;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessValidatorTest {
    @Mock
    LanguageService languageService;
    @Mock
    BusinessEntryLocalService localService;
    @InjectMocks
    BusinessValidator businessValidator;
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testValidatorForPostBusinessWhenNameEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setName("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenNameNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setName((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenPhoneEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenPhoneNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenBusinessAddressEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setBusinessAddress("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenBusinessAddressNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setBusinessAddress((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenFieldOperationEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenFieldOperationNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenEmailEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenEmailNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenWrongFormatEmail() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setEmail("123");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenWrongFormatPhone() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("abc");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenEmailExist() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        BusinessEntry businessEntry=new BusinessEntryWrapper(new BusinessEntryMockData());
        businessEntry.setEmail("EmailDuplicate@gmail.com");
        when(localService.findByEmail(anyString())).thenReturn(businessEntry);
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setEmail("EmailDuplicate@gmail.com");
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPostBusinessWhenPhoneExist() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("0948854268");
        BusinessEntry businessEntry=new BusinessEntryWrapper(new BusinessEntryMockData());
        businessEntry.setPhoneNumber("09488542689");
        when(localService.findByPhoneNumber(anyString())).thenReturn(businessEntry);
        expected.expect(PortalException.class);
        businessValidator.validatorForPostBusiness(business);
    }

    @Test
    public void testValidatorForPutBusinessWhenNotExist() throws SW_DataInputException, SW_NoSuchEntryException, SW_FieldDuplicateException, SW_FieldRequiredException {
        Business business= BusinessMockDataUtil.buildBusiness();
        when(localService.fetchBusinessEntry(anyLong())).thenReturn(null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenNameEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setName("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenNameNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setName((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenPhoneEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenPhoneNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenBusinessAddressEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setBusinessAddress("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenBusinessAddressNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setBusinessAddress((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenFieldOperationEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenFieldOperationNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenEmailEmpty() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations("");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenEmailNull() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setFieldOperations((String) null);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenWrongFormatEmail() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setEmail("123");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenWrongFormatPhone() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("abc");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenEmailExist() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        BusinessEntry businessEntry=new BusinessEntryWrapper(new BusinessEntryMockData());
        businessEntry.setEmail("EmailDuplicate@gmail.com");
        when(localService.findByEmail(anyString())).thenReturn(businessEntry);
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setEmail("EmailDuplicate@gmail.com");
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForPutBusinessWhenPhoneExist() throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException {
        Business business= BusinessMockDataUtil.buildBusiness();
        business.setPhoneNumber("0948854268");
        BusinessEntry businessEntry=new BusinessEntryWrapper(new BusinessEntryMockData());
        businessEntry.setPhoneNumber("09488542689");
        when(localService.findByPhoneNumber(anyString())).thenReturn(businessEntry);
        expected.expect(PortalException.class);
        businessValidator.validatorForPutBusiness(1L,business);
    }

    @Test
    public void testValidatorForExistWhenNotFound() throws SW_NoSuchEntryException {
        when(localService.fetchBusinessEntry(anyLong())).thenReturn(null);
        expected.expect(PortalException.class);
        businessValidator.validatorBusinessIsExists(1L);
    }


}
