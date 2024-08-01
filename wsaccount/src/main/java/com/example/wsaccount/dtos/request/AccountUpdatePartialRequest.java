package com.example.wsaccount.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountUpdatePartialRequest {

    private String entidad;

    private String numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Long clienteid;

    private Boolean estado;

    private String clienteNombre;


}
