package edu.uchicago.gerber._05gui.P10_10;

import javax.swing.JFrame;
import java.awt.*;

public class OlympicRingsViewer {

    public static final int FRAME_WIDTH = 400;
    public static final int FRAME_HEIGHT = 250;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OlympicRingsComponent rings = new OlympicRingsComponent();
        frame.add(rings);

        frame.setVisible(true);
    }
}

