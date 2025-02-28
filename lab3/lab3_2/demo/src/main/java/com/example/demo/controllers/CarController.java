package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Car;
import com.example.demo.services.CarManagerService;

@RestController
@RequestMapping("/api")
public class CarController {
    
    private final CarManagerService carService;

    @PostMapping("/new")
    public ResponseEntity<Car> createCar(Car car){
        HttpStatus status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = new ArrayList<>();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/find")
    public ResponseEntity<Car> getCarById(Long id){
        return ResponseEntity.notFound().build();
    }
}
