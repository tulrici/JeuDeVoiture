package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
} 