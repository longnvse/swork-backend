package com.swork.core.project.rest.test.mockdata;

import com.swork.core.project.rest.dto.v1_0.Project;

import java.util.Date;

public class ProjectMockDataUtil {
    public static Project buildProject() {
        Project to = new Project();
        to.setName("Phase A");
        to.setBudget(100L);
        to.setExternalReferenceCode("ABC");
        to.setDescription("Description");
        to.setCode("Code");
        to.setStartDate(new Date(2000,01,02));
        to.setEndDate(new Date(2003,02,01));
        to.setActualStartDate(new Date(2000,01,02));
        to.setActualEndDate(new Date(2003,02,01));
        to.setProgressType(Project.Status.APPROVED.getValue());
        return to;

    }

}
