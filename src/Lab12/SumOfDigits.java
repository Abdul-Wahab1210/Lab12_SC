package Lab12;

import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        
        // Get the input number
        int number = scanner.nextInt();
        
        // Call the sumOfDigits function to compute the sum of digits
        int sum = sumOfDigits(number);
        
        // Display the result
        System.out.println("The sum of the digits is: " + sum);
    }

    /**
     * Recursively calculates the sum of the digits of a number.
     * @param number The number to calculate the sum of digits for.
     * @return The sum of the digits.
     */
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting them to positive
        if (number < 0) {
            number = Math.abs(number);
        }

        // Base case: if the number is reduced to 0, return 0
        if (number == 0) {
            return 0;
        }
        
        // Recursive case: sum the last digit and recursively call with the rest of the number
        return number % 10 + sumOfDigits(number / 10);
    }
}
