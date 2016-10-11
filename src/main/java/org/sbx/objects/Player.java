package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.exceptions.GameplayException;

import javax.swing.*;

/**
 * Created by aloginov on 10.10.16.
 */
public class Player {

    private static final Logger logger = LogManager.getLogger(Player.class);
    private int currentRoomId;

    private void move(Direction direction){
        try {
            this.currentRoomId = Maze.getNeighbourId(direction);
            logger.error(this.currentRoomId);
            logger.error(Maze.getNeighbourId(direction));
        } catch (GameplayException ge){
            logger.error(ge.getErrorMessage(), ge.getErrorCode());
        }
    }

    public void setCurrentRoomId(int roomId){
        this.currentRoomId = roomId;
    }

    public void moveUp(){
        move(Direction.NORTH);
    }

    public void moveDown(){
        move(Direction.SOUTH);
    }

    public void moveRight(){
        move(Direction.EAST);
    }

    public void moveLeft(){
        move(Direction.WEST);
    }

    public int getCurrentRoomId(){
        return currentRoomId;
    }
}
