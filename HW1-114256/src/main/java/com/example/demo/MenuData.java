package com.example.demo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entities.FoodFacility;
import com.example.demo.entities.Meal;

public class MenuData {
    static FoodFacility facility1 = new FoodFacility("Cantina Crasto", 0, 0);
	static FoodFacility facility2 = new FoodFacility("Cantina ESTGA", 0, 0);
    static FoodFacility facility3 = new FoodFacility("Cantina Santiago", 0, 0);
    static FoodFacility facility4 = new FoodFacility("Restaurante Universitário", 0, 0);
    static FoodFacility facility5 = new FoodFacility("Campi Grelhados", 0, 0);
    static FoodFacility facility6 = new FoodFacility("Restaurante Vegetariano", 0, 0);
    static FoodFacility facility7 = new FoodFacility("Campi TrêsDê", 0, 0);
	public static List<FoodFacility> facilities = Arrays.asList(facility1, facility2, facility3, facility4, facility5, facility6, facility7);

	//Cantina Santiago
	static Meal meal3_1 = new Meal("Vitela à portuguesa com vinho do porto e arroz", 2.65, LocalDateTime.of(2025, 4, 7, 12, 0), facility3);
    static Meal meal3_2 = new Meal("Dourada grelhada com alecrim e batata cozida", 2.65, LocalDateTime.of(2025, 4, 7, 12, 0), facility3);
    static Meal meal3_3 = new Meal("Chili vegetariano e arroz integral", 2.65, LocalDateTime.of(2025, 4, 7, 12, 0), facility3);
	static Meal meal3_4 = new Meal("Marmota frita e arroz de tomate malandro", 2.65, LocalDateTime.of(2025, 4, 7, 19, 0), facility3);
    static Meal meal3_5 = new Meal("Tofu à Gomes de Sá e batata", 2.65, LocalDateTime.of(2025, 4, 7, 19, 0), facility3);
    static Meal meal3_6 = new Meal("Espetadas de peru e arroz de ervilhas", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0), facility3);
    static Meal meal3_7 = new Meal("Lombos de perca panados e salada russa", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0), facility3);
    static Meal meal3_8 = new Meal("Ratatuille e batata cozida", 2.65, LocalDateTime.of(2025, 4, 8, 12, 0), facility3);
    static Meal meal3_9 = new Meal("Arroz com frango", 2.65, LocalDateTime.of(2025, 4, 8, 19, 0), facility3);
    static Meal meal3_10 = new Meal("Strogonoff de seitan e millet", 2.65, LocalDateTime.of(2025, 4, 8, 19, 0), facility3);
    static Meal meal3_11 = new Meal("Feijoada à brasileira com arroz e couve mineira", 2.65, LocalDateTime.of(2025, 4, 9, 12, 0), facility3);
    static Meal meal3_12 = new Meal("Omelete de camarão e batata frita", 2.65, LocalDateTime.of(2025, 4, 9, 12, 0), facility3);
    static Meal meal3_13 = new Meal("Feijoada de legumes e arroz integral", 2.65, LocalDateTime.of(2025, 4, 9, 12, 0), facility3);
    static Meal meal3_14 = new Meal("Fricassé de lulas e puré de batata", 2.65, LocalDateTime.of(2025, 4, 9, 19, 0), facility3);
    static Meal meal3_15 = new Meal("Caril de soja e arroz integral", 2.65, LocalDateTime.of(2025, 4, 9, 19, 0), facility3);
    static Meal meal3_16 = new Meal("Costeletas de porco com massa esparguete e molho de tomate", 2.65, LocalDateTime.of(2025, 4, 10, 12, 0), facility3);
    static Meal meal3_17 = new Meal("Bacalhau com broa e batata assada", 2.65, LocalDateTime.of(2025, 4, 10, 12, 0), facility3);
    static Meal meal3_18 = new Meal("Tofu panado com massa esparguete integral e molho de tomate", 2.65, LocalDateTime.of(2025, 4, 10, 12, 0), facility3);
    static Meal meal3_19 = new Meal("Coelho de churrasco e arroz de miúdos", 2.65, LocalDateTime.of(2025, 4, 10, 19, 0), facility3);
    static Meal meal3_20 = new Meal("Risoto de cogumelos e arroz integral", 2.65, LocalDateTime.of(2025, 4, 10, 19, 0), facility3);
    static Meal meal3_21 = new Meal("Bolonhesa de vitela e massa esparguete", 2.65, LocalDateTime.of(2025, 4, 11, 12, 0), facility3);
    static Meal meal3_22 = new Meal("Perca com ervilhas, presunto e batata", 2.65, LocalDateTime.of(2025, 4, 11, 12, 0), facility3);
    static Meal meal3_23 = new Meal("Jardineira de seitan e batata", 2.65, LocalDateTime.of(2025, 4, 11, 12, 0), facility3);
    static Meal meal3_24 = new Meal("Maruca gratinada e puré de batata", 2.65, LocalDateTime.of(2025, 4, 11, 19, 0), facility3);
    static Meal meal3_25 = new Meal("Hambúrguer e batata frita", 2.65, LocalDateTime.of(2025, 4, 11, 19, 0), facility3);
	public static List<Meal> meals3 = Arrays.asList(meal3_1,meal3_2,meal3_3,meal3_4,meal3_5,meal3_6,meal3_7,meal3_8,meal3_9,meal3_10,meal3_11,meal3_12,meal3_13,meal3_14,meal3_15,meal3_16,meal3_17,meal3_18,meal3_19,meal3_20,meal3_21,meal3_22,meal3_23,meal3_24,meal3_25);
}
