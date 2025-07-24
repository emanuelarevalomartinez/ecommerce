package com.firstSpringBootProject.first.Product.domain.exceptions;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;

public enum ErrorProductMessageCode {
    PRODUCT_NAME_CONFLICT( 409, "ProductConflict", "El nombre del producto ya está en uso: "),
    PRODUCT_NOT_FOUND_ID( 404, "ProductNotFound", "Producto con id no encontrado: "),
    PRODUCT_PERSISTENCE_ERROR(400, "ProductPersistenceError", "Error de integridad de datos");

    private final String message;
    private final String type;
    private final int status;

    ErrorProductMessageCode(int status, String type, String message) {
        this.status = status;
        this.type = type;
        this.message = message;
    }

    public String getMessage() { return message; }
    public String getType() { return type; }
    public int getStatus() { return status; }

    public CategoryDomainException toException(Object data) {
        return new CategoryDomainException(status, type, message, data) {};
    }
}
