package edu.uchicago.gerber._04interfaces.E9_13;

public class Driver {
    public static void main(String[] args) {
        BetterRectangle rectangle = new BetterRectangle(0, 0, 15, 20);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}
