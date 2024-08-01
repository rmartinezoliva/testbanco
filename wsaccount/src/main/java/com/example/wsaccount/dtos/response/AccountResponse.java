package com.example.wsaccount.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AccountResponse {
    private UUID id;
    private String entidad;

    private String numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Long clienteid;

    private Boolean estado;

    private String clienteNombre;
}
