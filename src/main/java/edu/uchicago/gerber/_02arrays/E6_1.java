package edu.uchicago.gerber._02arrays;

import java.util.Random;

public class E6_1 {
    public static void main(String[] args) {
        int[] randomArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt();
        }
        for (int i = 0; i < randomArray.length; i += 2) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
        for (int num : randomArray) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        for (int i = randomArray.length - 1; i >= 0; i--) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
        System.out.print(randomArray[0] + " " + randomArray[9]);
    }
}
