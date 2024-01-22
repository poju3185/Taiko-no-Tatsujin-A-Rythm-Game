package edu.uchicago.gerber._08final.mvc.model;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Data
public class HitBox extends Sprite {
    private static Point drumCenter = new Point(305, 186);
    public int a;

    public HitBox(String type) {
        super.setType(type);

        //a size of zero is a big asteroid
        //a size of 1 or 2 is med or small asteroid respectively. See getSize() method.

        setRadius(28);
        setCenter(drumCenter);
        //HitBox is Friend
        setTeam(Team.HITBOX);


        Map<String, BufferedImage> rasterMap = new HashMap<>();
        rasterMap.put("HitBox", loadGraphic("/imgs/node/don.png"));
        setRasterMap(rasterMap);
        setExpiry(1);
    }

    @Override
    public void draw(Graphics g) {
//        renderRaster((Graphics2D) g, getRasterMap().get("HitBox"));
        //if you uncomment these, you can see how collision works. Feel free to remove these two lines.
//        g.setColor(Color.GREEN);
//        g.drawOval(getCenter().x - getRadius(), getCenter().y - getRadius(), getRadius() * 2, getRadius() * 2);
    }


}
