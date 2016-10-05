package org.sbx.objects;

import org.sbx.abstracts.Site;
import org.sbx.interfaces.Buildable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 27.09.16.
 */
public class Room implements Buildable{

    private Map<Direction, Site> sites;

    public Room(){
        sites = new HashMap<Direction, Site>();
    }

    public void addSite(Direction direction, Site site){
        if (this.sites.containsKey(direction))
            this.sites.remove(direction);

        this.sites.put(direction, site);

    }

    public Map<Direction, Site> getSites(){
        return sites;
    }

}
