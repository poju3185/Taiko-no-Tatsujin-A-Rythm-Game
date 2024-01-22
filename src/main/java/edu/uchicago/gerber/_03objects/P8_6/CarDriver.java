package edu.uchicago.gerber._03objects.P8_6;

public class CarDriver {
    public static void main(String[] args) {
        Car mycar = new Car(50);
        mycar.addGas(20);
        mycar.drive(100);
        System.out.println(mycar.getGasLevel());
    }
}
