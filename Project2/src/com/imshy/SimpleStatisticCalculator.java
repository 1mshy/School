package com.imshy;

import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStatisticCalculator {
    // Main driver method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input 5 numbers separated by space: ");
        String numbers = sc.nextLine();
        double[] nums = Stream.of(numbers.split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        OptionalDouble av;
        //Not recommended to use method getAsDouble without checking
        //if a value is present
        double average = (av = Arrays.stream(nums).average())
                .isPresent() ? av.getAsDouble() : -1 ;
        double minimum = (av = Arrays.stream(nums).min())
                .isPresent() ? av.getAsDouble() : -1 ;
        double maximum = (av = Arrays.stream(nums).max())
                .isPresent() ? av.getAsDouble() : -1 ;
        double deviation = Math.sqrt(Arrays.stream(nums)
                .map(x-> Math.pow(x-average, 2)).sum()/nums.length);

        System.out.printf("%-20s: %s%n", "Numbers", Arrays.toString(nums)
                .replace("[", "")
                .replace("]", ""));
        String format = "%-20s: %.2f%n";
        System.out.printf(format, "Mean", average);
        System.out.printf(format, "Minimum", minimum);
        System.out.printf(format, "Maximum", maximum);
        System.out.printf(format, "Standard Deviation", deviation);

    }
}
