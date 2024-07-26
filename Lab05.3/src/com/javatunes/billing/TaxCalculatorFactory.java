package com.javatunes.billing;

public class TaxCalculatorFactory {

    private TaxCalculatorFactory() {

    }

    // no instantiation from outside, this is an all-static class
    public static TaxCalculator createTaxCalculator(Location location) {
        TaxCalculator calc = switch (location) {
            case ONLINE -> new OnlineTax();
            case USA -> new USATax();
            case EUROPE -> new EuropeTax();
        };
        return calc;
    }
}