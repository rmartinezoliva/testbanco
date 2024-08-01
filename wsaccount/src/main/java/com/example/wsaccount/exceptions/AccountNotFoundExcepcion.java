package com.example.wsaccount.exceptions;

public class AccountNotFoundExcepcion extends RuntimeException{
    public AccountNotFoundExcepcion(String mensaje) {
        super(mensaje);
    }
}
