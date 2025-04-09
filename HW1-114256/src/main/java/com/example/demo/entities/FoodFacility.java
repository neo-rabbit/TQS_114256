package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class FoodFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int latitude;
    private int longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    private List<Meal> meals;

    public FoodFacility() {}
    public FoodFacility(String name, int latitude, int longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getLongitude() {
        return longitude;
    }
    public String getName() {
        return name;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Meal> getMeals() {
        return meals;
    }
}
