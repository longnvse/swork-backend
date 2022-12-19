package com.swork.core.project.rest.test.mockdata;

import com.swork.core.project.rest.dto.v1_0.Manage;
import com.swork.core.project.rest.dto.v1_0.Project;

import java.util.Date;

public class ManageMockDataUtil {
    public static Manage buildManage() {
        Manage to = new Manage();
        to.setMemberId(1L);
        return to;

    }
}
