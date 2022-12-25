package com.example.immatriculationservice.immatriculationQuery.repositories;


import com.example.immatriculationservice.immatriculationQuery.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
