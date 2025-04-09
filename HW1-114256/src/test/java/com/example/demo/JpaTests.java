package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entities.FoodFacility;
import com.example.demo.entities.Meal;
import com.example.demo.entities.Reservation;
import com.example.demo.repositories.FacilityRepository;
import com.example.demo.repositories.MealRepository;
import com.example.demo.repositories.ReservationRepository;

@DataJpaTest
public class JpaTests {
    
    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @AfterEach
    void resetJpa(){
        reservationRepository.deleteAll();
        mealRepository.deleteAll();
        facilityRepository.deleteAll();
    }

    @Test
    void assertFacilityIsCreated() {
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        facilityRepository.save(facility);
        assertEquals(1, facilityRepository.count());
        FoodFacility facilityFound = facilityRepository.findById(facility.getId()).orElse(null);
        assertEquals(facility.getId(), facilityFound.getId());
    }

    @Test
    void assertMealIsCreated() {
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        facilityRepository.save(facility);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        mealRepository.save(meal);
        assertEquals(1, mealRepository.count());
        Meal mealFound = mealRepository.findById(meal.getId()).orElse(null);
        assertEquals(meal.getId(), mealFound.getId());
    }

    @Test
    void assertReservationIsCreated() {
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        facilityRepository.save(facility);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        mealRepository.save(meal);
        Reservation reservation = new Reservation("neorabbit", "neorabbit--Cantina Santiago--Massa com almôndegas", meal);
        reservationRepository.save(reservation);
        assertEquals(1, reservationRepository.count());
        Reservation reservationFound = reservationRepository.findById(reservation.getId()).orElse(null);
        assertEquals(reservation.getId(), reservationFound.getId());
    }

    @Test
    void testMealFindByPrice(){
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        facilityRepository.save(facility);
        Meal meal1 = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Meal meal2 = new Meal("Arroz de marisco", 3.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        mealRepository.save(meal1);
        mealRepository.save(meal2);
        List<Meal> cheapMeals = mealRepository.findByPriceLessThanEqual(3.0);
        assertEquals(1, cheapMeals.size());
        assertEquals("Massa com almôndegas", cheapMeals.get(0).getMeal());
    }

    @Test
    void testReservationFindByToken(){
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        facilityRepository.save(facility);
        Meal meal1 = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Meal meal2 = new Meal("Arroz de marisco", 3.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        mealRepository.save(meal1);
        mealRepository.save(meal2);
        Reservation reservation1 = new Reservation("neorabbit", "neorabbit--Cantina Santiago--Massa com almôndegas", meal1);
        Reservation reservation2 = new Reservation("nextuser", "nextuser--Cantina Santiago--Arroz de marisco", meal2);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        Reservation reservationFound = reservationRepository.findByToken("nextuser--Cantina Santiago--Arroz de marisco");
        assertEquals("nextuser", reservationFound.getUsername());
        assertEquals(meal2.getId(), reservationFound.getMeal().getId());
    }
}
