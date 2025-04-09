package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByToken(String token);
}
