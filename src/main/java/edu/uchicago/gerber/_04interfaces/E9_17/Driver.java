package edu.uchicago.gerber._04interfaces.E9_17;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        SodaCan[] sodaCans = {
                new SodaCan(10, 5),
                new SodaCan(12, 6),
                new SodaCan(8, 4),
                new SodaCan(14, 7)
        };
        double totalSurfaceArea = 0;
        for (SodaCan sodaCan : sodaCans) {
            totalSurfaceArea += sodaCan.getSurfaceArea();
        }
        double averageSurfaceArea = totalSurfaceArea / sodaCans.length;
        System.out.println(averageSurfaceArea);
    }
}
