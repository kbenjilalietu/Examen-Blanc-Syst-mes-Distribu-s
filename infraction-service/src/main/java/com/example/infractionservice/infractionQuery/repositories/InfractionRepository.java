package com.example.infractionservice.infractionQuery.repositories;

import com.example.infractionservice.infractionQuery.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,String> {

}
