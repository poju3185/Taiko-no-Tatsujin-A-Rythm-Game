package edu.uchicago.gerber._05gui.P10_2;

import javax.swing.*;

public class BullsEyeViewer {
    public static final int FRAME_WIDTH = 400;
    public static final int FRAME_HEIGHT = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BullsEyeComponent bullsEye = new BullsEyeComponent();
        frame.add(bullsEye);

        frame.setVisible(true);
    }
}
