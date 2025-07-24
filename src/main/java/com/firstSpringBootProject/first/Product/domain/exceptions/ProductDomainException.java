package com.firstSpringBootProject.first.Product.domain.exceptions;

public class ProductDomainException extends RuntimeException {

    private final String message;
    private final String type;
    private final int statusCode;
    private final Object data;

    public ProductDomainException(int statusCode, String type, String message, Object data) {
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
