package edu.uchicago.gerber._03objects.P8_5;

public class SodaCanDriver {
    public static void main(String[] args) {
        SodaCan sodaCan = new SodaCan(5, 10);
        System.out.println(sodaCan.getVolume());
        System.out.println(sodaCan.getSurfaceArea());
    }
}
