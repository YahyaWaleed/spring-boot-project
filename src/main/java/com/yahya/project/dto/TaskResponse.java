package com.yahya.project.dto;

import com.yahya.project.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public class TaskResponse {
    private String title;
    private String status;
    private String description;
    private String priority;
    private LocalDate dueDate;
    private int projectId;
    private int id;
    private String projectName;
    List<EmployeeSummary> assignedEmployees;

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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<EmployeeSummary> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<EmployeeSummary> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
