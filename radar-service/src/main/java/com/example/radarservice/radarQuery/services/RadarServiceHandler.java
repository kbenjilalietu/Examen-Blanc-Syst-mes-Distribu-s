package com.example.radarservice.radarQuery.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.commonapi.events.RadarCreatedEvent;
import com.example.commonapi.query.GetAllRadarsQuery;
import com.example.radarservice.radarQuery.entities.Radar;
import com.example.radarservice.radarQuery.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongtitude(event.getLongtitude());
        radar.setMaxVitesse(event.getMaxVitesse());
        radarRepository.save(radar);
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }
}
