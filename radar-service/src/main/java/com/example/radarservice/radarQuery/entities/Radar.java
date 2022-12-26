package com.example.radarservice.radarQuery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private double MaxVitesse;
    private double longtitude;
    private double latitude;
}
