package com.example.wsaccount.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountUpdateRequest {

    @NotEmpty(message = "El campo entidad es obligatorio.")
    private String entidad;

    @NotEmpty(message = "El campo numeroCuenta es obligatorio.")
    private String numeroCuenta;

    @NotEmpty(message = "El campo tipoCuenta es obligatorio.")
    private String tipoCuenta;

    @NotNull(message = "El campo saldoInicial es obligatorio..")
    private Double saldoInicial;

    @NotNull(message = "El campo direccion es obligatorio..")
    private Long clienteid;

    @NotNull(message = "El campo estado es obligatorio..")
    private Boolean estado;

    @NotEmpty(message = "El campo clienteNombre es obligatorio..")
    private String clienteNombre;

}
