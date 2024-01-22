package edu.uchicago.gerber._03objects.P8_1;

public class MicrowaveDriver {
    public static void main(String[] args){
        Microwave microwave = new Microwave();
        microwave.switchPowerLevel();
        microwave.addCookingTime30s();
        microwave.addCookingTime30s();
        microwave.start();
        microwave.reset();
        microwave.addCookingTime30s();
        microwave.start();
    }
}
