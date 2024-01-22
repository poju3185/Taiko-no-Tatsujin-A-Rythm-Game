package edu.uchicago.gerber._07streams.P13_3;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        PhoneNumberSpelling p = new PhoneNumberSpelling();
        List<String> a = p.findAllCombinations("2633465282");
        System.out.println(a);
    }


}
