package edu.uchicago.gerber._04interfaces.P9_1;

public class Driver {
    public static void main(String[] args) {
        Clock myClock = new Clock();
        System.out.println(myClock.getTime());
        WorldClock worldClock = new WorldClock(3);
        System.out.println(worldClock.getTime());
    }
}
