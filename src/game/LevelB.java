package game;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 1 of the game
 */
public class LevelB extends GameLevel {

    private static final int NUM_BOWLINGBALL = 1;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));


        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);


        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(4, -2.5f));
        platform1.setAngleDegrees(2.5f);


        Body platform3 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(4,  2.5f));

        Body platform4 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(8, -5.5f));


        // add Cheese
        for (int i = 0; i < 8; i++) {
            Body cheese = new Cheese(this);
            cheese.setPosition(new Vec2(i*2-9, 20));
            //orange.removeCollisionListener (new Pickup(jerry));
            cheese.addCollisionListener(new Pickup(getJerry()));
        }

        { // Dominoes
            Shape shape = new BoxShape(0.125f, 2f);

            float density = 25.0f;
            float friction = .5f;
            int numPerRow = 10;

            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < numPerRow; j++) {
                    DynamicBody domino = new DynamicBody(this);
                    SolidFixture fixture = new SolidFixture(domino, shape, density);
                    fixture.setFriction(friction);
                    float x = -14.75f + j * (29.5f / (numPerRow - 1));
                    float y = 7.3f + 5f * i;
                    float angle = 0;
                    if (i == 2 && j == 0) {
                        angle = -0.1f;
                        x += .1f;
                    }
                    domino.setPosition(new Vec2(x, y));
                    domino.setAngle(angle);
                }
            }
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {return getJerry().getBowlingBallCount() >= NUM_BOWLINGBALL; }

    @Override
    public Color getBackgroundColor() {return Color.GREEN;}

}
