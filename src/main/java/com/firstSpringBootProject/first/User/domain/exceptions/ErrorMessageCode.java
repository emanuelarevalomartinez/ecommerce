package com.firstSpringBootProject.first.User.domain.exceptions;

public enum ErrorMessageCode {
    EMAIL_CONFLICT( 409, "EmailConflict", "El email ya está registrado"),
    USERNAME_CONFLICT( 409, "UsernameConflict", "El nombre de usuario ya está en uso"),
    USER_NOT_FOUND( 404, "UserNotFound", "Usuario no encontrado"),
    INVALID_CREDENTIALS(401, "AuthFailed", "Credenciales inválidas"),
    PERSISTENCE_ERROR(400, "PersistenceError", "Error de integridad de datos");

    private final String message;
    private final String type;
    private final int status;

    ErrorMessageCode(int status, String type, String message) {
        this.status = status;
        this.type = type;
        this.message = message;
    }

    public String getMessage() { return message; }
    public String getType() { return type; }
    public int getStatus() { return status; }

    public DomainException toException(Object data) {
        return new DomainException(status, type, message, data) {};
    }
    // este metodo final se invoca asi --> throw ErrorCode.USERNAME_CONFLICT.toException(username);
}
