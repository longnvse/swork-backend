package com.swork.auth.department.rest.test.mockdata;

import com.swork.auth.department.rest.dto.v1_0.Department;

public class DepartmentMockDataUtil {
    public static Department buildDepartment() {
        Department to = new Department();

        to.setId(1L);
        to.setName("Department A");
        Long[] accounts = {1L,2L,3L,4L};
//        to.setAccounts(accounts);
        return to;
    }


}
