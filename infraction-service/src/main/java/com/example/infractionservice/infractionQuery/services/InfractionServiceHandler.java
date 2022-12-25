package com.example.infractionservice.infractionQuery.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.commonapi.events.InfractionCreatedEvent;
import com.example.commonapi.events.InfractionUpdatedEvent;
import com.example.infractionservice.infractionQuery.entities.Infraction;
import com.example.infractionservice.infractionQuery.repositories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionServiceHandler {
    private  InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent event){
        log.info("**************************");
        log.info("InfractionCreatedEvent received");
        Infraction infraction = new Infraction();
        infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setMontant(event.getMontant());
        infraction.setVehiculeId(event.getVehiculeId());
        infraction.setRadarId(event.getRadarId());
        infractionRepository.save(infraction);
    }

    @EventHandler
    public void on(InfractionUpdatedEvent event){
        log.info("**************************");
        log.info("InfractionUpdatedEvent received");
        Infraction infraction = infractionRepository.findById(event.getId()).get();
        infraction.setDate(event.getDate());
        infraction.setMontant(event.getMontant());
        infraction.setVehiculeId(event.getVehiculeId());
        infraction.setRadarId(event.getRadarId());
        infractionRepository.save(infraction);
    }
}
