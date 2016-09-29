package org.sbx.builders;

import org.sbx.abstracts.Site;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Buildable;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;

/**
 * Created by aloginov on 28.09.16.
 */
public class StandardRoomBuilder {

    private Room room;

    public StandardRoomBuilder(){
        room = new Room();
    }

    public void addSite(Direction direction, Class clazz){
        SiteFactory siteFactory = new SiteFactory();
        room.addSite(direction, siteFactory.createSite(clazz));
    }

    public Room build(){
        return room;
    }

}
