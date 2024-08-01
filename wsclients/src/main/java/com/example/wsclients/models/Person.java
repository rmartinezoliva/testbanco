package com.example.wsclients.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;


@Data
@MappedSuperclass
abstract class Person {
    @Column(unique = true)
    private UUID id;

    private String nombre;

    private String genero;

    private Integer edad;

    @Column(unique = true)
    private String identificacion;

    private String direccion;

    private String telefono;
}