package edu.uchicago.gerber._02arrays;

import java.util.Arrays;
import java.util.Random;

public class E6_12 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int ranNum = random.nextInt(100);
            System.out.print(ranNum + " ");
            array[i] = ranNum;
        }
        System.out.println();
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
