package com.bridgelabz.cabinvoicegeneratortest;

import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTimeOfTravel_WhenMoreThanOneKMAndOneMinute_ShouldReturnTheTotalTravelFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(10, 20);
        Assert.assertEquals(120, totalTravelFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeOfTravel_WhenLessThanOneKMAndOneMinute_ShouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalTravelFare = cabInvoiceGenerator.getTravelFare(0, 0);
        Assert.assertEquals(5, totalTravelFare, 0.0);
    }
}