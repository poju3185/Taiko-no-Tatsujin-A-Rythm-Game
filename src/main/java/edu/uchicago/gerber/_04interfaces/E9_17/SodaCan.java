package edu.uchicago.gerber._04interfaces.E9_17;

import lombok.Getter;

@Getter
public class SodaCan implements Measurable {
    private final double surfaceArea;
    private final double volume;

    public SodaCan(double height, double radius) {
        this.surfaceArea = radius * radius * Math.PI * 2 + 2 * radius * Math.PI * height;
        this.volume = radius * radius * Math.PI * height;
    }

    public double getMeasure() {
        return surfaceArea;
    }
}
