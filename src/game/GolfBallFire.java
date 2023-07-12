package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GolfBallFire extends MouseAdapter {
    private WorldView view;

    private Jerry jerry;
    private GolfBall golfBall;
    Tom tom;


    public Jerry getJerry(Jerry jerry){
        return this.jerry = jerry;
    }

    public GolfBallFire(WorldView view, Jerry jerry){
        this.view = view;
        this.jerry = jerry;
    }

    @Override
    public void mousePressed(MouseEvent e){
            DynamicBody golfBall = new GolfBall(view.getWorld());
            golfBall.setPosition(new Vec2(getJerry(jerry).getPosition().x + 1, getJerry(jerry).getPosition().y + 3));
            golfBall.setLinearVelocity(new Vec2(-10,0));
            golfBall.setAngularVelocity(0);
        }
    }

