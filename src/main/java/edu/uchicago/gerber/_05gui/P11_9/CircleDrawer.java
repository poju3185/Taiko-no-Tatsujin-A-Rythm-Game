package edu.uchicago.gerber._05gui.P11_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleDrawer extends JFrame {
    private Point center;
    private Point periphery;
    private boolean isCenterSet = false;

    public CircleDrawer(){
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!isCenterSet){
                    System.out.println("center selected" + e.getPoint());
                    center = e.getPoint();
                    isCenterSet=true;
                }else {
                    System.out.println("periphery selected" + e.getPoint());
                    periphery = e.getPoint();
                    isCenterSet = false;
                    paint();
                }
            }
        });
    }
    public void paint(){
        Graphics g = getGraphics();
        int radius = (int) center.distance(periphery);
        g.drawOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
    }

}
