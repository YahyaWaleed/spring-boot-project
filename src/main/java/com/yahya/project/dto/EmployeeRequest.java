package com.yahya.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    @Email(message = "Enter a valid Email")  // ensures that the input is email
    private String email;

    @NotNull(message = "Department ID cannot be null")
    private Integer departmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
