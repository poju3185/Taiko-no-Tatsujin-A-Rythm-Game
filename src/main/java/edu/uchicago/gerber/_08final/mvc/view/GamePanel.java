package edu.uchicago.gerber._08final.mvc.view;

import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;


public class GamePanel extends JPanel {

    // ==============================================================
    // FIELDS
    // ==============================================================
    private final Font fontNormal = new Font("Arial", Font.BOLD, 16);
    private final Font fontBig = new Font("Arial", Font.BOLD, 24);
    private FontMetrics fontMetrics;
    private int fontWidth;
    private int fontHeight;

    //used to draw number of ships remaining

    //used for double-buffering
    private Image imgOff;

    //    private BufferedImage pauseImage;
    private final BufferedImage bgImage;
    private BufferedImage imgOn;
    private final BufferedImage pauseImage;


    // ==============================================================
    // CONSTRUCTOR
    // ==============================================================

    public GamePanel(Dimension dim) {

        GameFrame gameFrame = new GameFrame();

        gameFrame.getContentPane().add(this);

        // Robert Alef's awesome falcon design


        gameFrame.pack();
        initFontInfo();
        gameFrame.setSize(dim);
        //change the name of the game-frame to your game name
        gameFrame.setTitle("Game Base");
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
        setFocusable(true);
        try {
            bgImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/background/bg.png")));
            pauseImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/background/pause.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // ==============================================================
    // METHODS
    // ==============================================================

    private void drawScore(final Graphics graphics) {


        graphics.setColor(Color.WHITE);
        graphics.setFont(fontBig);

        //draw score always
        graphics.drawString("" + CommandCenter.getInstance().getScore(), 60, 159);
        graphics.drawString("Combo :  " + CommandCenter.getInstance().getCombo(), 250, 40);


    }

    //this is used for development, you can remove it from your final game
    private void drawNumFrame(Graphics g) {
        g.setColor(Color.white);
        g.setFont(fontNormal);
        g.drawString("FRAME :  " + CommandCenter.getInstance().getFrame(), fontWidth,
                Game.DIM.height - (fontHeight + 22));

    }

    private void drawMusicFrame(Graphics g) {
        g.setColor(Color.white);
        g.setFont(fontNormal);
        g.drawString("Music Frame :  " + CommandCenter.getInstance().getMusicFrame(), fontWidth,
                Game.DIM.height - (fontHeight + 122));
    }

    private void drawSongName(Graphics g, String name) {
        g.setColor(Color.WHITE);
        g.setFont(fontBig);
        g.drawString(name, 721, 44);
    }

    public void update(Graphics g) {

        Graphics grpOff;
        if (CommandCenter.getInstance().isGameOver()) {
            // The following "off" vars are used for the off-screen double-buffered image.
            imgOff = deepCopy(pauseImage);
            //get its graphics context
            grpOff = imgOff.getGraphics();
            displayTextOnScreen(grpOff,
                    "GAME OVER",
                    "YOUR SCORE IS " + CommandCenter.getInstance().getScore(),
                    "Select a song: ",
                    "'1': Racing Into The Night (Easy)     '2': world.execute(me); (Hard)",
                    "'P' to Pause",
                    "'F / J' Don (red node)",
                    "'E / I' Kat (blue node)"

            );
        } else if (CommandCenter.getInstance().isPaused()) {
            // The following "off" vars are used for the off-screen double-buffered image.
            imgOff = deepCopy(pauseImage);
            //get its graphics context
            grpOff = imgOff.getGraphics();
            displayTextOnScreen(grpOff, "Game Paused", "'P' To Resume", "'R' To Restart");

        }

        //playing and not paused!
        else {

            imgOn = deepCopy(bgImage);

            //get its graphics context
            Graphics grpOn = imgOn.getGraphics();
            //this is used for development, you may remove drawNumFrame() in your final game.
//            drawNumFrame(grpOn);
//            drawMusicFrame(grpOn);
            drawSongName(grpOn, CommandCenter.getInstance().getSongName());

            moveDrawMovables(grpOn,
                    CommandCenter.getInstance().getNodes(),
                    CommandCenter.getInstance().getEffects(),
                    CommandCenter.getInstance().getHitBoxes()
            );
            drawScore(grpOn);

        }

        //after drawing all the movables or text on the offscreen-image, copy it in one fell-swoop to graphics context
        // of the game panel, and show it for ~40ms. If you attempt to draw sprites directly on the gamePanel, e.g.
        // without the use of a double-buffered off-screen image, you will see flickering.
        if (CommandCenter.getInstance().isPaused() || CommandCenter.getInstance().isGameOver()) {
            g.drawImage(imgOff, 0, 0, this);
        } else {
            g.drawImage(imgOn, 0, 0, this);
        }
    }


    //this method causes all sprites to move and draw themselves
    @SafeVarargs
    private final void moveDrawMovables(final Graphics g, List<Movable>... teams) {

        BiConsumer<Movable, Graphics> moveDraw = (mov, grp) -> {
            mov.move();
            mov.draw(grp);
        };


        Arrays.stream(teams) //Stream<List<Movable>>
                //we use flatMap to flatten the teams (List<Movable>[]) passed-in above into a single stream of Movables
                .flatMap(Collection::stream) //Stream<Movable>
                .forEach(m -> moveDraw.accept(m, g));


    }


    // Draw the number of falcons remaining on the bottom-right of the screen.


    private void initFontInfo() {
        Graphics g = getGraphics();            // get the graphics context for the panel
        g.setFont(fontNormal);                        // take care of some simple font stuff
        fontMetrics = g.getFontMetrics();
        fontWidth = fontMetrics.getMaxAdvance();
        fontHeight = fontMetrics.getHeight();
        g.setFont(fontBig);                    // set font info
    }


    // This method draws some text to the middle of the screen
    private void displayTextOnScreen(final Graphics graphics, String... lines) {
        graphics.setFont(fontNormal);
        graphics.setColor(Color.white);
        //AtomicInteger is safe to pass into a stream
        final AtomicInteger spacer = new AtomicInteger(0);
        Arrays.stream(lines)
                .forEach(str ->
                        graphics.drawString(str, (Game.DIM.width - fontMetrics.stringWidth(str)) / 2,
                                Game.DIM.height / 10 + fontHeight + spacer.getAndAdd(50))
                );


    }

    // https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
    // Clone an image
    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
