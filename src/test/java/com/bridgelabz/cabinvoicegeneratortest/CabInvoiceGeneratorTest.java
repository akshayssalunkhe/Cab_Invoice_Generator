package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    //GLOBAL OBJECT
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    @Test
    public void givenDistanceAndTimeOfTravel_WhenMoreThanOneKMAndOneMinute_ShouldReturnTheTotalTravelFare() {
        Rides[] rides = {new Rides(5, 10)};
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(rides);
        Assert.assertEquals(60, totalTravelFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeOfTravel_WhenLessThanOneKMAndOneMinute_ShouldReturnMinimumFare() {
        Rides[] rides = {new Rides(0.5, 0)};
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(rides);
        Assert.assertEquals(5, totalTravelFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeOfTravelForMultipleRides_ShouldReturnTheTotalTravelFare() {
        Rides[] rides = {new Rides(0.5, 0), new Rides(5, 10)};
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(rides);
        Assert.assertEquals(65, totalTravelFare, 0.0);
    }
}