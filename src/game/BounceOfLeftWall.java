package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BounceOfLeftWall implements CollisionListener {
    private Tom tom;
    private BounceOfWall bounceOfWall;

    public BounceOfLeftWall(Tom tom, BounceOfWall bounceOfLeftWall){
        this.tom = tom;
        this.bounceOfWall = bounceOfLeftWall;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == tom && this.bounceOfWall.equals(bounceOfWall)) {
            e.getOtherBody().equals(tom);
            tom.startWalking(-1);
        }
    }

}
