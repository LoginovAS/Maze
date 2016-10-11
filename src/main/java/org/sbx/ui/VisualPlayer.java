package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.objects.Maze;
import org.sbx.objects.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by aloginov on 10.10.16.
 */
public class VisualPlayer extends AbstractVisual {

    private static final Logger logger = LogManager.getLogger(VisualPlayer.class);

    private Player player = new Player();
    public JButton p = new JButton();

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void init(){
        player.setCurrentRoomId(0);
        setCoords(getVisualXById(player.getCurrentRoomId()), getVisualYById(player.getCurrentRoomId()));
        logger.error(width);
        logger.error(height);
        p.setBounds(x, y, width, height);
        p.addKeyListener(new Move());
    }

    public void moveUp(){
        player.moveUp();
    }

    public void moveDown(){
        player.moveDown();
    }

    public void moveLeft(){
        player.moveLeft();
    }

    public void moveRight(){
        player.moveRight();
    }

    private class Move implements KeyListener {

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W: case KeyEvent.VK_UP:
                    moveUp();
                    setCoords(getVisualXById(player.getCurrentRoomId()), getVisualYById(player.getCurrentRoomId()));
                    System.out.printf("Current room: %d\nX: %d\nY: %d", player.getCurrentRoomId(), x, y);
                    p.setBounds(x, y, width, height);
                    p.repaint();
                    break;
                case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                    moveDown();
                    setCoords(getVisualXById(player.getCurrentRoomId()), getVisualYById(player.getCurrentRoomId()));
                    System.out.printf("Current room: %d\nX: %d\nY: %d", player.getCurrentRoomId(), x, y);
                    p.setBounds(x, y, width, height);
                    p.repaint();
                    break;
                case KeyEvent.VK_A:case KeyEvent.VK_LEFT:
                    moveLeft();
                    setCoords(getVisualXById(player.getCurrentRoomId()), getVisualYById(player.getCurrentRoomId()));
                    System.out.printf("Current room: %d\nX: %d\nY: %d", player.getCurrentRoomId(), x, y);
                    p.setBounds(x, y, width, height);
                    p.repaint();
                    break;
                case KeyEvent.VK_D:case KeyEvent.VK_RIGHT:
                    moveRight();
                    setCoords(getVisualXById(player.getCurrentRoomId()), getVisualYById(player.getCurrentRoomId()));
                    System.out.printf("Current room: %d\nX: %d\nY: %d", player.getCurrentRoomId(), x, y);
                    p.setBounds(x, y, width, height);
                    p.repaint();
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
