package game;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_BOWLINGBALL = 1;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(15, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        // Modifiy image to fit ground
        ground.addImage(new BodyImage("data/Level2/ground.png"));

        // underground ground
        Shape undergroundShape = new BoxShape(30, 0.5f);
        Body underground = new StaticBody(this, undergroundShape);
        underground.setPosition(new Vec2(2, -25.5f));
        //underground.addImage(new BodyImage("data/spikes.png"));

        {
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 8);
            Body leftWall = new StaticBody(this, leftWallShape);
            leftWall.setPosition(new Vec2(-14.5f, -4));
            leftWall.addImage(new BodyImage("data/Level2/leftWall.png", 16.0f));
            // Right Wall
            Shape rightWallShape = new BoxShape(0.5f, 10);
            Body rightWall = new StaticBody(this, rightWallShape);
            rightWall.setPosition(new Vec2(14.5f, -1));
            rightWall.addImage(new BodyImage("data/Level2/rightWall.png", 20.0f));
        }


        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(4, -2.5f));

        // add Spikes
        for (int i = 0; i < 4; i++) {
            Body spikes = new Spikes(this);
            spikes.setPosition(new Vec2(i*15, 2));
            //orange.removeCollisionaListener (new Pickup(jerry));
            spikes.addCollisionListener(new Pickup(getJerry()));
        }

        // add BowlingBalls
        for (int i = 0; i < 12; i++) {
            Body bowlingBall = new BowlingBall(this);
            bowlingBall.setPosition(new Vec2(i*2-10, 9));
            //bowlingBall.removeCollisionListener (new Pickup(jerry));
            bowlingBall.addCollisionListener(new Pickup(getJerry()));
        }
        // add Cheese
        for (int i = 0; i < 2; i++) {
            Body cheese = new Cheese(this);
            cheese.setPosition(new Vec2(i*13-9, 15));
            //cheese.removeCollisionListener (new Pickup(jerry));
            cheese.addCollisionListener(new Pickup(getJerry()));
        }
        // add Tom
        for (int i = 0; i < 2; i++){
            Body tom = new Tom(this);
            tom.setPosition(new Vec2(i*2-9, 15));
            //orange.removeCollisionaListener (new Pickup(jerry));
            tom.addCollisionListener(new Pickup(getJerry()));
        }

        int e_count = 7;

            {
                ground.setPosition(new Vec2(0.0f, -20.0f));
            }

            {
                Shape shape = new CircleShape(1.0f);

                for (int i = 0; i < e_count; ++i) {
                    Body body = new DynamicBody(this, shape);
                    body.setPosition(new Vec2(0.0f, 4.0f + 3.0f * i));
                }
            }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-11.4f, 7.5f);
    }

    @Override
    public boolean isCompleted() {
        return getJerry().getBowlingBallCount() >= NUM_BOWLINGBALL;
    }
    @Override
    public Color getBackgroundColor() {return Color.WHITE;
    }

}
