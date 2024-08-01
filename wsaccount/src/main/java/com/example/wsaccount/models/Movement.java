package com.example.wsaccount.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Movement {

    @Id
    private UUID id;
    private String entidad;
    private String tipoMovimiento;
    private Double saldo;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDateTime fecha;



}
