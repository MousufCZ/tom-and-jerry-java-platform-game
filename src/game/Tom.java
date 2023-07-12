package game;

import city.cs.engine.*;

/**
 * Tom is he the decrement walker towards Jerry's health. Tom's characteristics in the game are following
 * > He will follow Jerry through out the game, including jumping over obstacles.
 * > His health will continue to auto-recover slowly
 * > He cannot be killed but can be damaged through bowlingball projectiles.
 * Current status - Milestone 1 - Tom is a static walker, causing decrement to Jerry's life.
 */

public class Tom extends Walker {


    private Tom tom;
    private static SoundClip killSound;


    // I will the keyword static below for fields shape and image for class, rather than any instance.
    // There is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.116f,1.25f, 1.131f,0.55f, 1.376f,-1.165f, 1.111f,-1.375f, -0.624f,-1.355f, -1.124f,0.08f, -1.124f,1.0f, -0.739f,1.275f);

    private static final BodyImage image =
            new BodyImage("data/tom_left.png", 2.50f);


    private int tomDamage;
    private int golfBall;


    public Tom(World world) {
        super(world, shape);
        addImage(image);
        tomDamage = 1;
    }

    public int getGolfBall () {return golfBall; }


    public int getTomDamage () {return tomDamage; }

    public void decrementLivesCount() {
        tomDamage--;
        System.out.println("Got yaa tom! = " + getTomDamage());
    }

}
