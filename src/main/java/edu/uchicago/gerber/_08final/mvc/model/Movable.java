package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;

public interface Movable {

    enum Team {HITBOX, NODE, EFFECTS}


    //for the game to move and draw movable objects. See the GamePanel class.
    void move();

    void draw(Graphics g);

    //for collision detection
    Point getCenter();

    int getRadius();

    Team getTeam();

    boolean isProtected();


} //end Movable
