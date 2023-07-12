package game;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.AudioFormat;
import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_BOWLINGBALL = 0;

    private AudioFormat playbackFormat;
    private SoundClip gameMusic;
    //private Sound dieSound;
    //private Sound healthSound;
    //private Sound hurtSound;

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
        ground.setAngleDegrees(0.0f);


        // make the celing
        //Shape celingShape = new BoxShape(11, 0.5f);
        //ground.setPosition(new Vec2(0, 11.5f));


        // walls
        Shape leftWallShape = new BoxShape(0.5f, 10, new Vec2(-11.5f, 9.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);

        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(0.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);

        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(4, -2.5f));


        // add BowlingBalls
        for (int i = 0; i < 6; i++) {
            Body bowlingBall = new BowlingBall(this);
            bowlingBall.setPosition(new Vec2(i*4-10, 10));
            //orange.removeCollisionListener (new Pickup(jerry));
            bowlingBall.addCollisionListener(new Pickup(getJerry()));
        }
        // add Cheese
        for (int i = 0; i < 1; i++) {
            Body cheese = new Cheese(this);
            cheese.setPosition(new Vec2(i*2-9, 20));
            //orange.removeCollisionListener (new Pickup(jerry));
            cheese.addCollisionListener(new Pickup(getJerry()));
        }


        // add Tom
        /**private Random rand;
        public Tom() throws IOException{
            Body tom = new Tom(this);

            for (int i = 0; i < 1; i++)
            int tomGen = rand.nextInt(2);
            switch (tomGen){
                case 0:
                    return new Tom(this);
                    tom.setPosition(rand.nextInt(5, (rand.nextInt(100) + (Game.WIDTH - 100)), rand.nextInt(Game.HEIGHT - 200) + 50);
            }
            //orange.removeCollisionaListener (new Pickup(jerry));
            tom.addCollisionListener(new Pickup(getJerry()));

        }*/

        for (int i = 0; i < 1; i++){
            Body tom = new Tom(this);
            tom.setPosition(new Vec2(i*2-9, 15));
            //orange.removeCollisionaListener (new Pickup(jerry));
            tom.addCollisionListener(new Pickup(getJerry()));
            //((Tom) tom).applyForce(23,43);
            ((Tom) tom).setBullet(getJerry().isBullet());

            ((Tom) tom).startWalking(1);
        }


        // add boxes
        int count = 7;

        {
            float a = .5f;
            Shape shape = new BoxShape(a, a);

            float deltaX = 0.1f;
            float deltaY = 1.25f;


                for (int i = 0; i < count; ++i) {
                float y = i*deltaY + 0.75f;
                for (int j = i; j < count; ++j) {
                    float x = (5*j - i)*deltaX - 7.0f;
                    Body box = new DynamicBody(this, shape);
                    box.setPosition(new Vec2(x, y));
                    box.setFillColor(Color.black);
                }
            }
        }

        /**{
            Shape shape = new CircleShape(0.5f);
            float density = 5.0f;

            float restitution[] = new float[] { 0.0f, 0.1f, 0.3f, 1.5f, 0.75f,
                    0.9f, 1.0f };

            for (int i = 0; i < restitution.length; ++i) {
                DynamicBody body = new DynamicBody(this);
                body.setPosition(new Vec2(-10.0f + 3.0f * i, 10.0f));
                SolidFixture fixture = new SolidFixture(body, shape, density);
                fixture.setRestitution(restitution[i]);
            }
        }


        { // Dominoes
            Shape shape = new BoxShape(0.125f, 2f);

            float density = 25.0f;
            float friction = .5f;
            int numPerRow = 10;

            for (int i = 0; i < 1; ++i) {
                for (int j = 0; j < numPerRow; j++) {
                    DynamicBody domino = new DynamicBody(this);
                    SolidFixture fixture = new SolidFixture(domino, shape, density);
                    fixture.setFriction(friction);
                    float x = -14.75f + j * (29.5f / (numPerRow - 1));
                    float y = 7.3f + 5f * i;
                    float angle = 0;
                    if (i == 1 && j == 0) {
                        angle = -0.1f;
                        x += .1f;
                    } else if (i == 1 && j == numPerRow - 1) {
                        angle = .1f;
                        x -= .1f;
                    }
                    domino.setPosition(new Vec2(x, y));
                    domino.setAngle(angle);
                }
            }
        }*/




        // Load Music
        //private static final AudioFormat PLAYBACK_FORMAT =
        //        new AudioFormat(22050, 16, 1, true, false);
        //SoundClip soundClip = new SoundClip(String.valueOf(PLAYBACK_FORMAT));
        //dieSound = new dieSound ("data/");

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
    public Color getBackgroundColor() {return Color.YELLOW;}
}
