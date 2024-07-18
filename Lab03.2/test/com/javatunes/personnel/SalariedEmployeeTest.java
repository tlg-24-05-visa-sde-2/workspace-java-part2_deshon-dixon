package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee1;
    private SalariedEmployee salariedEmployee2;

    // SETUP METHOD
    @Before
    public void setUp() {
        salariedEmployee1 = new SalariedEmployee("Logan", Date.valueOf("2020-10-01"), 1500.0);
        salariedEmployee2 = new SalariedEmployee("Logan", Date.valueOf("2020-10-01"), 1500.0);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0,salariedEmployee1.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, salariedEmployee1.payTaxes(), 0.01);
    }

    @Test
    public void testEqualsTrue() {
        assertEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sametHireDate_sameSalary() {
        salariedEmployee2.setName("Levin");
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sametHireDate_differentSalary() {
        salariedEmployee2.setSalary(1299.0);
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        salariedEmployee2.setHireDate(Date.valueOf("2022-02-02"));
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void testHashCode() {
        assertEquals(salariedEmployee1.hashCode(), salariedEmployee2.hashCode());
    }
}