package com.emazon.api.stock.infrastructure.exception;

import com.emazon.api.stock.domain.exception.BrandNullPointerException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log
public class ErrorHandler {

    public static final String INTERNAL_ERROR_CUSTOM_MESSAGE = "No puede ser null el campo nombre";



    @ExceptionHandler({ BrandNullPointerException.class })
    public ResponseEntity<Object> handleGlobalException(BrandNullPointerException exception) {
        CustomError error = new CustomError();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMsg("BrandNullException exception thrown " + exception.getLocalizedMessage());
        return ResponseEntity
                .status(error.getErrorCode())
                .body(error);
        }


}
