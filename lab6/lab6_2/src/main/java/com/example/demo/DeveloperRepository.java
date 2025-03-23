package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    List<Developer> findByName(String name);
    List<Developer> findByEmail(String email);
}
