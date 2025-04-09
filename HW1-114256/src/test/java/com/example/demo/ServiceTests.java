package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import com.example.demo.services.BookingService;

@SpringBootTest
public class ServiceTests {
    
    @Mock
    private MealRepository mealRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private BookingService bookingService = new BookingService();

    @Test
    void testFindAllMeals(){
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal1 = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Meal meal2 = new Meal("Arroz de marisco", 3.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        List<Meal> meals = Arrays.asList(meal1, meal2);

        when(mealRepository.findAll()).thenReturn(meals);

        List<Meal> mealsFound = bookingService.findAllMeals();
        assertEquals(2, mealsFound.size());
        assertEquals("Massa com almôndegas", meal1.getMeal());
        assertEquals("Arroz de marisco", meal2.getMeal());
    }

    @Test
    void testCreateReservation(){
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Reservation reservation = new Reservation("neorabbit", meal);

        when(reservationRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);

        Reservation reservationCreated = bookingService.createReservation(reservation);
        assertEquals("neorabbit--Cantina Santiago--Massa com almôndegas", reservationCreated.getToken());
    }

    @Test
    void testGetReservationById(){
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Reservation reservation = new Reservation("neo-rabbit", "neo-rabbit--Cantina Santiago--Massa com almôndegas", meal);
        
        when(reservationRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(reservation));
        when(reservationRepository.findById(Long.valueOf(2))).thenReturn(Optional.empty());

        Reservation reservationFound = bookingService.getReservationById(Long.valueOf(1));
        assertNotNull(reservationFound);
        assertEquals(reservation.getToken(), reservationFound.getToken());
        Reservation reservationNotFound = bookingService.getReservationById(Long.valueOf(2));
        assertNull(reservationNotFound);
    }

    @Test
    void testCancelReservation() {
        when(reservationRepository.existsById(Long.valueOf(1))).thenReturn(true);
        when(reservationRepository.existsById(Long.valueOf(2))).thenReturn(false);

        boolean canceled = bookingService.cancelReservation(Long.valueOf(1));
        assertTrue(canceled);
        canceled = bookingService.cancelReservation(Long.valueOf(2));
        assertFalse(canceled);
    }
}
