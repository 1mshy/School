package com.imshy;

import java.util.Scanner;

public class ParkingPriceCalculator {
    public static void main(String[] args) {
        final int PRICEPERHOUR = 2;
        Scanner sc = new Scanner(System.in);
        System.out.print(
                "Please input the number of minutes your car has been parked: "
        );
        int minutes = sc.nextInt();
        int hours = minutes / 60;
        hours += minutes % 60 == 0 ? 0 : 1;
        double price = hours*PRICEPERHOUR;

        System.out.printf("%-25s: %d%n", "Parking time (minutes)", minutes);
        System.out.printf("%-25s: %d%n", "Parking time (hours)", hours);
        System.out.printf("%-25s: %.2f%n", "Price", price);
    }
}
