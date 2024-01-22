package edu.uchicago.gerber._04interfaces.E9_13;

import edu.uchicago.gerber._04interfaces.E9_8.BasicAccount;

import java.awt.*;

public class BetterRectangle extends Rectangle {
    public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }

    public int getPerimeter() {
        return 2 * (width + height);
    }

    public int getArea() {
        return width * height;
    }
}
