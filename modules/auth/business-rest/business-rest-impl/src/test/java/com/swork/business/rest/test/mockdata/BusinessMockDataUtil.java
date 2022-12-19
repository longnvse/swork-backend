package com.swork.business.rest.test.mockdata;

import com.swork.business.rest.dto.v1_0.Business;

public class BusinessMockDataUtil {
    public static Business buildBusiness() {
        Business to = new Business();
        to.setName("Business A");
        to.setCustomerName("Customer A");
        to.setPhoneNumber("0948854268");
        to.setEmail("BusinessA@gmail.com");
        to.setBusinessAddress("HaiPhong");
        to.setFieldOperations("FieldOperatotion");
        return to;
    }


}
