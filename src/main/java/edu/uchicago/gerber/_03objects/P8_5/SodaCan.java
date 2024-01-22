package edu.uchicago.gerber._03objects.P8_5;

import lombok.Getter;

@Getter
public class SodaCan {
    private final double surfaceArea;
    private final double volume;

//    public double getSurfaceArea() {
//        return surfaceArea;
//    }
//
//    public double getVolume() {
//        return volume;
//    }

    public SodaCan(double height, double radius) {
        this.surfaceArea = radius * radius * Math.PI * 2 + 2 * radius * Math.PI * height;
        this.volume = radius * radius * Math.PI * height;
    }
}
