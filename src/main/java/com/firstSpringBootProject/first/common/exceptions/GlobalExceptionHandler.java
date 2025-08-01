package com.firstSpringBootProject.first.common.exceptions;

import com.firstSpringBootProject.first.Category.domain.exceptions.CategoryDomainException;
import com.firstSpringBootProject.first.Product.domain.exceptions.ProductDomainException;
import com.firstSpringBootProject.first.User.domain.exceptions.UserDomainException;
import com.firstSpringBootProject.first.shared.ApiResponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDomainException.class)
    public ResponseEntity<ApiResponse<Object>> handleDomainExceptions(UserDomainException ex) {

        int statusCode = (ex.getStatusCode() > 0) ? ex.getStatusCode() : HttpStatus.BAD_REQUEST.value();

        ApiResponse<Object> response = new ApiResponse<>(
                statusCode,
                ex.getType(),
                ex.getMessage(),
                ex.getData()
        );
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(CategoryDomainException.class)
    public ResponseEntity<ApiResponse<Object>> handleCategoryDomainExceptions(CategoryDomainException ex) {

        int statusCode = (ex.getStatusCode() > 0) ? ex.getStatusCode() : HttpStatus.BAD_REQUEST.value();

        ApiResponse<Object> response = new ApiResponse<>(
                statusCode,
                ex.getType(),
                ex.getMessage(),
                ex.getData()
        );
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(ProductDomainException.class)
    public ResponseEntity<ApiResponse<Object>> handleProductDomainExceptions(ProductDomainException ex) {

        int statusCode = (ex.getStatusCode() > 0) ? ex.getStatusCode() : HttpStatus.BAD_REQUEST.value();

        ApiResponse<Object> response = new ApiResponse<>(
                statusCode,
                ex.getType(),
                ex.getMessage(),
                ex.getData()
        );
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> Map.of(
                        "field", fieldError.getField(),
                        "message", fieldError.getDefaultMessage()
                ))
                .toList();

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                "ValidationError",
                "Los datos enviados no son válidos",
                Map.of("errors", errors)
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmptyOrInvalidDtoBody(HttpMessageNotReadableException ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                "InvalidRequestBody",
                "El cuerpo de la solicitud está vacío o mal formado",
                Map.of("error", ex.getMessage())
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleUnexpected(Exception ex) {
        ApiResponse<Map<String, String>> response = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "InternalServerError",
                "Error interno no controlado",
                Map.of("exception", ex.getClass().getSimpleName())
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
