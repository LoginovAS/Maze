package org.sbx.builders;

import org.sbx.objects.Direction;
import org.sbx.objects.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by aloginov on 28.09.16.
 */
public class RoomDirector {
    public RoomDirector(){

    }

    public Room buildRoom(HashMap<Direction, String> sites){
        RoomBuilder roomBuilder = new RoomBuilder();
        for (Map.Entry<Direction, String> site: sites.entrySet()){
            roomBuilder.addSite(site.getKey(), site.getValue());
        }

        return roomBuilder.build();
    }
}
