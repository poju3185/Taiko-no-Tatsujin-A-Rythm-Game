package edu.uchicago.gerber._06design.E12_4;

import java.util.Random;
import java.util.Scanner;

public class ArithmeticTest {
    private int level;
    private int score;
    private int a, b, ans;
    public static final Random R = new Random();

    public ArithmeticTest() {
        level = 1;
        score = 0;
        a = 0;
        b = 0;
        ans = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (level <= 3) {
            switch (level) {
                case 1:
                    ans = 100;
                    while (ans >= 10) {
                        a = R.nextInt(10);
                        b = R.nextInt(10);
                        ans = a + b;
                    }
                    if (printQuestion('+', scanner)) {
                        score++;
                        checkLevel();
                    }
                    break;
                case 2:
                    a = R.nextInt(10);
                    b = R.nextInt(10);
                    ans = a + b;
                    if (printQuestion('+', scanner)) {
                        score++;
                        checkLevel();
                    }
                    break;
                case 3:
                    ans = -1;
                    while (ans < 0) {
                        a = R.nextInt(10);
                        b = R.nextInt(10);
                        ans = a - b;
                    }
                    if (printQuestion('-', scanner)) {
                        score++;
                        checkLevel();
                    }
                    break;
            }
        }
        System.out.println("Well done! You've completed all levels.");
        scanner.close();
    }

    private boolean printQuestion(char operator, Scanner scanner) {
        int tries = 2;

        while (tries > 0) {
            System.out.println("Level: " + level + " Answer the following question, you have " + tries + " tries.");
            System.out.println(a + " " + operator + " " + b + " = ?");
            if (scanner.nextInt() == ans) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println("Wrong answer, please try again.");
                tries--;
            }
        }
        return false;
    }

    private void checkLevel() {
        if (score >= 5 && level < 3) {
            level++;
            score = 0;
        }
    }
}
