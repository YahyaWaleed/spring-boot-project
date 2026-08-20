package com.yahya.project.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskStatusRequest {

    @NotBlank(message = "Task status cannot be blank")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
