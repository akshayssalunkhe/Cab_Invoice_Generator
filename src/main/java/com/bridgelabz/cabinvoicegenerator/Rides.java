package com.bridgelabz.cabinvoicegenerator;

public class Rides {
    //FIELDS
    public double travelDistanceInKM;
    public double travelTimeInMinutes;
    RideType rideType;

    //PARAMETRISED CONSTRUCTOR
    public Rides(double travelDistanceInKM, double travelTimeInMinutes, RideType rideType) {
        this.travelDistanceInKM = travelDistanceInKM;
        this.travelTimeInMinutes = travelTimeInMinutes;
        this.rideType = rideType;
    }
}