package com.firstSpringBootProject.first.shared.ApiResponse;

public class ApiResponse<T> {
    private int status;
    private String type;
    private String message;
    private T data;

    public ApiResponse(int status, String type, String message, T data) {
        this.status = status;
        this.type = type;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

