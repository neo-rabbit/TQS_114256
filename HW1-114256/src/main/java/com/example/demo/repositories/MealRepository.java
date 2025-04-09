package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByPriceLessThanEqual(Double price);
}
