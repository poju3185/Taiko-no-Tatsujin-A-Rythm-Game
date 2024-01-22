package edu.uchicago.gerber._05gui.P10_5;

import javax.swing.JFrame;

public class HouseViewer {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HouseComponent house = new HouseComponent();
        frame.add(house);

        frame.setVisible(true);
    }
}

