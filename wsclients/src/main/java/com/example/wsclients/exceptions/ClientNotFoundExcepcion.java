package com.example.wsclients.exceptions;

public class ClientNotFoundExcepcion extends RuntimeException{
    public ClientNotFoundExcepcion(String mensaje) {
        super(mensaje);
    }
}
