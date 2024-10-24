package com.example.reservas.repository;

import com.example.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reserva, Long> {
}
