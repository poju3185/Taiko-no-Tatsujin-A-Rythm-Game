package edu.uchicago.gerber._03objects.P8_19;

import lombok.Getter;

public class CannonBall {
    private static final double G = 9.81;
    @Getter
    private double xPosition;
    @Getter
    private double yPosition;
    private double xVelocity;
    private double yVelocity;

    public CannonBall(double xPosition) {
        this.xPosition = xPosition;
        this.yPosition = 0;
    }

    private void move(double sec) {
        xPosition += xVelocity * sec;
        yPosition += yVelocity * sec;
        yVelocity -= G * sec;
    }

    public void shoot(double angle, double velocity) {
        double interval = 0.1;
        xVelocity = velocity * Math.cos(angle);
        yVelocity = velocity * Math.sin(angle);
        System.out.println("(" + getXPosition() + ", " + getYPosition() + ")");
        move(interval);
        while (yPosition > 0) {
            System.out.println("(" + getXPosition() + ", " + getYPosition() + ")");
            move(interval);
        }

    }

}
