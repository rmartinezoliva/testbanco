package com.example.wsclients.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ClientCreateRequest {

    private String id = UUID.randomUUID().toString();
    @NotEmpty(message = "El campo nombre es obligatorio.")
    private String nombre;

    @NotEmpty(message = "El campo genero es obligatorio.")
    private String genero;

    @NotNull(message = "El campo edad es obligatorio.")
    private Integer edad;

    @NotEmpty(message = "El campo identificacion es obligatorio..")
    private String identificacion;

    @NotEmpty(message = "El campo direccion es obligatorio..")
    private String direccion;

    @NotEmpty(message = "El campo telefono es obligatorio..")
    private String telefono;

    @NotNull(message = "El campo estado es obligatorio..")
    private Boolean estado;

    @NotEmpty(message = "El campo contrasenna es obligatorio..")
    private String contrasenna;

}
