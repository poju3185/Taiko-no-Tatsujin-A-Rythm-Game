package edu.uchicago.gerber._08final.mvc.controller;

import edu.uchicago.gerber._08final.mvc.model.*;
import edu.uchicago.gerber._08final.mvc.model.songs.WorldExe;
import edu.uchicago.gerber._08final.mvc.model.songs.YoruniKakeru;
import edu.uchicago.gerber._08final.mvc.view.GamePanel;
import lombok.Getter;


import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

    // ===============================================
    // FIELDS
    // ===============================================

    public static final Dimension DIM = new Dimension(1000, 530); //the dimension of the game.
    // It takes a node 231 frames to travel from the right of the panel to the hit area
    private static final int DISTANCE_OFFSET = 240;
    private final GamePanel gamePanel;
    //this is used throughout many classes.
    public static final Random R = new Random();

    public final static int ANIMATION_DELAY = 10; // milliseconds between frames

    public final static int FRAMES_PER_SECOND = 1000 / ANIMATION_DELAY;

    private final Thread animationThread;


    //key-codes
    private static final int PAUSE = 80, // p key
            QUIT = 81, // q key
            START = 83, // s key
            RETRY = 82, // r key
            RIGHT_DON = 74, // j-key
            LEFT_DON = 70, // f-key
            RIGHT_KAT = 73, // i-key
            LEFT_KAT = 69, // e-key
            SONG_1 = 49, // 1-key
            SONG_2 = 50; // 1-key
    // for possible future use
    // HYPER = 68, 					// D key
    //ALIEN = 65;                // A key
    // SPECIAL = 70; 					// fire special weapon;  F key

    private ArrayList<Clip> songList;
    private ArrayList<SongMap> songMapList;
    public Clip soundBackground;

    @Getter
    private SongMap songMap;


    // ===============================================
    // ==CONSTRUCTOR
    // ===============================================

    public Game() {

        gamePanel = new GamePanel(DIM);
        gamePanel.addKeyListener(this); //Game object implements KeyListener

        // load songs
        songList = new ArrayList<>();
        songMapList = new ArrayList<>();
        songList.add(Sound.clipForLoopFactory("yorunikakeru.wav"));
        songList.add(Sound.clipForLoopFactory("world_execute_me.wav"));
        songMapList.add(new YoruniKakeru());
        songMapList.add(new WorldExe());
        //fire up the animation thread
        animationThread = new Thread(this); // pass the animation thread a runnable object, the Game object
        animationThread.start();


    }

    // ===============================================
    // ==METHODS
    // ===============================================

    public static void main(String[] args) {
        //typical Swing application start; we pass EventQueue a Runnable object.
        EventQueue.invokeLater(Game::new);
    }

    // Game implements runnable, and must have run method
    @Override
    public void run() {

        // lower animation thread's priority, thereby yielding to the "main" aka 'Event Dispatch'
        // thread which listens to keystrokes
        animationThread.setPriority(Thread.MIN_PRIORITY);

        // and get the current time
        long startTime = System.currentTimeMillis();

        // this thread animates the scene
        while (Thread.currentThread() == animationThread) {


            //this call will cause all movables to move() and draw() themselves every ~40ms
            // see GamePanel class for details
            gamePanel.update(gamePanel.getGraphics());

            checkCollisions();

            //keep track of the frame for development purposes
            CommandCenter.getInstance().incrementFrame();
            if (!CommandCenter.getInstance().isPaused() && !CommandCenter.getInstance().isGameOver()) {
                CommandCenter.getInstance().incrementMusicFrame();
            }
            // Generate nodes according to the songMap, songMap is null before user chooses a track
            if (songMap != null) {
                int frame = (int) CommandCenter.getInstance().getMusicFrame() + DISTANCE_OFFSET;
                if (songMap.map.containsKey(frame)) {
                    String nodeType = songMap.map.get(frame);
                    if (nodeType.equals("end")) {
                        CommandCenter.getInstance().endGame();
                    }
                    CommandCenter.getInstance().getOpsQueue().enqueue(new Node(DIM, nodeType), GameOp.Action.ADD);
                }
            }
            // surround the sleep() in a try/catch block
            // this simply controls delay time between
            // the frames of the animation
            try {
                // The total amount of time is guaranteed to be at least ANIMATION_DELAY long.  If processing (update)
                // between frames takes longer than ANIMATION_DELAY, then the difference between startTime -
                // System.currentTimeMillis() will be negative, then zero will be the sleep time
                startTime += ANIMATION_DELAY;

                Thread.sleep(Math.max(0, startTime - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                // do nothing (bury the exception), and just continue, e.g. skip this frame -- no big deal
            }
        } // end while
    } // end run


    private void checkCollisions() {

        Point pntHitBoxCenter, pntNodeCenter;
        int radHitBox, radNode;

        //This has order-of-growth of O(n^2), there is no way around this.
        for (Movable hitBoxMov : CommandCenter.getInstance().getHitBoxes()) {
            for (Movable nodeMov : CommandCenter.getInstance().getNodes()) {
                HitBox hitBox = (HitBox) hitBoxMov;
                Node node = (Node) nodeMov;

                pntHitBoxCenter = hitBox.getCenter();
                pntNodeCenter = node.getCenter();
                radHitBox = hitBox.getRadius();
                radNode = node.getRadius();
                double distance = pntNodeCenter.distance(pntHitBoxCenter);

                //detect collision
                if (distance < (radHitBox + radNode)) {

                    CommandCenter.getInstance().getOpsQueue().enqueue(node, GameOp.Action.REMOVE);
//                    CommandCenter.getInstance().getOpsQueue().enqueue(hitBox, GameOp.Action.REMOVE);
                    CommandCenter.getInstance().getHitBoxes().clear();
                    // Display the timing effect
                    if (Objects.equals(hitBox.getType(), node.getType())) {
                        // Assign different timing scores based on the distance between the center of the hitbox and the center of the node.
                        if (distance <= 15) {
                            int score = CommandCenter.getInstance().calculateScore(100, CommandCenter.getInstance().getCombo());
                            CommandCenter.getInstance().setScore(CommandCenter.getInstance().getScore() + score);
                            CommandCenter.getInstance().setCombo(CommandCenter.getInstance().getCombo() + 1);
                            playComboSound();
                            CommandCenter.getInstance().getOpsQueue().enqueue(new TimingEffect("Good"), GameOp.Action.ADD);
                            CommandCenter.getInstance().getOpsQueue().enqueue(new HitEffect("Good"), GameOp.Action.ADD);
                        } else if (distance <= 30) {
                            int score = CommandCenter.getInstance().calculateScore(50, CommandCenter.getInstance().getCombo());
                            CommandCenter.getInstance().setScore(CommandCenter.getInstance().getScore() + score);
                            CommandCenter.getInstance().setCombo(CommandCenter.getInstance().getCombo() + 1);
                            playComboSound();
                            CommandCenter.getInstance().getOpsQueue().enqueue(new TimingEffect("OK"), GameOp.Action.ADD);
                            CommandCenter.getInstance().getOpsQueue().enqueue(new HitEffect("OK"), GameOp.Action.ADD);
                        } else {
                            CommandCenter.getInstance().getOpsQueue().enqueue(new TimingEffect("Bad"), GameOp.Action.ADD);
                            CommandCenter.getInstance().setCombo(0);
                        }

                    } else {
                        CommandCenter.getInstance().setCombo(0);
                    }
                    break; // every hit can only clear one node.
                }
            }//end inner for
        }//end outer for


        processGameOpsQueue();

    }//end meth


    //This method adds and removes movables to/from their respective linked-lists.
    //This method is being called by the animationThread. The entire method is locked on the intrinsic lock of this
    // Game object. The main (Swing) thread also has access to the GameOpsQueue via the
    // key event methods such as keyReleased. Therefore, to avoid mutating the GameOpsQueue while we are iterating
    // it, we also synchronize the critical sections of the keyReleased and keyPressed methods below on the same
    // intrinsic lock.
    private synchronized void processGameOpsQueue() {

        //deferred mutation: these operations are done AFTER we have completed our collision detection to avoid
        // mutating the movable linkedlists while iterating them above.
        while (!CommandCenter.getInstance().getOpsQueue().isEmpty()) {
            GameOp gameOp = CommandCenter.getInstance().getOpsQueue().dequeue();
            Movable mov = gameOp.getMovable();
            GameOp.Action action = gameOp.getAction();

            switch (mov.getTeam()) {
                case NODE:
                    if (action == GameOp.Action.ADD) {
                        CommandCenter.getInstance().getNodes().add(mov);
                    } else {
                        CommandCenter.getInstance().getNodes().remove(mov);
                    }

                    break;
                case HITBOX:
                    if (action == GameOp.Action.ADD) {
                        CommandCenter.getInstance().getHitBoxes().add(mov);
                    } else {
                        CommandCenter.getInstance().getHitBoxes().remove(mov);

                    }
                    break;

                case EFFECTS:
                    if (action == GameOp.Action.ADD) {
                        CommandCenter.getInstance().getEffects().add(mov);
                    } else { //GameOp.Operation.REMOVE
                        CommandCenter.getInstance().getEffects().remove(mov);
                    }
                    break;
            }

        }
    }


    // Varargs for stopping looping-music-clips
    private static void stopLoopingSounds(Clip... clpClips) {
        Arrays.stream(clpClips).forEach(clip -> clip.stop());
    }

    // ===============================================
    // KEYLISTENER METHODS
    // ===============================================

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (CommandCenter.getInstance().isGameOver()) {
            switch (keyCode) {
                case SONG_1:
                    soundBackground = songList.get(0);
                    songMap = songMapList.get(0);
                    CommandCenter.getInstance().initGame(songMap.songName);
                    soundBackground.setFramePosition(0);
                    soundBackground.loop(0);
                    break;
                case SONG_2:
                    soundBackground = songList.get(1);
                    songMap = songMapList.get(1);
                    CommandCenter.getInstance().initGame(songMap.songName);
                    soundBackground.setFramePosition(0);
                    soundBackground.loop(0);
                    break;
                default:
                    break;
            }
        } else if (keyCode == RETRY && CommandCenter.getInstance().isPaused()) {
            CommandCenter.getInstance().setGameOver(true);
            soundBackground.setFramePosition(0);
        } else {
            switch (keyCode) {
                case PAUSE:
                    if (!CommandCenter.getInstance().isGameOver()) {
                        CommandCenter.getInstance().setPaused(!CommandCenter.getInstance().isPaused());
                        if (CommandCenter.getInstance().isPaused()) stopLoopingSounds(soundBackground);
                        else soundBackground.loop(0);
                    }
                    break;
                case QUIT:
                    System.exit(0);
                    break;
                case RIGHT_DON:
                    CommandCenter.getInstance().getOpsQueue().enqueue(new HitBox("don"), GameOp.Action.ADD);
                    CommandCenter.getInstance().getOpsQueue().enqueue(new DrumEffect("rightDon"), GameOp.Action.ADD);
                    Sound.playSound("don.wav");
                    break;
                case LEFT_DON:
                    CommandCenter.getInstance().getOpsQueue().enqueue(new HitBox("don"), GameOp.Action.ADD);
                    CommandCenter.getInstance().getOpsQueue().enqueue(new DrumEffect("leftDon"), GameOp.Action.ADD);
                    Sound.playSound("don.wav");
                    break;
                case RIGHT_KAT:
                    CommandCenter.getInstance().getOpsQueue().enqueue(new HitBox("kat"), GameOp.Action.ADD);
                    CommandCenter.getInstance().getOpsQueue().enqueue(new DrumEffect("rightKat"), GameOp.Action.ADD);
                    Sound.playSound("kat.wav");
                    break;
                case LEFT_KAT:
                    CommandCenter.getInstance().getOpsQueue().enqueue(new HitBox("kat"), GameOp.Action.ADD);
                    CommandCenter.getInstance().getOpsQueue().enqueue(new DrumEffect("leftKat"), GameOp.Action.ADD);
                    Sound.playSound("kat.wav");
                    break;

                default:
                    break;
            }
        }

    }

    //key events are triggered by the main (Swing) thread which is listening for keystrokes. Notice that some of the
    // cases below touch the GameOpsQueue such as fire bullet and nuke.
    //The animation-thread also has access to the GameOpsQueue via the processGameOpsQueue() method.
    // Therefore, to avoid mutating the GameOpsQueue on the main thread, while we are iterating it on the
    // animation-thread, we synchronize on the same intrinsic lock. processGameOpsQueue() is also synchronized.
    @Override
    public void keyReleased(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        //show the key-code in the console
//        System.out.println(keyCode);
//
//        switch (keyCode) {
//            case MUTE:
//                CommandCenter.getInstance().setMuted(!CommandCenter.getInstance().isMuted());
//
//                if (!CommandCenter.getInstance().isMuted()) {
//                    stopLoopingSounds(soundBackground);
//                } else {
//                    soundBackground.loop(Clip.LOOP_CONTINUOUSLY);
//                }
//                break;
//
//            default:
//                break;
//        }

    }

    @Override
    // does nothing, but we need it b/c of KeyListener contract
    public void keyTyped(KeyEvent e) {
    }

    private void playComboSound() {
        int combo = CommandCenter.getInstance().getCombo();
        switch (combo) {
            case 50:
                Sound.playSound("50-combo.wav");
                break;
            case 100:
                Sound.playSound("100-combo.wav");
                break;
            case 200:
                Sound.playSound("200-combo.wav");
                break;
            case 300:
                Sound.playSound("300-combo.wav");
                break;
            default:
                break;
            }
        }

}


