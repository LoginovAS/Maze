package org.sbx.directors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.builders.StandardRoomBuilder;
import org.sbx.interfaces.Director;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloginov on 28.09.16.
 */
public class RoomDirector implements Director {

    private static final Logger logger = LogManager.getLogger(RoomDirector.class);
    private StandardRoomBuilder roomBuilder;
    private HashMap<Direction, String> sites;

    public RoomDirector(){ }

    public void setBuilder(){
        this.roomBuilder = new StandardRoomBuilder();
    }

    public void desc(HashMap<Direction, String> sites){
        this.sites = sites;
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

    public void setDoor(Room room, Direction direction){
        roomBuilder = new StandardRoomBuilder(room);
        try {
            roomBuilder.addSite(direction, Class.forName(Classes.CLASS_DOOR));
        } catch (ClassNotFoundException ex){
            logger.fatal(ex);
        }

    }

    public void constructRoomFrame(){
        roomBuilder.constructRoomFrame();
    }

    public Room build(){
        return roomBuilder.build();
    }
}
