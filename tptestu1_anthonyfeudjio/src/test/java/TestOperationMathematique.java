package com.test.java;

import static org.junit.jupiter.api.Assertions.*;  // Import JUnit 5 assertions

import org.junit.jupiter.api.Test;                // Import JUnit 5 test annotation

public class TestOperationMathematique {

    @Test
    public void testEstPositif() {
        OperationMathematique op = new OperationMathematique();

        // Test for a positive number
        assertTrue(op.estPositif(5), "5 should be positive");

        // Test for a negative number
        assertFalse(op.estPositif(-5), "-5 should not be positive");

        // Test for zero, assuming 0 is considered non-positive
        assertFalse(op.estPositif(0), "0 should not be positive");
    }

    @Test
    public void testFactorial() {
        OperationMathematique op = new OperationMathematique();

        // Test for factorial of 5
        assertEquals(120, op.factorial(5), "Factorial of 5 should be 120");

        // Test for factorial of 0, typically 0! = 1
        assertEquals(1, op.factorial(0), "Factorial of 0 should be 1");

        // Test for factorial of 1
        assertEquals(1, op.factorial(1), "Factorial of 1 should be 1");
    }
}
