package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class HitEffect extends Effect {
    private int index = 0;

    public HitEffect(String type) {

        Map<Integer, BufferedImage> rasterMap = new HashMap<>();
        //see readme.txt file in the resources/imgs/exp directory for how I created these assets
        if (type.equals("Good")) {
            rasterMap.put(0, loadGraphic("/imgs/exp/hit-good-1.png"));
            rasterMap.put(1, loadGraphic("/imgs/exp/hit-good-2.png"));
            rasterMap.put(2, loadGraphic("/imgs/exp/hit-good-3.png"));
        } else if (type.equals("OK")) {
            rasterMap.put(0, loadGraphic("/imgs/exp/hit-ok-1.png"));
            rasterMap.put(1, loadGraphic("/imgs/exp/hit-ok-2.png"));
            rasterMap.put(2, loadGraphic("/imgs/exp/hit-ok-3.png"));
        }
        setRasterMap(rasterMap);

        //expire it out after it has done its animation. Multiply by 2 to slow down the animation
        setExpiry(rasterMap.size() * 8);

        //everything is relative to the exploding sprite

        setCenter(new Point(305, 186));

        setRadius(50);

    }

    //In this example, we are simply in-order traversing the rasterMap once.
    //However, we could also create a looping animation; think bird flapping over and over.
    //We can also create a hybrid of looping and image-state; think Mario
    //walking (looping), standing (suspended loop), jumping (one state), crouching (another state).
    //See Falcon class for example of image-state.
    @Override
    public void draw(Graphics g) {


        renderRaster((Graphics2D) g, getRasterMap().get(index));
        //hold the image for two frames to slow down the dust cloud animation
        //we already have a simple decrement-to-zero counter with expiry; see move() method of Sprite.
        if (getExpiry() % 8 == 0) index++;


    }
}
