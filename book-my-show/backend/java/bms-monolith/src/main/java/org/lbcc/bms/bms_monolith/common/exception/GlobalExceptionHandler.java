package org.lbcc.bms.bms_monolith.common.exception;

import org.lbcc.bms.bms_monolith.common.constants.BMSConstants;
import org.lbcc.bms.bms_monolith.common.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGlobalException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, BMSConstants.UNEXPECTED_ERROR_MESSAGE, BMSConstants.UNEXPECTED_ERROR_CODE);
    }

    public static ResponseEntity<ApiErrorResponse> buildErrorResponse(HttpStatus status, String message, String code) {
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .message(message)
                .code(code)
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }
}
