package edu.uchicago.gerber._06design.P12_1;

import java.util.ArrayList;

public class VendingMachine {
    private final ArrayList<Coin> coinBox = new ArrayList<>();
    private final ArrayList<Coin> tempCoinBox = new ArrayList<>();
    private final ArrayList<Product> sodas = new ArrayList<>();
    private final ArrayList<Product> chips = new ArrayList<>();
    private final ArrayList<Product> chocolateBars = new ArrayList<>();
    public double credit;
    private static final int PASSCODE = 1234;

    public VendingMachine() {
        restock();
        credit = 0;
    }

    public void insertCoins(String coin) {
        switch (coin) {
            case "q":
            case "Q":
                tempCoinBox.add(new Coin('q'));
                credit += 0.25;
                break;
            case "d":
            case "D":
                tempCoinBox.add(new Coin('d'));
                credit += 0.10;
                break;
            case "n":
            case "N":
                tempCoinBox.add(new Coin('n'));
                credit += 0.05;
                break;
            case "p":
            case "P":
                tempCoinBox.add(new Coin('p'));
                credit += 0.01;
                break;
            default:
                System.out.println("This is not a coin!");
        }
        credit = Math.round(credit * 100.0) / 100.0; // round credit to two decimal places
    }

    public void buyProduct(int index) {
        ArrayList<Product> currentProducts;
        switch (index) {
            case 1:
                currentProducts = sodas;
                break;
            case 2:
                currentProducts = chips;
                break;
            case 3:
                currentProducts = chocolateBars;
                break;
            default:
                System.out.println("No such product.");
                return;
        }
        if (currentProducts.isEmpty()) {
            System.out.println("This product is sold out.");
            return;
        }
        if (credit < currentProducts.get(0).price) {
            System.out.println("Not enough credit, returning coins");
            for (Coin coin : tempCoinBox) {
                System.out.print(coin.name + " ");
            }
            System.out.println();
            return;
        }
        Product product = currentProducts.remove(0);
        System.out.println("Here is your " + product.name + ", enjoy!");
        coinBox.addAll(tempCoinBox);
        tempCoinBox.clear();
        credit = 0;
    }

    private void restock() {
        while (sodas.size() < 3) {
            sodas.add(new Product("soda", 1.5));
        }
        while (chips.size() < 10) {
            chips.add(new Product("chip", 2));
        }
        while (chocolateBars.size() < 10) {
            chocolateBars.add(new Product("chocolate bar", 0.5));
        }
    }

    public void getMoney(int passcode) {
        if (passcode == PASSCODE) {
            System.out.println("Here are the coins inside the coin box");
            for (Coin coin : coinBox) {
                System.out.print(coin.name + " ");
            }
            System.out.println();
        } else {
            System.out.println("DONOT TRY TO STEAL MONEY!");
        }
    }
}
