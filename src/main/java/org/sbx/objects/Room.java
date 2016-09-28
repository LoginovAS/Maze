package org.sbx.objects;

import org.sbx.abstracts.Site;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 27.09.16.
 */
public class Room {

    private Map<Direction, Site> sites;

    public Room(){
        sites = new HashMap<Direction, Site>();
    }

    public void setSite(Direction direction, Site site){
        this.sites.put(direction, site);
    }
}
