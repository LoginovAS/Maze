package org.sbx.directors;

import org.sbx.builders.StandardRoomBuilder;
import org.sbx.interfaces.Director;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 28.09.16.
 */
public class RoomDirector implements Director {

    private StandardRoomBuilder roomBuilder;
    private HashMap<Direction, String> sites;

    public RoomDirector(HashMap<Direction, String> sites){
        this.sites = sites;
    }

    public void setBuilder(){
        this.roomBuilder = new StandardRoomBuilder();
    }

    public void construct(){

        for (Map.Entry<Direction, String> site: sites.entrySet()){
            try {
                roomBuilder.addSite(site.getKey(), Class.forName(site.getValue()));
            } catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }

    public Room build(){
        return roomBuilder.build();
    }
}
