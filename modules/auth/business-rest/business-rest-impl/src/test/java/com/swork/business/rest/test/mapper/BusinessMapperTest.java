package com.swork.business.rest.test.mapper;

import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.mapper.BusinessMapper;
import com.swork.business.rest.test.mockdata.BusinessEntryMockData;
import com.swork.business.rest.test.mockdata.BusinessMockDataUtil;
import com.swork.business.service.mapper.model.BusinessMapperModel;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.model.BusinessEntryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BusinessMapperTest {
    @InjectMocks
    private BusinessMapper businessMapper;

    @Test
    public void testMapMapperModelFromDTO(){
        Business business= BusinessMockDataUtil.buildBusiness();
        BusinessMapperModel businessMapperModel=businessMapper.mapMapperModelFromDTO(business);
        assertEquals(business.getName(),businessMapperModel.getName());
        assertEquals(business.getCustomerName(),businessMapperModel.getCustomerName());
        assertEquals(business.getPhoneNumber(),businessMapperModel.getPhoneNumber());
        assertEquals(business.getEmail(),businessMapperModel.getEmail());
        assertEquals(business.getBusinessAddress(),businessMapperModel.getBusinessAddress());
        assertEquals(business.getFieldOperations(),businessMapperModel.getFieldOperations());

    }

    @Test
    public void testMapDTOFromEntry(){
        BusinessEntry businessEntry=new BusinessEntryWrapper(new BusinessEntryMockData());
        businessEntry.setBusinessId(1L);
        businessEntry.setExternalReferenceCode("ABC");
        businessEntry.setName("Business A");
        businessEntry.setCustomerName("Customer A");
        businessEntry.setPhoneNumber("0948854268");
        businessEntry.setEmail("Business@gmail.com");
        businessEntry.setBusinessAddress("HaNoi");
        businessEntry.setFieldOperations("Operation");
        Business business=businessMapper.mapDTOFromEntry(businessEntry);
        assertEquals(businessEntry.getBusinessId(),(long)business.getId());
        assertEquals(businessEntry.getExternalReferenceCode(),business.getExternalReferenceCode());
        assertEquals(businessEntry.getName(),business.getName());
        assertEquals(businessEntry.getCustomerName(),business.getCustomerName());
        assertEquals(businessEntry.getPhoneNumber(),business.getPhoneNumber());
        assertEquals(businessEntry.getEmail(),business.getEmail());
        assertEquals(businessEntry.getBusinessAddress(),business.getBusinessAddress());
        assertEquals(businessEntry.getFieldOperations(),business.getFieldOperations());
    }

}
