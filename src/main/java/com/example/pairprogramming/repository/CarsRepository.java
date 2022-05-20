package com.example.pairprogramming.repository;

import com.example.pairprogramming.Entity.Cars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {
}
