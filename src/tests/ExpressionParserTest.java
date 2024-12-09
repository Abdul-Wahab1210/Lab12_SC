package tests;

import Lab12.ExpressionParser;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionParserTest {

    @Test
    public void testAddition() {
        assertEquals(8.0, ExpressionParser.evaluateExpression("3 + 5"), 0.001);
    }

    @Test
    public void testMultiplicationAndAddition() {
        assertEquals(13.0, ExpressionParser.evaluateExpression("3 + 5 * 2"), 0.001);
    }

    @Test
    public void testParentheses() {
        assertEquals(16.0, ExpressionParser.evaluateExpression("(3 + 5) * 2"), 0.001);
    }

    @Test
    public void testDivision() {
       assertEquals(5.0, ExpressionParser.evaluateExpression("10 / 2"), 0.001);
    }

    @Test
    public void testFloatingPoint() {
        assertEquals(7.5, ExpressionParser.evaluateExpression("3.5 + 4.0"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpression() {
        ExpressionParser.evaluateExpression("3 + + 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        ExpressionParser.evaluateExpression("10 / 0");
    }

    @Test
    public void testComplexExpression() {
        assertEquals(6.0, ExpressionParser.evaluateExpression("3 + 5 * 2 - (10 / 2)"), 0.001);
    }

    @Test
    public void testNestedParentheses() {
        assertEquals(6.0, ExpressionParser.evaluateExpression("(3 + (2 * 3))"), 0.001);
    }
}
