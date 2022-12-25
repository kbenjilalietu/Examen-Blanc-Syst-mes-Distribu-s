package com.example.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateRadarRequestDTO {
    private double MaxVitesse ;
    private double longtitude ;
    private  double latitude ;
}
