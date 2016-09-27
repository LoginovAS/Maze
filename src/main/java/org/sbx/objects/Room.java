package org.sbx.objects;

import org.sbx.interfaces.Site;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 27.09.16.
 */
public class Room implements Site{

    private int roomId;
    private Map<Direction, Site> sites;

    public Room(int roomId){
        this.roomId = roomId;
        sites = new HashMap<Direction, Site>();
    }

    public void setSite(Direction direction, Site site){
        this.sites.put(direction, site);
    }

    public int getId(){
        return roomId;
    }
}
