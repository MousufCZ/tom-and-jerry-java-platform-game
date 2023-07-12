package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * I will be using Collision listener to pickup various types of ammunition and and projectile at Tom, lose lives, interact with additional enemy
 * characters. Jerry will also be able to pick up lives from friendly characters.
 * Current status - Milestone 1 - Collision listener allows jerry to:
 * > collect bowling ball / ammunition.
 * > lose lives
 */
public class Pickup implements CollisionListener {
    private Jerry jerry;
    private Tom tom;
    private GolfBall golfBall;
    private static SoundClip hitSound;
    private static SoundClip pointSound;
    private static SoundClip lifeSound;
    private static SoundClip killSound;


    
    public Pickup(Jerry jerry) {
        this.jerry = jerry;
    }
    public Pickup(Tom tom) {
        this.tom = tom;
    }
    public Pickup(GolfBall golfBall) {this.golfBall = golfBall; }



        // Sound clips

        static {
        try {
            hitSound = new SoundClip("data/music/hit.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

        static {
        try {
            pointSound = new SoundClip("data/music/point.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

        static {
        try {
            lifeSound = new SoundClip("data/music/life.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    static {
        try {
            killSound = new SoundClip("data/music/kill.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }



    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof BowlingBall && e.getOtherBody() == jerry) {
            jerry.incrementBowlingBallCount();
            pointSound.play();
            e.getReportingBody().destroy();
        }
        else if (e.getReportingBody() instanceof Tom && e.getOtherBody() == jerry){
            jerry.decrementLivesCount();
            hitSound.play();
            e.getReportingBody().destroy();
        }
        else if (e.getReportingBody() instanceof Cheese && e.getOtherBody() == jerry){
            jerry.incrementLivesCount();
            lifeSound.play();
            e.getReportingBody().destroy();
        }
        else if (e.getReportingBody() instanceof Spikes && e.getOtherBody() == jerry){
            hitSound.play();
            jerry.decrementLivesCount();
        }
        if (e.getReportingBody() instanceof GolfBall && e.getOtherBody() == tom) {
            killSound.play();
            e.getReportingBody().destroy();
        }
    }
}
