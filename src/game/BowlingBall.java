package game;

import city.cs.engine.*;

/**
 * A bowling ball. This will be used for jerry to pick up as ammunition and projectile at Tom.
 * Current stage, Milestone 1 - Jerry picks up bowlingball.
 */
public class BowlingBall extends DynamicBody {

    private static final float radius = 0.4f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
        new BodyImage("data/bowl.png", 2*radius);

    /**
     * Construct a bowling ball.
     * world - the world in which this body exists.
     */
    public BowlingBall(World world) {
        super(world, ballShape);
        addImage(ballImage);
    }
}
