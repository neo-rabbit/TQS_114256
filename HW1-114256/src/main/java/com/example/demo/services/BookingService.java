package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.MenuData;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;

@Service
public class BookingService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Bean
	public CommandLineRunner demoData(FacilityRepository facilityRepository){
		return args -> {
			List<FoodFacility> facilities = MenuData.facilities;
    		facilityRepository.saveAll(facilities);

            List<Meal> meals3 = MenuData.meals3;
            mealRepository.saveAll(meals3);
		};
	}

    public List<Meal> findAllMeals(){
        return mealRepository.findAll();
    }

    public List<FoodFacility> findAllFacilities(){
        return facilityRepository.findAll();
    }

    public FoodFacility findFacility(Long id){
        return facilityRepository.findById(id).orElse(null);
    }

    public List<Meal> findMealsFromFacility(FoodFacility facility){
        return facility.getMeals();
    }

    public Reservation createReservation(Reservation reservation){
        reservation.setToken(
            reservation.getUsername()+"--"+
            reservation.getMeal().getFacility().getName()+"--"+
            reservation.getMeal().getMeal());
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).orElse(null);
    }

    public boolean cancelReservation(Long id){
        if (!reservationRepository.existsById(id)){
            return false;
        } else {
            reservationRepository.deleteById(id);
            return true;
        }
    }
}
