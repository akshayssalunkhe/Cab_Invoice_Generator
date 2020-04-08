package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    //CONSTANTS
    public static double COST_PER_KILOMETER_IN_RS;
    public static double COST_PER_MINUTE_IN_RS;
    private static double MINIMUM_TRAVEL_FARE_IN_RS;
    RideRepository rideRepository;

    public CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Cab Invoice Generator");
    }

    //METHOD TO GET TRAVEL FARE
    public double getTravelFare(RideType rideType, double distance, double time) {
        setValue(rideType);
        double totalTravelFareInRS = distance * COST_PER_KILOMETER_IN_RS + time * COST_PER_MINUTE_IN_RS;
        return Math.max(totalTravelFareInRS, MINIMUM_TRAVEL_FARE_IN_RS);
    }

    //METHOD TO SET THE RATE OF RIDE CATEGORY
    private void setValue(RideType rideType) {
        COST_PER_KILOMETER_IN_RS = rideType.costPerKilometerInRs;
        COST_PER_MINUTE_IN_RS = rideType.costPerMinuteInRs;
        MINIMUM_TRAVEL_FARE_IN_RS = rideType.minimumTravelFareInRs;
    }

    //METHOD TO GET INVOICE SUMMERY BY PASSING USER ID
    public InvoiceSummery getInvoiceSummery(String userId) throws CabInvoiceGeneratorException {
        return generateInvoiceSummery(rideRepository.getRideList(userId));
    }

    //METHOD TO GENERATE INVOICE SUMMERY
    private InvoiceSummery generateInvoiceSummery(Rides[] rideList) {
        double totalTravelFareInRS = 0;
        for (Rides rides : rideList) {
            totalTravelFareInRS = totalTravelFareInRS + getTravelFare(rides.rideType, rides.travelDistanceInKM, rides.travelTimeInMinutes);
        }
        return new InvoiceSummery(rideList.length, totalTravelFareInRS);
    }

    //METHOD TO ADD RIDE LIST
    public void addRides(String userId, Rides[] rides) {
        rideRepository.addRide(userId, rides);
    }
}