package com.example.wsaccount.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AccountCreateRequest {

    private UUID id = UUID.randomUUID();
    @NotEmpty(message = "El campo entidad es obligatorio.")
    private String entidad;

    @NotEmpty(message = "El campo numeroCuenta es obligatorio.")
    private String numeroCuenta;

    @NotEmpty(message = "El campo tipoCuenta es obligatorio.")
    private String tipoCuenta;

    @NotNull(message = "El campo saldoInicial es obligatorio..")
    private Double saldoInicial;

    @NotNull(message = "El campo estado es obligatorio..")
    private Boolean estado;

    @NotNull(message = "El campo clienteid es obligatorio..")
    private Long clienteid;

    @NotEmpty(message = "El campo clienteNombre es obligatorio..")
    private String clienteNombre;

}