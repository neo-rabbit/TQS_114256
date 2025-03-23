package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class DemoApplicationTests6_2 {
	
	@Container
	public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:12")
		.withUsername("neorabbit")
		.withPassword("abc")
		.withDatabaseName("test");

	//@Autowired
	//private DeveloperRepository devRepo;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Test
	void contextLoads(){
		System.out.println("Tests were successful");
	}
}
