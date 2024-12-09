package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Lab12.SumOfDigits;

public class SumOfDigitsTest {

    @Test
    public void testPositiveNumber() {
        // Test with a simple positive number
        assertEquals(15, SumOfDigits.sumOfDigits(12345));
    }

    @Test
    public void testZero() {
        // Test with 0, the sum of digits should be 0
        assertEquals(0, SumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testNegativeNumber() {
        // Test with a negative number, the sum should be the same as its positive counterpart
        assertEquals(15, SumOfDigits.sumOfDigits(-12345));
    }

    @Test
    public void testSingleDigit() {
        // Test with a single-digit number
        assertEquals(9, SumOfDigits.sumOfDigits(9));
    }

    @Test
    public void testLargeNumber() {
        // Test with a large number
        assertEquals(45, SumOfDigits.sumOfDigits(123456789));
    }

    @Test
    public void testEdgeCaseNegative() {
        // Test with a negative number that's a single digit
        assertEquals(7, SumOfDigits.sumOfDigits(-7));
    }

    @Test
    public void testLargeNegativeNumber() {
        // Test with a large negative number
        assertEquals(45, SumOfDigits.sumOfDigits(-123456789));
    }
}
