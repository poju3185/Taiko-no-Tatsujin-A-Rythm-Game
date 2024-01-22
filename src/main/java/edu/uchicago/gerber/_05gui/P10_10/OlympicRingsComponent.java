package edu.uchicago.gerber._05gui.P10_10;

import javax.swing.JComponent;
import java.awt.*;

public class OlympicRingsComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));  // Setting the stroke width to 8 pixels
        int diameter = 100; // diameter of each ring

        // Draw the top rings
        drawRing(g2, 50, 50, diameter, Color.BLUE);
        drawRing(g2, 150, 50, diameter, Color.BLACK);
        drawRing(g2, 250, 50, diameter, Color.RED);

        // Draw the bottom rings
        drawRing(g2, 100, 100, diameter, Color.YELLOW);
        drawRing(g2, 200, 100, diameter, Color.GREEN);
    }

    /**
     * Draws a ring.
     *
     * @param g - the Graphics object
     * @param x - the x position
     * @param y - the y position
     * @param diameter - the diameter of the ring
     * @param color - the color of the ring
     */
    private void drawRing(Graphics2D g, int x, int y, int diameter, Color color) {
        g.setColor(color);
        g.drawOval(x, y, diameter, diameter);
    }
}
