package Lab12;

import java.util.*;

public class ExpressionParser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Evaluates a mathematical expression with correct operator precedence.
     * @param expression The mathematical expression as a string.
     * @return The evaluated result.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", "");  // Remove any spaces
        return parseAdditionSubtraction(expression);
    }

    /**
     * Parses and evaluates addition and subtraction expressions.
     * @param expression The mathematical expression as a string.
     * @return The result of the evaluated expression.
     */
    private static double parseAdditionSubtraction(String expression) {
        double result = parseMultiplicationDivision(expression);
        int index = findOperatorIndex(expression, "+", "-");

        // Recursively handle addition and subtraction
        while (index != -1) {
            char operator = expression.charAt(index);
            double left = result;
            double right = parseMultiplicationDivision(expression.substring(index + 1));

            if (operator == '+') {
                result = left + right;
            } else if (operator == '-') {
                result = left - right;
            }
            index = findOperatorIndex(expression.substring(index + 1), "+", "-");
        }
        return result;
    }

    /**
     * Parses and evaluates multiplication and division expressions.
     * @param expression The mathematical expression as a string.
     * @return The result of the evaluated expression.
     */
    private static double parseMultiplicationDivision(String expression) {
        double result = parseParentheses(expression);
        int index = findOperatorIndex(expression, "*", "/");

        // Recursively handle multiplication and division
        while (index != -1) {
            char operator = expression.charAt(index);
            double left = result;
            double right = parseParentheses(expression.substring(index + 1));

            if (operator == '*') {
                result = left * right;
            } else if (operator == '/') {
                if (right == 0) throw new IllegalArgumentException("Division by zero");
                result = left / right;
            }
            index = findOperatorIndex(expression.substring(index + 1), "*", "/");
        }
        return result;
    }

    /**
     * Parses expressions within parentheses.
     * @param expression The mathematical expression as a string.
     * @return The result of the evaluated expression.
     */
    private static double parseParentheses(String expression) {
        if (expression.startsWith("(")) {
            int closingParenIndex = findClosingParenthesis(expression);
            if (closingParenIndex == -1) {
                throw new IllegalArgumentException("Unmatched parentheses");
            }
            String subExpression = expression.substring(1, closingParenIndex);
            double result = evaluateExpression(subExpression);
            String remainingExpression = expression.substring(closingParenIndex + 1);
            return result;
        }
        return parseNumber(expression);  // Parse the number if not inside parentheses
    }

    /**
     * Finds the index of the first occurrence of any of the given operators.
     * @param expression The expression as a string.
     * @param operators The operators to look for.
     * @return The index of the first operator found, or -1 if none found.
     */
    private static int findOperatorIndex(String expression, String... operators) {
        int index = -1;
        for (String operator : operators) {
            int tempIndex = expression.indexOf(operator);
            if (tempIndex != -1 && (index == -1 || tempIndex < index)) {
                index = tempIndex;
            }
        }
        return index;
    }

    /**
     * Finds the index of the closing parenthesis matching the first opening parenthesis.
     * @param expression The expression as a string.
     * @return The index of the closing parenthesis, or -1 if not found.
     */
    private static int findClosingParenthesis(String expression) {
        int openParenCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                openParenCount++;
            } else if (expression.charAt(i) == ')') {
                openParenCount--;
                if (openParenCount == 0) {
                    return i;
                }
            }
        }
        return -1; // No matching closing parenthesis
    }

    /**
     * Parses a number (integer or floating-point) from the expression.
     * @param expression The expression as a string.
     * @return The parsed number.
     */
    private static double parseNumber(String expression) {
        expression = expression.trim(); // Trim whitespace before parsing
        try {
            return Double.parseDouble(expression);  // This works for integers and floats
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + expression);
        }
    }
}
