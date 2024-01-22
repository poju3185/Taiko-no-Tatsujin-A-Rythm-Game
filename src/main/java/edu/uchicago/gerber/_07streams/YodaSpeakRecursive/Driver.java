package edu.uchicago.gerber._07streams.YodaSpeakRecursive;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input: ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        recursivePrint(words, words.length - 1);
    }

    private static void recursivePrint(String[] words, int index) {
        System.out.print(words[index] + " ");
        index--;
        if (index >= 0) recursivePrint(words, index);

    }
}
