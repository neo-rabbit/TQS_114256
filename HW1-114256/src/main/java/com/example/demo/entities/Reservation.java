package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String token;
    
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    public Reservation() {}
    public Reservation(String username, Meal meal){
        this.username = username;
        this.meal = meal;
    }
    public Reservation(String username, String token, Meal meal){
        this.username = username;
        this.token = token;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }
    public Meal getMeal() {
        return meal;
    }
    public String getToken() {
        return token;
    }
    public String getUsername() {
        return username;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
