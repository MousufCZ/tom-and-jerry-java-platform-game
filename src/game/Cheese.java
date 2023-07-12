package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

import java.awt.*;

/**
 * Cheese adds extra lives to Jerry.
 */
public class Cheese extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    
    public Cheese(World world) {
        super(world, shape);
        setFillColor(Color.yellow);
    }
}
