package com.yahya.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TaskRequest {
    @NotBlank(message = "Task title cannot be blank")
    private String title;

    @NotBlank(message = "Task Status cannot be blank")
    private String status;

    @NotBlank(message = "Task Description cannot be blank")
    private String description;

    @NotBlank(message = "Task priority cannot be blank")
    private String priority;

    @NotNull(message = "Task must have a due date")
    private LocalDate dueDate;

    @NotNull(message = "Project ID cannot be null")
    private Integer projectId;

    @NotBlank(message = "Project Name cannot be blank")
    private String projectName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
