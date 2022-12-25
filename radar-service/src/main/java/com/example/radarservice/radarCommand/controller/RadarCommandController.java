package com.example.radarservice.radarCommand.controller;

import com.example.commonapi.commands.CreateRadarCommand;
import com.example.commonapi.commands.UpdateRadarCommand;
import lombok.AllArgsConstructor;
import com.example.commonapi.dtos.CreateRadarRequestDTO;
import com.example.commonapi.dtos.UpdateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/radar/commands")
@AllArgsConstructor

public class RadarCommandController {
    private CommandGateway commandGateway ;
    private EventStore eventStore ;

    @PostMapping("/createRadar")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO createRadarRequestDTO){
        return  commandGateway.send(
                new CreateRadarCommand(
                                UUID.randomUUID().toString(),
                                createRadarRequestDTO.getMaxVitesse(),
                                createRadarRequestDTO.getLongtitude(),
                                createRadarRequestDTO.getLatitude()
                ));
    }

    @PutMapping("/updateRadar")
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadarRequestDTO updateRadarRequestDTO){
        return commandGateway.send(
                new UpdateRadarCommand(
                        updateRadarRequestDTO.getId(),
                        updateRadarRequestDTO.getMaxVitesse(),
                        updateRadarRequestDTO.getLongtitude(),
                        updateRadarRequestDTO.getLatitude()
                )
        ) ;
    }
    @GetMapping("/eventStore/{radarId}")
    public Stream getEventsForAccount(@PathVariable(value = "radarId") String radarId) {
        return eventStore.readEvents(radarId).asStream();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }


}
