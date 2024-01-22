package edu.uchicago.gerber._02arrays;

import java.util.Arrays;
import java.util.Scanner;

public class E6_16 {
    public static void main(String[] args) {
        int MAX_ASTERISKS = 20;
        Scanner scan = new Scanner(System.in);
        String numString = scan.nextLine();
        String[] numsTokens = numString.split(" ");
        int[] nums = new int[numsTokens.length];
        for (int i = 0; i < numsTokens.length; i++) {
            nums[i] = Integer.parseInt(numsTokens[i]);
        }
        int maxNumber = Arrays.stream(nums).max().getAsInt();

        int[] asterisks = new int[nums.length];
        for (int i = 0; i < asterisks.length; i++) {
            asterisks[i] = MAX_ASTERISKS * nums[i] / maxNumber;
        }
        for (int i = MAX_ASTERISKS; i > 0; i--) {
            for (int j = 0; j < asterisks.length; j++) {
                if (asterisks[j] - i >= 0 && j == asterisks.length - 1) {
                    System.out.print("*\n");
                } else if (asterisks[j] - i >= 0) {
                    System.out.print("*");
                } else if (asterisks[j] - i < 0 && j == asterisks.length - 1) {
                    System.out.print(" \n");
                } else {
                    System.out.print(" ");
                }
            }

        }
    }
}
