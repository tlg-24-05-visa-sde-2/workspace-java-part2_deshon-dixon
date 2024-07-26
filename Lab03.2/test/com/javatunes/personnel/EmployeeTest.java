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
       employee1 = getEmployee();

       employee2 = getEmployee();
    }

    private static Employee getEmployee() {
        return new Employee("Jay", Date.valueOf("1990-08-24")) {
            public double pay() { return 0; }
            public double payTaxes() { return 0; }
        };
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

    // NAMED, MEMBER-LEVEL INNER CLASSES
    // this is called a "mock" - a "fake" business type just for testing
    private static class DummyEmployee extends Employee {

        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}