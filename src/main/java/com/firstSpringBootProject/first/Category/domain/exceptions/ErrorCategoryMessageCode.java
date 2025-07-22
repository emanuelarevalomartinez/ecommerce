package com.firstSpringBootProject.first.Category.domain.exceptions;


public enum ErrorCategoryMessageCode {
    CATEGORY_CONFLICT( 409, "CategoryConflict", "El nombre de la categoria ya está en uso: "),
    CATEGORY_NOT_FOUND_ID( 404, "CategoryNotFound", "Categoria con id no encontrado: "),
    CATEGORY_PERSISTENCE_ERROR(400, "CategoryPersistenceError", "Error de integridad de datos");

    private final String message;
    private final String type;
    private final int status;

    ErrorCategoryMessageCode(int status, String type, String message) {
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
    // este metodo final se invoca asi --> throw ErrorCode.USERNAME_CONFLICT.toException(username);
}

