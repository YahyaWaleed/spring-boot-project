package com.yahya.project.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

// this DTO is used to help in assigning employees by their ids to a specefic task
public class AssignEmployeeRequest {

    @NotEmpty(message = "Must pass in the IDs of the employees")
    List<Integer> employeesId;

    public List<Integer> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(List<Integer> employeesId) {
        this.employeesId = employeesId;
    }
}
