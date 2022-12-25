package com.example.commonapi.events;

public class RadarCreatedEvent extends BaseEvent<String> {
    private double MaxVitesse ;
    private double longtitude ;
    private  double latitude ;

    public RadarCreatedEvent(String id, double maxVitesse, double longtitude, double latitude) {
        super(id);
        MaxVitesse = maxVitesse;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public double getMaxVitesse() {
        return MaxVitesse;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
