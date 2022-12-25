package com.example.immatriculationservice.immatriculationQuery.repositories;


import com.example.immatriculationservice.immatriculationQuery.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {
}

