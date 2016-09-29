package org.sbx.objects;

import org.sbx.abstracts.Site;
<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
=======
import org.sbx.interfaces.Buildable;
>>>>>>> [27/09/2016]

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 27.09.16.
 */
<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
public class Room {
=======
public class Room implements Buildable{
>>>>>>> [27/09/2016]

    private Map<Direction, Site> sites;

    public Room(){
        sites = new HashMap<Direction, Site>();
    }

<<<<<<< 8ab82bb5a8befd9ee0180d3fb94d0d3e35874816
    public void setSite(Direction direction, Site site){
=======
    public void addSite(Direction direction, Site site){
>>>>>>> [27/09/2016]
        this.sites.put(direction, site);
    }
}
