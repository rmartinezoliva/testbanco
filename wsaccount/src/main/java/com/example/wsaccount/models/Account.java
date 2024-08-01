package com.example.wsaccount.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    private UUID id;
    private String entidad;
    private String numeroCuenta;
    private String tipoCuenta;

    private Double saldoInicial;

    private Boolean estado;

    private int clienteid;

    private String clienteNombre;

}
