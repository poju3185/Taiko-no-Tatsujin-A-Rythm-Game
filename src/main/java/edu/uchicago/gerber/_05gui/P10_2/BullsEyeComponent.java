package edu.uchicago.gerber._05gui.P10_2;

import javax.swing.*;
import java.awt.*;

public class BullsEyeComponent extends JComponent {
    private static final int diameter = 200;
    private static final int rings = 5;

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < rings; i++) {
            if (i % 2 == 0) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.white);
            }
            int currentDiameter = diameter - (i * (diameter / rings));
            int x = (getWidth() - currentDiameter) / 2;
            int y = (getHeight() - currentDiameter) / 2;
            g.fillOval(x, y, currentDiameter, currentDiameter);
        }
    }

}
