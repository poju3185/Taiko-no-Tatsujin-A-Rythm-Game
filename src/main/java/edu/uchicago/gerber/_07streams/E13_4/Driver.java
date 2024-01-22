package edu.uchicago.gerber._07streams.E13_4;

public class Driver {
    public static void main(String[] args) {
        System.out.println(toBinaryString(35));
    }

    private static String toBinaryString(int num) {
        // Base cases
        if (num == 0) return "0";
        if (num == 1) return "1";
        String lastDigit = num % 2 == 0 ? "0" : "1";
        return toBinaryString(num / 2) + lastDigit;
    }
}
