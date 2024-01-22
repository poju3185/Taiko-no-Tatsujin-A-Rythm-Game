package edu.uchicago.gerber._04interfaces.E9_8;

public class Driver {
    public static void main(String[] args){
        BasicAccount myAccount = new BasicAccount();
        myAccount.deposit(500);
        myAccount.withdraw(1000);
        myAccount.withdraw(300);
        myAccount.deposit(500);

    }
}
