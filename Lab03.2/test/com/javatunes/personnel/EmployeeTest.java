package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee employee1;
    private Employee employee2;

    @Before
    public void setUp() {
       employee1 = new SalariedEmployee("Jay", Date.valueOf("1990-08-24"));
       employee2 = new SalariedEmployee("Jay", Date.valueOf("1990-08-24"));
    }

    @Test
    public void equals_shouldReturnTrue_sameName_sameHireDate() {
        assertEquals(employee1, employee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        employee2.setHireDate(Date.valueOf("2001-01-01"));
        assertNotEquals(employee1, employee2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        employee2.setName("Martina");
        assertNotEquals(employee1, employee2);
    }
}