package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummery;
import com.bridgelabz.cabinvoicegenerator.RideType;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    //GLOBAL OBJECT
    CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

    @Test
    public void givenDistanceAndTimeOfTravel_WhenMoreThanOneKMAndOneMinute_ShouldReturnTheTotalTravelFare() {
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(RideType.NORMAL, 5, 10);
        Assert.assertEquals(60, totalTravelFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeOfTravel_WhenLessThanOneKMAndOneMinute_ShouldReturnMinimumFare() {
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(RideType.NORMAL, 0.5, 0);
        Assert.assertEquals(5, totalTravelFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeOfTravelForMultipleRides_ShouldReturnTheTotalTravelFare() {
        Rides[] rides = {new Rides(0.5, 0, RideType.NORMAL), new Rides(5, 10, RideType.PREMIUM)};
        cabInvoiceGenerator.addRides("User_NO_1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_NO_1");
        Assert.assertEquals(100, invoiceSummery.totalTravelFareInRS, 0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(0.50, 0, RideType.NORMAL), new Rides(5, 10, RideType.PREMIUM)};
        cabInvoiceGenerator.addRides("User_NO_1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_NO_1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 100);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenUserId_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(0.50, 0, RideType.NORMAL), new Rides(5, 10, RideType.PREMIUM)};
        cabInvoiceGenerator.addRides("User_No_1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_No_1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 100);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenDistanceAndTimeWithNormalRideType_GenerateTotalFare_ShouldReturnTheTotalTravelFare() {
        Rides[] rides = new Rides[]{new Rides(100, 30, RideType.NORMAL)};
        cabInvoiceGenerator.addRides("User_No_1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_No_1");
        InvoiceSummery expectedSummery = new InvoiceSummery(1, 1030);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenDistanceAndTimeWithPremiumRideType_GenerateTotalFare_ShouldReturnTheTotalTravelFare() {
        Rides[] rides = {new Rides(50, 12.5, RideType.PREMIUM)};
        cabInvoiceGenerator.addRides("User_No_2", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_No_2");
        InvoiceSummery expectedSummery = new InvoiceSummery(1, 775);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}