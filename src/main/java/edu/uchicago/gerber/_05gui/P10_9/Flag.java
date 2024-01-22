package edu.uchicago.gerber._05gui.P10_9;

import javax.swing.*;
import java.awt.*;

public class Flag extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFlag(g, 100, 100, 200, Color.red, Color.white, Color.green);
            drawFlag(g, 100, 300, 200, Color.black, Color.red, Color.yellow);
    }

    private void drawFlag(Graphics g, int xLeft, int yTop, int width, Color topColor, Color midColor, Color botColor) {
        int height = width * 2 / 3;
        if (topColor.equals(Color.white)) {
            g.setColor(Color.black);
            g.drawLine(xLeft, yTop, xLeft, yTop + height / 3);
            g.drawLine(xLeft + width, yTop,
                    xLeft + width, yTop + height / 3);
        } else {
            g.setColor(topColor);
            g.fillRect(xLeft, yTop, width, height / 3);
        }
        if (midColor.equals(Color.white)) {
            g.setColor(Color.black);
            g.drawLine(xLeft, yTop + height / 3, xLeft, yTop + height * 2 / 3);
            g.drawLine(xLeft + width, yTop + height / 3,
                    xLeft + width, yTop + height * 2 / 3);
        } else {
            g.setColor(midColor);
            g.fillRect(xLeft, yTop + height / 3, width, height / 3);
        }
        if (botColor.equals(Color.white)) {
            g.setColor(Color.black);
            g.drawLine(xLeft, yTop + height * 2 / 3, xLeft, yTop + height);
            g.drawLine(xLeft + width, yTop + height * 2 / 3,
                    xLeft + width, yTop + height);
        } else {
            g.setColor(botColor);
            g.fillRect(xLeft, yTop + height * 2 / 3, width, height / 3);
        }
//        g.fillRect(xLeft + 2 * width / 3, yTop, width / 3, width * 2 / 3);
//        g.drawLine(xLeft + width / 3, yTop, xLeft + width * 2 / 3, yTop);
//        g.drawLine(xLeft + width / 3, yTop + width * 2 / 3,
//                xLeft + width * 2 / 3, yTop + width * 2 / 3);
//
    }
}
