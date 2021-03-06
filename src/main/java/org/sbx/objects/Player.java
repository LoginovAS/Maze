package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.Site;
import org.sbx.exceptions.Errors;
import org.sbx.exceptions.GameplayException;
import org.sbx.service.Classes;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by aloginov on 10.10.16.
 */
public class Player extends Observable{

    private static final Logger logger = LogManager.getLogger(Player.class);
    private int currentRoomId;

    private void move(Direction direction)  throws GameplayException{
        Site site = Maze.getRooms().get(currentRoomId).getSites().get(direction);
        if (site.getClass().toString().contains(Classes.CLASS_DOOR))
            try {
                this.currentRoomId = Maze.getNeighbourId(direction);
                setChanged();
                notifyObservers();
                Maze.setCurrentRoom(this.currentRoomId);
            } catch (GameplayException ge){
                logger.error(ge.getErrorMessage(), ge.getErrorCode());
            }
        else if (site.getClass().toString().contains(Classes.CLASS_WALL))
            throw new GameplayException(Errors.DIRECTION_WALL_ERROR);

    }

    public void setCurrentRoomId(int roomId){
        this.currentRoomId = roomId;
        setChanged();
        notifyObservers();
    }

    public void moveUp(){
        try {
            move(Direction.NORTH);
        } catch (GameplayException ex){
            logger.warn(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveDown(){
        try {
            move(Direction.SOUTH);
        } catch (GameplayException ex){
            logger.warn(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveRight(){
        try {
            move(Direction.EAST);
        } catch (GameplayException ex){
            logger.warn(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveLeft(){
        try {
            move(Direction.WEST);
        } catch (GameplayException ex){
            logger.warn(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public int getCurrentRoomId(){
        return currentRoomId;
    }
}
