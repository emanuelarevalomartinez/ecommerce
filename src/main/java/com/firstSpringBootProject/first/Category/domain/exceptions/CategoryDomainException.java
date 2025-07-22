package com.firstSpringBootProject.first.Category.domain.exceptions;

public class CategoryDomainException extends RuntimeException {

    private final String message;
    private final String type;
    private final int statusCode;
    private final Object data;

    public CategoryDomainException(int statusCode, String type, String message, Object data) {
        this.message = message;
        this.type = type;
        this.statusCode = statusCode;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getData() {
        return data;
    }
}
