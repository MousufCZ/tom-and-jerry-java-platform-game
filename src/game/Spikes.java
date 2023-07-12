package game;

import city.cs.engine.*;

/**
 * Tom is he the decrement walker towards Jerry's health. Tom's characteristics in the game are following
 * > He will follow Jerry through out the game, including jumping over obstacles.
 * > His health will continue to auto-recover slowly
 * > He cannot be killed but can be damaged through bowlingball projectiles.
 * Current status - Milestone 1 - Tom is a static walker, causing decrement to Jerry's life.
 */

public class Spikes extends Walker {
    // I will the keyword static below for fields shape and image for class, rather than any instance.
    // There is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -2.661f,0.938f, 2.709f,0.986f, 2.997f,-0.74f, 1.463f,-0.884f, -0.551f,-0.932f, -3.045f,-0.86f, -3.045f,0.291f, -2.949f,0.794f);

    private static final BodyImage image =
            new BodyImage("data/spikes.png", 0.80f);



    public Spikes(World world) {
        super(world, shape);
        addImage(image);
    }

    //public void setPosition(GameLevel gameLevel) {
    //}


    /**public int getBowlingBallCount() {
     return bowlingBallCount;
     }

     public void incrementBowlingBallCount() {
     bowlingBallCount++;
     System.out.println("Weapon!  Another Bowling Ball = " + bowlingBallCount);
     }
     }**/

}
