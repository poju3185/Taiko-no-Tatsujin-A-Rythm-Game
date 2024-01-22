package edu.uchicago.gerber._02arrays;

import java.util.Objects;

public class P5_24 {
    public static void main(String[] args) {
        String romanNumber = "MCMLXXVIII";
        System.out.println(romanNumberConverter(romanNumber));

    }
    public static int romanNumberConverter(String romanNumber) {
        int total = 0;
        while (!romanNumber.isEmpty()) {
            if (romanNumber.length() == 1 || romanNumeric(romanNumber.charAt(0)) >= romanNumeric(romanNumber.charAt(1))) {
                total += romanNumeric(romanNumber.charAt(0));
                StringBuilder stringBuilder = new StringBuilder(romanNumber);
                stringBuilder.deleteCharAt(0);
                romanNumber = stringBuilder.toString();
            }
            else {
                int difference =romanNumeric(romanNumber.charAt(1)) - romanNumeric(romanNumber.charAt(0));
                total += difference;
                StringBuilder stringBuilder = new StringBuilder(romanNumber);
                stringBuilder.deleteCharAt(0);
                stringBuilder.deleteCharAt(0);
                romanNumber = stringBuilder.toString();
            }
        }
        return total;
    }
    public static int romanNumeric(char str) {
        if (Objects.equals(str, 'I')) {
            return 1;
        }
        if (Objects.equals(str, 'V')) {
            return 5;
        }
        if (Objects.equals(str, 'X')) {
            return 10;
        }
        if (Objects.equals(str, 'L')) {
            return 50;
        }
        if (Objects.equals(str, 'C')) {
            return 100;
        }
        if (Objects.equals(str, 'D')) {
            return 500;
        }
        if (Objects.equals(str, 'M')) {
            return 1000;
        }
        return 0;
    }
}
