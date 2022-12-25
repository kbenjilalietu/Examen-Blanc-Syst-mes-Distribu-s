package com.example.immatriculationservice.immatriculationCommands.controllers;


import lombok.AllArgsConstructor;
import com.example.commonapi.commands.CreateVehiculeCommand;
import com.example.commonapi.commands.UpdateVehiculeCommand;
import com.example.commonapi.dtos.CreateVehiculeRequestDTO;
import com.example.commonapi.dtos.UpdateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/vehicule/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class VehiculeCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody CreateVehiculeRequestDTO request) {
        return commandGateway.send(new CreateVehiculeCommand(
                UUID.randomUUID().toString(),
                request.getMatricule(),
                request.getMarque(),
                request.getModele(),
                request.getPuissanceFiscale(),
                request.getProprietaireId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> update(@RequestBody UpdateVehiculeRequestDTO request) {
        return commandGateway.send(new UpdateVehiculeCommand(
                request.getId(),
                request.getMatricule(),
                request.getMarque(),
                request.getModele(),
                request.getPuissanceFiscale(),
                request.getProprietaireId()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }





}
