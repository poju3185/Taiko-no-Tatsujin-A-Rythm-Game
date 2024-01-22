package edu.uchicago.gerber._06design.P12_1;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, please follow the instruction. Enter E to leave");
        char userInput = ' ';
        while (true) {
            System.out.println("=====================================================================");
            System.out.println("q: quarter, d: dime, n: nickle, p:penny");
            System.out.println("1: soda ($1.5), 2: chip ($2), 3: chocolate bar ($0.5)");
            System.out.println("Please insert your coin, seperated by space. Or enter G (Staff only)");
            String line = scanner.nextLine();
            if (line.equals("E") || line.equals("e")) break;
            if (line.equals("G")) {
                System.out.println("Enter the passcode");
                vendingMachine.getMoney(scanner.nextInt());
                scanner.nextLine(); // Consume the rest of the line including the newline character
            } else {
                String[] coins = line.split(" ");
                for (String coin : coins) {
                    vendingMachine.insertCoins(coin);
                }
                System.out.println("Your credit is " + vendingMachine.credit + ". Now select a product.");
                int productIndex = scanner.nextInt();
                scanner.nextLine(); // Consume the rest of the line including the newline character

                vendingMachine.buyProduct(productIndex);
            }
        }
    }
}
