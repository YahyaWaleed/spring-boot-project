package com.yahya.project.exception;

import java.time.LocalDate;

public class ErrorResponse {

    private LocalDate timestamp;
    private String message;
    private  int  statusCode;

    ErrorResponse(int statusCode, String message) {
        this.timestamp = LocalDate.now();
        this.statusCode = statusCode;
        this.message = message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
