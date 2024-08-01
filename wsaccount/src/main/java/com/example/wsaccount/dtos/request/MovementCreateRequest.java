package com.example.wsaccount.dtos.request;

import com.example.wsaccount.models.Account;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class MovementCreateRequest {

    private UUID id = UUID.randomUUID();
    @NotEmpty(message = "El campo entidad es obligatorio.")
    private String entidad;

    @NotEmpty(message = "El campo tipoMovimiento es obligatorio.")
    private String tipoMovimiento;

    @NotNull(message = "El campo saldo es obligatorio.")
    private Double saldo;

    @NotNull(message = "El campo valor es obligatorio..")
    private Double valor;

    @NotNull(message = "El campo fecha es obligatorio..")
    private LocalDateTime fecha;

    @NotNull(message = "El campo accountid es obligatorio..")
    private UUID accountid;
}

