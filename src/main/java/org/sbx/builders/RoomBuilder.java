package org.sbx.builders;

import org.sbx.factories.SiteFactory;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;

/**
 * Created by aloginov on 28.09.16.
 */
public class RoomBuilder {

    private Room room;

    public RoomBuilder(){
        room = new Room();
    }

    public void addSite(Direction direction, String site){
        SiteFactory siteFactory = new SiteFactory();
        room.setSite(direction, siteFactory.getSite(site));
    }

    public Room build(){
        return room;
    }

}
