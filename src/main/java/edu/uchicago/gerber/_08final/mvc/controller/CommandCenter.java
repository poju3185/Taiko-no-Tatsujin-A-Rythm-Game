package edu.uchicago.gerber._08final.mvc.controller;


import edu.uchicago.gerber._08final.mvc.model.*;
import lombok.Data;
import lombok.Getter;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//The CommandCenter is a singleton that manages the state of the game.
//the lombok @Data gives us automatic getters and setters on all members
@Data
public class CommandCenter {


    private int level;
    private long score;
    private int combo;
    private boolean paused;
    private boolean muted;
    private String songName;
    //if the number of falcons is zero, then game over
    @Getter
    private boolean gameOver = true;

    //this value is used to count the number of frames (full animation cycles) in the game
    private long frame;
    private int musicFrame;

    //the falcon is located in the movFriends list, but since we use this reference a lot, we keep track of it in a
    //separate reference. Use final to ensure that the falcon ref always points to the single falcon object on heap.
    //Lombok will not provide setter methods on final members

    //lists containing our movables subdivided by team
    private final List<Movable> hitBoxes = new LinkedList<>();
    private final List<Movable> nodes = new LinkedList<>();
    private final List<Movable> effects = new LinkedList<>();

    private final GameOpsQueue opsQueue = new GameOpsQueue();

    //for sound playing. Limit the number of threads to 5 at a time.
    private final ThreadPoolExecutor soundExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    //singleton
    private static CommandCenter instance = null;

    // Constructor made private
    private CommandCenter() {
    }

    //this class maintains game state - make this a singleton.
    public static CommandCenter getInstance() {
        if (instance == null) {
            instance = new CommandCenter();
        }
        return instance;
    }


    public void initGame(String songName) {
        clearAll();
        setLevel(0);
        setScore(0);
        setCombo(0);
        setPaused(false);
        setMusicFrame(0);
        setSongName(songName);
        //set to one greater than number of falcons lives in your game as initFalconAndDecrementNum() also decrements
        setGameOver(false);
//		initFalconAndDecrementFalconNum();
        //add the falcon to the movFriends list
//		opsQueue.enqueue(falcon, GameOp.Action.ADD);
    }

    public void endGame() {
        setGameOver(true);
        setMusicFrame(0);
    }


    public void incrementFrame() {
        //use of ternary expression to simplify the logic to one line
        frame = frame < Long.MAX_VALUE ? frame + 1 : 0;
    }

    public void incrementMusicFrame() {
        //use of ternary expression to simplify the logic to one line
        musicFrame = musicFrame < Integer.MAX_VALUE ? musicFrame + 1 : 0;
    }

    private void clearAll() {
        hitBoxes.clear();
        nodes.clear();
    }

    public int calculateScore(int score, int combo) {
        if (combo < 10) return score;
        if (combo < 50) return (int) (score * 1.4);
        return (score * 2);
    }

}
