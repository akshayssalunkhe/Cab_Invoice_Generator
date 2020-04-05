package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
    public static final double COST_PER_KILOMETER_IN_RS = 10;
    public static final double COST_PER_MINUTE_IN_RS = 1;
    private static final double MINIMUM_TRAVEL_FARE_IN_RS = 5;

    public static void main(String[] args) {
        System.out.println("Welcome To Cab Invoice Generator");
    }

    //METHOD TO GET TRAVEL FARE
    public double getTravelFare(double travelDistanceInKM, double travelTimeInMinutes) {
        double totalTravelFareInRS = (travelDistanceInKM * COST_PER_KILOMETER_IN_RS) + (travelTimeInMinutes * COST_PER_MINUTE_IN_RS);
        return Math.max(totalTravelFareInRS, MINIMUM_TRAVEL_FARE_IN_RS);
    }
}