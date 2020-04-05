package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
    public static final double COST_PER_KILOMETER_IN_RS = 10;
    public static final double COST_PER_MINUTE_IN_RS = 1;
    private static final double MINIMUM_TRAVEL_FARE_IN_RS = 5;

    public static void main(String[] args) {
        System.out.println("Welcome To Cab Invoice Generator");
    }

    //METHOD TO GET TRAVEL FARE FOR MULTIPLE RIDES
    public double getTravelFare(Rides[] rides) {
        double totalTravelFareInRS = 0;
        for (Rides ride : rides) {
            totalTravelFareInRS = totalTravelFareInRS + (ride.travelDistanceInKM * COST_PER_KILOMETER_IN_RS) + (ride.travelTimeInMinutes * COST_PER_MINUTE_IN_RS);
        }
        return Math.max(totalTravelFareInRS, MINIMUM_TRAVEL_FARE_IN_RS);
    }

    //METHOD TO GET INVOICE SUMMERY
    public InvoiceSummery getInvoiceSummery(Rides[] rides) {
        double totalTravelFareInRS = getTravelFare(rides);
        return new InvoiceSummery(rides.length, totalTravelFareInRS);
    }
}