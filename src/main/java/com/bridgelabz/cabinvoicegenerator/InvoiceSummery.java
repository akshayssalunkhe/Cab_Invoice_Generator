package com.bridgelabz.cabinvoicegenerator;

import java.util.Objects;

public class InvoiceSummery {
    //FIELDS
    public int NumberOfRides;
    public double totalTravelFareInRS;
    public double averageFarePerRidesInRS;

    //CONSTRUCTOR
    public InvoiceSummery(int NumberOfRides, double totalTravelFareInRS) {
        this.NumberOfRides = NumberOfRides;
        this.totalTravelFareInRS = totalTravelFareInRS;
        this.averageFarePerRidesInRS = totalTravelFareInRS / NumberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummery summery = (InvoiceSummery) o;
        return NumberOfRides == summery.NumberOfRides &&
                Double.compare(summery.totalTravelFareInRS, totalTravelFareInRS) == 0 &&
                Double.compare(summery.averageFarePerRidesInRS, averageFarePerRidesInRS) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumberOfRides, totalTravelFareInRS, averageFarePerRidesInRS);
    }
}