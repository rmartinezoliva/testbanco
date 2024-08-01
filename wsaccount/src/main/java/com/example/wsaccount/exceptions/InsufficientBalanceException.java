package com.example.wsaccount.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("Saldo no está disponible");
    }
}
