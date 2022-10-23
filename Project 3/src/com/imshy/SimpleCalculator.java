package com.imshy;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter two numbers, separated by space: ");
        String twoNums = sc.nextLine();
        System.out.println("Please enter the operator (+, -, *, or /): ");
        char operator = sc.nextLine().charAt(0);
        System.out.println("Please enter a formular, e.g.: \"3.14 * 2\": ");
        String formula = sc.nextLine();
        System.out.println();
        Calculator calc = new Calculator();
        String[] nums = twoNums.split(" ");
        double num1 = Double.parseDouble(nums[0]);
        double num2 = Double.parseDouble(nums[1]);
        String format = "%-25s : %.2f %c %.2f = %.2f%n";
        System.out.printf(format, "Calling the first method",
                num1, '+', num2, calc.calcResult(num1, num2));
        System.out.printf(format, "Calling the second method",
                num1, operator, num2, calc.calcResult(num1, num2, operator));
        String[] splitFormula = formula.split(" ");

        double first = Double.parseDouble(splitFormula[0]);
        double second = Double.parseDouble(splitFormula[2]);
        char opp = splitFormula[1].charAt(0);
         /* the third method is useless as  the variables
         to use the second method are already existent */
        System.out.printf(format, "Calling the third method",
                first, opp, second, calc.calcResult(formula));
    }
}

class Calculator {
    double calcResult(double num1, double num2) {
        return num1 + num2;
    }

    double calcResult(double num1, double num2, char oper) {
        double result = num1;
        switch (oper) {
            case '*' -> result *= num2;
            case '/' -> result /= num2;
            case '-' -> result -= num2;
            case '+' -> result += num2;
            default -> throw new
                    IllegalStateException("Unexpected value: " + oper);
        }
        return result;
    }

    double calcResult(String formula) {
        String[] seperated = formula.split(" ");
        // index 0 and 2 are numbers while 1 is the operator
        return calcResult(Double.parseDouble(seperated[0]),
                Double.parseDouble(seperated[2]), seperated[1].charAt(0));
    }
}