package com.example.demo;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.BookingController;
import com.example.demo.entities.FoodFacility;
import com.example.demo.entities.Meal;
import com.example.demo.entities.Reservation;
import com.example.demo.services.BookingService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
public class ControllerTests {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookingService bookingService;

    @Test
    void testListMeals() throws Exception{
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal1 = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Meal meal2 = new Meal("Arroz de marisco", 3.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        List<Meal> meals = Arrays.asList(meal1, meal2);

        when(bookingService.findAllMeals()).thenReturn(meals);
        mvc.perform(
            get("").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].meal", is(meal1.getMeal())))
            .andExpect(jsonPath("$[1].meal", is(meal2.getMeal())));
    }

    @Test
    void testCreateReservation() throws Exception {
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Reservation reservation = new Reservation("neorabbit", meal);
        Reservation reservationCreated = new Reservation("neorabbit", "neorabbit--Cantina Santiago--Massa com almôndegas", meal);

        when(bookingService.createReservation(Mockito.any())).thenReturn(reservationCreated);

        mvc.perform(
            post("").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(reservation)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.token", is(reservationCreated.getToken())))
            .andExpect(jsonPath("$.meal.meal", is(meal.getMeal())))
            .andExpect(jsonPath("$.meal.facility.name", is(facility.getName())));
    }

    @Test
    void testGetReservation() throws Exception {
        FoodFacility facility = new FoodFacility("Cantina Santiago",0,0);
        Meal meal = new Meal("Massa com almôndegas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0) ,facility);
        Reservation reservation = new Reservation("neorabbit", "neorabbit--Cantina Santiago--Massa com almôndegas", meal);

        when(bookingService.getReservationById(Mockito.any())).thenReturn(reservation);

        mvc.perform(
            get("/{id}","1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.token", is(reservation.getToken())));
    }
}
