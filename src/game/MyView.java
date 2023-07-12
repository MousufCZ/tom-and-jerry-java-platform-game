package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Jerry jerry;
    Game game;
    GameLevel world;

    
    private Image background;
    
    public MyView(World world, Jerry jerry, int width, int height) {
        super(world, width, height);
        this.jerry = jerry;
        this.background = new ImageIcon("data/game-background.jpg").getImage();
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font = new Font("SansSerif", Font.BOLD, 16);
        g.setFont(font);
        g.setColor(Color.darkGray);
        g.drawString("Score:" + jerry.getBowlingBallCount(), 10, 30);
        g.drawString("Lives:" + jerry.getLivesCount(), 10, 48);
    }
    public void setJerry(Jerry jerry){
        this.jerry = jerry;
    }

}
