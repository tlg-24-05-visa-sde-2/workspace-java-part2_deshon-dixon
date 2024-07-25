package com.javatunes.billing;

public class TaxCalculatorFactory {

    // no instantiation from outside, this is an all-static class
    public static TaxCalculator createTaxCalculator(Location location) {
        TaxCalculator calc = null;
        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                new EuropeTax();
                break;
        };
        return calc;
    }
}