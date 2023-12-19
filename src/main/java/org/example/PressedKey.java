package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PressedKey implements KeyListener {
    private int lastNumberPressed;
    public PressedKey() {
        lastNumberPressed = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            lastNumberPressed = 1;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getLastNumberPressed() {
        return lastNumberPressed;
    }

}
