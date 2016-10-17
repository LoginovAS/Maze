package org.sbx.builders;

import org.sbx.abstracts.RoomBuilder;
import org.sbx.abstracts.Site;
import org.sbx.interfaces.Buildable;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Direction;
import org.sbx.objects.FinishRoom;
import org.sbx.objects.Room;

import java.util.Map;

/**
 * Created by aloginov on 13.10.16.
 */
public class FinishRoomBuilder extends RoomBuilder implements Builder {

    private FinishRoom finishRoom;
    private Room room;

    public FinishRoomBuilder(){
        finishRoom = new FinishRoom();
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void construct(){
        for (Map.Entry<Direction, Site> sites: room.getSites().entrySet()){
            finishRoom.addSite(sites.getKey(), sites.getValue());
        }
    }

    public Buildable build() {
        return finishRoom;
    }
}
