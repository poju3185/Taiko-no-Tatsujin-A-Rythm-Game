package edu.uchicago.gerber._04interfaces.E9_8;

public class BasicAccount extends BankAccount{
    public BasicAccount() {
        super();
    }
    @Override
    public void withdraw(double amount){
        if (amount > getBalance()) {
            System.out.println("Not enough balance.");
            return;
        }
        super.withdraw(amount);
    }
}
