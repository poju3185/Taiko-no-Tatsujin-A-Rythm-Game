package edu.uchicago.gerber._03objects.P8_1;

public class Microwave {
    private int powerLevel;
    private int cookingTime;

    public Microwave() {
        this.powerLevel = 1;
        this.cookingTime = 0;
    }

    public void switchPowerLevel() {
        if (this.powerLevel == 1) {
            this.powerLevel = 2;
        } else {
            this.powerLevel = 1;
        }
        System.out.println("Power level: " + this.powerLevel);
    }

    public void addCookingTime30s() {
        this.cookingTime += 30;
        System.out.println("Cooking time: " + this.cookingTime);
    }

    public void reset() {
        this.cookingTime = 0;
        this.powerLevel = 1;
        System.out.println("Reset cooking time and power level");
    }

    public void start() {
        System.out.println("Cooking for " + this.cookingTime + " seconds at level " + this.powerLevel);
    }
}
