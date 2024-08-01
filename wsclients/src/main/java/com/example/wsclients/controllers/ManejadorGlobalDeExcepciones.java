package com.example.wsclients.controllers;

import com.example.wsclients.dtos.response.ErrorResponse;
import com.example.wsclients.exceptions.ClientNotFoundExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorGlobalDeExcepciones {
    @ExceptionHandler(ClientNotFoundExcepcion.class)
    public ResponseEntity<ErrorResponse> manejarClienteNoEncontrado(ClientNotFoundExcepcion ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(HttpStatus.NOT_FOUND.value()));
    }
}
