package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TimingEffect extends Effect{
    public TimingEffect(String type) {

        //EFFECTS means that this sprite is inert, and does not interact with other teams.
        super.setType(type);

//        if (Objects.equals(super.getType(), "Good")) {
            setCenter(new Point(300, 115));
            setRadius(22);
//        } else if (Objects.equals(super.getType(), "OK")) {
//            setCenter(new Point(300, 141));
//            setRadius(38);
//        }else if (Objects.equals(super.getType(), "Bad")) {
//            setCenter(new Point(300, 141));
//            setRadius(38);
//        }


        Map<String, BufferedImage> rasterMap = new HashMap<>();
        //see readme.txt file in the resources/imgs/exp directory for how I created these assets
        rasterMap.put("Good",

                loadGraphic("/imgs/exp/good.png"));
        rasterMap.put("OK",

                loadGraphic("/imgs/exp/ok.png"));
        rasterMap.put("Bad",

                loadGraphic("/imgs/exp/bad.png"));



        setRasterMap(rasterMap);

        //expire it out after it has done its animation. Multiply by 2 to slow down the animation
//        setExpiry(rasterMap.size() * 2);
        setExpiry(16);


    }

    //In this example, we are simply in-order traversing the rasterMap once.
    //However, we could also create a looping animation; think bird flapping over and over.
    //We can also create a hybrid of looping and image-state; think Mario
    //walking (looping), standing (suspended loop), jumping (one state), crouching (another state).
    //See Falcon class for example of image-state.
    @Override
    public void draw(Graphics g) {

        renderRaster((Graphics2D) g, getRasterMap().get(super.getType()));


    }
}
