package edu.uchicago.gerber._04interfaces.E9_8;

public class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
