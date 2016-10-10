package org.sbx.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by aloginov on 10.10.16.
 */
public class VisualPlayer extends AbstractVisual {

    public JButton p = new JButton();

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void init(){
        p.setBounds(x, y, width, height);
        p.addKeyListener(new Move());
    }

    public void moveUp(){
        p.setBounds(x, y-=height, width, height);
        p.repaint();
    }

    public void moveDown(){
        p.setBounds(x, y+=height, width, height);
        p.repaint();
    }

    public void moveLeft(){
        p.setBounds(x-=width, y, width, height);
        p.repaint();
    }

    public void moveRight(){
        p.setBounds(x+=width, y, width, height);
        p.repaint();
    }

    private class Move implements KeyListener {

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W: case KeyEvent.VK_UP:
                    moveUp();
                    break;
                case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                    moveDown();
                    break;
                case KeyEvent.VK_A:case KeyEvent.VK_LEFT:
                    moveLeft();
                    break;
                case KeyEvent.VK_D:case KeyEvent.VK_RIGHT:
                    moveRight();
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {

        }
    }

    public JButton getPlayer(){
        return p;
    }
}
