package com.imshy;

public class Hex {
    public static void main(String[] args) {
        System.out.println(toDecimal("abcdef"));
    }
    public static int toDecimal(String hex)
    {
        hex = hex.toLowerCase();
        final String hexValues = "0123456789abcdef";
        int decimal = 0;
        for(int i = hex.length()-1; i >= 0; i--)
        {
            char c = hex.charAt(i);
            decimal+= hexValues.indexOf(c)*Math.pow(16, hex.length()-1-i);
        }
        return decimal;
    }
}
