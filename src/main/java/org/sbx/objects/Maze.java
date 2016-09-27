package org.sbx.objects;

import java.util.HashSet;
import java.util.List;

/**
 * Created by aloginov on 27.09.16.
 */
public class Maze {

    private HashSet<Room> rooms;

    public Maze(){
        // TODO
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoomById(int roomId){
        return null;
    }
}
