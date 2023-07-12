package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Jerry jerry;
    private Spikes spikes;
    private Tom tom;
    private BowlingBall bowlingBall;


    protected GameLevel() {
    }

    public Jerry getJerry() {
        return jerry;
    }


    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        jerry = new Jerry (this);
        jerry.setPosition(startPosition());

        //spikes = new Spikes(this);
        //spikes.setPosition(this);

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    /** Game background */
    public abstract Color   getBackgroundColor();

}
