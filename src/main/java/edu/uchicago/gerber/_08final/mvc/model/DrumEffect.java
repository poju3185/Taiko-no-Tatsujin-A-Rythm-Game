package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DrumEffect extends Effect {
    private final String type;

    public DrumEffect(String type) {

        this.type = type;

        if (Objects.equals(type, "rightDon") || Objects.equals(type, "leftDon")) {
            setCenter(new Point(182, 181));
            setRadius(38);
        } else if (Objects.equals(type, "rightKat")) {
            setCenter(new Point(187, 181));
            setRadius(41);
        } else if (Objects.equals(type, "leftKat")) {
            setCenter(new Point(183, 182));
            setRadius(45);
        }


        Map<String, BufferedImage> rasterMap = new HashMap<>();
        //see readme.txt file in the resources/imgs/exp directory for how I created these assets
        rasterMap.put("rightDon",

                loadGraphic("/imgs/exp/right_don.png"));
        rasterMap.put("rightKat",

                loadGraphic("/imgs/exp/right_kat.png"));
        rasterMap.put("leftDon",

                loadGraphic("/imgs/exp/left_don.png"));
        rasterMap.put("leftKat",

                loadGraphic("/imgs/exp/left_kat.png"));


        setRasterMap(rasterMap);

        //expire it out after it has done its animation. Multiply by 2 to slow down the animation
//        setExpiry(rasterMap.size() * 2);
        setExpiry(12);


    }

    //In this example, we are simply in-order traversing the rasterMap once.
    //However, we could also create a looping animation; think bird flapping over and over.
    //We can also create a hybrid of looping and image-state; think Mario
    //walking (looping), standing (suspended loop), jumping (one state), crouching (another state).
    //See Falcon class for example of image-state.
    @Override
    public void draw(Graphics g) {

        renderRaster((Graphics2D) g, getRasterMap().get(type));


    }

}
