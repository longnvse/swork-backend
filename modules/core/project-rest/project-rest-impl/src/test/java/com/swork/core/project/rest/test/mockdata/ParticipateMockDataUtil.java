package com.swork.core.project.rest.test.mockdata;

import com.swork.core.project.rest.dto.v1_0.Manage;
import com.swork.core.project.rest.dto.v1_0.Participate;

public class ParticipateMockDataUtil {
    public static Participate buildParticipate() {
        Participate to = new Participate();
        to.setMemberId(1L);
        to.setMemberType(Participate.MemberType.ACCOUNT);
        to.setMemberReferenceCode("ABC");
        return to;

    }
}
