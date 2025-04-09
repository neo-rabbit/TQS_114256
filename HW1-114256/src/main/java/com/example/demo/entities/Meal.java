package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meal;
    private double price;

    private LocalDateTime schedule;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private FoodFacility facility;

    @JsonIgnore
    @OneToMany(mappedBy = "meal")
    private List<Reservation> reservations;

    public Meal() {}
    public Meal(String meal, double price, LocalDateTime schedule, FoodFacility facility){
        this.meal = meal;
        this.price = price;
        this.schedule = schedule;
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }
    public String getMeal() {
        return meal;
    }
    public void setMeal(String meal) {
        this.meal = meal;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public LocalDateTime getSchedule() {
        return schedule;
    }
    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }
    public FoodFacility getFacility() {
        return facility;
    }
    public void setFacility(FoodFacility facility) {
        this.facility = facility;
    }
}
