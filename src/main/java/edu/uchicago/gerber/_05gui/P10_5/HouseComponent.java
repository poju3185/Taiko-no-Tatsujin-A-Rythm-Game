package edu.uchicago.gerber._05gui.P10_5;

import javax.swing.JComponent;
import java.awt.*;

public class HouseComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawHouse(g, 50, 150, 100, 100, Color.red);
        drawHouse(g, 175, 130, 150, 150, Color.blue);
        drawHouse(g, 350, 200, 75, 75, Color.magenta);
    }

    /**
     * Draws a house.
     *
     * @param g - the Graphics object
     * @param x - the x position
     * @param y - the y position
     * @param width - the width of the house
     * @param height - the height of the house
     * @param color - the color of the house
     */
    private void drawHouse(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        // Draw the base of the house
        g.drawRect(x, y, width, height);

        // Draw the roof of the house
        g.drawLine(x, y, x + width / 2, y - height / 2);
        g.drawLine(x + width / 2, y - height / 2, x + width, y);

        g.setColor(Color.black);
        // Draw the door
        g.drawRect(x + width / 3, y + 3 * height / 4, width / 3, height / 4);
    }
}
