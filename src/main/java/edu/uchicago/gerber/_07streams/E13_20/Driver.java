package edu.uchicago.gerber._07streams.E13_20;

public class Driver {
    public static void main(String[] args) {
        pay(10);
//      findCombinations(6, 0,0,0,0);


    }

    private static void pay(int n) {
        findCombinations(n, 0, 0, 0, 0);
    }

    private static void findCombinations(int remaining, int hundreds, int twenties, int fives, int ones) {
        // Base case: if remaining amount is 0, print the combination
        if (remaining == 0) {
            System.out.println(hundreds + " x $100, " + twenties + " x $20, " + fives + " x $5, " + ones + " x $1");
            return;
        }

        // Recursive calls
        if (remaining >= 100 && twenties == 0 && fives == 0 && ones == 0) {
            findCombinations(remaining - 100, hundreds + 1, twenties, fives, ones);
        }
        if (remaining >= 20 && fives == 0 && ones == 0) {
            findCombinations(remaining - 20, hundreds, twenties + 1, fives, ones);
        }
        if (remaining >= 5 && ones == 0) {
            findCombinations(remaining - 5, hundreds, twenties, fives + 1, ones);
        }
        if (remaining >= 1) {
            findCombinations(remaining - 1, hundreds, twenties, fives, ones + 1);
        }

    }

}
