package org.sbx.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.interfaces.Buildable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aloginov on 27.09.16.
 */
public class Maze implements Buildable{

    private static final Logger logger = LogManager.getLogger(Maze.class);
    private int size;
    private List<Room> rooms;
    private ArrayList<Integer> neighbours = new ArrayList<Integer>();
    private int currentRoom;

    public Maze(){
        rooms = new ArrayList<Room>();
    }

    public Maze(int size){
        this.size = size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setCurrentRoom(int roomId){
        this.currentRoom = roomId;
    }

    public void addRoom(Room room){
        rooms.add(room);
        int currentRoomId = rooms.indexOf(room);
    }

    public List<Room> getRooms(){
        return rooms;
    }

    public Room getRoomById(int roomId){
        return rooms.get(roomId);
    }

    public void changeRoom(int roomId, Room room){
        this.rooms.add(roomId, room);
    }

    public int getSize(){
        return  size;
    }

    public String toString(){
        return "New Maze has been created. It has " + rooms.size() + "rooms.";
    }
}
