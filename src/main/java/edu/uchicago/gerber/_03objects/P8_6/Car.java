package edu.uchicago.gerber._03objects.P8_6;

public class Car {
    private final double milesPerGallon;
    private double gasLevel;

    public Car(double efficiency) {
        this.milesPerGallon = efficiency;
        this.gasLevel = 0;
    }

    public void addGas(double gallons) {
        this.gasLevel += gallons;
    }

    public void drive(double miles) {
        this.gasLevel -= miles / milesPerGallon;
    }

    public double getGasLevel() {
        return this.gasLevel;
    }
}
