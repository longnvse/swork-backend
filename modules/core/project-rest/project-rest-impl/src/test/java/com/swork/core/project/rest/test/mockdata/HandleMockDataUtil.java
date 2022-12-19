package com.swork.core.project.rest.test.mockdata;

import com.swork.core.project.rest.dto.v1_0.Handle;
import com.swork.core.project.rest.dto.v1_0.Project;

import java.util.Date;

public class HandleMockDataUtil {
    public static Handle buildHandle() {
        Handle to = new Handle();
        to.setMemberId(1L);
        to.setMemberType(Handle.MemberType.ACCOUNT);
        return to;

    }

}
