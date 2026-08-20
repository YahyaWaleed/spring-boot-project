package com.yahya.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProjectRequest {
    @NotBlank(message = "Project name cannot be blank")
    private String name;

    @NotBlank(message = "Project description cannot be blank")
    private String description;

    @NotNull(message = "Project Start Date cannot be null")
    private LocalDate startDate;

    private LocalDate endDate;

    @NotNull(message = "Manager ID cannot be null")
    private Integer managerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
