package com.example.immatriculationservice.immatriculationCommands.aggregates;

import com.example.commonapi.commands.CreateProprietaireCommand;
import com.example.commonapi.commands.UpdateProprietaireCommand;
import com.example.commonapi.events.ProprietaireCreatedEvent;
import com.example.commonapi.events.ProprietaireUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class ProprietaireAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;

    public ProprietaireAggregate() {
    }

    @CommandHandler
    public ProprietaireAggregate(CreateProprietaireCommand command) {
        AggregateLifecycle.apply(
                new ProprietaireCreatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getPrenom(),
                        command.getDdn(),
                        command.getEmail(),
                        command.getNumTel()
                )
        );
    }

    @EventSourcingHandler
    public void on(ProprietaireCreatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.prenom = event.getPrenom();
        this.ddn = event.getDdn();
        this.email = event.getEmail();
        this.numTel = event.getNumTel();
    }

    @CommandHandler
    public void handle(UpdateProprietaireCommand command) {
        AggregateLifecycle.apply(
                new ProprietaireUpdatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getPrenom(),
                        command.getDdn(),
                        command.getEmail(),
                        command.getNumTel()
                )
        );
    }

    @EventSourcingHandler
    public void on(ProprietaireUpdatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.prenom = event.getPrenom();
        this.ddn = event.getDdn();
        this.email = event.getEmail();
        this.numTel = event.getNumTel();
    }

}
