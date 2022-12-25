package com.example.radarservice.radarQuery.repositories;

import com.example.radarservice.radarQuery.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {

}