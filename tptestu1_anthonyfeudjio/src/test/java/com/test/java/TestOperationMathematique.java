package com.test.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;  // Import JUnit 5 assertions
import static org.junit.jupiter.api.Assertions.assertFalse;                // Import JUnit 5 test annotation
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.stjean.operation.IllegalParamISIException;
import com.stjean.operation.OperationMathematique;
import com.stjean.operation.OperationMathematique.Sorter;

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
    public void testFactorial() throws IllegalParamISIException {
        OperationMathematique op = new OperationMathematique();

        // Test for factorial of 5
        assertEquals(120, op.factorial(5), "Factorial of 5 should be 120");

        // Test for factorial of 0, typically 0! = 1
        assertEquals(1, op.factorial(0), "Factorial of 0 should be 1");

        // Test for factorial of 1
        assertEquals(1, op.factorial(1), "Factorial of 1 should be 1");
    }
     @Test
    public void testSort() {
        int[] input = {4, 2, 7, 1};
        int[] expectedOutput = {7, 4, 2, 1};
        assertArrayEquals(expectedOutput, Sorter.sort(input));
    }

    @Test
    public void testFactorialWithNegativeInput() {
        assertThrows(IllegalParamISIException.class, () -> {
            MathOperations.factorial(-5);
        });
    }

    @Test
    public void testMaxNumba() {
        double[] values = {3.5, 7.2, 6.8, 1.4};
        double expected = 7.2;
        assertEquals(expected, OperationMathematique.maxNumba(values), 0.001);
    }
}
