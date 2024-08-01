package com.example.wsclients.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long clienteid;

    private String contrasenna;

    private Boolean estado;
}
