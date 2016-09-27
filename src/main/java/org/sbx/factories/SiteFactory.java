package org.sbx.factories;

import org.sbx.interfaces.Site;
import org.sbx.objects.Direction;
import org.sbx.objects.Door;
import org.sbx.objects.Room;
import org.sbx.objects.Wall;

/**
 * Created by aloginov on 27.09.16.
 */
public class SiteFactory {
    public Room makeRoom(int roomId){
        Room room = new Room(roomId);

        room.setSite(Direction.NORTH, new Wall());
        room.setSite(Direction.EAST, new Wall());
        room.setSite(Direction.SOUTH, new Wall());
        room.setSite(Direction.WEST, new Wall());

        return room;
    }

    public Door makeDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }
}
