package com.imshy;

import java.util.Scanner;

public class WebAddressExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a web address: ");
        String webAddress = sc.nextLine().toLowerCase();
//        String webAddress = "www.google.com";
        int firstDot = webAddress.indexOf('.');
        int secondDot = webAddress.lastIndexOf('.');
        String heading = webAddress.substring(0, firstDot);
        String company = webAddress.substring(firstDot+1, secondDot);
        String extension = webAddress.substring(secondDot+1);
        String format = "%-10s: %s%n";
        System.out.printf(format, "Address", webAddress);
        System.out.printf(format, "Heading", heading);
        System.out.printf(format, "Company", company);
        System.out.printf(format, "Extension", extension);

    }
}
