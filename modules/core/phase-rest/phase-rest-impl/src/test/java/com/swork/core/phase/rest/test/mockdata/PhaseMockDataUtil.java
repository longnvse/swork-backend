package com.swork.core.phase.rest.test.mockdata;


import com.swork.core.phase.rest.dto.v1_0.Phase;

import java.util.Date;

public class PhaseMockDataUtil {
    public static Phase buildPhase() {
        Phase to = new Phase();
        to.setName("Phase A");
        to.setProjectId(1L);
        to.setDescription("Description");
        to.setStatus(Phase.Status.ACTIVE);
        to.setStartDate(new Date(2000,01,02));
        to.setEndDate(new Date(2003,02,02));
        Long [] manages={1L,2L,3L};
        to.setManages(manages);
        return to;
    }


}
