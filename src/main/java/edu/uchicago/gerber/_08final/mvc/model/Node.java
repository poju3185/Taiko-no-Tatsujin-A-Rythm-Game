package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Data
public class Node extends Sprite {
    //radius of a large asteroid
    private final int SMALL_RADIUS = 22;
    private final int BIG_RADIUS = 32;
    private final int XSPEED = -3;
    private final int YSPEED = 0;

    //size determines if the Asteroid is Large (0), Medium (1), or Small (2)
    public Node(Dimension DIM, String type) {

        //a size of zero is a big asteroid
        //a size of 1 or 2 is med or small asteroid respectively. See getSize() method.


        super.setType(type);

        setRadius(SMALL_RADIUS);


        setCenter(new Point(DIM.width, 186));
        setTeam(Team.NODE);

        setDeltaX(XSPEED);
        // delta-y is zero
        setDeltaY(YSPEED);

        Map<String, BufferedImage> rasterMap = new HashMap<>();
        //brick from Mario Bros
        rasterMap.put("don", loadGraphic("/imgs/node/don.png"));
        rasterMap.put("kat", loadGraphic("/imgs/node/kat.png"));
        setRasterMap(rasterMap);
        // When the node touches the end wall.
        setExpiry(246);
    }

    @Override
    public void draw(Graphics g) {
        renderRaster((Graphics2D) g, getRasterMap().get(super.getType()));
        //if you uncomment these, you can see how collision works. Feel free to remove these two lines.
//        g.setColor(Color.GREEN);
//        g.drawOval(getCenter().x - getRadius(), getCenter().y - getRadius(), getRadius() *2, getRadius() *2);
    }

    @Override
    protected void expire() {
        super.expire();
        if (super.getExpiry() == 1) {
            CommandCenter.getInstance().setCombo(0);
        }

    }
}
