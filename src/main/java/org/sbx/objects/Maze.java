package org.sbx.objects;

<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
=======
import org.sbx.interfaces.Buildable;

>>>>>>> [27/09/2016]
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aloginov on 27.09.16.
 */
<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
public class Maze {
=======
public class Maze implements Buildable{
>>>>>>> [27/09/2016]

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
