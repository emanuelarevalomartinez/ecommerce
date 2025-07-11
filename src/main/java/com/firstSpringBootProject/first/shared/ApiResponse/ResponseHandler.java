package com.firstSpringBootProject.first.shared.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> generateResponse(
            HttpStatus status, String type, String message, T responseObj) {

        ApiResponse<T> response = new ApiResponse<>(
                status.value(), type, message, responseObj
        );

        return new ResponseEntity<>(response, status);
    }
}
