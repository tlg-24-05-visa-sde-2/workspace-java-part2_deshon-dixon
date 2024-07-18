package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee;

    // SETUP METHOD
    @Before
    public void setUp() {
        salariedEmployee = new SalariedEmployee("Logan", Date.valueOf("2020-10-01"), 1500.0);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0,salariedEmployee.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, salariedEmployee.payTaxes(), 0.01);
    }


}