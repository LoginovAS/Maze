package org.sbx.builders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.abstracts.RoomBuilder;
import org.sbx.abstracts.Site;
import org.sbx.exceptions.GameplayException;
import org.sbx.factories.SiteFactory;
import org.sbx.interfaces.Buildable;
import org.sbx.interfaces.Builder;
import org.sbx.objects.Direction;
import org.sbx.objects.Room;
import org.sbx.service.Classes;

/**
 * Created by aloginov on 28.09.16.
 */
public class StandardRoomBuilder extends RoomBuilder implements Builder {

    private static final Logger logger = LogManager.getLogger(StandardRoomBuilder.class);
    private Room room;

    public StandardRoomBuilder(){
        super();
        room = new Room();
    }

    public StandardRoomBuilder(Room room){
        super();
        this.room = room;
    }

    public void constructRoomFrame(){
        for (Direction direction: Direction.values())
            try {
                addSite(direction, Class.forName(Classes.CLASS_WALL));
            } catch (ClassNotFoundException ex){
                logger.fatal(ex);
            }

    }

    public void addSite(Direction direction, Class clazz){
        try {
            room.addSite(direction, siteFactory.createSite(clazz));
        } catch (GameplayException ex){
            logger.error(ex.getErrorMessage(), ex.getErrorCode());
            logger.trace(ex.getStackTrace());
        }
    }

    public Room build(){
        return room;
    }

}
