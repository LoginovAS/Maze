package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.exceptions.Errors;
import org.sbx.exceptions.GameplayException;
import org.sbx.interfaces.Buildable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aloginov on 27.09.16.
 */
public class Maze implements Buildable{

    private static final Logger logger = LogManager.getLogger(Maze.class);
    private static int size;
    private static List<Room> rooms;
    private ArrayList<Integer> neighbours = new ArrayList<Integer>();
    private static int currentRoom;

    public Maze(){
        rooms = new ArrayList<Room>();
        currentRoom = 0;
    }

    public Maze(int size){
        this.size = size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public static void setCurrentRoom(int roomId){
        currentRoom = roomId;
    }

    public void addRoom(Room room){
        rooms.add(room);
        int currentRoomId = rooms.indexOf(room);
    }

    public static List<Room> getRooms(){
        return rooms;
    }

    public Room getRoomById(int roomId){
        return rooms.get(roomId);
    }

    public void changeRoom(int roomId, Room room){
        this.rooms.set(roomId, room);
    }

    public static int getSize(){
        return  size;
    }

    public static int getNeighbourId(Direction direction) throws GameplayException{

        int nId = -1;
        switch (direction){
            case NORTH:
                if (currentRoom >= size)
                    nId = currentRoom - size;
                else
                    throw new GameplayException(Errors.DIRECTION_NEIGHBOURHOOD_ERROR);
                break;
            case EAST:
                if (currentRoom  % size < size - 1)
                    nId = currentRoom + 1;
                else
                    throw  new GameplayException(Errors.DIRECTION_NEIGHBOURHOOD_ERROR);
                break;
            case SOUTH:
                if (currentRoom < rooms.size() - size)
                    nId = currentRoom + size;
                else
                    throw  new GameplayException(Errors.DIRECTION_NEIGHBOURHOOD_ERROR);
                break;
            case WEST:
                if (currentRoom % size != 0)
                    nId = currentRoom - 1;
                else
                    throw new GameplayException(Errors.DIRECTION_NEIGHBOURHOOD_ERROR);
                break;
        }
        return nId;
    }

    public String toString(){
        return "New Maze has been created. It has " + rooms.size() + "rooms.";
    }
}
