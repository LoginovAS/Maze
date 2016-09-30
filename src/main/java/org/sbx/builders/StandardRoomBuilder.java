package org.sbx.builders;

import org.sbx.abstracts.RoomBuilder;
import org.sbx.abstracts.Site;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Buildable;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;

/**
 * Created by aloginov on 28.09.16.
 */
public class StandardRoomBuilder extends RoomBuilder implements Builder {

    private Room room;

    public StandardRoomBuilder(){
        super();
        room = new Room();
    }

    public void addSite(Direction direction, Class clazz){
        room.addSite(direction, siteFactory.createSite(clazz));
    }

    public Room build(){
        return room;
    }

}
