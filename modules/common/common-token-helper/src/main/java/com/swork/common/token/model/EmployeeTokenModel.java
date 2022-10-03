package com.swork.common.token.model;

import java.util.ArrayList;

public class EmployeeTokenModel {
    private String employeeCode;
    private DepartmentTokenModel department;
    private ArrayList<PositionTokenModel> positions;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public DepartmentTokenModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentTokenModel department) {
        this.department = department;
    }

    public ArrayList<PositionTokenModel> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<PositionTokenModel> positions) {
        this.positions = positions;
    }
}
