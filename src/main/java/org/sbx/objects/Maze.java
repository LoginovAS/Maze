package org.sbx.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aloginov on 27.09.16.
 */
public class Maze {

    private List<Room> rooms;

    public Maze(){
        rooms = new ArrayList<Room>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoomById(int roomId){
        return rooms.get(roomId);
    }
}
