package com.example.dummy.helper.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(String message, HttpStatus httpStatus) {
    
}
