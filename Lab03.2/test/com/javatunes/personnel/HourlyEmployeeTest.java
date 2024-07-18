package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @Before
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("Amilia", Date.valueOf("2010-02-02"), 37.50,25.0);
    }

    @Test
    public void testPay() {
        assertEquals(937.50, hourlyEmployee.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(234.375, hourlyEmployee.payTaxes(), .001);
    }


}