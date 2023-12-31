package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A mouse listener that gives the keyboard focus to a specified component.
 * Current Status - Mouse is acknowledged when it enters and/or clicked on the game frame.
 * Currently I have no intention of including mouse to the game.
 */
public class GiveFocus extends MouseAdapter {
    private Component target;
    
    /**
     * Initialize the listener.
     * @param target the component to be given the focus on mouseEntered().
     */
    public GiveFocus(Component target) {
        this.target = target;
    }
    
    /**
     * Called when the mouse enters a component.
     * description of the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}
