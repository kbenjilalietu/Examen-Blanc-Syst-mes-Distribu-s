package com.example.commonapi.commands;

public class UpdateRadarCommand  extends BaseCommand<String>{
    private double MaxVitesse ;
    private double longtitude ;
    private  double latitude ;

    public UpdateRadarCommand(String id, double maxVitesse, double longtitude, double latitude) {
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
