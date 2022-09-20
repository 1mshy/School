package com.imshy;

import java.util.Scanner;

public class BirthYearCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a birth year: ");
        String birthYear = sc.nextLine();
        // using the length allows the year to be larger
        //EX. year 194867349 will work correctly
        int century = Integer.parseInt(
                birthYear.substring(0, birthYear.length() - 2)
        ) + 1;
        int decade = Integer.parseInt(
                String.valueOf(birthYear.charAt(birthYear.length() - 2))
        ) * 10;
        String format = "%-10s: %d%n";
        System.out.printf("%-10s: %s%n", "Birth Year", birthYear);
        System.out.printf(format, "Century", century);
        System.out.printf(format, "Decade", decade);

    }
}
