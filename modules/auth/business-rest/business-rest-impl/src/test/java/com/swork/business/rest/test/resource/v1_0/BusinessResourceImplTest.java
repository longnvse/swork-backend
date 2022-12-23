package com.swork.business.rest.test.resource.v1_0;

import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.resource.v1_0.BusinessResourceImpl;
import com.swork.business.rest.internal.service.BusinessService;
import com.swork.business.rest.internal.validator.BusinessValidator;
import com.swork.business.rest.test.mockdata.BusinessMockDataUtil;
import com.swork.common.token.helper.api.CommonTokenHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class BusinessResourceImplTest {

    @Mock
    BusinessResourceImpl businessResource;

    @Test
    public void testPostBusiness() throws Exception {
        Business business= BusinessMockDataUtil.buildBusiness();
        businessResource.putBusiness(1L,business);
    }

    @Test
    public void testDeleteBusiness() throws Exception {
        businessResource.deleteBusiness(1L);
    }

    @Test
    public void testGetBusiness() throws Exception {
        businessResource.getBusiness(1L);
    }

    @Test
    public void testPutBusiness() throws Exception {
        Business business= BusinessMockDataUtil.buildBusiness();
        businessResource.putBusiness(1L,business);
    }

    @Test
    public void testApprovalBusiness() throws Exception {
        businessResource.approvalBusiness(1L, Business.Status.ACTIVE.getValue());
    }
}
