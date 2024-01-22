package edu.uchicago.gerber._05gui.P10_9;

import javax.swing.*;

public class FlagViewer {
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Flag flag = new Flag();
        frame.add(flag);

        frame.setVisible(true);

    }
}
