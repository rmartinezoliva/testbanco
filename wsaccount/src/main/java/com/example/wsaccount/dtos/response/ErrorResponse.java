package com.example.wsaccount.dtos.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String mensaje;
    private int codigo;

    public ErrorResponse(String mensaje, int codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
}
