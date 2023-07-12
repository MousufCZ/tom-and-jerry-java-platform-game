package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BounceOfRightWall implements CollisionListener {
    private Tom tom;
    private BounceOfWall bounceOfWall;

    public BounceOfRightWall(Tom tom, BounceOfWall bounceOfRightWall){
        this.tom = tom;
        this.bounceOfWall = bounceOfRightWall;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == tom && this.bounceOfWall.equals(bounceOfWall)) {
            e.getOtherBody().equals(tom);
            tom.startWalking(1);
        }
    }

}
