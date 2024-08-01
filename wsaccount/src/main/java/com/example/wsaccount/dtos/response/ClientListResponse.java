package com.example.wsaccount.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientListResponse {
    private String id;

    private String nombre;

    private String genero;

    private Integer edad;

    private String identificacion;

    private String direccion;

    private String telefono;

    private Boolean estado;

    private String contrasenna;

    private Long clienteid;
}
