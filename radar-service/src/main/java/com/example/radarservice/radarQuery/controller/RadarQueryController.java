package com.example.radarservice.radarQuery.controller;

import com.example.commonapi.query.GetAllRadarsQuery;
import com.example.commonapi.query.GetRadarById;
import com.example.radarservice.radarQuery.entities.Radar;
import com.example.radarservice.radarQuery.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/radar/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class RadarQueryController {
    private QueryGateway queryGateway;
    private RadarRepository radarRepository;

    @GetMapping("/getAllRadars")
    public List<Radar> getAllRadars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(Radar.class)).join();
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @GetMapping("/getRadar/{id}")
    public Radar getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarById(id),
                ResponseTypes.instanceOf(Radar.class)).join();
    }

    @QueryHandler
    public Radar on(GetRadarById query){
        return radarRepository.findById(query
                .getId()).get();
    }
}
