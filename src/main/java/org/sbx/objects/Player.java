package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.Site;
import org.sbx.exceptions.Errors;
import org.sbx.exceptions.GameplayException;
import org.sbx.service.Classes;

import javax.swing.*;

/**
 * Created by aloginov on 10.10.16.
 */
public class Player {

    private static final Logger logger = LogManager.getLogger(Player.class);
    private int currentRoomId;

    private void move(Direction direction)  throws GameplayException{
        Site site = Maze.getRooms().get(currentRoomId).getSites().get(direction);
        logger.error(site.getClass().toString());
        if (site.getClass().toString().contains(Classes.CLASS_DOOR))
            try {
                this.currentRoomId = Maze.getNeighbourId(direction);
                Maze.setCurrentRoom(this.currentRoomId);
                logger.error(this.currentRoomId);
                logger.error(Maze.getNeighbourId(direction));
            } catch (GameplayException ge){
                logger.error(ge.getErrorMessage(), ge.getErrorCode());
            }
        else if (site.getClass().toString() == Classes.CLASS_WALL)
            throw new GameplayException(Errors.DIRECTION_WALL_ERROR);

    }

    public void setCurrentRoomId(int roomId){
        this.currentRoomId = roomId;
    }

    public void moveUp(){
        try {
            move(Direction.NORTH);
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveDown(){
        try {
            move(Direction.SOUTH);
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveRight(){
        try {
            move(Direction.EAST);
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public void moveLeft(){
        try {
            move(Direction.WEST);
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
        }
    }

    public int getCurrentRoomId(){
        return currentRoomId;
    }
}
