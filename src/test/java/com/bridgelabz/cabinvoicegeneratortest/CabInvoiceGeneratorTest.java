package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.InvoiceSummery;
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

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(0.50, 0), new Rides(5, 10)};
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery(rides);
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 65);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }

    @Test
    public void givenUserId_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Rides[] rides = {new Rides(0.50, 0), new Rides(5, 10)};
        cabInvoiceGenerator.addRides("User_No_1", rides);
        InvoiceSummery invoiceSummery = cabInvoiceGenerator.getInvoiceSummery("User_No_1");
        InvoiceSummery expectedSummery = new InvoiceSummery(2, 65);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}