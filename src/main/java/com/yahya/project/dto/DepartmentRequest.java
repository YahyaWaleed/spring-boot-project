package com.yahya.project.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequest {

    @NotBlank(message = "Department name cannot be blank")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
