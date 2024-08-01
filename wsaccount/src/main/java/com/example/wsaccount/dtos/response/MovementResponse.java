package com.example.wsaccount.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class MovementResponse {
    private UUID id;

    private String entidad;

    private String tipoMovimiento;

    private Double saldo;

    private Double valor;

    private LocalDateTime fecha;
}
