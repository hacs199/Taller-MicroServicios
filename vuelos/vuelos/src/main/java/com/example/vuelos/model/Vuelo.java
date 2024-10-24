package com.example.vuelos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ordens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroVuelo;
    private String origen;
    private String destino;
    private String horaSalida;
}
