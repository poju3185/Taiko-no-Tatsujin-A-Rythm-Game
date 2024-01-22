package edu.uchicago.gerber._02arrays;

public class P5_8 {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2000));
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return  false;
        }
        return year % 100 != 0;
    }
}
