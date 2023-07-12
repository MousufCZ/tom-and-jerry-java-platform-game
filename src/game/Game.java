package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Tom & Jerry
 * Mousuf C Zaman
 * Reg No: 180021356
 * The frame is currently in grid debugging view. I will be introducing auto scroll from left >>>> right once platforms and obstacles are created.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic;
    private Jerry jerry;


    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);


        // Add Music

        try {
            gameMusic = new SoundClip("data/music/level_1_music.mid");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        // make a view
        view = new MyView(world, world.getJerry(), 500,  500);
        view.setBackground(world.getBackgroundColor());
        view.setZoom(12);



        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);


        // display the view in a frame
        final JFrame frame = new JFrame("Tom and Jerry");


        // Adding a Game Panel
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.SOUTH);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);


        // display the world in the window
        frame.add(view);


        // don't let the game window be resized
        frame.setResizable(false);


        // size the game window to fit the world view
        frame.pack();


        // make the window visible
        frame.setVisible(true);


        // get keyboard focus
        frame.requestFocus();

        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        //
        MouseTest mt = new MouseTest();
        view.addMouseListener(mt);

        controller = new Controller(world.getJerry());
        frame.addKeyListener(controller);
/**
        // add a wide angle view of the world
        UserView wideView = new UserView(world, 500, 100);
        wideView.setZoom(2);
        wideView.setBackground(Color.GRAY);
        frame.add(wideView, BorderLayout.EAST);*/

        // uncomment to make the view track the bird
        world.addStepListener(new Tracker(view, world.getJerry()));

        // Add firing bowling/golfball
        view.addMouseListener(new GolfBallFire(view, getJerry()));


        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(world, 500, 500);



        // start!
        world.start();
    }

    /** Jerry in the current level. */
    public Jerry getJerry() {return world.getJerry();}

   // public World getWorld(){
   //     return world;
   // }
   // public int getLevel(){
   //     return level;
   //}
   // public Lives getLivesCount(){
   //     return world.getJerry().setLivesCount());
   // }
   // public Score getBlowlingBallCount() {
   //     return world.getJerry().setBowlingBallCount();
   // }



    /** Is the current level of the game finished?
     * @param b*/
    public boolean isCurrentLevelCompleted(boolean b) {
        return world.isCompleted();
    }


    /** Advancing to next levels */
    public void goNextLevel() {
        world.stop();

        Jerry oldJerry = world.getJerry();

        //int livesCount = world.getJerry().getLivesCount();
        //int bowlingBallCount = world.getJerry().getBowlingBallCount();

        if (level == 3){
            System.exit(0);

        } else if (level == 1){
            level ++;

            // get a new world
            world = new Level2();

            // fill it with bodies
            world.populate (this);

            // switch the keyboard control to the new player
            controller.setBody(world.getJerry());

            // carrying on BowlinBallCount
            world.getJerry().setBowlingBallCount(oldJerry.getBowlingBallCount());

            // carrying on Lives
            world.getJerry().setLivesCount(oldJerry.getLivesCount());

            // Add firing bowling/golfball
            view.addMouseListener(new GolfBallFire(view, getJerry()));

            // uncomment to make the view track the bird
            world.addStepListener(new Tracker(view, world.getJerry()));

            // uncomment this to make a debugging view
            JFrame debugView = new DebugViewer(world, 500, 500);

            view.setZoom(8);

            // show the new world in the new view
            view.setWorld(world);

            //world.getJerry().setLivesCount(lives);
            //world.getJerry().getBowlingBallCount(score);


            world.start();

        } else if (level == 2){
            level ++;

            // get a new world
            world = new LevelB();

            // fill it with bodies
            world.populate (this);

            // switch the keyboard control to the new player
            controller.setBody(world.getJerry());

            // carrying on BowlinBallCount
            world.getJerry().setBowlingBallCount(oldJerry.getBowlingBallCount());


            // carrying on Lives
            world.getJerry().setLivesCount(oldJerry.getLivesCount());


            // show the new world in the new view
            view.setWorld(world);

            // Add firing bowling/golfball
            view.addMouseListener(new GolfBallFire(view, getJerry()));


            // uncomment to make the view track the bird
            world.addStepListener(new Tracker(view, world.getJerry()));


            //world.getJerry().setLivesCount(lives);
            //world.getJerry().getBowlingBallCount(score);


            // uncomment this to make a debugging view
            JFrame debugView = new DebugViewer(world, 500, 500);

            //game exits if Jerry looses all lives

            //if(getJerry().getLivesCount());
              //  System.exit(0);


            view.setZoom(12);

            world.start();
        }

    }

    public void pause(){
        world.stop();

    }

    public void restart(){
        world.start();

    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
     
        
    }
}
