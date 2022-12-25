package com.example.infractionservice.infractionQuery.controllers;


import lombok.AllArgsConstructor;
import com.example.commonapi.query.GetAllInfractionsQuery;
import com.example.commonapi.query.GetInfractionById;
import com.example.infractionservice.infractionQuery.entities.Infraction;
import com.example.infractionservice.infractionQuery.repositories.InfractionRepository;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infraction/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class InfractionQueryController {
    private QueryGateway queryGateway;
    private InfractionRepository infractionRepository;

    @GetMapping("/getAllInfractions")
    public List<Infraction> getAllInfractions(){
        return queryGateway.query(new GetAllInfractionsQuery(),
                ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }

    @QueryHandler
    public List<Infraction> on(GetAllInfractionsQuery query){
        return infractionRepository.findAll();
    }

    @GetMapping("/getInfraction/{id}")
    public Infraction getInfraction(@PathVariable String id){
        return queryGateway.query(new GetInfractionById(id),
                ResponseTypes.instanceOf(Infraction.class)).join();
    }

    @QueryHandler
    public Infraction on(GetInfractionById query){
        return infractionRepository.findById(query
                .getId()).get();
    }
}
