package game;

import city.cs.engine.*;

/**
 * Jerry is the main character/walker in the game.
 * There are no additional images or png style gifs to use array in creating motion. I am looking for a solution.
 * Current status - milestone 1 - Jerry is:
 * > controlled by keyboard
 * > interacts with Bowling Ball in collecting/picking up ammunition
 * > loses life when interacting with Tom.
 * > is tracked in view
 */
public class Jerry extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.746f,0.504f, 1.181f,-0.071f, 0.774f,-0.697f, -0.622f,-0.709f, -0.894f,-0.501f, -0.998f,-0.106f, -0.998f,0.352f, 0.088f,0.504f);

    private static final BodyImage image =
            new BodyImage("data/player/jerry_right.png", 1.25f);

    private int bowlingBallCount;
    private int livesCount;
    private int cheese;
    private int spikes;


    public Jerry(World world) {
        super(world, shape);
        addImage(image);
        bowlingBallCount = 0;
        livesCount = 3;
        cheese = 0;
        spikes = 0;
    }

    public int getBowlingBallCount() {
        return bowlingBallCount;
    }
    public int getLivesCount () {return livesCount; }
    public int getCheese () {return cheese; }
    public int getSpikes () {return spikes; }

    public void incrementBowlingBallCount() {
        bowlingBallCount++;
        System.out.println("Weapon!  Another Bowling Ball = " + bowlingBallCount);
    }


    public void decrementLivesCount() {
        livesCount--;
        System.out.println("Ffs, it's Tom again!!! = " + livesCount);
    }


    public void incrementLivesCount() {
        livesCount++;
        System.out.println("Extra Lives :D = " + livesCount);
    }

    public void decrementLivesCont() {
        livesCount--;
        System.out.println("Ffs, that hurt!!! = " + livesCount);
    }


    public void setBowlingBallCount(int bcnt) {
       bowlingBallCount = bcnt;
    }


    public void setLivesCount(int lcnt) {
        livesCount = lcnt;
    }

}
