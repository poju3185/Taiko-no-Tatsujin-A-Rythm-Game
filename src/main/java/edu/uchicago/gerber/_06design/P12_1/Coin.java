package edu.uchicago.gerber._06design.P12_1;

public class Coin {
    public final double value;
    public final char name;

    public Coin(char name) {
        this.name = name;
        if (name == 'Q' || name == 'q') {
            value = 0.25;
        } else if (name == 'D' || name == 'd') {
            value = 0.10;
        } else if (name == 'N' || name == 'n') {
            value = 0.05;
        } else if (name == 'P' || name == 'p') {
            value = 0.01;
        } else {
            value = 0;
        }
    }
}
