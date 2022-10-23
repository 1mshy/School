package com.imshy;

import java.util.Scanner;

public class CaseConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word: ");
        String word = sc.nextLine();
        System.out.println("""
                Please choose the case you want to convert:
                1. 'l' or 'L' for lowercase
                2. 'u' or 'U' for uppercase
                2. 't' or 'T' for titlecase""");
        char wordCase = sc.nextLine().charAt(0);
        System.out.println();

        Converter converter = new Converter();
        String format = "%-37s: %s%n";
        System.out.printf(format, "Original word", word);
        System.out.printf(format, "Calling the first convertCase method", converter.convertCase(word));
        System.out.printf(format, "Calling the second convertCase method", converter.convertCase(word, wordCase));
    }
}

class Converter {
    String convertCase(String word) {
        return convertCase(word, 't');
    }

    String convertCase(String word, char caseType) {
        switch (caseType) {
            case 'u', 'U' -> {
                return word.toUpperCase();
            }
            case 'l', 'L' -> {
                return word.toLowerCase();
            }
            case 't', 'T' -> {
                return String.valueOf(word.charAt(0)).toUpperCase()
                        + word.toLowerCase().substring(1);
            }
        }
        return word;
    }
}