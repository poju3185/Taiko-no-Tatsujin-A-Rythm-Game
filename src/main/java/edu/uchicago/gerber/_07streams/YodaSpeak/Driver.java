package edu.uchicago.gerber._07streams.YodaSpeak;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input: ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        for (int i = words.length-1; i >=0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
}
