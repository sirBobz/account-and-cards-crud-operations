package com.financial.service.exceptions;

import com.financial.service.dtos.ErrorResponse;
import com.financial.service.dtos.Error;
import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Date;
import java.util.List;

public class GlobalControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {

        Error error = new Error(
                String.valueOf(500),
                e.getMessage(),
                "ERR500",
                e.toString(),
                String.valueOf(new Date()));

        ErrorResponse errorResponse = new ErrorResponse(error);

        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler({WebClientResponseException.class})
    public ResponseEntity<ErrorResponse> handleWebClientResponseException(WebClientResponseException e) {

        Error error = new Error(
                String.valueOf(e.getStatusCode().value()),
                e.getStatusCode().toString(),
                "ERR" + e.getStatusCode().value(),
                e.getResponseBodyAsString(),
                String.valueOf(new Date()));

        ErrorResponse errorResponse = new ErrorResponse(error);

        return ResponseEntity.status(e.getStatusCode().value()).body(errorResponse);
    }

    @ExceptionHandler({WebClientRequestException.class})
    public ResponseEntity<ErrorResponse> handleWebClientRequestException(WebClientRequestException e) {

        Error error = new Error(
                String.valueOf(500),
                e.getMessage(),
                "ERR500",
                e.toString(),
                String.valueOf(new Date()));

        ErrorResponse errorResponse = new ErrorResponse(error);

        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorResponse> handleException(WebExchangeBindException e) {

        List<String> detailedResponseMessage = e.getBindingResult().getAllErrors().stream()
                .map(err -> err.unwrap(ConstraintViolation.class))
                .map(err -> String.format("'%s' %s", err.getPropertyPath(), err.getMessage()))
                .toList();

        Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "ERR" + HttpStatus.BAD_REQUEST,
                detailedResponseMessage,
                String.valueOf(new Date()));

        ErrorResponse errorResponse = new ErrorResponse(error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
