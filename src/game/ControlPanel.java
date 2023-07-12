package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private Game game;
    private JButton pauseButton;
    private JButton exitButton;
    private JButton restartButton;
    private JPanel mainPanel;
    private JButton LV1Button;
    private JButton LV2Button;
    private JButton bonusLVButton;

    public ControlPanel(Game game) {

        this.game = game;

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart");
                game.restart();

            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pause");
                game.pause();            }
        });
        LV1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Let's go to Level 1");
                game.goNextLevel();
            }
        });
        LV2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Let's go to Level 2");
                game.goNextLevel();
            }
        });
        bonusLVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Let's go to the BONUS LEVEL!!!!!");
                game.goNextLevel();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }




}


