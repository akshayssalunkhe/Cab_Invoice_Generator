package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, Rides[]> rideList;

    public RideRepository() {
        this.rideList = new HashMap<>();
    }

    public void addRide(String userId, Rides[] rides) {
        rideList.put(userId, rides);
    }

    public Rides[] getRideList(String userId) throws CabInvoiceGeneratorException {
        if (userId == null)
            throw new CabInvoiceGeneratorException("Enter Valid User Id");
        if (userId.equals(rideList.get(userId)))
            return rideList.get(userId);
        else
            throw new CabInvoiceGeneratorException("Given Incorrect User Id");
    }
}