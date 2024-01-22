package edu.uchicago.gerber._07streams.E19_6;
import java.util.Comparator;
import  java.util.Currency;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Set<Currency> currencySet = Currency.getAvailableCurrencies();
         currencySet.stream()
                 .map(s -> s.getDisplayName())
                 .sorted()
                 .forEach(s -> System.out.println(s));
    }
}
