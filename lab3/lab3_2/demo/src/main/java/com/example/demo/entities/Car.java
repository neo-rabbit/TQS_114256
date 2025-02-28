package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tqs_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String maker;

    private String model;

    public Car(){}
    public Car(String maker, String model){this.maker = maker; this.model = model;}

    public Long getCarId() {
        return carId;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "{'id':"+carId+",'maker:'"+maker+",'model':"+model+"}";
    }
}
