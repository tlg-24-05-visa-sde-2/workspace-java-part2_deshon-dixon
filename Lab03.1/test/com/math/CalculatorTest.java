/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import junit.extensions.TestSetup;
import org.junit.*;

public class CalculatorTest {
    // BUSINESS OBJECT(S) UNDER TEST - CALLED THE "FIXTURE"
    private Calculator calc;

    // SETUP METHODS
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    // TESTS
    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5, 2), .001); // expected, actual, delta
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }
}