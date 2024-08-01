package com.example.wsaccount.controllers;

import com.example.wsaccount.dtos.response.ErrorResponse;
import com.example.wsaccount.exceptions.AccountNotFoundExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorGlobalDeExcepciones {
    @ExceptionHandler(AccountNotFoundExcepcion.class)
    public ResponseEntity<ErrorResponse> manejarClienteNoEncontrado(AccountNotFoundExcepcion ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(HttpStatus.NOT_FOUND.value()));
    }
}
