package com.swork.business.rest.test.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.service.BusinessService;
import com.swork.business.rest.test.mockdata.BusinessMockDataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {
    @Mock
    BusinessService businessService;
    @Mock
    ServiceContext serviceContext;
    @Test
    public void testPostBusiness(){
        Business business= BusinessMockDataUtil.buildBusiness();
        businessService.postBusiness(1L,business,serviceContext);
    }
    @Test
    public void testPutBusiness(){
        Business business= BusinessMockDataUtil.buildBusiness();
        businessService.putBusiness(1L,1L,business,serviceContext);
    }

    @Test
    public void testGetBusiness() throws PortalException {
        businessService.getBusiness(1L);
    }

    @Test
    public void testDeleteBusiness() throws PortalException {
        businessService.deleteBusiness(1L);
    }

    @Test
    public void testApprovalBusiness(){
        businessService.approvalBusiness(1L,1L, Business.Status.ACTIVE.getValue(),serviceContext);
    }
}
