package com.project.codemic.Codemic.util;

import com.project.codemic.Codemic.model.response.ErrorResponse;
import com.project.codemic.Codemic.model.response.SuccessResponse;
import org.springframework.http.HttpStatus;

public class ResponseUtils {

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message) {
        SuccessResponse<T> response = new SuccessResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);

        return response;
    }

    public static <T> SuccessResponse<T> buildSuccessResponse(HttpStatus status, String message, T data) {
        SuccessResponse<T> response = new SuccessResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message) {
        ErrorResponse<T> response = new ErrorResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);

        return response;
    }

    public static <T> ErrorResponse<T> buildErrorResponse(HttpStatus status, String message, T data) {
        ErrorResponse<T> response = new ErrorResponse<>();
        response.setStatusCode(status.value());
        response.setMessage(message);
        response.setData(data);

        return response;
    }
}
