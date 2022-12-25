package com.example.commonapi.commands;

import lombok.Getter;

public class CreateRadarCommand extends  BaseCommand<String>{
    @Getter  private double MaxVitesse ;
    @Getter private double longtitude ;
    @Getter  private  double latitude ;

    public CreateRadarCommand(String id, double maxVitesse, double longtitude, double latitude) {
        super(id);
        MaxVitesse = maxVitesse;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    }
