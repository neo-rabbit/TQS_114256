package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.*;
import com.example.demo.services.BookingService;

@RestController
@RequestMapping
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Meal>> listMeals(){
        List<Meal> meals = bookingService.findAllMeals();
        return ResponseEntity.ok(meals);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation savedReservation = bookingService.createReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id){
        Reservation reservation = bookingService.getReservationById(id);
        if(reservation == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reservation);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id){
        bookingService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }
}
