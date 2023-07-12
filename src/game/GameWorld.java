package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A world with some bodies.
 */

public class GameWorld extends World {
    private Jerry jerry;
    private Tom tom;
    
    public GameWorld() {
        super();
        

        // make a character
        jerry = new Jerry(this);
        jerry.setPosition(new Vec2(6, -10));

        tom = new Tom(this);
        tom.setPosition(new Vec2(5, 10));
        tom.addCollisionListener(new Pickup(jerry));
        
        
        // add BowlingBalls
        for (int i = 0; i < 12; i++) {
            Body bowlingBall = new BowlingBall(this);
            bowlingBall.setPosition(new Vec2(i*2-10, 10));
            //orange.removeCollisionListener (new Pickup(jerry));
            bowlingBall.addCollisionListener(new Pickup(jerry));
        }
        // add Cheese
        for (int i = 0; i < 1; i++) {
            Body cheese = new Cheese(this);
            cheese.setPosition(new Vec2(i*2-9, 20));
            //orange.removeCollisionListener (new Pickup(jerry));
            cheese.addCollisionListener(new Pickup(jerry));
        }
    }
    
    public Jerry getPlayer() {
        return jerry;
    }
}
